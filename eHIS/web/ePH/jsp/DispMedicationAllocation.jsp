<!DOCTYPE html>
<!--
/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.  
 ******************************************************************************/
/* 
------------------------------------------ --------------------------------------------------------------------
Date			Edit History       Name			     Description  
--------------------------------------------------------------------------------------------------------------
?				100					?                created
05/12/2017      [IN:064158]     Devindra    Change in barcode scanning functionality in Dispense Medication(in each scan one quantity need to add).
10/01/2019	  	IN068344	     	Manickavasagam 		  								GHL-CRF-0549 [IN068344] 
05/07/2019      [IN:067952]     Devindra             MMS-KH-CRF-0013 [IN:067952] 
09/08/2019      IN070605		 prathyusha  MMS-KH-CRF-0028 
13/08/2019      IN070451		 Manickavasagam J						ML-MMOH-CRF-1408
26/08/2019      IN071102		 Manickavasagam J						MMS-KH-SCF-0035
30/08/2019	  	IN070894	     	Devindra 		  					ML-MMOH-SCF-1318(RF)
04/09/2019	  	IN070605	     	prathyusha 		   									 MMS-KH-CRF-0028 
10/09/2019	  	IN070605	     	prathyusha 		  									 MMS-KH-CRF-0028 
29/10/2019		IN071533			Shazana								SKR-SCF-1275
1/10/2019		IN071555			Shazana								MMS-ME-SCF-0008
30/11/2019		IN070606                Manickavasagam J                       MMS-KH-CRF-0029[IN070606]
06/02/2020		IN071362                Manickavasagam J                       AAKH-CRF-0117 
29/05/2020		IN:072092	        Manickavasagam J			     GHL-CRF-0618
25/06/2020		IN:072409	        Manickavasagam J			     MMS-CRF-0030	
17/08/2020      IN073688         Prabha                 Medical Item Screen
15/09/2020		IN:073856	        Manickavasagam J			     SKR-SCF-1423	
08/10/2020  		IN074038        	Manickavasagam J                                    ML-BRU-SCF-2049
12/10/2020      IN073397            Prabha     12/10/2020     Manickavasagam J          MOHE-CRF-0032
26/10/2020      IN074250         Prabha		 26/10/2020     Manickavasagam J          ML-MMOH-SCF-1634
29/10/2020      IN074206                      Manickavasagam J          ML-MMOH-SCF-1627
03/11/2020		IN:074297	        Manickavasagam J			     GHL-SCF-1527
18/11/2020		TFS:6608	        Manickavasagam J			     ML-BRU-SCF-2055
30/11/2020		8659			Shazana				MMS-MD-SCF-0141 	
17/12/2020		TFS:10221	        Manickavasagam J			     ML-BRU-SCF-2055.2
23/04/2021      TFS-17291         Prabha		 23/04/2021     Manickavasagam J          SKR-SCF-1593
15/4/2022		TFS25857		Shazana												SKR-SCF-1646
15/4/2022		TFS25858		Shazana												SKR-SCF-1647
---------------------------------------------------------------------------------------------------------------
*/ --> 
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8"import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.text.DecimalFormat,eST.*,eST.Common.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
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
       TD.EXPIRED_ORDER{    /* Added for MOHE-CRF-0032 */
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
	<script>//Adding start for TH-KW-CRF-0008
			window.onload = function(){
				window.setInterval("blinkImage()",500);
				window.setInterval("blinkPatExp()",500);
			}
</script><!-- Adding end for TH-KW-CRF-0008 -->

		<form name="DispMedicationAllStages" id="DispMedicationAllStages" >
<%      
        Connection con			= null;  // Added for ML-MMOH-SCF-0356.1 - start
		try{
        con				= ConnectionManager.getConnection(request);
        boolean complete_ord_yn = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","COMPLETE_ORD_YN");// Added for ML-MMOH-SCF-0356.1 - End
     	boolean displayGrossAmtYn = eCommon.Common.CommonBean.isSiteSpecific(con, "PH", "GROSS_AMT_DISPLY_YN");// Added for ML-BRU-CRF-0469 
			boolean item_type_site_app = eCommon.Common.CommonBean.isSiteSpecific(con, "PH", "ITEM_TYPE_APP");//added for GHL-CRF-0549
			boolean formulary_billing_app = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","FORMULARY_BLG_GRP_APP"); //GHL-CRF-0618
			boolean intractn_req_yn = CommonBean.isSiteSpecific(con, "PH","DISP_STAGE_INTRACTN_REQ_YN");	// Added for MMS-KH-CRF-0013 
			 boolean approval_no_flag = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","APPROVAL_NO_APPLICABLE_FLAG");//AAKH-CRF-0117 
			//boolean approval_flag = false;//AAKH-CRF-0117	and commented for CRF-0117		 
			boolean barcode_scan_for_alt_app = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","BARCODE_SCAN_FOR_ALT_APP"); //MMS-KH-CRF-0030
			boolean expired_order = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","EXPIRY_ORDER_APP"); //Added for MOHE-CRF-0032
			boolean drug_abuse_appl=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DRUG_ABUSE_APPL");//added for AAKH-CRF-0140
		boolean aggred_item_app = eCommon.Common.CommonBean.isSiteSpecific(con, "PH", "AGGRED_ITEM_APP");//added for MMS-DM-CRF-0209.1
		boolean site_remarks=eCommon.Common.CommonBean.isSiteSpecific(con, "PH", "DISP_REMARKS");//added for ML-MMOH-CRF-1755
    	String	bean_id				=	"DispMedicationAllStages" ;
			String	bean_name			=	"ePH.DispMedicationAllStages";
			
			DispMedicationAllStages bean = (DispMedicationAllStages)getBeanObject( bean_id, bean_name,request);
			bean.setLanguageId(locale);
			
			bean.loadReason();
			bean.setModuleId("2");

			String	bean_id_1		    =	"DispMedicationBean" ;
			String	bean_name_1		    =	"ePH.DispMedicationBean";
			String bl_install_yn		    =	 CommonBean.checkForNull((String) session.getValue( "bl_operational" ),"N") ;//GHL-CRF-0549
			
			DispMedicationBean bean_1	= (DispMedicationBean)getBeanObject( bean_id_1 , bean_name_1,request);
			bean_1.setLanguageId(locale);
			bean_1.setObject(bean);
			String medplan_bean_id="MedicationPlannerBean";// Added for Bru-HIMS-CRF-072.1[IN 049144]
			String medplan_bean_name="ePH.MedicationPlannerBean";// Added for Bru-HIMS-CRF-072.1[IN 049144]
			MedicationPlannerBean medplan_bean = (MedicationPlannerBean)getBeanObject( medplan_bean_id, medplan_bean_name,request);// Added for Bru-HIMS-CRF-072.1[IN 049144]
			bean_1.setObject(medplan_bean);// Added for Bru-HIMS-CRF-072.1[IN 049144]

			String facility_id					= (String) session.getValue("facility_id");
			String param_bean_id				= "@DrugInterfaceControlBean";
			String param_bean_name				= "ePH.DrugInterfaceControlBean";
			DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
			String drug_db_interface_yn			= param_bean.getDrugDBInterface_yn(facility_id); 
			param_bean.clear();

			String Image_bean_id				= "@DrugTradeImageBean";
			String Image_bean_name				= "ePH.DrugTradeImageBean";
			DrugTradeImageBean drug_trade_bean	= (DrugTradeImageBean)getBeanObject( Image_bean_id, Image_bean_name, request );
			/** Stock Bean Integration -Start ***/
			String	bean_id_2		=	"StUtilities" ;
			String	bean_name_2		=	"eST.Common.StUtilities";
			StUtilities bean_2=null;
			String sDispDrugAuthYN				= "N";
			String alt_drug_flag      ="N";
			String stSalseBean_id				=    "salesBean";//Added for AMS-CRF-0068.1 [IN:050333] start
			String stSalseBean_name			    =    "eST.SalesBean";
			SalesBean stSalseBean				=	(SalesBean)getBeanObject( "salesBean", "eST.SalesBean", request );//Added for AMS-CRF-0068.1 [IN:050333] -end
			String medical_applicable="";//added for ghl-crf-0548
			//changed during PE By Naveen
			//String strIncludeZeroQty = bean_1.getStrIncludeZeroAllocQtyItems()==null?"N":bean_1.getStrIncludeZeroAllocQtyItems();
			String strIncludeZeroQty    = bean_1.getStrIncludeZeroAllocQtyItems();
			String allow_amend_alt_drug_dtl     =   bean_1.getAmendAltDrugDtlYN();  // Added for JD-CRF-0198 [IN058599]
			String strAutoCompletePartialDisp	= 	bean_1.getAutoCompletePartialDisp(); 	// Added for JD-CRF-0179 [IN:41211]
			String loc_lang_id = medplan_bean.getStrLocalLangID();//Added for Bru-HIMS-CRF-072.1[IN 049144]
			String primary_lang_id = medplan_bean.getStrPrimaryLangID();//Added for Bru-HIMS-CRF-072.1[IN 049144]
			String Disp_drug_verify_remarks  =bean_1.getDisp_drug_verify_remarks_yn();//added for ml-mmoh-crf-1755
					try{ 
				bean_2 = (StUtilities) getBeanObject( bean_id_2,  bean_name_2, request );
				bean_2.setLanguageId(locale);
			}
			catch(Exception exception){
				exception.printStackTrace();
			}
			String st_no_of_decimals ="",  st_disp_decimal_dtls_yn="", st_allow_decimals_yn="N"; //  Added for AAKH-SCF-0113 [IN:048937] 
			st_no_of_decimals = bean.getSt_no_of_decimals(); //  Added for AAKH-SCF-0113 [IN:048937] 
			st_disp_decimal_dtls_yn =bean.getSt_disp_decimal_dtls_yn(); //  Added for AAKH-SCF-0113 [IN:048937] 
			String display_list = "";
			String disp_locn_catg	=	bean_1.getDispLocnCatg();
			String patient_class	=	"";

			boolean bPatientPaid	=  false;

			ArrayList	stk_units	=	new ArrayList();
			String orig_dflt_issue_uom		= "";

			String strAllocBMSChkValue = "N";
			String strAllocBMSChecked = "";

			ArrayList alEditLabelPair			= new ArrayList();
			HashMap hmEditLabelValues			= new HashMap();
			boolean bEditLabelEnabled			= false;
			ArrayList listRecord				= new ArrayList();  // Added for KAUH-SCF-0094 [IN:035252] -- begin
			String	bean_id_st		   			= "batchSearchBean" ;
			String	bean_name_st		   		= "eST.BatchSearchBean"; 
			request.setAttribute("p_list_all_trades_yn","Y");
			BatchSearchBean bean_st				= (BatchSearchBean) getBeanObject( bean_id_st,bean_name_st,request );
			bean_st.setLanguageId(locale); 		// Added for KAUH-SCF-0094 [IN:035252] -- end

			String barcode_id = "";//Added for KDAH-CRF-0231 [IN-034551]
					
			if(disp_locn_catg.equals("I")) {
				patient_class	=	"IP";
			} else {
				patient_class	=	"OP";
			}
			String tpn_wrksheet_rcrd	= "N";
			String tpn_finalize = request.getParameter("TPN_FINALIZE");
			if(tpn_finalize==null)tpn_finalize = "";
			if(tpn_finalize.equals("YES")){
				bean_1.setWsStatus("C");
				tpn_wrksheet_rcrd	= "Y";
			}
			else if(tpn_finalize.equals("NO")){
				bean_1.setWsStatus("I");
				tpn_wrksheet_rcrd	= "N";
			}

				//added for AAKH-CRF-0117 - start
			String approval_no_app_for_patient_class = "N";
			if(approval_no_flag){
			   approval_no_app_for_patient_class = bean.getApprovalNoApplicableForPatientClass(patient_class);
			}
			//added for AAKH-CRF-0117 - end
			String allocate_status			= bean_1.getAllocatedStatus();
			Hashtable param_legends			= bean_1.getLegendsFromParam();
			String disp_stage				= bean_1.getDispStage();
			String disp_locn_code			= bean_1.getDispLocnCode();
			String order_type				= bean_1.getOrderType();
			String legend					=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.CompleteOrderReason.label","ph_labels"); //"Complete Order Reason";
			String scope					= bean_1.getScope();
			String legend1					= "";
			String legend_text				= "";
			String complete_order_value		= "";
			String complete_order_checked	= "";
			String disable_complete_order	= "";
			String pat_reqd					="";
			String pt_couns_reqd_yn			="";
			String dischargeIND				="";
			String strBMS_Include_yn ="N";// Added for [IN:045295]
			boolean bKeepQty				= false;
			ArrayList disp_info			=	new ArrayList(2);
			int adr_count					=  0;
			double ws_tot_qty				= 0;
			float tot_tap=0; //Added for RUT-CRF-0088 [IN036978]
			StringBuffer drugs_remarks  = null ;//Bru-HIMS-CRF-416[IN045566] 
			String strDrugsRemarks="";//Bru-HIMS-CRF-416[IN045566] 
			String order_line_status = "";   // Added for JD-CRF-198
			String pres_strength_1        = ""; //MMS-KH-CRF-0030
			String pat_paid_amt	,pat_net_charge_amt; //Added FOR ML-BRU-SCF-1281 [IN:047783] -ISSUE 1
			if(bean_1.getBarcode_Scan_YN()!=null && bean_1.getBarcode_Scan_YN().equals("Y")){// if block added for KDAH-CRF-0231 [IN-034551]
				bean_1.getBarCodeflg(facility_id,disp_locn_code);
			}
			if(scope.equals("H")){
				legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ResultLineStatus.label","ph_labels");//"ResultLineStatus";
			}
			String disable_all  ="";
			 if(((disp_stage.equals("F") && (bean_1.getFillingStatus().equals("A")  ))|| (disp_stage.equals("A") && (bean_1.getFillingStatus().equals("B")  )))&&(!disp_locn_catg.equals("I")) ){
				 
				 bKeepQty = bean_1.getEditValues(); // This value should be used to load the qty values frm database if allocation is in second stage.
				if(!bKeepQty){
					 disable_all ="disabled";
					 display_list="display:none";
				}		 
			}

			String patient_id			= request.getParameter("patient_id");
			String encounter_id			= bean_1.getEncounterID();
			String order_id				= request.getParameter("order_id");
			String alt_drug_qty			= "";
			if (order_id==null){
				order_id	=	"";
			}	
			
			if (patient_id==null){
				patient_id	=	"";
			}
			String bean_id2					= "@PrescriptionBean_1"+patient_id+encounter_id; // Added for MMS-KH-CRF-0013 - Start
            String bean_name2		= "ePH.PrescriptionBean_1"; 
            PrescriptionBean_1 pres_bean =  (PrescriptionBean_1)getBeanObject( bean_id2,bean_name2,request) ;
            pres_bean.setLanguageId(locale); // Added for MMS-KH-CRF-0013 - End
			//Declaration starts
			String order_line_no		=	"";
			String drug_code			=	"";
			String drug_name			=	"";
			String dosage_dtls			=	"";
			String end_date				=	"";
			String start_date           =   ""; // Added for MMS-KH-CRF-0013
			String pres_qty				=	"";
			String qty_uom				=	"";
			String alt_drug_code		=	"";
			String alt_drug_desc		=	"";
			String drug_color			=	"";
			String form_code			=	"";
			String form_desc            = ""; // Added for MMS-KH-CRF-0013
			String hold_status			=	"";
			String remark_status		=	"";
			String uom					=	"";
			String check_status			=	"";
			HashMap pack_dtls			=	null;
			String title_remarks		=	"";
			String tmp_bms_qty			=	"";
			String title				=	"";
			String pres_details			=	"";
			String pat_couns_reqd_yn	=	"";
			int bmscount                =    0;
			String visibility1			=	"";
			String visibility2			=	"";
			String strChangedFludRmks	=	"";
		//code added for drug remarks
			String drug_remarks			=	"";
			String prn_remarks			=	"";
			String pharma_remarks		=	"";		
			String pres_remarks			=	"";
			String slidingscaleremarks	=   "";
			String verificationremarks	=	"";
			String remarks_style		=	"";	
			float dialog_height			=	0;
			String admixture_yn			=  "N";
			String qty_uom_disp			=  "N";
			String strength_uom_disp	=  "N";
			//ends here
			String currentdateplusAllocatePeriod		=  	"";			//added by Ganga for ML-BRU-SCF-0905 [IN:041285]
			boolean	endDateIsbeforAllocatedate			= 	false;//added by Ganga for ML-BRU-SCF-0905 [IN:041285]
			String home_med_yn = null;//Added for Bru-HIMS-CRF-093-DD1[IN047223]
			String drug_desc = "";//Added for Bru-HIMS-CRF-414 ML-BRU-SCF-1454 [IN:052271]
			String disc_cancelled_orders="", appl_for_compounding_rx_yn="",  disc_cancelled_orders_display="display:none;", disp_mnf_flag= "display:none"; //Added for HSA-CRF-0138 [IN:048414] & Bru-HIMS-CRF-080
			String showZeroQtyCheckBox = "";
			String showOtherEditLables = "";
			String abuse_drug_override_reason="";//added for aakh-crf-0140  drug_abuse_appl
			String abuse_exists="";//added for aakh-crf-0140
			String drugIndication="";//added for jd-crf-0220		
			String drug_expiry_alert ="";//Added for TH-Kw-CRF-0008
			String drug_expiry_days  = "";//Added for TH-KW-CRF-0008
			String insurance_status ="";//Added for TH-KW-CRF-0012
			HashMap insuranceStatus = bean.getInsuranceStatus();//Added for TH-KW-CRF-0012
			String	category_code="";//added for mms-dm-crf-209.1
      String	alternate_yn="";//added for mms-dm-crf-209.1
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
			String FillingStatus=bean_1.getFillingStatus();
			
			boolean min_stk	= false;
			boolean rol_stk	= false;
			HashMap rol_min		= null;
			String frm_store_min_stk_level  = "";
			String frm_store_reorder_level =  "";
			String[] stParameters = {"", "", "0", "N", "", "N", "" };
			HashMap hmStockAvailabilityStatus = null;
			boolean Min_Rol_yn	=bean_1.getMin_Rol_yn();
			boolean getReq_allowed_yn =bean_1.getReq_allowed_yn(); //Added for AMS-CRF-0068.1 [IN:050333] -end

			ArrayList result		=	null;
			ArrayList orderLineDtls	=	new ArrayList();
			//Declaration ends

			String disp_level	= bean_1.getDispLevelValue();
			String disp_catg	= bean_1.getDispLocnCatg();

			ArrayList alOrderIds = new ArrayList();
			ArrayList tmpResult = new ArrayList();
			
			String iv_prep_yn = "";	
			if(bean_1.getAlTrxOrderIds()!=null){
				alOrderIds = bean_1.getAlTrxOrderIds();
				if(alOrderIds != null && alOrderIds.size()>0){
					iv_prep_yn		=   bean.getIVFlag(alOrderIds.get(0).toString());
					iv_prep_yn		=	iv_prep_yn==null?"":iv_prep_yn;
					bean_1.setWsType(iv_prep_yn);
				}
			}
			if(disp_level.equals("P")) {
				// criteria is patient wise		
				//order lines of all orders
				result			= bean_1.getOrders(patient_id.trim());
				if(bean_1.getOrderType()!=null && (bean_1.getCriteriaOrderType().equals("ALL") || bean_1.getCriteriaOrderType().equals("CDR"))){ // CDR Condition Added for ML-MMOH-CRF-0435 [IN:057357]
					if(alOrderIds.size()>0){
						for(int i=0;i<result.size();i=i+11) {		//10 ->11  for SKR-SCF-0330 ICN 29789 //11->13 RUT-CRF-0069 ICN29607  //Modified for RUT-CRF-0088 [IN036978]  13 ->11
							if(alOrderIds.contains(result.get(i+1))){
								for(int j=i;j< i+11;j++)		//10 ->11 for SKR-SCF-0330 ICN 29789 //11->13 RUT-CRF-0069 ICN29607 //Modified for RUT-CRF-0088 [IN036978]  13 ->11
									tmpResult.add(result.get(j));
							}
						}
					}
					result = tmpResult;
				}
				ArrayList tmp	=	new ArrayList();
				for(int i=0;i<result.size();i=i+11) {		//10 ->11 for SKR-SCF-0330 ICN 29789 //11->13 RUT-CRF-0069 ICN29607  //Modified for RUT-CRF-0088 [IN036978]  13 ->11
					tmp = (ArrayList)bean_1.getOrderLineDetails(patient_id,(String)result.get(i+1));
					if(tmp.size()!=0) {
						orderLineDtls.add((String)result.get(i+1));
						orderLineDtls.add((String)result.get(i+3));
						orderLineDtls.add((String)result.get(i+4));
					
					for(int j=0; j<tmp.size(); j++)
						orderLineDtls.add(tmp.get(j));
					}
				}
			} 
			else {// criteria is order wise
				orderLineDtls = (ArrayList)bean_1.getOrderLineDetails(patient_id,order_id);
			}
			String ws_type				=   bean_1.getWsType()==null?"": bean_1.getWsType();
			String allergy				=	"";
			String exceed_dose			=	"";
			String generic_id			=	"";
			String generic_name			=	"";
			String dosage_details		=	"";
			String exceed_status		=	"";
			String monograph			=	"";
			String dosage_type			=	"";
			String dosage_unit			=	"";
			String std_dose             =   "";
			String unit_dose			=	"";
			String daily_dose			=	"";
			String bms_qty				=	"";
			String source_code			=	"";
			String source_type			=	"";
			String ordering_facility_id =	"";
			String ord_date_time		=	"";
			String performing_pract_id	=   "";
			String duplicate_yn			=	"";
			String min_dose_dtls		=	"";
			String min_unit_dose		=	"";
			String min_daily_dose		=	"";
			String alloc_qty_from_tmp	=	"";
			String strength_uom			=	"";
			String strength_value		=	"";
			String module_id			=	bean.getModuleId(); 
			ArrayList stock_opt			=	new ArrayList();
			double	tot_qty				=	0;
			String image				=	"";
			//code added for in_formulary....drugs..
			String in_formulary_yn		=	"";
			String drug_class			=	"";
			String expired_yn			=	"";
			String ext_prod_id			=	"";
			ArrayList complete_reason_codes		=  (ArrayList)bean.getCompleteReasonCodes();
			String disp_delivery_chk_box_val	=   "Y";
			String billing_interface_yn			=   bean.getBLInterfaceYN();// checkforbillinginterface();
			String width						=   "100%";
			String bl_encounter_id				=	bean_1.getEncounterID();
			String bl_patient_class				=   "";
			String bl_display                   =   "Y"; 
			String ord_type						=	bean_1.getOrderType();
			String sysdate						=   bean_1.getTodaysDate();
			String gross_admx_prep_charge		=	"";
			String groos_pat_payable_admx_prep_charge	=	"";
			//added during PE By Naveen
			String drug_db_product_id				=	"";
			String allergy_override_reason			=	"";
			String dosage_limit_override_reason		=	"";
			String duplicate_drug_override_reason	=	"";
			String interaction_override_reason		=	"";
			String contraind_override_reason		=	"";	
			String food_interaction_override_reason =   "";//MMS-KH-CRF-0029
			String lab_interaction_override_reason =   ""; //MMS-KH-CRF-0029
			String disease_inter_override_reason =   "";//Added for MMS-DM-CRF-0229
			//ends here
			boolean bEquivalentNormalOrder		= false;
			if(ord_type.equals("ALL") && result != null && result.size() >0 && result.get(8) == null)
				bEquivalentNormalOrder = true;
			if(!((ord_type.equals("NOR") || bEquivalentNormalOrder) && bean_1.getIssueByUOM().equals("I"))  ){
				display_list ="display:none" ;
			}
			float tot_gross_charge_amount		=   0;
			float tot_groos_pat_payable			=   0; 
			float  tot_gross_amount             =   0; // added for ML-BRU-CRF-0469
			String tot_gross_charge_amount_str	=  "";
			String tot_groos_pat_payable_str	=  "";
			String tot_gross_amount_str         =  "";	// added for ML-BRU-CRF-0469
			String gross_charge_amount_str		=  "";
			String groos_pat_payable_str		=  "";
			String gross_amount_str             =  ""; //added for ML-BRU-CRF-0469
			String decimalFormatString			=  "";
			String	batch_str					=  "";
			String image_path					=  "";
			String trade_code					=  "";
			HashMap batch_data=new HashMap();//Added for KAIH-SCF-0094[Inc:35252]
			ArrayList temp=  new ArrayList();//Added for KAIH-SCF-0094[Inc:35252]
			String worksheet_id					=  bean_1.getWorksheetID();
			String admx_prep_charges_appl_yn    =  bean_1.getadmx_prep_charges_appl_yn();
			/*=================code for auto defaulting batches for normal RX===============*/
			ArrayList items						=	null;
			ArrayList alloc_drug_detail			=	null;
			HashMap batch_det					=	null;	
			ArrayList stock_det					=	null;
			HashMap	 stock						=	null;	
			String item_code					=	"";
			String store_code					=	"";
			String fill_period					=	null;
			String fill_unit					=	null;
			String item_cost					=   "";
			String issue_qty					=	"";
			double tmp_unit_qty					=	0;
			double tot_issued_qty				=	0;
			String avail_qty					=	"";
			String act_bms_qty					=	"";
			float opdispperiod					=	0;	
			String alloc_readonly				=   "";
			String billable_item_yn				=	"";
			String alt_drug_remarks_ind =  bean_1.getAltDrugRemarksInd(); //added for  Bru-HIMS-CRF-082 [IN:029948]
			String alt_drug_remarks_disp = ""; //added for  Bru-HIMS-CRF-082 [IN:029948]
			HashMap taperValues = null; //Added for RUT-CRF-0088 [IN036978]
			String totalTaperQtyDisplay = bean_1.getTotalTaperQtyDisplay();//Added for RUT-CRF-0088 [IN036978]
			String includeBMSDefCheck_yn= bean_1.getIncludeBMSDefCheck();//added for [IN:045055](Bru-HIMS-CRF-281[IN:033166])
			int count = 0;
			if(ord_type.equals("TA")){
					bl_display                   ="N";        
			}
			if(billing_interface_yn.equals("Y")&& bl_display.equals("Y")){	
				 width="120%"; 
				 bl_patient_class  =   bean.getEncounterPatientClass(bl_encounter_id, patient_id);  // patient_id  added for [IN:035667] 
			}
			if(!order_type.equals("TA")){	
				if(((bean_1.getHTWSAllocateBatches()).size()==0)&&(!worksheet_id.equals(""))){
					bean_1.setWSDrugDetails(order_id,worksheet_id);
					bean_1.setWSBatchDetails(order_id);
				}
			}
			String pres_qty_alert = bean_1.getPresQtyAlert();//code added for AMS-CRF-0035[IN033551]					
			String barcodeScan = ""; // Added for GHL-CRF-0463 - Start
			String last_scanned ="";
			if(bean_1.getBarcode_id().equals("") && bean_1.getOrderType().equals("NOR")){
			   barcodeScan=bean_1.getBarcode_Scan_YN();
			  // last_scanned = bean_1.getScannedBarcode_id();//removed for mms-dm-scf-0488
			}// Added for GHL-CRF-0463 - End
%>
			<input type="hidden" name="alloc_fromBarCode" id="alloc_fromBarCode" value="N"> <!-- added for KDAH-CRF-0231 [IN-034551]  -->
			<input type="hidden" id="barcode_scan_yn" value="<%=barcodeScan%>"> <!-- Added for GHL-CRF-0463 -->
		<!--	<input type="hidden" id="last_scanned" value="<%=last_scanned%>">  Added for GHL-CRF-0463  removed for mms-dm-scf-0488-->
			<table cellpadding="0" cellspacing="0" width='<%=width%>'align="center" border="1" id="allocationTable">
				<tr>
					<%	                if(intractn_req_yn && order_type.equals("NOR")){ //Added for MMS-KH-CRF-0028 [IN070605] - Start
%>
                              <td class= "COLUMNHEADER" width="4%" style="font-size:9px"><fmt:message key="Common.Select.label" bundle="${common_labels}"/>
							  <input type="checkbox" value="Y" name="selectAll" id="selectAll" checked onClick="selectAllRcordsDeliver(this,'<%=disp_stage%>')" ><!--MMS-KH-CRF-0016.1-->
							 </td>
<%					
                    } //Added for MMS-KH-CRF-0028 [IN070605] - End
					else{
                    %>
					<td class= "COLUMNHEADER" width="4%" style="font-size:9px">Print</td><!-- GHL-CRF-0453-->
					<%
					}%>
					<td class= "COLUMNHEADER"   width="10%" style="font-size:9px"><%=param_legends.get("V")%> <fmt:message key="Common.status.label" bundle="${common_labels}"/></td> <!-- 6% changed to 10% for MMS-KH-CRF-0013 -->
					<td class= "COLUMNHEADER" width="3%" style="font-size:9px" nowrap>&nbsp;</td>
<%					if(bl_install_yn.equals("Y") && !iv_prep_yn.equals("7") && !iv_prep_yn.equals("8") && item_type_site_app && !encounter_id.equals("")){	//GHL-CRF-0549
%>
					<td width="5%" class= "COLUMNHEADER" style="font-size:9px" nowrap><fmt:message key="ePH.ItemType.label" bundle="${ph_labels}"/></td>
					<%
					if(formulary_billing_app){	//GHL-CRF-0618
					%>
					<td  class="COLUMNHEADER" width="2%"  style="font-size:9px" >&nbsp;</td><!-- added for GHL-CRF-0618 -->
					<%}	 

					} %>
					<!-- added for mms-dm-crf-0209.1 start -->
					<%if(aggred_item_app){%>
					<td class= "COLUMNHEADER" style="font-size:9px" width="2%">&nbsp;</td>
					<%} %>
					<!-- added for mms-dm-crf-0209.1 end -->
					<td class= "COLUMNHEADER"width="30%" style="font-size:9px"><fmt:message key="ePH.Drug/DosageDetails.label" bundle="${ph_labels}"/></td>
					<td class= "COLUMNHEADER" style="font-size:9px" width="3%">&nbsp;</td>
					<td class= "COLUMNHEADER" style="font-size:9px" width="3%">&nbsp;</td>
					<td class= "COLUMNHEADER" width="10%" style="font-size:9px"><fmt:message key="ePH.PrescribedQuantity.label" bundle="${ph_labels}"/></td>
					<td align="right" class="COLUMNHEADER" width="10%" style='<%=display_list%>'><fmt:message key="ePH.ISSUEUOM.label" bundle="${ph_labels}"/>&nbsp;</td>
					<td class= "COLUMNHEADER" width="10%" style="font-size:9px"><%=param_legends.get("A")%> <fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
					<td class= "COLUMNHEADER" width="10%" style="font-size:9px"><fmt:message key="ePH.BalanceQuantity.label" bundle="${ph_labels}"/></td>
<% 
					if(billing_interface_yn.equals("Y") && bl_display.equals("Y")){
%>
                       <%if(bean.getDisplayInsStatus()){ %><!-- //Added for TH-KW-CRF-0012 -->
                        <td class= "COLUMNHEADER" width="10%" style="font-size:9px"><fmt:message key="Common.Insurance.label" bundle="${common_labels}"/> <fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
						<% } %>
                       <!-- Added for ML-BRU-CRF-0469 start -->
                       <%if(displayGrossAmtYn){%> 
                       <td class= "COLUMNHEADER" width="8%" style="font-size:9px"><fmt:message key="ePH.GrossAmount.label" bundle="${ph_labels}"/></td>
					    <%}%> 
					  <!-- Added for ML-BRU-CRF-0469 end --> 
						<td class= "COLUMNHEADER" width="10%" style="font-size:9px"><fmt:message key="Common.ChargeAmount.label" bundle="${common_labels}"/></td>
						<td class= "COLUMNHEADER" width="10%" style="font-size:9px"><fmt:message key="ePH.PayableAmount.label" bundle="${ph_labels}"/></td>
						<td class= "COLUMNHEADER" width="10%" style="font-size:9px"><fmt:message key="ePH.OverrideIncl/Excl.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td> 
<%
					}
%>
					<td class= "COLUMNHEADER" width="10%" style="font-size:9px"><%=param_legends.get("A")%>&nbsp'<fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
					<td class= "COLUMNHEADER" width="15%" style="font-size:9px"><%=legend%></td>
					<%if(approval_no_flag){ //added for AAKH-CRF-0117 
					%>
					<td class= "COLUMNHEADER" width="15%" style="font-size:9px"> <fmt:message key="ePH.ApprovalNo.label" bundle="${ph_labels}"/> &nbsp;&nbsp;&nbsp;&nbsp;</td>
					<%} %>
				</tr>
<%
				String classvalue		    =	"";
				String strength			    =	"";
				String pres_strength	    =	"";
				String alt_strength_value	=	"";
				String alloc_strength		=	"";
				String bms_strength			=	"";
				String 	hold_text		    = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Hold.label","ph_labels");
				String check_value          =   "N";
				String fromdb               =   "N";
				String narc_style			=	"";
				float main_pack_size		=   0;
				String tmp_bms_qty_1		=	"";
				float main_drug_pack_size   =	0;
				String main_strength_per_value_pres_uom ="";
				HashMap IssueUOMAndBaseUOM       = new HashMap();
				HashMap IssueUomQty			     = new HashMap();
				String issue_qty_value		     = "";	  
				String issue_uom_desc            = ""; 
				String dflt_issue_uom		     = "";
				String base_uom				     = "";
				String issue_uom			     = "";
				String issue_uom_equl            = "";
				double base_to_disp_uom_equl     = 0;
				double base_to_def_uom_equl      = 1;
				double issue_qty_val			 = 0;
				double conv_factor				 = 1;
				StringBuffer issue_qty_dtl       = new StringBuffer();
				boolean item_uom_definition_flag = false;
				String zero_alloc_qty_item_yn    = "N";
				String sOrderTypeFromResult      = "";
				int recCount					=	1;
				double tmp_alloc				=	0;
				int iOrderTypeCount				=	0;
				String sRepeatFreqCode		    = null;
				String sFreqCode			    = null;
				boolean bPRNOrAbsOrder		    = false;
				boolean	bDrugOrder				= true;
				Set stDrugCodes					= new HashSet();
				String disable_alloc_text_box   = "";
				HashMap OrderIDS                = new HashMap();
				//String taper_order_yn, taper_order_id, taper_order_line_num, show_remarks, taper_disable;  // Commented for RUT-CRF-0088 [IN036978]
				String show_remarks, taper_disable;  //Added for RUT-CRF-0088 [IN036978]  
				HashMap Order_id_amend_yn = null;
				Hashtable ht_ws_allocated_batches = null;
				Hashtable ht_ws_alloc_qty = null;
				Hashtable ht_drug_details = null;
				String alt_drug ="", ws_item_code="", ws_drug_code="", sOrderType, sAbsOrder, nar_cnt_drug, qty, sOrigDispUnit, sOrigDispPeriod, taper ; 
				String qty_avail_from_spillage = "0";
				StringTokenizer st = null; 
				StringTokenizer dose = null; 
				StringTokenizer min_dose = null; 
				ArrayList multi_drugs = null;
				HashMap hm= null;
				HashMap issue_uom_qty_hm = null;
				ArrayList alValues = null;
				HashMap hmUOMValues = null; 
				String stk_unit_code	= "";
				String stk_unit_desc	= "";
				String stk_equval_value	= "";
				String act_stk_equval_value	= "";

				String base_to_def_uom_equl_val  ="1";
				String base_to_disp_uom_equl_val ="1";
				int	k	=	0;
				ArrayList alt_qty	=	new ArrayList();
				String 	drug_name_1=  ""; 
				String alt_external_prod_id ="";
				LinkedHashMap hsh_med_plan = new LinkedHashMap();// Added for Bru-HIMS-CRF-072.1 [IN:049144]
				ArrayList arrOrderId = new ArrayList();// Added for Bru-HIMS-CRF-072.1 [IN:049144]
				HashMap<String,String> altDrugName = new HashMap<String,String>();// Added for Bru-HIMS-CRF-072.1 [IN:049144]
				String dosedet[] = new String[4],dosedetlocal[] = new String[4];// Added for Bru-HIMS-CRF-072.1 [IN:049144]
				String dispno[] = new String[2];// Added for Bru-HIMS-CRF-072.1 [IN:049144]
				HashMap printValue = bean_1.getPrintValue(); //GHL-CRF-453
				String print_value = "";//GHL-CRF-453
				//GHL-CRF-0549 - start
				String bl_grp_app	  = "";

				String mm_item_low_cost_yn = "";	
				String mm_item_high_margin_yn = "";
				String mm_item_Innovator_yn = "";
				boolean matched_entry_flow = false;
				String low_cost_green_style ="visibility:none";
				String high_margin_green_style ="visibility:none";
				String high_margin_red_style   ="visibility:none";
				String low_cost_red_style	="visibility:none";
				String low_cost_grey_style ="visibility:none";
				String high_margin_grey_style ="visibility:none";
				String innovator_style		="visibility:none";
				String item_type = "";
				String dose_unit_desc="";//added for ML-MMOH-CRF-1408
				String ceil_dose_unit_desc = "";//added for ML-MMOH-CRF-1408
				ArrayList celling_dose = null;//added for ML-MMOH-CRF-1408
				String min_unit_ceiling_dose = "", max_unit_ceiling_dose = "", min_daily_ceiling_dose = "", max_daily_ceiling_dose = ""; //added for ML-MMOH-CRF-1408
				String allow_alternate_yn="";//added for mms-kh-crf-0028
	            String expiry_date="";//added for mms-kh-crf-0028
				String alt_called_from="";//added for MMS-KH-CRF-0028
				String approval_no_style = "visibility:hidden"; //AAKH-CRF-0117
				String issue_token_on_regn_YN = bean_1.getIssueTokenOnRegnYN(); //ML-BRU-SCF-2049 & ML-BRU-SCF-2055
				if(item_type_site_app && !encounter_id.equals(""))
				bl_grp_app = bean.getItemTypeApp(patient_id);
				//GHL-CRF-0549 - end		
				if(bl_grp_app==null || bl_grp_app.equals(""))
					bl_grp_app = "N";
				HashMap lab_food_interaction =null;//added for MMS-KH-CRF-0029
				HashMap approvalNo = bean_1.getApprovalNo();//AAKH-CRF-0117
			 String approval_no="";//AAKH-CRF-0117
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
					disp_delivery_chk_box_val = "Y";
					strength			=	"";	
					hold_status			=	"";
					pres_strength		=	"";
					tot_qty				=	0;
					stock_opt			=	new ArrayList();
					image				=	"";
					alloc_strength		=	"";
					tmp_alloc			=	0;
					title_remarks		=	"";
					title				=	"";
					narc_style			=	"";
					pres_details		=	"";
					main_drug_pack_size	=    0;
					strAllocBMSChecked   ="";
					disable_complete_order	=	""; 
					//added for ML-MMOH-CRF-1408 - start
						celling_dose			= null;
						min_unit_ceiling_dose = "";
						max_unit_ceiling_dose = "";
						min_daily_ceiling_dose = "";
						max_daily_ceiling_dose = "";
						dose_unit_desc="";
						ceil_dose_unit_desc = ""; //added for ML-MMOH-CRF-1408
					//added for ML-MMOH-CRF-1408 - end
					
					if ( recCount % 2 == 0 )
						classvalue = "QRYODD" ;
					else
						classvalue = "QRYEVEN" ;

						if(disp_level.equals("P") && ((String)orderLineDtls.get(i)).startsWith("PH")) {
							order_id				=	(String)orderLineDtls.get(i);
							OrderIDS.put(order_id,order_id) ;
							++i;
							++i;
							++i;
						}
						allergy					=	(String)orderLineDtls.get(i);
						exceed_dose				=	(String)orderLineDtls.get(++i);
						++i;
						drug_code				=	(String)orderLineDtls.get(++i);
						drug_name				=	(String)orderLineDtls.get(++i);
						dosage_dtls				=	(String)orderLineDtls.get(++i);
						//++i; commented for MMS-KH-CRF-0013
						start_date              =   (String)orderLineDtls.get(++i); // added for MMS-KH-CRF-0013
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
						act_bms_qty             =	bms_qty;
						source_code				=   (String)orderLineDtls.get(++i);
						source_type				=   (String)orderLineDtls.get(++i);
						ordering_facility_id	=   (String)orderLineDtls.get(++i);
						ord_date_time			=   (String)orderLineDtls.get(++i);
						performing_pract_id		=   (String)orderLineDtls.get(++i);
						duplicate_yn			=   (String)orderLineDtls.get(++i);
						min_dose_dtls			=   (String)orderLineDtls.get(++i);
						alloc_qty_from_tmp		=   (String)orderLineDtls.get(++i);
						strength_value			=	(String)orderLineDtls.get(++i);
						if(end_date.length() >=10)
							end_date		=	end_date.substring(0,10);
					
							//added for ML-BRU-SCF-2049 & ML-BRU-SCF-2055 and bean_1.getTokenNo() removed for ML-BRU-SCF-2055.1 - start
							if(issue_token_on_regn_YN!=null && issue_token_on_regn_YN.equals("Y") ){
								if(!ordering_facility_id.equals(""))
								 bean_1.setOrderingFacility(ordering_facility_id);
							}
							//added for ML-BRU-SCF-2049 & ML-BRU-SCF-2055 - end
						currentdateplusAllocatePeriod		=  	com.ehis.util.DateUtils.plusDate(sysdate,"DMY",locale,Integer.parseInt(bean_1.getFillPeriod()),"d").toString(); 	//Added for ML-BRU-SCF-0905 [IN:041285]- Start	
						endDateIsbeforAllocatedate			=  	com.ehis.util.DateUtils.isBefore(end_date,currentdateplusAllocatePeriod,"DMY",locale);

						if(!endDateIsbeforAllocatedate){
							end_date=currentdateplusAllocatePeriod;
						}//Added for ML-BRU-SCF-0905 [IN:041285] ended

						if(strength_value!=null && !strength_value.equals("") && Float.parseFloat(strength_value) <1 &&Float.parseFloat(strength_value)!=0)
							strength_value = Float.parseFloat(strength_value) +"" ;

						strength_uom			=	(String)orderLineDtls.get(++i);
						strength_uom_disp		=	(String)orderLineDtls.get(++i);
						// For Multi Frequency 
						sRepeatFreqCode			=	bean_1.getFreqRepeatCode(order_id, order_line_no).split("~")[0];
						sFreqCode				=	bean_1.getFreqRepeatCode(order_id, order_line_no).split("~")[1];
						stDrugCodes.add(drug_code); // to Add drug codes for authorization check

						trade_code				= (String)bean_1.gettrade_codes(order_id,order_line_no,drug_code);
						if(generic_id.equals("MEDICALITEM")){
						   drug_trade_bean.setDrugyesno("");
						}
						else{
							drug_trade_bean.setDrugyesno("Y");
						}
						image_path				=   drug_trade_bean.getImagePath(drug_code,trade_code);				
						pack_dtls			    =	bean.getPackSize(drug_code);

						if(pack_dtls!=null && pack_dtls.containsKey("PACK_SIZE")){
							if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
								main_drug_pack_size		=	Float.parseFloat(((String)pack_dtls.get("PACK_SIZE")));						
							 }		
						 }
						alt_drug			=bean.checkMultiStrength(drug_code);
						//Added for KAIH-SCF-0094[Inc:35252]-Start
						batch_data= (HashMap) bean.getbatchString(patient_id,order_id,order_line_no,drug_code);
						int medi_count=bean.altDrugsAvelibleYN(drug_code);//added for ghl-crf-0548
						if(medi_count>0){
							alt_drug="Y";
						}
						if( (alt_drug.equals("N") || alt_drug.equals(""))){
							for(int j=0;j<batch_data.size();j++){
								  temp=(ArrayList)batch_data.get(order_id+order_line_no+drug_code);
									for(int k1=0;k1<temp.size();k1=k1+4){
										trade_code=(String)temp.get(k1);
								}
							}
						}//Added for KAIH-SCF-0094[Inc:35252]-End
						//pat_couns_reqd_yn     =   bean.getPatCounsReqdyn(order_id, order_line_no);
						bmscount                =   bean.CheckBMSYN(order_id, order_line_no);
						bean.addDrugs(patient_id,order_id,drug_code,alt_drug,order_line_no);
						pres_details	        =	bean.getPresDetails(order_id);
						if(order_type.equals("IVI") ||  order_type.equals("CA"))
							strChangedFludRmks = bean.getChngdFluidRemarks(order_id,order_line_no);
						else
							strChangedFludRmks ="";

						if(strChangedFludRmks != "" && strChangedFludRmks != null)
							classvalue = "FLUDCOLOR";
					//GHL-CRF-0453 - start
						if(printValue!=null && printValue.size()>0){
							print_value = (String)printValue.get(order_id+order_line_no);
						}
					//GHL-CRF-0453 - end
						// Written for Worksheet (Starts)
						ws_tot_qty = 0;
						ht_ws_allocated_batches = bean_1.getHTWSAllocateBatches();
						if(ht_ws_allocated_batches.get(order_line_no) != null){
							ArrayList arr_list = (ArrayList)ht_ws_allocated_batches.get(order_line_no);	
							ht_ws_alloc_qty    = (Hashtable)bean_1.getHTWSAllocatedQty();
							ht_ws_alloc_qty = (Hashtable)ht_ws_alloc_qty.get(order_line_no);
							ws_item_code = "";
							ws_drug_code = "";
							if(arr_list.size()>1){
								ws_item_code = (String)arr_list.get(0);
								ws_drug_code = (String)arr_list.get(2);
							}
							
							if(ht_ws_alloc_qty != null && ht_ws_alloc_qty.get(ws_item_code+ws_drug_code) != null){
								ArrayList arr_list_alloc_qty = (ArrayList)ht_ws_alloc_qty.get(ws_item_code+ws_drug_code);
								for (int jj=0;jj<arr_list_alloc_qty.size();jj++){
									ws_tot_qty += Double.parseDouble((String)arr_list_alloc_qty.get(jj));
								}	
							}
							ht_drug_details	    = bean_1.getAllDrugDetails();
							ArrayList arr_list_drug_details = (ArrayList)ht_drug_details.get(order_line_no);
							qty_avail_from_spillage = "0";
							if(arr_list_drug_details != null)
								qty_avail_from_spillage= (String)arr_list_drug_details.get(3);

							ws_tot_qty += Double.parseDouble(qty_avail_from_spillage);
						}// Written for Worksheet ends

						if(!alloc_qty_from_tmp.equals("") && !alloc_qty_from_tmp.equals("0")) {
							if(bean.getFirstTime(order_id).trim().equals("true")) {
								HashMap drug_detail		=	bean.getDB_DrugDetail(order_id,order_line_no,end_date);
								ArrayList multi_detail	=	(ArrayList)drug_detail.get("multi_detail");
								ArrayList main_detail	=	(ArrayList)drug_detail.get("main_detail");
								HashMap   alt_detail	=	(HashMap)drug_detail.get("alt_detail");
								if(multi_detail.size()==0) {
									bean.setDrugDetail(patient_id,order_id,order_line_no,main_detail);
									bean.setDrugQuantity(patient_id,order_id,order_line_no,Double.parseDouble(alloc_qty_from_tmp));
								}
								else if(multi_detail.size()!=0) {
									bean.setMultiDrugs(patient_id,order_id,order_line_no,multi_detail);

									for(int no=0; no<multi_detail.size(); no+=5) {
										alt_drug_code			    =	(String)multi_detail.get(no);
										ArrayList alt_drug_detail	=	(ArrayList)alt_detail.get(alt_drug_code);
										bean.setAlternateDrugDetail(patient_id,order_id,order_line_no,alt_drug_detail,alt_drug_code);
									}
								}
								//bean.setFirstTime(order_id,false);
							}
						}
						stock_opt =(ArrayList)bean.getStockItems(drug_code);
						
						if(module_id.equals("2") /*&& stock_opt.size()==0*/ ) {  //SKR-SCF-1646
							st	=	new StringTokenizer((String)orderLineDtls.get(++i),"|");
							while(st.hasMoreTokens()){
								stock_opt.add((String)st.nextToken());
							}
						}						
						else{
							++i;
						}
					
						 ext_prod_id  = (String)orderLineDtls.get(++i);
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
						}	//ended...
						// Drug class
						drug_class	=	(((String)orderLineDtls.get(++i)).trim());
						i=i+2;
						expired_yn  = (String)orderLineDtls.get(++i);
						if(expired_yn.equals("Y"))
						{
							if(expired_order) // Modified for MOHE-CRF-0032
								{
								classvalue="EXPIRED_ORDER";
								}
							else
							{
								classvalue="EXPIRED_MEDICATION";
							}
						 }
						i=i+1;  // i+2 changed to i+1   // added for JD-CRF-198
						order_line_status = (((String)orderLineDtls.get(++i)).trim()); // added for JD-CRF-198
						main_strength_per_value_pres_uom =(String)orderLineDtls.get(++i);
						i++;
						sOrderType = orderLineDtls.get(i) == null ?"":orderLineDtls.get(i).toString();
						i++;
						sAbsOrder  = orderLineDtls.get(i) == null ?"":orderLineDtls.get(i).toString();
						if(sOrderType.equals("P") || sAbsOrder.equals("N"))
							bPRNOrAbsOrder = true;
						else
							bPRNOrAbsOrder = false;
						if(drug_class.equals("C") || drug_class.equals("N")) {
							narc_style	="color:brown";
							nar_cnt_drug = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.NarcoticControlledDrugs.label","ph_labels");
							title		= "title='"+nar_cnt_drug+"'";
						}
						bean.setStockItems(drug_code,stock_opt);
						if(!strength_value.equals("0"))
							strength	=	strength_value+" "+strength_uom;
						dose	=	new StringTokenizer(dosage_details,":");
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
						if(!dosage_unit.equals("")){ //added for ML-MMOH-CRF-1408 - start
							   dose_unit_desc      = bean.getUomDisplay((String)session.getValue("facility_id"),dosage_unit); 
		 						ceil_dose_unit_desc = dose_unit_desc ; //added for ML-MMOH-CRF-1408
								if(dose_unit_desc==null || dose_unit_desc=="" ) {
									if(dosage_unit.indexOf("/")!=-1){//if added for ML-MMOH-SCF-1627
		 						  dose_unit_desc = bean.getUomDisplay((String)session.getValue("facility_id"),(dosage_unit.split("/")[0]));
		 						ceil_dose_unit_desc = dose_unit_desc ; //added for ML-MMOH-CRF-1408
								  if(dosage_unit.length()>=2){
		 							 dose_unit_desc =dose_unit_desc+"/"+(dosage_unit.split("/")[1]);
		 						  }
								}
		 						} 
	 						}//added for ML-MMOH-CRF-1408 - end
						min_dose	=	new StringTokenizer(min_dose_dtls,":");
						if(min_dose.hasMoreTokens()) {//added for ml-mmoh-scf-1997
							min_unit_dose	=	min_dose.nextToken();
						} // Added for the issue which is found while testing MMS-KH-CRF-0028 [IN070605]
						if(min_dose.hasMoreTokens()) { // Added for the issue which is found while testing MMS-KH-CRF-0028 [IN070605]
							min_daily_dose	=	min_dose.nextToken();
						}					
						multi_drugs	=	bean.getMultiDrugs(patient_id,order_id,order_line_no);	
						alt_drug_remarks_disp="";
						if(multi_drugs.size() >0  && (alt_drug_remarks_ind.equals("M") || alt_drug_remarks_ind.equals("O")) ){// Added For Bru-HIMS-CRF-082 [IN:029948]-start
							alt_drug_remarks_disp = "&nbsp;<a href=\"javascript:openAltDrugRemarks('"+order_id+"','"+ order_line_no+"','"+ alt_drug_remarks_ind+"','LINK');\" id='altDrugRmkLbl' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+"</a>";
							if(alt_drug_remarks_ind.equals("M"))
								alt_drug_remarks_disp=alt_drug_remarks_disp+" <img  id='altDrugRmkMand' src='../../eCommon/images/mandatory.gif'></img>";
						}// Added For Bru-HIMS-CRF-082 [IN:029948]-end
						qty			 = "";
						if(request.getParameter("resetQty")== null)
							qty				=	bean.getDrugQuantity(patient_id,order_id,order_line_no);
						else
							qty				= "";
						Order_id_amend_yn =(HashMap)bean_1.getOrder_id_amend_yn();
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
						if(!scope.equals("H")){
							if( (!qty.equals("") && !qty.equals("0")) || (!alt_drug_qty.equals("") && !alt_drug_qty.equals("0")) ||(ws_tot_qty>0)){
								hold_status	="disabled";
							}
						}
						if(bean.checkHold(order_id,order_line_no)) {
							hold_text=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OnHold.label","ph_labels");
							check_value="Y";
							check_status="checked";
							fromdb="Y";
							remark_status	="visibility:visible";
						} 
						else {
							hm= bean.loadHoldRemarks(order_id,order_line_no);
							if (!hm.isEmpty()){
								hold_text=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OnHold.label","ph_labels");
								check_value="Y";
								check_status="checked";
								fromdb="Y";
								remark_status	="visibility:visible";
							}
							else{
								hold_text		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Hold.label","ph_labels");
								remark_status	="visibility:hidden";
								check_status	="";
							}
						}
						/*-----code for displaying drug remarks---------------*/
						drug_remarks	    = "";
						prn_remarks		    = "";
						pharma_remarks	    = "";		
						pres_remarks        = "";
						slidingscaleremarks ="";
						remarks_style       = "";
						dialog_height       = 0;
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
						dischargeIND					=	(String)orderLineDtls.get(++i);//from OR_ORDER dischargindicator
						strBMS_Include_yn				=	(String)orderLineDtls.get(++i);// Added for [IN:045295] 
						home_med_yn 				= 	(String)orderLineDtls.get(++i);//Added for Bru-HIMS-CRF-093-DD1[IN047223]
						drug_desc 				= 	(String)orderLineDtls.get(++i);//Added for Bru-HIMS-CRF-414 ML-BRU-SCF-1454 [IN:052271]
						disc_cancelled_orders		= 	(String)orderLineDtls.get(++i);//Added for  HSA-CRF-0138 [IN:048414] 
						appl_for_compounding_rx_yn 	= 	(String)orderLineDtls.get(++i);//Added for  Bru-HIMS-CRF-080 -start
						//added for MMS-KH-CRF-0029 - start
						food_interaction_override_reason =   "";
						lab_interaction_override_reason =   "";  
						disease_inter_override_reason="";//MMS-DM-CRF-0229
						if(iv_prep_yn!=null && iv_prep_yn.equals("")){
							 lab_food_interaction = bean.getDrugLabFoodInteraction(order_id,order_line_no);
							 food_interaction_override_reason = (String)lab_food_interaction.get("FOOD_INTERACT_OVERRIDE_REASON")==null?"":(String)lab_food_interaction.get("FOOD_INTERACT_OVERRIDE_REASON");
							 lab_interaction_override_reason = (String)lab_food_interaction.get("LAB_INTERACT_OVERRIDE_REASON")==null?"":(String)lab_food_interaction.get("LAB_INTERACT_OVERRIDE_REASON");//modified for mms-md-scf-0141
							 disease_inter_override_reason = (String)lab_food_interaction.get("DISEASE_INTER_OVERRIDE_REASON")==null?"":(String)lab_food_interaction.get("DISEASE_INTER_OVERRIDE_REASON");//MMS-DM-CRF-0229
						}
						if(lab_interaction_override_reason==null) //MMS-KH-CRF-0029
							lab_interaction_override_reason = "";
						if(food_interaction_override_reason==null) //MMS-KH-CRF-0029
							food_interaction_override_reason = "";
						//added for MMS-KH-CRF-0029 - end
						if(disease_inter_override_reason==null) //MMS-DM-CRF-0229
							disease_inter_override_reason = "";


						if("Y".equals(appl_for_compounding_rx_yn)){
							disp_mnf_flag = "display:inline;color:blue";
						} //Added for  Bru-HIMS-CRF-080 -end
						if(!disc_cancelled_orders.equals("")) //Added for  HSA-CRF-0138 [IN:048414] - start
							disc_cancelled_orders_display="display:inline";
						else
							disc_cancelled_orders_display="display:none"; //Added for  HSA-CRF-0138 [IN:048414] end
						//Commented for RUT-CRF-0088 [IN036978] 
						/*taper_order_yn 					=	(String)orderLineDtls.get(++i);//from OR_ORDER
						taper_order_id					=	(String)orderLineDtls.get(++i);//from OR_ORDER
						taper_order_line_num					=	(String)orderLineDtls.get(++i);//from OR_ORDER
						if(taper_order_yn.equals("Y") && !taper_order_id.equals("") && !taper_order_line_num.equals("")){
							taper_disable = "disabled";
							alloc_qty_from_tmp = "0"; // added to avoid displaying qty for tapered drugs
						}
						else*/
						 abuse_drug_override_reason=(String)orderLineDtls.get(++i);//added for aakh-crf-0140
						abuse_exists=(String)orderLineDtls.get(++i);//aakh-crf-0140
						drugIndication=(String)orderLineDtls.get(++i);//ADDED FOR JD-CRF-0220
						drug_expiry_alert = (String)orderLineDtls.get(++i);//Added for TH-KW-CRF-0008
						drug_expiry_days  = (String)orderLineDtls.get(++i);//Added for TH-KW-CRF-0008
						if(insuranceStatus.containsKey(order_id+order_line_no))
						insurance_status  = (String)insuranceStatus.get(order_id+order_line_no);//Added for TH-KW-CRF-0012
						System.err.println("drug_expiry_alert@@@=="+drug_expiry_alert+"insurance_status=="+insurance_status);
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
				System.out.println("Dispmedicationallocation abuse_drug_override_reason"+abuse_drug_override_reason);
				System.out.println("DispmedicationAllocation abuse_exists"+abuse_exists);
						taper_disable="";
						taperValues=bean.chkfortapering(order_id,drug_code, order_line_no, patient_id);	
						count =Integer.parseInt(taperValues.get("COUNT").toString()); 
						tot_tap=Float.parseFloat(taperValues.get("TOT_QTY").toString());
						show_remarks = "N";
						if(!allergy_override_reason.equals("")||!dosage_limit_override_reason.equals("")||!duplicate_drug_override_reason.equals("")||!interaction_override_reason.equals("")||!contraind_override_reason.equals("") || !food_interaction_override_reason.equals("") ||  !lab_interaction_override_reason.equals("") || !disease_inter_override_reason.equals("")){//modified for MMS-KH-CRF-0029
							show_remarks="Y";
						}
						if(!alloc_qty_from_tmp.equals("") && !alloc_qty_from_tmp.equals("0")) {
							if(bean.getFirstTime(order_id).trim().equals("true")) {
								HashMap drug_detail		=	bean.getDB_DrugDetail(order_id,order_line_no,end_date);
								ArrayList multi_detail	=	(ArrayList)drug_detail.get("multi_detail");
								ArrayList main_detail	=	(ArrayList)drug_detail.get("main_detail");
								HashMap   alt_detail	=	(HashMap)drug_detail.get("alt_detail");
								if(multi_detail.size()==0) {
									bean.setDrugDetail(patient_id,order_id,order_line_no,main_detail);
									bean.setDrugQuantity(patient_id,order_id,order_line_no,Double.parseDouble(alloc_qty_from_tmp));
								} 
								else if(multi_detail.size()!=0) {
									bean.setMultiDrugs(patient_id,order_id,order_line_no,multi_detail);
									for(int no=0; no<multi_detail.size(); no+=5) {
										alt_drug_code			    =	(String)multi_detail.get(no);
										ArrayList alt_drug_detail	=	(ArrayList)alt_detail.get(alt_drug_code);
										bean.setAlternateDrugDetail(patient_id,order_id,order_line_no,alt_drug_detail,alt_drug_code);
									}
								}
								//bean.setFirstTime(order_id,false);
							}
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
							drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.VerificationRemarks.label","ph_labels")+" : "+verificationremarks.trim()+"\n");			//code added for Bru-HIMS-CRF-416[IN045566]-- End	
							//!abuse_drug_override_reason.trim().equals("") added for aakh-crf-0140
							if(!abuse_drug_override_reason.trim().equals(""))
								drugs_remarks.append("DrugAbuse Remarks : "+abuse_drug_override_reason.trim()+"\n");	
							System.out.println("abuse_drug_override_reason"+abuse_drug_override_reason+"drugs_remarks"+drugs_remarks);
							//abuse_drug_override_reason.trim().equals("") added for aakh-crf-0140
							if(!abuse_drug_override_reason.trim().equals(""))
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
						}/*-------------------------ends------------------------*/	
						tmp_bms_qty				=	bms_qty;

						main_pack_size		=   0;
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
						Float fTotalDuration = Float.parseFloat(bean_1.getDurationValue(order_id+order_line_no));
						
					   if(ord_type.equals("NOR") || bEquivalentNormalOrder){/*==============code for getting defult batches====================================*/
							items			=  (ArrayList)bean.loadItems(drug_code);
							if(items.size()>0){
								item_code     =   (String)items.get(0);
							}
							store_code	=	bean_1.getStoreCode();
							opdispperiod  = Float.parseFloat(bean_1.getFillPeriod());
							// For Multi Frequency
							sOrigDispUnit	= bean_1.getStrChangedDispenseUnit() != null?bean_1.getStrChangedDispenseUnit():"D";
							sOrigDispPeriod	= bean_1.getStrChangedDispensePeriod() != null?bean_1.getStrChangedDispensePeriod():"1";
							if(sRepeatFreqCode.equals("W")){
								if(sOrigDispUnit.equals("H")){
									//opdispperiod = new Float(Math.ceil((opdispperiod/(24*7)))*7); // divide by 24 to make day and divide by 7 to convert to week and ceil it. // commented for ARYU-SCF-077
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

							if(sFreqCode.equals("H")){
								fTotalDuration = fTotalDuration/24;
							}
							else if(sFreqCode.equals("W")){
								fTotalDuration = fTotalDuration*7;
							}
							else if(sFreqCode.equals("L")){
								fTotalDuration = fTotalDuration*30;
							}
							else if(sFreqCode.equals("Y")){
								fTotalDuration = fTotalDuration*365;
							}
							//if(end_date.length() >=10)
							//	end_date		=	end_date.substring(0,10);
						}
							if(bean.checkHold(order_id,order_line_no)|| scope.equals("H")){
								alloc_readonly ="disabled";  
							}
							else{
								alloc_readonly ="";  
							}
							tot_issued_qty  =0;
							IssueUOMAndBaseUOM		=	(HashMap)bean.getStoreDfltIssueUOMAndBaseUOM(store_code,drug_code);
							base_to_disp_uom_equl	=	0;
							base_to_def_uom_equl	=	1;
							orig_dflt_issue_uom		= (String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM")==null?"":(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM");
							st_allow_decimals_yn	= CommonBean.checkForNull((String)IssueUOMAndBaseUOM.get("ALLOW_DECIMALS_YN")); //  Added for AAKH-SCF-0113 [IN:048937] 
							if(bKeepQty && qty.equals("")){
								alValues = bean.setIssueUOMValuesLevelTwo(order_id,order_line_no,drug_code);
								for(int iCount =0 ;iCount<alValues.size();iCount++){
									hmUOMValues = (HashMap) alValues.get(iCount);
									qty = (String)hmUOMValues.get("DISP_QTY");
									if(alValues.size()==1){ // if the returned UOM values are single, then set all the values default else set the dflt_issue_uom values
									System.err.println("@@@ inside SetIssueUOM 1353==");
										bean.setIssueUomQty(order_id+order_line_no+item_code+"_qty",(String)hmUOMValues.get("DISP_QTY"));
										bean.setIssueUomQty(order_id+order_line_no+item_code+"_uom",(String)hmUOMValues.get("UOM_CODE"));
										bean.setIssueUomQty(order_id+order_line_no+item_code+"_desc",(String)hmUOMValues.get("UOM_DESC"));
										bean.setIssueUomQty(order_id+order_line_no+item_code+"_equl",(String)hmUOMValues.get("CONVERTED_EQUAL") );
									}
									if(hmUOMValues.get("UOM_CODE").toString().equals(orig_dflt_issue_uom)){
										bean.setIssueUomQty(order_id+order_line_no+item_code+"_base_to_def_uom_equl",(String)hmUOMValues.get("DEFAULT_EQUAL"));
									}
									else{
										System.err.println("@@@ inside SetIssueUOM 1363==");
										bean.setIssueUomQty(order_id+order_line_no+item_code+"_qty",(String)hmUOMValues.get("DISP_QTY"));
										bean.setIssueUomQty(order_id+order_line_no+item_code+"_uom",(String)hmUOMValues.get("UOM_CODE"));
										bean.setIssueUomQty(order_id+order_line_no+item_code+"_desc",(String)hmUOMValues.get("UOM_DESC"));
										bean.setIssueUomQty(order_id+order_line_no+item_code+"_equl",(String)hmUOMValues.get("CONVERTED_EQUAL") );
										bean.setIssueUomQty(order_id+order_line_no+item_code+"_base_to_disp_uom_equl", (String)hmUOMValues.get("DEFAULT_EQUAL"));
										dflt_issue_uom = (String)hmUOMValues.get("UOM_CODE");
									}
								}
								hold_status	="disabled";
								if(!qty.equals(""))
									bms_qty = (Double.parseDouble(bms_qty) - Double.parseDouble(qty))+"";
							}
							else
								dflt_issue_uom	= "";
							/*=============code added to handle if dispense uom and default uom in item store is different and variable UOM==========*/

							issue_uom_qty_hm =  bean.getIssueUomQty();
							if(dflt_issue_uom.equals("")){
								if(issue_uom_qty_hm.size()>0){
									if(issue_uom_qty_hm.containsKey(order_id+order_line_no+drug_code+"_uom")){
										dflt_issue_uom = (String)issue_uom_qty_hm.get(order_id+order_line_no+drug_code+"_uom");
									}
								}

								if(dflt_issue_uom.equals("") || request.getParameter("resetQty")!= null)
									dflt_issue_uom			 =	(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM")==null?"":(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM");
							}
							base_uom			     =  (String)IssueUOMAndBaseUOM.get("BASE_UOM");
							base_to_disp_uom_equl    =	bean.getEqulValue ( item_code, base_uom, qty_uom);
							base_to_def_uom_equl	 =  bean.getEqulValue ( item_code, base_uom, orig_dflt_issue_uom);
							/*=======================ends here=========================================================================================*/
							if(request.getParameter("barcode_id")!=null){ //Added for KDAH-CRF-0231 [IN-034551]
								barcode_id = request.getParameter("barcode_id");
							}
							last_scanned = bean_1.getScannedBarcode_id(order_id,order_line_no); //Added for GHL-CRF-0463 //modified for MMS-DM-SCF-0488
									String use_after_expiry="";//SKR-SCF-1647
									use_after_expiry= bean.getItemUseAfterExpiry(item_code);
							if(qty.equals("") && alt_drug_qty.equals("")&& ord_type.equals("NOR") &&alloc_readonly.equals("") /*&& stock_opt.get(0).equals("Y")*/ &&  (!item_code.equals("")) && barcode_id.equals("")) {//  && barcode_id.equals("") Added for KDAH-CRF-0231 [IN-034551], SKR-SCF-1646 and SKR-SCF-1647
								if(disable_all.equals("disabled")&&qty.equals("")){
									zero_alloc_qty_item_yn ="Y";
								}
								else{
									zero_alloc_qty_item_yn ="N";
									if(base_to_disp_uom_equl!=0 && base_to_def_uom_equl !=0){
										tmp_unit_qty    =	0;
										if(bPRNOrAbsOrder)
											tmp_unit_qty = Double.parseDouble(act_bms_qty);
										else{
											fill_period	= bean_1.getFillPeriod();
											fill_unit		= bean_1.getFillUnit();
											item_cost       ="";
											issue_qty       ="";
											float per_day	=Float.parseFloat(pres_qty)/ fTotalDuration;
											if(disp_catg.equals("I")){
												if(fill_unit.equals("H") && !fill_period.equals("")) {
													tmp_unit_qty	=	new Float((opdispperiod / 24 )* per_day).doubleValue();	
												}
												else if(fill_unit.equals("D")) {
													tmp_unit_qty	=	new Float((opdispperiod * per_day)).doubleValue();
												}
											}
											else{
												if(opdispperiod!=0){
													tmp_unit_qty= new Float(Math.ceil(per_day*opdispperiod)).doubleValue();
												}
												else{
												   tmp_unit_qty=new Float(Double.parseDouble(pres_qty)).doubleValue();
												}
											}
											if(tmp_unit_qty > (Double.parseDouble(act_bms_qty))) { //  || (count>1) ) {// removed for ML-BRU-SCF-1015 [IN:043355]
												 tmp_unit_qty =Double.parseDouble(act_bms_qty);
											}
										}
										if(bean_1.getBarcode_Scan_YN().equals("Y") && barcode_id.equals("") && bean_1.getOrderType().equals("NOR")){ // condition Added for [IN:064158] - Start
											  tmp_unit_qty=0;  
										  } // condition Added for [IN:064158] -End
										/*==========code added to handle if dispense uom and default uom in item store is different=================*/
										issue_qty_val			 =  0;
										if(base_to_disp_uom_equl!=base_to_def_uom_equl){
											conv_factor    = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
											issue_qty_val  =  new Float(Math.ceil(tmp_unit_qty*base_to_disp_uom_equl)).doubleValue(); 
											issue_qty_val  =  new Float(Math.ceil(((Math.ceil(Double.parseDouble(issue_qty_val+"")/conv_factor))*(conv_factor))/base_to_def_uom_equl)).doubleValue(); 
											// bean.setIssueUomQty(order_id+order_line_no+item_code+"_qty",issue_qty_val+""); //moved from common to  specific  MMS-SCF-0040 [IN:041888] // commented for IN:6585
											issue_qty_val  =  new Float(Math.ceil(issue_qty_val*base_to_def_uom_equl)).doubleValue(); //Added for  MMS-SCF-0040 [IN:041888]
											System.err.println("@@@ inside SetIssueUOM 1446==");
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
											System.err.println("@@@ inside SetIssueUOM 1458==");
											bean.setIssueUomQty(order_id+order_line_no+item_code+"_qty",tmp_unit_qty+""); //Moved from common to specific for  MMS-SCF-0040 [IN:041888]
										}                   

										//bean.setIssueUomQty(order_id+order_line_no+item_code+"_qty",tmp_unit_qty+"");
										//bean.setIssueUomQty(order_id+order_line_no+item_code+"_qty",issue_qty_val+"");
										System.err.println("@@@ inside SetIssueUOM 1463==");
										bean.setIssueUomQty(order_id+order_line_no+item_code+"_uom",dflt_issue_uom);
										bean.setIssueUomQty(order_id+order_line_no+item_code+"_desc",bean.getUOMDesc ( dflt_issue_uom));
										bean.setIssueUomQty(order_id+order_line_no+item_code+"_equl",base_to_def_uom_equl+"");
										//tmp_unit_qty =issue_qty_val;  //Commented for SKR-SCF-0377 [IN:030453]
										//item_cost	=	bean.getItemCost(item_code,store_code,tmp_unit_qty+"",end_date);    //Commented for SKR-SCF-0377 [IN:030453]
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
										if(use_after_expiry!=null && use_after_expiry.equals("N")){//SKR-SCF-1646,SKR-SCF-1647
										params.put("INCLUDE_EXPIRED","FALSE");
										}else if (use_after_expiry!=null && use_after_expiry.equals("Y")){
											params.put("INCLUDE_EXPIRED","TRUE");
										}
										params.put("CUT_OFF_DATE",end_date);
										params.put("VERIFY_INSUFFICIENT_QTY","FALSE");
										params.put("ALREADY_USED_QTY","");
										params.put("MIN_EXP_DATE",end_date);
										params.put("BARCODE_ID",barcode_id);
										if(bean_1.get2DBarcodeApplicable().equals("Y") && !barcode_id.equals("")){//Added if condition for MMS-DM-CRF-0174.5
								           stock = (HashMap)bean_2.get2DBarcodeDetails(params);
				                         }else{
										   stock				= (HashMap)bean_2.getBatches(params);
										 }
										stock_det           = (ArrayList)stock.get("BATCH_DATA");

										if(trade_code.equals("") && stock.containsKey("EXCEPTION")){ // Added for KAUH-SCF-0094 [IN:035252] -- begin When Trade and Stock is blank, Alternate trade should be taken 
											bean_st.setIncludeSuspendedBatches("N") ;
											bean_st.setIncludeZeroStockBatches("N") ;
											bean_st.setIncludeExpiredBatches("N") ;//modified for SKR-SCF-1647  
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
											listRecord					=		bean_st.getDataList();
											if(listRecord!=null && listRecord.size()>0){
												trade_code=((HashMap)listRecord.get(0)).get("TRADE_ID").toString();//Changed TRADE_NAME to TRADE_ID for IN037289
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
										}// Added for KAUH-SCF-0094 [IN:035252] -- end
										//code for setting batch details in bean
										alloc_drug_detail	=	new ArrayList();
										
										if(stock_det.size()>0)
											disp_delivery_chk_box_val = "Y";
										else
											disp_delivery_chk_box_val = "N";
										tmp_unit_qty =issue_qty_val; //moved from down for  MMS-SCF-0040 [IN:041888]
										//if(!stock.containsKey("EXCEPTION")){//added by Ganga for ML-BRU-SCF-0905 [IN:041285] //Commented for TTM-SCF-0096 [IN:048808]
											for (int j=0;j<stock_det.size();j++){
												batch_det =(HashMap)stock_det.get(j);
												avail_qty			= (String)batch_det.get("AVAIL_QTY");
												if(Double.parseDouble(avail_qty) < 1.0)
													continue;
												avail_qty			= retunFormatedInt(Math.floor(Double.parseDouble(avail_qty))+"");
												alloc_drug_detail.add(batch_det.get("ITEM_CODE"));
												alloc_drug_detail.add(batch_det.get("BATCH_ID"));
												alloc_drug_detail.add(batch_det.get("EXPIRY_DATE"));
												/*if(qty_uom!=base_uom){   //added for SKR-SCF-0377 [IN:030453] - start
													conv_factor    = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
													issue_qty_val  =  new Float(Math.ceil(tmp_unit_qty*base_to_disp_uom_equl)).doubleValue(); 
													issue_qty_val  =  new Float(Math.ceil(((Math.ceil(Double.parseDouble(issue_qty_val+"")/conv_factor))*(conv_factor))/base_to_def_uom_equl)).doubleValue(); 
												}*/ // Commented MMS-SCF-0040 [IN:041888] 
												//tmp_unit_qty =issue_qty_val; //Commented for MMS-SCF-0040 [IN:041888]
												item_cost	=	bean.getItemCost(item_code,store_code,tmp_unit_qty+"",end_date);
												/*if(qty_uom!=base_uom){ // Commented MMS-SCF-0040 [IN:041888] 
													conv_factor    = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
													avail_qty  =   retunFormatedInt(Math.floor(Double.parseDouble(avail_qty)/base_to_disp_uom_equl)+""); 
												 }
												 else{  
												   avail_qty			= retunFormatedInt(Math.floor(Double.parseDouble(avail_qty))+"");
												 }*/ //Added for SKR-SCF-0377 [IN:030453] - end
												if(tmp_unit_qty>Double.parseDouble(avail_qty)){
													 tmp_unit_qty =tmp_unit_qty-Double.parseDouble(avail_qty);
													 issue_qty =avail_qty;
												}
												else{
													 issue_qty =tmp_unit_qty+"";    
												}
												tot_issued_qty = tot_issued_qty+Double.parseDouble(issue_qty);
												if(base_to_disp_uom_equl!=base_to_def_uom_equl){					  
													/*int  alloc_qty = new Float(Math.ceil(((Math.ceil((Float.parseFloat((Double.parseDouble(issue_qty)*base_to_def_uom_equl)+""))/Double.parseDouble(conv_factor+"")))*(conv_factor))/base_to_disp_uom_equl)).intValue();  
													issue_qty = alloc_qty+"";*/ //commented for  MMS-SCF-0040 [IN:041888]
													alloc_drug_detail.add(issue_qty); //moved from common to specific for  MMS-SCF-0040 [IN:041888]
													alloc_drug_detail.add(qty_uom);
												}
												else{ //else block added for  MMS-SCF-0040 [IN:041888]
													if(!qty_uom.equals(base_uom)){
														alloc_drug_detail.add(issue_qty);
														alloc_drug_detail.add(qty_uom);
													}
													else{
														alloc_drug_detail.add((String)batch_det.get("QTY"));
														alloc_drug_detail.add(base_uom);
													}
												}
												/* Commented for RUT-CRF-0088 [IN036978]  
												if(taper_order_yn.equals("Y") && !taper_order_id.equals("") && !taper_order_line_num.equals("")){ //if block added to avoid displaying charges for tapered drugs
													 issue_qty = "0";
												 }*/
												/*alloc_drug_detail.add(issue_qty);
												alloc_drug_detail.add(qty_uom);*/ //Commented for  MMS-SCF-0040 [IN:041888]
												alloc_drug_detail.add("");
												alloc_drug_detail.add(batch_det.get("TRADE_ID"));
												alloc_drug_detail.add(batch_det.get("BIN_LOCATION_CODE"));
												alloc_drug_detail.add(item_cost);
												alloc_drug_detail.add(base_uom); //Added for for  MMS-SCF-0040 [IN:041888]
											}
										/*}
										else{//added ElseCondition by Ganga for ML-BRU-SCF-0905 [IN:041285]
											alloc_readonly ="disabled";
										}*/ //Commented for  TTM-SCF-0096 [IN:048808]
										hold_status	="disabled"; //Commented for KAUH-SCF-0184 [IN032611] -Reopened.
										/*if(base_to_disp_uom_equl!=base_to_def_uom_equl){//if block code added to handle if dispense uom and default uom in item store is different
											int  alloc_qty = new Float(Math.ceil(((Math.ceil((Double.parseDouble((tot_issued_qty*base_to_def_uom_equl)+""))/(conv_factor)))*(conv_factor))/base_to_disp_uom_equl)).intValue();  
											tot_issued_qty = alloc_qty;
										} *///Commeted for  MMS-SCF-0040 [IN:041888]
										/* Commented for RUT-CRF-0088 [IN036978] 
										if(taper_order_yn.equals("Y") && !taper_order_id.equals("") && !taper_order_line_num.equals("")){ //if block added to avoid displaying charges for tapered drugs
											tot_issued_qty = 0;
										}*/
										if(bean_1.getBarcode_Scan_YN().equals("Y") && barcode_id.equals("") && bean_1.getOrderType().equals("NOR")){ // Added for [IN:064158] - Start
											tot_issued_qty=0;
										} // Added for [IN:064158] - End
										if(!qty_uom.equals(base_uom)){ //if & else block added for  MMS-SCF-0040 [IN:041888]
											conv_factor    = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
											tot_issued_qty  =   Math.floor(tot_issued_qty/base_to_disp_uom_equl); 
										}
										else{
											tot_issued_qty			= Math.floor(tot_issued_qty);
										} //Added for MMS-SCF-0040 [IN:041888] - end
										bean.setDrugDetail(patient_id,order_id,order_line_no,alloc_drug_detail);
										bean.setDrugQuantity(patient_id,order_id,order_line_no,tot_issued_qty);		
								   }
								   else{
									   if(!item_uom_definition_flag){
										   item_uom_definition_flag=true;
									   }
									   alloc_readonly ="disabled";  
									}
								}
								//if condition added for SKR-SCF-1423
								if(stock_opt.get(0).equals("Y") && qty.equals("") && tot_issued_qty==0 && bean_1.getBarcode_Scan_YN().equals("N") && barcode_id.equals("")) //added for MMS-DM-SCF-0162
									hold_status = "";
							}
							IssueUomQty		= (HashMap)bean.getIssueUomQty();/*=====code added to handle if dispense uom and default uom in item store is different======*/
							issue_qty_dtl   =  new StringBuffer();
							if(IssueUomQty.containsKey(order_id+order_line_no+drug_code+"_qty")&& base_to_disp_uom_equl!=0){
								issue_qty_value	= (String)IssueUomQty.get(order_id+order_line_no+drug_code+"_qty");
								issue_uom_desc	= (String)IssueUomQty.get(order_id+order_line_no+drug_code+"_desc");
								issue_uom	    = (String)IssueUomQty.get(order_id+order_line_no+drug_code+"_uom");
								issue_uom_equl	= (String)IssueUomQty.get(order_id+order_line_no+drug_code+"_equl"); 
								System.err.println("issue_qty_value@@@=="+issue_qty_value+"issue_uom_equl==="+issue_uom_equl);
								if(bean_1.getIssueByUOM().equals("I")){
									issue_qty_dtl   =  issue_qty_dtl.append("( ").append(issue_qty_value).append("  ").append(issue_uom_desc).append(" )");
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
									if (Double.parseDouble(avail_qty) <  Double.parseDouble(frm_store_min_stk_level) ){
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
							<td> 
							<input type="checkbox" name="print_<%=recCount%>" id="print_<%=recCount%>" onclick="setValue(this)" value="Y" checked> <!--added for GHL-CRF-453 -->
							</td>
								<td class="white" >
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
										if(exceed_dose.equals("") ) { 
%>
											<td class="white" width="20%">&nbsp;</td> <!-- 33% changed to 20% for MMS-KH-CRF-0013 -->
<%
										}
										else{//order_id,order_line_no,(recCount),patient_class,review_called_from FOR IN070605
%>
											<td class='DOSELIMIT3' width="20%" style="cursor:pointer" onClick="showMonoGraph('<%=drug_name%>','<%=java.net.URLEncoder.encode(monograph)%>','<%=daily_dose%>','<%=unit_dose%>','<%=min_unit_dose%>','<%=min_daily_dose%>','<%=dosage_unit%>','<%=std_dose%>','<%=dose_unit_desc%>','<%=order_id%>','<%=order_line_no%>','<%=(recCount)%>','<%=patient_class%>','','<%=max_daily_ceiling_dose%>','<%=min_daily_ceiling_dose%>','<%=max_unit_ceiling_dose%>','<%=min_unit_ceiling_dose%>','<%=ceil_dose_unit_desc%>')">&nbsp;</td> <!-- 33% changed to 20% for MMS-KH-CRF-0013 and ceiling dose added for ML-MMOH-CRF-1408 and changed dose_unit_desc to ceil_dose_unit_desc for 1408-->
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
										if(iv_prep_yn.equals("")){ // Added for MMS-KH-CRF-0013 - Start and removed intractn_req_yn && for MMS-KH-CRF-0029
										pres_bean.setEncounterId(encounter_id); //MMS-KH-CRF-0029	
											if(!drug_db_interface_yn.equals("Y") && pres_bean.getDrugInteractionDtls(drug_code, bean_1.getForm_code(order_id+order_line_no+drug_code), generic_id, start_date, end_date, patient_id).size()>2) { 											
									    	    
												form_code = bean_1.getForm_code(order_id+order_line_no+drug_code);
												form_desc = bean_1.getForm_descs(order_id+order_line_no+drug_code);
%>
											<td class='DINTERACN' width="20%" style="cursor:pointer" onClick="showDispInractionDtl('<%=patient_id%>','<%=encounter_id%>','<%=drug_code%>','<%=form_code%>','<%=generic_id%>','<%=start_date%>','<%=end_date%>','<%=java.net.URLEncoder.encode(drug_name,"UTF-8")%>','<%=java.net.URLEncoder.encode(form_desc,"UTF-8")%>','<%=order_id%>','<%=order_line_no%>','<%=(recCount)%>','<%=patient_class%>','')">&nbsp;</td>
											<!--order_id,order_line_no,(recCount),patient_class,review_called_from FOR IN070605-->
<% 
							            }
								       else{	
%>
								    	   <td class="white" width="20%">&nbsp;</td> 
<%						    	   
										   }
										}// Added for MMS-KH-CRF-0013 - End
										/* added for aakh-crf-0140 start */
								   	System.out.println("abuse_drug_override_reason"+abuse_drug_override_reason);
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
								<td class="<%=classvalue%>"  nowrap <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" >
<% 
//The following condition is for worksheet...
/*boolean hold_visible=true;
if(recCount!=1 && (!ws_type.equals("")))
	hold_visible=false;
// ends
if(hold_visible){*/
								if (hold_status.equals("disabled")){
%>
									<label style="color:grey;font-size:9px;" onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" onClick="callReason(this,'<%=order_id%>','<%=drug_code%>','<%=recCount%>','<%=order_line_no%>','A','<%=scope%>');" id='hold_remarks_<%=recCount%>'  <%=hold_status%> <%=disable_all%>  <%=disable_alloc_text_box%> <%=taper_disable%>><%=hold_text%></label>
									<input type="checkbox" name="hold<%=recCount%>" id="hold<%=recCount%>" style='display:none'  value="<%=check_value%>" <%=hold_status%> <%=check_status%>>

<%
								}
								else{
%>
									<label style="cursor:pointer;color:blue;font-size:9px;" onClick="callReason(this,'<%=order_id%>','<%=drug_code%>','<%=recCount%>','<%=order_line_no%>','A','<%=scope%>');notifyChange()" id='hold_remarks_<%=recCount%>' <%=disable_all%> <%=disable_alloc_text_box%> <%=taper_disable%>><%=hold_text%></label>
									<input type="checkbox" name="hold<%=recCount%>" id="hold<%=recCount%>" style='display:none'  value="<%=check_value%>" <%=check_status%>>
<%
								}
								//}
		
								if(ht_ws_allocated_batches.get(order_line_no) != null){	
%>
									<input type="hidden" name="drug_code<%=order_line_no%>" id="drug_code<%=order_line_no%>" value="<%=drug_code%>">	<!-- for worksheet -->
<%	
								}
%>
								<input type="hidden" name="fromdb_<%=recCount%>" id="fromdb_<%=recCount%>" value="<%=fromdb%>">
								<input type="hidden" name="hold_status<%=recCount%>" id="hold_status<%=recCount%>" value="<%=hold_status%>">

								</td>
								<!-- added for mms-dm-crf-0209.1 start -->
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
								<!-- added for mms-dm-crf-0209.1 end -->
<%  							//GHL-CRF-0549 - start
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
								
									if(hmBlgGrp!=null && hmBlgGrp.size()>0){
										if(hmBlgGrp.containsKey(drug_code)){
											preference = (String)hmBlgGrp.get(drug_code)==null?"":(String)hmBlgGrp.get(drug_code);
											preference_img = "";
											if(preference.equals("P1")){
												preference_img ="<img src='../../ePH/images/Preference1.jpg' height='15' width='15' title='Prefered-1 Item' />";
											}else if(preference.equals("P2")){
												preference_img ="<img src='../../ePH/images/Preference2.jpg' height='15' width='15' title='Prefered-2 Item' />";
											}else if(preference.equals("P3")){
												preference_img ="<img src='../../ePH/images/Preference3.jpg' height='15' width='15' title='Prefered3 Item' />";
											}else{
												preference_img ="<img src='../../ePH/images/Preference4.jpg' height='15' width='15' title='Non Prefered Item' />";
											}
										}else{
												preference_img ="<img src='../../ePH/images/Preference4.jpg' height='15' width='15' title='Non Prefered Item' />";
											}

									}/*else{
												preference_img ="<img src='../../ePH/images/Preference4.jpg' height='15' width='15'/>";
									}*/
								}//GHL-CRF-0618 - end

								
									
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
								<img src="../../ePH/images/HighMargin.jpg" style="<%=high_margin_grey_style%>" height='15' width='15' title="High Margin Item"  ><%}if(!innovator_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/Innovator.jpg" style="<%=innovator_style%>"  height='15' width='15' > <%} %></td>
								<%if(formulary_billing_app){ %>	<!-- //GHL-CRF-0618 -->							
									<td class="<%=classvalue%>"><%=preference_img%>&nbsp;</td>
<%									}
								}	
								%>
								

								<td class="<%=classvalue%>" style="font-size:9px;" <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" nowrap>
								<label style='color:red;font-size:12px;FONT-WEIGHT: BOLDER;cursor:pointer;' onclick="showDrugMasterValues('<%=drug_code%>');" id="drug_mast_det_<%=recCount%>">&nbsp;+&nbsp;</label>
								<label style="cursor:pointer;color:blue" onclick="showDrugDetails('<%=patient_class%>','<%=source_code%>','<%=order_id%>','<%=drug_code%>','<%=order_line_no%>','','<%=disp_locn_code%>','','', '<%=patient_id%>','Y','<%=generic_id%>','<%=order_line_status%>');" id="drug_desc<%=recCount%>"><%=drug_name%>&nbsp;<%=strength%></label>&nbsp;&nbsp; <!--  , 'patient_id' added for [IN:035667]  ('Y',generic_id Added for JD-CRF-0198 [IN058599])-->
<%  
								if ((ext_prod_id!=null) && !(ext_prod_id.equals(""))&& drug_db_interface_yn.equals("Y")){ 
%>
									<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/info.gif" height='20'  width='20' onClick="showDrugInfo('<%=ext_prod_id%>','<%=java.net.URLEncoder.encode(drug_name,"UTF-8")%>')"></img> <!-- Passing UTF-8 to drugname By Sandhya -->
<%  
								}
								if ((image_path!=null)&& !(image_path.equals(""))){%>

								<img style="cursor:pointer;" src="../../ePH/images/camera.gif" height='20'  width='20' onClick="showImage('<%=drug_code%>','<%=trade_code%>')">

<%  								}
								if(print_value.equals("1")){//GHL-CRF-0453
%>
								<img  src="../../ePH/images/printed_fully.gif" height='20'  width='20' onmouseover = "showToolTipPrint(this,'Fully Printed')"></img>
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
								if(count>1){
									taper = bean.getTapervalue();
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
									if(totalTaperQtyDisplay.equals("Y")){
%>
										<fmt:message key="Common.total.label" bundle="${common_labels}"/><fmt:message key="Common.Taper.label" bundle="${common_labels}"/><fmt:message key="Common.Qty.label" bundle="${common_labels}"/>
										<label>-<%=(int)tot_tap%>&nbsp;&#40;<%=qty_uom_disp%>&#41;</label>
<%				
									}}
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
									//drug_name = java.net.URLEncoder.encode(drug_name,"UTF-8");//IN071555 commented for SKR-SCF-1338
									if(barcode_scan_for_alt_app && iv_prep_yn.equals("")){//changed intractn_req_yn to  barcode_scan_for_alt_app for MMS-KH-CRF-0030
					%> 
	    <!--<img src="../../ePH/images/altenate.jpg" height='15' width='15' align='top' onClick="callMultiStrength('<%=drug_code%>','<%=drug_name_1%>','<%=patient_id%>','<%=order_id%>','<%=order_line_no%>','Alloc','<%=store_code%>','<%=pres_qty%>','<%=end_date%>','<%=strength_uom%>','<%=recCount%>','<%=alt_drug_remarks_ind%>','<%=expiry_date%>','<%=disp_locn_catg%>','<%=allow_alternate_yn%>','<%=item_type_site_app%>','<%=strength_value%>','<%=iv_prep_yn%>','<%=alt_called_from%>','<%=disp_stage%>','Y');" style='cursor:pointer' title='<fmt:message key="ePH.AlternateDrugs.label" bundle="${ph_labels}"/>'>  -->
		<img src="../../ePH/images/altenate.jpg" height='15' width='15' align='top' style='cursor:pointer' onClick="getAlternateDrug('<%=drug_code%>','','<%=patient_id%>','<%=order_id%>','<%=order_line_no%>','Fill','<%=store_code%>','<%=pres_qty%>','<%=end_date%>','<%=strength_uom%>','<%=recCount%>','','<%=expiry_date%>','<%=disp_locn_catg%>','<%=allow_alternate_yn%>','<%=item_type_site_app%>','<%=strength_value%>','<%=iv_prep_yn%>','<%=alt_called_from%>','<%=disp_stage%>','Y','<%=classvalue%>','<%=generic_id%>','<%=barcodeScan%>')" title='<fmt:message key="ePH.AlternateDrugs.label" bundle="${ph_labels}"/>'>
		<!-- Y passed for MMS-KH-CRF-0030-->
		<%
			}
								if(bmscount==0){
									if(pat_couns_reqd_yn.equals("Y")){
										pat_reqd="Checked";	
%>
										<img src="../../ePH/images/Patientcounsel.gif" valign="center"  ></img>
										<input type='checkbox' name='pat_reqd_<%=recCount%>' id='pat_reqd_<%=recCount%>' <%=pat_reqd%> value='C' disabled onclick="CheckPatReqd(this)">
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
								disp_info	=	bean.getLastDispense(order_id,order_line_no);

								if(bDrugOrder){
									if(disp_info.size() > 0) {				
										if( ((String)disp_info.get(1)).equals("Y")) {
											dosage_dtls =dosage_dtls+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color='red'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DispensedToday.label","ph_labels")+"</font>";
										}
										dosage_dtls =dosage_dtls+"&nbsp;&nbsp;&nbsp;&nbsp;<font color='red'style='cursor:pointer;' title='"+disp_info.get(0)+"' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.LastDispense.label","ph_labels")+"</font>";
									}
%>
									<%=alt_drug_remarks_disp%>&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=dosage_dtls%><!-- <%=alt_drug_remarks_disp%> Added For Bru-HIMS-CRF-082 [IN:029948]  -->
<% 
								}
%>
				<!-- MMS-KH-CRF-0030 start -->
				<div id="alternate_<%=recCount%>" style="display:none">
				 <table cellpadding="0" cellspacing="0" width='100%' align="center" border="1" id="alternate_header_<%=recCount%>">
				 
 			<!--	<tr> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<td class="<%=classvalue%>" width="20%"  style='text-align:right;'><font style='font-size:10px;vertical-align: text-top;'>Barcode</font> <input type="text" class='fields' name="barcode_id_<%=recCount%>" id="barcode_id_<%=recCount%>" style="text-align:right"  onkeydown="if (event.keyCode==13) {}" maxlength="50"  >
					</td>

					</tr>

				 <tr>
					<td class= "<%=classvalue%>" width="30%"><fmt:message key="ePH.AlternateDrugNames.label" bundle="${ph_labels}"/></td>

				 <td class= "<%=classvalue%>" width="30%"><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
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
				<!-- MMS-KH-CRF-0030 end-->
								<br><label id="id_min_stk_label" style='<%=min_stk_flag%>;'><fmt:message key="ePH.MINLEVEL.label" bundle="${ph_labels}"/>:</label><!--Added AMS-CRF-0068.1 [IN:050333] start  -->
								<label id="id_min_str_stk_<%=recCount%>" style='<%=min_stk_flag_bkg_clr%>;<%=min_stk_flag%>;'><b><%=frm_store_min_stk_level%></b></label>&nbsp;&nbsp;
								<label id="id_stk_rol_label_<%=recCount%>" style='<%=rol_flag%>;'><fmt:message key="ePH.ROL.label" bundle="${ph_labels}"/>:</label>
								<label  id="id_stk_rol_<%=recCount%>" style='<%=rol_flag_bkg_clr%>;<%=rol_flag%>;'><b><%=frm_store_reorder_level%></b></label>&nbsp;
								<label class='HYPERLINK'  name = "request_<%=recCount%>"  onmouseover="changeCursor(this);" onclick="request();" id="sales_req_label" style='<%=disp_req_flag%>;' ><b><fmt:message key="ePH.CreateRequest.label" bundle="${ph_labels}"/></b></label><!--Added AMS-CRF-0068.1 [IN:050333] end  -->
								<label class='HYPERLINK'  name = "manufacturing_<%=recCount%>"  onmouseover="changeCursor(this);" onclick="callManufacturingReceipt('<%=drug_code%>','<%=disp_locn_code%>');" id="manufacturing_Recpt" style='<%=disp_mnf_flag%>;' ><b>&nbsp;&nbsp;<fmt:message key="eST.Manufacturing.label" bundle="${ph_labels}"/></b></label><!--Added BRU-HIMS-CRF-080 -->
<%
								k	=	0;
								alt_qty	=	new ArrayList();
								drug_name_1=  drug_name; 
								alt_external_prod_id ="";
										
								/* Commented By Sandhya frm .line num:1271 to 1276 on 24/Nov/2010 for getting Drug name into Thai onclick of PharmacistInstructions Link
								if(!drug_name_1.equals("")&&drug_name_1!=null){
									drug_name_1=drug_name_1.replaceAll(" ","%20");
									drug_name_1=	java.net.URLEncoder.encode(drug_name_1,"UTF-8");
									drug_name_1=drug_name_1.replaceAll("%2520","%20");
							   }*/
								for(int n=0; n<multi_drugs.size(); n+=5)	{ 
									alt_drug_code	=	(String)multi_drugs.get(n);
									alt_drug_desc	=	(String)multi_drugs.get(n+1);
									altDrugName.put(alt_drug_code,alt_drug_desc);// Added for Bru-HIMS-CRF-072.1 [IN:049144]
									form_code		=	(String)multi_drugs.get(n+2);
									alt_strength_value		=	(String)multi_drugs.get(n+3);
									String alt_drug_desc_1	=    alt_drug_desc;
									//if else condition added for ML-BRU-SCF-0179 [IN:032578]
									if(!disable_all.equals("disabled")){	
										bEditLabelEnabled = true;
									}
									else{
										bEditLabelEnabled = false;
									}
									//Commented code from 1326 to 1330 regarding incident num:25007 on 19/Nov/2010==By Sandhya
									/*if(!alt_drug_desc_1.equals("")&&alt_drug_desc_1!=null){
										alt_drug_desc_1=alt_drug_desc_1.replaceAll(" ","%20");
										alt_drug_desc_1=	java.net.URLEncoder.encode(alt_drug_desc_1);
										alt_drug_desc_1=alt_drug_desc_1.replaceAll("%2520","%20");
									}*/

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
									drug_color		=	(String)colors.get(k++);
									qty				=	bean.getAlternateDrugQuantity(patient_id,order_id,order_line_no,alt_drug_code); 
									if(!qty.equals("") && !qty.equals("0")) {
										alt_qty.add(alt_drug_code);
										alt_qty.add(qty);
										alt_qty.add(form_code);
										alt_qty.add(alt_strength_value);
									}
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
												qty=(String)hmStockAvailabilityStatus.get("available_stock");
											}
											catch (Exception e){
												qty = "0";
											}
											if(qty.equals(""))
												qty="0";
											if(!frm_store_min_stk_level.equals("0")){
										         if (Double.parseDouble(qty)  <  Double.parseDouble(frm_store_min_stk_level)){
												min_stk = true;
					                         	if(getReq_allowed_yn)
												disp_req_flag =  "display:inline;color:blue";
												else
												disp_req_flag = "display:none";
											 }
										         
											}
											if(!frm_store_reorder_level.equals("0")){
												if (Double.parseDouble(qty)  <  Double.parseDouble(frm_store_reorder_level)){
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
									<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style='color:red;font-size:12px;FONT-WEIGHT: BOLDER;cursor:pointer;' onclick="showDrugMasterValues('<%=alt_drug_code%>');" id="drug_mast_det_<%=recCount%>">&nbsp;+&nbsp;</label><label style="cursor:pointer;color:<%=drug_color%>" onclick="callDrugDetails('<%=patient_id%>','<%=order_id%>','<%=drug_code%>','<%=alt_drug%>','<%=alt_drug_code%>','<%=drug_color%>','<%=form_code%>','');changeColor(this);" id="alte_drug_desc<%=n%>"><%=alt_drug_desc%></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!-- code '<%=drug_name_1%>','<%=alt_drug_desc_1%>', removed for TTM-SCF-0096[IN048808]-->
<%
									if ((alt_external_prod_id!=null)&& !(alt_external_prod_id.equals(""))&& drug_db_interface_yn.equals("Y")){ 
%>
										<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/info.gif" height='20'  width='20' onClick="showDrugInfo('<%=alt_external_prod_id%>','<%=java.net.URLEncoder.encode(alt_drug_desc_1,"UTF-8")%>')"></img> <!-- Passing UTF-8 to alt_drug_desc_1 for the incident num:25007 By Sandhya -->
<%  
									}
									adr_count = bean.getADRCount(patient_id,alt_drug_code);
									if(adr_count>0){
%>
										<img  id="ADR_img" src='../../ePH/images/ADR.gif'  height='20'  width='20' title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>' onclick= "callADRdetails('<%=patient_id%>','<%=alt_drug_code%>')"></img><!-- callADRdetails() newly added for RUT-SCF-0144 [IN:033371]-->
<%
									}
									//if condition added for ML-BRU-SCF-0179 [IN:032578]
									if(bEditLabelEnabled){
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
										hmEditLabelValues.put("alt_drug_count", (multi_drugs.size()/5)+""); //Added for Bru-HIMS-CRF-414- ML-BRU-SCF-1528 [IN:053217]
										alEditLabelPair.add(hmEditLabelValues);

										bEditLabelEnabled = false;
										bean.setSPerformPractId(performing_pract_id);
									}
%>
									<br><label id="id_min_stk_label" style='<%=min_stk_flag%>;'><fmt:message key="ePH.MINLEVEL.label" bundle="${ph_labels}"/>:</label><!--Added AMS-CRF-0068.1 [IN:050333] start  -->
									<label id="id_min_str_stk" style='<%=min_stk_flag_bkg_clr%>;<%=min_stk_flag%>;'><b><%=frm_store_min_stk_level%></b></label>&nbsp;&nbsp;
									<label id="id_stk_rol_label" style='<%=rol_flag%>;'><fmt:message key="ePH.ROL.label" bundle="${ph_labels}"/>:</label>
									<label  id="id_stk_rol" style='<%=rol_flag_bkg_clr%>;<%=rol_flag%>;'><b><%=frm_store_reorder_level%></b></label>&nbsp;
									<label class='HYPERLINK'  name = "request"  onmouseover="changeCursor(this);" onclick="request();" id="sales_req_label" style='<%=disp_req_flag%>;' ><b><fmt:message key="ePH.CreateRequest.label" bundle="${ph_labels}"/></b></label><!--Added AMS-CRF-0068.1 [IN:050333] end  -->
<%
								}
%>
<%
	         if(drug_expiry_alert.equals("Yes") && !drug_expiry_days.equals("")){//Added for TH-KW-CRF-0008
%>
                   <label style="color:darkred" id="expiry_aler_lb_<%=recCount%>">&nbsp; This drug has batches which are going to expire in <%=drug_expiry_days%> Days </label>
<%}%>
								</td>       
								<!-- Passed URLEncoder,UTF-8  for drug name in displayInstructions regarding incident num:25276 ==By sandhya -->		
								<td class="<%=classvalue%>" style="font-size:9px" <%=title%> >
									 <img src="../../ePH/images/DrugRemarks.gif" id='drugRemarks_<%=recCount%>' title='' valign="center"style="cursor:pointer;" onClick="displayInstructions('<%=order_id%>','<%=order_line_no%>','<%=dialog_height%>','<%=java.net.URLEncoder.encode(drug_name_1,"UTF-8")%>')"<%=remarks_style%>>
								</td>
							   <script>
									var drug_remarks = decodeURIComponent('<%=strDrugsRemarks%>');
									eval(document.getElementById("drugRemarks_"+'<%=recCount%>')).title= drug_remarks ;
							   </script>
								<td class="<%=classvalue%>" style="font-size:9px" title="<%=pres_details%>">
										<img src="../../ePH/images/exceed.gif" valign="center">
								</td>
								<td class="<%=classvalue%>" style="font-size:9px" <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" >&nbsp;<label style='<%=narc_style%>'><%=retunFormatedInt(pres_qty)%>&nbsp;(<%=qty_uom_disp%>)</label><br>&nbsp;
								<!---/*bean.getUomDisplay(facility_id,qty_uom)*/-->
<%
								if(order_type.equals("TA")){
									bean.setTPNPresQty(pres_qty);
								}
								if(!strength_value.equals("") && !strength_value.equals("0")) //IN073688
								{
								    pres_strength	=	retunFormatedInt(((Float.parseFloat(pres_qty) * Float.parseFloat(strength_value))*(main_drug_pack_size))/(Float.parseFloat(main_strength_per_value_pres_uom))+"")+" "+strength_uom;
									pres_strength_1 = retunFormatedInt(((Float.parseFloat(pres_qty) * Float.parseFloat(strength_value))*(main_drug_pack_size))/(Float.parseFloat(main_strength_per_value_pres_uom))+"")+"";
								}
								
 
								if(multi_drugs.size()>1 ) { 
%>
									<b><%=pres_strength%></b>
<%	
								}
%>
								</td>
<% 		
								if(multi_drugs.size() > 1 ) {	
									if((ord_type.equals("NOR") || bEquivalentNormalOrder) && bean_1.getIssueByUOM().equals("I")  && !disable_all.equals("disabled")){
%>
										<td class="<%=classvalue%>">&nbsp;</td>
<%					
									}
%>			
									<td class="<%=classvalue%>" <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" ><br>
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
										drug_color	=	(String)colors.get(x++);

										pack_dtls				=	bean.getPackSize(alternate_drug);
										
										IssueUOMAndBaseUOM		=	(HashMap)bean.getStoreDfltIssueUOMAndBaseUOM(store_code,alternate_drug); // Added for ML-BRU-SCF-1803 - Start
										base_uom			     =  (String)IssueUOMAndBaseUOM.get("BASE_UOM")==null?"":(String)IssueUOMAndBaseUOM.get("BASE_UOM");
										base_to_disp_uom_equl    =	bean.getEqulValue ( alternate_drug, base_uom, uom);
										orig_dflt_issue_uom      = (String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM")==null?"":(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM");
										base_to_def_uom_equl	 =  bean.getEqulValue ( alternate_drug, base_uom, orig_dflt_issue_uom);
										medical_applicable=bean.checkMedicalItemYN(alternate_drug);//added for ghl-crf-0548
										if(!uom.equals(base_uom)){
											conv_factor    = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
											//bean.setAlternateDrugQtyForCharge(patient_id,order_id,order_line_no,alt_drug_code,(Double.parseDouble(qty)*conv_factor)+"");//Commented for MMS-DM-SCF-0570
										} // Added for ML-BRU-SCF-1803 - End

										if(pack_dtls!=null && pack_dtls.containsKey("PACK_SIZE")){
											if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
												pack_size			=	Float.parseFloat(((String)pack_dtls.get("PACK_SIZE")));
												if(!medical_applicable.equals("Y")){//added for ghl-crf-0548
												strength_per_value	=	Float.parseFloat(((String)pack_dtls.get("STRENGTH_PER_VALUE_PRES_UOM")));}
											 if(base_to_disp_uom_equl!=base_to_def_uom_equl ){ // if condition Added for ML-BRU-SCF-1892 // || (!uom.equals(base_uom) && !alternate_drug.equals("")) Added for ML-MMOH-SCF-1160
											   // qty = Math.round(Integer.parseInt(qty)/pack_size)+"";//added for ML-BRU-SCF-1443 //commneted for MMS-KH-SCF-0035
											   //|| (!uom.equals(base_uom) && !alternate_drug.equals("")) removedf or ML-MMOH-SCF-1318
												qty = Math.ceil(Float.parseFloat(qty)/pack_size)+"";//Added for 
							 //ML-BRU-SCF-1443 and removed math.round(Integer.parseInt Math.ceil(Float.parseFloat to math.ceil for MMS-KH-SCF-0035
											 }else if(!uom.equals(base_uom) && !alternate_drug.equals("")){ // else if block added for ML-MMOH-SCF-1318 - Start							
												  qty  =   Math.round(Double.parseDouble(qty)/base_to_disp_uom_equl)+""; 
											 }
											}		
										}
										if(!medical_applicable.equals("Y")){//added for ghl-crf-0548
										tmp_alloc	+=	new Float( ((Float.parseFloat(alt_strength_value)) * Double.parseDouble(qty)*pack_size)/strength_per_value ).doubleValue();
										alloc_strength	=	retunFormatedInt(tmp_alloc+"")+""+strength_uom;
										}
												float prescribed_strength=0;//modified for ghl-crf-0548
										if(!medical_applicable.equals("Y")){//added for ghl-crf-0548		
										 prescribed_strength	=	Float.parseFloat(tmp_bms_qty_1) * 	Float.parseFloat(strength_value)/Float.parseFloat(main_strength_per_value_pres_uom);
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
											uom			=	"("+bean.getUomDisplay(facility_id,uom)+")";
											tot_qty		+=	Double.parseDouble(qty);
										}
										/*==========code added to handle if dispense uom and default uom in item store is different=================*/
										issue_qty_dtl =new StringBuffer();
										if(IssueUomQty.containsKey(order_id+order_line_no+alternate_drug+"_qty")){
											issue_qty_value	= (String)IssueUomQty.get(order_id+order_line_no+alternate_drug+"_qty");
											issue_uom	    = (String)IssueUomQty.get(order_id+order_line_no+alternate_drug+"_uom");
											issue_uom_desc	= (String)IssueUomQty.get(order_id+order_line_no+alternate_drug+"_desc");
											issue_uom_equl  = (String)IssueUomQty.get(order_id+order_line_no+alternate_drug+"_equl");
											if(bean_1.getIssueByUOM().equals("I")){
												issue_qty_dtl   =  issue_qty_dtl.append("( ").append(issue_qty_value).append("  ").append(issue_uom_desc).append(" )");
											}
										}/*==========ends here=========================================================================================*/
%>
										<label style="color:<%=drug_color%>;font-size:9px" id="alloc_qty<%=tmp_recCount%>">&nbsp;<%=retunFormatedInt(qty)%>&nbsp;<%=uom%><%=issue_qty_dtl.toString()%><br>
<%	
										tmp_recCount++;
										
										if(!scope.equals("H") && scope!=null){
											if(( !qty.equals("") && !qty.equals("0")) && (Float.parseFloat(bms_qty) == 0 || !complete_ord_yn)){ //&&  Float.parseFloat(bms_qty) == 0 added forKAUH-SCF-0096 [IN:035355] // !complete_ord_yn Added for ML-MMOH-SCF-0356.1
												disable_complete_order	=	"disabled"; 
											}
											else{
												disable_complete_order	=	""; 
											}
										}
										hsh_med_plan = new LinkedHashMap();// Added for Bru-HIMS-CRF-072.1 [IN:049144] start
										hsh_med_plan.put("qty",qty);
										if(!qty.equals("") && !qty.equals("0") && drug_trade_bean.getDrugyesno().equals("Y") && bean_1.getMedicationPlannerYN().equals("Y") && patient_class.equals("OP"))	{
											if(!alt_qty.contains(drug_code)){
												medplan_bean.getMedPlan_DrugDetails().remove(order_id+"_"+order_line_no+"_"+drug_code+"_"+primary_lang_id);
												medplan_bean.getMedPlan_Local_DrugDetails().remove(order_id+"_"+order_line_no+"_"+drug_code+"_"+loc_lang_id);
											}
											arrOrderId.add(order_id+"_"+order_line_no);
											dosedet[0] = "";dosedet[1] = "";dosedet[2] = "";dosedet[3] = "";dispno[0]="";dispno[1]="";
											dosedetlocal[0] = "";dosedetlocal[1] = "";dosedetlocal[2] = "";dosedetlocal[3] = "";
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
											hsh_med_plan.put("qty_issuelocal",dfToInteger.format(Double.parseDouble(qty))+" "+medplan_bean.getUOMDesc((String)alt_qty.get(l+2),loc_lang_id)); 
											hsh_med_plan.put("qty_issue",dfToInteger.format(Double.parseDouble(qty))+" "+medplan_bean.getUOMDesc((String)alt_qty.get(l+2),primary_lang_id));
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
%>
									<!-- Passed URLEncoder,UTF-8  for drug name in callbatchdetails regarding incident num:25276 ==By sandhya -->
									</label>&nbsp;<label style="font-size:9px;color:black"><b><%=alloc_strength%></b></label><input type="hidden" name="alloc_strength<%=recCount%>" id="alloc_strength<%=recCount%>" value="<%=retunFormatedInt(qty)%>"><br><label style="cursor:pointer;color:blue;font-size:9px;"  onClick="javascript:callbatchdetails('<%=patient_id%>','<%=order_id%>','<%=order_line_no%>','<%=drug_code%>','Y','<%=java.net.URLEncoder.encode(drug_name_1,"UTF-8")%>')"><fmt:message key="ePH.Trades.label" bundle="${ph_labels}"/></label></td>
<%	
								}
								else if(!tpn_finalize.equals("")){
									String tpn_qty=bean.getTPNQty();
									String tpn_qty_uom=bean.getTPNQtyUOM();
									if(tpn_qty.equals("0")){
										tpn_qty="";
										tpn_qty_uom="";
									}
%>
									<td class="<%=classvalue%>" style="font-size:9px" <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" >
									<label class="label" id="alloc_qty<%=recCount%>" style="font-size:9px"><b>&nbsp;<%=tpn_qty%>&nbsp;<%=bean.getUomDisplay(facility_id,tpn_qty_uom)%></b><br></label>
<%
								}
								else if(ws_tot_qty != 0 ){								// THIS IS FOR WORKSHEET
%>
									<td class="<%=classvalue%>" style="font-size:9px" <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" >
									<label class="label" id="alloc_qty<%=recCount%>" style="font-size:9px"><b>&nbsp;<%=ws_tot_qty%>&nbsp;<%=qty_uom_disp%></b><br></label>
									<!--/*bean.getUomDisplay(facility_id,qty_uom)*/-->

									</td>
<%
								}
								else{	
									if(qty.equals("") || qty.equals("0")) {
										qty	=	"";
										uom	=	"";	
									}
									else {
										if(!strength_value.equals("") && !strength_value.equals("0")){
											alloc_strength	=	Float.parseFloat(strength_value) * Double.parseDouble(qty)+"";
										}
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
								}*/ //Commented for ML-BRU-SCF-1015 [IN:043355]
								/* Commented for RUT-CRF-0088 [IN036978] 
								if(taper_order_yn.equals("Y") && !taper_order_id.equals("") && !taper_order_line_num.equals("")){ //if block added to avoid displaying qty for tapered drugs
									qty = "0";
									bms_qty = "0";
								}*/
								String uom_desc = "";//Added for AAKH-SCF-0338
								String issueUomDisbYn = ""; // Added for MMS-DM-SCF-0488 - Reopen Issue - Start
								if(!last_scanned.equals("") && (ord_type.equals("NOR") || bEquivalentNormalOrder) && bean_1.getIssueByUOM().equals("I")){
									issueUomDisbYn = "disabled";
								}  // Added for MMS-DM-SCF-0488 - End
%>
								<td align="left" CLASS="<%=classvalue%>" style='<%=display_list%>'>&nbsp;
									<select onChange="calculateIssueUOM(this,'<%=recCount%>','<%=order_id+order_line_no+drug_code+"_uom"%>');" name="issue_uom_select_<%=recCount%>" <%=issueUomDisbYn%>> <!-- // issueUomDisbYn Added for MMS-DM-SCF-0488 - Reopen Issue -->
<% 
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
									<input type ="hidden" name ="issueUOMValue_<%=recCount%>" value = "<%=order_id+order_line_no+drug_code+"_uom"%>">
									<label id="item_desc_3" style="font-weight:bold"></label>
									</td>

									<td class="<%=classvalue%>" <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" >
										<input type="hidden" name="AllowMoreThanPresQty<%=recCount%>" id="AllowMoreThanPresQty<%=recCount%>"  value="<%=hmAllowMoreQty.get(drug_code)%>">
<%
										if( (ord_type.equals("NOR") || bEquivalentNormalOrder)){
											if(bean_1.getBarcode_Scan_YN().equals("Y") || (bean_1.getBarcode_Scan_YN().equals("N") && barcode_id.equals(""))) // Added for [IN:064158] - Start
				                        		                 if(qty.equals("0.0") || qty.equals("") ||  qty.equals("0"))
				                        			               qty = "0.0";  // Added for [IN:064158] - End // "" modified to "0.0" for GHL-CRF-0463
											if( stock_opt.get(0).equals("Y")){
												 if(in_formulary_yn.equals("Y")){													 
%>
													<input type="text" class="flat" size="6" style="text-align:right"  <%=alloc_readonly%>   onKeyPress="return allowValidNumber(this,event,6,0);"  maxlength="5" name="alloc_qty_<%=recCount%>" value="<%=  retunFormatedInt(qty)%>" oncopy="return false" onpaste="return false"  onchange="if(checkAllocBmsSecondStage('<%=recCount%>', this)){checkValue(this); setbatchdetails(this,'<%=store_code%>','<%=base_uom%>','<%=end_date%>','<%=item_code%>','<%=trade_code%>','<%=patient_id%>','<%=order_id%>','<%=order_line_no%>','<%=uom%>','<%=billing_interface_yn%>','<%=drug_code%>','<%=act_bms_qty%>','<%=retunFormatedInt(qty)%>','<%=recCount%>')};" <%=disable_all%> <%=taper_disable%> > 
<%
													bean_1.setStockDtlKey(drug_code+"qty",retunFormatedInt(qty));//Added for KDAH-CRF-0231 [IN-034551]
													if(bean_1.getStockDtl().containsKey("valid_drug_code") && (order_id+"~"+order_line_no+"~"+drug_code).equals((String) bean_1.getStockDtl().get("valid_drug_code"))){ //if block added for KDAH-CRF-0231 [IN-034551] 
%>
														<script>
															document.getElementById("alloc_fromBarCode").value="Y";
															<!--document.getElementById("alloc_qty_")<%=recCount%>.focus(); commented for GHL-CRF-0413.1 [IN:061794] and added color for GHL-CRF-0413.1 [IN:061794]-->
														<% if(bean_1.getBarcodeColorYn(order_id,order_line_no).equals("Y")){ // condition Added for MMS-DM-SCF-0488 %>
															document.getElementById("alloc_qty"<%=recCount%>).style.backgroundColor = "#ADFF2F";
														<%}%>
														</script>
<%
														bean_1.setStockDtlKey(drug_code+"qty",retunFormatedInt(qty));//Added for KDAH-CRF-0231 [IN-034551]
													}
												}
												else{
%>
													<input type="text" class="flat" size="6" style="text-align:right"onKeyPress="return allowValidNumber(this,event,6,0);"  maxlength="5" <%=alloc_readonly%> name="alloc_qty_<%=recCount%>" value="" disabled>
<%
												}
%>
												<input type ="hidden" name = "alloc_qty_hidden_<%=recCount%>" value ="document.DispMedicationAllStages.alloc_qty_<%=recCount%>~<%=store_code%>~<%=base_uom%>~<%=end_date%>~<%=item_code%>~<%=trade_code%>~<%=patient_id%>~<%=order_id%>~<%=order_line_no%>~<%=uom%>~<%=billing_interface_yn%>~<%=drug_code%>~<%=act_bms_qty%>~<%=retunFormatedInt(qty)%>~<%=recCount%>">
												<!-- Passed URLEncoder,UTF-8  for drug name in callbatchdetails regarding incident num:25276 ==By sandhya -->
												<label class="label" ><b>&nbsp;<%=bean.getUomDisplay(facility_id,uom)%></b></label><br><label id="issue_uom_lbl<%=recCount%>" class="label" style style='font-size:9px' ><b>&nbsp;<%=issue_qty_dtl.toString()%></b></label><br><label style="cursor:pointer;color:blue;font-size:9px;"  onClick="javascript:callbatchdetails('<%=patient_id%>','<%=order_id%>','<%=order_line_no%>','<%=drug_code%>','N','<%=java.net.URLEncoder.encode(drug_name_1,"UTF-8")%>')"><fmt:message key="ePH.Trades.label" bundle="${ph_labels}"/></label> 
										 
												<input type="hidden" name="issue_uom<%=recCount%>" id="issue_uom<%=recCount%>"     value="<%=uom%>">
												<input type="hidden" name="issue_qty_old<%=recCount%>" id="issue_qty_old<%=recCount%>" value="<%=retunFormatedInt(qty)%>">
												<input type="hidden" name="issue_uom_qty<%=recCount%>" id="issue_uom_qty<%=recCount%>" value="<%=issue_qty_value%>">
												<input type="hidden" name="issue_uom_uom<%=recCount%>" id="issue_uom_uom<%=recCount%>" value="<%=issue_uom%>">
												<input type="hidden" name="issue_uom_desc<%=recCount%>" id="issue_uom_desc<%=recCount%>"value="<%=issue_uom_desc%>">
												<input type="hidden" name="issue_uom_equl<%=recCount%>" id="issue_uom_equl<%=recCount%>"value="<%=issue_uom_equl%>">
												<input type="hidden" id="last_scanned_<%=recCount%>" value="<%=last_scanned%>"> <!-- Added for GHL-CRF-0463 // changed for MMS-DM-SCF-0488 -->
<%
											}
											else{ 
												if(in_formulary_yn.equals("Y")){	 
%>
													<input type="text" class="flat" size="6" style="text-align:right"onKeyPress="return allowValidNumber(this,event,6,0);"  maxlength="5" <%=alloc_readonly%> name="alloc_qty_<%=recCount%>" value="<%=retunFormatedInt(qty)%>" onblur="includeToBms(this,'<%=recCount%>')" <%=disable_all%> <%=taper_disable%>>
<%
												}
												else{
%>
													<input type="text" class="flat" size="6" style="text-align:right"onKeyPress="return allowValidNumber(this,event,6,0);"  maxlength="5" <%=alloc_readonly%> name="alloc_qty_<%=recCount%>" value="" onblur="includeToBms(this,'<%=recCount%>')" disabled>
<%
												}
%>
												<input type="hidden" name="issue_uom<%=recCount%>" id="issue_uom<%=recCount%>" value="<%=uom%>">
												<input type="hidden" name="issue_qty_old<%=recCount%>" id="issue_qty_old<%=recCount%>" value="<%=retunFormatedInt(qty)%>">
												<input type="hidden" name="issue_uom_qty<%=recCount%>" id="issue_uom_qty<%=recCount%>" value="<%=issue_qty_value%>">
												<input type="hidden" name="issue_uom_uom<%=recCount%>" id="issue_uom_uom<%=recCount%>" value="<%=issue_uom%>">
												<input type="hidden" name="issue_uom_desc<%=recCount%>" id="issue_uom_desc<%=recCount%>"value="<%=issue_uom_desc%>">
<%
											}
										}
										else{
%>
											<label class="label" id="alloc_qty<%=recCount%>"><b>&nbsp;<%=retunFormatedInt(qty)%>&nbsp;<%=bean.getUomDisplay(facility_id,uom)%></b></label><br><label id="issue_uom_lbl<%=recCount%>" class="label" style style='font-size:9px' ><b>&nbsp;<%=issue_qty_dtl.toString()%></b></label>
											<% if(bean_1.getBarcodeColorYn(order_id,order_line_no).equals("Y")){ // condition Added for MMS-DM-SCF-0488 %><script>
												document.getElementById("alloc_qty"<%=recCount%>).style.backgroundColor = "#ADFF2F";
														<%}%>
														</script>
											 <input type="hidden" name="issue_uom<%=recCount%>" id="issue_uom<%=recCount%>" value="<%=uom%>">
											<input type="hidden" name="issue_qty_old<%=recCount%>" id="issue_qty_old<%=recCount%>" value="<%=retunFormatedInt(qty)%>">
											<input type="hidden" name="issue_uom_qty<%=recCount%>" id="issue_uom_qty<%=recCount%>" value="<%=issue_qty_value%>">
											<input type="hidden" name="issue_uom_uom<%=recCount%>" id="issue_uom_uom<%=recCount%>" value="<%=issue_uom%>">
											<input type="hidden" name="issue_uom_desc<%=recCount%>" id="issue_uom_desc<%=recCount%>"value="<%=issue_uom_desc%>">
<%  
											if(!qty.equals("")){
%>	
												<!-- Passed URLEncoder,UTF-8  for drug name in callbatchdetails regarding incident num:25276 ==By sandhya -->
												<br><label style="cursor:pointer;color:blue;font-size:9px;"  onClick="javascript:callbatchdetails('<%=patient_id%>','<%=order_id%>','<%=order_line_no%>','<%=drug_code%>','N','<%=java.net.URLEncoder.encode(drug_name_1,"UTF-8")%>')"><fmt:message key="ePH.Trades.label" bundle="${ph_labels}"/></label>
<%
											}
										}
										hsh_med_plan = new LinkedHashMap();// Added for Bru-HIMS-CRF-072.1 [IN:049144] start
										hsh_med_plan.put("qty",qty);
										if(!qty.equals("") && !qty.equals("0") && drug_trade_bean.getDrugyesno().equals("Y") && bean_1.getMedicationPlannerYN().equals("Y") && patient_class.equals("OP"))	{
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
%>
										<input type="hidden" name="alloc_strength<%=recCount%>" id="alloc_strength<%=recCount%>" value="<%=retunFormatedInt(qty)%>"></td>
<% 
										if(!scope.equals("H") && scope!=null){
											if((!qty.equals("") && !qty.equals("0")) && (Float.parseFloat(bms_qty) ==0 || !complete_ord_yn) ){ //  && Float.parseFloat(bms_qty) == 0 added forKAUH-SCF-0096 [IN:035355] // !complete_ord_yn Added for ML-MMOH-SCF-0356.1
											   disable_complete_order	=	"disabled"; 
											}
											else{
												disable_complete_order	=	"";   
											}		
										}	
									}
									if(multi_drugs.size() <= 1 ) {
										if(ws_tot_qty != 0){
											bms_qty	=	Float.parseFloat(bms_qty)- ws_tot_qty +"";
										}
										else if(!qty.equals("") && !qty.equals("0")){
											if( !bean_1.getBarcode_multi_id().equals("Y"))
												bms_qty	=	Float.parseFloat(bms_qty)- tot_qty +"";
										}
									}
											
									if(!strength_value.equals("") && !alt_strength_value.equals("")) {
										if(bms_strength.equals(""))
										bms_strength		=	Float.parseFloat(bms_qty) * Float.parseFloat(strength_value)*(main_pack_size)+"";

									}
									else if(!strength_value.equals("") && !strength_value.equals("0")) {
									  bms_strength		=	"";
									  strength_uom		=	"";
									}
									else {
										strength_uom	=	"";
									}
									if(bms_strength.equals("0.0")||bms_strength.equals("0")||bms_qty.equals("0.0")||bms_qty.equals("0")){
										bms_strength="";
										strength_uom="";
									}
									if(Float.parseFloat(bms_qty)<0){
										bms_qty ="0";
									}
%>
									<td class="<%=classvalue%>"  style="font-size:9px" <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" >&nbsp;
									<label class="label" id="bms_qty_<%=recCount%>">&nbsp;<%=retunFormatedInt(bms_qty)%>&nbsp;</label><input type="hidden" name="bms_qty<%=recCount%>" id="bms_qty<%=recCount%>" value="<%=retunFormatedInt(bms_qty)%>"><input type="hidden" name="qty_uom<%=recCount%>" id="qty_uom<%=recCount%>" value="<%=qty_uom%>">(<%=qty_uom_disp%>)<br>&nbsp;<b><%=bms_strength%>&nbsp;<%=strength_uom%></b>
									<!--/*bean.getUomDisplay(facility_id,qty_uom)*/-->
<%
									bms_strength="";
									strength_uom="";
									if(stock_opt.size()>0){
%>
										<input type="hidden" name="stock_availability_check<%=recCount%>" id="stock_availability_check<%=recCount%>" value="<%=stock_opt.get(0)%>">
<%
									}
									else{
%>
										<input type="hidden" name="stock_availability_check<%=recCount%>" id="stock_availability_check<%=recCount%>" value="">
<%
									}
%>
								</td>
 <%
								//for billing interface coding starts
								String strModDrugCode =  drug_code.replace("_","zXd1").replace(".","zXd2").replace("-","zXd3");
								boolean approval_flag = false;
								String disabled = "disabled";//AAKH-CRF-0117
								if(billing_interface_yn.equals("Y")&& bl_display.equals("Y")){	
									if(in_formulary_yn.equals("Y")){
										float gross_charge_amount =  0;
										float groos_pat_payable   =  0;
										 float gross_amount        = 0;//Added for ML-BRU-CRF-0469
										//float net_amount          =  0;
										gross_charge_amount_str	  =  "";
										groos_pat_payable_str	  =  "";
										     gross_amount_str     =  "";//added for ML-BRU-CRF-0469
										disp_delivery_chk_box_val =  "Y";
										batch_str				  =   "";

										StringBuffer gross_charge_display_str   = new StringBuffer();
										StringBuffer pat_charge_display_str     = new StringBuffer();
										StringBuffer inc_exec_display_str		= new StringBuffer();
										StringBuffer gross_disply_str          = new StringBuffer(); //added for ML-BRU-CRF-0469
											
										if( !qty.equals("")|| ws_tot_qty!=0 || multi_drugs.size()>1){						
											if((!qty.equals("")|| ws_tot_qty != 0) && (billable_item_yn.equals("Y"))){
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
														if(chareg_det.get("error_msg").equals("")){
															if(chareg_det.get("pat_paid_flag") != null && !chareg_det.get("pat_paid_flag").toString().equals("")){
																if(chareg_det.get("pat_paid_flag").equals("0")||chareg_det.get("pat_paid_flag").equals("1")||chareg_det.get("pat_paid_flag").equals("2")){
																	bPatientPaid   =true;
																	if(bean_1.getPatPaidYNForZeroBill().equals("Y")){//Added FOR SKR-SCF-0979 [IN:048119] & ML-BRU-SCF-1281 [IN:047783] -ISSUE 1 -start
																		pat_paid_amt			=	(String)chareg_det.get("pat_paid_amt"); 
																		pat_net_charge_amt			=	(String)chareg_det.get("netchargeamt");
																		if((pat_paid_amt.equals("")|| Float.parseFloat(pat_paid_amt)==0) && (pat_net_charge_amt.equals("")|| Float.parseFloat(pat_net_charge_amt)==0)){ 
																			bPatientPaid   = false;
																		}
																		else if(!pat_paid_amt.equals("") && Float.parseFloat(pat_paid_amt)!=0 && !pat_net_charge_amt.equals("") && Float.parseFloat(pat_net_charge_amt)!=0){  
																			bPatientPaid   = true;
																		} 
																	}//Added FOR SKR-SCF-0979 [IN:048119] & ML-BRU-SCF-1281 [IN:047783] -ISSUE 1 -end
																}
															}
															decimalFormatString=(String)chareg_det.get("BL_DECIMAL_FORMAT_STRING");
															DecimalFormat dfTest        = new DecimalFormat(decimalFormatString);
															/*if(!chareg_det.get("grosschargeamt").equals("null")){
																gross_charge_amount= Float.parseFloat((String)chareg_det.get("grosschargeamt"));
															}*/ //Commented ML-BRU-SCF-0368 [IN:034748]
															if(!chareg_det.get("netchargeamt").equals("null")){// if block added ML-BRU-SCF-0368 [IN:034748]
																gross_charge_amount  = Float.parseFloat((String)chareg_det.get("netchargeamt")); 
															}

															if(!chareg_det.get("patnetamt").equals("null")){
																groos_pat_payable  = Float.parseFloat(((String)chareg_det.get("patnetamt")).trim());
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
															gross_amount_str         = dfTest.format(gross_amount);
															}
															//added for ML-BRU-CRF-0469 end
															gross_charge_display_str.append("<label style='font-size:9px;color:black' id='groos_pat_payable_str_").append(order_id).append(order_line_no).append(strModDrugCode).append("'>").append(groos_pat_payable_str).append("</label>");

															pat_charge_display_str.append("<label style='font-size:9px;color:black' id='gross_charge_amount_str_").append(order_id).append(order_line_no).append(strModDrugCode).append("'>").append(gross_charge_amount_str).append("</label>");	
															//added for ML-BRU-SCF-0469 start 
															if(displayGrossAmtYn){
															gross_disply_str.append("<label style='font-size:9px;color:black' id='gross_amount_str_").append(order_id).append(order_line_no).append(strModDrugCode).append("'>").append(gross_amount_str).append("</label>");
															}
															//added for ML-BRU-SCF-0469 end
															inc_exec_display_str.append("<a  style ='font-size:9px' href=\"javascript:callIncludeExclude(").append("'A'").append(",").append("''").append(",").append("'").append(drug_code).append("'").append(",").append("'").append(qty).append("'").append(",").append("'").append(batch_str).append("'").append(",").append("'").append(order_id).append("'").append(",").append("'").append(order_line_no).append("'").append(")\">").append( com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Include.label","common_labels")).append("?</a>");
															
															tot_gross_charge_amount = tot_gross_charge_amount+gross_charge_amount;
															tot_groos_pat_payable   = tot_groos_pat_payable+groos_pat_payable;
															if(tot_gross_charge_amount !=tot_groos_pat_payable){//AAKH-CRF-0117
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
															<!-- added for ML-BRU-CRF-0469 start-->
															<%if(displayGrossAmtYn){ %>
															<input type="hidden" name="gross_amount_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="gross_amount_<%=order_id%><%=order_line_no%><%=strModDrugCode%>"   value="<%=gross_amount+""%>">
															<% } %>
															<!-- added for ML-BRU-CRF-0469 end-->
															<input type="hidden" name="drug_color_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="drug_color_<%=order_id%><%=order_line_no%><%=strModDrugCode%>"   value='black'>
<%
														}
														else{												
															gross_charge_display_str.append("<label style='font-size:9px;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label>");
															pat_charge_display_str.append("<label style='font-size:9px;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label>");
															//added for ML-BRU-CRF-0469 strt
															if(displayGrossAmtYn){
															gross_disply_str.append("<label style='font-size:9px;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label>");
															}
															//added for ML-BRU-CRF-0469 end
															//disp_delivery_chk_box="";
															disp_delivery_chk_box_val="N";
															//disp_delivery_chk_box_disabled="disabled";
														}
													}
												}
											}
											if(multi_drugs.size()>1){
												int  added_yn =0;
												int  x		=0;
												String sModAltDrugCode = "";
												for(int n=0; n<multi_drugs.size(); n+=5)	{							    
													alt_drug_code	     =	(String)multi_drugs.get(n);
													sModAltDrugCode		 = alt_drug_code.replace("_","zXd1").replace(".","zXd2").replace("-","zXd3");

													drug_color			 =	(String)colors.get(x++);
													HashMap billing_det = bean.getchargedetails(patient_id ,order_id,order_line_no,bl_encounter_id,bl_patient_class,dischargeIND);
													if(billing_det.containsKey(alt_drug_code)){
														HashMap  chareg_det=(HashMap)billing_det.get(alt_drug_code);
														if(chareg_det.get("error_msg").equals("")){
															batch_str =(String)chareg_det.get("BATCH_STRING");
															decimalFormatString     =(String)chareg_det.get("BL_DECIMAL_FORMAT_STRING");
															DecimalFormat dfTest   = new DecimalFormat(decimalFormatString);
														   /*if(!chareg_det.get("grosschargeamt").equals("null")){ 
																gross_charge_amount= Float.parseFloat((String)chareg_det.get("grosschargeamt"));
														   }*/ //Commented added ML-BRU-SCF-0368 [IN:034748]
															if(!chareg_det.get("netchargeamt").equals("null")){// if block added ML-BRU-SCF-0368 [IN:034748]
																gross_charge_amount  = Float.parseFloat((String)chareg_det.get("netchargeamt")); 
															}
															if(!chareg_det.get("patnetamt").equals("null")){ 
																groos_pat_payable  = Float.parseFloat(((String)chareg_det.get("patnetamt")).trim());
															}
															if(displayGrossAmtYn){ // Added for 68194 - Start
																if(!chareg_det.get("grosschargeamt").equals("null")){
																	gross_amount  = Float.parseFloat((String)chareg_det.get("grosschargeamt")); 
																  }
															} // Added for 68194 - End
															gross_charge_amount_str = dfTest.format(gross_charge_amount);
															groos_pat_payable_str   = dfTest.format(groos_pat_payable);
															if(displayGrossAmtYn){ // Added for 68194 - Start
																gross_amount_str = dfTest.format(gross_amount);
															} // Added for 68194 - End
															
													   
															gross_charge_display_str.append("<label style='font-size:9px;color:").append(drug_color).append("' id='groos_pat_payable_str_").append(order_id).append(order_line_no).append(sModAltDrugCode).append("'>").append(groos_pat_payable_str).append("</label><BR>");

															pat_charge_display_str.append("<label style='font-size:9px;color:").append(drug_color).append("' id='gross_charge_amount_str_").append(order_id).append(order_line_no).append(sModAltDrugCode).append("'>").append(gross_charge_amount_str).append("</label><BR>");

															inc_exec_display_str.append("<label style='cursor:pointer;font-size:9px;color:").append(drug_color).append("' onclick=\"javascript:callIncludeExclude(").append("'A'").append(",").append("''").append(",").append("'").append(alt_drug_code).append("'").append(",").append("'").append(qty).append("'").append(",").append("'").append(batch_str).append("'").append(",").append("'").append(order_id).append("'").append(",").append("'").append(order_line_no).append("'").append(")\">").append( com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Include.label","common_labels")).append("?</label><br>");
                                                            
															if(displayGrossAmtYn){ // Added for 68194 - Start   
																gross_disply_str.append("<label style='font-size:9px;color:").append(drug_color).append("' id='gross_amount_str_").append(order_id).append(order_line_no).append(sModAltDrugCode).append("'>").append(gross_amount_str).append("</label><BR>");																								
															} // Added for 68194 - End
															
															added_yn++;
															tot_gross_charge_amount = tot_gross_charge_amount+gross_charge_amount;
															tot_groos_pat_payable   = tot_groos_pat_payable+groos_pat_payable;
															if(tot_gross_charge_amount !=tot_groos_pat_payable){ //AAKH-CRF-0117
																approval_flag =true;
															}
															if(displayGrossAmtYn){ // Added for 68194 - Start
																tot_gross_amount            =tot_gross_amount+gross_amount; //added for ML-BRU-SCF-1841
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
															gross_charge_display_str.append("<label style='font-size:9px;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label><BR>");
															pat_charge_display_str.append("<label style='font-size:9px;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label><BR>");
															// disp_delivery_chk_box    ="";
															disp_delivery_chk_box_val="N";
															// disp_delivery_chk_box_disabled="disabled";
														}
													}							  
												}
												/*if(added_yn>0){
												}*/
											}
										}	
										else{ // if its zero qty
											//added for ML-BRU-CRF-0469 start
											if(displayGrossAmtYn){
											 gross_disply_str.append("<label style='font-size:9px;color:black' id='gross_amount_str_").append(order_id).append(order_line_no).append(strModDrugCode).append("'>").append("</label>");
											}
											//added for ML-BRU-CRF-0469 end
											 gross_charge_display_str.append("<label style='font-size:9px;color:black' id='groos_pat_payable_str_").append(order_id).append(order_line_no).append(strModDrugCode).append("'>").append("</label>");

											pat_charge_display_str.append("<label style='font-size:9px;color:black' id='gross_charge_amount_str_").append(order_id).append(order_line_no).append(strModDrugCode).append("'>").append("</label>");	

											inc_exec_display_str.append("<a id='lblIncludeExclude"+recCount+"' style ='font-size:9px;visibility:hidden' href=\"javascript:callIncludeExclude(").append("'A'").append(",").append("''").append(",").append("'").append(drug_code).append("'").append(",").append("'").append(qty).append("'").append(",").append("'").append(batch_str).append("'").append(",").append("'").append(order_id).append("'").append(",").append("'").append(order_line_no).append("'").append(")\">").append( com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Include.label","common_labels")).append("?</a>");
%>
											<input type="hidden" name="override_allowed_yn_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="override_allowed_yn_<%=order_id%><%=order_line_no%><%=strModDrugCode%>"  value="">
											<input type="hidden" name="excl_incl_ind_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="excl_incl_ind_<%=order_id%><%=order_line_no%><%=strModDrugCode%>"        value="">
											<input type="hidden" name="excl_incl_ind_default_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="excl_incl_ind_default_<%=order_id%><%=order_line_no%><%=strModDrugCode%>"value="">
											<input type="hidden" name="approval_reqd_yn_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="approval_reqd_yn_<%=order_id%><%=order_line_no%><%=strModDrugCode%>"     value="">
											<input type="hidden" name="bl_incl_excl_override_reason_desc_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="bl_incl_excl_override_reason_desc_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" value="">
											<input type="hidden" name="bl_incl_excl_override_reason_code_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="bl_incl_excl_override_reason_code_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" value="">
											<!-- added for ML-BRU-CRF-0469 start-->
											<% if(displayGrossAmtYn){ %>
											<input type="hidden" name="gross_amount_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="gross_amount_<%=order_id%><%=order_line_no%><%=strModDrugCode%>"   value="">
											<%} %>
											<!-- added for ML-BRU-CRF-0469 end-->
											<input type="hidden" name="gross_charge_amount_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="gross_charge_amount_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" value="">
											<input type="hidden" name="groos_pat_payable_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="groos_pat_payable_<%=order_id%><%=order_line_no%><%=strModDrugCode%>"   value="">
											<input type="hidden" name="drug_color_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="drug_color_<%=order_id%><%=order_line_no%><%=strModDrugCode%>"   value='black'>
<%
										}
							if(bean.getDisplayInsStatus()){  //Added for TH-KW-CRF-0012
%>	                     		
                           <td class="<%=classvalue%>"><center>&nbsp;<%=insurance_status%></center></td>
<%}%>
                                       <!-- Added for ML-BRU-CRF-0469 start -->
                                       <% if(displayGrossAmtYn){ %>
                                       <td  align="center" class="<%=classvalue%>"><center>&nbsp;<%=gross_disply_str.toString()%></center></td>
                                       <%} %>
                                       <!-- Added for ML-BRU-CRF-0469 end   -->
										<td align="center" class="<%=classvalue%>"><center>&nbsp;<%=pat_charge_display_str.toString()%><center></td>
										<td align="center" class="<%=classvalue%>"><center>&nbsp;<%=gross_charge_display_str.toString()%><center></td>
										<td class="<%=classvalue%>" align="center">&nbsp;<%=inc_exec_display_str.toString()%></td>
<%  
									}
									else{
										disp_delivery_chk_box_val =  "N";				
%>
										<td class="<%=classvalue%>" align="center">&nbsp;</td>
										<td class="<%=classvalue%>" align="center">&nbsp;</td>
										<td class="<%=classvalue%>" align="center">&nbsp;</td>
<%
									}  
								}  //billing interface coding ends here  
								if(base_to_def_uom_equl == 0 && base_to_disp_uom_equl == 0 && (ord_type.equals("NOR") || bEquivalentNormalOrder) ){
									disp_delivery_chk_box_val = "N";
								}
%>
								<input type="hidden"  name="allocateyn_<%=recCount%>" id="allocateyn_<%=recCount%>" value="<%=disp_delivery_chk_box_val%>">
								<input type="hidden"  name="prescribed_strength_<%=recCount%>" id="prescribed_strength_<%=recCount%>" value="<%=pres_strength_1%>"> <!--MMS-KH-CRF-0030 --> 
<%
								if((ws_tot_qty == 0 )&&( ws_type.equals("")||ws_type.equals("1")||ws_type.equals("3")||ws_type.equals("5")||ws_type.equals("9"))){		// THIS IS EXECUTED FOR ALLOCATE //"||ws_type.equals("9")" alone added for SRR20056-SCF-7289
									showZeroQtyCheckBox = "";
									showOtherEditLables = "";
									if(!disable_all.equals("disabled") && ((strAutoCompletePartialDisp.equals("Y") && Double.parseDouble(bms_qty) > 0 && !qty.equals("")) || (strIncludeZeroQty.equals("Y") && (qty.equals("") ||  qty.equals("0") )) )){// qty ==null || qty.equals("0") is changed to  Double.parseDouble(bms_qty) > 0 for [IN:045700]
										showZeroQtyCheckBox ="";
										showOtherEditLables ="display:none";
									}
									else{
										showZeroQtyCheckBox="display:none";
										showOtherEditLables ="";
									}
									if((qty ==null || qty.equals("0") || qty.equals("")) && (disable_all.equals("disabled") || bKeepQty ) && !hold_text.equals("On Hold")){ // && !hold_text.equals("On Hold") added for IN039007
										strAllocBMSChkValue  = "Y";
										strAllocBMSChecked	 = "checked";
										disable_complete_order ="disabled";
									}
									else{
										strAllocBMSChkValue  = "N";
										strAllocBMSChecked	 = "";
									}

									if(base_to_def_uom_equl == 0 && base_to_disp_uom_equl == 0){
										strAllocBMSChkValue  = "N";
										strAllocBMSChecked	 = "";
									}
									if( ((strAutoCompletePartialDisp.equals("Y") && Double.parseDouble(bms_qty) > 0 && !qty.equals("")) || (strIncludeZeroQty.equals("Y") && (qty.equals("") ||  qty.equals("0") || qty.equals("0.0") )) ) && !hold_text.equals("On Hold")  ){  //if block added for Bru-HIMS-CRF-281 [IN:033166]  // && !hold_text.equals("On Hold") added for IN039007//qty.equals("0.0") added for  ML-BRU-1810
										if(includeBMSDefCheck_yn.equals("Y")){ //if condition added for [IN:045055](Bru-HIMS-CRF-281[IN:033166])
											strAllocBMSChkValue  = "Y";
											strAllocBMSChecked	 = "checked";
											disable_complete_order ="disabled";
											showOtherEditLables ="display:none";//Added for ML-BRU-1810
										}
										showZeroQtyCheckBox	 = "";
										out.println("<input type ='hidden' name='allocBmsSecondStage_"+recCount+"' id='allocBmsSecondStage_"+recCount+"' value='Y'>");
										showOtherEditLables ="display:none";
									}
									else if(bKeepQty)
										out.println("<input type ='hidden' name='allocBmsSecondStage_"+recCount+"' id='allocBmsSecondStage_"+recCount+"' value='N'>");
									if(image.equals("")) {
%>
										<td class="<%=classvalue%>" onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')">
<%
										//if(strIncludeZeroQty.equals("Y")){   Commented for [IN:045700]
%>
											<div style="color:blue;font-size:9px;font-weight:bold" id="divIncludeZeroQty<%=recCount%>" style="<%=showZeroQtyCheckBox%>">
												<input type ="checkbox" name ="alloc_bms_chk_<%=recCount%>" value="<%=strAllocBMSChkValue%>" onclick="assignValue(this);setEnableDsbleCOR(this,'<%=recCount%>');" <%=strAllocBMSChecked%> />
												<fmt:message key="ePH.INCLUDE_IN_BMS.label" bundle="${ph_labels}"/>
											</div>
<%
										//} Commented for [IN:045700]
										if(!disable_all.equals("disabled")){	
											bEditLabelEnabled = true;							  
%>                    
											<div id="divOtherEditLables<%=recCount%>" style="<%=showOtherEditLables%>">								
<%
											if(!order_type.equals("TD") && !order_type.equals("TA")){
%>
												<!-- Passed URLEncoder,UTF-8  for drug name in callEditDetails regarding incident num:25276 ==By sandhya -->
												<label style="cursor:pointer;color:blue;font-size:9px;" id="edit_remarks<%=recCount%>" 
												onClick="callEditDetails(this,'<%=order_id%>','<%=drug_code%>','<%=recCount%>','<%=order_line_no%>','D','edit_remarks<%=recCount%>','<%=patient_id%>','<%=ord_date_time%>','<%=performing_pract_id%>','<%=drug_code%>','<%=java.net.URLEncoder.encode(drug_name_1,"UTF-8")%>','<%=alt_drug_flag%>','<%=pres_qty%>','<%=uom%>','<%=disp_locn_catg%>');"  <%=disable_all%> ><fmt:message key="ePH.EditLabel.label" bundle="${ph_labels}"/></label>
<%
											}
%>
										</div>
										<!--  added above alt_drug_flag for ML-BRU-SCF-0179 [IN:032578]-->
										<br>
										<label style="color:blue;cursor:pointer;font-size:9px" id="alloc_detail<%=recCount%>" onClick="if(!<%=bPatientPaid%>){callAllocate('<%=patient_id%>','<%=order_id%>','<%=drug_code%>','<%=disp_stage%>')}" <%=disable_all%> ><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></label>
										<br>
										<label style="cursor:pointer;color:blue;font-size:9px;" id="fill_remarks<%=recCount%>" onClick="callFillingRemarks(this,'<%=order_id%>','<%=drug_code%>','<%=recCount%>','<%=order_line_no%>','A','fill_remarks<%=recCount%>');"  <%=disable_all%>> <fmt:message key="Common.Findings.label" bundle="${common_labels}"/></label>&nbsp;
	<%
									}
									else{
										bEditLabelEnabled = false;	
										disable_complete_order ="disabled";
%>
										<div id="divOtherEditLables<%=recCount%>" style="<%=showOtherEditLables%>">							 
<%
										if(!order_type.equals("TD") && !order_type.equals("TA")){
%>
											<label style="color:black;font-size:9px;" id="edit_remarks<%=recCount%>" <%=disable_all%> ><fmt:message key="ePH.EditLabel.label" bundle="${ph_labels}"/></label>
<%
										}
%>
										&nbsp;			
										<br>
										<label style="color:black;font-size:9px;" id="fill_remarks<%=recCount%>" <%=disable_all%>> <fmt:message key="Common.Findings.label" bundle="${common_labels}"/></label>
										<br>
										<label style="color:blue;cursor:pointer;font-size:9px" id="alloc_detail<%=recCount%>" <%=disable_all%>>&nbsp;<fmt:message key="Common.Detail.label" bundle="${common_labels}"/></label>
										</div>
<%
									}
									if(multi_drugs.size()==0){
										if(bEditLabelEnabled){ // This block is used to store the values for showing the edit lables while open from the header
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
											hmEditLabelValues.put("alt_drug_flag","N");   //newly added for ML-BRU-SCF-0179 [IN:032578]
											hmEditLabelValues.put("alt_drug_count", "0"); //Added for Bru-HIMS-CRF-414- ML-BRU-SCF-1528 [IN:053217]
											alEditLabelPair.add(hmEditLabelValues);
											bEditLabelEnabled = false;
											bean.setSPerformPractId(performing_pract_id);
										}
									}
%>
								&nbsp;</td>
<%				
							}	
							else{			
%>
								<td class="<%=classvalue%>" >&nbsp;<%=image%></td>
<%
							}	
						}
						else{			// THIS IS EXECUTED FOR WORKSHEET
							if(ws_tot_qty != 0 ){
								disable_complete_order	=	"disabled"; 
							}
							else{
								disable_complete_order	=	""; 
							}
%>
							<td class="<%=classvalue%>" >&nbsp;</td>
<%
						}
%>
						<input type="hidden"  name="order_line_num<%=recCount%>" id="order_line_num<%=recCount%>" value="<%=order_line_no%>">
<%
						if(scope.equals("H")){
							legend1=bean_1.getresultlinestatus(order_id,order_line_no);
							if(legend1==null)legend1="";
							if(legend1.equals("OS")){
								legend_text= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outstanding.label","common_labels");
							}
							else if(legend1.equals("DP")){
								legend_text= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PartiallyDispensed.label","ph_labels");
							}
							else if(legend1.equals("RG")){
								legend_text= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InProcess.label","common_labels");

							}
							else if(legend1.equals("AL")){
								legend_text= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Alloocated.label","ph_labels");
							}
							visibility1="visibility:visible";
							visibility2="visibility:hidden";
						}
						else{
							if(hold_text.equals("On Hold")||disable_all.equals("disabled")){
							   disable_complete_order	=	"disabled"; 
							}
							visibility1="visibility:hidden";
							visibility2="visibility:visible";
						}
%>
						<td class="<%=classvalue%>" ><label style="color:red;font-size:9px" id="result_line_status<%=recCount%>" style='<%=visibility1%>'><b><%=legend_text%></b>
						</label> <input type='checkbox'   name="CompleteOrder<%=recCount%>" id="CompleteOrder<%=recCount%>"    value='<%=complete_order_value%>' onClick='setcompleteorder(this)' style='visibility:hidden'  <%=disable_complete_order%>  <%=complete_order_checked%> >
							<select name="ComplteOrderReason<%=recCount%>" id="ComplteOrderReason<%=recCount%>" onchange='setCheckBoxValue(this,document.DispMedicationAllStages.CompleteOrder<%=recCount%>,document.getElementById("hold_remarks_")<%=recCount%>,<%=recCount%>)' style='<%=visibility2%>' <%=disable_complete_order%> <%=complete_order_checked%>>
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
						<input type="hidden" name="release_flag<%=recCount%>" id="release_flag<%=recCount%>" value="N">  
						<input type="hidden" name="base_to_disp_uom_equl_val<%=recCount%>" id="base_to_disp_uom_equl_val<%=recCount%>" value="<%=base_to_disp_uom_equl%>">
						<input type="hidden" name="base_to_def_uom_equl_val<%=recCount%>" id="base_to_def_uom_equl_val<%=recCount%>" value="<%=base_to_def_uom_equl%>">
						<input type="hidden" name="dischargeIND<%=recCount%>" id="dischargeIND<%=recCount%>" value="<%=dischargeIND%>">
                         			
						<%-- Commented for RUT-CRF-0088 [IN036978]  
						<input type="hidden" name="taper_order_yn<%=recCount%>" id="taper_order_yn<%=recCount%>" value="<%=taper_order_yn%>">
						<input type="hidden" name="taper_order_id<%=recCount%>" id="taper_order_id<%=recCount%>" value="<%=taper_order_id%>">
						<input type="hidden" name="taper_order_line_num<%=recCount%>" id="taper_order_line_num<%=recCount%>" value="<%=taper_order_line_num%>">--%>

						<input type="hidden" name="allow_decimals_yn<%=recCount%>" id="allow_decimals_yn<%=recCount%>" value="<%=st_allow_decimals_yn%>"> <!--  Added for AAKH-SCF-0113 [IN:048937] -->
						<input type="hidden"  name="order_line_num_<%=recCount%>" id="order_line_num_<%=recCount%>" value="<%=order_line_no%>"><!--added for GHL-CRF-0453 -->
						<input type="hidden"  name="order_id_<%=recCount%>" id="order_id_<%=recCount%>" value="<%=order_id%>"> <!--added for GHL-CRF-0453 -->
						<input type="hidden"  name="drug_code_<%=recCount%>" id="drug_code_<%=recCount%>" value="<%=drug_code%>"> <!--added for GHL-CRF-0453 -->
<% 
						if(disp_level.equals("P")) {	
%>
							<input type="hidden"  name="order_id<%=recCount%>" id="order_id<%=recCount%>" value="<%=order_id%>">
<%	
						}
					//ML-MMOH-SCF-1634 - start
					if(patient_class.equals("OP")){
					
					if(strIncludeZeroQty.equals("N") && (iv_prep_yn==null || iv_prep_yn.equals("")) && (qty.equals("") ||  qty.equals("0") || qty.equals("0.0")) && !hold_text.equals("On Hold")){ %>
					
					<script>
						if(eval('document.DispMedicationAllStages.allocateyn_'+recCount).value = "N";	
					</script>
					<%}
					} //ML-MMOH-SCF-1634 - end
					if(approval_flag){//AAKH-CRF-0117
						disabled = "";
					}    
				    if(approval_no_flag) { //added for AAKH-CRF-0117
							if(approval_flag){//AAKH-CRF-0117
								approval_no= (String)approvalNo.get(order_id+order_line_no);
						   }
						   if(approval_no==null) //AAKH-CRF-0117
							   approval_no = "";
%>
                     <td class="<%=classvalue%>" nowrap>   <!--modified for AAKH-CRF-0117 --> 
					 <input type="text" value="<%=approval_no%>" maxlength="20" onchange="getApprovalNumForDrug(this,<%=recCount%>)"   name="approval_no_<%=recCount%>" <%=disabled%> onKeyPress="return KeyPressSpecCharsForApprovalNo(event)" onBlur="CheckForSpecCharApprovalno(this,'A',<%=recCount%>)"/> <!--MODIFIED FOR AAKH-CRF-0117  again modified for  CRF-0117-->
					 <% //added for AAKH-CRF-0117
						if(approval_no_app_for_patient_class!=null && approval_no_app_for_patient_class.equals("Y") && disabled.equals("")){
							approval_no_style = "visibility:visible";
						}%>
						<img id="imgForWithin_<%=recCount%>" src="../../eCommon/images/mandatory.gif" align="center" style="<%=approval_no_style%>"></img><!-- AAKH-CRF-0117 -->	
						<%
						
					%>
					 </td>
<%
					}
%>
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
				/* commented for SKR-SCF-0105
				String allow_yn	=	"Y";
				if( (disp_stage.equals("A") && (bean_1.getFillingStatus().equals("A")  ))&&(!disp_locn_catg.equals("I")) ){
						allow_yn    =   (String) bean_1.Check_applicable_orders(OrderIDS);
				 }
				*/
				if(billing_interface_yn.equals("Y")&& bl_display.equals("Y")&&ws_tot_qty != 0 && admx_prep_charges_appl_yn.equals("Y")){
					String ItemForAdmixPrepCharges				=  "";
					String mark_up_down					    =	"1";
					String old_mark_up_down					=   "";
					if(ord_type.equals("IVAA")||ord_type.equals("IVIA")||ord_type.equals("CA")||ord_type.equals("CO")){
						iv_prep_yn						=   "";
						String calc_groos_pat_payable_admx_prep_charge = "";
						String calc_gross_admx_prep_charge	=	"";	
						admixture_yn							=   "Y";
						StringBuffer gross_charge_display_str =   new StringBuffer();
					  
						HashMap	AdmxPrepChargeDetails =(HashMap)bean_1.getAdmxPrepChargeDetails(disp_locn_code,worksheet_id,ord_type);
						if(AdmxPrepChargeDetails!=null && AdmxPrepChargeDetails.size()>0){
						   ItemForAdmixPrepCharges			=  (String) AdmxPrepChargeDetails.get("ADMX_PREP_CHARGE_ITEM_CODE");
						   mark_up_down						=  (String)AdmxPrepChargeDetails.get("ADMX_PREP_CHARGE_UNITS");
						   old_mark_up_down					=  mark_up_down;
						}
						else{
							iv_prep_yn						=   bean.getIVFlag(order_id);
							ItemForAdmixPrepCharges			=   bean.getItemForAdmixPrepCharges(iv_prep_yn);
						}				  			
						HashMap charge_det=(HashMap)bean.callItemChargeDtls(patient_id,encounter_id,bl_patient_class,ItemForAdmixPrepCharges,1.0,"",sysdate,store_code,"","",order_id,"","",dischargeIND);
						if(charge_det.get("error_msg").equals("")){ 
							decimalFormatString					=(String)charge_det.get("BL_DECIMAL_FORMAT_STRING");
							DecimalFormat dfTest				=   new DecimalFormat(decimalFormatString);

							//if(!charge_det.get("grosschargeamt").equals("null")){ //Commented for ML-BRU-SCF-0368 [IN:034748]
							if(charge_det.get("netchargeamt")!=null && !charge_det.get("netchargeamt").equals("null")){// added ML-BRU-SCF-0368 [IN:034748]
								//gross_admx_prep_charge=dfTest.format( Float.parseFloat((String)charge_det.get("grosschargeamt")));// Commented for ML-BRU-SCF-0368 [IN:034748]
								gross_admx_prep_charge=dfTest.format( Float.parseFloat((String)charge_det.get("netchargeamt")));// added ML-BRU-SCF-0368 [IN:034748]
								calc_gross_admx_prep_charge=dfTest.format( Float.parseFloat(gross_admx_prep_charge)*Float.parseFloat(mark_up_down));
							}
							if(!charge_det.get("patnetamt").equals("null")){
								groos_pat_payable_admx_prep_charge  =dfTest.format( Float.parseFloat((String)charge_det.get("patnetamt"))); 
								calc_groos_pat_payable_admx_prep_charge=dfTest.format( Float.parseFloat(groos_pat_payable_admx_prep_charge)*Float.parseFloat(mark_up_down));
							} 
%>
							<tr>
								<td class="data">&nbsp;</td> <td class="data">&nbsp;</td> 
								<td class="data"><label style="cursor:pointer;color:blue" onclick="CallPreparationChargeDetails('<%=gross_admx_prep_charge%>',<%=groos_pat_payable_admx_prep_charge%>,mark_up_down,bl_decimal_format_str,'A')" id="prep_charges"><fmt:message key="ePH.PreparationCharges.label" bundle="${ph_labels}"/>(<%=mark_up_down%>)</label></td>
								<td class="data">&nbsp;</td> <td class="data">&nbsp;</td>
								<td class="data">&nbsp;</td> <td class="data">&nbsp;</td>  <td class="data">&nbsp;</td>
								<td class="data" id="gross_admx_prep_charge_legend" align="center">&nbsp;<%=calc_gross_admx_prep_charge%></td>
								<td class="data" id="groos_pat_payable_admx_prep_charge_legend" align="center">&nbsp;<%=calc_groos_pat_payable_admx_prep_charge%></td>
								<td class="data">&nbsp;</td> <td class="data">&nbsp;</td>  <td class="data">&nbsp;</td>
							</tr>
<%	
						}
						else{
							gross_admx_prep_charge=(gross_charge_display_str.append("<label style='font-size:9px;color:red' title='").append(charge_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label>")).toString();

							groos_pat_payable_admx_prep_charge=gross_admx_prep_charge;
%>
							<tr>
								<td class="data">&nbsp;</td> <td class="data">&nbsp;</td> 
								<td class="data"><label  id="prep_charges"><fmt:message key="ePH.PreparationCharges.label" bundle="${ph_labels}"/></label></td>
								<td class="data">&nbsp;</td> <td class="data">&nbsp;</td>
								<td class="data">&nbsp;</td> <td class="data">&nbsp;</td>  <td class="data">&nbsp;</td>
								<td class="data" id="gross_admx_prep_charge_legend" align="center">&nbsp;<%=gross_admx_prep_charge%></td>
								<td class="data" id="groos_pat_payable_admx_prep_charge_legend" align="center">&nbsp;<%=groos_pat_payable_admx_prep_charge%></td>
								<td class="data">&nbsp;</td> <td class="data">&nbsp;</td>  <td class="data">&nbsp;</td>
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
					<input type="hidden" name="old_mark_up_down" id="old_mark_up_down" value="<%=old_mark_up_down%>">
					<input type="hidden" name="ItemForAdmixPrepCharges" id="ItemForAdmixPrepCharges"value="<%=ItemForAdmixPrepCharges%>">
					<input type="hidden" name="bl_decimal_format_str" id="bl_decimal_format_str" value="<%=decimalFormatString%>">
<%
				}
				if(disp_level.equals("P") && result!=null) {
					for(int i=0;i<result.size();i=i+11) {		//10->11 for SKR-SCF-0330 ICN 29789 //11->13 RUT-CRF-0069 ICN29607   //Modified for RUT-CRF-0088 [IN036978]  13 ->11
						bean.setFirstTime(((String)result.get(i+1)).trim(),false);
					}
				}
				else {
					bean.setFirstTime(order_id,false);
				}

				if(stDrugCodes.size()>0){
					sDispDrugAuthYN = bean.getDispDrugAuthYN(stDrugCodes);
				}	
				bean_1.setPatientPaid(bPatientPaid);
%>
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id_1%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name_1%>">
			<input type="hidden" name="bean_id_1" id="bean_id_1" value="<%=bean_id%>">
			<input type="hidden" name="bean_name_1" id="bean_name_1" value="<%=bean_name%>">
			<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>">
			<input type="hidden" name="disp_stage" id="disp_stage" value="<%=disp_stage%>">
			<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
			<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
			<input type="hidden" name="source_code" id="source_code" value="<%=source_code%>">
			<input type="hidden" name="source_type" id="source_type" value="<%=source_type%>">
			<input type="hidden" name="ordering_facility_id" id="ordering_facility_id" value="<%=ordering_facility_id%>">
			<input type="hidden" name="ord_date_time" id="ord_date_time" value="<%=ord_date_time%>">
			<input type="hidden" name="performing_pract_id" id="performing_pract_id" value="<%=performing_pract_id%>">
			<input type="hidden" name="disp_locn_code" id="disp_locn_code" value="<%=disp_locn_code%>">
			<input type="hidden" name="mode" id="mode" value="<%=CommonRepository.getCommonKeyValue( "MODE_MODIFY" )%>">
			<input type="hidden" name="module_id" id="module_id" value="<%=module_id%>">
			<input type="hidden" name="tot_rec" id="tot_rec" value="<%=recCount%>">
			<input type="hidden" name="allocate_status" id="allocate_status" value="<%=allocate_status%>">
			<input type="hidden" name="ws_type" id="ws_type" value="<%=ws_type%>">
			<input type="hidden" name="curr_stage" id="curr_stage" value="<%=disp_stage%>">
			<input type="hidden" name="disp_level" id="disp_level" value="<%=disp_level%>">
			<input type="hidden" name="disp_locn_catg" id="disp_locn_catg" value="<%=disp_locn_catg%>">
			<input type="hidden" name="ord_type" id="ord_type" value="<%=ord_type%>">
			<input type="hidden" name="IssueByUOM" id="IssueByUOM" value="<%=bean_1.getIssueByUOM()%>">
			<input type="hidden" name="IncludeZeroQty" id="IncludeZeroQty" value="<%=strIncludeZeroQty%>">
			<input type="hidden" name="EquivalentNormalOrder" id="EquivalentNormalOrder" value="<%=bEquivalentNormalOrder%>">
			<input type="hidden" name="function_id" id="function_id" value="<%=bean_1.getSFunctionId()%>">
			<input type="hidden" name="tpn_wrksheet_rcrd" id="tpn_wrksheet_rcrd" value="<%=tpn_wrksheet_rcrd%>">
			<!--<input type="hidden" name="allow_yn" id="allow_yn" value="">  allow_yn --> 
			<input type="hidden" name="pres_qty_alert" id="pres_qty_alert" value="<%=pres_qty_alert%>"><!-- code added for AMS-CRF-0035[IN033551] -->   
			<input type="hidden" name="includeBMSDefCheck_yn" id="includeBMSDefCheck_yn" value="<%=includeBMSDefCheck_yn%>"><!-- code added for [IN:045055](Bru-HIMS-CRF-281[IN:033166]) -->   
			<input type="hidden" name="strAutoCompletePartialDisp" id="strAutoCompletePartialDisp" value="<%=strAutoCompletePartialDisp%>"><!-- Added for JD-CRF-0179 [IN:41211] -->
			<input type="hidden" name="no_of_decimals" id="no_of_decimals" value="<%=st_no_of_decimals%>"> <!--  Added for AAKH-SCF-0113 [IN:048937] -->
			<input type="hidden" name="disp_decimal_dtls_yn" id="disp_decimal_dtls_yn" value="<%=st_disp_decimal_dtls_yn%>"> <!--  Added for AAKH-SCF-0113 [IN:048937] -->
			<input type="hidden" name="allow_amend_alt_drug_dtl" id="allow_amend_alt_drug_dtl" value="<%=allow_amend_alt_drug_dtl%>"> <!--  Added for JD-CRF-0198 [IN058599] -->
			<input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>"><!-- added for GHL-CRF-0453-->
			<input type="hidden"  name="displayGrossAmtYn" id="displayGrossAmtYn" value="<%=displayGrossAmtYn%>"><!-- added for ML-BRU-CRF-0469 -->
			<input type="hidden" name="intractn_req_yn" id="intractn_req_yn" value="<%=intractn_req_yn%>"><!-- Added for MMS-KH-CRF-0028 [IN070605] -->
				<input type="hidden" name="iv_prep_yn" id="iv_prep_yn" value="<%=iv_prep_yn%>" ><!--added for mms-kh-crf-0028-->
			<input type="hidden" name="approval_no_flag" id="approval_no_flag" value="<%=approval_no_flag%>"><!-- AAKH-CRF-0117-->
			<input type="hidden" name="approval_no_app_for_patient_class" id="approval_no_app_for_patient_class" value="<%=approval_no_app_for_patient_class%>"> <!-- AAKH-CRF-0117-->
			<input type="hidden" name="approval_no" id="approval_no" value=""> <!-- AAKH-CRF-0117-->

<% 
			if(billing_interface_yn.equals("Y")&& bl_display.equals("Y")){
%>
				<input type="hidden" name="bl_encounter_id" id="bl_encounter_id" value="<%=bl_encounter_id%>">
				<input type="hidden" name="bl_patient_class" id="bl_patient_class" value="<%=bl_patient_class%>">
				<input type="hidden" name="bl_sysdate" id="bl_sysdate" value="<%=sysdate%>">	
				<!-- added for ML-BRU-CRF-0469 start-->
				<% if(displayGrossAmtYn){ %>
				<input type="hidden" name="tot_gross_amount" id="tot_gross_amount" value="<%=tot_gross_amount%>">
				<%} %>
				<!-- added for ML-BRU-CRF-0469 end-->
				<input type="hidden" name="tot_gross_charge_amount" id="tot_gross_charge_amount" value="<%=tot_gross_charge_amount%>">
				<input type="hidden" name="tot_groos_pat_payable" id="tot_groos_pat_payable" value="<%=tot_groos_pat_payable%>">
				<input type="hidden" name="admx_prep_charges_appl_yn" id="admx_prep_charges_appl_yn" value="<%=admx_prep_charges_appl_yn%>">	
<%
			}
%>
		</form>
<%  
		if(decimalFormatString!=null && !decimalFormatString.equals("")&& billing_interface_yn.equals("Y")&& bl_display.equals("Y")){
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
			callLegendsFrame('<%=patient_id%>','A','<%=recCount-1%>','<%=tpn_finalize%>','<%=order_id%>','<%=billing_interface_yn%>','<%=tot_gross_charge_amount_str%>','<%=tot_groos_pat_payable_str%>','<%=admixture_yn%>','<%=sDispDrugAuthYN%>','<%=tot_gross_amount_str%>');//added for ML-BRU-CRf-0469  tot_gross_amount_str  

<%
			if(bPatientPaid){
%>
				disableFillOrAllocate();
<%
			}
%>
			enableDisableButton(document.getElementById("stock_availability_check1"));
<% 
			if(!display_list.equals("display:none")){
%>
				try{
					for(var i=1; i<<%=recCount%>;i++){
<% 
						if(!item_uom_definition_flag){
%>
							if(eval('document.DispMedicationAllStages.alloc_qty_'+i).value != '')
								calculateIssueUOM(eval('document.DispMedicationAllStages.issue_uom_select_'+i),i,eval('document.DispMedicationAllStages.issueUOMValue_'+i).value,'NO',eval('document.DispMedicationAllStages.approval_no_'+i).value); // .value added forMMS-SCF-0040 [IN:041888] and modified for AAKH-CRF-0117
<% 
						}
%>
					}
				}
				catch(exp){
				}
<%
			}
%>
		</script>
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
    finally{ // Added for ML-MMOH-SCF-0356.1 - start
		
		if(con != null)
			ConnectionManager.returnConnection(con,request);	
	} // Added for ML-MMOH-SCF-0356.1 - start
%>
</html>

