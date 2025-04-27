<!DOCTYPE html>
 <!--saved on 27th Oct 2005 -->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*,ePH.*,ePH.Common.*,eCommon.Common.*,eOR.Common.*,eOR.*,java.text.DecimalFormat,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<%
	String patient_id		=request.getParameter("patient_id");
	String encounter_id	=request.getParameter("encounter_id");
	String bean_id			= "@PrescriptionBean_1"+patient_id+encounter_id;
	String bean_name	= "ePH.PrescriptionBean_1";
	PrescriptionBean_1 bean = (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request) ;
	String presBean_id			= "PrescriptionBean"+patient_id+encounter_id;
	String presBean_name		= "ePH.PrescriptionBean";
	PrescriptionBean presBean		= (PrescriptionBean)getBeanObject(presBean_id, presBean_name, request );

	ArrayList prescriptionDetails = bean.getpresDetails();
	String or_bean_name = "eOR.OrderEntryBean";
	String or_bean_id = "@orderentrybean" + patient_id + encounter_id;
	//Code Added For ICN 29927	RUT-CRF-0034 -Start
	String route_color = "";
	String addRouteDesc = "";
	String route_desc = "";
	String fntColor = "";
	String route_code = "";
	//Code Added For ICN 29927	RUT-CRF-0034 -End
String called_amend_from=bean.getCalledFromAmend();
	OrderEntryBean orbean = (OrderEntryBean)getBeanObject( or_bean_id,or_bean_name,request) ;
	eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) orbean.getOrderEntryRecordBean();

	String drug_code = null;
	String srl_no = null;
	String taper_yn = null;
	String qty_value = null;
	String qty_desc = null;
	String qty_desc_code = null;
	String or_qty_desc = null;
	String freq_nature = null;
	String freq_desc = null;
	String durn_value = null;
	String durn_type = null;
	String or_durn_desc = null;
	String strength_uom = null;
	String dosage_type = null;
	String strength_value = null;
	String no_refill = null;
	HashMap RefillDetail = null;
	String end_date = null;
	String repeat_durn_type = null;
	String order_line_num = "";
	String order_qty = null;
	String order_uom = null;
	String uom_desc = "";
	HashMap PRN_remarks = new HashMap();
	String PRN_remarks_code = "";
	String PRN_remarks_dtl = "";
	String allergy_yn = "";
	String override_yn = "";
	String overdose_yn = "";
	String dsg_reason = "";
	String dup_reason = "";
	String con_reason = "";
	String int_reason = "";
	String alg_reason = "";
	String trade_name = "";
	String tot_payable = "";
	String pat_payable = "";
	double tot_payable_sum = 0.0;
	double pat_payable_sum = 0.0;
	String tot_payable_sum_str = "";
	String pat_payable_sum_str = "";
	String decimalFormatString = "";
	String charge_display = "display:none";
	String sliding_scale_remarks = "";
	String billable_item_yn = "";
	String facility_id = (String) session.getValue("facility_id");
	String drugindication_remarks = "";//added for MMS Adhoc Testing
	String display_auth_rule = "visibility:hidden", color_auth_rule = "RED", ord_auth_reqd_yn = "", ord_authorized_yn = "", strAuthStatus = "-"; //added for ML-MMOH-CRF-0343
	String preview_auth_status_yn = bean.getPreviewAuthStatus(); //added for ML-MMOH-CRF-0343
	String interaction_exists="";//MMS-KH-CRF-0029
	String interaction_remarks = "";//MMS-KH-CRF-0029
	String food_interaction_remarks = "";//MMS-KH-CRF-0029
	String lab_interaction_remarks = "";//MMS-KH-CRF-0029
	String abuse_exists="";//added  for AAKH-CRF-0140
	String abuse_action="";//added for aakh-crf-0140
	String abuse_remarks	=	"";//added  for AAKH-CRF-0140
	String disease_interaction_remarks ="";//Added for MMS-DM-CRF-0229
	
	//String order_ststus="";//added for ml-mmoh-crf-0863
	if ("Y".equals(preview_auth_status_yn)) { // if condition added for ML-MMOH-CRF-0343
		display_auth_rule = "visibility:visible";
	}
	//added for ml-mmoh-crf-0863 start
	String disp_locn_code = "";
	disp_locn_code = presBean.getDisp_locn_code();//added for ml-mmoh-crf-0863
	//	 order_ststus=presBean.getOrder_ststus();//added for ml-mmoh-crf-0863

	String auth_amend_pres_yn = "";
	auth_amend_pres_yn = presBean.getAuthAmendPres(disp_locn_code);

	//added for ml-mmoh-crf-0863 end
%>
	<html>
		<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
			String locale = (String) session.getAttribute("LOCALE");
			bean.setLanguageId(locale);
			orbean.setLanguageId(locale);
			String bl_install_yn = request.getParameter("bl_install_yn")==null?"":request.getParameter("bl_install_yn");
			String bl_disp_charge_dtl_in_rx_yn = request.getParameter("bl_disp_charge_dtl_in_rx_yn")==null?"":request.getParameter("bl_disp_charge_dtl_in_rx_yn");
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
			<script language="javascript" src="../../eCommon/js/common.js"></script>
			<script language="JavaScript" src="../js/Prescription.js"></script>
			<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
			<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
			<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</head>
		<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">

			<form name="prescription_form_preview_order" id="prescription_form_preview_order" >
