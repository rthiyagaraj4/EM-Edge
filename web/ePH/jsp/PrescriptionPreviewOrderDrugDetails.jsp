<!DOCTYPE html>
<!--saved on 27th Oct 2005 -->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*,eOR.Common.*,eOR.*,java.text.DecimalFormat,eCommon.XSSRequestWrapper" pageEncoding="ISO-8859-1"%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
02/07/2017	  	IN061197	     	Mukesh M 											AAKH-CRF-0091 [IN061197] 
22/11/2019	  	IN070606	     	Manickavasagam J 											AAKH-CRF-0091 [IN061197] 
17/08/2020      IN073481           Prabha     17/08/2020       Manickavasagam J        Place more than 10 drugs -> Preview Rx -> shows more blank space 
20/10/2020      IN:069886         Haribabu                        Manickam            MO-CRF-20151
05/01/2021	 TFS id:7345           Haribabu	      05/01/2021       Manickavasagam J			     MMS-DM-CRF-0177
11/4/2022		26251					Shazana														SKR-SCF-1660
--------------------------------------------------------------------------------------------------------------
*/
try{
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale = (String) session.getAttribute("LOCALE");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String patient_id				=	request.getParameter("patient_id");
	String encounter_id			=	request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String bl_install_yn = request.getParameter("bl_install_yn")==null?"":request.getParameter("bl_install_yn");
	String bl_disp_charge_dtl_in_rx_yn = request.getParameter("bl_disp_charge_dtl_in_rx_yn")==null?"":request.getParameter("bl_disp_charge_dtl_in_rx_yn");
	String take_home_medication = request.getParameter("take_home_medication")==null?"":request.getParameter("take_home_medication");
	String episode_type = request.getParameter("episode_type")==null?"":request.getParameter("episode_type");
	String order_Date = request.getParameter("order_Date")==null?"":request.getParameter("order_Date");
	if(!locale.equals("en"));
		order_Date				= DateUtils.convertDate(order_Date, "DMYHM",locale,"en");
	String override_excl_incl_ind, overriden_action_reason ;

	String bean_id					= "@PrescriptionBean_1"+patient_id+encounter_id;
	String bean_name		= "ePH.PrescriptionBean_1";
	PrescriptionBean_1 bean = (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);
	ArrayList prescriptionDetails	=	bean.getpresDetails();
	String presBean_id			= "PrescriptionBean"+patient_id+encounter_id;
	String presBean_name		= "ePH.PrescriptionBean";
	PrescriptionBean presBean		= (PrescriptionBean)getBeanObject(presBean_id, presBean_name, request );

	String or_bean_name	="eOR.OrderEntryBean";
	String or_bean_id	="@orderentrybean"+patient_id+encounter_id;
	String facility_id	=  (String) session.getValue("facility_id");//21/10/09

	OrderEntryBean orbean = (OrderEntryBean)getBeanObject( or_bean_id,or_bean_name,request ) ;
	orbean.setLanguageId(locale);
	eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) orbean.getOrderEntryRecordBean();
	
	String drug_code		=	null;
	String srl_no			=	null;
	String taper_yn			=	null;
	String split_dose_yn	=	null;
	String qty_value		=	null;
	String qty_desc			=	null;
	String or_qty_desc		=	null;
	String freq_desc		=	null;
	String durn_value		=	null;
	String or_durn_desc		=	null;
	String strength_uom		=	null;
	String strength_uom_Details		=	"";
	String dosage_type		=	null;
	String strength_value	=	null;
	String no_refill		=	null;
	String end_date			=	null;
	String repeat_durn_type	=	null;
	String freq_chng_durn_desc	= "";
	String freq_chng_durn_value	= "";
	String	prn_dose		= 	"";
	String fract_dose		=   "N";
	String act_strength_value=  "";
	HashMap PRN_remarks		=	new HashMap();
	String PRN_remarks_code		=	"";
	String PRN_remarks_dtl		=	"";
	String freq_nature		=	"";
	String allergy_yn		=   "";
	String allergy_remarks	=	"";
	String override_yn		=	"";
	String override_reason	=   "";
	String overdose_yn		=	"";
	String overdose_remarks	=	"";
	String sliding_scale_remarks="";
	String dsg_reason = "";
	String dup_reason = "";
	String con_reason = "";
	String int_reason = "";
	String alg_reason = "";
	String trade_name="";
	String tot_payable = "";
	String pat_payable = "";
	double tot_payable_sum = 0.0;
	double pat_payable_sum = 0.0;
	String tot_payable_sum_str = "";
	String pat_payable_sum_str = "";
	String decimalFormatString = "";
	String repeatValue = "";
	String route_desc ="";
	HashMap RefillDetail	=	null;
	String tappered_over = "N";
	String drug_tapered = "N";
	String pat_brought_medn = "";
	ArrayList dose_list	    = new ArrayList();
	String billable_item_yn = "";
	String strength_per_value_pres_uom ="";
	//Code Added For ICN 29927	RUT-CRF-0034 -Start
	String route_color                 =""; 
	String addRouteDesc                 ="";
	String fntColor                 =""; 
	String backgrndColor= "";// added for CRF RUT-CRF-0034.1[IN:037389]
	String route_code ="";
	String order_uom="";
	float totTapperQty = 0;
	float tap_lvl_qty = 0;
	float balTaperQty=0;
	String totalTaperQtyDisplay = bean.getTotalTaperQtyDisplay();
	String tot_payable_tapper="", pat_payable_tapper="";
	HashMap hmBLDtlforPreview = null;
	//Code Added For ICN 29927	RUT-CRF-0034 -End
	String interaction_exists		=   "";
	String abuse_exists="";//added  for AAKH-CRF-0140
	String abuse_action="";//added for aakh-crf-0140
	String interaction_remarks	=	"";
	String abuse_remarks	=	"";//added  for AAKH-CRF-0140
	String food_interaction_remarks = ""; //MMS-KH-CRF-0029 [IN070606]
	String lab_interaction_remarks = ""; //MMS-KH-CRF-0029 [IN070606]
	String drugindication_remarks	=   "";//Added for SKR-SCF-0647[Inc:35263]
	String disease_interaction_remarks ="";//Added for MMS-DM-CRF-0229
	String display_auth_rule ="visibility:hidden", color_auth_rule = "RED", ord_auth_reqd_yn = "", ord_authorized_yn = "", strAuthStatus="-" ;  //added for ML-MMOH-CRF-0343
	String preview_auth_status_yn = bean.getPreviewAuthStatus(); //added for ML-MMOH-CRF-0343
	String stat_yn="";	//AAKH-CRF-0091 

	String freq_code=null;	//AAKH-CRF-0091 
	String pre_alloc_appl_yn =bean.getPreAllocApplYN();//Added for TFS id:7345		

			
%>
	<html>
		<head>
		<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
			<script language="javascript" src="../../eCommon/js/common.js"></script>
			<!--<script language="JavaScript" src="../../ePH/js/Prescription.js"></script>-->
			<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
			<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
			<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		</head>
		<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">

			<form name="prescription_form_preview_order" id="prescription_form_preview_order" >
				<table border="0" width="100%" cellspacing="0" cellpadding="0" id="prescription_table">
