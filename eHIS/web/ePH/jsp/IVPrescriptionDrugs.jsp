<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
05/09/2019      IN070451		   B Haribabu   06/09/2019     Manickam                 ML-MMOH-CRF-1408
30/06/2020      IN:072715                  Haribabu            30/06/2020     Manickavasagam J     MMS-DM-CRF-0165
06/01/2021		 TFS-7345          Prabha      06/01/2020	  Manickavasagam J         MMS-DM-CRF-0177
25-05-2022               AAKH-CRF-0140      PRATHYUSHA
--------------------------------------------------------------------------------------------------------------
*/    
%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eOR.*,eOR.Common.* ,webbeans.eCommon.*, eCommon.Common.*,java.sql.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<!-- <%@include file="../../eCommon/jsp/Common.jsp" %> -->
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%> 
<HTML>
	<HEAD>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		Connection con			= null;    //added for aakh-crf-0140
				con						   = ConnectionManager.getConnection(request);//added for aakh-crf-0140
	   	
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/IVPrescriptionWithAdditives.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
		String patient_id		= request.getParameter("patient_id");
		String encounter_id		= request.getParameter("encounter_id");
		String adr_count	    = request.getParameter("adr_count")==null?"0":request.getParameter("adr_count");
		String order_id			= request.getParameter("order_id")==null?"":request.getParameter("order_id");
		String order_set_code   = request.getParameter("order_set_code")==null?"":request.getParameter("order_set_code");
		String weight           = request.getParameter("weight")==null?"":request.getParameter("weight");
		String bsa              = request.getParameter("bsa")==null?"":request.getParameter("bsa");
		// added for ml-mmoh-crf-0863 start 
		String iv_prep_yn		= request.getParameter("iv_prep_yn") == null ? "":request.getParameter("iv_prep_yn");
		String take_home_medication		= request.getParameter("take_home_medication") == null ? "":request.getParameter("take_home_medication");
		String priority		= request.getParameter("priority") == null ? "":request.getParameter("priority");
		boolean drug_abuse_app=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DRUG_ABUSE_APPL");//added for AAKH-CRF-0140
		System.out.println("take_home_medication in IVprescriptiondrugs.jsp"+take_home_medication);
		System.out.println("priority in  IVprescriptiondrugs.jsp"+priority);
		System.out.println("iv_prep_yn in  IVprescriptiondrugs.jsp "+iv_prep_yn);
		// added for ml-mmoh-crf-0863 end
		if(weight.equals(""))
			weight = "0";
		if(bsa.equals(""))
			bsa = "0";
		ArrayList orderSetCodes	= new ArrayList();
		String iv_prep_default  = request.getParameter("iv_prep_default")==null?"":request.getParameter("iv_prep_default");
		StringBuffer ordsetDrugCodes = new StringBuffer();
		String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
		String bean_name		= "ePH.IVPrescriptionBean";
		IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject(bean_id,bean_name,request) ;
		bean.setPatId(patient_id);
		bean.setEncId(encounter_id);

		if(iv_prep_default.equals("1") || iv_prep_default.equals("2")){
			if(!order_set_code.equals("")) 
				orderSetCodes = bean.getOrdersetCodes(order_set_code);

			if(orderSetCodes != null && orderSetCodes.size() > 1) {
				for(int i=1; i<orderSetCodes.size();i++){
					ordsetDrugCodes.append((String)orderSetCodes.get(i));
					ordsetDrugCodes.append(",");
				}
			}
			bean.setDrugCodes(ordsetDrugCodes.toString());
		}
		String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
		String facility_id					= (String)session.getValue("facility_id");
		String param_bean_id				= "@DrugInterfaceControlBean";
		String param_bean_name				= "ePH.DrugInterfaceControlBean";
		DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
		/* Commented for SRR20056-SCF-7354
		String drug_db_interface_yn			=	param_bean.getDrugDBInterface_yn(facility_id);    
		String drug_db_product_id			=	param_bean.getDrugDBProductID(facility_id);
		String drug_db_dosecheck_yn			=	param_bean.getDrugDBDosecheck_yn(facility_id);    
		String drug_db_duptherapy_yn		=	param_bean.getDrugDBDuptherapy_yn(facility_id);
		String drug_db_interact_check_yn	=	param_bean.getDrugDBInteract_check_yn(facility_id);  
		String drug_db_contraind_check_yn	=	param_bean.getDrugDBContraind_check_yn(facility_id);
		String drug_db_allergy_check_yn		=	param_bean.getDrugDBAllergy_check_yn(facility_id);
		*/
		String drug_db_interface_yn			= "N";//Added for SRR20056-SCF-7354
		String drug_db_product_id			= "";
		String drug_db_dosecheck_yn			= "N";
		String drug_db_duptherapy_yn		= "N";
		String drug_db_interact_check_yn	= "N";
		String drug_db_contraind_check_yn	= "N";
		String drug_db_allergy_check_yn		= "N";
		String abuse_exists="";//added for aakh-crf-0140
		String abuse_action="";//added for aakh-crf-0140
		String abuse_override="";//added for aakh-crf-0140
				String abuse_override_remarks="";
String drug_abuse_gif="";//added for aakh-crf-0140
				String abuse_restrict_tran="N";//added for AAKH-CRF-0140
		String[] sDrugDBAllChecks = param_bean.drugDBALLChecksYN(facility_id);
		if(sDrugDBAllChecks != null && sDrugDBAllChecks.length>6){
			drug_db_interface_yn			=	sDrugDBAllChecks[0];    
			drug_db_product_id			=	sDrugDBAllChecks[1];    
			drug_db_dosecheck_yn			=	sDrugDBAllChecks[2];    
			drug_db_duptherapy_yn		=	sDrugDBAllChecks[3];    
			drug_db_interact_check_yn	=	sDrugDBAllChecks[4];      
			drug_db_contraind_check_yn	=	sDrugDBAllChecks[5];    
			drug_db_allergy_check_yn		=	sDrugDBAllChecks[6];    
		}//SRR20056-SCF-7354
		param_bean.clear();		
		bean.setExternalDrugDataBaseInterface_yn(drug_db_interface_yn);	
		String or_bean_name			= "eOR.OrderEntryBean";
		String or_bean_id			= "@orderentrybean"+patient_id+encounter_id;
		OrderEntryBean orbean		= (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request);
		ArrayList drugList		= null;
		drugList		        = bean.getDrugDetails();
		int drug_adr_count      = 0;
%>

	</HEAD>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
		<FORM name="formIVPrescriptionDrugList" id="formIVPrescriptionDrugList">
			<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="1">
				<tr>
					<td class="COLUMNHEADER" colspan="6"><font style="font-size:9"><fmt:message key="ePH.Additive(s).label" bundle="${ph_labels}"/>/<fmt:message key="ePH.Drugs.label" bundle="${ph_labels}"/></font></td>
				</tr>
