<!DOCTYPE html>
 <!--saved on 27th Oct 2005 -->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.text.*, java.util.*, ePH.*,eOR.*, ePH.Common.* , eCommon.Common.*,java.sql.Connection,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %> <!-- java.sql.Connection,webbeans.eCommon.ConnectionManager Added for ML-BRU-CRF-0469 [IN:065426] -->

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
	<head>
<% 
request.setCharacterEncoding("UTF-8");
//request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		try{
		String locale				= (String) session.getAttribute("LOCALE");
		String sStyle				= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
		ArrayList drugList			= new ArrayList();
		HashMap fluidDetails		= new HashMap();
		String bean_id				= request.getParameter("bean_id")==null?"":request.getParameter("bean_id");
		String bean_name			= request.getParameter("bean_name")==null?"":request.getParameter("bean_name");
		String patient_id			= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String actual_patient_class = request.getParameter("actual_patient_class")==null?"":request.getParameter("actual_patient_class");
		String encounter_id			= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String iv_prep_yn			= request.getParameter("iv_prep_yn")==null?"":request.getParameter("iv_prep_yn");
		String rx_order_type		= request.getParameter("rx_order_type")==null?"":request.getParameter("rx_order_type");
		String mfr_yn				= (String)request.getParameter("MFR_YN")==null?"":request.getParameter("MFR_YN");
		String episode_type			= actual_patient_class.substring(0,1);
		String freq_nature_ivpb			= request.getParameter("freq_nature")==null?"":request.getParameter("freq_nature");
		String take_home_medication = request.getParameter("take_home_medication")==null?"":request.getParameter("take_home_medication");
		if(episode_type.equals("X"))
			episode_type = "R";

		String durn_value					= "";
		String infusion_over				= "";
		String lstInfusionRateDurnUnit		= "";
		float dur1							= 0.0f;
		HashMap drugDetails					= new HashMap();
		String item_code					= "";
		String drug_code					= "";
		String drug_desc					= "";
		String dosage_type					= "";
		String repeat_value					= "";
		String strength_per_value_pres_uom	= "";
		String strength_per_pres_uom		= "";
		String content_in_pres_base_uom		= "";
		String fract_dose					= "";
		String bl_included_IE				= "";
		String bl_incl_excl_override_value	= "";
		String bl_override_reason_code		= "";
		String bl_override_reason_desc		= "";
		String bl_charge_amt				= "";
		String bl_patient_payable			= "";
		String bl_apprvl_reqd_yn			= "";
		String bl_apprvl_reqd_gif			= "";
		String bl_override_allowed_yn		= "";
		String bl_decimal_format_string		= "#0.00";
		String bl_included_IE_gif			= "";
		String bl_override_checked			= "";
		String bl_override_disable			= "";
		String bl_error_code				= "";
		String bl_sys_message_id			= "";
		String bl_error_text				= "";
		double bl_tot_charge_amt			= 0.0;
		double bl_tot_patient_payable		= 0.0;
		String ordered_qty					= "";
		double iOrdQty						= 0;
		String totalGrossAmountStr          = ""; // Added for ML-BRU-CRF-0469 [IN:065426]
		String tot_payable_sum_str			= "";
		String pat_payable_sum_str			= "";
		String in_formulary_yn				= "";
		String fluid_code					= "";
		String fluid_name					= "";
		String qty_unit						= "";
		String ing_order_uom				= "";
		String order_uom					= "";
		String eqvl_value					= "";
		String include_selected				= "";
	    String exclude_selected				= "";
	    String billable_item_yn				= "";
		HashMap MultiFlowRecs				= new HashMap();
		DecimalFormat dfTest = dfTest = new DecimalFormat(bl_decimal_format_string);
		ArrayList blErrorDrugs				= new ArrayList();
		int drug_index						= 0;
		double totalGrossAmount             = 0.0; // Added for ML-BRU-CRF-0469 [IN:065426] - Strat
		String grossAmount                  = ""; 
		Connection con=null;
		boolean displayGrossAmtYn           = false;
		try{
			con = ConnectionManager.getConnection(request);
			displayGrossAmtYn = CommonBean.isSiteSpecific(con, "PH", "GROSS_AMT_DISPLY_YN");
		}
		catch(Exception e){
			e.printStackTrace();
			displayGrossAmtYn = false;
		}
		finally{
			ConnectionManager.returnConnection(con,request);
		}  // Added for ML-BRU-CRF-0469 [IN:065426] - End
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>

		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../js/ChargeDetail.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title><fmt:message key="Common.ChargeDetails.label" bundle="${common_labels}"/></title>
	</head>
	<!-- <body> -->
	<body onMouseDown="" onKeyDown="lockKey()">
		<form name='chargeDetailForm' id='chargeDetailForm'>
			<table border="0" width="100%" cellspacing="0" cellpadding="0">
				<tr>
					<td class='COLUMNHEADER' width='30%'><fmt:message key="Common.Drug.label" bundle="${common_labels}"/>/<fmt:message key="ePH.Fluid.label" bundle="${ph_labels}"/>/<fmt:message key="Common.MedicalItem.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER' width='6%'><fmt:message key="Common.Included.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER' width='6%'><fmt:message key="ePH.OverrideIncl/Excl.label" bundle="${ph_labels}"/></td>
					<td class='COLUMNHEADER' width='30%'><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
					<%if(displayGrossAmtYn){ // Added for ML-BRU-CRF-0469 [IN:065426] - Start %>
					<td class='COLUMNHEADER' width='10%' style='TEXT-ALIGN:center;'><fmt:message key="ePH.GrossAmount.label" bundle="${ph_labels}"/></td>
					<%} // Added for ML-BRU-CRF-0469 [IN:065426] - End %>
					<td class='COLUMNHEADER' width='10%' style='TEXT-ALIGN:center;'><fmt:message key="Common.ChargeAmount.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER' width='10%' style='TEXT-ALIGN:center;'><fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER' width='7'><fmt:message key="ePH.ApprReqd.label" bundle="${ph_labels}"/></td>
				</tr>
