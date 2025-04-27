<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*,eOR.*, ePH.Common.* , eCommon.Common.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %><!-- Modified for IN:072715  -->
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
   <!--  <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
04/09/2019      IN:071108		    manickavasagam                                          ML-MMOH-CRF-1408
16/4/2020		IN072917			Shazana												SKR-SCF-1317
10/06/2020      IN072753           Prabha											   NMC-JD-CRF-0046
03/07/2020  IN:072715       Haribabu  25/06/2020     Manickavasagam     MMS-DM-CRF-0165
20/07/2020      IN:073424		   Prabha												SKR-SCF-1391      
12/11/2020     IN:069887       Haribabu         13/11/2020     Manickavasagam     MO-CRF-20152
--------------------------------------------------------------------------------------------------------------
*/
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		//
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<!--<script language="JavaScript" src="../../eCommon/js/PhCommon.js"></script>-->
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="JavaScript" src="../../ePH/js/PrescriptionComp.js"></script>
		<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="Javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../eOR/js/OrderEntrySearch.js"></script>
		<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script> <!-- Added for RollForward from SRR - SRR20056-SCF-9368 [IN:057068]-->
		<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/DateUtils.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  <!-- Added for RollForward from SRR - SRR20056-SCF-9368 [IN:057068]-->
		
	</head>

<!-- Variable initialization starts-->
<%
try{
	String patient_id						= request.getParameter("patient_id") ;
	String encounter_id						= request.getParameter("encounter_id");
	String adr_count						= request.getParameter("adr_count");	
	String priority							= "";
	String start_time						= "";
	String drug_code						= "";
	String srl_no							= "";
	String bsa								= "";
	String weight							= "0";
  	String iv_bean_id						= "IVPrescriptionBean"+patient_id+encounter_id;
	String iv_bean_name						= "ePH.IVPrescriptionBean";
	IVPrescriptionBean iv_bean				= (IVPrescriptionBean)getBeanObject( iv_bean_id,iv_bean_name, request) ;

	//Start of NMC-JD-CRF-0046
	String location_type		= request.getParameter("location_type")==null?"":request.getParameter("location_type");
	String location_code		= request.getParameter("location_code")==null?"":request.getParameter("location_code");
	String take_home_medication = request.getParameter("take_home_medication")==null?"":request.getParameter("take_home_medication");
	priority				= request.getParameter("priority")==null?"":request.getParameter("priority");
	String iv_prep_yn		= "";
	//End of NMC-JD-CRF-0046
	//Added for IN:072715 start
	Connection con			= null; 
	con				= ConnectionManager.getConnection(request);
	boolean over_ride_remarks_select_appl=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","PH_OVERRIDE_REASON_SELECT_APPL");
	//Added for IN:069887 start
	boolean validate_overide_on_confirm =eCommon.Common.CommonBean.isSiteSpecific(con,"PH","VALIDATE_OVERIDE_ON_CONFIRM");//added for MO-CRF-20152
	String validate_overide_on_confirm_yn="N";
	if(validate_overide_on_confirm){
		validate_overide_on_confirm_yn="Y";
	}
	//Added for IN:069887 end
	if(con != null)
		ConnectionManager.returnConnection(con,request);
	//Added for IN:072715 end
    iv_bean.setLanguageId(locale);
    String facility_id						=  (String)session.getValue("facility_id");
	String param_bean_id					= "@DrugInterfaceControlBean"+patient_id+encounter_id;
    String param_bean_name					= "ePH.DrugInterfaceControlBean";
    DrugInterfaceControlBean param_bean		= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
    String drug_db_interface_yn				=	param_bean.getDrugDBInterface_yn(facility_id);  
	String drug_db_dosecheck_yn			    =	param_bean.getDrugDBDosecheck_yn(facility_id);    
	String drug_db_duptherapy_yn			=   param_bean.getDrugDBDuptherapy_yn(facility_id);
	String drug_db_interact_check_yn		=   param_bean.getDrugDBInteract_check_yn(facility_id);
	String drug_db_contraind_check_yn		=   param_bean.getDrugDBContraind_check_yn(facility_id);
	String drug_db_allergy_check_yn			=   param_bean.getDrugDBAllergy_check_yn(facility_id);
	param_bean.clear();

	String or_bean_name						= "eOR.OrderEntryBean";
	String or_bean_id						= "@orderentrybean"+patient_id+encounter_id;
	OrderEntryBean orbean					= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name,request ) ;
	orbean.setLanguageId(locale);

	String pract_id							= (String) orbean.getPractitionerId();
	String servide_code						= (String) orbean.getServiceCode();
	String resp_id							= (String) orbean.getResponsibilityId();   
	ArrayList frequency						=  iv_bean.loadFrequency();   
	String calling_mode						=  request.getParameter("mode") ;
	String patient_class					=  request.getParameter("patient_class")==null?"": request.getParameter("patient_class");
	String act_patient_class				=  request.getParameter("act_patient_class");
	String atc_allergy_alert_level				=  request.getParameter("atc_allergy_alert_level")==null?"N":request.getParameter("atc_allergy_alert_level");
	iv_bean.setATCAllergyLevel(atc_allergy_alert_level);
	String external_prod_id					=  "";
	String interaction_override_reason		=  "";
	String contraind_override_reason		=  "";
	String DrugRemarksEntered			=	"";//added for [IN:039576]

    String allergy_override_reason_flag			=  "N";	
	String duplicate_drug_override_reason_flag	=  "N";
	String interaction_override_reason_flag		=  "N";
	String contraind_override_reason_flag		=  "N";
	String adr_display_yn						="hidden";
	String ext_image_display					="hidden";

	String drug_desc = "",freq_code = "",qty_value = "",qty_unit = "",durn_vlaue = "",order_qty = "",order_uom = "",start_date	= "",end_date = "",order_id	= "",temp = "", form_desc = "",strength_value = "",strength_uom	= "", pres_remarks = "", allergy_override_reason	= "",dosage_limit_override_reason		= "", duplicate_drug_override_reason	= "",allergy_flag = "hidden",doselimit_flag	= "hidden",currentrx_flag	= "hidden",over_ride_flag	= "hidden",no_of_drugs	= "", order_line_num = "",repeat_value = "", amnd_drg_code = "",disableflag	= "", tdmOrderIdAmnd = "",display_tdm = "", buildMAR_yn="", buildMAR_ynCheck="",ext_over_ride_flag	= "hidden";
// RUT-CRF-0062 [IN029600] Added to get Build MAR Rule CRF 0062 -- begin	
	String buildMAR_ynEnable =""; 
	String buildMAR_rule =""; 
