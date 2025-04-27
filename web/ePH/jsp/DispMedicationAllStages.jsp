<!DOCTYPE html>
<!-- 
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description 
--------------------------------------------------------------------------------------------------------------
?				100					?           created
04/19/2017	MMS-DM-SCF-0417   Manickavasagam	Allocated Quantity is showing wrong when the batch gets expired before Allocated days
04/19/2017	BSP-SCF-0041	  Mukesh		Allocated Quantity is showing wrong when the batch gets expired before Allocated days		
05/12/2017	[IN:064158]	  Devindra		Change in barcode scanning functionality in Dispense Medication(in each scan one quantity need to add).	
05/07/2019  [IN:067952]     Devindra             MMS-KH-CRF-0013 [IN:067952] 	
13/08/2019      IN070451		 Manickavasagam J						ML-MMOH-CRF-1408
13/08/2019      IN070605		 Devindra           MMS-KH-CRF-0028 
09/08/2019      IN070605		 prathyusha  MMS-KH-CRF-0028
26/08/2019      IN071102		 Manickavasagam J						MMS-KH-SCF-0035
30/08/2019	  	IN070894	     	Devindra 		  					ML-MMOH-SCF-1318(RF)
04/09/2019	  	IN070605	     	prathyusha 		  									 MMS-KH-CRF-0028 
10/09/2019	  	IN070605	     	prathyusha 		  									 MMS-KH-CRF-0028  
29/10/2019		IN071533			Shazana				SKR-SCF-1275
1/10/2019		IN071555			Shazana				MMS-ME-SCF-0008
30/11/2019		IN070606                Manickavasagam J                       MMS-KH-CRF-0029[IN070606]
29/05/2020		IN:072092	        Manickavasagam J			     GHL-CRF-0618
25/06/2020		IN:072409	        Manickavasagam J			     MMS-CRF-0030	 
15/09/2020		IN:073856	        Manickavasagam J			     SKR-SCF-1423	
12/10/2020      IN073397            Prabha     12/10/2020     Manickavasagam J          MOHE-CRF-0032
03/11/2020		IN:074297	        Manickavasagam J			     GHL-SCF-1527
30/11/2020		8659			Shazana					     MMS-MD-SCF-0141 	
23/04/2021      TFS-17291         Prabha		 23/04/2021     Manickavasagam J          SKR-SCF-1593
7/7/2021		TFS:9495	Shazana					MOHE-CRF-0026.1
31/12/2021		TFS-6900		   Prabha			MOHE-CRF-0040
--------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8"import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.text.DecimalFormat,eST.*,eST.Common.*,java.sql.Connection,webbeans.eCommon.ConnectionManager,eXH.*,eCommon.XSSRequestWrapper" %><!-- java.sql.Connection,webbeans.eCommon.ConnectionManager added for ML-BRU-0469 -->
<%-- JSP Page specific attributes end --%>
 
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
	<head>
<%	
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../ePH/js/DispMedicationAllStages.js"></script>
		<script language="JavaScript" src="../../ePH/js/DispMedication.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eXH/js/ExternalApplication.js"></script>  
		<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  
		<script>
		function CheckPatReqd(Obj){
			if(Obj.checked==true)
				Obj.value="C";
			else
			Obj.value="N";
		}
		</script>
	</head>
	<body onMouseDown="" onKeyDown="lockKey()">
<script>//Adding start for TH-KW-CRF-0008
			window.onload = function(){
				window.setInterval("blinkImage()",500);
				window.setInterval("blinkPatExp()",500);
			}
</script><!-- Adding end for TH-KW-CRF-0008 -->

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
	</style>  <!-- Added for MMS-KH-CRF-0013 - End -->
		<form name="DispMedicationAllStages" id="DispMedicationAllStages" >
<%			try{
			String patient_id						= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
			String encounter_id						= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
			String order_id							= request.getParameter("order_id")==null?"":request.getParameter("order_id");
			String pract_id							= request.getParameter("practitioner_id")==null?"":request.getParameter("practitioner_id");
			String pract_name						= request.getParameter("practitioner_name")==null?"":request.getParameter("practitioner_name");
			String filling_status					=	"";
			String check_status						=	"";
			String filling_reqd						=	"";
			String delivery_reqd					=	"";
			String stage							=	"";
			String display_seq						=	"";
			String allocation_reqd					=	"";
			String filling_det						=	"";
			String del_data							=	"";
			String ext_prod_id						=	"";
			String order_line_no					=	"";
			String drug_code						=	"";
			String drug_name						=	"";
			String dosage_dtls						=	"";
			String end_date							=	"";
			String pres_qty							=	"";
			String qty_uom							=	"";
			String qty_uom_disp						=	"";
			String alt_drug_code					=	"";
			String alt_drug_desc					=	"", alt_drug_desc_1="";
			String drug_color						=	"";
			String form_code						=	"";
			String form_desc                        =   ""; // Added for MMS-KH-CRF-0013
			String start_date						=	""; // Added for MMS-KH-CRF-0013
			String hold_status						=	"";
			String remark_status					=	"";
			String uom								=	"";
			String del_style						=	"";
			String hold_text						=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Hold.label","ph_labels");
			String check_value						=	"N";
			String fromdb							=	"N";
			String allergy							=	"";
			String exceed_dose						=	"";
			String generic_id						=	"";
			String generic_name						=	"";
			String dosage_details					=	"";
			String exceed_status					=	"";
			String monograph						=	"";
			String unit_dose						=	"";
			String daily_dose						=	"";
			String bms_qty							=	"";
			String allocate_button					=	"";
			String filling_button					=	"";
			String alloc_empty_det					=	"";
			String alloc_det						=	"";
			String source_code						=	"";
			String source_type						=	"";
			String ordering_facility_id				=	"";
			String ord_date_time					=	"";
			String performing_pract_id				=	"";
			String filling_empty_det				=	"";
			String alt_drug_qty						=	"";
			String duplicate_yn						=	"";
			String min_dose_dtls					=	"";
			String min_unit_dose					=	"";
			String min_daily_dose					=	"";
			ArrayList stock_opt						=	new ArrayList();
			String hold_value						=	"";
			String alloc_qty_from_tmp				=	"";
			String strength_value					=	"";
			String strength_uom						=	"";
			int		tot_qty							=	0;
			String classvalue						=	"";
			String pres_strength					=	"";
			String alt_strength_value				=	"";
			String alloc_strength					=	"";
			String bms_strength						=	"";
			String in_formulary_yn					=	"";
			String drug_class						=	"";
			String tmp_bms_qty						=	"";
			String title							=	"";
			String narc_style						=	"";
			String pat_couns_reqd_yn				=   "";
			int bmscount							=    0;
			String  scope							=   "";
			String legend1                          =   "";  
			String legend_text                      =   "";
			String disable_complete_order			=	"";
			String strChangedFludRmks				=	"";
			String pat_reqd							=	"";
			String pt_couns_reqd_yn					=	"";	
			String dosage_type						=   "";
			String dosage_unit						=   "";
			String std_dose                         =   "";
			String drug_remarks						=	"";
			String prn_remarks						=	"";
			String pharma_remarks					=	"";		
			String pres_remarks						=	"";
			String remarks_style					=	"";
			String slidingscaleremarks				=   "";
			String verificationremarks				=	"";
			String title_remarks					=	"";
			String pres_details						=	"";
			String drug_verf_reqd_yn				=	"N";
			String order_line_status				=	"";
			String	pres_strength_1					=   "";//MMS-KH-CRF-0030
			String drug_style						=	"";
			String alt_external_prod_id				=   "";
			String expired_yn			            =	"";
			String tmp_bms_qty_1					=	"";
			String alt_drug							=	"";
			String qty								=	null;
			String main_strength_per_value_pres_uom =   "";
			String sDispDrugAuthYN				= "N";
			String home_med_yn = null;//Added for Bru-HIMS-CRF-093-DD1[IN047223]
			String barcode_id = "";//Added for KDAH-CRF-0231 [IN-034551] 
			String drug_desc = "";//Added for Bru-HIMS-CRF-414 ML-BRU-SCF-1454 [IN:052271]
			String disc_cancelled_orders="", appl_for_compounding_rx_yn="",disc_cancelled_orders_display="display:none;", disp_mnf_flag	= "display:none"; //Added for HSA-CRF-0138 [IN:048414] & Bru-HIMS-CRF-080
			String medical_applicable="";//added for ghl-crf-0548
			String iv_prep_yn  =  ""; //GHL-CRF-549
		/*==================code for variable UOM==============================*/
			HashMap IssueUOMAndBaseUOM     = new HashMap();
			HashMap IssueUomQty			   = new HashMap();
			HashMap hmEditLabelValues      = new HashMap();
			ArrayList alEditLabelPair	   = new ArrayList();
			String drug_expiry_alert ="";//Added for TH-Kw-CRF-0008
			String drug_expiry_days  = "";//Added for TH-KW-CRF-0008
			String insurance_status ="";//Added for TH-KW-CRF-0012

			String issue_qty_value		   = "";	  
			String issue_uom_desc          = ""; 
			String dflt_issue_uom		   = "";
			String base_uom				   = "";
			String issue_uom			   = "";
			String issue_uom_equl          = "";
			String strength_uom_disp        = "";
			double base_to_disp_uom_equl   = 0;
			double base_to_def_uom_equl    = 1;
			double issue_qty_val		   = 0;
			double conv_factor			   = 1;
			StringBuffer issue_qty_dtl     = new StringBuffer();

		/*=====================================================================*/
			StringTokenizer		token				=	null;
			ArrayList disp_info						=	new ArrayList(2);
			float dialog_height						=	0;	
			float main_pack_size					=   0;
			float		main_drug_pack_size			=	0;	
			int recCount							=	1;
			double tmp_alloc						=	0;
			HashMap drug_detail						=	null;
			ArrayList multi_detail					=	null;
			ArrayList main_detail					=	null;
			HashMap   alt_detail					=	null;
			ArrayList alt_drug_detail				=	null;
			ArrayList multi_drugs					=	null;
			HashMap hm								=	null;
			ArrayList alt_qty						=	null;
			ArrayList	colors						=	new ArrayList();
			ArrayList tmp							=	null;
			HashMap pack_dtls						=	null;
			float tot_tap=0; //Added for RUT-CRF-0088 [IN036978]
			String currentdateplusAllocatePeriod		=  	"";			//added by Ganga for ML-BRU-SCF-0905 [IN:041285]
			boolean	endDateIsbeforAllocatedate			= 	false;//added by Ganga for ML-BRU-SCF-0905 [IN:041285]


			colors.add("#FF0000");
			colors.add("#669900");
			colors.add("#FF9966");
			colors.add("#6699CC");
			colors.add("#FF0000");
			colors.add("#669900");

			ArrayList result		=	null;
			ArrayList orderLineDtls	=	new ArrayList();
		//Declaration ends
		// the below code moved to down for MMS-KH-CRF-0034.4
            /*String bean_id2					= "@PrescriptionBean_1"+patient_id+encounter_id; // Added for MMS-KH-CRF-0013 - Start
            String bean_name2		= "ePH.PrescriptionBean_1"; 
            PrescriptionBean_1 pres_bean =  (PrescriptionBean_1)getBeanObject( bean_id2,bean_name2,request) ;
            pres_bean.setLanguageId(locale); // Added for MMS-KH-CRF-0013 - End
           */  
			String	bean_id						=	"DispMedicationAllStages" ;
			String	bean_name					=	"ePH.DispMedicationAllStages";
			DispMedicationAllStages bean		= (DispMedicationAllStages)getBeanObject( bean_id, bean_name,request);
			bean.setLanguageId(locale);
			
			String	bean_id_1					=	"DispMedicationBean" ;
			String	bean_name_1					=	"ePH.DispMedicationBean";
			DispMedicationBean bean_1			= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1,request);
			bean_1.setLanguageId(locale);

			encounter_id			= bean_1.getEncounterID();//added for MMS-KH-CRF-0034.4
		        String bean_id2					= "@PrescriptionBean_1"+patient_id+encounter_id; // Added for MMS-KH-CRF-0013 - Start
            		String bean_name2		= "ePH.PrescriptionBean_1"; 
            		PrescriptionBean_1 pres_bean =  (PrescriptionBean_1)getBeanObject( bean_id2,bean_name2,request) ;
            		pres_bean.setLanguageId(locale); // Added for MMS-KH-CRF-0013 - End


			String disp_stage					=	bean_1.getDispStage();
			String facility_id					= (String) session.getValue("facility_id");
			String param_bean_id				= "@DrugInterfaceControlBean";
			String param_bean_name				= "ePH.DrugInterfaceControlBean";
			DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
			String drug_db_interface_yn			= param_bean.getDrugDBInterface_yn(facility_id); 
			param_bean.clear();

			String Image_bean_id				= "@DrugTradeImageBean";
			String Image_bean_name				= "ePH.DrugTradeImageBean";
			DrugTradeImageBean drug_trade_bean	= (DrugTradeImageBean)getBeanObject( Image_bean_id, Image_bean_name, request );
			ArrayList listRecord				= new ArrayList();  // Added for KAUH-SCF-0094 [IN:035252] -- begin
			String	bean_id_st		   			= "batchSearchBean" ;
			String	bean_name_st		   		= "eST.BatchSearchBean"; 
			
			String stSalseBean_id				=    "salesBean";//Added for AMS-CRF-0068.1 [IN:050333] start
			String stSalseBean_name			    =    "eST.SalesBean";
			SalesBean stSalseBean				=	(SalesBean)getBeanObject( "salesBean", "eST.SalesBean", request );//Added for AMS-CRF-0068.1 [IN:050333] -end
			String medplan_bean_id="MedicationPlannerBean";// Added for Bru-HIMS-CRF-072.1[IN 049144]
			String medplan_bean_name="ePH.MedicationPlannerBean";// Added for Bru-HIMS-CRF-072.1[IN 049144]
			MedicationPlannerBean medplan_bean = (MedicationPlannerBean)getBeanObject( medplan_bean_id, medplan_bean_name,request);// Added for Bru-HIMS-CRF-072.1[IN 049144]
			bean.setObject(medplan_bean);// Added for Bru-HIMS-CRF-072.1[IN 049144]
			bean_1.setObject(medplan_bean);// Added for Bru-HIMS-CRF-072.1[IN 049144]
			String primary_lang_id = medplan_bean.getStrPrimaryLangID();//Added for Bru-HIMS-CRF-072.1[IN 049144]
			String loc_lang_id = medplan_bean.getStrLocalLangID();//Added for Bru-HIMS-CRF-072.1[IN 049144]
			request.setAttribute("p_list_all_trades_yn","Y");
			BatchSearchBean bean_st				= (BatchSearchBean) getBeanObject( bean_id_st,bean_name_st,request );
			bean_st.setLanguageId(locale); 		// Added for KAUH-SCF-0094 [IN:035252] -- end
			String alt_drug_remarks_ind =bean_1.getAltDrugRemarksInd(); //added for  Bru-HIMS-CRF-082 [IN:029948]
			String alt_drug_remarks_disp = ""; //added for  Bru-HIMS-CRF-082 [IN:029948]
			HashMap taperValues = null; //Added for RUT-CRF-0088 [IN036978]
			String totalTaperQtyDisplay = bean_1.getTotalTaperQtyDisplay();//Added for RUT-CRF-0088 [IN036978]
			String includeBMSDefCheck_yn= bean_1.getIncludeBMSDefCheck();//added for [IN:045055](Bru-HIMS-CRF-281[IN:033166])
			int count=0;
			String strIncludeZeroQty    = bean_1.getStrIncludeZeroAllocQtyItems();//Added for MO-GN-5434 [IN:043669]
			String allow_amend_alt_drug_dtl     =   bean_1.getAmendAltDrugDtlYN();  // Added for JD-CRF-0198 [IN058599]
			String strAllocBMSChkValue = "N";//Added for MO-GN-5434 [IN:043669]
			String strAllocBMSChecked = "";//Added for MO-GN-5434 [IN:043669]		
		    String showZeroQtyCheckBox = "";
			String showOtherEditLables = "";
			String strAutoCompletePartialDisp	= 	bean_1.getAutoCompletePartialDisp(); 	// Added for JD-CRF-0179 [IN:41211]
			/** Stock Bean Integration -Start ***/
			String	bean_id_2		=	"StUtilities" ;
			String	bean_name_2		=	"eST.Common.StUtilities";
			StUtilities bean_2=null;
			StringBuffer drugs_remarks  = null ;//Bru-HIMS-CRF-416[IN045566] 
			String strDrugsRemarks="";//Bru-HIMS-CRF-416[IN045566] 
			// Added for ML-BRU-CRF-0469 [IN:065426] - start
			Connection con=null;
			boolean displayGrossAmtYn           = false;
			boolean item_type_site_app          = false; //GHL-CRF-549
			boolean intractn_req_yn = false;	// Added for MMS-KH-CRF-0013
			boolean approval_no_flag = false;//AAKH-CRF-0117
			boolean formulary_billing_app = false;//GHL-CRF-0618
			boolean barcode_scan_for_alt_app = false; //MMS-KH-CRF-0030
			boolean expired_order = false; //added for MOHE-CRF-0032
			boolean iqvia_integration_flag = false;  //MOHE-CRF-0026.1  start
			boolean drug_abuse_appl=false;//added for aakh-crf-0140
			HashMap insuranceStatus = bean.getInsuranceStatus();//Added for TH-KW-CRF-0012
			boolean aggred_item_app =false;//eCommon.Common.CommonBean.isSiteSpecific(con, "PH", "AGGRED_ITEM_APP");//added for MMS-DM-CRF-0209.1
     boolean site_remarks=false;//added for ml-mmoh-crf-1755
	  String strDosageDtls	=	""; 
			 String qtyValue = "";
		        String qtyUnit = "";  
		        String durnValue ="";
		        String durationType =""; 
		        String frequencyCode ="";
		        String repeatValue ="";
		        String routeCode = ""; 
				String dispTmpNo= "";				
				bean_1.setIqviaDispData(null);
				bean_1.setIqviaAuthStatusDispData(null); 
				bean_1.setIqviaAfterDispenseData(null);   
				java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;  
				String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
				String added_by_id			= prop.getProperty("login_user");
				String disp_data = "";  
				String authStatus_disp_data = ""; 
				String postDisp_disp_data = ""; 
				String claimId = ""; 
				String claimIdNo = ""; 
				String response_code = "";
				String responseStatus = ""; 
				String authReqSent = ""; 
				String alloc_qty_check = ""; 
				String postAuthStatusData = ""; 
				String authStatusCompleted_yn = ""; 
				String settlement_id = "";
				settlement_id= bean_1.getSettlementId() ;
				String itemCost = ""; //MOHE-CRF-0026.1 end   
				
			//System.out.println("getSettlement_id: "+bean_1.getSettlement_id());     
			try{
				con = ConnectionManager.getConnection(request);
				displayGrossAmtYn = CommonBean.isSiteSpecific(con, "PH", "GROSS_AMT_DISPLY_YN");
				item_type_site_app = eCommon.Common.CommonBean.isSiteSpecific(con, "PH", "ITEM_TYPE_APP");//added for GHL-CRF-0549
				
				formulary_billing_app = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","FORMULARY_BLG_GRP_APP"); //GHL-CRF-0618
				intractn_req_yn = CommonBean.isSiteSpecific(con, "PH","DISP_STAGE_INTRACTN_REQ_YN");	
				// Added for MMS-KH-CRF-0013 same variable used for MMS-KH-CRF-0028 [IN070605] 			        
				  approval_no_flag = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","APPROVAL_NO_APPLICABLE_FLAG");//AAKH-CRF-0117
				  barcode_scan_for_alt_app = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","BARCODE_SCAN_FOR_ALT_APP"); //MMS-KH-CRF-0030
					 expired_order = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","EXPIRY_ORDER_APP"); //Added for MOHE-CRF-0032
					 iqvia_integration_flag = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","IQVIA_INTEGRATION");//MOHE-CRF-0026.1   
					  drug_abuse_appl=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DRUG_ABUSE_APPL");//added for AAKH-CRF-0140
					aggred_item_app = eCommon.Common.CommonBean.isSiteSpecific(con, "PH", "AGGRED_ITEM_APP");//added for MMS-DM-CRF-0209.1
					 site_remarks=eCommon.Common.CommonBean.isSiteSpecific(con, "PH", "DISP_REMARKS");//added for ML-MMOH-CRF-1755
						
          	if(iqvia_integration_flag){
							bean_1.setIqvia_integration_yn("Y");
						}else{
							bean_1.setIqvia_integration_yn("N");  
						}//END 		 
 

			}
			catch(Exception e){
				e.printStackTrace();
				displayGrossAmtYn = false;
			}
			finally{
				ConnectionManager.returnConnection(con,request);
			}  
			// Added for ML-BRU-CRF-0469 [IN:065426] - End
			try { 
				bean_2 = (StUtilities) getBeanObject( bean_id_2,  bean_name_2, request );
				bean_2.setLanguageId(locale);
			}
			catch (Exception exception) {
				exception.printStackTrace();
			}
			String st_no_of_decimals ="",  st_disp_decimal_dtls_yn="", st_allow_decimals_yn="N"; //Added for AAKH-SCF-0113 [IN:048937] start
			st_no_of_decimals = bean.getSt_no_of_decimals();
			st_disp_decimal_dtls_yn =bean.getSt_disp_decimal_dtls_yn(); // Added for AAKH-SCF-0113 [IN:048937] -end

			String disp_locn_catg	=	bean_1.getDispLocnCatg();
			String patient_class	=	"";
			int adr_count			=   0;
			ArrayList	stk_units	=	new ArrayList();
			String orig_dflt_issue_uom		= "";
			
			//added for AAKH-CRF-0117 - start
			String approval_no_app_for_patient_class = "N";
			String approval_no_style = "visibility:hidden"; //AAKH-CRF-0117
			if(approval_no_flag){
			   approval_no_app_for_patient_class = bean.getApprovalNoApplicableForPatientClass("OP");
			}
			//added for AAKH-CRF-0117 - end


			/*if(disp_locn_catg.equals("I")) {
				patient_class	=	"IP";
			} else {
				patient_class	=	"OP";
			}*/
			bean.loadReason();
			bean.setModuleId("2");
			bean.setPractitionerID(pract_id);
			bean.setPractitionerName(pract_name);
			
			String module_id			=	bean.getModuleId();
			Hashtable param_legends		=	bean_1.getLegendsFromParam();
			//String issue_token			=	bean_1.getIssueTokenOnRegnYN();
			String stages				=	bean_1.getStageDisplaySequence();
			String curr_stage			=	bean_1.getDispStage();
			String disp_level			=	bean_1.getDispLevelValue();
			String order_type			=   bean_1.getOrderType();
			ArrayList	delivery_det	=	bean_1.getDeliveryDetails();
			String Disp_drug_verify_remarks  =bean_1.getDisp_drug_verify_remarks_yn();//added for ml-mmoh-crf-1755
			String legend               =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.CompleteOrderReason.label","ph_labels"); //"Complete Order Reason";
				   scope				=	bean_1.getScope();
			String visibility1          =   "visibility:hiiden";
			String visibility2          =   "visibility:hiiden";
			if(scope.equals("H")){
				legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ResultLineStatus.label","ph_labels");//"ResultLineStatus";
				visibility2          =   "visibility:hiiden";
				visibility1          =   "visibility:visible";
			}
			else{
				visibility1          =   "visibility:hiiden";
				visibility2          =   "visibility:visible";
			}

			if(delivery_det!=null && delivery_det.size() > 1) {
				//butt_status			=	"disabled";
				del_data			=	"found";
			}

			token = new StringTokenizer(stages,":");
			while(token.hasMoreTokens()){
				stage	=	(String)token.nextToken();
				if( stage.equals("F")) 
					filling_reqd = "Y";
				else if( stage.equals("D")) 
					delivery_reqd = "Y";
				else if( stage.equals("A")) 
					allocation_reqd = "Y";
				//else if( stage.equals("V")) 
					//verification_reqd = "Y";
			}

			filling_status				=	bean_1.getFillingStatus();
			if(filling_status.equals("A")) 
				display_seq	=	"A";
			else if(filling_status.equals("B"))
				display_seq	=	"F";

			ArrayList alOrderIds = new ArrayList();
			ArrayList tmpResult = new ArrayList();

			if(bean_1.getAlTrxOrderIds()!=null){
				alOrderIds = bean_1.getAlTrxOrderIds();
				if(alOrderIds != null && alOrderIds.size()>0){ //if condition added for GHL-CRF-549
					iv_prep_yn		=   bean.getIVFlag(alOrderIds.get(0).toString());
					iv_prep_yn		=	iv_prep_yn==null?"":iv_prep_yn;
				}
			}
			//added for ML-BRU-SCF-2049 - start
					String issue_token_on_regn_YN = bean_1.getIssueTokenOnRegnYN();
					if(issue_token_on_regn_YN!=null && issue_token_on_regn_YN.equals("Y")){
					     bean_1.getOrderlingFacilityID(patient_id.trim());
					}
			//added for ML-BRU-SCF-2049 - end 
			if(disp_level.equals("P")){
				//order lines of all orders
				result			=	bean_1.getOrders(patient_id.trim());
				if(bean_1.getCriteriaOrderType()!=null && (bean_1.getCriteriaOrderType().equals("ALL") || bean_1.getCriteriaOrderType().equals("CDR"))){ // CDR Condition Added for ML-MMOH-CRF-0435 [IN:057357]
					if(alOrderIds.size()>0)	{
						for(int i=0;i<result.size();i=i+11) {		//10 ->11 for SKR-SCF-0330 ICN 29789 //11->13 RUT-CRF-0069 ICN29607  // //Modified for RUT-CRF-0088 [IN036978]  13 -> 11
							if(alOrderIds.contains(result.get(i+1))){
								for(int j=i;j< i+11;j++)	//10 ->11 for SKR-SCF-0330 ICN 29789 //11->13 RUT-CRF-0069 ICN29607
									tmpResult.add(result.get(j));
							}
						}
					}
					result = tmpResult;
				}

				tmp				=	new ArrayList();
				
				for(int i=0;i<result.size();i=i+11){		//10 ->11 for SKR-SCF-0330 ICN 29789 //11->13 RUT-CRF-0069 ICN29607  //Modified for RUT-CRF-0088 [IN036978]  13 -> 11
					tmp = (ArrayList)bean_1.getOrderLineDetails(patient_id,(String)result.get(i+1));
					if(tmp.size()!=0){
						orderLineDtls.add((String)result.get(i+1));
						orderLineDtls.add((String)result.get(i+3));
						orderLineDtls.add((String)result.get(i+4));
					
						for(int j=0; j<tmp.size(); j++)
							orderLineDtls.add(tmp.get(j));
					}
				}
			} 
			else{
				orderLineDtls = (ArrayList)bean_1.getOrderLineDetails(patient_id,order_id);
			}
			ArrayList complete_reason_codes = (ArrayList)bean.getCompleteReasonCodes();

			String disp_delivery_chk_box			=   "checked";
			String disp_delivery_chk_box_val		=   "Y";
			String disp_delivery_chk_box_disabled	=   "";
			String  billing_interface_yn			=   bean.getBLInterfaceYN();//checkforbillinginterface();
			String width							=   "100%";
			String bl_encounter_id					=   bean_1.getEncounterID();
			String bl_display                       =   "Y"; 
			String ord_type						    =	bean_1.getOrderType();
			String sysdate							=   bean_1.getTodaysDate();
			String disp_locn_code			        =   bean_1.getDispLocnCode();
			float tot_gross_charge_amount			=   0;
			float tot_groos_pat_payable				=   0; 
			float tot_gross_amount                  =   0; // added for ML-BRU-CRF-0469
			String tot_gross_charge_amount_str		=  "";
			String tot_groos_pat_payable_str		=  "";
			String tot_gross_amount_str             =	"";	// added for ML-BRU-CRF-0469
			String gross_charge_amount_str			=  "";
			String groos_pat_payable_str			=  "";
			String gross_amount_str                 =   ""; //added for ML-BRU-CRF-0469
			String decimalFormatString				=  "";
			String	batch_str						=  "";
			String image_path					    =  "";
			String trade_code					    =  "";
		//added during PE By Naveen
			String drug_db_product_id				=	"";
			String allergy_override_reason			=	"";
			String dosage_limit_override_reason		=	"";
			String duplicate_drug_override_reason	=	"";
			String interaction_override_reason		=	"";
			String contraind_override_reason		=	"";	
			String dischargeIND		=	"";	
			String strBMS_Include_yn ="N";// Added for [IN:045295]
		//ends here
		/*=================code for auto defaulting batches for normal RX===============*/
			String min_stk_flag	=	"display:none;align:right";//Added for AMS-CRF-0068.1 [IN:050333] -start
			String min_stk_flag_bkg_clr	=		"background-color:none";
			String rol_flag_bkg_clr		=		"background-color:none";
			String rol_flag			=		"display:none";
			String disp_req_flag	= "display:none;color:blue";
			
			boolean min_stk	= false;
			boolean rol_stk	= false;
			HashMap rol_min		= null;
			String frm_store_min_stk_level  = "";
			String frm_store_reorder_level =  "";
			String[] stParameters = {alt_drug_code, disp_locn_code, "0", "N", "", "N", "" };
			HashMap hmStockAvailabilityStatus = null;
			boolean Min_Rol_yn	=bean_1.getMin_Rol_yn();
			boolean getReq_allowed_yn =bean_1.getReq_allowed_yn(); //Added for AMS-CRF-0068.1 [IN:050333] -end
			boolean bEquivalentNormalOrder		= false;
			String abuse_drug_override_reason="";//added for aakh-crf-0140  drug_abuse_appl
			String abuse_exists="";//added for aakh-crf-0140
			String drugIndication="";//added for jd-crf-0220
			String	category_code="";//added for mms-dm-crf-209.1
					String	alternate_yn="";//added for mms-dm-crf-209.1	
			if(ord_type.equals("ALL") && result != null && result.size() >0 && result.get(8) == null)
				bEquivalentNormalOrder = true;

			String display_list = "";

			if(!((ord_type.equals("NOR") || bEquivalentNormalOrder) && bean_1.getIssueByUOM().equals("I"))  ){
				display_list ="display:none" ;
			}

			ArrayList items					=	null;
			ArrayList alloc_drug_detail		=	null;
			HashMap batch_det				=	null;	
			ArrayList stock_det				=	null;
			HashMap	 stock					=	null;	
			String item_code				=	"";
			String store_code				=	"";
			String fill_period				=	null;
			String fill_unit				=	null;
			String item_cost				=   "";
			String issue_qty				=	"";
			String batch_issue_qty				=	""; //MMS-40
			double tmp_unit_qty				=	0;
			double tot_issued_qty			=	0;
			String avail_qty				=	"";
			String act_bms_qty				=	"";
			float opdispperiod				=	0;	
			String alloc_readonly			=   "";
			boolean item_uom_definition_flag = false;
			String billable_item_yn			=	"";
			String pat_class = "";//added for MOHE-CRF-0026.1 
			pat_class   =   bean.getEncounterPatientClass(bl_encounter_id, patient_id); 
		/*	if(iqvia_integration_flag){
				bean_1.setIqvia_integration_yn("Y");
			}else{
				bean_1.setIqvia_integration_yn("N");  
			}*/ //END 
			//String  taper_order_yn, taper_order_id, taper_order_line_num, show_remarks, taper_disable;
			String show_remarks, taper_disable; //Added for RUT-CRF-0088 [IN036978]
			LinkedHashMap hsh_med_plan = new LinkedHashMap();// Added for Bru-HIMS-CRF-072.1 [IN:049144]
			ArrayList arrOrderId = new ArrayList();// Added for Bru-HIMS-CRF-072.1 [IN:049144]
			HashMap<String,String> altDrugName = new HashMap<String,String>();// Added for Bru-HIMS-CRF-072.1 [IN:049144]
			String dosedet[] = new String[4],dosedetlocal[] = new String[4];// Added for Bru-HIMS-CRF-072.1 [IN:049144]
			String dispno[] = new String[2];// Added for Bru-HIMS-CRF-072.1 [IN:049144]

			if(ord_type.equals("CO")||ord_type.equals("IVAA")||ord_type.equals("IVIA")||ord_type.equals("CA")||ord_type.equals("TA")){
				bl_display      =   "N";        
			}
			if(billing_interface_yn.equals("Y")&& bl_display.equals("Y")){	
				width			=   "115%"; 
				patient_class   =   bean.getEncounterPatientClass(bl_encounter_id, patient_id);  // patient_id  added for [IN:035667] 
			}
			String pres_qty_alert = bean_1.getPresQtyAlert();//code added for AMS-CRF-0035[IN033551] 
			String barcodeScan = ""; // Added for GHL-CRF-0463 - Start
			String last_scanned   ="";
			//GHL-CRF-549 - start
			String bl_grp_app		   = "N";
			String mm_item_low_cost_yn = "";	
			String mm_item_high_margin_yn = "";
			String mm_item_Innovator_yn = "";
			String low_cost_green_style ="visibility:none";
			String high_margin_green_style ="visibility:none";
			String high_margin_red_style   ="visibility:none";
			String low_cost_red_style	="visibility:none";
			String low_cost_grey_style ="visibility:none";
			String high_margin_grey_style ="visibility:none";
			String innovator_style		="visibility:none";
			String item_type = "";
			String unit_price = "";
			String bl_install_yn= CommonBean.checkForNull((String) session.getValue( "bl_operational" ),"N") ;	//GHL-CRF-549 - end
			if(bean_1.getBarcode_id().equals("") && bean_1.getOrderType().equals("NOR")){
			   barcodeScan=bean_1.getBarcode_Scan_YN(); 
			 //  last_scanned = bean_1.getScannedBarcode_id(); removed for mms-dm-scf-0488
			}// Added for GHL-CRF-0463 - End
			if(item_type_site_app && !encounter_id.equals("")) //GHL-CRF-549 
			bl_grp_app = bean.getItemTypeApp(patient_id);

			HashMap lab_food_interaction =null;//added for MMS-KH-CRF-0029
			String food_interaction_override_reason =   "";//MMS-KH-CRF-0029
			String lab_interaction_override_reason =   ""; //MMS-KH-CRF-0029
			String disease_inter_override_reason =   "";//Added for MMS-DM-CRF-0229
			String Qtystyle			=	"";//Added for MOHE-CRF-0026.1		
			if(bl_grp_app==null || bl_grp_app.equals(""))
				bl_grp_app = "N";
			
