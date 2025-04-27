<!DOCTYPE html>
<!-- /* 
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			     Description
--------------------------------------------------------------------------------------------------------------
?				100					?                created
05/07/2019      [IN:067952]     Devindra             MMS-KH-CRF-0013 [IN:067952] 
09/08/2019      IN070605		 prathyusha  MMS-KH-CRF-0028
13/08/2019      IN070451		 Manickavasagam J  		MMS-KH-CRF-1408
13/08/2019      IN070605		 Devindra           MMS-KH-CRF-0028  
10/09/2019	  	IN070605	     	prathyusha 		  									 MMS-KH-CRF-0028 
29/10/2019		IN071533			Shazana			SKR-SCF-1275
30/11/2019		IN070606                Manickavasagam J                       MMS-KH-CRF-0029[IN070606]
12/10/2020      IN073397            Prabha     12/10/2020     Manickavasagam J          MOHE-CRF-0032
30/11/2020	8659						Shazana				MMS-MD-SCF-0141 	
---------------------------------------------------------------------------------------------------------------
*/ -->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.text.DecimalFormat,eST.*,eST.Common.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
System.out.println("==============in==========>DispMedicationVerification.jsp");
request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="JavaScript" src="../../ePH/js/DispMedicationAllStages.js"></script>
		<script language="JavaScript" src="../../ePH/js/DispMedication.js"></script>
		<script language="javascript" src="../../ePH/js/PPNRegimen.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



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
		height:15px;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #663300 0px solid;
	        BORDER-LEFT: #663300 0px solid;
	        BORDER-RIGHT: #663300 1px solid;
	        BORDER-TOP: #663300 1px solid;
        } 
		<!-- Added for MMS-KH-CRF-0013 - End -->
		
		
		
	TD.ALLERGY_REMARKS{
		BACKGROUND-COLOR:#CC0000;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #663300 1px solid;
  		BORDER-LEFT: #663300 1px solid;
		BORDER-RIGHT:#663300 1px solid;
		BORDER-TOP: #663300 1px solid;
		height:10;
		background-image : url('../../ePH/images/red.jpg');
	  }
	  
TD.DOSELIMIT_REMARKS{
		BACKGROUND-COLOR:#FFCC66;
		FONT-SIZE: 8pt ;
		height:10;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #663300 0px solid;
	        BORDER-LEFT: #663300 0px solid;
	        BORDER-RIGHT: #663300 1px solid;
	        BORDER-TOP: #663300 1px solid;
	        background-image : url('../../ePH/images/yellow.jpg');
        }

TD.CURRENTRX_REMARKS{
		BACKGROUND-COLOR:#6699FF;
		FONT-SIZE: 8pt ;
		height:10px;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #663300 0px solid;
		BORDER-LEFT: #663300 0px solid;
		BORDER-RIGHT: #663300 0px solid;
		BORDER-TOP: #CC9966 1px solid;
		background-image : url('../../ePH/images/blue.jpg');
	}
	TD.INTARACTION_REMARKS{ 
		BACKGROUND-COLOR:pink;
		FONT-SIZE: 8pt ;
		height:15px;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #663300 0px solid;
	        BORDER-LEFT: #663300 0px solid;
	        BORDER-RIGHT: #663300 1px solid;
	        BORDER-TOP: #663300 1px solid;
			background-image : url('../../ePH/images/Pink.jpg');
        } 
	 TD.EXPIRED_ORDER{    /* Added for MOHE-CRF-0032 */
			BACKGROUND-COLOR:#FFA500;  //code modified for MOHE-CRF-0032
			FONT-SIZE: 8pt ;
			height:10px;
			BORDER-STYLE: solid;
	}   
	/* Added for aakh-crf-0140 */
	TD.ABUSE_REMARKS{ 
		BACKGROUND-COLOR:purple;
		FONT-SIZE: 8pt ;
		height:15px;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #663300 0px solid;
	        BORDER-LEFT: #663300 0px solid;
	        BORDER-RIGHT: #663300 1px solid;
	        BORDER-TOP: #663300 1px solid;
			
        }   
			TD.PATIENTMED{    /* Added for TH-KW-CRF-0002 */
			BACKGROUND-COLOR:#87CEEB; //code modified for MOHE-CRF-0032
			FONT-SIZE: 8pt ;
			height:10px;
			BORDER-STYLE: solid;
	}                       
	</style> 
		<form name="DispMedicationAllStages" id="DispMedicationAllStages" >
<%