<%
	if (prescriptionDetails.size() > 0) {
%>
				<table border="0" width="100%" cellspacing="0" cellpadding="0" id="prescription_table">
<%
				ArrayList grp		=(ArrayList) bean.sortList();
				int k=0;
				HashMap drugDetails =	null;
				for(int i=0;i<grp.size();i++){
					ArrayList displayList=(ArrayList) bean.getDisplayList((String)grp.get(i));

					for(int j=0;j<displayList.size();j++){	
						color_auth_rule ="BLACK"; // Added for  ML-MMOH-CRF-0343 [IN:057182]
						strAuthStatus="-"; // Added for  ML-MMOH-CRF-0343 [IN:057182]
						drugDetails=(HashMap) displayList.get(j);
						drug_code		= (String)drugDetails.get("DRUG_CODE");
						srl_no			= (String)drugDetails.get("SRL_NO");
						taper_yn		= (String)drugDetails.get("TAPERED_YN");
						billable_item_yn = (String)drugDetails.get("BILLABLE_ITEM_YN")==null?"Y":(String)drugDetails.get("BILLABLE_ITEM_YN");
						qty_value		= (String)drugDetails.get("QTY_VALUE");
						qty_desc		= (String)drugDetails.get("QTY_DESC");
						or_qty_desc		= (String)drugDetails.get("OR_QTY_DESC")==null?(String)drugDetails.get("QTY_UNIT"):(String)drugDetails.get("OR_QTY_DESC");
						//added for ML-BRU-SCF-1785 start
						if((String) drugDetails.get("OR_QTY_DESC") == null){
							//(String)drugDetails.get("ORDERING_FACILITY_ID");
							or_qty_desc=bean.getUomDisplay((String)drugDetails.get("ORDERING_FACILITY_ID"),or_qty_desc);
						}
						//added for ML-BRU-SCF-1785 end
						freq_desc		= (String)drugDetails.get("FREQ_DESC");
						freq_desc		=  java.net.URLDecoder.decode(freq_desc,"UTF-8");
						freq_desc		=  freq_desc.replaceAll("%26","&");
						freq_desc		=  freq_desc.replaceAll("%40","@");

				durn_value = (String) drugDetails.get("DURN_VALUE");
				durn_type = (String) drugDetails.get("DURN_TYPE");
				or_durn_desc = (String) drugDetails.get("DURN_DESC");
				strength_uom = (String) drugDetails.get("STRENGTH_UOM");
				dosage_type = (String) drugDetails.get("DOSAGE_TYPE"); 
				interaction_exists =		  (String)drugDetails.get("INTERACTION_EXISTS")==null?"":(String)drugDetails.get("INTERACTION_EXISTS");//MMS-KH-CRF-0029
				interaction_remarks=	  (String)drugDetails.get("INTERACTION_REMARKS")==null?"":	(String)drugDetails.get("INTERACTION_REMARKS"); //MMS-KH-CRF-0029
						strength_value	= (String)drugDetails.get("STRENGTH_VALUE");
						trade_name		= (String)drugDetails.get("TRADE_NAME")==null?"": (String)drugDetails.get("TRADE_NAME");
						
					//	order_ststus       =(String)drugDetails.get("ORDER_STATUS")==null?"N":(String)drugDetails.get("ORDER_STATUS");//added for ml-mmoh-crf-0863
						if(!trade_name.equals(""))
							trade_name	="("+trade_name+")";
						
						if(drugDetails.containsKey("SLIDING_SCALE_REMARKS")) {
							sliding_scale_remarks	=	(String)drugDetails.get("SLIDING_SCALE_REMARKS");
						}
						
						//route_desc=(String)drugDetails.get("ROUTE_DESC")==null?"":	(String)drugDetails.get("ROUTE_DESC");  //Code Added For ICN 29927	RUT-CRF-0034 Start
						route_code=(String)drugDetails.get("ROUTE_CODE")==null?"":	(String)drugDetails.get("ROUTE_CODE");  
						fntColor="000000";
						ArrayList routes				=	presBean.getRoutes((String)drugDetails.get("FORM_CODE")); 
						for(int l=0; l<routes.size(); l+=3) { 
							if(route_code.equals(routes.get(l))){
								route_desc = (String)routes.get(l+1);
								route_color = (String)routes.get(l+2);
								break;
							}
						}
						if(route_color!= null && !route_color.equals("") && route_color.length()==12){
							fntColor= route_color.substring(0, 6);
						}
						addRouteDesc="<font color='"+fntColor+"'>("+route_desc+")</font>"; 	//Code Added For ICN 29927	RUT-CRF-0034 End

						if( "Y".equals(preview_auth_status_yn)) {
							ord_auth_reqd_yn = (String) drugDetails.get("ORD_AUTH_REQD_YN");  //added for ML-MMOH-CRF-0343 -start
							ord_authorized_yn			= (String) drugDetails.get("ORD_AUTHORIZED_YN");
							if(ord_auth_reqd_yn.equals("Y") && "Y".equals(preview_auth_status_yn)){
								display_auth_rule = "visibility:visible";
								color_auth_rule = "color:red";
								strAuthStatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.AuthorizationReqd..label", "common_labels");
								if(ord_authorized_yn.equals("Y")){
									color_auth_rule = "color:green";
									strAuthStatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Authorized.label", "common_labels");
								}
								//added for ml-mmoh-crf-0863 start
							if(ord_authorized_yn.equals("N")){
								if("Y".equals(auth_amend_pres_yn) && called_amend_from.equals("PH") ){
									color_auth_rule = "color:green";
									strAuthStatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Authorized.label", "common_labels");
								}
								
							}
								//added for ml-mmoh-crf-0863 end
							} 
						}//added for ML-MMOH-CRF-0343 -end

						String scheduled_yn	= (String)drugDetails.get("SCHEDULED_YN");
						no_refill			= (String)drugDetails.get("NO_REFILL");
						end_date			= (String)drugDetails.get("END_DATE");	
						repeat_durn_type	= (String)drugDetails.get("REPEAT_DURN_TYPE");	
						order_qty			= (String)drugDetails.get("ORDER_QTY");	

						if(order_qty != null && (!order_qty.equals(""))) 
							order_qty			=	new Float(Math.ceil(Float.parseFloat(order_qty))).intValue()+""; 

						order_uom			= (String)drugDetails.get("ORDER_UOM");	
						freq_nature			= (String)drugDetails.get("FREQ_NATURE")==null?"":(String)drugDetails.get("FREQ_NATURE");
						PRN_remarks			=  bean.getPRNRemarks(drug_code);

						if(PRN_remarks != null){
							PRN_remarks_code = PRN_remarks.get("prn_remarks_code")==null?"":(String)PRN_remarks.get("prn_remarks_code");
							PRN_remarks_dtl  = PRN_remarks.get("prn_remarks_dtl")==null?"":(String)PRN_remarks.get("prn_remarks_dtl");
						}
						String order_uom1	=	presBean.getOrderUnit(dosage_type,order_qty,drug_code);
						PRN_remarks_dtl		=	PRN_remarks_dtl.replaceAll(" ","%20");
						PRN_remarks_dtl		=	java.net.URLEncoder.encode(PRN_remarks_dtl,"UTF-8");
						PRN_remarks_dtl		=	PRN_remarks_dtl.replaceAll("%2520","%20");

						allergy_yn			=   (String)drugDetails.get("ALLERGY_OVERRIDE")==null?"":	(String)drugDetails.get("ALLERGY_OVERRIDE");  
						alg_reason			=   (String)drugDetails.get("ALLERGY_REMARKS")==null?"":	(String)drugDetails.get("ALLERGY_REMARKS");   
						alg_reason			=   alg_reason.replaceAll(" ","%20");
						alg_reason			=   java.net.URLEncoder.encode(alg_reason,"UTF-8");
						alg_reason			=   alg_reason.replaceAll("%2520","%20");

						override_yn			=  (String)drugDetails.get("CURRENTRX_OVERRIDE")==null?"":(String)drugDetails.get("CURRENTRX_OVERRIDE");
						dup_reason			=  (String)drugDetails.get("CURRENTRX_REMARKS")==null?"":	(String)drugDetails.get("CURRENTRX_REMARKS");

						dup_reason			=	dup_reason.replaceAll(" ","%20");
						dup_reason			=	java.net.URLEncoder.encode(dup_reason,"UTF-8");
						dup_reason			=	dup_reason.replaceAll("%2520","%20");

						overdose_yn			=   (String)drugDetails.get("DOSE_OVERRIDE")==null?"":	 (String)drugDetails.get("DOSE_OVERRIDE");      
						dsg_reason			=   (String)drugDetails.get("DOSE_REMARKS")==null?"": (String)drugDetails.get("DOSE_REMARKS");  
						
						dsg_reason			=	dsg_reason.replaceAll(" ","%20");
						dsg_reason			=   java.net.URLEncoder.encode(dsg_reason,"UTF-8");
						dsg_reason			=	dsg_reason.replaceAll("%2520","%20");

						con_reason			=   (String)drugDetails.get("EXT_DDB_CON_REASON")==null?"":(String)drugDetails.get("EXT_DDB_CON_REASON");      
						con_reason			=	con_reason.replaceAll(" ","%20");
						con_reason			=   java.net.URLEncoder.encode(con_reason,"UTF-8");
						con_reason			=   con_reason.replaceAll("%2520","%20");

						int_reason			=	(String)drugDetails.get("EXT_DDB_INT_REASON")==null?"":(String)drugDetails.get("EXT_DDB_INT_REASON");
						int_reason			=	int_reason.replaceAll(" ","%20");
						int_reason			=	java.net.URLEncoder.encode(int_reason,"UTF-8");
						int_reason			=	int_reason.replaceAll("%2520","%20");
						drugindication_remarks=	(String)drugDetails.get("DRUG_INDICATION")==null?"":(String)drugDetails.get("DRUG_INDICATION");
				////MMS-KH-CRF-0029 [IN070606] - start
				food_interaction_remarks=	  (String)drugDetails.get("FOOD_INTERACTION_REMARKS")==null?"":	(String)drugDetails.get("FOOD_INTERACTION_REMARKS"); 
				lab_interaction_remarks=	  (String)drugDetails.get("LAB_INTERACTION_REMARKS")==null?"":	(String)drugDetails.get("LAB_INTERACTION_REMARKS");//MMS-KH-CRF-0029 [IN070606]
				disease_interaction_remarks=	  (String)drugDetails.get("DISEASE_INTERACTION_REMARKS")==null?"":	(String)drugDetails.get("DISEASE_INTERACTION_REMARKS");//Added for MMS-DM-CRF-0229
				interaction_remarks=interaction_remarks.replaceAll(" ","%20");
				interaction_remarks = java.net.URLEncoder.encode(interaction_remarks,"UTF-8");
				interaction_remarks = java.net.URLDecoder.decode(interaction_remarks,"UTF-8");
				interaction_remarks=interaction_remarks.replaceAll("%2520"," ");
				interaction_remarks=interaction_remarks.replaceAll("%20"," ");
				abuse_exists= (String)drugDetails.get("ABUSE_EXISTS")==null?"":(String)drugDetails.get("ABUSE_EXISTS");//added for aakh-crf-0140
				abuse_action= (String)drugDetails.get("ABUSE_ACTION")==null?"":(String)drugDetails.get("ABUSE_ACTION");//added for aakh-crf-0140
				abuse_remarks= (String)drugDetails.get("abuse_override_remarks")==null?"":(String)drugDetails.get("abuse_override_remarks");//added for aakh-crf-0140
				
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
						if(orbean.getCalledFromFunction()!=null && !(orbean.getCalledFromFunction()).equals("RENEW_ORDER")) {
							order_line_num	=	(String)drugDetails.get("ORDER_LINE_NUM");	
						}
						else {
							order_line_num	=	orbean.getOrderLineNo();	
						}
						RefillDetail= (HashMap) presBean.populateRefillDetail(end_date,durn_value, repeat_durn_type,no_refill);
						if(strength_value!=null && !strength_value.equals("") && Float.parseFloat(strength_value) <1)
							strength_value = Float.parseFloat(strength_value) +"" ;

						if(strength_value!=null && strength_value.equals("0")) {
							strength_value		=	"";
					strength_uom = "";
				}

				String tooltip = "";
				String freq_str = "";
				String pres_remarks = "";
				boolean split_chk = false;
				boolean override_flag = false; //MMS-KH-CRF-0029

				ArrayList schedule = new ArrayList();

				if (scheduled_yn.equals("Y")) {
							 schedule	=	(ArrayList)bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
						     split_chk	=	bean.checkSplit(schedule);
						     //freq_str    = (String)bean.getTooltipStringFrFreq(schedule,"prvwString"+or_qty_desc);
							 if(((String)drugDetails.get("SLIDING_SCALE_YN")).equals("Y")) 
							      freq_str = (String)bean.getTooltipStringFrFreq(schedule,"SSprvwString"+or_qty_desc);
						     else
							      freq_str = (String)bean.getTooltipStringFrFreq(schedule,"prvwString"+or_qty_desc);

					/*						for(int n=0; n<schedule.size(); n++) {
					 HashMap detail	=	(HashMap)schedule.get(n);
					 freq_str += detail.get("admin_time")+"-";
					 if(drugDetails.get("SLIDING_SCALE_YN") == null || ((String)drugDetails.get("SLIDING_SCALE_YN")).equals("N")) {
					 freq_str += detail.get("admin_qty")+" "+qty_desc;
					 }
					 if(n==(schedule.size()-1))
					 freq_str +=" ";
					 else
					 freq_str +=", ";
					 }		*/
				}

						if(drugDetails.get("SLIDING_SCALE_YN") != null && ((String)drugDetails.get("SLIDING_SCALE_YN")).equals("Y")) {
							qty_value = "";
							or_qty_desc = "";
						}
					/*	if(qty_value != null && qty_value != "" && Float.parseFloat(qty_value) < 1.0)
							qty_value = Float.parseFloat(qty_value)+""; */ //commented for IN25920 --28/01/2011-- priya

						or_durn_desc = presBean.getDurationType(durn_type);
						if(dosage_type.equals("A"))
							tooltip			= " "+qty_value+" "+or_qty_desc+" "+freq_desc+" for "+durn_value+" "+or_durn_desc;
						else if(schedule.size() > 0 && split_chk) {
							tooltip			= " "+qty_value+" "+or_qty_desc+" <label style='color:red'>(Divided)</label> for "+durn_value+" "+or_durn_desc;
						}
						else if(schedule.size() > 0) {
							tooltip			= " "+qty_value+" "+or_qty_desc+" "+freq_desc+" <label style='color:red'></label> for "+durn_value+" "+or_durn_desc;
						} 
						else {
							tooltip			= " "+qty_value+" "+or_qty_desc+" "+freq_desc+" for "+durn_value+" "+or_durn_desc;
						}

						Hashtable template	=	null;
						ArrayList seq_num	=	(ArrayList)orderEntryRecordBean.getOrderFormats((drug_code+srl_no),(drug_code+srl_no)+"_0");

						if(seq_num==null)
							seq_num			=	new ArrayList();

						for(int p=0; p<seq_num.size(); p++) {
							template	=	(Hashtable)orderEntryRecordBean.getOrderFormats((drug_code+srl_no),((drug_code+srl_no)+((Integer.parseInt((String)seq_num.get(p))) ) ));

							if(((String) template.get("field_mnemonic")).equals("PRES_REMARKS")) {
								pres_remarks += "<br>"+template.get("label_text")+": "+presBean.getPrescriptionRemarks((String) template.get("field_values"));
							}
							else {
								pres_remarks += "<br>"+template.get("label_text")+": "+(String) template.get("field_values") ;
							}
					
						}
						if(pres_remarks.equals("")) {
							ArrayList drug_remarks	=	bean.getPrescribedRemarks(orbean.getOrderId(),order_line_num);
							if(drug_remarks.size()!=0) { 
								for(int x=0; x<drug_remarks.size(); x++) {	
									if(x==(drug_remarks.size()-1)) {	
										pres_remarks	+=	(String)drug_remarks.get(x);
									}
									else {
										pres_remarks	+=	(String)drug_remarks.get(x)+",";
									}
								} 
							} 
							if(drug_remarks.size() == 0){
								String drug_remarks1						= bean.getDrugInstructions(orbean.getOrderId(),order_line_num);
								pres_remarks=drug_remarks1;
							}
						}
						if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
							tot_payable			= (String)drugDetails.get("BL_TOTAL_CHARGE_AMT")==null?"0.0":(String)drugDetails.get("BL_TOTAL_CHARGE_AMT");
							pat_payable			= (String)drugDetails.get("BL_PATIENT_PAYABLE_AMT")==null?"0.0":(String)drugDetails.get("BL_PATIENT_PAYABLE_AMT");
							decimalFormatString	= (String)drugDetails.get("BL_DECIMAL_FORMAT_STRING")==null?"##.00":(String)drugDetails.get("BL_DECIMAL_FORMAT_STRING");
							if(billable_item_yn.equals("Y"))
							{
								if(!(tot_payable.equals("")) && tot_payable != null)
									tot_payable_sum += Float.parseFloat(tot_payable);
								if(!(pat_payable.equals("")) && pat_payable != null)
									pat_payable_sum += Float.parseFloat(pat_payable);
							}
							else
							{
								tot_payable = "--";
								pat_payable = "--";
							}
							charge_display = "display:inline";
						}
						else{
							tot_payable = "&nbsp;";
							pat_payable = "&nbsp;";
						}
						if(j==0 || !taper_yn.equals("Y"))	{					

%>
							<tr>
<%
	//								if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")&&(i==0)&&(j==0)){
%>
									<td class="data" colspan="4" ><fmt:message key="ePH.CurrentRx.label" bundle="${ph_labels}"/></td>
									<td colspan='2' class='Data' nowrap width='16%' align='right' style='<%=charge_display%>'><fmt:message key="eBL.PAYABLE_AMT.label" bundle="${bl_labels}"/></td>
									<td colspan='3'>&nbsp;</td>
									<td class="label" align='center' style='<%=display_auth_rule%>;'>&nbsp;</td> <!-- added for ML-MMOH-CRF-0343 -->
<%
	//							}
%>
							<tr>
								<td width='5%'>&nbsp;</td>
								<td class="data" WRAP colspan="2"  width="50%"><%=(String)drugDetails.get("DRUG_DESC")%>&nbsp;<label class="label" style="font-size:xx-small;font-weight:normal"><%=trade_name%>&nbsp;<%=strength_value%>&nbsp;<%=bean.getUomDisplay(facility_id,strength_uom)%> &nbsp;<%=(String)drugDetails.get("FORM_CODE")%></label></td>
								<td class="data" wrap >&nbsp;<fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
<%
								if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")&&(i==0)&&(j==0)){
%>
									<td class='Data' align='right' style='<%=charge_display%>'><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;</td>
									<td class='Data' align='right'><fmt:message key="Common.patient.label" bundle="${common_labels}"/>&nbsp;</td>
<%
	}
%>
								<td class="data" wrap  width="15%">&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/> &nbsp;&nbsp;</td>
								<td class="data" wrap  width="15%">&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
								<td class="data" align='center' style='<%=display_auth_rule%>;'>&nbsp;&nbsp;<fmt:message key="Common.status.label" bundle="${common_labels}"/></td> <!-- added for ML-MMOH-CRF-0343 -->
							</tr>
							<tr>
								<td class="label" width="5%">&nbsp;</td>
								<td class="label" wrap colspan="2"><%=tooltip%>&nbsp;<%=addRouteDesc%></td>
								<td class="label"><%=order_qty%>&nbsp;<%=order_uom1%></td>
								<td class='label' style='TEXT-ALIGN:right;<%=charge_display%>'><%=tot_payable%></td>
								<td class='label' style='TEXT-ALIGN:right;<%=charge_display%>'><%=pat_payable%></td>
								<td class="label" wrap ><%=(String)drugDetails.get("START_DATE_TIME")%></td>
								<td class="label" wrap ><%=(String)drugDetails.get("END_DATE_TIME")%></td>
								<td class="label" align='center' style='<%=display_auth_rule%>;'> <!-- added for ML-MMOH-CRF-0343 -->
									<label id='lbl_authorize' style='<%=display_auth_rule%>;<%=color_auth_rule%>'><%=strAuthStatus%></label>
								</td>
							</tr>
<%
	if (!freq_str.equals("")) {
%>
								<tr>	<td width="5%">&nbsp;</td>
										<td colspan="8" class="label"><%=freq_str%></td>	
								</tr>
<%
	}
					if (!pres_remarks.equals("")) {
%>
								<tr>	
									<td width="5%">&nbsp;</td>
									<td width='20%' class='label' ><b><fmt:message key="ePH.DrugRemarks.label" bundle="${ph_labels}"/>: </b></td>
									<td colspan="7" class="label"><%=pres_remarks%></td>	
								</tr>
<%
							}		
							if(!PRN_remarks_dtl.equals("")&&(freq_nature.equals("P"))){
%>
								<tr>	
									<td width="5%">&nbsp;</td>
									<td width='20%' class='label' ><b><fmt:message key="ePH.PRNRemarks.label" bundle="${ph_labels}"/>: </b></td>
									<td class='label' colspan='7'  id='prn_remarks<%=j%>'></td>
								</tr>
								<script>
									var prn_rem = decodeURIComponent('<%=PRN_remarks_dtl%>');
									//document.getElementById("prn_remarks").innerText=document.getElementById("prn_remarks").innerText+prn_rem;
									eval("document.getElementById("prn_remarks")"+'<%=j%>').innerText= prn_rem ;
								</script>
<%							}
							if(!drugindication_remarks.equals("")) { //if condition is added for MMS Adhoc Testing-Start
%>
								<tr>	
									 <td width="5%" class=label>&nbsp;</td>
									 <td width='17%' class=label ><b><fmt:message key="ePH.DrugIndications.label" bundle="${ph_labels}"/>: </b></td>
									 <td class=label colspan='7'  id='drugindication_remarks<%=j%>'> <%=drugindication_remarks%></td>
								</tr>
<%
	}
							//if condition is added for MMS Adhoc Testing-End
							if(!abuse_remarks.equals("") ){//aaded for aakh-crf-0140
								%>
																			<tr>	
																				<td width="5%" class=label>&nbsp;</td>
																				<td class=label width="17%" valign='TOP'><b>Drug Abuse Remarks:</b></td>
																				<td class=label colspan='7'  id='abuse_remarks<%=j%>'><%=abuse_remarks%></td>
																			</tr>
																			
								<%		
																		}
					if (!sliding_scale_remarks.equals("")) {
%>
								<tr>	
									<td width="5%">&nbsp;</td>
									<td width='19%' class=label valign='TOP'><b><fmt:message key="ePH.SlidingScaleRemarks.label" bundle="${ph_labels}"/>: </b></td>
									<td class=label colspan='7' >&nbsp;<%=sliding_scale_remarks%></td>
								</tr>
<%			
							}	
							if(((String)drugDetails.get("SLIDING_SCALE_YN")).equals("Y")){
								ArrayList slidingScaleTmplDtl = (ArrayList)drugDetails.get("SLDSCALE_TMPL_DTL");
								int noOfRangeForTmpl = slidingScaleTmplDtl.size();
								if(noOfRangeForTmpl > 0){
%>								<tr><TD colspan='9' width='100%'><table  width='100%'>
								<tr>
										<th > <fmt:message key="Common.from.label" bundle="${common_labels}"/> </th>
										<th > <fmt:message key="Common.to.label" bundle="${common_labels}"/> </th>
										<th > <fmt:message key="Common.uom.label" bundle="${common_labels}"/>  </th>
										<th > <fmt:message key="ePH.AdminUnits.label" bundle="${ph_labels}"/> </th>
										<th > <fmt:message key="Common.uom.label" bundle="${common_labels}"/> </th>
										<th > <fmt:message key="Common.remarks.label" bundle="${common_labels}"/> </th>
										<td class="data" align='center' style='<%=display_auth_rule%>;'>&nbsp;&nbsp;<fmt:message key="Common.status.label" bundle="${common_labels}"/></td> <!-- added for ML-MMOH-CRF-0343 -->
								</tr>
<%									for(int m=0; m<noOfRangeForTmpl; m=m+5){
%>
										<tr>
											<td class="data"   width="15%">&nbsp;&nbsp;<%=slidingScaleTmplDtl.get(m+1)%></td> 
											<td class="data"   width="15%">&nbsp;&nbsp;<%=slidingScaleTmplDtl.get(m+2)%></td> 
											<td class="data"   width="15%">&nbsp;&nbsp;<%=(String)drugDetails.get("RANGEUOM")%></td> 
											<td class="data"   width="15%">&nbsp;&nbsp;<%=slidingScaleTmplDtl.get(m+3)%></td> 
											<td class="data"   width="15%">&nbsp;&nbsp;<%=(String)drugDetails.get("ADMINUOM")%></td> 
											<td class="data"   width="25%">&nbsp;&nbsp;<%=java.net.URLDecoder.decode((String) slidingScaleTmplDtl.get(m+4),"UTF-8")%></td> 
											<td class="data" align='center' style='<%=display_auth_rule%>;'>&nbsp;</td> <!-- added for ML-MMOH-CRF-0343 -->
										</tr>
<%
									} 
%>								</table></TD></tr>
<%								}
							}
					//		if(!(dsg_reason.equals("") && dup_reason.equals("") && con_reason.equals("") && int_reason.equals("") && alg_reason.equals(""))){
								if(!dsg_reason.equals("") && !((String)drugDetails.get("LIMIT_IND")).equals("N")){
%>
									<tr>	
										<td width="5%">&nbsp;</td>
										<td class='label' width="20%"  ><b><fmt:message key="ePH.DrugDosageOverrideReason.label" bundle="${ph_labels}"/>: </b></td>
										<td class='label' colspan='7'  id='dsg_reason<%=j%>'></td>
									</tr>
									<script>
										var dsg_reason = decodeURIComponent('<%=dsg_reason%>');
										eval("document.getElementById("dsg_reason")"+'<%=j%>').innerText= dsg_reason ;
									</script>
<%
								}else{
										if(((String)drugDetails.get("LIMIT_IND")).equals("N") && !dsg_reason.equals("")){
%>
											<tr>	
												<td width="5%">&nbsp;</td>
												<td class=label width="20%" valign='TOP'><b><fmt:message key="ePH.OverDoseRemarks.label" bundle="${ph_labels}"/>:</b></td>
												<td class=label colspan='7'  id='dsg_reason<%=j%>'><%=java.net.URLDecoder.decode(dsg_reason,"UTF-8")%></td>
											</tr>
<%										}
								}
					//MMS-KH-CRF-0029 [IN070606] - start	
										if((override_yn.equals("Y") && !dup_reason.equals("") && ((String)drugDetails.get("CURRENT_RX")).equals("Y")) || (allergy_yn.equals("Y") && !alg_reason.equals("") && ((String)drugDetails.get("ALLERGY_YN")).equals("Y")) || (overdose_yn.equals("Y") && !dsg_reason.equals("") && ((String)drugDetails.get("LIMIT_IND")).equals("N")) || ((interaction_exists.equals("Y") && !interaction_remarks.equals("")) || !food_interaction_remarks.equals("") || !lab_interaction_remarks.equals("")|| !disease_interaction_remarks.equals(""))) //modified for MMS-KH-CRF-0029
										{  
											override_flag = true; //MMS-KH-CRF-0029
											System.err.println("PrescriptionPreviewOrderDrugDetails.jsp===943====>");
%>
											<tr>	
												<td width="5%" class=label>&nbsp;</td>
												<td class=label width="17%" valign='TOP'><U><b><fmt:message key="ePH.OverrideReason.label" bundle="${ph_labels}"/></b></U></td>

											</tr><br><br>
<%										} //MMS-KH-CRF-0029 [IN070606] - end
								if(!dup_reason.equals("") && !((String)drugDetails.get("CURRENT_RX")).equals("Y")){
%>
									<tr>	
										<td width="5%">&nbsp;</td>
										<td class='label' width="20%" ><b><fmt:message key="ePH.DuplicateTheraphyOverrideReason.label" bundle="${ph_labels}"/>: </b></td>
										<td class='label' colspan='7'  id='dup_reason<%=j%>'></td>
									</tr>
									<script>
										var dup_reason = decodeURIComponent('<%=dup_reason%>');
										eval("document.getElementById("dup_reason")"+'<%=j%>').innerText= dup_reason ;
									</script>
<%
								}
								else{
									if(((String)drugDetails.get("CURRENT_RX")).equals("Y") && !dup_reason.equals("")){
%>
										<tr>	
											<td width="5%">&nbsp;</td>
											<td class=label width="20%" valign='TOP'><b><fmt:message key="ePH.DuplicateRemarks.label" bundle="${ph_labels}"/>:</b></td>
											<td class=label colspan='7'  id='dup_reason<%=j%>'><%=java.net.URLDecoder.decode(
											dup_reason, "UTF-8")%></td><!--label modified for  MMS-KH-CRF-0029-->
										</tr>
<%									}
								}
								if(!con_reason.equals("")){
%>
									<tr>	
										<td width="5%">&nbsp;</td>
										<td class='label' width="20%"  ><b><fmt:message key="ePH.ContraIndicationOverrideReason.label" bundle="${ph_labels}"/>: </b></td>
										<td class='label' colspan='7'  id='con_reason<%=j%>'></td>
									</tr>
									<script>
										var con_reason = decodeURIComponent('<%=con_reason%>');
										eval("document.getElementById("con_reason")"+'<%=j%>').innerText= con_reason ;
									</script>
<%
	}
					if (!int_reason.equals("")) {
%>
									<tr>	
										<td width="5%">&nbsp;</td>
										<td class='label' width="20%"  ><b><fmt:message key="ePH.DrugInteractionOverrideReason.label" bundle="${ph_labels}"/>: </b></td>
										<td class='label' colspan='7'  id='int_reason<%=j%>'></td>
									</tr>
									<script>
										var int_reason = decodeURIComponent('<%=int_reason%>');
										eval("document.getElementById("int_reason")"+'<%=j%>').innerText= int_reason ;
									</script>
<%
								}
								if(!alg_reason.equals("") && !((String)drugDetails.get("ALLERGY_YN")).equals("Y")){
%>
									<tr>	
										<td width="5%">&nbsp;</td>
										<td class='label' width="20%"  ><b><fmt:message key="Common.AllergyOverrideReason.label" bundle="${common_labels}"/>: </b></td>
										<td class='label' colspan='7'  id='alg_reason<%=j%>'></td>
									</tr>
									<script>
										var alg_reason = decodeURIComponent('<%=alg_reason%>');
										eval("document.getElementById("alg_reason")"+'<%=j%>').innerText= alg_reason ;
									</script>
<%
								}
								else{
									if(((String)drugDetails.get("ALLERGY_YN")).equals("Y") && !alg_reason.equals("")){
%>
										<tr>	
											<td width="5%">&nbsp;</td>
											<td class=label width="20%" valign='TOP'><b><fmt:message key="ePH.AllergyRemarks.label" bundle="${ph_labels}"/>:</b></td>
											<td class=label colspan='7'  id='dup_reason<%=j%>'><%=java.net.URLDecoder.decode(alg_reason,"UTF-8")%></td>
										</tr>
<%										}
								}
							//}
					ArrayList hmDrugIntList=(ArrayList) drugDetails.get("INTERACTION_DTL"); //MMS-KH-CRF-0029 - start
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
												<td class=label width="17%" valign='TOP' nowrap><b><fmt:message key="ePH.Drug_LabInteractionRemarks.label" bundle="${common_labels}"/>&nbsp;:</b></td>
												<td class=label colspan='7'  id='interaction_remarks<%=j%>'><%=drug_lab_remarks%></td>
											</tr> <!-- added for MMS-KH-CRF-0029[IN070606] end-->
										<!--	<script>
												var interaction_remarks = decodeURIComponent('<%=interaction_remarks%>');
												eval("document.getElementById("interaction_remarks")"+'<%=j%>').innerText= interaction_remarks ;
											</script> -->
<%		
										} //MMS-KH-CRF-0029 - end
                                   if(drug_disease_display.equals("inline") && override_flag){ //modified for MMS-DM-CRF-0229
%>
											<tr>	
												<td width="5%" class=label>&nbsp;</td>
												<td class=label width="17%" valign='TOP' nowrap><b><fmt:message key="ePH.Drug-DiseaseInteractionRemarks.label" bundle="${ph_labels}"/>&nbsp;:</b></td>
												<td class=label colspan='7'  id='interaction_remarks<%=j%>'><%=drug_disease_remarks%></td>
											</tr> 
<%		
										}

					if (no_refill != null && (!no_refill.equals(""))) {
%>
								<tr><td class="data" colspan="8">&nbsp;</td></tr>
<%
								for(int p=0; p<((ArrayList)RefillDetail.get("refill_start_date")).size(); p++) { 		
%>
									<tr>
										<td width="5%" class="data"><fmt:message key="ePH.Refill.label" bundle="${ph_labels}"/></td>
										<td class="label" wrap  colspan="4"><%=tooltip%></td>
										<td class='label' style='TEXT-ALIGN:right;<%=charge_display%>'><%=tot_payable%></td>
										<td class='label' style='TEXT-ALIGN:right;<%=charge_display%>'><%=pat_payable%></td>
										<td class="label" wrap ><%=((ArrayList)RefillDetail.get("refill_start_date")).get(p)%></td>
										<td class="label" wrap ><%=((ArrayList)RefillDetail.get("refill_end_date")).get(p)%></td>
										<td class="label" align='center' style='<%=display_auth_rule%>;'> <!-- added for ML-MMOH-CRF-0349 -->
											<label id='lbl_authorize' style='<%=display_auth_rule%>;<%=color_auth_rule%>'><%=strAuthStatus%></label>
										</td>
									</tr>
<%
								} 
							}
						
						} 
						else	{	
%>
							<tr><td class="data" colspan="8">&nbsp;</td></tr>
<%
	if (freq_nature.equals("O") || freq_nature.equals("P")) {
%>
								<tr><td class="data" colspan="8" ><fmt:message key="ePH.CurrentRx.label" bundle="${ph_labels}"/></td></tr>
<%		
							}
							else{ 
%>
								<tr>
									<td width="5%" class="data"><fmt:message key="Common.Taper.label" bundle="${common_labels}"/></td>
									<td class="label" wrap   colspan="2"><%=tooltip%></td>
									<td class="label"><%=order_qty%>&nbsp;<%=order_uom1%></td>
									<td class='label' style='TEXT-ALIGN:right;<%=charge_display%>'><%=tot_payable%></td>
									<td class='label' style='TEXT-ALIGN:right;<%=charge_display%>'><%=pat_payable%></td>
									<td class="label" wrap ><%=(String)drugDetails.get("START_DATE_TIME")%></td>
									<td class="label" wrap ><%=(String)drugDetails.get("END_DATE_TIME")%></td>
									<td class="label" align='center' style='<%=display_auth_rule%>;'> <!-- added for ML-MMOH-CRF-0349 -->
										<label id='lbl_authorize' style='<%=display_auth_rule%>;<%=color_auth_rule%>'><%=strAuthStatus%></label>
									</td>
								</tr>
<%
	}
					if (!freq_str.equals("")) {
%>
								<tr>	
									<td width="5%">&nbsp;</td>
									<td colspan="8" class="label"><%=freq_str%></td>	
								</tr>
<%
	}

					if (!pres_remarks.equals("")) {
%>
								<tr>	
									<td width="5%">&nbsp;</td>
									<td width='20%' class='label'  ><b><fmt:message key="ePH.DrugRemarks.label" bundle="${ph_labels}"/>: </b></td>
									<td colspan="7" class="label"><%=pres_remarks%></td>	
								</tr>
<%
							}		
							if(!PRN_remarks_dtl.equals("")&&(freq_nature.equals("P"))){ 
%>
								<tr>	
									<td width="5%">&nbsp;</td>
									<td width='20%' class='label'  ><b><fmt:message key="ePH.PRNRemarks.label" bundle="${ph_labels}"/>: </b></td>
									<td class='label' colspan='7'  id='prn_remarks<%=j%><%=k%>'></td>
								</tr>
								<script>
									var PRN_remarks = decodeURIComponent('<%=PRN_remarks_dtl%>');
									eval("document.getElementById("prn_remarks")"+'<%=j%>'+'<%=k%>').innerText= PRN_remarks ;
								</script>
<%						}
						//	if(!(dsg_reason.equals("") && dup_reason.equals("") && con_reason.equals("") && int_reason.equals("") && alg_reason.equals(""))){
								if(!dsg_reason.equals("")){
%>
									<tr>	
										<td width="5%">&nbsp;</td>
										<td class='label' width="20%"  ><b><fmt:message key="ePH.DrugDosageOverrideReason.label" bundle="${ph_labels}"/>: </b></td>
										<td class='label' colspan='7'  id='dsg_reason<%=j%><%=k%>'></td>
									</tr>
									<script>
										var dsg_reason = decodeURIComponent('<%=dsg_reason%>');
										eval("document.getElementById("dsg_reason")"+'<%=j%><%=k%>').innerText= dsg_reason ;
									</script>
<%
	}
					if (!dup_reason.equals("")) {
%>
									<tr>	
										<td width="5%">&nbsp;</td>
										<td class='label' width="20%"  ><b><fmt:message key="ePH.DuplicateTheraphyOverrideReason.label" bundle="${ph_labels}"/>: </b></td>
										<td class='label' colspan='7'  id='dup_reason<%=j%><%=k%>'></td>
									</tr>
									<script>
										var dup_reason = decodeURIComponent('<%=dup_reason%>');
										eval("document.getElementById("dup_reason")"+'<%=j%><%=k%>').innerText= dup_reason ;
									</script>
<%
	}
					if (!con_reason.equals("")) {
%>
									<tr>	
										<td width="5%">&nbsp;</td>
										<td class='label' width="20%"  ><b><fmt:message key="ePH.ContraIndicationOverrideReason.label" bundle="${ph_labels}"/>: </b></td>
										<td class='label' colspan='7'  id='con_reason<%=j%><%=k%>'></td>
									</tr>
									<script>
										var con_reason = decodeURIComponent('<%=con_reason%>');
										eval("document.getElementById("con_reason")"+'<%=j%><%=k%>').innerText= con_reason ;
									</script>

<%
	}
					if (!int_reason.equals("")) {
%>
									<tr>	
										<td width="5%">&nbsp;</td>
										<td class='label' width="20%"  ><b><fmt:message key="ePH.DrugInteractionOverrideReason.label" bundle="${ph_labels}"/>: </b></td>
										<td class='label' colspan='7'  id='int_reason<%=j%><%=k%>>'></td>
									</tr>
									<script>
										var int_reason = decodeURIComponent('<%=int_reason%>');
										eval("document.getElementById("int_reason")"+'<%=j%><%=k%>').innerText= int_reason ;
									</script>

<%
	}
					if (!alg_reason.equals("")) {
%>
									<tr>	
										<td width="5%">&nbsp;</td>
										<td class='label' width="20%"  ><b><fmt:message key="Common.AllergyOverrideReason.label" bundle="${common_labels}"/>: </b></td>
										<td class='label' colspan='7'  id='alg_reason<%=j%><%=k%>'></td>
									</tr>
									<script>
										var alg_reason = decodeURIComponent('<%=alg_reason%>');
										eval("document.getElementById("alg_reason")"+'<%=j%><%=k%>').innerText= alg_reason ;
									</script>

<%
	}
					//	}
				}
				k++;
			}
			if ((i != (grp.size()) - 1))