%>
			<input type="hidden" name="alloc_fromBarCode" id="alloc_fromBarCode" value="N"> <!-- added for KDAH-CRF-0231 [IN-034551]  -->
			<input type="hidden" id="barcode_scan_yn" value="<%=barcodeScan%>"> <!-- Added for GHL-CRF-0463 -->
		<!--<input type="hidden" id="last_scanned" value="<%=last_scanned%>">  Added for GHL-CRF-0463 removed for  removed for mms-dm-scf-0488-->
			<table cellpadding="0" cellspacing="0" width='<%=width%>' align="center" border="1"  id="verificationTable">
				<tr>
<%	                if(intractn_req_yn && order_type.equals("NOR")){ //Added for MMS-KH-CRF-0028 [IN070605] - Start
%>
                              <td class= "COLUMNHEADER" width="4%" style="font-size:9px"><fmt:message key="Common.Select.label" bundle="${common_labels}"/>
							   <input type="checkbox" value="Y" name="selectAll" id="selectAll" checked onClick="selectAllRcordsDeliver(this,'<%=disp_stage%>')" ><!--MMS-KH-CRF-0016.1-->
							  </td>
							 
<%					
                    } //Added for MMS-KH-CRF-0028 [IN070605] - End
					if(iqvia_integration_flag){
					if(pat_class.equalsIgnoreCase("O") && bean_1.getSettlementId().equals("X")  && (iv_prep_yn ==null || iv_prep_yn.equals("")|| iv_prep_yn.equals("null")) ){ //added for mohe-crf-0026.1
					%>
					 <td class= "COLUMNHEADER" width="4%" style="font-size:9px"><fmt:message key="ePH.Auth.label" bundle="${common_labels}"/>
						<input type="checkbox" value="Y" name="AuthAll" id="AuthAll" checked onClick="authtAllRcordsDeliver(this,'<%=disp_stage%>')" >
					 </td>
					 <%} } %>  
					<td class= "COLUMNHEADER" width="10%" style="font-size:9px"><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VerificationStatus.label","common_labels")%></td> <!-- 6% changed to 10% for MMS-KH-CRF-0013 --><!--  Modified for MOHE-CRF-0040 -->
					<td class= "COLUMNHEADER" width="3%" style="font-size:9px">&nbsp;</td>
<%					if(bl_install_yn.equals("Y") && !iv_prep_yn.equals("7") && !iv_prep_yn.equals("8") && item_type_site_app && !encounter_id.equals("")){	 //GHL-CRF-0549
%>
					<td width="5%" class= "COLUMNHEADER" style="font-size:9px" nowrap><fmt:message key="ePH.ItemType.label" bundle="${ph_labels}"/></td>
<%
					if(formulary_billing_app){	 //GHL-CRF-0618
					%>
					<td  class="COLUMNHEADER" width="2%"  style="font-size:9px" >&nbsp;</td><!-- added for GHL-CRF-0618 -->
					<%}	 
 					
					}  //GHL-CRF-549 - end
					%>
<%if(aggred_item_app){%>
					<td class= "COLUMNHEADER" style="font-size:9px" width="2%">&nbsp;</td>
					<%} %>
					<td class= "COLUMNHEADER" width="41%" style="font-size:9px"><fmt:message key="ePH.Drug/DosageDetails.label" bundle="${ph_labels}"/></td>
					<td class= "COLUMNHEADER" style="font-size:9px" width="2%">&nbsp;</td>
					<td class= "COLUMNHEADER" style="font-size:9px" width="2%">&nbsp;</td>
					<%
					if(iqvia_integration_flag){
					if( pat_class.equalsIgnoreCase("O") && bean_1.getSettlementId().equals("X")  && (iv_prep_yn ==null || iv_prep_yn.equals("")|| iv_prep_yn.equals("null")) ){ //added for mohe-crf-0026.1 START %>
					<td class= "COLUMNHEADER" width="10%" style="font-size:9px"><fmt:message key="ePH.AuthorizationStatus.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
					<%} } //END%>
					<td class= "COLUMNHEADER" width="9%" style="font-size:9px"><fmt:message key="ePH.PrescribedQuantity.label" bundle="${ph_labels}"/></td>
					<td align="right" class="COLUMNHEADER" width="9%" style='<%=display_list%>'><fmt:message key="ePH.ISSUEUOM.label" bundle="${ph_labels}"/>&nbsp;</td>
					<td class= "COLUMNHEADER" width="9%" style="font-size:9px"><fmt:message key="ePH.AllocatedQuantity.label" bundle="${ph_labels}"/></td>
					<td class= "COLUMNHEADER" width="9%" style="font-size:9px"><fmt:message key="ePH.BalanceQuantity.label" bundle="${ph_labels}"/></td>
<% 		
					if(billing_interface_yn.equals("Y") &&bl_display.equals("Y")){
%>		
                       <%if(bean.getDisplayInsStatus()){ %><!-- //Added for TH-KW-CRF-0012 -->
                        <td class= "COLUMNHEADER" width="10%" style="font-size:9px"><fmt:message key="Common.Insurance.label" bundle="${common_labels}"/> <fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
						<% } %>
                       <!-- Added for ML-BRU-CRF-0469 start -->
                       <%if(displayGrossAmtYn){%>
                        <td class= "COLUMNHEADER" width="10%" style="font-size:9px"><fmt:message key="ePH.GrossAmount.label" bundle="${ph_labels}"/></td>
                        <% } %>
						<!-- Added for ML-BRU-CRF-0469 end -->
						<td class= "COLUMNHEADER" width="10%" style="font-size:9px"><fmt:message key="Common.ChargeAmount.label" bundle="${common_labels}"/></td>
						<td class= "COLUMNHEADER" width="10%" style="font-size:9px"><fmt:message key="ePH.PayableAmount.label" bundle="${ph_labels}"/></td>
						<td class= "COLUMNHEADER" width="10%" style="font-size:9px"><fmt:message key="ePH.OverrideIncl/Excl.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>  
<%
					}      
					if(delivery_reqd.equals("Y")) { 
%>
						<td class= "COLUMNHEADER" width="8%" style="font-size:9px" align="center"><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Deliver.label","ph_labels")%></th> <!-- Modified for MOHE-CRF-0040 -->
<%
					}

					allocate_button = "<td class= 'COLUMNHEADER' width='10%' style='font-size:9px' align='center'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Allocate.label","common_labels")+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels")+"</td>"; // Modified for MOHE-CRF-0040
					filling_button	="<td class= 'COLUMNHEADER' width='8%' style='font-size:9px' align='center'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Fill.label","ph_labels")+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels")+"</td>"; //Modified for MOHE-CRF-0040

					if(display_seq.equals("A")) { 
						if(allocation_reqd.equals("Y")) 
							out.println(allocate_button);
						if(filling_reqd.equals("Y")) 
							out.println(filling_button);
					} 
					else	{ 
						if(filling_reqd.equals("Y"))  
							out.println(filling_button);
						if(allocation_reqd.equals("Y")) 
							out.println(allocate_button);
					}
%>
					<td class= "COLUMNHEADER" width="10%" style="font-size:9px"><%=legend%></th>
<%				//added for AAKH-CRF-0117 - start
				if(approval_no_flag)
				{
%>
							<td class= "COLUMNHEADER" width="15%" style="font-size:9px"><fmt:message key="ePH.ApprovalNo.label" bundle="${ph_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;</td>
<%							
                }//added for AAKH-CRF-0117 - start
%>
				</tr>
<%
				String sRepeatFreqCode		   = null;
				String sFreqCode			   = null;
				boolean bPRNOrAbsOrder		   = false;
				boolean bDrugOrder			   = true;
				String disable_alloc_text_box  =  "";
//				String iv_prep_yn  =  ""; moved to up for GHL-CRF-0549
				String allow_alternate_yn="";//added for mms-kh-crf-0028
            String expiry_date="";//added for mms-kh-crf-0028
			String alt_called_from="";//added for MMS-KH-CRF-0028
				String dose_unit_desc="";//added for ML-MMOH-CRF-1408
				ArrayList celling_dose = null;//added for ML-MMOH-CRF-1408
				String min_unit_ceiling_dose = "", max_unit_ceiling_dose = "", min_daily_ceiling_dose = "", max_daily_ceiling_dose = ""; //added for ML-MMOH-CRF-1408
				String ceil_dose_unit_desc = ""; //IN070451
				Set stDrugCodes				= new HashSet();
				HashMap approvalNo = bean_1.getApprovalNo();//AAKH-CRF-0117

		//GHL-CRF-0618 - start
			String preference = "";  
			String preference_img = ""; 
			String formulary_value = "";
			String formulary_code  = "";
			String blg_grp_type = "";
			HashMap hmBlgGrp = null;

			if(formulary_billing_app){
				String blng_grp_id = bean.getBillingGrpId();				
				formulary_value = bean.getFormularyBillingGrpCode(blng_grp_id);
				formulary_code = formulary_value.substring(0, formulary_value.indexOf("~"));
				blg_grp_type = formulary_value.substring(formulary_value.indexOf("~")+1);
				if(!formulary_code.equals(""))
				 hmBlgGrp = bean.getFormularyBillingGrpCodeDtl(formulary_code,blng_grp_id);//blng_grp_id added for GHL-SCF-1527
			}