<%
			if(prescriptionDetails != null && prescriptionDetails.size()>0){
				ArrayList grp		=(ArrayList) bean.sortList();

				int k					=0;
				HashMap drugDetails		=	null;
				String absol_qty		=	"";
				String pres_base_uom	=	"";
				if(grp != null && grp.size() >0){
					for(int i=0;i<grp.size();i++){
						color_auth_rule ="BLACK"; // Added for ML-MMOH-CRF-0343
						strAuthStatus="-"; // Added for ML-MMOH-CRF-0343
						ArrayList displayList=(ArrayList) bean.getDisplayList((String)grp.get(i));
						totTapperQty = 0;
						balTaperQty = 0;
						if(displayList != null && displayList.size()>0){
							for(int j=0;j<displayList.size();j++){
								drugDetails=(HashMap) displayList.get(j);
								Iterator it = drugDetails.entrySet().iterator(); 
								while (it.hasNext()) { 
									Map.Entry pairs = (Map.Entry)it.next(); 
								} 
								pat_brought_medn =  (String)drugDetails.get("BROUGHT_BY_PAT")==null?"N":(String)drugDetails.get("BROUGHT_BY_PAT");
								if(pat_brought_medn.equals(""))
									pat_brought_medn ="N";
								billable_item_yn  =  (String)drugDetails.get("BILLABLE_ITEM_YN")==null?"Y":(String)drugDetails.get("BILLABLE_ITEM_YN");
								repeatValue = (String)drugDetails.get("REPEAT_VALUE");
								drug_code			= (String)drugDetails.get("DRUG_CODE")==null?"":(String)drugDetails.get("DRUG_CODE");
								srl_no				= (String)drugDetails.get("SRL_NO")==null?"":(String)drugDetails.get("SRL_NO");
								taper_yn			= (String)drugDetails.get("TAPER_DOSE_YN")==null?"":(String)drugDetails.get("TAPER_DOSE_YN");
								split_dose_yn		= (String)drugDetails.get("SPLIT_DOSE_YN_VAL")==null?"":(String)drugDetails.get("SPLIT_DOSE_YN_VAL");
								qty_value			= (String)drugDetails.get("QTY_VALUE")==null?"":(String)drugDetails.get("QTY_VALUE");
								// Below lines commented for IN25702 --06/11/2011-- priya
								//	if(qty_value!=null && !qty_value.equals("") && Float.parseFloat(qty_value) <1)
								//	qty_value = Float.parseFloat(qty_value) +"" ;

								//qty_desc			= (String)drugDetails.get("QTY_DESC")==null?"":(String)drugDetails.get("QTY_DESC");
								qty_desc			= (String)drugDetails.get("QTY_DESC_CODE")==null?"":(String)drugDetails.get("QTY_DESC_CODE"); //Changed from QTY_DESC to QTY_DESC_CODE for SKR-SCF-0309 [IN:029585]
								or_qty_desc			= (String)drugDetails.get("OR_QTY_DESC")==null?"":(String)drugDetails.get("OR_QTY_DESC");
								freq_desc			= (String)drugDetails.get("FREQ_DESC")==null?"":(String)drugDetails.get("FREQ_DESC");
								freq_desc			=	java.net.URLDecoder.decode(freq_desc,"UTF-8");
								freq_desc=freq_desc.replaceAll("%26","&");
								freq_desc=freq_desc.replaceAll("%40","@");
								//freq_desc = java.net.URLEncoder.encode(freq_desc,"UTF-8");
								//freq_desc=freq_desc.replaceAll("%2520","%20");
								stat_yn			= (String)drugDetails.get("stat_yn")==null?"":(String)drugDetails.get("stat_yn"); //AAKH-CRF-0091 
					
								freq_code			= (String)drugDetails.get("FREQ_CODE")==null?"":(String)drugDetails.get("FREQ_CODE");	//AAKH-CRF-0091 

								
								
								if(drugDetails.containsKey("TAPPERED_OVER"))
									tappered_over = (String)drugDetails.get("TAPPERED_OVER")==null?"N":(String)drugDetails.get("TAPPERED_OVER");

								durn_value			= (String)drugDetails.get("DURN_VALUE")==null?"":(String)drugDetails.get("DURN_VALUE");
								or_durn_desc		= (String)drugDetails.get("DURN_DESC")==null?"":(String)drugDetails.get("DURN_DESC");
								strength_uom		= (String)drugDetails.get("STRENGTH_UOM")==null?"":(String)drugDetails.get("STRENGTH_UOM");
							
								strength_uom_Details	=bean.getUomDisplay(facility_id,strength_uom); //created on 21/10/09
								//out.println("strength_uom_Details======151====>" +strength_uom_Details);
								dosage_type			= (String)drugDetails.get("DOSAGE_TYPE")==null?"":(String)drugDetails.get("DOSAGE_TYPE");
								//if condition  added for SKR-SCF-0561 [IN:033486] 
								if(dosage_type.equals("S")){
									or_qty_desc		= strength_uom_Details;
								}
								strength_value		= (String)drugDetails.get("STRENGTH_VALUE")==null?"":(String)drugDetails.get("STRENGTH_VALUE");
								no_refill			= (String)drugDetails.get("NO_REFILL")==null?"":(String)drugDetails.get("NO_REFILL");
								end_date			= (String)drugDetails.get("END_DATE")==null?"":(String)drugDetails.get("END_DATE");	
								repeat_durn_type	= (String)drugDetails.get("REPEAT_DURN_TYPE")==null?"":(String)drugDetails.get("REPEAT_DURN_TYPE");	
								
								freq_chng_durn_value = durn_value;
								freq_chng_durn_desc	= (String)drugDetails.get("freq_chng_durn_desc")==null?"":(String)drugDetails.get("freq_chng_durn_desc");	
								if(!freq_chng_durn_desc.equals(repeat_durn_type)){
									freq_chng_durn_value = (String)bean.getFreqDurnConvValue(repeat_durn_type,durn_value,freq_chng_durn_desc);
									repeat_durn_type = freq_chng_durn_desc;
								}
								absol_qty			= (String)drugDetails.get("ABSOL_QTY")==null?"":(String)drugDetails.get("ABSOL_QTY");
								pres_base_uom		= (String)drugDetails.get("PRES_BASE_UOM")==null?"":(String)drugDetails.get("PRES_BASE_UOM");
								prn_dose			= (String)drugDetails.get("PRN_DOSES_PRES_PRD_FILL")==null?"":(String)drugDetails.get("PRN_DOSES_PRES_PRD_FILL");
								fract_dose			= (String)drugDetails.get("FRACT_DOSE_ROUND_UP_YN")==null?"":(String)drugDetails.get("FRACT_DOSE_ROUND_UP_YN");
								act_strength_value	= (String)drugDetails.get("ACT_STRENGTH_VALUE")==null?"":(String)drugDetails.get("ACT_STRENGTH_VALUE");
								drug_tapered = drugDetails.get("DRUG_TAPERED_YN")==null?"":(String)drugDetails.get("DRUG_TAPERED_YN");
								totTapperQty	= Float.parseFloat(drugDetails.get("TOTTAPPERQTY")==null?"1":(String)drugDetails.get("TOTTAPPERQTY"));
								/*if(totalTaperQtyDisplay.equals("Y") && drug_tapered.equals("Y") && !tappered_over.equals("Y")){
									balTaperQty = totTapperQty;
								}*/
								sliding_scale_remarks="";                           
								strength_per_value_pres_uom	= (String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM")==null?"":(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");
							
								trade_name =(String)drugDetails.get("TRADE_NAME")==null?"":(String)drugDetails.get("TRADE_NAME");
								if(!trade_name.equals("")){
									trade_name="("+trade_name+")";
								}
								if(!locale.equals("en")){
									end_date =  DateUtils.convertDate(end_date, "DMYHM",locale,"en");
								}

								if(drugDetails.containsKey("SLIDING_SCALE_REMARKS")) {
									sliding_scale_remarks=(String)drugDetails.get("SLIDING_SCALE_REMARKS")==null?"":(String)drugDetails.get("SLIDING_SCALE_REMARKS");
								}
								if( "Y".equals(preview_auth_status_yn)) {
									ord_auth_reqd_yn = (String) drugDetails.get("ORD_AUTH_REQD_YN");  //added for ML-MMOH-CRF-0343 -start
									ord_authorized_yn			= (String) drugDetails.get("ORD_AUTHORIZED_YN");
									display_auth_rule = "visibility:visible";
									if(ord_auth_reqd_yn.equals("Y")){
										color_auth_rule = "color:red";
										strAuthStatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.AuthorizationReqd..label", "common_labels");
										if(ord_authorized_yn.equals("Y")){
											color_auth_rule = "color:green";
											strAuthStatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Authorized.label", "common_labels");
										}
									} 
								}//added for ML-MMOH-CRF-0343 -end
								
								route_desc=(String)drugDetails.get("ROUTE_DESC")==null?"":	(String)drugDetails.get("ROUTE_DESC"); //Code Added For ICN 29927	RUT-CRF-0034 Start 
								route_code=(String)drugDetails.get("ROUTE_CODE")==null?"":	(String)drugDetails.get("ROUTE_CODE");  
								fntColor="000000";
								ArrayList routes				=	presBean.getRoutes((String)drugDetails.get("FORM_CODE")); 
								for(int l=0; l<routes.size(); l+=3) { 
									if(route_code.equals(routes.get(l))){
										route_desc = (String)routes.get(l+1); //added for ML-BRU-SCF-0103 (incident no: 31812)
										route_color = (String)routes.get(l+2);
										break;
									}
								}
								if(route_color!= null && !route_color.equals("") && route_color.length()==12){
									fntColor= route_color.substring(0, 6);
									backgrndColor= route_color.substring(6, 12);// added for CRF RUT-CRF-0034.1[IN:037389]
								}
								/*
								if(route_desc.equals("") ){
									route_desc = (String)routes.get(2);
									fntColor = "";
								}*/
								addRouteDesc="("+route_desc+")";  	

								//Code Added For ICN 29927	RUT-CRF-0034 End
								allergy_yn=           (String)drugDetails.get("ALLERGY_OVERRIDE")==null?"":	(String)drugDetails.get("ALLERGY_OVERRIDE");  
								allergy_remarks=    (String)drugDetails.get("ALLERGY_REMARKS")==null?"":	(String)drugDetails.get("ALLERGY_REMARKS"); 

								/*allergy_remarks=allergy_remarks.replaceAll(" ","%20");
								allergy_remarks = java.net.URLEncoder.encode(allergy_remarks,"UTF-8");
								allergy_remarks=allergy_remarks.replaceAll("%2520"," ");
								allergy_remarks=allergy_remarks.replaceAll("%20"," "); Commented for the incident num:26025 ==by Sandhya on 20/Jan/2011*/

								override_yn =		  (String)drugDetails.get("CURRENTRX_OVERRIDE")==null?"":(String)drugDetails.get("CURRENTRX_OVERRIDE");
								override_reason=	  (String)drugDetails.get("CURRENTRX_REMARKS")==null?"":	(String)drugDetails.get("CURRENTRX_REMARKS");
								
								override_reason=override_reason.replaceAll(" ","%20");
								override_reason = java.net.URLEncoder.encode(override_reason,"UTF-8");
								override_reason = java.net.URLDecoder.decode(override_reason,"UTF-8");
								override_reason=override_reason.replaceAll("%2520"," ");
								override_reason=override_reason.replaceAll("%20"," ");
								
								overdose_yn =       (String)drugDetails.get("DOSE_OVERRIDE")==null?"":	 (String)drugDetails.get("DOSE_OVERRIDE");      
								overdose_remarks= (String)drugDetails.get("DOSE_REMARKS")==null?"": (String)drugDetails.get("DOSE_REMARKS");       
								overdose_remarks=overdose_remarks.replaceAll(" ","%20");
								overdose_remarks = java.net.URLEncoder.encode(overdose_remarks,"UTF-8");
								overdose_remarks=overdose_remarks.replaceAll("%2520"," ");
								overdose_remarks=overdose_remarks.replaceAll("%20"," ");

								or_durn_desc =	presBean.getDurationType(repeat_durn_type);

								PRN_remarks	=  bean.getPRNRemarks(drug_code);
								if(PRN_remarks != null){
									PRN_remarks_code = PRN_remarks.get("prn_remarks_code")==null?"":(String)PRN_remarks.get("prn_remarks_code");
									PRN_remarks_dtl = PRN_remarks.get("prn_remarks_dtl")==null?"":(String)PRN_remarks.get("prn_remarks_dtl");
								}
								freq_nature					= (String) drugDetails.get("FREQ_NATURE")==null?"":(String) drugDetails.get("FREQ_NATURE");

		/*						PRN_remarks=PRN_remarks.replaceAll(" ","%20");
								PRN_remarks=PRN_remarks.replaceAll("%2520","%20");*/
							//	PRN_remarks_dtl = java.net.URLEncoder.encode(PRN_remarks_dtl,"UTF-8");
							//	PRN_remarks_dtl = java.net.URLDecoder.decode(PRN_remarks_dtl,"UTF-8");

								dsg_reason= (String)drugDetails.get("EXT_DDB_DSG_REASON")==null?"":(String)drugDetails.get("EXT_DDB_DSG_REASON");    
								dsg_reason=dsg_reason.replaceAll(" ","%20");
								dsg_reason = java.net.URLEncoder.encode(dsg_reason,"UTF-8");
								dsg_reason=dsg_reason.replaceAll("%2520"," ");

								dup_reason= (String)drugDetails.get("EXT_DDB_DUP_REASON")==null?"":(String)drugDetails.get("EXT_DDB_DUP_REASON");      
								dup_reason=dup_reason.replaceAll(" ","%20");
								dup_reason = java.net.URLEncoder.encode(dup_reason,"UTF-8");
								dup_reason=dup_reason.replaceAll("%2520"," ");

								con_reason= (String)drugDetails.get("EXT_DDB_CON_REASON")==null?"":(String)drugDetails.get("EXT_DDB_CON_REASON");      
								con_reason=con_reason.replaceAll(" ","%20");
								con_reason = java.net.URLEncoder.encode(con_reason,"UTF-8");
								con_reason=con_reason.replaceAll("%2520","%20");

								int_reason=(String)drugDetails.get("EXT_DDB_INT_REASON")==null?"":(String)drugDetails.get("EXT_DDB_INT_REASON");
								int_reason=int_reason.replaceAll(" ","%20");
								int_reason = java.net.URLEncoder.encode(int_reason,"UTF-8");
								int_reason=int_reason.replaceAll("%2520"," ");

								alg_reason= (String)drugDetails.get("EXT_DDB_ALG_REASON")==null?"":(String)drugDetails.get("EXT_DDB_ALG_REASON");
								alg_reason=alg_reason.replaceAll(" ","%20");
								alg_reason = java.net.URLEncoder.encode(alg_reason,"UTF-8");
								alg_reason=alg_reason.replaceAll("%2520"," ");

								if(prn_dose==null || prn_dose.equals("") || prn_dose.equals("0")) {
									prn_dose	=	"1";
								}
								interaction_exists =		  (String)drugDetails.get("INTERACTION_EXISTS")==null?"":(String)drugDetails.get("INTERACTION_EXISTS");
								abuse_exists= (String)drugDetails.get("ABUSE_EXISTS")==null?"":(String)drugDetails.get("ABUSE_EXISTS");//added for aakh-crf-0140
								abuse_action= (String)drugDetails.get("ABUSE_ACTION")==null?"":(String)drugDetails.get("ABUSE_ACTION");//added for aakh-crf-0140
								abuse_remarks= (String)drugDetails.get("abuse_override_remarks")==null?"":(String)drugDetails.get("abuse_override_remarks");//added for aakh-crf-0140
								
								interaction_remarks=	  (String)drugDetails.get("INTERACTION_REMARKS")==null?"":	(String)drugDetails.get("INTERACTION_REMARKS");
								food_interaction_remarks=	  (String)drugDetails.get("FOOD_INTERACTION_REMARKS")==null?"":	(String)drugDetails.get("FOOD_INTERACTION_REMARKS"); //MMS-KH-CRF-0029 [IN070606]
								lab_interaction_remarks=	  (String)drugDetails.get("LAB_INTERACTION_REMARKS")==null?"":	(String)drugDetails.get("LAB_INTERACTION_REMARKS");//MMS-KH-CRF-0029 [IN070606]
								disease_interaction_remarks=	  (String)drugDetails.get("DISEASE_INTERACTION_REMARKS")==null?"":	(String)drugDetails.get("DISEASE_INTERACTION_REMARKS");//Added for MMS-DM-CRF-0229
								interaction_remarks=interaction_remarks.replaceAll(" ","%20");
								interaction_remarks = java.net.URLEncoder.encode(interaction_remarks,"UTF-8");
								interaction_remarks = java.net.URLDecoder.decode(interaction_remarks,"UTF-8");
								interaction_remarks=interaction_remarks.replaceAll("%2520"," ");
								interaction_remarks=interaction_remarks.replaceAll("%20"," ");
								//MMS-KH-CRF-0029 [IN070606] - start
								food_interaction_remarks=food_interaction_remarks.replaceAll(" ","%20");
								food_interaction_remarks = java.net.URLEncoder.encode(food_interaction_remarks,"UTF-8");
								food_interaction_remarks = java.net.URLDecoder.decode(food_interaction_remarks,"UTF-8");
								food_interaction_remarks=food_interaction_remarks.replaceAll("%2520"," ");
								food_interaction_remarks=food_interaction_remarks.replaceAll("%20"," ");

								lab_interaction_remarks=lab_interaction_remarks.replaceAll(" ","%20");
								lab_interaction_remarks = java.net.URLEncoder.encode(lab_interaction_remarks,"UTF-8");
								lab_interaction_remarks = java.net.URLDecoder.decode(lab_interaction_remarks,"UTF-8");
								lab_interaction_remarks=lab_interaction_remarks.replaceAll("%2520"," ");
								lab_interaction_remarks=lab_interaction_remarks.replaceAll("%20"," ");
								//MMS-KH-CRF-0029 [IN070606] - end
                                //Adding start for MMS-DM-CRF-0229
								disease_interaction_remarks=disease_interaction_remarks.replaceAll(" ","%20");
								disease_interaction_remarks = java.net.URLEncoder.encode(disease_interaction_remarks,"UTF-8");
								disease_interaction_remarks = java.net.URLDecoder.decode(disease_interaction_remarks,"UTF-8");
								disease_interaction_remarks=disease_interaction_remarks.replaceAll("%2520"," ");
								disease_interaction_remarks=disease_interaction_remarks.replaceAll("%20"," ");//Adding end MMS-DM-CRF-0229
								//Added for SKR-SCF-0647[Inc:35263]-Start
								drugindication_remarks=	(String)drugDetails.get("DRUG_INDICATION")==null?"":(String)drugDetails.get("DRUG_INDICATION");
								drugindication_remarks=drugindication_remarks.replaceAll(" ","%20");
								drugindication_remarks = java.net.URLEncoder.encode(drugindication_remarks,"UTF-8");
								drugindication_remarks = java.net.URLDecoder.decode(drugindication_remarks,"UTF-8");
								drugindication_remarks=drugindication_remarks.replaceAll("%2520"," ");
								drugindication_remarks=drugindication_remarks.replaceAll("%20"," ");//Added for SKR-SCF-0647[Inc:35263]-End
								RefillDetail= (HashMap) bean.getRefillDetail(srl_no);//Modified for IN:069886
								//RefillDetail= (HashMap) presBean.populateRefillDetail(end_date,durn_value, repeat_durn_type,no_refill);//changed from freq_chng_durn_value to  durn_value for Refil dates wrong popuilation
								if(strength_value.equals("0")) {
									strength_value		=	"";
									strength_uom		=	"";
								}

								String tooltip			= "";
								String tooltipnew			= "";//Added for IN:069886
								String last_refill_durn_value=(String)RefillDetail.get("last_refill_durn_value")==null?durn_value:(String)RefillDetail.get("last_refill_durn_value");//Added for IN:069886
								float durn_conv_fact=Float.parseFloat(last_refill_durn_value)/Float.parseFloat(durn_value);//Added for IN:069886
								String freq_str			= "";
								String pres_remarks		= "";
								ArrayList schedule		=	null;
								Hashtable template		=	null;
								ArrayList seq_num		=	(ArrayList)orderEntryRecordBean.getOrderFormats((drug_code+srl_no),(drug_code+srl_no)+"_0");
								
								if(seq_num==null)
									seq_num			=	new ArrayList();

								for(int p=0; p<seq_num.size(); p++) {
									template	=	(Hashtable)orderEntryRecordBean.getOrderFormats((drug_code+srl_no),((drug_code+srl_no)+((Integer.parseInt((String)seq_num.get(p))) ) ));
									if(template.get("field_values")!=null && !(((String)template.get("field_values")).trim()).equals("")){
				
										if(((String) template.get("field_mnemonic")).equals("PRES_REMARKS")) {
											pres_remarks =pres_remarks +"<br>"+template.get("label_text")+": "+ presBean.getPrescriptionRemarks((String) template.get("field_values"));
										} 
										else {
											pres_remarks =pres_remarks + "<br>"+template.get("label_text")+": "+ (String) template.get("field_values") ;
										} 
									}
								}
								schedule	=	(ArrayList)bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
								boolean split_chk	=	bean.checkSplit(schedule);
								if(((String)drugDetails.get("SLIDING_SCALE_YN")).equals("Y")) 
									freq_str = (String)bean.getTooltipStringFrFreq(schedule,"SSprvwString"+or_qty_desc);
								else
									freq_str = (String)bean.getTooltipStringFrFreq(schedule,"prvwString"+or_qty_desc);

								if(schedule != null && schedule.size()>0)
									dose_list	= (ArrayList)schedule.get(4);						
								else
									dose_list = null;
								if(split_chk && dose_list!=null){//Code added for IN22425 to get SPLIT_DOSE qty value on clicking release without confirm --01/06/2010-- priya
									float temp_qty_value = 0;
									for(int m = 0;m<dose_list.size();m++){
										temp_qty_value+= Float.parseFloat((String)dose_list.get(m));
									}
									qty_value = temp_qty_value+"";
								}
								/*HashMap freq_char_list	 = new HashMap();
								ArrayList day_list	= new ArrayList();
								ArrayList day_names	= new ArrayList();
								ArrayList time_list	= new ArrayList();
								ArrayList dose_list	= new ArrayList();


								if(schedule != null && schedule.size()>0){
									freq_char_list	= (HashMap)schedule.get(0);
									day_list	= (ArrayList)schedule.get(1);
									day_names	= (ArrayList)schedule.get(2);
									time_list	= (ArrayList)schedule.get(3);
									dose_list	= (ArrayList)schedule.get(4);						

									for(int frStr = 0;frStr<day_list.size();frStr++){
										if(!freq_char_list.get("durationType").equals("D")){
											freq_str = freq_str + "Day "+day_list.get(frStr);
											freq_str = freq_str + " - ";
											freq_str = freq_str + day_names.get(frStr);
											freq_str = freq_str + " - ";
										}
										freq_str = freq_str + time_list.get(frStr);
										freq_str = freq_str + " - ";
										freq_str = freq_str + dose_list.get(frStr);
										freq_str = freq_str + " "+or_qty_desc;
										freq_str = freq_str + "; ";
									}
								}*/
								/* for(int n=0; n<schedule.size(); n++) {

									
									HashMap detail	=	(HashMap)schedule.get(n);
									
									if(drugDetails.get("SLDSCALE_TMPL_DTL") != null && ((ArrayList)drugDetails.get("SLDSCALE_TMPL_DTL")).size()>0){
										//sliding scale 
										freq_str = freq_str + detail.get("admin_time")+"";
									}
									else{
										freq_str = freq_str + detail.get("admin_time")+"-";
										freq_str = freq_str + detail.get("admin_qty")+" "+or_qty_desc;
									}
									if(n==(schedule.size()-1))
										freq_str = freq_str + " ";
									else
										freq_str = freq_str + ", ";
									
								}	*/	
		
								if(!(qty_value.equals(""))){//added for IN26567 --16/02/2011-- priya
									if(qty_value.indexOf(".")== 0)
										qty_value = "0"+qty_value;
								}
								
								if(((String)drugDetails.get("SLIDING_SCALE_YN")).equals("Y")) {
									qty_value = "";
									or_qty_desc = "";
								}
								//Added forAAKH-CRF-0091 starts
								if(stat_yn.equals("Y")){
									ArrayList stat_freqs	=	presBean.loadStatFreqs();
									
									for(int m=0;m<stat_freqs.size();m+=2){
										freq_desc	   = ((String) stat_freqs.get(m+1));
										freq_code      = ((String) stat_freqs.get(m));
										
									}
									drugDetails.put("FREQ_CODE",freq_code);
									drugDetails.put("FREQ_DESC",freq_desc);
									
									drugDetails.put("FREQ_NATURE","O");
									tooltip	=tooltip+ " - "+qty_value+" "+or_qty_desc+" " +freq_desc+"  "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.for.label", "common_labels")+" "+durn_value+" "+or_durn_desc;
									tooltipnew	=tooltipnew+ " - "+qty_value+" "+or_qty_desc+" " +freq_desc+"  "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.for.label", "common_labels")+" "+last_refill_durn_value+" "+or_durn_desc;//Added for IN:069886
								}
									//Added forAAKH-CRF-0091 ends
								if(dosage_type.equals("A"))
									tooltip			= "  "+qty_value+" "+or_qty_desc+" "+freq_desc+" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.for.label", "common_labels")+" "+durn_value+" "+or_durn_desc;
								else if(schedule.size() > 0 && split_chk) {
									tooltip			= "  "+qty_value+" "+or_qty_desc+" <label style='color:red' >("+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Divided.label", "ph_labels")+")</label> "+" "+freq_desc+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.for.label", "common_labels")+" "+durn_value+" "+or_durn_desc;
								} 
								else if(schedule.size() > 0) {
									tooltip			= "  "+qty_value+" "+or_qty_desc+" "+freq_desc+" <label style='color:red'></label> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.for.label", "common_labels")+" "+durn_value+" "+or_durn_desc;
								} 
								else {
									tooltip			= "  "+qty_value+" "+or_qty_desc+" "+freq_desc+"  "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.for.label", "common_labels")+" "+durn_value+" "+or_durn_desc;
								}
								//Added for IN:069886 start	
								if(dosage_type.equals("A"))
									tooltipnew			= "  "+qty_value+" "+or_qty_desc+" "+freq_desc+" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.for.label", "common_labels")+" "+last_refill_durn_value+" "+or_durn_desc;
								else if(schedule.size() > 0 && split_chk) {
									tooltipnew			= "  "+qty_value+" "+or_qty_desc+" <label style='color:red' >("+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Divided.label", "ph_labels")+")</label> "+" "+freq_desc+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.for.label", "common_labels")+" "+last_refill_durn_value+" "+or_durn_desc;
								} 
								else if(schedule.size() > 0) {
									tooltipnew			= "  "+qty_value+" "+or_qty_desc+" "+freq_desc+" <label style='color:red'></label> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.for.label", "common_labels")+" "+last_refill_durn_value+" "+or_durn_desc;
								} 
								else {
									tooltipnew			= "  "+qty_value+" "+or_qty_desc+" "+freq_desc+"  "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.for.label", "common_labels")+" "+last_refill_durn_value+" "+or_durn_desc;
								}
                                                               //Added for IN:069886 end
								// calculate the dosage qty
								String sch_size			=	"1";
								String conv_factor		=	"";
								float tot_qty_value     =   0; 
							
								// && !(freq_nature.equals("O")) condition added for IN22799 --21/07/2010-- priya
								if(dose_list != null && dose_list.size() > 0 && (split_dose_yn.equals("N")) && !(freq_nature.equals("O"))) {
		//							HashMap detail	=	(HashMap)schedule.get(0);
									if(fract_dose.equals("N")){
										if( !(freq_nature.equals("I")))
										//qty_value		=	(String)detail.get("admin_qty");
											 qty_value		=	(String)dose_list.get(0);
									}
									else{
										if(dosage_type.equals("S") && !(freq_nature.equals("I")) ){  //  !(freq_nature.equals("I") added on 30/07/2010-- priya
		//									qty_value		=	(String)detail.get("admin_qty");
											// qty_value        =   (Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(act_strength_value)))+"";
											qty_value		=	(String)dose_list.get(0);
											//qty_value		=   (Math.ceil((Float.parseFloat(qty_value))/(Float.parseFloat(strength_per_value_pres_uom))))*(Float.parseFloat(strength_per_value_pres_uom))+"";

										}
										else if(dosage_type.equals("Q") && !(freq_nature.equals("I"))){ //  !(freq_nature.equals("I") added on 30/07/2010-- priya
		//									qty_value		=	(String)detail.get("admin_qty");
											qty_value		=	(String)dose_list.get(0);
											//qty_value		=   (Math.ceil(Float.parseFloat(qty_value)))+""; // Commented for IN23884 and below line added

		//ADDED BY NAVEEN FOR iNCIDENT IN23884  ON 29NOV2010
											qty_value		=  Float.parseFloat(qty_value)+""; //added for IN25425 --09/12/2010-- priya
								//			qty_value		=   (Math.ceil((Float.parseFloat(qty_value))/(Float.parseFloat(strength_per_value_pres_uom))))*(Float.parseFloat(strength_per_value_pres_uom))+""; //Commented for IN25425 --09/12/2010-- priya
										}  
										// qty_value        =   (Math.ceil(Float.parseFloat(qty_value)*schedule.size()))+"";
									 }
		//							 sch_size		=	""+schedule.size();
									
									 sch_size		=	""+dose_list.size();

									 if(freq_nature.equals("I")) // added on 30/07/2010-- priya
										sch_size = "1";
								} 
								else {
									if(split_dose_yn.equals("Y")){
										if(fract_dose.equals("N")){
											for(int tqI=0;tqI<dose_list.size();tqI++){
												sch_size		=	"1";
												tot_qty_value=tot_qty_value+Float.parseFloat((String)dose_list.get(tqI));
											}
											/*for(int n=0; n<schedule.size(); n++) {
											  sch_size		=	"1";
											  HashMap  detail	=  (HashMap)schedule.get(n);
											  tot_qty_value    =  tot_qty_value+Float.parseFloat((String)detail.get("admin_qty"));
											}*/
										}
										else{
											if(dose_list != null){
												for(int n=0; n<dose_list.size(); n++) {
													sch_size		=	"1";
													//HashMap  detail	=  (HashMap)schedule.get(n);
													if(dosage_type.equals("S")){
														//qty_value		=	(String)detail.get("admin_qty");
														qty_value		=	(String)dose_list.get(n);
														qty_value        =   (Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(act_strength_value)))+"";
														qty_value		=	Float.parseFloat(qty_value) * Float.parseFloat(act_strength_value)+"";
													}
													else if(dosage_type.equals("Q")){
														//qty_value		=	(String)detail.get("admin_qty");
														qty_value		=	(String)dose_list.get(n);
														qty_value		=   (Math.ceil(Float.parseFloat(qty_value)))+"";
													}  
													if(qty_value!=null && !(qty_value.equals("")))
														tot_qty_value    =  tot_qty_value+Float.parseFloat(qty_value);
												}
											}
										}
										qty_value       =tot_qty_value+"";
									}
								}
								/*if(schedule.size() > 0 && (split_dose_yn.equals("N"))) {
									HashMap detail	=	(HashMap)schedule.get(0);
									if(fract_dose.equals("N")){
										qty_value		=	(String)detail.get("admin_qty");

									}
									else{
										if(dosage_type.equals("S")){
											qty_value		=	(String)detail.get("admin_qty");
											// qty_value        =   (Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(act_strength_value)))+"";
										}
										else if(dosage_type.equals("Q")){
											qty_value		=	(String)detail.get("admin_qty");
											qty_value		=   (Math.ceil(Float.parseFloat(qty_value)))+"";
										}  
										// qty_value        =   (Math.ceil(Float.parseFloat(qty_value)*schedule.size()))+"";
									 }

									 sch_size		=	""+schedule.size();
									
								} 
								else {
									if(split_dose_yn.equals("Y")){
										if(fract_dose.equals("N")){
											for(int n=0; n<schedule.size(); n++) {
											  sch_size		=	"1";
											  HashMap  detail	=  (HashMap)schedule.get(n);
											  tot_qty_value    =  tot_qty_value+Float.parseFloat((String)detail.get("admin_qty"));
											}
										}
										else{
											for(int n=0; n<schedule.size(); n++) {
												sch_size		=	"1";
												HashMap  detail	=  (HashMap)schedule.get(n);
												if(dosage_type.equals("S")){
													qty_value		=	(String)detail.get("admin_qty");
													qty_value        =   (Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(act_strength_value)))+"";
													qty_value		=	Float.parseFloat(qty_value) * Float.parseFloat(act_strength_value)+"";
												}
												else if(dosage_type.equals("Q")){
													qty_value		=	(String)detail.get("admin_qty");
													qty_value		=   (Math.ceil(Float.parseFloat(qty_value)))+"";
												}  
												tot_qty_value    =  tot_qty_value+Float.parseFloat(qty_value);
											}
										}

										qty_value       =tot_qty_value+"";
									}
								}*/

								if(freq_nature.equals("P") && (absol_qty==null || absol_qty.equals(""))) { //hanga
									absol_qty		=	prn_dose;	
								}

								if(absol_qty==null || absol_qty.equals("0"))
									absol_qty		=	"1";

								if(dosage_type.equals("A") || freq_nature.equals("P")) {
									qty_value		=	absol_qty;
									dosage_type		=	"A";
								}
								if(dosage_type.equals("Q"))
									conv_factor = (String) bean.getConvFactor(qty_desc,pres_base_uom);
								String order_qty = "";
								boolean override_flag=false; //MMS-KH-CRF-0029
								if(!dosage_type.equals("A") && !freq_nature.equals("P")){ //added && !freq_nature.equals("P") for IN26267 --02/02/2011-- priya
									if(totalTaperQtyDisplay.equals("Y") && (drug_tapered.equals("Y") || tappered_over.equals("Y"))){ //if block added for [IN:037436]
										if(drugDetails.get("TAP_LVL_QTY")!=null && !((String)drugDetails.get("TAP_LVL_QTY")).equals(""))
											order_qty	= (String)drugDetails.get("TAP_LVL_QTY");
										else
											order_qty	=	bean.getOrderQty(drugDetails,qty_value,sch_size,freq_chng_durn_value,"",dosage_type,conv_factor,split_chk);
									}
									else{

										order_qty	=	bean.getOrderQty(drugDetails,qty_value,sch_size,freq_chng_durn_value,"",dosage_type,conv_factor,split_chk);

									}
								}
								else{
									if(totalTaperQtyDisplay.equals("Y") && (drug_tapered.equals("Y") || tappered_over.equals("Y"))){ 
										if(drugDetails.get("TAP_LVL_QTY")!=null && !((String)drugDetails.get("TAP_LVL_QTY")).equals(""))
											order_qty	= (String)drugDetails.get("TAP_LVL_QTY");
										else
											order_qty = qty_value;
									}
									else
										order_qty = qty_value;
								}
								if(order_qty != null && (!order_qty.equals("")))
									order_qty			=	new Float(Math.ceil(Float.parseFloat(order_qty))).intValue()+"";
								order_uom	=	presBean.getOrderUnit(dosage_type,order_qty,drug_code);
								/*if(totalTaperQtyDisplay.equals("Y") && totTapperQty>0 && (tappered_over.equals("Y")|| drug_tapered.equals("Y"))){
									if(balTaperQty< Float.parseFloat(order_qty))
										order_qty = balTaperQty+"";
									balTaperQty -= Float.parseFloat(order_qty);
								}*/
								if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y") &&pat_brought_medn.equals("N") && billable_item_yn.equals("Y")){ 
									if(totalTaperQtyDisplay.equals("Y") && (tappered_over.equals("Y") || drug_tapered.equals("Y"))){ // || drug_tapered.equals("Y") added for RUT-SCF-0154 [IN:033594] && RUT-SCF-0155 [IN:033595]
										overriden_action_reason	= (String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_CODE")==null?"":(String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_CODE");
										override_excl_incl_ind		= (String)drugDetails.get("BL_DEF_OVERRIDE_EXCL_INCL_IND")==null?"":(String)drugDetails.get("BL_DEF_OVERRIDE_EXCL_INCL_IND"); 
										hmBLDtlforPreview = bean.getBillingDetailforPrev((String)drugDetails.get("ITEM_CODE"), order_qty,patient_id,encounter_id,episode_type, order_Date, take_home_medication, override_excl_incl_ind, overriden_action_reason, facility_id);
										tot_payable = (String)hmBLDtlforPreview.get("BL_TOTAL_CHARGE_AMT")==null?"0.0":(String)hmBLDtlforPreview.get("BL_TOTAL_CHARGE_AMT");
										pat_payable = (String)hmBLDtlforPreview.get("BL_PATIENT_PAYABLE_AMT")==null?"0.0":(String)hmBLDtlforPreview.get("BL_PATIENT_PAYABLE_AMT");
										tot_payable_tapper = (String)drugDetails.get("BL_TOTAL_CHARGE_AMT")==null?"0.0":(String)drugDetails.get("BL_TOTAL_CHARGE_AMT");
										pat_payable_tapper = (String)drugDetails.get("BL_PATIENT_PAYABLE_AMT")==null?"0.0":(String)drugDetails.get("BL_PATIENT_PAYABLE_AMT");
										if(!drug_tapered.equals("Y")){
											if(!tot_payable_tapper.equals(""))
												tot_payable_sum += Float.parseFloat(tot_payable_tapper);
											if(!pat_payable_tapper.equals(""))
												pat_payable_sum += Float.parseFloat(pat_payable_tapper);
										}
									}
									else{
										tot_payable = (String)drugDetails.get("BL_TOTAL_CHARGE_AMT")==null?"0.0":(String)drugDetails.get("BL_TOTAL_CHARGE_AMT");
										pat_payable = (String)drugDetails.get("BL_PATIENT_PAYABLE_AMT")==null?"0.0":(String)drugDetails.get("BL_PATIENT_PAYABLE_AMT");
										if(!tot_payable.equals(""))
											tot_payable_sum += Float.parseFloat(tot_payable);
										if(!pat_payable.equals(""))
											pat_payable_sum += Float.parseFloat(pat_payable);
									}
									decimalFormatString = (String)drugDetails.get("BL_DECIMAL_FORMAT_STRING")==null?"##.00":(String)drugDetails.get("BL_DECIMAL_FORMAT_STRING");
									//if((totalTaperQtyDisplay.equals("Y") && drug_tapered.equals("Y")&& !tappered_over.equals("Y"))|| totalTaperQtyDisplay.equals("N") || !drug_tapered.equals("Y") ){
									//if((totalTaperQtyDisplay.equals("Y") && !drug_tapered.equals("Y") && tappered_over.equals("Y") )|| !totalTaperQtyDisplay.equals("Y") || !drug_tapered.equals("Y")) { // commented new

							/*			if(tot_payable!=null && (!tot_payable.equals("")))
											tot_payable_sum += Float.parseFloat(tot_payable);
										if(pat_payable!=null && (!pat_payable.equals("")))
											pat_payable_sum += Float.parseFloat(pat_payable);*/
									//}
								}
								else{
									if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y"))
										decimalFormatString = (String)drugDetails.get("BL_DECIMAL_FORMAT_STRING")==null?"##.00":(String)drugDetails.get("BL_DECIMAL_FORMAT_STRING");
								}
								if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
									if(pat_brought_medn.equals("Y")){
										tot_payable = "--";
										pat_payable = "--";
									}
									if(billable_item_yn.equals("N")){
										tot_payable = "--";
										pat_payable = "--";
									}
								}
								else{
									tot_payable = "";
									pat_payable = "";
								}
								/*if(pat_brought_medn.equals("Y"))  //added for IN21314 --10/06/2010-- priya
											{
												tot_payable = "--";
												pat_payable = "--";
											}*/
		//tappered_over.equals("N") condition added for IN20154 --25/03/2010-- priya
								if(j==0 || tappered_over.equals("N")) {	// !taper_yn.equals("Y") || This condition removed on 02/06/2010 -- priya		
%>
									<tr>
<%
										if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")&&(i==0)&&(j==0)){
%>
											<td class="data" colspan="4" ><fmt:message key="ePH.CurrentRx.label" bundle="${ph_labels}"/></td>
											<td colspan='2' class='Data' nowrap width='16%' align='right'><fmt:message key="eBL.PAYABLE_AMT.label" bundle="${bl_labels}"/></td>
											<td colspan='3' class=label>&nbsp;</td>
<%
										}
										else{
%>
											<td class="data" colspan="9" ><fmt:message key="ePH.CurrentRx.label" bundle="${ph_labels}"/></td>
<%
										}