// RUT-CRF-0062 [IN029600] Added to get Build MAR Rule CRF 0062 -- end	
	String allergy_yn						= "N";
	String allergy_rsn_flag					= "hidden";
	String currentrx_yn						= "N";
	String currentrx_rsn_flag				= "hidden";
	String limit_ind						= "N";
	String height							= "0"; //ML-MMOH-CRF-1408
	//Added for IN:072715 start
	String allergy_remarks_code="",dose_remarks_code="",currentrx_remarks_code="";
	//Added for IN:072715 end
	HashMap chkValuescheduleFrequency		= null;
    ArrayList frequencyValues				= null;
	HashMap drugReasons						= null;
	int tem									=   0;
	//String ex_bean_id						= "@ExternalProductLinkBean"+patient_id+encounter_id;
    String ex_bean_id						= "@ExternalProductLinkBean";
	String ex_bean_name						= "ePH.ExternalProductLinkBean";
	ExternalProductLinkBean beanex			= (ExternalProductLinkBean)getBeanObject(ex_bean_id,ex_bean_name,request);

	String dup_drug_det						= "";
	HashMap drug_Interactions				= null;
	ArrayList exProd						= new ArrayList();
	ArrayList drugDesc						= new ArrayList();

	String drug_db_contraind_check_flag		= "N";
	String drug_db_interact_check_flag		= "N";
	String drug_db_duptherapy_flag			= "N";
	String drug_db_dose_check_flag			= "N"; 
	String drug_db_allergy_flag				= "N";

	ArrayList prescriptionDetails			= new ArrayList();

	HashMap ext_drugData					= null;
	String ext_drug_code					= null;

	HashMap freq_vals						= new HashMap();
    String freq_interval_value				= "";
	String freq_repeat_value				= "";
	String freq_frequency					= "";
	HashMap drugDosageResult				= null;
    ArrayList dosageCheckParams				= null;
    ArrayList AllUOMs						= new ArrayList();
	String presc_base_uom					= "";
	String generic_id="", generic_name ="", DrugIndicationRemarks="";
	iv_bean.setExcludeADRAllergyAlert(CommonBean.checkForNull(request.getParameter("excludeADRAllergyAlert_yn")));
	
	//Start of NMC-JD-CRF-0046
	String ext_disp_appl_yn="";
	ArrayList ord_disp_location  = (ArrayList) iv_bean.getOrderDispenseLocation(location_type, location_code, take_home_medication, priority, iv_prep_yn, "", patient_id, encounter_id);
	if(ord_disp_location !=null && ord_disp_location.size()>0)
	{
	String  disp_loc = (String)ord_disp_location.get(0);
	ext_disp_appl_yn = iv_bean.getExtDispYN(disp_loc);
	}
	//End of NMC-JD-CRF-0046	
	
	if(calling_mode.equals("amend") || calling_mode.equals("RENEW_ORDER") ){
%>
		<body onMouseDown="" onKeyDown="lockKey()">
		<form name="prescription_compdetail_form" id="prescription_compdetail_form" >
			<table cellpadding=0 cellspacing=0 width="100%" align="center" border="1">				
				<tr>
					<td class="COLUMNHEADER" colspan="1" ><fmt:message key="ePH.Alerts.label" bundle="${ph_labels}"/></td>
					<td class="COLUMNHEADER" colspan="1" ><fmt:message key="ePH.Drugs.label" bundle="${ph_labels}"/></td>
					<td class="COLUMNHEADER" colspan="1" ><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></td>
					<td class="COLUMNHEADER" colspan="1" > <fmt:message key="ePH.Form.label" bundle="${ph_labels}"/></td>
					<td class="COLUMNHEADER" colspan="1" ><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
					<td class="COLUMNHEADER" colspan="1" ></td>
					<td class="COLUMNHEADER" colspan="1" ></td>
				</tr>
<%
				if(calling_mode.equals("RENEW_ORDER")){
					 disableflag="disabled";
				}
				priority				= request.getParameter("priority") ;
				start_time				= request.getParameter("start_date") ;
				srl_no					= request.getParameter("srl_no") ;
				order_id                = request.getParameter("order_id") ;
				weight					= request.getParameter("weight");
				bsa						= request.getParameter("bsa");
				if((weight == null) || weight.equals("")){weight = "0";}
				if((bsa == null) || (bsa.equals("")))   {bsa = "0";}

				ArrayList comp_drugs    = new ArrayList();
				HashMap drug_dtls       = new HashMap();

				String act_pat_class	= request.getParameter("act_pat_class")==null?act_patient_class:request.getParameter("act_pat_class");  // RUT-CRF-0062
				comp_drugs=iv_bean.getCompDrugDtls(order_id,act_pat_class); // RUT-CRF-0062 Added actual patient class to get the Build MAR Rule
				if(comp_drugs != null){
					no_of_drugs = comp_drugs.size()+"";

				 HashMap drug_data=new HashMap();
                 for(int i=0;i<comp_drugs.size();i++){
					drug_data	=	(HashMap)comp_drugs.get(i);					
					drugDesc.add((String)drug_data.get("DRUG_DESC"));
					external_prod_id=(String)drug_data.get("EXTERNAL_PRODUCT_ID");

					if(!external_prod_id.equals("")){
					     exProd.add(external_prod_id);
					}
				 }
				 /*
				 if(exProd.size()>0)
					beanex.storeDrugIds(patient_id,"",exProd,drugDesc);//Store Drug ids*/
				external_prod_id="";
				for(int i=0;i<comp_drugs.size();i++){
	  				ext_image_display				="hidden";
					drug_db_contraind_check_flag	=	"N";
					drug_db_interact_check_flag		=	"N";
					drug_db_duptherapy_flag			=	"N";
					drug_db_dose_check_flag			=	"N"; 
					drug_db_allergy_flag				=	"N";
					allergy_yn						=	"N";
					allergy_rsn_flag				= "hidden";
					currentrx_yn					=   "N";
					currentrx_rsn_flag				=  "hidden";
					external_prod_id				= "";
					freq_vals		                = new HashMap();
					freq_interval_value		        = "";
					freq_repeat_value	            = "";		
					freq_frequency					= "";
					DrugIndicationRemarks					= "";//Added for ML-BRU-CRF-072[Inc:29938]
					drug_dtls=(HashMap)comp_drugs.get(i);

					if(drug_dtls != null){
						drug_code       =(String)drug_dtls.get("ORDER_CATALOG_CODE"); 
						iv_bean.setDrugDetails(drug_code+",",pract_id,resp_id,"","","","");  //CRF-0062 
						  
						drug_desc       =(String)drug_dtls.get("CATALOG_DESC");
						freq_code       =(String)drug_dtls.get("FREQ_CODE");
						qty_value       =(String)drug_dtls.get("QTY_VALUE");
						qty_unit        =(String)drug_dtls.get("QTY_UNIT");
						durn_vlaue      =(String)drug_dtls.get("DURN_VALUE");
						order_qty       =(String)drug_dtls.get("ORDER_QTY");
						order_uom       =(String)drug_dtls.get("ORDER_UOM");
						start_date      =(String)drug_dtls.get("START_DATE_TIME");
						srl_no			=(String)drug_dtls.get("ORDER_LINE_NUM");
						end_date        =(String)drug_dtls.get("END_DATE_TIME");
						buildMAR_yn     =(String)drug_dtls.get("BUILDMAR_YN");
						allergy_yn		=(String)drug_dtls.get("ALLERGY_YN");
						currentrx_yn	=(String)drug_dtls.get("CURRENT_RX");
						presc_base_uom	=(String)drug_dtls.get("PRES_BASE_UOM");
						generic_id			= drug_dtls.get("GENERIC_ID")==null?"":(String)drug_dtls.get("GENERIC_ID");
						generic_name		= drug_dtls.get("GENERIC_NAME")==null?"":(String)drug_dtls.get("GENERIC_NAME");
						DrugIndicationRemarks	= (String)drug_dtls.get("DRUG_INDICATION");// Added for ML-BRU-CRF-072[Inc:29938]
						if(!DrugIndicationRemarks.equals(""))
						DrugIndicationRemarks = java.net.URLEncoder.encode(DrugIndicationRemarks,"UTF-8"); 

						/*   RUT-CRF-0062 [IN029600] Commented and Added to get Build MAR Rule CRF 0062 -- begin
						if(buildMAR_yn.equals("Y"))
							buildMAR_ynCheck="checked";
						else{
							buildMAR_ynCheck="";
							buildMAR_yn = "N";
						}
						*/
						if(i==0)  {               // To load the build MAR based on the first drug
							buildMAR_rule	=drug_dtls.get("BUILD_MAR_RULE").toString();
						}
						buildMAR_yn="N";
						if(buildMAR_rule==null){
							buildMAR_rule="";
						}
						if(buildMAR_rule.equals("CE")){
							buildMAR_ynCheck ="checked";		
							buildMAR_ynEnable="";
							buildMAR_yn="Y";
						}
						else if(buildMAR_rule.equals("UE")){
							buildMAR_ynCheck ="";		
							buildMAR_ynEnable="";
						}
						else if(buildMAR_rule.equals("CD")){
							buildMAR_ynCheck ="checked";		
							buildMAR_ynEnable="disabled";
							buildMAR_yn="Y";
						}
						else if(buildMAR_rule.equals("UD")){
							buildMAR_ynCheck ="";		
							buildMAR_ynEnable="disabled";
						}
						
						if(ext_disp_appl_yn.equals("Y"))   //ADDED FOR NMC-JD-CRF-0046--AMEND ORDER
						{
							buildMAR_ynEnable="disabled";
							buildMAR_ynCheck="";
							buildMAR_yn="N";
						}
						
						iv_bean.setBuildMAR_yn(buildMAR_yn);
						//}
						
						//RUT-CRF-0062 [IN029600] Commented and Added to get Build MAR Rule CRF 0062 -- end
						if(calling_mode.equals("RENEW_ORDER")){
							start_date=iv_bean.comp_date_time(end_date,order_id,1+"");
						}
						form_desc       =(String)drug_dtls.get("FORM_DESC");
						strength_value  =(String)drug_dtls.get("STRENGTH_VALUE");
						strength_uom    =(String)drug_dtls.get("STRENGTH_UOM");
						if(strength_uom == null) strength_uom="";               

						external_prod_id				=	(String)drug_dtls.get("EXTERNAL_PRODUCT_ID");	

						freq_vals					 = (HashMap)iv_bean.freqValidate(freq_code);
				        freq_interval_value          = (String)freq_vals.get("interval_value");
						freq_repeat_value            = (String)freq_vals.get("repeat_value");
						if(!freq_interval_value.equals("") && !freq_repeat_value.equals("")){
							freq_frequency				= (int)Math.ceil( Integer.parseInt(freq_repeat_value) / Integer.parseInt(freq_interval_value))+"";
						}
						// if(drug_db_interface_yn.equals("Y") ){
							allergy_override_reason			=	(String)drug_dtls.get("ALLERGY_OVERRIDE_REASON");

							dosage_limit_override_reason	=	(String)drug_dtls.get("DOSAGE_LIMIT_OVERRIDE_REASON");
							duplicate_drug_override_reason	=	(String)drug_dtls.get("DUPLICATE_DRUG_OVERRIDE_REASON");
							//Added for IN:072715 start
							allergy_remarks_code	=	(String)drug_dtls.get("ALLERGY_REMARKS_CODE")==null?"":(String)drug_dtls.get("ALLERGY_REMARKS_CODE");
							dose_remarks_code	=	(String)drug_dtls.get("DOSE_REMARKS_CODE")==null?"":(String)drug_dtls.get("DOSE_REMARKS_CODE");
							currentrx_remarks_code	=	(String)drug_dtls.get("CURRENTRX_REMARKS_CODE")==null?"":(String)drug_dtls.get("CURRENTRX_REMARKS_CODE");
							//Added for IN:072715 end
							interaction_override_reason		=	(String)drug_dtls.get("INTERACTION_OVERRIDE_REASON");
							contraind_override_reason		=	(String)drug_dtls.get("CONTRAIND_OVERRIDE_REASON");
							if(!allergy_override_reason.equals("")){
								allergy_override_reason_flag="Y";
								allergy_rsn_flag = "hidden";
							}
							else{
								allergy_override_reason_flag="N";		
								allergy_rsn_flag = "visible";
							}
							if(!duplicate_drug_override_reason.equals("")){
								duplicate_drug_override_reason_flag="Y";
								currentrx_rsn_flag = "hidden";
							}
							else{
								duplicate_drug_override_reason_flag="N";
								currentrx_rsn_flag = "visible";
							}
							if(!interaction_override_reason.equals("")){
								interaction_override_reason_flag="Y";
							}
							else{
								interaction_override_reason_flag="N";		
							}
							if(!contraind_override_reason.equals("")){
								contraind_override_reason_flag="Y";
							}
							else{
								contraind_override_reason_flag="N";
							}

							if(!allergy_override_reason.equals("") || !duplicate_drug_override_reason.equals("") || !interaction_override_reason.equals("") || !contraind_override_reason.equals("")){
								ext_image_display					="visible";
							}else{
								ext_image_display					="hidden";
							}
						//}
						//else{               

							drugReasons=new HashMap();
							allergy_override_reason			="";
							dosage_limit_override_reason	="";
							duplicate_drug_override_reason	="";
							//Added for IN:072715 start
							allergy_remarks_code="";
							dose_remarks_code="";
							currentrx_remarks_code="";
							//Added for IN:072715 end
							allergy_flag	="hidden";
							doselimit_flag	="hidden";
							currentrx_flag	="hidden";
							over_ride_flag	="hidden";
							ext_over_ride_flag = "hidden";

							drugReasons=iv_bean.getDrugReasons(order_id,(i+1)+"","");
							allergy_override_reason=(String)drugReasons.get("ALLERGY_OVERRIDE_REASON")==null?"":(String)drugReasons.get("ALLERGY_OVERRIDE_REASON");

							dosage_limit_override_reason=(String)drugReasons.get("DOSAGE_LIMIT_OVERRIDE_REASON")==null?"":(String)drugReasons.get("DOSAGE_LIMIT_OVERRIDE_REASON");
							duplicate_drug_override_reason=(String)drugReasons.get("DUPLICATE_DRUG_OVERRIDE_REASON")==null?"":(String)drugReasons.get("DUPLICATE_DRUG_OVERRIDE_REASON");
							//Added for IN:072715 start
							allergy_remarks_code	=	(String)drugReasons.get("ALLERGY_REMARKS_CODE")==null?"":(String)drugReasons.get("ALLERGY_REMARKS_CODE");
							dose_remarks_code	=	(String)drugReasons.get("DOSE_REMARKS_CODE")==null?"":(String)drugReasons.get("DOSE_REMARKS_CODE");
							currentrx_remarks_code	=	(String)drugReasons.get("CURRENTRX_REMARKS_CODE")==null?"":(String)drugReasons.get("CURRENTRX_REMARKS_CODE");
							//Added for IN:072715 end
							if(!allergy_override_reason.equals(""))
								allergy_flag="visible";
							if(drug_db_interface_yn.equals("N") && !dosage_limit_override_reason.equals(""))
								doselimit_flag="visible";
							if(!duplicate_drug_override_reason.equals(""))
								currentrx_flag="visible";
							if((!allergy_override_reason.equals("")) || !dosage_limit_override_reason.equals("") || (!duplicate_drug_override_reason.equals(""))) 
								over_ride_flag="visible";

							if(doselimit_flag.equals("hidden")){
								limit_ind = "Y";		
								over_ride_flag="hidden";
							}
						//}
						// TDM
						tdmOrderIdAmnd = "";
						display_tdm = "display:none";
						tdmOrderIdAmnd			= iv_bean.getOrderIdForTDMDtls(patient_id,drug_code);

						if(tdmOrderIdAmnd==null ||tdmOrderIdAmnd.equals("")){
							display_tdm="display:none";
						}
						else{
							display_tdm="display:inline";
						} 
					}
					//  newly added code for ammending -> Remarks 
				  
					pres_remarks ="";
					ArrayList drug_remarks	=	iv_bean.getPrescribedRemarks(order_id,(i+1)+"");
				   
					if(drug_remarks.size()!=0) { 
						for(int x=0; x<drug_remarks.size(); x++) {	
							if(x==(drug_remarks.size()-1)) {	
								pres_remarks	= pres_remarks +	(String)drug_remarks.get(x);
							}
							else {
								pres_remarks	= pres_remarks +	(String)drug_remarks.get(x)+",";
							}
						} 
					} 
					/* if(!pres_remarks.equals(""))
						remarks_style	="visibility:visible";
					 else
						remarks_style	="visibility:hidden";
					*/
					// ---- Ends here 
				   if(Integer.parseInt(adr_count)>0){
						int  drug_adr_count = iv_bean.getADRCount(patient_id,drug_code); 
						if(drug_adr_count>0){

							adr_display_yn="visible";
						}else{
							adr_display_yn="hidden";
						}
					}
				
					if(drug_db_interface_yn.equals("Y") && !external_prod_id.equals("")){
						//beanex.storeDrugIds(patient_id,"",new ArrayList(),new ArrayList());//Store Drug ids
						/*
						beanex.removeSelectedDrugonAmend(external_prod_id);
						if(drug_db_duptherapy_yn.equals("Y")){ 
						   dup_drug_det			= beanex.isDuplicateTherapy(external_prod_id);//get dupluicate theraphy result
						   if(!dup_drug_det.equals("")&&dup_drug_det!=null)
							   drug_db_duptherapy_flag="Y";
							   ext_image_display	  ="visible";
							   currentrx_flag		  ="hidden";
							   currentrx_yn			  = "N";
						}

						if(drug_db_interact_check_yn.equals("Y")){
						   beanex.getDDInteractions(external_prod_id);//Store interactions
							   drug_Interactions		= beanex.getInteractions();//get Interactions

							if(drug_Interactions.size()>0){							
								 drug_db_interact_check_flag="Y";
							}
						}

						if(drug_db_contraind_check_yn.equals("Y")){
							  ArrayList ex_prod_ids =new ArrayList();
							  ex_prod_ids.add(external_prod_id);
							  boolean flag = beanex.isContraDrugMedicalCondition(ex_prod_ids,patient_id);
							  HashMap contra_indications =(HashMap)beanex.getContraIndications();
							  if(contra_indications.containsKey(external_prod_id)){
								 drug_db_contraind_check_flag="Y";
							  }				  
						}

						if(drug_db_allergy_check_yn.equals("Y")){
							ArrayList ex_prod_ids =new ArrayList();
							ex_prod_ids.add(external_prod_id);
							beanex.DrugAlergyCheck(ex_prod_ids,patient_id);//get drug alergy result
							beanex.DrugAlergyCheck(exProd,patient_id);//get drug alergy result
							HashMap drug_alergies =(HashMap)beanex.getDrugAlergies();
							if(drug_alergies.containsKey(external_prod_id)){
								drug_db_allergy_flag	= "Y";
								allergy_yn			= "N";
							}	
						}
						
						*/
						if(drug_db_dosecheck_yn.equals("Y")){
							//drugDosageResult = new HashMap();
							//	weight = "65";
							//	bsa = "10";
							dosageCheckParams        = new ArrayList();
							dosageCheckParams.add(patient_id);
							dosageCheckParams.add(external_prod_id);
							dosageCheckParams.add(weight);
							dosageCheckParams.add(bsa);
							dosageCheckParams.add(qty_value);//dose
							dosageCheckParams.add(presc_base_uom);//pres_base_uom
							dosageCheckParams.add(freq_frequency);
							dosageCheckParams.add(durn_vlaue);
							//Store Drug ids
							/*if(!weight.equals("") && !bsa.equals("")){
								drugDosageResult = beanex.getDrugDosageCheck(dosageCheckParams);

								if(drugDosageResult != null && drugDosageResult.size() > 0){
									drug_db_dose_check_flag = "Y";						
								}
							}*/
						}
						if(exProd.size()>0 ){
							for(i=0;i<exProd.size();i++){
								if(exProd.get(i).equals(external_prod_id)) {
									drugDesc.remove(i);
									exProd.remove(i);
									break;
								}
							}
						}

						String storeIDs = "N";
						if(exProd.size()>0 )
							storeIDs = "Y";
							
						HashMap tempDetails= null;
						ArrayList reqChecks = new ArrayList();
						reqChecks.add(drug_db_dosecheck_yn); //Dosage Check 
						reqChecks.add(drug_db_duptherapy_yn); //Duplicate Check
						reqChecks.add(drug_db_interact_check_yn); //DrugInteraction
						reqChecks.add(drug_db_contraind_check_yn); //Contra Indication
						reqChecks.add(drug_db_allergy_check_yn); //AllergyCheck
						HashMap drugDBCheckResult = (HashMap)beanex.getExternalDBChecks( reqChecks, external_prod_id, patient_id, "", exProd ,drugDesc, null, storeIDs, start_date, end_date); //Parameters (AL)requiredchecks, ext_proID, PatienId, OrderID, (AL)ExtProdIDlist, (AL)DrugDescs (AL)DoseCheckParams, Y/N to store EXTID list in EXTbean 
						if(drugDBCheckResult!=null)
							beanex.setExternalDBCheckResult(external_prod_id,srl_no,drugDBCheckResult);

						if(drug_db_dosecheck_yn.equals("Y")){
							tempDetails = (HashMap)drugDBCheckResult.get("DOSECHECK");
							if(tempDetails != null && tempDetails.size() > 0){
								drug_db_dose_check_flag = "Y";						
							}
						}

						if(drug_db_allergy_check_yn.equals("Y")){
						   if(beanex!=null && beanex.getProdID()!=null && (beanex.getProdID()).equals("CIMS")){ // for CIMS) //if block and else part added
							   String allergy_alert			= (String)drugDBCheckResult.get("ALLERGYCHECK");
							   if(allergy_alert!=null && !allergy_alert.equals(""))
									drug_db_allergy_flag="Y";
									allergy_yn			= "N";
						   } 
						   else {  
								tempDetails =(HashMap)drugDBCheckResult.get("ALLERGYCHECK");
								if(tempDetails!=null && tempDetails.size()>0){
									 drug_db_allergy_flag="Y";
									allergy_yn			= "N";
								}
							} 
						}

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
							if(beanex!=null && beanex.getProdID()!=null && (beanex.getProdID()).equals("CIMS")){ //adding start for IN066787- Performance
								 tempDetails = (HashMap)drugDBCheckResult.get("HEALTHINTRACHECK");	 /* Added in JUNE 2012 - New changes - Health Care Interaction */
								if(tempDetails!=null && tempDetails.size()>0){ //IN066787- Performance
										 drug_db_contraind_check_flag="Y";
									}
								}else{//Adding end for IN066787- Performance
										tempDetails =(HashMap)drugDBCheckResult.get("CONTRACHECK");
								  if(tempDetails!=null && tempDetails.containsKey(external_prod_id)){
									   drug_db_contraind_check_flag="Y";
								}		
								  else
									   drug_db_contraind_check_flag="N";
							}	
						}
					}
					if(drug_db_duptherapy_flag.equals("Y")){
						currentrx_flag="hidden";
						over_ride_flag="hidden";
						currentrx_rsn_flag = "hidden";
					}
					else if(currentrx_yn.equals("Y")){
						currentrx_flag="visible";
						if(!duplicate_drug_override_reason.equals("")){
							currentrx_rsn_flag = "hidden";
						}else{
							currentrx_rsn_flag = "visible";
						}
					}
					else if(currentrx_yn.equals("N")){
						currentrx_rsn_flag = "hidden";
					}

					if(drug_db_allergy_flag.equals("Y")){
						allergy_flag="hidden";
						over_ride_flag="hidden";
						allergy_rsn_flag = "hidden";
					}
					else if(allergy_yn.equals("Y")){
						allergy_flag="visible";	
						if(!allergy_override_reason.equals("")){
							allergy_rsn_flag = "hidden";
						}
						else{
							allergy_rsn_flag = "visible";
						}
					}
					else if(allergy_yn.equals("N")){
						allergy_rsn_flag = "hidden";
					}

					drug_dtls.put("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN",drug_db_duptherapy_flag);
					drug_dtls.put("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN",drug_db_interact_check_flag);
					drug_dtls.put("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN",drug_db_contraind_check_flag);
					drug_dtls.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN",drug_db_dose_check_flag);
					drug_dtls.put("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN",drug_db_allergy_flag);

					if(drug_db_allergy_flag.equals("Y") || drug_db_duptherapy_flag.equals("Y") || drug_db_interact_check_flag.equals("Y") || drug_db_contraind_check_flag.equals("Y") || drug_db_dose_check_flag.equals("Y")){ 
						ext_image_display	=	"visible";
					}
					else{
						ext_image_display	=	"hidden";
					}

					if(((drug_db_allergy_flag.equals("Y") && (allergy_override_reason.equals(""))) || (drug_db_duptherapy_flag.equals("Y") && (duplicate_drug_override_reason.equals("")))) || ((drug_db_interact_check_flag.equals("Y")) && interaction_override_reason.equals("")) || ((drug_db_contraind_check_flag.equals("Y")) && contraind_override_reason.equals("")) || ((drug_db_dose_check_flag.equals("Y")) && dosage_limit_override_reason.equals(""))){
						ext_over_ride_flag	=	"visible";
					}
					if(allergy_flag.equals("visible") || doselimit_flag.equals("visible") || currentrx_flag.equals("visible")){
						over_ride_flag="visible";
					}
%>
					<tr>
						<td class="QRYEVENSMALL" width="3%" >
							<table>
								<tr>
                                  <td NOWRAP width="12" class="label" id="ADR_<%=i+1%>" name="ADR_<%=i+1%>" style="visibility:hidden" >
									<img style="visibility:<%=adr_display_yn%>" id="ADR_img_<%=i+1%>" name="ADR_img_<%=i+1%>" src='../../ePH/images/ADR.gif'   title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>'></img>
									</td>

									<td NOWRAP width="12" class="SHIFTTOTAL" id="external_<%=i+1%>" name="external_<%=i+1%>" style="visibility:<%=ext_image_display%>" onclick="displayDosageCheckResult(<%=i+1%>)"><img style="visibility:<%=ext_over_ride_flag%>" id="external_img<%=i+1%>" src='../../ePH/images/exceed1.gif' ></img></td>
									<td NOWRAP width="12" class="ALLERGY" id="allergy_<%=i+1%>" name="allergy_<%=i+1%>" style="visibility:<%=allergy_flag%>" onclick="showAllergyDetails('<%=generic_id%>','<%=patient_id%>','<%=encounter_id%>','<%=java.net.URLEncoder.encode(generic_name,"UTF-8")%>','<%=java.net.URLEncoder.encode(drug_desc,"UTF-8")%>');" onmouseover="changeCursor(this);" ><img style="visibility:<%=allergy_rsn_flag%>" id="allergy_img<%=i+1%>" name="allergy_img<%=i+1%>" src='../../ePH/images/exceed1.gif' ></img></td>
									<td NOWRAP width="12" class="DOSELIMIT" id="dosage_<%=i+1%>" name="dosage_<%=i+1%>" style="visibility:<%=doselimit_flag%>" ><img style="visibility:hidden" id="dosage_img<%=i+1%>" name="dosage_img<%=i+1%>" src='../../ePH/images/exceed1.gif' ></img></td>
									<td NOWRAP width="12" class="CURRENTRX" id="currentrx_<%=i+1%>" name="currentrx_<%=i+1%>" style="visibility:<%=currentrx_flag%>"><img style="visibility:<%=currentrx_rsn_flag%>" id="currentrx_img<%=i+1%>" name="currentrx_img<%=i+1%>" src='../../ePH/images/exceed1.gif' ></img></td>
								</tr>
							</table>
						</td>
						<td class="QRYEVENSMALL" width="34%">&nbsp;
							<input type="text" name="drug_name<%=i+1%>" id="drug_name<%=i+1%>" size="42"  maxlength="42" value="<%=drug_desc%>" disabled onblur="deleteDrug(this,<%=i+1%>)" >
							
							<input type="button" name="drug_search<%=i+1%>" id="drug_search<%=i+1%>" value="?" class="button"   onClick="searchDrug(prescription_compdetail_form,'D', drug_name<%=i+1%>,<%=i+1%>)" disabled>
						</td>
						<td class="QRYEVENSMALL"  width="5%">
							<b><label style="font-size:7pt" class="label" id="strength<%=i+1%>" name="strength<%=i+1%>">&nbsp;<%=strength_value%>&nbsp;&nbsp;<%=strength_uom%></label></b>
						</td>
						<td class="QRYEVENSMALL"  width="10%">
							<b><label style="font-size:7pt" class="label" id="form<%=i+1%>" name="form<%=i+1%>">&nbsp;<%=form_desc%></label></b>
						</td>
						<td class="QRYEVENSMALL"  width="20%">
							<input type="text" name="absol_qty<%=i+1%>" id="absol_qty<%=i+1%>" value="<%=order_qty%>"  size="6" maxlength="6" onblur="CheckNum(this);extdosechk();"  onKeyPress="return allowValidNumber(this,event,6,0);" class="number">&nbsp;
							<b><label style="font-size:7pt" class="label" id="qty<%=i+1%>" name="qty<%=i+1%>">&nbsp;<%=order_uom %></label></b>
						</td>
						<td class="QRYEVENSMALL" width="6%" >
							<a href="javascript:callOrderAmend('<%=i+1%>');" id="remarks_<%=i+1%>" name="remarks_<%=i+1%>" HREF onMouseOver="changeCursor(this);" title='<fmt:message key="ePH.remarks.label" bundle="${ph_labels}"/>'>><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></A>
							<!-- added for [IN:039576]-start -->
							<img  src="../../eCommon/images/mandatory.gif" style='display:none;' id='DrugRemarksMandImg_<%=i+1%>' name='DrugRemarksMandImg_<%=i+1%>'>
							<input type='hidden' name='DrugRemarksMandatory_<%=i+1%>' id='DrugRemarksMandatory_<%=i+1%>' value='N'>
							<input type='hidden' name='DrugRemarksEntered_<%=i+1%>' id='DrugRemarksEntered_<%=i+1%>' value="<%=DrugRemarksEntered%>">&nbsp;&nbsp;
							<!-- added for [IN:039576]-end -->
							<a href="javascript:drugindication_remarks('<%=i+1%>');" id="drug_ind_remarks_<%=i+1%>" name="drug_ind_remarks_<%=i+1%>" style="visibility:visible" title='<fmt:message key="ePH.DrugIndications.label" bundle="${ph_labels}"/>'><fmt:message key="ePH.DrugIndications.label" bundle="${ph_labels}"/></a>
							<input type="hidden" name="DrugIndicationRemarks_<%=i+1%>" id="DrugIndicationRemarks_<%=i+1%>"	value="<%=DrugIndicationRemarks%>"><!--Added for ML-BRU-CRF-072[Inc:29938] -->

						</td>
						<td class="QRYEVENSMALL" width="18%">
							<input style="visibility:<%=over_ride_flag%>" type="button" class="button" width="8%" value="Override" id="dosage_limit<%=i+1%>" name="dosage_limit<%=i+1%>" onclick="showOverrideReason('<%=order_id%>','<%=(i+1)%>','<%=drug_db_interface_yn%>','<%=drug_db_duptherapy_flag%>','<%=drug_db_allergy_flag%>','<%=allergy_yn%>','<%=currentrx_yn%>','<%=limit_ind%>','<%=drug_db_dosecheck_yn%>')" > <!--drug_db_dosecheck_yn added for ML-MMOH-CRF-1408 -->
						<!-- Modified for IN:072715 START -->
							<%if(over_ride_remarks_select_appl){ %>
							<input style="visibility:<%=over_ride_flag%>" type="checkbox" width="2%" id="chk_ovr<%=(i+1)%>" name="chk_ovr<%=(i+1)%>" onclick="showOverrideReason('<%=order_id%>','<%=(i+1)%>','<%=drug_db_interface_yn%>','<%=drug_db_duptherapy_flag%>','<%=drug_db_allergy_flag%>','<%=allergy_yn%>','<%=currentrx_yn%>','<%=limit_ind%>','<%=drug_db_dosecheck_yn%>')" >
							<%}else{ %>
							<input style="visibility:<%=over_ride_flag%>" type="checkbox" width="2%" id="chk_ovr<%=(i+1)%>" name="chk_ovr<%=(i+1)%>" onclick="default_override_rsn('<%=i+1%>')" >
							<%} %>
							<!-- Modified for IN:072715 end -->
							<A title="TDM Result" style="<%=display_tdm%>" id="tdmRsltAmnd_<%=i+1%>" name="tdmRsltAmnd_<%=i+1%>" HREF onMouseOver="changeCursor(this);" onClick="viewReasonforRequest(tdmOrderIdAmnd<%=i+1%>.value)"> <fmt:message key="ePH.TDM.label" bundle="${ph_labels}"/></A>
						</td>
						<input type="text" name="drug_class<%=i+1%>" id="drug_class<%=i+1%>" value="">
						<input type="hidden" name="ALLERGY_DESC<%=i+1%>" id="ALLERGY_DESC<%=i+1%>" value="">
						<input type="hidden" name="EXCEED_DOSE_DESC<%=i+1%>" id="EXCEED_DOSE_DESC<%=i+1%>" value="">
						<input type="hidden" name="DUP_DRUG_DESC<%=i+1%>" id="DUP_DRUG_DESC<%=i+1%>" value="<%=duplicate_drug_override_reason%>">		
						<!-- Added for IN:072715 start -->		
      					 <input type="hidden"  name="allergy_remarks_code<%=i+1%>" id="allergy_remarks_code<%=i+1%>" value="">
       					 <input type="hidden"  name="dose_remarks_code<%=i+1%>" id="dose_remarks_code<%=i+1%>" value="">
      					 <input type="hidden"  name="currentrx_remarks_code<%=i+1%>" id="currentrx_remarks_code<%=i+1%>" value="">
      					 <!-- Added for IN:072715 end -->	
						<input type="hidden" name="drug_code<%=i+1%>" id="drug_code<%=i+1%>"	 value="<%=drug_code%>">
						<input type="hidden" name="strength_uom<%=i+1%>" id="strength_uom<%=i+1%>" value="<%=strength_uom%>">
						<input type="hidden" name="pres_remarks<%=i+1%>" id="pres_remarks<%=i+1%>" value="<%=pres_remarks%>">
						<input type="hidden" name="tdmOrderIdAmnd<%=i+1%>" id="tdmOrderIdAmnd<%=i+1%>" value="<%=tdmOrderIdAmnd%>">
						<input type="hidden" name="srl_no<%=i+1%>" id="srl_no<%=i+1%>" value="<%= srl_no %>">
						<input type="hidden" name="external_prod_id_<%=i+1%>" id="external_prod_id_<%=i+1%>" value="<%=external_prod_id%>">
						<input type="hidden" name="external_dosage_override_reason<%=i+1%>" id="external_dosage_override_reason<%=i+1%>" value="<%=dosage_limit_override_reason%>">
						<input type="hidden" name="external_duplicate_override_reason<%=i+1%>" id="external_duplicate_override_reason<%=i+1%>" value="<%=duplicate_drug_override_reason%>">
						<input type="hidden" name="external_interaction_override_reason<%=i+1%>" id="external_interaction_override_reason<%=i+1%>" value="<%=interaction_override_reason%>">
						<input type="hidden" name="external_contra_override_reason<%=i+1%>" id="external_contra_override_reason<%=i+1%>" value="<%=contraind_override_reason%>">
						<input type="hidden" name="external_Alergy_override_reason<%=i+1%>" id="external_Alergy_override_reason<%=i+1%>" value="<%=allergy_override_reason%>">
						<input type="hidden" name="external_db_dose_check_<%=i+1%>" id="external_db_dose_check_<%=i+1%>" value="<%=drug_db_dose_check_flag%>">
						<input type="hidden" name="ext_med_alerts_fired_for_dup_check_yn<%=i+1%>" id="ext_med_alerts_fired_for_dup_check_yn<%=i+1%>" value="<%=drug_db_duptherapy_flag%>">
						<input type="hidden" name="ext_med_alerts_fired_for_inte_check_yn<%=i+1%>" id="ext_med_alerts_fired_for_inte_check_yn<%=i+1%>" value="<%=drug_db_interact_check_flag%>">
						<input type="hidden" name="ext_med_alerts_fired_for_contra_check_yn<%=i+1%>" id="ext_med_alerts_fired_for_contra_check_yn<%=i+1%>" value="<%=drug_db_contraind_check_flag%>">
						<input type="hidden" name="ext_med_alerts_fired_for_allergy_check_yn<%=i+1%>" id="ext_med_alerts_fired_for_allergy_check_yn<%=i+1%>" value="<%=drug_db_allergy_flag%>">
					</tr>
<% 
					tem=i+2; 

					prescriptionDetails	=	(ArrayList)iv_bean.getDrugDetails();
					for(int j=0;j<prescriptionDetails.size();j++){
						ext_drugData	=(HashMap) prescriptionDetails.get(j);
						ext_drug_code	=(String) ext_drugData.get("DRUG_CODE");
						if( drug_code.equals(ext_drug_code) ){
							if(!allergy_override_reason.equals("") ) {
								ext_drugData.put("ALLERGY_REMARKS",allergy_override_reason);
								ext_drugData.put("ALLERGY_OVERRIDE","Y");
								ext_drugData.put("ALLERGY_REMARKS_CODE",allergy_remarks_code);//Added for IN:072715 
							}

							if(!dosage_limit_override_reason.equals("")) {
								ext_drugData.put("DOSE_REMARKS",dosage_limit_override_reason);
								ext_drugData.put("DOSE_OVERRIDE","Y");
								ext_drugData.put("DOSE_REMARKS_CODE",dose_remarks_code);//Added for IN:072715 
							}

							if(!duplicate_drug_override_reason.equals("")) {
								ext_drugData.put("CURRENTRX_REMARKS",duplicate_drug_override_reason);
								ext_drugData.put("CURRENTRX_OVERRIDE","Y");
								ext_drugData.put("CURRENTRX_REMARKS_CODE",currentrx_remarks_code);//Added for IN:072715 
							}
							break;
						}
					}
				}
			}
			if(tem<= 4){
				for(int t=tem;t<=4;t++){ 
%>
					<tr>
						<td class="QRYEVENSMALL" width="3%" >
							<table>
							  <td NOWRAP width="12" class="label" id="ADR_<%=t%>" name="ADR_<%=t%>" style="visibility:hidden" >
									<img style="visibility:hidden" id="ADR_img_<%=t%>" name="ADR_img_<%=t%>" src='../../ePH/images/ADR.gif'   title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>'></img>
								</td>	
								<td NOWRAP width="12" class="SHIFTTOTAL" id="external_<%=t%>" name="external_<%=t%>" style="visibility:hidden" >
									<img style="visibility:hidden" id="external_img<%=t%>" name="external_img<%=t%>" src='../../ePH/images/exceed1.gif' ></img>
								</td>
								<td NOWRAP width="12" class="ALLERGY" id="allergy_<%=t%>" name="allergy_<%=t%>" style="visibility:hidden">
									<img style="visibility:hidden" id="allergy_img<%=t%>" name="allergy_img<%=t%>" src='../../ePH/images/exceed1.gif' ></img>
								</td>
								<td NOWRAP width="12" class="DOSELIMIT" id="dosage_<%=t%>" name="dosage_<%=t%>" style="visibility:hidden">
									<img style="visibility:hidden" id="dosage_img<%=t%>" name="dosage_img<%=t%>" src='../../ePH/images/exceed1.gif' ></img>
								</td>
								<td NOWRAP width="12" class="CURRENTRX" id="currentrx_<%=t%>" name="currentrx_<%=t%>" style="visibility:hidden">
									<img style="visibility:hidden" id="currentrx_img<%=t%>" name="currentrx_img<%=t%>" src='../../ePH/images/exceed1.gif' ></img>
								</td>
							</table>
						</td>
						<td class="QRYEVENSMALL" width="34%">&nbsp;
							<input type="text" name="drug_name<%=t%>" id="drug_name<%=t%>"  name="drug_name<%=t%>" size="42"  maxlength="42" value="" disabled onblur="deleteDrug(this,<%=t%>)" >
							
							<input type="button" name="drug_search<%=t%>" id="drug_search<%=t%>" name="drug_search<%=t%>" value="?" class="button"  disabled  onClick="searchDrug(prescription_compdetail_form,'D', drug_name<%=t%>,<%=t%>)"></td>
						<td class="QRYEVENSMALL"  width="5%"> 
							<b><label style="font-size:7pt" class="label" id="strength<%=t%>" name="strength<%=t%>">&nbsp;</label></b>
						</td>
						<td class="QRYEVENSMALL"  width="10%">
							<b><label style="font-size:7pt" class="label" id="form<%=t%>" name="form<%=t%>">&nbsp;</label></b>
						</td>
						<td class="QRYEVENSMALL"  width="16%">
							<input type="text" name="absol_qty<%=t%>" id="absol_qty<%=t%>" name="absol_qty<%=t%>" value="" disabled size="6" maxlength="6" onblur="CheckNum(this);extdosechk();" onKeyPress="return allowValidNumber(this,event,6,0);" class="number">&nbsp;
							<b><label style="font-size:7pt" class="label" id="qty<%=t%>" name="qty<%=t%>">&nbsp;</label></b>
						</td>
						<td class="QRYEVENSMALL"  width="8%" >
							<A style="visibility:hidden" id="remarks_<%=t%>"  name="remarks_<%=t%>" onMouseOver="changeCursor(this);" HREF="javascript:getRemarks('<%=t%>','Y')"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></A>
							<!-- added for [IN:039576]-start -->
							<img  src="../../eCommon/images/mandatory.gif" style='display:none;' id='DrugRemarksMandImg_<%=t%>' name='DrugRemarksMandImg_<%=t%>'>
							<input type='hidden' name='DrugRemarksMandatory_<%=t%>' id='DrugRemarksMandatory_<%=t%>' value='N'>
							<input type='hidden' name='DrugRemarksEntered_<%=t%>' id='DrugRemarksEntered_<%=t%>' value="<%=DrugRemarksEntered%>">
							<!-- added for [IN:039576]-end -->
							<a style="visibility:hidden" href="javascript:drugindication_remarks('<%=t%>');" id="drug_ind_remarks_<%=t%>" name="drug_ind_remarks_<%=t%>" style="visibility:visible" title='<fmt:message key="ePH.DrugIndications.label" bundle="${ph_labels}"/>'><fmt:message key="ePH.DrugIndications.label" bundle="${ph_labels}"/></a>
							<input type="hidden" name="DrugIndicationRemarks_<%=t%>" id="DrugIndicationRemarks_<%=t%>"	value="<%=DrugIndicationRemarks%>"><!--Added for ML-BRU-CRF-072[Inc:29938] -->
						</td>
						<td class="QRYEVENSMALL" width="14%">
							<input style="visibility:hidden" type="button" class="button" width="8%" value="Override" id="dosage_limit<%=t%>" name="dosage_limit<%=t%>" onclick="overRideRemarks(drug_code<%=t%>.value,'<%=t%>')">&nbsp;<input disabled style="visibility:hidden" type="checkbox" width="2%" id="chk_ovr<%=t%>" name="chk_ovr<%=t%>" onclick=""> 
						</td>
						<input type="hidden" name="drug_class<%=t%>" id="drug_class<%=t%>" value="">
						<input type="hidden" name="srl_no<%=t%>" id="srl_no<%=t%>" value="<%=srl_no%>">
						<input type="hidden" name="ALLERGY_DESC<%=t%>" id="ALLERGY_DESC<%=t%>" value="">
						<input type="hidden" name="EXCEED_DOSE_DESC<%=t%>" id="EXCEED_DOSE_DESC<%=t%>" value="">
						<input type="hidden" name="DUP_DRUG_DESC<%=t%>" id="DUP_DRUG_DESC<%=t%>" value="">
						<!-- Added for IN:072715 start -->		
      					 <input type="hidden"  name="allergy_remarks_code<%=t%>" id="allergy_remarks_code<%=t%>" value="">
       					 <input type="hidden"  name="dose_remarks_code<%=t%>" id="dose_remarks_code<%=t%>" value="">
      					 <input type="hidden"  name="currentrx_remarks_code<%=t%>" id="currentrx_remarks_code<%=t%>" value="">
      					 <!-- Added for IN:072715 end -->		
						<input type="hidden" name="drug_code<%=t%>" id="drug_code<%=t%>"	 value="">
						<input type="hidden" name="strength_uom<%=t%>" id="strength_uom<%=t%>" value="">
						<input type="hidden" name="external_db_dose_check_<%=t%>" id="external_db_dose_check_<%=t%>" value="">
						<input type="hidden" name="external_dosage_override_reason<%=t%>" id="external_dosage_override_reason<%=t%>" value="">
						<input type="hidden" name="external_duplicate_override_reason<%=t%>" id="external_duplicate_override_reason<%=t%>" value="">
						<input type="hidden" name="external_interaction_override_reason<%=t%>" id="external_interaction_override_reason<%=t%>" value="">
						<input type="hidden" name="external_contra_override_reason<%=t%>" id="external_contra_override_reason<%=t%>" value="">
						<input type="hidden" name="external_Alergy_override_reason<%=t%>" id="external_Alergy_override_reason<%=t%>" value="">
					</tr>
<% 
				}
			}

			drug_dtls=(HashMap)comp_drugs.get(0);
			if(drug_dtls != null){
				amnd_drg_code			= (String)drug_dtls.get("ORDER_CATALOG_CODE"); 
				repeat_value			= (String) drug_dtls.get("REPEAT_VALUE");
				if(repeat_value == null) repeat_value ="1";
			}	
			srl_no           ="1";

			Hashtable sch_output1	=	new Hashtable();
			sch_output1.put("code",amnd_drg_code);
			sch_output1.put("row_value",srl_no);
			sch_output1.put("repeat",repeat_value);
			order_line_num="1";

			ArrayList values	=	iv_bean.getFreqDet(order_id,order_line_num);
			int incr=0;

			for(int p=0; p<values.size(); p+=3) {
				incr++;
				sch_output1.put("time"+(incr),values.get(p));
				sch_output1.put("qty"+(incr),values.get(p+1));				
			}

			if(incr<=6) {
				for(int q=(incr+1); q<=6; q++) {
					sch_output1.put("time"+(q),"");
					sch_output1.put("qty"+(q),"");
				}
			}
			
			iv_bean.setScheduleFrequencyStr(sch_output1);
		
			chkValuescheduleFrequency	        = iv_bean.getscheduleFrequency();

			if(chkValuescheduleFrequency!= null && chkValuescheduleFrequency.size()>0){
				frequencyValues			= (ArrayList) chkValuescheduleFrequency.get(amnd_drg_code);
			}
