<!DOCTYPE html>

<!-- 
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
04/10/2017      IN063877         Devindra       Unused Variables.
05/07/2019      [IN:067952]     Devindra             MMS-KH-CRF-0013 [IN:067952] 
09/08/2019      IN070605		 prathyusha  MMS-KH-CRF-0028
13/08/2019      IN070451		 Manickavasagam J						ML-MMOH-CRF-1408
13/08/2019      IN070605		 Devindra           MMS-KH-CRF-0028
26/08/2019      IN071102		 Manickavasagam J						MMS-KH-SCF-0035
10/09/2019	  	IN070605	     	prathyusha 		  									 MMS-KH-CRF-0028 
29/10/2019		IN071533			Shazana				SKR-SCF-1275
30/11/2019		IN070606                Manickavasagam J                       MMS-KH-CRF-0029[IN070606]
06/02/2020		IN071362                Manickavasagam J                         AAKH-CRF-0117
19/06/2020		IN072387                Manickavasagam J                         ML-MMOH-SCF-1479
11/08/2020		IN073523		Shazana								 PHIS-PH-Alpha - Exceed Dosage Limit Icon in Fill and Deliver Stage
08/10/2020  		IN074038        	Manickavasagam J                                    ML-BRU-SCF-2049
12/10/2020      IN073397            Prabha     12/10/2020     Manickavasagam J          MOHE-CRF-0032
18/11/2020      TFS:6608            Manickavasagam J     18/11/2020                  ML-BRU-SCF-2055
30/11/2020	8659		    Shazana					     MMS-MD-SCF-0141
17/12/2020      TFS:10221            Manickavasagam J     		                  ML-BRU-SCF-2055.2 	
7/7/2021		TFS:9495	Shazana					MOHE-CRF-0026.1
---------------------------------------------------------------------------------------------------------------
 -->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.text.DecimalFormat,eST.*,eST.Common.*,java.sql.*,webbeans.eCommon.*,eXH.*,eCommon.XSSRequestWrapper" %>
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
		<script language="javascript" src="../../ePH/js/PPNRegimen.js"></script>
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
<%
				String iv_prep_yn				 =	"";
				String	bean_id					 =	"DispMedicationAllStages" ;
				String	bean_name				 =	"ePH.DispMedicationAllStages";	
				DispMedicationAllStages bean	 = (DispMedicationAllStages)getBeanObject( bean_id,bean_name, request);	
				bean.setLanguageId(locale);

				//bean.clear();
				bean.loadReason();
				bean.setModuleId("2");	
				String bean_id_1				 = "DispMedicationBean" ;
				String bean_name_1				 = "ePH.DispMedicationBean";	
				DispMedicationBean bean_1		 = (DispMedicationBean)getBeanObject( bean_id_1,bean_name_1, request );
				bean_1.setLanguageId(locale);

				String facility_id					= (String) session.getValue("facility_id");
				String param_bean_id				= "@DrugInterfaceControlBean";
				String param_bean_name				= "ePH.DrugInterfaceControlBean";
				DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
				String drug_db_interface_yn			= param_bean.getDrugDBInterface_yn(facility_id); 
				param_bean.clear();

				String Image_bean_id				= "@DrugTradeImageBean";
				String Image_bean_name				= "ePH.DrugTradeImageBean";
				DrugTradeImageBean drug_trade_bean	= (DrugTradeImageBean)getBeanObject( Image_bean_id, Image_bean_name, request );
				String medplan_bean_id="MedicationPlannerBean";// Added for Bru-HIMS-CRF-072.1[IN 049144]
				String medplan_bean_name="ePH.MedicationPlannerBean";// Added for Bru-HIMS-CRF-072.1[IN 049144]
				MedicationPlannerBean medplan_bean = (MedicationPlannerBean)getBeanObject( medplan_bean_id, medplan_bean_name,request);// Added for Bru-HIMS-CRF-072.1[IN 049144]
				bean_1.setObject(medplan_bean);// Added for Bru-HIMS-CRF-072.1[IN 049144]
				bean_1.setObject(bean);
				//String stSalseBean_id				=    "salesBean";//Added for AMS-CRF-0068.1 [IN:050333] start  // comment Added for IN063877
				//String stSalseBean_name			    =    "eST.SalesBean";                                     // comment Added for IN063877
				SalesBean stSalseBean 				=	(SalesBean)getBeanObject( "salesBean", "eST.SalesBean", request );//Added for AMS-CRF-0068.1 [IN:050333] -end
		java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ; //MOHE-CRF-0026.1  
		String login_at_ws_no		        = prop.getProperty( "client_ip_address" );//MOHE-CRF-0026.1  
		String added_by_id			= prop.getProperty("login_user");//login_by_id
		String disp_data = "";  
		String authStatus_disp_data = ""; 
		String postDisp_disp_data =""; 
		bean_1.setIqviaDispData(null);  //MOHE-CRF-0026.1    
		bean_1.setIqviaAuthStatusDispData(null);  
		bean_1.setIqviaAfterDispenseData(null); 
		boolean iqvia_integration_flag = false; 
		String claimId = ""; 
		String claimIdNo = ""; 
		String response_code = ""; 
		String responseStatus = ""; 
		String authReqSent = "";  
		String alloc_qty_check= "";//MOHE-CRF-0026.1 end 
		Connection con			= null;//added for ml-mmoh-crf-0468
		
		try{ 
			String disp_locn_catg		 =	bean_1.getDispLocnCatg();
			String patient_class		 =	"";
			if(disp_locn_catg.equals("I")) {
				patient_class	=	"IP";
			} else {
				patient_class	=	"OP"; 
			}
			con				= ConnectionManager.getConnection(request);//added for ml-mmoh-crf-0468
			boolean tpn_mf_label = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","TPN_MF_LABEL");// Added for ML-MMOH-CRF-0468 
			
			boolean displayGrossAmtYn    = eCommon.Common.CommonBean.isSiteSpecific(con, "PH", "GROSS_AMT_DISPLY_YN");// Added for ML-BRU-CRF-0469 
	        boolean  allow_zero_disp_label_site= eCommon.Common.CommonBean.isSiteSpecific(con, "PH","ALLOW_ZERO_DISP_LABEL");//added for ML-BRU-CRF-0473
	        boolean intractn_req_yn = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DISP_STAGE_INTRACTN_REQ_YN");	// Added for MMS-KH-CRF-0013 // same variable used for MMS-KH-CRF-0028 [IN070605] 			        
			boolean approval_no_flag = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","APPROVAL_NO_APPLICABLE_FLAG");//AAKH-CRF-0117 
			iqvia_integration_flag =  eCommon.Common.CommonBean.isSiteSpecific(con, "PH","IQVIA_INTEGRATION");//MOHE-CRF-0026.1  
			boolean drug_abuse_appl=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DRUG_ABUSE_APPL");//added for AAKH-CRF-0140
	       	boolean aggred_item_app = eCommon.Common.CommonBean.isSiteSpecific(con, "PH", "AGGRED_ITEM_APP");//added for MMS-DM-CRF-0209.1
	       	boolean site_remarks=eCommon.Common.CommonBean.isSiteSpecific(con, "PH", "DISP_REMARKS");//added for ML-MMOH-CRF-1755
	   
          		if(iqvia_integration_flag){
				bean_1.setIqvia_integration_yn("Y");
		}else{
			bean_1.setIqvia_integration_yn("N");  
		}
		String strDosageDtls = ""; 
		String qtyValue = "";
		String qtyUnit = "";
		String durnValue = "";
		String durationType = "";
		String frequencyCode = "";
		String repeatValue = "";
		String routeCode = ""; 
		String postAuthStatusData = ""; 
		String authStatusCompleted_yn = ""; 
		String itemCost = ""; //MOHE-CRF-0026.1 END  

		boolean expired_order = eCommon.Common.CommonBean.isSiteSpecific(con, "PH", "EXPIRY_ORDER_APP"); //Added for MOHE-CRF-0032					 
		bean_1.setDispStage("D");//added for AMS-SCF-0603
		String primary_lang_id = medplan_bean.getStrPrimaryLangID();//Added for Bru-HIMS-CRF-072.1[IN 049144]
		String loc_lang_id = medplan_bean.getStrLocalLangID();//Added for Bru-HIMS-CRF-072.1[IN 049144]
		Hashtable param_legends = bean_1.getLegendsFromParam();
		String Disp_drug_verify_remarks  =bean_1.getDisp_drug_verify_remarks_yn();//added for ml-mmoh-crf-1755
		String disp_stage = bean_1.getDispStage();

					String approval_no_style = "visibility:hidden"; //AAKH-CRF-0117
					String issue_token_on_regn_YN = bean_1.getIssueTokenOnRegnYN(); //ML-BRU-SCF-2049 & ML-BRU-SCF-2055
					//added for AAKH-CRF-0117 - start
					String approval_no_app_for_patient_class = "N";
					if(approval_no_flag){
					   approval_no_app_for_patient_class = bean.getApprovalNoApplicableForPatientClass(patient_class);
					}
			//added for AAKH-CRF-0117 - end
					String disp_locn_code		= bean_1.getDispLocnCode();
					//String issue_token		=	bean_1.getIssueTokenOnRegnYN();	
					//String filling_status		= bean_1.getFillingStatus();
					String order_type			= bean_1.getOrderType();
					String  worksheet_id		= "";
					String patient_id			= request.getParameter("patient_id");
					String encounter_id			= bean_1.getEncounterID();
					String order_id				= request.getParameter("order_id");
					String alt_drug_qty			= "";
					String qty_status			= "";
					String pat_reqd				="";
					String pt_couns_reqd_yn		="";
					String disable				="";
					double spilqtyavail			= 0;	
					int adr_count				= 0;
					HashMap hmPPNStoredValues	= null;
					HashMap hmEditLabelValues = new HashMap();
					ArrayList alEditLabelPair	= new ArrayList();
					ArrayList dispNoList = new ArrayList(); //MOHE-CRF-0026.1 
					String dispTmpNo= "";

					boolean bDischargePatient  = false;
					String order_line_status		= "";
					if (order_id==null){
						order_id	=	"";
					}		
					if (patient_id==null){
						patient_id	=	"";
					}	
					if(order_type.equals("TA") || (tpn_mf_label && order_type.equals("TD"))){//prathyusha
						worksheet_id=bean_1.getTPNWorksheetID(order_id);
					}
					else{
						worksheet_id=bean_1.getWorksheetID(); 
						
					}
					
                                       String bean_id2					= "@PrescriptionBean_1"+patient_id+encounter_id; // Added for MMS-KH-CRF-0013 - Start
		                       String bean_name2		= "ePH.PrescriptionBean_1"; 
		                       PrescriptionBean_1 pres_bean =  (PrescriptionBean_1)getBeanObject( bean_id2,bean_name2,request) ;
		                       pres_bean.setLanguageId(locale); 
		                       // Added for MMS-KH-CRF-0013 - End

					//Declaration starts
					String qty					= 	"";
					String order_line_no		=	"";
					String drug_code			=	"";
					String drug_name			=	"", drug_name_1="";
					String dosage_dtls			=	"";
					String start_date			=	""; // uncommented for MMS-KH-CRF-0013
					String end_date				=	"";
					String pres_qty				=	"";
					String qty_uom				=	"";
					String qty_uom_disp				=	"";
					String alt_drug_code		=	"";
					String alt_drug_desc		=	"", alt_drug_desc_1="";
					String drug_color			=	"";
					String form_code			=	"";
					String form_desc            = ""; // Added for MMS-KH-CRF-0013
					String hold_status			=	"";
					String remark_status		=	"";
					String uom					=	"", uom_desc="";
					//ArrayList remarks			=	null;
					String title_remarks		=	"";
					//code added for in_formulary....drugs..
					String in_formulary_yn		=	"";
					String pres_details			=	"";
					String pat_couns_reqd_yn	=   "";
					int bmscount                =    0;

					String scope				=   bean_1.getScope();
					String legend               =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.CompleteOrderReason.label","ph_labels"); //"Complete Order Reason";
					String legend1				=   "";
					String legend_text			=   "";
					String strChangedFludRmks   =   "";
					String fractroundupyn       =   "";
					String alt_external_prod_id =	"";
					String expired_yn			=	"";
					//String  taper_order_yn, taper_order_id, taper_order_line_num, show_remarks, taper_disable;
					String  show_remarks, taper_disable; //RUT-CRF-0088 [IN036978]
					String alt_drug_remarks_ind = bean_1.getAltDrugRemarksInd();//bean_1.getAltDrugRemarksInd(); //added for  Bru-HIMS-CRF-082 [IN:029948]
			        String alt_drug_remarks_disp = ""; //added for  Bru-HIMS-CRF-082 [IN:029948]
			    	float tot_tap=0; //Added for RUT-CRF-0088 [IN036978]
			    	//HashMap tot_tap_qty = new HashMap(); //Added for RUT-CRF-0088 [IN036978]
					StringBuffer drugs_remarks  = null ;//Bru-HIMS-CRF-416[IN045566] 
					String strDrugsRemarks="";//Bru-HIMS-CRF-416[IN045566] 
					String medical_applicable="";//added for ghl-crf-0548
					String abuse_drug_override_reason="";//added for aakh-crf-0140  drug_abuse_appl
					String abuse_exists="";//added for aakh-crf-0140
					String drugIndication="";//added for jd-crf-0220
          String	category_code="";//added for mms-dm-crf-209.1
					String	alternate_yn="";//added for mms-dm-crf-209.1
          	String insurance_status ="";//Added for TH-KW-CRF-0012
			HashMap insuranceStatus = bean.getInsuranceStatus();//Added for TH-KW-CRF-0012
	
							if(scope.equals("H")){
						//legend="ResultLineStatus";    
						legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ResultLineStatus.label","ph_labels");//"ResultLineStatus";

					 }
					ArrayList	colors	=	new ArrayList();
					colors.add("#FF0000");
					colors.add("#669900");
					colors.add("#FF9966");
					colors.add("#6699CC");
					colors.add("#FF0000");
					colors.add("#669900");
					colors.add("#FF9966");
					colors.add("#6699CC");
					colors.add("#FF0000");
					colors.add("#669900");
					colors.add("#FF9966");
					colors.add("#6699CC");
					
					String min_stk_flag	=	"display:none;align:right";//Added for AMS-CRF-0068.1 [IN:050333] -start
					String min_stk_flag_bkg_clr	=	"background-color:none";
					String rol_flag_bkg_clr		=	"background-color:none";
					String rol_flag			=	"display:none";
					String disp_req_flag	= "display:none;color:blue";
					
					boolean min_stk	= false;
					boolean rol_stk	= false;
					HashMap rol_min		= null;
					String frm_store_min_stk_level  = "";
					String frm_store_reorder_level =  "", avail_qty="";
					String[] stParameters = {"", "", "0", "N", "", "N", "" };
					HashMap hmStockAvailabilityStatus = null;
					boolean Min_Rol_yn	=bean_1.getMin_Rol_yn();
					boolean getReq_allowed_yn =bean_1.getReq_allowed_yn(); //Added for AMS-CRF-0068.1 [IN:050333] -end

					ArrayList result		=	null;
					ArrayList orderLineDtls	=	new ArrayList();
				//Declaration ends	
					String disp_level		= bean_1.getDispLevelValue();
				//	String disp_catg		= bean_1.getDispLocnCatg(); // comment Added for IN063877
					ArrayList alOrderIds	= new ArrayList();
					ArrayList tmpResult		= new ArrayList();
					if(bean_1.getAlTrxOrderIds()!=null){
						alOrderIds = bean_1.getAlTrxOrderIds();
					}
					if(disp_level.equals("P")) {
						//order lines of all orders
						result			= bean_1.getOrders(patient_id.trim());
						if(bean_1.getCriteriaOrderType()!=null && (bean_1.getCriteriaOrderType().equals("ALL") || bean_1.getCriteriaOrderType().equals("CDR"))){ // CDR Condition Added for ML-MMOH-CRF-0435 [IN:057357]
							if(alOrderIds.size()>0){
								for(int i=0;i<result.size();i=i+11) {		//10 ->11 for SKR-SCF-0330 ICN 29789 //11->13 RUT-CRF-0069 ICN29607    //Modified for RUT-CRF-0088 [IN036978]  13 ->11
									if(alOrderIds.contains(result.get(i+1))){
										for(int j=i;j< i+11;j++)		//10 ->11 for SKR-SCF-0330 ICN 29789 //11->13 RUT-CRF-0069 ICN29607   //Modified for RUT-CRF-0088 [IN036978]  13 ->11
											tmpResult.add(result.get(j));
									}
								}
							}
							result = tmpResult;
						}

						ArrayList tmp	=	new ArrayList();
						for(int i=0;i<result.size();i=i+11) {		//10 ->11 for SKR-SCF-0330 ICN 29789 //11->14 RUT-CRF-0069 ICN29607 //11->13 RUT-CRF-0069 ICN29607
							tmp = (ArrayList)bean_1.getOrderLineDetails(patient_id,(String)result.get(i+1));
							if(tmp.size()!=0) {
								orderLineDtls.add((String)result.get(i+1));
								orderLineDtls.add((String)result.get(i+3));
								for(int j=0; j<tmp.size(); j++)
									orderLineDtls.add(tmp.get(j));
							}
						}
					} 
					else {
						orderLineDtls = (ArrayList)bean_1.getOrderLineDetails(patient_id,order_id);
					}

					String allergy				=	"";
					String exceed_dose			=	"";
					//String duplicate			=	"";
					String generic_id			=	"";
					String generic_name			=	"";
					String dosage_details		=	"";
					String exceed_status		=	"";
					String monograph			=	"";
					String dosage_type			=   "";
					String dosage_unit			=   "";
					String std_dose             =   "";
					String unit_dose			=	"";
					String daily_dose			=	"";
					String bms_qty				=	"";
					String source_code			=	"";
					String source_type			=	"";
					String ordering_facility_id	=	"";
					String ord_date_time		=	"";
					String performing_pract_id	=	"";
					String duplicate_yn			=	"";
					String min_dose_dtls		=	"";
					String min_unit_dose		=	"";
					String min_daily_dose		=	"";
					String alloc_qty_from_tmp	=	"";
					String strength_uom			=	"";
					String strength_uom_disp	=	"";
					String strength_value		=	"";
					String module_id			=	bean.getModuleId(); 
					ArrayList stock_opt			=	new ArrayList();
					double	tot_qty				=	0;
					String drug_class			=	"";
					HashMap pack_dtls			=	null;
					String tmp_bms_qty			=	"";
					String unallocDrugs = bean_1.geuUallocDrugs();
					fractroundupyn              =   "";
					ArrayList complete_reason_codes = (ArrayList)bean.getCompleteReasonCodes();

					//Billing interface
					String disp_delivery_chk_box			=	"checked";
					String disp_delivery_chk_box_val		=	"Y";
					String disp_delivery_chk_box_disabled	=	"";
					//String complete_order_reason_disabled	=	"";
					String str_enable_disable				=   "";
					String amt_paid_yn						=	"";
					String  billing_interface_yn			=	bean.getBLInterfaceYN();//checkforbillinginterface();
					String width							=	"100%";
					String bl_encounter_id					=	 bean_1.getEncounterID();
					String bl_display						=	"Y"; 
					String ord_type							=	bean_1.getOrderType();
					String bl_patient_class					=	"";	
					String sysdate							=   bean_1.getTodaysDate();
					float tot_gross_charge_amount			=   0;
					float tot_groos_pat_payable				=   0; 
					float tot_gross_amount             =   0; // added for ML-BRU-CRF-0469
					String tot_gross_charge_amount_str		=  "";
					String tot_groos_pat_payable_str		=  "";
					String tot_gross_amount_str         =	"";	// added for ML-BRU-CRF-0469
					String gross_charge_amount_str			=  "";
					String groos_pat_payable_str			=  "";
					String gross_amount_str             =   ""; //added for ML-BRU-CRF-0469
					String decimalFormatString				=  "";
					String	batch_str						=  "";
					String image_path						=   "";
					String trade_code						=   "";
					String gross_admx_prep_charge				=	"";
					String groos_pat_payable_admx_prep_charge	=	"";    
					String admixture_yn						=  "N";
					String admx_prep_charges_appl_yn		= bean_1.getadmx_prep_charges_appl_yn();
					String disp_billing_stage               = bean_1.getDispBillStage();  // getDisp_Bill_Stage changed to getDispBillStage for SRR20056-SCF-7639ICN027720 
					String disp_cash_coll_stage             = bean_1.getDispCashCollStage();  
					//added during PE By Naveen
					String drug_db_product_id				=	"";
					String allergy_override_reason			=	"";
					String dosage_limit_override_reason		=	"";
					String duplicate_drug_override_reason	=	"";
					String interaction_override_reason		=	"";
					String contraind_override_reason		=	"";	
					String  billable_item_yn				=	"";
					String dischargeIND ="";
					String strBMS_Include_yn ="N";// Added for [IN:045295]
					String food_interaction_override_reason =   "";//MMS-KH-CRF-0029
					String lab_interaction_override_reason =   ""; //MMS-KH-CRF-0029
					String disease_inter_override_reason =   "";//Added for MMS-DM-CRF-0229
					String home_med_yn ="", home_med_style="",home_med_style_1="";//Added for Bru-HIMS-CRF-093-DD1[IN047223]//modified for ml-bru-scf-1784
					String allow_deliver_without_bl = bean_1.getDeliverWithoutBL();  
					String drug_desc = "";//Added for Bru-HIMS-CRF-414 ML-BRU-SCF-1454 [IN:052271]
					String disc_cancelled_orders="",  disc_cancelled_orders_display="display:none;"; //Added for HSA-CRF-0138 [IN:048414] & Bru-HIMS-CRF-080
					//ends here
					HashMap taperValues = null; //Added for RUT-CRF-0088 [IN036978]
					String totalTaperQtyDisplay = bean_1.getTotalTaperQtyDisplay();//Added for RUT-CRF-0088 [IN036978]
					int count = 0;
					String dose_unit_desc="";//Added for Ml-MMOH-SCF-0863
					String ceil_dose_unit_desc = "";//added for ML-MMOH-CRF-1408
					if(ord_type.equals("TA") || (tpn_mf_label && order_type.equals("TD"))){//added for ml-mmoh-crf-0468
							bl_display                   ="N";        
					}
					boolean approval_flag = false;//AAKH-CRF-0117
					if(billing_interface_yn.equals("Y")){	
						 width="115%"; 
						bl_patient_class  =   bean.getEncounterPatientClass(bl_encounter_id, patient_id);  // patient_id  added for [IN:035667] 
						if(order_type.equals("TA") ||(tpn_mf_label && order_type.equals("TD"))){//added for ml-mmoh-crf-0468
							HashMap bl_det =(HashMap)bean.getBillingDetails( disp_locn_code , worksheet_id,patient_id,bl_encounter_id,bl_patient_class,sysdate,order_id,"D",dischargeIND);
							if(bl_det.containsKey("TOT_GROSS_CHRG_AMT")&&bl_det.containsKey("TOT_PAT_PAYABLE_AMT")){
								tot_gross_charge_amount_str	= (String)bl_det.get("TOT_GROSS_CHRG_AMT");    
								tot_groos_pat_payable_str	= (String)bl_det.get("TOT_PAT_PAYABLE_AMT");
							}
                             // added for ML-BRU-CRF-0469 && !tot_gross_amount_str.equals("")
							if(!tot_gross_charge_amount_str.equals("")&& !tot_groos_pat_payable_str.equals("")&& !tot_gross_amount_str.equals("")){
								tot_gross_charge_amount     = Float.parseFloat(tot_gross_charge_amount_str);
								tot_groos_pat_payable       = Float.parseFloat(tot_groos_pat_payable_str);
								if(displayGrossAmtYn){
								tot_gross_amount            = Float.parseFloat(tot_gross_amount_str);//added for ML-BRU-CRF-0469
								}
								if(tot_gross_charge_amount!=tot_groos_pat_payable) //AAKH-CRF-0117
									approval_flag = true;
								
							}
						}
					}
					if(order_type.equals("TD")){
						hmPPNStoredValues = bean_1.getPPNIOrderValues(order_id, patient_id,disp_locn_code,dischargeIND);
					}
					//ends here
					String settlement_id = bean_1.getSettlementId(); //added for MOHE-CRF-0026.1
				//	System.out.println("settlement_id: "+settlement_id);  
%>
					<table cellpadding="0" cellspacing="0" width='<%=width%>' align="center" border="1" id="deliveryTable">
						<tr>
						     <%	if(intractn_req_yn && order_type.equals("NOR")){ //Added for MMS-KH-CRF-0028 [IN070605] - Start
                             %><td class= "COLUMNHEADER" width="4%" style="font-size:9px"><fmt:message key="Common.Select.label" bundle="${common_labels}"/>
							 <input type="checkbox" value="Y" name="selectAll" id="selectAll" checked onClick="selectAllRcordsDeliver(this,'<%=disp_stage%>')" >
							 </td><!-- added for GHL-CRF-0453-->
                             <%					
                                } //Added for MMS-KH-CRF-0028 [IN070605] - End
						     //added for MOHE-CRF-0026.1
						     if(iqvia_integration_flag){ 
						     if( patient_class.equalsIgnoreCase("OP") && (settlement_id.equalsIgnoreCase("X")) && (iv_prep_yn ==null || iv_prep_yn.equals("")|| iv_prep_yn.equals("null")) ){  
                             %>	
                            <td class= "COLUMNHEADER" width="4%" style="font-size:9px"><fmt:message key="ePH.Auth.label" bundle="${common_labels}"/>
							 <input type="checkbox" value="Y" name="AuthAll" id="AuthAll" checked onClick="authtAllRcordsDeliver(this,'<%=disp_stage%>')" >
							 </td><!-- added for mohe-crf-0026.1-->
							 <%} } %>
							<td class= "COLUMNHEADER"width="10%" style="font-size:9px"><%=param_legends.get("V")%>Status</td> <!-- 6% changed to 10% for MMS-KH-CRF-0013 -->
							<!-- <th width="3%" style="font-size:9">&nbsp;</th> -->
							<td  class="COLUMNHEADER" width="4%"  style="font-size:9px" >&nbsp;</td><!--Added for Bru-HIMS-CRF-093-DD1[IN047223]-->
								<%	if(patient_class.equals("IP")){ %>
							<td  class="COLUMNHEADER" width="4%"  style="font-size:9px" >&nbsp;</td><!--Added for ml-bru-scf-1784-->
							<%} %>
							<td class= "COLUMNHEADER" width="43%" style="font-size:9px"><fmt:message key="ePH.Drug/DosageDetails.label" bundle="${ph_labels}"/></td>
							<td class= "COLUMNHEADER" style="font-size:9px" width="2%">&nbsp;</td>
							<td class= "COLUMNHEADER" style="font-size:9px" width="2%">&nbsp;</td>
							<%
							if(iqvia_integration_flag){//mohe-crf-0026.1
							if(patient_class.equalsIgnoreCase("OP") && (settlement_id.equalsIgnoreCase("X")) && (iv_prep_yn ==null || iv_prep_yn.equals("")|| iv_prep_yn.equals("null")) ){ %>
							<td class= "COLUMNHEADER" width="10%" style="font-size:9px"><fmt:message key="ePH.AuthorizationStatus.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
							<%} } %>
							<td class= "COLUMNHEADER" width="10%" style="font-size:9px"><fmt:message key="ePH.PrescribedQuantity.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
							<td class= "COLUMNHEADER" width="10%" style="font-size:9px"><%=param_legends.get("A")%> <fmt:message key="Common.Quantity.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>  
							<td class= "COLUMNHEADER" width="10%" style="font-size:9px"><fmt:message key="ePH.BalanceQuantity.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>

<%
							if(billing_interface_yn.equals("Y") ){
%>
                        <%if(bean.getDisplayInsStatus()){ %><!-- //Added for TH-KW-CRF-0012 -->
                        <td class= "COLUMNHEADER" width="10%" style="font-size:9px"><fmt:message key="Common.Insurance.label" bundle="${common_labels}"/> <fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
						<% } %>
                        <!-- Added for ML-BRU-CRF-0469 start -->
                        <%if(displayGrossAmtYn){%> 
                        <td class= "COLUMNHEADER" width="10%" style="font-size:9px"><fmt:message key="ePH.GrossAmount.label" bundle="${ph_labels}"/></td>
                        <%}%>
						<!-- Added for ML-BRU-CRF-0469 end -->
								<td class= "COLUMNHEADER" width="10%" style="font-size:9px"><fmt:message key="Common.ChargeAmount.label" bundle="${common_labels}"/></td>
								<td class= "COLUMNHEADER" width="10%" style="font-size:9px"><fmt:message key="ePH.PayableAmount.label" bundle="${ph_labels}"/></td>
								<td class= "COLUMNHEADER" width="10%" style="font-size:9px"><fmt:message key="ePH.OverrideIncl/Excl.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>  
								<td class= "COLUMNHEADER" width="5%" style="font-size:9px"><fmt:message key="Common.Paid.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
<%
							}
%>
							<td class= "COLUMNHEADER" width="8%" style="font-size:9px"><%=param_legends.get("D")%> <fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
							<td class= "COLUMNHEADER" width="10%" style="font-size:9px"><%=legend%></td>
						<%
						HashMap approvalNo = null;  //AAKH-CRF-0117
						if(approval_no_flag){ //added for AAKH-CRF-0117%>
						<td class= "COLUMNHEADER" width="15%" style="font-size:9px">  <fmt:message key="ePH.ApprovalNo.label" bundle="${ph_labels}"/> &nbsp;&nbsp;&nbsp;&nbsp;</td>
						<%
						 approvalNo = bean_1.getApprovalNo();//AAKH-CRF-0117
						} 
						%>
						</tr>
<%
						String classvalue				=	"";
						String strength					=	"";
						String pres_strength			=	"";
						String alt_strength_value		=	"";
						String alloc_strength			=	"";
						String bms_strength				=	"";
						String hold_text				=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Hold.label","ph_labels");
						String check_value				=   "N";
						String fromdb					=	"N";
						String title					=	"";
						String narc_style				=	"";		
						int recCount					=	1;
						double tmp_alloc				=	0;
						String drug_remarks				=	"";
						String prn_remarks				=	"";
						String pharma_remarks			=	"";		
						String pres_remarks				=	"";
						String slidingscaleremarks		=   "";
						String verificationremarks		=	"";
						String remarks_style			=	"";
						float dialog_height				=	0;
						float main_pack_size			=   0;
						String tmp_bms_qty_1			=	"";
						//String bms_qty_1				=  "";
						float	main_drug_pack_size		=  0;
						String ext_prod_id				=  "";	
						String main_strength_per_value_pres_uom ="";
						boolean	bDrugOrder				= true;
						LinkedHashMap hsh_med_plan = new LinkedHashMap();// Added for Bru-HIMS-CRF-072.1 [IN:049144]
						ArrayList arrOrderId = new ArrayList();// Added for Bru-HIMS-CRF-072.1 [IN:049144]
						HashMap<String,String> altDrugName = new HashMap<String,String>();// Added for Bru-HIMS-CRF-072.1 [IN:049144]
						String dosedet[] = new String[4],dosedetlocal[] = new String[4];// Added for Bru-HIMS-CRF-072.1 [IN:049144]
						String dispno[] = new String[2];// Added for Bru-HIMS-CRF-072.1 [IN:049144]
						ArrayList alValues = null, drug_details =null;  //added for IN055174 -start
						StringBuffer issue_qty_dtl = null;
						HashMap hmUOMValues = null;
						String store_code	=	bean_1.getStoreCode(), display_qty="";
						HashMap drug_detail	= null, alt_detail=null;	
						ArrayList multi_detail	=null, main_detail=null;  //added for IN055174 -end
						HashMap IssueUOMAndBaseUOM       = new HashMap(); // Added for ML-BRU-SCF-1799
						String base_uom                  ="";  // Added for ML-BRU-SCF-1799
						double base_to_disp_uom_equl     = 0; // Added for ML-BRU-SCF-1803 - Start
						double base_to_def_uom_equl      = 1;
						String orig_dflt_issue_uom		= ""; 
						double conv_factor				 = 1; // Added for ML-BRU-SCF-1803 - End
						ArrayList celling_dose = null;//added for ML-MMOH-CRF-1408
						String min_unit_ceiling_dose = "", max_unit_ceiling_dose = "", min_daily_ceiling_dose = "", max_daily_ceiling_dose = ""; //added for ML-MMOH-CRF-1408
						HashMap lab_food_interaction =null;//added for MMS-KH-CRF-0029
						String Qtystyle			=	"";//Added for MOHE-CRF-0026.1
						for(int i=0;i<orderLineDtls.size(); i++){
							IssueUOMAndBaseUOM       = new HashMap(); // Added for ML-BRU-SCF-1799
							strength			=	"";	
							hold_status			=	"";
							pres_strength		=	"";
							tot_qty				=	0;
							stock_opt			=	new ArrayList();			
							alloc_strength		=	"";
							tmp_alloc			=	0;
							title_remarks		=	"";
							title				=	"";
							narc_style			=	"";
							pres_details		=	"";
							main_drug_pack_size	=	0;
							amt_paid_yn			=  "";
							bDrugOrder			= true;
							alt_drug_remarks_disp="";
							qty_status="";
							display_qty = "";//added for SKR-SCF-1273
							//added for ML-MMOH-CRF-1408 - start
							celling_dose			= null;
							min_unit_ceiling_dose = "";
							max_unit_ceiling_dose = "";
							min_daily_ceiling_dose = "";
							max_daily_ceiling_dose = "";
							ceil_dose_unit_desc    = "";
							//added for ML-MMOH-CRF-1408 - end
							if ( recCount % 2 == 0 )
								classvalue = "QRYODD" ;
							else
								classvalue = "QRYEVEN" ;

							if(disp_level.equals("P") && ((String)orderLineDtls.get(i)).startsWith("PH")) {
								order_id		=	(String)orderLineDtls.get(i);
								//location		=	(String)orderLineDtls.get(++i);
								++i;
								++i;
							}

							allergy					=	(String)orderLineDtls.get(i);
							exceed_dose				=	(String)orderLineDtls.get(++i);
							//duplicate				=	(String)orderLineDtls.get(++i);
							 ++i;
							drug_code				=	(String)orderLineDtls.get(++i);
							drug_name				=	(String)orderLineDtls.get(++i);
							dosage_dtls				=	(String)orderLineDtls.get(++i);
							start_date			=	(String)orderLineDtls.get(++i); // uncommented for MMS-KH-CRF-0013
							//++i; // commented for MMS-KH-CRF-0013
							end_date				=	(String)orderLineDtls.get(++i);
							pres_qty				=	(String)orderLineDtls.get(++i);
							qty_uom					=	(String)orderLineDtls.get(++i);
							qty_uom_disp			=	(String)orderLineDtls.get(++i);
							order_line_no			=	(String)orderLineDtls.get(++i);
							generic_id				=	(String)orderLineDtls.get(++i);

							if(generic_id.equals("MEDICALITEM"))
								bDrugOrder				= false;

							generic_name			=	(String)orderLineDtls.get(++i);
							dosage_details			=	(String)orderLineDtls.get(++i);
							bms_qty					=	(String)orderLineDtls.get(++i);				
							source_code				=   (String)orderLineDtls.get(++i);
							source_type				=   (String)orderLineDtls.get(++i);
							ordering_facility_id	=   (String)orderLineDtls.get(++i);
							ord_date_time			=   (String)orderLineDtls.get(++i);
							performing_pract_id		=   (String)orderLineDtls.get(++i);
							duplicate_yn			=   (String)orderLineDtls.get(++i);
							min_dose_dtls			=   (String)orderLineDtls.get(++i);
							alloc_qty_from_tmp		=   (String)orderLineDtls.get(++i);
							strength_value			=	(String)orderLineDtls.get(++i);
							strength_uom			=	(String)orderLineDtls.get(++i);
							strength_uom_disp		=	(String)orderLineDtls.get(++i);

							trade_code				= (String)bean_1.gettrade_codes(order_id,order_line_no,drug_code);
							//added for ML-BRU-SCF-2049 & ML-BRU-SCF-2055 and bean_1.getTokenNo() removed for ML-BRU-SCF-2055.1- start
							if(issue_token_on_regn_YN!=null && issue_token_on_regn_YN.equals("Y") ){
								if(!ordering_facility_id.equals(""))
								 bean_1.setOrderingFacility(ordering_facility_id);
							}
							//added for ML-BRU-SCF-2049 & ML-BRU-SCF-2055 - end

							if(generic_id.equals("MEDICALITEM")){
							   drug_trade_bean.setDrugyesno("");
							}
							else{
								drug_trade_bean.setDrugyesno("Y");
							}
							image_path				=  drug_trade_bean.getImagePath(drug_code,trade_code);

							pack_dtls			=	bean.getPackSize(drug_code);
							if(pack_dtls!=null && pack_dtls.containsKey("PACK_SIZE")){
								if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
									main_drug_pack_size		=	Float.parseFloat(((String)pack_dtls.get("PACK_SIZE")));						
								}		
						   }

							String alt_drug			=	bean.checkMultiStrength(drug_code);				
							//pat_couns_reqd_yn       =   bean.getPatCounsReqdyn(order_id, order_line_no);	
							int medi_count=bean.altDrugsAvelibleYN(drug_code);//added for ghl-crf-0548
							if(medi_count>0){
								alt_drug="Y";
							}
							
							bmscount                =   bean.CheckBMSYN(order_id, order_line_no);
							bean.addDrugs(patient_id,order_id,drug_code,alt_drug,order_line_no);
							pres_details			=	bean.getPresDetails(order_id);
							
							if(order_type.equals("IVI") ||  order_type.equals("CA")){
								strChangedFludRmks = bean.getChngdFluidRemarks(order_id,order_line_no);
							}
							else{
								strChangedFludRmks ="";
							}

							if(strChangedFludRmks != "" && strChangedFludRmks != null){
								classvalue = "FLUDCOLOR";
							}
							
							if(!alloc_qty_from_tmp.equals("") && !alloc_qty_from_tmp.equals("0")) {
								//if(bean.getFirstTime(order_id).trim().equals("true")) {
								drug_detail		=	bean.getDB_DrugDetail(order_id,order_line_no,end_date);
								multi_detail	=	(ArrayList)drug_detail.get("multi_detail");
								main_detail	=	(ArrayList)drug_detail.get("main_detail");
								alt_detail	=	(HashMap)drug_detail.get("alt_detail");

								issue_qty_dtl = new StringBuffer(); //added for IN055174
								if(multi_detail.size()==0) {									
   								
								IssueUOMAndBaseUOM		=	(HashMap)bean.getStoreDfltIssueUOMAndBaseUOM(store_code,drug_code); // Added for ML-BRU-SCF-1799 - Start
								base_uom			     =  (String)IssueUOMAndBaseUOM.get("BASE_UOM")==null?"":(String)IssueUOMAndBaseUOM.get("BASE_UOM");
								if(!base_uom.equals(qty_uom)){
								  if(!qty_uom.equals("")) 
   									bean.setDispUom(patient_id, order_id, order_line_no, qty_uom);
 								} // Added for ML-BRU-SCF-1799   - End
									bean.setDrugDetail(patient_id,order_id,order_line_no,main_detail);
									bean.setDrugQuantity(patient_id,order_id,order_line_no,Double.parseDouble(alloc_qty_from_tmp));
									if(bean_1.getIssueByUOM().equals("I")){  //if block added for IN055174
										alValues = bean.setIssueUOMValuesLevelTwo(order_id,order_line_no,drug_code);
										drug_details     = (ArrayList)bean.getDrugDetail(patient_id,order_id,order_line_no);
										display_qty = (String)drug_details.get(3);
										for(int iCount =0 ;iCount<alValues.size();iCount++){
											hmUOMValues = (HashMap) alValues.get(iCount);
											System.out.println("hmUOMValues :"+hmUOMValues);
											System.out.println("hmUOMValues1 :"+(String)hmUOMValues.get("DISP_UOM_CODE"));
											display_qty = (String)hmUOMValues.get("DISP_QTY");// added for ML-BRU-SCF-1433 [IN:051291] 
											if(hmUOMValues.get("DISP_UOM_CODE")!=null)
											if(!((String)hmUOMValues.get("DISP_UOM_CODE")).equals((String)hmUOMValues.get("ISSUE_UOM_CODE")) && ((String)hmUOMValues.get("ISSUE_UOM_CODE")).equals((String)hmUOMValues.get("UOM_CODE")) ){
												issue_qty_dtl   =  issue_qty_dtl.append("( ").append((String)hmUOMValues.get("ISSUE_QTY")).append("  ").append((String)hmUOMValues.get("UOM_DESC")).append(" )");
												break;
											}
										}
									}
								} 
								else if(multi_detail.size()!=0) {
									bean.setMultiDrugs(patient_id,order_id,order_line_no,multi_detail);	
									for(int no=0; no<multi_detail.size(); no+=5) {
										alt_drug_code				=	(String)multi_detail.get(no);
										ArrayList alt_drug_detail	=	(ArrayList)alt_detail.get(alt_drug_code);
										for(int no1=0;no1<alt_drug_detail.size();no1+=10){ // Added for ML-BRU-SCF-1803 -Start
										   // alt_drug_detail.set(no1+3,multi_detail.get(no+3));//Added for ML-BRU-SCF-1803
										    alt_drug_detail.set(no1+4,multi_detail.get(no+2));
										} // Added for ML-BRU-SCF-1803 -End
										bean.setAlternateDrugDetail(patient_id,order_id,order_line_no,alt_drug_detail,alt_drug_code);
									}							
								}
								if( multi_detail.size() > 0){// if condition added for  Bru-HIMS-CRF-082 [IN:029948]
									if(alt_drug_remarks_ind.equals("M") || alt_drug_remarks_ind.equals("O")){
										alt_drug_remarks_disp = "&nbsp;<a href=\"javascript:openAltDrugRemarks('"+order_id+"','"+ order_line_no+"','"+ alt_drug_remarks_ind+"','LINK');\" id='altDrugRmkLbl' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+"</a>";
										if(alt_drug_remarks_ind.equals("M"))
											alt_drug_remarks_disp=alt_drug_remarks_disp+" <img  id='altDrugRmkMand' src='../../eCommon/images/mandatory.gif'></img>";
									}
								}
								//bean.setFirstTime(order_id,false);
								//}
							}

							if(module_id.equals("2")) {
								StringTokenizer st	=	new StringTokenizer((String)orderLineDtls.get(++i),"|");
								while(st.hasMoreTokens()){
									stock_opt.add((String)st.nextToken());
								}
							}
					  
							ext_prod_id				 = (String)orderLineDtls.get(++i);
							in_formulary_yn			 =	((String)orderLineDtls.get(++i)).trim();
							if(in_formulary_yn.equals("N"))
								classvalue			 =	"FORMULARY";
							
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
							
							drug_class	=	(((String)orderLineDtls.get(++i)).trim());
							i=i+2;
							expired_yn  = (String)orderLineDtls.get(++i);
							if(expired_yn.equals("Y"))
							{
								if(expired_order) //MOHE-CRF-0032
									{
									classvalue="EXPIRED_ORDER";
									}
								else
								{
									classvalue="EXPIRED_MEDICATION";
								}
							}
							i=i+2;
							order_line_status = (String)orderLineDtls.get(i);
							main_strength_per_value_pres_uom  = (String)orderLineDtls.get(++i);
							i=i+2; // To skip the PRN and Absolute Value

							if(drug_class.equals("C") || drug_class.equals("N")) {
								narc_style	="color:brown";
								String nar_cnt_drug = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.NarcoticControlledDrugs.label","ph_labels");
								title		= "title='"+nar_cnt_drug+"'";
							}

							bean.setStockItems(drug_code,stock_opt);

							if(strength_value!=null && !strength_value.equals("") && Float.parseFloat(strength_value) <1&&Float.parseFloat(strength_value)!=0)
								strength_value= Float.parseFloat(strength_value) +"" ;

							if(!strength_value.equals("0"))
								strength	=	strength_value+" "+strength_uom;

							StringTokenizer dose	=	new StringTokenizer(dosage_details,":");
							if(dose.hasMoreTokens()) {
								exceed_status	=	dose.nextToken();
							}

							if(exceed_status.equals("Y")) {
								if(dose.hasMoreTokens())
									monograph	=	dose.nextToken();
								if(dose.hasMoreTokens())
									unit_dose	=	dose.nextToken();
								if(dose.hasMoreTokens())
									daily_dose	=	dose.nextToken();
								if(dose.hasMoreTokens())
									dosage_type =dose.nextToken();
								if(dose.hasMoreTokens())
									dosage_unit =dose.nextToken();
								if(dose.hasMoreTokens())
									std_dose   =dose.nextToken();
							}
							if(!dosage_unit.equals("")){ // Added for ML-MMOH-SCF-0863 - Start
						   dose_unit_desc      = bean.getUomDisplay((String)session.getValue("facility_id"),dosage_unit); 
	 						ceil_dose_unit_desc = dose_unit_desc;//added for ML-MMOH-CRF-1408
							if(dose_unit_desc==null || dose_unit_desc=="" ) {
	 						  dose_unit_desc = bean.getUomDisplay((String)session.getValue("facility_id"),(dosage_unit.split("/")[0]));
	  	 						ceil_dose_unit_desc = dose_unit_desc;//added for ML-MMOH-CRF-1408
							  if(dosage_unit.split("/").length>=2)
						      dose_unit_desc =dose_unit_desc+"/"+(dosage_unit.split("/")[1]);
	 						} 
 						}// Added for ML-MMOH-SCF-0863 - End
							//StringTokenizer min_dose	=	new StringTokenizer(min_dose_dtls,":");
							//removed for ML-MMOH-SCF-1997
							StringTokenizer min_dose	=	new StringTokenizer(min_dose_dtls,":");//ADDED for ML-MMOH-SCF-1997
							if(min_dose.hasMoreTokens()) {
								min_unit_dose	=	min_dose.nextToken();
							} // Added for the issue which is found while testing MMS-KH-CRF-0028 [IN070605]
							if(min_dose.hasMoreTokens()) { // Added for the issue which is found while testing MMS-KH-CRF-0028 [IN070605]
								min_daily_dose	=	min_dose.nextToken();
							}
							ArrayList multi_drugs	=	bean.getMultiDrugs(patient_id,order_id,order_line_no);	
							if(bean_1.getIssueByUOM().equals("I"))  //if block and else condition added for IN055174 
								qty = display_qty;
							else
								qty		=	bean.getDrugQuantity(patient_id,order_id,order_line_no);
							if(order_type.equals("TA") ||(tpn_mf_label && order_type.equals("TD"))){//Added for ml-mmoh-crf-0468
								qty				=	bean.getTPNDrugQuantity(order_id,order_line_no);
							}

							if(!qty.equals("") && !qty.equals("0") && multi_drugs.size() < 1)
								tot_qty				+=	Double.parseDouble(qty);

							alt_drug_qty			=	"";
							for(int n=0; n<multi_drugs.size(); n+=5)	{ 
								alt_drug_code	=	(String)multi_drugs.get(n);

								alt_drug_qty	=	bean.getAlternateDrugQuantity(patient_id,order_id,order_line_no,alt_drug_code); 
								if(alt_drug_qty != null && !alt_drug_qty.equals(""))
								break;
							}

							if( (!qty.equals("") && !qty.equals("0")) || (!alt_drug_qty.equals("") && !alt_drug_qty.equals("0")) ){
								hold_status		="disabled";
							}
							else if(order_line_status.equals("AL") || order_line_status.equals("IP"))	{
								hold_status		="disabled";
							}
		
							if(bean.checkHold(order_id,order_line_no)) {
								//hold_text		="On Hold";
								hold_text       = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OnHold.label","ph_labels");
								check_value		="Y";
								fromdb			="Y";
								remark_status	="visibility:visible";
							} 
							else {
								HashMap hm= bean.loadHoldRemarks(order_id,order_line_no);
								if (!hm.isEmpty()){
									//hold_text		="On Hold";
									hold_text       = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OnHold.label","ph_labels");
									check_value		="Y";
									fromdb			="Y";
									remark_status	="visibility:visible";
								}
								else{
									//hold_text		="Hold";
									hold_text		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Hold.label","ph_labels");
									remark_status	="visibility:hidden";
								}
							}
							/*-----code for displaying drug remarks---------------*/

							drug_remarks	    = "";
							prn_remarks		    = "";
							pharma_remarks	    = "";		
							pres_remarks        = "";
							slidingscaleremarks = "";
							remarks_style       = "";
							dialog_height       = 0;
						

						   /* pres_remarks		= bean.getPrescriptionInstructions(order_id);
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
							}*/
							//changed during PE By Naveen  added in get order line details
							pres_remarks					=   bean.getPrescriptionInstructions(order_id);
							drug_remarks					=   bean.getDrugInstructions(order_id,order_line_no);
							//IN071533 Start					
							if(iv_prep_yn!=null && !iv_prep_yn.equals("") && iv_prep_yn.equals("5")){
								drug_remarks = bean.getNonMFRfluidRemarks(order_id,order_line_no); 
							}
							//IN071533 end	
							
							prn_remarks						=   (String)orderLineDtls.get(++i);
							pharma_remarks					=   bean.getPharmacistInstructions(order_id,order_line_no,"Y");
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
							home_med_yn 				= 	(String)orderLineDtls.get(++i);//Added for Bru-HIMS-CRF-093-DD1[IN047223]
							if(home_med_yn!=null && home_med_yn.equalsIgnoreCase("Y"))
								home_med_style = "HOME_MED";
							else
								home_med_style = "white";//Added for Bru-HIMS-CRF-093-DD1[IN047223] -End
							drug_desc 				= 	(String)orderLineDtls.get(++i);//Added for Bru-HIMS-CRF-414 ML-BRU-SCF-1454 [IN:052271]
							disc_cancelled_orders	= 	(String)orderLineDtls.get(++i);//Added for  HSA-CRF-0138 [IN:048414] 
							i++;//Added for  Bru-HIMS-CRF-080
							if(!disc_cancelled_orders.equals("")) //Added for  HSA-CRF-0138 [IN:048414] - start
								disc_cancelled_orders_display="display:inline";
							else
								disc_cancelled_orders_display="display:none"; //Added for  HSA-CRF-0138 [IN:048414] end
							/*taper_order_yn 					=	(String)orderLineDtls.get(++i);//from OR_ORDER   Commented for RUT-CRF-0088 [IN036978] 
							taper_order_id					=	(String)orderLineDtls.get(++i);//from OR_ORDER
							taper_order_line_num					=	(String)orderLineDtls.get(++i);//from OR_ORDER
							if(taper_order_yn.equals("Y") && !taper_order_id.equals("") && !taper_order_line_num.equals(""))
								taper_disable = "disabled";
							else*/
								taper_disable="";
							show_remarks = "N";
							//added for MMS-KH-CRF-0029 - start
							food_interaction_override_reason =   "";
						lab_interaction_override_reason =   "";  
						disease_inter_override_reason="";//MMS-DM-CRF-0229
						if(iv_prep_yn!=null && iv_prep_yn.equals("")){
							 lab_food_interaction = bean.getDrugLabFoodInteraction(order_id,order_line_no);
							 food_interaction_override_reason = (String)lab_food_interaction.get("FOOD_INTERACT_OVERRIDE_REASON")==null?"":(String)lab_food_interaction.get("FOOD_INTERACT_OVERRIDE_REASON");
							 lab_interaction_override_reason = (String)lab_food_interaction.get("LAB_INTERACT_OVERRIDE_REASON")==null?"":(String)lab_food_interaction.get("LAB_INTERACT_OVERRIDE_REASON");//MODIFIED FOR MMS-MD-SCF-0141
							 disease_inter_override_reason = (String)lab_food_interaction.get("DISEASE_INTER_OVERRIDE_REASON")==null?"":(String)lab_food_interaction.get("DISEASE_INTER_OVERRIDE_REASON");//MMS-DM-CRF-0229
						}
						if(lab_interaction_override_reason==null) //MMS-KH-CRF-0029
							lab_interaction_override_reason = "";
						if(food_interaction_override_reason==null) //MMS-KH-CRF-0029
							food_interaction_override_reason = "";
						//added for MMS-KH-CRF-0029 - end
						if(disease_inter_override_reason==null) //MMS-DM-CRF-0229
							disease_inter_override_reason = "";
					abuse_drug_override_reason=(String)orderLineDtls.get(++i);//added for aakh-crf-0140
						abuse_exists=(String)orderLineDtls.get(++i);//aakh-crf-0140
						drugIndication=(String)orderLineDtls.get(++i);//ADDED FOR JD-CRF-0220
						++i;//Added for TH-KW-CRF-0008
						++i;//Added for TH-KW-CRF-0008
						category_code=(String)orderLineDtls.get(++i);//added for mms-dm-crf-0209.1
						alternate_yn=(String)orderLineDtls.get(++i);//added for mms-dm-crf-0209.1
						if(insuranceStatus.containsKey(order_id+order_line_no))
						insurance_status  = (String)insuranceStatus.get(order_id+order_line_no);//Added for TH-KW-CRF-0012

					/* 	if(drug_abuse_appl &&( !abuse_drug_override_reason.equals("") && abuse_exists.equals("Y"))){
							 ABUSE_REMARKS_CLASS="ABUSE_REMARKS";//ADDED FOR AAKH-CRF-0140
							  ABUSE_REMARKS_YN="Y";//ADDED FOR AAKH-CRF-0140
							
						}
						else{
							ABUSE_REMARKS_CLASS="";
							ABUSE_REMARKS_YN="N";
						} */
				System.out.println("Dispmedicationallocation abuse_drug_override_reason"+abuse_drug_override_reason);
				System.out.println("DispmedicationAllocation abuse_exists"+abuse_exists);
							if(!allergy_override_reason.equals("")||!dosage_limit_override_reason.equals("")||!duplicate_drug_override_reason.equals("")||!interaction_override_reason.equals("")||!contraind_override_reason.equals("") || !food_interaction_override_reason.equals("") ||  !lab_interaction_override_reason.equals("") || !disease_inter_override_reason.equals("")){
								show_remarks="Y";
							}

							drugs_remarks = new StringBuffer(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PractitionerPharmacistInstructions.label","ph_labels")+" : \n"); //code added for Bru-HIMS-CRF-416[IN045566]-- Start								
							if(!pres_remarks.trim().equals(""))
								drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PrescriptionInstructions.label","ph_labels")+" : "+pres_remarks.trim()+"\n");
							if(!slidingscaleremarks.trim().equals(""))
								drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.SlidingScaleRemarks.label","ph_labels")+" : "+slidingscaleremarks.trim()+"\n");
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
								drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.VerificationRemarks.label","ph_labels")+" : "+verificationremarks.trim()+"\n");
							//!abuse_drug_override_reason.trim().equals("") added for aakh-crf-0140
							if(!abuse_drug_override_reason.trim().equals(""))
								drugs_remarks.append("DrugAbuse Remarks : "+abuse_drug_override_reason.trim()+"\n");	
							System.out.println("abuse_drug_override_reason"+abuse_drug_override_reason+"drugs_remarks"+drugs_remarks);
							//abuse_drug_override_reason.trim().equals("") added for aakh-crf-0140
							drugs_remarks.append("DrugAbuse Remarks : "+abuse_drug_override_reason.trim()+"\n");	
							if(drugIndication !=null && !drugIndication.equals("")){
								drugs_remarks.append("Drug Indications : "+drugIndication.trim()+"\n");
							}
							
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
							pack_dtls				=	bean.getPackSize(drug_code);
							main_pack_size			=   0;
							if(pack_dtls!=null && pack_dtls.containsKey("PACK_SIZE")) {
								if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
									 main_pack_size	=	Float.parseFloat(((String)pack_dtls.get("PACK_SIZE")));	
									tmp_bms_qty_1	=   Float.parseFloat(tmp_bms_qty)*main_pack_size+"";
									//bms_qty_1		=   Float.parseFloat(bms_qty)*main_pack_size+"";
								}		
							}
							else{
								tmp_bms_qty_1		=   tmp_bms_qty;
								//bms_qty_1			=	bms_qty;
							}
							adr_count					= bean.getADRCount(patient_id,drug_code);
							if(Min_Rol_yn){ ///Added AMS-CRF-0068.1 [IN:050333] start
								rol_min		=	(HashMap)stSalseBean.getROL(drug_code,disp_locn_code);
								frm_store_min_stk_level = CommonBean.checkForNull((String)rol_min.get("MIN_STK_QTY"),"0");
								frm_store_reorder_level	= CommonBean.checkForNull((String)rol_min.get("REORDER_LEVEL"),"0");
								min_stk=false;
								rol_stk=false;
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
									if ( Double.parseDouble(avail_qty)  <  Double.parseDouble(frm_store_min_stk_level)){
										min_stk = true;
										if(getReq_allowed_yn)
											disp_req_flag =  "display:inline;color:blue";
										else
											disp_req_flag = "display:none";
									}
								}
								if(!frm_store_reorder_level.equals("0")){
									if (Double.parseDouble(avail_qty)  <  Double.parseDouble(frm_store_reorder_level)){
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
							 
							} //added for ML-MMOH-CRF-1408 -end
%>
							<tr <%=taper_disable%>>
<%
					   if(intractn_req_yn && order_type.equals("NOR")){ // Added for MMS-KH-CRF-0028 [IN070605] - Start
%>					     <td> 
						    <input type="checkbox" name="deliveryChecked_<%=recCount%>" id="deliveryChecked_<%=recCount%>" checked onclick="setValue(this)" value="Y" checked> <!--added for GHL-CRF-453 -->
					     </td>
			
<%                     }
                       else{
%>                          
                           <input type="hidden" name="deliveryChecked_<%=recCount%>" id="deliveryChecked_<%=recCount%>" value="Y">
<% 	
                       } // Added for MMS-KH-CRF-0028 [IN070605] - End 
                       if(iqvia_integration_flag){//added for MOHE-CRF-0026.1 start 
                      if(patient_class.equalsIgnoreCase("OP") && (settlement_id.equalsIgnoreCase("X"))  && (iv_prep_yn.equals("")|| iv_prep_yn.equals(null) || iv_prep_yn.equals("null")) ){ 
%>
 						<td> 
						     <input type="checkbox" name="authChecked_<%=recCount%>" id="authChecked_<%=recCount%>" checked onclick="setValueAuth(this)" value="Y" checked>  
					     </td> 
					     <input type="hidden" name="authChecked1_<%=recCount%>" id="authChecked1_<%=recCount%>" value="Y">
					     <%} } //END%>
					      
								<td class="white" width="6%">
									<table border="1" width="100%" cellpadding="0" cellspacing="0" align="center">
										<tr>
<%	
										if(allergy.equals("")) { 
%>
											<td class="white" width="20%">&nbsp;</td> <!-- 33% changed to 20% for MMS-KH-CRF-0013 -->
<%	
										}
										else{//order_id,order_line_no,(recCount),patient_class,review_called_from FOR IN070605
%>
											<td class='ALLERGY' width="20%" style="cursor:pointer" onClick="showAllergyDetails('<%=generic_id%>','<%=patient_id%>','<%=encounter_id%>','<%=java.net.URLEncoder.encode(generic_name,"UTF-8")%>','<%=java.net.URLEncoder.encode(drug_name,"UTF-8")%>','<%=order_id%>','<%=order_line_no%>','<%=(recCount)%>','<%=patient_class%>','')">&nbsp;</td> <!-- 33% changed to 20% for MMS-KH-CRF-0013 -->
<%	
										}
										if(exceed_dose.equals("")) { 
%>
											<td class="white" width="20%">&nbsp;</td> <!-- 33% changed to 20% for MMS-KH-CRF-0013 -->
<% 
										}
										else{//order_id,order_line_no,(recCount),patient_class,review_called_from FOR IN070605	
%>
											<td class='DOSELIMIT' width="20%" style="cursor:pointer" onClick="showMonoGraph('<%=java.net.URLEncoder.encode(drug_name)%>','<%=java.net.URLEncoder.encode(monograph)%>','<%=daily_dose%>','<%=unit_dose%>','<%=min_unit_dose%>','<%=min_daily_dose%>','<%=dosage_unit%>','<%=std_dose%>','<%=dose_unit_desc%>','<%=order_id%>','<%=order_line_no%>','<%=(recCount)%>','<%=patient_class%>','','<%=max_daily_ceiling_dose%>','<%=min_daily_ceiling_dose%>','<%=max_unit_ceiling_dose%>','<%=min_unit_ceiling_dose%>','<%=ceil_dose_unit_desc%>')">&nbsp;</td><!-- dose_unit_desc added for ML-MMOH-SCF-0863, 33% changed to 20% for MMS-KH-CRF-0013 ceilng dose added for ML-MMOH-CRF-1408 and changed dose_unit_desc to ceil_dose_unit_desc for 1408 ,added drugname encoding for IN73523 -->
<%
										}
										if(duplicate_yn.equals("Y") || !duplicate_drug_override_reason.equals("")) { 
%>
											<td class='CURRENTRX' width="20%" style="cursor:pointer" onClick="callActiveOrders('<%=patient_id%>','<%=encounter_id%>','<%=generic_id%>','<%=order_id%>','<%=order_line_no%>','<%=(recCount)%>','<%=patient_class%>','')">&nbsp;</td> <!-- 33% changed to 20% for MMS-KH-CRF-0013 -->
<%	
										}
										else{	
%>
											<td class="white" width="20%">&nbsp;</td> <!-- 33% changed to 20% for MMS-KH-CRF-0013 -->
<%	
										}
			                        if( iv_prep_yn.equals("")){ // Added for MMS-KH-CRF-0013 - Start and removed intractn_req_yn && for MMS-KH-CRF-0029
									pres_bean.setEncounterId(encounter_id); //MMS-KH-CRF-0029	
										if(!drug_db_interface_yn.equals("Y") && pres_bean.getDrugInteractionDtls(drug_code, bean_1.getForm_code(order_id+order_line_no+drug_code), generic_id, start_date, end_date, patient_id).size()>2) { 											
											    	    
														form_code = bean_1.getForm_code(order_id+order_line_no+drug_code);
														form_desc = bean_1.getForm_descs(order_id+order_line_no+drug_code);
%>
											<td class='DINTERACN' width="20%" style="cursor:pointer" onClick="showDispInractionDtl('<%=patient_id%>','<%=encounter_id%>','<%=drug_code%>','<%=form_code%>','<%=generic_id%>','<%=start_date%>','<%=end_date%>','<%=java.net.URLEncoder.encode(drug_name,"UTF-8")%>','<%=java.net.URLEncoder.encode(form_desc,"UTF-8")%>','<%=order_id%>','<%=order_line_no%>','<%=(recCount)%>','<%=patient_class%>','')">&nbsp;</td><!--order_id,order_line_no,(recCount),patient_class,review_called_from FOR IN070605-->
											
<% 
							            }
								       else{	
%>
								    	   <td class="white" width="20%">&nbsp;</td> <!-- 33% changed to 25% for MMS-KH-CRF-0013 --> 
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
								<!-- <td class="<%=classvalue%>"  align="center" width="3%" nowrap> -->
								<!--<input type="checkbox" name="hold<%=recCount%>" id="hold<%=recCount%>" onClick="callReason(this,'<%=order_id%>','<%=drug_code%>','<%=recCount%>','<%=order_line_no%>');notifyChange()" <%=hold_status%>><br><label style="cursor:pointer;color:blue;font-size:9px;<%=remark_status%>" onClick="callReason(document.DispMedicationAllStages.hold<%=recCount%>,'<%=order_id%>','<%=drug_code%>','<%=recCount%>','<%=order_line_no%>');notifyChange()" id='hold_remarks_<%=recCount%>'>Remarks</label>-->
<% 
								//if (hold_status.equals("disabled")){
%>
									<!-- 
									<label style="color:black;font-size:9px;" id='hold_remarks_<%=recCount%>'><%=hold_text%></label>
									<input type="checkbox" name="hold<%=recCount%>" id="hold<%=recCount%>" style='display:none'  value="<%=check_value%>"> -->
<%
								/*}	
								else{*/
%>
									<!-- 	<label style="cursor:pointer;color:blue;font-size:9px;" onClick="callReason(this,'<%=order_id%>','<%=drug_code%>','<%=recCount%>','<%=order_line_no%>');notifyChange()" id='hold_remarks_<%=recCount%>'><%=hold_text%></label>
									<input type="checkbox" name="hold<%=recCount%>" id="hold<%=recCount%>" style='display:none' value="<%=check_value%>"> -->
<%
								//}
								/*Added for indicating colours from legend ML-MMOH-CRF-0434 start [IN057356] */
								if(patient_class.equals("IP")){
									ArrayList disp_info			=	new ArrayList(2);
									disp_info	=	bean.getLastDispense(order_id,order_line_no);
									if(disp_info.size() > 0){
										home_med_style_1 = "green";	//modified for ml-bru-scf-1784
									}
									else{
										home_med_style_1 = "blue";//modified for ml-bru-scf-1784
									}
								}
									/*Added for ML-MMOH-CRF-0434 End [IN057356] */
%>
								<input type="hidden" name="drug_code<%=recCount%>" id="drug_code<%=recCount%>" value="<%=drug_code%>">
								<input type="hidden" name="fromdb_<%=recCount%>" id="fromdb_<%=recCount%>" value="<%=fromdb%>">
								<input type="hidden" name="hold_status<%=recCount%>" id="hold_status<%=recCount%>" value="<%=hold_status%>">
								</td>
								<td class="<%=home_med_style%>" width="4%" ></td> <!-- Added for Bru-HIMS-CRF-093-DD1[IN047223]  -->
							<%	if(patient_class.equals("IP")){ %>
								<td class="<%=home_med_style_1%>" width="4%" ></td> <!-- Added forml-bru-scf-1784  -->
								<%	} %>
								<td class="<%=classvalue%>" style="font-size:9px;overflow: auto;" width="41%" <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" nowrap>
<%
								if(!ord_type.equals("TA")&&!ord_type.equals("TD")){
%>
									<label style='color:red;font-size:12px;FONT-WEIGHT: BOLDER;cursor:pointer;' onclick="showDrugMasterValues('<%=drug_code%>');" id="drug_mast_det_<%=recCount%>">&nbsp;+&nbsp;</label>
<%
								}
%>
								<label style="cursor:pointer;color:blue" onclick="showDrugDetails('<%=patient_class%>','MW','<%=order_id%>','<%=drug_code%>','<%=order_line_no%>','','<%=disp_locn_code%>','','', '<%=patient_id%>');" id="drug_desc<%=recCount%>"><%=drug_name%>&nbsp;<%=strength%></label>&nbsp;&nbsp; <!--  , 'patient_id' added for [IN:035667] --><!-- Added for '','', Inc No : 41282 -->
<% 
								if ((ext_prod_id!=null)&& !(ext_prod_id.equals("")) && drug_db_interface_yn.equals("Y")){ 
%>
									<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/info.gif" height='20'  width='20' onClick="showDrugInfo('<%=ext_prod_id%>','<%=java.net.URLEncoder.encode(drug_name,"UTF-8")%>')"></img> <!-- Passed UTC-8 to Drug name for the incident num:25007 on 19/Nov/2010 By Sandhya -->
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
								}
								if(order_type.equals("TD") && hmPPNStoredValues != null){
%>
									<img src='../../ePH/images/AddedIngredient.gif' height='15' width='15' style="cursor:pointer;" title='<fmt:message key="ePH.Constituents.label" bundle="${ph_labels}"/>' onClick="displayConstInPPN('<%=drug_code%>')"></img>
<%
								}
								taperValues=bean.chkfortapering(order_id,drug_code, order_line_no, patient_id);		//Modified for RUT-CRF-0088 [IN036978] 
								count =Integer.parseInt(taperValues.get("COUNT").toString()); 
								tot_tap=Float.parseFloat(taperValues.get("TOT_QTY").toString());
								if(count>1){
									/*float tmp_tot_qty=0;  //Added for RUT-CRF-0088 [IN036978] -- begin
					        		
					        	   	if(tot_tap_qty.containsKey(drug_code))
					        	   		tmp_tot_qty=Float.parseFloat(tot_tap_qty.get(drug_code).toString());
					        	   	else
					        	   		tmp_tot_qty=0;
					        		
					        	   	tot_tap=tmp_tot_qty+Float.parseFloat(pres_qty);
					        	   	tot_tap_qty.put(drug_code,tot_tap);  //Added for RUT-CRF-0088 [IN036978] --end*/	
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
									if(totalTaperQtyDisplay.equals("Y")){ //added for RUT-CRF-0088 [IN036978]
%>
									<fmt:message key="Common.total.label" bundle="${common_labels}"/><fmt:message key="Common.Taper.label" bundle="${common_labels}"/><fmt:message key="Common.Qty.label" bundle="${common_labels}"/>
									<label>-<%=(int)tot_tap%>&nbsp;&#40;<%=qty_uom_disp%>&#41;</label>
<%		
									}
								}
								if(bmscount==0){
									if(pat_couns_reqd_yn.equals("Y")){
										pat_reqd="Checked";
%>
										<img src="../../ePH/images/Patientcounsel.gif" valign="center"  ></img>
										<input type=checkbox name='pat_reqd_<%=recCount%>' id='pat_reqd_<%=recCount%>' <%=pat_reqd%> value='C' onclick="CheckPatReqd(this)">
<%
									}
									if(pat_couns_reqd_yn.equals("C")){
										pat_reqd="Checked";
%>
										<img src="../../ePH/images/Patientcounsel.gif"  ></img>
										<input type=checkbox name='pat_reqd_<%=recCount%>' id='pat_reqd_<%=recCount%>' <%=pat_reqd%> disabled value=''>
<%
									}
									if(pat_couns_reqd_yn.equals("N")|| pat_couns_reqd_yn.equals("Null") ){
										pat_reqd="Unchecked";	
										//pt_couns_reqd_yn       =   bean.getPatCounsReqd(drug_code);
										if(pt_couns_reqd_yn.equals("Y")){
%>
											<img src="../../ePH/images/Patientcounsel.gif"  ></img>
											<input type=checkbox valign='center' name='pat_reqd_<%=recCount%>' id='pat_reqd_<%=recCount%>' <%=pat_reqd%> value='' onclick='CheckPatReqd(this)'>
<%	
										}
									}
								}
								if(bDrugOrder){
%>
									<%=alt_drug_remarks_disp%>	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=dosage_dtls%>
<% 
								}
%>
								<br><label id="id_min_stk_label" style='<%=min_stk_flag%>;'><fmt:message key="ePH.MINLEVEL.label" bundle="${ph_labels}"/>:</label><!--Added AMS-CRF-0068.1 [IN:050333] start  -->
								<label id="id_min_str_stk" style='<%=min_stk_flag_bkg_clr%>;<%=min_stk_flag%>;'><b><%=frm_store_min_stk_level%></b></label>&nbsp;&nbsp;
								<label id="id_stk_rol_label" style='<%=rol_flag%>;'><fmt:message key="ePH.ROL.label" bundle="${ph_labels}"/>:</label>
								<label  id="id_stk_rol" style='<%=rol_flag_bkg_clr%>;<%=rol_flag%>;'><b><%=frm_store_reorder_level%></b></label>&nbsp;
								<label class='HYPERLINK'  name = "request"  onmouseover="changeCursor(this);" onclick="request();" id="sales_req_label" style='<%=disp_req_flag%>;' ><b><fmt:message key="ePH.CreateRequest.label" bundle="${ph_labels}"/></b></label><!--Added AMS-CRF-0068.1 [IN:050333] end  -->
<%
								int	k	=	0;
								ArrayList alt_qty	=	new ArrayList();
								drug_name_1=  drug_name;   
								// Commented By Sandhya frm 847 to 851 on 24/Nov/2010 for getting Drug name into Thai onclick of PharmacistInstructions Link   	
								/*if(!drug_name_1.equals("")&&drug_name_1!=null){
									drug_name_1=drug_name_1.replaceAll(" ","%20");
									drug_name_1=java.net.URLEncoder.encode(drug_name_1,"UTF-8");
									drug_name_1=drug_name_1.replaceAll("%2520","%20");
								}*/
								for(int n=0; n<multi_drugs.size(); n+=5)	{ 
									alt_drug_code			=	(String)multi_drugs.get(n);
									alt_drug_desc			=	(String)multi_drugs.get(n+1);
									altDrugName.put(alt_drug_code,alt_drug_desc);// Added for Bru-HIMS-CRF-072.1 [IN:049144]
									form_code				=	(String)multi_drugs.get(n+2);
									alt_strength_value		=	(String)multi_drugs.get(n+3);
									//alt_strength_uom		=	(String)multi_drugs.get(n+4);

									alt_drug_desc_1	=    alt_drug_desc;
									//Commented code from 861 to 866 regarding incident num:25007 on 19/Nov/2010==By Sandhya
									/*if(!alt_drug_desc_1.equals("")&&alt_drug_desc_1!=null){
										alt_drug_desc_1=alt_drug_desc_1.replaceAll(" ","%20");
										alt_drug_desc_1=	java.net.URLEncoder.encode(alt_drug_desc_1);
										alt_drug_desc_1=alt_drug_desc_1.replaceAll("%2520","%20");
									}*/
									pack_dtls				=	bean.getPackSize(alt_drug_code);

									if(pack_dtls!=null && pack_dtls.containsKey("PACK_SIZE")) {
										form_code			    =	(String)pack_dtls.get("STOCK_UOM");
									}

									if(pack_dtls!=null && pack_dtls.containsKey("EXTERNAL_PRODUCT_ID")) {
										alt_external_prod_id	=	(String)pack_dtls.get("EXTERNAL_PRODUCT_ID");
									}
									else{
										alt_external_prod_id    =   "";
									}
									drug_color				=	(String)colors.get(k++);
									qty						=	bean.getAlternateDrugQuantity(patient_id,order_id,order_line_no,alt_drug_code); 
									if(!qty.equals("") && !qty.equals("0")) {
										alt_qty.add(alt_drug_code);
										alt_qty.add(qty);
										alt_qty.add(form_code);
										alt_qty.add(alt_strength_value);
										fractroundupyn          =   bean.getFractRoundupYN(alt_drug_code);
									}

									/*if(!strength_value.equals("") && !alt_strength_value.equals("")) {
									prod_qty			=	Float.parseFloat(strength_value) / Float.parseFloat(alt_strength_value);
									bms_qty				=	new Float(prod_qty  * Float.parseFloat(bms_qty))+"";
									}*/
									if(Min_Rol_yn){ ///Added AMS-CRF-0068.1 [IN:050333] start
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
												avail_qty=(String)hmStockAvailabilityStatus.get("available_stock");
											}
											catch (Exception e){
												avail_qty = "0";
											}
											if(avail_qty.equals(""))
												avail_qty="0";
											if(!frm_store_min_stk_level.equals("0")){
												if (Double.parseDouble(avail_qty)  <  Double.parseDouble(frm_store_min_stk_level)){
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
													rol_flag_bkg_clr = "background-color:none";
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
										}
										else{
											rol_flag   =	"display:none";
											min_stk_flag=	"display:inline";
											disp_req_flag  = "display:none";	
											min_stk_flag=	"display:none";
										}
									}//Added AMS-CRF-0068.1 [IN:050333] end
%>	
									<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<%
										if(!ord_type.equals("TA")&&!ord_type.equals("TD")){
%>
											<label style='color:red;font-size:12px;FONT-WEIGHT: BOLDER;cursor:pointer;' onclick="showDrugMasterValues('<%=alt_drug_code%>');" id="drug_mast_det_<%=recCount%>">&nbsp;+&nbsp;</label>
<%
										}
%>
										<label style="cursor:pointer;color:<%=drug_color%>" onclick="callDrugDetails('<%=patient_id%>','<%=order_id%>','<%=drug_code%>','<%=alt_drug%>','<%=alt_drug_code%>','<%=drug_color%>','<%=form_code%>','');changeColor(this);" id="alte_drug_desc<%=n%>"><%=alt_drug_desc%></label><!-- code '<%=drug_name_1%>','<%=alt_drug_desc_1%>', removed for TTM-SCF-0096[IN048808]-->
<% 
										if ((alt_external_prod_id!=null) && !(alt_external_prod_id.equals(""))&& drug_db_interface_yn.equals("Y")){ 
%>
											<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/info.gif" height='20'  width='20' onClick="showDrugInfo('<%=alt_external_prod_id%>','<%=java.net.URLEncoder.encode(alt_drug_desc_1,"UTF-8")%>')"></img> <!-- Passed UTF-8 to alt_drug_desc_1 for the incident num:25007==By Sandhya -->
<%  
										}
										adr_count = bean.getADRCount(patient_id,alt_drug_code);
										if(adr_count>0){
%>
											<img  id="ADR_img" src='../../ePH/images/ADR.gif'  height='20'  width='20' title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>' onclick= "callADRdetails('<%=patient_id%>','<%=alt_drug_code%>')"></img><!-- callADRdetails() newly added for RUT-SCF-0144 [IN:033371]-->
<%
										}
										hmEditLabelValues = new HashMap();	
										hmEditLabelValues.put("order_id",order_id);
										hmEditLabelValues.put("pres_drug_code",drug_code);
										hmEditLabelValues.put("drug_code",alt_drug_code);
										hmEditLabelValues.put("order_line_no",order_line_no);
										hmEditLabelValues.put("ord_date_time",ord_date_time);
										hmEditLabelValues.put("drug_name_1",drug_name);
										hmEditLabelValues.put("drug_desc",drug_desc); //Added for Bru-HIMS-CRF-414- ML-BRU-SCF-1454 [IN:052271]
										hmEditLabelValues.put("alt_drug_desc",alt_drug_desc);
										hmEditLabelValues.put("pres_qty",qty);
										hmEditLabelValues.put("uom",form_code);
										hmEditLabelValues.put("alt_drug_flag","Y");
										hmEditLabelValues.put("alt_drug_count", (multi_drugs.size()/5)+"");  //Added for Bru-HIMS-CRF-414- ML-BRU-SCF-1528 [IN:053217]
										alEditLabelPair.add(hmEditLabelValues);
										//bEditLabelEnabled = false;
										bean.setSPerformPractId(performing_pract_id);
%>	
										<br><label id="id_min_stk_label" style='<%=min_stk_flag%>;'><fmt:message key="ePH.MINLEVEL.label" bundle="${ph_labels}"/>:</label><!--Added AMS-CRF-0068.1 [IN:050333] start  -->
										<label id="id_min_str_stk" style='<%=min_stk_flag_bkg_clr%>;<%=min_stk_flag%>;'><b><%=frm_store_min_stk_level%></b></label>&nbsp;&nbsp;
										<label id="id_stk_rol_label" style='<%=rol_flag%>;'><fmt:message key="ePH.ROL.label" bundle="${ph_labels}"/>:</label>
										<label  id="id_stk_rol" style='<%=rol_flag_bkg_clr%>;<%=rol_flag%>;'><b><%=frm_store_reorder_level%></b></label>&nbsp;
										<label class='HYPERLINK'  name = "request"  onmouseover="changeCursor(this);" onclick="request();" id="sales_req_label" style='<%=disp_req_flag%>;' ><b><fmt:message key="ePH.CreateRequest.label" bundle="${ph_labels}"/></b></label><!--Added AMS-CRF-0068.1 [IN:050333] end  -->
<%
									}
								String status = "Pending"; //added for mohe-crf-0026.1	START						
							if(iqvia_integration_flag){	
								dispNoList = bean_1.getDispTmpNoAndSrlNo(drug_code, order_id, order_line_no);
								if(dispNoList!=null && dispNoList.size()>0)
								 dispTmpNo= (String) dispNoList.get(0); //END 
							}	
								String approvedQty = ""; 
								String approvedAmt = ""; 
								Qtystyle = "visibility:visible";
								if (status.equalsIgnoreCase("Pending")){  
									Qtystyle = "visibility:hidden"; 
								}//END
										
									if(order_type.equals("TD") && hmPPNStoredValues != null){ 			
										String sPPNItemCode = (String)hmPPNStoredValues.get("itemCode");
%>
										<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
										<label style="color:green;cursor:pointer;" id="TPN_PPN_Details"  onclick="openPPNDisplay('<%=patient_id%>','<%=order_id%>','<%=disp_locn_code%>','<%=dischargeIND%>')">&nbsp;<%=hmPPNStoredValues.get("itemDesc")%></label>&nbsp;<img src='../../ePH/images/AddedIngredient.gif' height='15' width='15' style="cursor:pointer;" title='<fmt:message key="ePH.Constituents.label" bundle="${ph_labels}"/>' onClick="displayConstInPPN('<%=sPPNItemCode%>')"></img>
<%
									}
%>			
									</td>
									<td class="<%=classvalue%>" style="font-size:9px"  >
										<!-- Passed URLEncoder,UTF-8  for drug name in displayInstructions regarding incident num:25276 ==By sandhya -->
										<img src="../../ePH/images/DrugRemarks.gif" id='drugRemarks_<%=recCount%>' title='' valign="center"style="cursor:pointer;" onClick="displayInstructions('<%=order_id%>','<%=order_line_no%>','<%=dialog_height%>','<%=java.net.URLEncoder.encode(drug_name_1,"UTF-8")%>')"<%=remarks_style%>> <!-- code  ePH.PractitionerPharmacistInstructions replaced by drugs_remarks for Bru-HIMS-CRF-416[IN045566] -->
									   <script>
											<%-- var drug_remarks = decodeURIComponent('<%=strDrugsRemarks%>');
											eval("document.getElementById("drugRemarks_")"+'<%=recCount%>').title= drug_remarks ; --%>
											var drug_remarks = decodeURIComponent('<%=strDrugsRemarks%>');
											document.getElementById("drugRemarks_" + '<%=recCount%>').title = drug_remarks;
									   </script>
									</td>  
									<td class="<%=classvalue%>" style="font-size:9px" title="<%=pres_details%>">
										<img src="../../ePH/images/exceed.gif" valign="center">
									</td>
									<%
									if(iqvia_integration_flag){
									if(patient_class.equalsIgnoreCase("OP") && (settlement_id.equalsIgnoreCase("X"))  && (iv_prep_yn.equals("")|| iv_prep_yn.equals(null) || iv_prep_yn.equals("null")) ){  //added for MOHE-CRF-0026.1 START %>
									<td class="<%=classvalue%>" style="font-size:9px" width="10%" >&nbsp;
									<label style='<%=narc_style%>' id="authStatus_<%=recCount%>"><b><%=status%></b> </label><br>&nbsp;
									<label style='<%=Qtystyle%>' id="appQtylabel_<%=recCount%>"><fmt:message key="ePH.ApprovedQty.label" bundle="${ph_labels}"/></label>&nbsp; 
									<label style='<%=narc_style%>' id="appQty_<%=recCount%>"> </label><%=approvedQty%><br>&nbsp;
									<label style='<%=Qtystyle%>' id="appAmtlabel_<%=recCount%>"><fmt:message key="ePH.ApprovedAmount.label" bundle="${ph_labels}"/> </label>&nbsp;
									<label style='<%=narc_style%>'  id="appAmt_<%=recCount%>"> </label><%=approvedAmt%><br>&nbsp;
									<input type="hidden" name="authStatus1_<%=recCount%>" id="authStatus1_<%=recCount%>" value="<%=status%>">
									<input type="hidden" name="appQty1_<%=recCount%>" id="appQty1_<%=recCount%>" value="<%=approvedQty%>">
									<input type="hidden" name="appAmt1_<%=recCount%>" id="appAmt1_<%=recCount%>" value="<%=approvedAmt%>">
									<input type="hidden" name="responseCode_<%=recCount%>" id="responseCode_<%=recCount%>" value=""><!-- MOHE-CRF-0026.1 -->
									<%} } //END %>
									<td class="<%=classvalue%>" style="font-size:9px" width="10%" <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')">&nbsp;<label style='<%=narc_style%>'><%=retunFormatedInt(pres_qty)%>&nbsp;(<%=qty_uom_disp%>)</label><br>&nbsp;
									<!--/*bean.getUomDisplay(facility_id,qty_uom)*/-->
<%
									if(!strength_value.equals("") && !strength_value.equals("0"))
										//pres_strength	=	Float.parseFloat(pres_qty) * Float.parseFloat(strength_value)+" "+strength_uom;
										pres_strength	=	retunFormatedInt(((Float.parseFloat(pres_qty) * Float.parseFloat(strength_value))*(main_drug_pack_size))+"")+" "+strength_uom_disp;
									if(multi_drugs.size()>1 &&((fractroundupyn.equals("N"))||(fractroundupyn.equals("")) )) { 
%>
										<b><%=pres_strength%></b>
<%	
									}
%>
									</td>
<%
									if(multi_drugs.size() > 1 ) {	
%>
										<td class="<%=classvalue%>" width="10%" <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')"><br>
<%
										int x	=	0;
										int tmp_recCount	=	recCount;
										String alternate_drug	=	"";
										float pack_size			=	1;
										float strength_per_value	=	1.0f;
										for(int l=0; l<alt_qty.size(); l+=4) { 
											alternate_drug		=	(String)alt_qty.get(l);	
											qty					=	(String)alt_qty.get(l+1);	
											uom					=	(String)alt_qty.get(l+2);	
											alt_strength_value	=	(String)alt_qty.get(l+3);	
											drug_color	        =	(String)colors.get(x++);
											pack_dtls			=	bean.getPackSize(alternate_drug);
											fractroundupyn      =   bean.getFractRoundupYN(alternate_drug);
                                            
											IssueUOMAndBaseUOM		=	(HashMap)bean.getStoreDfltIssueUOMAndBaseUOM(store_code,alternate_drug); // Added for ML-BRU-SCF-1803 - Start
											base_uom			     =  (String)IssueUOMAndBaseUOM.get("BASE_UOM")==null?"":(String)IssueUOMAndBaseUOM.get("BASE_UOM");
											base_to_disp_uom_equl    =	bean.getEqulValue ( alternate_drug, base_uom, uom);
											orig_dflt_issue_uom      = (String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM")==null?"":(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM");
											base_to_def_uom_equl	 =  bean.getEqulValue ( alternate_drug, base_uom, orig_dflt_issue_uom);
											medical_applicable=bean.checkMedicalItemYN(alternate_drug);//added for ghl-crf-0548
											if(!uom.equals(base_uom)){
												conv_factor    = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
												bean.setAlternateDrugQtyForCharge(patient_id,order_id,order_line_no,alternate_drug,Math.round(Double.parseDouble(qty)/conv_factor)+"");//changed alt_drug_code to alternate_drug for ML-MMOH-SCF-1479
											} // Added for ML-BRU-SCF-1803 - End
											
											if(pack_dtls!=null && pack_dtls.containsKey("PACK_SIZE")){
												if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
													pack_size			=	Float.parseFloat(((String)pack_dtls.get("PACK_SIZE")));
													if(!medical_applicable.equals("Y") ){//ADDED FOR GHL-CRF-0548
													strength_per_value	=	Float.parseFloat(((String)pack_dtls.get("STRENGTH_PER_VALUE_PRES_UOM")));
													if(base_to_disp_uom_equl!=base_to_def_uom_equl ){ // if condition Added for ML-BRU-SCF-1892 // || (!uom.equals(base_uom) && !alternate_drug.equals("")) Added for ML-MMOH-SCF-1160 
//													 qty = Math.round(Integer.parseInt(qty)/pack_size)+"";//added for ML-BRU-SCF-1803  //commented for MMS-KH-SCF-0035
//|| (!uom.equals(base_uom) && !alternate_drug.equals("")) commentedf or ML-MMOH-SCF-1318
													qty = (int)Math.ceil(Float.parseFloat(qty)/pack_size)+""; //added for MMS-KH-SCF-0035
													}else if(!uom.equals(base_uom) && !alternate_drug.equals("")){ // else if block added for ML-MMOH-SCF-1318 - Start							
													 qty  =   Math.round(Double.parseDouble(qty)/base_to_disp_uom_equl)+""; 
													} // added for ML-BRU-SCF-1892 - End
													}
												}		
											}
											if(!medical_applicable.equals("Y") )//ADDED FOR GHL-CRF-0548
											tmp_alloc	+=	new Float( ((Float.parseFloat(alt_strength_value)) * Double.parseDouble(qty)*pack_size)/strength_per_value ).doubleValue();
											if(fractroundupyn.equals("N")){
											   alloc_strength	=	retunFormatedInt(tmp_alloc+"")+" "+strength_uom;
											}
											else{
											   alloc_strength="";
											}
											//pres_qty		=	bms_qty;
											
											float prescribed_strength	=0;
											if(!medical_applicable.equals("Y") ){//ADDED FOR GHL-CRF-0548
											prescribed_strength=Float.parseFloat(tmp_bms_qty_1) * 	Float.parseFloat(strength_value)/Float.parseFloat(main_strength_per_value_pres_uom);
												
											}
											double balance_strength		=	prescribed_strength - tmp_alloc;
											if(balance_strength<1)
													balance_strength		=	0;
											 if(fractroundupyn.equals("N")&&fractroundupyn.equals("")){
												if(balance_strength!=0 && strength_value != null && strength_value !="") {
													bms_qty						=	Math.round(balance_strength / Float.parseFloat(strength_value))+"";
												} 
												else {
													bms_qty					=	"0";
												}
											}
											else{
												// bms_qty					=bms_qty;
												if(strength_value !="" && strength_value != null)
												bms_qty						=	Math.round(balance_strength / Float.parseFloat(strength_value))+"";
											}
											bms_strength				    =	balance_strength+"";
											bms_qty=Math.round(((Float.parseFloat(bms_qty)*(Float.parseFloat(main_strength_per_value_pres_uom)))/main_pack_size))+"";
											if(medical_applicable.equals("Y")){ //added for ghl-crf-0548 - Start
												bms_qty = (Float.parseFloat(tmp_bms_qty)-Float.parseFloat(qty))+"";
												tmp_bms_qty = bms_qty;
												alloc_strength = "";
											} //added for ghl-crf-0548 - End
									
											if(qty.equals("")){    
												uom_desc="";	
												if(unallocDrugs.equals("Y") && !(order_line_status.equals("AL") || order_line_status.equals("IP")))
													qty_status = "Unallocated";
											}
											else {
												//uom=qty_uom;
												tot_qty		+=	Double.parseDouble(qty);
												uom_desc	="("+bean.getUomDisplay(facility_id,uom)+")";
											}
										
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
												
												 itemCost = bean.getItemCost(drug_code, store_code, "1", end_date);  //MOHE-CRF-0026.1 
												
											}//end 
																						 
%>
											<label style="color:<%=drug_color%>;font-size:9px" id="alloc_qty<%=tmp_recCount%>">&nbsp;<%=retunFormatedInt(qty)%>&nbsp;<%=uom_desc%><br>
											<% if(iqvia_integration_flag){ %><!-- modified for ML-MMOH-SCF-1943 -->
											<input type="hidden" name="allocate_qty<%=tmp_recCount%>" id="allocate_qty<%=tmp_recCount%>" value="<%=retunFormatedInt(qty)%>  
											<input type="hidden" name="uom<%=tmp_recCount%>" id="uom<%=tmp_recCount%>" value="<%=uom%>">  <!-- MOHE-CRF-0026.1 -->
											 <input type="hidden" name="frequencyCode<%=tmp_recCount%>" id="frequencyCode<%=tmp_recCount%>" value="<%=frequencyCode%>"> 
											 <input type="hidden" name="repeatValue<%=tmp_recCount%>" id="repeatValue<%=tmp_recCount%>" value="<%=repeatValue%>"> 
											 <input type="hidden" name="durnValue<%=tmp_recCount%>" id="durnValue<%=tmp_recCount%>" value="<%=durnValue%>"> 
											 <input type="hidden" name="durationType<%=tmp_recCount%>" id="durationType<%=tmp_recCount%>" value="<%=durationType%>"> 
											<input type="hidden" name="routeCode<%=tmp_recCount%>" id="routeCode<%=tmp_recCount%>" value="<%=routeCode%>"> 
											 <input type="hidden" name="qtyValue<%=tmp_recCount%>" id="qtyValue<%=tmp_recCount%>" value="<%=qtyValue%>"> 
											 <input type="hidden" name="qtyUnit<%=tmp_recCount%>" id="qtyUnit<%=tmp_recCount%>" value="<%=qtyUnit%>">  
											 <input type="hidden" name="dispTmpNo<%=tmp_recCount%>" id="dispTmpNo<%=tmp_recCount%>" value="<%=dispTmpNo%>"> 
											 <input type="hidden" name="claimIdNo<%=tmp_recCount%>" id="claimIdNo<%=tmp_recCount%>" value="<%=claimIdNo%>">  
											 <input type="hidden" name="orderId<%=tmp_recCount%>" id="orderId<%=tmp_recCount%>" value="<%=order_id%>">  
											 <input type="hidden" name="itemCost<%=tmp_recCount%>" id="itemCost<%=tmp_recCount%>" value="<%=itemCost%>">
											<%} %>	<!-- modified for ML-MMOH-SCF-1943 -->						
											<!-- MOHE-CRF-0026.1 END  -->
											
<%	
											tmp_recCount        =   tmp_recCount+1;
											hsh_med_plan = new LinkedHashMap();// Added for Bru-HIMS-CRF-072.1 [IN:049144] start
											hsh_med_plan.put("qty",qty);
											if((qty.equals("") || qty.equals("0") ) ){//added for ml-bru-crf-0473
												 qty = "0.0";
												 uom=qty_uom;
											}
											if(!qty.equals("") && !qty.equals("0") && drug_trade_bean.getDrugyesno().equals("Y") && bean_1.getMedicationPlannerYN().equals("Y") && patient_class.equals("OP"))	{
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
												hsh_med_plan.put("qty_issuelocal",dfToInteger.format(Double.parseDouble(qty))+" "+medplan_bean.getUOMDesc(uom,loc_lang_id)); 
												hsh_med_plan.put("qty_issue",dfToInteger.format(Double.parseDouble(qty))+" "+medplan_bean.getUOMDesc(uom,primary_lang_id));
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
										<!-- Passed URLEncoder,UTF-8  for drug name in callbatchdetails regarding incident num:25276 ==By sandhya -->
										</label>&nbsp;<label id="alloc_qty_<%=tmp_recCount%>" style="font-size:9px;color:black"><b><%=alloc_strength%></b></label>
										<br><label style="cursor:pointer;color:blue;font-size:9px;"  onClick="javascript:callbatchdetails('<%=patient_id%>','<%=order_id%>','<%=order_line_no%>','<%=drug_code%>','Y','<%=java.net.URLEncoder.encode(drug_name_1,"UTF-8")%>')"><fmt:message key="ePH.Trades.label" bundle="${ph_labels}"/></label>
										</td>
<%	
									}
									else{	
										if(qty.equals("")) {
											qty	=	"";
											uom_desc	=	"";	
											if(unallocDrugs.equals("Y") && !(order_line_status.equals("AL") || order_line_status.equals("IP")))
												qty_status = "Unallocated";
										}
										else {
											if(!strength_value.equals("") && !strength_value.equals("0"))
												alloc_strength	=	Float.parseFloat(strength_value) * Float.parseFloat(qty)+"";
											uom_desc="("+bean.getUomDisplay(facility_id,qty_uom)+")";
											uom = qty_uom;
										}
										if(allow_zero_disp_label_site && qty.equals("") ){
											qty	=	"0";
											uom_desc="("+bean.getUomDisplay(facility_id,qty_uom)+")";
											uom = qty_uom;
											
										}
										String worksheet_id_1=bean_1.getWorksheetID();
										if(worksheet_id_1!=null && !worksheet_id_1.equals("")){
											spilqtyavail = bean_1.getSPILQTYAVAIL(order_id,order_line_no,ordering_facility_id,worksheet_id_1);
											qty =(Double.parseDouble(qty)+spilqtyavail)+"";
										}
						
										if(iqvia_integration_flag){//MOHE-CRF-0026.1 START
											strDosageDtls = bean_1.getFreqRepeatCode(order_id, order_line_no); 
											String[] arrSplit = strDosageDtls.split("~");  								
											frequencyCode = arrSplit[3];
											repeatValue = arrSplit[2]; 
											durnValue =  arrSplit[4]; 
											durationType = arrSplit[1];
											routeCode = arrSplit[5];
											qtyValue  =arrSplit[6];
											qtyUnit	  =	arrSplit[7];
											
											 itemCost = bean.getItemCost(drug_code, store_code, "1", end_date); //MOHE-CRF-0026.1 
											
										}//END 

										/*	Commented for RUT-CRF-0088 [IN036978] 
										if(taper_order_yn.equals("Y") && !taper_order_id.equals("") && !taper_order_line_num.equals("")){ //if block added to avoid displaying qty/charges for tapered drugs
											qty = "0";
											bms_qty = "0";
										}*/
										if(issue_qty_dtl==null)  //if block added for IN055174
											issue_qty_dtl = new StringBuffer();
%>
										<td class="<%=classvalue%>" width="10%" <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')"><label class="label" id="alloc_qty<%=recCount%>" ><b>&nbsp;<%=retunFormatedInt(qty)%>&nbsp;<%=uom_desc%></b>&nbsp;<%=issue_qty_dtl.toString()%><br></label><br>
 										<input type="hidden" name="allocate_qty<%=recCount%>" id="allocate_qty<%=recCount%>" value="<%=retunFormatedInt(qty)%>">  <!-- MOHE-CRF-0026.1 -->
										<input type="hidden" name="uom<%=recCount%>" id="uom<%=recCount%>" value="<%=uom%>">
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
											<input type="hidden" name="itemCost<%=recCount%>" id="itemCost<%=recCount%>" value="<%=itemCost%>"> <!-- MOHE-CRF-0026.1 END  -->
<% 
										if(order_type.equals("TD") && hmPPNStoredValues != null){ 
%>
											<b><label style="color:green;font-size:9px" id="TPN_PPN_alloc_qty"><%=hmPPNStoredValues.get("selectedQty")%>&nbsp;<%=bean.getUomDisplay(facility_id,hmPPNStoredValues.get("UOMCode").toString())%></label><b>
<%
										}
										if(!ord_type.equals("TA")){
%>
											<!-- Passed URLEncoder,UTF-8  for drug name in callbatchdetails regarding incident num:25276 ==By sandhya -->
											<label style="cursor:pointer;color:blue;font-size:9px;"  onClick="javascript:callbatchdetails('<%=patient_id%>','<%=order_id%>','<%=order_line_no%>','<%=drug_code%>','N','<%=java.net.URLEncoder.encode(drug_name_1,"UTF-8")%>')"><fmt:message key="ePH.Trades.label" bundle="${ph_labels}"/></label>
<%
										}
%>
										</td>
<%
										hsh_med_plan = new LinkedHashMap();// Added for Bru-HIMS-CRF-072.1 [IN:049144] start
										hsh_med_plan.put("qty",qty);
										if((qty.equals("") || qty.equals("0") ) ){//added for ml-bru-crf-0473
											 qty = "0.0";
											 uom=qty_uom;
										}
										if(!qty.equals("") && !qty.equals("0") && drug_trade_bean.getDrugyesno().equals("Y") && bean_1.getMedicationPlannerYN().equals("Y") && patient_class.equals("OP"))	{
											arrOrderId.add(order_id+"_"+order_line_no);
											dosedet[0] = "";dosedet[1] = "";dosedet[2] = "";dosedet[3] = "";dispno[0]="";dispno[1]="";
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
											hsh_med_plan.put("qty_issuelocal",dfToInteger.format(Double.parseDouble(qty))+" "+medplan_bean.getUOMDesc(uom,loc_lang_id)); 
											hsh_med_plan.put("qty_issue",dfToInteger.format(Double.parseDouble(qty))+" "+medplan_bean.getUOMDesc(uom,primary_lang_id));
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
									}
									
									if(multi_drugs.size() > 1 ) { 
										/*if(fractroundupyn.equals("Y")){
											bms_qty	=	Float.parseFloat(bms_qty)- tot_qty +"";
										}/*
										if( Float.parseFloat(strength_value) > Float.parseFloat(alt_strength_value) ) {
											if(tot_qty > 0)
												bms_qty	=	Float.parseFloat(pres_qty) - (tot_qty / prod_qty)+"";
											else 
												bms_qty	=	(Float.parseFloat(bms_qty) / prod_qty)+"";
										} 
										else {
											if(!qty.equals("") && !qty.equals("0")){
												bms_qty	=	Float.parseFloat(bms_qty)- tot_qty +"";
											}
										}*/
									} 
									else {
										if(!qty.equals("") && !qty.equals("0")){
											bms_qty	=	Double.parseDouble(bms_qty)- tot_qty +"";
											bms_qty	=   Double.parseDouble(bms_qty)- spilqtyavail+"";
											if(Float.parseFloat(bms_qty)<0){
												 bms_qty	= "0";
											}
										}
									}
									if(fractroundupyn.equals("N")){			
										if(!strength_value.equals("") && !alt_strength_value.equals("")) {
											if(bms_strength.equals(""))
											bms_strength	=	Float.parseFloat(bms_qty) * Float.parseFloat(strength_value)*(main_pack_size)+"";
											//bms_strength		=	Float.parseFloat(bms_qty) * Float.parseFloat(alt_strength_value)+"";
										}
										else if(!strength_value.equals("") && !strength_value.equals("0")) {
											//bms_strength		=	Float.parseFloat(bms_qty) * Float.parseFloat(strength_value)+"";
											  bms_strength		=	"";
											  strength_uom		=	"";
											  strength_uom_disp = "";
										}
										else {
											strength_uom	=	"";
											strength_uom_disp = "";
										}
									}
									else{
										 bms_strength		=	"";
										 strength_uom		=	"";
										 strength_uom_disp = "";
									}
									//if(bms_qty.indexOf(".")!=-1) {
									// int pos	=	bms_qty.indexOf(".");
									// if(bms_qty.length() > (pos+3) )
									//	bms_qty	=	bms_qty.substring(0,(pos+3));

									//}
									if(bms_strength.equals("0.0")||bms_strength.equals("0")||bms_qty.equals("0.0")||bms_qty.equals("0")){
										bms_strength="";
										strength_uom="";
										strength_uom_disp = "";
									}	
%>
									<td class="<%=classvalue%>" width="10%" style="font-size:9px" onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" <%=title%>>&nbsp;<%=retunFormatedInt(bms_qty)%>&nbsp;(<%=qty_uom_disp%>)<br>&nbsp;<!---/*bean.getUomDisplay(facility_id,qty_uom)*/--><b><%=bms_strength%>&nbsp;<%=strength_uom_disp%></b><input type="hidden" name="bms_qty<%=recCount%>" id="bms_qty<%=recCount%>" value="<%=bms_qty%>"></td><!---/*bean.getUomDisplay(facility_id,strength_uom)*/-->
<%
									bms_strength="";
									strength_uom="";
									strength_uom_disp = "";
									if(bms_qty .equals("0.0")||bms_qty .equals("0")){
											disable="disabled";
									}
									else{
										disable="";
									}
									//disp_delivery_chk_box_disabled
									//for billing interface coding starts
									//boolean approval_flag = false;//AAKH-CRF-0117 moved to up
							        String disabled = "disabled";//AAKH-CRF-0117
									if(billing_interface_yn.equals("Y")&& bl_display.equals("Y")){	
			                     if(bean.getDisplayInsStatus()){  //Added for TH-KW-CRF-0012
%>
                                    <td class="<%=classvalue%>"><center>&nbsp;<%=insurance_status%></center></td>
<%}
										if(in_formulary_yn.equals("Y")){ 
											float gross_charge_amount		=	0;
											float groos_pat_payable			=	0;
											 float gross_amount        = 0;//Added for ML-BRU-CRF-0469
											//float net_amount          =0;
											disp_delivery_chk_box			=	"checked";
											disp_delivery_chk_box_val		=	"Y";
											disp_delivery_chk_box_disabled	=	"";
											gross_charge_amount_str			=	"";
											groos_pat_payable_str			=   "";
											batch_str						=   "";
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
													HashMap billing_det = bean.getchargedetails(patient_id ,order_id,order_line_no,bl_encounter_id,bl_patient_class,dischargeIND);
													if(billing_det.containsKey(drug_code)){
													   HashMap  chareg_det=(HashMap)billing_det.get(drug_code);
													   if(chareg_det.get("error_msg").equals("")  ){

															decimalFormatString         =(String)chareg_det.get("BL_DECIMAL_FORMAT_STRING");
															DecimalFormat dfTest        = new DecimalFormat(decimalFormatString);
															/*if(!chareg_det.get("grosschargeamt").equals("null")){
																 gross_charge_amount= Float.parseFloat((String)chareg_det.get("grosschargeamt"));
															}*/ //commented for ML-BRU-SCF-0368 [IN:034748]
															if(!chareg_det.get("patnetamt").equals("null")){
																 groos_pat_payable  = Float.parseFloat(((String)chareg_det.get("patnetamt")).trim());
															}
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
															//added for ML-BRU-CRF-0469 start
															if(displayGrossAmtYn){
															gross_amount_str = dfTest.format(gross_amount);
															}
															//added for ML-BRU-CRF-0469 end
															gross_charge_display_str.append("<label style='font-size:9px;color:black' id='groos_pat_payable_str_").append(order_id).append(order_line_no).append(drug_code).append("'>").append(groos_pat_payable_str).append("</label>");
															pat_charge_display_str.append("<label style='font-size:9px;color:black' id='gross_charge_amount_str_").append(order_id).append(order_line_no).append(drug_code).append("'>").append(gross_charge_amount_str).append("</label>");	
															//added for ML-BRU-CRF-0469 start 
															if(displayGrossAmtYn){    
															gross_disply_str.append("<label style='font-size:9px;color:black' id='gross_amount_str_").append(order_id).append(order_line_no).append(drug_code).append("'>").append(gross_amount_str).append("</label>");
															}
															//added for ML-BRU-CRF-0469 end
															inc_exec_display_str.append("<a  style ='font-size:9px' href=\"javascript:callIncludeExclude(").append("'D'").append(",").append("''").append(",").append("'").append(drug_code).append("'").append(",").append("'").append(qty).append("'").append(",").append("'").append(batch_str).append("'").append(",").append("'").append(order_id).append("'").append(",").append("'").append(order_line_no).append("'").append(")\">").append( com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Include.label","common_labels")).append("?</a>");
															tot_gross_charge_amount = tot_gross_charge_amount+gross_charge_amount;
															tot_groos_pat_payable   = tot_groos_pat_payable+groos_pat_payable;
															if(tot_gross_charge_amount!=tot_groos_pat_payable){  //AAKH-CRF-0117
																approval_flag =true;
															}
															//added for ML-BRU-SCF-0469 start
															if(displayGrossAmtYn){   
															tot_gross_amount        = tot_gross_amount+gross_amount;
															}
															//added for ML-BRU-SCF-0469 end
%>
															<input type="hidden" name="override_allowed_yn_<%=order_id%><%=order_line_no%><%=drug_code%>" id="override_allowed_yn_<%=order_id%><%=order_line_no%><%=drug_code%>"  value="<%=(String)chareg_det.get("override_allowed_yn")%>">
															<input type="hidden" name="excl_incl_ind_<%=order_id%><%=order_line_no%><%=drug_code%>" id="excl_incl_ind_<%=order_id%><%=order_line_no%><%=drug_code%>"        value="">
															<input type="hidden" name="excl_incl_ind_default_<%=order_id%><%=order_line_no%><%=drug_code%>" id="excl_incl_ind_default_<%=order_id%><%=order_line_no%><%=drug_code%>" value="<%=(String)chareg_det.get("excl_incl_ind")%>">
															<input type="hidden" name="approval_reqd_yn_<%=order_id%><%=order_line_no%><%=drug_code%>" id="approval_reqd_yn_<%=order_id%><%=order_line_no%><%=drug_code%>"     value="<%=(String)chareg_det.get("approval_reqd_yn")%>">
															<input type="hidden" name="bl_incl_excl_override_reason_desc_<%=order_id%><%=order_line_no%><%=drug_code%>" id="bl_incl_excl_override_reason_desc_<%=order_id%><%=order_line_no%><%=drug_code%>" value="">
															<input type="hidden" name="bl_incl_excl_override_reason_code_<%=order_id%><%=order_line_no%><%=drug_code%>" id="bl_incl_excl_override_reason_code_<%=order_id%><%=order_line_no%><%=drug_code%>" value="">
															<input type="hidden" name="gross_charge_amount_<%=order_id%><%=order_line_no%><%=drug_code%>" id="gross_charge_amount_<%=order_id%><%=order_line_no%><%=drug_code%>" value="<%=gross_charge_amount+""%>">
															<input type="hidden" name="groos_pat_payable_<%=order_id%><%=order_line_no%><%=drug_code%>" id="groos_pat_payable_<%=order_id%><%=order_line_no%><%=drug_code%>"   value="<%=groos_pat_payable+""%>">
															<!-- added for ML-BUR-CRF-0469 start-->
															<% if(displayGrossAmtYn){ %>
															<input type="hidden" name="gross_amount_<%=order_id%><%=order_line_no%><%=drug_code%>" id="gross_amount_<%=order_id%><%=order_line_no%><%=drug_code%>"   value="<%=gross_amount+""%>">
															<%} %>
															<!-- added for ML-BUR-CRF-0469 end-->
															<input type="hidden" name="drug_color_<%=order_id%><%=order_line_no%><%=drug_code%>" id="drug_color_<%=order_id%><%=order_line_no%><%=drug_code%>"   value='black'>
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
															disp_delivery_chk_box			="";
															disp_delivery_chk_box_val		="N";
															disp_delivery_chk_box_disabled	="disabled";
															disable							="disabled";
														}        
														if(disp_locn_catg.equals("I")){
															amt_paid_yn="";
														}
														else{
															if(chareg_det.get("pat_paid_flag").equals("0")||chareg_det.get("pat_paid_flag").equals("1")||chareg_det.get("pat_paid_flag").equals("2")){
																amt_paid_yn="Y";	
															}
															else{
																amt_paid_yn="N";
															}
															/*if(!chareg_det.get("pat_paid_amt").equals("")){
																if(Float.parseFloat((String)chareg_det.get("pat_paid_amt"))>=groos_pat_payable){
																	 amt_paid_yn="Y";	
																}
																else{
																	 amt_paid_yn="N";
																}
															}
															else{
																if(groos_pat_payable==0){
																	amt_paid_yn="Y";
																}
																else{
																	amt_paid_yn="N";
																}
															}*/
														}
													}	
												}
											}
											if(multi_drugs.size()>1){
												int  added_yn =0;
												int  x		=0;

												for(int n=0; n<multi_drugs.size(); n+=5)	{							    
													alt_drug_code	     =	(String)multi_drugs.get(n);
													drug_color			 =	(String)colors.get(x++);
													HashMap billing_det = bean.getchargedetails(patient_id ,order_id,order_line_no,bl_encounter_id,bl_patient_class,dischargeIND);

													if(billing_det.containsKey(alt_drug_code)){
														HashMap  chareg_det=(HashMap)billing_det.get(alt_drug_code);
														if(chareg_det.get("error_msg").equals("") ){
															batch_str =(String)chareg_det.get("BATCH_STRING");
															decimalFormatString     =(String)chareg_det.get("BL_DECIMAL_FORMAT_STRING");
															DecimalFormat dfTest   = new DecimalFormat(decimalFormatString);

															/*if(!chareg_det.get("grosschargeamt").equals("null")){ 
																gross_charge_amount= Float.parseFloat((String)chareg_det.get("grosschargeamt"));
															} */ //commented for ML-BRU-SCF-0368 [IN:034748]
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
															
															if(tot_gross_charge_amount!=tot_groos_pat_payable){  //AAKH-CRF-0117
																approval_flag =true;
															}

															if(displayGrossAmtYn){ // Added for 68194 - Start   
																gross_amount_str    = dfTest.format(gross_amount);
															} // Added for 68194 - End
																	
															gross_charge_display_str.append("<label style='font-size:9px;color:").append(drug_color).append("' id='groos_pat_payable_str_").append(order_id).append(order_line_no).append(alt_drug_code).append("'>").append(groos_pat_payable_str).append("</label><BR>");
															pat_charge_display_str.append("<label style='font-size:9px;color:").append(drug_color).append("' id='gross_charge_amount_str_").append(order_id).append(order_line_no).append(alt_drug_code).append("'>").append(gross_charge_amount_str).append("</label><BR>");
															inc_exec_display_str.append("<label style='cursor:pointer;font-size:9px;color:").append(drug_color).append("' onclick=\"javascript:callIncludeExclude(").append("'D'").append(",").append("''").append(",").append("'").append(alt_drug_code).append("'").append(",").append("'").append(qty).append("'").append(",").append("'").append(batch_str).append("'").append(",").append("'").append(order_id).append("'").append(",").append("'").append(order_line_no).append("'").append(")\">").append( com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Include.label","common_labels")).append("?</label><br>");

															if(displayGrossAmtYn){ // Added for 68194 - Start   
																gross_disply_str.append("<label style='font-size:9px;color:").append(drug_color).append("' id='gross_amount_str_").append(order_id).append(order_line_no).append(alt_drug_code).append("'>").append(gross_amount_str).append("</label><BR>");												
															} // Added for 68194 - End
															
															added_yn++;

															tot_gross_charge_amount = tot_gross_charge_amount+gross_charge_amount;
															tot_groos_pat_payable   = tot_groos_pat_payable+groos_pat_payable;
															
															if(displayGrossAmtYn){
																tot_gross_amount            =tot_gross_amount+gross_amount; //added for 68194
															}
 
															if(disp_locn_catg.equals("I")){
																amt_paid_yn="";
															}
															else{
																if(chareg_det.get("pat_paid_flag").equals("0")||chareg_det.get("pat_paid_flag").equals("1")||chareg_det.get("pat_paid_flag").equals("2")){
																	amt_paid_yn="Y";	
																}
																else{
																	amt_paid_yn="N";
																}

																/*if(!chareg_det.get("pat_paid_amt").equals("")){
																	if(Float.parseFloat((String)chareg_det.get("pat_paid_amt"))>=groos_pat_payable){
																		 amt_paid_yn="Y";	
																	}else{
																		 amt_paid_yn="N";
																	}
																}else{
																	if(groos_pat_payable==0){
																		amt_paid_yn="Y";
																	}else{
																		amt_paid_yn="N";
																	}
																}*/
														   }
%>
															<input type="hidden" name="override_allowed_yn_<%=order_id%><%=order_line_no%><%=alt_drug_code%>" id="override_allowed_yn_<%=order_id%><%=order_line_no%><%=alt_drug_code%>"  value="<%=(String)chareg_det.get("override_allowed_yn")%>">
															<input type="hidden" name="excl_incl_ind_<%=order_id%><%=order_line_no%><%=alt_drug_code%>" id="excl_incl_ind_<%=order_id%><%=order_line_no%><%=alt_drug_code%>"        value="">
															<input type="hidden" name="excl_incl_ind_default_<%=order_id%><%=order_line_no%><%=alt_drug_code%>" id="excl_incl_ind_default_<%=order_id%><%=order_line_no%><%=alt_drug_code%>"value="<%=(String)chareg_det.get("excl_incl_ind")%>">
															<input type="hidden" name="approval_reqd_yn_<%=order_id%><%=order_line_no%><%=alt_drug_code%>" id="approval_reqd_yn_<%=order_id%><%=order_line_no%><%=alt_drug_code%>"     value="<%=(String)chareg_det.get("approval_reqd_yn")%>">
															<input type="hidden" name="bl_incl_excl_override_reason_desc_<%=order_id%><%=order_line_no%><%=alt_drug_code%>" id="bl_incl_excl_override_reason_desc_<%=order_id%><%=order_line_no%><%=alt_drug_code%>" value="">
															<input type="hidden" name="bl_incl_excl_override_reason_code_<%=order_id%><%=order_line_no%><%=alt_drug_code%>" id="bl_incl_excl_override_reason_code_<%=order_id%><%=order_line_no%><%=alt_drug_code%>" value="">
															<input type="hidden" name="gross_charge_amount_<%=order_id%><%=order_line_no%><%=alt_drug_code%>" id="gross_charge_amount_<%=order_id%><%=order_line_no%><%=alt_drug_code%>" value="<%=gross_charge_amount+""%>">
															<input type="hidden" name="groos_pat_payable_<%=order_id%><%=order_line_no%><%=alt_drug_code%>" id="groos_pat_payable_<%=order_id%><%=order_line_no%><%=alt_drug_code%>"   value="<%=groos_pat_payable+""%>">
															<input type="hidden" name="drug_color_<%=order_id%><%=order_line_no%><%=alt_drug_code%>" id="drug_color_<%=order_id%><%=order_line_no%><%=alt_drug_code%>"   value="<%=drug_color%>">
<% 
														}
														else{
															  gross_charge_display_str.append("<label style='font-size:9px;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("<BR>");
															  pat_charge_display_str.append("<label style='font-size:9px;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("<BR>");
															   disp_delivery_chk_box			="";
															   disp_delivery_chk_box_val		="N";
															   disp_delivery_chk_box_disabled	="disabled";
															   disable							="disabled";
														}
													}							  
												}
											
												/*if(added_yn>0){
													gross_charge_display_str.append("</label>");
													pat_charge_display_str.append("</label>");
												}*/

											}
											str_enable_disable		="-";
											if(allow_deliver_without_bl.equals("Y")) //Added for Allow Deliver without Bill
												amt_paid_yn="Y";
											if(amt_paid_yn.equals("N")){
												if(disp_billing_stage.equals("A")){
													if((bl_patient_class != null && bl_patient_class.equals("I")) &&  (patient_class!= null && patient_class.equals("OP"))){
														 str_enable_disable ="-";
													}
													else{
														str_enable_disable				="<IMG SRC=\"../../eCommon/images/disabled.gif\"></IMG>";
													}
													if(!disp_cash_coll_stage.equals("D")){
														disp_delivery_chk_box			="";
														disp_delivery_chk_box_val		="N";
														disp_delivery_chk_box_disabled	="disabled";
														disable							="disabled";
													}
												}
											}
											else if(amt_paid_yn.equals("Y")) {
												if(disp_billing_stage.equals("A")){
													str_enable_disable		="<IMG SRC=\"../../eCommon/images/enabled.gif\"></IMG>";
												}
											}
%>			  
                      <!-- added for ML-BRU-CRF-0469 start -->
                      <%if(displayGrossAmtYn){ %>
					<td class="<%=classvalue%>"><center>&nbsp;<%=gross_disply_str.toString()%></center><br>
<% 
					if(order_type.equals("TD") && bean_1.getHmPPNValues() != null){ 
						if(bean_1.getHmPPNValues().get("billingError")== null || bean_1.getHmPPNValues().get("billingError").equals("")){					
%>
							<label style="color:green;font-size:9px" ><%=bean_1.getHmPPNValues().get("grossCost")%></label>
<%
						}
						else{
%>
							<label style="color:green;font-size:9px" title="<%=bean_1.getHmPPNValues().get("billingError")%>"><center><fmt:message key="Common.Error.label" bundle="${common_labels}"/></center></label>
<%
						}
					}
%>				
					</td>
					<% }%>
					
					<!-- added for ML-BRU-CRF-0469 end -->
											<td class="<%=classvalue%>"><center>&nbsp;<%=pat_charge_display_str.toString()%></center><br>
<% 
											if(order_type.equals("TD") && hmPPNStoredValues != null){
												if(bean_1.getHmPPNValues().get("billingError")== null || bean_1.getHmPPNValues().get("billingError").equals("")){
%>
													<label style="color:green;font-size:9px" ><%=bean_1.getHmPPNValues().get("grossCost")%></label>
<%
												}
												else{
%>
													<label style="color:green;font-size:9px" title="<%=bean_1.getHmPPNValues().get("billingError")%>"><center><fmt:message key="Common.Error.label" bundle="${common_labels}"/></center></label>
<%
												}
											}
%>	
											</td>
											<td class="<%=classvalue%>"><center>&nbsp;<%=gross_charge_display_str.toString()%></center><br>
<% 
											if(order_type.equals("TD") && hmPPNStoredValues != null){
												if(bean_1.getHmPPNValues().get("billingError")== null || bean_1.getHmPPNValues().get("billingError").equals("")){
%>
													<label style="color:green;font-size:9px" ><%=bean_1.getHmPPNValues().get("grossCost")%></label>
<%
												}
												else{
%>
													<label style="color:green;font-size:9px" title="<%=bean_1.getHmPPNValues().get("billingError")%>"><center><fmt:message key="Common.Error.label" bundle="${common_labels}"/></center></label>
<%
												}
											}
%>	
											</td>
											<td class="<%=classvalue%>"><center>&nbsp;<%=inc_exec_display_str.toString()%></center></td>
											<td class="<%=classvalue%>"><center>&nbsp;<%=str_enable_disable%></center></td>			
<% 				
										}
										else{
%>
											<td class="<%=classvalue%>">&nbsp;
											<br>
<% 
											if(order_type.equals("TD") && hmPPNStoredValues != null){
												if(bean_1.getHmPPNValues().get("billingError")== null || bean_1.getHmPPNValues().get("billingError").equals("")){
%>
													<label style="color:green;font-size:9px" ><%=bean_1.getHmPPNValues().get("grossCost")%></label>
<%
												}
												else{
%>
													<label style="color:green;font-size:9px" title="<%=bean_1.getHmPPNValues().get("billingError")%>"><center><fmt:message key="Common.Error.label" bundle="${common_labels}"/></center></label>
<%
												}
											}
%>	
											 </td>
											 <td class="<%=classvalue%>">&nbsp;
											 <br>
<% 
											if(order_type.equals("TD") && hmPPNStoredValues != null){ 
												if(bean_1.getHmPPNValues().get("billingError")== null || bean_1.getHmPPNValues().get("billingError").equals("")){
%>
													<label style="color:green;font-size:9px" ><%=bean_1.getHmPPNValues().get("grossCost")%></label>
<%
												}
												else{
%>
													<label style="color:green;font-size:9px" title="<%=bean_1.getHmPPNValues().get("billingError")%>"><center><fmt:message key="Common.Error.label" bundle="${common_labels}"/></center></label>
<%
												}
											}
%>						 
											 </td>
											 <td class="<%=classvalue%>">&nbsp;</td>
											 <td class="<%=classvalue%>"><center>-</center></td>
<%
										}		
										//billing interface coding ends here
									}   
									if(billing_interface_yn.equals("Y")&& (ord_type.equals("TA") ||(tpn_mf_label && order_type.equals("TD")))){

										StringBuffer gross_charge_display_str   = new StringBuffer();
										StringBuffer pat_charge_display_str     = new StringBuffer();
										StringBuffer gross_disply_str          = new StringBuffer(); //added for 68194
									   
										gross_charge_display_str.append("<label style='font-size:9px;color:black' id='groos_pat_payable_str_").append(order_id).append(order_line_no).append(drug_code).append("'>").append(tot_groos_pat_payable).append("</label>");
										pat_charge_display_str.append("<label style='font-size:9px;color:black' id='gross_charge_amount_str_").append(order_id).append(order_line_no).append(drug_code).append("'>").append(tot_gross_charge_amount).append("</label>");
										if(displayGrossAmtYn){  // Added for 68194 - Start  
											gross_disply_str.append("<label style='font-size:9px;color:black' id='gross_amount_str_").append(order_id).append(order_line_no).append(drug_code).append("'>").append(tot_gross_amount).append("</label>");
										} // Added for 68194 - End
%>
										<td class="<%=classvalue%>"><center><%=pat_charge_display_str.toString()%></center></td>
										<td class="<%=classvalue%>"><center><%=gross_charge_display_str.toString()%></center></td>
										<td class="<%=classvalue%>">&nbsp;</td>
										<td class="<%=classvalue%>"><center>-</center></td>
<% 
									}
									if(billing_interface_yn.equals("Y")){
										if((bl_patient_class != null && bl_patient_class.equals("I")) &&  (patient_class!= null && patient_class.equals("OP"))){
											disp_delivery_chk_box_val = "Y";
											disp_delivery_chk_box	= "checked";
										}
									}
%>		
									<!-- delivery status -->
									<td class="<%=classvalue%>" width="10%"  <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')">&nbsp;
<% 
									//if( (!qty.equals("") && !qty.equals("0")) ||((taper_order_yn.equals("Y") && !taper_order_id.equals("") && !taper_order_line_num.equals(""))) ) { // && !taper_order_id.equals("") && !taper_order_line_num.equals("") added to display/print lables for tapered drugs
									if((!ord_type.equals("IVAA")&& !ord_type.equals("IVIA")&& !ord_type.equals("CA")&&!ord_type.equals("TA")&& !ord_type.equals("TD")&& !ord_type.equals("CO"))){  //"&& !ord_type.equals("TD")" alone added for SRR20056-SCF-7289
%>
										<!-- Passed URLEncoder,UTF-8  for drug name in callEditDetails regarding incident num:25276 ==By sandhya -->
										<label style="cursor:pointer;color:blue;font-size:9px;" id="edit_remarks<%=recCount%>" onClick="callEditDetails(this,'<%=order_id%>','<%=drug_code%>','<%=recCount%>','<%=order_line_no%>','D','edit_remarks<%=recCount%>','<%=patient_id%>','<%=ord_date_time%>','<%=performing_pract_id%>','<%=drug_code%>','<%=java.net.URLEncoder.encode(drug_name_1,"UTF-8")%>','<%=pres_qty%>','<%=uom%>','<%=disp_locn_catg%>');" ><fmt:message key="ePH.EditLabel.label" bundle="${ph_labels}"/></label>
<%
										if(multi_drugs.size()==0){
											hmEditLabelValues = new HashMap();	
											hmEditLabelValues.put("order_id",order_id);
											hmEditLabelValues.put("pres_drug_code",drug_code);
											hmEditLabelValues.put("drug_code",drug_code);
											hmEditLabelValues.put("order_line_no",order_line_no);
											hmEditLabelValues.put("ord_date_time",ord_date_time);
											hmEditLabelValues.put("drug_name_1",drug_name);
											hmEditLabelValues.put("drug_desc",drug_desc); //Added for Bru-HIMS-CRF-414- ML-BRU-SCF-1454 [IN:052271]
											hmEditLabelValues.put("pres_qty",pres_qty);	
											hmEditLabelValues.put("uom",uom);
											hmEditLabelValues.put("alt_drug_flag","N");   //newly added by manickam
											hmEditLabelValues.put("alt_drug_count", "0");  //Added for Bru-HIMS-CRF-414- ML-BRU-SCF-1528 [IN:053217]
											alEditLabelPair.add(hmEditLabelValues);
											bean.setSPerformPractId(performing_pract_id);
										}
									}
									if( Double.parseDouble(bms_qty) == 0 ) { // && !taper_order_id.equals("") && !taper_order_line_num.equals("") added to display/print lables for tapered drugs	// (!qty.equals("") && !qty.equals("0")) changed to Double.parseDouble(bms_qty) == 0 for JD-CRF-0179 [IN:41211] 
%>
										<label style="cursor:pointer;color:blue;font-size:9px;" id="fill_remarks<%=recCount%>" onClick="callFillingRemarks(this,'<%=order_id%>','<%=drug_code%>','<%=recCount%>','<%=order_line_no%>','D','fill_remarks<%=recCount%>');"> <fmt:message key="Common.Findings.label" bundle="${common_labels}"/></label>&nbsp;	
		
										<!-- <input type='checkbox'  name='del_detail<%=recCount%>' id='del_detail<%=recCount%>'  style='visibility:visible' checked disabled value='Y' onClick='updateValue(this)'></td> -->
										<br><input type='checkbox' name='del_detail<%=recCount%>' id='del_detail<%=recCount%>'  style='visibility:visible' <%=disp_delivery_chk_box%> <%=disp_delivery_chk_box_disabled%>  value='<%=disp_delivery_chk_box_val%>' onClick='updateValue(this)'>
<%		
									} 
									else if(order_line_status.equals("AL") || order_line_status.equals("IP"))	{	
%>
										&nbsp;<input type='checkbox' name='del_detail<%=recCount%>' id='del_detail<%=recCount%>'  style='visibility:visible' <%=disp_delivery_chk_box%> <%=disp_delivery_chk_box_disabled%>  value='<%=disp_delivery_chk_box_val%>' onClick='updateValue(this)'> <!-- disp_delivery values assigned for  [IN:049880] -->
										<font style='color:red;font-weight:bold;FONT-SIZE: 7pt ;'><br ><%=qty_status%></br></font>			
										<label style="cursor:pointer;color:blue;font-size:9px;" id="fill_remarks<%=recCount%>" onClick="callFillingRemarks(this,'<%=order_id%>','<%=drug_code%>','<%=recCount%>','<%=order_line_no%>','D','fill_remarks<%=recCount%>');"> <fmt:message key="Common.Findings.label" bundle="${common_labels}"/></label>&nbsp; <!-- code added for ML-BRU-SCF-0971[IN042220]--></td>
<%	
									}
									else if (bDischargePatient){
%>
										&nbsp;<input type='checkbox' name='del_detail<%=recCount%>' id='del_detail<%=recCount%>'  style='visibility:visible'  checked disabled value='Y'>
<%
									}
									else{	
%>
										&nbsp;
										<input type='checkbox' name='del_detail<%=recCount%>' id='del_detail<%=recCount%>'  style='visibility:visible' disabled value='N'><font style='color:red;font-weight:bold;FONT-SIZE: 7pt ;'><br ><%=qty_status%></br></font></td>
<%
									}
%>
									<input type="hidden"  name="order_line_num<%=recCount%>" id="order_line_num<%=recCount%>" value="<%=order_line_no%>">
<%
									if(scope.equals("H")){
										legend1=bean_1.getresultlinestatus(order_id,order_line_no);
										if(legend1==null)
											legend1="";
										if(legend1.equals("OS")){
											legend_text= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outstanding.label","common_labels");
										}
										else if(legend1.equals("DP")||legend1.equals("DD")){//legend1.equals("DD") ADDED FOR MMS-KH-CRF-0014
											legend_text=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PartiallyDispensed.label","ph_labels");
										}
										else if(legend1.equals("RG")){
											legend_text= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InProcess.label","common_labels");
										}
										else if(legend1.equals("AL")){
											legend_text= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Alloocated.label","ph_labels");
										}
%>
										<td class="<%=classvalue%>"  onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')"><label style="color:red;font-size:9px" id="result_line_status<%=recCount%>"><b><%=legend_text%></b>
										</label></td>
<%
									}
									else{
										/*if(bms_qty .equals("0.0")||bms_qty .equals("0")){
												disable="disabled";
											}else{
												disable="";
										}*/
										//disp_delivery_chk_box_disabled
									if(order_type.equals("TA") ||(tpn_mf_label && order_type.equals("TD")))    //added for IN038706 - to disable Complete Order Reason for TPN Admixture - Delivery
										disable="disabled";
%>
										<td class="<%=classvalue%>" onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')"><input type='checkbox'   name="CompleteOrder<%=recCount%>" id="CompleteOrder<%=recCount%>" value='N' onClick='setcompleteorder(this)'<%=disable%> style='visibility:hidden'>
											<select name="ComplteOrderReason<%=recCount%>" id="ComplteOrderReason<%=recCount%>" onchange='setCheckBoxValue(this,document.DispMedicationAllStages.CompleteOrder<%=recCount%>,document.getElementById("hold_remarks_")<%=recCount%>)'  <%=disable%>>
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
									}
									if(disp_level.equals("P")) {	
%>
										<input type="hidden"  name="order_id<%=recCount%>" id="order_id<%=recCount%>" value="<%=order_id%>">
<%	
									}
 
						if(approval_flag){//AAKH-CRF-0117
							disabled = "";
						}
						
						if(approval_no_flag){ //added for AAKH-CRF-0117
						String approval_no="";//AAKH-CRF-0117
						   if(approval_flag){//AAKH-CRF-0117
								approval_no= (String)approvalNo.get(order_id+order_line_no);
								 
						   }
						   if(approval_no==null) //AAKH-CRF-0117
							   approval_no = "";
						%>
                     <td class="<%=classvalue%>" nowrap> <!--modified for AAKH-CRF-0117 -->    
					 <input type="text" value="<%=approval_no%>" maxlength="20" onchange="getApprovalNumForDrug(this,<%=recCount%>)"  name="approval_no_<%=recCount%>" <%=disabled%>  onKeyPress="return KeyPressSpecCharsForApprovalNo(event)" onBlur="CheckForSpecCharApprovalno(this,'D',<%=recCount%>)"  /><!--MODIFIED FOR AAKH-CRF-0117 -->
					 <%
						if(approval_no_app_for_patient_class!=null && approval_no_app_for_patient_class.equals("Y") && disabled.equals("")){
						 approval_no_style = "visibility:visible";
					 }%>
						<img id="imgForWithin_<%=recCount%>" src="../../eCommon/images/mandatory.gif" align="center" style="<%=approval_no_style%>"></img><!-- AAKH-CRF-0117 -->	 
						 
					 </td>
					 <input type="hidden"  name="order_id_<%=recCount%>" id="order_id_<%=recCount%>" value="<%=order_id%>"> <!--added for GHL-CRF-0453 -->
				<input type="hidden"  name="drug_code_<%=recCount%>" id="drug_code_<%=recCount%>" value="<%=drug_code%>"> <!--added for GHL-CRF-0453 -->
				<input type="hidden"  name="order_line_num_<%=recCount%>" id="order_line_num_<%=recCount%>" value="<%=order_line_no%>">
<%
               }
%>								</tr>

								<input type="hidden"  name="order_line_status<%=recCount%>" id="order_line_status<%=recCount%>" value="<%=order_line_status%>">
								<input type="hidden"  name="dischargeIND<%=recCount%>" id="dischargeIND<%=recCount%>" value="<%=dischargeIND%>">
								<%--<input type="hidden" name="taper_order_yn<%=recCount%>" id="taper_order_yn<%=recCount%>" value="<%=taper_order_yn%>">
								<input type="hidden" name="taper_order_id<%=recCount%>" id="taper_order_id<%=recCount%>" value="<%=taper_order_id%>">
								<input type="hidden" name="taper_order_line_num<%=recCount%>" id="taper_order_line_num<%=recCount%>" value="<%=taper_order_line_num%>"> --%>
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

						if(billing_interface_yn.equals("Y")&& admx_prep_charges_appl_yn.equals("Y")){
							String ItemForAdmixPrepCharges				=  "";
							String mark_up_down					    =	"1";
							store_code	=	bean_1.getStoreCode();
							if(ord_type.equals("IVAA")||ord_type.equals("IVIA")||ord_type.equals("CA")||ord_type.equals("TA")||ord_type.equals("CO")){
								//iv_prep_yn						=   "";
								String calc_groos_pat_payable_admx_prep_charge = "";
								String calc_gross_admx_prep_charge	=	"";	
								admixture_yn							=   "Y";
								StringBuffer gross_charge_display_str =   new StringBuffer();
								if(!ord_type.equals("TA")){
									worksheet_id					= bean_1.getWorksheetID();
								}

								HashMap	AdmxPrepChargeDetails =(HashMap)bean_1.getAdmxPrepChargeDetails(disp_locn_code,worksheet_id,ord_type);
								if(AdmxPrepChargeDetails.size()>0){
									ItemForAdmixPrepCharges			=  (String) AdmxPrepChargeDetails.get("ADMX_PREP_CHARGE_ITEM_CODE");
									mark_up_down						=  (String)AdmxPrepChargeDetails.get("ADMX_PREP_CHARGE_UNITS");
								}
								else{
									//iv_prep_yn						=   bean.getIVFlag(order_id);
									ItemForAdmixPrepCharges			=   bean.getItemForAdmixPrepCharges(iv_prep_yn);
								}
								HashMap charge_det	=	(HashMap)bean.callItemChargeDtls(patient_id,encounter_id,bl_patient_class,ItemForAdmixPrepCharges,1.0,"",sysdate,store_code,"","",order_id,"","",dischargeIND);
								if(charge_det.get("error_msg").equals("")){ 
									decimalFormatString					=(String)charge_det.get("BL_DECIMAL_FORMAT_STRING");
									DecimalFormat dfTest				=   new DecimalFormat(decimalFormatString);

									//if(!charge_det.get("grosschargeamt").equals("null")){ //Commented for ML-BRU-SCF-0368 [IN:034748]
									if(charge_det.get("netchargeamt")!=null && !charge_det.get("netchargeamt").equals("null")){// added ML-BRU-SCF-0368 [IN:034748]
										//gross_admx_prep_charge=dfTest.format( Float.parseFloat((String)charge_det.get("grosschargeamt")));//Commented for ML-BRU-SCF-0368 [IN:034748]
										gross_admx_prep_charge=dfTest.format( Float.parseFloat((String)charge_det.get("netchargeamt")));// added ML-BRU-SCF-0368 [IN:034748]
										calc_gross_admx_prep_charge=dfTest.format( Float.parseFloat(gross_admx_prep_charge)*Float.parseFloat(mark_up_down));
									}
									if(!charge_det.get("patnetamt").equals("null")){
										groos_pat_payable_admx_prep_charge  =dfTest.format( Float.parseFloat((String)charge_det.get("patnetamt"))); 
										calc_groos_pat_payable_admx_prep_charge=dfTest.format( Float.parseFloat(groos_pat_payable_admx_prep_charge)*Float.parseFloat(mark_up_down));
									} 
%>
									<tr>
										<td class="data">&nbsp;</td>
										<td class="data"><label style="cursor:pointer;color:blue" onclick="CallPreparationChargeDetails('<%=gross_admx_prep_charge%>',<%=groos_pat_payable_admx_prep_charge%>,mark_up_down,bl_decimal_format_str,'D')" id="prep_charges"><fmt:message key="ePH.PreparationCharges.label" bundle="${ph_labels}"/>(<%=mark_up_down%>)</label></td>
										<td class="data">&nbsp;</td> <td class="data">&nbsp;</td>
										<td class="data">&nbsp;</td> <td class="data">&nbsp;</td>  <td class="data">&nbsp;</td>
										<td class="data" id="gross_admx_prep_charge_legend">&nbsp;<%=calc_gross_admx_prep_charge%></td>
										<td class="data" id="groos_pat_payable_admx_prep_charge_legend">&nbsp;<%=calc_groos_pat_payable_admx_prep_charge%></td>
										<td class="data">&nbsp;</td> <td class="data">&nbsp;</td>  <td class="data">&nbsp;</td><td class="data">&nbsp;</td>
									</tr>
<%	       
								}
								else{

									gross_admx_prep_charge=(gross_charge_display_str.append("<label style='font-size:9px;color:red' title='").append(charge_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label>")).toString();
									groos_pat_payable_admx_prep_charge=gross_admx_prep_charge;
%>
									<tr>
										<td class="data">&nbsp;</td>  
										<td class="data"><label  id="prep_charges"><fmt:message key="ePH.PreparationCharges.label" bundle="${ph_labels}"/></label></td>
										<td class="data">&nbsp;</td> <td class="data">&nbsp;</td>
										<td class="data">&nbsp;</td> <td class="data">&nbsp;</td>  <td class="data">&nbsp;</td>
										<td class="data" id="gross_admx_prep_charge_legend">&nbsp;<%=gross_admx_prep_charge%></td>
										<td class="data" id="groos_pat_payable_admx_prep_charge_legend">&nbsp;<%=groos_pat_payable_admx_prep_charge%></td>
										<td class="data">&nbsp;</td> <td class="data">&nbsp;</td>  <td class="data">&nbsp;</td><td class="data">&nbsp;</td>
									</tr>
<%	
									gross_admx_prep_charge="0";
									groos_pat_payable_admx_prep_charge="0";
								}	 
							}
%>
				<input type="hidden" name="gross_admx_prep_charge" id="gross_admx_prep_charge" value="<%=gross_admx_prep_charge%>">
				<input type="hidden" name="groos_pat_payable_admx_prep_charge" id="groos_pat_payable_admx_prep_charge" value="<%=groos_pat_payable_admx_prep_charge%>">
				<input type="hidden" name="mark_up_down" id="mark_up_down" value="<%=mark_up_down%>">
				<input type="hidden" name="ItemForAdmixPrepCharges" id="ItemForAdmixPrepCharges"value="<%=ItemForAdmixPrepCharges%>">
				<input type="hidden" name="bl_decimal_format_str" id="bl_decimal_format_str" value="<%=decimalFormatString%>">
<%
			}
%>
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id_1%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name_1%>">
			<input type="hidden" name="bean_id_1" id="bean_id_1" value="<%=bean_id%>">
			<input type="hidden" name="bean_name_1" id="bean_name_1" value="<%=bean_name%>">
			<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>">
			<input type="hidden" name="order_type" id="order_type" value="<%=order_type%>">
			<input type="hidden" name="disp_stage" id="disp_stage" value="<%=disp_stage%>">
			<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
			<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
			<input type="hidden" name="source_code" id="source_code" value="<%=source_code%>">
			<input type="hidden" name="source_type" id="source_type" value="<%=source_type%>">
			<input type="hidden" name="ordering_facility_id" id="ordering_facility_id" value="<%=ordering_facility_id%>">
			<input type="hidden" name="ord_date_time" id="ord_date_time" value="<%=ord_date_time%>">
			<input type="hidden" name="performing_pract_id" id="performing_pract_id" value="<%=performing_pract_id%>">
			<input type="hidden" name="mode" id="mode" value="<%=CommonRepository.getCommonKeyValue( "MODE_MODIFY" )%>">
			<input type="hidden" name="module_id" id="module_id" value="<%=module_id%>">
			<input type="hidden" name="tot_rec" id="tot_rec" value="<%=recCount%>">
			<input type="hidden" name="curr_stage" id="curr_stage" value="<%=disp_stage%>">
			<input type="hidden" name="disp_level" id="disp_level" value="<%=disp_level%>">
			<input type="hidden" name="disp_locn_code" id="disp_locn_code" value="<%=disp_locn_code%>">
			<input type="hidden" name="iv_prep_yn" id="iv_prep_yn" value="<%=iv_prep_yn%>">
			<input type="hidden" name="ord_type" id="ord_type" value="<%=ord_type%>">
			<input type="hidden" name="billing_interface_yn" id="billing_interface_yn" value="<%=billing_interface_yn%>">
			<input type="hidden" name="disp_locn_catg" id="disp_locn_catg" value="<%=disp_locn_catg%>">
			<input type="hidden" name="function_id" id="function_id" value="<%=bean_1.getSFunctionId()%>">
			<input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>">
			<input type="hidden" name="displayGrossAmtYn" id="displayGrossAmtYn" value="<%=displayGrossAmtYn%>"><!-- added for ML-BRU-CRF-0469 -->
			<input type="hidden" name="approval_no_flag" id="approval_no_flag" value="<%=approval_no_flag%>"><!-- AAKH-CRF-0117-->
			<input type="hidden" name="approval_no_app_for_patient_class" id="approval_no_app_for_patient_class" value="<%=approval_no_app_for_patient_class%>">
			<input type="hidden" name="approval_no" id="approval_no" value=""> <!-- AAKH-CRF-0117-->
			<input type="hidden" name="added_by_id" id="added_by_id" value="<%=added_by_id%>"> <!-- MOHE-CRF-0026.1 -->
			<input type="hidden" name="login_at_ws_no" id="login_at_ws_no" value="<%=login_at_ws_no%>"> 
			<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
			<input type="hidden" name="disp_data" id="disp_data" value="<%=disp_data%>"> 
			<input type="hidden" name="authStatus_disp_data" id="authStatus_disp_data" value="<%=authStatus_disp_data%>"> 
			<input type="hidden" name="postDisp_disp_data" id="postDisp_disp_data" value="<%=postDisp_disp_data%>"> 
			<input type="hidden" name="claimId" id="claimId" value="<%=claimId%>"> 
			<input type="hidden" name="response_code" id="response_code" value="<%=response_code%>"> 
			<input type="hidden" name="responseStatus" id="responseStatus" value="<%=responseStatus%>">
			<input type="hidden" name="authReqSent" id="authReqSent" value="<%=authReqSent%>">
			<input type="hidden" name="alloc_qty_check" id="alloc_qty_check" value="<%=alloc_qty_check%>"> 
			<input type="hidden" name="iqvia_integration_flag" id="iqvia_integration_flag" value="<%=iqvia_integration_flag%>"> 
			<input type="hidden" name="postAuthStatusData" id="postAuthStatusData" value="<%=postAuthStatusData%>">
			<input type="hidden" name="authStatusCompleted_yn" id="authStatusCompleted_yn" value="<%=authStatusCompleted_yn%>">   <!-- MOHE-CRF-0026.1 END -->  
			<input type="hidden" name="settlement_id" id="settlement_id" value="<%=settlement_id%>">   
		
			
<%
			if(order_type.equals("TA")){
%>
				<input type="hidden" name="worksheet_id" id="worksheet_id" value="<%=bean_1.getTPNWorksheetID(order_id)%>">
<%
			}
			else{
%>
				<input type="hidden" name="worksheet_id" id="worksheet_id" value="<%=bean_1.getWorksheetID()%>">
<%
			}
			if(billing_interface_yn.equals("Y")){
%>
				<input type="hidden" name="bl_encounter_id" id="bl_encounter_id" value="<%=bl_encounter_id%>">
				<input type="hidden" name="bl_patient_class" id="bl_patient_class" value="<%=bl_patient_class%>">
				<input type="hidden" name="bl_sysdate" id="bl_sysdate" value="<%=sysdate%>">	
				<input type="hidden" name="tot_gross_charge_amount" id="tot_gross_charge_amount" value="<%=tot_gross_charge_amount%>">
				<input type="hidden" name="tot_groos_pat_payable" id="tot_groos_pat_payable" value="<%=tot_groos_pat_payable%>">
				<input type="hidden" name="admx_prep_charges_appl_yn" id="admx_prep_charges_appl_yn" value="<%=admx_prep_charges_appl_yn%>">
				<!-- added for ML-BRU-0469 strt -->
				<%if(displayGrossAmtYn){ %>
				<input type="hidden" name="tot_gross_amount" id="tot_gross_amount" value="<%=tot_gross_amount%>">
				<%} %>
				<!-- added for ML-BRU-0469 end -->
				
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
%>
	</body>
	<script>
		//callLegendsFrame('<%=patient_id%>','D','','','<%=order_id%>');
		callLegendsFrame('<%=patient_id%>','D','','','<%=order_id%>','<%=billing_interface_yn%>','<%=tot_gross_charge_amount_str%>','<%=tot_groos_pat_payable_str%>','<%=admixture_yn%>','','<%=tot_gross_amount_str%>'); // added for ML-BRU-CRF-0469 ,'',tot_gross_amount_str 
	</script>
</html>
<%! 
	DecimalFormat dfToInteger = new DecimalFormat("#.####");
	private String retunFormatedInt(String sValue){
		if(sValue != null && !sValue.equals("")){
			return dfToInteger.format(Double.parseDouble(sValue));
		}
		return "";
	}
%> 
<%
	if(alEditLabelPair.size()==0){	//if block added for ICN-31165
        hmEditLabelValues.put("order_id",order_id);
		hmEditLabelValues.put("pres_drug_code",drug_code);
		hmEditLabelValues.put("drug_code",drug_code);
		hmEditLabelValues.put("order_line_no",order_line_no);
		hmEditLabelValues.put("ord_date_time",ord_date_time);
		hmEditLabelValues.put("drug_name_1",drug_name);
		hmEditLabelValues.put("drug_desc",drug_desc); //Added for Bru-HIMS-CRF-414- ML-BRU-SCF-1454 [IN:052271]
		hmEditLabelValues.put("pres_qty",pres_qty);
		hmEditLabelValues.put("uom",uom);
		hmEditLabelValues.put("alt_drug_flag","N");
		hmEditLabelValues.put("alt_drug_count", "0");  //Added for Bru-HIMS-CRF-414- ML-BRU-SCF-1528 [IN:053217]
		alEditLabelPair.add(hmEditLabelValues);
	}
	bean.setAlEditLabelPairValues(alEditLabelPair);
	medplan_bean.setMedOrderIds(arrOrderId);// Added for Bru-HIMS-CRF-072.1 [IN:049144]
	putObjectInBean(medplan_bean_id,medplan_bean,request);// Added for Bru-HIMS-CRF-072.1 [IN:049144]
	putObjectInBean(param_bean_id,param_bean,request);
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(bean_id_1,bean_1,request);
}
catch(Exception e){
	e.printStackTrace();
}
finally{ // Added for ML-MMOH-SCF-0468 - start
	
	if(con != null)
		ConnectionManager.returnConnection(con,request);	
} // Added for ML-MMOH-crf-0468 end
%>