%>
									</tr>
									<tr>
<%
									if(strength_value!=null && !strength_value.equals("") && Float.parseFloat(strength_value) <1)
										strength_value = Float.parseFloat(strength_value) +""+route_desc;
		//out.println("strength_uom_Details=====592=====>" +strength_uom_Details);
%>
									<td width="5%" class=label>&nbsp;</td>
									<!-- Modified for TFS id:7345 START -->
									<%if(pre_alloc_appl_yn.equals("Y") && ((String)drugDetails.get("DRUG_SEARCH_BY")).equals("G")){ %>
									<td class="data" WRAP colspan="2"  width="42%"><%=(String)drugDetails.get("DRUG_DESC_NEW")%>&nbsp;<label class="label" style="font-size:xx-small;font-weight:normal"><%=trade_name%>&nbsp;<%=strength_value%>&nbsp;<%=strength_uom_Details%> &nbsp;<%=drugDetails.get("FORM_DESC")%>&nbsp;</label><!-- Changed drugDetails.get("FORM_CODE") to drugDetails.get("FORM_DESC") for IN:033174 -->
									</td>
									<%}else{ %>
									<td class="data" WRAP colspan="2"  width="42%"><%=(String)drugDetails.get("DRUG_DESC")%>&nbsp;<label class="label" style="font-size:xx-small;font-weight:normal"><%=trade_name%>&nbsp;<%=strength_value%>&nbsp;<%=strength_uom_Details%> &nbsp;<%=drugDetails.get("FORM_DESC")%>&nbsp;</label><!-- Changed drugDetails.get("FORM_CODE") to drugDetails.get("FORM_DESC") for IN:033174 -->
									</td>
									<%} %>
									<!-- Modified for TFS id:7345 END -->
									<td class="data" wrap width="10%">&nbsp;<fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