<%

				if(rx_order_type.equals("MS")){
					ConsumableOrderBean bean			= (ConsumableOrderBean)getBeanObject( bean_id, bean_name, request );
					drugList = bean.getPresItemList();
					String selected_yn="";
					
					for (int i=0; i<drugList.size(); i++) {
						drugDetails	= (HashMap)drugList.get(i);
						selected_yn =(String)drugDetails.get("SELECTED_YN")==null?"Y":(String)drugDetails.get("SELECTED_YN");
						if(selected_yn.equals("N"))
							continue;
						item_code				 = (String)drugDetails.get("ITEM_CODE")==null?"":(String)drugDetails.get("ITEM_CODE");         
						drug_desc				 = (String)drugDetails.get("ITEM_DESC")==null?"":(String)drugDetails.get("ITEM_DESC");        
						ordered_qty				 = (String)drugDetails.get("QTY_VALUE");
						bean.setBillingDetail(drugDetails, episode_type, patient_id, encounter_id, item_code, ordered_qty,take_home_medication);
						billable_item_yn =(String)drugDetails.get("BILLABLE_ITEM_YN")==null?"":(String)drugDetails.get("BILLABLE_ITEM_YN"); 
						if(billable_item_yn.equals("Y")){
							bl_included_IE			    = (String)drugDetails.get("BL_INCL_EXCL_VALUE")==null?"":(String)drugDetails.get("BL_INCL_EXCL_VALUE");          
							bl_incl_excl_override_value = (String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_VALUE")==null?"":(String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_VALUE");
							bl_override_reason_code     = (String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON")==null?"":(String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON");
							bl_override_reason_desc     = (String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC")==null?"":(String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC");
							bl_charge_amt			    = (String)drugDetails.get("BL_CHARGE_AMT")==null?"0.0":(String)drugDetails.get("BL_CHARGE_AMT");           
							bl_patient_payable		    = (String)drugDetails.get("BL_PATIENT_PAYABLE")==null?"0.0":(String)drugDetails.get("BL_PATIENT_PAYABLE"); 
                                			bl_apprvl_reqd_yn		    = (String)drugDetails.get("BL_APPRVL_REQD_YN")==null?"":(String)drugDetails.get("BL_APPRVL_REQD_YN");       
							 if(displayGrossAmtYn){ // Added for ML-BRU-CRF-0469 [IN:065426] - Start
								  grossAmount		    = (String)drugDetails.get("BL_GROSS_AMT")==null?"0.0":(String)drugDetails.get("BL_GROSS_AMT");
								 } // Added for ML-BRU-CRF-0469 [IN:065426] - End       
							bl_decimal_format_string    = (String)drugDetails.get("BL_DECIMAL_FORMAT_STRING")==null?"#0":(String)drugDetails.get("BL_DECIMAL_FORMAT_STRING");
							bl_override_allowed_yn	    = (String)drugDetails.get("BL_OVERRIDE_ALLOWED_YN")==null?"":(String)drugDetails.get("BL_OVERRIDE_ALLOWED_YN");
							bl_error_code			    = (String)drugDetails.get("BL_ERROR_CODE")==null?"":(String)drugDetails.get("BL_ERROR_CODE"); 
							bl_sys_message_id		    = (String)drugDetails.get("BL_SYS_MESSAGE_ID")==null?"":(String)drugDetails.get("BL_SYS_MESSAGE_ID");
							bl_error_text			    = (String)drugDetails.get("BL_ERROR_TEXT")==null?"":(String)drugDetails.get("BL_ERROR_TEXT");

							if ((bl_error_code.equals("10") && (!bl_error_text.equals(""))) ||!bl_sys_message_id.equals("")){
								blErrorDrugs.add(item_code);
								blErrorDrugs.add(drug_desc);
								blErrorDrugs.add(bl_error_code);
								blErrorDrugs.add(bl_sys_message_id);
								blErrorDrugs.add(bl_error_text);
								bl_charge_amt = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels");
								bl_patient_payable = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels");
								if(displayGrossAmtYn){  // Added for ML-BRU-CRF-0469 [IN:065426] - Start
									grossAmount = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels"); // Added for ML-BRU-CRF-0469 [IN:065426] 
								} // Added for ML-BRU-CRF-0469 [IN:065426] - End
							}
							else{
								//if( !bl_included_IE.equals("E") && (bl_incl_excl_override_value.equals("") || bl_incl_excl_override_value.equals("I"))){ //if condition commed for RUT-SCF-0188 [IN:039946]
									bl_tot_charge_amt      += Float.parseFloat(bl_charge_amt);
									bl_tot_patient_payable += Float.parseFloat(bl_patient_payable);
								//}
								if(displayGrossAmtYn){  // Added for ML-BRU-CRF-0469 [IN:065426] - Start
									totalGrossAmount       += Float.parseFloat(grossAmount); 
								} // Added for ML-BRU-CRF-0469 [IN:065426] - End
								dfTest                  = new DecimalFormat(bl_decimal_format_string);
							}

							if(bl_included_IE.equals("I"))
								bl_included_IE_gif = "<img src='../../eCommon/images/enabled.gif'></img>";
							else if(bl_included_IE.equals("E"))
								bl_included_IE_gif = "<img src='../../eCommon/images/disabled.gif'></img>";
							else
								bl_included_IE_gif = "&nbsp;";

							//commented for BL CRF 0001     
							/*if(!bl_incl_excl_override_value.equals(""))
								bl_override_checked = "checked";
							else
								bl_override_checked = "";

							if(bl_override_allowed_yn.equals("Y"))
								bl_override_disable = "";
							else
								bl_override_disable = "disabled";
							*/

							//added for BL CRF 0001     

							if(bl_override_allowed_yn.equals(""))
								bl_override_disable = "disabled";
							else
								bl_override_disable = "";

							if(!bl_override_reason_desc.equals("")){
								if(bl_incl_excl_override_value.equals("I")){
									include_selected ="selected";
								}
								else if(bl_incl_excl_override_value.equals("E")){
									exclude_selected ="selected";
								}
							}
							// ends here

							if(bl_apprvl_reqd_yn.equals("Y"))
								bl_apprvl_reqd_gif = "<img src='../../eCommon/images/enabled.gif'></img>";
							else if(bl_apprvl_reqd_yn.equals("N"))
								bl_apprvl_reqd_gif= "<img src='../../eCommon/images/disabled.gif'></img>";
							else
								bl_apprvl_reqd_gif = "&nbsp;";
						}
						else{
							bl_included_IE		       ="";	   
							bl_incl_excl_override_value="";
							bl_override_reason_code    ="";
							bl_override_reason_desc    =""; 
							bl_charge_amt			   ="";
							bl_patient_payable		   ="";
							bl_apprvl_reqd_yn		   ="";
							bl_decimal_format_string   ="";
							bl_override_allowed_yn	   ="";
							bl_error_code			   ="";
							bl_sys_message_id		   ="";
							bl_error_text			   ="";
							bl_included_IE_gif         = "&nbsp;";
							bl_apprvl_reqd_gif         = "&nbsp;";
						}

						iOrdQty = Math.ceil(Float.parseFloat(ordered_qty));
%>
						<tr>
							<td class='label'><%=drug_desc%></td>
							<input type='hidden' name='drug_code_<%=drug_index%>' id='drug_code_<%=drug_index%>' value='<%=item_code%>'>
							<input type='hidden' name='fluid_yn_<%=drug_index%>' id='fluid_yn_<%=drug_index%>' value='N'>
							<td class='label' style='TEXT-ALIGN:right;'><%=iOrdQty%>&nbsp;&nbsp;</td>
<%
							if(billable_item_yn.equals("Y")){
%>
								<td class='label'  id='bl_included_IE_gif_<%=drug_index%>'><%=bl_included_IE_gif%></td>
								<td class='label'>
									<!-- <input type='checkbox' name='bl_overide_yn_<%=drug_index%>' id='bl_overide_yn_<%=drug_index%>' <%=bl_override_checked%> <%=bl_override_disable%> value='<%=bl_incl_excl_override_value%>' onclick="assignOverrideExclInclInd(this,'<%=bl_included_IE%>','<%=drug_index%>','<%=locale%>');"> -->
									<select name="bl_overide_yn_<%=drug_index%>" id="bl_overide_yn_<%=drug_index%>" onchange="assignOverrideExclInclInd(this,'<%=bl_included_IE%>','<%=drug_index%>','<%=locale%>');"  <%=bl_override_disable%>>
									   <option value="SEL">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
										<%if(bl_override_allowed_yn.equals("I"))%>
											<option value="I" <%=include_selected%>><fmt:message key="Common.Include.label" bundle="${common_labels}"/></option>
										<%if(bl_override_allowed_yn.equals("E"))%>
											<option value="E" <%=exclude_selected%> ><fmt:message key="Common.Exclude.label" bundle="${common_labels}"/></option>
										<%if(bl_override_allowed_yn.equals("B")){%>
											<option value="I" <%=include_selected%> ><fmt:message key="Common.Include.label" bundle="${common_labels}"/></option>
											<option value="E" <%=exclude_selected%> ><fmt:message key="Common.Exclude.label" bundle="${common_labels}"/></option>
										<%}%>														
									</select>
								</td>
								<td class='field'>
									<input type='text' name='bl_override_reason_desc_<%=drug_index%>' id='bl_override_reason_desc_<%=drug_index%>' value='<%=bl_override_reason_desc%>' readonly size='26'>
									<input type="button" name="bl_overriden_reason_lkp_<%=drug_index%>" id="bl_overriden_reason_lkp_<%=drug_index%>" value="?" class="button" onClick="searchBLOverrideReason('<%=locale%>','<%=drug_index%>');" <%=bl_override_disable%>><img  src="../../eCommon/images/mandatory.gif" id='bl_overriden_action_reason_img_<%=drug_index%>' style='visibility:hidden;'>
									<input type='hidden' name='bl_override_reason_code_<%=drug_index%>' id='bl_override_reason_code_<%=drug_index%>' value='<%=bl_override_reason_code%>'>
								</td>
								<%if(displayGrossAmtYn){ // Added for ML-BRU-CRF-0469 - Start %>
								<td class='label' style='TEXT-ALIGN:right;' id='bl_gross_amt_<%=drug_index%>'><%=grossAmount%>&nbsp;&nbsp;</td>
								<%} // Added for ML-BRU-CRF-0469 - End %>
								<td class='label' style='TEXT-ALIGN:right;' id='bl_charge_amt_<%=drug_index%>'><%=bl_charge_amt%>&nbsp;&nbsp;</td>
								<td class='label' style='TEXT-ALIGN:right;' id='bl_patient_payable_<%=drug_index%>'><%=bl_patient_payable%>&nbsp;&nbsp;</td>
								<td class='label' id='bl_apprvl_reqd_gif_<%=drug_index%>'><%=bl_apprvl_reqd_gif%></td>
<%								}
							else{
%>
								<td class='label'  id='bl_included_IE_gif_<%=drug_index%>'></td>
								<td class='label' style='visibility:hidden;'>
										<select name="bl_overide_yn_<%=drug_index%>" id="bl_overide_yn_<%=drug_index%>" onchange="assignOverrideExclInclInd(this,'<%=bl_included_IE%>','<%=drug_index%>','<%=locale%>');"  <%=bl_override_disable%>>

										   <option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>													
												
										</select>
								</td>
								<td class='field'>
									<input type='hidden' name='bl_override_reason_desc_<%=drug_index%>' id='bl_override_reason_desc_<%=drug_index%>' value='' >
									<input type='hidden' name='bl_override_reason_code_<%=drug_index%>' id='bl_override_reason_code_<%=drug_index%>' value=''>
								</td>
								
<%								}
%>
							</tr>
<%
							drug_index++;
					}

				}
				else{
					if(!iv_prep_yn.equals("") && (Integer.parseInt(iv_prep_yn)<=6)){
						rx_order_type="IV";
						String iv_calc_infuse_by = request.getParameter("iv_calc_infuse_by")==null?"":request.getParameter("iv_calc_infuse_by");
						drug_index = 0;
						IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject(bean_id, bean_name, request);
						if(iv_prep_yn.equals("5"))
							drugList = bean.getAllFluids();
						else
							drugList = bean.getDrugDetails();

						if(drugList!=null && drugList.size()>0){
							if(iv_prep_yn.equals("1") || iv_prep_yn.equals("2") || iv_prep_yn.equals("3") || iv_prep_yn.equals("4")){
								//IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject(bean_id, bean_name, request);
								fluid_code			= request.getParameter("fluid_code")==null?"":request.getParameter("fluid_code");
								//String mfr_yn = (String)request.getParameter("MFR_YN")==null?"":request.getParameter("MFR_YN");
								if(mfr_yn.equals("Y")){
									MultiFlowRecs = bean.getMFRRecs();
									if(MultiFlowRecs != null && MultiFlowRecs.size() > 0){
										durn_value= (String)MultiFlowRecs.get("totFlowDurnHrs")==null?"":(String)MultiFlowRecs.get("totFlowDurnHrs");
										//infuse over wil be same as duration in case of mfr coz flow duration is sum of the infuse over value. 
										infusion_over = durn_value;
										lstInfusionRateDurnUnit = "H";
									}
								}
								else{
									durn_value = request.getParameter("durn_value")==null?"":request.getParameter("durn_value");
									if(iv_calc_infuse_by.equals("I"))
										durn_value = request.getParameter("infusion_over")==null?"":request.getParameter("infusion_over");
									infusion_over = request.getParameter("infusion_over")==null?"":request.getParameter("infusion_over");
									lstInfusionRateDurnUnit = request.getParameter("lstInfusionRateDurnUnit")==null?"":request.getParameter("lstInfusionRateDurnUnit");
								}
								/*if(lstInfusionRateDurnUnit.equals("M")){
									//infusion_over = Float.parseFloat(infusion_over)/60+"";
								}*/
								if(!fluid_code.equals("") && !fluid_code.equals((String)((HashMap)drugList.get(0)).get("DRUG_CODE"))) {
			
									order_uom = bean.getStockUOM(fluid_code);
									fluidDetails = bean.getFluidDetails();
									item_code			= (String)fluidDetails.get("ITEM_CODE")==null?"":(String)fluidDetails.get("ITEM_CODE");
									in_formulary_yn = (String)fluidDetails.get("IN_FORMULARY_YN")==null?"":(String)fluidDetails.get("IN_FORMULARY_YN");

									if(in_formulary_yn.equals("Y") /*&& !item_code.equals("")*/){
										ordered_qty		    = (String)fluidDetails.get("ORDERED_QTY");
										repeat_value		= (String)fluidDetails.get("REPEAT_VALUE");
										fluid_name			= (String)fluidDetails.get("DRUG_DESC");
										bean.setBillingDetail(fluidDetails, episode_type, patient_id, encounter_id, fluid_code, ordered_qty,take_home_medication );
										billable_item_yn =(String)fluidDetails.get("BILLABLE_ITEM_YN")==null?"":(String)fluidDetails.get("BILLABLE_ITEM_YN"); 
                                        if(billable_item_yn.equals("Y")){
											bl_included_IE = (String)fluidDetails.get("BL_INCL_EXCL_VALUE")==null?"":(String)fluidDetails.get("BL_INCL_EXCL_VALUE");          
											bl_incl_excl_override_value = (String)fluidDetails.get("BL_INCL_EXCL_OVERRIDE_VALUE")==null?"":(String)fluidDetails.get("BL_INCL_EXCL_OVERRIDE_VALUE");       
											bl_override_reason_code = (String)fluidDetails.get("BL_INCL_EXCL_OVERRIDE_REASON")==null?"":(String)fluidDetails.get("BL_INCL_EXCL_OVERRIDE_REASON");
											bl_override_reason_desc = (String)fluidDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC")==null?"":(String)fluidDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC");
											if((String)fluidDetails.get("BL_CHARGE_AMT")==null || (String)fluidDetails.get("BL_CHARGE_AMT")=="")
												bl_charge_amt = "0.0";           
											else
												bl_charge_amt =(String)fluidDetails.get("BL_CHARGE_AMT");
											if(displayGrossAmtYn){ // Added for ML-BRU-CRF-0469 [IN:065426] - Start
												  grossAmount		    = (String)drugDetails.get("BL_GROSS_AMT")==null?"0.0":(String)drugDetails.get("BL_GROSS_AMT");
											} // Added for ML-BRU-CRF-0469 [IN:065426] - End 
											bl_patient_payable = (String)fluidDetails.get("BL_PATIENT_PAYABLE")==null?"0.0":(String)fluidDetails.get("BL_PATIENT_PAYABLE"); 
											bl_apprvl_reqd_yn = (String)fluidDetails.get("BL_APPRVL_REQD_YN")==null?"":(String)fluidDetails.get("BL_APPRVL_REQD_YN");       
											bl_decimal_format_string = (String)fluidDetails.get("BL_DECIMAL_FORMAT_STRING")==null?"#0.00":(String)fluidDetails.get("BL_DECIMAL_FORMAT_STRING");
											bl_override_allowed_yn = (String)fluidDetails.get("BL_OVERRIDE_ALLOWED_YN")==null?"":(String)fluidDetails.get("BL_OVERRIDE_ALLOWED_YN");
											bl_error_code			= (String)drugDetails.get("BL_ERROR_CODE")==null?"":(String)drugDetails.get("BL_ERROR_CODE"); 
											bl_sys_message_id		= (String)drugDetails.get("BL_SYS_MESSAGE_ID")==null?"":(String)drugDetails.get("BL_SYS_MESSAGE_ID");
											bl_error_text			= (String)drugDetails.get("BL_ERROR_TEXT")==null?"":(String)drugDetails.get("BL_ERROR_TEXT");

											if ((bl_error_code.equals("10") && (!bl_error_text.equals(""))) ||!bl_sys_message_id.equals("")){
												blErrorDrugs.add(fluid_code);
												blErrorDrugs.add(fluid_name);
												blErrorDrugs.add(bl_error_code);
												blErrorDrugs.add(bl_sys_message_id);
												blErrorDrugs.add(bl_error_text);							
												bl_charge_amt = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels");
												bl_patient_payable = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels");
												if(displayGrossAmtYn){  // Added for ML-BRU-CRF-0469 [IN:065426] - Start
													grossAmount = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels"); // Added for ML-BRU-CRF-0469 [IN:065426] 
												} // Added for ML-BRU-CRF-0469 [IN:065426] - End
											}
											else{
												//if( !bl_included_IE.equals("E") && (bl_incl_excl_override_value.equals("") || bl_incl_excl_override_value.equals("I"))){ //if condition commed for RUT-SCF-0188 [IN:039946]
													bl_tot_charge_amt += Float.parseFloat(bl_charge_amt);
													if(!bl_patient_payable.equals(""))
														bl_tot_patient_payable += Float.parseFloat(bl_patient_payable);
												//}
													if(displayGrossAmtYn){  // Added for ML-BRU-CRF-0469 [IN:065426] - Start
														totalGrossAmount       += Float.parseFloat(grossAmount); 
													} // Added for ML-BRU-CRF-0469 [IN:065426] - End
												dfTest = new DecimalFormat(bl_decimal_format_string);
											}

											if(bl_included_IE.equals("I"))
												bl_included_IE_gif= "<img src='../../eCommon/images/enabled.gif'></img>";
											else if(bl_included_IE.equals("E"))
												bl_included_IE_gif= "<img src='../../eCommon/images/disabled.gif'></img>";
											else
												bl_included_IE_gif = "&nbsp;";

											/*commented for BL CRF 0001
											if(!bl_incl_excl_override_value.equals(""))
												bl_override_checked = "checked";
											else
												bl_override_checked = "";
											
											if(bl_override_allowed_yn.equals("Y"))
												bl_override_disable = "";
											else
												bl_override_disable = "disabled";
											*/
											//added for BL CRF 0001     

											if(bl_override_allowed_yn.equals(""))
												bl_override_disable = "disabled";
											else
												bl_override_disable = "";

											if(!bl_override_reason_desc.equals("")){
												if(bl_incl_excl_override_value.equals("I")){
													include_selected ="selected";
												}
												else if(bl_incl_excl_override_value.equals("E")){
													exclude_selected ="selected";
												}
											}
											// ends here

											if(bl_apprvl_reqd_yn.equals("Y"))
												bl_apprvl_reqd_gif = "<img src='../../eCommon/images/enabled.gif'></img>";
											else if(bl_apprvl_reqd_yn.equals("N"))
												bl_apprvl_reqd_gif= "<img src='../../eCommon/images/disabled.gif'></img>";
											else
												bl_apprvl_reqd_gif = "&nbsp;";
									}
									else{
										bl_included_IE				="";
										bl_incl_excl_override_value	="";
										bl_override_reason_code		="";
										bl_override_reason_desc		="";
										bl_patient_payable			="";
										bl_apprvl_reqd_yn			="";
										bl_decimal_format_string	="";
										bl_override_allowed_yn		="";
										bl_error_code				="";
										bl_sys_message_id			="";
										bl_error_text				="";
										bl_included_IE				="";
										bl_apprvl_reqd_gif			="";
									}
									iOrdQty = Math.ceil(Float.parseFloat(ordered_qty));
									if(!fluid_code.equals((String)((HashMap)drugList.get(0)).get("DRUG_CODE"))){
%>
										<tr>
											<td class='label'><%=fluid_name%></td>
											<input type='hidden' name='drug_code_<%=drug_index%>' id='drug_code_<%=drug_index%>' value='<%=fluid_code%>'>
											<input type='hidden' name='fluid_yn_<%=drug_index%>' id='fluid_yn_<%=drug_index%>' value='Y'>
											<td class='label' style='TEXT-ALIGN:right;'><%=iOrdQty%>&nbsp;<%=order_uom%>&nbsp;</td>
<%											if(billable_item_yn.equals("Y")){
%>
											<td class='label' id='bl_included_IE_gif_<%=drug_index%>'><%=bl_included_IE_gif%></td>
											<td class='label'>
												<!-- <input type='checkbox' name='bl_overide_yn_<%=drug_index%>' id='bl_overide_yn_<%=drug_index%>' <%=bl_override_checked%> <%=bl_override_disable%> value='<%=bl_incl_excl_override_value%>' onclick="assignOverrideExclInclInd(this,'<%=bl_included_IE%>','<%=drug_index%>','<%=locale%>');"> -->
												<select name="bl_overide_yn_<%=drug_index%>" id="bl_overide_yn_<%=drug_index%>" onchange="assignOverrideExclInclInd(this,'<%=bl_included_IE%>','<%=drug_index%>','<%=locale%>');"  <%=bl_override_disable%>>
												   <option value="SEL">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
													<%if(bl_override_allowed_yn.equals("I"))%>
														<option value="I" <%=include_selected%>><fmt:message key="Common.Include.label" bundle="${common_labels}"/></option>
													<%if(bl_override_allowed_yn.equals("E"))%>
														<option value="E" <%=exclude_selected%> ><fmt:message key="Common.Exclude.label" bundle="${common_labels}"/></option>
													<%if(bl_override_allowed_yn.equals("B")){%>
														<option value="I" <%=include_selected%> ><fmt:message key="Common.Include.label" bundle="${common_labels}"/></option>
														<option value="E" <%=exclude_selected%> ><fmt:message key="Common.Exclude.label" bundle="${common_labels}"/></option>
													 <%}%>
														
												</select>
												</td>
												<td class='field'>
													<input type='text' name='bl_override_reason_desc_<%=drug_index%>' id='bl_override_reason_desc_<%=drug_index%>' value='<%=bl_override_reason_desc%>' readonly size='26'>
													<input type="button" name="bl_overriden_reason_lkp_<%=drug_index%>" id="bl_overriden_reason_lkp_<%=drug_index%>" value="?" class="button" onClick="searchBLOverrideReason('<%=locale%>','<%=drug_index%>');" <%=bl_override_disable%>><img  src="../../eCommon/images/mandatory.gif" id='bl_overriden_action_reason_img_<%=drug_index%>' style='visibility:hidden;'>
													<input type='hidden' name='bl_override_reason_code_<%=drug_index%>' id='bl_override_reason_code_<%=drug_index%>' value='<%=bl_override_reason_code%>'>
												</td>
												<%if(displayGrossAmtYn){ // Added for ML-BRU-CRF-0469 - Start %>
										        <td class='label' style='TEXT-ALIGN:right;' id='bl_gross_amt_<%=drug_index%>'><%=grossAmount%>&nbsp;&nbsp;</td>
										        <%} // Added for ML-BRU-CRF-0469 - End %>
												<td class='label' style='TEXT-ALIGN:right;' id='bl_charge_amt_<%=drug_index%>'><%=bl_charge_amt%>&nbsp;&nbsp;</td>
												<td class='label' style='TEXT-ALIGN:right;' id='bl_patient_payable_<%=drug_index%>'><%=bl_patient_payable%>&nbsp;&nbsp;</td>
												<td class='label' id='bl_apprvl_reqd_gif_<%=drug_index%>'><%=bl_apprvl_reqd_gif%></td>
<%
											}
											else{
%>
												<td class='label'  id='bl_included_IE_gif_<%=drug_index%>'></td>
												<td class='label' style='visibility:hidden;'>
													<select name="bl_overide_yn_<%=drug_index%>" id="bl_overide_yn_<%=drug_index%>" onchange="assignOverrideExclInclInd(this,'<%=bl_included_IE%>','<%=drug_index%>','<%=locale%>');"  <%=bl_override_disable%>>
													<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>										</select>
												</td>
												<td class='field'>
													<input type='hidden' name='bl_override_reason_desc_<%=drug_index%>' id='bl_override_reason_desc_<%=drug_index%>' value='' >
													<input type='hidden' name='bl_override_reason_code_<%=drug_index%>' id='bl_override_reason_code_<%=drug_index%>' value=''>
												</td>
													
<%											
											}
%>
											</tr>
											<tr height='2'><td colspan='8'>&nbsp;</td></tr>
<%
											drug_index++;
										}
									}
								}
							}
							for (int i=0; i<drugList.size(); i++) {

								drugDetails	= (HashMap)drugList.get(i);
								HashMap freqNature = null;
								in_formulary_yn = (String)drugDetails.get("IN_FORMULARY_YN")==null?"":(String)drugDetails.get("IN_FORMULARY_YN");
								item_code = (String)drugDetails.get("ITEM_CODE")==null?"":(String)drugDetails.get("ITEM_CODE");

								if(item_code.equals(""))
									item_code = (String)drugDetails.get("ORDER_CATALOG_CODE");

								if(in_formulary_yn.equals("Y") && !item_code.equals("")){

									drug_code = (String)drugDetails.get("DRUG_CODE")==null?"":(String)drugDetails.get("DRUG_CODE");
									drug_desc = (String)drugDetails.get("DRUG_DESC")==null?"":(String)drugDetails.get("DRUG_DESC");
									order_uom = bean.getStockUOM(drug_code);

									if(iv_prep_yn.equals("1") || iv_prep_yn.equals("2") || iv_prep_yn.equals("3") || iv_prep_yn.equals("4")){
										dosage_type = (String)drugDetails.get("DOSAGE_TYPE")==null?"":(String)drugDetails.get("DOSAGE_TYPE"); 
										repeat_value = (String)drugDetails.get("REPEAT_VALUE")==null?"1":(String)drugDetails.get("REPEAT_VALUE"); 
										strength_per_value_pres_uom = (String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM")==null?"":(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");
										strength_per_pres_uom = (String)drugDetails.get("STRENGTH_PER_PRES_UOM")==null?"":(String)drugDetails.get("STRENGTH_PER_PRES_UOM");
										content_in_pres_base_uom = (String)drugDetails.get("CONTENT_IN_PRES_BASE_UOM")==null?"":(String)drugDetails.get("CONTENT_IN_PRES_BASE_UOM");

										float ing_unit_qty		= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
										float in_tot_qty = 0.0f;
										fract_dose					=   bean.getFractDoseRndyn((String)drugDetails.get("DRUG_CODE"));
										dur1			= Float.parseFloat(durn_value);
										if(mfr_yn.equals("Y")){
											MultiFlowRecs = bean.getMFRRecs();
										}
										if(iv_prep_yn.equals("3") || iv_prep_yn.equals("4")){
											//dur1=dur1/24;
											HashMap freqDet = bean.getscheduleFrequency();
											String freqDurnType = "";
											String freq_code = (String)request.getParameter("freq_code")==null?"":(String)request.getParameter("freq_code");
											freqNature			=(HashMap)bean.freqValidate(freq_code);
											if(freq_nature_ivpb.equals("I")){
												
												freqDurnType =  (String)freqNature.get("interval_durn_type");
											}
											else{
												freqDurnType = (String)(((HashMap)(((ArrayList)freqDet.get(drug_code)).get(0))).get("durationType"))==null?"":(String)(((HashMap)(((ArrayList)freqDet.get(drug_code)).get(0))).get("durationType"));
											}
											String durn_unit = (String)request.getParameter("durn_unit")==null?"":(String)request.getParameter("durn_unit");

											if(! freqDurnType.equals(durn_unit)) {
												int durn_calc = bean.getDurationCalc(durn_unit,durn_value,freqDurnType);
												dur1 = Float.parseFloat(durn_calc+"");
											}
											float interval_repeat = Float.parseFloat((String)freqNature.get("interval_value")==null?"1":(String)freqNature.get("interval_value"));
											if(freq_nature_ivpb.equals("I") || (freq_nature_ivpb.equals("F") && interval_repeat > 1 )){
												dur1 = dur1 / interval_repeat;
											}
											repeat_value			= bean.getRepeatValue();
											ing_unit_qty = Float.parseFloat(bean.getDOSAGE());
											//ing_unit_qty = Float.parseFloat(request.getParameter("drug_dosage"));
										}
										else{
											if(iv_calc_infuse_by.equals("I"))
												dur1=1;
											else
												dur1			= Float.parseFloat(Math.ceil(((Float.parseFloat(durn_value) / (Float.parseFloat(infusion_over)))*100)/100)+"");
										}
										if(MultiFlowRecs != null && MultiFlowRecs.size() > 0){
											/*durn_value= (String)MultiFlowRecs.get("totFlowDurnHrs")==null?"":(String)MultiFlowRecs.get("totFlowDurnHrs");
											dur1 = durn_value;*/
											dur1 = 1;
										}

										if(dosage_type!=null){
											if(dosage_type.equals("S")) {				
												strength_per_value_pres_uom	=	(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");	
												strength_per_pres_uom		=	(String)drugDetails.get("STRENGTH_PER_PRES_UOM");

												if(fract_dose.equals("Y")){
													in_tot_qty	=new Double(Math.ceil(ing_unit_qty/Float.parseFloat(strength_per_pres_uom))).floatValue() * Float.parseFloat(strength_per_value_pres_uom);
													//ordered_qty		=   Math.ceil((in_tot_qty*dur1)/Float.parseFloat(content_in_pres_base_uom))+"";
													ordered_qty		=	(new Double(Math.ceil(in_tot_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue()*dur1)+"";
												}
												else if(fract_dose.equals("N")){
													in_tot_qty	= (ing_unit_qty*Float.parseFloat(strength_per_value_pres_uom))/(Float.parseFloat(strength_per_pres_uom)); 
													//ing_order_uom	= (String)drugDetails.get("STRENGTH_UOM");
													ordered_qty		=   ((in_tot_qty*dur1)/Float.parseFloat(content_in_pres_base_uom))+"";
												}
											}
											else {
												qty_unit				= (String)drugDetails.get("QTY_DESC_CODE");
												ing_order_uom		= (String)drugDetails.get("PRES_BASE_UOM");
												eqvl_value			=  bean.getConvFactor(ing_order_uom,qty_unit);
												if(eqvl_value.equals(""))	eqvl_value	=	"1";	
													in_tot_qty = ing_unit_qty*Float.parseFloat(eqvl_value);
												if(fract_dose.equals("Y")){
													ordered_qty	=   (new Double(Math.ceil(in_tot_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue()*dur1)+"";
												}
												else if(fract_dose.equals("N")){
													ordered_qty	=   ((in_tot_qty*dur1)/Float.parseFloat(content_in_pres_base_uom))+"";
												}
											}	
										}

										if(iv_prep_yn.equals("3") || iv_prep_yn.equals("4")){
											if(freq_nature_ivpb.equals("I")){
												ordered_qty=Math.ceil(Float.parseFloat(ordered_qty))+"";
											}
											else{
												 if(fract_dose.equals("N")){
													 ordered_qty=Math.ceil(Float.parseFloat(ordered_qty) * Float.parseFloat(repeat_value))+"";
												}
												else{
													ordered_qty=Float.parseFloat(ordered_qty) * Float.parseFloat(repeat_value)+"";
												}
											}
										}
										drugDetails.put("ORDERED_QTY",ordered_qty);
									}
									else if(iv_prep_yn.equals("5") || iv_prep_yn.equals("6")){
										ordered_qty = (String)drugDetails.get("ORDERED_QTY");
									}
									bean.setBillingDetail(drugDetails, episode_type, patient_id, encounter_id, item_code, ordered_qty,take_home_medication);
									billable_item_yn =(String)drugDetails.get("BILLABLE_ITEM_YN")==null?"":(String)drugDetails.get("BILLABLE_ITEM_YN"); 
									if(billable_item_yn.equals("Y")){
										bl_included_IE          = (String)drugDetails.get("BL_INCL_EXCL_VALUE")==null?"":(String)drugDetails.get("BL_INCL_EXCL_VALUE"); 
										bl_incl_excl_override_value = (String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_VALUE")==null?"":(String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_VALUE"); 
										bl_override_reason_code  = (String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON")==null?"":(String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON");
										bl_override_reason_desc  = (String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC")==null?"":(String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC");

										bl_charge_amt            = (String)drugDetails.get("BL_CHARGE_AMT")==null?"0.0":(String)drugDetails.get("BL_CHARGE_AMT");
										bl_patient_payable       = (String)drugDetails.get("BL_PATIENT_PAYABLE")==null?"0.0":(String)drugDetails.get("BL_PATIENT_PAYABLE");  
										bl_apprvl_reqd_yn        = (String)drugDetails.get("BL_APPRVL_REQD_YN")==null?"":(String)drugDetails.get("BL_APPRVL_REQD_YN");
										bl_decimal_format_string = (String)drugDetails.get("BL_DECIMAL_FORMAT_STRING")==null?"#0":(String)drugDetails.get("BL_DECIMAL_FORMAT_STRING");
										bl_override_allowed_yn   = (String)drugDetails.get("BL_OVERRIDE_ALLOWED_YN")==null?"":(String)drugDetails.get("BL_OVERRIDE_ALLOWED_YN");
										if(displayGrossAmtYn){ // Added for ML-BRU-CRF-0469 [IN:065426] - Start
											  grossAmount		    = (String)drugDetails.get("BL_GROSS_AMT")==null?"0.0":(String)drugDetails.get("BL_GROSS_AMT");
										} // Added for ML-BRU-CRF-0469 [IN:065426] - End 
										bl_error_code			 = (String)drugDetails.get("BL_ERROR_CODE")==null?"":(String)drugDetails.get("BL_ERROR_CODE"); 
										bl_sys_message_id		 = (String)drugDetails.get("BL_SYS_MESSAGE_ID")==null?"":(String)drugDetails.get("BL_SYS_MESSAGE_ID");
										bl_error_text			 = (String)drugDetails.get("BL_ERROR_TEXT")==null?"":(String)drugDetails.get("BL_ERROR_TEXT");
										if ((bl_error_code.equals("10") && (!bl_error_text.equals(""))) ||!bl_sys_message_id.equals("")){
											blErrorDrugs.add(drug_code);
											blErrorDrugs.add(drug_desc);
											blErrorDrugs.add(bl_error_code);
											blErrorDrugs.add(bl_sys_message_id);
											blErrorDrugs.add(bl_error_text);
											bl_charge_amt = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels");
											bl_patient_payable = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels");
											if(displayGrossAmtYn){  // Added for ML-BRU-CRF-0469 [IN:065426] - Start
												grossAmount = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels"); // Added for ML-BRU-CRF-0469 [IN:065426] 
											} // Added for ML-BRU-CRF-0469 [IN:065426] - End
										}
										else{
											//if( !bl_included_IE.equals("E") && (bl_incl_excl_override_value.equals("") || bl_incl_excl_override_value.equals("I"))){ //if condition commed for RUT-SCF-0188 [IN:039946]
												if(!bl_charge_amt.equals(""))
													bl_tot_charge_amt += Float.parseFloat(bl_charge_amt);
												if(!bl_patient_payable.equals("")) 
													bl_tot_patient_payable += Float.parseFloat(bl_patient_payable);
											//}
												if(displayGrossAmtYn){  // Added for ML-BRU-CRF-0469 [IN:065426] - Start
													totalGrossAmount       += Float.parseFloat(grossAmount); 
												} // Added for ML-BRU-CRF-0469 [IN:065426] - End
											dfTest = new DecimalFormat(bl_decimal_format_string);
										}

										if(bl_included_IE.equals("I"))
											bl_included_IE_gif= "<img src='../../eCommon/images/enabled.gif'></img>";
										else if(bl_included_IE.equals("E"))
											bl_included_IE_gif= "<img src='../../eCommon/images/disabled.gif'></img>";
										else
											bl_included_IE_gif = "&nbsp;";
										
										/* commented for BL CRF 0001
										if(!bl_incl_excl_override_value.equals(""))
											bl_override_checked = "checked";
										else
											bl_override_checked = "";

										if(bl_override_allowed_yn.equals("Y"))
											bl_override_disable = "";
										else
											bl_override_disable = "disabled";
										*/
									   //done for BL CRF 0001
										 if(bl_override_allowed_yn.equals(""))
												bl_override_disable = "disabled";
										 else
												bl_override_disable = "";
				  
										include_selected="";
										exclude_selected="";
										if(!bl_override_reason_desc.equals("")){
											if(bl_incl_excl_override_value.equals("I")){
												include_selected ="selected";
											}
											else if(bl_incl_excl_override_value.equals("E")){
												exclude_selected ="selected";
											}
										} 

										// ends here
										if(bl_apprvl_reqd_yn.equals("Y"))
											bl_apprvl_reqd_gif = "<img src='../../eCommon/images/enabled.gif'></img>";
										else if(bl_apprvl_reqd_yn.equals("N"))
											bl_apprvl_reqd_gif= "<img src='../../eCommon/images/disabled.gif'></img>";
										else
											bl_apprvl_reqd_gif = "&nbsp;";
								}
								else{
									bl_included_IE				 ="";
									bl_incl_excl_override_value ="";
									bl_override_reason_code		="";
									bl_override_reason_desc		="";
									bl_charge_amt				="";
									bl_patient_payable			="";
									bl_apprvl_reqd_yn			="";
									bl_decimal_format_string="";
									bl_override_allowed_yn="";
									bl_error_code	="";	
									bl_sys_message_id="";	
									bl_error_text	="";
									bl_included_IE_gif="";
									bl_override_disable = "";
									bl_apprvl_reqd_gif = "&nbsp;";
								}
									//Added If condition for  handling Null(Ordered_qty) ===By Sandhya on 11/JAN/2011
									if(ordered_qty==null)									{
										ordered_qty="";
									}
									ordered_qty = ordered_qty.equals("")?"0":ordered_qty;
									
									iOrdQty = Math.ceil(Float.parseFloat(ordered_qty));
//									drugDetails.put("ORDERED_QTY",iOrdQty+"");
//									if(!fluid_code.equals(drug_code)){
//	if(true){
%>				
									<tr>
										<td class='label'><%=drug_desc%></td>
										<input type='hidden' name='drug_code_<%=drug_index%>' id='drug_code_<%=drug_index%>' value='<%=drug_code%>'>
										<input type='hidden' name='fluid_yn_<%=drug_index%>' id='fluid_yn_<%=drug_index%>' value='N'>
										<td class='label' style='TEXT-ALIGN:right;'><%=iOrdQty%>&nbsp;<%=order_uom%>&nbsp;</td>
<%									if(billable_item_yn.equals("Y")){
%>									

										<td class='label'  id='bl_included_IE_gif_<%=drug_index%>'><%=bl_included_IE_gif%></td>
										<td class='label'>
											<!-- <input type='checkbox' name='bl_overide_yn_<%=drug_index%>' id='bl_overide_yn_<%=drug_index%>' <%=bl_override_checked%> <%=bl_override_disable%> value='<%=bl_incl_excl_override_value%>' onclick="assignOverrideExclInclInd(this,'<%=bl_included_IE%>','<%=drug_index%>','<%=locale%>');"> -->
											<select name="bl_overide_yn_<%=drug_index%>" id="bl_overide_yn_<%=drug_index%>" onchange="assignOverrideExclInclInd(this,'<%=bl_included_IE%>','<%=drug_index%>','<%=locale%>');"  <%=bl_override_disable%>>

												   <option value="SEL">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
													<%if(bl_override_allowed_yn.equals("I"))%>
														<option value="I" <%=include_selected%>><fmt:message key="Common.Include.label" bundle="${common_labels}"/></option>
													<%if(bl_override_allowed_yn.equals("E"))%>
														<option value="E" <%=exclude_selected%>><fmt:message key="Common.Exclude.label" bundle="${common_labels}"/></option>
													<%if(bl_override_allowed_yn.equals("B")){%>
														<option value="I" <%=include_selected%> ><fmt:message key="Common.Include.label" bundle="${common_labels}"/></option>
														<option value="E" <%=exclude_selected%> ><fmt:message key="Common.Exclude.label" bundle="${common_labels}"/></option>
													 <%}%>
														
												</select>
										</td>
										<td class='field'>
											<input type='text' name='bl_override_reason_desc_<%=drug_index%>' id='bl_override_reason_desc_<%=drug_index%>' value='<%=bl_override_reason_desc%>' readonly size='26'>
											<input type="button" name="bl_overriden_reason_lkp_<%=drug_index%>" id="bl_overriden_reason_lkp_<%=drug_index%>" value="?" class="button" onClick="searchBLOverrideReason('<%=locale%>','<%=drug_index%>');" <%=bl_override_disable%>><img  src="../../eCommon/images/mandatory.gif" id='bl_overriden_action_reason_img_<%=drug_index%>' style='visibility:hidden;'>
											<input type='hidden' name='bl_override_reason_code_<%=drug_index%>' id='bl_override_reason_code_<%=drug_index%>' value='<%=bl_override_reason_code%>'>
										</td>
										<%if(displayGrossAmtYn){ // Added for ML-BRU-CRF-0469 - Start %>
										<td class='label' style='TEXT-ALIGN:right;' id='bl_gross_amt_<%=drug_index%>'><%=grossAmount%>&nbsp;&nbsp;</td>
										<%} // Added for ML-BRU-CRF-0469 - End %>
										<td class='label' style='TEXT-ALIGN:right;' id='bl_charge_amt_<%=drug_index%>'><%=bl_charge_amt%>&nbsp;&nbsp;</td>
										<td class='label' style='TEXT-ALIGN:right;' id='bl_patient_payable_<%=drug_index%>'><%=bl_patient_payable%>&nbsp;&nbsp;</td>
										<td class='label' id='bl_apprvl_reqd_gif_<%=drug_index%>'><%=bl_apprvl_reqd_gif%></td>
<%                                 
									}
									else{
%>
                                        <td class='label'  id='bl_included_IE_gif_<%=drug_index%>'></td>
										<td class='label' style='visibility:hidden;'>
												<select name="bl_overide_yn_<%=drug_index%>" id="bl_overide_yn_<%=drug_index%>" onchange="assignOverrideExclInclInd(this,'<%=bl_included_IE%>','<%=drug_index%>','<%=locale%>');"  <%=bl_override_disable%>>

												   <option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>													
														
												</select>
										</td>
										<td class='field'>
											<input type='hidden' name='bl_override_reason_desc_<%=drug_index%>' id='bl_override_reason_desc_<%=drug_index%>' value='' >
											<input type='hidden' name='bl_override_reason_code_<%=drug_index%>' id='bl_override_reason_code_<%=drug_index%>' value=''>
										</td>
										                                      

<%                                  }
%>
									</tr>
<%
								//	}
									drug_index++;
								}
							}
						}
					}
					else if(iv_prep_yn.equals("9") || iv_prep_yn.equals("0")){
						OncologyRegimenBean bean	= (OncologyRegimenBean)getBeanObject(bean_id, bean_name, request);
						HashMap CompFluidDetails = bean.getCompFluidDetails();

						rx_order_type="ONC";
						drug_index = 0;
						drugList = bean.getDrugDetails();
						String interval_value="";
						String freq_nature="";
						String pack_size="";
						String amend_repeat_value="";
						String amend_durn_value="";
						String qty_value = "";
						String ocurrance_num ="";
						for (int i=0; i<drugList.size(); i++){

							drugDetails	= (HashMap)drugList.get(i);
							if(drugDetails!=null && drugDetails.size()>0){
								in_formulary_yn = (String)drugDetails.get("IN_FORMULARY_YN")==null?"":(String)drugDetails.get("IN_FORMULARY_YN");
								item_code = (String)drugDetails.get("ITEM_CODE")==null?"":(String)drugDetails.get("ITEM_CODE");

								if(in_formulary_yn.equals("Y") && !item_code.equals("")){

									drug_code = (String)drugDetails.get("DRUG_CODE")==null?"":(String)drugDetails.get("DRUG_CODE");
									ocurrance_num = (String)drugDetails.get("OCURRANCE_NUM")==null?"":(String)drugDetails.get("OCURRANCE_NUM");
									drug_desc = (String)drugDetails.get("DRUG_DESC")==null?"":(String)drugDetails.get("DRUG_DESC");
									pack_size	= bean.getPackSize(drug_code);	
									dosage_type = (String)drugDetails.get("DOSAGE_TYPE")==null?"":(String)drugDetails.get("DOSAGE_TYPE"); 
									order_uom	= bean.getStockUOM(drug_code);			

									qty_value = (String)drugDetails.get("dose");
									if(qty_value==null || qty_value.equals(""))
										qty_value = (String)drugDetails.get("QTY_VALUE");

									repeat_value = (String)drugDetails.get("REPEAT_VALUE")==null?"1":(String)drugDetails.get("REPEAT_VALUE");
									
									float ing_unit_qty		= Float.parseFloat(qty_value);
									float in_tot_qty = 0.0f;
									fract_dose					=   bean.getFractDoseRndyn((String)drugDetails.get("DRUG_CODE"));

									strength_per_value_pres_uom	=	(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM")==null?"":(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");	
									strength_per_pres_uom		=	(String)drugDetails.get("STRENGTH_PER_PRES_UOM")==null?"":(String)drugDetails.get("STRENGTH_PER_PRES_UOM");	
									fract_dose     =(String)drugDetails.get("FRACT_DOSE_ROUND_UP_YN")==null?"":(String)drugDetails.get("FRACT_DOSE_ROUND_UP_YN");	
									interval_value     =(String)drugDetails.get("INTERVAL_VALUE")==null?"":(String)drugDetails.get("INTERVAL_VALUE");
									amend_repeat_value=(String)drugDetails.get("amend_repeat_value")==null?"":(String)drugDetails.get("amend_repeat_value");
									if(amend_repeat_value.equals(""))
										amend_repeat_value=(String)drugDetails.get("REPEAT_VALUE")==null?"1":(String)drugDetails.get("REPEAT_VALUE");
									amend_durn_value=(String)drugDetails.get("amend_durn_value")==null?"":(String)drugDetails.get("amend_durn_value");	
									if(amend_durn_value.equals(""))
										amend_durn_value=(String)drugDetails.get("DURN_VALUE")==null?"":(String)drugDetails.get("DURN_VALUE");
									freq_nature=(String)drugDetails.get("FREQ_NATURE")==null?"F":(String)drugDetails.get("FREQ_NATURE");

									if(dosage_type!=null){
										if(dosage_type.equals("S")) {				

											in_tot_qty	= 0.0f;

											if(fract_dose.equals("Y")){
												in_tot_qty	=new Double(Math.ceil(ing_unit_qty/Float.parseFloat(strength_per_pres_uom))).floatValue() * Float.parseFloat(strength_per_value_pres_uom);
											}
											else{
												//in_tot_qty	=Math.ceil(new Double (ing_unit_qty/Float.parseFloat(strength_per_pres_uom).floatValue()) * Float.parseFloat(strength_per_value_pres_uom));

												in_tot_qty	=new Double(Math.ceil(ing_unit_qty/Float.parseFloat(strength_per_pres_uom) * Float.parseFloat(strength_per_value_pres_uom))).floatValue();

											}
											if (freq_nature.equals("I")) {
												in_tot_qty = in_tot_qty*(Float.parseFloat(durn_value))*(24/(Float.parseFloat(interval_value)));
											}
											else if (freq_nature.equals("F") || freq_nature.equals("C")) {

												in_tot_qty = in_tot_qty*(Float.parseFloat(amend_repeat_value))*(Float.parseFloat(amend_durn_value));


											}
											else if (freq_nature.equals("O")) {
												in_tot_qty = in_tot_qty;
											}


										   ordered_qty=in_tot_qty+"";
										   ordered_qty=(Math.ceil(Float.parseFloat(ordered_qty)/Float.parseFloat(pack_size)))+"";


										}
										else{
											qty_unit			= (String)drugDetails.get("QTY_DESC_CODE");
											ing_order_uom		= (String)drugDetails.get("PRES_BASE_UOM");
											eqvl_value			=  bean.getConvFactor(ing_order_uom,qty_unit);
											if(eqvl_value.equals(""))	eqvl_value	=	"1";
											
											in_tot_qty	= 0.0f;
											if(fract_dose.equals("Y")){
												in_tot_qty	=new Double(Math.ceil(ing_unit_qty/(Float.parseFloat(pack_size)))).floatValue() * Float.parseFloat(eqvl_value);	
											}
											else{
												in_tot_qty = ing_unit_qty*Float.parseFloat(eqvl_value);
											}

											if (freq_nature.equals("I")) {
												in_tot_qty = in_tot_qty*(Float.parseFloat(durn_value))*(24/(Float.parseFloat(interval_value)));
											}
											else if (freq_nature.equals("F") || freq_nature.equals("C")) {
												in_tot_qty = in_tot_qty*(Float.parseFloat(amend_repeat_value))*(Float.parseFloat(amend_durn_value));
											}
											else if (freq_nature.equals("O")) {
												in_tot_qty = in_tot_qty;
											}

											

											if(!fract_dose.equals("Y")){
												in_tot_qty	=   new Double(Math.ceil((in_tot_qty)/Float.parseFloat(pack_size))).floatValue();
											}	
											ordered_qty=in_tot_qty+"";
										}

										
									}
									drugDetails.put("ORDERED_QTY",ordered_qty);

									bean.setBillingDetail(drugDetails, episode_type, patient_id, encounter_id, item_code, ordered_qty,take_home_medication);
									
									billable_item_yn =(String)drugDetails.get("BILLABLE_ITEM_YN")==null?"":(String)drugDetails.get("BILLABLE_ITEM_YN"); 
									if(billable_item_yn.equals("Y")){
										bl_included_IE				= (String)drugDetails.get("BL_INCL_EXCL_VALUE")==null?"":(String)drugDetails.get("BL_INCL_EXCL_VALUE");          
										bl_incl_excl_override_value = (String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_VALUE")==null?"":(String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_VALUE");         
										bl_override_reason_code		= (String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON")==null?"":(String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON");
										bl_override_reason_desc		= (String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC")==null?"":(String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC");
										bl_charge_amt				= (String)drugDetails.get("BL_CHARGE_AMT")==null?"0.0":(String)drugDetails.get("BL_CHARGE_AMT");           
										bl_patient_payable			= (String)drugDetails.get("BL_PATIENT_PAYABLE")==null?"0.0":(String)drugDetails.get("BL_PATIENT_PAYABLE");      
										bl_apprvl_reqd_yn			= (String)drugDetails.get("BL_APPRVL_REQD_YN")==null?"":(String)drugDetails.get("BL_APPRVL_REQD_YN");       
										bl_decimal_format_string	= (String)drugDetails.get("BL_DECIMAL_FORMAT_STRING")==null?"#0":(String)drugDetails.get("BL_DECIMAL_FORMAT_STRING");
										bl_override_allowed_yn		= (String)drugDetails.get("BL_OVERRIDE_ALLOWED_YN")==null?"":(String)drugDetails.get("BL_OVERRIDE_ALLOWED_YN");
										bl_error_code				= (String)drugDetails.get("BL_ERROR_CODE")==null?"":(String)drugDetails.get("BL_ERROR_CODE"); 
										bl_sys_message_id			= (String)drugDetails.get("BL_SYS_MESSAGE_ID")==null?"":(String)drugDetails.get("BL_SYS_MESSAGE_ID");
										bl_error_text				= (String)drugDetails.get("BL_ERROR_TEXT")==null?"":(String)drugDetails.get("BL_ERROR_TEXT");
										if(displayGrossAmtYn){ // Added for ML-BRU-CRF-0469 [IN:065426] - Start
											  grossAmount		    = (String)drugDetails.get("BL_GROSS_AMT")==null?"0.0":(String)drugDetails.get("BL_GROSS_AMT");
										} // Added for ML-BRU-CRF-0469 [IN:065426] - End   
										if ((bl_error_code.equals("10") && (!bl_error_text.equals(""))) ||!bl_sys_message_id.equals("")){
											blErrorDrugs.add("D");
											blErrorDrugs.add(drug_code);
											blErrorDrugs.add(drug_desc);
											blErrorDrugs.add(bl_error_code);
											blErrorDrugs.add(bl_sys_message_id);
											blErrorDrugs.add(bl_error_text);
											bl_charge_amt = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels");
											bl_patient_payable = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels");
											if(displayGrossAmtYn){  // Added for ML-BRU-CRF-0469 [IN:065426] - Start
												grossAmount = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels"); // Added for ML-BRU-CRF-0469 [IN:065426] 
											} // Added for ML-BRU-CRF-0469 [IN:065426] - End
										}
										else{
											//if( !bl_included_IE.equals("E") && (bl_incl_excl_override_value.equals("") || bl_incl_excl_override_value.equals("I"))){ //if condition commed for RUT-SCF-0188 [IN:039946]
												bl_tot_charge_amt += Float.parseFloat(bl_charge_amt);
												bl_tot_patient_payable += Float.parseFloat(bl_patient_payable);
											//}
												if(displayGrossAmtYn){  // Added for ML-BRU-CRF-0469 [IN:065426] - Start
													totalGrossAmount       += Float.parseFloat(grossAmount); 
												} // Added for ML-BRU-CRF-0469 [IN:065426] - End
											dfTest = new DecimalFormat(bl_decimal_format_string);
										}

										if(bl_included_IE.equals("I"))
											bl_included_IE_gif= "<img src='../../eCommon/images/enabled.gif'></img>";
										else if(bl_included_IE.equals("E"))
											bl_included_IE_gif= "<img src='../../eCommon/images/disabled.gif'></img>";
										else
											bl_included_IE_gif = "&nbsp;";			
										
										//commented for BL CRF 0001
										/*if(!bl_incl_excl_override_value.equals(""))
											bl_override_checked = "checked";
										else
											bl_override_checked = "";

										if(bl_override_allowed_yn.equals("Y"))
											bl_override_disable = "";
										else
											bl_override_disable = "disabled";
										*/


										 //done for BL CRF 0001
										 if(bl_override_allowed_yn.equals(""))
												bl_override_disable = "disabled";
										 else
												bl_override_disable = "";

				  
										include_selected="";
										exclude_selected="";
										if(!bl_override_reason_desc.equals("")){
											if(bl_incl_excl_override_value.equals("I")){
												include_selected ="selected";
											}
											else if(bl_incl_excl_override_value.equals("E")){
												exclude_selected ="selected";
											}
										}

										// ends here

										if(bl_apprvl_reqd_yn.equals("Y"))
											bl_apprvl_reqd_gif = "<img src='../../eCommon/images/enabled.gif'></img>";
										else if(bl_apprvl_reqd_yn.equals("N"))
											bl_apprvl_reqd_gif= "<img src='../../eCommon/images/disabled.gif'></img>";
										else
											bl_apprvl_reqd_gif = "&nbsp;";
									}
									else{
										bl_included_IE				="";		
										bl_incl_excl_override_value ="";	
										bl_override_reason_code		="";		
										bl_override_reason_desc		="";		
										bl_charge_amt				="";				
										bl_patient_payable			="";			
										bl_apprvl_reqd_yn			="";			
										bl_decimal_format_string	="";		
										bl_override_allowed_yn		="";		
										bl_error_code				="";			
										bl_sys_message_id			="";			
										bl_error_text				="";
										bl_included_IE_gif			="";
										bl_override_disable			= "";
										include_selected			="";
										exclude_selected			="";
										bl_apprvl_reqd_gif			= "&nbsp;";
									}
									iOrdQty = Math.ceil(Float.parseFloat(ordered_qty));
%>
									<tr>
										<td class='label'><%=drug_desc%></td>
										<input type='hidden' name='drug_code_<%=drug_index%>' id='drug_code_<%=drug_index%>' value='<%=drug_code%>'>
										<input type='hidden' name='fluid_yn_<%=drug_index%>' id='fluid_yn_<%=drug_index%>' value='N'>
										<td class='label' style='TEXT-ALIGN:right;'><%=iOrdQty%>&nbsp;<%=order_uom%>&nbsp;</td>
<%										if(billable_item_yn.equals("Y")){
%>
												<td class='label'  id='bl_included_IE_gif_<%=drug_index%>'><%=bl_included_IE_gif%></td>
												<td class='label'>
													<!-- <input type='checkbox' name='bl_overide_yn_<%=drug_index%>' id='bl_overide_yn_<%=drug_index%>' <%=bl_override_checked%> <%=bl_override_disable%> value='<%=bl_incl_excl_override_value%>' onclick="assignOverrideExclInclInd(this,'<%=bl_included_IE%>','<%=drug_index%>','<%=locale%>');"> -->
													<select name="bl_overide_yn_<%=drug_index%>" id="bl_overide_yn_<%=drug_index%>" onchange="assignOverrideExclInclInd(this,'<%=bl_included_IE%>','<%=drug_index%>','<%=locale%>');"  <%=bl_override_disable%>>

														   <option value="SEL">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
															<%if(bl_override_allowed_yn.equals("I"))%>
																<option value="I" <%=include_selected%>><fmt:message key="Common.Include.label" bundle="${common_labels}"/></option>
															<%if(bl_override_allowed_yn.equals("E"))%>
																<option value="E" <%=exclude_selected%> ><fmt:message key="Common.Exclude.label" bundle="${common_labels}"/></option>
															<%if(bl_override_allowed_yn.equals("B")){%>
																<option value="I" <%=include_selected%> ><fmt:message key="Common.Include.label" bundle="${common_labels}"/></option>
																<option value="E" <%=exclude_selected%> ><fmt:message key="Common.Exclude.label" bundle="${common_labels}"/></option>
															 <%}%>
																
														</select>
												</td>
												<td class='field'>
													<input type='text' name='bl_override_reason_desc_<%=drug_index%>' id='bl_override_reason_desc_<%=drug_index%>' value='<%=bl_override_reason_desc%>' readonly size='26'>
													<input type="button" name="bl_overriden_reason_lkp_<%=drug_index%>" id="bl_overriden_reason_lkp_<%=drug_index%>" value="?" class="button" onClick="searchBLOverrideReason('<%=locale%>','<%=drug_index%>');" <%=bl_override_disable%>><img  src="../../eCommon/images/mandatory.gif" id='bl_overriden_action_reason_img_<%=drug_index%>' style='visibility:hidden;'>
													<input type='hidden' name='bl_override_reason_code_<%=drug_index%>' id='bl_override_reason_code_<%=drug_index%>' value='<%=bl_override_reason_code%>'>
												</td>
												<%if(displayGrossAmtYn){ // Added for ML-BRU-CRF-0469 - Start %>
										        <td class='label' style='TEXT-ALIGN:right;' id='bl_gross_amt_<%=drug_index%>'><%=grossAmount%>&nbsp;&nbsp;</td>
										       <%} // Added for ML-BRU-CRF-0469 - End %>
												<td class='label' style='TEXT-ALIGN:right;' id='bl_charge_amt_<%=drug_index%>'><%=bl_charge_amt%>&nbsp;&nbsp;</td>
												<td class='label' style='TEXT-ALIGN:right;' id='bl_patient_payable_<%=drug_index%>'><%=bl_patient_payable%>&nbsp;&nbsp;</td>
												<td class='label' id='bl_apprvl_reqd_gif_<%=drug_index%>'><%=bl_apprvl_reqd_gif%></td>
<%										}else{
%>
												<td class='label'  id='bl_included_IE_gif_<%=drug_index%>'></td>
												<td class='label' style='visibility:hidden;'>
												<select name="bl_overide_yn_<%=drug_index%>" id="bl_overide_yn_<%=drug_index%>" onchange="assignOverrideExclInclInd(this,'<%=bl_included_IE%>','<%=drug_index%>','<%=locale%>');"  <%=bl_override_disable%>>

												   <option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>													
														
												</select>
										       </td>
												<td class='field'>
													<input type='hidden' name='bl_override_reason_desc_<%=drug_index%>' id='bl_override_reason_desc_<%=drug_index%>' value='' >
													<input type='hidden' name='bl_override_reason_code_<%=drug_index%>' id='bl_override_reason_code_<%=drug_index%>' value=''>
												</td> 

<%										}
%>
									</tr>
<%

									drug_index++;
								}


								fluidDetails =(HashMap) CompFluidDetails.get(drug_code+"_"+ocurrance_num);
								if(fluidDetails !=null && fluidDetails.size()>0){
									in_formulary_yn = (String)fluidDetails.get("IN_FORMULARY_YN")==null?"":(String)fluidDetails.get("IN_FORMULARY_YN");
									durn_value=(String)drugDetails.get("DURN_VALUE")==null?"":(String)drugDetails.get("DURN_VALUE");
									amend_repeat_value=(String)drugDetails.get("amend_repeat_value")==null?"1":(String)drugDetails.get("amend_repeat_value");	
									amend_durn_value=(String)drugDetails.get("amend_durn_value")==null?"1":(String)drugDetails.get("amend_durn_value");
									if(amend_durn_value.equals("")) //IN066756 ML-MMOH-CRF-1014
										amend_durn_value = "1";
									item_code = (String)fluidDetails.get("ITEM_CODE")==null?"":(String)fluidDetails.get("ITEM_CODE");

									if(in_formulary_yn.equals("Y")  && !item_code.equals("")){
										fluid_name			= (String)fluidDetails.get("DRUG_DESC");

										qty_value			= (String)drugDetails.get("amend_stock_value");
										if(qty_value==null || qty_value.equals(""))
											qty_value			= (String)fluidDetails.get("QTY_VALUE");

										fluid_code=(String)fluidDetails.get("DRUG_CODE");
										order_uom	= bean.getStockUOM(fluid_code);	
										pack_size	= bean.getPackSize(fluid_code);			

										ordered_qty		= (Math.ceil((Float.parseFloat(qty_value)) / Float.parseFloat(pack_size)))+""; 
//if(!amend_durn_value.equals("")){
										ordered_qty		= (Math.ceil((Float.parseFloat(ordered_qty)) * (Float.parseFloat(amend_durn_value))*(Float.parseFloat(amend_repeat_value))))+"";
//}
										ordered_qty=new Float(ordered_qty).intValue()+"";				
										drugDetails.put("ORDERED_QTY",ordered_qty);

										bean.setBillingDetail(fluidDetails, episode_type, patient_id, encounter_id, item_code, ordered_qty,take_home_medication );
										billable_item_yn =(String)fluidDetails.get("BILLABLE_ITEM_YN")==null?"":(String)fluidDetails.get("BILLABLE_ITEM_YN"); 
									if(billable_item_yn.equals("Y")){

											bl_error_code				= (String)fluidDetails.get("BL_ERROR_CODE")==null?"":(String)fluidDetails.get("BL_ERROR_CODE"); 
											bl_sys_message_id			= (String)fluidDetails.get("BL_SYS_MESSAGE_ID")==null?"":(String)fluidDetails.get("BL_SYS_MESSAGE_ID");
											bl_error_text				= (String)fluidDetails.get("BL_ERROR_TEXT")==null?"":(String)fluidDetails.get("BL_ERROR_TEXT");
											drug_desc					= (String)fluidDetails.get("DRUG_DESC")==null?"":(String)fluidDetails.get("DRUG_DESC");
											bl_charge_amt				= (String)fluidDetails.get("BL_CHARGE_AMT")==null?"0.0":(String)fluidDetails.get("BL_CHARGE_AMT");           
											bl_patient_payable			= (String)fluidDetails.get("BL_PATIENT_PAYABLE")==null?"0.0":(String)fluidDetails.get("BL_PATIENT_PAYABLE");      
											bl_decimal_format_string	= (String)fluidDetails.get("BL_DECIMAL_FORMAT_STRING")==null?"#0":(String)fluidDetails.get("BL_DECIMAL_FORMAT_STRING");
											bl_override_allowed_yn		= (String)fluidDetails.get("BL_OVERRIDE_ALLOWED_YN")==null?"":(String)fluidDetails.get("BL_OVERRIDE_ALLOWED_YN");
											bl_apprvl_reqd_yn			= (String)fluidDetails.get("BL_APPRVL_REQD_YN")==null?"":(String)fluidDetails.get("BL_APPRVL_REQD_YN");
											bl_incl_excl_override_value = (String)fluidDetails.get("BL_INCL_EXCL_OVERRIDE_VALUE")==null?"":(String)fluidDetails.get("BL_INCL_EXCL_OVERRIDE_VALUE"); 
											bl_included_IE				= (String)fluidDetails.get("BL_INCL_EXCL_VALUE")==null?"":(String)fluidDetails.get("BL_INCL_EXCL_VALUE");          
											bl_override_reason_code		= (String)fluidDetails.get("BL_INCL_EXCL_OVERRIDE_REASON")==null?"":(String)fluidDetails.get("BL_INCL_EXCL_OVERRIDE_REASON");
											bl_override_reason_desc		= (String)fluidDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC")==null?"":(String)fluidDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC");
											if ((bl_error_code.equals("10") && (!bl_error_text.equals(""))) ||!bl_sys_message_id.equals("")){
												blErrorDrugs.add("F");
												blErrorDrugs.add(fluid_code);
												blErrorDrugs.add(fluid_name);
												blErrorDrugs.add(bl_error_code);
												blErrorDrugs.add(bl_sys_message_id);
												blErrorDrugs.add(bl_error_text);
											}
											else{
												//if( !bl_included_IE.equals("E") && (bl_incl_excl_override_value.equals("") || bl_incl_excl_override_value.equals("I"))){ //if condition commed for RUT-SCF-0188 [IN:039946]
													bl_tot_charge_amt += Float.parseFloat(bl_charge_amt);
													bl_tot_patient_payable += Float.parseFloat(bl_patient_payable);
												//}
												dfTest = new DecimalFormat(bl_decimal_format_string);
											}

											if(bl_included_IE.equals("I"))
												bl_included_IE_gif= "<img src='../../eCommon/images/enabled.gif'></img>";
											else if(bl_included_IE.equals("E"))
												bl_included_IE_gif= "<img src='../../eCommon/images/disabled.gif'></img>";
											else
												bl_included_IE_gif = "&nbsp;";

											/*
											//commented for BL CRF 0001
											
											if(!bl_incl_excl_override_value.equals(""))
												bl_override_checked = "checked";
											else
												bl_override_checked = "";

											if(bl_override_allowed_yn.equals("Y"))
												bl_override_disable = "";
											else
												bl_override_disable = "disabled";
											 */
											 //done for BL CRF 0001
											 if(bl_override_allowed_yn.equals(""))
													bl_override_disable = "disabled";
											 else
													bl_override_disable = "";

					  
											include_selected="";
											exclude_selected="";
											if(!bl_override_reason_desc.equals("")){
												if(bl_incl_excl_override_value.equals("I")){
													include_selected ="selected";
												}
												else if(bl_incl_excl_override_value.equals("E")){
													exclude_selected ="selected";
												}
											}
											if(bl_apprvl_reqd_yn.equals("Y"))
												bl_apprvl_reqd_gif = "<img src='../../eCommon/images/enabled.gif'></img>";
											else if(bl_apprvl_reqd_yn.equals("N"))
												bl_apprvl_reqd_gif= "<img src='../../eCommon/images/disabled.gif'></img>";
											else
												bl_apprvl_reqd_gif = "&nbsp;";
									}
									else{
										bl_error_code				="";			
										bl_sys_message_id			="";		
										bl_error_text				="";		
										drug_desc					="";			
										bl_charge_amt				="";		
										bl_patient_payable			="";		
										bl_decimal_format_string	="";
										bl_override_allowed_yn		="";	
										bl_apprvl_reqd_yn			="";			
										bl_incl_excl_override_value ="";
										bl_included_IE				="";		
										bl_override_reason_code		="";	
										bl_override_reason_desc		="";
										bl_included_IE_gif			= "&nbsp;";
										include_selected			="";
										exclude_selected			="";
										bl_apprvl_reqd_gif			= "&nbsp;";

									}
										iOrdQty = Math.ceil(Float.parseFloat(ordered_qty));
%>
										<tr>
											<td class='label'><%=fluid_name%></td>
											<input type='hidden' name='drug_code_<%=drug_index%>' id='drug_code_<%=drug_index%>' value='<%=drug_code%>'>
											<input type='hidden' name='fluid_yn_<%=drug_index%>' id='fluid_yn_<%=drug_index%>' value='Y'>
											<input type='hidden' name='ocurrance_num_<%=drug_index%>' id='ocurrance_num_<%=drug_index%>' value='<%=ocurrance_num%>'>
											<td class='label' style='TEXT-ALIGN:right;'><%=iOrdQty%>&nbsp;<%=order_uom%>&nbsp;</td>
<%                                   if(billable_item_yn.equals("Y")){
%>
											<td class='label'  id='bl_included_IE_gif_<%=drug_index%>'><%=bl_included_IE_gif%></td>
											<td class='label'>
											<!-- 	<input type='checkbox' name='bl_overide_yn_<%=drug_index%>' id='bl_overide_yn_<%=drug_index%>' <%=bl_override_checked%> <%=bl_override_disable%> value='<%=bl_incl_excl_override_value%>' onclick="assignOverrideExclInclInd(this,'<%=bl_included_IE%>','<%=drug_index%>','<%=locale%>');"> -->
											<select name="bl_overide_yn_<%=drug_index%>" id="bl_overide_yn_<%=drug_index%>" onchange="assignOverrideExclInclInd(this,'<%=bl_included_IE%>','<%=drug_index%>','<%=locale%>','<%=ocurrance_num%>');"  <%=bl_override_disable%>>

												   <option value="SEL">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
													<%if(bl_override_allowed_yn.equals("I"))%>
														<option value="I" <%=include_selected%>><fmt:message key="Common.Include.label" bundle="${common_labels}"/></option>
													<%if(bl_override_allowed_yn.equals("E"))%>
														<option value="E" <%=exclude_selected%> ><fmt:message key="Common.Exclude.label" bundle="${common_labels}"/></option>
													<%if(bl_override_allowed_yn.equals("B")){%>
														<option value="I" <%=include_selected%> ><fmt:message key="Common.Include.label" bundle="${common_labels}"/></option>
														<option value="E" <%=exclude_selected%> ><fmt:message key="Common.Exclude.label" bundle="${common_labels}"/></option>
													 <%}%>
														
												</select>
											</td>
											<td class='field'>
												<input type='text' name='bl_override_reason_desc_<%=drug_index%>' id='bl_override_reason_desc_<%=drug_index%>' value='<%=bl_override_reason_desc%>' readonly size='26'>
												<input type="button" name="bl_overriden_reason_lkp_<%=drug_index%>" id="bl_overriden_reason_lkp_<%=drug_index%>" value="?" class="button" onClick="searchBLOverrideReason('<%=locale%>','<%=drug_index%>');" <%=bl_override_disable%>><img  src="../../eCommon/images/mandatory.gif" id='bl_overriden_action_reason_img_<%=drug_index%>' style='visibility:hidden;'>
												<input type='hidden' name='bl_override_reason_code_<%=drug_index%>' id='bl_override_reason_code_<%=drug_index%>' value='<%=bl_override_reason_code%>'>
											</td>
											<%if(displayGrossAmtYn){ // Added for ML-BRU-CRF-0469 - Start %>
										     <td class='label' style='TEXT-ALIGN:right;' id='bl_gross_amt_<%=drug_index%>'><%=grossAmount%>&nbsp;&nbsp;</td>
										    <%} // Added for ML-BRU-CRF-0469 - End %>
											<td class='label' style='TEXT-ALIGN:right;' id='bl_charge_amt_<%=drug_index%>'><%=bl_charge_amt%>&nbsp;&nbsp;</td>
											<td class='label' style='TEXT-ALIGN:right;' id='bl_patient_payable_<%=drug_index%>'><%=bl_patient_payable%>&nbsp;&nbsp;</td>
											<td class='label' id='bl_apprvl_reqd_gif_<%=drug_index%>'><%=bl_apprvl_reqd_gif%></td>
<%                                    }else{
%>
												<td class='label'  id='bl_included_IE_gif_<%=drug_index%>'></td>
												<td class='label' style='visibility:hidden;'>
												<select name="bl_overide_yn_<%=drug_index%>" id="bl_overide_yn_<%=drug_index%>" onchange="assignOverrideExclInclInd(this,'<%=bl_included_IE%>','<%=drug_index%>','<%=locale%>');"  <%=bl_override_disable%>>
												   <option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>											
														
												</select>
										        </td>
												 <td class='field'>
													<input type='hidden' name='bl_override_reason_desc_<%=drug_index%>' id='bl_override_reason_desc_<%=drug_index%>' value='' >
													<input type='hidden' name='bl_override_reason_code_<%=drug_index%>' id='bl_override_reason_code_<%=drug_index%>' value=''>
												</td>

<%										}
%>
										</tr>
<%
										drug_index++;
									}
								}
							}
						}
					}
				}
			/*	if((iv_prep_yn.equals("3") || iv_prep_yn.equals("4") )&& fluid_code.equals((String)((HashMap)drugList.get(0)).get("DRUG_CODE"))){
// value is being divided by 2 coz - in IV intermittent if it is ready to use iv then drug and fluid wil be same, in that case the amt wil be added twice
				bl_tot_charge_amt = bl_tot_charge_amt / 2;
					bl_tot_patient_payable = bl_tot_patient_payable / 2;
				}*/
				totalGrossAmountStr = dfTest.format(totalGrossAmount); // Added for ML-BRU-CRF-0469 [IN:065426]
				tot_payable_sum_str = dfTest.format(bl_tot_charge_amt);
				pat_payable_sum_str = dfTest.format(bl_tot_patient_payable);
				
%>
				<tr height='2'><td colspan='8'>&nbsp;</td></tr>
				<tr> 
					<td colspan='5' class='data' align='right'><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;</td>
					<% if(displayGrossAmtYn){ // Added for ML-BRU-CRF-0469 [IN:065426] - Strat%>
					<td class='data' style='TEXT-ALIGN:right;' id='bl_tot_gross_amt'><%=totalGrossAmountStr%>&nbsp;&nbsp;&nbsp;</td>
					<%}  // Added for ML-BRU-CRF-0469 [IN:065426] - End %>
					<td class='data'  style='TEXT-ALIGN:right;' id='bl_tot_charge_amt'><%=tot_payable_sum_str%>&nbsp;&nbsp;&nbsp;</td>
					<td class='data'  style='TEXT-ALIGN:right;' id='bl_tot_patient_payable'><%=pat_payable_sum_str%>&nbsp;&nbsp;&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr> 
					<td colspan='8'>&nbsp; </td>
				</tr>
				<tr> 
					<td colspan='6'>&nbsp; </td>
					<td colspan='2' align='right'><input type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' class="button" onClick="storeOverrideDetail()">&nbsp;&nbsp;<input type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class="button" onClick="cancelOverrideDetail()"></td>
				</tr>
			</table>
			<INPUT TYPE="hidden" name="sql_ph_prescription_bl_action_select_lookup" id="sql_ph_prescription_bl_action_select_lookup" VALUE="<%= PhRepository.getPhKeyValue( "SQL_PH_PRESCRIPTION_BL_ACTION_SELECT_LOOKUP") %>">						
			<input type='hidden' name='bean_id' id='bean_id' value='<%=bean_id%>'>
			<input type='hidden' name='bean_name' id='bean_name' value='<%=bean_name%>'>
			<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
			<input type='hidden' name='encounter_id' id='encounter_id' value='<%=encounter_id%>'>
			<input type='hidden' name='episode_type' id='episode_type' value='<%=episode_type%>'>
			<input type='hidden' name='iv_prep_yn' id='iv_prep_yn' value='<%=iv_prep_yn%>'>
			<input type='hidden' name='rx_order_type' id='rx_order_type' value='<%=rx_order_type%>'>
			<input type='hidden' name='tot_drugs' id='tot_drugs' value='<%=drug_index%>'>
			<input type='hidden' name='take_home_medication' id='take_home_medication' value='<%=take_home_medication%>'>
<%
			if(blErrorDrugs.size()>0){
%>
				<input type='hidden' name='blErrorDrugs' id='blErrorDrugs' value='<%=blErrorDrugs%>'>
<%
			}
			else{
%>
				<input type='hidden' name='blErrorDrugs' id='blErrorDrugs' value=''>
<%
			}
%>
		</form>
	</body>
</html>
<%
}catch(Exception e){
e.printStackTrace();
}	
%>

