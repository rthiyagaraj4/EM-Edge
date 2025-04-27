<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date	 		Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

14/08/2020	    IN73343             Shazana												 PHIS-PH-Alpha - Medical Supply, Special Characters issue in SIKARIN
06/11/2020      IN:069887              Haribabu                   Manickavasagam J          MO-CRF-20152
05/01/2021	 TFS id:7345 Haribabu	      06/01/2021       Manickavasagam J			     MMS-DM-CRF-0177
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/  %>

<!--saved on 27th Oct 2005 -->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*,eOR.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
	<head>
    <!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086 
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
	<!-- <script language="JavaScript" src="../js/PhMessages.js"></script> -->
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
    <script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/PhCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
    <script language="JavaScript" src="../../ePH/js/Prescription_1.js"></script>
	<script language="JavaScript" src="../../ePH/js/PrescriptionTest.js"></script>
	<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="Javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="Javascript" src="../../eOR/js/OrderEntrySearch.js"></script>

</head>
<!-- Added for Bru-HIMS-CRF-0265 [IN032315] -- begin	-->
	<!--<script language="VBScript">
		Function vbConfirm(msg)
		   butVal = 32 + 4 + 0 + 0
		   vbConfirm = MsgBox(msg,butVal,"Duplicate Drug")
		End Function
	</script>-->
	<script language="Javascript">

function jsConfirm(msg) {        
return confirm(msg); 
}
 </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	<!-- Added for Bru-HIMS-CRF-0265 [IN032315] -- end	-->