<%
				if ((drugList != null)&&(drugList.size() > 0)) {
					String tmp_srl_no				=	null;
					String srl_no					=	null;
					String drug_desc				=	null;
					String drug_code				=   null;
					String drug_class				=   null;
					String generic_id				=	null;
					String generic_name				=	null;
					String allergy_yn				=	null;
					String qty_value				=	null;
					String or_qty_desc				=	null;
					String limit_ind				=	null;
					String mono_graph				=	null;
					String daily_dose				=	null;
					String unit_dose				=	null;
					String min_daily_dose			=	null;
					String min_unit_dose			=	null;
					String current_rx				=	null;
					String count_rx				    =	null;
					String allergy_override			=	null;
					String dose_override			=	null;
					String currentrx_override		=	null;
					String sch_over_yn				=	null;
					String ext_prod_id				=	null;						
					String strength_per_value		=   "0";
					String strength_per_pres		=	"0";
					String dosage_type				=	"";
					String tot_volume				=	"0";
					String dosage_unit				=	"";
					String dosage_std               =   "";
					//String abuse_override="";//added for aakh-crf-0140
					//String abuse_override_remarks="";
					String perform_external_database_checks_yn	=	"";	
					String external_database_overrided_reason	=	"";	
					String external_database_overrided_yn	    =	"";	
					String loading_ext_prod_id					=	"";
					String drug_db_interact_check_flag			=  "N";
					String drug_db_duptherapy_flag				=  "N";
					String drug_db_allergy_check_flag			=  "N";
					String drug_db_contraind_check_flag			=  "N";
					String drug_db_dosage_check_flag			=  "N";
					String external_dosage_override_reason		=   "";	
					String external_duplicate_override_reason	=   "";
					String external_interaction_override_reason	=   "";
					String external_contra_override_reason		=   ""; 
					String external_alergy_override_reason		=   ""; 
					String dose_unit_desc ="";//Added for IN:070451
					String dose_unit_desc1="";//Added for IN:070451
					String ext_dosage_reason		=   ""; //Added new variable on 18/oct/2010
					String startdate="", enddate="";// Added for ML-BRU-SCF-0811 [IN:039394]
					String pract_name							= (String)orbean.getPractitionerName();
					String extVisble							= "visible";

					//Added for MMS-DM-CRF-0177
					String new_generic_name = ""; 
					String pre_alloc_appl = ""; 
					String drug_search = "";
					pre_alloc_appl = bean.getPreAllocApplYN();
					//Added for MMS-DM-CRF-0177
					
					String ex_bean_id				= "@ExternalProductLinkBean";
					String ex_bean_name				= "ePH.ExternalProductLinkBean";
					ExternalProductLinkBean beanex  = (ExternalProductLinkBean)getBeanObject(ex_bean_id,ex_bean_name,request);

					String classValue				= "SELECTEDRUGS";
					ArrayList exProd				= new ArrayList();
					ArrayList drugDesc				= new ArrayList();
					HashMap drug_Interactions				= null;
					String  dose_uom = "", frequency="", repeat_value="", interval_value="", dosage="",  strength_per_value_pres_uom="", strength_per_pres_uom="", dosage_by="" ;
					HashMap details = null;
					ArrayList dosageCheckParams = null;
					String dup_drug_det					= "";
					String route_code	= "", qty_desc_code= "", repeat_durn_type	= "", freq_nature	= "", freq_nature_pas = "I";// Added in January 2014 for CIMS dosage check 
					HashMap drugDetails = null;
					for(int k=0;k<drugList.size();k++){
						HashMap drug_detail				=   (HashMap) drugList.get(k);
						String ext_srl_no				=   (String) drug_detail.get("SRL_NO");
						if(!exProd.contains((String)drug_detail.get("EXTERNAL_PRODUCT_ID"))){
							drugDesc.add((String)drug_detail.get("DRUG_DESC"));
							if((String) drug_detail.get("EXTERNAL_PRODUCT_ID")!=null && !((String) drug_detail.get("EXTERNAL_PRODUCT_ID")).equals("")){
							       exProd.add((String)drug_detail.get("EXTERNAL_PRODUCT_ID"));
							}
						}
					}
					/*if(exProd.size()>0)
						beanex.storeDrugIds(patient_id,"",exProd,drugDesc);//Store Drug ids*/

					for(int i=0;i<drugList.size();i++) {
						//if(mode.equals("amend")){i = i+1;}
						drugDetails = (HashMap)drugList.get(i);
						if ( (drugDetails!=null) && (drugDetails.size() > 0) ){
							extVisble	= "visible";
							srl_no					= (String)drugDetails.get("SRL_NO");
							drug_desc				= (String)drugDetails.get("DRUG_DESC")==null?(String)drugDetails.get("SHORT_DESC"):(String)drugDetails.get("DRUG_DESC");
							drug_code				= (String)drugDetails.get("DRUG_CODE");
							drug_class				= (String)drugDetails.get("DRUG_CLASS")==null?"":(String)drugDetails.get("DRUG_CLASS");
							generic_id				= (String)drugDetails.get("GENERIC_ID");
							generic_name			= (String)drugDetails.get("GENERIC_NAME");
							allergy_yn				= (String)drugDetails.get("ALLERGY_YN");
							qty_value				= (String)drugDetails.get("QTY_VALUE");
							or_qty_desc				= (String)drugDetails.get("OR_QTY_DESC");
							limit_ind				= (String)drugDetails.get("LIMIT_IND");
							mono_graph				= (String)drugDetails.get("MONO_GRAPH");
							daily_dose				= (String)drugDetails.get("DAILY_DOSE");
							unit_dose				= (String)drugDetails.get("UNIT_DOSE");
							min_daily_dose			= (String)drugDetails.get("MIN_DAILY_DOSE");
							min_unit_dose			= (String)drugDetails.get("MIN_UNIT_DOSE");
							dosage_std				= (String)drugDetails.get("DOSAGE_STD");
							//added for aakh-crf-0140 start
							if(drug_abuse_app){
								
							
							abuse_exists=(String)drugDetails.get("ABUSE_EXISTS")==null?"":(String)drugDetails.get("ABUSE_EXISTS");
							abuse_action=(String)drugDetails.get("ABUSE_ACTION")==null?"":(String)drugDetails.get("ABUSE_ACTION");
							abuse_restrict_tran=(String)drugDetails.get("ABUSE_RESTRIC_TRN")==null?"":(String)drugDetails.get("ABUSE_RESTRIC_TRN");
							abuse_override=(String)drugDetails.get("ABUSE_OVERRIDE")==null?"N":(String)drugDetails.get("ABUSE_OVERRIDE");
							abuse_override_remarks=(String)drugDetails.get("abuse_override_remarks")==null?"":(String)drugDetails.get("abuse_override_remarks");
							
							System.out.println("248 abuse_override_remarks"+abuse_override_remarks);
							}
							else{
								abuse_exists="N";
								abuse_action="U";
								abuse_restrict_tran="N";
								abuse_override_remarks="";
								abuse_override="N";
							}
							//added for aakh-crf-0140end
							//Added for IN:070451 start
							String max_daily_ceeling_dose			= (String)drugDetails.get("MAX_DAILY_CEELING_DOSE");
							String min_daily_ceeling_dose			= (String)drugDetails.get("MIN_DAILY_CEELING_DOSE");
							String max_unit_ceeling_dose			= (String)drugDetails.get("MAX_UNIT_CEELING_DOSE");
							String min_unit_ceeling_dose			= (String)drugDetails.get("MIN_UNIT_CEELING_DOSE");
							dosage_unit			=	(String)drugDetails.get("DOSAGE_UNIT");
							if(!dosage_unit.equals("")){ // Added for ML-MMOH-SCF-0864 - Start
								   dose_unit_desc      = bean.getUomDisplay((String)session.getValue("facility_id"),dosage_unit);
								   dose_unit_desc1= dose_unit_desc;
									System.out.println("dose_unit_desc--11>"+dose_unit_desc);
									if(dose_unit_desc==null || dose_unit_desc=="" ) {
									  dose_unit_desc = bean.getUomDisplay((String)session.getValue("facility_id"),(dosage_unit.split("/")[0]));
									  dose_unit_desc1= dose_unit_desc;
								     if(dosage_unit.split("/").length>=2)
									   dose_unit_desc =dose_unit_desc+"/"+(dosage_unit.split("/")[1]);
									
									} 

								}
								//Added for IN:070451 end
							current_rx				= (String)drugDetails.get("CURRENT_RX");
							count_rx				= (String)drugDetails.get("COUNT_RX");
							allergy_override		= (String)drugDetails.get("ALLERGY_OVERRIDE");
							dose_override			= (String)drugDetails.get("DOSE_OVERRIDE");
							currentrx_override		= (String)drugDetails.get("CURRENTRX_OVERRIDE");
							sch_over_yn				= (String)drugDetails.get("SCH_OVER_YN");
							ext_prod_id			    = (String)drugDetails.get("EXTERNAL_PRODUCT_ID")==null?"":(String)drugDetails.get("EXTERNAL_PRODUCT_ID");
							//dosage_unit			    = (String)drugDetails.get("DOSAGE_UNIT")//Commentted for IN:070451
							strength_per_value		= (String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM")==null?"":(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");
							strength_per_pres		= (String)drugDetails.get("STRENGTH_PER_PRES_UOM")==null?"":(String)drugDetails.get("STRENGTH_PER_PRES_UOM");
							dosage_type			    = (String)drugDetails.get("DOSAGE_TYPE");
							perform_external_database_checks_yn = drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS")==null?"":(String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS");	
	
							
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
							
							loading_ext_prod_id				    = ext_prod_id;
							drug_db_dosage_check_flag           = (String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN");
							external_dosage_override_reason		= (String) drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON")==null?"":(String) drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON");	
							external_duplicate_override_reason	= (String) drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON")==null?"":(String) drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON");
							external_interaction_override_reason= (String) drugDetails.get("EXTERNAL_INTERACTION_OVERRIDE_REASON")==null?"":(String) drugDetails.get("EXTERNAL_INTERACTION_OVERRIDE_REASON");
							external_contra_override_reason		= (String) drugDetails.get("EXTERNAL_CONTRA_OVERRIDE_REASON")==null?"":(String) drugDetails.get("EXTERNAL_CONTRA_OVERRIDE_REASON");
							external_alergy_override_reason		= (String) drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON")==null?"":(String) drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON");

							if(external_dosage_override_reason.equals("")){
								external_dosage_override_reason = (String)(((HashMap)bean.getAmendDoseRemarks()).get("1")) == null?"":(String)(((HashMap)bean.getAmendDoseRemarks()).get("1"));
								drugDetails.put("EXTERNAL_DOSAGE_OVERRIDE_REASON",external_dosage_override_reason);
							}

							if(mode.equals("amend") && count_rx != null && Integer.parseInt(count_rx) <=1){
								current_rx = "N";
								drugDetails.put("CURRENT_RX",current_rx);
							}

							if(dosage_type!=null && dosage_type.equals("S")){
								if(!(strength_per_pres.equals(""))&& !(tot_volume.equals("")) && !(strength_per_value.equals(""))){
									if(strength_per_pres.equals(qty_value)){
										tot_volume = (Float.parseFloat(tot_volume) + Float.parseFloat(strength_per_value))+"";
									}
									else if(!(strength_per_pres.equals("")) && !(qty_value.equals("")) && !strength_per_pres.equals(qty_value)){
										tot_volume = (Math.ceil(Float.parseFloat(tot_volume) + ( (Float.parseFloat(strength_per_value) / Float.parseFloat(strength_per_pres)) * Float.parseFloat(qty_value) )))+"";
									}
								}
							}
							if( drugDetails.get("AMEND_YN")!=null && ((String)drugDetails.get("AMEND_YN")).equals("Y") ) {							
								classValue="AMENDEDDRUGS";
							}
							else{
								classValue="SELECTEDRUGS";
								if(tmp_srl_no==null) {
									tmp_srl_no	=	srl_no;
								}
							} 
							//code for drug interaction check
							drug_Interactions				= null;
							dup_drug_det					= "";
							if(perform_external_database_checks_yn.equals("Y") && !(ext_prod_id.equals("")) ){
								if(drug_db_duptherapy_yn.equals("Y")|| drug_db_interact_check_yn.equals("Y")||drug_db_contraind_check_yn.equals("Y")||drug_db_allergy_check_yn.equals("Y") || drug_db_dosecheck_yn.equals("Y") ){
									dosageCheckParams = null;
									if(mode.equals("amend") && drug_db_dosecheck_yn.equals("Y")){
										dosageCheckParams = new ArrayList();
										details = (HashMap)bean.getAllExistingIVOrders().get(0);
										dosage					   = (String)drugDetails.get("STRENGTH_VALUE");
										strength_per_value_pres_uom = (String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");
										strength_per_pres_uom       = (String)drugDetails.get("STRENGTH_PER_PRES_UOM");
										if(!(dosage.equals(""))){
											if(!(strength_per_value_pres_uom.equals(""))){
											   dosage					   = (Float.parseFloat(dosage)*Float.parseFloat(strength_per_value_pres_uom))+"";
											}
											if(!(strength_per_pres_uom.equals(""))){
											   dosage					   = (float)(Float.parseFloat(dosage)/Float.parseFloat(strength_per_pres_uom))+"";
											}
										}
										dosage_by				   = (String)drugDetails.get("DOSAGE_TYPE");	
										if(dosage_by.equals(""))
											dosage_by = (String)bean.getDosage_type();

//infuse over wil be same as duration in case of mfr coz flow duration is sum of the infuse over value. 
										if(details.get("INFUSE_OVER") == null || details.get("INFUSE_OVER").equals(""))
											details.put("INFUSE_OVER",(String)details.get("DURN_VALUE"));
		
										int freq	= 1;
										if( !( ((String)details.get("DURN_VALUE")).equals("") ) && !( ((String)details.get("INFUSE_OVER")).equals("") ) ){
											freq = (int)Math.ceil(Float.parseFloat((String)details.get("DURN_VALUE"))/Float.parseFloat((String)details.get("INFUSE_OVER")));
										}
										//freq = Integer.parseInt(freq)+"";
										 dose_uom = "";
										if(dosage_by.equals("S"))
											dose_uom		    =	(String)drugDetails.get("STRENGTH_UOM");         
										else if(dosage_by.equals("Q"))
											dose_uom		    =	(String)drugDetails.get("PRES_BASE_UOM");	
										repeat_value     =   (String)drugDetails.get("REPEAT_VALUE")==null?"":(String)drugDetails.get("REPEAT_VALUE");
										interval_value	=	(String)drugDetails.get("INTERVAL_VALUE")==null?"":(String)drugDetails.get("INTERVAL_VALUE");		
										route_code	= (String)drugDetails.get("ROUTE_CODE")==null?"":(String) drugDetails.get( "ROUTE_CODE" );// Added in January 2014 for CIMS dosage check -start
										qty_desc_code= (String)drugDetails.get("QTY_DESC_CODE")==null?"":(String) drugDetails.get( "QTY_DESC_CODE" );
										repeat_durn_type	= drugDetails.get("REPEAT_DURN_TYPE")==null?"":(String) drugDetails.get( "REPEAT_DURN_TYPE" );
										freq_nature	= drugDetails.get( "FREQ_NATURE" )==null?"":(String) drugDetails.get( "FREQ_NATURE" );
										freq_nature_pas = "I";	  //Added in January 2014, CIMS Dosage Check -end
										
										frequency	    =   "1";
										if(repeat_value != "" && interval_value != "")
											frequency = (int)Math.ceil( Integer.parseInt(repeat_value) / Integer.parseInt(interval_value))+"";
										dosageCheckParams.add(patient_id);
										dosageCheckParams.add(loading_ext_prod_id);
										dosageCheckParams.add(weight);
										dosageCheckParams.add(bsa);
										dosageCheckParams.add(dosage);
										if(beanex!=null && (beanex.getProdID()).equals("CIMS"))  // Added in January 2014 - DOSAGE Checks Added
											dosageCheckParams.add(qty_desc_code);	// Added in January 2014 - DOSAGE Checks Added
										else
											dosageCheckParams.add(dose_uom);
										dosageCheckParams.add(freq+"");
										dosageCheckParams.add("1");
										dosageCheckParams.add(route_code);	 // Added in January 2014 for CIMS-Dosage Checks -start
										dosageCheckParams.add(repeat_durn_type);	 
										 if(freq_nature!=null && !freq_nature.equals(""))
											 freq_nature_pas =  freq_nature;
										 dosageCheckParams.add(freq_nature_pas);	
										 dosageCheckParams.add(interval_value);	 // Added in January 2014 for CIMS-Dosage Checks -end
									}
									HashMap tempDetails= null;
									HashMap drugDBCheckResult= null;
									ArrayList reqChecks = new ArrayList();
									if(mode.equals("amend") && drug_db_dosecheck_yn.equals("Y"))
										reqChecks.add("Y"); //Dosage Check 
									else
										reqChecks.add("N"); //Dosage Check 

									reqChecks.add(drug_db_duptherapy_yn); //Duplicate Check
									reqChecks.add(drug_db_interact_check_yn); //DrugInteraction
									reqChecks.add(drug_db_contraind_check_yn); //Contra Indication
									reqChecks.add(drug_db_allergy_check_yn); //AllergyCheck
									/*if(mode.equals("amend")){
										beanex.removeSelectedDrugonAmend(ext_prod_id);
									}*/
									startdate	= (String)drugDetails.get("START_DATE");// Added for ML-BRU-SCF-0811 [IN:039394]
									enddate		= (String)drugDetails.get("END_DATE");// Added for ML-BRU-SCF-0811 [IN:039394]
									drugDBCheckResult = beanex.getExternalDBChecks( reqChecks, ext_prod_id, patient_id, "", exProd ,drugDesc, dosageCheckParams, "Y",startdate,enddate); //Parameters (AL)requiredchecks, ext_proID, PatienId, OrderID, (AL)ExtProdIDlist, (AL)DrugDescs (AL)DoseCheckParams, Y/N to store EXTID list in EXTbean 
									if(drugDBCheckResult!=null)
										beanex.setExternalDBCheckResult(ext_prod_id,srl_no,drugDBCheckResult);
									if(mode.equals("amend") && drug_db_dosecheck_yn.equals("Y")){
										drug_db_dosage_check_flag = "N";
										if(drugDBCheckResult != null && drugDBCheckResult.size() > 0){
											tempDetails = (HashMap)drugDBCheckResult.get("DOSECHECK");
											if(tempDetails != null && tempDetails.size() > 0){
												beanex.setDosageCheck(ext_prod_id, srl_no,tempDetails);
												drug_db_dosage_check_flag = "Y";
											}
										}
										if(drug_db_dosage_check_flag.equals("N")){
											tempDetails =beanex.getDosageCheck(ext_prod_id, srl_no);
											if(tempDetails != null && tempDetails.containsKey(ext_prod_id)){
												beanex.removeDosageCheck(ext_prod_id, srl_no);
											}
										}
										if(!external_dosage_override_reason.equals(""))
											drug_db_dosage_check_flag="Y";
									}
									if(drug_db_allergy_check_yn.equals("Y")){
									   if(beanex!=null && beanex.getProdID()!=null && (beanex.getProdID()).equals("CIMS")){ // for CIMS) //if block and else part added
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
									   dup_drug_det	= (String)drugDBCheckResult.get("DUPCHECK");
									   if(dup_drug_det!=null && !dup_drug_det.equals(""))
											drug_db_duptherapy_flag="Y";
									   else{
											drug_db_duptherapy_flag="N";
									   }
									}
									if(drug_db_contraind_check_yn.equals("Y")){
										if(beanex!=null && beanex.getProdID()!=null && (beanex.getProdID()).equals("CIMS")){ // for CIMS
											tempDetails = (HashMap)drugDBCheckResult.get("HEALTHINTRACHECK");	 /* Added in JUNE 2012 - New changes - Health Care Interaction */

				System.err.println("----------tempDetailList"+tempDetails);
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
								/*if(drug_db_interact_check_yn.equals("Y")){
										if(loading_ext_prod_id!=null && !loading_ext_prod_id.equals("")){
											beanex.getDDInteractions(loading_ext_prod_id);//Store interactions
											drug_Interactions		= beanex.getInteractions();//get Interactions
											if(drug_Interactions.size()>0){							
												drug_db_interact_check_flag="Y";
											}
										}
									}
									if(mode.equals("amend")){
										beanex.removeSelectedDrugonAmend(ext_prod_id);
									}
									if(drug_db_duptherapy_yn.equals("Y")){ 
										if(ext_prod_id!=null&& !ext_prod_id.equals("")){
											dup_drug_det			= beanex.isDuplicateTherapy(ext_prod_id);//get dupluicate theraphy result
											if(dup_drug_det!=null && (!dup_drug_det.equals(""))){
												drug_db_duptherapy_flag="Y";
											}
										}
									}

									if(drug_db_allergy_check_yn.equals("Y")){ 
										ArrayList ex_prod_ids =new ArrayList();
											ex_prod_ids.add(loading_ext_prod_id);
										if(ext_prod_id!=null&& !ext_prod_id.equals("") && ex_prod_ids!=null && !ex_prod_ids.equals("")){
											beanex.DrugAlergyCheck(ex_prod_ids,patient_id);//get allergy
											HashMap drug_alergies =(HashMap)beanex.getDrugAlergies();
											
											if(drug_alergies.containsKey(ext_prod_id)){
												drug_db_allergy_check_flag="Y";
											}	
										}
									}

									if(drug_db_contraind_check_yn.equals("Y")){
										if(loading_ext_prod_id!=null&& !loading_ext_prod_id.equals("")){
											ArrayList ex_prod_ids =new ArrayList();
											ex_prod_ids.add(loading_ext_prod_id);

											boolean flag = beanex.isContraDrugMedicalCondition(ex_prod_ids,patient_id);
											HashMap contra_indications =(HashMap)beanex.getContraIndications();
											if(contra_indications.containsKey(ext_prod_id)){
												// String  contra_indication_for_drug   =(String)contra_indications.get(ext_prod_id);
												drug_db_contraind_check_flag="Y";
											}					  
										}
									} 
									
									if(mode.equals("amend") && drug_db_dosecheck_yn.equals("Y")){
										HashMap details = (HashMap)bean.getAllExistingIVOrders().get(0);
										HashMap drugDosageResult	= new HashMap();
										ArrayList dosageCheckParams = new ArrayList();
										String dosage					   = (String)drugDetails.get("STRENGTH_VALUE");
										String strength_per_value_pres_uom = (String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");
										String strength_per_pres_uom       = (String)drugDetails.get("STRENGTH_PER_PRES_UOM");
										if(!(dosage.equals("")))
										{
											if(!(strength_per_value_pres_uom.equals("")))
											{
											   dosage					   = (Float.parseFloat(dosage)*Float.parseFloat(strength_per_value_pres_uom))+"";
											}
											if(!(strength_per_pres_uom.equals("")))
											{
											   dosage					   = (float)(Float.parseFloat(dosage)/Float.parseFloat(strength_per_pres_uom))+"";
											}
										}
										String dosage_by				   = (String)drugDetails.get("DOSAGE_TYPE");	
										if(dosage_by.equals(""))
											dosage_by = (String)bean.getDosage_type();

										//infuse over wil be same as duration in case of mfr coz flow duration is sum of the infuse over value. 
										if(details.get("INFUSE_OVER") == null || details.get("INFUSE_OVER").equals(""))
											details.put("INFUSE_OVER",(String)details.get("DURN_VALUE"));
		
										int freq	= 1;
										if( !( ((String)details.get("DURN_VALUE")).equals("")   ) && !( ((String)details.get("INFUSE_OVER")).equals("")    ) )
										{
											freq = (int)Math.ceil(Float.parseFloat((String)details.get("DURN_VALUE"))/Float.parseFloat((String)details.get("INFUSE_OVER")));
										}

					//					freq = Integer.parseInt(freq)+"";
										String  dose_uom	    = "";
										if(dosage_by.equals("S"))
											dose_uom		    =	(String)drugDetails.get("STRENGTH_UOM");         
										else if(dosage_by.equals("Q"))
											dose_uom		    =	(String)drugDetails.get("PRES_BASE_UOM");	
										String repeat_value     =   (String)drugDetails.get("REPEAT_VALUE")==null?"":(String)drugDetails.get("REPEAT_VALUE");
										String interval_value	=	(String)drugDetails.get("INTERVAL_VALUE")==null?"":(String)drugDetails.get("INTERVAL_VALUE");		
										
										String frequency	    =   "1";
										if(repeat_value != "" && interval_value != "")
											frequency = (int)Math.ceil( Integer.parseInt(repeat_value) / Integer.parseInt(interval_value))+"";
										dosageCheckParams.add(patient_id);
										dosageCheckParams.add(loading_ext_prod_id);
										dosageCheckParams.add(weight);
										dosageCheckParams.add(bsa);
										dosageCheckParams.add(dosage);
										dosageCheckParams.add(dose_uom);
										dosageCheckParams.add(freq+"");
										dosageCheckParams.add("1");

										//String ext_beanid   = "@ExternalProductLinkBean";
										//String ext_beanname = "ePH.ExternalProductLinkBean";
										//ExternalProductLinkBean ext_beanObj = (ExternalProductLinkBean)getBeanObject(ext_beanid,ext_beanname,request);
										drugDosageResult = beanex.getDrugDosageCheck(dosageCheckParams);

										if(drugDosageResult != null && drugDosageResult.size() > 0){
											beanex.setDosageCheck(loading_ext_prod_id, srl_no,drugDosageResult);	
											drug_db_dosage_check_flag="Y";
										}
										else{
											HashMap ext_dosage_det =beanex.getDosageCheck(loading_ext_prod_id, srl_no);
											if(ext_dosage_det != null && ext_dosage_det.size()>0){
												beanex.removeDosageCheck(loading_ext_prod_id, srl_no);
											}
										}	
										if(!external_dosage_override_reason.equals(""))
											drug_db_dosage_check_flag="Y";
									}		*/						
									drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN",drug_db_dosage_check_flag);
									drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN",drug_db_duptherapy_flag);
									drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN",drug_db_interact_check_flag);
									drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN",drug_db_contraind_check_flag);
									drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN",drug_db_allergy_check_flag);
							}
							else{
								drug_db_product_id = "";
							}
							drugDetails.put("DRUG_DB_PRODUCT_ID",drug_db_product_id);
							if(drug_db_dosage_check_flag.equals("Y") || drug_db_duptherapy_flag.equals("Y") || drug_db_interact_check_flag.equals("Y") || drug_db_contraind_check_flag.equals("Y") || drug_db_allergy_check_flag.equals("Y"))
								external_database_overrided_yn = "Y";

							if(external_database_overrided_yn.equals("Y") && ((drug_db_interact_check_flag.equals("Y") && external_interaction_override_reason.equals(""))|| (drug_db_duptherapy_flag.equals("Y") && external_duplicate_override_reason.equals("")) || (drug_db_contraind_check_flag.equals("Y") && external_contra_override_reason.equals("")) || (drug_db_dosage_check_flag.equals("Y") && external_dosage_override_reason.equals("")) || (drug_db_allergy_check_flag.equals("Y") && external_alergy_override_reason.equals(""))))
								external_database_overrided_reason="N";
							else
								external_database_overrided_reason="Y";

							if(external_database_overrided_reason.equals("Y"))
								extVisble	= "hidden";

							if(drug_db_allergy_check_flag.equals("Y")){
								drugDetails.put("ALLERGY_YN","N");
								allergy_yn = "N";
							}
							if(drug_db_duptherapy_flag.equals("Y")){
								drugDetails.put("CURRENT_RX","N");
								current_rx = "N";
							}
							if(drug_db_dosage_check_flag.equals("Y"))
								drugDetails.put("LIMIT_IND","Y");						

							drugDetails.put("EXTERNAL_DATABASE_OVERRIDED_REASON",external_database_overrided_reason);
							if(mode.equals("amend")){
								extVisble	= "hidden";
								HashMap drugReasons     = new HashMap();

								drugReasons =bean.getDrugReasons(order_id,(i+2)+"",ext_prod_id);
								System.out.println("656 ivprescription drugs"+drugReasons);

								if(drugReasons != null){
								//	if(drug_db_interface_yn.equals("N") || ext_prod_id.equals("")){
										if((String)drugReasons.get("ALLERGY_OVERRIDE_REASON") != null ){ 
											allergy_override = "Y";
											//drugDetails.put("ALLERGY_REMARKS",(String)drugReasons.get("ALLERGY_OVERRIDE_REASON"));// Modified for IN:072715 commentted to fix existing bug
											if(drug_db_allergy_check_flag.equals("N")){
												allergy_yn="Y";
												drugDetails.put("ALLERGY_YN","Y");
											}else{
												allergy_yn="N";
												drugDetails.put("ALLERGY_YN","N");
												drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_ALERGY_CHECK_YN",drug_db_allergy_check_flag);
												drugDetails.put("EXTERNAL_ALERGY_OVERRIDE_REASON",(String)drugReasons.get("ALLERGY_OVERRIDE_REASON"));
											}
										}										
										
										if((String)drugReasons.get("DOSAGE_LIMIT_OVERRIDE_REASON") != null ){
											dose_override ="Y";		
										//	drugDetails.put("DOSE_REMARKS",(String)drugReasons.get("DOSAGE_LIMIT_OVERRIDE_REASON"));// Modified for IN:072715 commentted to fix existing bug
											drugDetails.put("LIMIT_IND","N");
										}
										else{
											dose_override ="N";	
											ext_dosage_reason=(String) drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON")==null?"":(String) drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON");//Null Handling done for the incident num:24145 on 18/Oct/2010===By Sandhya
											drugDetails.put("LIMIT_IND","Y");
											drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN",drug_db_dosage_check_flag);
											//drugDetails.put("DOSE_REMARKS",(String)drugReasons.get("DOSAGE_LIMIT_OVERRIDE_REASON"));// Modified for IN:072715 commentted to fix existing bug

										}

										if((String)drugReasons.get("DUPLICATE_DRUG_OVERRIDE_REASON") != null){
											currentrx_override="Y";		
											
											if(drug_db_duptherapy_flag.equals("N")){
											//	drugDetails.put("CURRENTRX_REMARKS",(String)drugReasons.get("DUPLICATE_DRUG_OVERRIDE_REASON"));// Modified for IN:072715 commentted to fix existing bug
												current_rx = "Y";
												drugDetails.put("CURRENT_RX","Y");
											}else {
												drugDetails.put("EXTERNAL_DUPLICATE_OVERRIDE_REASON",(String)drugReasons.get("DUPLICATE_DRUG_OVERRIDE_REASON"));
												drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN",drug_db_duptherapy_flag);
												current_rx = "N";
												drugDetails.put("CURRENT_RX","N");
											}
											
										}
										if((String)drugReasons.get("ABUSE_DRUG_OVERRIDE_REASON") != null){ 
											if(abuse_override_remarks.equals("")){
											drugDetails.put("abuse_override_remarks",(String)drugReasons.get("ABUSE_DRUG_OVERRIDE_REASON"));
											}
											drugDetails.put("ABUSE_OVERRIDE","Y");
										}
								//	}
									//else{
									if(drug_db_interface_yn.equals("Y") && !ext_prod_id.equals("")){

										if((String)drugReasons.get("EXTERNAL_ALERGY_OVERRIDE_REASON") != null){ 
											drugDetails.put("EXTERNAL_ALERGY_OVERRIDE_REASON",(String)drugReasons.get("EXTERNAL_ALERGY_OVERRIDE_REASON"));
											drugDetails.put("ALLERGY_YN","Y");
											drug_db_allergy_check_flag = "Y";
										}
										if((String)drugReasons.get("EXTERNAL_DOSAGE_OVERRIDE_REASON") != null){ 
											drugDetails.put("EXTERNAL_DOSAGE_OVERRIDE_REASON",(String)drugReasons.get("EXTERNAL_DOSAGE_OVERRIDE_REASON"));
											drug_db_dosage_check_flag      = "Y";
											drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN",drug_db_dosage_check_flag);
											drugDetails.put("LIMIT_IND","N");
										}
										if((String)drugReasons.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON") != null){ 
											drugDetails.put("EXTERNAL_DUPLICATE_OVERRIDE_REASON",(String)drugReasons.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON"));
											drug_db_duptherapy_flag = "Y";
											drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN",drug_db_duptherapy_flag);
										}
										if((String)drugReasons.get("INTERACTION_OVERRIDE_REASON") != null){ 
											drugDetails.put("EXTERNAL_INTERACTION_OVERRIDE_REASON",(String)drugReasons.get("INTERACTION_OVERRIDE_REASON"));
											drug_db_interact_check_flag = "Y";
											drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN",drug_db_interact_check_flag);
										}
										if((String)drugReasons.get("CONTRAIND_OVERRIDE_REASON") != null){ 
											drugDetails.put("EXTERNAL_CONTRA_OVERRIDE_REASON",(String)drugReasons.get("CONTRAIND_OVERRIDE_REASON"));
											drug_db_contraind_check_flag = "Y";
											drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN",drug_db_contraind_check_flag);
										}
										if((String)drugReasons.get("CONTRAIND_OVERRIDE_REASON") != null){ 
											drugDetails.put("EXTERNAL_CONTRA_OVERRIDE_REASON",(String)drugReasons.get("CONTRAIND_OVERRIDE_REASON"));
											drug_db_contraind_check_flag = "Y";
											drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN",drug_db_contraind_check_flag);
										}
										
										
										

//***********************
							
							if(drug_db_dosage_check_flag.equals("Y") || drug_db_duptherapy_flag.equals("Y") || drug_db_interact_check_flag.equals("Y") || drug_db_contraind_check_flag.equals("Y") || drug_db_allergy_check_flag.equals("Y"))
								external_database_overrided_yn = "Y";

							if(external_database_overrided_yn.equals("Y") && ((drug_db_interact_check_flag.equals("Y") && external_interaction_override_reason.equals(""))|| (drug_db_duptherapy_flag.equals("Y") && external_duplicate_override_reason.equals("")) || (drug_db_contraind_check_flag.equals("Y") && external_contra_override_reason.equals("")) || (drug_db_dosage_check_flag.equals("Y") && external_dosage_override_reason.equals("")) || (drug_db_allergy_check_flag.equals("Y") && external_alergy_override_reason.equals(""))))
								external_database_overrided_reason="N";
							else
								external_database_overrided_reason="Y";

							if(external_database_overrided_reason.equals("Y"))
								extVisble	= "hidden";

							if(drug_db_allergy_check_flag.equals("Y")){
								drugDetails.put("ALLERGY_YN","N");
								allergy_yn = "N";
							}
							if(drug_db_duptherapy_flag.equals("Y")){
								drugDetails.put("CURRENT_RX","N");
								current_rx = "N";
							}
							if(drug_db_dosage_check_flag.equals("Y"))
								drugDetails.put("LIMIT_IND","Y");	
//***********************
									}
								}

								 external_dosage_override_reason		= (String) drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON");	

								 external_duplicate_override_reason		= (String) drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON");

								 external_interaction_override_reason	= (String) drugDetails.get("EXTERNAL_INTERACTION_OVERRIDE_REASON");
								 external_contra_override_reason		= (String) drugDetails.get("EXTERNAL_CONTRA_OVERRIDE_REASON");
								 external_alergy_override_reason		= (String) drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON");
								 System.out.println("in drug pageabuse_override_remarks"+abuse_override_remarks);
								// abuse_override_remarks=(String) drugDetails.get("abuse_override_remarks");

							}

							String allergy_override_gif		= "";
							String overdose_override_gif	= "";
							String currrx_override_gif		= "";
							if(sch_over_yn==null)
								sch_over_yn		=	"N";
							if(ext_prod_id==null)
								ext_prod_id		=	"";

							String tooltip					= new_generic_name+"/"+generic_name+" - "+qty_value+" "+or_qty_desc; //Modified for MMS-DM-CRF-0177
							String dispDesc					= "";
							
							//code changed to display drug name fully....on 10/5/2004
							dispDesc=drug_desc;
							if(allergy_override!=null && allergy_override.equals("N")) {
								allergy_override_gif="<IMG SRC='../images/exceed1.gif'></IMG>";
							}
							else {
								allergy_override_gif="&nbsp;";
							}

							if(dose_override!=null && dose_override.equals("N")) {
								overdose_override_gif="<IMG SRC='../images/exceed1.gif'></IMG>";
							}
							else {
								overdose_override_gif="&nbsp;";
							}

							if(currentrx_override!=null && currentrx_override.equals("N")) {
								currrx_override_gif="<IMG SRC='../images/exceed1.gif'></IMG>";
							}
							else {
								currrx_override_gif="&nbsp;";
							}
							abuse_override=(String)drugDetails.get("ABUSE_OVERRIDE")==null?"N":(String)drugDetails.get("ABUSE_OVERRIDE");
							abuse_override_remarks=(String)drugDetails.get("abuse_override_remarks")==null?"":(String)drugDetails.get("abuse_override_remarks");
							
							System.out.println("815 abuse_override_remarks"+abuse_override_remarks);
							System.out.println("815 abuse_override"+abuse_override);
							
							if(abuse_override_remarks!=null && abuse_override.equals("N")){//added for aakh-crf-0140
								drug_abuse_gif="<IMG SRC='../images/exceed1.gif'></IMG>";
							}
							else{
								drug_abuse_gif="&nbsp;";
							}
							if(!classValue.equals("AMENDEDDRUGS") && (!order_id.equals(""))){
								int srlNo = 1;
								if(srl_no != null)
									srlNo         = Integer.parseInt(srl_no);

								String orgLineNum = Integer.toString(srlNo+1);
								HashMap qtyValues =	bean.getQtyValue(patient_id,order_id,orgLineNum);
								dosage_type       = (String)qtyValues.get("dosage_type")==null?"":(String)qtyValues.get("dosage_type");
								qty_value         = (String)qtyValues.get("qty_value");
						
								drugDetails.put("DOSAGE_TYPE",dosage_type);
								drugDetails.put("QTY_VALUE",qty_value);
							}
%>
							<input type="hidden" name="external_dosage_override_reason<%=srl_no%>" id="external_dosage_override_reason<%=srl_no%>"      value="<%=external_dosage_override_reason%>">
							<input type="hidden" name="external_duplicate_override_reason<%=srl_no%>" id="external_duplicate_override_reason<%=srl_no%>"   value="<%=external_duplicate_override_reason%>">
							<input type="hidden" name="external_interaction_override_reason<%=srl_no%>" id="external_interaction_override_reason<%=srl_no%>" value="<%=external_interaction_override_reason%>">
							<input type="hidden" name="external_contra_override_reason<%=srl_no%>" id="external_contra_override_reason<%=srl_no%>"      value="<%=external_contra_override_reason%>">
							<input type="hidden" name="external_alergy_override_reason<%=srl_no%>" id="external_alergy_override_reason<%=srl_no%>"      value="<%=external_alergy_override_reason%>">
							<input type="hidden" name="abuse_override_remarks<%=srl_no%>" id="abuse_override_remarks<%=srl_no%>" value="<%=abuse_override_remarks%>"><!--added for aakh-crf-0140 -->
							<TR TITLE="<%=tooltip%>">
<%
							if(sch_over_yn.equals("Y") ) {
%>
								<TD CLASS="<%=classValue%>" COLSPAN="" NOWRAP WIDTH="64%" onClick="defaultDrug('<%=srl_no%>','<%=mode%>','<%=classValue%>');"  onMouseOver="changeCursor(this); changeCol(this);" onMouseOut="realCol(this,'<%=classValue%>');"><FONT CLASS="HYPERLINK"><%=new_generic_name%></FONT>
<%
								if (!ext_prod_id.equals("")	&& drug_db_interface_yn.equals("Y")) { // && drug_db_interface_yn.equals("Y") Added for PMG2018-COMN-CRF-0002
%>
									<IMG onMouseOver="changeCursor(this)" STYLE="filter:Chroma(Color=#FFFFFF)" SRC="../../ePH/images/info.gif" HEIGHT="20" WIDTH="20" onClick="loadDrugInfo('<%=ext_prod_id%>','<%=drug_desc%>')">
<%
								}
%>
								</TD>
<%
							}
							else {
%>

								<TD CLASS="<%=classValue%>" COLSPAN="" NOWRAP WIDTH="64%" onClick="defaultDrug('<%=srl_no%>','<%=mode%>','<%=classValue%>');"  onMouseOver="changeCursor(this); changeCol(this);" onMouseOut="realCol(this,'<%=classValue%>');"><FONT CLASS="HYPERLINK"><%=new_generic_name%></FONT>
<%
								if (!ext_prod_id.equals("")	&& drug_db_interface_yn.equals("Y")) { // && drug_db_interface_yn.equals("Y") Added for PMG2018-COMN-CRF-0002
%>
									<IMG onMouseOver="changeCursor(this)" STYLE="filter:Chroma(Color=#FFFFFF)" SRC="../../ePH/images/info.gif" HEIGHT="20" WIDTH="20" onClick="loadDrugInfo('<%=ext_prod_id%>','<%=drug_desc%>')">
<%
								}
%>
								</TD>
<%
							}
							if( Integer.parseInt(adr_count)>0){
								drug_adr_count = bean.getADRCount(patient_id,drug_code);
								if(drug_adr_count>0){
%>
									<TD CLASS="<%=classValue%>" COLSPAN="" NOWRAP WIDTH="6%" ><img  id="ADR_img" src='../../ePH/images/ADR.gif' height =20 width =20 title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>' ></img></TD>
<%				
								}
								else{
%>
									<TD CLASS="<%=classValue%>" WIDTH="6%">&nbsp;</TD>
<%	             
								}
							}
							if(external_database_overrided_yn.equals("Y") && !ext_prod_id.equals("") && (drug_db_interact_check_flag.equals("Y") || drug_db_duptherapy_flag.equals("Y") ||drug_db_allergy_check_flag.equals("Y") ||drug_db_contraind_check_flag.equals("Y") || drug_db_dosage_check_flag.equals("Y"))){

%>
								<TD CLASS="SHIFTTOTAL" COLSPAN="" NOWRAP WIDTH="6%" id="ext_ddb_override_indc<%=srl_no%>"  onclick="viewMedicationAlert('<%=patient_id%>','<%=ext_prod_id%>','<%=drug_db_interact_check_flag%>','<%=drug_db_duptherapy_flag%>','<%=drug_db_contraind_check_flag%>','<%=drug_db_dosage_check_flag%>','PRESPAD','<%=java.net.URLEncoder.encode(external_dosage_override_reason,"UTF-8")%>','<%=drug_code%>','<%=srl_no%>','<%=java.net.URLEncoder.encode(external_duplicate_override_reason,"UTF-8")%>','<%=java.net.URLEncoder.encode(external_interaction_override_reason,"UTF-8")%>','<%=java.net.URLEncoder.encode(external_contra_override_reason,"UTF-8")%>','<%=java.net.URLEncoder.encode(pract_name,"UTF-8")%>','<%=java.net.URLEncoder.encode(external_alergy_override_reason,"UTF-8")%>','<%=drug_db_dosecheck_yn%>','<%=drug_db_allergy_check_flag%>')" onmouseover="changeCursor(this);">
								<img name="ext_ddb_override_img<%=srl_no%>" src='../../ePH/images/exceed1.gif' style="visibility:<%=extVisble%>;" ></img>
								&nbsp;</TD>
							<!--	<TD CLASS="<%=classValue%>" COLSPAN="" NOWRAP WIDTH="6%">&nbsp;</TD>
								<TD CLASS="<%=classValue%>" WIDTH="6%">&nbsp;</TD>
								<TD CLASS="<%=classValue%>" COLSPAN="" NOWRAP WIDTH="6%">&nbsp;</TD>-->
										  
<%
							}
							else{

%>
								<TD CLASS="<%=classValue%>" COLSPAN="" NOWRAP WIDTH="6%" id="override_indc<%=srl_no%>"><img name="override_img<%=srl_no%>" src='../../ePH/images/exceed1.gif' style="visibility:hidden;" ></img>&nbsp;</TD>
<%
							}								
							if(allergy_yn!=null && allergy_yn.equals("Y") && !drug_db_allergy_check_flag.equals("Y")) {
%>
									<TD CLASS="ALLERGY" COLSPAN="" NOWRAP WIDTH="6%" TITLE='<fmt:message key="ePH.AllergyDrug.label" bundle="${ph_labels}"/>' onClick="showAllergyDetails('<%=generic_id%>','<%=patient_id%>','<%=encounter_id%>','<%=java.net.URLEncoder.encode(generic_name,"UTF-8")%>','<%=java.net.URLEncoder.encode(drug_desc,"UTF-8")%>');" onMouseOver="changeCursor(this);">&nbsp;<%=allergy_override_gif%>&nbsp;</TD>
<%
								}
								else {
%>
									<TD CLASS="<%=classValue%>" COLSPAN="" NOWRAP WIDTH="6%">&nbsp;</TD>
<%
								}
								if(limit_ind!=null && limit_ind.equals("N") && !drug_db_dosage_check_flag.equals("Y")) {
%>
									<TD CLASS="DOSELIMIT" COLSPAN="" NOWRAP WIDTH="6%" TITLE='<fmt:message key="ePH.ExceedDosageLimit.label" bundle="${ph_labels}"/>' onMouseOver="changeCursor(this);" onClick="showMonoGraph('<%=drug_desc%>','<%=java.net.URLEncoder.encode(mono_graph,"UTF-8")%>','<%=daily_dose%>','<%=unit_dose%>','<%=min_daily_dose%>','<%=min_unit_dose%>','<%=dosage_unit%>','<%=dosage_std%>','<%=dose_unit_desc%>','<%=max_daily_ceeling_dose%>','<%=min_daily_ceeling_dose%>','<%=max_unit_ceeling_dose%>','<%=min_unit_ceeling_dose%>','<%=dose_unit_desc1%>');">&nbsp;<%=overdose_override_gif%>&nbsp;</TD><!-- Modified for IN:070451  -->
<%
								}
								else {
%>
									<TD CLASS="<%=classValue%>" WIDTH="6%">&nbsp;</TD>
<%
								}
								if(current_rx!=null && current_rx.equals("Y") && !drug_db_duptherapy_flag.equals("Y")) {
%>
									<TD CLASS="CURRENTRX" COLSPAN="" NOWRAP WIDTH="6%" TITLE='<fmt:message key="ePH.DuplicateMedication.label" bundle="${ph_labels}"/>' onMouseOver="changeCursor(this);" onClick="callCurrentMedication('<%=patient_id%>','<%=encounter_id%>','<%=generic_id%>')">&nbsp;<%=currrx_override_gif%>&nbsp;</TD>
<%
								}
								else {
%>
									<TD CLASS="<%=classValue%>" COLSPAN="" NOWRAP WIDTH="6%">&nbsp;</TD>
<%
								}if(abuse_exists.equals("Y") && abuse_action.equals("B") ) {//added for aakh-crf-0140
%>
									<TD CLASS="CURRENTRX" style="BACKGROUND-COLOR:purple;" COLSPAN="" NOWRAP WIDTH="6%" TITLE='Drug Abuse' onMouseOver="changeCursor(this);" onClick="showAbuseDetails('','<%=patient_id%>','<%=encounter_id%>','<%=generic_id%>','<%=drug_code%>','Clicking')">&nbsp;<%=drug_abuse_gif%>&nbsp;</TD>
<%
								}
								else {
%>
									<TD CLASS="<%=classValue%>" COLSPAN="" NOWRAP WIDTH="6%">&nbsp;</TD>
<%
								}
								
%>
								
<%
							//}
%></TR>
							<input type="hidden" name="drug_code_<%=srl_no%>" id="drug_code_<%=srl_no%>"	 value="<%=drug_code%>">
							<input type="hidden" name="drug_class_<%=srl_no%>" id="drug_class_<%=srl_no%>"	 value="<%=drug_class%>">
							<input type="hidden" name="ext_prod_id_<%=srl_no%>" id="ext_prod_id_<%=srl_no%>"	 value="<%=ext_prod_id%>">
							<input type="hidden" name="external_db_dose_check_<%=srl_no%>" id="external_db_dose_check_<%=srl_no%>" value="">
							<input type="hidden" name="ext_med_alerts_fired_for_dup_check_yn<%=srl_no%>" id="ext_med_alerts_fired_for_dup_check_yn<%=srl_no%>" value="<%=drug_db_duptherapy_flag%>">
							<input type="hidden" name="ext_med_alerts_fired_for_inte_check_yn<%=srl_no%>" id="ext_med_alerts_fired_for_inte_check_yn<%=srl_no%>" value="<%=drug_db_interact_check_flag%>">
							<input type="hidden" name="ext_med_alerts_fired_for_contra_check_yn<%=srl_no%>" id="ext_med_alerts_fired_for_contra_check_yn<%=srl_no%>" value="<%=drug_db_contraind_check_flag%>">
							<input type="hidden" name="ext_med_alerts_fired_for_dosage_check_yn<%=srl_no%>" id="ext_med_alerts_fired_for_dosage_check_yn<%=srl_no%>" value="<%=drug_db_dosage_check_flag%>">
							<input type="hidden" name="ext_med_alerts_fired_for_allergy_check_yn<%=srl_no%>" id="ext_med_alerts_fired_for_allergy_check_yn<%=srl_no%>" value="<%=drug_db_allergy_check_flag%>">
							<input type="hidden" name="abuse_override_remarks" id="abuse_override_remarks" value="<%=abuse_override_remarks %>" >
							<input type="hidden" name="abuse_override" id="abuse_override" value="<%=abuse_override %>" >
<%
						}
					}
%>
					</TABLE>
					<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
					<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
					<INPUT TYPE="hidden" name="patient_id" id="patient_id" VALUE="<%= patient_id %>">
					<input type="hidden" name="drug_codes" id="drug_codes" value="<%= bean.getDrugCodes() %>">
					<input type="hidden" name="tot_volume" id="tot_volume" value="<%=tot_volume%>" >
					<input type="hidden" name="weight" id="weight" value="<%=weight%>" >
					<input type="hidden" name="bsa" id="bsa" value="<%=bsa%>" >
					<!-- added for ml-mmoh-crf-0863 start -->
				    <INPUT type="hidden" name="take_home_medication" id="take_home_medication" value="<%=take_home_medication%>">
					<INPUT type="hidden" name="priority" id="priority" value="<%=priority%>">
					<INPUT type="hidden" name="iv_prep_yn" id="iv_prep_yn" value="<%=iv_prep_yn%>">
<!-- added for ml-mmoh-crf-0863 end -->
					
					<script>
<%
						if(!mode.equals("amend")){
%>
							loadDrugCodes();	
<%
						}
						if(tmp_srl_no!=null ) { 
%>
							setTimeout("defaultDrug('<%=tmp_srl_no%>','<%=mode%>','<%=classValue%>');",1500);
<%
						}
%>
					</script>
<%
				}
			if(iv_prep_default.equals("1") || iv_prep_default.equals("2")){
%>
				<script>setTimeout("setOrdersetIVDrugs('<%=ordsetDrugCodes.toString()%>','<%=bean_id%>','<%=bean_name%>');",1000);</script>
<%
			}

	/*		String or_bean_name			= "eOR.OrderEntryBean";
			String or_bean_id			= "@orderentrybean"+patient_id+encounter_id;
			OrderEntryBean orbean		= (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request);
			eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean)orbean.getOrderEntryRecordBean();
			String key = orbean.getPatientId() + orbean.getEncounterId();
			java.util.HashMap previousValues	= (java.util.HashMap)orderEntryRecordBean.getCheckedEntries(key);
			String order_catalog_code 			= orbean.getOrderCatalogCode(previousValues, "PH");*/

%>
		</FORM>
	</BODY>
</HTML>
<% putObjectInBean(bean_id,bean,request); %>