%>
			<tr height="4">
				<td colspan="12"></td>
			</tr>
		</table>

		<table cellpadding=0 cellspacing=0 width="100%" align="center" border="0">
			<tr>
				<td class="COLUMNHEADERCENTER" colspan="12" >
					<fmt:message key="ePH.AdminDetails.label" bundle="${ph_labels}"/>
				</td>
			</tr>
			<tr height="8">
				<td colspan="12"></td>
			</tr>
			<tr>
				<td class="label" width="15%">
					<fmt:message key="Common.Dosage.label" bundle="${common_labels}"/>
				</td>
				<td class="label" width="5%">
					<input type="text" name="dosage" id="dosage" value="<%=qty_value%>" <%=disableflag%> onBlur="CheckNum(this);chkBlank();setSchedule(this.value);autoschedule1();" onKeyPress="return allowValidNumber(this,event,3,0);" size="2"  maxlength="3" style="text-align:right">&nbsp;
					<label  class="label" id="qty_uom" name="qty_uom"><%=qty_unit%></label>
				</td> 
				<td class="label" width="5%">
					<fmt:message key="Common.Frequency.label" bundle="${common_labels}"/>
				</td>
				<td class="label" width="5%">
					<select name="frequency" id="frequency" <%=disableflag%> onChange="ValidateDosage(); setSchedule(dosage.value);extdosechk();" style="width:200;">
						<option value="">&nbsp;&nbsp;&nbsp;--- <fmt:message key="ePH.Select.label" bundle="${ph_labels}"/> ---&nbsp;&nbsp;&nbsp; </option>
