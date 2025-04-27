<!DOCTYPE html>
  <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*,eOR.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
	<head>
   <!--  <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
		 request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
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
		<script language="JavaScript" src="../../eCommon/js/PhCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="JavaScript" src="../../ePH/js/PrescriptionComp.js"></script>
		<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="Javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../eOR/js/OrderEntrySearch.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

<!-- Variable initialization starts-->
<%
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
	String external_prod_id					=  "";
	String interaction_override_reason		=  "";
	String contraind_override_reason		=  "";

    String allergy_override_reason_flag			=  "N";	
	String duplicate_drug_override_reason_flag	=  "N";
	String interaction_override_reason_flag		=  "N";
	String contraind_override_reason_flag		=  "N";
	String adr_display_yn						="hidden";
	String ext_image_display					="hidden";

	String drug_desc = "",freq_code = "",qty_value = "",qty_unit = "",durn_vlaue = "",order_qty = "",order_uom = "",start_date	= "",end_date = "",order_id	= "",temp = "", form_desc = "",strength_value = "",strength_uom	= "", pres_remarks = "", allergy_override_reason	= "",dosage_limit_override_reason		= "", duplicate_drug_override_reason	= "",allergy_flag = "hidden",doselimit_flag	= "hidden",currentrx_flag	= "hidden",over_ride_flag	= "hidden",no_of_drugs	= "", order_line_num = "",repeat_value = "", amnd_drg_code = "",disableflag	= "", tdmOrderIdAmnd = "",display_tdm = "", buildMAR_yn="", buildMAR_ynCheck="",ext_over_ride_flag	= "hidden";

	String allergy_yn			= "N";
	String allergy_rsn_flag		= "hidden";
	String currentrx_yn			= "N";
	String currentrx_rsn_flag	= "hidden";
	String limit_ind			= "N";

	HashMap chkValuescheduleFrequency		=	null;
    ArrayList frequencyValues				=	null;
	HashMap drugReasons						=   null;
	int tem									=   0;
	//String ex_bean_id						= "@ExternalProductLinkBean"+patient_id+encounter_id;
    String ex_bean_id						= "@ExternalProductLinkBean";
	String ex_bean_name						= "ePH.ExternalProductLinkBean";
	ExternalProductLinkBean beanex			= (ExternalProductLinkBean)getBeanObject(ex_bean_id,ex_bean_name,request);

	String dup_drug_det						= "";
	HashMap drug_Interactions				= null;
	ArrayList exProd						= new ArrayList();
	ArrayList drugDesc						= new ArrayList();

	String drug_db_contraind_check_flag		=	"N";
	String drug_db_interact_check_flag		=	"N";
	String drug_db_duptherapy_flag			=	"N";
	String drug_db_dose_check_flag			=	"N"; 
	String drug_db_allergy_flag				=	"N";

	ArrayList prescriptionDetails	=	new ArrayList();

	HashMap ext_drugData	=	null;
	String ext_drug_code	=	null;

	HashMap freq_vals              = new HashMap();
    String freq_interval_value          = "";
	String freq_repeat_value            = "";
	String freq_frequency			   = "";
	HashMap drugDosageResult	   = new HashMap();
    ArrayList dosageCheckParams    = new ArrayList();
	String presc_base_uom		   = "";
	if(calling_mode.equals("amend") || calling_mode.equals("RENEW_ORDER") ){
%>
		<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">

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

				comp_drugs=iv_bean.getCompDrugDtls(order_id,act_patient_class); // RUT-CRF-0062 Added actual patient class to get the Build MAR Rule
				if(comp_drugs != null){
					no_of_drugs = comp_drugs.size()+"";

				 HashMap drug_data=new HashMap();
                 for(int i=0;i<comp_drugs.size();i++){
					drug_data	=	(HashMap)comp_drugs.get(i);					
					external_prod_id=(String)drug_data.get("EXTERNAL_PRODUCT_ID");
					if(!external_prod_id.equals("")){
					    exProd.add(external_prod_id);
						drugDesc.add((String)drug_data.get("DRUG_DESC"));
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

						if(buildMAR_yn.equals("Y"))
							buildMAR_ynCheck="checked";
						else{
							buildMAR_ynCheck="";
							buildMAR_yn = "N";
						}

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
							allergy_flag	="hidden";
							doselimit_flag	="hidden";
							currentrx_flag	="hidden";
							over_ride_flag	="hidden";
							ext_over_ride_flag = "hidden";

							drugReasons=iv_bean.getDrugReasons(order_id,(i+1)+"","");
							allergy_override_reason=(String)drugReasons.get("ALLERGY_OVERRIDE_REASON")==null?"":(String)drugReasons.get("ALLERGY_OVERRIDE_REASON");

							dosage_limit_override_reason=(String)drugReasons.get("DOSAGE_LIMIT_OVERRIDE_REASON")==null?"":(String)drugReasons.get("DOSAGE_LIMIT_OVERRIDE_REASON");
							duplicate_drug_override_reason=(String)drugReasons.get("DUPLICATE_DRUG_OVERRIDE_REASON")==null?"":(String)drugReasons.get("DUPLICATE_DRUG_OVERRIDE_REASON");



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
//				beanex.storeDrugIds(patient_id,"",new ArrayList(),new ArrayList());//Store Drug ids
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

				if(drug_db_dosecheck_yn.equals("Y")){
					drugDosageResult = new HashMap();
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
					if(!weight.equals("") && !bsa.equals("")){
					drugDosageResult = beanex.getDrugDosageCheck(dosageCheckParams);

						if(drugDosageResult != null && drugDosageResult.size() > 0){
							drug_db_dose_check_flag = "Y";						
						}
					}
				}
				*/
						if(drug_db_dosecheck_yn.equals("Y")){
							dosageCheckParams        = new ArrayList();
							dosageCheckParams.add(patient_id);
							dosageCheckParams.add(external_prod_id);
							dosageCheckParams.add(weight);
							dosageCheckParams.add(bsa);
							dosageCheckParams.add(qty_value);//dose
							dosageCheckParams.add(presc_base_uom);//pres_base_uom
							dosageCheckParams.add(freq_frequency);
							dosageCheckParams.add(durn_vlaue);
						}

							String storeIDs = "N";
							if(exProd.size()>0 ){
								for(i=0;i<exProd.size();i++){
									if(exProd.get(i).equals(external_prod_id)) {
										drugDesc.remove(i);
										exProd.remove(i);
										break;
									}
								}
							}
							if(exProd.size()>0)
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
								tempDetails =(HashMap)drugDBCheckResult.get("CONTRACHECK");
								if(tempDetails!=null && tempDetails.containsKey(external_prod_id)){
									drug_db_contraind_check_flag="Y";
								}		
							}
						}
				if(drug_db_duptherapy_flag.equals("Y")){
					currentrx_flag="hidden";
					over_ride_flag="hidden";
					currentrx_rsn_flag = "hidden";
				}else if(currentrx_yn.equals("Y")){
					currentrx_flag="visible";
					if(!duplicate_drug_override_reason.equals("")){
						currentrx_rsn_flag = "hidden";
					}else{
						currentrx_rsn_flag = "visible";
					}
				}else if(currentrx_yn.equals("N")){
					currentrx_rsn_flag = "hidden";
				}


				if(drug_db_allergy_flag.equals("Y")){
					allergy_flag="hidden";
					over_ride_flag="hidden";
					allergy_rsn_flag = "hidden";
				}else if(allergy_yn.equals("Y")){
					allergy_flag="visible";	
					if(!allergy_override_reason.equals("")){
						allergy_rsn_flag = "hidden";
					}else{
						allergy_rsn_flag = "visible";
					}
				}else if(allergy_yn.equals("N")){
					allergy_rsn_flag = "hidden";
				}

				drug_dtls.put("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN",drug_db_duptherapy_flag);
				drug_dtls.put("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN",drug_db_interact_check_flag);
				drug_dtls.put("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN",drug_db_contraind_check_flag);
				drug_dtls.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN",drug_db_dose_check_flag);
				drug_dtls.put("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN",drug_db_allergy_flag);

				if(drug_db_allergy_flag.equals("Y") || drug_db_duptherapy_flag.equals("Y") || drug_db_interact_check_flag.equals("Y") || drug_db_contraind_check_flag.equals("Y") || drug_db_dose_check_flag.equals("Y")){ 
					ext_image_display	=	"visible";
				}else{
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
                                  <td NOWRAP width="12" class="label" id="ADR_<%=i+1%>" style="visibility:hidden" >
									<img style="visibility:<%=adr_display_yn%>" id="ADR_img_<%=i+1%>" src='../../ePH/images/ADR.gif'   title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>'></img>
									</td>

									<td NOWRAP width="12" class="SHIFTTOTAL" id="external_<%=i+1%>" style="visibility:<%=ext_image_display%>" onclick="displayDosageCheckResult(<%=i+1%>)"><img style="visibility:<%=ext_over_ride_flag%>" id="external_img<%=i+1%>" src='../../ePH/images/exceed1.gif' ></img></td>
									<td NOWRAP width="12" class="ALLERGY" id="allergy_<%=i+1%>" style="visibility:<%=allergy_flag%>"><img style="visibility:<%=allergy_rsn_flag%>" id="allergy_img<%=i+1%>" src='../../ePH/images/exceed1.gif' ></img></td>
									<td NOWRAP width="12" class="DOSELIMIT" id="dosage_<%=i+1%>" style="visibility:<%=doselimit_flag%>" ><img style="visibility:hidden" id="dosage_img<%=i+1%>" src='../../ePH/images/exceed1.gif' ></img></td>
									<td NOWRAP width="12" class="CURRENTRX" id="currentrx_<%=i+1%>" style="visibility:<%=currentrx_flag%>"><img style="visibility:<%=currentrx_rsn_flag%>" id="currentrx_img<%=i+1%>" src='../../ePH/images/exceed1.gif' ></img></td>
								</tr>
							</table>
						</td>
						<td class="QRYEVENSMALL" width="34%">&nbsp;
							<input type="text" name="drug_name<%=i+1%>" id="drug_name<%=i+1%>" size="42"  maxlength="42" value="<%=drug_desc%>" disabled onblur="deleteDrug(this,<%=i+1%>)" >
							<input type="button" name="drug_search<%=i+1%>" id="drug_search<%=i+1%>" value="?" class="button"  onfocus="searchDrug(prescription_compdetail_form,'D', drug_name<%=i+1%>,<%=i+1%>)" onClick="searchDrug(prescription_compdetail_form,'D', drug_name<%=i+1%>,<%=i+1%>)" disabled>
						</td>
						<td class="QRYEVENSMALL"  width="5%">
							<b><label style="font-size:7pt" class="label" id="strength<%=i+1%>">&nbsp;<%=strength_value%>&nbsp;&nbsp;<%=strength_uom%></label></b>
						</td>
						<td class="QRYEVENSMALL"  width="10%">
							<b><label style="font-size:7pt" class="label" id="form<%=i+1%>">&nbsp;<%=form_desc%></label></b>
						</td>
						<td class="QRYEVENSMALL"  width="20%">
							<input type="text" name="absol_qty<%=i+1%>" id="absol_qty<%=i+1%>" value="<%=order_qty%>"  size="6" maxlength="6" onblur="CheckNum(this);extdosechk();"  onKeyPress="return allowValidNumber(this,event,6,0);" class="number">&nbsp;
							<b><label style="font-size:7pt" class="label" id="qty<%=i+1%>">&nbsp;<%=order_uom %></label></b>
						</td>
						<td class="QRYEVENSMALL" width="6%" >
							<A  id="remarks_<%=i+1%>" HREF onMouseOver="changeCursor(this);" onClick="callOrderAmend('<%=i+1%>');"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></A>
						</td>
						<td class="QRYEVENSMALL" width="18%">
							<input style="visibility:<%=over_ride_flag%>" type="button" class="button" width="8%" value="Override" id="dosage_limit<%=i+1%>" onclick="showOverrideReason('<%=order_id%>','<%=(i+1)%>','<%=drug_db_interface_yn%>','<%=drug_db_duptherapy_flag%>','<%=drug_db_allergy_flag%>','<%=allergy_yn%>','<%=currentrx_yn%>','<%=limit_ind%>')" > 
							<input style="visibility:<%=over_ride_flag%>" type="checkbox" width="2%" id="chk_ovr<%=(i+1)%>" onclick="default_override_rsn('<%=i+1%>')" > 
							<A title="TDM Result" style="<%=display_tdm%>" id="tdmRsltAmnd_<%=i+1%>" HREF onMouseOver="changeCursor(this);" onClick="viewReasonforRequest(tdmOrderIdAmnd<%=i+1%>.value)"> <fmt:message key="ePH.TDM.label" bundle="${ph_labels}"/></A>
						</td>

						<input type="hidden" name="ALLERGY_DESC<%=i+1%>" id="ALLERGY_DESC<%=i+1%>" value="">
						<input type="hidden" name="EXCEED_DOSE_DESC<%=i+1%>" id="EXCEED_DOSE_DESC<%=i+1%>" value="">
						<input type="hidden" name="DUP_DRUG_DESC<%=i+1%>" id="DUP_DRUG_DESC<%=i+1%>" value="<%=duplicate_drug_override_reason%>">		
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
								}

								if(!dosage_limit_override_reason.equals("")) {
									ext_drugData.put("DOSE_REMARKS",dosage_limit_override_reason);
									ext_drugData.put("DOSE_OVERRIDE","Y");
								}

								if(!duplicate_drug_override_reason.equals("")) {
									ext_drugData.put("CURRENTRX_REMARKS",duplicate_drug_override_reason);
									ext_drugData.put("CURRENTRX_OVERRIDE","Y");
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
							  <td NOWRAP width="12" class="label" id="ADR_<%=t%>" style="visibility:hidden" >
									<img style="visibility:hidden" id="ADR_img_<%=t%>" src='../../ePH/images/ADR.gif'   title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>'></img>
								</td>	
								<td NOWRAP width="12" class="SHIFTTOTAL" id="external_<%=t%>" style="visibility:hidden" >
									<img style="visibility:hidden" id="external_img<%=t%>" src='../../ePH/images/exceed1.gif' ></img>
								</td>
								<td NOWRAP width="12" class="ALLERGY" id="allergy_<%=t%>" style="visibility:hidden">
									<img style="visibility:hidden" id="allergy_img<%=t%>" src='../../ePH/images/exceed1.gif' ></img>
								</td>
								<td NOWRAP width="12" class="DOSELIMIT" id="dosage_<%=t%>" style="visibility:hidden">
									<img style="visibility:hidden" id="dosage_img<%=t%>" src='../../ePH/images/exceed1.gif' ></img>
								</td>
								<td NOWRAP width="12" class="CURRENTRX" id="currentrx_<%=t%>" style="visibility:hidden">
									<img style="visibility:hidden" id="currentrx_img<%=t%>" src='../../ePH/images/exceed1.gif' ></img>
								</td>
							</table>
						</td>
						<td class="QRYEVENSMALL" width="34%">&nbsp;
							<input type="text" name="drug_name<%=t%>" id="drug_name<%=t%>" size="42"  maxlength="42" value="" disabled onblur="deleteDrug(this,<%=t%>)" ><input type="button" name="drug_search<%=t%>" id="drug_search<%=t%>" value="?" class="button"  disabled  onClick="searchDrug(prescription_compdetail_form,'D', drug_name<%=t%>,<%=t%>)"></td>
						<td class="QRYEVENSMALL"  width="5%">
							<b><label style="font-size:7pt" class="label" id="strength<%=t%>">&nbsp;</label></b>
						</td>
						<td class="QRYEVENSMALL"  width="10%">
							<b><label style="font-size:7pt" class="label" id="form<%=t%>">&nbsp;</label></b>
						</td>
						<td class="QRYEVENSMALL"  width="16%">
							<input type="text" name="absol_qty<%=t%>" id="absol_qty<%=t%>" value="" disabled size="6" maxlength="6" onblur="CheckNum(this);extdosechk();" onKeyPress="return allowValidNumber(this,event,6,0);" class="number">&nbsp;
							<b><label style="font-size:7pt" class="label" id="qty<%=t%>">&nbsp;</label></b>
						</td>
						<td class="QRYEVENSMALL"  width="8%" >
							<A style="visibility:hidden" id="remarks_<%=t%>" HREF onMouseOver="changeCursor(this);" onClick="getRemarks('<%=t%>')"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></A>
						</td>
						<td class="QRYEVENSMALL" width="14%">
							<input style="visibility:hidden" type="button" class="button" width="8%" value="Override" id="dosage_limit<%=t%>" onclick="overRideRemarks(drug_code<%=t%>.value,'<%=t%>')">&nbsp;<input disabled style="visibility:hidden" type="checkbox" width="2%" id="chk_ovr<%=t%>" onclick=""> 
						</td>
						<input type="hidden" name="srl_no<%=t%>" id="srl_no<%=t%>" value="<%=srl_no%>">
						<input type="hidden" name="ALLERGY_DESC<%=t%>" id="ALLERGY_DESC<%=t%>" value="">
						<input type="hidden" name="EXCEED_DOSE_DESC<%=t%>" id="EXCEED_DOSE_DESC<%=t%>" value="">
						<input type="hidden" name="DUP_DRUG_DESC<%=t%>" id="DUP_DRUG_DESC<%=t%>" value="">	
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
					<label  class="label" id="qty_uom"><%=qty_unit%></label>
				</td> 
				<td class="label" width="5%">
					<fmt:message key="Common.Frequency.label" bundle="${common_labels}"/>
				</td>
				<td class="label" width="5%">
					<select name="frequency" id="frequency" <%=disableflag%> onChange="ValidateDosage(); setSchedule();extdosechk();">
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
				<td class="label" width='10%' id="dosage_label" nowrap>&nbsp;</td>
				<td class="label" width="25%"><fmt:message key="ePH.Admixture.label" bundle="${ph_labels}"/>
					<input type="checkbox" name="admixture" id="admixture"  value="Y" CHECKED DISABLED>&nbsp;&nbsp;
					<fmt:message key="ePH.BuildMAR.label" bundle="${ph_labels}"/>
					<input type="checkbox" name="buildMAR_yn" id="buildMAR_yn"  value="<%=buildMAR_yn%>" disabled <%=buildMAR_ynCheck%> >				
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
				<td class="label" width="10%">
					<fmt:message key="Common.StartDate.label" bundle="${common_labels}"/>
				</td>
				<td class="label" colspan="2" width="10%">
					<input type="text" name="start_date" id="start_date" size="14"  maxlength="16" onBlur="populateEndDate();" value="<%=start_date%>" <%=disableflag%> >
					<IMG SRC="../../eCommon/images/CommonCalendar.gif"  <%=disableflag%>  id=Calendar  onclick="if(document.prescription_compdetail_form.start_date.disabled){return false;};showCalendar('start_date',null,'hh:mm');document.prescription_compdetail_form.start_date.focus();return false;" >
				</td>
				<td class="label" colspan="2" width="10%">
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
		patient_id				= request.getParameter("patient_id") ;
		encounter_id			= request.getParameter("encounter_id") ;
		priority				= request.getParameter("priority")==null?"":request.getParameter("priority") ;
		start_time				= request.getParameter("start_date") ;
		bsa						= request.getParameter("bsa")==null?"":request.getParameter("bsa") ;	
		String MAR_app_yn				=  request.getParameter("MAR_app_yn")==null?"N":request.getParameter("MAR_app_yn");
		if(MAR_app_yn.equals("Y")){
			buildMAR_ynCheck="checked";
			buildMAR_yn = "Y";
		}
		else{
			buildMAR_ynCheck="";
			buildMAR_yn = "N";
		}
		if(patient_class.equals("IP") && MAR_app_yn.equals("Y"))
			buildMAR_ynCheck = buildMAR_ynCheck+" disabled";
%>
		<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
			<form name="prescription_compdetail_form1" id="prescription_compdetail_form1" >
			<!-- Prescription Writer Table starts-->				
				<table cellpadding=0 cellspacing=0 width="100%" align="center" border="0">
					<tr>
						<td class="COLUMNHEADERCENTER" colspan="12" >
							<fmt:message key="ePH.AdminDetails.label" bundle="${ph_labels}"/>
						</td>
					</tr>
						<tr height="2"><td colspan="12"></td></tr>
					<tr>
						<td class="label" colspan="2" width="40%" nowrap>
							<fmt:message key="Common.Dosage.label" bundle="${common_labels}"/>&nbsp;
							<input type="text" name="dosage" id="dosage" value=""  onBlur="parent.f_compound_detail.document.prescription_compdetail_form.dosage.value=this.value;CheckNum(this);chkBlank();setSchedule(this.value);autoschedule1();" onKeyPress="return allowValidNumber(this,event,3,0);" size="2"  maxlength="3" style="text-align:right">&nbsp;
							<select name="uom" id="uom" onChange="">
								<option value="">-- <fmt:message key="ePH.Select.label" bundle="${ph_labels}"/> --</option>
							</select>
						</td>
						<td class="label" width="5%">
							<fmt:message key="Common.Frequency.label" bundle="${common_labels}"/>
						</td>
						<td class="label" width="5%">
							<select name="frequency" id="frequency" onChange="parent.f_compound_detail.document.prescription_compdetail_form.frequency.value=this.value; ValidateDosage();setSchedule();extdosechk();">
								<option value="">&nbsp;&nbsp;&nbsp; --- <fmt:message key="ePH.Select.label" bundle="${ph_labels}"/> ---&nbsp;&nbsp;&nbsp; </option>
<% 
								for(int i=0; i<frequency.size(); i+=2) {
%>
									<option value="<%=(String)frequency.get(i)%>"><%=(String)frequency.get(i+1)%></option>
<%
								}
%>
							</select>
						</td>
						<td class="label" width="5%">
							<input type="button" name="btn_schedule" id="btn_schedule" value="Schedule" disabled class="button" onClick="DisplaySchedule()">
						</td>
						<td class="label" width='10%' id="dosage_label" nowrap>&nbsp;</td>
						<td class="label" width="20%">
							<fmt:message key="ePH.Admixture.label" bundle="${ph_labels}"/>
							<input type="checkbox" name="admixture" id="admixture"  value="Y" CHECKED DISABLED>&nbsp;&nbsp;
							<fmt:message key="ePH.BuildMAR.label" bundle="${ph_labels}"/>
							<input type="checkbox" name="buildMAR_yn" id="buildMAR_yn"  value="<%=buildMAR_yn%>" <%=buildMAR_ynCheck%> onclick='assignCheckValue(this);'>				
						</td>
					</tr>
					<tr height="4">
						<td colspan="12"></td>
					</tr>
					<tr>
						<td class="label" width="10%">
							<fmt:message key="Common.duration.label" bundle="${common_labels}"/>
						</td>
						<td width="15%" nowrap>
							<input type="text" size="1" maxlength="11" name="durn_value" id="durn_value" class="NUMBER"  value=""  onBlur="parent.f_compound_detail.document.prescription_compdetail_form.durn_value.value=this.value;validateDuration(this);CheckPositiveNumber(this);populateEndDate();extdosechk();" onKeyPress="return(ChkNumberInput(this,event,'0'))" >&nbsp;
							<label id="durn_desc" class="label"></label>
						</td>
						<td class="label" width="10%">
							<fmt:message key="Common.StartDate.label" bundle="${common_labels}"/>
						</td>
						<td class="label" colspan="2" width="10%">
							<input type="text" name="start_date" id="start_date" size="14"  maxlength="16" onBlur="parent.f_compound_detail.document.prescription_compdetail_form.start_date.value=this.value;populateEndDate();" value="<%=start_time%>" >
							<IMG SRC="../../eCommon/images/CommonCalendar.gif"   id=Calendar  onclick="if(document.prescription_compdetail_form1.start_date.disabled){return false;};showCalendar('start_date',null,'hh:mm');document.prescription_compdetail_form1.start_date.focus();return false;" >
						</td>
						<td class="label" colspan="2" width="10%">
							<fmt:message key="Common.enddate.label" bundle="${common_labels}"/>&nbsp;&nbsp;
							<input type="text" name="end_date" id="end_date" size="14"  maxlength="13" value="" disabled>
						</td>
					</tr>
					<tr height="4"><td colspan="12"></td></tr>
				</table>

				<br>
<%
			}
%>
<!-- Prescription Writer Table ends-->	
		<label id="tool_tip" style="visibility:hidden"></label>
			<div name="tooltiplayer" id="tooltiplayer" style="position:absolute; width:20%; visibility:hidden;">
				<table id="tooltiptable" cellpadding=0 cellspacing=0 border="0" width="auto" height="100%"  align="center">
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

		populateDurationDesc(parent.f_compound_detail.document.prescription_compdetail_form.frequency)
	</script>
</html>