<%
									if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){//&&(i==0)&&(j==0)){
%>
										<td class='Data' align='right'><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;</td>
										<td class='Data' align='right'><fmt:message key="Common.patient.label" bundle="${common_labels}"/>&nbsp;</td>
<%
									}
%>
									<td class="data" nowrap  width="15%">&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
									<td class="data" nowrap  width="15%">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
									<td class="data" style='<%=display_auth_rule%>;'>&nbsp;&nbsp;<fmt:message key="Common.status.label" bundle="${common_labels}"/></td> <!-- Added for ML-MMOH-CRF-0343 -->
									</tr>
									<tr>
										<td width="5%" class=label>&nbsp;</td>										
										<td class="label" wrap colspan="2"><%=tooltip%>&nbsp;<font style='color:<%=fntColor%>;background-color:<%=backgrndColor%>;'><%=addRouteDesc%></font></td><!-- addRouteDesc Added For ICN 29927	RUT-CRF-0034  Start -->
										<td class="label" nowrap><%=order_qty%>&nbsp;<%=order_uom%></td><!--changed order_uom to  bean.getUomDisplay(facility_id,(String)drugDetails.get("FORM_CODE")) for ML-BRU-SCF-0103 (String)drugDetails.get("FORM_CODE")-->
<%
										//if(totalTaperQtyDisplay.equals("Y") && (tappered_over.equals("Y") || drug_tapered.equals("Y"))){