<!-- Variable initialization starts-->
<%
try{
	String patient_id				= "";
	String encounter_id				= "";
	String priority					= "";
//	String hr_start_time			= "";
	String drug_code				= "";
	String drug_desc				="";
	String drug_desc_new			="";//Added for TFS id:7345
	String drug_search_by			="";//Added for TFS id:7345
	String srl_no					= "";
	String bsa						= "";
	String order_id				    = "";
	String display_tdm              ="display:none";
	String freq_code		=	""; //  added for Bru-HIMS-CRF-0265 [IN032315] 
	String start_date		=	""; //  added for Bru-HIMS-CRF-0265 [IN032315] 
	String end_date		=	""; //  added for Bru-HIMS-CRF-0265 [IN032315] 
%>
<!-- Variable initialization ends-->

<!-- Parameters--Start-->
<%
	String calling_mode			= request.getParameter("mode") ;
	String mode						= CommonRepository.getCommonKeyValue( "MODE_INSERT" );
	if(calling_mode.equals("blank")){
		patient_id				= request.getParameter("patient_id") ;
		encounter_id			= request.getParameter("encounter_id") ;
		priority				= request.getParameter("priority") ;
	}
	else{
		drug_code				= request.getParameter("drug_code") ;
		srl_no					= request.getParameter("srl_no") ;
		patient_id				= request.getParameter("patient_id") ;
		encounter_id			= request.getParameter("encounter_id") ;
		priority				= request.getParameter("priority") ;
		bsa						= request.getParameter("bsa") ;	
	}
	String patient_class		= request.getParameter("patient_class");
	String drug_db_interface_yn		= request.getParameter("drug_db_interface_yn")==null?"":request.getParameter("drug_db_interface_yn");
	String drug_db_allergy_check_yn	    = request.getParameter("drug_db_allergy_check_yn")==null?"":request.getParameter("drug_db_allergy_check_yn");
	String drug_db_duptherapy_yn	    = request.getParameter("drug_db_duptherapy_yn")==null?"":request.getParameter("drug_db_duptherapy_yn");

	String extdrugCode		=	"";
	String srlNo			=	"";
	String allergy_yn		=	"";
	String limit_ind		=	"";
	String current_rx		=	"";
	String generic_id		=	"";
	String generic_name		=	"";
	String daily_dose		=	"";
	String unit_dose		=	"";
	String min_daily_dose	=	"";
	String min_unit_dose	=	"";
	String dosage_std					=	"";
	String dosage_unit					=	"";
	String mono_graph		=	"";
	String order_type_code	=	"";
	String allow_duplicate	=	"";
	String freq_nature		=	"";
	String qty_unit			=	"";
	String Override_Checked = "";
	String Override_Check="";
	String checkEnabled="";
	String sliding_scale_yn="";
	String ord_set_reqd_or_opt="";
	String form_code	   = "";
	String form_desc  	   = "";
	String route_code	   = "";
	String route_desc	   = "";
	String route_color	   = "";
	String amend_yn		   = "";
	String sliding_scale_yn_status = "";
	String dsg_reason = "";
	String dup_reason = "";
	String int_reason = "";
	String con_reason = "";
	String alg_reason = "";
	String		ext_prod_id				=	"";
	String		trade_code ="";
	String		trade_name="";
	String		trade_name_display="";
	String MAR_app_yn = request.getParameter("MAR_app_yn")==null?"Y":request.getParameter("MAR_app_yn");
	String buildMAR_yn = "";
	String buildMAR_enable = "";
	String buildMAR_checked = "";
	String ord_id = "";
	String ord_line_no = "";
	String called_from_amend = request.getParameter("called_from_amend")==null?"":request.getParameter("called_from_amend");
	String force_auth_yn			=	"";
	String ord_auth_reqd_yn			= 	"";
	String ord_authorized_prev_yn	= 	"";
	String ord_spl_appr_reqd_yn		= 	"";
	String ord_cosign_reqd_yn		= 	"";
	String ord_authorized_yn		= 	"";
	String ord_approved_yn			= 	"";
	String ord_cosigned_yn			= 	"";
	String color_auth_rule	= "RED";
	String display_auth_rule	="visibility:hidden";
	String drug_db_allergy_flag = "";
	String drug_db_duptherapy_flag = "";
	String drug_db_interact_check_flag = "";
	String drug_db_contraind_check_flag = "";
	String drug_db_dosage_check_flag = "";
	String dose_override = "";
	String DrugRemarksEntered = ""; //Added for Antibiotic Screen using Order Entry Format ICN 29904
	String buildMAR_rule			= "";  // RUT-CRF-0062 - IN 32186
	String 		DrugIndicationRemarks				=   "";// ML-BRU-CRF-072[Inc:29938] 
	String interaction_exists				=	"", intr_restric_trn="N", intr_msg_content="";
	ArrayList alDrugIntrList = null;
	HashMap hmDrugInteractionDtl = null;

	ArrayList presDetails				=	null;
	HashMap drugDetails					=	null;

	if(bsa==null) 				bsa	=	"";
	if(priority==null)	 priority	=	"";
	String presBean_id			= "PrescriptionBean"+patient_id+encounter_id;
	String presBean_name		= "ePH.PrescriptionBean";
	PrescriptionBean presBean		= (PrescriptionBean)getBeanObject(presBean_id, presBean_name, request );
	
	String bean_id			= "@PrescriptionBean_1"+patient_id+encounter_id;
	String bean_name		= "ePH.PrescriptionBean_1";
	PrescriptionBean_1 bean	= (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request );
	bean.setLanguageId(locale);
	String actionText				=	""; // add for SKR-CRF-0006[IN029561]
	String validate_overide_on_confirm_yn="N";//Added for IN:069887 
	//int take_home					=	bean.getHomeMecdicationYn(encounter_id,(String)session.getValue("facility_id"));
	int take_home					=	(int)bean.getTakeHomeCount();
	int profile_count		= bean.getDrugProfileCount();  //added for Bru-HIMS-CRF-0265 [IN032315]		
	//Added for IN:069887 start
	boolean validate_overide_on_confirm =presBean.isSiteSpecific("PH","VALIDATE_OVERIDE_ON_CONFIRM"); 
	boolean drug_abuse_appl=presBean.isSiteSpecific("PH","DRUG_ABUSE_APPL");//added for AAKH-CRF-0140
	String abuse_exists	=	"", abuse_restric_trn="N", abuse_remarks="", abuse_override ="" ,abuse_action="",abuse_type="",abuse_override_remarks="";//added for AAKH-CRF-140
	
	String pre_alloc_appl_yn =CommonBean.checkForNull(bean.getPreAllocApplYN());//Added for TFS id:7345		
	String drug_indication_mdry="";//added for jd-crf-0220
	drug_indication_mdry=bean.getDrugIndicationMdry();//added for jd-crf-0220
			if(validate_overide_on_confirm){
		validate_overide_on_confirm_yn="Y";
	}
	//Added for IN:069887 end
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
	//ADDED FOR IN073343 start
	String		max_daily_ceeling_dose	    =   "";
	String		min_daily_ceeling_dose	    =   "";
	String		max_unit_ceeling_dose	    =   "";
	String		min_unit_ceeling_dose	    =   "";
	String allergy_remarks_code = "";
	String dose_remarks_code = "";
	String currentrx_remarks_code = "";
	String interaction_remarks_code = "";
	String food_interaction_remarks_code = "";
	String lab_interaction_remarks_code = "";
	//ADDED FOR IN073343 end
	
		patient_id				= request.getParameter("patient_id") ;
		encounter_id			= request.getParameter("encounter_id") ;
		priority				= request.getParameter("priority") ;
		if(!calling_mode.equals("blank")){
			presDetails					= (ArrayList) bean.getpresDetails();
			drug_code				= request.getParameter("drug_code") ;
			srl_no					= request.getParameter("srl_no") ;
			bsa						= request.getParameter("bsa") ;	
			if(order_id==null||order_id.equals("")){
				display_tdm="display:none";
			}
			else{
				display_tdm="display:inline";
			} 
		}
		if(presDetails!=null && presDetails.size()>0){		
			for(int i=0;i<presDetails.size();i++){
				drugDetails		= (HashMap)presDetails.get(i);
				extdrugCode		= (String)drugDetails.get("DRUG_CODE");
				srlNo			= (String)drugDetails.get("SRL_NO");
					if(extdrugCode.equals(drug_code) && srlNo.equals(srl_no) ){
						ext_prod_id					= (String) drugDetails.get("EXTERNAL_PRODUCT_ID")==null?"":(String) drugDetails.get("EXTERNAL_PRODUCT_ID");
						drug_db_dosage_check_flag = (String)drugDetails.get("DRUG_DB_DOSAGE_CHECK_FLAG")==null?"N":(String) drugDetails.get("DRUG_DB_DOSAGE_CHECK_FLAG");
						drug_db_contraind_check_flag = (String)drugDetails.get("DRUG_DB_CONTRAIND_CHECK_FLAG")==null?"N":(String) drugDetails.get("DRUG_DB_CONTRAIND_CHECK_FLAG");
						drug_db_interact_check_flag = (String)drugDetails.get("DRUG_DB_INTERACT_CHECK_FLAG")==null?"N":(String) drugDetails.get("DRUG_DB_INTERACT_CHECK_FLAG");
						drug_db_duptherapy_flag = (String)drugDetails.get("DRUG_DB_DUPTHERAPY_FLAG")==null?"N":(String) drugDetails.get("DRUG_DB_DUPTHERAPY_FLAG");
						drug_db_allergy_flag = (String)drugDetails.get("DRUG_DB_ALLERGY_FLAG")==null?"N":(String) drugDetails.get("DRUG_DB_ALLERGY_FLAG");
				
						drug_desc	   = (String)drugDetails.get("DRUG_DESC");
						drug_desc_new				= (String) drugDetails.get("DRUG_DESC_NEW")==null?"":(String) drugDetails.get("DRUG_DESC_NEW");//Added for TFS id:7345
						drug_search_by				= (String) drugDetails.get("DRUG_SEARCH_BY")==null?"":(String) drugDetails.get("DRUG_SEARCH_BY");//Added for TFS id:7345
						generic_id					= (String) drugDetails.get("GENERIC_ID");
						generic_name				= (String) drugDetails.get("GENERIC_NAME");
						allergy_yn					= (String) drugDetails.get("ALLERGY_YN")==null?"":(String) drugDetails.get("ALLERGY_YN");
						limit_ind					= (String) drugDetails.get("LIMIT_IND")==null?"":(String) drugDetails.get("LIMIT_IND");
						current_rx					= (String) drugDetails.get("CURRENT_RX")==null?"":(String) drugDetails.get("CURRENT_RX");
						daily_dose					= (String) drugDetails.get("DAILY_DOSE");
						unit_dose					= (String) drugDetails.get("UNIT_DOSE");
						min_daily_dose				= (String) drugDetails.get("MIN_DAILY_DOSE");
						min_unit_dose				= (String) drugDetails.get("MIN_UNIT_DOSE"); 
						mono_graph					= (String) drugDetails.get("MONO_GRAPH");
						dose_override				= (String) drugDetails.get("DOSE_OVERRIDE");
						order_type_code				= (String) drugDetails.get("ORDER_TYPE_CODE");
						allow_duplicate				= (String) drugDetails.get("ALLOW_DUPLICATE_DRUG");
						if(patient_class.equals("OP"))
							allow_duplicate	   = (String) drugDetails.get("ALLOW_DUPLICATE_DRUG_OP");
						freq_nature					= (String) drugDetails.get("FREQ_NATURE");
						freq_code					= (String) drugDetails.get("FREQ_CODE")==null?"":(String) drugDetails.get("FREQ_CODE"); // added for Bru-HIMS-CRF-0265 [IN032315] 
						start_date					= (String) drugDetails.get("START_DATE")==null?"":(String) drugDetails.get("START_DATE"); // added for Bru-HIMS-CRF-0265 [IN032315] 
						end_date					= (String) drugDetails.get("END_DATE")==null?"":(String) drugDetails.get("END_DATE"); // added for Bru-HIMS-CRF-0265 [IN032315] 
						ord_auth_reqd_yn			= (String) drugDetails.get("ORD_AUTH_REQD_YN");
						force_auth_yn				= (String) drugDetails.get("FORCE_AUTH_YN"); // THIS IS TO KNOW IF AUTH YN IS DUE TO FORCE AUT OR DUE TO DURATION EXCEEDED
						ord_spl_appr_reqd_yn		= (String) drugDetails.get("ORD_SPL_APPR_REQD_YN");
						ord_cosign_reqd_yn			= (String) drugDetails.get("ORD_COSIGN_REQD_YN");
						ord_authorized_yn					= (String) drugDetails.get("ORD_AUTHORIZED_YN");
						ord_authorized_prev_yn					= (String) drugDetails.get("ORD_AUTHORIZED_PREV_YN");
						ord_approved_yn				= (String) drugDetails.get("ORD_APPROVED_YN");
						ord_cosigned_yn				= (String) drugDetails.get("ORD_COSIGNED_YN");

						qty_unit			        = CommonBean.checkForNull((String)drugDetails.get("STRENGTH_UOM"));
						sliding_scale_yn	= (String)drugDetails.get("SLIDING_SCALE_YN")==null?"Y":(String)drugDetails.get("SLIDING_SCALE_YN"); 
						ord_set_reqd_or_opt	   = (String) drugDetails.get("REQD_OR_OPT_IND")==null?"":(String) drugDetails.get("REQD_OR_OPT_IND");

						form_code	    = (String)drugDetails.get("FORM_CODE");         
						form_desc  	    = (String)drugDetails.get("FORM_DESC");     
						route_code	    = (String)drugDetails.get("ROUTE_CODE")==null?"":(String)drugDetails.get("ROUTE_CODE");       
						route_desc	    = (String)drugDetails.get("ROUTE_DESC")==null?"":(String)drugDetails.get("ROUTE_DESC");       
						route_color	    = (String)drugDetails.get("ROUTE_COLOR")==null?"":(String)drugDetails.get("ROUTE_COLOR");   
						if( route_color.equals("")){
							if(route_color.length()==12){
								route_color = "color:"+route_color.substring(0, 6)+";background-color:"+route_color.substring(6, 12)+";";
							}
						}
						actionText = presBean.getActionText(form_code,route_code);	 //add for SKR-CRF-0006[IN029561]					
						
						amend_yn	    = (String)drugDetails.get("AMEND_YN");       
						dosage_std	    = (String)drugDetails.get("DOSAGE_STD");
						dosage_unit		= (String)drugDetails.get("DOSAGE_UNIT");
						dsg_reason		=	(String)drugDetails.get("EXT_DDB_DSG_REASON")==null?"":(String)drugDetails.get("EXT_DDB_DSG_REASON");
						dup_reason		=	(String)drugDetails.get("EXT_DDB_DUP_REASON")==null?"":(String)drugDetails.get("EXT_DDB_DUP_REASON");
						con_reason		=	(String)drugDetails.get("EXT_DDB_CON_REASON")==null?"":(String)drugDetails.get("EXT_DDB_CON_REASON");
						int_reason		=	(String)drugDetails.get("EXT_DDB_INT_REASON")==null?"":(String)drugDetails.get("EXT_DDB_INT_REASON");
						alg_reason		=	(String)drugDetails.get("EXT_DDB_ALG_REASON")==null?"":(String)drugDetails.get("EXT_DDB_ALG_REASON");
						trade_code = (String) drugDetails.get("TRADE_CODE")==null?"": (String) drugDetails.get("TRADE_CODE");
						trade_name = (String) drugDetails.get("TRADE_NAME")==null?"": (String) drugDetails.get("TRADE_NAME");
						if(trade_code.equals(""))
							trade_name_display="none";
						else
							trade_name_display ="inline";

//RUT-CRF-0062 IN-32186	 Added to get the Build MAR Value based on MAR Rule -- begin
				if(MAR_app_yn.equals("Y")){
						buildMAR_rule = drugDetails.get("BUILD_MAR_RULE").toString();
						buildMAR_yn ="N";
						if(drugDetails.get("BUILDMAR_YN")!=null){
							buildMAR_yn = drugDetails.get("BUILDMAR_YN").toString();
							
							if(buildMAR_yn.equals("Y"))
								buildMAR_checked="checked";
							else
								buildMAR_checked="";
							
							if(buildMAR_rule.equals("CD") || buildMAR_rule.equals("UD"))
								buildMAR_enable="disabled";
							else	
								buildMAR_enable="";
						}
						else{
							buildMAR_enable="";
							buildMAR_checked="";
							buildMAR_yn ="N";					
						
							if(buildMAR_rule.equals("CD")||buildMAR_rule.equals("UD"))
								buildMAR_enable="disabled";
							
							if(buildMAR_rule.equals("CE")||buildMAR_rule.equals("CD")){
								buildMAR_checked="checked";
								buildMAR_yn ="Y";
							}
						}
					  }
					}
					/* RUT-CRF-0062 IN 32186  Commented to load Build MAR value based on Rule 
					if(drugDetails.get("BUILDMAR_YN")==null){
						drugDetails.put("BUILDMAR_YN",MAR_app_yn);
					} 
					RUT-CRF-0062 IN 32186   -- end */
					DrugRemarksEntered = (String) drugDetails.get("DrugRemarksEntered")==null?"":(String) drugDetails.get("DrugRemarksEntered"); //Added for Antibiotic Screen using Order Entry Format ICN 29904
				}
			}
			DrugIndicationRemarks= (String) drugDetails.get("DRUG_INDICATION")==null?"":(String)drugDetails.get("DRUG_INDICATION");//Added for ML-BRU-CRF-072[Inc:29938]
			if(!DrugIndicationRemarks.equals(""))
				DrugIndicationRemarks = java.net.URLEncoder.encode(DrugIndicationRemarks,"UTF-8"); ;
			
			if(MAR_app_yn.equals("Y")){
		/* Commented for SRR20056-CRF-0649.1 to (deselect)enable BuildMAR fo rIP
				if(patient_class.equals("IP") || calling_mode.equals("taper")|| calling_mode.equals("tapered"))
		 SRR20056-CRF-0649.1 */
		 
		 
				if( calling_mode.equals("taper")|| calling_mode.equals("tapered"))
					buildMAR_enable ="disabled";
					
				/* Commented RUT-CRF-0062 IN 32186
				 if(buildMAR_yn.equals("Y"))
					buildMAR_checked ="Checked";
				*/
			}
			sliding_scale_yn_status = "";                                            
			order_id	   =  "";
			order_id	   = bean.getOorderIdForTDMDtls(patient_id,drug_code);
			display_tdm    ="display:none"; 
			if(order_id==null||order_id.equals("")){
				display_tdm="display:none";
			}else{
				display_tdm="display:inline";
			}				
			HashMap sliding_scale_dtls = bean.getSlidingScaleDetails(drug_code);
			if((amend_yn!=null && amend_yn.equals("Y")) || called_from_amend.equals("Y")) {
				sliding_scale_yn_status = "disabled";
			}

			if(calling_mode.equals("amend")){
				ord_id = (String)drugDetails.get("ORDER_ID");
				ord_line_no = (String)drugDetails.get("ORDER_LINE_NUM");
			}
		/*	if(current_rx.equals("Y") || limit_ind.equals("N") || allergy_yn.equals("Y"))
			{
				Override_Check = "Y";
				drugDetails.put("Override_Check",Override_Check);
			} */
			//Added for IN073343 start
			max_daily_ceeling_dose				= (String) drugDetails.get("MAX_DAILY_CEELING_DOSE");
			min_daily_ceeling_dose				= (String) drugDetails.get("MIN_DAILY_CEELING_DOSE");
			max_unit_ceeling_dose				= (String) drugDetails.get("MAX_UNIT_CEELING_DOSE");
			min_unit_ceeling_dose				= (String) drugDetails.get("MIN_UNIT_CEELING_DOSE");
			allergy_remarks_code				= (String) drugDetails.get("ALLERGY_REMARKS_CODE")==null?"":(String) drugDetails.get("ALLERGY_REMARKS_CODE");
			dose_remarks_code				= (String) drugDetails.get("DOSE_REMARKS_CODE")==null?"":(String) drugDetails.get("DOSE_REMARKS_CODE");
			currentrx_remarks_code				= (String) drugDetails.get("CURRENTRX_REMARKS_CODE")==null?"":(String) drugDetails.get("CURRENTRX_REMARKS_CODE");
			interaction_remarks_code				= (String) drugDetails.get("INTERACTION_REMARKS_CODE")==null?"":(String) drugDetails.get("INTERACTION_REMARKS_CODE");
			food_interaction_remarks_code				= (String) drugDetails.get("FOOD_INTERACTION_REMARKS_CODE")==null?"":(String) drugDetails.get("FOOD_INTERACTION_REMARKS_CODE");
			lab_interaction_remarks_code				= (String) drugDetails.get("LAB_INTERACTION_REMARKS_CODE")==null?"":(String) drugDetails.get("LAB_INTERACTION_REMARKS_CODE");
			//Added for IN073343 end
			
			//added for AAKH-CRF-0140 start
			if(drug_abuse_appl){ 
		    	
		   
		    	abuse_exists	= (String) drugDetails.get("ABUSE_EXISTS")==null?"N": (String) drugDetails.get("ABUSE_EXISTS");
					 abuse_restric_trn=(String) drugDetails.get("ABUSE_RESTRIC_TRN")==null?"N": (String) drugDetails.get("ABUSE_RESTRIC_TRN");
					  abuse_override =(String) drugDetails.get("ABUSE_OVERRIDE")==null?"": (String) drugDetails.get("ABUSE_OVERRIDE");
					  abuse_action=(String) drugDetails.get("ABUSE_ACTION")==null?"U": (String) drugDetails.get("ABUSE_ACTION");
					  abuse_override_remarks=(String) drugDetails.get("abuse_override_remarks")==null?"": (String) drugDetails.get("abuse_override_remarks");
					  System.out.println("abuse_restric_trn 821"+abuse_restric_trn);
		    }
		    else{
		    	abuse_exists	=	"N";// (String) drugDetails.get("ABUSE_EXISTS")==null?"N": (String) drugDetails.get("ABUSE_EXISTS");
				 abuse_restric_trn="N";// (String) drugDetails.get("ABUSE_RESTRIC_TRN")==null?"N": (String) drugDetails.get("ABUSE_RESTRIC_TRN");
				 abuse_remarks="";// (String) drugDetails.get("ABUSE_MSG_CONTENT")==null?"N": (String) drugDetails.get("ABUSE_MSG_CONTENT");
				  abuse_override ="";// (String) drugDetails.get("ABUSE_OVERRIDE")==null?"N": (String) drugDetails.get("ABUSE_OVERRIDE");
				  abuse_action="";// (String) drugDetails.get("ABUSE_OVERRIDE")==null?"N": (String) drugDetails.get("ABUSE_OVERRIDE");
				  abuse_override_remarks="";

		    }
			//added for AAKH-CRF-0140 end

			String overrided_yn = "Y";
			if(current_rx.equals("Y") && (((String)drugDetails.get("CURRENTRX_REMARKS"))==null || ((String)drugDetails.get("CURRENTRX_REMARKS")).equals("")))
				overrided_yn = "N";
			if(limit_ind.equals("N") && (((String)drugDetails.get("DOSE_REMARKS"))==null || ((String)drugDetails.get("DOSE_REMARKS")).equals("")))
				overrided_yn = "N";
			if(allergy_yn.equals("Y") && (((String)drugDetails.get("ALLERGY_REMARKS"))==null || ((String)drugDetails.get("ALLERGY_REMARKS")).equals("")))
				overrided_yn = "N";
			if(abuse_exists.equals("Y")&& abuse_action.equals("B") && (((String)drugDetails.get("abuse_override_remarks"))==null || ((String)drugDetails.get("abuse_override_remarks")).equals("")))
				overrided_yn = "N";

			drugDetails.put("OVERRIDED_YN",overrided_yn); 
			
			//		if(drugDetails.containsKey("Override_Check")) {

			//			Override_Check	=(String)drugDetails.get("Override_Check");
					if(drugDetails.containsKey("OVERRIDED_YN")) {
						overrided_yn = (String) drugDetails.get("OVERRIDED_YN");
			//			if(Override_Check.equals("Y") && overrided_yn.equals("Y")){
						if(overrided_yn.equals("Y")){
							Override_Checked="Checked";
							checkEnabled="disabled";
						}
						else{
							Override_Checked="";
							checkEnabled="";
						}
					} 

				interaction_exists			= (String) drugDetails.get("INTERACTION_EXISTS")==null?"N": (String) drugDetails.get("INTERACTION_EXISTS");
				intr_restric_trn			= (String) drugDetails.get("INTR_RESTRIC_TRN")==null?"N": (String) drugDetails.get("INTR_RESTRIC_TRN");
				if(intr_restric_trn.equals("Y")){
					alDrugIntrList = (ArrayList) drugDetails.get("INTERACTION_DTL");
					for(int intr=0; intr<(alDrugIntrList.size()-2); intr++){
						hmDrugInteractionDtl = (HashMap) alDrugIntrList.get(intr);
						if(((String)hmDrugInteractionDtl.get("restrict_transaction")).equals("Y"))
							intr_msg_content += (String)hmDrugInteractionDtl.get("intr_name")+", ";
					}
					intr_msg_content = intr_msg_content.substring(0, intr_msg_content.length()-1);
				}
%>
<!-- Parameters--End-->

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="prescription_detail_form" id="prescription_detail_form" >
<!-- Below table for CurrentRx details-->
<table border="0" width="100%" cellspacing="0" cellpadding="0">
	<tr>
		<td   width="15%">
			<input type="button" class="button" value='<fmt:message key="ePH.CurrentRx.label" bundle="${ph_labels}"/>' onClick="javascript:callActiveOrders('<%=patient_id%>','<%=encounter_id%>','','<%=patient_class%>');">
		</td>
		<td class="CURRTEXT"   width="85%">&nbsp;</td>
		<td class="label"   width="15%"><input type='button' class='button' onClick="showDrugProfile('<%=patient_id%>','Prescription')" value='<fmt:message key="Common.DrugProfile.label" bundle="${common_labels}"/>'></td>
	</tr>
</table>
<!--CurrentRx table ends-->

<!-- Prescription Writer Table starts-->
<table cellpadding=0 cellspacing=0 width="100%"   border="0">
	<th style="font-size:9"   colspan="7"><fmt:message key="ePH.DrugDetail.label" bundle="${ph_labels}"/></th>
	<tr>
		<td class="label" width='10%' ><fmt:message key="Common.Drug.label" bundle="${common_labels}"/> </td>
		<!-- Modified for TFS id:7345 start -->
		<%if(pre_alloc_appl_yn.equals("Y") && drug_search_by.equals("G")){ %>
		<td class="label"  colspan="6" ><input type="text" name="drug_name" id="drug_name" size="42"  maxlength="42" value="<%=drug_desc_new%>" readOnly>
		<%}else{ %>
		<td class="label"  colspan="6" ><input type="text" name="drug_name" id="drug_name" size="42"  maxlength="42" value="<%=drug_desc%>" readOnly>
		<%} %>
		<!-- Modified for TFS id:7345 end -->
			<input type="button" name="drug_search" id="drug_search" value="?" class="button"  onfocus="searchDrugName();" onClick="searchDrugName();" disabled>&nbsp;<img  src="../../eCommon/images/mandatory.gif"></img>
			<input type="hidden" name="drug_code" id="drug_code" value="<%=drug_code%>" >
			<input type="hidden" name="srl_no" id="srl_no" value="<%=srl_no%>" >&nbsp;
			<a href="javascript:showOverRideRemarks(document.prescription_detail_form);"  style="visibility:visible" id="dosage_limit"><fmt:message key="ePH.OverrideReason.label" bundle="${ph_labels}"/></a>&nbsp;&nbsp;<!-- added for IN073343 -->
			<input type="checkbox" class="label" value="<%=overrided_yn%>" style="visibility:hidden" name="override_remarks" <%=Override_Checked%> <%=checkEnabled%> onclick="checkOverRideRemarks(document.prescription_detail_form)"  >

<%			
			if(calling_mode.equals("amend")){
%>
				<a href="javascript:callOrderAmend('<%=ord_id%>','<%=ord_line_no%>');" id="drug_remarks" style="visibility:visible" title="Drug Remarks"><fmt:message key="ePH.DrugRemarks.label" bundle="${ph_labels}"/></a>
<%
			}
			else{
%>
				<a href="javascript:callOrder();" id="drug_remarks" style="visibility:visible" title="Drug Remarks"><fmt:message key="ePH.DrugRemarks.label" bundle="${ph_labels}"/></a>
<%
			}
%>
			<!-- //Added for Antibiotic Screen using Order Entry Format ICN 29904 Start-->	
				<img  src="../../eCommon/images/mandatory.gif" style='display:none;' id='DrugRemarksMandImg'>
				<input type='hidden' name='DrugRemarksMandatory' id='DrugRemarksMandatory' value='N'>
				<input type='hidden' name='DrugRemarksEntered' id='DrugRemarksEntered' value='<%=DrugRemarksEntered%>'>
			<!-- //Added for Antibiotic Screen using Order Entry Format ICN 29904 end-->	
			<input type="hidden" name="checkEnabled" id="checkEnabled" value="<%=checkEnabled%>" > 
			&nbsp;&nbsp;<a href="javascript:drugindication_remarks();" id="drug_ind_remarks" style="visibility:visible" title='<fmt:message key="ePH.DrugIndications.label" bundle="${ph_labels}"/>'><fmt:message key="ePH.DrugIndications.label" bundle="${ph_labels}"/></a>
		<%	 System.out.println("522");if(drug_indication_mdry.equals("Y")){//added for jd-crf-0220
								 %>	
								 &nbsp;<img  src="../../eCommon/images/mandatory.gif"></img>
								<%} %>
		</td>
	</tr>
	<tr>
		<td class="label" width='25%' colspan='2'><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/>
			&nbsp;&nbsp;<label id="trade_name" style="font-weight:bold;visibility:<%=trade_name_display%>" ><%=trade_name%></label>
			<input type="hidden" name="trade_code" id="trade_code" value="<%=trade_code%>">
			<input type="hidden" name="trade_name" id="trade_name" value="<%=trade_name%>">
		</td>

		<td class="label"  width='25%' ><fmt:message key="Common.Route.label" bundle="${common_labels}"/>
			&nbsp;&nbsp;<label id="route_desc" style="font-weight:bold;<%=route_color%>"><%=route_desc%></label>
			<input type="hidden" name="route_code" id="route_code" value="<%=route_code%>">
		</td>
		<td class="label"   width="30%" colspan='2'><fmt:message key="ePH.Form.label" bundle="${ph_labels}"/>
		    &nbsp;&nbsp;<label id="form_desc" style="font-weight:bold"><%=form_desc%></label>
			<input type="hidden" name="form_code" id="form_code" value="<%=form_code%>">
		</td>
		<td class="label" width='15%'  ><fmt:message key="Common.SlidingScale.label" bundle="${common_labels}"/>
			&nbsp;&nbsp;<input type="checkbox" name="chk_sliding_scale" id="chk_sliding_scale" value="E" checked onClick="loadNonSlidingScreen(this,'<%=calling_mode%>','<%=drug_code%>','<%=srl_no%>')" <%=sliding_scale_yn_status%>>
			</td>
		<td class="label"  ><a href="javascript:viewReasonforRequest('<%=order_id%>');" id="tdm_details" style="<%=display_tdm%>" style="font-size:9"title="TDM Result"><fmt:message key="ePH.TDM.label" bundle="${ph_labels}"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
		</td>
	</tr>
	<tr>
	<td class='label' colspan='2'>
<%
						if(MAR_app_yn.equals("Y")){
%>
							<fmt:message key="ePH.BuildMAR.label" bundle="${ph_labels}"/>&nbsp;
							<input type='checkbox' name='buildMAR_yn' id='buildMAR_yn' value='<%=buildMAR_yn%>' <%=buildMAR_checked%> <%=buildMAR_enable%> onclick='assignValue1(this);'>
<%
						}
						else{
%>
							<!-- &nbsp;<input type='hidden' name='buildMAR_yn' id='buildMAR_yn' value='N'> -->
							<fmt:message key="ePH.BuildMAR.label" bundle="${ph_labels}"/>&nbsp;
							<input type='checkbox' name='buildMAR_yn' id='buildMAR_yn' value='N' disabled>
<%
						}
%>
						</td>
						<!-- add this td and label for  SKR-CRF-0006[IN029561]-- start -->
						<td class='label'><label style='color:red;' id="actionTextval" ><%=actionText%>
						 </label></td>
						<!-- add this td and label for  SKR-CRF-0006[IN029561]-- end -->

<%						display_auth_rule = "visibility:hidden";

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
						<td class="label"  align='center' ><label id='lbl_splapprvl' style='<%=display_auth_rule%>;<%=color_auth_rule%>'><fmt:message key="ePH.splapproval.label" bundle="${ph_labels}"/></label></td>
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
						<td  class="label"><a href="javascript:viewReasonforRequest('<%=order_id%>');" id="tdm_details"  style="font-size:9;<%=display_tdm%>"  title="TDM Result"><fmt:message key="ePH.TDM.label" bundle="${ph_labels}"/> </a>&nbsp;</td>
					
				</tr>
			</table>
	<input type="hidden" value="<%=presBean_id%>" name="presBean_id">
	<input type="hidden" value="<%=presBean_name %>" name="presBean_name">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" value="<%=ext_prod_id%>" name="ext_prod_id">
	<input type="hidden" value="<%=patient_id%>" name="patient_id">
	<input type="hidden" value="<%=encounter_id%>" name="encounter_id">
	<input type="hidden" value="<%=generic_id%>" name="generic_id">
	<input type="hidden" value="<%=generic_name%>" name="generic_name">
	<input type="hidden" value="<%=allergy_yn%>" name="allergy_yn">
	<input type="hidden" value="<%=limit_ind%>" name="limit_ind">
	<input type="hidden" value="<%=current_rx%>" name="current_rx">
	<input type="hidden" value="<%=mono_graph%>" name="mono_graph">
	<input type="hidden" value="<%=mono_graph%>" name="monograph">	
	<input type="hidden" value="<%=unit_dose%>" name="unit_dose">
	<input type="hidden" value="<%=daily_dose%>" name="daily_dose">
	<input type="hidden" value="<%=min_daily_dose%>" name="min_daily_dose">
	<input type="hidden" value="<%=min_unit_dose%>" name="min_unit_dose">	
	<input type="hidden" name="dosage_std" id="dosage_std" value="<%=dosage_std%>">
	<input type="hidden" name="dosage_unit" id="dosage_unit" value="<%=dosage_unit%>">		
	<input type="hidden" value="<%=calling_mode%>" name="calling_mode">
	<input type="hidden" value="<%=order_type_code%>" name="order_type_code">
	<input type="hidden" name="allow_duplicate" id="allow_duplicate" value="<%=allow_duplicate%>">
	<input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>">
	<input type="hidden" name="take_home" id="take_home" value="<%=take_home%>">
	<input type="hidden" name="freq_nature" id="freq_nature" value="<%=freq_nature%>">
	<input type="hidden" name="qty_unit" id="qty_unit" value="<%=qty_unit%>">
	<input type="hidden" name="sliding_scale_yn" id="sliding_scale_yn" value="Y"> <%/*=sliding_scale_yn*/%> <!-- hardcoded sliding_scale_yn to Y to avoid script error when click on left pad for sldingscale drug and confirm/release -->
	<input type="hidden" name="ord_set_reqd_or_opt" id="ord_set_reqd_or_opt" value="<%=ord_set_reqd_or_opt%>">	
	<input type="hidden" value="<%=dsg_reason%>" name="dsg_reason">
	<input type="hidden" value="<%=dup_reason%>" name="dup_reason">
	<input type="hidden" value="<%=con_reason%>" name="con_reason">
	<input type="hidden" value="<%=int_reason%>" name="int_reason">
	<input type="hidden" value="<%=alg_reason%>" name="alg_reason">
	<input type="hidden" value="<%=force_auth_yn%>" name="force_auth_yn">
	<input type="hidden" value="<%=amend_yn%>" name="amend_yn">
	<input type="hidden" value="<%=overrided_yn%>" name="overrided_yn">
	<input type="hidden" value="<%=dose_override%>" name="dose_override">
	<input type="hidden" name="DrugIndicationRemarks" id="DrugIndicationRemarks" value="<%=DrugIndicationRemarks%>"><!--Added for  ML-BRU-CRF-072[Inc:29938] -->
	<input type='hidden' name='totalTaperQtyDisplay' id='totalTaperQtyDisplay' value='N'>
	<input type="hidden" name="intr_restric_trn" id="intr_restric_trn" value="<%=intr_restric_trn%>"><!--Added for  RUT-CRF-0066 -->
	<input type="hidden" name="intr_msg_content" id="intr_msg_content" value="<%=intr_msg_content%>"><!--Added for  RUT-CRF-0066 -->
	<input type="hidden" name="interaction_exists" id="interaction_exists" value="<%=interaction_exists%>"><!--Added for  RUT-CRF-0066 -->
	<input type="hidden" name="order_id_copy" id="order_id_copy" value=""><!--Added for ARYU-SCF-0033-->
    <input type="hidden" name="order_line_no_copy" id="order_line_no_copy" value=""><!--Added for ARYU-SCF-0033--> 
    <!-- ADDED FOR IN073343  start-->
    <input type="hidden" value="<%=max_daily_ceeling_dose%>" name="max_daily_ceeling_dose"> 
       <input type="hidden" value="<%=min_daily_ceeling_dose%>" name="min_daily_ceeling_dose">
       <input type="hidden" value="<%=max_unit_ceeling_dose%>" name="max_unit_ceeling_dose">
       <input type="hidden" value="<%=min_unit_ceeling_dose%>" name="min_unit_ceeling_dose">
       <input type="hidden" value="<%=allergy_remarks_code%>" name="allergy_remarks_code">
       <input type="hidden" value="<%=dose_remarks_code%>" name="dose_remarks_code">
       <input type="hidden" value="<%=currentrx_remarks_code%>" name="currentrx_remarks_code">
       <input type="hidden" value="<%=interaction_remarks_code%>" name="interaction_remarks_code">
       <input type="hidden" value="<%=food_interaction_remarks_code%>" name="food_interaction_remarks_code">
         <input type="hidden" value="<%=lab_interaction_remarks_code%>" name="lab_interaction_remarks_code">
	 <!-- ADDED FOR IN073343  start-->
	  <input type="hidden" value="<%=validate_overide_on_confirm_yn%>" name="validate_overide_on_confirm_yn"><!-- Added for IN:069887  -->
      <input type="hidden" name="abuse_action" id="abuse_action" value="<%=abuse_action%>"><!-- Added for AAKH-CRF-140 -->
		<input type="hidden" name="abuse_override" id="abuse_override" value="<%=abuse_override%>"><!-- Added for AAKH-CRF-140 -->
		<input type="hidden" name="abuse_exists" id="abuse_exists" value="<%=abuse_exists%>"><!-- Added for AAKH-CRF-140 -->
		<input type="hidden" name="abuse_remarks" id="abuse_remarks" value="<%=abuse_remarks%>"><!-- Added for AAKH-CRF-140 -->
		<input type="hidden" name="abuse_override_remarks" id="abuse_override_remarks" value="<%=abuse_override_remarks%>"><!-- Added for AAKH-CRF-140 -->
		<input type="hidden" name="abuse_restric_trn" id="abuse_restric_trn" value="<%=abuse_restric_trn%>"><!-- added for aakh-crf-0140 -->
		<input type="hidden" name="drug_indication_mdry" id="drug_indication_mdry" value="<%=drug_indication_mdry%>"><!-- added for jd-crf-0220 -->
		
		   
</form>
</body>
<script>
<%		// To Display reason button 
	//if(((drug_db_interface_yn != null && !drug_db_interface_yn.equals("Y")) || (ext_prod_id != null && ext_prod_id.equals(""))) && ((allergy_yn != null && allergy_yn.equals("Y")) || (current_rx != null && current_rx.equals("Y"))) ){

		if(((allergy_yn != null && allergy_yn.equals("Y"))
 || current_rx.equals("Y") ||
 interaction_exists.equals("Y") 
 || (abuse_exists.equals("Y") && abuse_action.equals("B")))
 && (ext_prod_id== null  ||  ext_prod_id.equals("") 
 || !drug_db_interface_yn.equals("Y")|| drug_db_duptherapy_yn.equals("N")) ) {//Added for Duplicate button issue
	  System.out.println(abuse_exists+"672");
%>
			document.prescription_detail_form.dosage_limit.style.visibility="visible";
			document.prescription_detail_form.override_remarks.style.visibility="visible";
<%
		}
%>
		getFormatId();
 <%
 if(!(((allergy_yn != null && allergy_yn.equals("Y")) 
		 || current_rx.equals("Y") ||
		  (abuse_exists.equals("Y") && abuse_action.equals("B"))|| 
		  interaction_exists.equals("Y")) && (ext_prod_id== null  ||
		  ext_prod_id.equals("") || !drug_db_interface_yn.equals("Y")|| 
		  drug_db_duptherapy_yn.equals("N")))){
		  	System.out.println(abuse_exists+"682");
 %>
			document.prescription_detail_form.dosage_limit.style.visibility="hidden";	
			document.prescription_detail_form.override_remarks.style.visibility="hidden";
<%
		}
		if((drug_db_interface_yn != null &&!drug_db_interface_yn.equals("Y")) || (ext_prod_id.equals(""))){
			if((amend_yn==null || !amend_yn.equals("Y") ) && interaction_exists.equals("Y") && intr_restric_trn.equals("Y")){
				%>	//out.println("alertIntr('"+drug_desc+"','"+intr_msg_content+"' );");
				out.println("alertIntr('"+drug_code+"','"+srl_no+"','"+patient_id+"','"+encounter_id+"','N' );");
				<%			}
			
			if((amend_yn==null || !amend_yn.equals("Y")) && (abuse_exists.equals("Y") && abuse_action.equals("B"))){
				System.out.println("2810abuse_exists"+abuse_exists+"abuse_action"+abuse_action);
					%>
					
						alertAbuse('<%=drug_code%>','<%=srl_no%>', '<%=patient_id%>','<%=encounter_id%>','N');
					
		<%	
				}
		
		}
		//added for Bru-HIMS-CRF-0265 [IN032315] -- begin 
		if(profile_count>=1 && ((bean.getExternalpatient_id()==null) || (bean.getExternalpatient_id().equals("") )) && current_rx.equals("Y") && bean.getCancelDiscConDupOrders().equals("Y") ){ 
%>
			parent.parent.f_button.document.forms[0].btnDiscOrders.style.display = "inline";
			callDiscCancelOrders('<%=patient_id%>','<%=encounter_id%>','<%=generic_id%>','<%=start_date%>','<%=end_date%>','<%=freq_code%>','<%=drug_code%>','<%=srlNo%>','<%=drug_db_interface_yn%>','<%=ext_prod_id%>','','Y');	 
<%
		}
		else{
%>			if(parent.parent.f_button.document.forms[0].btnDiscOrders!=undefined) //TBMC-SCF-0166
			parent.parent.f_button.document.forms[0].btnDiscOrders.style.display = "none";
<%
		}
		//added for Bru-HIMS-CRF-0265 [IN032315] -- end 
		putObjectInBean(bean_id,bean,request); 
		putObjectInBean(presBean_id,presBean,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>
	</script>
</html>

