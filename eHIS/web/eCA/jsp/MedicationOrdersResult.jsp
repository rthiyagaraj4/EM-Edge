<!DOCTYPE html>
 <%
/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------

05/08/2020  IN072762    chandrashekar                                   MO-CRF-20101.11
---------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes st art --%>  
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eCA.*, eCA.Common.*, eCommon.Common.*,java.text.DecimalFormat,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
 
<html>
	<head>
		<title></title>
<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String locale			= (String)session.getAttribute("LOCALE");
		String facility_id					= (String) session.getValue("facility_id");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCA/js/MedicationOrders.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
		<script type="text/javascript">
			function initScroll() {
				var rightDivSize = document.body.offsetWidth-371;
				var leftDiv = document.getElementById('table_container_left');
				var rightDiv = document.getElementById('table_container_right');
				if(rightDiv!=undefined && leftDiv!=undefined && rightDivSize!=-371){
					rightDiv.style.width=rightDivSize+'px';
					rightDiv.onscroll = function() {
						leftDiv.scrollTop = this.scrollTop;
						leftDiv.scrollTop = this.scrollTop;
					};
				}
			}
			
			function tableresize()
			{	
				if(document.getElementById('table_container_left_1')){
				var rows = document.getElementById('table_container_left_1').getElementsByTagName("tr").length;
				var tbl = document.getElementById('table_container_left_1').rows;
				var x=document.getElementById('table_container_right_1').rows;
				var rows1 = document.getElementById('table_container_right_1').getElementsByTagName("tr").length;
			for(var i=0;i<rows;i++){
				if(tbl[i].offsetHeight>x[i].offsetHeight){
				document.getElementById("table_container_right_1").rows[i].style.height =tbl[i].offsetHeight+"px" ;
				}else
				if(tbl[i].offsetHeight<x[i].offsetHeight){
			document.getElementById("table_container_left_1").rows[i].style.height =x[i].offsetHeight+"px" ;
			}
			} 
			}
			}
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="initScroll();tableresize();" onresize="initScroll();tableresize();">
<%
		
		String patient_id	= request.getParameter("patient_id") ==null?"":request.getParameter("patient_id");
		String dt_from		= request.getParameter("from_date")==null?"":request.getParameter("from_date");
		String dt_to		= request.getParameter("to_date")==null?"":request.getParameter("to_date");
		String generic_id	= request.getParameter("generic_id")==null?"":request.getParameter("generic_id");
		String drug_code	= request.getParameter("drug_id")==null?"":request.getParameter("drug_id");
		String pat_class	= request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
		String status		= request.getParameter("status")==null?"":request.getParameter("status");
		String encounter_id	    =	request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String req_facility_id		=	request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
		String pract_id		=	request.getParameter("pract_id")==null?"":request.getParameter("pract_id");
		String selTab		=	request.getParameter("selTab")==null?"":request.getParameter("selTab");
		String order_type		=	request.getParameter("order_type")==null?"":request.getParameter("order_type");
		String date_order		=	request.getParameter("date_order")==null?"":request.getParameter("date_order");

		if(date_order.equals(""))
		    date_order ="D";
		
		String date_append ="";
		String ret_uom1		=	"";
		String ret_uom2		=	"";
		String reissue_uom1		=	"";
		String reissue_uom2		=	"";
		String heightpx		=	"";
		String scroll		=	"scroll";
		String scroll_id ="";
		String	bean_id			=	"MedicationOrdersBean" ;
		String	bean_name		=	"ePH.MedicationOrdersBean";

		MedicationOrdersBean bean = (MedicationOrdersBean)getBeanObject( bean_id,bean_name, request) ;
		bean.setLanguageId(locale);
		
		HashMap disc_cancel         = new HashMap();
		String discontinued_link_yn = "N";
		String cancel_link_yn       = "N";
		String disc_cancel_style	= "";
		String on_click				= "";
		String pres_disp_unit_value		= "";
		String dispnsd_disp_unit_value	= "";
		String disp_stock_uom			= "";
		String dosage_type				= "";
		String admin_dose_chng_reason_cnt  = "";
		String dosage_uom_desc             = "" ;
		String linkYN                      ="";
		bean.setNoOfDecimals();
		int noOfDecimals = bean.getNoOfDecimals();
		String alt_drug_remarks_ind = bean.getAltDrugRemarksInd();
		 Connection con				= null;
		 con						= ConnectionManager.getConnection(request);
		boolean site = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","TRANSCRIBED_BY");//Added for ML-MMOH-CRF-0510[IN060510] END
		boolean display_transfer_locn= eCommon.Common.CommonBean.isSiteSpecific(con, "PH","PATIENT_TRANSFER_LOCN_UPD");//SKR-SCF-1239
		boolean siteOrder = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","ORDER_LOCATION"); /* Added for ML-MMOH-CRF-0532 [IN061327]  */
		String decimalStringFormat = "#.";
		if(noOfDecimals == 0) 
			decimalStringFormat = "#.#"; 
		for (int i=0;i<noOfDecimals;i++){
			decimalStringFormat = decimalStringFormat+"#";
		}
		int len=0, point=0;
		String temp="";
		DecimalFormat dfToInteger = new DecimalFormat(decimalStringFormat);	

		boolean searched	= request.getParameter( "searched" ) == null ? false : true  ;
		try{
			String classvalue			=	"";
			patient_id	 = CommonBean.checkForNull( patient_id );
			dt_from		 = CommonBean.checkForNull( dt_from);
			dt_to		 = CommonBean.checkForNull( dt_to );
			generic_id	 = CommonBean.checkForNull( generic_id );
			drug_code	 = CommonBean.checkForNull( drug_code );
			pat_class	 = CommonBean.checkForNull( pat_class );
			ArrayList result=bean.getDrugDetails(con,locale,patient_id,encounter_id,pract_id,dt_from,dt_to,selTab,pat_class,req_facility_id,status,drug_code,generic_id,"D",  order_type,date_order,site,display_transfer_locn,siteOrder);
			if(result.size()>0){

				//Retriving the records from result arraylist
				StringBuffer title_buffer	= new StringBuffer();
				ArrayList records	=new ArrayList();
				String ht_wt_title	=	"";

				String order_line_no	=	"";
				String line_iv_prep_yn	=	"";
				String dtls				=	"";
				String discharge_med	=	"";
				String pres_qty			=	"";
				String disp_qty			=	"";
				String ret_qty			=	"";
				String disp_uom			=	"";
				String stock_uom        =   "";
				String ret_uom			=	"";
				String ret_date			=	"";
				String disp_drugs		=	"";
				String tot_admin_qty	=	"";
				String admin_uom		=	"";
				String ret_diff			=	"";
				String line_status		=	"";
				String child_order		=	"";
				String reissue_qty		=	"";
				String classVal			=	"";
				String pres_uom			=	"";
				String patient_class	=	"";
				String reissue_uom		=	"";
				String strength_per_pres_uom = "";
				String content_in_pres_base_uom = "";
				String reissue_date_time = "";
				String line_status_text			= "";
				String strIVPrepYN = "";
				String drug_status = "";
				String order_id    = "";	
				String order_line_num	= "";
				String sr_no			= "";
				String future_yn		=	"";
				String expiry_yn		=	"";
				String formulary_item_yn		=	"";
				String sliding_scale_yn		=	"";
				String alternates		= "N";
				String freq_nature		= "";
				String route_color="";   // Coded Added For CRF 0034
				String pres_base_uom = ""; //Added for ML-BRU-SCF-1190 [IN:045647]
				String home_leave_medn_yn = "";//Added for Bru-HIMS-CRF-093-DD1[IN047223]
				String ref_sent_remarks="";//Added for HSA-CRF-0155 [IN048487]
				String amended_by_id ="";   /* code Added for ML-BRU-SCF-0098 [IN031837] -- Start*/	
				String amend_reason ="";  
				String amend_reason_code ="";  
				String amended_date ="";  	/*code Added for ML-BRU-SCF-0098 [IN031837] -- End*/	
				String disc_cancelled_orders = "", disc_cancelled_orders_display="display:none", last_dispensed_date=""; //Added for HSA-CRF-0138 [IN:048414]

				String strength_value =""; // Added for IN-30262
				String alt_drug_remarks ="", stkey; // Added for Bru-HIMS-CRF-082 [IN:029948]
				String pregnancy_override_reason =""; // Added for RUT-CRF-0063 [IN:029601]
				String complete_reason 		= null;//Added for MMS-SCF-0196
				String allocate_remarks_code="", allocate_finding = "", fill_remarks_code="", fill_finding = "", delivery_remarks_code="", delivery_finding= "", verify_remarks="";//Code added for ML-BRU-SCF-0971[IN042220]
				String dispense_count ="";
				String order_qty="";//Added for ARYU-SCF-0034
				
				    heightpx="380px";
				
%>
				<div id='table_container_left' style='overflow:hidden;width:360px;height:<%=heightpx%>;position:relative;float:left;' >   <!-- local:360px and main:225px FOr BSP-SCF-0037 -->
					<table   border="1" cellpadding="0" cellspacing="0" align="left" id='table_container_left_1'>
						<tr style='height:40px;' style='position:relative' style='top:expression(this.offsetParent.scrollTop-2)'>
							<td class='COLUMNHEADER' style="border:none">&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td class='COLUMNHEADER' nowrap><fmt:message key="ePH.Prescribed/DispensedDrug.label" bundle="${ph_labels}"/></td>   <!--nowrap Added for IN:063627 --><!--nowrap Added for BSP-SCF-0037 --><!--nowrap Added for BSP-SCF-0042 -->
							<td class='COLUMNHEADER' ><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></td>
						</tr>
<%
						for(int recCount=0; recCount<result.size(); recCount++) {
							strIVPrepYN		=	"";       
							drug_status		=	"";       
							order_id		=	"";	   
							order_line_num	=	"";  
							sr_no			=	"";  
							future_yn		=	"";
							expiry_yn		=	"";
							//freq_nature		=	"";
							ht_wt_title		=	"";
							if ( recCount % 2 == 0 )
								classvalue = "QRYODD" ;
							else
								classvalue = "QRYEVEN" ;

							records=(ArrayList) result.get( recCount );
							for(int colCount=0; colCount<records.size(); colCount++){
								title_buffer	= new StringBuffer();
								if(records.get(19)!=null) {
									title_buffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.height.label","common_labels"));
									title_buffer.append(":");
									title_buffer.append(CommonBean.checkForNull((String)records.get(19)));
									title_buffer.append("; ");
									title_buffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.weight.label","common_labels"));
									title_buffer.append(":");
									title_buffer.append(CommonBean.checkForNull((String)records.get(21)));
									title_buffer.append("; ");
									title_buffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BSA.label","common_labels"));
									title_buffer.append(":");
									title_buffer.append(CommonBean.checkForNull((String)records.get(23)));
									title_buffer.append("; ");
									title_buffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BMI.label","common_labels"));
									title_buffer.append(":");
									title_buffer.append(CommonBean.checkForNull((String)records.get(38)));
								}	
								// Added Newly for the KAUH-SCF-049[Inc:33575] Start
								pres_qty		= CommonBean.checkForNull((String)records.get(27));
								if(pres_qty!=null && !pres_qty.equals(""))
									pres_qty = dfToInteger.format(Double.parseDouble(pres_qty));
								disp_qty		= CommonBean.checkForNull((String)records.get(28));
								if(disp_qty!=null && !disp_qty.equals(""))
									disp_qty = dfToInteger.format(Double.parseDouble(disp_qty));
								ret_qty			= CommonBean.checkForNull((String)records.get(29));
								if(ret_qty!=null && !ret_qty.equals(""))
									ret_qty = dfToInteger.format(Double.parseDouble(ret_qty));

								ret_date		= CommonBean.checkForNull((String)records.get(30));
								line_status				= CommonBean.checkForNull((String)records.get(35));
								disp_drugs				= CommonBean.checkForNull((String)records.get(32));
								/*if(!ret_date.equals("") && ret_qty.equals(pres_qty)){
									line_status_text = "Return-Medication";
								}
								else{*/
								line_status_text = CommonBean.checkForNull((String)records.get(44));
								//}
								//Added Newly for the KAUH-SCF-049[Inc:33575] End
								formulary_item_yn		= CommonBean.checkForNull((String)records.get(45));
								child_order				= CommonBean.checkForNull((String)records.get(36));
								discharge_med			= CommonBean.checkForNull((String)records.get(25));
								route_color				= CommonBean.checkForNull((String)records.get(58));//Code added for CRF 0034
								
								amended_by_id			= CommonBean.checkForNull((String)records.get(59));/*below code Added for ML-BRU-SCF-0098 [IN031837] -- Start*/
								amend_reason			= CommonBean.checkForNull((String)records.get(60));
								amend_reason_code		= CommonBean.checkForNull((String)records.get(61));
								amended_date			= CommonBean.checkForNull((String)records.get(62));/*Above code Added for ML-BRU-SCF-0098 [IN031837] -- End*/
							   							   						   
							   	complete_reason 		= CommonBean.checkForNull((String)records.get(50));//Added for MMS-SCF-0196
							   	home_leave_medn_yn = CommonBean.checkForNull((String)records.get(74));//Added for Bru-HIMS-CRF-093-DD1[IN047223]
							   	disc_cancelled_orders = CommonBean.checkForNull((String)records.get(76));//Added for HSA-CRF-0138 [IN:048414] - start
							   	last_dispensed_date = CommonBean.checkForNull((String)records.get(77));//Added for HSA-CRF-0138 [IN:048414] - start
								scroll_id =CommonBean.checkForNull((String)records.get(9));
								if(!disc_cancelled_orders.equals("") && last_dispensed_date.equals(""))
									disc_cancelled_orders_display="display";
								else
									disc_cancelled_orders_display="display:none";
								if (colCount>18)
									continue;
								if (colCount ==0 || colCount==1){
									strIVPrepYN =(String)records.get( 0 );
									if (colCount==0){						
										continue;
									}
									else{
										if (strIVPrepYN.equals("N")){
											linkYN = "N";
										}
										else if (strIVPrepYN.equals("Y")&&(records.get( 1 ) != null)){
											linkYN = "Y";
										}
									}
								}
								else if (colCount == 3){
									drug_status = "";
									disc_cancel = bean.isCancelDiscontinuedApplicable((String)records.get( 15 ),(String)records.get( 16 ));	
									cancel_link_yn       = (String)disc_cancel.get("CANCEL");
									future_yn	=	bean.compareDate((String)records.get(9));
									expiry_yn	=	bean.compareDate((String)records.get(10));
									patient_class	= CommonBean.checkForNull((String)records.get(11));
									disp_qty		= CommonBean.checkForNull((String)records.get(28));
									if(!ret_qty.equals("") ){
										if (line_status.equals("DC"))
											drug_status = "#C40062";
										//else if(expiry_yn.equals("N"))
										//	drug_status = "#FFB66C";
										else
											drug_status = "#FFB66C";
											//DD AND DE added for mms-kh-crf-0014
										if((status.equals("A") || status.equals("*A")) && (line_status.equals("DP") || line_status.equals("DF") || line_status.equals("DD") || line_status.equals("DE")) && (future_yn.equals("N")) && !expiry_yn.equals("N")){
											classVal	= "ACTIVE";
										}
										else{
											if(future_yn.equals("Y")) 
												classVal	= "FUTURE_Rx";
											else if(expiry_yn.equals("N")){
												classVal	= "EXPIRED_MEDICATION";
											}
											else if (line_status.equals("CN"))
												classVal	= "CANCEL";
											else if (line_status.equals("DC"))
												classVal	= "DIS-CONTINUED";
											else if(discharge_med.equals("D"))
												classVal="DISCHARGEMED1";
											else if (line_status.equals("HD") || line_status.equals("HC"))
												classVal	= "HOLD";
											else
												classVal	= "ACTIVE";
												//classVal	= "ReturnedMedication";	
										}
									}
									else if (line_status.equals("CN")){
										drug_status = "#990000";
										if(expiry_yn.equals("N"))
											classVal	= "EXPIRED_MEDICATION";
										else
											classVal	= "CANCEL";
									}
									else if (line_status.equals("DC")){
										drug_status = "#C40062";
										if(expiry_yn.equals("N"))
											classVal	= "EXPIRED_MEDICATION";
										else
											classVal	= "DIS-CONTINUED";
									}
									//DD AND DE added for mms-kh-crf-0014
									else if( ((((String)records.get( colCount )).trim()).equals("ACTIVE")) || ((patient_class.equals("IP") || patient_class.equals("DC")) && (line_status.equals("OS") || line_status.equals("RG") || line_status.equals("IP") || line_status.equals("VF")) ) || ((patient_class.equals("OP") || patient_class.equals("EM")) && (line_status.equals("OS") || line_status.equals("RG") || line_status.equals("IP") || line_status.equals("VF") || line_status.equals("DP") || line_status.equals("DF")|| line_status.equals("DD") || line_status.equals("DE")) )){
										//(line_status.equals("DP") || line_status.equals("DF") )

										if(future_yn.equals("Y")) { 
											drug_status = "#99FFCC";
											classVal	= "FUTURE_Rx";
										}
										else{
											drug_status = "#FF5E5E";
											if(expiry_yn.equals("N")){
												drug_status = "#D9B86C";
												classVal	= "EXPIRED_MEDICATION";
											}
											else {
												if(discharge_med.equals("D")){
													drug_status = "#FF9DFF"; // #D9B86C changed to #FF9DFF for ML-BRU-SCF-0941.1 [IN:045176]
													classVal="DISCHARGEMED1";
												}
												else 
													classVal	= "ACTIVE";
											}
											// for outpatient active orders, who are not yet dispensed.
											if((patient_class.equals("OP") || patient_class.equals("EM")) && disp_qty.equals("") && complete_reason.equals("")){
												drug_status = "#8204FF";
											}
										}
									}
									else if(child_order.equals("Y")){
										drug_status = "#B6BC8B";
										if(future_yn.equals("Y")) 
											classVal	= "FUTURE_Rx";
										else
											classVal	= "Refill_Rx";
									}
									else if(future_yn.equals("Y")) { 
										drug_status = "#99FFCC";
										classVal	= "FUTURE_Rx";						
									}
									else if(cancel_link_yn.equals("Y") || (line_status.equals("IP") || line_status.equals("PO") || line_status.equals("PS") || line_status.equals("AL") || line_status.equals("VF")) || (disp_qty.equals("") && !tot_admin_qty.equals("") && complete_reason.equals("")) )  {
										drug_status = "#8204FF";
										if(expiry_yn.equals("N"))
											classVal	= "EXPIRED_MEDICATION";
										else
											classVal	= "YET_TO_BE_DISPENSED";
									}
									else if (line_status.equals("HD") || line_status.equals("HC")){
										if(expiry_yn.equals("N"))
											drug_status = "#D9B86C";
										else
											drug_status = "#F0F000";
										classVal	= "HOLD";
									}
									else if ((((String)records.get( colCount )).trim()).equals("INACTIVE")&&line_status.equals("DF")){
										classVal	= "ACTIVE";
										drug_status = "#FF5E5E";
										//Added Code for Checking Expired Drugs  on 5/Oct/2010 For the incident num:24069 ---By Sandhya
										if(expiry_yn.equals("N")){
											drug_status = "#D9B86C";
											classVal	= "EXPIRED_MEDICATION";
										} //Ends
									}
									else if(expiry_yn.equals("N")){
										drug_status = "#D9B86C";										
										classVal	= "EXPIRED_MEDICATION";
									}
									else {
										drug_status = "";
										classVal	= classvalue;
									}

									if(line_status.equals("PO") || line_status.equals("PS")){
										title_buffer.append(" / ");
										title_buffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PndngFrAppr.label","ph_labels"));
									}
									ht_wt_title = title_buffer.toString();
									if(line_iv_prep_yn.equals("1") || line_iv_prep_yn.equals("2") || line_iv_prep_yn.equals("3") || line_iv_prep_yn.equals("4") || line_iv_prep_yn.equals("5")){
										if(order_line_no.equals("1"))
											drug_status="#478F8F";
										else
											drug_status="#92C9C9";
									}

									if((status.equals("C") || status.equals("*A")) && ((patient_class.equals("OP") || patient_class.equals("EM")) && (line_status.equals("DP") || line_status.equals("DF") ||line_status.equals("DD")|| line_status.equals("DE")) ) && expiry_yn.equals("N")){
										if(ret_qty.equals("") )
											drug_status="#D9B86C";
										classVal	= "EXPIRED_MEDICATION";
									}

									if(status.equals("C") && ((patient_class.equals("OP") || patient_class.equals("EM")) && line_status.equals("OS") ) && child_order.equals("Y") && ret_qty.equals("")){
										drug_status="#D9B86C";
									}

									if(line_status.equals("PO"))
										drug_status="#0099FF";
									else if(line_status.equals("PC"))
										drug_status="#33CC99";
									else if(line_status.equals("PS"))
										drug_status="#C48400";
									if(home_leave_medn_yn.equalsIgnoreCase("Y"))//Added for Bru-HIMS-CRF-093-DD1[IN047223]
										drug_status = "#959500";
									if(formulary_item_yn.equals("N")){
%>          
										<tr style='height:50px;' id ='<%=scroll_id%>'>
											<td  style="background-color:#FF9999" title="<%=ht_wt_title%>" >&nbsp;&nbsp;</td>
<%
									}
									else{
%>          
										<tr style='height:50px;' id ='<%=scroll_id%>'>
											<td  style="background-color:<%=drug_status%>" title="<%=ht_wt_title%>" >&nbsp;&nbsp;</td>
<%
									}
								}
								if(line_status.equals("PO") || line_status.equals("PS")){
									title_buffer.append(" / ");
									title_buffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PndngFrAppr.label","ph_labels"));
								}
								ht_wt_title = title_buffer.toString();
								if (colCount==5){
									if(linkYN.equals("Y")){
										order_id=(String)records.get( 15 );
%>
										<td class="<%=classVal%>" title="<%=ht_wt_title%>" ><font class="hyperlink" style="cursor:pointer;" onClick="showMedicationDetails('<%=order_id%>')"><%=(String)records.get( colCount )%></font>
										<label id='lblDiscCancelledOrders_<%=recCount%>' style='cursor:pointer;<%=disc_cancelled_orders_display%>' title='<fmt:message key="ePH.DiscCancelDrugDtls.label" bundle="${ph_labels}"/>'>&nbsp;&nbsp;<img id='discCancelledOrders_<%=recCount%>' src="../../ePH/images/DiscCancelledIndicator.png" onclick='callDiscCancelledOrders("<%=disc_cancelled_orders%>", "<%=java.net.URLEncoder.encode((String)records.get( colCount ),"UTF-8")%>");'  ></label>
										<br><label style="color:brown"><%=disp_drugs%></label></td>
<% 
									}
									else{
										if (classVal.equals("FUTURE_Rx")|| classVal.equals("EXPIRED_MEDICATION")|| classVal.equals("HOLD") || classVal.equals("DISCHARGEMED1") || drug_status.equals("")||line_status.equals("PC") || drug_status.equals("#959500")){ // drug_status.equals("#959500") Added for ML-BRU-SCF-1877 
%>
											<td class="<%=classVal%>"  title="<%=ht_wt_title%>"><font color='black'><%=(String)records.get( colCount )%></font><label id='lblDiscCancelledOrders_<%=recCount%>' style='cursor:pointer;<%=disc_cancelled_orders_display%>'  title='<fmt:message key="ePH.DiscCancelDrugDtls.label" bundle="${ph_labels}"/>'>&nbsp;&nbsp;<img id='discCancelledOrders_<%=recCount%>' src="../../ePH/images/DiscCancelledIndicator.png" onclick='callDiscCancelledOrders("<%=disc_cancelled_orders%>", "<%=java.net.URLEncoder.encode((String)records.get( colCount ),"UTF-8")%>");'></label>
											<br><label style="color:green"><%=disp_drugs%></label></td>
<%
										}
										else { 
%>
											<td class="<%=classVal%>"  title="<%=ht_wt_title%>"><font color='white'><%=(String)records.get( colCount )%></font><label id='lblDiscCancelledOrders_<%=recCount%>' style='cursor:pointer;<%=disc_cancelled_orders_display%>'  title='<fmt:message key="ePH.DiscCancelDrugDtls.label" bundle="${ph_labels}"/>'>&nbsp;&nbsp;<img id='discCancelledOrders_<%=recCount%>' src="../../ePH/images/DiscCancelledIndicator.png" onclick='callDiscCancelledOrders("<%=disc_cancelled_orders%>", "<%=java.net.URLEncoder.encode((String)records.get( colCount ),"UTF-8")%>");'></label>
											<br><label style="color:Green"><%=disp_drugs%></label> </td>
<% 
										}
									}
								}
								title_buffer	= null;
								if (colCount==18){ ////added 18 for AAKH-CRF-0088 [IN:060357]  %>
									
									<td width="111px" class="<%=classvalue%>" title="<%=ht_wt_title%>"><%=(String)records.get( 79 )%>&nbsp;</td>
<%								}
							}
							
%>
							</tr>
<%
						}
%>
					</table>
				</div>
<%
				
				
				    heightpx="400px";
				
%>
				<div id='table_container_right' style='overflow:<%=scroll%>;height:<%=heightpx%>;position:relative;float:right;' ><!--  Modified for Bru-HIMS-CRF-081 -->
					<table   border="1" cellpadding="0" cellspacing="0" align="left" id='table_container_right_1' >
						<tr style='height:40px;' style='position:relative' style='top:expression(this.offsetParent.scrollTop-2)'>
							<td class='COLUMNHEADER' style='width:0px;border-right:0' ></td>
							<td class='COLUMNHEADER' nowrap style='border-left:0'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.status.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td class='COLUMNHEADER' nowrap><fmt:message key="Common.Route.label" bundle="${common_labels}"/></td>
							<td class='COLUMNHEADER' nowrap><fmt:message key="ePH.DosageDetail.label" bundle="${ph_labels}"/></td>
							<td class='COLUMNHEADER' nowrap>&nbsp;&nbsp;<fmt:message key="Common.StartDate.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
							<td class='COLUMNHEADER' nowrap>&nbsp;&nbsp;<fmt:message key="Common.enddate.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
							<td class='COLUMNHEADER' nowrap>&nbsp;&nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
							<td class='COLUMNHEADER' nowrap><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
							
							<td class='COLUMNHEADER' colspan=2 >
								<table   border="1" cellpadding="0" cellspacing="0"  >
									<tr style='height:14px;'>
										<td class='COLUMNHEADER' colspan=2 nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.PrescribedQuantity.label" bundle="${ph_labels}"/>
										</td>
									</tr>
									<tr style='height:1px;'></tr>
									<tr style='height:14px;'>
										<td class='COLUMNHEADER' nowrap width='50%'>&nbsp;<fmt:message key="ePH.PrescribingUnit.label" bundle="${ph_labels}"/>&nbsp;</td>
										<td class='COLUMNHEADER' nowrap width='50%'>&nbsp;<fmt:message key="ePH.DispensingUnit.label" bundle="${ph_labels}"/>&nbsp;</td>
									</tr>
								</table>
							</td>
							<td class='COLUMNHEADER' colspan=2 >
								<table   border="1" cellpadding="0" cellspacing="0" >
									<tr style='height:14px;'>
										<td class='COLUMNHEADER' colspan=2 nowrap>&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.DispenseQuantity.label" bundle="${ph_labels}"/>
										</td>
									</tr>
									<tr style='height:1px;'></tr>
									<tr style='height:14px;'>
										<td class='COLUMNHEADER' nowrap width='50%'>&nbsp;<fmt:message key="ePH.PrescribingUnit.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
										<td class='COLUMNHEADER' nowrap width='50%'><fmt:message key="ePH.DispensingUnit.label" bundle="${ph_labels}"/>&nbsp;</td>
									</tr>
								</table>
							</td>

							<td class='COLUMNHEADER' nowrap ><fmt:message key="ePH.ReturnQuantity/Date.label" bundle="${ph_labels}"/></td>							
								<!-- PrescribedQuantity added for mms-kh-crf-0014 -->
							<td class='COLUMNHEADER' nowrap><fmt:message key="ePH.AdminQuantity.label" bundle="${ph_labels}"/> / <fmt:message key="ePH.PrescribedQuantity.label" bundle="${ph_labels}"/></td>
							<td class='COLUMNHEADER' nowrap><fmt:message key="ePH.ReissuedQuantity.label" bundle="${ph_labels}"/></td>
							<% //Added for ml-mmoh-crf-0510 start  [IN060510]
							if(site){
								%>
							
<!-- 							<td class='COLUMNHEADER'></td> -->
							
							<%	} else{
								%>					
					       <td class='COLUMNHEADER' nowrap><fmt:message key="Common.PrescribedBy.label" bundle="${common_labels}"/></td>
						<%	} ////Added for ml-mmoh-crf-0510 end  [IN060510] %>
							<td class='COLUMNHEADER' nowrap><fmt:message key="Common.OrderingLocation.label" bundle="${common_labels}"/>/ <fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></td>
							<td class='COLUMNHEADER' nowrap><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
<%-- 							<td class='COLUMNHEADER' nowrap><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></td> --%>
							<%// Added for ml-mmoh-crf-0510 start  [IN060510]
							if(site){
								
								 %>
							<td class='COLUMNHEADER' nowrap><fmt:message key="Common.PrescribedBy.label" bundle="${common_labels}"/></td>
							<th class='COLUMNHEADER' nowrap><fmt:message key="Common.Transcribed.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.by.label" bundle="${common_labels}"/></th>
						<%	} // Added for ml-mmoh-crf-0510 end [IN060510] %>
						</tr>
<%
						String backgrndColor=""; 
						String fntColor="";
						StringTokenizer st = null;
						for(int recCount=0; recCount<result.size(); recCount++){
							strIVPrepYN				= "";       
							drug_status				= "";       
							order_id				= "";	   
							order_line_num			= "";  
							sr_no					= "";  
							future_yn				= "";
							expiry_yn				= "";
							pres_disp_unit_value	= "";
							dispnsd_disp_unit_value	= "";
							disp_stock_uom			= "";
							alternates				= "N";
							freq_nature				= "";
							dosage_uom_desc         = "";
							fntColor = "";
							backgrndColor = "";

							if ( recCount % 2 == 0 )
								classvalue = "QRYODD" ;
							else
								classvalue = "QRYEVEN" ;

							records=(ArrayList) result.get( recCount );

							ht_wt_title		= "";
							title_buffer	= new StringBuffer(); 
							if(records.get(19)!=null) {
								title_buffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.height.label","common_labels"));
								title_buffer.append(":");
								title_buffer.append(CommonBean.checkForNull((String)records.get(19)));
								title_buffer.append("; ");
								title_buffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.weight.label","common_labels"));
								title_buffer.append(":");
								title_buffer.append(CommonBean.checkForNull((String)records.get(21)));
								title_buffer.append("; ");
								title_buffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BSA.label","common_labels"));
								title_buffer.append(":");
								title_buffer.append(CommonBean.checkForNull((String)records.get(23)));
								title_buffer.append("; ");
								title_buffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BMI.label","common_labels"));
								title_buffer.append(":");
								title_buffer.append(CommonBean.checkForNull((String)records.get(38)));
							}	
		
							line_iv_prep_yn	= CommonBean.checkForNull((String)records.get(24));
							order_line_no	= CommonBean.checkForNull((String)records.get(16));
							discharge_med	= CommonBean.checkForNull((String)records.get(25));
							
							pres_qty		= CommonBean.checkForNull((String)records.get(27));
							disp_qty		= CommonBean.checkForNull((String)records.get(28));
							
							if(disp_qty!=null && !disp_qty.equals(""))
								disp_qty = dfToInteger.format(Double.parseDouble(disp_qty));
								
							ret_qty			= CommonBean.checkForNull((String)records.get(29));
							if(ret_qty!=null && !ret_qty.equals(""))
								ret_qty = dfToInteger.format(Double.parseDouble(ret_qty));

							ret_date		= CommonBean.checkForNull((String)records.get(30));
							stock_uom       = CommonBean.checkForNull((String)records.get(31));
							disp_drugs		= CommonBean.checkForNull((String)records.get(32));
							tot_admin_qty	= CommonBean.checkForNull((String)records.get(33));
							ret_diff		= CommonBean.checkForNull((String)records.get(34));
							line_status		= CommonBean.checkForNull((String)records.get(35));
							child_order		= CommonBean.checkForNull((String)records.get(36));
							admin_uom		= CommonBean.checkForNull((String)records.get(37));//DOSAGE_UOM_CODE
							reissue_qty	    = CommonBean.checkForNull((String)records.get(39));
							pres_uom		= CommonBean.checkForNull((String)records.get(40));//PRESCRIBED_UOM
							patient_class	= CommonBean.checkForNull((String)records.get(11));
							strength_per_pres_uom = CommonBean.checkForNull((String)records.get(41));
							content_in_pres_base_uom = CommonBean.checkForNull((String)records.get(42));
							reissue_date_time = CommonBean.checkForNull((String)records.get(43));
							// Added Newly for the KAUH-SCF-049[Inc:33575] Start
							/*if(!ret_date.equals("") && ret_qty.equals(pres_qty)){
								line_status_text = "Return-Medication";
							}
							else{*/
							line_status_text = CommonBean.checkForNull((String)records.get(44));
							//}
							//Added Newly for the KAUH-SCF-049[Inc:33575] End
							order_id		 = CommonBean.checkForNull((String)records.get( 15 ));
							freq_nature		= CommonBean.checkForNull((String)records.get(51));
							dosage_type		= CommonBean.checkForNull((String)records.get(52));
							admin_dose_chng_reason_cnt = CommonBean.checkForNull((String)records.get(53));
							dosage_uom_desc  = CommonBean.checkForNull((String)records.get(54));
							route_color = CommonBean.checkForNull((String)records.get(58));// Code Added CRF -0034 Start
							if(route_color!= null && !route_color.equals("")){
								if(route_color.length()==12){
									fntColor= route_color.substring(0, 6);
									backgrndColor= route_color.substring(6, 12);
								}
							}
                           //Code Added  CRF -0034 End
						   /*below code Added for ML-BRU-SCF-0098 [IN031837] -- Start*/
							amended_by_id		= CommonBean.checkForNull((String)records.get(59));						  
							amend_reason			= CommonBean.checkForNull((String)records.get(60));
							amend_reason_code	= CommonBean.checkForNull((String)records.get(61));
							amended_date			= CommonBean.checkForNull((String)records.get(62));
							/*Above code Added for ML-BRU-SCF-0098 [IN031837] -- End*/
							strength_value		= CommonBean.checkForNull((String)records.get(63));// Added for IN-30262
							alt_drug_remarks		= CommonBean.checkForNull((String)records.get(64));// Added for IN-30262
							pregnancy_override_reason		= CommonBean.checkForNull((String)records.get(65));// Added for RUT-CRF-0063 [IN:029601]
							allocate_remarks_code 	= CommonBean.checkForNull((String)records.get(66));//code added for ML-BRU-SCF-0971[IN042220]--Start
							allocate_finding 	= CommonBean.checkForNull((String)records.get(67));
							fill_remarks_code 		= CommonBean.checkForNull((String)records.get(68));
							fill_finding 		= CommonBean.checkForNull((String)records.get(69));
							delivery_remarks_code 	= CommonBean.checkForNull((String)records.get(70));
							delivery_finding 	= CommonBean.checkForNull((String)records.get(71));
							pres_base_uom 	= CommonBean.checkForNull((String)records.get(73)); //Added for ML-BRU-SCF-1190 [IN:045647]
							ref_sent_remarks = CommonBean.checkForNull((String)records.get(75));//Added for HSA-CRF-0155 [IN048487] 
							verify_remarks = CommonBean.checkForNull((String)records.get(78));//Added for ML-MMOH-SCF-0327 [IN:058772] 
							order_qty      = CommonBean.checkForNull((String)records.get(82));//Added for ARYU-SCF-0034
							if(!allocate_finding.equals("")){
								allocate_finding=allocate_finding.replaceAll(" ","%20");
								allocate_finding=	java.net.URLEncoder.encode(allocate_finding,"UTF-8");
								allocate_finding=allocate_finding.replaceAll("%2520","%20");
							}
							if(!fill_finding.equals("")){
								fill_finding=fill_finding.replaceAll(" ","%20");
								fill_finding=	java.net.URLEncoder.encode(fill_finding,"UTF-8");
								fill_finding=fill_finding.replaceAll("%2520","%20");
							}				
							if(!delivery_finding.equals("")){
								delivery_finding=delivery_finding.replaceAll(" ","%20");
								delivery_finding=	java.net.URLEncoder.encode(delivery_finding,"UTF-8");
								delivery_finding=delivery_finding.replaceAll("%2520","%20");
							}// code added for ML-BRU-SCF-0971[IN042220]--End	
							if(line_iv_prep_yn.equals("0") || line_iv_prep_yn.equals("9")){
								//content_in_pres_base_uom = bean.getPackSizeFluid(order_id);
							}

							disp_uom		=	pres_uom;
							ret_uom			=	stock_uom+"  - ";
							//admin_uom		=	pres_uom;
							reissue_uom		=	stock_uom+"  - ";
                            sliding_scale_yn        =(String)records.get(46)==null?"N":(String)records.get(46);
							
                            if(((String)records.get(46)).equals("Y")){
								tot_admin_qty = CommonBean.checkForNull((String)records.get(47));//sliding_scale_adm_unit
								admin_uom     = CommonBean.checkForNull((String)records.get(48));//sliding_scale_adm_uom
							}
							alternates		= CommonBean.checkForNull((String)records.get(49));//alternates

							if(alternates.equals("Y")){
								disp_qty		= "";
								dispnsd_disp_unit_value = "";
								disp_uom		=  "";
								disp_stock_uom	=  "";
							}

							if(disp_qty.equals("")) {
								disp_uom		=  "";
								disp_stock_uom	=  "";
							}

							if(line_status.equals("IP") && disp_qty.equals("")) 
								disp_qty	="";

							if((ret_qty.trim()).equals("")){ //trim() added for KAUH-SCF-013 [IN:032157]
								ret_uom	=	"";
							}
							else{		
								st =new StringTokenizer(ret_uom, " ");
								while (st.hasMoreTokens()){
									ret_uom1 = st.nextToken();
									ret_uom2 = st.nextToken();
								}
								ret_uom= bean.getUomDisplay(facility_id,ret_uom1)+"  - ";
							}
							if(line_iv_prep_yn.equals("6"))
								admin_uom= (String)records.get( 54 );
							
							if(tot_admin_qty.equals("")) {
								admin_uom	=	"";
							}
							else{
								if(Float.parseFloat(tot_admin_qty)<1 && Float.parseFloat(tot_admin_qty)>0)
									tot_admin_qty="0"+tot_admin_qty;
							}
							if(!disp_drugs.equals("")) 
								disp_drugs	=	" / "+disp_drugs;

							if((reissue_qty.trim()).equals("")){ //trim() added for KAUH-SCF-013 [IN:032157]
								reissue_uom	=	"";
							}
							else{	//ADDED for 26236-reopen==Else condition	
								st =new StringTokenizer(reissue_uom, " ");
								while (st.hasMoreTokens()){
								reissue_uom1 = st.nextToken();
								reissue_uom2 = st.nextToken();
							}
							reissue_uom= bean.getUomDisplay(facility_id,reissue_uom1)+"  - ";
						}
						if(ret_diff.equals("")) 
							ret_diff	=	"0";
						
						if(line_iv_prep_yn.equals("N") || line_iv_prep_yn.equals("I")){
							if(order_line_no.equals("1"))
								classVal="IVFLUID";
							else
								classVal="IVINGREDIENT";
						}
						else if(discharge_med.equals("D")){
							classVal="DISCHARGEMED1";
						}
%>		
						<tr style='height:50px;'><td style='width:0px;border-right:0;' >&nbsp;</td>
<%
							for(int colCount=0; colCount<records.size(); colCount++){

								/*	 0	--->    IV_PREP_YN
									 1	--->	INFUSE_OVER
									 2	--->	TRN_TYPE_IND (To decide whether it is direct dispensing or via prescription)
									 3	--->	STATUS	(To decide whether the drug is cancelled,hold,discontinued or active)
									 4	--->	Drug Code
									 6	--->	Route Code
									 11	--->	Remarks	*/

								order_id=(String)records.get( 15 );
								order_line_num=(String)records.get( 16 );
								sr_no         =(String)records.get( 17 );

								//if (colCount>18)//changed to 18 for AAKH-CRF-0088 [IN:060357]  
									//continue;
									//added ADDED_BY_ID  for ml-mmoh-crf-0510 [IN060510] start
									if(site){
										if (colCount>19)
											continue;
									}
									else{
										if (colCount>17)
											continue;

									}
								//added ADDED_BY_ID  for ml-mmoh-crf-0510 [IN060510] end
								if (colCount ==0 || colCount==1){
									strIVPrepYN =(String)records.get( 0 );
									if (colCount==0){						
										continue;
									}
									else{
										if (strIVPrepYN.equals("N")){
											linkYN = "N";
										}
										else if (strIVPrepYN.equals("Y")&&(records.get( 1 ) != null)){
											linkYN = "Y";
										}
									}
								}
								else if (colCount==2 ){
								}
								else if (colCount == 3) {

									drug_status = "";
									disc_cancel = bean.isCancelDiscontinuedApplicable((String)records.get( 15 ),(String)records.get( 16 ));	
									cancel_link_yn       = (String)disc_cancel.get("CANCEL");
									future_yn	=	bean.compareDate((String)records.get(9));
									expiry_yn	=	bean.compareDate((String)records.get(10));

									if(!ret_qty.equals("") ){
										if (line_status.equals("DC"))
											drug_status = "#C40062";
										//else if(expiry_yn.equals("N"))
										//	drug_status = "#FFB66C";
										else
											drug_status = "#FFB66C";
										if((status.equals("A") || status.equals("*A")) && (line_status.equals("DP") || line_status.equals("DF")|| line_status.equals("DD")|| line_status.equals("DE")) && (future_yn.equals("N")) && !expiry_yn.equals("N")){	//DD AND DD added for mms-kh-crf-0014
											classVal	= "ACTIVE";
										}
										else{
											if(future_yn.equals("Y")) 
												classVal	= "FUTURE_Rx";
											else if(expiry_yn.equals("N"))
												classVal	= "EXPIRED_MEDICATION";
											else if (line_status.equals("CN"))
												classVal	= "CANCEL";
											else if (line_status.equals("DC"))
												classVal	= "DIS-CONTINUED";
											else if(discharge_med.equals("D"))
												classVal="DISCHARGEMED1";
											else if (line_status.equals("HD") || line_status.equals("HC"))
												classVal	= "HOLD";
											else
												classVal	= "ACTIVE";
												//classVal	= "ReturnedMedication";	
										}
									}
									else if (line_status.equals("CN")){
										drug_status = "#990000";
										if(expiry_yn.equals("N"))
											classVal	= "EXPIRED_MEDICATION";
										else
											classVal	= "CANCEL";
									}
									else if (line_status.equals("DC")){
										drug_status = "#C40062";
										if(expiry_yn.equals("N"))
											classVal	= "EXPIRED_MEDICATION";
										else
											classVal	= "DIS-CONTINUED";
									}
									else if( ((((String)records.get( colCount )).trim()).equals("ACTIVE")) || ((patient_class.equals("IP") || patient_class.equals("DC")) && (line_status.equals("OS") || line_status.equals("RG") || line_status.equals("IP") || line_status.equals("VF")) ) || ((patient_class.equals("OP") || patient_class.equals("EM")) && (line_status.equals("DP") || line_status.equals("DF") ) )){
										if(future_yn.equals("Y")) { 
											drug_status = "#99FFCC";
											classVal	= "FUTURE_Rx";
										}
										else{
											drug_status = "#FF5E5E";
											if(expiry_yn.equals("N")){
												classVal	= "EXPIRED_MEDICATION";
												drug_status = "#D9B86C";
											}
											else 
												classVal	= "ACTIVE";
										}
									}
									else if(child_order.equals("Y")){
										drug_status = "#B6BC8B";
										if(future_yn.equals("Y")) 
											classVal	= "FUTURE_Rx";
										else
											classVal	= "Refill_Rx";
									}
									else if(future_yn.equals("Y")) { 
										drug_status = "#99FFCC";
										classVal	= "FUTURE_Rx";						
									}
									else if(cancel_link_yn.equals("Y") || (line_status.equals("IP") || line_status.equals("PO") || line_status.equals("PS") || line_status.equals("AL") || line_status.equals("VF")) || (disp_qty.equals("") && !tot_admin_qty.equals("") && complete_reason.equals(""))){
										drug_status = "#8204FF";
										if(expiry_yn.equals("N"))
											classVal	= "EXPIRED_MEDICATION";
										else
											classVal	= "YET_TO_BE_DISPENSED";
									}
									else if (line_status.equals("HD") || line_status.equals("HC")){
										if(expiry_yn.equals("N"))
											drug_status = "#D9B86C";
										else
											drug_status = "#F0F000";
										classVal	= "HOLD";
									
									} 
									else if(expiry_yn.equals("N")){
										drug_status = "#D9B86C";
										classVal	= "EXPIRED_MEDICATION";
									}
									else {
										drug_status = "";
										classVal	= classvalue;
									}
									/* if(expiry_yn.equals("N")){
										drug_status = "#D9B86C";
										classVal	= "EXPIRED_MEDICATION";
									}*/
									if(line_status.equals("PO") || line_status.equals("PS")){
										title_buffer.append(" / ");
										title_buffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PndngFrAppr.label","ph_labels"));
									}
									ht_wt_title = title_buffer.toString();
								}
								
								else if (colCount==4 || colCount==6 || colCount==15 || colCount==16 || colCount==17){	
								%>			
									<td class="<%=classvalue%>" style="display:none" title="<%=ht_wt_title%>"><%=(String)records.get( colCount )%>&nbsp;</td>
								
<%								}
						     //Added for ML-MMOH-CRF-0510[IN060510] START
								else if (colCount==18){ //added 18 for AAKH-CRF-0088 [IN:060357] 
									
										if(((String)records.get( 80 )) != null){
%>
									<td class="<%=classvalue%>" ><%=(String)records.get( 80 )%>&nbsp;</td>
<%								}else{
%> 
								<td class="<%=classvalue%>" ><%=(String)records.get( 12 )%>&nbsp;</td> 
 									
<%									}
 									}
                              else if (colCount==19){ //added 18 for AAKH-CRF-0088 [IN:060357] 
									
										if(((String)records.get( 81 )) != null){
										 %>
									<td class="<%=classvalue%>" ><%=(String)records.get( 81 )%>&nbsp;</td>
<% 								}else if(((String)records.get( 80 )) != null && ((String)records.get( 81 )) == null){ 
%> 
									<td class="<%=classvalue%>" ><%=(String)records.get( 12 )%>&nbsp;</td> 
 									
<%								}else{
%>
									<td class="<%=classvalue%>" >&nbsp;</td> 
<%									}
 									}//Added for ML-MMOH-CRF-0510[IN060510] END							}


								else if(colCount==9||colCount==10){

									String date	=	com.ehis.util.DateUtils.convertDate((String)records.get(colCount),"DMYHM","en",locale);
									out.print("<td style='background-color:#FFFFFF'class='"+classvalue+" '>"); 
									out.print(date+"&nbsp;"); 
									out.print("</td>");
								}
								else if (colCount==5){
%>
									<td class="<%=classvalue%>" style='width:0px;border-left:0' title="<%=ht_wt_title%>"><%=line_status_text%>
<%
									if(line_status.equals("IS")){ //if block added for Bru-HIMS-CRF-087 [IN:029953]
%>
										<br><label style='color:blue;cursor:pointer;' onclick="viewOutsourceDtls('<%=order_id%>','<%=order_line_num%>');"><fmt:message key="ePH.DispenseDetail.label" bundle="${ph_labels}"/></label>
<%
									}
%>
									</td>
<%
								}
								else if (colCount==11 ){
%>	
									<td class="<%=classvalue%>"  title="<%=ht_wt_title%>">
<%
									if ( !(((String)records.get(3)).trim()).equals("CANCEL") && !(((String)records.get(3)).trim()).equals("HOLD") && ((String)records.get( 18 )).equals("0") && ((String)records.get( 26 ))==null && ret_date.equals("") && ((String)records.get( 50 ))==null && (((String)records.get(57))==null || ((String)records.get(57)).equals("")) && (ret_qty==null || ret_qty.equals("")) && (amended_by_id == null || amended_by_id.equals(""))  && (amend_reason==null || amend_reason.equals("")) && (amend_reason_code==null || amend_reason_code.equals("")) && pregnancy_override_reason.equals("")&& allocate_finding.equals("") && fill_finding.equals("")&& delivery_finding.equals("") && ref_sent_remarks.equals("") ) { // added  || (ret_qty==null || ret_qty.equals("") ML-BRU-SCF-0037[030949]  and  amended_by_id, amend_reason added for ML-BRU-SCF-0098 [IN031837]  rtn_qty condition replaced with && code allocate_finding.equals("") && fill_finding.equals("")&& delivery_finding.equals("") added for ML-BRU-SCF-0971[IN042220]
%>
										<font >&nbsp;</font>				
<%	
									}
									else{
										//Display remarks hyper link for orders with Cancelled/Held/Remarks enterd/LAST_ACTION_REASON_DESC/COMPLETED/PRN_REMARKS 
%>
										<font class="HYPERLINK" style="cursor:pointer" onClick="showRemarks('<%=order_id%>','<%=order_line_num%>','<%=sr_no%>','<%=line_status%>','<%=(String)records.get(56)%>','<%=sliding_scale_yn%>','<%=amended_by_id%>','<%=amended_date%>','<%= java.net.URLDecoder.decode(amend_reason,"UTF-8")%>','<%=amend_reason_code%>','<%=allocate_finding%>','<%=fill_finding%>','<%=delivery_finding%>', '<%=allocate_remarks_code%>', '<%=fill_remarks_code%>', '<%=delivery_remarks_code%>','','<%=encounter_id%>','','<%=java.net.URLEncoder.encode(ref_sent_remarks,"UTF-8")%>', '<%=java.net.URLEncoder.encode(verify_remarks,"UTF-8")%>','<%=patient_id %>')"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></font><!-- code '<%=allocate_finding%>','<%=fill_finding%>','<%=delivery_finding%>added for ML-BRU-SCF-0971[IN042220] //Added called_from,encounter_id,ReqDb for MMS-DM-CRF-115.4-->
<%	
									}
%>
									</td>	
<% 
									if((discharge_med.equals("D"))){ // if else condition added for ML-MMOH-SCF-0328 [IN058775]
%>	
										<td class="<%=classvalue%>" title="<%=ht_wt_title%>"><%="OP"%></td>	
<%
									}
									else { 
%>
										<td class="<%=classvalue%>" title="<%=ht_wt_title%>"><%=(String)records.get( colCount )%></td>
<% 
									}
								}
								else if(colCount==10){

									dtls = CommonBean.checkForNull((String)records.get( colCount ));
									disc_cancel = bean.isCancelDiscontinuedApplicable((String)records.get( 15 ),(String)records.get( 16 ));	
									
									discontinued_link_yn = (String)disc_cancel.get("DISCONTINUE");
									cancel_link_yn       = (String)disc_cancel.get("CANCEL");

																		if(discontinued_link_yn!=null && discontinued_link_yn.equals("Y"))
										disc_cancel_style = "";
									else if(cancel_link_yn!=null && cancel_link_yn.equals("Y"))
										disc_cancel_style = "";
									else
										disc_cancel_style = "";
									
									if(discontinued_link_yn!=null && discontinued_link_yn.equals("Y")){
										//on_click = "discontinueTheDrug('"+(String)records.get( 15 )+"','"+(String)records.get( 16 )+"','"+called_frm+"')";
									}
									else if(cancel_link_yn!=null && cancel_link_yn.equals("Y")){
										//on_click = "cancelTheDrug('"+(String)records.get( 15 )+"','"+(String)records.get( 16 )+"','"+called_frm+"')";
									}
									else{
										on_click = "";
									}
									
									//else{
%>
										<td class="<%=classvalue%>" title="<%=ht_wt_title%>" id="disc_cancel_id"><%=dtls%> 
										</td>
<%
									//}
								}
								else{
									// Added for ml-mmoh-crf-0510 start
									//dtls = CommonBean.checkForNull((String)records.get( colCount ));
									if(site){
									if(colCount == 12){
										dtls = "";
									}
									else{
										dtls = CommonBean.checkForNull((String)records.get( colCount ));
									}
									}
									else{
										
										dtls = CommonBean.checkForNull((String)records.get( colCount ));
									
									}
									// Added for ml-mmoh-crf-0510 end
//code added for 24361 on 29Nov2010
									if((line_iv_prep_yn.equals("1") || line_iv_prep_yn.equals("2") || line_iv_prep_yn.equals("3") || line_iv_prep_yn.equals("4")||line_iv_prep_yn.equals("9")||line_iv_prep_yn.equals("0"))&& (colCount==7)){
										if(!order_line_no.equals("1")){
										    dtls ="&nbsp;";
										}
								    }//ends here
									if(line_iv_prep_yn.equals("N") || line_iv_prep_yn.equals("I")){
										if(!order_line_no.equals("1")){
											if(colCount==9 || colCount==12 || colCount==13 || colCount==14 )
												dtls = "&nbsp;";
										}
									}
									if(colCount==12) { 
										/* if(!pres_base_uom.equals(pres_uom)){ //Added for ML-BRU-SCF-1190 [IN:045647] 
											convFactor = bean.getConvFactor(pres_uom,pres_base_uom );
											pres_qty = Float.parseFloat(pres_qty)/Float.parseFloat(convFactor)+"";
										} *///comment for BH-4760(wrong pres qty in pateint drug profile)
										if(pres_qty!=null && !pres_qty.equals(""))
											pres_qty = dfToInteger.format(Double.parseDouble(pres_qty));
										if(!dosage_type.equals("A")){
											if(!freq_nature.equals("P")){
												//pres_disp_unit_value		=  (new Double(Math.ceil(Float.parseFloat(pres_qty)/Float.parseFloat(content_in_pres_base_uom))).intValue())+"";//Commented for ARYU-SCF-0034
												pres_disp_unit_value=order_qty;//Added for ARYU-SCF-0033
											}
											else{
												pres_disp_unit_value=pres_qty;
												pres_uom=stock_uom;
											}
										}
										else{
											if(!line_iv_prep_yn.equals("5") && !line_iv_prep_yn.equals("") && !line_iv_prep_yn.equals("9") && !line_iv_prep_yn.equals("0")){ //added 9 and 0 condition for IN26750 --14/03/2011-- priya
												pres_disp_unit_value=pres_qty;
												//pres_uom=stock_uom;
											}
											else{
												   //pres_disp_unit_value		=  (new Double(Math.ceil(Float.parseFloat(pres_qty)/Float.parseFloat(content_in_pres_base_uom))).intValue())+"";
												if(!dosage_type.equals("A")){
													pres_disp_unit_value		=  (new Double(Math.ceil(Float.parseFloat(pres_qty)/Float.parseFloat(content_in_pres_base_uom))).intValue())+"";
												}
												else{
													//Added IF-Else Condition For getting Prescribed Pres &Dispensing Quantities of PRNAbsolute &Absolute orders regarding incident num:25141,25131 on 25/Nov/2010==By Sandhya
												   /*  if(freq_nature.equals("P")){
														   pres_disp_unit_value		=  pres_qty+"";
													 }
													 else{*/
													pres_disp_unit_value		=  (new Double(Math.ceil(Float.parseFloat(pres_qty)/Float.parseFloat(content_in_pres_base_uom))).intValue())+"";
													// }										
												}
												if(dosage_type.equals("A") || freq_nature.equals("P")){ //added for ARYU-SCF-104
													pres_disp_unit_value = order_qty;
												}
											}
										}
										if(disp_qty != null && disp_qty != ""){
											if(!pres_uom.equals(stock_uom)){
												if(line_iv_prep_yn.equals("2")||line_iv_prep_yn.equals("4")||line_iv_prep_yn.equals("6")||line_iv_prep_yn.equals("0")){
													dispnsd_disp_unit_value	=  Double.parseDouble(disp_qty)/Float.parseFloat(content_in_pres_base_uom)+"";
												}
												else{										
													if(!dosage_type.equals("A")){
													   dispnsd_disp_unit_value		=  (new Double(Math.ceil(Float.parseFloat(disp_qty)/Float.parseFloat(content_in_pres_base_uom))).intValue())+"";
													}
													else{
														//Added IF-Else Condition For getting Dispensed Pres & Dispense Quantities  of PRNAbsolute & Absolute Orders regarding incident num:25141 on 25/Nov/2010==By Sandhya
														if(freq_nature.equals("P")){
														   //dispnsd_disp_unit_value		=disp_qty+"";
														   dispnsd_disp_unit_value		=disp_qty+"";
														   disp_qty		=  (new 		Double(Math.ceil(Float.parseFloat(disp_qty)*Float.parseFloat(content_in_pres_base_uom))).intValue())+"";
														}
														else{ 
															dispnsd_disp_unit_value     =disp_qty+"";
															disp_qty		=  (new 		Double(Math.ceil(Float.parseFloat(disp_qty)*Float.parseFloat(content_in_pres_base_uom))).intValue())+"";
														}
													}
												}
											}
											else{
												dispnsd_disp_unit_value		= disp_qty;
											}
											disp_stock_uom				=  stock_uom;
										}

										if(!pres_qty.equals("")){
											/*if(dosage_type.equals("A")){//Added if for ML-BRU-SCF-1307
												pres_base_uom = stock_uom;
											}*/ //Commented for SKR-SCF-1036.1 [IN:052023]
											//if(!dosage_type.equals("A") && freq_nature.equals("P")){//Added if for BSP-SCF-0017[62586]  --start//!dosage_type.equals("A")added for Aryu-scf-0101
										//	pres_base_uom = stock_uom;
										//	}//end
											if(freq_nature.equals("P") || dosage_type.equals("A")){ //added for ARYU-SCF-0104
												 pres_qty = (new  		Double(Math.ceil(Float.parseFloat(pres_qty)*Float.parseFloat(content_in_pres_base_uom))).intValue())+"";
											}

%>											
											<td class="<%=classvalue%>" width="53%"  align="left" ><%=pres_qty%>&nbsp;<%=CommonBean.checkForNull(bean.getUomDisplay(facility_id,pres_base_uom))%></td>
											<!-- //style="border-bottom-color:white"><%=pres_qty%>&nbsp;<%=pres_uom%></td>pres_uom -->
											<td class="<%=classvalue%>"  align="left" > <%=pres_disp_unit_value%>&nbsp;<%=CommonBean.checkForNull(bean.getUomDisplay(facility_id,stock_uom))%></td><!-- </td> -->
<%
										}
										else{
%>
											<td class="<%=classvalue%>" align="right" >&nbsp;</td>
											<td class="<%=classvalue%>" align="left" >&nbsp;</td>
<%
										}
										if(alternates.equals("N")){
											if(!disp_qty.equals("")){									
												if(disp_qty != null && !disp_qty.equals("")){
													disp_qty = dfToInteger.format(Double.parseDouble(disp_qty));
												}
												/*if(dosage_type.equals("A")){//Added if for ML-BRU-SCF-1307
													disp_uom = disp_stock_uom;
												}*/////Commented for SKR-SCF-1036.1 [IN:052023]
												if(!dosage_type.equals("A") && freq_nature.equals("P")){//Added if for BSP-SCF-0017[62586]  --start//!dosage_type.equals("A")added for Aryu-scf-0101
													disp_uom = stock_uom;
												}//end
												//if else condtion added for IN007846
												if(disp_qty.equals("0")){
													%>
												<td class="<%=classvalue%>" width="52%" >&nbsp;</td><!-- </td> -->
												
<%			}
												else{
													 %>
													<td class="<%=classvalue%>" width="52%" ><%=disp_qty%>&nbsp;<%=CommonBean.checkForNull(bean.getUomDisplay(facility_id,disp_uom))%></td><!-- </td> -->
						<%						}
												if(dispnsd_disp_unit_value != null && !dispnsd_disp_unit_value.equals("")){
													dispnsd_disp_unit_value = dfToInteger.format(Double.parseDouble(dispnsd_disp_unit_value));
												}
												//if else condtion added for IN007846
												if(dispnsd_disp_unit_value.equals("0")){
													%>
													<td class="<%=classvalue%>" width="52%" >&nbsp;</td><!-- </td> -->
													<%													
												}else{
%>
												<td class="<%=classvalue%>" nowrap  ><%=dispnsd_disp_unit_value%>&nbsp;<%=CommonBean.checkForNull(bean.getUomDisplay(facility_id,disp_stock_uom))%></td>
												
<%}
											}
											else{
%>
												<td class="<%=classvalue%>" align="right" >&nbsp;</td>
												<td class="<%=classvalue%>"  align="left" >&nbsp;</td>
<%
											}
										}
										else if(alternates.equals("Y") ){ //Added  && ReqDb.equals("") for MMS-DM-CRF-115.4s
%>
											<td class="<%=classvalue%>" nowrap align="left" >&nbsp;<font class="HYPERLINK" style="cursor:pointer" onClick="showDetails('<%=order_id%>','<%=order_line_no%>','<%=line_status_text%>','<%=allocate_finding%>','<%=fill_finding%>', '<%=allocate_remarks_code%>', '<%=fill_remarks_code%>', '', '<%=java.net.URLEncoder.encode(verify_remarks,"UTF-8")%>','','','<%=patient_id%>')"><!--code ','<%=allocate_finding%>','<%=fill_finding%>', '<%=allocate_remarks_code%>', '<%=fill_remarks_code%>'' added for IN046252  modified parameters fror mms-icn-0115-->
											<img  src='../../ePH/images/altenate.jpg' height='15' width='15' align='top' title='<fmt:message key="ePH.AlternateDrugs.label" bundle="${ph_labels}"/> <fmt:message key="Common.Dispensed.label" bundle="${common_labels}"/>' align="center"></img>
											</font>
<%
											if(alt_drug_remarks!=null && !alt_drug_remarks.equals("")){
												stkey = order_id+"~"+order_line_num;
												if(!alt_drug_remarks.equals(""))
													bean.setAltDrugRemarks(stkey, alt_drug_remarks);
%>
												<font class="HYPERLINK" style="cursor:pointer" onClick="showAltDrugRemarks('<%=stkey%>','<%=alt_drug_remarks_ind%>')"><fmt:message key="ePH.Remarks.label" bundle="${ph_labels}"/>
												</font>
<%
											}
%>
											</td>
											<td class="<%=classvalue%>" nowrap align="left">&nbsp;<font class="HYPERLINK" style="cursor:pointer" onClick="showDetails('<%=order_id%>','<%=order_line_no%>','<%=line_status_text%>','<%=allocate_finding%>','<%=fill_finding%>', '<%=allocate_remarks_code%>', '<%=fill_remarks_code%>', '', '<%=java.net.URLEncoder.encode(verify_remarks,"UTF-8")%>','','','<%=patient_id%>')"><!--code ','<%=allocate_finding%>','<%=fill_finding%>', '<%=allocate_remarks_code%>', '<%=fill_remarks_code%>'' added for IN046252 modified parameters fror mms-icn-0115-->
											<img  src='../../ePH/images/altenate.jpg' height='15' width='15' align='top'  title='<fmt:message key="ePH.AlternateDrugs.label" bundle="${ph_labels}"/> <fmt:message key="Common.Dispensed.label" bundle="${common_labels}"/>' align="center"></img>
											</font>
<%
										if(alt_drug_remarks!=null && !alt_drug_remarks.equals("")){
											stkey = order_id+"~"+order_line_num;
											stkey = order_id+"~"+order_line_num;
											if(!alt_drug_remarks.equals(""))
												bean.setAltDrugRemarks(stkey, alt_drug_remarks);
%>
											<font class="HYPERLINK" style="cursor:pointer" onClick="showAltDrugRemarks('<%=stkey%>','<%=alt_drug_remarks_ind%>')"><fmt:message key="ePH.Remarks.label" bundle="${ph_labels}"/>
											</font>
<%
										}
%>
										</td>
<%
									}else if (alternates.equals("Y")){//Added if else condition for MMS-DM-CRF-115.4
	%>
	                                   <td> <img  src='../../ePH/images/altenate.jpg' height='15' width='15' align='top' title='<fmt:message key="ePH.AlternateDrugs.label" bundle="${ph_labels}"/> <fmt:message key="Common.Dispensed.label" bundle="${common_labels}"/>' align="center"></img>
									   </td>
									   <td> <img  src='../../ePH/images/altenate.jpg' height='15' width='15' align='top' title='<fmt:message key="ePH.AlternateDrugs.label" bundle="${ph_labels}"/> <fmt:message key="Common.Dispensed.label" bundle="${common_labels}"/>' align="center"></img>
									   </td>
<%
									}
									if(tot_admin_qty!=null && !tot_admin_qty.equals("") && !tot_admin_qty.equals("0") && freq_nature.equals("P")){ /* Added !tot_admin_qty.equals("0") for SKR-SCF-0550[Inc:33338] curly bracket added for MMS-KH-SCF-0037 */ 
										tot_admin_qty =Float.toString( Float.parseFloat(tot_admin_qty)*Float.parseFloat(content_in_pres_base_uom));
										len= tot_admin_qty.length();
										//Below condition is added by sureshkumar T for the Incident no : SRR20056-SCF-7039 [inc : 26763]
										if( len > 0 ){
											temp = tot_admin_qty;
											point= temp.indexOf(".")+1;
											if(point!=0 && temp.charAt(point)=='0')
												tot_admin_qty = tot_admin_qty.substring(0,point-1);
										}// {} added for MMS-KH-SCF-0037
									}
									//tot_admin_qty=total_admin_qty_format.format(Float.parseFloat(tot_admin_qty));
%>
					
									<!--<td class="<%=classvalue%>" title="<%=ht_wt_title%>" nowrap ><%=ret_qty%>&nbsp;<%=ret_uom%> &nbsp;<%=com.ehis.util.DateUtils.convertDate(ret_date,"DMYHM","en",locale)%>&nbsp;</td>--><!--Commented for ML-BRU-SCF-1394[IN0501010] -->
<%
								if(alternates.equals("N") || ret_date.equals("")){//Added for ML-BRU-SCF-1394[IN0501010]-Start
									if(!ret_qty.equals("")) //if added for SKR-SCF-1218
									ret_uom = bean.getReturnMedicationUom(order_id,order_line_no); // Added for ICN-69026 - Start

									if(ret_qty.equals("")){ //if condition added for SKR-SCF-1218
										ret_uom = "";
									}
								
								if(!ret_uom.equals(""))
									ret_uom = bean.getUomDisplay(facility_id,ret_uom); // Added for ICN-69026 - End
%>
									<td class="<%=classvalue%>" title="<%=ht_wt_title%>" nowrap ><%=ret_qty%>&nbsp;<%=ret_uom%> &nbsp;<%=com.ehis.util.DateUtils.convertDate(ret_date,"DMYHM","en",locale)%>&nbsp;</td>
<% 
								}
							    else if(alternates.equals("Y") && !ret_date.equals("")){
%>
									<td class="<%=classvalue%>" nowrap align="left" >&nbsp;<font class="HYPERLINK" style="cursor:pointer" onClick="showDetails('<%=order_id%>','<%=order_line_no%>','<%=line_status_text%>','<%=allocate_finding%>','<%=fill_finding%>', '<%=allocate_remarks_code%>', '<%=fill_remarks_code%>','return', '<%=java.net.URLEncoder.encode(verify_remarks,"UTF-8")%>','','<%=encounter_id%>','<%=patient_id%>')"><img  src='../../ePH/images/altenate.jpg' height='15' width='15' align='top' title='<fmt:message key="ePH.AlternateDrugs.label" bundle="${ph_labels}"/> <fmt:message key="Common.Dispensed.label" bundle="${common_labels}"/>' align="center"></img><!--modified parameters fror mms-icn-0115 -->
									</font>
<%
									if(alt_drug_remarks!=null && !alt_drug_remarks.equals("")){
										stkey = order_id+"~"+order_line_num;
										stkey = order_id+"~"+order_line_num;
										if(!alt_drug_remarks.equals(""))
											bean.setAltDrugRemarks(stkey, alt_drug_remarks);
%>
										<font class="HYPERLINK" style="cursor:pointer" onClick="showAltDrugRemarks('<%=stkey%>','<%=alt_drug_remarks_ind%>')"><fmt:message key="ePH.Remarks.label" bundle="${ph_labels}"/>
										</font>
<%
									}
%>
									</td>
<%
								}//Added for ML-BRU-SCF-1394[IN0501010]-End
%>
									<td class="<%=classvalue%>" nowrap title="<%=ht_wt_title%>">&nbsp;
								<!---Added Newly in if condition  && (dosage_type.equals("A") || dosage_type.equals("Q"))   for the SKR-SCF-0489 on 18/05/2012 --->
<%
										if(!tot_admin_qty.equals("")  && !tot_admin_qty.equals("0") && (dosage_type.equals("A") || dosage_type.equals("Q"))){  //Added !tot_admin_qty.equals("0") for SKR-SCF-0550[Inc:33338]
											len= tot_admin_qty.length();
											if( len > 0 && Float.parseFloat(tot_admin_qty)>1 ){ //&& Float.parseFloat(tot_admin_qty)>1 added for MMS-KH-SCF-0037
												temp = tot_admin_qty;
												point= temp.indexOf(".")+1;
												if(point!=0 && temp.charAt(point)=='0')
													tot_admin_qty = tot_admin_qty.substring(0,point-1);
											}						
%> 													<!-- pres_qty and uom added for MMS-KH-CRF-0014-->						
											<%=tot_admin_qty%>&nbsp;<%=CommonBean.checkForNull(bean.getUomDisplay(facility_id,admin_uom))%> /<%=pres_qty%>&nbsp;<%=CommonBean.checkForNull(bean.getUomDisplay(facility_id,pres_base_uom))%>
<%
										}
										//Added Newly if condition  for the SKR-SCF-0489 on 18/05/2012 
										else if(!tot_admin_qty.equals("")  && !tot_admin_qty.equals("0") && dosage_type.equals("S")){  //Added !tot_admin_qty.equals("0") for SKR-SCF-0550[Inc:33338]
											tot_admin_qty = Float.toString( Float.parseFloat(tot_admin_qty) * Float.parseFloat(strength_value) );	// Added for IN-30262 & 31883 
											len= tot_admin_qty.length();
											if( len > 0 && Float.parseFloat(tot_admin_qty)>1 ){//Float.parseFloat(tot_admin_qty) added for MMS-SCF-037
												temp = tot_admin_qty;
												point= temp.indexOf(".")+1;
												if(point!=0 && temp.charAt(point)=='0')
													tot_admin_qty = tot_admin_qty.substring(0,point-1);
											}						
											if(alternates.equals("Y")) // MMS-KH-SCF-0052
												admin_uom = pres_base_uom;

%> 													<!-- pres_qty and uom added for MMS-KH-CRF-0014-->								
											<%=tot_admin_qty%>&nbsp;<%=CommonBean.checkForNull(bean.getUomDisplay(facility_id,admin_uom))%> / <%=pres_qty%>&nbsp;<%=CommonBean.checkForNull(bean.getUomDisplay(facility_id,pres_base_uom))%>
<%
										}
										if(Integer.parseInt(admin_dose_chng_reason_cnt) > 0){
%>
											<img src="../images/changeddosageindicator.gif" title='<fmt:message key="ePH.ChangeDoseDetailExist.label" bundle="${ph_labels}"/>' align="center" id="chng_dose_ind"></img>
<%
										}
%>
<!--=================Date convesion done for ret_med and Reissuemedication time regnd incident num:26236==By Sandhya==01/FEB/2011================-->
										</td>
										<!-- <td class="<%=classvalue%>" title="<%=ht_wt_title%>" nowrap ><%=reissue_qty%>&nbsp;<%=reissue_uom%>&nbsp;<%=reissue_date_time%>&nbsp;</td> -->										
										<!--<td class="<%=classvalue%>" title="<%=ht_wt_title%>"nowrap><%=reissue_qty%>&nbsp;
										<%=reissue_uom%>
										&nbsp;<%=com.ehis.util.DateUtils.convertDate(reissue_date_time,"DMYHM","en",locale)%>&nbsp;</td>--><!--Commented for ML-BRU-SCF-1394[IN0501010]-->
<%										
										if(alternates.equals("N") || reissue_date_time.equals("")){//Added for ML-BRU-SCF-1394[IN0501010]-Start
%>
											<td class="<%=classvalue%>" title="<%=ht_wt_title%>"nowrap><%=reissue_qty%>&nbsp;<%=reissue_uom%>						&nbsp;<%=com.ehis.util.DateUtils.convertDate(reissue_date_time,"DMYHM","en",locale)%>&nbsp;</td>
<%	
										}
										else if(alternates.equals("Y") && !reissue_date_time.equals("")){
%>
											<td class="<%=classvalue%>" nowrap align="left" >&nbsp;<font class="HYPERLINK" style="cursor:pointer" onClick="showDetails('<%=order_id%>','<%=order_line_no%>','<%=line_status_text%>','<%=allocate_finding%>','<%=fill_finding%>', '<%=allocate_remarks_code%>', '<%=fill_remarks_code%>','reissue', '<%=java.net.URLEncoder.encode(verify_remarks,"UTF-8")%>','','<%=encounter_id%>','<%=patient_id%>')"><img  src='../../ePH/images/altenate.jpg' height='15' width='15' align='top' title='<fmt:message key="ePH.AlternateDrugs.label" bundle="${ph_labels}"/> <fmt:message key="Common.Dispensed.label" bundle="${common_labels}"/>' align="center"></img><!---modified parameters fror mms-icn-0115-->
											</font>
<%
											if(alt_drug_remarks!=null && !alt_drug_remarks.equals("")){
												stkey = order_id+"~"+order_line_num;
												stkey = order_id+"~"+order_line_num;
												if(!alt_drug_remarks.equals(""))
													bean.setAltDrugRemarks(stkey, alt_drug_remarks);
%>
												<font class="HYPERLINK" style="cursor:pointer" onClick="showAltDrugRemarks('<%=stkey%>','<%=alt_drug_remarks_ind%>')"><fmt:message key="ePH.Remarks.label" bundle="${ph_labels}"/></font>
<%
											}
%>
											</td>
<%
									   }//Added for ML-BRU-SCF-1394[IN0501010]-End
									}
									if(colCount==7){ //Code Added CRF - 0034  Start
%>
										<td class="<%=classvalue%>" style='color:<%=fntColor%>;background-color:<%=backgrndColor%>' title="<%=ht_wt_title%>"><%=dtls%></td>
<% 
									}
									else if(colCount==8  && records.get(55) != null && ((String)records.get(55)).equals("Y")){ //Code Added CRF - 0034 End

%>										<td class="<%=classvalue%>" title="<%=ht_wt_title%>" nowrap>
											<a HREF="#" onMouseOver="changeCursor(this);" onClick="showMultipleFlowRate('<%=patient_id %>','<%=order_id%>');" id='mfrLink'><fmt:message key="ePH.MultipleFlowRate.label" bundle="${common_labels}"/></a></td>
<%								
									}
									else{ // Else block Added for 10.X-CRF-SRR20056-CRF-0675-PH-SL-2 -- start
										if(site){
											if( colCount!=12){
%>
										<td class="<%=classvalue%>" nowrap>
<%
											}
										}else{%>
											<td class="<%=classvalue%>" nowrap>
									<%	}
										if(colCount==8){
											if(sliding_scale_yn!=null && sliding_scale_yn.equals("Y") ){// && ReqDb.equals("") added for MMS-DM-CRF-115.4
%>
												<div name="divSlidingdetail<%=recCount%>" id="divSlidingdetail<%=recCount%>" style="position:absolute; width:100%;display:none;border:1px solid black;">
												<table id="tblSlidingdetail" border="1"  width="100%" height="100%" align="center" cellpadding="1" cellspacing="0" >
<%
												ArrayList sliding_scale_details =   bean.getSlidingScaleTemplateDetails(order_id,order_line_num,"",encounter_id);
												String sRemarks="&nbsp;";
												boolean blTempFound = false;

												if(sliding_scale_details.size()>1){
													blTempFound = true;
%>
														<tr>
															<th style="font-size:13; border-bottom:1px solid white;" colspan=6 > <%=(String)sliding_scale_details.get(9)%></th>		
														</tr>
														<tr>
															<th align="left" style="font-size:9" nowrap><fmt:message key="ePH.FROMRANGE.label" bundle="${ph_labels}"/></th>
															<th align="left" style="font-size:9" nowrap><fmt:message key="ePH.TORANGE.label" bundle="${ph_labels}"/></th>
															<th align="left" style="font-size:9" nowrap><fmt:message key="ePH.RangeUOM.label" bundle="${ph_labels}"/></th>
															<th align="left" style="font-size:9" nowrap><fmt:message key="ePH.AdminUnits.label" bundle="${ph_labels}"/></th>
															<th align="left" style="font-size:9" nowrap><fmt:message key="ePH.AdminUnitsUOM.label" bundle="${ph_labels}"/></th>
															<th align="left" style="font-size:9" nowrap width='150px' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
														</tr>
<%
														String toRan="";
														String admUnit="";
														for(int sl=1;sl<sliding_scale_details.size();sl+=9){
															toRan=((String)sliding_scale_details.get(sl+3)).equals("0")?(">"+(String)sliding_scale_details.get(sl+2)):(String)sliding_scale_details.get(sl+3);
															admUnit=(String)sliding_scale_details.get(sl+4);
															if(admUnit!=null && !admUnit.equals("")){
																float admUnitValue=Float.parseFloat(admUnit);
																if(admUnitValue>0.0 && admUnitValue<1.0)
																	admUnit=Float.parseFloat(admUnit)+"";
															}
															if(((String)sliding_scale_details.get(sl+7)).equalsIgnoreCase("null") || ((String)sliding_scale_details.get(sl+7)).equals(" ") || sliding_scale_details.get(sl+7) ==null)
																sRemarks = "&nbsp;&nbsp;";
															else
																sRemarks = java.net.URLDecoder.decode((String)sliding_scale_details.get(sl+7),"UTF-8");
%>
															<tr>
																<td nowrap><%=(String)sliding_scale_details.get(sl+2)%></td>
																<td nowrap><%=toRan%></td>	
																<td nowrap><%=(String)sliding_scale_details.get(sl+5)%></td>	
																<td nowrap><%=admUnit%></td>	
																<td nowrap><%=(String)sliding_scale_details.get(sl+6)%></td>
																<td width='150px'><%=sRemarks%></td>	
															</tr>
<%
														}
													}
													else{
														blTempFound = false;
%>
														<tr>
															<th style="font-size:13; border-bottom:1px solid white;" colspan=6 >No Templates Found</th>	
														</tr>
<%
													}
%>
														</table>
													</div>
													<label id='lblslidingscale' style="color:red;cursor:pointer" onmouseover='dispSlidingDtl("<%=recCount%>");' onmouseout='hideSlidingDtl("<%=recCount%>");' onClick="showSlidingDetails('<%=order_id%>','<%=order_line_no%>','<%=sliding_scale_yn%>','<%=blTempFound%>','<%=recCount%>')"><fmt:message key="Common.SlidingScale.label" bundle="${common_labels}"/></label> 
<%
												}
                                               
										}
if(dtls!=""){
%>
										<label id='lblDosagedtl' title="<%=ht_wt_title%>"> <%=dtls%>&nbsp;</label>
<%
}
									} //Added/Modified for 10.X-CRF-SRR20056-CRF-0675-PH-SL-2 -- End
									if(colCount==13){
										
%>
										  /<%=order_id%>
<% 
										//if(!disp_qty.equals("") || alternates.equals("Y") || line_status.equals("IP") || line_status.equals("AL") || line_status.equals("DP")|| line_status.equals("DC")){ //if condition added for ML-BRU-SCF-0430 IN[035169]  //line_status added for ML-BRU-SCF-1116 [IN:044786]
							   			dispense_count 		= CommonBean.checkForNull((String)records.get(69));//Added for MMS-SCF-0196
										if(!disp_qty.equals("") || alternates.equals("Y") || line_status.equals("IP") || line_status.equals("AL") || line_status.equals("DP")|| line_status.equals("DF") || (!dispense_count.equals("") && !dispense_count.equals("0"))){ //if condition added for ML-BRU-SCF-0430 IN[035169]  //line_status added for ML-BRU-SCF-1116 [IN:044786]
%> 
											<br><font class="HYPERLINK" style="cursor:pointer" onClick="showDetails('<%=order_id%>','<%=order_line_no%>','<%=line_status_text%>','<%=allocate_finding%>','<%=fill_finding%>', '<%=allocate_remarks_code%>', '<%=fill_remarks_code%>', '','<%=java.net.URLEncoder.encode(verify_remarks,"UTF-8")%>','','<%=encounter_id%>','<%=patient_id%>')"><!--modified parameters fror mms-icn-0115-->
											<fmt:message key="ePH.DispensedLocns.label" bundle="${ph_labels}"/> 
											</font>
<%
										
										}
									}
%>
									</td>
<%
								}
							}
%>
							</tr>
<%
						}
						int index1=-1;
						if (result.size()<index1){
%>
							<script>
								alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
							</script>
<%
							return;
						}
%>
					</table> 
				</div>
<%
				out.flush();
%>
				
<%

			}
			else{
%>
				<script>
					//document.f_status_frame.location.href="../../eCommon/html/blank.html";
					alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				</script>
<%
			}
			out.println(CommonBean.setForm ( request ,"../../eCA/jsp/MedicationOrdersResult.jsp", searched) );
		} 
		catch(Exception e) {
			//out.print("Exception @ Result JSP :"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();
		}//Added  for ml-mmoh-crf-0510 start
		finally{
			

			if(con != null)
				ConnectionManager.returnConnection(con,request);
		
		}
		//Added  for ml-mmoh-crf-0510 end
%>
	</body>
<% 
	putObjectInBean(bean_id,bean,request); 
%>
</html>