%>
										<!--	<td class='label' style='TEXT-ALIGN:right;'>--</td>
											<td class='label' style='TEXT-ALIGN:right;'>--</td> -->
<%
										//}
										//else{
										if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
%>
											<td class='label' style='TEXT-ALIGN:right;'><%=tot_payable%></td>
											<td class='label' style='TEXT-ALIGN:right;padding-right: 10px;'><%=pat_payable%></td>
<%
										}
%>
										<td class="label" nowrap style='padding-left: 10px;'><%=(String)drugDetails.get("START_DATE")%></td>
										<td class="label" nowrap style='padding-left: 10px;'><%=(String)drugDetails.get("END_DATE")%></td>								
										<td class="label" align='center' style='<%=display_auth_rule%>;'> <!-- added for ML-MMOH-CRF-0343 -->
										<label id='lbl_authorize' style='<%=display_auth_rule%>;<%=color_auth_rule%>'><%=strAuthStatus%></label>
										</td>
									</tr>
<%
									if(!freq_str.equals("")) { 
%>
										<tr>
											<td width="5%" class=label>&nbsp;</td>
											<td colspan="8" class="label"><%=freq_str%></td>	
										</tr>
<%
									}	
									if(!pres_remarks.equals("")) {
%>
										<tr>	
											<td width="5%" class=label>&nbsp;</td>
											<td width='17%' class=label valign='TOP'><b><fmt:message key="ePH.DrugRemarks.label" bundle="${ph_labels}"/>: </b></td>
											<td colspan="7" class="label"><%=pres_remarks%></td>	
										</tr>
<%
									}		
									if(!PRN_remarks_dtl.equals("")&&(freq_nature.equals("P"))){
%>
										<tr>	
											<td width="5%" class=label>&nbsp;</td>
											<td width='17%' class=label ><b><fmt:message key="ePH.PRNRemarks.label" bundle="${ph_labels}"/>: </b></td>
											<td class=label colspan='7'  id='prn_remarks<%=j%>'> <%=PRN_remarks_dtl%></td>
										</tr>
										
<%							
									}
									//Added for SKR-SCF-0647[Inc:35263]-Start
									if(!drugindication_remarks.equals("")) {
%>
										<tr>	
											<td width="5%" class=label>&nbsp;</td>
											<td width='17%' class=label ><b><fmt:message key="ePH.DrugIndications.label" bundle="${ph_labels}"/>: </b></td>
											<td class=label colspan='7'  id='drugindication_remarks<%=j%>'> <%=drugindication_remarks%></td>
										</tr>
<%									
									}//Added for SKR-SCF-0647[Inc:35263]-End
									if(((String)drugDetails.get("SLIDING_SCALE_YN")).equals("Y") && !sliding_scale_remarks.equals("") ){//SLIDING_SCALE_YN condition added for ARYU-SCF-0053
										if((sliding_scale_remarks.charAt(sliding_scale_remarks.length()-2))==('.'))
											sliding_scale_remarks = sliding_scale_remarks.substring(0,sliding_scale_remarks.length()-2);
%>
										<tr>	
											<td width="5%" class=label>&nbsp;</td>
											<td width='19%' class=label valign='TOP'><b><fmt:message key="ePH.SlidingScaleRemarks.label" bundle="${ph_labels}"/>: </b></td>
											<td class=label colspan='7' >&nbsp;<%=sliding_scale_remarks%></td>
										</tr>
<%			
									}	
									if(((String)drugDetails.get("SLIDING_SCALE_YN")).equals("Y")){
										ArrayList slidingScaleTmplDtl = (ArrayList)drugDetails.get("SLDSCALE_TMPL_DTL") == null ? new ArrayList() : (ArrayList)drugDetails.get("SLDSCALE_TMPL_DTL");
										int noOfRangeForTmpl = slidingScaleTmplDtl.size();
										if(noOfRangeForTmpl > 0){
%>								
											<tr><TD colspan='9' width='100%'><table  width='100%'>
											<tr>
												<th > <fmt:message key="Common.from.label" bundle="${common_labels}"/> </th>
												<th > <fmt:message key="Common.to.label" bundle="${common_labels}"/> </th>
												<th > <fmt:message key="Common.uom.label" bundle="${common_labels}"/>  </th>
												<th > <fmt:message key="ePH.AdminUnits.label" bundle="${ph_labels}"/> </th>
												<th > <fmt:message key="Common.uom.label" bundle="${common_labels}"/> </th>
												<th > <fmt:message key="Common.remarks.label" bundle="${common_labels}"/> </th>
											</tr>
<%
											for(int m=0; m<noOfRangeForTmpl; m=m+5){
%>
												<tr>
													<td class="data"   width="15%">&nbsp;&nbsp;<%=slidingScaleTmplDtl.get(m+1)%></td> 
													<td class="data"   width="15%">&nbsp;&nbsp;<%=slidingScaleTmplDtl.get(m+2)%></td> 
													<td class="data"   width="15%">&nbsp;&nbsp;<%=(String)drugDetails.get("RANGEUOM")%></td> 
													<td class="data"   width="15%">&nbsp;&nbsp;<%=slidingScaleTmplDtl.get(m+3)%></td> 
													<td class="data"   width="15%">&nbsp;&nbsp;<%=(String)drugDetails.get("ADMINUOM")%></td> 
													<td class="data"   width="25%">&nbsp;&nbsp;<%=java.net.URLDecoder.decode((String)slidingScaleTmplDtl.get(m+4),"UTF-8")%></td> 
												</tr>
<%
											} 
%>								
											</table></TD></tr>
<%								
										}
									}
									if(!(dsg_reason==null && dup_reason==null && con_reason==null && int_reason==null && alg_reason==null) && !(dsg_reason.equals("") && dup_reason.equals("") && con_reason.equals("") && int_reason.equals("") && alg_reason.equals(""))){
										if(!dsg_reason.equals("")){
%>
											<tr>	
												<td width="5%" class=label>&nbsp;</td>
												<td class=label width="15%" valign='TOP'><b><fmt:message key="ePH.DrugDosageOverrideReason.label" bundle="${ph_labels}"/>: </b></td>
												<td class=label colspan='7'  id='dsg_reason<%=i%><%=j%>'></td>
											</tr>
											<script>
												var dsg_reason = decodeURIComponent('<%=dsg_reason%>');
												eval("document.getElementById("dsg_reason"+'<%=i%><%=j%>')).innerText= dsg_reason ;
											</script>
<%
										}
										if(!dup_reason.equals("")){
%>
											<tr>	
												<td width="5%" class=label>&nbsp;</td>
												<td class=label width="15%" valign='TOP'><b><fmt:message key="ePH.DuplicateTheraphyOverrideReason.label" bundle="${ph_labels}"/>: </b></td>
												<td class=label colspan='7'  id='dup_reason<%=i%><%=j%>'></td>
											</tr>
											<script>
												var dup_reason = decodeURIComponent('<%=dup_reason%>');
												eval(document.getElementById("dup_reason"+'<%=i%><%=j%>')).innerText= dup_reason ;
											</script>
<%
										}
										if(!con_reason.equals("")){
%>
											<tr>	
												<td width="5%" class=label>&nbsp;</td>
												<td class=label width="15%" valign='TOP'><b><fmt:message key="ePH.ContraIndicationOverrideReason.label" bundle="${ph_labels}"/>: </b></td>
												<td class=label colspan='7'  id='con_reason<%=i%><%=j%>'></td>
											</tr>
											<script>
												var con_reason = decodeURIComponent('<%=con_reason%>');
												eval(document.getElementById("con_reason"+'<%=i%><%=j%>')).innerText= con_reason ;
											</script>

<%
										}
										if( !int_reason.equals("") ){
%>
											<tr>	
												<td width="5%" class=label>&nbsp;</td>
												<td class=label width="15%" valign='TOP'><b><fmt:message key="ePH.DrugInteractionOverrideReason.label" bundle="${ph_labels}"/>: </b></td>
												<td class=label colspan='7'  id='int_reason<%=i%><%=j%>'></td>
											</tr>
											<script>
												var int_reason = decodeURIComponent('<%=int_reason%>');
												eval(document.getElementById("int_reason"+'<%=i%><%=j%>')).innerText= int_reason ;
											</script>
<%
										}
										if(!alg_reason.equals("")){
%>
											<tr>	
												<td width="5%" class=label>&nbsp;</td>
												<td class=label width="15%" valign='TOP'><b><fmt:message key="Common.AllergyOverrideReason.label" bundle="${common_labels}"/>: </b></td>
												<td class=label colspan='7'  id='alg_reason<%=i%><%=j%>'></td>
											</tr>
											<script>
												var alg_reason = decodeURIComponent('<%=alg_reason%>');
												eval(document.getElementById("alg_reason"+'<%=i%><%=j%>')).innerText= alg_reason ;
											</script>
<%
										}
									}
		//							else{ 
										//MMS-KH-CRF-0029 [IN070606] - start	//abuse_exists added for aakh-crf-0140
										if((override_yn.equals("Y") && !override_reason.equals("") && ((String)drugDetails.get("CURRENT_RX")).equals("Y")) || (allergy_yn.equals("Y") && !allergy_remarks.equals("") && ((String)drugDetails.get("ALLERGY_YN")).equals("Y")) || (overdose_yn.equals("Y") && !overdose_remarks.equals("") && ((String)drugDetails.get("LIMIT_IND")).equals("N")) || ((interaction_exists.equals("Y") && !interaction_remarks.equals("")||(abuse_exists.equals("Y") && abuse_action.equals("B"))) || !food_interaction_remarks.equals("") || !lab_interaction_remarks.equals("") || !disease_interaction_remarks.equals(""))) //modified for MMS-KH-CRF-0029
										{   
											override_flag = true; //MMS-KH-CRF-0029
											System.err.println("PrescriptionPreviewOrderDrugDetails.jsp===943====>");
%>
											<tr>	
												<td width="5%" class=label>&nbsp;</td>
												<td class=label width="17%" valign='TOP'><U><b><fmt:message key="ePH.OverrideReason.label" bundle="${ph_labels}"/></b></U></td>

											</tr> <!-- Removed <br> for IN073481 -->
<%										} //MMS-KH-CRF-0029 [IN070606] - end


										if(override_yn.equals("Y") && !override_reason.equals("") && ((String)drugDetails.get("CURRENT_RX")).equals("Y")){
											
%>
											<tr>	
												<td width="5%" class=label>&nbsp;</td>
												<td class=label width="17%" valign='TOP'><b><fmt:message key="ePH.DuplicateRemarks.label" bundle="${ph_labels}"/>:</b></td> <!-- modified for MMS-KH-CRF-0029[IN070606]-->
												<td class=label colspan='7'  id='override_reason<%=j%>'><%=override_reason%></td>
											</tr>
											<!-- <script>
												var override_reason = decodeURIComponent('<%=override_reason%>');
												//document.getElementById("prn_remarks").innerText=document.getElementById("prn_remarks").innerText+prn_rem;

												eval("document.getElementById("override_reason")"+'<%=j%>').innerText= override_reason ;
												alert(eval("document.getElementById("override_reason")"+'<%=j%>').innerText);
											</script> -->
<%
										}

										if(allergy_yn.equals("Y") && !allergy_remarks.equals("") && ((String)drugDetails.get("ALLERGY_YN")).equals("Y")){
%>
											<tr>	
												<td width="5%" class=label>&nbsp;</td>
												<td class=label width="17%" valign='TOP'><b><fmt:message key="ePH.AllergyRemarks.label" bundle="${ph_labels}"/>:</b></td>
												<td class=label colspan='7'  id='allergy_remarks<%=j%>'><%=allergy_remarks%></td>
											</tr>
											<!-- <script>
												var allergy_remarks = decodeURIComponent('<%=allergy_remarks%>');
												//document.getElementById("prn_remarks").innerText=document.getElementById("prn_remarks").innerText+prn_rem;
												eval("document.getElementById("allergy_remarks")"+'<%=j%>').innerText= allergy_remarks ;
											</script> -->
<%					
										}
										if(overdose_yn.equals("Y") && !overdose_remarks.equals("") && ((String)drugDetails.get("LIMIT_IND")).equals("N")){
%>
											<tr>	
												<td width="5%" class=label>&nbsp;</td>
												<td class=label width="17%" valign='TOP'><b><fmt:message key="ePH.OverDoseRemarks.label" bundle="${ph_labels}"/>:</b></td>
												<td class=label colspan='7'  id='overdose_remarks<%=j%>'><%=overdose_remarks%></td>
											</tr>
											<!-- <script>
												var overdose_remarks = decodeURIComponent('<%=overdose_remarks%>');
												//document.getElementById("prn_remarks").innerText=document.getElementById("prn_remarks").innerText+prn_rem;
												eval("document.getElementById("overdose_remarks")"+'<%=j%>').innerText= overdose_remarks ;
											</script> -->
<%		
										}
										//MMS-KH-CRF-0029 [IN070606] - start
										ArrayList hmDrugIntList=(ArrayList) drugDetails.get("INTERACTION_DTL");
										String interaction_desc = "";
										String interaction_type = "";
										ArrayList intrType = new ArrayList();
										HashMap DrugInteractionDtl=  null;
										if(hmDrugIntList!=null && hmDrugIntList.size()> 0){
											for(int count=0 ; count<(hmDrugIntList.size()-2) ; count++){
												DrugInteractionDtl =(HashMap) hmDrugIntList.get(count);
											  interaction_desc = (String)DrugInteractionDtl.get("interaction_desc");
											  interaction_type = (String)DrugInteractionDtl.get("INTR_TYPE2");
												intrType.add(interaction_type);
											}
										}
										String drug_drug_display = "none";
										String drug_food_display = "none";
										String drug_lab_display = "none";
										String drug_disease_display = "none";//MMS-DM-CRF-0229
										String drug_food_remarks ="";
										String drug_lab_remarks ="";
										String drug_disease_remarks ="";//MMS-DM-CRF-0229

										if(intrType!=null && intrType.size()>0){
										if(intrType.contains("D") || intrType.contains("G")){
											drug_drug_display = "inline";
										}
										if(intrType.contains("F")){
											drug_food_display = "inline";
										}
										if(intrType.contains("L")){
											drug_lab_display = "inline"; 
										}
										if(intrType.contains("I")){//MMS-DM-CRF-0229
											drug_disease_display = "inline"; 
										}
										drug_food_remarks = food_interaction_remarks;
										drug_lab_remarks = lab_interaction_remarks;
										drug_disease_remarks = disease_interaction_remarks;//MMS-DM-CRF-0229

										} //MMS-KH-CRF-0029 [IN070606] - end
										
										if(interaction_exists.equals("Y") && drug_drug_display.equals("inline") && !interaction_remarks.equals("")  ){//modified for MMS-KH-CRF-0029
%>
											<tr>	
												<td width="5%" class=label>&nbsp;</td>
												<td class=label width="17%" valign='TOP' nowrap><b><fmt:message key="ePH.Drug_DrugInteractionRemarks.label" bundle="${ph_labels}"/>&nbsp;:</b></td> <!-- modified for MMS-KH-CRF-0029[IN070606]-->
												<td class=label colspan='7'  id='interaction_remarks<%=j%>'><%=interaction_remarks%></td>
											</tr> <!-- modified for MMS-KH-CRF-0029[IN070606]-->
										<!--	<script>
												var interaction_remarks = decodeURIComponent('<%=interaction_remarks%>');
												eval("document.getElementById("interaction_remarks")"+'<%=j%>').innerText= interaction_remarks ;
											</script> -->
<%		
										}
										if(abuse_exists.equals("Y") && abuse_action.equals("B") && !abuse_remarks.equals("") ){//added for AAKH-CRF-0140
											%>
																						<tr>	
																							<td width="5%" class=label>&nbsp;</td>
																							<td class=label width="17%" valign='TOP' nowrap><b>Drug Abuse Remarks:</b></td> 
																							<td class=label colspan='7'  id='abuse_remarks<%=j%>'><%=abuse_remarks%></td>
																						</tr> <!-- modified for MMS-KH-CRF-0029[IN070606]-->
																					<!--	<script>
																							var interaction_remarks = decodeURIComponent('<%=abuse_remarks%>');
																							eval("document.getElementById("interaction_remarks")"+'<%=j%>').innerText= interaction_remarks ;
																						</script> -->
											<%		
																					}
										if(drug_food_display.equals("inline") && override_flag ){//modified for MMS-KH-CRF-0029
%>
											<tr>	
												<td width="5%" class=label>&nbsp;</td>
												<td class=label width="17%" valign='TOP' nowrap><b><fmt:message key="ePH.Drug_FoodInteractionRemarks.label" bundle="${ph_labels}"/>&nbsp;:</b></td>
												<td class=label colspan='7'  id='interaction_remarks<%=j%>'><%=drug_food_remarks%></td>
											</tr>
										<!--	<script>
												var interaction_remarks = decodeURIComponent('<%=interaction_remarks%>');
												eval("document.getElementById("interaction_remarks")"+'<%=j%>').innerText= interaction_remarks ;
											</script> -->
<%		
										}
										if(drug_lab_display.equals("inline") && override_flag){ //modified for MMS-KH-CRF-0029
%>
											<tr>	
												<td width="5%" class=label>&nbsp;</td>
												<td class=label width="17%" valign='TOP' nowrap><b><fmt:message key="ePH.Drug_LabInteractionRemarks.label" bundle="${ph_labels}"/>&nbsp;:</b></td>
												<td class=label colspan='7'  id='interaction_remarks<%=j%>'><%=drug_lab_remarks%></td>
											</tr> <!-- added for MMS-KH-CRF-0029[IN070606] end-->
										<!--	<script>
												var interaction_remarks = decodeURIComponent('<%=interaction_remarks%>');
												eval("document.getElementById("interaction_remarks")"+'<%=j%>').innerText= interaction_remarks ;
											</script> -->
<%		
										}
                                       if(drug_disease_display.equals("inline") && override_flag){ //modified for MMS-DM-CRF-0229
%>
											<tr>	
												<td width="5%" class=label>&nbsp;</td>
												<td class=label width="17%" valign='TOP' nowrap><b><fmt:message key="ePH.Drug-DiseaseInteractionRemarks.label" bundle="${ph_labels}"/>&nbsp;:</b></td>
												<td class=label colspan='7'  id='interaction_remarks<%=j%>'><%=drug_disease_remarks%></td>
											</tr> 
<%		
										}
		//							}
									if(no_refill!=null && (!no_refill.equals(""))) {	
%>
									<tr>
										<td class="data" colspan="8">&nbsp;</td></tr>
<%								
										if(RefillDetail.get("refill_start_date") != null && ((ArrayList)RefillDetail.get("refill_start_date")).size() >0){
											for(int p=0; p<((ArrayList)RefillDetail.get("refill_start_date")).size(); p++) { 		
												if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y") && pat_brought_medn.equals("N") && billable_item_yn.equals("Y")){
													if(totalTaperQtyDisplay.equals("Y") && tappered_over.equals("Y")){
														overriden_action_reason	= (String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_CODE")==null?"":(String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_CODE");
														override_excl_incl_ind		= (String)drugDetails.get("BL_DEF_OVERRIDE_EXCL_INCL_IND")==null?"":(String)drugDetails.get("BL_DEF_OVERRIDE_EXCL_INCL_IND"); 
														hmBLDtlforPreview = bean.getBillingDetailforPrev((String)drugDetails.get("ITEM_CODE"), order_qty,patient_id,encounter_id,episode_type, order_Date, take_home_medication, override_excl_incl_ind, overriden_action_reason, facility_id);
														tot_payable = (String)hmBLDtlforPreview.get("BL_TOTAL_CHARGE_AMT")==null?"0.0":(String)hmBLDtlforPreview.get("BL_TOTAL_CHARGE_AMT");
														pat_payable = (String)hmBLDtlforPreview.get("BL_PATIENT_PAYABLE_AMT")==null?"0.0":(String)hmBLDtlforPreview.get("BL_PATIENT_PAYABLE_AMT");
														tot_payable_tapper = (String)drugDetails.get("BL_TOTAL_CHARGE_AMT")==null?"0.0":(String)drugDetails.get("BL_TOTAL_CHARGE_AMT");
														pat_payable_tapper = (String)drugDetails.get("BL_PATIENT_PAYABLE_AMT")==null?"0.0":(String)drugDetails.get("BL_PATIENT_PAYABLE_AMT");
														//Added for IN:069886 start
														if(p==(((ArrayList)RefillDetail.get("refill_start_date")).size()-1)){
															tot_payable = (Float.parseFloat(tot_payable)*durn_conv_fact)+"";
															pat_payable	=(Float.parseFloat(pat_payable)*durn_conv_fact)+"";	
															tot_payable_tapper = (Float.parseFloat(tot_payable_tapper)*durn_conv_fact)+"";
															pat_payable_tapper	=(Float.parseFloat(pat_payable_tapper)*durn_conv_fact)+"";	
														}
														//Added for IN:069886 end
														if(!drug_tapered.equals("Y")){
															tot_payable_sum += Float.parseFloat(tot_payable_tapper);
															pat_payable_sum += Float.parseFloat(pat_payable_tapper);
														}
													}
													else{
														tot_payable = (String)drugDetails.get("BL_TOTAL_CHARGE_AMT")==null?"0.0":(String)drugDetails.get("BL_TOTAL_CHARGE_AMT");
														pat_payable = (String)drugDetails.get("BL_PATIENT_PAYABLE_AMT")==null?"0.0":(String)drugDetails.get("BL_PATIENT_PAYABLE_AMT");
														//Added for IN:069886 start
														if(p==(((ArrayList)RefillDetail.get("refill_start_date")).size()-1)){
															tot_payable = (Float.parseFloat(tot_payable)*durn_conv_fact)+"";
															pat_payable	=(Float.parseFloat(pat_payable)*durn_conv_fact)+"";	
														}
														//Added for IN:069886 end
														tot_payable_sum += Float.parseFloat(tot_payable);
														pat_payable_sum += Float.parseFloat(pat_payable);
													}
													decimalFormatString = (String)drugDetails.get("BL_DECIMAL_FORMAT_STRING")==null?"##.00":(String)drugDetails.get("BL_DECIMAL_FORMAT_STRING");
													//if((totalTaperQtyDisplay.equals("Y") && drug_tapered.equals("Y") && !tappered_over.equals("Y"))  || (totalTaperQtyDisplay.equals("N")|| !drug_tapered.equals("Y"))) {
													//if((totalTaperQtyDisplay.equals("Y") && !drug_tapered.equals("Y") && tappered_over.equals("Y") )|| !totalTaperQtyDisplay.equals("Y")  || !drug_tapered.equals("Y") ){ //comment new
													//	tot_payable_sum += Float.parseFloat(tot_payable);
													//	pat_payable_sum += Float.parseFloat(pat_payable);
												//	}
												}
												else{
													if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
														tot_payable = "--";
														pat_payable = "--";
													}
													else{
														tot_payable = "";
														pat_payable = "";
													}
												}
												/*if(pat_brought_medn.equals("Y"))
												{
													tot_payable = "--";
													pat_payable = "--";
												}*/
%>
												<tr>
													<td width="5%" class="data"><fmt:message key="ePH.Refill.label" bundle="${ph_labels}"/></td>
													<!-- Modified for IN:069886 start -->
													<%if(p==(((ArrayList)RefillDetail.get("refill_start_date")).size()-1)){ %>
													<td class="label" wrap colspan="3"><%=tooltipnew%>&nbsp;<font style='color:<%=fntColor%>;background-color:<%=backgrndColor%>;'><%=addRouteDesc%></font></td> <!-- addRouteDesc Added For ICN 29927 RUT-CRF-0034 -->
													<%}else{ %>
													<td class="label" wrap colspan="3"><%=tooltip%>&nbsp;<font style='color:<%=fntColor%>;background-color:<%=backgrndColor%>;'><%=addRouteDesc%></font></td> <!-- addRouteDesc Added For ICN 29927 RUT-CRF-0034 -->
													<%} %>
													<!-- Modified for IN:069886 end-->
<%
													if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
%>
														<td class='label' style='TEXT-ALIGN:right;'><%=tot_payable%></td>
														<td class='label' style='TEXT-ALIGN:right;'><%=pat_payable%></td>
<%
													}
%>
													<td class="label" nowrap  ><%=((ArrayList)RefillDetail.get("refill_start_date")).get(p)%></td>
													<td class="label" nowrap ><%=((ArrayList)RefillDetail.get("refill_end_date")).get(p)%></td>
												</tr>
<%											
											}
										} 
									}
								} 
								else{	
%>
									<tr><td class="data" colspan="8">&nbsp;</td></tr>
<%
									if(freq_nature.equals("P")){//SKR-SCF-1660 
%>
										<tr><td class="data" colspan="8"  > <fmt:message key="ePH.CurrentRx.label" bundle="${ph_labels}"/></td></tr>
<%		
									}
									else  { 
%>
										<tr>
											<td width="5%" class="data"><fmt:message key="Common.Taper.label" bundle="${common_labels}"/></td>
											<td class="label" wrap   colspan="2"><%=tooltip%>&nbsp;<font style='color:<%=fntColor%>;background-color:<%=backgrndColor%>;'><%=addRouteDesc%></font></td> <!-- addRouteDesc Added For ICN 29927	RUT-CRF-0034  Start -->
											<td class="label" nowrap><%=order_qty%>&nbsp;<%=order_uom%></td><!--order_uom-->
<%
										//if(totalTaperQtyDisplay.equals("Y") && tappered_over.equals("Y")){
%>
										<!--	<td class='label' style='TEXT-ALIGN:right;'>--</td>
											<td class='label' style='TEXT-ALIGN:right;'>--</td> -->
<%
										//}
										//else{
											if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
%>
												<td class='label' style='TEXT-ALIGN:right;'><%=tot_payable%></td>
												<td class='label' style='TEXT-ALIGN:right;'><%=pat_payable%></td>
<%
											}
%>

											<td class="label" nowrap ><%=(String)drugDetails.get("START_DATE")==null?"":(String)drugDetails.get("START_DATE")%></td>
											<td class="label" nowrap ><%=(String)drugDetails.get("END_DATE")==null?"":(String)drugDetails.get("END_DATE")%></td>
										</tr>
<%
									}
									if(!freq_str.equals("")) { 
%>
										<tr>
											<td width="5%" class=label>&nbsp;</td>
											<td colspan="7" class="label"><%=freq_str%></td>	
										</tr>
<%
									}
									if(!pres_remarks.equals("")) {
%>
										<tr>	
											<td width="5%" class=label>&nbsp;</td>
											<td width="17%" class="label" valign='TOP'><b><fmt:message key="ePH.DrugRemarks.label" bundle="${ph_labels}"/>:</b>
											<td colspan="6" class="label"><%=pres_remarks%></td>	
										</tr>
<%
									}	
									if(!PRN_remarks_dtl.equals("")&&(freq_nature.equals("P"))){
%>
										<tr>	
											<td width="5%" class=label>&nbsp;</td>
											<td width='17%' class=label valign='TOP'><b><fmt:message key="ePH.PRNRemarks.label" bundle="${ph_labels}"/>: </b></td>
											<td class=label colspan='6' id='prn_remarks<%=j%><%=k%>'></td>
										</tr>
										<script>
											var PRN_remarks = decodeURIComponent('<%=PRN_remarks_dtl%>');
											eval(document.getElementById("prn_remarks"+'<%=j%>'+'<%=k%>')).innerText= PRN_remarks ;
										</script>
<%			
									}
									if(((String)drugDetails.get("SLIDING_SCALE_YN")).equals("Y") && !sliding_scale_remarks.equals("") ){//SLIDING_SCALE_YN condition added for ARYU-SCF-0053
%>
										<tr>	
											<td width="5%" class=label>&nbsp;</td>
											<td width='19%' class=label valign='TOP'><b><fmt:message key="ePH.SlidingScaleRemarks.label" bundle="${ph_labels}"/>: </b></td>
											<td class=label colspan='6' ><%=sliding_scale_remarks%></td>
										</tr>
<%			
									}	
									if(!(dsg_reason.equals("") && dup_reason.equals("") && con_reason.equals("") && int_reason.equals("") && alg_reason.equals(""))){
										if(!dsg_reason.equals("")){
%>
											<tr>	
												<td width="5%" class=label>&nbsp;</td>
												<td class=label width="15%" valign='TOP'><b><fmt:message key="ePH.DrugDosageOverrideReason.label" bundle="${ph_labels}"/>: </b></td>
												<td class=label colspan='6'  id='dsg_reason<%=j%><%=k%>'></td>
											</tr>
											<script>
												var dsg_reason = decodeURIComponent('<%=dsg_reason%>');
												eval(document.getElementById("dsg_reason"+'<%=j%><%=k%>')).innerText= dsg_reason ;
											</script>
<%
										}
										if(!dup_reason.equals("")){
%>
											<tr>	
												<td width="5%" class=label>&nbsp;</td>
												<td class=label width="15%" valign='TOP'><b><fmt:message key="ePH.DuplicateTheraphyOverrideReason.label" bundle="${ph_labels}"/>: </b></td>
												<td class=label colspan='6'  id='dup_reason<%=j%><%=k%>'></td>
											</tr>
											<script>
												var dup_reason = decodeURIComponent('<%=dup_reason%>');
												eval(document.getElementById("dup_reason"+'<%=j%><%=k%>')).innerText= dup_reason ;
											</script>
<%
										}
										if(!con_reason.equals("")){
%>
											<tr>	
												<td width="5%" class=label>&nbsp;</td>
												<td class=label width="15%" valign='TOP'><b><fmt:message key="ePH.ContraIndicationOverrideReason.label" bundle="${ph_labels}"/>: </b></td>
												<td class=label colspan='6'  id='con_reason<%=j%><%=k%>'></td>
											</tr>
											<script>
												var con_reason = decodeURIComponent('<%=con_reason%>');
												eval(document.getElementById("con_reason"+'<%=j%><%=k%>')).innerText= con_reason ;
											</script>
<%
										}
										if( !int_reason.equals("") ){
%>
										<tr>	
											<td width="5%" class=label>&nbsp;</td>
											<td class=label width="15%" valign='TOP'><b><fmt:message key="ePH.DrugInteractionOverrideReason.label" bundle="${ph_labels}"/>: </b></td>
											<td class=label colspan='6'  id='int_reason<%=j%><%=k%>'></td>
										</tr>
										<script>
											var int_reason = decodeURIComponent('<%=int_reason%>');
											eval(document.getElementById("int_reason"+'<%=j%><%=k%>')).innerText= int_reason ;
										</script>
<%
									}
									if(!alg_reason.equals("")){
%>
										<tr>	
											<td width="5%" class=label>&nbsp;</td>
											<td class=label width="15%" valign='TOP'><b><fmt:message key="Common.AllergyOverrideReason.label" bundle="${common_labels}"/>: </b></td>
											<td class=label colspan='6'  id='alg_reason<%=j%><%=k%>'></td>
										</tr>
										<script>
											var alg_reason = decodeURIComponent('<%=alg_reason%>');
											eval(document.getElementById("alg_reason"+'<%=j%><%=k%>')).innerText= alg_reason ;
										</script>
<%
									}
								}
								else{
									if(override_yn.equals("Y") && !override_reason.equals("")){
%>
										<tr>	
											<td width="5%" class=label>&nbsp;</td>
											<td width='17%' class=label valign='TOP'><b><fmt:message key="ePH.OverrideReason.label" bundle="${ph_labels}"/>   :</b>
											<td class=label colspan='6'  id='override_reason<%=j%><%=k%>'></td>
										</tr>
										<script>
											var override_reason = decodeURIComponent('<%=override_reason%>');
											eval(document.getElementById("override_reason"+'<%=j%>'+'<%=k%>')).innerText= override_reason ;
										</script>
<%
									}
									if(allergy_yn.equals("Y") && !allergy_remarks.equals("")){
%>
										<tr>	
											<td width="5%" class=label>&nbsp;</td>
											<td width='17%' class=label valign='TOP'><b><fmt:message key="ePH.AllergyRemarks.label" bundle="${ph_labels}"/>   :</b>
											<td class=label colspan='6'  id='allergy_remarks<%=j%><%=k%>'></td>
										</tr>
										<script>
											var allergy_remarks = decodeURIComponent('<%=allergy_remarks%>');
											eval(document.getElementById("allergy_remarks"+'<%=j%>'+'<%=k%>')).innerText= allergy_remarks ;
										</script>
<%
									}
									if(overdose_yn.equals("Y") && !overdose_remarks.equals("")){
%>
										<tr>	
											<td width="5%" class=label>&nbsp;</td>
											<td width='17%' class=label valign='TOP'><b><fmt:message key="ePH.OverDoseRemarks.label" bundle="${ph_labels}"/>:</b>
											<td class=label colspan='6'  id='overdose_remarks<%=j%><%=k%>'></td>
										</tr>
										<script>
											var overdose_remarks = decodeURIComponent('<%=overdose_remarks%>');
											eval(document.getElementById("overdose_remarks"+'<%=j%>'+'<%=k%>')).innerText= overdose_remarks ;
										</script>
<%
									}
									if(interaction_exists.equals("Y")  && !interaction_remarks.equals("") ){//modified fro AAKH-CRF-0140
%>
										<tr>	
											<td width="5%" class=label>&nbsp;</td>
											<td class=label width="17%" valign='TOP'><b><fmt:message key="Common.DrugInteraction.label" bundle="${common_labels}"/>&nbsp;:<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></b></td>
											<td class=label colspan='6'  id='interaction_remarks<%=j%><%=k%>'></td>
										</tr>
										<script>
											var interaction_remarks = decodeURIComponent('<%=interaction_remarks%>');
											eval(document.getElementById("interaction_remarks"+'<%=j%>'+'<%=k%>')).innerText= interaction_remarks ;
										</script>
<%		
									}
									if(abuse_exists.equals("Y")  && !abuse_remarks.equals("") ){//modified fro AAKH-CRF-0140
										%>
																				<tr>	
																					<td width="5%" class=label>&nbsp;</td>
																					<td class=label width="17%" valign='TOP'><b>Drug Abuse&nbsp;:<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></b></td>
																					<td class=label colspan='6'  id='abuse_remarks<%=j%><%=k%>'></td>
																				</tr>
																				<script>
																					var abuse_remarks = decodeURIComponent('<%=abuse_remarks%>');
																					eval(document.getElementById("abuse_remarks"+'<%=j%>'+'<%=k%>')).innerText= abuse_remarks ;
																				</script>
										<%		
																			}
								}
							}		   
							k++;
						}
						if(totalTaperQtyDisplay.equals("Y") && tappered_over.equals("Y")){
							//totTapperQty=bean.getTotTapQty(drug_code);  //Added for RUT-CRF-0088 [IN036978]
%>
							<tr>
								<td colspan='3' class='data' align='right'><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Taper.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Quantity.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;</td>
								<td class='data' nowrap><%=totTapperQty%>&nbsp;<%=order_uom%></td>
								<td class='data' style='TEXT-ALIGN:right;'><%=tot_payable_tapper%>&nbsp;&nbsp;</td>
								<td class='data'style='TEXT-ALIGN:right;'><%=pat_payable_tapper%>&nbsp;&nbsp;</td>
								<td colspan='2' class=label>&nbsp;</td>
							</tr>
<%
						}
					}
					if( (i!=(grp.size())-1))