<%
						for(int i=0; i<frequency.size(); i+=2) {
							temp=(String)frequency.get(i);
							if(temp.equals(freq_code)){    
%>
								<option value="<%=(String)frequency.get(i)%>" Selected ><%=(String)frequency.get(i+1)%></option>
<%	
							}
							else{
%>
								<option value="<%=(String)frequency.get(i)%>"><%=(String)frequency.get(i+1)%></option>
<%	
							}
						}	
%>
					</select>
				</td>
				<td class="label" width="5%">
					<input type="button" name="btn_schedule" id="btn_schedule" value="Schedule" disabled class="button" onClick="DisplaySchedule()">
				</td>
				<td class="label"  id="dosage_label" nowrap>&nbsp;</td>
				<td class="label" width="25%"><fmt:message key="ePH.Admixture.label" bundle="${ph_labels}"/>
					<input type="checkbox" name="admixture" id="admixture"  value="Y" CHECKED DISABLED>&nbsp;&nbsp;
					<fmt:message key="ePH.BuildMAR.label" bundle="${ph_labels}"/>
					<!-- RUT-CRF-0062 [IN029600] buildMAR_ynEnable flag added to enable / disable based on Build MAR Rule -->	
	<% 				
					if(!ext_disp_appl_yn.equals(""))
					{
	%>
					<input type="checkbox" name="buildMAR_yn" id="buildMAR_yn"  value="<%=buildMAR_yn%>" <%=buildMAR_ynCheck%> <%=buildMAR_ynEnable%> >	
	<%
					}
	%>
				</td>
			</tr>
			<tr height="8">
				<td colspan="12"></td>
			</tr>
			<tr> 
				<td class="label" width="15%">
					<fmt:message key="Common.duration.label" bundle="${common_labels}"/>
				</td>
				<td width="5%" nowrap class='label'>
					<input type="text" size="1" maxlength="11" name="durn_value" id="durn_value" class="NUMBER"  value="<%=durn_vlaue%>"  onBlur="validateDuration(this);CheckPositiveNumber(this);populateEndDate();extdosechk();" onKeyPress="return(ChkNumberInput(this,event,'0'))" >&nbsp;
					<label id="durn_desc" class="label"></label>
				</td>
				<td class="label" width="20%">
					<fmt:message key="Common.StartDate.label" bundle="${common_labels}"/>
				</td>
				<td class="label" colspan="2" width="20%">
					<input type="text" name="start_date" id="start_date" size="14"  maxlength="16" onBlur="if(CheckDateLeap(this,'DMYHM','<%=locale%>')) populateEndDate();" value="<%=start_date%>" <%=disableflag%> > <!-- Changed from onBlur="populateEndDate();" to onBlur="if(CheckDateLeap(this,'DMYHM','<%=locale%>')) populateEndDate();" RollForward from SRR - SRR20056-SCF-9368 [IN:057068]-->
					<IMG SRC="../../eCommon/images/CommonCalendar.gif"  <%=disableflag%>  id='Calendar' name='Calendar' onclick="if(document.prescription_compdetail_form.start_date.disabled){return false;};showCalendar('start_date',null,'hh:mm');document.prescription_compdetail_form.start_date.focus();return false;" >
				</td>
				<td class="label" colspan="2" width="20%">
					<fmt:message key="Common.enddate.label" bundle="${common_labels}"/>&nbsp;&nbsp;
					<input type="text" name="end_date" id="end_date"  value="<%=end_date%>"  size="14"  maxlength="13" value="" disabled>
				</td>
			</tr> 
			<tr height="8"><td colspan="12"></td></tr>
		</table>