//GHL-CRF-0618  - end
				for(int i=0;i<orderLineDtls.size(); i++){
					bDrugOrder			= true;
					sRepeatFreqCode		= "";
					sFreqCode			= "";
					if ( recCount % 2 == 0 )
					classvalue = "QRYODD" ;
					else
					classvalue = "QRYEVEN" ;

					hold_value			=	"";
					title_remarks		=	"";
					hold_status			=	"";
					pres_strength		=	"";
					pres_strength_1		=   ""; //MMS-KH-CRF-0030
					tot_qty				=	0;
					stock_opt			=	new ArrayList();
					alloc_strength		=	"";
					tmp_alloc			=	0;
					title				=	"";
					narc_style			=	"";
					pres_details		=	"";

					//added for ML-MMOH-CRF-1408 - start
						celling_dose			= null;
						min_unit_ceiling_dose = "";
						max_unit_ceiling_dose = "";
						min_daily_ceiling_dose = "";
						max_daily_ceiling_dose = "";
						dose_unit_desc="";
						ceil_dose_unit_desc = ""; //IN070451
					//added for ML-MMOH-CRF-1408 - end
					if(disp_level.equals("P") && ((String)orderLineDtls.get(i)).startsWith("PH")) {
						order_id			=	(String)orderLineDtls.get(i);
						//ordered_by	=	(String)orderLineDtls.get(++i);
						++i;
						//location		=	(String)orderLineDtls.get(++i);
						++i;
						++i;
					}

					allergy					=	(String)orderLineDtls.get(i);
					exceed_dose				=	(String)orderLineDtls.get(++i);
					++i;
					drug_code				=	(String)orderLineDtls.get(++i);
					drug_name				=	(String)orderLineDtls.get(++i);
					dosage_dtls				=	(String)orderLineDtls.get(++i);
					//++i; // commented for MMS-KH-CRF-0013
					start_date              =   (String)orderLineDtls.get(++i); // Added for for MMS-KH-CRF-0013
					end_date				=	(String)orderLineDtls.get(++i);
					pres_qty				=	(String)orderLineDtls.get(++i);
					qty_uom					=	(String)orderLineDtls.get(++i);
					qty_uom_disp			=	(String)orderLineDtls.get(++i);
					order_line_no			=	(String)orderLineDtls.get(++i);
					generic_id				=	(String)orderLineDtls.get(++i);

					if(generic_id.equals("MEDICALITEM"))
						bDrugOrder			= false;

					generic_name			=	(String)orderLineDtls.get(++i);
					dosage_details			=	(String)orderLineDtls.get(++i);
					bms_qty					=	(String)orderLineDtls.get(++i);
					act_bms_qty				=   bms_qty;
					source_code				=	(String)orderLineDtls.get(++i);
					source_type				=	(String)orderLineDtls.get(++i);
					ordering_facility_id	=	(String)orderLineDtls.get(++i);
					ord_date_time			=	(String)orderLineDtls.get(++i);
					performing_pract_id		=	(String)orderLineDtls.get(++i);
					duplicate_yn			=	(String)orderLineDtls.get(++i);
					min_dose_dtls			=	(String)orderLineDtls.get(++i);
					alloc_qty_from_tmp		=	(String)orderLineDtls.get(++i);
					strength_value			=	(String)orderLineDtls.get(++i);
					strength_uom			=	(String)orderLineDtls.get(++i);
					strength_uom_disp		=	(String)orderLineDtls.get(++i);
					trade_code				=	(String)bean_1.gettrade_codes(order_id,order_line_no,drug_code);

					currentdateplusAllocatePeriod		=  	com.ehis.util.DateUtils.plusDate(sysdate,"DMY",locale,Integer.parseInt(bean_1.getFillPeriod()),"d").toString();  //Added for ML-BRU-SCF-0905 [IN:041285] -Start
					if(end_date.length() >=10)
						end_date		=	end_date.substring(0,10);
					endDateIsbeforAllocatedate			=  	com.ehis.util.DateUtils.isBefore(end_date,currentdateplusAllocatePeriod,"DMY",locale);
					if(!endDateIsbeforAllocatedate){
						end_date=currentdateplusAllocatePeriod;
					}//Added for ML-BRU-SCF-0905 [IN:041285]ended
					// For Multi Frequency 

					sRepeatFreqCode			=	bean_1.getFreqRepeatCode(order_id, order_line_no).split("~")[0];
					sFreqCode				=	bean_1.getFreqRepeatCode(order_id, order_line_no).split("~")[1];

					stDrugCodes.add(drug_code); // to Add drug codes for authorization check
					bean.setStockItems(drug_code,stock_opt); //MMS-SCF-417 and BSP-SCF-0041
					if(generic_id.equals("MEDICALITEM")){
						drug_trade_bean.setDrugyesno("");
					}
					else{
						drug_trade_bean.setDrugyesno("Y");
					}
					image_path				=  drug_trade_bean.getImagePath(drug_code,trade_code);
					pack_dtls			    =	bean.getPackSize(drug_code);
					main_drug_pack_size = 0;
					if(pack_dtls!=null && pack_dtls.containsKey("PACK_SIZE")){
						if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
							main_drug_pack_size		=	Float.parseFloat(((String)pack_dtls.get("PACK_SIZE")));						
						}		
					}
					bean.setOrderDetails(order_id+order_line_no,end_date);

					alt_drug				=	bean.checkMultiStrength(drug_code);
					//pat_couns_reqd_yn       =   bean.getPatCounsReqdyn(order_id, order_line_no);
					bmscount                =   bean.CheckBMSYN(order_id, order_line_no);
					int medi_count=bean.altDrugsAvelibleYN(drug_code);//added for ghl-crf-0548
					if(medi_count>0){
						alt_drug="Y";
					}
					bean.addDrugs(patient_id,order_id,drug_code,alt_drug,order_line_no);
					pres_details			=	bean.getPresDetails(order_id);
					if(order_type.equals("IVI") || order_type.equals("CA"))
						strChangedFludRmks =	bean.getChngdFluidRemarks(order_id,order_line_no);
					else
						strChangedFludRmks =	"";

					if(strChangedFludRmks != "" && strChangedFludRmks != null)
						classvalue = "FLUDCOLOR";
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

					ext_prod_id=(String)orderLineDtls.get(++i);
					bean.setStockItems(drug_code,stock_opt);

					/*if(!strength_value.equals("0"))
					strength	=	strength_value+" "+strength_uom;*/

					//code added for in_formulary_yn ..added on 25/4/2004
					in_formulary_yn			=	((String)orderLineDtls.get(++i)).trim();
					if(in_formulary_yn.equals("N")){
						classvalue			=	"FORMULARY";
						disable_alloc_text_box ="disabled";
					}
					else{
						disable_alloc_text_box ="";
					}

					// IV_PREP_YN
					iv_prep_yn = (String)orderLineDtls.get(++i);
					//if( (((String)orderLineDtls.get(++i)).trim()).equals("N")) {
					if(iv_prep_yn!=null && iv_prep_yn.trim().equals("N")) {
						if(order_line_no.equals("1")){
							classvalue="IVFLUID";
						}
						else{
							classvalue="IVINGREDIENT";
						}
					}

					//ended...

					// Drug class
					drug_class	=	(((String)orderLineDtls.get(++i)).trim());
					i=i+2;

					expired_yn  = (String)orderLineDtls.get(++i);

					if(expired_yn.equals("Y"))
					{
						if(expired_order) //modified for MOHE-CRF-0032
							{
							classvalue="EXPIRED_ORDER";
							}
						else
						{
							classvalue="EXPIRED_MEDICATION";
						}
					}
					drug_verf_reqd_yn = (String)orderLineDtls.get(++i);
					order_line_status = (String)orderLineDtls.get(++i);
					main_strength_per_value_pres_uom = (String)orderLineDtls.get(++i);

					i++;
					String sOrderType = orderLineDtls.get(i) == null ?"":orderLineDtls.get(i).toString();
					i++;
					String sAbsOrder  = orderLineDtls.get(i) == null ?"":orderLineDtls.get(i).toString();

					if(sOrderType.equals("P") || sAbsOrder.equals("N"))
						bPRNOrAbsOrder = true;
					else
						bPRNOrAbsOrder = false;

					drug_style        = "cursor:pointer;color:blue";
					String current_order_line_status = order_line_status;//for 61540
					order_line_status ="VF";
					if(!bean_1.getVerfCombinedWithAlloc().equals("C")){
						if(drug_verf_reqd_yn.equals("Y")){
							if(order_line_status.equals("VF")){
								disp_delivery_chk_box_disabled  ="";
								disp_delivery_chk_box_val		="Y";
								disp_delivery_chk_box			="checked";
							}
							else{
								disp_delivery_chk_box_disabled  ="disabled";
								disp_delivery_chk_box_val		="N";
								disp_delivery_chk_box			="";
								drug_style="color:red;FONT-WEIGHT: BOLDER";
							}					
						}
						else{
							disp_delivery_chk_box_disabled  ="";
							disp_delivery_chk_box_val		="Y";
							disp_delivery_chk_box			="checked";
						}
					}
					if(drug_class.equals("C") || drug_class.equals("N")) {
						narc_style	="color:brown";
						//title		= "title='Narcotic/Controlled Drugs'";
						String nar_cnt_drug = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.NarcoticControlledDrugs.label","ph_labels");
						title		= "title='"+nar_cnt_drug+"'";
					}

					token	=	new StringTokenizer(dosage_details,":");

					if(token.hasMoreTokens()) {
						exceed_status	=	token.nextToken();
					}
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
					if(!dosage_unit.equals("")){ //added for ML-MMOH-CRF-1408 - start
						   dose_unit_desc      = bean.getUomDisplay((String)session.getValue("facility_id"),dosage_unit); 
							ceil_dose_unit_desc = dose_unit_desc;//added for ML-MMOH-CRF-1408
							if(dose_unit_desc==null || dose_unit_desc=="" ) {
								if(dosage_unit.indexOf("/")!=-1){//if added for ML-MMOH-SCF-1627
							  dose_unit_desc = bean.getUomDisplay((String)session.getValue("facility_id"),(dosage_unit.split("/")[0]));
							ceil_dose_unit_desc = dose_unit_desc;//added for ML-MMOH-CRF-1408
							  if(dosage_unit.length()>=2){
								 dose_unit_desc =dose_unit_desc+"/"+(dosage_unit.split("/")[1]);
							  }
							}
							  
							} 
	 				}//added for ML-MMOH-CRF-1408 - end
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
						check_value				="Y";
						check_status			="checked";
						fromdb					="Y";
						remark_status			="visibility:visible";
					} 
					else {
						hm		= bean.loadHoldRemarks(order_id,order_line_no);
						if (!hm.isEmpty()){
							hold_text=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OnHold.label","ph_labels");

							check_value		="Y";
							check_status	="checked";
							fromdb			="Y";
							remark_status	="visibility:visible";
						}
						else{
							hold_text		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Hold.label","ph_labels");
							remark_status	="visibility:hidden";
							check_status	="";
						}
					}
					multi_drugs	=	bean.getMultiDrugs(patient_id,order_id,order_line_no);	
					alt_drug_remarks_disp="";
					if(multi_drugs.size()>0){
						if(alt_drug_remarks_ind.equals("M") || alt_drug_remarks_ind.equals("O")){//if block added for  Bru-HIMS-CRF-082 [IN:029948]
							alt_drug_remarks_disp = "&nbsp;<a href=\"javascript:openAltDrugRemarks('"+order_id+"','"+ order_line_no+"','"+ alt_drug_remarks_ind+"','LINK');\" id='altDrugRmkLbl' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+"</a>";
							if(alt_drug_remarks_ind.equals("M"))
								alt_drug_remarks_disp=alt_drug_remarks_disp+" <img  id='altDrugRmkMand' src='../../eCommon/images/mandatory.gif'></img>";
						}
					}
					if(request.getParameter("resetQty")== null)
						qty				=	bean.getDrugQuantity(patient_id,order_id,order_line_no);
					else
						qty				= "";
					//				qty			=	bean.getDrugQuantity(patient_id,order_id,order_line_no);
					HashMap Order_id_amend_yn =(HashMap)bean_1.getOrder_id_amend_yn();
					if(Order_id_amend_yn.containsKey(order_id)){
						Order_id_amend_yn.remove(order_id);
						qty			=  "";
					}
					if(!qty.equals("") && !qty.equals("0") && multi_drugs.size() < 1)
						tot_qty				+=	Double.parseDouble(qty);

					alt_drug_qty			=	"";
					for(int n=0; n<multi_drugs.size(); n+=5)	{ 
						alt_drug_code	=	(String)multi_drugs.get(n);
						alt_drug_qty	=	bean.getAlternateDrugQuantity(patient_id,order_id,order_line_no,alt_drug_code); 
						if(!alt_drug_qty.equals(""))
							break;
					}
					if( (!qty.equals("") && !qty.equals("0")) || (!alt_drug_qty.equals("") && !alt_drug_qty.equals("0")) )
						hold_status	="disabled";

					/*if(verification_reqd.equals("")) {
					hold_status			=	"disabled";
					hold_value			=	"E";
					}*/


					/*-----code for displaying drug remarks---------------*/
					/* drug_remarks	    = "";
					prn_remarks		    = "";
					pharma_remarks	    = "";		
					pres_remarks        = "";
					slidingscaleremarks ="";
					remarks_style       = "";
					dialog_height       = 0;

					pres_remarks		= bean.getPrescriptionInstructions(order_id);
					drug_remarks		= bean.getDrugInstructions(order_id,order_line_no);
					prn_remarks			= bean.getPRNInstructions(order_id,order_line_no);
					pharma_remarks		= bean.getPharmacistInstructions(order_id,order_line_no,"Y");
					slidingscaleremarks	= bean.getSlidingScaleRemarks(order_id,order_line_no);
					verificationremarks	= bean.getVerificationRemarks(order_id,order_line_no);
					HashMap overridereason =(HashMap)bean.getOverrideremarks(order_id,order_line_no);
					String	show_remarks = "N";
					if(drug_db_interface_yn.equals("Y") && overridereason.containsKey("DRUG_DB_PRODUCT_ID")){
					if(overridereason.size()>1){
					show_remarks="Y";
					}			
					}else{
					if(overridereason.size()>0){
					show_remarks="Y";
					}
					}
					*/
					pres_remarks					=   bean.getPrescriptionInstructions(order_id);
					drug_remarks					=   bean.getDrugInstructions(order_id,order_line_no);
					//IN071533 Start					
					if(iv_prep_yn!=null && !iv_prep_yn.equals("") && iv_prep_yn.equals("5")){
						drug_remarks = bean.getNonMFRfluidRemarks(order_id,order_line_no); 
					}
					//IN071533 end	
					
					prn_remarks						=   (String)orderLineDtls.get(++i);
					pharma_remarks					=    bean.getPharmacistInstructions(order_id,order_line_no,"Y");
					slidingscaleremarks				=   (String)orderLineDtls.get(++i);
					verificationremarks				=   (String)orderLineDtls.get(++i);             
					drug_db_product_id				=	(String)orderLineDtls.get(++i);
					allergy_override_reason			=	(String)orderLineDtls.get(++i);
					dosage_limit_override_reason	=	(String)orderLineDtls.get(++i);
					duplicate_drug_override_reason	=	(String)orderLineDtls.get(++i);
					interaction_override_reason		=	(String)orderLineDtls.get(++i);		  
					contraind_override_reason		=	(String)orderLineDtls.get(++i);
					pat_couns_reqd_yn		        =	(String)orderLineDtls.get(++i);//from order_line_PH
					pt_couns_reqd_yn		        =	(String)orderLineDtls.get(++i);//from PH_drug
					billable_item_yn		        =	(String)orderLineDtls.get(++i);//from PH_drug
					dischargeIND		        =	(String)orderLineDtls.get(++i);//from OR_ORDER
					strBMS_Include_yn				=	(String)orderLineDtls.get(++i);// Added for [IN:045295]
					home_med_yn 					= 	(String)orderLineDtls.get(++i);//Added for Bru-HIMS-CRF-093-DD1[IN047223]
					drug_desc 				= 	(String)orderLineDtls.get(++i);//Added for Bru-HIMS-CRF-414 ML-BRU-SCF-1454 [IN:052271]
					disc_cancelled_orders		= 	(String)orderLineDtls.get(++i);//Added for  HSA-CRF-0138 [IN:048414] 
					appl_for_compounding_rx_yn 	= 	(String)orderLineDtls.get(++i);//Added for  Bru-HIMS-CRF-080
					if("Y".equals(appl_for_compounding_rx_yn)){
						disp_mnf_flag = "display:inline;color:blue";
					}
					if(!disc_cancelled_orders.equals("")) //Added for  HSA-CRF-0138 [IN:048414] - start
						disc_cancelled_orders_display="display:inline";
					else
						disc_cancelled_orders_display="display:none"; //Added for  HSA-CRF-0138 [IN:048414] end
					/*Commented for RUT-CRF-0088 [IN036978] 
					taper_order_yn 					=	(String)orderLineDtls.get(++i);//from OR_ORDER
					taper_order_id					=	(String)orderLineDtls.get(++i);//from OR_ORDER
					taper_order_line_num					=	(String)orderLineDtls.get(++i);//from OR_ORDER
					if(taper_order_yn.equals("Y") && !taper_order_id.equals("") && !taper_order_line_num.equals("")){
						taper_disable = "disabled";
						alloc_qty_from_tmp="0"; //added to avoid displaying qty for tapered drugs
					}
					else*/
						taper_disable="";

					//added for MMS-KH-CRF-0029 - start
						food_interaction_override_reason =   "";
						lab_interaction_override_reason =   "";  
						disease_inter_override_reason="";//MMS-DM-CRF-0229
						if(iv_prep_yn!=null && iv_prep_yn.equals("")){
							 lab_food_interaction = bean.getDrugLabFoodInteraction(order_id,order_line_no);
							 food_interaction_override_reason = (String)lab_food_interaction.get("FOOD_INTERACT_OVERRIDE_REASON")==null?"":(String)lab_food_interaction.get("FOOD_INTERACT_OVERRIDE_REASON");
							 lab_interaction_override_reason = (String)lab_food_interaction.get("LAB_INTERACT_OVERRIDE_REASON")==null?"":(String)lab_food_interaction.get("LAB_INTERACT_OVERRIDE_REASON");//modified for MMS-MD-SCF-0141
							 disease_inter_override_reason = (String)lab_food_interaction.get("DISEASE_INTER_OVERRIDE_REASON")==null?"":(String)lab_food_interaction.get("DISEASE_INTER_OVERRIDE_REASON");//MMS-DM-CRF-0229
						}
						if(lab_interaction_override_reason==null) //MMS-KH-CRF-0029
							lab_interaction_override_reason = "";
						if(food_interaction_override_reason==null) //MMS-KH-CRF-0029
							food_interaction_override_reason = "";
						if(disease_inter_override_reason==null) //MMS-DM-CRF-0229
							disease_inter_override_reason = "";
						//added for MMS-KH-CRF-0029 - end


					show_remarks = "N";
					if(!alloc_qty_from_tmp.equals("") && !alloc_qty_from_tmp.equals("0")) {
						if(bean.getFirstTime(order_id).trim().equals("true")) {
							drug_detail		=	bean.getDB_DrugDetail(order_id,order_line_no,end_date);
							multi_detail	=	(ArrayList)drug_detail.get("multi_detail");
							main_detail		=	(ArrayList)drug_detail.get("main_detail");
							alt_detail		=	(HashMap)drug_detail.get("alt_detail");
							if(multi_detail.size()==0) {
								bean.setDrugDetail(patient_id,order_id,order_line_no,main_detail);
								bean.setDrugQuantity(patient_id,order_id,order_line_no,Integer.parseInt(alloc_qty_from_tmp));
							} 
							else if(multi_detail.size()!=0) {
								bean.setMultiDrugs(patient_id,order_id,order_line_no,multi_detail);	
								for(int no=0; no<multi_detail.size(); no+=5) {
									alt_drug_code		=	(String)multi_detail.get(no);
									alt_drug_detail		=	(ArrayList)alt_detail.get(alt_drug_code);
									bean.setAlternateDrugDetail(patient_id,order_id,order_line_no,alt_drug_detail,alt_drug_code);
								}							
							}
							bean.setFirstTime(order_id,false);
						}
					}
					abuse_drug_override_reason=(String)orderLineDtls.get(++i);//added for aakh-crf-0140
					abuse_exists=(String)orderLineDtls.get(++i);//aakh-crf-0140
					drugIndication=(String)orderLineDtls.get(++i);//ADDED FOR JD-CRF-0220
					drug_expiry_alert = (String)orderLineDtls.get(++i);//Added for TH-KW-CRF-0008
					drug_expiry_days  = (String)orderLineDtls.get(++i);//Added for TH-KW-CRF-0008
					if(insuranceStatus.containsKey(order_id+order_line_no))
						insurance_status  = (String)insuranceStatus.get(order_id+order_line_no);//Added for TH-KW-CRF-0012
					category_code=(String)orderLineDtls.get(++i);//added for mms-dm-crf-0209.1
					alternate_yn=(String)orderLineDtls.get(++i);//added for mms-dm-crf-0209.1
							System.out.println("category_code"+category_code);
				/* 	if(drug_abuse_appl &&( !abuse_drug_override_reason.equals("") && abuse_exists.equals("Y"))){
						 ABUSE_REMARKS_CLASS="ABUSE_REMARKS";//ADDED FOR AAKH-CRF-0140
						  ABUSE_REMARKS_YN="Y";//ADDED FOR AAKH-CRF-0140
						
					}
					else{
						ABUSE_REMARKS_CLASS="";
						ABUSE_REMARKS_YN="N";
					} */
			System.out.println("Dispmedicationdelivery abuse_drug_override_reason"+abuse_drug_override_reason);
			System.out.println("Dispmedicationdelivery abuse_exists"+abuse_exists);
					
					if(!allergy_override_reason.equals("")||!dosage_limit_override_reason.equals("")||!duplicate_drug_override_reason.equals("")||!interaction_override_reason.equals("")||!contraind_override_reason.equals("") || !food_interaction_override_reason.equals("") ||  !lab_interaction_override_reason.equals("") || !disease_inter_override_reason.equals("")){ //modified for MMS-KH-CRF-0029
						show_remarks="Y";
					}
					drugs_remarks = new StringBuffer(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PractitionerPharmacistInstructions.label","ph_labels")+" : \n"); //code added for Bru-HIMS-CRF-416[IN045566]-- Start								
					if(!pres_remarks.trim().equals(""))
						drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PrescriptionInstructions.label","ph_labels")+" : "+pres_remarks.trim()+"\n");
					if(!slidingscaleremarks.trim().equals("")){
						drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.SlidingScaleRemarks.label","ph_labels")+" : "+slidingscaleremarks.trim()+"\n");
						bPRNOrAbsOrder=true; // Added for ARYU-SCF-100
					}
					if(!allergy_override_reason.trim().equals(""))
						drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllergyOverrideReason.label","common_labels")+" : "+allergy_override_reason.trim()+"\n");		
					if(!duplicate_drug_override_reason.trim().equals("")){
					   if(drug_db_product_id != null  && !drug_db_product_id.equals(""))
							drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DuplicateTheraphyOverrideReason.label","ph_labels")+" : "+duplicate_drug_override_reason.trim()+"\n");
						else
							drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DuplicateDrugOverrideReason.label","ph_labels")+" : "+duplicate_drug_override_reason.trim()+"\n");
					}
					if(!dosage_limit_override_reason.trim().equals(""))
						drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DosageOverrideReason.label","ph_labels")+" : "+dosage_limit_override_reason.trim()+"\n");
					if(!interaction_override_reason.trim().equals(""))
							drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Drug-DrugInteractionOverrideReason.label","ph_labels")+" : "+interaction_override_reason.trim()+"\n"); //modified for MMS-KH-CRF-0029
							//added for MMS-KH-CRF-0029 - start
						if(!lab_interaction_override_reason.trim().equals(""))
							drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Drug-LabInteractionOverrideReason.label","ph_labels")+" : "+lab_interaction_override_reason.trim()+"\n");
						if(!food_interaction_override_reason.trim().equals(""))
							drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Drug-FoodInteractionOverrideReason.label","ph_labels")+" : "+food_interaction_override_reason.trim()+"\n");
						//added for MMS-KH-CRF-0029 - end
						if(!disease_inter_override_reason.trim().equals(""))
							drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Drug-DiseaseOverrideReason.label","ph_labels")+" : "+disease_inter_override_reason.trim()+"\n");//MMS-DM-CRF-0229
					if(!contraind_override_reason.trim().equals(""))
						drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ContraIndicationOverrideReason.label","ph_labels")+" : "+contraind_override_reason.trim()+"\n");								
					if(!drug_remarks.trim().equals(""))
						drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DrugInstructions.label","ph_labels")+" : "+drug_remarks.trim()+"\n");
					if(!prn_remarks.trim().equals(""))
						drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PRNInstructions.label","ph_labels")+" : "+prn_remarks.trim()+"\n");						
					if(!pharma_remarks.trim().equals(""))
						drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Pharmacist.label","ph_labels")+" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Instructions.label","common_labels")+" : "+pharma_remarks.trim()+"\n");
					if(!verificationremarks.trim().equals(""))
						drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.VerificationRemarks.label","ph_labels")+" : "+verificationremarks.trim()+"\n");		//code added for Bru-HIMS-CRF-416[IN045566]-- End
					 	//!abuse_drug_override_reason.trim().equals("") added for aakh-crf-0140
						if(!abuse_drug_override_reason.trim().equals(""))
							drugs_remarks.append("DrugAbuse Remarks : "+abuse_drug_override_reason.trim()+"\n");	
						if(drugIndication !=null && !drugIndication.equals("")){
							drugs_remarks.append("Drug Indications : "+drugIndication.trim()+"\n");
						}
							System.out.println("abuse_drug_override_reason"+abuse_drug_override_reason+"drugs_remarks"+drugs_remarks);
							//abuse_drug_override_reason.trim().equals("") added for aakh-crf-0140
							if(drug_remarks.trim().equals("") && pharma_remarks.trim().equals("") && pres_remarks.trim().equals("") && prn_remarks.trim().equals("")&& slidingscaleremarks.trim().equals("")&& verificationremarks.equals("") &&show_remarks.equals("N") && abuse_drug_override_reason.trim().equals("") && drugIndication.equals("")){
								remarks_style	=	"style='visibility:hidden'";
						drugs_remarks.setLength(0);
					} 
					else {
						strDrugsRemarks = drugs_remarks.toString();
						strDrugsRemarks=strDrugsRemarks.replaceAll(" ","%20");
						strDrugsRemarks = java.net.URLEncoder.encode(strDrugsRemarks,"UTF-8");
						strDrugsRemarks=strDrugsRemarks.replaceAll("%2520","%20");
						dialog_height = 0 ;
						if(!prn_remarks.trim().equals(""))
							dialog_height	 += 6.5;

						if(!drug_remarks.trim().equals(""))
							dialog_height	 += 6.5;

						if(!pres_remarks.trim().equals(""))
							dialog_height	 += 6.5;

						if(!pharma_remarks.trim().equals(""))
							dialog_height	 += 6.5;

						if(!slidingscaleremarks.trim().equals(""))
							dialog_height	 += 6.5;

						if(!verificationremarks.trim().equals(""))
							dialog_height	 += 6.5;
						if(show_remarks.equals("Y"))
							dialog_height	 += 13;

						remarks_style	=	"style='visibility:visible'";
						if(dialog_height>18) 
							dialog_height = dialog_height-4;
						if(dialog_height==18) 
							dialog_height = dialog_height-3;
						if(dialog_height==12) 
							dialog_height = dialog_height-1;

						dialog_height	 += 1.4;					
					}
					/*-------------------------ends------------------------*/	

					tmp_bms_qty				=	bms_qty;
					main_pack_size			=   0;
					if(pack_dtls!=null && pack_dtls.containsKey("PACK_SIZE")) {
						if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
							main_pack_size	=	Float.parseFloat(((String)pack_dtls.get("PACK_SIZE")));	
							tmp_bms_qty_1		=   Float.parseFloat(tmp_bms_qty)*main_pack_size+"";
						}		
					}
					else{
						tmp_bms_qty_1		=   tmp_bms_qty;
					}
					adr_count = bean.getADRCount(patient_id,drug_code);
					/*==============code for getting defult batches====================================*/

					items			=  (ArrayList)bean.loadItems(drug_code);
					if(items.size()>0){
						item_code     =   (String)items.get(0);
					}
					store_code	=	bean_1.getStoreCode();

					/*if(end_date.length() >=10)
						end_date		=	end_date.substring(0,10);*/
					Float fTotalDuration = Float.parseFloat(bean_1.getDurationValue(order_id+order_line_no));
					//opdispperiod  =  bean_1.getopdispperiod( disp_locn_code);
					opdispperiod  = Float.parseFloat(bean_1.getFillPeriod());

					// For Multi Frequency
					String sOrigDispUnit	= bean_1.getStrChangedDispenseUnit() != null?bean_1.getStrChangedDispenseUnit():"D";
					String sOrigDispPeriod	= bean_1.getStrChangedDispensePeriod() != null?bean_1.getStrChangedDispensePeriod():"1";
					if(sRepeatFreqCode.equals("W")){
						if(sOrigDispUnit.equals("H")){
							//opdispperiod = new Float(Math.ceil((opdispperiod/(24*7)))*7); // divide by 24 to make day and divide by 7 to convert to week and ceil it. // commented for ARYU-SCF-0077
							opdispperiod = new Float(Math.ceil((opdispperiod/7)*7));//Added for ARYU-SCF-0077 removed 24 because opdispperiod already converted to day in Bean 
						}
						else if(sOrigDispUnit.equals("D")){
							//opdispperiod = new Float(Math.ceil((opdispperiod/7))*7); // commented for ARYU-SCF-0077
							opdispperiod = new Float(Math.ceil((opdispperiod/7)*7));//Added for ARYU-SCF-0077
						}
						else if(sOrigDispUnit.equals("M"))
							opdispperiod = new Float(Integer.parseInt(sOrigDispPeriod)*4*7);
					}
					else if(sRepeatFreqCode.equals("M")){
						if(sOrigDispUnit.equals("H"))
							opdispperiod = new Float(Math.ceil((opdispperiod/(24*30)))*30);
						else if(sOrigDispUnit.equals("D"))
							opdispperiod = new Float(Math.ceil((opdispperiod/30))*30);
						else if(sOrigDispUnit.equals("W"))
							opdispperiod = new Float(Math.ceil((opdispperiod/4))*30);
					}

					if(sFreqCode.equals("H"))
						fTotalDuration = fTotalDuration/24;
					else if(sFreqCode.equals("W"))
						fTotalDuration = fTotalDuration*7;
					else if(sFreqCode.equals("L"))
						fTotalDuration = fTotalDuration*30;
					else if(sFreqCode.equals("Y"))
						fTotalDuration = fTotalDuration*365;

					if(bean.checkHold(order_id,order_line_no)|| scope.equals("H")){
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

					dflt_issue_uom = "";
					if(issue_uom_qty_hm.size()>0){
						if(issue_uom_qty_hm.containsKey(order_id+order_line_no+drug_code+"_uom")){
							dflt_issue_uom = (String)issue_uom_qty_hm.get(order_id+order_line_no+drug_code+"_uom");
						}
					}
					if(dflt_issue_uom.equals("") || request.getParameter("resetQty")!= null)
						dflt_issue_uom			 =	(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM")==null?"":(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM");

					base_uom			     =  (String)IssueUOMAndBaseUOM.get("BASE_UOM");
					base_to_disp_uom_equl    =	bean.getEqulValue ( item_code, base_uom, qty_uom);

					orig_dflt_issue_uom		= (String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM")==null?"":(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM");
					st_allow_decimals_yn	= CommonBean.checkForNull((String)IssueUOMAndBaseUOM.get("ALLOW_DECIMALS_YN")); //  Added for AAKH-SCF-0113 [IN:048937] 
					base_to_def_uom_equl	 =  bean.getEqulValue ( item_code, base_uom, orig_dflt_issue_uom);

					/*=======================ends here=========================================================================================*/
					if(request.getParameter("barcode_id")!=null){ //Added for KDAH-CRF-0231 [IN-034551]
						barcode_id = request.getParameter("barcode_id");
					}
					last_scanned = bean_1.getScannedBarcode_id(order_id,order_line_no); //Added for GHL-CRF-0463 //modified for MMS-DM-SCF-0488

					if(alt_drug_qty.equals("")&& ord_type.equals("NOR") && alloc_readonly.equals("")&& stock_opt.get(0).equals("N") && (!item_code.equals("")) && barcode_id.equals("")){//MMS-SCF-417 and BSP-SCF-0041
						qty = "";
					}
					if(qty.equals("") && alt_drug_qty.equals("")&& ord_type.equals("NOR") &&alloc_readonly.equals("")&& stock_opt.get(0).equals("Y") && (!item_code.equals("")) && barcode_id.equals("")) {//  && barcode_id.equals("") Added for KDAH-CRF-0231 [IN-034551]
						if(base_to_disp_uom_equl!=0 && base_to_def_uom_equl !=0){
							tmp_unit_qty    =	0;
							if(bPRNOrAbsOrder){
								tmp_unit_qty = Double.parseDouble(act_bms_qty);
							}
							else{
								fill_period	= bean_1.getFillPeriod();
								fill_unit		= bean_1.getFillUnit();
								item_cost       ="";
								//tot_issued_qty  =0;
								issue_qty       ="";

								float per_day	=Integer.parseInt(pres_qty)/ fTotalDuration;
								//if(per_day < 1)  
								//	     per_day	=	1;

								if(disp_locn_catg.equals("I")){
									if(fill_unit.equals("H") && !fill_period.equals("")) {
										//					tmp_unit_qty	=	new Float((Integer.parseInt(fill_period) / 24 )* per_day).intValue();				
										tmp_unit_qty	=	new Float((opdispperiod / 24 )* per_day).doubleValue();	
									}
									else if(fill_unit.equals("D")) {
										//tmp_unit_qty	=	new Float((Integer.parseInt(fill_period) * per_day)).intValue();
										tmp_unit_qty	=	new Float((opdispperiod * per_day)).doubleValue();
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
								if(tmp_unit_qty > Double.parseDouble(act_bms_qty) ){
									tmp_unit_qty =Double.parseDouble(act_bms_qty);
								}
							}
							/*==========code added to handle if dispense uom and default uom in item store is different=================*/
							 if(bean_1.getBarcode_Scan_YN().equals("Y") && barcode_id.equals("") && bean_1.getOrderType().equals("NOR")){ // condition Added for [IN:064158] - Start
								  tmp_unit_qty=0;  
							  } // condition Added for [IN:064158] -End

							issue_qty_val			 =  0;
							if(base_to_disp_uom_equl!=base_to_def_uom_equl){
								conv_factor    = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
								issue_qty_val  =  new Float(Math.ceil(tmp_unit_qty*base_to_disp_uom_equl)).doubleValue(); 
								issue_qty_val  =  new Float(Math.ceil(((Math.ceil(Double.parseDouble(issue_qty_val+"")/conv_factor))*(conv_factor))/base_to_def_uom_equl)).doubleValue(); 
								//bean.setIssueUomQty(order_id+order_line_no+item_code+"_qty",issue_qty_val+""); //moved from common to  specific  MMS-SCF-0040 [IN:041888] // commented for IN:6585
								issue_qty_val  =  new Float(Math.ceil(issue_qty_val*base_to_def_uom_equl)).doubleValue(); //Added for  MMS-SCF-0040 [IN:041888] 
								bean.setIssueUomQty(order_id+order_line_no+item_code+"_qty",issue_qty_val+""); // Added for IN:6585
							}
							else{
								 if(qty_uom!=base_uom){   //if block and else condition added for SKR-SCF-0377 [IN:030453]
									 conv_factor    = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
									 issue_qty_val  =  new Float(Math.ceil(tmp_unit_qty*base_to_disp_uom_equl)).doubleValue(); 
								 }
								 else{ 
									  issue_qty_val  = tmp_unit_qty;	
								 }	
								bean.setIssueUomQty(order_id+order_line_no+item_code+"_qty",tmp_unit_qty+""); //Moved from common to specific for  MMS-SCF-0040 [IN:041888]
							}                   

							//bean.setIssueUomQty(order_id+order_line_no+item_code+"_qty",tmp_unit_qty+""); //Commented for  MMS-SCF-0040 [IN:041888]
							//bean.setIssueUomQty(order_id+order_line_no+item_code+"_qty",issue_qty_val+"");//Commented for  MMS-SCF-0040 [IN:041888]
							bean.setIssueUomQty(order_id+order_line_no+item_code+"_uom",dflt_issue_uom);
							bean.setIssueUomQty(order_id+order_line_no+item_code+"_desc",bean.getUOMDesc ( dflt_issue_uom));
							bean.setIssueUomQty(order_id+order_line_no+item_code+"_equl",base_to_def_uom_equl+"");

							//item_cost				=	bean.getItemCost(item_code,store_code,tmp_unit_qty+"",end_date);
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
							params.put("CUT_OFF_DATE",end_date);
							params.put("VERIFY_INSUFFICIENT_QTY","FALSE");
							params.put("ALREADY_USED_QTY","");
							params.put("MIN_EXP_DATE",end_date);
							if(bean_1.get2DBarcodeApplicable().equals("Y") && !barcode_id.equals("")){//Added if condition for MMS-DM-CRF-0174.5
								  stock = (HashMap)bean_2.get2DBarcodeDetails(params);
				            }else{
							      stock				= (HashMap)bean_2.getBatches(params);
							}
							if(stock.size()>0){
								stock_det           = (ArrayList)stock.get("BATCH_DATA");
								if(trade_code.equals("") && stock.containsKey("EXCEPTION")){ // Added for KAUH-SCF-0094 [IN:035252] -- begin When Trade and Stock is blank, Alternate trade should be taken 
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
									bean_st.setCuttOffDate(end_date);//Added for SKR-SCF-1593
									bean_st.loadResultPage("","","");
									bean_st.setModuleId("PH") ; //Added for KDAH-SCF-0243 [IN:049577]
									listRecord			=		bean_st.getDataList();
									if(listRecord!=null && listRecord.size()>0){
										trade_code=((HashMap)listRecord.get(0)).get("TRADE_NAME").toString();
										params.remove("ITEM_CODE");
										params.put("ITEM_CODE",item_code+"="+trade_code);
										//params.put("ITEM_CODE",item_code);
										if(bean_1.get2DBarcodeApplicable().equals("Y") && !barcode_id.equals("")){//Added if condition for MMS-DM-CRF-0174.5
								           stock = (HashMap)bean_2.get2DBarcodeDetails(params);
				                        }else{
										   stock				= (HashMap)bean_2.getBatches(params);
										}
										stock_det           = listRecord;
									}
								}
								// Added for KAUH-SCF-0094 [IN:035252] -- end
								//code for setting batch details in bean
								alloc_drug_detail	=	new ArrayList();
								tmp_unit_qty =issue_qty_val; //Added for  MMS-SCF-0040 [IN:041888]
								//if(!stock.containsKey("EXCEPTION")){//if condition added for ML-BRU-SCF-0905 [IN:041285]- Ganga //Commented for TTM-SCF-0096 [IN:048808]
									for (int j=0;j<stock_det.size();j++){
										batch_det =(HashMap)stock_det.get(j);
										avail_qty			= (String)batch_det.get("AVAIL_QTY");
										if(Double.parseDouble(avail_qty) < 1.0)
											continue;

										alloc_drug_detail.add(batch_det.get("ITEM_CODE"));
										alloc_drug_detail.add(batch_det.get("BATCH_ID"));
										alloc_drug_detail.add(batch_det.get("EXPIRY_DATE"));

										/*if(qty_uom!=base_uom){   //added for SKR-SCF-0377 [IN:030453] - start
											conv_factor    = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
											issue_qty_val  =  new Float(Math.ceil(tmp_unit_qty*base_to_disp_uom_equl)).doubleValue(); 
											issue_qty_val  =  new Float(Math.ceil(((Math.ceil(Double.parseDouble(issue_qty_val+"")/conv_factor))*(conv_factor))/base_to_def_uom_equl)).doubleValue(); 
										}*/// Commented MMS-SCF-0040 [IN:041888] 
										item_cost	=	bean.getItemCost(item_code,store_code,tmp_unit_qty+"",end_date);
										/*if(qty_uom!=base_uom){ //Commented for  MMS-SCF-0040 [IN:041888]
											conv_factor    = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
											avail_qty  =   retunFormatedInt(Math.floor(Double.parseDouble(avail_qty)/base_to_disp_uom_equl)+""); 
										}
										else{
											avail_qty			= retunFormatedInt(Math.floor(Double.parseDouble(avail_qty))+"");
										}*/ //Added for SKR-SCF-0377 [IN:030453] - end
										avail_qty			= retunFormatedInt(Math.floor(Double.parseDouble(avail_qty))+"");
										if(tmp_unit_qty>Double.parseDouble(avail_qty)){
											tmp_unit_qty =tmp_unit_qty-Double.parseDouble(avail_qty);
											issue_qty =avail_qty;
										}
										else{
											issue_qty =tmp_unit_qty+"";    
										}
										batch_issue_qty =  (String)batch_det.get("QTY"); //Added for  MMS-SCF-0040 [IN:041888]
										tot_issued_qty = tot_issued_qty+Double.parseDouble(issue_qty);
									
										if(base_to_disp_uom_equl!=base_to_def_uom_equl){					  
											// int  alloc_qty = new Float(Math.ceil(((Math.ceil((Float.parseFloat((Double.parseDouble(issue_qty)*base_to_def_uom_equl)+""))/Float.parseFloat(conv_factor+"")))*(conv_factor))/base_to_disp_uom_equl)).intValue(); 
											//int  alloc_qty = new Float(Math.ceil(((Math.ceil((Float.parseFloat((Double.parseDouble(issue_qty)*base_to_def_uom_equl)+""))/Double.parseDouble(conv_factor+"")))*(conv_factor))/base_to_disp_uom_equl)).intValue();  //Added for  MMS-SCF-0040 [IN:041888]
											//issue_qty = alloc_qty+""; //Commented for  MMS-SCF-0040 [IN:041888]
											alloc_drug_detail.add(issue_qty); //moved from common to specific for  MMS-SCF-0040 [IN:041888]
											alloc_drug_detail.add(qty_uom);
										} 
										else{ //else block added for  MMS-SCF-0040 [IN:041888]
											if(!qty_uom.equals(base_uom)){
												alloc_drug_detail.add(issue_qty);
												alloc_drug_detail.add(qty_uom);
											}
											else{
												alloc_drug_detail.add(batch_issue_qty);
												alloc_drug_detail.add(base_uom);
											}
										}
									
										//alloc_drug_detail.add(issue_qty);
										//alloc_drug_detail.add(base_uom);
										//alloc_drug_detail.add(qty_uom);
										alloc_drug_detail.add("");
										alloc_drug_detail.add(batch_det.get("TRADE_ID"));
										alloc_drug_detail.add(batch_det.get("BIN_LOCATION_CODE"));
										alloc_drug_detail.add(item_cost);
										alloc_drug_detail.add(base_uom);  //Added for for  MMS-SCF-0040 [IN:041888]
									}
								/*}
								else{//added ElseCondition by Ganga for ML-BRU-SCF-0905 [IN:041285]	
									alloc_readonly ="disabled";
								}*///Commented for  TTM-SCF-0096 [IN:048808]
									hold_status	="disabled";
									/*==========code added to handle if dispense uom and default uom in item store is different=================*/
									/*if(base_to_disp_uom_equl!=base_to_def_uom_equl){ //Commeted for  MMS-SCF-0040 [IN:041888]

										// int  alloc_qty = new Float(Math.ceil(((Math.ceil((Float.parseFloat((tot_issued_qty*base_to_def_uom_equl)+""))/Float.parseFloat(conv_factor+"")))*(conv_factor))/base_to_disp_uom_equl)).intValue();  
										int  alloc_qty = new Float(Math.ceil(((Math.ceil((Double.parseDouble((tot_issued_qty*base_to_def_uom_equl)+""))/(conv_factor)))*(conv_factor))/base_to_disp_uom_equl)).intValue(); 
										tot_issued_qty = alloc_qty;
									} */
									if(bean_1.getBarcode_Scan_YN().equals("Y") && barcode_id.equals("") && bean_1.getOrderType().equals("NOR")){ // Added for [IN:064158] - Start
										tot_issued_qty=0;
									} // Added for [IN:064158] - End
									if(!qty_uom.equals(base_uom)){ //if & else block added for  MMS-SCF-0040 [IN:041888]
										conv_factor    = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
										tot_issued_qty  =   Math.floor(tot_issued_qty/base_to_disp_uom_equl); 
									}
									else{
										tot_issued_qty			= Math.floor(tot_issued_qty);
									} //Added for SKR-SCF-0377 [IN:030453] - end
									bean.setDrugDetail(patient_id,order_id,order_line_no,alloc_drug_detail);
									bean.setDrugQuantity(patient_id,order_id,order_line_no,tot_issued_qty);
								}	
							}
							else{
								if(!item_uom_definition_flag){
								item_uom_definition_flag=true;
							}
							alloc_readonly ="disabled"; 
						}
							//if condition added for SKR-SCF-1423
								if(stock_opt.get(0).equals("Y") && qty.equals("") && tot_issued_qty==0)
									hold_status = "";
					}
					/*==========code added to handle if dispense uom and default uom in item store is different=================*/
					IssueUomQty		= (HashMap)bean.getIssueUomQty();
					issue_qty_dtl   =  new StringBuffer();
					if(IssueUomQty.containsKey(order_id+order_line_no+drug_code+"_qty")&& base_to_disp_uom_equl!=0){
						issue_qty_value	= (String)IssueUomQty.get(order_id+order_line_no+drug_code+"_qty");
						issue_uom_desc	= (String)IssueUomQty.get(order_id+order_line_no+drug_code+"_desc");
						issue_uom	    = (String)IssueUomQty.get(order_id+order_line_no+drug_code+"_uom");
						issue_uom_equl	= (String)IssueUomQty.get(order_id+order_line_no+drug_code+"_equl");

						if(bean_1.getIssueByUOM().equals("I")){ 
							issue_qty_dtl   =  issue_qty_dtl.append("( ").append(retunFormatedInt(issue_qty_value)).append("  ").append(issue_uom_desc).append(" )");
						}
					}
					if(Min_Rol_yn){ ///Added AMS-CRF-0068.1 [IN:050333] start
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
							if ( Double.parseDouble(avail_qty)   <  Double.parseDouble(frm_store_min_stk_level)){
								min_stk = true;
								if(getReq_allowed_yn)
									disp_req_flag =  "display:inline;color:blue";
								else
									disp_req_flag = "display:none";
							}
						}
						if(!frm_store_reorder_level.equals("0")){
							if ( Double.parseDouble(avail_qty)   <  Double.parseDouble(frm_store_reorder_level)){
								rol_stk = true; 
								if(getReq_allowed_yn)
									disp_req_flag = "display:inline;color:blue";
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
								rol_flag_bkg_clr = "style='background-color:none'";
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
					}//Added AMS-CRF-0068.1 [IN:050333] end
					if(!exceed_dose.equals("")){ //if condition added for ML-MMOH-CRF-1408 -start
							String repeat_value = 											bean_1.getFreqRepeatCode(order_id, order_line_no).split("~")[2];
							 celling_dose = bean_1.getMinMaxCeilingDose(drug_code,patient_id,repeat_value,order_id,order_line_no);
							 if(celling_dose!=null && celling_dose.size()>0){
								min_unit_ceiling_dose = (String)celling_dose.get(0);
								max_unit_ceiling_dose = (String)celling_dose.get(1);
								min_daily_ceiling_dose = (String)celling_dose.get(2);
								max_daily_ceiling_dose = (String)celling_dose.get(3);
							 }
							
						}
%>
				<tr id='<%="RECORD"+(recCount-1)%>' name='<%="RECORD"+(recCount-1)%>'  <%=taper_disable%>>
<%                       if(intractn_req_yn && order_type.equals("NOR")){ // Added for MMS-KH-CRF-0028 [IN070605] - Start
%>					       <td> 
	                          <input type="checkbox" name="deliveryChecked_<%=recCount%>" id="deliveryChecked_<%=recCount%>" onclick="setValue(this)" checked  value="Y" > <!--added for GHL-CRF-453 -->
                           </td>

<%                        }
                         else{
%>                          
                             <input type="hidden" name="deliveryChecked_<%=recCount%>" id="deliveryChecked_<%=recCount%>" value="Y">
<% 	
                         } // Added for MMS-KH-CRF-0028 [IN070605] - End 
                         if(iqvia_integration_flag){
                         if(pat_class.equalsIgnoreCase("O") && bean_1.getSettlementId().equals("X")  && (iv_prep_yn.equals("")|| iv_prep_yn==null || iv_prep_yn.equals("null")) ){ //added for MOHE-CRF-0026.1 START 
                         %>
                         <td> 
						    <input type="checkbox" name="authChecked_<%=recCount%>" id="authChecked_<%=recCount%>" checked onclick="setValueAuth(this)" value="Y" checked> 
					     </td>
					      <input type="hidden" name="authChecked1_<%=recCount%>" id="authChecked1_<%=recCount%>" value="Y">
					<%} }//END %>
					<td class="white" width="6%">
						<table border="1" width="100%" cellpadding="0" cellspacing="0" align="center">
							<tr>
<%	
							if(allergy.equals("")) { 
%>
								<td class="white" width="20%">&nbsp;</td> <!-- 33% changed to 20% for MMS-KH-CRF-0013 -->
<%	
							}
							else{ //order_id,order_line_no,(recCount),patient_class,review_called_from FOR IN070605
%>
								<td class='ALLERGY' width="20%" style="cursor:pointer" onClick="showAllergyDetails('<%=generic_id%>','<%=patient_id%>','<%=encounter_id%>','<%=java.net.URLEncoder.encode(generic_name,"UTF-8")%>','<%=java.net.URLEncoder.encode(drug_name,"UTF-8")%>','<%=order_id%>','<%=order_line_no%>','<%=(recCount)%>','<%=patient_class%>','')">&nbsp;</td> <!-- 33% changed to 20% for MMS-KH-CRF-0013 -->
<%	
							}	
							if(exceed_dose.equals("")) {
%>
								<td class="white" width="20%">&nbsp;</td> <!-- 33% changed to 20% for MMS-KH-CRF-0013 -->
<% 
							}
							else{ //order_id,order_line_no,(recCount),patient_class,review_called_from FOR IN070605	
%>
								<td class='DOSELIMIT3' width="20%" style="cursor:pointer" onClick="showMonoGraph('<%=drug_name%>','<%=java.net.URLEncoder.encode(monograph)%>','<%=daily_dose%>','<%=unit_dose%>','<%=min_unit_dose%>','<%=min_daily_dose%>','<%=dosage_unit%>','<%=std_dose%>','<%=dose_unit_desc%>','<%=order_id%>','<%=order_line_no%>','<%=(recCount)%>','<%=patient_class%>','','<%=max_daily_ceiling_dose%>','<%=min_daily_ceiling_dose%>','<%=max_unit_ceiling_dose%>','<%=min_unit_ceiling_dose%>','<%=ceil_dose_unit_desc%>')">&nbsp;</td> <!-- 33% changed to 20% for MMS-KH-CRF-0013 and ceiling dose added for ML-MMOH-CRF-1408 and changed dose_unit_desc to ceil_dose_unit_desc for 1408-->
<% 
							}	
							if(duplicate_yn.equals("Y") || !duplicate_drug_override_reason.equals("")) { //order_id,order_line_no,(recCount),patient_class,review_called_from FOR IN070605
%>
								<td class='CURRENTRX' width="20%" style="cursor:pointer" onClick="callActiveOrders('<%=patient_id%>','<%=encounter_id%>','<%=generic_id%>','<%=order_id%>','<%=order_line_no%>','<%=(recCount)%>','<%=patient_class%>','')">&nbsp;</td> <!-- 33% changed to 20% for MMS-KH-CRF-0013 -->
<%	
							}	
							else{	
%>
								<td class="white" width="20%">&nbsp;</td> <!-- 33% changed to 20% for MMS-KH-CRF-0013 -->
<%	
							}
							if(iv_prep_yn.equals("")){ // Added for MMS-KH-CRF-0013 - Start and removed intractn_req_yn && for MMS-KH-CRF-0029
							pres_bean.setEncounterId(encounter_id); //MMS-KH-CRF-0029
								if(!drug_db_interface_yn.equals("Y") && pres_bean.getDrugInteractionDtls(drug_code, bean_1.getForm_code(order_id+order_line_no+drug_code), generic_id, start_date, end_date, patient_id).size()>2) { 											
						    	    
									form_code = bean_1.getForm_code(order_id+order_line_no+drug_code);
									form_desc = bean_1.getForm_descs(order_id+order_line_no+drug_code);
%>
								<td class='DINTERACN' width="20%" style="cursor:pointer" onClick="showDispInractionDtl('<%=patient_id%>','<%=encounter_id%>','<%=drug_code%>','<%=form_code%>','<%=generic_id%>','<%=start_date%>','<%=end_date%>','<%=java.net.URLEncoder.encode(drug_name,"UTF-8")%>','<%=java.net.URLEncoder.encode(form_desc,"UTF-8")%>','<%=order_id%>','<%=order_line_no%>','<%=(recCount)%>','<%=patient_class%>','')">&nbsp;</td><!-- order_id,order_line_no,(recCount),patient_class,review_called_from FOR IN070605 -->
								
<% 
				            }
					       else{	
%>
					    	   <td class="white" width="20%">&nbsp;</td> 
<%						    	   
							   }
							}// Added for MMS-KH-CRF-0013 - End
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
		%>
							</tr>
						</table>
					</td>
					<td class="<%=classvalue%>"   width="3%" nowrap <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" >
<% 
					if (hold_status.equals("disabled")){
%>
						<!-- <label style="color:black;font-size:9px;" id='hold_remarks_<%=recCount%>'><%=hold_text%></label> -->
                         <label style="color:black;font-size:9px;" onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" onClick="callReason(this,'<%=order_id%>','<%=drug_code%>','<%=recCount%>','<%=order_line_no%>','AS','<%=scope%>');" id='hold_remarks_<%=recCount%>'  <%=hold_status%> <%=disable_alloc_text_box%> <%=taper_disable%>><%=hold_text%></label>
						<input type="checkbox" name="hold<%=recCount%>" id="hold<%=recCount%>" style='display:none'  value="<%=check_value%>" <%=check_status%>>
<%
					}	
					else{
%>
						<label style="cursor:pointer;color:blue;font-size:9px;" onClick="callReason(this,'<%=order_id%>','<%=drug_code%>','<%=recCount%>','<%=order_line_no%>','AS','<%=scope%>');notifyChange()" id='hold_remarks_<%=recCount%>' <%=disable_alloc_text_box%> <%=taper_disable%>><%=hold_text%></label>
						<input type="checkbox" name="hold<%=recCount%>" id="hold<%=recCount%>" style='display:none' value="<%=check_value%>" <%=check_status%>>
<%
					}
%>
					<input type="hidden" name="drug_code<%=recCount%>" id="drug_code<%=recCount%>" value="<%=drug_code%>">
					<input type="hidden" name="stock_yn<%=recCount%>" id="stock_yn<%=recCount%>" value="<%=stock_opt%>">
					<input type="hidden" name="fromdb_<%=recCount%>" id="fromdb_<%=recCount%>" value="<%=fromdb%>">
					<input type="hidden" name="hold_status<%=recCount%>" id="hold_status<%=recCount%>" value="<%=hold_status%>">
					<input type="hidden" id="last_scanned_<%=recCount%>" value="<%=last_scanned%>"> <!-- Added for GHL-CRF-0463 // changed for MMS-DM-SCF-0488 -->
					</td>
	<%					//GHL-CRF-549 - start
						if(bl_install_yn.equals("Y") && !iv_prep_yn.equals("7") && !iv_prep_yn.equals("8") && item_type_site_app && !encounter_id.equals("")){
							low_cost_green_style ="visibility:hidden";
							high_margin_green_style ="visibility:hidden";
							high_margin_red_style   ="visibility:hidden";
							low_cost_red_style	="visibility:hidden";
							low_cost_grey_style ="visibility:hidden";
							high_margin_grey_style ="visibility:hidden";
							innovator_style		="visibility:hidden"; 
							high_margin_grey_style = "visibility:hidden"; 
							low_cost_grey_style="visibility:hidden";
							item_type= bean.getItemType(drug_code);
							mm_item_low_cost_yn = item_type.split("~")[0];
							mm_item_high_margin_yn = item_type.split("~")[1];
							mm_item_Innovator_yn = item_type.split("~")[2];
						if(!bl_grp_app.equals("N")){
						if(mm_item_low_cost_yn.equals("Y")) {
							if(bl_grp_app.equals("L")){
									low_cost_green_style ="visibility:visible";
									low_cost_red_style = "visibility:hidden";
									low_cost_grey_style = "visibility:hidden";
									
								if(mm_item_high_margin_yn.equals("Y")){
									high_margin_red_style = "visibility:visible";
									high_margin_green_style ="visibility:hidden";
									high_margin_grey_style = "visibility:hidden";
								}else{
									high_margin_grey_style = "visibility:hidden";
								}
							}else{
								if(bl_grp_app.equals("H")){
									low_cost_green_style ="visibility:hidden";
									low_cost_red_style = "visibility:visible";
									low_cost_grey_style = "visibility:hidden";
								}
							} 
						}else{
								low_cost_green_style ="visibility:hidden";
								low_cost_red_style = "visibility:hidden";
								low_cost_grey_style = "visibility:hidden";
						}
						if(mm_item_high_margin_yn.equals("Y")){
								if(bl_grp_app.equals("H")){
									high_margin_green_style ="visibility:visible";
									high_margin_red_style = "visibility:hidden";
									high_margin_grey_style = "visibility:hidden";
									if(mm_item_low_cost_yn.equals("Y")) {
									low_cost_red_style ="visibility:visible";
									low_cost_green_style = "visibility:hidden";
									low_cost_grey_style = "visibility:hidden";
									}

								}else{
									if(bl_grp_app.equals("L")){
										high_margin_red_style = "visibility:visible";
									}
								}
						}else{
							
								high_margin_green_style ="visibility:hidden";
								high_margin_red_style = "visibility:hidden";
								high_margin_grey_style = "visibility:hidden";
						}

						if(mm_item_Innovator_yn.equals("Y")){
								innovator_style		="visibility:visible";		
							}else{
								innovator_style		="visibility:hidden";		
							}
						}
					else{
						low_cost_green_style = "visibility:hidden";
						high_margin_green_style = "visibility:hidden";
						low_cost_red_style = "visibility:hidden";
						high_margin_red_style = "visibility:hidden";

						if(mm_item_low_cost_yn.equals("Y"))
							low_cost_grey_style = "visibility:visible";		
						else
							low_cost_grey_style = "visibility:hidden";					

						if(mm_item_high_margin_yn.equals("Y"))
							high_margin_grey_style = "visibility:visible";
						else
							high_margin_grey_style = "visibility:hidden";
						
						if(mm_item_Innovator_yn.equals("Y"))
							innovator_style		="visibility:visible";		
						else
							innovator_style		="visibility:hidden";		
					}
						
								if(formulary_billing_app){ //GHL-CRF-0618 - start
									high_margin_red_style = "visibility:hidden";
									high_margin_green_style ="visibility:hidden";
									low_cost_green_style ="visibility:hidden";
									low_cost_red_style = "visibility:hidden";
									
									if(mm_item_low_cost_yn.equals("Y")){
										low_cost_grey_style = "visibility:visible";
									}else{
										low_cost_grey_style = "visibility:hidden";
									}
									if(mm_item_high_margin_yn.equals("Y")){
										high_margin_grey_style = "visibility:visible";								
									}else{
										high_margin_grey_style = "visibility:hidden";
									}
									if(mm_item_Innovator_yn.equals("Y")){
										innovator_style		="visibility:visible";
									}else{
										innovator_style		="visibility:hidden";
									}
									preference_img = "";
									preference = "";
								
									if(hmBlgGrp!=null && hmBlgGrp.size()>0){
										if(hmBlgGrp.containsKey(drug_code)){
											preference = (String)hmBlgGrp.get(drug_code)==null?"":(String)hmBlgGrp.get(drug_code);
											preference_img = "";
											if(preference.equals("P1")){
												preference_img ="<img src='../../ePH/images/Preference1.jpg' height='15' width='15' title='Prefered-1 Item' />";
											}else if(preference.equals("P2")){
												preference_img ="<img src='../../ePH/images/Preference2.jpg' height='15' width='15' title='Prefered-2 Item' />";
											}else if(preference.equals("P3")){
												preference_img ="<img src='../../ePH/images/Preference3.jpg' height='15' width='15' title='Prefered-3 Item' />";
											}else{
												preference_img ="<img src='../../ePH/images/Preference4.jpg' height='15' width='15' title='Non Prefered Item' />";
											}
										}else{
												preference_img ="<img src='../../ePH/images/Preference4.jpg' height='15' width='15' title='Non Prefered Item' />";
											}

									}
								}
								//GHL-CRF-0618 - end

%>								<td class='<%=classvalue%>'>&nbsp
								<%if(!low_cost_green_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/LowCostGreen.jpg" style='<%=low_cost_green_style%>' height='15' width='15' ><%}
								if(!high_margin_green_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/HighMarginGreen.jpg" style="<%=high_margin_green_style%>" height='15' width='15' >
								<%}if(!low_cost_red_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/LowCostRed.jpg" style="<%=low_cost_red_style%>" height='15' width='15' ><%}if(!high_margin_red_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/HighMarginRed.jpg" style="<%=high_margin_red_style%>" height='15' width='15' ><%} if(!low_cost_grey_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/LowCost.jpg" style="<%=low_cost_grey_style%>" height='15' width='15' title="Low Cost Item" ><%} if(!high_margin_grey_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/HighMargin.jpg" style="<%=high_margin_grey_style%>" height='15' width='15'  title="High Margin Item" ><%}if(!innovator_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/Innovator.jpg" title="Innovator Item" style="<%=innovator_style%>"  height='15' width='15' > <%} %></td>
								
								<%if(formulary_billing_app){ %>								
									<td class="<%=classvalue%>"><%=preference_img%>&nbsp;</td>
<%									}
								}	
								%>
								
<%
								if(aggred_item_app){
								if( category_code.equals("B")&& alternate_yn.equals("Y")){
								%>	
								<td style="background-color: #00FFFF" >
								</td>
								<%}
								else if(category_code.equals("B")){
								%>	
								<td style="background-color: #7CFC00">
								</td>
							<%	}
								else{
									%>
									<td>
								</td>
							<%	}}
								%>
					<td class="<%=classvalue%>" style="font-size:9px;" width="41%" <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" nowrap>
						<label style='color:red;font-size:12px;FONT-WEIGHT: BOLDER;cursor:pointer;' onclick="showDrugMasterValues('<%=drug_code%>');" id="drug_mast_det_<%=recCount%>">&nbsp;+&nbsp;</label>
						<label style='<%=drug_style%>' onclick="showDrugDetails('OP','<%=source_code%>','<%=order_id%>','<%=drug_code%>','<%=order_line_no%>','','<%=bean_1.getDispLocnCode()%>','','', '<%=patient_id%>','Y','<%=generic_id%>','<%=current_order_line_status%>');" id="drug_desc<%=recCount%>"><%=drug_name%></label>&nbsp;&nbsp; <!--  , 'patient_id' added for [IN:035667] --><!-- Added for '','', Inc No : 41282  ('Y',generic_id, order_line_status Added for JD-CRF-0198 [IN058599]) -->
<%
						taperValues=bean.chkfortapering(order_id,drug_code, order_line_no, patient_id);	//Modified for RUT-CRF-0088 [IN036978] 		
						count =Integer.parseInt(taperValues.get("COUNT").toString()); 
						tot_tap=Float.parseFloat(taperValues.get("TOT_QTY").toString());	
						if(count>1){
							String taper = bean.getTapervalue();
							if(taper.equals("UP")){
%>
								<img src="../../ePH/images/uparrow.gif" onclick="showTaperDetails('<%=patient_id%>','<%=order_id%>','<%=drug_code%>');" valign="center" title='<fmt:message key="ePH.TaperDose.label" bundle="${ph_labels}"/>' style="cursor:pointer"height='20' width='20'></img>
<%
							}
							else if(taper.equals("DOWN")){
%>
								<img src="../../ePH/images/downarrow.gif" onclick="showTaperDetails('<%=patient_id%>','<%=order_id%>','<%=drug_code%>');" valign="center" title='<fmt:message key="ePH.TaperDose.label" bundle="${ph_labels}"/>' style="cursor:pointer" height='20' width='20'></img>
<% 
							}
							else{
%>
								<img src="../../ePH/images/MultiFrequency.gif" onclick="showTaperDetails('<%=patient_id%>','<%=order_id%>','<%=drug_code%>');" valign="center" title='<fmt:message key="ePH.TaperDose.label" bundle="${ph_labels}"/>' style="cursor:pointer" height='20' width='20' ></img>
<%
							}
							if(totalTaperQtyDisplay.equals("Y")){ //Added for RUT-CRF-0088 [IN036978]
%>
								<fmt:message key="Common.total.label" bundle="${common_labels}"/><fmt:message key="Common.Taper.label" bundle="${common_labels}"/><fmt:message key="Common.Qty.label" bundle="${common_labels}"/>   <!--Added for RUT-CRF-0088 [IN036978] -->
								<label>-<%=(int)tot_tap%>&nbsp;&#40;<%=qty_uom_disp%>&#41;</label>  <!--Added for RUT-CRF-0088 [IN036978] -->
<%				
							}
						}
						//added for mms-kh-crf-0028 start
				
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
								//drug_name = java.net.URLEncoder.encode(drug_name,"UTF-8");//IN071555 and commented for SKR-SCF-1338
								String drug_name_1=  drug_name;   //moved from down to up
								if(barcode_scan_for_alt_app){
								//changed intractn_req_yn to barcode_scan_for_alt_app for MMS-KH-CRF-0030
				%>
  <!--  <img src="../../ePH/images/altenate.jpg" height='15' width='15' align='top' onClick="callMultiStrength('<%=drug_code%>','<%=drug_name%>','<%=patient_id%>','<%=order_id%>','<%=order_line_no%>','Alloc','<%=store_code%>','<%=pres_qty%>','<%=end_date%>','<%=strength_uom%>','<%=recCount%>','<%=alt_drug_remarks_ind%>','<%=expiry_date%>','<%=disp_locn_catg%>','<%=allow_alternate_yn%>','<%=item_type_site_app%>','<%=strength_value%>','<%=iv_prep_yn%>','<%=alt_called_from%>','<%=disp_stage%>');" style='cursor:pointer' title='<fmt:message key="ePH.AlternateDrugs.label" bundle="${ph_labels}"/>'> --> 
				  <img src="../../ePH/images/altenate.jpg" height='15' width='15' align='top' style='cursor:pointer' onClick="getAlternateDrug('<%=drug_code%>','','<%=patient_id%>','<%=order_id%>','<%=order_line_no%>','AllStage','<%=store_code%>','<%=pres_qty%>','<%=end_date%>','<%=strength_uom%>','<%=recCount%>','','<%=expiry_date%>','<%=disp_locn_catg%>','<%=allow_alternate_yn%>','<%=item_type_site_app%>','<%=strength_value%>','<%=iv_prep_yn%>','<%=alt_called_from%>','<%=disp_stage%>','Y','<%=classvalue%>','<%=generic_id%>','<%=barcodeScan%>')" title='<fmt:message key="ePH.AlternateDrugs.label" bundle="${ph_labels}"/>'>

			<%		
			}//added for mms-kh-crf-0028 end
						if(bmscount==0){
							if(pat_couns_reqd_yn.equals("Y")){
								pat_reqd="Checked"; 
%>
						<img src="../../ePH/images/Patientcounsel.gif" valign="center"  ></img>
						<input type='checkbox' name='pat_reqd_<%=recCount%>' id='pat_reqd_<%=recCount%>' <%=pat_reqd%> disabled value='C' onclick="CheckPatReqd(this)">
<%
					}
					if(pat_couns_reqd_yn.equals("C")){
						pat_reqd="Checked";	
%>
						<img src="../../ePH/images/Patientcounsel.gif"  ></img>
						<input type='checkbox' name='pat_reqd_<%=recCount%>' id='pat_reqd_<%=recCount%>' <%=pat_reqd%> disabled value=''>
<%
					} 
					if(pat_couns_reqd_yn.equals("N")|| pat_couns_reqd_yn.equals("Null") ){
						pat_reqd="Unchecked";	
						//pt_couns_reqd_yn       =   bean.getPatCounsReqd(drug_code);
						if(pt_couns_reqd_yn.equals("Y")){
%>
							<img src="../../ePH/images/Patientcounsel.gif"  ></img>
							<input type='checkbox' valign='center' name='pat_reqd_<%=recCount%>' id='pat_reqd_<%=recCount%>' <%=pat_reqd%> value='' onclick='CheckPatReqd(this)'>
<%
						}
					}
				}
	//			String drug_name_1=  drug_name;   // moved to up
							
				if(!drug_name_1.equals("")&&drug_name_1!=null){
					drug_name_1=drug_name_1.replaceAll(" ","%20");
					drug_name_1=	java.net.URLEncoder.encode(drug_name_1);
					drug_name_1=drug_name_1.replaceAll("%2520","%20");
				}

				if ((ext_prod_id!=null)&& !(ext_prod_id.equals("")) && drug_db_interface_yn.equals("Y")){
%>
					<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/info.gif" height=20  width=20 onClick="showDrugInfo('<%=ext_prod_id%>','<%=drug_name_1%>')">
<%
				}
				if ((image_path!=null)&& !(image_path.equals(""))){
%>
					<img style="cursor:pointer;" src="../../ePH/images/camera.gif" height=20  width=20 onClick="showImage('<%=drug_code%>','<%=trade_code%>')">
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
					// if((bean_1.getDispLocnCatg()).equals("I")) {
					 disp_info	=	bean.getLastDispense(order_id,order_line_no);
					 if(disp_info.size() > 0) {				

						if( ((String)disp_info.get(1)).equals("Y")) {
							dosage_dtls =dosage_dtls+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color='red'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DispensedToday.label","ph_labels")+"</font>";
						}
						dosage_dtls =dosage_dtls+"&nbsp;&nbsp;&nbsp;&nbsp;<font color='red'style='cursor:pointer;' title='"+disp_info.get(0)+"' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.LastDispense.label","ph_labels")+"</font>";
					}
					//}	
%>
					<%=alt_drug_remarks_disp%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=dosage_dtls%><!-- <%=alt_drug_remarks_disp%> added for  Bru-HIMS-CRF-082 [IN:029948] -->
<% 
				}
%>
				<!-- added for MMS-KH-CRF-0030 - start -->
				<div id="alternate_<%=recCount%>" style="display:none">
				 <table cellpadding="0" cellspacing="0" width='100%' align="center" border="1" id="alternate_header_<%=recCount%>">
				<!-- 
 				<tr> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<td class="<%=classvalue%>" width="20%"  style='text-align:right;'><font style='font-size:10;vertical-align: text-top;'>Barcode</font> <input type="text" class='fields' name="barcode_id_<%=recCount%>" id="barcode_id_<%=recCount%>" style="text-align:right"  onkeydown="if (event.keyCode==13) {}" maxlength="50"  >
					</td>

				</tr>

				 <tr>
					<td class= "<%=classvalue%>" width="30%"><fmt:message key="ePH.AlternateDrugNames.label" bundle="${ph_labels}"/></td>

				 <td class= "<%=classvalue%>" width="20%"><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
				<td class= "<%=classvalue%>" width="5%"><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/></td>
				<td class= "<%=classvalue%>" width="5%"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
				<td class= "<%=classvalue%>" width="5%"><fmt:message key="ePH.AllocatedQuantity.label" bundle="${ph_labels}"/></td>
				 </tr>
				-->			
				 </table>
				<table cellpadding="0" cellspacing="0" width='100%' align="center" border="1" id="alternate_dtl_header_<%=recCount%>">
				</table>
				<table cellpadding="0" cellspacing="0" width='100%' align="center" border="1" id="alternate_dtl_footer_<%=recCount%>">
				</table>
				</div>
				<!-- added for MMS-KH-CRF-0030 - end -->

				<br><label id="id_min_stk_label" style='<%=min_stk_flag%>;'><fmt:message key="ePH.MINLEVEL.label" bundle="${ph_labels}"/>:</label><!--Added AMS-CRF-0068.1 [IN:050333] start  -->
				<label id="id_min_str_stk_<%=recCount%>" style='<%=min_stk_flag_bkg_clr%>;<%=min_stk_flag%>'><b><%=frm_store_min_stk_level%></b></label>&nbsp;&nbsp;
				<label id="id_stk_rol_label_<%=recCount%>" style='<%=rol_flag%>;'><fmt:message key="ePH.ROL.label" bundle="${ph_labels}"/>:</label>
				<label  id="id_stk_rol_<%=recCount%>" style='<%=rol_flag_bkg_clr%>;<%=rol_flag%>'><b><%=frm_store_reorder_level%></b></label>&nbsp;
				<label class='HYPERLINK'  name = "request_<%=recCount%>"  onmouseover="changeCursor(this);" onclick="request();" id="sales_req_label" style='<%=disp_req_flag%>' ><b><fmt:message key="ePH.CreateRequest.label" bundle="${ph_labels}"/></b></label><!--Added AMS-CRF-0068.1 [IN:050333] end  -->
				<label class='HYPERLINK'  name = "manufacturing_<%=recCount%>"  onmouseover="changeCursor(this);" onclick="callManufacturingReceipt('<%=drug_code%>','<%=disp_locn_code%>');" id="manufacturing_Recpt" style='<%=disp_mnf_flag%>;' ><b>&nbsp;&nbsp;<fmt:message key="eST.Manufacturing.label" bundle="${st_labels}"/></b></label><!--Added BRU-HIMS-CRF-080 -->
<%
				int	k	=	0;
				alt_qty	=	new ArrayList();
				for(int n=0; n<multi_drugs.size(); n+=5)	{ 
					alt_drug_code		=	(String)multi_drugs.get(n);
					alt_drug_desc		=	(String)multi_drugs.get(n+1);
					altDrugName.put(alt_drug_code,alt_drug_desc);// Added for Bru-HIMS-CRF-072.1 [IN:049144]
					form_code			=	(String)multi_drugs.get(n+2);
					alt_strength_value	=	(String)multi_drugs.get(n+3);
					//alt_strength_uom	=	(String)multi_drugs.get(n+4);
					alt_drug_desc_1	=    alt_drug_desc;
					if(!alt_drug_desc_1.equals("")&&alt_drug_desc_1!=null){
						alt_drug_desc_1=alt_drug_desc_1.replaceAll(" ","%20");
						alt_drug_desc_1=	java.net.URLEncoder.encode(alt_drug_desc_1,"UTF-8"); //Passed UTF-8 to alt_drug_desc_1 for the incident 25007==By Sandhya
						alt_drug_desc_1=alt_drug_desc_1.replaceAll("%2520","%20");
					}
				
					drug_color			=	(String)colors.get(k++);
					pack_dtls			=	bean.getPackSize(alt_drug_code);

					if(pack_dtls!=null && pack_dtls.containsKey("PACK_SIZE")) {
						form_code	=	(String)pack_dtls.get("STOCK_UOM");
					}
					if(pack_dtls!=null && pack_dtls.containsKey("EXTERNAL_PRODUCT_ID")) {
						alt_external_prod_id	=	(String)pack_dtls.get("EXTERNAL_PRODUCT_ID");
					}
					else{
						alt_external_prod_id	=  "";
					}

					qty	=	bean.getAlternateDrugQuantity(patient_id,order_id,order_line_no,alt_drug_code); 

					if(!qty.equals("") && !qty.equals("0")) {
						alt_qty.add(alt_drug_code);
						alt_qty.add(qty);
						alt_qty.add(form_code);
						alt_qty.add(alt_strength_value);
					}
					if(Min_Rol_yn ){ ///Added AMS-CRF-0068.1 [IN:050333] start
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
								if ( Double.parseDouble(qty)  <  Double.parseDouble(frm_store_min_stk_level)){
									min_stk = true;
									if(getReq_allowed_yn)
										disp_req_flag =  "display:inline;color:blue";
									else
										disp_req_flag = "display:none";
								}
							}
							if(!frm_store_reorder_level.equals("0")){
								if ( Double.parseDouble(qty)   <  Double.parseDouble(frm_store_reorder_level)){
									rol_stk = true; 
									if(getReq_allowed_yn)
										disp_req_flag = "display:inline;color:blue";
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
							
							if((min_stk&&getReq_allowed_yn)||(rol_stk&&getReq_allowed_yn)){
								disp_req_flag = "display:inline;color:blue";
							}
							else{
								disp_req_flag  = "display:none;color:blue";
							}
						}
						else{
							rol_flag   =	"display:none";
							min_stk_flag=	"display:inline";
							disp_req_flag  = "display:none";	
							min_stk_flag=	"display:none";
						}
					}//Added AMS-CRF-0068.1 [IN:050333] end
%>	
					<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style='color:red;font-size:12px;FONT-WEIGHT: BOLDER' onclick="showDrugMasterValues('<%=alt_drug_code%>');" id="drug_mast_det_<%=recCount%>">&nbsp;+&nbsp;</label>
					<label style="color:<%=drug_color%>"  id="alte_drug_desc<%=n%>"><%=alt_drug_desc%></label>
<%
					if ((alt_external_prod_id!=null)&& !(alt_external_prod_id.equals(""))&& drug_db_interface_yn.equals("Y")){
%>
						<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/info.gif" height='20'  width='20' onClick="showDrugInfo('<%=alt_external_prod_id%>','<%=alt_drug_desc_1%>')"></img>
<%
					} 
                    adr_count = bean.getADRCount(patient_id,alt_drug_code);
					if(adr_count>0){
%>
		                <img  id="ADR_img" src='../../ePH/images/ADR.gif'  height='20'  width='20' title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>' onclick= "callADRdetails('<%=patient_id%>','<%=alt_drug_code%>')"></img><!-- callADRdetails() newly added for RUT-SCF-0144 [IN:033371]-->
<%
					}
%>
					
					<br><label id="id_min_stk_label" style='<%=min_stk_flag%>;'><fmt:message key="ePH.MINLEVEL.label" bundle="${ph_labels}"/>:</label><!--Added AMS-CRF-0068.1 [IN:050333] start  -->
					<label id="id_min_str_stk" style='<%=min_stk_flag_bkg_clr%>;<%=min_stk_flag%>'><b><%=frm_store_min_stk_level%></b></label>&nbsp;&nbsp;
					<label id="id_stk_rol_label" style='<%=rol_flag%>;'><fmt:message key="ePH.ROL.label" bundle="${ph_labels}"/>:</label>
					<label  id="id_stk_rol" style='<%=rol_flag_bkg_clr%>;<%=rol_flag%>;'><b><%=frm_store_reorder_level%></b></label>&nbsp;
					<label class='HYPERLINK'  name = "request"  onmouseover="changeCursor(this);" onclick="request();" id="sales_req_label" style='<%=disp_req_flag%>;' ><b><fmt:message key="ePH.CreateRequest.label" bundle="${ph_labels}"/></b></label><!--Added AMS-CRF-0068.1 [IN:050333] end  -->
<%
				}	
				String status = "Pending"; //added for mohe-crf-0026.1 START
				String approvedQty = ""; 
				String approvedAmt = ""; 
				Qtystyle = "visibility:visible";
				if (status.equalsIgnoreCase("Pending")){
					Qtystyle = "visibility:hidden"; 
				}//END
				drug_name_1=  drug_name;   
				if(!drug_name_1.equals("")&&drug_name_1!=null){
					drug_name_1=drug_name_1.replaceAll(" ","%20");
					drug_name_1=	java.net.URLEncoder.encode(drug_name_1,"UTF-8");
					drug_name_1=drug_name_1.replaceAll("%2520","%20");
				}
%>
<%
	         if(drug_expiry_alert.equals("Yes") && !drug_expiry_days.equals("")){
%>
                   <label style="color:darkred" id='expiry_aler_lb_<%=recCount%>'>&nbsp; This drug has batches which are going to expire in <%=drug_expiry_days%> Days </label>
<%}%>
				</td>
				<td class="<%=classvalue%>" style="font-size:9px"  >
					<img src="../../ePH/images/DrugRemarks.gif" id='drugRemarks_<%=recCount%>' title='' valign="center"style="cursor:pointer;" onClick="displayInstructions('<%=order_id%>','<%=order_line_no%>','<%=dialog_height%>','<%=drug_name_1%>')"<%=remarks_style%>> <!-- code  ePH.PractitionerPharmacistInstructions replaced by drugs_remarks for Bru-HIMS-CRF-416[IN045566] --> 		
				   <script>
						var drug_remarks = decodeURIComponent('<%=strDrugsRemarks%>');
						eval(document.getElementById("drugRemarks_"+'<%=recCount%>')).title= drug_remarks ;
				   </script>
				</td> 
				<td class="<%=classvalue%>" style="font-size:9px" title="<%=pres_details%>">
					<img src="../../ePH/images/exceed.gif" valign="center">
						 
				</td>
				<%  
				if(iqvia_integration_flag){  //added for mohe-crf-0026.1 START
				if(pat_class.equalsIgnoreCase("O") && bean_1.getSettlementId().equals("X")  && (iv_prep_yn.equals("")|| iv_prep_yn==null || iv_prep_yn.equals("null")) ){ %>
				<td class="<%=classvalue%>" style="font-size:9px" width="10%" >&nbsp;
				<label style='<%=narc_style%>' id="authStatus_<%=recCount%>"><b><%=status%></b> </label><br>&nbsp;
				<label style='<%=Qtystyle%>' id="appQtylabel_<%=recCount%>"><fmt:message key="ePH.ApprovedQty.label" bundle="${ph_labels}"/></label>&nbsp; 
				<label style='<%=narc_style%>' id="appQty_<%=recCount%>"> </label><%=approvedQty%><br>&nbsp;
				<label style='<%=Qtystyle%>' id="appAmtlabel_<%=recCount%>"><fmt:message key="ePH.ApprovedAmount.label" bundle="${ph_labels}"/> </label>&nbsp;
				<label style='<%=narc_style%>'  id="appAmt_<%=recCount%>"> </label><%=approvedAmt%><br>&nbsp;
				<input type="hidden" name="authStatus1_<%=recCount%>" id="authStatus1_<%=recCount%>" value="<%=status%>">
				<input type="hidden" name="appQty1_<%=recCount%>" id="appQty1_<%=recCount%>" value="<%=approvedQty%>">
				<input type="hidden" name="appAmt1_<%=recCount%>" id="appAmt1_<%=recCount%>" value="<%=approvedAmt%>">
				<%} } //END %>
				<td class="<%=classvalue%>" style="font-size:9px" width="10%" <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" >&nbsp;<label style='<%=narc_style%>'><%=retunFormatedInt(pres_qty)%>&nbsp;(<%=qty_uom_disp%>)</label><br>
				<!---/*/*bean.getUomDisplay(facility_id,qty_uom)*/-->
<%
				if(!strength_value.equals("") && !strength_value.equals("0")){
					pres_strength	=	retunFormatedInt((((Float.parseFloat(pres_qty) * Float.parseFloat(strength_value))/(Float.parseFloat(main_strength_per_value_pres_uom)))*(main_drug_pack_size))+"")+" "+strength_uom;
				 pres_strength_1 = retunFormatedInt((((Float.parseFloat(pres_qty) * Float.parseFloat(strength_value))/(Float.parseFloat(main_strength_per_value_pres_uom)))*(main_drug_pack_size))+"")+"";
				}
%>
					&nbsp;
<% 
					if(multi_drugs.size()>1 ) { 
%>
						<b><%=pres_strength%></b>
<%	
					}
%>
					</td>
<% 			
					if(multi_drugs.size() > 1 ) {	

						if((ord_type.equals("NOR") || bEquivalentNormalOrder) && bean_1.getIssueByUOM().equals("I")){
%>
							<td class="<%=classvalue%>">&nbsp;</td>
<%
						}
%>
						<td class="<%=classvalue%>" width="10%" <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" ><br>
<% 
						int x	=	0;
						int tmp_recCount	=	recCount;
						String alternate_drug	=	"";
						float pack_size	=	1;
						float strength_per_value	=	1.0f;

						for(int l=0; l<alt_qty.size(); l+=4) { 
							alternate_drug			=	(String)alt_qty.get(l);	
							qty					=	(String)alt_qty.get(l+1);	
							uom					=	(String)alt_qty.get(l+2);	
							alt_strength_value	=	(String)alt_qty.get(l+3);	
							drug_color			=	(String)colors.get(x++);

							pack_dtls				=	bean.getPackSize(alternate_drug);
							
							IssueUOMAndBaseUOM		=	(HashMap)bean.getStoreDfltIssueUOMAndBaseUOM(store_code,alternate_drug); // Added for ML-BRU-SCF-1803 - Start
							base_uom			     =  (String)IssueUOMAndBaseUOM.get("BASE_UOM")==null?"":(String)IssueUOMAndBaseUOM.get("BASE_UOM");
							base_to_disp_uom_equl    =	bean.getEqulValue ( alternate_drug, base_uom, uom);
							orig_dflt_issue_uom      = (String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM")==null?"":(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM");
							base_to_def_uom_equl	 =  bean.getEqulValue ( alternate_drug, base_uom, orig_dflt_issue_uom);
							medical_applicable=bean.checkMedicalItemYN(alternate_drug);//added for ghl-crf-0548
							if(!uom.equals(base_uom)){
								conv_factor    = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
								//bean.setAlternateDrugQtyForCharge(patient_id,order_id,order_line_no,alt_drug_code,(Double.parseDouble(qty)*conv_factor)+"");//Commented for MMS-DM0SCF-0564
							} // Added for ML-BRU-SCF-1803 - End
							

							if(pack_dtls!=null && pack_dtls.containsKey("PACK_SIZE")) {
								if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
									pack_size			=	Float.parseFloat(((String)pack_dtls.get("PACK_SIZE")));
									if(!medical_applicable.equals("Y")){//added for ghl-crf-0548	
									strength_per_value	=	Float.parseFloat(((String)pack_dtls.get("STRENGTH_PER_VALUE_PRES_UOM")));}
								if(base_to_disp_uom_equl!=base_to_def_uom_equl ){ // added for ML-BRU-SCF-1892 - Start // || (!uom.equals(base_uom) && !alternate_drug.equals("")) Added for ML-MMOH-SCF-1160
								//|| (!uom.equals(base_uom) && !alternate_drug.equals(""))
									qty = (int)Math.ceil(Float.parseFloat(qty)/pack_size)+"";
								}else if(!uom.equals(base_uom) && !alternate_drug.equals("")){ // else if block added for ML-MMOH-SCF-1318 - Start							
									  qty  =   Math.round(Double.parseDouble(qty)/base_to_disp_uom_equl)+""; 
								} // added for ML-BRU-SCF-1892 - End
								// added for ML-BRU-SCF-1892 - End and changed Integer.parseint to Float.parseFloat for MMS-KH-SCF-0035
								}		
							}
	if(!medical_applicable.equals("Y")){//added for ghl-crf-0548	
							tmp_alloc	+=	new Float( ((Float.parseFloat(alt_strength_value)) * Double.parseDouble(qty)*pack_size)/strength_per_value ).doubleValue();

							alloc_strength	=	retunFormatedInt(tmp_alloc+"")+""+strength_uom;}
							//pres_qty		=	bms_qty;
							float prescribed_strength	=	0;
							if(!medical_applicable.equals("Y")){//ADDED FOR GHL-CRF-0548
							prescribed_strength=Float.parseFloat(tmp_bms_qty_1) * 	Float.parseFloat(strength_value)/(Float.parseFloat(main_strength_per_value_pres_uom));
							}
							double balance_strength		=	prescribed_strength - tmp_alloc;	
							
							if(balance_strength<1)
								balance_strength		=	0;

							if(balance_strength!=0) {
								bms_qty						=	Math.round(balance_strength / Float.parseFloat(strength_value))+"";
							} 
							else {
								bms_qty					=	"0";
							}
							bms_qty=Math.round(((Float.parseFloat(bms_qty)*(Float.parseFloat(main_strength_per_value_pres_uom)))/main_pack_size))+"";
							bms_strength				=	balance_strength+"";
							if(medical_applicable.equals("Y")){ //added for ghl-crf-0548 - Start
								bms_qty = (Float.parseFloat(tmp_bms_qty)-Float.parseFloat(qty))+"";
								tmp_bms_qty = bms_qty;
								alloc_strength = "";
								} //added for ghl-crf-0548 - End
							if(qty.equals("") || qty.equals("0")) 
								uom="";	
							else {
								//uom=qty_uom;
								tot_qty		+=	Integer.parseInt(qty);
								//uom			=	"("+uom+")";  // Commented and brackets added below for ML-BRU-SCF-0866 IN040255								
							}

							issue_qty_dtl =new StringBuffer();/*code added to handle if dispense uom and default uom in item store is different==Start*/
							if(IssueUomQty.containsKey(order_id+order_line_no+drug_code+"_qty")){
								issue_qty_value	= (String)IssueUomQty.get(order_id+order_line_no+alternate_drug+"_qty");
								issue_uom	    = (String)IssueUomQty.get(order_id+order_line_no+alternate_drug+"_uom");
								issue_uom_desc	= (String)IssueUomQty.get(order_id+order_line_no+alternate_drug+"_desc");
								issue_uom_equl  = (String)IssueUomQty.get(order_id+order_line_no+alternate_drug+"_equl");
								if(bean_1.getIssueByUOM().equals("I")){
									issue_qty_dtl   =  issue_qty_dtl.append("( ").append(retunFormatedInt(issue_qty_value)).append("  ").append(issue_uom_desc).append(" )");
								}
							}/*code added to handle if dispense uom and default uom in item store is different==End*/
%>
							<label style="color:<%=drug_color%>;font-size:9px" id="alloc_qty<%=tmp_recCount%>">&nbsp;<%=qty%>&nbsp;<%="("+bean.getUomDisplay(facility_id,uom)+")"%><%=issue_qty_dtl.toString()%><br>
							<!--  <input type="hidden" name="issue_uom<%=recCount%>" id="issue_uom<%=recCount%>" value="<%=uom%>">
							<input type="hidden" name="issue_qty_old<%=recCount%>" id="issue_qty_old<%=recCount%>" value="<%=qty%>">
							<input type="hidden" name="issue_uom_qty<%=recCount%>" id="issue_uom_qty<%=recCount%>" value="<%=issue_qty_value%>">
							<input type="hidden" name="issue_uom_uom<%=recCount%>" id="issue_uom_uom<%=recCount%>" value="<%=issue_uom%>">
							<input type="hidden" name="issue_uom_desc<%=recCount%>" id="issue_uom_desc<%=recCount%>"value="<%=issue_uom_desc%>">
							<input type="hidden" name="issue_uom_equl<%=recCount%>" id="issue_uom_equl<%=recCount%>"value="<%=issue_uom_equl%>"> -->
							<!-- <input type="hidden" name="alloc_strength<%=tmp_recCount%>" id="alloc_strength<%=tmp_recCount%>" value="<%=qty%>"> -->
<%
							tmp_recCount++;
							hsh_med_plan = new LinkedHashMap();// Added for Bru-HIMS-CRF-072.1 [IN:049144] start
							hsh_med_plan.put("qty",qty);
							if(!qty.equals("") && !qty.equals("0") && drug_trade_bean.getDrugyesno().equals("Y") && bean_1.getMedicationPlannerYN().equals("Y"))	{
								if(!alt_qty.contains(drug_code)){
									medplan_bean.getMedPlan_DrugDetails().remove(order_id+"_"+order_line_no+"_"+drug_code+"_"+primary_lang_id);
									medplan_bean.getMedPlan_Local_DrugDetails().remove(order_id+"_"+order_line_no+"_"+drug_code+"_"+loc_lang_id);
								}
								arrOrderId.add(order_id+"_"+order_line_no);
								dosedet[0] = "";dosedet[1] = "";dosedet[2] = "";dosedet[3] = "";dispno[0]="";dispno[1]="";dosedetlocal[0] = "";dosedetlocal[1] = "";dosedetlocal[2] = "";dosedetlocal[3] = "";
								dosedet = medplan_bean.getDoseDetails(order_id, order_line_no,primary_lang_id,drug_code,alternate_drug);
								dosedetlocal = medplan_bean.getDoseDetails(order_id, order_line_no,loc_lang_id,drug_code,alternate_drug);
								medplan_bean.getDosageDetails(drug_code,alternate_drug, order_id, order_line_no);
								hsh_med_plan.put("drug_name",(String)altDrugName.get(alternate_drug));
								hsh_med_plan.put("drug_code",alternate_drug);
								hsh_med_plan.put("morning",dosedet[0]);
								hsh_med_plan.put("afternoon",dosedet[1]);
								hsh_med_plan.put("evening",dosedet[2]);
								hsh_med_plan.put("night",dosedet[3]);
								hsh_med_plan.put("morninglocal",dosedetlocal[0]);
								hsh_med_plan.put("afternoonlocal",dosedetlocal[1]);
								hsh_med_plan.put("eveninglocal",dosedetlocal[2]);
								hsh_med_plan.put("nightlocal",dosedetlocal[3]);
								hsh_med_plan.put("qty_issuelocal",dfToInteger.format(Double.parseDouble(qty))+" "+medplan_bean.getUOMDesc(qty_uom,loc_lang_id));
								hsh_med_plan.put("qty_issue",dfToInteger.format(Double.parseDouble(qty))+" "+medplan_bean.getUOMDesc(qty_uom,primary_lang_id));
								hsh_med_plan.put("curr_disp_yn","Y");
								hsh_med_plan.put("merge_yn","N");
								hsh_med_plan.put("plan_recorded","N");
								hsh_med_plan.put("pres_drug_code",drug_code);
								hsh_med_plan.put("disp_drug_code",alternate_drug);
								hsh_med_plan.put("impnote",CommonBean.checkForNull(medplan_bean.getDrug_ImpNote(alternate_drug)));
								hsh_med_plan.put("impnotelocal",CommonBean.checkForNull(medplan_bean.getDrug_ImpNote_Local(alternate_drug)));
								hsh_med_plan.put("howtotakelocal",CommonBean.checkForNull(medplan_bean.getDrug_Howtotake_Local(order_id+"~"+order_line_no+"~"+alternate_drug)));
								hsh_med_plan.put("drug_name_local",CommonBean.checkForNull(medplan_bean.getDrug_desc_local(alternate_drug)));
								hsh_med_plan.put("howtotake",CommonBean.checkForNull(medplan_bean.getDrug_Howtotake(order_id+"~"+order_line_no+"~"+alternate_drug)));
								dispno = medplan_bean.getDispNumber(order_id, order_line_no);
								hsh_med_plan.put("disp_no",dispno[0]);
								hsh_med_plan.put("disp_srl_no",dispno[1]);
								hsh_med_plan.put("checked","checked");
								hsh_med_plan.put("order_id",order_id);
								hsh_med_plan.put("order_line_no",order_line_no);
								medplan_bean.setMedPlan_DrugDetails(order_id+"_"+order_line_no+"_"+alternate_drug+"_"+primary_lang_id, hsh_med_plan);
								medplan_bean.setMedPlan_Local_DrugDetails(order_id+"_"+order_line_no+"_"+alternate_drug+"_"+loc_lang_id, hsh_med_plan);
							}// Added for Bru-HIMS-CRF-072.1 [IN:049144] end
						}	
						/*if(!alt_strength_value.equals("")) {
							alloc_strength	=	Integer.parseInt(alt_strength_value) * tot_qty+"";
							alloc_strength	=	(Integer.parseInt(alloc_strength)==0)?"":alloc_strength+" "+strength_uom;
						}*/
%>
		<!--  added alloc_strength for ML-BRU-SCF-0866 IN040255 -->
						</label>&nbsp;<label style="font-size:9px;color:black"><b>
						<%=alloc_strength%></b></label><input type="hidden" name="alloc_strength<%=recCount%>" id="alloc_strength<%=recCount%>" value="<%=qty%>"><br><label style="cursor:pointer;color:blue;font-size:9px;"  onClick="javascript:callbatchdetails('<%=patient_id%>','<%=order_id%>','<%=order_line_no%>','<%=drug_code%>','Y','<%=drug_name_1%>')"><fmt:message key="ePH.Trades.label" bundle="${ph_labels}"/></label></td>
<%
					}
					else{	
						if(qty.equals("") || qty.equals("0")) {
							qty	=	"";
							uom	=	"";	
						}
						else {
							if(!strength_value.equals("") && !strength_value.equals("0"))
								alloc_strength	=	Float.parseFloat(strength_value) * Float.parseFloat(qty)+"";
							//uom="("+qty_uom+")";
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
						/*if(count>1){ //if block added to avoid displaying qty for tapered drugs
							qty = act_bms_qty;
							bms_qty = "0";
						}*/ //Commented for ML-BRU-SCF-1015 [IN:04335
						/*Commented for RUT-CRF-0088 [IN036978] 
						if(taper_order_yn.equals("Y") && !taper_order_id.equals("") && !taper_order_line_num.equals("")){ //if block added to avoid displaying qty for tapered drugs
							qty = "0";
							bms_qty = "0";
						}*/
						String issueUomDisbYn = ""; // Added for MMS-DM-SCF-0488 - Reopen Issue - Start
						if(!last_scanned.equals("") && (ord_type.equals("NOR") || bEquivalentNormalOrder) && bean_1.getIssueByUOM().equals("I")){ 
							issueUomDisbYn = "disabled";
						}  // Added for MMS-DM-SCF-0488 - Reopen Issue - End
%>
					<td align="left" class="<%=classvalue%>"  style='<%=display_list%>'>&nbsp;
					<select onChange="calculateIssueUOM(this,'<%=recCount%>','<%=order_id+order_line_no+drug_code+"_uom"%>');" name="issue_uom_select_<%=recCount%>" <%=issueUomDisbYn%>> <!-- // issueUomDisbYn Added for MMS-DM-SCF-0488 - Reopen Issue -->
<% 
					String stk_unit_code	= "";
					String stk_unit_desc	= "";
					String stk_equval_value	= "";
					String act_stk_equval_value	= "";
					String uom_desc	= ""; //AAKH-SCF-0338
					
					stk_units				= bean.loadStockUnit(drug_code);
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
					//added for AAKH-SCF-0338 - end
					String base_to_def_uom_equl_val  ="1";
					String base_to_disp_uom_equl_val ="1";

					for(int iStkCountt=0; iStkCountt<stk_units.size();iStkCountt+=4) { 
						stk_unit_code		=	(String)stk_units.get(iStkCountt);
						stk_unit_desc		=	(String)stk_units.get(iStkCountt+1);
						stk_equval_value	=	(String)stk_units.get(iStkCountt+2);
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

					// For Allowing more quantity than order quantity dispense based on drug setup
					HashMap hmAllowMoreQty = bean_1.getHmAllowMoreQty();

					if(hmAllowMoreQty == null)
						hmAllowMoreQty = new HashMap();
%>
					</select>&nbsp;
					<input type ="hidden" name ="issueUOMValue_<%=recCount%>" value = "<%=order_id+order_line_no+drug_code+"_uom"%>"> <!-- Added for AAKH-SCF-0377/ML-BRU-SCF-1880 -->
					<label id="item_desc_3" style="font-weight:bold"></label>
					</td>

					<td class="<%=classvalue%>" width="10%" <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" >
					<input type="hidden" name="AllowMoreThanPresQty<%=recCount%>" id="AllowMoreThanPresQty<%=recCount%>"  value="<%=hmAllowMoreQty.get(drug_code)%>">
<%
							if(iqvia_integration_flag){//mohe-crf-0026.1
								strDosageDtls = bean_1.getFreqRepeatCode(order_id, order_line_no); 
								String[] arrSplit = strDosageDtls.split("~");  								
								frequencyCode = arrSplit[3];
								repeatValue = arrSplit[2]; 
								durnValue =  arrSplit[4]; 
								durationType = arrSplit[1];
								routeCode = arrSplit[5];
								qtyValue  =arrSplit[6];
								qtyUnit	  =	arrSplit[7];
								itemCost = bean.getItemCost(item_code,store_code, "1",end_date);//MOHE-CRF-0026.1
							
								
							}//end 
							
						if( (ord_type.equals("NOR") || bEquivalentNormalOrder)){
						if(bean_1.getBarcode_Scan_YN().equals("Y") || (bean_1.getBarcode_Scan_YN().equals("N") && barcode_id.equals(""))){ // Added for [IN:064158] - Start
                 		                  if(qty.equals("0.0") || qty.equals("") || qty.equals("0"))
                 			            qty = "0.0"; // "" modified to "0.0" for GHL-CRF-0463 
						} // Added for [IN:064158] - End
						if(stock_opt.get(0).equals("Y")&& disp_delivery_chk_box_val.equals("Y")){
							if(in_formulary_yn.equals("Y")){
%>
								<input type="text" class="flat" size="6" style="text-align:right"  <%=alloc_readonly%>   onKeyPress="return allowValidNumber(this,event,6,0);"  maxlength="5" name="alloc_qty_<%=recCount%>" value="<%=  retunFormatedInt(qty)%>" oncopy="return false" onpaste="return false"  onchange=" if(checkAllocBmsSecondStage('<%=recCount%>', this)){checkValue(this); setbatchdetails(this,'<%=store_code%>','<%=base_uom%>','<%=end_date%>','<%=item_code%>','<%=trade_code%>','<%=patient_id%>','<%=order_id%>','<%=order_line_no%>','<%=uom%>','<%=billing_interface_yn%>','<%=drug_code%>','<%=act_bms_qty%>','<%=retunFormatedInt(qty)%>','<%=recCount%>')};" <%=taper_disable%> > 
<%
                                    bean_1.setStockDtlKey(drug_code+"qty",retunFormatedInt(qty));//Added for AAKH-SCF-0377 // ML-BRU-SCF-1880
                                    
                                    if(bean_1.getStockDtl().containsKey("valid_drug_code") && (order_id+"~"+order_line_no+"~"+drug_code).equals((String) bean_1.getStockDtl().get("valid_drug_code"))){ //if block added for KDAH-CRF-0231 [IN-034551] 
%>
									<script>
									<% if(bean_1.getBarcodeColorYn(order_id,order_line_no).equals("Y")){ // condition Added for MMS-DM-SCF-0488 %>
										document.getElementById("alloc_qty_"<%=recCount%>).style.backgroundColor = "#ADFF2F";//changed for 62327
								    <%}%>
										document.getElementById("alloc_fromBarCode").value="Y";
									</script>
<%					    
                                    bean_1.setStockDtlKey(drug_code+"qty",retunFormatedInt(qty));//Added for AAKH-SCF-0377 // ML-BRU-SCF-1880
                                    }
							}
							else{
%>
								<input type="text" class="flat" size="6" style="text-align:right" <%=alloc_readonly%>    onKeyPress="return allowValidNumber(this,event,6,0);"  maxlength="5" name="alloc_qty_<%=recCount%>" value="" disabled>
<%
							}
%>
							<input type ="hidden" name = "alloc_qty_hidden_<%=recCount%>" value ="document.DispMedicationAllStages.alloc_qty_<%=recCount%>~<%=store_code%>~<%=base_uom%>~<%=end_date%>~<%=item_code%>~<%=trade_code%>~<%=patient_id%>~<%=order_id%>~<%=order_line_no%>~<%=uom%>~<%=billing_interface_yn%>~<%=drug_code%>~<%=act_bms_qty%>~<%=retunFormatedInt(qty)%>~<%=recCount%>">
							<label class="label" ><b>&nbsp;<%=bean.getUomDisplay(facility_id,uom)%></b></label>&nbsp;&nbsp;<label id="issue_uom_lbl<%=recCount%>" class="label" style style='font-size:9px' ><b>&nbsp;<%=issue_qty_dtl.toString()%></b></label><br><label style="cursor:pointer;color:blue;font-size:9px;"  onClick="javascript:callbatchdetails('<%=patient_id%>','<%=order_id%>','<%=order_line_no%>','<%=drug_code%>','N','<%=drug_name_1%>')"><fmt:message key="ePH.Trades.label" bundle="${ph_labels}"/></label>

							<input type="hidden" name="issue_uom<%=recCount%>" id="issue_uom<%=recCount%>"     value="<%=uom%>">
							<input type="hidden" name="issue_qty_old<%=recCount%>" id="issue_qty_old<%=recCount%>" value="<%=qty%>">
							<input type="hidden" name="issue_uom_qty<%=recCount%>" id="issue_uom_qty<%=recCount%>" value="<%=issue_qty_value%>">
							<input type="hidden" name="issue_uom_uom<%=recCount%>" id="issue_uom_uom<%=recCount%>" value="<%=issue_uom%>">
							<input type="hidden" name="issue_uom_desc<%=recCount%>" id="issue_uom_desc<%=recCount%>"value="<%=issue_uom_desc%>">
							<input type="hidden" name="issue_uom_equl<%=recCount%>" id="issue_uom_equl<%=recCount%>"value="<%=issue_uom_equl%>">
							<input type="hidden" name="uom<%=recCount%>" id="uom<%=recCount%>" value="<%=uom%>"> <!-- mohe-crf-0026.1 -->
							<input type="hidden" name="allocate_qty<%=recCount%>" id="allocate_qty<%=recCount%>" value="<%=qty%>">  
							<input type="hidden" name="frequencyCode<%=recCount%>" id="frequencyCode<%=recCount%>" value="<%=frequencyCode%>">
							<input type="hidden" name="repeatValue<%=recCount%>" id="repeatValue<%=recCount%>" value="<%=repeatValue%>">
							<input type="hidden" name="durnValue<%=recCount%>" id="durnValue<%=recCount%>" value="<%=durnValue%>">
							<input type="hidden" name="durationType<%=recCount%>" id="durationType<%=recCount%>" value="<%=durationType%>">
							<input type="hidden" name="routeCode<%=recCount%>" id="routeCode<%=recCount%>" value="<%=routeCode%>">
							<input type="hidden" name="qtyValue<%=recCount%>" id="qtyValue<%=recCount%>" value="<%=qtyValue%>">
							<input type="hidden" name="qtyUnit<%=recCount%>" id="qtyUnit<%=recCount%>" value="<%=qtyUnit%>">  
							<input type="hidden" name="dispTmpNo<%=recCount%>" id="dispTmpNo<%=recCount%>" value="<%=dispTmpNo%>">
							<input type="hidden" name="claimIdNo<%=recCount%>" id="claimIdNo<%=recCount%>" value="<%=claimIdNo%>">  
							<input type="hidden" name="orderId<%=recCount%>" id="orderId<%=recCount%>" value="<%=order_id%>"> 
							<input type="hidden" name="itemCost<%=recCount%>" id="itemCost<%=recCount%>" value="<%=itemCost%>"> 
							  <!-- mohe-crf-0026.1 END -->
							
<%
						}
						else{
							if(in_formulary_yn.equals("Y")){//Added for MO-GN-5434 [IN:043669]
%>
							<input type="text" class="flat" size="6" style="text-align:right" <%=alloc_readonly%> onKeyPress="return allowValidNumber(this,event,6,0);"  maxlength="5" name="alloc_qty_<%=recCount%>" value="<%=retunFormatedInt(qty)%>" onblur="includeToBms(this,'<%=recCount%>')" <%=taper_disable%>>
<%
							}else{//Added for MO-GN-5434 [IN:043669]
%>
							<input type="text" class="flat" size="6" style="text-align:right" <%=alloc_readonly%>  onKeyPress="return allowValidNumber(this,event,6,0);"  maxlength="5" name="alloc_qty_<%=recCount%>" value="<%=retunFormatedInt(qty)%>"  disabled>
<%
							}//Added for MO-GN-5434 [IN:043669]
%>
							<input type="hidden" name="issue_uom<%=recCount%>" id="issue_uom<%=recCount%>"     value="">
							<input type="hidden" name="issue_qty_old<%=recCount%>" id="issue_qty_old<%=recCount%>" value="">
							<input type="hidden" name="issue_uom_qty<%=recCount%>" id="issue_uom_qty<%=recCount%>" value="">
							<input type="hidden" name="issue_uom_uom<%=recCount%>" id="issue_uom_uom<%=recCount%>" value="">
							<input type="hidden" name="issue_uom_desc<%=recCount%>" id="issue_uom_desc<%=recCount%>"value="">
							<input type="hidden" name="issue_uom_equl<%=recCount%>" id="issue_uom_equl<%=recCount%>"value="">
<%
						}
					}
					else{
%>
						<label class="label" id="alloc_qty<%=recCount%>"><b>&nbsp;<%=retunFormatedInt(qty)%>&nbsp;<%=bean.getUomDisplay(facility_id,uom)%></b></label><br><label id="issue_uom_lbl<%=recCount%>" class="label" style style='font-size:9px' ><b>&nbsp;<%=issue_qty_dtl.toString()%></b> 
						</label>&nbsp;&nbsp;<label style="cursor:pointer;color:blue;font-size:9px;"  onClick="javascript:callbatchdetails('<%=patient_id%>','<%=order_id%>','<%=order_line_no%>','<%=drug_code%>','N','<%=drug_name_1%>')"><fmt:message key="ePH.Trades.label" bundle="${ph_labels}"/></label>
						<% if(bean_1.getBarcodeColorYn(order_id,order_line_no).equals("Y")){ // condition Added for MMS-KH-CRF-0026.1 %><script>
						document.getElementById("alloc_qty"<%=recCount%>).style.backgroundColor = "#ADFF2F";
						<%}%>
														</script>
						</td>
						<input type="hidden" name="alloc_strength<%=recCount%>" id="alloc_strength<%=recCount%>" value="<%=qty%>">
						<input type="hidden" name="issue_uom<%=recCount%>" id="issue_uom<%=recCount%>"     value="<%=uom%>">
						<input type="hidden" name="issue_qty_old<%=recCount%>" id="issue_qty_old<%=recCount%>" value="<%=qty%>">
						<input type="hidden" name="issue_uom_qty<%=recCount%>" id="issue_uom_qty<%=recCount%>" value="<%=issue_qty_value%>">
						<input type="hidden" name="issue_uom_uom<%=recCount%>" id="issue_uom_uom<%=recCount%>" value="<%=issue_uom%>">
						<input type="hidden" name="issue_uom_desc<%=recCount%>" id="issue_uom_desc<%=recCount%>"value="<%=issue_uom_desc%>">
						<input type="hidden" name="issue_uom_equl<%=recCount%>" id="issue_uom_equl<%=recCount%>"value="<%=issue_uom_equl%>">
						<input type="hidden" name="uom<%=recCount%>" id="uom<%=recCount%>" value="<%=uom%>"> <!-- mohe-crf-0026.1 -->
						<input type="hidden" name="allocate_qty<%=recCount%>" id="allocate_qty<%=recCount%>" value="<%=qty%>">  <!-- mohe-crf-0026.1 -->
						<input type="hidden" name="frequencyCode<%=recCount%>" id="frequencyCode<%=recCount%>" value="<%=frequencyCode%>">
						<input type="hidden" name="repeatValue<%=recCount%>" id="repeatValue<%=recCount%>" value="<%=repeatValue%>">
						<input type="hidden" name="durnValue<%=recCount%>" id="durnValue<%=recCount%>" value="<%=durnValue%>">
						<input type="hidden" name="durationType<%=recCount%>" id="durationType<%=recCount%>" value="<%=durationType%>">
						<input type="hidden" name="routeCode<%=recCount%>" id="routeCode<%=recCount%>" value="<%=routeCode%>">
						<input type="hidden" name="qtyValue<%=recCount%>" id="qtyValue<%=recCount%>" value="<%=qtyValue%>">
						<input type="hidden" name="qtyUnit<%=recCount%>" id="qtyUnit<%=recCount%>" value="<%=qtyUnit%>"> 
						<input type="hidden" name="dispTmpNo<%=recCount%>" id="dispTmpNo<%=recCount%>" value="<%=dispTmpNo%>">
						<input type="hidden" name="claimIdNo<%=recCount%>" id="claimIdNo<%=recCount%>" value="<%=claimIdNo%>">
						<input type="hidden" name="orderId<%=recCount%>" id="orderId<%=recCount%>" value="<%=order_id%>"> 
						
<%
					}
				}	
		  
				if(multi_drugs.size() > 1 ) {
					/*if( Float.parseFloat(strength_value) > Float.parseFloat(alt_strength_value) ) {
						if(tot_qty > 0)
							bms_qty	=	Float.parseFloat(pres_qty) - (tot_qty / prod_qty)+"";
						else 
							bms_qty	=	(Float.parseFloat(bms_qty) / prod_qty)+"";
					} else {
							if(!qty.equals("") && !qty.equals("0")){
								bms_qty	=	Float.parseFloat(bms_qty)- tot_qty +"";
							}
						}*/
				}
				else {
					if(!qty.equals("") && !qty.equals("0")){
						if(!bean_1.getBarcode_multi_id().equals("Y"))
							bms_qty	=	Float.parseFloat(bms_qty)- tot_qty +"";
					}
				}
						
				if(!strength_value.equals("") && !alt_strength_value.equals("")) {
					if(bms_strength.equals(""))
					bms_strength		=	Float.parseFloat(bms_qty) * Float.parseFloat(strength_value)*(main_pack_size)+"";
					//bms_strength		=	Float.parseFloat(bms_qty) * Float.parseFloat(alt_strength_value)+"";
				}
				else if(!strength_value.equals("") && !strength_value.equals("0")) {
					//bms_strength		=	Float.parseFloat(bms_qty) * Float.parseFloat(strength_value)+"";
					bms_strength		=	"";
					strength_uom		=	"";
				}
				else 
					strength_uom	=	"";
				
				if(bms_qty.indexOf(".")!=-1) {
					int pos	=	bms_qty.indexOf(".");
					if(bms_qty.length() > (pos+3) )
						bms_qty	=	bms_qty.substring(0,(pos+3));
				}
				if(bms_strength.equals("0.0")||bms_strength.equals("0")||bms_qty.equals("0.0")||bms_qty.equals("0")){
					bms_strength="";
					strength_uom="";
				}
				if(Float.parseFloat(bms_qty)<0){
					bms_qty ="0";
				}
				hsh_med_plan = new LinkedHashMap();// Added for Bru-HIMS-CRF-072.1 [IN:049144] start
				hsh_med_plan.put("qty",qty);
				if(!qty.equals("") && !qty.equals("0") && drug_trade_bean.getDrugyesno().equals("Y") && bean_1.getMedicationPlannerYN().equals("Y"))	{
					arrOrderId.add(order_id+"_"+order_line_no);
					dosedet[0] = "";dosedet[1] = "";dosedet[2] = "";dosedet[3] = "";dispno[0]="";dispno[1]="";dosedetlocal[0] = "";dosedetlocal[1] = "";dosedetlocal[2] = "";dosedetlocal[3] = "";
					dosedet = medplan_bean.getDoseDetails(order_id, order_line_no,primary_lang_id,drug_code,drug_code);
					dosedetlocal = medplan_bean.getDoseDetails(order_id, order_line_no,loc_lang_id,drug_code,drug_code);
					hsh_med_plan.put("drug_name",CommonBean.checkForNull(medplan_bean.getDrug_desc(drug_code)));
					hsh_med_plan.put("drug_code",drug_code);
					hsh_med_plan.put("morning",dosedet[0]);
					hsh_med_plan.put("afternoon",dosedet[1]);
					hsh_med_plan.put("evening",dosedet[2]);
					hsh_med_plan.put("night",dosedet[3]);
					hsh_med_plan.put("morninglocal",dosedetlocal[0]);
					hsh_med_plan.put("afternoonlocal",dosedetlocal[1]);
					hsh_med_plan.put("eveninglocal",dosedetlocal[2]);
					hsh_med_plan.put("nightlocal",dosedetlocal[3]);
					hsh_med_plan.put("qty_issuelocal",dfToInteger.format(Double.parseDouble(qty))+" "+medplan_bean.getUOMDesc(qty_uom,loc_lang_id));
					hsh_med_plan.put("qty_issue",dfToInteger.format(Double.parseDouble(qty))+" "+medplan_bean.getUOMDesc(qty_uom,primary_lang_id));
					hsh_med_plan.put("curr_disp_yn","Y");
					hsh_med_plan.put("merge_yn","N");
					hsh_med_plan.put("plan_recorded","N");
					hsh_med_plan.put("pres_drug_code",drug_code);
					hsh_med_plan.put("disp_drug_code",drug_code);
					hsh_med_plan.put("impnote",CommonBean.checkForNull(medplan_bean.getDrug_ImpNote(drug_code)));
					hsh_med_plan.put("impnotelocal",CommonBean.checkForNull(medplan_bean.getDrug_ImpNote_Local(drug_code)));
					hsh_med_plan.put("howtotakelocal",CommonBean.checkForNull(medplan_bean.getDrug_Howtotake_Local(order_id+"~"+order_line_no+"~"+drug_code)));
					hsh_med_plan.put("drug_name_local",CommonBean.checkForNull(medplan_bean.getDrug_desc_local(drug_code)));
					hsh_med_plan.put("howtotake",CommonBean.checkForNull(medplan_bean.getDrug_Howtotake(order_id+"~"+order_line_no+"~"+drug_code)));
					dispno = medplan_bean.getDispNumber(order_id, order_line_no);
					hsh_med_plan.put("disp_no",dispno[0]);
					hsh_med_plan.put("disp_srl_no",dispno[1]);
					hsh_med_plan.put("checked","checked");
					hsh_med_plan.put("order_id",order_id);
					hsh_med_plan.put("order_line_no",order_line_no);
					medplan_bean.setMedPlan_DrugDetails(order_id+"_"+order_line_no+"_"+drug_code+"_"+primary_lang_id, hsh_med_plan);
					medplan_bean.setMedPlan_Local_DrugDetails(order_id+"_"+order_line_no+"_"+drug_code+"_"+loc_lang_id, hsh_med_plan);
				}// Added for Bru-HIMS-CRF-072.1 [IN:049144] end

%>
				<td class="<%=classvalue%>" width="10%" style="font-size:9px" <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" >&nbsp;<label class="label" id="bms_qty_<%=recCount%>">&nbsp;<%=retunFormatedInt(bms_qty)%>&nbsp;</label>&nbsp;(<%=qty_uom_disp%>)<br>&nbsp;<b><%=bms_strength%>&nbsp;<%=strength_uom%></b><input type="hidden" name="bms_qty<%=recCount%>" id="bms_qty<%=recCount%>" value="<%=retunFormatedInt(bms_qty)%>"><input type="hidden" name="bms_strength<%=recCount%>" id="bms_strength<%=recCount%>" value="<%=bms_strength%>"></td><!---/*bean.getUomDisplay(facility_id,qty_uom)*/-->
<%
				String strModDrugCode =  drug_code.replace("_","zXd1").replace(".","zXd2").replace("-","zXd3");
				//for billing interface coding starts
				
				boolean approval_flag = false;//AAKH-CRF-0117
				String disabled = "disabled";//AAKH-CRF-0117
				if(billing_interface_yn.equals("Y")&& bl_display.equals("Y")){	
					if(in_formulary_yn.equals("Y")){ 

						float gross_charge_amount =0;
						float groos_pat_payable   =0;
						float gross_amount        = 0;//Added for ML-BRU-CRF-0469
						//float net_amount          =0;

						disp_delivery_chk_box     = "checked";
						disp_delivery_chk_box_val = "Y";
						disp_delivery_chk_box_disabled= "";

						gross_charge_amount_str	  =  "";
						groos_pat_payable_str	  =  "";
						 batch_str				  =  "";
						 gross_amount_str                =  "";//added for ML-BRU-CRF-0469
						 
						StringBuffer gross_charge_display_str  = new StringBuffer();
						StringBuffer pat_charge_display_str    = new StringBuffer();
						StringBuffer inc_exec_display_str      = new StringBuffer();
						StringBuffer gross_disply_str          = new StringBuffer(); //added for ML-BRU-CRF-0469
						if(!qty.equals("") && billable_item_yn.equals("Y")){
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
							HashMap billing_det = bean.getchargedetails(patient_id ,order_id,order_line_no,bl_encounter_id,patient_class,dischargeIND);  // IN032479   Added discharge indicator
							if(billing_det.containsKey(drug_code)){
								HashMap  chareg_det=(HashMap)billing_det.get(drug_code);
								if(chareg_det.get("error_msg").equals("")){
									decimalFormatString         =(String)chareg_det.get("BL_DECIMAL_FORMAT_STRING");
									DecimalFormat dfTest        = new DecimalFormat(decimalFormatString);

									/*if(!chareg_det.get("grosschargeamt").equals("null")){
										 gross_charge_amount= Float.parseFloat((String)chareg_det.get("grosschargeamt"));
									}*/
									if(!chareg_det.get("patnetamt").equals("null")){
										 groos_pat_payable  = Float.parseFloat(((String)chareg_det.get("patnetamt")).trim());
									} //Commented added ML-BRU-SCF-0368 [IN:034748]
									if(!chareg_det.get("netchargeamt").equals("null")){
										//groos_pat_payable  = Float.parseFloat((String)chareg_det.get("netchargeamt"));
										gross_charge_amount  = Float.parseFloat((String)chareg_det.get("netchargeamt")); //added ML-BRU-SCF-0368 [IN:034748]
									}
									//added for ML-BRU-CRF-0469 start
									if(displayGrossAmtYn){
									if(!chareg_det.get("grosschargeamt").equals("null")){
										gross_amount  = Float.parseFloat((String)chareg_det.get("grosschargeamt")); 
									     }
									}
									//added for ML-BRU-CRF-0469 end

									batch_str                =(String)chareg_det.get("BATCH_STRING");
									gross_charge_amount_str  = dfTest.format(gross_charge_amount);
									groos_pat_payable_str    = dfTest.format(groos_pat_payable);
									//added for ML-BRU-SCF-0469 strt
									if(displayGrossAmtYn){
									gross_amount_str         = dfTest.format(gross_amount);
									}
									//added for ML-BRU-SCF-0469 end
									
									
									//added for ML-BRU-SCF-0469 strt
									if(displayGrossAmtYn){
								    gross_disply_str.append("<label style='font-size:9px;color:black' id='gross_amount_str_").append(order_id).append(order_line_no).append(strModDrugCode).append("'>").append(gross_amount_str).append("</label>");
								 	}
									//added for ML-BRU-SCF-0469 end     
									gross_charge_display_str.append("<label style='font-size:9px;color:black' id='groos_pat_payable_str_").append(order_id).append(order_line_no).append(strModDrugCode).append("'>").append(groos_pat_payable_str).append("</label>");

									pat_charge_display_str.append("<label style='font-size:9px;color:black' id='gross_charge_amount_str_").append(order_id).append(order_line_no).append(strModDrugCode).append("'>").append(gross_charge_amount_str).append("</label>");	

									inc_exec_display_str.append("<a  style ='font-size:9px' href=\"javascript:callIncludeExclude(").append("'AS'").append(",").append("''").append(",").append("'").append(drug_code).append("'").append(",").append("'").append(qty).append("'").append(",").append("'").append(batch_str).append("'").append(",").append("'").append(order_id).append("'").append(",").append("'").append(order_line_no).append("'").append(")\">").append( com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Include.label","common_labels")).append("?</a>");
								
									tot_gross_charge_amount = tot_gross_charge_amount+gross_charge_amount;
									tot_groos_pat_payable   = tot_groos_pat_payable+groos_pat_payable;
									
									if(tot_gross_charge_amount!=tot_groos_pat_payable){  //AAKH-CRF-0117
										approval_flag =true;
									}
									//added for ML-BRU-SCF-0469 strt
									if(displayGrossAmtYn){
									tot_gross_amount        = tot_gross_amount+gross_amount;
									}
									//added for ML-BRU-SCF-0469 end
%>

									<input type="hidden" name="override_allowed_yn_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="override_allowed_yn_<%=order_id%><%=order_line_no%><%=strModDrugCode%>"  value="<%=(String)chareg_det.get("override_allowed_yn")%>">
									<input type="hidden" name="excl_incl_ind_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="excl_incl_ind_<%=order_id%><%=order_line_no%><%=strModDrugCode%>"        value="">
									<input type="hidden" name="excl_incl_ind_default_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="excl_incl_ind_default_<%=order_id%><%=order_line_no%><%=strModDrugCode%>"value="<%=(String)chareg_det.get("excl_incl_ind")%>">
									<input type="hidden" name="approval_reqd_yn_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="approval_reqd_yn_<%=order_id%><%=order_line_no%><%=strModDrugCode%>"     value="<%=(String)chareg_det.get("approval_reqd_yn")%>">
									<input type="hidden" name="bl_incl_excl_override_reason_desc_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="bl_incl_excl_override_reason_desc_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" value="">
									<input type="hidden" name="bl_incl_excl_override_reason_code_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="bl_incl_excl_override_reason_code_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" value="">
									
									<input type="hidden" name="gross_charge_amount_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="gross_charge_amount_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" value="<%=gross_charge_amount+""%>">
									<input type="hidden" name="groos_pat_payable_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="groos_pat_payable_<%=order_id%><%=order_line_no%><%=strModDrugCode%>"   value="<%=groos_pat_payable+""%>">
									<input type="hidden" name="drug_color_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="drug_color_<%=order_id%><%=order_line_no%><%=strModDrugCode%>"   value='black'>
									<!-- added for ML-BRU-SCF-0469 start -->
									<%if(displayGrossAmtYn){ %>
									<input type="hidden" name="gross_amount_<%=order_id%><%=order_line_no%><%=drug_code%>" id="gross_amount_<%=order_id%><%=order_line_no%><%=drug_code%>"   value="<%=gross_amount+""%>">
                                                                       <%} %>
                                                                        <!-- added for ML-BRU-SCF-0469 end -->
<% 
								}
								else{                                        
									gross_charge_display_str.append("<label style='font-size:9px;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label>");
									pat_charge_display_str.append("<label style='font-size:9px;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label>");
									//added for ML-BRU-SCF-0469 start
									if(displayGrossAmtYn){     
									gross_disply_str.append("<label style='font-size:9px;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label>");
									}
									//added for ML-BRU-SCF-0469 end
									disp_delivery_chk_box="";
									disp_delivery_chk_box_val="N";
									disp_delivery_chk_box_disabled="disabled";
											
								}
							}
						}
					}
					if(multi_drugs.size()>1){
						int  added_yn =0;
						int  x		=0;
						String sModAltDrugCode = "";
						HashMap billing_det = null;
						for(int n=0; n<multi_drugs.size(); n+=5)	{							    
							alt_drug_code	     =	(String)multi_drugs.get(n);
							sModAltDrugCode		 = alt_drug_code.replace("_","zXd1").replace(".","zXd2").replace("-","zXd3");
							drug_color			 =	(String)colors.get(x++);
							billing_det = bean.getchargedetails(patient_id ,order_id,order_line_no,bl_encounter_id,patient_class,dischargeIND);  // IN032479   Added discharge indicator);
							if(billing_det.containsKey(alt_drug_code)){
								HashMap  chareg_det=(HashMap)billing_det.get(alt_drug_code);
								if(chareg_det.get("error_msg").equals("")){

									batch_str =(String)chareg_det.get("BATCH_STRING");
									decimalFormatString     =(String)chareg_det.get("BL_DECIMAL_FORMAT_STRING");
									DecimalFormat dfTest   = new DecimalFormat(decimalFormatString);

									/*if(!chareg_det.get("grosschargeamt").equals("null")){ 
										gross_charge_amount= Float.parseFloat((String)chareg_det.get("grosschargeamt"));
									}*/ //commented for  ML-BRU-SCF-0368 [IN:034748]
									if(!chareg_det.get("patnetamt").equals("null")){ 
										groos_pat_payable  = Float.parseFloat(((String)chareg_det.get("patnetamt")).trim());
									}
									 if(!chareg_det.get("netchargeamt").equals("null")){
										//groos_pat_payable  = Float.parseFloat((String)chareg_det.get("netchargeamt"));
										gross_charge_amount  = Float.parseFloat((String)chareg_det.get("netchargeamt")); //added ML-BRU-SCF-0368 [IN:034748]
									}
									 
									 if(displayGrossAmtYn){ // Added for 68194 - Start
											if(!chareg_det.get("grosschargeamt").equals("null")){
												gross_amount  = Float.parseFloat((String)chareg_det.get("grosschargeamt")); 
											  }
										} // Added for 68194 - End
							   
									gross_charge_amount_str = dfTest.format(gross_charge_amount);
									groos_pat_payable_str   = dfTest.format(groos_pat_payable);
												
									if(displayGrossAmtYn){ // Added for 68194 - Start
										  gross_amount_str         = dfTest.format(gross_amount);
									} // Added for 68194 - End
									   
									gross_charge_display_str.append("<label style='font-size:9px;color:").append(drug_color).append("' id='groos_pat_payable_str_").append(order_id).append(order_line_no).append(sModAltDrugCode).append("'>").append(groos_pat_payable_str).append("</label><BR>");

									pat_charge_display_str.append("<label style='font-size:9px;color:").append(drug_color).append("' id='gross_charge_amount_str_").append(order_id).append(order_line_no).append(sModAltDrugCode).append("'>").append(gross_charge_amount_str).append("</label><BR>");
                                    
									if(displayGrossAmtYn){ // Added for 68194 - Start   
										gross_disply_str.append("<label style='font-size:9px;color:").append(drug_color).append("' id='gross_amount_str_").append(order_id).append(order_line_no).append(sModAltDrugCode).append("'>").append(gross_amount_str).append("</label><BR>");																								
									} // Added for 68194 - End
									
								   inc_exec_display_str.append("<label style='cursor:pointer;font-size:9px;color:").append(drug_color).append("' onclick=\"javascript:callIncludeExclude(").append("'AS'").append(",").append("''").append(",").append("'").append(alt_drug_code).append("'").append(",").append("'").append(qty).append("'").append(",").append("'").append(batch_str).append("'").append(",").append("'").append(order_id).append("'").append(",").append("'").append(order_line_no).append("'").append(")\">").append( com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Include.label","common_labels")).append("?</label><br>");

									added_yn++;

									tot_gross_charge_amount = tot_gross_charge_amount+gross_charge_amount;
									tot_groos_pat_payable   = tot_groos_pat_payable+groos_pat_payable;
									
									if(tot_gross_charge_amount!=tot_groos_pat_payable){    //AAKH-CRF-0117
										approval_flag =true;
									}
									
									if(displayGrossAmtYn){ // Added for 68194 - Start
										gross_amount_str = dfTest.format(gross_amount);
									} // Added for 68194 - End
%>
										<input type="hidden" name="override_allowed_yn_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>" id="override_allowed_yn_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>"  value="<%=(String)chareg_det.get("override_allowed_yn")%>">
										<input type="hidden" name="excl_incl_ind_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>" id="excl_incl_ind_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>"        value="">
										<input type="hidden" name="excl_incl_ind_default_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>" id="excl_incl_ind_default_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>"value="<%=(String)chareg_det.get("excl_incl_ind")%>">
										<input type="hidden" name="approval_reqd_yn_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>" id="approval_reqd_yn_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>"     value="<%=(String)chareg_det.get("approval_reqd_yn")%>">
										<input type="hidden" name="bl_incl_excl_override_reason_desc_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>" id="bl_incl_excl_override_reason_desc_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>" value="">
										<input type="hidden" name="bl_incl_excl_override_reason_code_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>" id="bl_incl_excl_override_reason_code_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>" value="">
										
										<input type="hidden" name="gross_charge_amount_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>" id="gross_charge_amount_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>" value="<%=gross_charge_amount+""%>">
										<input type="hidden" name="groos_pat_payable_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>" id="groos_pat_payable_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>"   value="<%=groos_pat_payable+""%>">
										<input type="hidden" name="drug_color_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>" id="drug_color_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>"   value="<%=drug_color%>">
<% 
									}
									else{
										  gross_charge_display_str.append("<label style='font-size:9px;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("<BR>");
								          pat_charge_display_str.append("<label style='font-size:9px;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("<BR>");
										  disp_delivery_chk_box    ="";
								          disp_delivery_chk_box_val="N";
										  disp_delivery_chk_box_disabled="disabled";
									   }
								  }							  
						}
						/*if(added_yn>0){
							//gross_charge_display_str.append("</label>");
							//pat_charge_display_str.append("</label>");
						}*/
				}		
			%>	
<%
			if(bean.getDisplayInsStatus()){  //Added for TH-KW-CRF-0012
%>
          <td class="<%=classvalue%>"><center>&nbsp;<%=insurance_status%></center></td>
<%}%>
			<!--   added for ML-BRU-SCF-0469 start-->
			<% if(displayGrossAmtYn){%>
			<td class="<%=classvalue%>"><center>&nbsp;<%=gross_disply_str.toString()%></center></td>
			<%} %>
			<!-- added for ML-BRU-SCF-0469 end -->
			<td class="<%=classvalue%>"><center>&nbsp;<%=pat_charge_display_str.toString()%></center></td>
			<td class="<%=classvalue%>"><center>&nbsp;<%=gross_charge_display_str.toString()%></center></td>
			<td class="<%=classvalue%>"><center>&nbsp;<%=inc_exec_display_str.toString()%></center></td>
<% 
			}
			else{
%> 
                <!-- added for ML-BRU-CRF-0469 start-->
                 <% if(displayGrossAmtYn){%>
                 <td class="<%=classvalue%>" align="center">&nbsp;</td>
                 <%} %>
                 <!-- added for ML-BRU-CRF-0469 end-->
			     <td class="<%=classvalue%>" align="center">&nbsp;</td>
			     <td class="<%=classvalue%>" align="center">&nbsp;</td>
			     <td class="<%=classvalue%>" align="center">&nbsp;</td>
				
<%
			   }			
			//billing interface coding ends here
			} 
%>
			<input type="hidden"  name="allocateyn_<%=recCount%>" id="allocateyn_<%=recCount%>" value="<%=disp_delivery_chk_box_val%>">   <!--  Added for MO-GN-5434 [IN:043669]  -->
			<input type="hidden"  name="prescribed_strength_<%=recCount%>" id="prescribed_strength_<%=recCount%>" value="<%=pres_strength_1%>"> <!-- MMS-KH-CRF-0030-->
<%
		if(delivery_reqd.equals("Y")) { 
			if(delivery_det!=null && delivery_det.size() > 1) {
				//Ifcondition added and the block moved from below "if(!order_type.equals("TD") && !order_type.equals("TA")){" for SRR20056-SCF-7289
		    if(!ord_type.equals("IVAA")&& !ord_type.equals("IVIA")&& !ord_type.equals("CA")&& !ord_type.equals("TA")&&!ord_type.equals("TD")&& !ord_type.equals("CO")){
				if(multi_drugs.size() == 0){//Added if condition alone for ML-BRU-SCF-1881
				hmEditLabelValues = new HashMap();	
				hmEditLabelValues.put("order_id",order_id);
				hmEditLabelValues.put("pres_drug_code",drug_code);
				/*if( (multi_drugs.size()!=0)){//added if condition for alternate drugs in edit label ML-BRU-SCF-1528 [IN:053217] //commented and added below for ML-BRU-SCF-1881
					hmEditLabelValues.put("drug_code",alt_drug_code);
					hmEditLabelValues.put("alt_drug_desc",alt_drug_desc);
					hmEditLabelValues.put("alt_drug_flag","Y");
				}*/
				//else
					hmEditLabelValues.put("drug_code",drug_code);
				hmEditLabelValues.put("order_line_no",order_line_no);
				hmEditLabelValues.put("ord_date_time",ord_date_time);
				hmEditLabelValues.put("drug_name_1",drug_name);
				hmEditLabelValues.put("drug_desc",drug_desc); //Added for Bru-HIMS-CRF-414- ML-BRU-SCF-1454 [IN:052271]
				hmEditLabelValues.put("pres_qty",pres_qty);
				hmEditLabelValues.put("uom",uom);
			//	if(multi_drugs.size()>1)//Added for Bru-HIMS-CRF-414- ML-BRU-SCF-1528 [IN:053217] -start//commented and added below for ML-BRU-SCF-1881
			//		hmEditLabelValues.put("alt_drug_count", (multi_drugs.size()/5)+""); 
			//	else
					hmEditLabelValues.put("alt_drug_count", "0"); //Added for Bru-HIMS-CRF-414- ML-BRU-SCF-1528 [IN:053217] -end
				alEditLabelPair.add(hmEditLabelValues);
				bean.setSPerformPractId(performing_pract_id);
			 }
			//addig start  for ML-BRU-SCF-1881
			if(multi_drugs.size()>1){
			for(int m=0; m<multi_drugs.size(); m+=5)	{ 
					alt_drug_code		=	(String)multi_drugs.get(m);
					alt_drug_desc		=	(String)multi_drugs.get(m+1);
						hmEditLabelValues = new HashMap();	
						hmEditLabelValues.put("order_id",order_id);
						hmEditLabelValues.put("pres_drug_code",drug_code);
						hmEditLabelValues.put("drug_code",alt_drug_code);
						hmEditLabelValues.put("order_line_no",order_line_no);
						hmEditLabelValues.put("ord_date_time",ord_date_time);
						hmEditLabelValues.put("drug_name_1",drug_name);
						hmEditLabelValues.put("drug_desc",drug_desc); 
						hmEditLabelValues.put("alt_drug_desc",alt_drug_desc);
						hmEditLabelValues.put("pres_qty",qty);
						hmEditLabelValues.put("uom",form_code);
						hmEditLabelValues.put("alt_drug_flag","Y");
						hmEditLabelValues.put("alt_drug_count", (multi_drugs.size()/5)+"");
						alEditLabelPair.add(hmEditLabelValues);
						bean.setSPerformPractId(performing_pract_id);
			     }
			  }
			  		//addig end  for ML-BRU-SCF-1881
			}
			strAllocBMSChkValue  = "";
			strAllocBMSChecked	 = "";
			showZeroQtyCheckBox="";
			showOtherEditLables ="";
		    
			if((strAutoCompletePartialDisp.equals("Y") && Double.parseDouble(bms_qty) > 0 && !qty.equals("")) || (strIncludeZeroQty.equals("Y") && (qty.equals("") || qty.equals("0") || qty.equals("0.0") )) ){//Added for MO-GN-5434 [IN:043669] start //(qty ==null || qty.equals("0")) is changed to Double.parseDouble(bms_qty)>0 for JD-CRF-0179 [IN:41211] //Added || (Double.parseDouble(qty)==0 && strIncludeZeroQty.equals("Y")) for [IN:045700]//qty.equals("0.0") added  for ML-BRU-1810
				showZeroQtyCheckBox ="";
				showOtherEditLables ="display:none";
				strAllocBMSChecked	 = "checked";//added for ML-BRU-1810
				
				if(includeBMSDefCheck_yn.equals("Y") && strBMS_Include_yn.equals("Y")){ //if condition added for [IN:045055](Bru-HIMS-CRF-281[IN:033166]) //Added && strBMS_Include_yn.equals("Y") for [IN:045700]
					strAllocBMSChkValue  = "Y";
					strAllocBMSChecked	 = "checked";
				}
			}
			else{
				showZeroQtyCheckBox="display:none";
				showOtherEditLables ="";
			}
			//Added for MO-GN-5434 [IN:043669] end
			if(!qty.equals("") ){
%>
				<td class="<%=classvalue%>" width="8%"  <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" >&nbsp;
<%
				//if(strIncludeZeroQty.equals("Y")){//Added for MO-GN-5434 [IN:043669] start Commented for [IN:045700]
%>
					<div style="color:blue;font-size:9px;font-weight:bold" id="divIncludeZeroQty<%=recCount%>" style="<%=showZeroQtyCheckBox%>">
						<input type ="checkbox" name ="alloc_bms_chk_<%=recCount%>" value="<%=strAllocBMSChkValue%>" onclick="assignValue(this);setEnableDsbleCOR(this,'<%=recCount%>');" <%=strAllocBMSChecked%> />
						<fmt:message key="ePH.INCLUDE_IN_BMS.label" bundle="${ph_labels}"/>
					</div>								
<%
				//} Commented for [IN:045700]
%>
					<div id="divOtherEditLables<%=recCount%>" style="<%=showOtherEditLables%>">	
<%//Added for MO-GN-5434 [IN:043669] end
					if(!order_type.equals("TD") && !order_type.equals("TA")){
%>
						<label style='color:blue;cursor:pointer;font-size:9px' id='detail"+recCount+"' onClick="callEditDetails(this,'<%=order_id%>','<%=drug_code%>','<%=recCount%>','<%=order_line_no%>','D','<%=recCount%>','<%=patient_id%>','<%=ord_date_time%>','<%=pract_id%>','<%=drug_code%>','<%=drug_name_1%>','<%=pres_qty%>','<%=uom%>','<%=disp_locn_catg%>')"><fmt:message key="ePH.EditLabel.label" bundle="${ph_labels}"/></label><br>
<%
					}
%>
					<!-- <%	
					del_style	=	"<input type='checkbox'   name='del_detail"+recCount+"' id='del_detail"+recCount+"'  style='visibility:visible' checked value='Y' onClick='updateValue(this)'>"; %> -->
					<input type='checkbox'   name='del_detail<%=recCount%>' id='del_detail<%=recCount%>'  style='visibility:visible' <%=disp_delivery_chk_box%> <%=disp_delivery_chk_box_disabled%>  value='<%=disp_delivery_chk_box_val%>' onClick='updateValue(this)'>
					<!-- <%=del_style%> -->
					</div><!-- //Added for MO-GN-5434 [IN:043669] -->
					<br>
					<label style="cursor:pointer;color:blue;font-size:9px;" id="fill_remarks<%=recCount%>" onClick="callFillingRemarks(this,'<%=order_id%>','<%=drug_code%>','<%=recCount%>','<%=order_line_no%>','D','fill_remarks<%=recCount%>');"> <fmt:message key="Common.Findings.label" bundle="${common_labels}"/></label>
					</td>
<%
				}		
				else{
%>
					<td class="<%=classvalue%>" width="8%"  <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" >&nbsp;
<%
					del_style	=	"<input type='checkbox'   name='del_detail"+recCount+"' id='del_detail"+recCount+"'  style='visibility:hidden' checked value='N' onClick='updateValue(this)'>"; 
%>
					<%=del_style%> </td>
<%
				}
			}
			else{
%>
				<td class="<%=classvalue%>" width="8%"  <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" >&nbsp;
<%
				del_style	=	"<input type='checkbox'   name='del_detail"+recCount+"' id='del_detail"+recCount+"'  style='visibility:hidden' checked value='N' onClick='updateValue(this)'>"; 
%>
				<%=del_style%> </td>
<%
			}
		}	

	        bms_strength="";
			strength_uom="";
			
					if(!scope.equals("H") && scope!=null){	
						if(bms_qty.equals("") || Double.parseDouble(bms_qty)==0){  // bms_qty.equals("0.0") ) changed to bms_qty.equals("") || Double.parseDouble(bms_qty)==0 for KAUH-SCF-0096 [IN:035355]
							disable_complete_order	=	"disabled";
					   }
					   else{
							disable_complete_order	=	"";
					   }
					}
					
					
					/*if(stock_opt.size()!=0 && ((String)stock_opt.get(0)).equals("N")) {
						image		=	"<img src='../../eCommon/images/disabled.gif' align='center'>";
					}
					else {
						image		=	"";
					}*/
				
					alloc_empty_det	=	"<td class="+classvalue+" width='10%'>&nbsp;<label style='color:blue;cursor:pointer;font-size:9px' id='alloc_detail"+recCount+"'>&nbsp;</label><input type='hidden' name='alloc_status"+recCount+"' id='alloc_status"+recCount+"' value=''></td>";
					
					if(!qty.equals("") && bean.getFilling(patient_id,order_id,order_line_no)) {
						alloc_det	=	"<td class="+classvalue+" width='10%' align='center'>&nbsp;<img src='../../eCommon/images/enabled.gif'><label id='alloc_detail"+recCount+"' style='visibility:hidden'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Det.label","ph_labels")+"</label><input type='hidden' name='alloc_status"+recCount+"' id='alloc_status"+recCount+"' value='P'></td>";

					}
					else {
					 
						alloc_det	=	"<td class="+classvalue+" width='10%'>&nbsp;<label style='color:blue;cursor:pointer;font-size:9px' id='alloc_detail"+recCount+"' onClick='callAllocate(\""+patient_id+"\",\""+order_id+"\",\""+drug_code+"\",\"AS\",\"A\")'>&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Detail.label","common_labels")+"</label><input type='hidden' name='alloc_status"+recCount+"' id='alloc_status"+recCount+"' value='P'></td>";
					}

					filling_empty_det	="<td class="+classvalue+" width='8%'>&nbsp;<label id='fill_detail"+recCount+"'>&nbsp;</label><input type='hidden' name='fill_status"+recCount+"' id='fill_status"+recCount+"' value=''></td>";
					
					filling_det			="<td class="+classvalue+" width='10%'>&nbsp;<label style='color:blue;cursor:pointer;font-size:9px' id='fill_detail"+recCount+"' onClick='callFilling(\""+patient_id+"\",\""+order_id+"\",\""+drug_code+"\",\"AS\",\"F\")'>&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Detail.label","common_labels")+"</label><input type='hidden' name='fill_status"+recCount+"' id='fill_status"+recCount+"' value='P'></td>";


					if(display_seq.equals("A")) {  
						if(allocation_reqd.equals("Y")) {
						  if(qty.equals("") && alt_qty.size() < 1) 	
							out.println(alloc_empty_det);
						  else	
							out.println(alloc_det);
						}

						if(filling_reqd.equals("Y")) { 
							if(qty.equals("") && alt_qty.size() < 1)
								out.println(filling_empty_det);
							else if((!qty.equals("") || alt_qty.size() >=1) && bean.getFilling(patient_id,order_id,order_line_no))
								out.println(filling_det);
							else 
								out.println(filling_empty_det);
						}	
					}
					else{	
						if(filling_reqd.equals("Y")) { 
							if(qty.equals(""))
								out.println(filling_empty_det);
							else if((!qty.equals("") || alt_qty.size() >=1) &&  bean.getFilling(patient_id,order_id,order_line_no))
								out.println(filling_det);
							else 
								out.println(filling_empty_det);
						} 
					 
						if(allocation_reqd.equals("Y")) {
							if(qty.equals("") && alt_qty.size() < 1) {	
								out.println(alloc_empty_det);
							}
							else{	
								out.println(alloc_det);
							}	
						}
					}
%>
					<input type="hidden"  name="order_line_num<%=recCount%>" id="order_line_num<%=recCount%>" value="<%=order_line_no%>">
					<input type="hidden"  name="pres_qty<%=recCount%>" id="pres_qty<%=recCount%>" value="<%=pres_qty%>">
<%
					if(disp_level.equals("P")) {	
%>
						<input type="hidden"  name="order_id<%=recCount%>" id="order_id<%=recCount%>" value="<%=order_id%>">
<%	
					}	
					if(scope.equals("H")){
						legend1=bean_1.getresultlinestatus(order_id,order_line_no);
				 
						if(legend1==null)
							legend1="";
						if(legend1.equals("OS"))
							legend_text= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outstanding.label","common_labels");
						else if(legend1.equals("DP"))
							legend_text= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PartiallyDispensed.label","ph_labels");
						else if(legend1.equals("RG"))
							legend_text= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InProcess.label","common_labels");
						else if(legend1.equals("AL"))
							legend_text= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Alloocated.label","ph_labels");
					
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
					<td class="<%=classvalue%>"  ><label style="color:red;font-size:9px" id="result_line_status<%=recCount%>"style="<%=visibility1%>"><b><%=legend_text%></b></label>  
					<input type='checkbox'   name="CompleteOrder<%=recCount%>" id="CompleteOrder<%=recCount%>" value='N' onClick='setcompleteorder(this)'	style='visibility:hidden' <%=disable_complete_order%>   >
					<select name="ComplteOrderReason<%=recCount%>" id="ComplteOrderReason<%=recCount%>" style="<%=visibility2%>" onchange='setCheckBoxValueInAllStages(this,document.DispMedicationAllStages.CompleteOrder<%=recCount%>,document.getElementById("hold_remarks_")<%=recCount%>,<%=recCount%>)'  <%=disable_complete_order%> <%=disable_alloc_text_box%>>
					<option value="">------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
<%
				       for(int m=0; m<complete_reason_codes.size(); m=m+2){
%>
							<option value="<%=complete_reason_codes.get(m)%>"><%=complete_reason_codes.get(m+1)%></option>
<%
					   }
%>
					</select>	
					</td>
<%			        
					 //AAKH-CRF-0117 - start
					if(approval_flag){
						disabled = "";
					}
					if(approval_no_flag) {
						String approval_no="";//AAKH-CRF-0117
						  if(approval_flag){//AAKH-CRF-0117
								approval_no= (String)approvalNo.get(order_id+order_line_no);
								 
						   }
						   if(approval_no==null) //AAKH-CRF-0117
							   approval_no = "";
%>                              
					 <td class="<%=classvalue%>" nowrap> <!--modified for AAKH-CRF-0117 -->    
					 <input type="text" maxlength="20" onchange="getApprovalNumForDrug(this,<%=recCount%>)"  name="approval_no_<%=recCount%>" <%=disabled%> value="<%=approval_no%>"  onKeyPress="return KeyPressSpecCharsForApprovalNo(event)" onBlur="CheckForSpecCharApprovalno(this,'AS',<%=recCount%>)"/><!--MODIFIED FOR AAKH-CRF-0117 and modified for CRF-0117 -->
					 
					 <%
						if(approval_no_app_for_patient_class!=null && approval_no_app_for_patient_class.equals("Y") && disabled.equals("")){ 
					 approval_no_style = "visibility:visible";
					 }%>
						<img id="imgForWithin_<%=recCount%>" src="../../eCommon/images/mandatory.gif" align="center" style="<%=approval_no_style%>"></img><!-- AAKH-CRF-0117-->	
 						</td>
<%
						}	 //AAKH-CRF-0117 - end	
%>
					<input type="hidden" name="release_flag<%=recCount%>" id="release_flag<%=recCount%>" value="N">  
					<input type="hidden" name="base_to_disp_uom_equl_val<%=recCount%>" id="base_to_disp_uom_equl_val<%=recCount%>" value="<%=base_to_disp_uom_equl%>">
					<input type="hidden" name="base_to_def_uom_equl_val<%=recCount%>" id="base_to_def_uom_equl_val<%=recCount%>" value="<%=base_to_def_uom_equl%>">
					<input type="hidden" name="dischargeIND<%=recCount%>" id="dischargeIND<%=recCount%>" value="<%=dischargeIND%>">
					<input type="hidden" name="allow_decimals_yn<%=recCount%>" id="allow_decimals_yn<%=recCount%>" value="<%=st_allow_decimals_yn%>">  <!-- Added for AAKH-SCF-0113 [IN:048937] -->
					<input type="hidden"  name="order_id_<%=recCount%>" id="order_id_<%=recCount%>" value="<%=order_id%>"> <!--added for AAKH-CRF-0117 -->
					 <input type="hidden"  name="drug_code_<%=recCount%>" id="drug_code_<%=recCount%>" value="<%=drug_code%>"><!--added for AAKH-CRF-0117 -->
					<input type="hidden"  name="order_line_num_<%=recCount%>" id="order_line_num_<%=recCount%>" value="<%=order_line_no%>"><!--added for AAKH-CRF-0117 -->
					<%-- <input type="hidden" name="taper_order_yn<%=recCount%>" id="taper_order_yn<%=recCount%>" value="<%=taper_order_yn%>">  Commented for RUT-CRF-0088 [IN036978] 
					<input type="hidden" name="taper_order_id<%=recCount%>" id="taper_order_id<%=recCount%>" value="<%=taper_order_id%>">
					<input type="hidden" name="taper_order_line_num<%=recCount%>" id="taper_order_line_num<%=recCount%>" value="<%=taper_order_line_num%>"> --%>
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

			if(stDrugCodes.size()>0){
				sDispDrugAuthYN = bean.getDispDrugAuthYN(stDrugCodes);
			}    
%>
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="bean_id_1" id="bean_id_1" value="<%=bean_id_1%>">
			<input type="hidden" name="bean_name_1" id="bean_name_1" value="<%=bean_name_1%>">
			<input type="hidden" name="disp_stage" id="disp_stage" value="<%=disp_stage%>">
			<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
			<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
			<input type="hidden" name="pract_id" id="pract_id" value="<%=pract_id%>">
			<input type="hidden" name="pract_name" id="pract_name" value="<%=pract_name%>">
			<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>">
			<input type="hidden" name="recCount" id="recCount" value="<%=recCount%>">
			<input type="hidden" name="filling_status" id="filling_status" value="<%=filling_status%>">
			<input type="hidden" name="del_data" id="del_data" value="<%=del_data%>">
			<input type="hidden" name="source_code" id="source_code" value="<%=source_code%>">
			<input type="hidden" name="source_type" id="source_type" value="<%=source_type%>">
			<input type="hidden" name="ordering_facility_id" id="ordering_facility_id" value="<%=ordering_facility_id%>">
			<input type="hidden" name="ord_date_time" id="ord_date_time" value="<%=ord_date_time%>">
			<input type="hidden" name="performing_pract_id" id="performing_pract_id" value="<%=performing_pract_id%>">
			<input type="hidden" name="module_id" id="module_id" value="<%=module_id%>">
			<input type="hidden" name="mode" id="mode" value="<%=CommonRepository.getCommonKeyValue( "MODE_MODIFY" )%>">
			<input type="hidden" name="tot_rec" id="tot_rec" value="<%=recCount%>">
			<input type="hidden" name="curr_stage" id="curr_stage" value="<%=curr_stage%>">
			<input type="hidden" name="disp_level" id="disp_level" value="<%=disp_level%>">
			<input type="hidden" name="disp_locn_catg" id="disp_locn_catg" value="<%=disp_locn_catg%>">
			<input type="hidden" name="ord_type" id="ord_type" value="<%=ord_type%>">
			<input type="hidden" name="IssueByUOM" id="IssueByUOM" value="<%=bean_1.getIssueByUOM()%>">
			<input type="hidden" name="EquivalentNormalOrder" id="EquivalentNormalOrder" value="<%=bEquivalentNormalOrder%>">
			<input type="hidden" name="function_id" id="function_id" value="<%=bean_1.getSFunctionId()%>">
			<input type="hidden" name="iv_prep_yn" id="iv_prep_yn" value="<%=iv_prep_yn%>">
			<input type="hidden"  name="delivery_reqd" id="delivery_reqd" value="<%=delivery_reqd%>">
			<input type="hidden" name="IncludeZeroQty" id="IncludeZeroQty" value="<%=strIncludeZeroQty%>"><!-- Added for MO-GN-5434 [IN:043669]  -->
			<input type="hidden" name="pres_qty_alert" id="pres_qty_alert" value="<%=pres_qty_alert%>"><!-- code added for AMS-CRF-0035[IN033551] --> 
			<input type="hidden" name="includeBMSDefCheck_yn" id="includeBMSDefCheck_yn" value="<%=includeBMSDefCheck_yn%>"><!-- code added for [IN:045055](Bru-HIMS-CRF-281[IN:033166]) -->   
			<input type="hidden" name="strAutoCompletePartialDisp" id="strAutoCompletePartialDisp" value="<%=strAutoCompletePartialDisp%>"><!-- Added for JD-CRF-0179 [IN:41211] -->   
			<input type="hidden" name="no_of_decimals" id="no_of_decimals" value="<%=st_no_of_decimals%>"> <!-- Added for AAKH-SCF-0113 [IN:048937] -->
			<input type="hidden" name="disp_decimal_dtls_yn" id="disp_decimal_dtls_yn" value="<%=st_disp_decimal_dtls_yn%>"> <!-- Added for AAKH-SCF-0113 [IN:048937] -->
			<input type="hidden" name="disp_locn_code" id="disp_locn_code" value="<%=disp_locn_code%>">
			<input type="hidden" name="allow_amend_alt_drug_dtl" id="allow_amend_alt_drug_dtl" value="<%=allow_amend_alt_drug_dtl%>"> <!-- Added for JD-CRF-0198 [IN058599] -->
			<input type="hidden"  name="displayGrossAmtYn" id="displayGrossAmtYn" value="<%=displayGrossAmtYn%>"><!-- added for ML-BRU-CRF-0469 -->
			<input type="hidden" name="approval_no_flag" id="approval_no_flag" value="<%=approval_no_flag%>"><!-- AAKH-CRF-0117-->
			<input type="hidden" name="approval_no_app_for_patient_class" id="approval_no_app_for_patient_class" value="<%=approval_no_app_for_patient_class%>"> <!-- AAKH-CRF-0117-->
			<input type="hidden" name="approval_no" id="approval_no" value=""> <!-- AAKH-CRF-0117-->
			<input type="hidden" name="added_by_id" id="added_by_id" value="<%=added_by_id%>"> <!-- mohe-crf-0026.1 start -->
			<input type="hidden" name="login_at_ws_no" id="login_at_ws_no" value="<%=login_at_ws_no%>"> 
			<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
			<input type="hidden" name="disp_data" id="disp_data" value="<%=disp_data%>"> 
			<input type="hidden" name="authStatus_disp_data" id="authStatus_disp_data" value="<%=authStatus_disp_data%>">
			<input type="hidden" name="postDisp_disp_data" id="postDisp_disp_data" value="<%=postDisp_disp_data%>"> 
			<input type="hidden" name="claimId" id="claimId" value="<%=claimId%>"> 
			<input type="hidden" name="response_code" id="response_code" value="<%=response_code%>"> 
			<input type="hidden" name="alloc_qty_check" id="alloc_qty_check" value="<%=alloc_qty_check%>">
			<input type="hidden" name="responseStatus" id="responseStatus" value="<%=responseStatus%>">
			<input type="hidden" name="authReqSent" id="authReqSent" value="<%=authReqSent%>">
			<input type="hidden" name="iqvia_integration_flag" id="iqvia_integration_flag" value="<%=iqvia_integration_flag%>">
			<input type="hidden" name="postAuthStatusData" id="postAuthStatusData" value="<%=postAuthStatusData%>">  
			<input type="hidden" name="authStatusCompleted_yn" id="authStatusCompleted_yn" value="<%=authStatusCompleted_yn%>"> 
			<input type="hidden" name="settlement_id" id="settlement_id" value="<%=settlement_id%>"> 	 
			<input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>"> <!-- TFS: 23589 -->
			<!-- MOHE-CRF-0026.1 END -->
			
			
<%
			if(billing_interface_yn.equals("Y")&& bl_display.equals("Y")){
%>
				<input type="hidden" name="bl_encounter_id" id="bl_encounter_id" value="<%=bl_encounter_id%>">
				<input type="hidden" name="bl_patient_class" id="bl_patient_class" value="<%=patient_class%>">
				<input type="hidden" name="bl_sysdate" id="bl_sysdate" value="<%=sysdate%>">	
				<input type="hidden" name="tot_gross_charge_amount" id="tot_gross_charge_amount" value="<%=tot_gross_charge_amount%>">
				<input type="hidden" name="tot_groos_pat_payable" id="tot_groos_pat_payable" value="<%=tot_groos_pat_payable%>">
				 <!-- added for ML-BRU-CRF-0469 start-->
				<%if(displayGrossAmtYn){ %>
				<input type="hidden" name="tot_gross_amount" id="tot_gross_amount" value="<%=tot_gross_amount%>">
				<%} %>
				 <!-- added for ML-BRU-CRF-0469 start-->
<%
			}
%>
		</form>
<%
		if(!decimalFormatString.equals("")&&billing_interface_yn.equals("Y")&& bl_display.equals("Y")){
			DecimalFormat dfTest        = new DecimalFormat(decimalFormatString);
			tot_gross_charge_amount_str = dfTest.format(tot_gross_charge_amount);
			tot_groos_pat_payable_str   = dfTest.format(tot_groos_pat_payable); 
			//added for ML-BRU-CRF-0469 start
			if(displayGrossAmtYn){ 
			tot_gross_amount_str        = dfTest.format(tot_gross_amount);
			
			}
			//added for ML-BRU-CRF-0469 end
		}

		if(item_uom_definition_flag){%>
   
			<script>alert(getMessage("PH_ITEMS_UOM_DEF_NOT_FOUND","PH"));</script>
<%
		}
%>
<%! 
		DecimalFormat dfToInteger = new DecimalFormat("#.####");
		private String retunFormatedInt(String sValue){
			if(sValue != null && !sValue.equals("")){
				return dfToInteger.format(Double.parseDouble(sValue));
			}
			return "";
		}
%>
	</body>
	<script>
<% 
		if(allocation_reqd.equals("Y") && filling_reqd.equals("Y"))  { 
%>
			controlAllocFillingButtons();
<%
		}
		else if(allocation_reqd.equals("Y") && delivery_reqd.equals("Y")) { 
%>	
			controlAllocButton();
<%	
		}
		else if(filling_reqd.equals("Y") && delivery_reqd.equals("Y") ) { 
%>
		//	controlFillingButton(document.DispMedicationAllStages);
<%	
		}
%>
		//callLegendsFrame('<%=patient_id%>','AS','','','<%=order_id%>');
		callLegendsFrame('<%=patient_id%>','AS','','','<%=order_id%>','<%=billing_interface_yn%>','<%=tot_gross_charge_amount_str%>','<%=tot_groos_pat_payable_str%>','','<%=sDispDrugAuthYN%>','<%=tot_gross_amount_str%>');// added for ML-BRU-CRF-0469  ,'tot_gross_amount_str'
		<% 
		if(!display_list.equals("display:none")){ //Added for AAKH-SCF-0377/ML-BRU-SCF-1880 - Start
%>
			try{
				for(var i=1; i<<%=recCount%>;i++){
<% 
					if(!item_uom_definition_flag){
%>
						if(eval('document.DispMedicationAllStages.alloc_qty_'+i).value != ''){							
							calculateIssueUOM(eval('document.DispMedicationAllStages.issue_uom_select_'+i),i,eval('document.DispMedicationAllStages.issueUOMValue_'+i).value,'NO',eval('document.DispMedicationAllStages.approval_no_'+i).value); // .value added forMMS-SCF-0040 [IN:041888] and modified for AAKH-CRF-0117
						}
<% 
					}
%>
				}
			}
			catch(exp){
			}
<%
		} //Added for AAKH-SCF-0377/ML-BRU-SCF-1880 - End
%>
		</script>
</html>
<%
	bean.clearAlEditLabelPairValues();
	bean.setAlEditLabelPairValues(alEditLabelPair);
	medplan_bean.setMedOrderIds(arrOrderId);// Added for Bru-HIMS-CRF-072.1 [IN:049144]
	putObjectInBean(medplan_bean_id,medplan_bean,request);// Added for Bru-HIMS-CRF-072.1 [IN:049144]
	putObjectInBean(param_bean_id,param_bean,request);
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(bean_id_1,bean_1,request);
	putObjectInBean(bean_id_2,bean_2,request);
	putObjectInBean(bean_id_st,bean_st,request); // Added for KAUH-SCF-0094 [IN:035252] 
	}
	catch(Exception e){
		e.printStackTrace();
	}
    
%>