%>
						<tr><td class="label"></td></tr>	
<%
					}
				}
				String clinical_comments	=	bean.getPresRemarks();
				if(clinical_comments!=null && !clinical_comments.equals("")) {
%>
					<tr>
						<td class="label"></td>
					</tr>
					<tr>
						<td width="5%" colspan="2" class="data"><fmt:message key="ePH.PrescriptionRemarks.label" bundle="${ph_labels}"/>:&nbsp;&nbsp;</td>
						<td colspan="6" class="label" id='clinical_comments'><%=clinical_comments%></td>	
					</tr>
<%
				}
			}

		//	HashMap schd_week_hr_dates = (HashMap)bean.getSchdDatesFrWeekHr(bean.getscheduleFrequency(),bean.getOrderDetails(),"CREATE");

			String consumable_bean_id				= "@ConsumableOrderBean"+patient_id+encounter_id;
			String consumable_bean_name				= "ePH.ConsumableOrderBean";
			ConsumableOrderBean consumable_bean		= (ConsumableOrderBean)getBeanObject( consumable_bean_id,consumable_bean_name , request );
			ArrayList presItemList = consumable_bean.getPresItemList();
			HashMap itemDetail = null;
			if(presItemList!=null && presItemList.size()>0){
				for (int i=0; i<presItemList.size(); i++) {
					itemDetail	= (HashMap)presItemList.get(i);	
					tot_payable = (String)itemDetail.get("BL_CHARGE_AMT")==null?"":(String)itemDetail.get("BL_CHARGE_AMT");
					pat_payable = (String)itemDetail.get("BL_PATIENT_PAYABLE")==null?"":(String)itemDetail.get("BL_PATIENT_PAYABLE");
					decimalFormatString = (String)itemDetail.get("BL_DECIMAL_FORMAT_STRING")==null?"##.00":(String)itemDetail.get("BL_DECIMAL_FORMAT_STRING");

%>             
                   <TR><td class="data" WIDTH="52%" colspan="9" ><fmt:message key="ePH.MedicalItems.label" bundle="${ph_labels}"/></td></TR>
					<tr>
						<td width="5%" class=label>&nbsp;</td>
						<td class="data" WRAP colspan="2"  width="47%"><%=(String)itemDetail.get("ITEM_DESC")%>&nbsp;<label class="label" style="font-size:xx-small;font-weight:normal"><%=(String)itemDetail.get("TRADE_NAME")%>&nbsp;</label> 
					</td>
					<td class="label" wrap >&nbsp;<%=(String)itemDetail.get("QTY_VALUE")%>&nbsp;<%=(String)itemDetail.get("UOM_DESC")%></td>
<%
					if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
						if(tot_payable.equals(""))
							tot_payable = "0.0";
						if(pat_payable.equals(""))
							pat_payable = "0.0";
%>
						<td class='label' style='TEXT-ALIGN:right;'><%=tot_payable%>&nbsp;</td>
						<td class='label' style='TEXT-ALIGN:right;'><%=pat_payable%>&nbsp;</td>
<%
						//if((totalTaperQtyDisplay.equals("Y") && drug_tapered.equals("Y") && !tappered_over.equals("Y"))|| (totalTaperQtyDisplay.equals("N") || !drug_tapered.equals("Y")) ){
						//if((totalTaperQtyDisplay.equals("Y") && !drug_tapered.equals("Y") && tappered_over.equals("Y") )|| totalTaperQtyDisplay.equals("N") ){ //if condition commented for RUT-SCF-0188[IN039946]
							tot_payable_sum += Float.parseFloat(tot_payable);
							pat_payable_sum += Float.parseFloat(pat_payable);
						//}
					}
					else{
%>
						<td colspan='2' class=label>&nbsp;</td>
<%
					}
%>
					<td class="data" nowrap  width="15%">&nbsp;</td>
					<td class="data" nowrap  width="15%">&nbsp;</td>
					</tr>
<%
				}
			}

			if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
				DecimalFormat dfTest = new DecimalFormat(decimalFormatString);
				//charge_amt = Double.parseDouble(patient_payable_amt)+"";
				tot_payable_sum_str = dfTest.format(tot_payable_sum);
				pat_payable_sum_str = dfTest.format(pat_payable_sum);
%>
				<tr><td class="label">&nbsp;</td></tr>	
				<tr>
					<td colspan='4' class='data' align='right'><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td class='data' align='right'><%=tot_payable_sum_str%>&nbsp;&nbsp;</td>
					<td class='data' align='right'><%=pat_payable_sum_str%>&nbsp;&nbsp;</td>
					<td colspan='2' class=label>&nbsp;</td>
				</tr>
<%
			}
%>
			</table>
		</form>
<%
		putObjectInBean(bean_id,bean,request);
		putObjectInBean(or_bean_id,orbean,request);
		putObjectInBean(presBean_id,presBean,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>
	</body>
</html> 