<%
		if(!drug_db_interface_yn.equals("Y")){
%>
			<table  border="2" bordercolor="black" width="100%">
				<tr> 
					<td NOWRAP width="15" class="ALLERGY">
						<img src='../../ePH/images/exceed1.gif' ></img>
					</td>
					<td NOWRAP  style="font-size:7pt" class="label" border="0" bordercolor="label">
						<fmt:message key="ePH.Allergic.label" bundle="${ph_labels}"/>
					</td>
					<td  NOWRAP width="15" class="DOSELIMIT"  border="1" bordercolor="black">
						<img src='../../ePH/images/exceed1.gif' ></img>
					</td>
					<td  NOWRAP  style="font-size:7pt" class="label" border="0" bordercolor="label" >
						<fmt:message key="ePH.BeyondDoseLimit.label" bundle="${ph_labels}"/>
					</td>
					<td  NOWRAP width="15" class="CURRENTRX"
					border="1" bordercolor="black">
						<img src='../../ePH/images/exceed1.gif' ></img>
					</td>
					<td  NOWRAP style="font-size:7pt" class="label" border="0" bordercolor="label">
						<fmt:message key="ePH.DuplicateDrug.label" bundle="${ph_labels}"/>
					</td> 
				</tr> 
				<tr height="8">
					<td colspan="12"></td>
				</tr>
			</table>
<%
		}