%>
					<tr>
						<td class="white"></td></tr><tr><td class="white"></td>
					</tr>	
<%
		}
			String clinical_comments = bean.getPresRemarks();
			if (clinical_comments != null && !clinical_comments.equals("")) {
	%>
					<tr>
						<td class="white"></td></tr><tr><td class="white"></td>
					</tr>
					<tr>
						<td class="white"></td></tr><tr><td class="white"></td>
					</tr>
					<tr>
						<td width="5%" colspan="2" class="data"><fmt:message key="ePH.PrescriptionRemarks.label" bundle="${ph_labels}"/>:&nbsp;&nbsp;</td>
						<td colspan="5" class="label">&nbsp;&nbsp;<%=clinical_comments%></td>	
					</tr>
<%
				}
				if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
					DecimalFormat dfTest = new DecimalFormat(decimalFormatString);
					//charge_amt = Double.parseDouble(patient_payable_amt)+"";
					tot_payable_sum_str = dfTest.format(tot_payable_sum);
					pat_payable_sum_str = dfTest.format(pat_payable_sum);

%>
					<tr><td class="white"></td></tr>	
					<tr>
						<td colspan='4' class='data' align='right'><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
						<td class='data' align='right'><%=tot_payable_sum_str%>&nbsp;&nbsp;</td>
						<td class='data' align='right'><%=pat_payable_sum_str%>&nbsp;&nbsp;</td>
						<td colspan='2'>&nbsp;</td>
					</tr>
<%
	}
%>
				</table>
<%
	}
%>
		</form>
<%
	putObjectInBean(bean_id, bean, request);
	putObjectInBean(or_bean_id, orbean, request);
	putObjectInBean(presBean_id, presBean, request);
%>
	</body>
</html>