Connection con			= null;  // Added for ML-MMOH-CRF-0468
          try{
			con				= ConnectionManager.getConnection(request);//added for ml-mmoh-crf-0468
			boolean tpn_mf_label = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","TPN_MF_LABEL");// Added for ML-MMOH-CRF-0468 
					
		    boolean displayGrossAmtYn = eCommon.Common.CommonBean.isSiteSpecific(con, "PH", "GROSS_AMT_DISPLY_YN");// Added for ML-BRU-CRF-0469 - start
						
			boolean intractn_req_yn = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DISP_STAGE_INTRACTN_REQ_YN");	// Added for MMS-KH-CRF-0013 // same variable used for MMS-KH-CRF-0028 [IN070605]		        		   
			boolean expired_order = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","EXPIRY_ORDER_APP"); //Added for MOHE-CRF-0032
			boolean drug_abuse_appl=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DRUG_ABUSE_APPL");//added for AAKH-CRF-0140
				System.out.println("drug_abuse_appl"+drug_abuse_appl);
        boolean aggred_item_app = eCommon.Common.CommonBean.isSiteSpecific(con, "PH", "AGGRED_ITEM_APP");//added for MMS-DM-CRF-0209.1
        boolean site_remarks=eCommon.Common.CommonBean.isSiteSpecific(con, "PH", "DISP_REMARKS");//added for ML-MMOH-CRF-1755
					String	bean_id						=	"DispMedicationAllStages" ;
			String	bean_name					=	"ePH.DispMedicationAllStages";

			DispMedicationAllStages bean		= (DispMedicationAllStages)getBeanObject( bean_id, bean_name, request);
			bean.setLanguageId(locale);
			bean.loadReason();

			String	bean_id_1					=	"DispMedicationBean" ;
			String	bean_name_1					=	"ePH.DispMedicationBean";
			DispMedicationBean bean_1			= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1, request);
			bean_1.setLanguageId(locale);
			
			String facility_id					= (String) session.getValue("facility_id");
			String param_bean_id				= "@DrugInterfaceControlBean";
			String param_bean_name				= "ePH.DrugInterfaceControlBean";
			DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
			param_bean.setLanguageId(locale);

			String Image_bean_id				= "@DrugTradeImageBean";
			String Image_bean_name				= "ePH.DrugTradeImageBean";
			DrugTradeImageBean drug_trade_bean	= (DrugTradeImageBean)getBeanObject( Image_bean_id, Image_bean_name, request );

			MedicationPlannerBean medplan_bean = (MedicationPlannerBean)getBeanObject( "MedicationPlannerBean", "ePH.MedicationPlannerBean",request); // Added for Bru-HIMS-CRF-072.1[IN 049144]
			bean_1.setObject(medplan_bean);// Added for Bru-HIMS-CRF-072.1[IN 049144]

			String drug_db_interface_yn			= param_bean.getDrugDBInterface_yn(facility_id); 
			param_bean.clear();
			String disp_locn_catg	=	bean_1.getDispLocnCatg();
			String patient_class	=	"";

			if(disp_locn_catg.equals("I")) 
				patient_class	=	"IP";
			else 
				patient_class	=	"OP";

			String disp_stage			=	bean_1.getDispStage();
			String order_type			=   bean_1.getOrderType();
			bean_1.setObject(bean);
			String patient_id			=   request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
			String encounter_id			=   bean_1.getEncounterID();
			String order_id				=   request.getParameter("order_id")==null?"":request.getParameter("order_id");
			String practitioner_id		=   request.getParameter("practitioner_id")==null?"":request.getParameter("practitioner_id");
			String practitioner_name	=   java.net.URLDecoder.decode(request.getParameter ("practitioner_name")==null?"":request.getParameter ("practitioner_name"),"UTF-8");
			Hashtable param_legends		=   bean_1.getLegendsFromParam();
			String Disp_drug_verify_remarks  =bean_1.getDisp_drug_verify_remarks_yn();//added for ml-mmoh-crf-1755
			bean.setPractitionerID(practitioner_id);
			bean.setPractitionerName(practitioner_name);
			
			String bean_id2					= "@PrescriptionBean_1"+patient_id+encounter_id; // Added for MMS-KH-CRF-0013 - Start
            String bean_name2		= "ePH.PrescriptionBean_1"; 
            PrescriptionBean_1 pres_bean =  (PrescriptionBean_1)getBeanObject( bean_id2,bean_name2,request) ;
            pres_bean.setLanguageId(locale); // Added for MMS-KH-CRF-0013 - End

			//Declaration starts
			ArrayList drug_interact		=	new ArrayList();
			String order_line_no		=	"";
			String drug_code			=	"";
			String drug_name			=	"", drug_name_1="";
			String dosage_dtls			=	"";
			String start_date			=	"";
			String end_date				=	"";
			String pres_qty				=	"";
			String qty_uom				=	"";
			String qty_uom_disp			=	"";
			String alt_drug_code		=	"";
			String alt_drug_desc		=	"";
			String drug_color			=	"";
			String style				=	"";
			String ord_id				=   "";	
			String form_code			=	"";
			String form_desc            = ""; // Added for MMS-KH-CRF-0013
			String hold_status			=	"";
			String remark_status		=	"";
			//String hold_text			=	"Hold";
			String 	hold_text		    = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Hold.label","ph_labels");
			String check_value			=   "N";
			String fromdb				=   "N";	
			String strChangedFludRmks	=	"";
			String pat_couns_reqd_yn	=	"";
			int bmscount                =    0;
			String pat_reqd				=	"";
			String pt_couns_reqd_yn		=	"";
			String dosage_unit			=	"";
			String std_dose             =   "";
			String location				=	"";
			String expired_yn			=	"";
			String pres_details			=	"";
			String iv_prep_yn			=	"";
			String dischargeIND			=	"";
			String strBMS_Include_yn ="N";// Added for [IN:045295]
			String home_med_yn = "", home_med_style="";//Added for Bru-HIMS-CRF-093-DD1[IN047223]
			String disc_cancelled_orders="", disc_cancelled_orders_display="display:none;", drug_desc=""; //Added for HSA-CRF-0138 [IN:048414] & Bru-HIMS-CRF-080
			HashMap IssueUOMAndBaseUOM       = new HashMap();//ML-BRU-SCF-1798
			double base_to_disp_uom_equl     = 0;//ML-BRU-SCF-1798
			String base_uom = "";//ML-BRU-SCF-1798
			String patient_brought_medn ="";


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
			ArrayList result		=	null;
			ArrayList orderLineDtls	=	new ArrayList();
			//Declaration ends

			String disp_level	= bean_1.getDispLevelValue();
			String disp_catg	= bean_1.getDispLocnCatg();

			ArrayList alOrderIds = new ArrayList();
			ArrayList tmpResult = new ArrayList();

			if(bean_1.getAlTrxOrderIds()!=null){
				alOrderIds = bean_1.getAlTrxOrderIds();
			}
			if(disp_level.equals("P")) {				
				result			= bean_1.getOrders(patient_id.trim());//order lines of all orders
				if(bean_1.getCriteriaOrderType()!=null && (bean_1.getCriteriaOrderType().equals("ALL") || bean_1.getCriteriaOrderType().equals("CDR") ||(tpn_mf_label && bean_1.getCriteriaOrderType().equals("TD")))){ //TD added for ml-mmoh-crf-0468 CDR Condition Added for ML-MMOH-CRF-0435 [IN:057357]
					if(alOrderIds.size()>0){
						for(int i=0;i<result.size();i=i+11) {	//10 ->11 for SKR-SCF-0330 ICN 29789  //11->13 RUT-CRF-0069 ICN29607   //Modified for RUT-CRF-0088 [IN036978] 13->11
							if(alOrderIds.contains(result.get(i+1))){
								for(int j=i;j< i+11;j++)	//10 ->11  for SKR-SCF-0330 ICN 29789  //11->13 RUT-CRF-0069 ICN29607   //Modified for RUT-CRF-0088 [IN036978] 13->11
									tmpResult.add(result.get(j));
							}
						}
					}
					result = tmpResult;
				}
				ArrayList tmp	=	new ArrayList();

				for(int i=0;i<result.size();i=i+11) {	//10 ->11  for SKR-SCF-0330 ICN 29789  //11->13 RUT-CRF-0069 ICN29607   //Modified for RUT-CRF-0088 [IN036978] 13->11
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
			else {
				result			= bean_1.getOrders(patient_id.trim());
				for(int i=0;i<result.size();i=i+11) {		//10 ->11  for SKR-SCF-0330 ICN 29789  //11->13 RUT-CRF-0069 ICN29607	//Modified for RUT-CRF-0088 [IN036978] 13->11
				  ord_id = (String)result.get(i+1);
				  if(ord_id.equals(order_id)){
					location  = (String)result.get(i+4);
				  }
				  ord_id="";
				}
				orderLineDtls = (ArrayList)bean_1.getOrderLineDetails(patient_id,order_id);
			}

			String allergy				=	"";
			String exceed_dose			=	"";	
			String generic_id			=	"";
			String generic_name			=	"";
			String dosage_details		=	"";
			String exceed_status		=	"";
			String monograph			=	"";
			String unit_dose			=	"";
			String daily_dose			=	"";
			String bms_qty				=	"";
			String duplicate_yn			=	"";
			String min_dose_dtls		=	"";
			String min_unit_dose		=	"";
			String min_daily_dose		=	"";
			String dosage_type    		=   "";
			String ext_prod_id			=	"";
			String ordered_by			=	"";
			String ord_date_time		=	"";	
			//code added for in_formulary....drugs..	
			String in_formulary_yn		=	"";	
			String source_code			=	"";
			String source_type			=	"";
			String ordering_facility_id	=	"";
			String performing_pract_id	=	"";
			//code added for drug remarks
			String drug_remarks			=	"";
			String prn_remarks			=	"";
			String pharma_remarks		=	"";		
			String pres_remarks			=	"";
			String slidingscaleremarks	=   "";
			String verificationremarks	=   "";
			String remarks_style		=	"";
			String trade_code			=   "";
			float dialog_height			=	0;
			String image_path			=   "";
			String strength				=   "";
			String strength_uom			=   "";
			String strength_uom_disp	=   "";
			String strength_value		=   "";
			String OrderDate			= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OrderDate/Time.label","ph_labels");
			String OrderedPractitioner	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OrderedPractitioner.label","ph_labels");
			String OrderingLocation		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderingLocation.label","common_labels");
			//ends here
			String  billing_interface_yn		=	bean.getBLInterfaceYN();//checkforbillinginterface();
			String width						=	"100%";
			String bl_encounter_id				=	bean_1.getEncounterID();
			String bl_patient_class				=   "";
			String bl_display                   =   "Y"; 
			String sysdate						=   bean_1.getTodaysDate();
			String disp_locn_code               =   bean_1.getDispLocnCode();
			float tot_gross_charge_amount		=   0;
			float tot_groos_pat_payable			=   0; 
			float  tot_gross_amount             =   0; // added for ML-BRU-CRF-0469
			String tot_gross_charge_amount_str	=   "";
			String tot_groos_pat_payable_str	=   "";
			String tot_gross_amount_str         =	"";	// added for ML-BRU-CRF-0469
			String decimalFormatString			=   "";
			String gross_charge_amount_str		=   "";
			String groos_pat_payable_str		=   "";
			String gross_amount_str             =   ""; //added for ML-BRU-CRF-0469
			int adr_count						=   0;
			String bl_incl_excl_val             =	"";
			String alloc_qty_from_tmp			=	"";
			String bl_incl_excl_override_reason_code =	"";
			//added during PE By Naveen
			String drug_db_product_id				=	"";
			String allergy_override_reason			=	"";
			String dosage_limit_override_reason		=	"";
			String duplicate_drug_override_reason	=	"";
			String interaction_override_reason		=	"";
			String contraind_override_reason		=	"";	
			String billable_item_yn					=	"";
			String food_interaction_override_reason =   "";//MMS-KH-CRF-0029
			String lab_interaction_override_reason =   ""; //MMS-KH-CRF-0029
			String disease_inter_override_reason =   "";//Added for MMS-DM-CRF-0229
			//added for IN070605 START
			String alergy_details_remarks="",dosage_details_remarks="",duplicate_details_remarks="",intaraction_details_remarks="";
			String review_called_from="";
			String revw_aprrove_applicable_yn=bean.approvalSetting(patient_class);
			String ALLERGY_REMARKS_CLASS="";
			String DOSAGE_REMARKS_CLASS="";
			String DUPLICATE_REMARKS_CLASS="";
			String INTARACTION_REMARKS_CLASS="";
			String ALLERGY_REMARKS_YN="";
			String DOSAGE_REMARKS_YN="";
			String DUPLICATE_REMARKS_YN="";
			String INTARACTION_REMARKS_YN="";
			//added for IN070605 END
			String ABUSE_REMARKS_CLASS="";//ADDED FOR AAKH-CRF-0140
			String  ABUSE_REMARKS_YN="";//ADDED FOR AAKH-CRF-0140
			String abuse_drug_override_reason="";//added for aakh-crf-0140  
			String abuse_exists="";//added for aakh-crf-0140
			String drugIndication="";//added for jd-crf-0220	
      String	category_code="";//added for mms-dm-crf-209.1
			String	alternate_yn="";//added for mms-dm-crf-209.1	
			//String taper_order_yn, taper_order_id, taper_order_line_num, taper_disable, show_remarks;  //Commented for RUT-CRF-0088 [IN036978]
			String taper_disable, show_remarks;  //Added for RUT-CRF-0088 [IN036978] -Start
			float tot_tap=0;
			HashMap taperValues = null;
			String totalTaperQtyDisplay = bean_1.getTotalTaperQtyDisplay();
			int count = 0; //Added for RUT-CRF-0088 [IN036978] -End
			StringBuffer drugs_remarks  = null ;//Bru-HIMS-CRF-416[IN045566] 
			String strDrugsRemarks="";//Bru-HIMS-CRF-416[IN045566] 
			String dose_unit_desc="";//Added for Ml-MMOH-SCF-0863
			/*if(bean_1.getOrderType().equals("CO")||bean_1.getOrderType().equals("IVAA")||bean_1.getOrderType().equals("IVIA")||bean_1.getOrderType().equals("CA")||bean_1.getOrderType().equals("TA")){
					bl_display                   ="N"; 
			   
			}*/
			
			if(billing_interface_yn.equals("Y")&& bl_display.equals("Y")){	
				width			=	"115%"; 
				bl_patient_class  =   bean.getEncounterPatientClass(bl_encounter_id, patient_id); // patient_id   added for [IN:035667] 
			}
%>
			<table cellpadding="0" cellspacing="0" width='<%=width%>' align="center" border="1" id="verificationTable">
				<tr>
	<%	                if(intractn_req_yn && order_type.equals("NOR")){ //Added for MMS-KH-CRF-0028 [IN070605] - Start
%>
                              <td class= "COLUMNHEADER" width="4%" style="font-size:9px"><fmt:message key="Common.Select.label" bundle="${common_labels}"/>
							   <input type="checkbox" value="Y" name="selectAll" id="selectAll" checked onClick="selectAllRcordsDeliver(this,'<%=disp_stage%>')" ><!--MMS-KH-CRF-0016.1-->
							  </td>
							 
<%					
                    } //Added for MMS-KH-CRF-0028 [IN070605] - End
%>	
					<td  class="COLUMNHEADER" width="10%"  style="font-size:9px"><%=param_legends.get("V")%><fmt:message key="Common.status.label" bundle="${common_labels}"/></td> <!-- 4% changed to 10% for MMS-KH-CRF-0013 --> 
					<td  class="COLUMNHEADER" width="5%"  style="font-size:9px">&nbsp;</td>
					<td  class="COLUMNHEADER" width="2%"  style="font-size:9px" >&nbsp;</td><!--Added for Bru-HIMS-CRF-093-DD1[IN047223]-->
					<!-- added for mms-dm-crf-0209.1 start -->
					<%if(aggred_item_app){%>
					<td class= "COLUMNHEADER" style="font-size:9px" width="2%">&nbsp;</td>
					<%} %>
					<!-- added for mms-dm-crf-0209.1 end -->
					<td  class="COLUMNHEADER" width="41%" style="font-size:9px"><fmt:message key="ePH.Drug/DosageDetails.label" bundle="${ph_labels}"/></td>
					<td  class="COLUMNHEADER" width="2%"  style="font-size:9px" >&nbsp;</td>	
					<td  class="COLUMNHEADER" width="2%"  style="font-size:9px" >&nbsp;</td>
					<td  class="COLUMNHEADER" width="10%" style="font-size:9px"><fmt:message key="ePH.PrescribedQuantity.label" bundle="${ph_labels}"/></td>
					<td  class="COLUMNHEADER" width="10%" style="font-size:9px"><fmt:message key="ePH.BalanceQuantity.label" bundle="${ph_labels}"/></td>
<% 
					if(billing_interface_yn.equals("Y") && bl_display.equals("Y")){
%>	
                       <!-- Added for ML-BRU-CRF-0469 start -->
                      <%if(displayGrossAmtYn){%> 
                       <td class= "COLUMNHEADER" width="10%" style="font-size:9px"><fmt:message key="ePH.GrossAmount.label" bundle="${ph_labels}"/></td>
                       <% }%>
					   <!-- Added for ML-BRU-CRF-0469 end --> 
						<td class= "COLUMNHEADER" width="10%" style="font-size:9px"><fmt:message key="Common.ChargeAmount.label" bundle="${common_labels}"/></td>
						<td class= "COLUMNHEADER" width="10%" style="font-size:9px"><fmt:message key="ePH.PayableAmount.label" bundle="${ph_labels}"/></td>
						<td class= "COLUMNHEADER" width="10%" style="font-size:9px"><fmt:message key="ePH.OverrideIncl/Excl.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td> 
<%
					}
%>
					<td  class="COLUMNHEADER" width="10%"  style="font-size:9px" ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
<%
					if(bean_1.getStockInstalled()){
%>
						<td  class="COLUMNHEADER" style="font-size:9px" colspan=2><fmt:message key="eST.StockAvailability.label" bundle="${st_labels}"/></td>
<%
					}
%>
					</tr>
<%
					String classvalue	=	"";
					int recCount		=	1;
					ArrayList celling_dose = null;//added for ML-MMOH-CRF-1408
					String min_unit_ceiling_dose = "", max_unit_ceiling_dose = "", min_daily_ceiling_dose = "", max_daily_ceiling_dose = ""; //added for ML-MMOH-CRF-1408
					//String drug_type	=	"";
					String ceil_dose_unit_desc = "";//added for ML-MMOH-CRF-1408
					HashMap lab_food_interaction =null;//added for MMS-KH-CRF-0029
					boolean	bDrugOrder				= true;
					System.out.println("==============in==========>DispMedicationVerification.jsp 483 orderLineDtls "+orderLineDtls);
					for(int i=0;i<orderLineDtls.size(); i++){
						
						System.out.println("==============in==========>DispMedicationVerification.jsp 486 ");
						bDrugOrder				= true;
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

						pres_details		=	"";

						if(disp_level.equals("P") && ((String)orderLineDtls.get(i)).startsWith("PH")) {
							order_id			= (String)orderLineDtls.get(i);
							ordered_by			= (String)orderLineDtls.get(++i);
							location			= (String)orderLineDtls.get(++i);
							++i;
						
						}
						else{
						   ordered_by   =   practitioner_name;
						}                 
						
						allergy					= (String)orderLineDtls.get(i);
						exceed_dose				= (String)orderLineDtls.get(++i);
						i=i+1;
						//duplicate				=	(String)orderLineDtls.get(++i);
						drug_code				= (String)orderLineDtls.get(++i);				
						//drug_type				=	bean_1.getDrugType(drug_code);
						drug_name				= (String)orderLineDtls.get(++i);
						
						dosage_dtls				= (String)orderLineDtls.get(++i);
						start_date				= (String)orderLineDtls.get(++i);
						end_date				= (String)orderLineDtls.get(++i);
						pres_qty				= (String)orderLineDtls.get(++i);
						qty_uom					= (String)orderLineDtls.get(++i);
						qty_uom_disp			= (String)orderLineDtls.get(++i);
						order_line_no			= (String)orderLineDtls.get(++i);
						generic_id				= (String)orderLineDtls.get(++i);

						if(generic_id.equals("MEDICALITEM"))
							bDrugOrder				= false;

						generic_name			= (String)orderLineDtls.get(++i);
						dosage_details			= (String)orderLineDtls.get(++i);
						bms_qty					= (String)orderLineDtls.get(++i);
						source_code				= (String)orderLineDtls.get(++i);
						source_type				= (String)orderLineDtls.get(++i);
						ordering_facility_id	= (String)orderLineDtls.get(++i);
						ord_date_time			= (String)orderLineDtls.get(++i);
						performing_pract_id		= (String)orderLineDtls.get(++i);
						duplicate_yn			= (String)orderLineDtls.get(++i);
						min_dose_dtls			= (String)orderLineDtls.get(++i);               
						trade_code				= (String)bean_1.gettrade_codes(order_id,order_line_no,drug_code);
						if(generic_id.equals("MEDICALITEM")){
						   drug_trade_bean.setDrugyesno("");
						}
						else{
							drug_trade_bean.setDrugyesno("Y");
						}
						image_path				=  drug_trade_bean.getImagePath(drug_code,trade_code);


						i=i+1;
						strength_value			=	(String)orderLineDtls.get(++i);
						strength_uom			=	(String)orderLineDtls.get(++i);
						strength_uom_disp		=	(String)orderLineDtls.get(++i);
						strength	="";
						if(!strength_value.equals("0"))
							strength	=	strength_value+" "+strength_uom;
						//commented during PE by naveen
						//pat_couns_reqd_yn       =   bean.getPatCounsReqdyn(order_id, order_line_no);
						bmscount                =   bean.CheckBMSYN(order_id, order_line_no);
									
						if(order_type.equals("IVI") )
							strChangedFludRmks = bean.getChngdFluidRemarks(order_id,order_line_no);
						else
							strChangedFludRmks ="";

						if(strChangedFludRmks != "" && strChangedFludRmks != null)
							classvalue = "FLUDCOLOR";

						//if(module_id.equals("2"))
							//stock_opt	=	(String)orderLineDtls.get(++i);				
						i=i+1;  
						ext_prod_id=(String)orderLineDtls.get(++i);

						if(ext_prod_id!=null && !ext_prod_id.equals("")) {
							drug_interact.add(ext_prod_id);
						}
						StringTokenizer dose	=	new StringTokenizer(dosage_details,":");
						//code added for in_formulary_yn ..added on 25/4/2004
						in_formulary_yn			=	((String)orderLineDtls.get(++i)).trim();
						if(in_formulary_yn.equals("N"))
							classvalue			=	"FORMULARY";
						iv_prep_yn = (String)orderLineDtls.get(++i);
						//if( (((String)orderLineDtls.get(++i)).trim()).equals("N")) {
						if(iv_prep_yn!=null && iv_prep_yn.trim().equals("N")) {
							if(order_line_no.equals("1"))
								classvalue="IVFLUID";
							else
								classvalue="IVINGREDIENT";
						}	//ended...                
						i=i+1; 				
						bl_incl_excl_val                  =(String)orderLineDtls.get(++i);
						bl_incl_excl_override_reason_code =(String)orderLineDtls.get(++i);           
						expired_yn                        = (String)orderLineDtls.get(++i);
						i=i+5;			  // to skip the PRN and absolute YN values                 
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
											
						if(dose.hasMoreTokens())
							exceed_status	=	dose.nextToken();
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
						StringTokenizer min_dose	=	new StringTokenizer(min_dose_dtls,":");
						if(min_dose.hasMoreTokens()) {
							min_unit_dose	=	min_dose.nextToken();
						} // Added for the issue which is found while testing MMS-KH-CRF-0028 [IN070605]
						if(min_dose.hasMoreTokens()) { // Added for the issue which is found while testing MMS-KH-CRF-0028 [IN070605]
							min_daily_dose	=	min_dose.nextToken();
						}

						if(bean.checkHold(order_id,order_line_no)) {
							hold_text=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OnHold.label","ph_labels");
							check_value="Y";
							//check_status="checked";
							fromdb="Y";
							remark_status	="visibility:visible";
						} 
						else {
							HashMap hm= bean.loadHoldRemarks(order_id,order_line_no);
							if (!hm.isEmpty()){
								hold_text=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OnHold.label","ph_labels");
								//check_status="checked";
								check_value="Y";
								fromdb="Y";
								remark_status	="visibility:visible";
							}
							else{
								//hold_text		="Hold";
								hold_text		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Hold.label","ph_labels");
								remark_status	="visibility:hidden";
								//check_status	="";
							}
						}
						ArrayList multi_drugs	=	bean.getMultiDrugs(patient_id,order_id,order_line_no);
						String qty				=	bean.getDrugQuantity(patient_id,order_id,order_line_no);
						if(!qty.equals(""))
							hold_status			=	"disabled";
						String alt_drug			=	bean.checkMultiStrength(drug_code);
						bean.addDrugs(patient_id,order_id,drug_code,alt_drug,order_line_no);
						if(multi_drugs.size() < 1)	{
							style				=	"cursor:pointer;color:blue";
							//call_function		=	"callDrugDetails('"+patient_id+"','"+order_id+"','"+drug_code+"','"+drug_name+"','"+alt_drug+"','','','','"+qty_uom+"','"+pres_qty+"')";
						}
						else	{
							style				=	"font-weight:bold";
							//call_function		=	"";
						}
						HashMap hm= bean.loadHoldRemarks(order_id,order_line_no);
						if(hm.size() > 1) {
							hold_status="checked";
							remark_status="visibility:visible";
						}
						/*-----code for displaying drug remarks---------------*/
						drug_remarks	    = "";
						prn_remarks		    = "";
						pharma_remarks	    = "";		
						pres_remarks        = "";
						slidingscaleremarks ="";
						remarks_style       = "";
						dialog_height       = 0;
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
						dischargeIND					=	(String)orderLineDtls.get(++i);//from OR_ORDER dischargeindecator
						strBMS_Include_yn				=	(String)orderLineDtls.get(++i);// Added for [IN:045295]
						home_med_yn 				= 	(String)orderLineDtls.get(++i);//Added for Bru-HIMS-CRF-093-DD1[IN047223]
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
						if(disease_inter_override_reason==null) //MMS-DM-CRF-0229
							disease_inter_override_reason = "";
						//added for MMS-KH-CRF-0029 - end
						drug_desc = (String)orderLineDtls.get(++i);//Added for Bru-HIMS-CRF-414- ML-BRU-SCF-1454 [IN:052271]
						disc_cancelled_orders		= 	(String)orderLineDtls.get(++i);//Added for  HSA-CRF-0138 [IN:048414] 
						if(!disc_cancelled_orders.equals(""))
							disc_cancelled_orders_display="display:inline";
						else
							disc_cancelled_orders_display="display:none";
						i++;//Added for Bru-HIMS-CRF-080
						if(home_med_yn!=null && home_med_yn.equalsIgnoreCase("Y"))
							home_med_style = "HOME_MED";
						else
							home_med_style = "white";//Added for Bru-HIMS-CRF-093-DD1[IN047223] -End
						/*taper_order_yn 					=	(String)orderLineDtls.get(++i);//from OR_ORDER   //Commented for RUT-CRF-0088 [IN036978]
						taper_order_id					=	(String)orderLineDtls.get(++i);//from OR_ORDER
						taper_order_line_num					=	(String)orderLineDtls.get(++i);//from OR_ORDER
						if(taper_order_yn.equals("Y") && !taper_order_id.equals("") && !taper_order_line_num.equals("")){
							taper_disable = "disabled";
							bms_qty = "0"; // added to avoid displaying qty for tapered drugs
						}
						else*/
						//added for IN070605 START
						if(intractn_req_yn && revw_aprrove_applicable_yn.equals("Y") && iv_prep_yn=="" ){
							review_called_from="disp_medication";
						}
						else{
							review_called_from="";
						}
						 ALLERGY_REMARKS_YN="N";
						 DOSAGE_REMARKS_YN="N";
						 DUPLICATE_REMARKS_YN="N";
						 INTARACTION_REMARKS_YN="N";
						 ABUSE_REMARKS_YN="N";//added for aakh-crf-0140
						alergy_details_remarks=(String)orderLineDtls.get(++i);
						if( intractn_req_yn && !alergy_details_remarks.equals("")&& alergy_details_remarks!=null){
							ALLERGY_REMARKS_CLASS="ALLERGY_REMARKS";
							ALLERGY_REMARKS_YN="Y";
						}
						else{
							ALLERGY_REMARKS_CLASS="ALLERGY";	
						}
						dosage_details_remarks=(String)orderLineDtls.get(++i);
						if(intractn_req_yn && !dosage_details_remarks.equals("")&& dosage_details_remarks!=null){
							DOSAGE_REMARKS_CLASS="DOSELIMIT_REMARKS";
							DOSAGE_REMARKS_YN="Y";
								}
								else{
									DOSAGE_REMARKS_CLASS="DOSELIMIT";	
								}
						duplicate_details_remarks=(String)orderLineDtls.get(++i);
						if(intractn_req_yn && !duplicate_details_remarks.equals("")&& duplicate_details_remarks!=null){
							DUPLICATE_REMARKS_CLASS="CURRENTRX_REMARKS";
							DUPLICATE_REMARKS_YN="Y";
						}
						else{
							DUPLICATE_REMARKS_CLASS="CURRENTRX";	
						}
						intaraction_details_remarks=(String)orderLineDtls.get(++i);
						if(intractn_req_yn && !intaraction_details_remarks.equals("")&& intaraction_details_remarks!=null){
							INTARACTION_REMARKS_CLASS="INTARACTION_REMARKS";
							INTARACTION_REMARKS_YN="Y";
						}
						else{
							INTARACTION_REMARKS_CLASS="DINTERACN";	
						}
						

					    abuse_drug_override_reason=(String)orderLineDtls.get(++i);//ADDED FOR AAKH-CRF-0140
						abuse_exists=(String)orderLineDtls.get(++i);//ADDED FOR AAKH-CRF-0140
						drugIndication=(String)orderLineDtls.get(++i);//ADDED FOR JD-CRF-0220
							
						if(drug_abuse_appl &&( !abuse_drug_override_reason.equals("") )){
							 ABUSE_REMARKS_CLASS="ABUSE_REMARKS";//ADDED FOR AAKH-CRF-0140
							  ABUSE_REMARKS_YN="Y";//ADDED FOR AAKH-CRF-0140
							
						}
						else{
							ABUSE_REMARKS_CLASS="";
							ABUSE_REMARKS_YN="N";
						}
						System.out.println("811 abuse_drug_override_reason"+abuse_drug_override_reason);
						
						if(disp_locn_catg.equals("I") || disp_locn_catg.equals("IAE"))//Adding start for TH-KW-CRF-0014
						  patient_brought_medn =(String)orderLineDtls.get(++i);
						  ++i;//Added for TH-KW-CRF-0008
						++i;//Added for TH-KW-CRF-0008
							category_code=(String)orderLineDtls.get(++i);//added for mms-dm-crf-0209.1
						alternate_yn=(String)orderLineDtls.get(++i);//added for mms-dm-crf-0209.1
						if(patient_brought_medn.equals("Y")){
							classvalue			=	"PATIENTMED";//Adding end for TH-KW-CRF-0002
						}
						System.err.println("822 classvalue==="+classvalue+"patient_brought_medn==="+patient_brought_medn);
						//added for IN070605 END
						
						taper_disable="";
						taperValues=bean.chkfortapering(order_id,drug_code, order_line_no, patient_id);	//Modified for RUT-CRF-0088 [IN036978]
						count =Integer.parseInt(taperValues.get("COUNT").toString()); 
						tot_tap=Float.parseFloat(taperValues.get("TOT_QTY").toString());
						show_remarks			= "N";
						if(!allergy_override_reason.equals("")||!dosage_limit_override_reason.equals("")||!duplicate_drug_override_reason.equals("")||!interaction_override_reason.equals("")||!contraind_override_reason.equals("") || !food_interaction_override_reason.equals("") ||  !lab_interaction_override_reason.equals("") || !disease_inter_override_reason.equals("")){ //modified for MMS-KH-CRF-0029//disease_inter_override_reason for MMS-DM-CRF-0229
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
						//added for MMS-KH-CRF-0029 - end disease_inter_override_reason
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
							drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.VerificationRemarks.label","ph_labels")+" : "+verificationremarks.trim()+"\n");	//code added for Bru-HIMS-CRF-416[IN045566]-- End
							System.out.println("abuse_drug_override_reason"+abuse_drug_override_reason+"drugs_remarks"+drugs_remarks);
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
							System.out.println("882 drugs_remarks"+drugs_remarks);
							
							System.out.println("prathyusha sfjsef");
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
							System.out.println("919 prathyusha strDrugsRemarks"+strDrugsRemarks);
						}
						adr_count			= bean.getADRCount(patient_id,drug_code);
						pres_details		= bean.getPresDetails(order_id);
						System.out.println("924 pres_details  "+pres_details);
						System.out.println("924 adr_count  "+adr_count);
						if(!exceed_dose.equals("")){ //if condition added for ML-MMOH-CRF-1408
							String repeat_value = 											bean_1.getFreqRepeatCode(order_id, order_line_no).split("~")[2];
							 System.out.println("925 prathyusha repeat_value"+repeat_value);
							 celling_dose = bean_1.getMinMaxCeilingDose(drug_code,patient_id,repeat_value,order_id,order_line_no);
							 System.out.println("927 prathyusha celling_dose"+celling_dose);
								if(celling_dose!=null && celling_dose.size()>0){
								min_unit_ceiling_dose = (String)celling_dose.get(0);
								max_unit_ceiling_dose = (String)celling_dose.get(1);
								min_daily_ceiling_dose = (String)celling_dose.get(2);
								max_daily_ceiling_dose = (String)celling_dose.get(3);
							 }
						
						}System.out.println("935 prathyusa  ");
%>
						<tr id='<%="RECORD"+(recCount-1)%>' name='<%="RECORD"+(recCount-1)%>' <%=taper_disable%>>
<%				   if(intractn_req_yn && order_type.equals("NOR")){ // Added for MMS-KH-CRF-0028 [IN070605] - Start
%>					<td> 
						<input type="checkbox" name="verifyChecked_<%=recCount%>" id="verifyChecked_<%=recCount%>" onclick="setValue(this)" value="Y" checked >
					</td>
			
<%                                  }
                                   else{
%>                                      <input type="hidden" name="verifyChecked_<%=recCount%>" id="verifyChecked_<%=recCount%>" value="Y">
<% 	
                                   } // Added for MMS-KH-CRF-0028 [IN070605] - End
%>
							<td class="white" width="6%" >
								<table border="1" width="100%" cellpadding="0" cellspacing="0" align="center">
									<tr>
<%	
										if(allergy.equals("")) { System.out.println("955 allergy  "+allergy);
%>
											<td class="white" width="20%">&nbsp;</td> <!-- 33% changed to 20% for MMS-KH-CRF-0013 -->
											 <INPUT TYPE="hidden" id='ALLERGY_VALUE<%=(recCount)%>' name='ALLERGY_VALUE<%=(recCount)%>' value="Y" /><!-- added for IN070605-->
<%	
										}
										else{//TD CLASS CHANGED and order_id,order_line_no,(recCount),patient_class,review_called_from FOR IN070605
										%>
										<td  class='<%=ALLERGY_REMARKS_CLASS%>' id='<%="ALLERGY"+(recCount)%>' name='<%="ALLERGY"+(recCount)%>' width="20%" style="cursor:pointer" onClick="showAllergyDetails('<%=generic_id%>','<%=patient_id%>','<%=encounter_id%>','<%=java.net.URLEncoder.encode(generic_name,"UTF-8")%>','<%=java.net.URLEncoder.encode(drug_name,"UTF-8")%>','<%=order_id%>','<%=order_line_no%>','<%=(recCount)%>','<%=patient_class%>','<%=review_called_from%>')">&nbsp;</td><!-- 33% changed to 20% for MMS-KH-CRF-0013 -->
										<%if(intractn_req_yn && revw_aprrove_applicable_yn.equals("Y") && iv_prep_yn=="" ){//if else condtion added for IN070605
										%>
										<INPUT TYPE="hidden" id='ALLERGY_VALUE<%=(recCount)%>' name='ALLERGY_VALUE<%=(recCount)%>' value="<%=ALLERGY_REMARKS_YN%>" />
										
										<%}else{
										 %>
										 <INPUT TYPE="hidden" id='ALLERGY_VALUE<%=(recCount)%>' name='ALLERGY_VALUE<%=(recCount)%>' value="Y" />
										
										<% } %>
										
										<%	
										}if(exceed_dose.equals("")) { 
%>
											<td class="white" width="20%">&nbsp;</td><!-- 33% changed to 20% for MMS-KH-CRF-0013 -->
											<INPUT TYPE="hidden" id='<%="DOSELIMIT_VALUE"+(recCount)%>' name='<%="DOSELIMIT_VALUE"+(recCount)%>' value="Y" />
<% 										}
										else{	//TD CLASS CHANGED and order_id,order_line_no,(recCount),patient_class,review_called_from FOR IN070605
%>										<td class='<%=DOSAGE_REMARKS_CLASS%>' id='<%="DOSELIMIT"+(recCount)%>' name='<%="DOSELIMIT"+(recCount)%>' width="20%" style="cursor:pointer" onClick="showMonoGraph('<%=java.net.URLEncoder.encode(drug_name)%>','<%=java.net.URLEncoder.encode(monograph)%>','<%=daily_dose%>','<%=unit_dose%>','<%=min_unit_dose%>','<%=min_daily_dose%>','<%=dosage_unit%>','<%=std_dose%>','<%=dose_unit_desc%>','<%=order_id%>','<%=order_line_no%>','<%=(recCount)%>','<%=patient_class%>','<%=review_called_from%>','<%=max_daily_ceiling_dose%>','<%=min_daily_ceiling_dose%>','<%=max_unit_ceiling_dose%>','<%=min_unit_ceiling_dose%>','<%=ceil_dose_unit_desc%>')">&nbsp;</td> <!-- ceiling dose added for ML-MMOH-CRF-1408 and  ceil_dose_unit_desc = dose_unit_desc;//added for ML-MMOH-CRF-1408-->
											<%if(intractn_req_yn && revw_aprrove_applicable_yn.equals("Y") && iv_prep_yn=="" ){//if else condtion added for IN070605
											%>
												<INPUT TYPE="hidden" id='<%="DOSELIMIT_VALUE"+(recCount)%>'  name='<%="DOSELIMIT_VALUE"+(recCount)%>'value="<%=DOSAGE_REMARKS_YN%>" />
												<%}else{ %>
												<INPUT TYPE="hidden" id='<%="DOSELIMIT_VALUE"+(recCount)%>' name='<%="DOSELIMIT_VALUE"+(recCount)%>' value="Y" />
												<%} %>
											
<%											}
										if(duplicate_yn.equals("Y") || !duplicate_drug_override_reason.equals("")  ) { 
											//TD CLASS CHANGED and order_id,order_line_no,(recCount),patient_class,review_called_from FOR IN070605
											%>
											<td class='<%=DUPLICATE_REMARKS_CLASS%>' id='<%="CURRENTRX"+(recCount)%>' name='<%="CURRENTRX"+(recCount)%>' width="20%" style="cursor:pointer" onClick="callActiveOrders('<%=patient_id%>','<%=encounter_id%>','<%=generic_id%>','<%=order_id%>','<%=order_line_no%>','<%=(recCount)%>','<%=patient_class%>','<%=review_called_from%>')">&nbsp;</td><!-- 33% changed to 25% for MMS-KH-CRF-0013 -->
											<%if(intractn_req_yn && revw_aprrove_applicable_yn.equals("Y") && iv_prep_yn==""){//if else condtion added for IN070605 %>
											
												<INPUT TYPE="hidden" id='<%="CURRENTRX_VALUE"+(recCount)%>' name='<%="CURRENTRX_VALUE"+(recCount)%>' value="<%=DUPLICATE_REMARKS_YN%>" />
												<%}else{ %>
												<INPUT TYPE="hidden" id='<%="CURRENTRX_VALUE"+(recCount)%>' name='<%="CURRENTRX_VALUE"+(recCount)%>' value="Y" />
												<%} %>
											
<%
										}else{
%>
											<td class="white" width="20%">&nbsp;</td><!-- 33% changed to 25% for MMS-KH-CRF-0013 -->
											<INPUT TYPE="hidden" id='<%="CURRENTRX_VALUE"+(recCount)%>' name='<%="CURRENTRX_VALUE"+(recCount)%>' value="Y" /><!-- added  FOR IN070605 -->
<%	
										}
									if( iv_prep_yn.equals("")){ // Added for MMS-KH-CRF-0013 - Start
									pres_bean.setEncounterId(encounter_id); //MMS-KH-CRF-0029[IN070606]
										if(!drug_db_interface_yn.equals("Y") && pres_bean.getDrugInteractionDtls(drug_code, bean_1.getForm_code(order_id+order_line_no+drug_code), generic_id, start_date, end_date, patient_id).size()>2) { 											
								    	    
											form_code = bean_1.getForm_code(order_id+order_line_no+drug_code);
											form_desc = bean_1.getForm_descs(order_id+order_line_no+drug_code);
											//TD CLASS CHANGED and order_id,order_line_no,(recCount),patient_class,review_called_from FOR IN070605
%>
											<td class='<%=INTARACTION_REMARKS_CLASS%>'id='<%="INTARACTION"+(recCount)%>' name='<%="INTARACTION"+(recCount)%>' width="20%" style="cursor:pointer" onClick="showDispInractionDtl('<%=patient_id%>','<%=encounter_id%>','<%=drug_code%>','<%=form_code%>','<%=generic_id%>','<%=start_date%>','<%=end_date%>','<%=java.net.URLEncoder.encode(drug_name,"UTF-8")%>','<%=java.net.URLEncoder.encode(form_desc,"UTF-8")%>','<%=order_id%>','<%=order_line_no%>','<%=(recCount)%>','<%=patient_class%>','<%=review_called_from%>')">&nbsp;</td>
											<%if(intractn_req_yn && revw_aprrove_applicable_yn.equals("Y") && iv_prep_yn==""){//if else condtion added for IN070605 %>
											
												<INPUT TYPE="hidden" id='<%="INTARACTION_VALUE"+(recCount)%>' name='<%="INTARACTION_VALUE"+(recCount)%>' value="<%=INTARACTION_REMARKS_YN%>" />
												<%}else{ %>
												<INPUT TYPE="hidden" id='<%="INTARACTION_VALUE"+(recCount)%>' name='<%="INTARACTION_VALUE"+(recCount)%>' value="Y" />
												<%} %>
<% 
							            }
								       else{	
%>
								    	   <td class="white" width="20%">&nbsp;</td> 
								    	   <INPUT TYPE="hidden" id='<%="INTARACTION_VALUE"+(recCount)%>' name='<%="INTARACTION_VALUE"+(recCount)%>' value="Y" /><!-- added  FOR IN070605 -->
<%						    	   
									   }
									}// Added for MMS-KH-CRF-0013 - End
									else{ // else Added for MMS-KH-CRF-0028 [IN070605] - Start
										%>
										<INPUT TYPE="hidden" id='<%="INTARACTION_VALUE"+(recCount)%>' name='<%="INTARACTION_VALUE"+(recCount)%>' value="Y" /><!-- added  FOR IN070605 -->
									<%} // else Added for MMS-KH-CRF-0028 [IN070605] - End
%>
			               <%		if(drug_abuse_appl && abuse_drug_override_reason != null && abuse_drug_override_reason != "" ) { System.out.print("abuse_exists----->"+abuse_exists+"ABUSE_REMARKS_CLASS"+ABUSE_REMARKS_CLASS);
											
											%>
											<td class='<%=ABUSE_REMARKS_CLASS%>'  width="20%" style="cursor:pointer" onClick="showAbuseDetails('','<%=patient_id%>','<%=encounter_id%>','<%=generic_id%>','<%=drug_code%>','clicking')">&nbsp;</td>
											
												
												
											
<%
										}else{
%>
											<td class="white" width="20%">&nbsp;</td>
											
<%	
										}
					%></tr>
								</table>
							</td>
							<td class="<%=classvalue%>"   width="3%" nowrap onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')">
								<!--<input type="checkbox" name="hold<%=recCount%>" id="hold<%=recCount%>" onClick="callReason(this,'<%=order_id%>','<%=drug_code%>','<%=recCount%>','<%=order_line_no%>');notifyChange()" <%=hold_status%> value="Y"><br><label style="cursor:pointer;color:blue;font-size:9px;<%=remark_status%>" onClick="callReason(document.DispMedicationAllStages.hold<%=recCount%>,'<%=order_id%>','<%=drug_code%>','<%=recCount%>','<%=order_line_no%>');notifyChange()" id='hold_remarks_<%=recCount%>'>Remarks</label>	-->
								<label style="cursor:pointer;color:blue;font-size:9px;" onClick="callReason(this,'<%=order_id%>','<%=drug_code%>','<%=recCount%>','<%=order_line_no%>','V');notifyChange()" id='hold_remarks_<%=recCount%>' <%=taper_disable%>><%=hold_text%></label>
								<input type="hidden" name="drug_code<%=recCount%>" id="drug_code<%=recCount%>" value="<%=drug_code%>">
								<input type="hidden" name="fromdb_<%=recCount%>" id="fromdb_<%=recCount%>" value="<%=fromdb%>">
								<input type="checkbox" name="hold<%=recCount%>" id="hold<%=recCount%>" style='display:none' value="<%=check_value%>" <%=hold_status%>>
								<input type="hidden" name="hold_status<%=recCount%>" id="hold_status<%=recCount%>" value="<%=hold_status%>">
							</td>
							<td class="<%=home_med_style%>" width="2%" >    <!-- Added for Bru-HIMS-CRF-093-DD1[IN047223]  -->
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
							<td class="<%=classvalue%>" style="font-size:9px;overflow: auto;" width="41%" 
							onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<% 
							if(!order_type.equals("TD") && !order_type.equals("TA")) { 
%>
								<label style='color:red;font-size:12px;FONT-WEIGHT: BOLDER;cursor:pointer;' onclick="showDrugMasterValues('<%=drug_code%>');" id="drug_mast_det_<%=recCount%>">&nbsp;+&nbsp;</label>
<%	
							}
%>
							<label style="<%=style%>"  <%=taper_disable%> onclick="showDrugDetails('<%=patient_class%>','<%=source_code%>','<%=order_id%>','<%=drug_code%>','<%=order_line_no%>','','<%=disp_locn_code%>','','','<%=patient_id%>');" id="drug_desc<%=recCount%>"><%=drug_name%>&nbsp;<%=strength%></label>  <!--  , 'patient_id' added for [IN:035667] --><!-- Added for 41282  -->
<% 
							if(order_type.equals("TD")){ 
%>
								<img src='../../ePH/images/AddedIngredient.gif' height='15' width='15' style="cursor:pointer;" title='<fmt:message key="ePH.Constituents.label" bundle="${ph_labels}"/>' onClick="displayConstInPPN('<%=drug_code%>')"></img>
<%
							}
							if ((ext_prod_id!=null)&& !(ext_prod_id.equals(""))&& drug_db_interface_yn.equals("Y")){ 
%>
								<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/info.gif" height=20  width=20 onClick="showDrugInfo('<%=ext_prod_id%>','<%=java.net.URLEncoder.encode(drug_name,"UTF-8")%>')"> <!-- Passing UTF-8 for Drug name By Sandhya -->
<%		
							}
							if ((image_path!=null)&& !(image_path.equals(""))){
%>
								<img style="cursor:pointer;" src="../../ePH/images/camera.gif" height=20  width=20 onClick="showImage('<%=drug_code%>','<%=trade_code%>')">
<%     
							}
							if(adr_count>0){
%>
								<img  id="ADR_img" src='../../ePH/images/ADR.gif'   title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>' onclick= "callADRdetails('<%=patient_id%>','<%=drug_code%>')"></img><!-- callADRdetails() newly added for RUT-SCF-0144 [IN:033371]-->
 <%
							}
							if(bDrugOrder){
%>
								<img src='../../ePH/images/DrugInfo.gif' width='17' height='15' onclick = "showDrug('<%=drug_code%>');" >
								<label id='lblDiscCancelledOrders_<%=recCount%>' style='cursor:pointer;<%=disc_cancelled_orders_display%>' title='<fmt:message key="ePH.DiscCancelDrugDtls.label" bundle="${ph_labels}"/>'>&nbsp;&nbsp;&nbsp;&nbsp;<img id='discCancelledOrders_<%=recCount%>' src="../../ePH/images/DiscCancelledIndicator.png" onclick='callDiscCancelledOrders("<%=disc_cancelled_orders%>", "<%=java.net.URLEncoder.encode(drug_desc,"UTF-8")%>");'></label>
	        					<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=dosage_dtls%>&nbsp;&nbsp;<b><fmt:message key="Common.from.label" bundle="${common_labels}"/></b><%=com.ehis.util.DateUtils.convertDate(start_date,"DMYHM","en",locale)%>&nbsp;&nbsp;<b><fmt:message key="Common.to.label" bundle="${common_labels}"/></b><%=com.ehis.util.DateUtils.convertDate(end_date,"DMYHM","en",locale)%>
<%
							}
							int	k	=	0;
							ArrayList alt_qty	=	new ArrayList();
							System.out.println("1121 multi_drugs "+multi_drugs);
							for(int n=0; n<multi_drugs.size(); n+=5)	{ 
								alt_drug_code	=	(String)multi_drugs.get(n);
								alt_drug_desc	=	(String)multi_drugs.get(n+1);
								form_code		=	(String)multi_drugs.get(n+2);
								drug_color		=	(String)colors.get(k++);
								qty				=	bean.getAlternateDrugQuantity(patient_id,order_id,order_line_no,alt_drug_code);
								alt_qty.add(qty);
%>
								<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style="cursor:pointer;color:<%=drug_color%>" onclick="callDrugDetails('<%=patient_id%>','<%=order_id%>','<%=drug_code%>','<%=alt_drug%>','<%=alt_drug_code%>','<%=drug_color%>','<%=form_code%>','');changeColor(document.frmDispQueueManagementAllocatePrescDetails,this);" id="alte_drug_desc<%=n%>"><%=alt_drug_desc%>&nbsp;&nbsp;</label><!-- code '<%=drug_name%>','<%=alt_drug_desc%>', removed for TTM-SCF-0096[IN048808]-->
<%
							}
							if(count>1){
								/*float tmp_tot_qty=0;  //Added for RUT-CRF-0088 [IN036978] -- begin
								if(tot_tap_qty.containsKey(drug_code))
									tmp_tot_qty=Float.parseFloat(tot_tap_qty.get(drug_code).toString());
								else
									tmp_tot_qty=0;
								tot_tap=tmp_tot_qty+Float.parseFloat(pres_qty);
								tot_tap_qty.put(drug_code,tot_tap); */ //Added for RUT-CRF-0088 [IN036978] --end
								String taper = bean.getTapervalue();
								System.out.println("1163 taper "+taper);
								if(taper.equals("UP")){
%>
									<img src="../../ePH/images/uparrow.gif" onclick="showTaperDetails('<%=patient_id%>','<%=order_id%>','<%=drug_code%>');" valign="center" title='Taper Dose' style="cursor:pointer"height='20' width='20'></img>
<%
								}
								else if(taper.equals("DOWN")){
%>
									<img src="../../ePH/images/downarrow.gif"onclick="showTaperDetails('<%=patient_id%>','<%=order_id%>','<%=drug_code%>');" valign="center" title='Taper Dose' style="cursor:pointer" height='20' width='20'></img>
<%	
								}
								else{
%>
									<img src="../../ePH/images/MultiFrequency.gif" onclick="showTaperDetails('<%=patient_id%>','<%=order_id%>','<%=drug_code%>');" valign="center" title='<fmt:message key="ePH.TaperDose.label" bundle="${ph_labels}"/>' style="cursor:pointer" height='20' width='20' ></img>
<%
								}
								if(totalTaperQtyDisplay.equals("Y")){ //added for RUT-CRF-0088 [IN036978]
%>
									<fmt:message key="Common.total.label" bundle="${common_labels}"/><fmt:message key="Common.Taper.label" bundle="${common_labels}"/><fmt:message key="Common.Qty.label" bundle="${common_labels}"/>   <!--Added for RUT-CRF-0088 [IN036978] -->
									<label>-<%=(int)tot_tap%>&nbsp;&#40;<%=qty_uom_disp%>&#41;</label>  <!--Added for RUT-CRF-0088 [IN036978] -->
<%				
								}
							}System.out.println("1163 bmscount "+bmscount);
							if(bmscount==0){
								if(pat_couns_reqd_yn.equals("Y")){
									pat_reqd="Checked";	
%>
									<img src="../../ePH/images/Patientcounsel.gif"  ></img>
									<input type='checkbox' name='pat_reqd_<%=recCount%>' id='pat_reqd_<%=recCount%>' <%=pat_reqd%> value='C' disabled onclick="CheckPatReqd(this)"></td>
<%
								}
								if(pat_couns_reqd_yn.equals("C")){
									pat_reqd="Checked";	%>
									<img src="../../ePH/images/Patientcounsel.gif"  ></img>
									<input type=checkbox name=pat_reqd_<%=recCount%> <%=pat_reqd%> disabled value=''></td>
<%
								} 
								if(pat_couns_reqd_yn.equals("N")|| pat_couns_reqd_yn.equals("Null") ){
									pat_reqd="Unchecked";	
									//commented By Naveen during PE
									//pt_couns_reqd_yn       =   bean.getPatCounsReqd(drug_code);
									if(pt_couns_reqd_yn.equals("Y")){
%>
										<img src="../../ePH/images/Patientcounsel.gif"  ></img>
										<input type="checkbox" valign='center' name='pat_reqd_<%=recCount%>' id='pat_reqd_<%=recCount%>' <%=pat_reqd%> value='<%=pat_couns_reqd_yn%>' onclick='CheckPatReqd(this)'>
<%
									}
								}
							} 
							drug_name_1=  drug_name;  
							System.out.println("1190 drug_name ");
							//Commented By Sandhya from 705 to 709 line for incident num:24786 on 24/Nov/2010		
							/*if(!drug_name_1.equals("")&&drug_name_1!=null){
								drug_name_1=drug_name_1.replaceAll(" ","%20");
								drug_name_1=	java.net.URLEncoder.encode(drug_name_1);
								drug_name_1=drug_name_1.replaceAll("%2520","%20");
							}*/  
%>
							<!-- Passed URLEncoder,UTF-8  for drug name in displayInstructions regarding incident num:25276 ==By sandhya -->  
							</td>
							<td class="<%=classvalue%>" style="font-size:9px"  >
							<img src="../../ePH/images/DrugRemarks.gif" id='drugRemarks_<%=recCount%>' title='' valign="center"style="cursor:pointer;" onClick="displayInstructions('<%=order_id%>','<%=order_line_no%>','<%=dialog_height%>','<%=java.net.URLEncoder.encode(drug_name_1,"UTF-8")%>','Y')" <%=remarks_style%> ><!-- code  ePH.PractitionerPharmacistInstructions replaced by drugs_remarks for Bru-HIMS-CRF-416[IN045566] -->
							<script>
								var drug_remarks = decodeURIComponent('<%=strDrugsRemarks%>');
								eval(document.getElementById("drugRemarks_"+'<%=recCount%>')).title= drug_remarks ;
							</script>
							</td> 
							<td class="<%=classvalue%>" style="font-size:9px" title="<%=pres_details%>">
								<img src="../../ePH/images/exceed.gif" valign="center"></td>		
							</td> 
							<td class="<%=classvalue%>" style="font-size:9px" width="10%" onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')">&nbsp;<%=pres_qty%>&nbsp;(<%=qty_uom_disp%>)</td><!---/*bean.getUomDisplay(facility_id,qty_uom)*/-->
							<td class="<%=classvalue%>" width="10%" style="font-size:9px" onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')">&nbsp;<%=bms_qty%>&nbsp;(<%=qty_uom_disp%>)</td><!---/*bean.getUomDisplay(facility_id,qty_uom)*/--->
<%	
							if(billing_interface_yn.equals("Y")&& bl_display.equals("Y")){	System.out.println("1212 billing_interface_yn "+billing_interface_yn);
								if(in_formulary_yn.equals("Y")&& billable_item_yn.equals("Y")){       
									float gross_charge_amount = 0;
									float groos_pat_payable   = 0;
								    float gross_amount        = 0;//Added for ML-BRU-CRF-0469
									//float net_amount          = 0;	
									gross_charge_amount_str	  =  "";
									groos_pat_payable_str	  =  "";
								    gross_amount_str =  "";//added for ML-BRU-CRF-0469
									StringBuffer gross_charge_display_str  = new StringBuffer();
									StringBuffer pat_charge_display_str    = new StringBuffer();   
									StringBuffer gross_disply_str          = new StringBuffer(); //added for ML-BRU-CRF-0469
									//added for ML-BRU-SCF-1798 - start

		 					IssueUOMAndBaseUOM		=	(HashMap)bean.getStoreDfltIssueUOMAndBaseUOM(disp_locn_code,drug_code);
		 					System.out.println("1227 IssueUOMAndBaseUOM "+IssueUOMAndBaseUOM);
							base_uom			     =  (String)IssueUOMAndBaseUOM.get("BASE_UOM")== null ? "":(String)IssueUOMAndBaseUOM.get("BASE_UOM");

							if(!base_uom.equals("")&& !base_uom.equals(qty_uom)){ System.out.println("1229 base_uom "+base_uom);
							base_to_disp_uom_equl    =	bean.getEqulValue ( drug_code, base_uom, qty_uom);					bms_qty = Math.ceil(Double.parseDouble(bms_qty)* base_to_disp_uom_equl)+"";
							}
					//added for ML-BRU-SCF-1798 - end
									HashMap chareg_det = bean.callItemChargeDtls(patient_id ,bl_encounter_id,bl_patient_class,drug_code,Double.parseDouble(bms_qty),";",sysdate,disp_locn_code,bl_incl_excl_val,bl_incl_excl_override_reason_code,order_id,order_line_no,"V",dischargeIND);//order_id,order_line_no added for MMS-DM-CRF-0126.2
									System.out.println("1234 chareg_det "+chareg_det);	
									if(chareg_det.get("error_msg").equals("")){
										decimalFormatString=(String)chareg_det.get("BL_DECIMAL_FORMAT_STRING");								
										DecimalFormat dfTest        = new DecimalFormat(decimalFormatString);                      
										
										/*if(!chareg_det.get("grosschargeamt").equals("null")){
											 gross_charge_amount= Float.parseFloat((String)chareg_det.get("grosschargeamt"));
										}*/// Commented ML-BRU-SCF-0368 [IN:034748]
										if(!chareg_det.get("patnetamt").equals("null")){
											 groos_pat_payable  = Float.parseFloat(((String)chareg_det.get("patnetamt")).trim());
										}
										if(!chareg_det.get("netchargeamt").equals("null")){
											// groos_pat_payable  = Float.parseFloat((String)chareg_det.get("netchargeamt"));
											 gross_charge_amount  = Float.parseFloat((String)chareg_det.get("netchargeamt")); // added ML-BRU-SCF-0368 [IN:034748]
										}
										//added for ML-BRU-CRF-0469 start 
										if(displayGrossAmtYn){ 
										if(!chareg_det.get("grosschargeamt").equals("null")){
											gross_amount  = Float.parseFloat((String)chareg_det.get("grosschargeamt")); 
										  }
										}
										//added for ML-BRU-CRF-0469 end
										gross_charge_amount_str = dfTest.format(gross_charge_amount);
										groos_pat_payable_str   = dfTest.format(groos_pat_payable);
										//added for ML-BRU-CRF-0469 start
										if(displayGrossAmtYn){ 
										gross_amount_str = dfTest.format(gross_amount);
										}//added for ML-BRU-CRF-0469 end
										gross_charge_display_str.append("<label style='font-size:9px;color:black;text-align: center'>").append(gross_charge_amount_str).append("</label>");
										pat_charge_display_str.append("<label style='font-size:9px;color:black;text-align: center'>").append(groos_pat_payable_str).append("</label>");	
										//added for ML-BRU-CRF-0469 start
										if(displayGrossAmtYn){ 
										gross_disply_str.append("<label style='font-size:9px;color:black;text-align: center'>").append(gross_amount_str).append("</label>");//added for ML-BRU-SCF-0469
										}
										//added for ML-BRU-CRF-0469 end 
										tot_gross_charge_amount = tot_gross_charge_amount+gross_charge_amount;
										tot_groos_pat_payable   = tot_groos_pat_payable+groos_pat_payable;
										//added for ML-BRU-SCF-0469 start
										if(displayGrossAmtYn){ 
										tot_gross_amount        = tot_gross_amount+gross_amount;
												
										}
									//added for ML-BRU-SCF-0469 end 
								   }
								   else{
										if(order_type.equals("TA")){
											gross_charge_display_str.append("<label>&nbsp;</label>").append("");
											pat_charge_display_str.append("<label>&nbsp;</label>").append("");	
											//added for ML-BRU-SCF-0469 start
											if(displayGrossAmtYn){ 
											gross_disply_str.append("<label>&nbsp;</label>").append("");
											}
											
								                  }//added for ML-BRU-SCF-0469 end
										else{
											gross_charge_display_str.append("<label style='font-size:9px;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label>");
											pat_charge_display_str.append("<label style='font-size:9px;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label>");	
											//added for ML-BRU-SCF-0469 strt 
											if(displayGrossAmtYn){ 
											gross_disply_str.append("<label style='font-size:9px;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label>");
											}
											//added for ML-BRU-SCF-0469 end
										}
								   }
%>	 
                                    <!-- Added for ML-BRU-CRF-0469 start -->
                                   <% if(displayGrossAmtYn){  %>
                                    <td  class="<%=classvalue%>" id='gross_amount_str_<%=recCount%>'><center><%=gross_disply_str%></center></td>
                                   <% } %>
                                    <!-- Added for ML-BRU-CRF-0469 end   -->
									<td  class="<%=classvalue%>" id='gross_charge_amount_str_<%=recCount%>'><center><%=gross_charge_display_str%></center></td>
									<td  class="<%=classvalue%>" id='groos_pat_payable_str_<%=recCount%>'><center><%=pat_charge_display_str%></center></td>
<%
									if(chareg_det.get("error_msg").equals("")){System.out.println("1307 recCount ");	
%>
										<input type="hidden" name="override_allowed_yn_<%=recCount%>" id="override_allowed_yn_<%=recCount%>"  value="<%=(String)chareg_det.get("override_allowed_yn")%>">
										<input type="hidden" name="excl_incl_ind_<%=recCount%>" id="excl_incl_ind_<%=recCount%>"        value="">
										<input type="hidden" name="excl_incl_ind_default_<%=recCount%>" id="excl_incl_ind_default_<%=recCount%>"value="<%=(String)chareg_det.get("excl_incl_ind")%>">
										<input type="hidden" name="approval_reqd_yn_<%=recCount%>" id="approval_reqd_yn_<%=recCount%>"     value="<%=(String)chareg_det.get("approval_reqd_yn")%>">
										<input type="hidden" name="bl_incl_excl_override_reason_desc_<%=recCount%>" id="bl_incl_excl_override_reason_desc_<%=recCount%>" value="">
										<input type="hidden" name="bl_incl_excl_override_reason_code_<%=recCount%>" id="bl_incl_excl_override_reason_code_<%=recCount%>" value="">
										<input type="hidden" name="gross_charge_amount_<%=recCount%>" id="gross_charge_amount_<%=recCount%>" value="<%=gross_charge_amount+""%>">
										<input type="hidden" name="groos_pat_payable_<%=recCount%>" id="groos_pat_payable_<%=recCount%>"   value="<%=groos_pat_payable+""%>">
										<!-- added for ML-BRU-CRF-0469 start -->
										<%if(displayGrossAmtYn){ %>
										<input type="hidden" name="gross_amount_<%=recCount%>" id="gross_amount_<%=recCount%>"   value="<%=gross_amount+""%>">
										<% } %>
										<!-- added for ML-BRU-CRF-0469 end -->
										<input type="hidden" name="drug_color_<%=recCount%>" id="drug_color_<%=recCount%>"   value='black'>
										
										<td class="<%=classvalue%>" ><a href="javascript:callIncludeExclude('V','<%=recCount%>','<%=drug_code%>','<%=bms_qty%>',';','<%=order_id%>','<%=order_line_no%>');" id="include_exclude"  style="font-size:9px;"><fmt:message key="Common.Include.label" bundle="${common_labels}"/>?</a></td>
<%System.out.println("1325 recCount ");	
									}
									else{System.out.println("1327 recCount ");	
%>
									   <td class="<%=classvalue%>" >&nbsp;</td>
<%
									}
								 }
								 else{System.out.println("1333 recCount ");	
%> 
                                                                       
                                     <!-- Added for ML-BRU-CRF-0469 start-->                                
                                     <% if(displayGrossAmtYn){ %>                                
                                    <td class="<%=classvalue%>" align="center" id='gross_amount_str_<%=recCount%>'>&nbsp;</td>
                                    <% } %>
                                     <!-- Added for ML-BRU-CRF-0469 end -->
									<td class="<%=classvalue%>" align="center" id='gross_charge_amount_str_<%=recCount%>'>&nbsp;</td>
									<td class="<%=classvalue%>" align="center" id='groos_pat_payable_str_<%=recCount%>'>&nbsp;</td>
									<td class="<%=classvalue%>" >&nbsp;</td>
<%
								}
							 }
%>		
							<td class="<%=classvalue%>"><label id="objectaa" style="cursor:pointer" class="hyperlink1" onClick=" callverifyremarks('<%=order_id%>', '<%=order_line_no%>')"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></label></td>
<%
							if(bean_1.getStockInstalled()){			 System.out.println("1350 recCount ");	
%>
								<!-- Passed URLEncoder,UTF-8  for drug name in callBatchSearchVerification regarding incident num:25276 ==By sandhya -->
								<td style="font-size:9px" width="6%" nowrap class="<%=classvalue%>" onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')">&nbsp;
									<label style='color:blue;cursor:pointer;font-size:9px' onClick="callBatchSearchVerification('<%=drug_code%>','<%=recCount%>','<%=java.net.URLEncoder.encode(drug_name_1,"UTF-8")%>','<%=pres_qty%>','<%=trade_code%>',
									'<%=end_date%>')"><fmt:message key="ePH.CheckStatus.label" bundle="${ph_labels}"/></label> 		</td> 
								<td class="white" width="2%" id="stock<%=recCount%>" name="stock<%=recCount%>" onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')">&nbsp;
								</td>
<%
							}
%>
							<input type="hidden"  name="order_line_num<%=recCount%>" id="order_line_num<%=recCount%>" value="<%=order_line_no%>">
							<input type="hidden"  name="dischargeIND<%=recCount%>" id="dischargeIND<%=recCount%>" value="<%=dischargeIND%>">
							<%-- Commented for RUT-CRF-0088 [IN036978] <input type="hidden" name="taper_order_yn<%=recCount%>" id="taper_order_yn<%=recCount%>" value="<%=taper_order_yn%>">
							<input type="hidden" name="taper_order_id<%=recCount%>" id="taper_order_id<%=recCount%>" value="<%=taper_order_id%>">
							<input type="hidden" name="taper_order_line_num<%=recCount%>" id="taper_order_line_num<%=recCount%>" value="<%=taper_order_line_num%>"> --%>
<%
							if(disp_level.equals("P")) {	
%>
								<input type="hidden"  name="order_id<%=recCount%>" id="order_id<%=recCount%>" value="<%=order_id%>">
<%
							}
%>
						</tr>
						<%if(Disp_drug_verify_remarks.equals("Y") && site_remarks && drug_remarks !="" && drug_remarks !=null){System.out.println("1374 Disp_drug_verify_remarks "+Disp_drug_verify_remarks); %>
							<tr>
							
							<td colspan="14"><label style="color:red;font-size: 9px;"><fmt:message key="ePH.DrugInstructions.label" bundle="${ph_labels}"/>&nbsp;&nbsp; :</label>
							<label style="font-size: 9px;" ><%=drug_remarks %></label> </br>
							
							</td>
							</tr>
						<%} %>	
						
<%     System.out.println("1384 recCount "+recCount);
						recCount++;
					}
%>
				</table>
				<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id_1%>">
				<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name_1%>">
				<input type="hidden" name="bean_id_1" id="bean_id_1" value="<%=bean_id%>">
				<input type="hidden" name="bean_name_1" id="bean_name_1" value="<%=bean_name%>">
				<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>">
				<input type="hidden" name="ord_date_time" id="ord_date_time" value="<%=ord_date_time%>">
				<input type="hidden" name="disp_stage" id="disp_stage" value="<%=disp_stage%>">
				<input type="hidden" name="practitioner_id" id="practitioner_id" value="<%=practitioner_id%>">
				<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
				<input type="hidden" name="mode" id="mode" value="<%=CommonRepository.getCommonKeyValue( "MODE_MODIFY" )%>">
				<input type="hidden" name="source_code" id="source_code" value="<%=source_code%>">
				<input type="hidden" name="source_type" id="source_type" value="<%=source_type%>">
				<input type="hidden" name="ordering_facility_id" id="ordering_facility_id" value="<%=ordering_facility_id%>">
				<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
				<input type="hidden" name="function_id" id="function_id" value="<%=bean_1.getSFunctionId()%>">
				<input type="hidden"  name="iv_prep_yn" id="iv_prep_yn" value="<%=iv_prep_yn%>">
				<input type="hidden"  name="recCount" id="recCount" value="<%=recCount%>"> <!--  Added for MMS-KH-CRF-0028 [IN070605] -->
				<input type="hidden"  name="displayGrossAmtYn" id="displayGrossAmtYn" value="<%=displayGrossAmtYn%>"><!-- added for ML-BRU-CRF-0469 -->
<%
				if(billing_interface_yn.equals("Y")&& bl_display.equals("Y")){System.out.println("1408 billing_interface_yn "+billing_interface_yn);
				
				System.out.println("1408 bl_display "+bl_display);
%>
					<input type="hidden" name="bl_encounter_id" id="bl_encounter_id" value="<%=bl_encounter_id%>">
					<input type="hidden" name="bl_patient_class" id="bl_patient_class" value="<%=bl_patient_class%>">
					<input type="hidden" name="bl_sysdate" id="bl_sysdate" value="<%=sysdate%>">
					<input type="hidden" name="disp_locn_code" id="disp_locn_code" value="<%=disp_locn_code%>">
					<input type="hidden" name="tot_gross_charge_amount" id="tot_gross_charge_amount" value="<%=tot_gross_charge_amount%>">
					<input type="hidden" name="tot_groos_pat_payable" id="tot_groos_pat_payable" value="<%=tot_groos_pat_payable%>">
					<!-- added for ML-BRU-CRF-0469 start -->
					<% if(displayGrossAmtYn){ %>
					<input type="hidden" name="tot_gross_amount" id="tot_gross_amount" value="<%=tot_gross_amount%>"> 
					<% } %>
					<!-- added for ML-BRU-CRF-0469 end -->
<%
				}
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
				<input type="hidden" name="performing_pract_id" id="performing_pract_id" value="<%=performing_pract_id%>">
				<script>
					callLegendsFrame('<%=patient_id%>','V','','','<%=order_id%>','<%=billing_interface_yn%>','<%=tot_gross_charge_amount_str%>','<%=tot_groos_pat_payable_str%>','N','N','<%=tot_gross_amount_str%>');  // added for ML-BRU-CRF-0469  tot_gross_amount_str 
				</script>
<%	
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
		</form>
	</body>
</html>

