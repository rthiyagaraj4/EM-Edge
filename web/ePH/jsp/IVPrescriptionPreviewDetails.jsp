<!DOCTYPE html>
 <%
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
06/01/2021		 TFS-7345          Prabha      06/01/2020	  Manickavasagam J         MMS-DM-CRF-0177
--------------------------------------------------------------------------------------------------------------
*/
%> 
<%-- JSP Page specific attributes start --%> 
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<HTML>
	<HEAD>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/IVPrescriptionWithAdditives.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
<%
		String patient_class		= request.getParameter("actual_patient_class"); 
		String patient_id			= request.getParameter("patient_id");
		String encounter_id			= request.getParameter("encounter_id");
		String date					= request.getParameter("date");
		String locn_code			= request.getParameter("locn_code");
		String pract_name			= request.getParameter("pract_name");
		String fluid_code			= request.getParameter("fluid_code");
		String fluid_name			= request.getParameter("fluid_name");
		String infusion_rate		= request.getParameter("infusion_rate");
		String infusion_over		= request.getParameter("infusion_over");
		String infusion_over_uom	= request.getParameter("infusion_over_uom");
		String infusion_rate_uom	= request.getParameter("infusion_rate_uom");
		String tot_inf_volume		= request.getParameter("tot_inf_volume");
		String frequency			= request.getParameter("freq_desc");
		String start_date			= request.getParameter("start_date");
		String end_date				= request.getParameter("end_date");
		String fluid_volume_uom     = request.getParameter("fluid_volume_uom");
		String durn_value			= request.getParameter("durn_value");	
		String lstInfusionRateDurnUnit	= request.getParameter("lstInfusionRateDurnUnit");	
		
		String mode	= request.getParameter("mode")==null?"":request.getParameter("mode"); //Added for MMS-DM-CRF-0177	
		
		String infusionRatePeriod		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Hour(s).label","common_labels");
		String infusion_over_uom_desc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Hour(s).label","common_labels");
		String display_auth_rule ="visibility:hidden", color_auth_rule = "RED", ord_auth_reqd_yn = "", ord_authorized_yn = "", strAuthStatus="-" ;  //added for ML-MMOH-CRF-0343
		String preview_auth_status_yn = "Y";//bean.getPreviewAuthStatus(); //added for ML-MMOH-CRF-0343
		//String order_status="";
		if( "Y".equals(preview_auth_status_yn)) {   // if condition added for ML-MMOH-CRF-0343
			display_auth_rule = "visibility:visible";   
		}
		String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
		String bean_name		= "ePH.IVPrescriptionBean";
		IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject(bean_id, bean_name, request);
		
		String or_bean_name		="eOR.OrderEntryBean";
		String or_bean_id		="@orderentrybean"+patient_id+encounter_id;
		OrderEntryBean orbean = (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
		eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) orbean.getOrderEntryRecordBean();

		String pres_bean_id			 = "@PrescriptionBean_1"+patient_id+encounter_id;
		String pres_bean_name		 = "ePH.PrescriptionBean_1";
		PrescriptionBean_1 pres_bean = (PrescriptionBean_1)getBeanObject( pres_bean_id, pres_bean_name, request ) ;
		//added for ml-mmoh-crf-0863 start
		String called_amend_from=pres_bean.getCalledFromAmend();
		String disp_locn_code	= "";
				//bean.setOrderStatus("");
		 disp_locn_code=bean.getDisp_locn_code();
				//order_status=bean.getOrderStatus();
		System.out.println("disp in IVprescriptionpreviewDetails"+bean.getDisp_locn_code());
		 String auth_amend_pres_yn="";
			auth_amend_pres_yn = bean.getAuthAmendPres(disp_locn_code);
			//System.out.println(disp_locn_code+"IVprescriptionpreviewDetails"+order_status);
			//added for ml-mmoh-crf-0863 end
		try{
			if(lstInfusionRateDurnUnit.equals("M")){
				infusionRatePeriod=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Minute(s).label","common_labels");
			}
			if(infusion_over_uom.equals("M"))
				infusion_over_uom_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Minute(s).label","common_labels");
			String iv_calc_infuse_by=bean.getIVCalcInfuseBy();

			String patient_name		= "";
			String sex				= "";
			String age				= "";
			String pres_remarks		= "";
			String drug_remarks		= "";
			ArrayList schedule		=	null;
			String freq_str			=	"";
			HashMap detail			=	null;
			String infusion_over_disp = infusion_over;
			String drugindication_remarks	=   "";//added for MMS Adhoc Testing
			if(infusion_over.indexOf(".") != -1){
				infusion_over_disp = infusion_over.substring(0,infusion_over.indexOf("."));
				Double temp = new Double(infusion_over);
				String hr   = "";
				temp        = temp*60;
				temp        = (temp%60);
				infusion_over_disp =  Math.round(temp)+"";
				hr          = infusion_over.substring(0,infusion_over.indexOf("."));
				if(hr.equals(""))
					hr = "0";
				infusion_over_disp = hr+":"+infusion_over_disp;
			}
			else{
				infusion_over_disp = infusion_over;
			}
			ArrayList pat_details	= bean.getPatientDetails(patient_id);
			if (pat_details.size() != 0) {
				patient_name	= (String)pat_details.get(0);
				sex				= (String)pat_details.get(1);
				age				= (String)pat_details.get(2);
			}

			if(sex.equalsIgnoreCase("female"))
				sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			else if(sex.equalsIgnoreCase("male"))
				sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			else if(sex.equalsIgnoreCase("unknown"))
				sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

			String locn_desc	= bean.getLocationDesc(patient_class,locn_code);
			if(locn_desc == null) locn_desc="";
			Hashtable template	=	null;
			ArrayList seq_num	=	(ArrayList)orderEntryRecordBean.getOrderFormats(fluid_code,fluid_code+"_0");
			if(seq_num==null)
				seq_num			=	new ArrayList();
			for(int p=0; p<seq_num.size(); p++) {
				template	=	(Hashtable)orderEntryRecordBean.getOrderFormats(fluid_code,(fluid_code+((Integer)seq_num.get(p)).intValue()));

				if(((String) template.get("field_mnemonic")).equals("PRES_REMARKS")) {
					pres_remarks = pres_remarks + bean.getPrescriptionRemarks((String) template.get("field_values"))+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
				}
				else {
					pres_remarks = pres_remarks + (String) template.get("field_values") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
				}
			}
			ArrayList rec			= new ArrayList();
			HashMap MultiFlowRecs	= bean.getMFRRecs();
			String tot_volume		= "";
			String tot_flow_durn	= "";
			String tot_durn			= ""; 
			int totRecs				= 0; 
			String temp				= "";  
			String mfr_yn			= "N";
			String tot_durnHrs		= "";
			String tot_flow_durnHrs = "";
			String hr				= "";
			String mi				= "";
			Double Dtemp			= null;
			if(MultiFlowRecs != null && MultiFlowRecs.size() > 0){
				temp			= (String)MultiFlowRecs.get("totRec")==null?"0":(String)MultiFlowRecs.get("totRec");
				totRecs			= Integer.parseInt(temp);
				tot_volume		= (String)MultiFlowRecs.get("totInfVolume")==null?"":(String)MultiFlowRecs.get("totInfVolume");
				tot_inf_volume	= tot_volume;
				tot_flow_durn	= (String)MultiFlowRecs.get("totFlowDurn")==null?"":(String)MultiFlowRecs.get("totFlowDurn");
				tot_flow_durnHrs= (String)MultiFlowRecs.get("totFlowDurnHrs")==null?"":(String)MultiFlowRecs.get("totFlowDurnHrs");
				tot_durn		= (String)MultiFlowRecs.get("totDuration")==null?"":(String)MultiFlowRecs.get("totDuration");
				tot_durnHrs		= (String)MultiFlowRecs.get("totDurationHrs")==null?"":(String)MultiFlowRecs.get("totDurationHrs");
				mfr_yn			= "Y";
				if(tot_flow_durnHrs.indexOf(".") != -1){
					hr = tot_flow_durnHrs.substring(0,tot_flow_durnHrs.indexOf("."));
					Dtemp = new Double(tot_flow_durnHrs);
					Dtemp = Dtemp*60;
					Dtemp = (Dtemp%60);
					mi = Math.round(Dtemp)+""; 
					if(mi.indexOf(".") != -1)
						mi = mi.substring(0,mi.indexOf("."));  
				}
				else{
					hr = tot_flow_durnHrs;
					mi = "";
				}
				if(iv_calc_infuse_by.equals("I")){
				}
				hr = hr.equals("")?"00":hr;
				mi = mi.equals("")?"00":mi;
				hr = hr.length() == 1 ? ("0"+hr):hr;
				mi = mi.length() == 1 ? ("0"+mi):mi;
				tot_flow_durn = hr+":"+mi;
				MultiFlowRecs.put("tot_flow_durn",tot_flow_durn);
				/*if(tot_durnHrs.indexOf(".") != -1){
					hr = tot_durnHrs.substring(0,tot_durnHrs.indexOf("."));
					Dtemp = new Double(tot_durnHrs);
					Dtemp = Dtemp*60;
					Dtemp = (Dtemp%60);
					mi = Math.round(Dtemp)+""; 
					if(mi.indexOf(".") != -1)
						mi = mi.substring(0,mi.indexOf("."));  
				}
				else{
					hr = tot_durnHrs;
					mi = "";
				}
				hr = hr.equals("")?"0":hr;
				mi = mi.equals("")?"0":mi;
				tot_durn = hr+":"+mi;
				MultiFlowRecs.put("totDuration",tot_durn);*/
			}
			if(iv_calc_infuse_by.equals("I") && !mfr_yn.equals("Y")){
				int infusion_period_value =Integer.parseInt( request.getParameter("infusion_period_value")==null?"0":request.getParameter("infusion_period_value"));
				int infusion_period_value_min =Integer.parseInt( request.getParameter("infusion_period_value_min")==null?"0":request.getParameter("infusion_period_value_min"));
			}
%>
			<FORM name="formIVPrescriptionPreviewDetails" id="formIVPrescriptionPreviewDetails">
				<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
					<tr>
					<td class="COLUMNHEADER" COLSPAN="4"><FONT STYLE="font-size:10"><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></font></Td>
					</tr>
					<tr><td colspan="4"></td></tr>
					<tr><td colspan="4"></td></tr>
					<tr><td colspan="4"></td></tr>
					<tr><td colspan="4"></td></tr>
					<TR>
						<TD CLASS="label" WIDTH="20%" style="font-size:10"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/> :&nbsp;</TD>
						<TD CLASS="data" WIDTH="30%" style="font-size:10"><%= patient_name %></TD>
						<TD CLASS="label" WIDTH="20%" style="font-size:10"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/> :&nbsp;</TD>
						<TD CLASS="data" WIDTH="30%" style="font-size:10"><%= patient_id %></TD>
					</TR>
					<TR>
						<TD CLASS="label" WIDTH="20%" style="font-size:10"><fmt:message key="Common.age.label" bundle="${common_labels}"/> :&nbsp;</TD>
						<TD CLASS="data" WIDTH="30%" style="font-size:10"><%= age %></TD>
						<TD CLASS="label" WIDTH="20%" style="font-size:10"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/> :&nbsp;</TD>
						<TD CLASS="data" WIDTH="30%" style="font-size:10"><%= encounter_id %></TD>
					</TR>
					<TR>
						<TD CLASS="label" WIDTH="20%" style="font-size:10"><fmt:message key="Common.gender.label" bundle="${common_labels}"/> :&nbsp;</TD>
						<TD CLASS="data" WIDTH="30%" style="font-size:10"><%= sex %></TD>
						<TD CLASS="label" WIDTH="20%" style="font-size:10"><fmt:message key="ePH.OrderDate/Time.label" bundle="${ph_labels}"/> :&nbsp;</TD>
						<TD CLASS="data" WIDTH="30%" style="font-size:10"><%= date %></TD>
					</TR>
					<TR> 
						<TD CLASS="label" WIDTH="20%" style="font-size:10"><fmt:message key="Common.OrderingLocation.label" bundle="${common_labels}"/> :&nbsp;</TD>
						<TD CLASS="data" WIDTH="30%" style="font-size:10"><%= locn_desc %></TD>
						<TD CLASS="label" WIDTH="20%" style="font-size:10"><fmt:message key="Common.PrescribedBy.label" bundle="${common_labels}"/>  :&nbsp;</TD>
<%
						if(pract_name!=null && !(pract_name.equals(""))){
							pract_name  =java.net.URLDecoder.decode(pract_name,"UTF-8");
						}
%>
						<TD CLASS="data" WIDTH="30%" style="font-size:10"><%=pract_name%></TD>
					</TR>
					<tr><td colspan="4"></td></tr>
					<tr><td colspan="4"></td></tr>
					<tr><td colspan="4"></td></tr>
					<tr><td colspan="4"></td></tr>
				</TABLE>
				<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
					<TR>
						<td class="COLUMNHEADER" WIDTH="2%">&nbsp;</td>
						<td class="COLUMNHEADER" WIDTH="40%" style="font-size:10"><fmt:message key="ePH.Fluid.label" bundle="${ph_labels}"/></td>
						<td class="COLUMNHEADER" WIDTH="20%" style="font-size:10"><fmt:message key="Common.volume.label" bundle="${common_labels}"/></td>
<%
						if(MultiFlowRecs != null && MultiFlowRecs.size() > 0){
%>
							<td class="COLUMNHEADER" WIDTH="20%" style="font-size:10"><fmt:message key="ePH.TotalInfuseDuration.label" bundle="${ph_labels}"/></td>
<%
						}
%>
						<td class="COLUMNHEADER" WIDTH="20%" style="font-size:10"><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
						<td class="COLUMNHEADER" WIDTH="20%" style="font-size:10" style='<%=display_auth_rule%>;'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td> <!-- Added for ML-MMOH-CRF-0343 -->
<!-- 						<td class="COLUMNHEADER" WIDTH="20%" style="font-size:10">&nbsp;</td>	 -->
							
					</TR>
					<tr><td colspan="4"></td></tr>
					<tr><td colspan="4"></td></tr>
					<tr><td colspan="4"></td></tr>
					<tr><td colspan="4"></td></tr>
<%
					// Fluid order qty
					/*if(lstInfusionRateDurnUnit.equals("M")){
						infusion_over = Float.parseFloat(infusion_over)/60+"";
					}*/
					//infuse over wil be same as duration in case of mfr coz flow duration is sum of the infuse over value. 
					HashMap fluid_details = (HashMap)bean.getFluidDetails();
					float dur1 = 0.0f;
					if(mfr_yn.equals("Y") )
						dur1 = Float.parseFloat(tot_flow_durnHrs);
					else if(iv_calc_infuse_by.equals("I"))
						dur1	= 1.0f;
					else
						dur1	= Float.parseFloat(Math.ceil(((Float.parseFloat(durn_value) / (Float.parseFloat(infusion_over)))*100)/100)+"");
					//code commented during PE BY Naveen
					//String pack_size	= bean.getPackSize(fluid_code);
					String pack_size	= (String)fluid_details.get("FLUID_PACK_SIZE");

					String order_uom	=  bean.getStockUOM(fluid_code);
					float order_qty		= Float.parseFloat(Math.ceil(Float.parseFloat(tot_inf_volume)/Float.parseFloat(pack_size))*dur1+"");

					if(MultiFlowRecs != null && MultiFlowRecs.size() > 0){
						order_qty		= Float.parseFloat(Math.ceil(Float.parseFloat(tot_volume)/Float.parseFloat(pack_size))+"");
					}
					
					if( "Y".equals(preview_auth_status_yn)) { //added for ML-MMOH-CRF-0343
						strAuthStatus="-";
					}
%>
					<TR>
						<TD CLASS="label" WIDTH="2%">&nbsp;</TD>
						<TD CLASS="label" WIDTH="20%" style="font-size:10"><%= fluid_name %> </TD>
						<TD CLASS="label" WIDTH="20%" style="font-size:10"><%= tot_inf_volume %>&nbsp; <%=bean.getUomDisplay((String)session.getValue("facility_id"),infusion_rate_uom)%></TD>
<%
						if(!tot_flow_durn.equals("")){
%>
							<TD CLASS="data" width="20%" style="font-size:10"><%=tot_flow_durn%>&nbsp;<fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></TD>
<%
						}
%>
						<TD CLASS="data" width="20%" style="font-size:10"><%=order_qty%>&nbsp;<%=order_uom%></TD>
						<TD class="label" align='center' style='<%=display_auth_rule%>;'> <!-- added for ML-MMOH-CRF-0343 -->
						<label id='lbl_authorize' style='<%=display_auth_rule%>;<%=color_auth_rule%>'><%=strAuthStatus%></label>
						</TD>
						<td>&nbsp;</td>
					</TR>
<%
					schedule	=	(ArrayList)bean.getScheduleFrequencyStr(fluid_code,"0");
					for(int n=0; n<schedule.size(); n++) {
						detail		=	(HashMap)schedule.get(n);
						freq_str  = freq_str +  detail.get("admin_time")+"-";
						freq_str = freq_str + detail.get("admin_qty")+" ";
						if(n==(schedule.size()-1))
							freq_str = freq_str+" ";
						else
							freq_str = freq_str +", ";
					}
					freq_str	= freq_str + " "+fluid_volume_uom;
					if(!pres_remarks.equals("")) {	
%>
						<tr><td colspan="4"></td></tr>
						<tr><td colspan="4"></td></tr>
						<tr><td colspan="4"></td></tr>
						<tr><td colspan="4"></td></tr>
						<tr>
							<TD CLASS="label" colspan="4" style="font-size:10">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.FluidRemarks.label" bundle="${ph_labels}"/>:&nbsp;&nbsp;<%=pres_remarks%></TD>
						<tr>
<%	
					}
%>
					<tr><td colspan="4"></td></tr>
					<tr><td colspan="4"></td></tr>
					<tr><td colspan="4"></td></tr>
					<tr><td colspan="4"></td></tr>
				</TABLE>
<%
				ArrayList drugList = bean.getDrugDetails();
				HashMap hmOrdAuthReqDtl = bean.getOrdAuthReqDtl();
				if (drugList.size() != 0) {
					boolean display=false;
					HashMap drugDetails = null;
					for (int i=0; i<drugList.size(); i++) {
						drugDetails	= (HashMap)drugList.get(i);
						if(drugDetails.get("DOSAGE_TYPE") !=null){
							display=true;
							break;
						}
					}
					if(display){
%>
						<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
							<TR>
								<td class="COLUMNHEADER" WIDTH="1%">&nbsp;</td>
								<td class="COLUMNHEADER" WIDTH="28%" style="font-size:10"><fmt:message key="ePH.Additive.label" bundle="${ph_labels}"/>/<fmt:message key="ePH.Drugs.label" bundle="${ph_labels}"/></td>
								<td class="COLUMNHEADER" WIDTH="10%" style="font-size:10"><fmt:message key="Common.DosageBy.label" bundle="${common_labels}"/></td>
								<td class="COLUMNHEADER" WIDTH="20%" style="font-size:10"><fmt:message key="ePH.Dose.label" bundle="${ph_labels}"/></td>
								<td class="COLUMNHEADER" WIDTH="20%" style="font-size:10"><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
							    <td class="COLUMNHEADER" WIDTH="20%" style="font-size:10" style='<%=display_auth_rule%>;'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
							</TR>
<%
							drugDetails					=	null;
							String dose_type 					=	"";
							String strength_per_value_pres_uom	=	"";
							String strength_per_pres_uom		=	"";
							String content_in_pres_base_uom		=	"";
							String stock_uom					=	"";
							String fract_dose					=   "";
							float ing_order_qty					=	0;
							float in_tot_qty					=	0;
							
							//Added for MMS-DM-CRF-0177
		
							String new_generic_name = "";
							String drug_search = "";
							String pre_alloc_appl = "";
							//Added for MMS-DM-CRF-0177
							
							//i=0;
							//if(order_type_flag.equals("Existing")) i=1;
							for (int i=0; i<drugList.size(); i++) {
								color_auth_rule	="";	//Added for 0863
								strAuthStatus	="-";	//Added for 0863
								drugDetails	= (HashMap)drugList.get(i);
								drugindication_remarks=	(String)drugDetails.get("DRUG_INDICATION")==null?"":(String)drugDetails.get("DRUG_INDICATION");	//added for MMS Adhoc Testing
								if(drugDetails.size() != 0){
									dose_type 	=  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Quantity.label","common_labels"); 
									float ing_unit_qty		= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
									stock_uom		=	bean.getStockUOM((String)drugDetails.get("DRUG_CODE"));
									content_in_pres_base_uom	=	(String)drugDetails.get("CONTENT_IN_PRES_BASE_UOM");
									//corrected during PE By Naveen
									//fract_dose	=   bean.getFractDoseRndyn((String)drugDetails.get("DRUG_CODE"));
									fract_dose		=   (String)drugDetails.get("FRACT_DOSE_ROUND_UP_YN");

									if(drugDetails.get("DOSAGE_TYPE") !=null){
										if(drugDetails.get("DOSAGE_TYPE").toString().equals("S")) {				
											dose_type = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Strength.label","common_labels");
											strength_per_value_pres_uom	=	(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");	
											strength_per_pres_uom		=	(String)drugDetails.get("STRENGTH_PER_PRES_UOM");	
											
											if(fract_dose.equals("Y")){
												in_tot_qty	    =   new Double(	Math.ceil(ing_unit_qty/Float.parseFloat(strength_per_pres_uom))).floatValue() * Float.parseFloat(strength_per_value_pres_uom);
												ing_order_qty	=   Float.parseFloat((Math.ceil(in_tot_qty/Float.parseFloat(content_in_pres_base_uom))*dur1)+"");
											}
											else if(fract_dose.equals("N")){
												in_tot_qty	= (ing_unit_qty*Float.parseFloat(strength_per_value_pres_uom))/(Float.parseFloat(strength_per_pres_uom));  
												//ing_order_uom	= (String)drugDetails.get("STRENGTH_UOM");
												ing_order_qty		=   Float.parseFloat(Math.ceil((in_tot_qty*dur1)/Float.parseFloat(content_in_pres_base_uom))+"");
											}
											if(MultiFlowRecs != null && MultiFlowRecs.size() > 0){
												ing_order_qty = Float.parseFloat(Math.ceil((in_tot_qty)/Float.parseFloat(content_in_pres_base_uom))+"");
											}
										} 
										else {
											String qty_unit				= (String)drugDetails.get("QTY_DESC_CODE");
											String ing_order_uom		= (String)drugDetails.get("PRES_BASE_UOM");
											String eqvl_value			=  bean.getConvFactor(ing_order_uom,qty_unit);
											if(eqvl_value.equals(""))	eqvl_value	=	"1";	
												in_tot_qty = ing_unit_qty*Float.parseFloat(eqvl_value);

											if(fract_dose.equals("Y")){
												ing_order_qty	=   Float.parseFloat((Math.ceil(in_tot_qty/Float.parseFloat(content_in_pres_base_uom))*dur1)+"");
											}
											else if(fract_dose.equals("N")){
												ing_order_qty	=   Float.parseFloat(Math.ceil((in_tot_qty*dur1)/Float.parseFloat(content_in_pres_base_uom))+"");
											}
										}
										if( "Y".equals(preview_auth_status_yn)) {
											ord_auth_reqd_yn =(String) drugDetails.get("ORD_AUTH_REQD_YN");  //added for ML-MMOH-CRF-0343 -start
											if((ord_auth_reqd_yn==null || ord_auth_reqd_yn.equals("")) && hmOrdAuthReqDtl.containsKey((String)drugDetails.get("DRUG_CODE")))
												ord_auth_reqd_yn =(String)hmOrdAuthReqDtl.get((String)drugDetails.get("DRUG_CODE")); //(String) drugDetails.get("ORD_AUTH_REQD_YN");  //added for ML-MMOH-CRF-0343 -start
											ord_authorized_yn			= (String) drugDetails.get("ORD_AUTHORIZED_YN");
											if("Y".equals(ord_auth_reqd_yn)){
												color_auth_rule = "color:red";
												strAuthStatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.AuthorizationReqd..label", "common_labels");
												if("Y".equals(ord_authorized_yn)){
													color_auth_rule = "color:green";
													strAuthStatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Authorized.label", "common_labels");
												}
												//added for ml-mmoh-crf-0863 start
												if("Y".equals(auth_amend_pres_yn) && called_amend_from.equals("PH")){
													color_auth_rule = "color:green";
													strAuthStatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Authorized.label", "common_labels");
												}
																								
												//added for ml-mmoh-crf-0863 end
											} 
										}//added for ML-MMOH-CRF-0343 -end
										
								//Added for MMS-DM-CRF-0177
								pre_alloc_appl = bean.getPreAllocApplYN();
								drug_search = (String) drugDetails.get("DRUG_SEARCH_BY")==null?"":(String) drugDetails.get("DRUG_SEARCH_BY");
								if(pre_alloc_appl.equals("Y") && drug_search.equals("G") && !mode.equals("amend"))
								{
									new_generic_name= (String)drugDetails.get("DRUG_DESC_NEW")==null?"":(String)drugDetails.get("DRUG_DESC_NEW");
								}
								else
								{
									new_generic_name= (String) drugDetails.get("DRUG_DESC");
								}
								//Added for MMS-DM-CRF-0177
%>
				<TR>
					<TD CLASS="label">&nbsp;</TD>
					<TD CLASS="data"  style="font-size:10"><%=new_generic_name%></TD> <!-- Modified for MMS-DM-CRF-0177 -->
					<TD CLASS="label" style="font-size:10"><%= dose_type %></TD>
<%
					if(drugDetails.get("DOSAGE_TYPE").toString().equals("S")){
						String qty_val = (String)drugDetails.get("QTY_VALUE") == null?"":(String)drugDetails.get("QTY_VALUE");
						if(qty_val != "" && Float.parseFloat(qty_val) < 1.0)
							qty_val    = Float.parseFloat(qty_val)+"";
						String dispUom = (String)drugDetails.get("STRENGTHUOM")==null?(String)drugDetails.get("STRENGTH_UOM"):(String)drugDetails.get("STRENGTHUOM");
						
%>
						<TD CLASS="label" style="font-size:10"><%= qty_val %>&nbsp;<%=bean.getUomDisplay((String)session.getValue("facility_id"),dispUom)%></TD>
<%
					}
					else{

						String qty_val = (String)drugDetails.get("QTY_VALUE") == null?"":(String)drugDetails.get("QTY_VALUE");
						if(qty_val != "" && Float.parseFloat(qty_val) < 1.0)
							qty_val    = Float.parseFloat(qty_val)+"";
						String dispUom = (String)drugDetails.get("QTY_UNIT")==null?(String)drugDetails.get("QTY_UOM"):(String)drugDetails.get("QTY_UNIT");
%>					
						<TD CLASS="label" style="font-size:10"><%= qty_val %>&nbsp;<%=bean.getUomDisplay((String)session.getValue("facility_id"),dispUom)%>
					
						</TD>
<%}%>
					
					<TD CLASS="label"><%=ing_order_qty%>&nbsp;<%=stock_uom%></TD>
					<td class="label" align='center' style='<%=display_auth_rule%>;'> <!-- added for ML-MMOH-CRF-0343 -->
					<label id='lbl_authorize' style='<%=display_auth_rule%>;<%=color_auth_rule%>'><%=strAuthStatus%></label>
					</td>
				</TR>
<%
				drug_remarks	=	"";

				seq_num	=	(ArrayList)orderEntryRecordBean.getOrderFormats(((String)drugDetails.get("DRUG_CODE")),((String)drugDetails.get("DRUG_CODE"))+"_0");

				if(seq_num==null)
					seq_num			=	new ArrayList();

				for(int p=0; p<seq_num.size(); p++) {
					template	=	(Hashtable)orderEntryRecordBean.getOrderFormats(((String)drugDetails.get("DRUG_CODE")),(((String)drugDetails.get("DRUG_CODE"))+seq_num.get(p)));

					if(((String) template.get("field_mnemonic")).equals("PRES_REMARKS")) {
						drug_remarks = drug_remarks +"<br>"+template.get("label_text")+": "+ bean.getPrescriptionRemarks((String) template.get("field_values"));
					} 
					else {
						drug_remarks = drug_remarks +"<br>"+template.get("label_text")+": "+ (String) template.get("field_values");
					}
				}
				if(!drug_remarks.equals("")) {	
%>
					<tr><td colspan="6"></td></tr>
					<tr><td colspan="6"></td></tr>
					<tr><td colspan="6"></td></tr>
					<tr><td colspan="6"></td></tr>
					<tr>
						<TD CLASS="label" style="font-size:10"><fmt:message key="ePH.DrugRemarks.label" bundle="${ph_labels}"/>:</TD>
						<TD CLASS="label" colspan="5" style="font-size:10"><%=drug_remarks%></TD>
					<tr>
<%
					}
			  //added for MMS Adhoc Testing-Start
			  if(!drugindication_remarks.equals("")) {
%>
				<tr>
						<TD CLASS="label" nowrap><fmt:message key="ePH.DrugIndications.label" bundle="${ph_labels}"/>:</TD>
						<TD CLASS="label" style="font-size:10"><%=drugindication_remarks%></TD>
					<tr>

<%			
					}//added for MMS Adhoc Testing-End
				}
			}	
		}
%>
		<tr><td colspan="6"></td></tr>
		<tr><td colspan="6"></td></tr>
		<tr><td colspan="6"></td></tr>
		<tr><td colspan="6"></td></tr>
		</TABLE>
<%
		}
	}
%>

	<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="1">
	<td class="COLUMNHEADER" COLSPAN="6" ><FONT STYLE="font-size:10"><fmt:message key="ePH.AdministrationDetails.label" bundle="${ph_labels}"/></font></td>
	<tr><td colspan="6"></td></tr>
	<tr><td colspan="6"></td></tr>
	<tr><td colspan="6"></td></tr>
	<tr><td colspan="6"></td></tr>
	<tr><td colspan="6"></td></tr>


<%	

	if(MultiFlowRecs != null && MultiFlowRecs.size() > 0){
%>
	<TR >
		<TD CLASS="data" WIDTH="12%" style="font-size:10"><fmt:message key="ePH.FlowRateNo.label" bundle="${ph_labels}"/></TD>
		<TD CLASS="data" WIDTH="15%" style="font-size:10"><fmt:message key="ePH.InfuseVol.label" bundle="${ph_labels}"/></TD>
		<TD CLASS="data" WIDTH="20%" style="font-size:10"><fmt:message key="ePH.InfusionRate.label" bundle="${ph_labels}"/></TD>
		<TD CLASS="data" WIDTH="13%" style="font-size:10"><fmt:message key="ePH.InfuseOver.label" bundle="${ph_labels}"/></TD>
		<TD CLASS="data" WIDTH="20%" style="font-size:10"><fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/></TD>
		<TD CLASS="data" WIDTH="20%" style="font-size:10"><fmt:message key="Common.enddatetime.label" bundle="${common_labels}"/></TD>
	</TR>
<%		String volume		="";
		String inf_rate		="";
		String inf_over_hr	="";
		String inf_over_min	="";
		String InfRateHrMin	="";
	//	String start_date	="";
	//	String end_date		="";
		for(int i=1; i<=totRecs; i++){
			rec			= (ArrayList)MultiFlowRecs.get("MFR"+i);

			volume		= (String)rec.get(0);
			inf_rate	= (String)rec.get(1);
			InfRateHrMin= (String)rec.get(2);
			inf_over_hr	= (String)rec.get(3);
			inf_over_hr = inf_over_hr.length()==1?"0"+inf_over_hr:inf_over_hr;
			inf_over_min= (String)rec.get(4);
			inf_over_min = inf_over_min.length()==1?"0"+inf_over_min:inf_over_min;
			start_date	= (String)rec.get(6);
			end_date	= (String)rec.get(7);

%>
			<tr>
				<td class='label' ><fmt:message key="ePH.FlowRate.label" bundle="${ph_labels}"/>&nbsp;<%=i%></td>
				<td class='label' >
					<label><%=volume%> &nbsp;<%=bean.getUomDisplay((String)session.getValue("facility_id"),infusion_rate_uom)%></label>
				</td>
				<td class='label' >
					<% if(InfRateHrMin.equals("H")){%>
						<label><%=inf_rate%>&nbsp;<%=bean.getUomDisplay((String)session.getValue("facility_id"),infusion_rate_uom)%>/<fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></label>
<%					}else{%>
						<label><%=inf_rate%>&nbsp;<%=bean.getUomDisplay((String)session.getValue("facility_id"),infusion_rate_uom)%>/<fmt:message key="Common.Minute(s).label" bundle="${common_labels}"/></label>

<%					}%>
					
				</td>
				<td class='label' >
					<label><%=inf_over_hr%>:<%=inf_over_min%>&nbsp;<fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></label>

				</td>
				<td class='label' >
					<label><%=start_date%></label>
				<td class='label' >
					<label><%=end_date%></label>
				</td>
			</tr>
<%		}//for loop
	}else{
%>

	<TR>
		<TD CLASS="label" WIDTH="2%">&nbsp;</TD>
		<TD CLASS="data" WIDTH="20%" style="font-size:10"><fmt:message key="ePH.InfusionRate.label" bundle="${ph_labels}"/></TD>
		<TD CLASS="data" WIDTH="18%" style="font-size:10"><fmt:message key="ePH.InfuseOver.label" bundle="${ph_labels}"/></TD>
		<TD CLASS="data" WIDTH="20%" style="font-size:10"><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></TD>
		<TD CLASS="data" WIDTH="20%" style="font-size:10"><fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/></TD>
		<TD CLASS="data" WIDTH="20%" style="font-size:10"><fmt:message key="Common.enddatetime.label" bundle="${common_labels}"/></TD>
	</TR>
	<TR>
		<TD CLASS="label" WIDTH="2%">&nbsp;</TD>
		<TD CLASS="label" WIDTH="20%" style="font-size:10"><%= infusion_rate %><%=bean.getUomDisplay((String)session.getValue("facility_id"),infusion_rate_uom)%> / <%=infusionRatePeriod%></TD>
		<TD CLASS="label" WIDTH="18%" style="font-size:10"><%= infusion_over_disp %>&nbsp;<%=infusion_over_uom_desc%></TD>
		<TD CLASS="label" WIDTH="20%" style="font-size:10"><%= frequency %></TD>
		<TD CLASS="label" WIDTH="20%" style="font-size:10"><%= start_date %></TD>
		<TD CLASS="label" WIDTH="20%" style="font-size:10"><%= end_date %></TD>
	</TR>
	<%		if(!freq_str.equals("")) { %>
		<tr><td colspan="6" class="white"></td></tr>
		<tr><td colspan="6" class="white"></td></tr>
		<tr>	
				<td width="2%">&nbsp;</td>
				<td>&nbsp;</td>
				<td colspan="4" class="label" style="font-size:10">&nbsp;&nbsp;<%=freq_str%></td>	
		</tr>
	<%
		} 
			String clinical_comments	=	pres_bean.getPresRemarks();
		   if(clinical_comments!=null && !clinical_comments.equals("")) {
	%>
		<tr>
			<td class="white"></td></tr><tr><td class="white"></td>
		</tr>
		<tr>
			<td class="white"></td></tr><tr><td class="white"></td>
		</tr>
		<tr>
			<td colspan="7" class="label" style="font-size:10"><b><fmt:message key="ePH.PrescriptionRemarks.label" bundle="${ph_labels}"/>:</b>&nbsp;&nbsp;&nbsp;&nbsp;<%=clinical_comments%></td>
		</tr>
<%	
					}
				}
%>
			</TABLE>
		</FORM>
<%
	}
	catch(Exception e){
		e.printStackTrace();
	}
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(or_bean_id,orbean,request);
	putObjectInBean(pres_bean_id,pres_bean,request);
%>
	</BODY>
</HTML>