%>
		<input type="hidden" name="no_of_drugs" id="no_of_drugs" value="<%=no_of_drugs%>">
<% 
	}
	else{
		drug_code				= request.getParameter("drug_code") ;
		srl_no					= request.getParameter("srl_no") ;
		priority				= request.getParameter("priority")==null?"":request.getParameter("priority") ;
		start_time				= request.getParameter("start_date") ;
		bsa					= request.getParameter("bsa")==null?"":request.getParameter("bsa") ;
		weight					= request.getParameter("weight")==null?"0":request.getParameter("weight") ; // ML-MMOH-CRF-1408
		height					= request.getParameter("height")==null?"0":request.getParameter("height") ; // ML-MMOH-CRF-1408
		String MAR_app_yn				=  request.getParameter("MAR_app_yn")==null?"N":request.getParameter("MAR_app_yn");
		iv_bean.setWeight(weight); // ML-MMOH-CRF-1408
		iv_bean.setBSA(bsa);// ML-MMOH-CRF-1408

System.err.println("weight======>"+weight+"==bsa===>"+bsa+"==height==>"+height);
		//RUT-CRF-0062 [IN029600] Build MAR will be loaded  based on the first drug selected. (PrescriptionCompValidate.jsp)  - begin
		/*if(MAR_app_yn.equals("Y")){
			buildMAR_ynCheck="checked";
			buildMAR_yn = "Y";
		}
		else{
			buildMAR_ynCheck="";
			buildMAR_yn = "N";
		}
		*/
		
		if(!MAR_app_yn.equals("Y")){
			buildMAR_ynEnable="disabled";
			buildMAR_yn = "N";
		}
			
		//RUT-CRF-0062 [IN029600] Build MAR will be loaded  based on the first drug selected.   - end
		/* Commented for SRR20056-CRF-0649.1 to (deselect)enable BuildMAR fo rIP
		if(patient_class.equals("IP") && MAR_app_yn.equals("Y"))
			buildMAR_ynCheck = buildMAR_ynCheck+" disabled";
		 SRR20056-CRF-0649.1 */
		AllUOMs=iv_bean.getAllUOMs();
%>
		<body onMouseDown="" onKeyDown="lockKey()">
			<form name="prescription_compdetail_form" id="prescription_compdetail_form" >
			<!-- Prescription Writer Table starts-->
				<table cellpadding=0 cellspacing=0 width="100%" align="center" border="0">
					<tr>
						<td class='label' width='12%'>&nbsp;<fmt:message key="ePH.PrescribingBy.label" bundle="${ph_labels}"/></td>
						<td class='label' width='8%'><label for="r1"><input type='radio' name='pres_by' id='pres_by' value='S' id="r1" onClick='changePrescribingBy(this)' checked><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></label></td>
						<td class='label' width='6%'><label for="r2"><input type='radio' name='pres_by' id='pres_by' value='R' id="r2" onClick='changePrescribingBy(this)'><fmt:message key="ePH.Ratio.label" bundle="${ph_labels}"/></label></td>
						<td class='label' width='25%'><label for="r3"><input type='radio' name='pres_by' id='pres_by' value='P' id="r3" onClick='changePrescribingBy(this)'><fmt:message key="ePH.Percentage.label" bundle="${ph_labels}"/>%</label></td>						
						<td class='label'><fmt:message key="ePH.ReqdFinalProductQty.label" bundle="${ph_labels}"/> &nbsp;<input type='text' value="" name='final_prod_qty' id='final_prod_qty' size='5' maxlength='3' onKeyPress="return allowValidNumber(this,event,3,0);" onBlur="percentageRatioCalculation('NX');" disabled>&nbsp;<select name='final_prod_qty_uom' id='final_prod_qty_uom' onChange="changeFinalProductQtyUOM(this);" disabled><option value="">-- <fmt:message key="ePH.Select.label" bundle="${ph_labels}"/> --</option>
<%
							for(int uomsize=0;uomsize<AllUOMs.size();uomsize+=2){
%>
								<option value='<%=AllUOMs.get(uomsize)%>'><%=AllUOMs.get(uomsize+1)%></option>
<%
							}
%>
							</select><img src="../../eCommon/images/mandatory.gif" id='mandImage1' name='mandImage1' align="center" style="display:none;"></td>
						</td>					
					</tr>
				</table>
				<div id="bar" style="overflow: auto; height: 88px; width: 100%;">
				<table cellpadding=0 cellspacing=0 width="100%" align="center" border="0">
					<tr>
						<td class="COLUMNHEADER" colspan="1" ><fmt:message key="ePH.Alerts.label" bundle="${ph_labels}"/></td>
						<td class="COLUMNHEADER" colspan="1" ><fmt:message key="ePH.Drugs.label" bundle="${ph_labels}"/></td>
						<td class="COLUMNHEADER" colspan="1" ><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></td>
						<td class="COLUMNHEADER" colspan="1" ><fmt:message key="ePH.Form.label" bundle="${ph_labels}"/></td>
						<td class="COLUMNHEADER" colspan="1" id="perc_rat_header" name="perc_rat_header" style="display:" ><fmt:message key="ePH.Ratio.label" bundle="${ph_labels}"/></td>
						<td class="COLUMNHEADER" colspan="1" id="req_qty_header" name="req_qty_header" style="display:" ><fmt:message key="ePH.ReqQty.label" bundle="${ph_labels}"/></td>
						<td class="COLUMNHEADER" colspan="1" id="absol_qty_header" name="absol_qty_header"><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
						<td class="COLUMNHEADER" colspan="1" ></td>
						<td class="COLUMNHEADER" colspan="1" ></td>
					</tr>
<%
					for(int i=1; i<=10; i++){
%>
						<tr>
							<td class="label" width="5%" >
								<table cellpadding=0 cellspacing=0 border="0">
									<tr>
									   	<td NOWRAP width="12" class="label" id="ADR_<%=i%>" name="ADR_<%=i%>" style="visibility:hidden" >
											<img style="visibility:hidden" id="ADR_img_<%=i%>" name="ADR_img_<%=i%>" src='../../ePH/images/ADR.gif'  title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>' ></img>
										</td>							    

										<td NOWRAP width="12" class="SHIFTTOTAL" id="external_<%=i%>" name="external_<%=i%>" style="visibility:hidden" onclick="displayDosageCheckResult(<%=i%>)">
											<img style="visibility:hidden" id="external_img<%=i%>" name="external_img<%=i%>" src='../../ePH/images/exceed1.gif'  ></img>
										</td>
										<td NOWRAP width="12" class="ALLERGY" id="allergy_<%=i%>" name="allergy_<%=i%>" style="visibility:hidden"  onclick="showAllergyDetails(generic_id<%=i%>.value,'<%=patient_id%>','<%=encounter_id%>',encodeURIComponent(generic_name<%=i%>.value),encodeURIComponent(drug_name<%=i%>.value));" onmouseover="changeCursor(this);" >
											<img style="visibility:hidden" id="allergy_img<%=i%>" name="allergy_img<%=i%>" src='../../ePH/images/exceed1.gif' ></img>
										</td>
										<td NOWRAP width="12" class="DOSELIMIT" id="dosage_<%=i%>" name="dosage_<%=i%>" style="visibility:hidden">
											<img style="visibility:hidden" id="dosage_img<%=i%>" name="dosage_img<%=i%>" src='../../ePH/images/exceed1.gif'  ></img>
										</td>
										<td NOWRAP width="12" class="CURRENTRX" id="currentrx_<%=i%>" name="currentrx_<%=i%>" style="visibility:hidden">
											<img style="visibility:hidden" id="currentrx_img<%=i%>" name="currentrx_img<%=i%>" src='../../ePH/images/exceed1.gif' ></img>
										</td>
									</tr>
								</table>
							</td>
							<td class="label" width="38%" nowrap>		
								<label for="baseDrugId<%=i%>" id="lblBaseDrugId<%=i%>" name="lblBaseDrugId<%=i%>" style='display:none;'><input type='radio' name='baseDrug' id='baseDrug' id='baseDrugId<%=i%>' onClick="selectBaseDrug(this)" value='<%=i%>'/><fmt:message key="ePH.Base.label" bundle="${ph_labels}"/></label>
								<input type="text" name="drug_name<%=i%>" id="drug_name<%=i%>" size="42"  maxlength="42" value="" onblur="deleteDrug(this,<%=i%>)" onChange="searchDrug(prescription_compdetail_form,'D', drug_name<%=i%>,<%=i%>)" ><!-- added for SKR-SCF-1391 -->
<%-- 								<input type="button" name="drug_search<%=i%>" id="drug_search<%=i%>" value="?" class="button"  onfocus="searchDrug(prescription_compdetail_form,'D', drug_name<%=i%>,<%=i%>)" onClick="searchDrug(prescription_compdetail_form,'D', drug_name<%=i%>,<%=i%>)">&nbsp;&nbsp; --%><!-- commented for SKR-SCF-1317 -->
								<input type="button" name="drug_search<%=i%>" id="drug_search<%=i%>" value="?" class="button"  onClick="searchDrug(prescription_compdetail_form,'D', drug_name<%=i%>,<%=i%>)">&nbsp;&nbsp; <!-- REMOVED onFocus for SKR-SCF-1317 -->
								<img style="visibility:hidden;cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/info.gif" height=20 id="drug_info_<%=i%>"  width=20 onClick="loadDrugInfo(document.prescription_compdetail_form,<%=i%>)">
								<img style="visibility:hidden;cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/FD-ICON-rollOverInformationIcon.gif" height=20  width=20 onClick="openEDLDetails(drug_code<%=i%>.value);" id="edl_info_<%=i%>" name="edl_info_<%=i%>">
							</td>
							<td NOWRAP class="label"  width="9%">
								<b><label style="font-size:7pt" class="label" id="strength<%=i%>" name="strength<%=i%>"></label></b>
							</td>
							<td class="label"  width="10%">
								<b><label style="font-size:7pt" class="label" id="form<%=i%>" name="form<%=i%>"></label></b>
							</td>
							<td class="label" id="perc_rat_col<%=i%>" name="perc_rat_col<%=i%>" style="display:;width: 9%;">
								<input type='text' name="percent_ratio<%=i%>" id="percent_ratio<%=i%>" value="" size=2 onKeyPress="return percentageRatioValidation(this)" onBlur="percentageRatioCalculation('<%=i%>','PR')"><label class='label' id=perc<%=i%> name=perc<%=i%> style="display:none;font-size:7pt">%</label>
							</td>
							<td class="label" id="req_qty_col<%=i%>" name="req_qty_col<%=i%>" style="display:none;" nowrap>
								<input type='text' name="req_qty<%=i%>" id="req_qty<%=i%>" value="" size=1  maxlength="6" disabled style="text-align:right;"><div class='label' id='req_qty_uom<%=i%>' name='req_qty_uom<%=i%>' style="display:none;font-size:7pt"></div>
							</td>
							<td class="label"  width="15%" nowrap>
								<input type="text" name="absol_qty<%=i%>" id="absol_qty<%=i%>" value="" size="3" maxlength="6" onblur="CheckNum(this);extdosechk();calculateOrderQuantiyInStrengthMode('<%=i%>')" onKeyPress="return allowValidNumber(this,event,6,0);" class="number">
								<b><label style="font-size:7pt" class="label" id="qty<%=i%>"></label></b>
							</td>
							<td class="label"  width="6%" nowrap>
								<A style="visibility:visible" id="remarks_<%=i%>"  name="remarks_<%=i%>" onMouseOver="changeCursor(this);" HREF="javascript:getRemarks('<%=i%>','Y')"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></A>
								<!-- added for [IN:039576]-start -->
								<img  src="../../eCommon/images/mandatory.gif" style='display:none;' id='DrugRemarksMandImg_<%=i%>' name='DrugRemarksMandImg_<%=i%>'>
								<input type='hidden' name='DrugRemarksMandatory_<%=i%>' id='DrugRemarksMandatory_<%=i%>' value='N'>
								<input type='hidden' name='DrugRemarksEntered_<%=i%>' id='DrugRemarksEntered_<%=i%>' value="<%=DrugRemarksEntered%>">
								<!-- added for [IN:039576]-end -->
								<a style="visibility:hidden" href="javascript:drugindication_remarks('<%=i%>');" id="drug_ind_remarks_<%=i%>" name="drug_ind_remarks_<%=i%>" style="visibility:visible" title='<fmt:message key="ePH.DrugIndications.label" bundle="${ph_labels}"/>'><fmt:message key="ePH.DrugIndications.label" bundle="${ph_labels}"/></a>
								<input type="hidden" name="DrugIndicationRemarks_<%=i%>" id="DrugIndicationRemarks_<%=i%>"	value="<%=DrugIndicationRemarks%>"><!--Added for ML-BRU-CRF-072[Inc:29938] -->
							</td>
							
							<td class="label" width="16%" nowrap>
								<input style="visibility:hidden" type="button" class="button" width="6%" value="Override" id="dosage_limit<%=i%>"  name="dosage_limit<%=i%>" onclick="overRideRemarks(drug_code<%=i%>.value,'<%=i%>')" > 
							<!-- Modified for IN:072715 START -->
								<%if(over_ride_remarks_select_appl){ %>
								<input style="visibility:hidden" type="checkbox" width="2%" id="chk_ovr<%=i%>" name="chk_ovr<%=i%>" onclick="overRideRemarks(drug_code<%=i%>.value,'<%=i%>')" >
								<%}else{ %>
								<input style="visibility:hidden" type="checkbox" width="2%" id="chk_ovr<%=i%>" name="chk_ovr<%=i%>" onclick="default_override_rsn('<%=i%>')" >
								<%} %>
								<!-- Modified for IN:072715 START -->
								<A title="TDM Result" style="visibility:hidden" id="tdmRslt_<%=i%>" name="tdmRslt_<%=i%>" HREF onMouseOver="changeCursor(this);" onClick="viewReasonforRequest(tdmOrderId<%=i%>.value)"> <fmt:message key="ePH.TDM.label" bundle="${ph_labels}"/></A>
							</td>
							<input type="hidden" name="drug_class<%=i%>" id="drug_class<%=i%>" value="">
							<input type="hidden" name="drug_code<%=i%>" id="drug_code<%=i%>"		value="">
							<input type="hidden" name="strength_uom<%=i%>" id="strength_uom<%=i%>"	value="">
							<input type="hidden" name="strength_uom_need<%=i%>" id="strength_uom_need<%=i%>"	value=""><!-- //added for CRF--0749 INC-13640 -->
							<input type="hidden" name="tdmOrderId<%=i%>" id="tdmOrderId<%=i%>"		value="">
							<input type="hidden" name="ALLERGY_DESC<%=i%>" id="ALLERGY_DESC<%=i%>" value="">
							<input type="hidden" name="EXCEED_DOSE_DESC<%=i%>" id="EXCEED_DOSE_DESC<%=i%>" value="">
							<input type="hidden" name="DUP_DRUG_DESC<%=i%>" id="DUP_DRUG_DESC<%=i%>" value="">	
							<!-- Added for IN:072715 start -->		
      					 <input type="hidden"  name="allergy_remarks_code<%=i%>" id="allergy_remarks_code<%=i%>" value="">
       					 <input type="hidden"  name="dose_remarks_code<%=i%>" id="dose_remarks_code<%=i%>" value="">
      					 <input type="hidden"  name="currentrx_remarks_code<%=i%>" id="currentrx_remarks_code<%=i%>" value="">
      					 <!-- Added for IN:072715 end -->		
							<input type="hidden" name="pres_base_uom<%=i%>" id="pres_base_uom<%=i%>" value="">
							<input type="hidden" name="pres_base_uom_need<%=i%>" id="pres_base_uom_need<%=i%>" value=""><!-- //added for CRF--0749 INC-13640 -->
							<input type="hidden" name="external_prod_id_<%=i%>" id="external_prod_id_<%=i%>" value="">
							<!-- <input type="hidden" name="external_override_reason_<%=i%>" id="external_override_reason_<%=i%>" value=""> -->
							<input type="hidden" name="external_dosage_override_reason<%=i%>" id="external_dosage_override_reason<%=i%>" value="">
							<input type="hidden" name="external_duplicate_override_reason<%=i%>" id="external_duplicate_override_reason<%=i%>" value="">
							<input type="hidden" name="external_interaction_override_reason<%=i%>" id="external_interaction_override_reason<%=i%>" value="">
							<input type="hidden" name="external_contra_override_reason<%=i%>" id="external_contra_override_reason<%=i%>" value="">
							<input type="hidden" name="external_Alergy_override_reason<%=i%>" id="external_Alergy_override_reason<%=i%>" value="">
							<input type="hidden" name="external_db_dose_check_<%=i%>" id="external_db_dose_check_<%=i%>" value="">
							<input type="hidden" name="ext_med_alerts_fired_for_dup_check_yn<%=i%>" id="ext_med_alerts_fired_for_dup_check_yn<%=i%>" value="N">
							<input type="hidden" name="ext_med_alerts_fired_for_inte_check_yn<%=i%>" id="ext_med_alerts_fired_for_inte_check_yn<%=i%>" value="N">
							<input type="hidden" name="ext_med_alerts_fired_for_contra_check_yn<%=i%>" id="ext_med_alerts_fired_for_contra_check_yn<%=i%>" value="N">
							<input type="hidden" name="ext_med_alerts_fired_for_allergy_check_yn<%=i%>" id="ext_med_alerts_fired_for_allergy_check_yn<%=i%>" value="N">						
							<input type="hidden" name="equvalentUOM_conversion_value<%=i%>" id="equvalentUOM_conversion_value<%=i%>" value="">
							<input type="hidden" name="equvalentUOM_conversion_factor<%=i%>" id="equvalentUOM_conversion_factor<%=i%>" value="">
							<input type="hidden" name="contentInPresBaseUOM<%=i%>" id="contentInPresBaseUOM<%=i%>" value="">
							<input type="hidden" name="orderQty<%=i%>" id="orderQty<%=i%>" value="">
							<input type="hidden" name="orderQtyUOM<%=i%>" id="orderQtyUOM<%=i%>" value="">
							<input type="hidden" name="Perform_ext_db_checks_YN<%=i%>" id="Perform_ext_db_checks_YN<%=i%>" value="N">
							<input type="hidden" name="generic_id<%=i%>" id="generic_id<%=i%>" value="">
							<input type="hidden" name="generic_name<%=i%>" id="generic_name<%=i%>"	value="">
							<!-- added for ML-MMOH-CRF-1408 start-->
							<input type="hidden" name="max_daily_celing_dose<%=i%>" id="max_daily_celing_dose<%=i%>" value="">
							<input type="hidden" name="min_daily_ceiling_dose<%=i%>" id="min_daily_ceiling_dose<%=i%>" value="">
							<input type="hidden" name="max_unit_ceiling_dose<%=i%>" id="max_unit_ceiling_dose<%=i%>" value="">
							<input type="hidden" name="min_unit_ceiling_dose<%=i%>" id="min_unit_ceiling_dose<%=i%>"	value="">
							<!-- added for ML-MMOH-CRF-1408 end-->	
							
						</tr>
						<!-- <tr><td colspan="12">------------------------------</td></tr> -->
<%
					}
%>
					 <tr height="4">
						<td colspan="12"></td>
					</tr> 
				</table>
				</div>
				<hr>
				<table cellpadding=0 cellspacing=0 width="100%" align="center" border="0">
					<tr><td class="label" width='30%' id='ratiofooter'>&nbsp;</td>
						<td class="label" width='20%'><div class="label" id='ratiolabel' name='ratiolabel' style="display:none"><fmt:message key="ePH.Ratio.label" bundle="${ph_labels}"/>:&nbsp;</div></td>
						<td class="label" width='13%'><fmt:message key="ePH.TotalQuantity.label" bundle="${ph_labels}"/></td>
						<td><input type='text' value="" name='txt_total_quantity' id='txt_total_quantity' size=7 style="text-align:right" disabled>&nbsp;<div class='label' id='txt_total_quantity_uom' name='txt_total_quantity_uom' style="display:none"></div></td>
					</tr>
				</table>
				<table cellpadding=0 cellspacing=0 width="100%" align="center" border="0">
					<tr>
						<td class="COLUMNHEADERCENTER" colspan="12" >
							<fmt:message key="ePH.AdminDetails.label" bundle="${ph_labels}"/>
						</td>
					</tr>
						<tr height="2"><td colspan="12"></td></tr>
					<tr>
						<td class="label" colspan="2" width="40%" nowrap>
							<fmt:message key="Common.Dosage.label" bundle="${common_labels}"/>&nbsp;&nbsp;
							<input type="text" name="dosage" id="dosage" value=""  onBlur="CheckNum(this);chkBlank();setSchedule(this.value);autoschedule1();" onKeyPress="return allowValidNumber(this,event,3,0);" size="2"  maxlength="3" style="text-align:right">&nbsp;<select name="uom" id="uom" onChange="">
								<option value="">-- <fmt:message key="ePH.Select.label" bundle="${ph_labels}"/> --</option>
							</select>
							
						</td>
						<td class="label" width="5%">
							<fmt:message key="Common.Frequency.label" bundle="${common_labels}"/>
						</td>
						<td class="label" colspan="5">
							<select name="frequency" id="frequency" onChange="ValidateDosage();setSchedule();extdosechk();" style="width:460;">
								<option value="">&nbsp;&nbsp;&nbsp; --- <fmt:message key="ePH.Select.label" bundle="${ph_labels}"/> ---&nbsp;&nbsp;&nbsp; </option>
<% 
								for(int i=0; i<frequency.size(); i+=2) {
%>
									<option value="<%=(String)frequency.get(i)%>"><%=(String)frequency.get(i+1)%></option>
<%
								}
%>
							</select>
							<input type="button" name="btn_schedule" id="btn_schedule" value="Schedule" disabled class="button" onClick="DisplaySchedule()">
						</td>
						<td class="label" width='10%' id="dosage_label" nowrap>&nbsp;</td>
						
					</tr>
					<tr height="4">
						<td colspan="12"></td>
					</tr>
					<tr>
						<td class="label" width="7%">
							<fmt:message key="Common.duration.label" bundle="${common_labels}"/>
						</td>
						<td width="18%" nowrap>
							<input type="text" size="1" maxlength="11" name="durn_value" id="durn_value" class="NUMBER"  value=""  onBlur="validateDuration(this);CheckPositiveNumber(this);populateEndDate();extdosechk();" onKeyPress="return(ChkNumberInput(this,event,'0'))" >&nbsp;<!--<label id="durn_desc" class="label"></label>--><select name="durn_type_desc" id="durn_type_desc" onChange='validateDuration(durn_value);populateEndDate();extdosechk();'></select>
						</td>
						<td class="label" width="10%">
							<fmt:message key="Common.StartDate.label" bundle="${common_labels}"/>
						</td>
						<td class="label" colspan="2" width="20%">
							<input type="text" name="start_date" id="start_date" size="14"  maxlength="16" onBlur="if(CheckDateLeap(this,'DMYHM','<%=locale%>')) populateEndDate();" value="<%=start_time%>" >  <!-- Changed from onBlur="populateEndDate();" to onBlur="if(CheckDateLeap(this,'DMYHM','<%=locale%>')) populateEndDate();" RollForward from SRR - SRR20056-SCF-9368 [IN:057068]--> 
							<IMG SRC="../../eCommon/images/CommonCalendar.gif"   id='Calendar'  name='Calendar'  onclick="if(document.prescription_compdetail_form.start_date.disabled){return false;};showCalendar('start_date',null,'hh:mm');document.prescription_compdetail_form.start_date.focus();return false;" >
						</td>
						<td class="label" colspan="2">
							<fmt:message key="Common.enddate.label" bundle="${common_labels}"/>&nbsp;&nbsp;
							<input type="text" name="end_date" id="end_date" size="14"  maxlength="13" value="" disabled>
							<td class="label" colspan=2>							
							<fmt:message key="ePH.Admixture.label" bundle="${ph_labels}"/>
							<input type="checkbox" name="admixture" id="admixture"  value="Y" CHECKED DISABLED>&nbsp;&nbsp;<fmt:message key="ePH.BuildMAR.label" bundle="${ph_labels}"/>
<!-- RUT-CRF-0062 [IN029600] buildMAR_ynEnable flag added to enable / disable based on Build MAR Rule -->						
							<input type="checkbox" name="buildMAR_yn" id="buildMAR_yn"  value="<%=buildMAR_yn%>" <%=buildMAR_ynCheck%> <%=buildMAR_ynEnable%> onclick='assignCheckValue(this);'>				
						</td>
					</tr>
					<tr height="4"><td colspan="12"></td></tr>
				</table>

				<br>
<%
			}
%>
<!-- Prescription Writer Table ends-->
    
			<input type="hidden" name="order_id" id="order_id"			value="<%=order_id%>">
			<input type="hidden" name="mode" id="mode"				value="<%=calling_mode%>">
			<input type="hidden" name="bean_id" id="bean_id"				value="<%=iv_bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"			value="<%=iv_bean_name%>">
			<input type="hidden" name="patient_class" id="patient_class"		value="<%=patient_class%>">
			<input type="hidden" name="act_patient_class" id="act_patient_class"	value="<%=act_patient_class%>">
			<input type="hidden" name="patient_id" id="patient_id"			value="<%=patient_id%>"> 
			<input type="hidden" name="facility_id" id="facility_id"			value="<%=facility_id%>">
			<input type="hidden" name="encounter_id" id="encounter_id"		value="<%=encounter_id%>">
			<input type="hidden" name="qty_value" id="qty_value"			value="<%=qty_value%>">
			<input type="hidden" name="durn_type" id="durn_type"			value="">
			<input type="hidden" name="freq_nature" id="freq_nature"			value="">
			<input type="hidden" name="qty_desc_code" id="qty_desc_code"		value=""><!-- Added in January 2014 for CIMS dosage check -->
			<input type="hidden" name="route_code" id="route_code"			value=""><!-- Added in January 2014 for CIMS dosage check -->
			<input type="hidden" name="repeat_durn_type" id="repeat_durn_type"	value=""><!-- Added in January 2014 for CIMS dosage check -->
			<input type="hidden" name="sched_medn_yn" id="sched_medn_yn"		value="N">
			<input type="hidden" name="drug_db_interface_yn" id="drug_db_interface_yn"	value="<%=drug_db_interface_yn%>">
			<input type="hidden" name="drug_db_dosecheck_yn" id="drug_db_dosecheck_yn"	value="<%=drug_db_dosecheck_yn%>"><!--added for ML-MMOH-CRF-1408 -->
			<input type='hidden' name='ext_disp_appl_yn' id='ext_disp_appl_yn' value='<%=ext_disp_appl_yn%>'><!--added for NMC-JD-CRF-0046 -->
			 <input type="hidden" value="<%=validate_overide_on_confirm_yn%>" name="validate_overide_on_confirm_yn"><!-- Added for IN:069887  -->
			
			<label id="tool_tip" style="visibility:hidden"></label>

			<div name="tooltiplayer" id="tooltiplayer" style="position:absolute; width:20%; visibility:hidden;">
				<table id="tooltiptable" cellpadding='0' cellspacing='0' border="0" width="auto" height="100%"  align="center">
					<tr>
						<td width="100%" id="t"  ></td>
					</tr>
				</table>
			</div>
		</form>
<%
		putObjectInBean(iv_bean_id,iv_bean,request);
		putObjectInBean(param_bean_id,param_bean,request);
%>
	</body>
<% 
	if(calling_mode.equals("amend") || calling_mode.equals("RENEW_ORDER") ){
		HashMap data		=	null;
		String att			=	null;
		String adm_time		=	"";
		String adm_qty		=	"";
		String total_qty	=   "";

		if(frequencyValues!=null && frequencyValues.size()>0){
			
			adm_time = adm_time + "<tr>";					
			for(int i=0;i<frequencyValues.size();i++){
				data=(HashMap)frequencyValues.get(i);
				att="align=center class=TIP1";
				adm_time = adm_time + "<td "+att+">&nbsp;"+data.get("admin_time")+"&nbsp;</td>";
			}
			adm_time = adm_time + "</tr>";

			adm_qty = adm_qty + "<tr>";
			for(int i=0;i<frequencyValues.size();i++){
				att="align=center class=TIP1";
				data=(HashMap)frequencyValues.get(i);
				adm_qty = adm_qty + "<td "+att+">&nbsp;"+data.get("admin_qty")+"&nbsp;</td>";
				total_qty=(String) data.get("admin_qty");
			}
			adm_qty = adm_qty + "</tr>";
			boolean split_chk	=	iv_bean.checkSplit(frequencyValues);	
%>
			<script>
				makeScheduleLink('<%=adm_time%>','<%=adm_qty%>','<%=total_qty%>','<%=frequencyValues.size()%>','<%=split_chk%>');	
			</script>
<%
		}
%>
		<script>
			//extdosechk();
			for(i=1;i<=4;i++){
//				eval("document.getElementById("external_img")"+i).style.visibility="hidden";
//				eval("document.getElementById("external_img")"+i).style.visibility="visible";
			}
		</script>
<%
	}
	else{
		if(!order_id.equals("") &&  order_id != null ){
%>
			<script>
				setSchedule();
			</script>
<%
		}
	}
%>
	<script>
		populateDurationDesc(document.getElementById('frequency'));
	</script>
</html>
<% }catch(Exception exception) {
       exception.printStackTrace();
 } %>

