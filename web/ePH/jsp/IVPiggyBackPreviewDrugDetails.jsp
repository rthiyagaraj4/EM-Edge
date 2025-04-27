<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
28/10/2020		IN074292	  	   Shazana											   SKR-SCF-1454
06/01/2021		 TFS-7345          Prabha      06/01/2020	  Manickavasagam J         MMS-DM-CRF-0177
--------------------------------------------------------------------------------------------------------------
*/
%>
<!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086 
		String locale = (String) session.getAttribute("LOCALE");		
        String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String title_display		= request.getParameter("title_display");
%>
		<TITLE><%=title_display%></TITLE>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<!-- <SCRIPT LANGUAGE="javascript" SRC="../js/IVPiggyBack.js"></SCRIPT> -->
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
		<form name="frmPrescriptionPrevOrdersCriteria" id="frmPrescriptionPrevOrdersCriteria"><%
		try{
			String patient_class		= request.getParameter("patient_class");
			String patient_id			= request.getParameter("patient_id");
			String encounter_id			= request.getParameter("encounter_id");
			String date					= request.getParameter("ord_date");
			String locn_code			= request.getParameter("locn_code");
			String pract_name			= request.getParameter("pract_name");
			String fluid_code			= request.getParameter("fluid_code");
			String fluid_name			= request.getParameter("fluid_name");
			String infusion_rate		= request.getParameter("infusion_rate");
			String infusion_over		= request.getParameter("infusion_over");
			String infusion_over_uom	= request.getParameter("infusion_over_uom");
			String infusion_rate_uom	= request.getParameter("infusion_rate_uom");
			String tot_inf_volume		= request.getParameter("tot_inf_volume");
			String durn_value		    = request.getParameter("durn_value");
			String frequency			= request.getParameter("freq_desc");
			String freq_code			= request.getParameter("freq_code");
			String start_date			= request.getParameter("start_date");
			String end_date				= request.getParameter("end_date");
			String lstInfusionRateDurnUnit	= request.getParameter("lstInfusionRateDurnUnit");
			String mode	= request.getParameter("mode")==null?"":request.getParameter("mode"); //Added for MMS-DM-CRF-0177
			String drugindication_remarks	= "";//added for MMS Adhoc Testing
			//String order_status="";//added for ml-mmoh-crf-0863
			
			boolean display=false;
			boolean drugDisplay=false;
			String dispUom =	"";
			String patient_name			= "";
			String age					= "";
			String sex			        = "";
			String qty_unit				= "";
			String ing_order_uom		= "";
			String eqvl_value			= "";
			String freq_str				= "";
			String drug_code			=  "";
			String display_auth_rule ="visibility:hidden", color_auth_rule = "RED", ord_auth_reqd_yn = "", ord_authorized_yn = "", strAuthStatus="-" ;  //added for ML-MMOH-CRF-0343
			String preview_auth_status_yn = "Y";//bean.getPreviewAuthStatus(); //added for ML-MMOH-CRF-0343
			if( "Y".equals(preview_auth_status_yn)) {   // if condition added for ML-MMOH-CRF-0343
				display_auth_rule = "visibility:visible";   
			}
			double iOrdQty				= 0;
			HashMap detail			    = null;
			String infusionRatePeriod = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Hour(s).label","common_labels");
			String infusion_over_uom_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Hour(s).label","common_labels");
			if(lstInfusionRateDurnUnit.equals("M")){
				infusionRatePeriod=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Minute(s).label","common_labels");
			}
			if(infusion_over_uom.equals("M"))
				infusion_over_uom_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Minute(s).label","common_labels");
			
			String pres_bean_id			 = "@PrescriptionBean_1"+patient_id+encounter_id;
			String pres_bean_name		 = "ePH.PrescriptionBean_1";
			PrescriptionBean_1 pres_bean = (PrescriptionBean_1)getBeanObject( pres_bean_id, pres_bean_name, request ) ;
			
			String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
			String bean_name		= "ePH.IVPrescriptionBean";
			IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject(bean_id, bean_name, request);
			//added for NMC-JD-CRF-0063 [13355]
			patient_class = pres_bean.getPrEncounterPatientClass(patient_id, encounter_id);
					if(patient_class!=null){
						if(patient_class.equals("O"))
							patient_class="OP";
						else if(patient_class.equals("E"))
							patient_class="EM";
						else if (patient_class.equals("I"))
							patient_class="IP"; 
						else if (patient_class.equals("D"))
								patient_class="DC"; 
					}//END 
			String locn_desc	   = bean.getLocationDesc(patient_class,locn_code);
			
			ArrayList pat_details	= bean.getPatientDetails(patient_id);
		//	order_status=bean.getOrderStatus();//added for ml-mmoh-crf-0863
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

			String infusion_over_disp = infusion_over;
			if(infusion_over.indexOf(".") != -1){
				infusion_over_disp = infusion_over.substring(0,infusion_over.indexOf("."));
				Double temp = new Double(infusion_over);
				String hr = "";
				temp = temp*60;
				temp = (temp%60);
				infusion_over_disp =  Math.round(temp)+"";
				hr = infusion_over.substring(0,infusion_over.indexOf("."));
				if(hr.equals(""))
					hr = "0";
				infusion_over_disp = hr+":"+infusion_over_disp;
			}
			else{
				infusion_over_disp = infusion_over;
			}
			//added for ml-mmoh-crf-0863 start
			String called_amend_from=pres_bean.getCalledFromAmend();
			String disp_locn_code	= "";
			 disp_locn_code=bean.getDisp_locn_code();
			//System.out.println("disp in IVPiggyBackpreviewDetails"+bean.getDisp_locn_code());
			 String auth_amend_pres_yn="";
				auth_amend_pres_yn = bean.getAuthAmendPres(disp_locn_code);
			//	System.out.println(disp_locn_code+"IVPiggyBackpreviewDetails"+auth_amend_pres_yn);
				//added for ml-mmoh-crf-0863 end
%>

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
					<TD CLASS="data" WIDTH="30%" style="font-size:10"><%= pract_name %></TD>
				</TR>
				<tr><td colspan="4"></td></tr>
				<tr><td colspan="4"></td></tr>
				<tr><td colspan="4"></td></tr>
				<tr><td colspan="4"></td></tr>
			</TABLE>
<%
			HashMap fluidDetails = (HashMap)bean.getFluidDetails();
			String pack_size	= bean.getPackSize(fluid_code);
			String order_uom	= bean.getStockUOM(fluid_code);
			String order_qty		= (String)fluidDetails.get("ORDERED_QTY");
			ArrayList drugList = bean.getDrugDetails();

			if (drugList.size() != 0) {
				
				for (int i=0; i<drugList.size(); i++) {
					HashMap drugDetails	= (HashMap)drugList.get(i);
					if(drugDetails.get("DOSAGE_TYPE") !=null){
						drugDisplay = true;
					}
					if( !drugDetails.get("DRUG_CODE").equals(fluid_code)){
						display=true;
						break;
					}

					if(drugDetails.get("DOSAGE_TYPE") ==null || drugDetails.get("DOSAGE_TYPE").equals("") )
						drugDetails.put("DOSAGE_TYPE", (String)fluidDetails.get("DOSAGE_TYPE") );
				}
				if(display){
					if( "Y".equals(preview_auth_status_yn)) {  //added for ML-MMOH-CRF-0343
						strAuthStatus="-";
					} 
%>
					<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
						<TR>
							<td class="COLUMNHEADER" WIDTH="40%" style="font-size:10"><fmt:message key="ePH.Fluid.label" bundle="${ph_labels}"/></td>
							<td class="COLUMNHEADER" WIDTH="20%" style="font-size:10"><fmt:message key="Common.volume.label" bundle="${common_labels}"/></td>
							<td class="COLUMNHEADER" WIDTH="20%" style="font-size:10"><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
							<td class="COLUMNHEADER" WIDTH="20%" style="font-size:10" style='<%=display_auth_rule%>;'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td> <!-- Added for ML-MMOH-CRF-0343 -->
<!-- 							<td class="COLUMNHEADER" WIDTH="20%" style="font-size:10">&nbsp;</td>		 -->
						</TR>
						<tr><td colspan="4"></td></tr>
						<tr><td colspan="4"></td></tr>
						<tr><td colspan="4"></td></tr>
						<tr><td colspan="4"></td></tr>

						<TR>
							<TD CLASS="data"  style="font-size:10"><%= fluid_name %> </TD>
							<TD CLASS="label" WIDTH="20%" style="font-size:10"><%= tot_inf_volume %>&nbsp;<%=bean.getUomDisplay((String)session.getValue("facility_id"),infusion_rate_uom)%></TD>
							<TD CLASS="data" width="20%" style="font-size:10"><%=Math.ceil(Float.parseFloat(order_qty))%>&nbsp;<%=order_uom%></TD>
							<TD class="label" align='center' style='<%=display_auth_rule%>;'> <!-- added for ML-MMOH-CRF-0343 -->
											<label id='lbl_authorize' style='<%=display_auth_rule%>;'><%=strAuthStatus%></label>
							</TD>
							<td>&nbsp;</td>
						</TR>

						<tr><td colspan="4"></td></tr>
						<tr><td colspan="4"></td></tr>
						<tr><td colspan="4"></td></tr>
						<tr><td colspan="4"></td></tr>
					</TABLE>
<%
				}
				if(drugDisplay){
%>
					<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
						<TR>
							<td class="COLUMNHEADER" WIDTH="35%" style="font-size:10"><fmt:message key="ePH.DrugDetail.label" bundle="${ph_labels}"/></td>
							<td class="COLUMNHEADER" WIDTH="10%" style="font-size:10"><fmt:message key="Common.DosageBy.label" bundle="${common_labels}"/></td>
							<td class="COLUMNHEADER" WIDTH="15%" style="font-size:10"><fmt:message key="ePH.Dose.label" bundle="${ph_labels}"/></td>
							<td class="COLUMNHEADER" WIDTH="15%" style="font-size:10"><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
							<td class="COLUMNHEADER" WIDTH="25%" style="font-size:10" style='<%=display_auth_rule%>;'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td> <!-- Added for ML-MMOH-CRF-0343 -->
						</TR>
<%
						HashMap drugDetails					=	null;
						String dosage_type 					=	"";
						String strength_per_value_pres_uom	=	"";
						String strength_per_pres_uom		=	"";
						String content_in_pres_base_uom		=	"";
						String stock_uom					=	"";
						String fract_dose					=   "";
						float ing_order_qty					=	0;
						//float in_tot_qty					=	0;
						String item_code					=  "";		
							   order_uom					=  "";
						String ordered_qty					=  "";
						String dose_type					=  "";
						String repeat_value					=  "";
						
						//MMS-DM-CRF-0177
						String new_generic_name = "";
						String pre_alloc_appl = "";
						String drug_search = "";
						pre_alloc_appl = bean.getPreAllocApplYN();
						//Added for MMS-DM-CRF-0177
						
						
						float dur1							=0;	

						for (int i=0; i<drugList.size(); i++) {
							drugDetails	= (HashMap)drugList.get(i);

						  if(drugDetails.size() != 0){
							 stock_uom					=	bean.getStockUOM((String)drugDetails.get("DRUG_CODE"));
							if(drugDetails.get("DOSAGE_TYPE") !=null){
								/*====order quantity calculation========*/
								item_code = (String)drugDetails.get("ITEM_CODE")==null?"":(String)drugDetails.get("ITEM_CODE");
								if(item_code==null || item_code.equals(""))
									item_code = (String)drugDetails.get("ORDER_CATALOG_CODE");

								if(!item_code.equals("")){

									drug_code					= (String)drugDetails.get("DRUG_CODE")==null?"":(String)drugDetails.get("DRUG_CODE");
									order_uom					= bean.getStockUOM(drug_code);
									dosage_type					= (String)drugDetails.get("DOSAGE_TYPE")==null?"":(String)drugDetails.get("DOSAGE_TYPE"); 
									repeat_value				= (String)drugDetails.get("REPEAT_VALUE")==null?"1":(String)drugDetails.get("REPEAT_VALUE"); 
									strength_per_value_pres_uom = (String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM")==null?"":(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");
									strength_per_pres_uom       = (String)drugDetails.get("STRENGTH_PER_PRES_UOM")==null?"":(String)drugDetails.get("STRENGTH_PER_PRES_UOM");
									content_in_pres_base_uom    = (String)drugDetails.get("CONTENT_IN_PRES_BASE_UOM")==null?"":(String)drugDetails.get("CONTENT_IN_PRES_BASE_UOM");
									drugindication_remarks		=	(String)drugDetails.get("DRUG_INDICATION")==null?"":(String)drugDetails.get("DRUG_INDICATION");//added for MMS Adhoc Testing
									
									//Added for MMS-DM-CRF-0177
									drug_search = (String) drugDetails.get("DRUG_SEARCH_BY")==null?"":(String)drugDetails.get("DRUG_SEARCH_BY");
									if(pre_alloc_appl.equals("Y") && drug_search.equals("G") && !mode.equals("amend"))
									{
										new_generic_name= (String)drugDetails.get("DRUG_DESC_NEW")==null?"":(String)drugDetails.get("DRUG_DESC_NEW");
									}
									else
									{
										new_generic_name= (String) drugDetails.get("DRUG_DESC");
									}
									//Added for MMS-DM-CRF-0177
									
									float ing_unit_qty		    = Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
									float in_tot_qty            = 0.0f;
									fract_dose					= bean.getFractDoseRndyn((String)drugDetails.get("DRUG_CODE"));
									dur1			            = Float.parseFloat(durn_value);
									
									HashMap freqDet             = bean.getscheduleFrequency();
									
									String freqDurnType			= "";
									String interval_val = "1";
									//for interval frequency there wont be schedule

									HashMap freqNature	=(HashMap)bean.freqValidate(freq_code);
									if(!((String)freqNature.get("freq_nature")).equals("I") && freqDet!=null && freqDet.size()>0){
										freqDurnType = (String)(((HashMap)(((ArrayList)freqDet.get(drug_code)).get(0))).get("durationType"))==null?"":(String)(((HashMap)(((ArrayList)freqDet.get(drug_code)).get(0))).get("durationType"));	
										freqDurnType =  (String)freqNature.get("interval_durn_type");
										interval_val = (String)freqNature.get("interval_value");
									}
									else{
										freqDurnType =  (String)freqNature.get("interval_durn_type");
										interval_val = (String)freqNature.get("interval_value");
									}

									String durn_unit = (String)request.getParameter("durn_unit")==null?"":(String)request.getParameter("durn_unit");

									if(! freqDurnType.equals(durn_unit)) {
										int durn_calc = bean.getDurationCalc(durn_unit,durn_value,freqDurnType);
										dur1 = Float.parseFloat(durn_calc+"");
									}

									dur1 = dur1/Float.parseFloat(interval_val);
									repeat_value = bean.getRepeatValue();
									ing_unit_qty = Float.parseFloat(bean.getDOSAGE());																
									if(dosage_type!=null){
										if(dosage_type.equals("S")) {				
											strength_per_value_pres_uom	=	(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");	
											strength_per_pres_uom		=	(String)drugDetails.get("STRENGTH_PER_PRES_UOM");
											if(fract_dose.equals("Y")){

												in_tot_qty	=  new Double(Math.ceil(ing_unit_qty/Float.parseFloat(strength_per_pres_uom))).floatValue() * Float.parseFloat(strength_per_value_pres_uom);
												ordered_qty	=	(new Double(Math.ceil(in_tot_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue()*dur1)+"";
											}
											else if(fract_dose.equals("N")){
												in_tot_qty	= (ing_unit_qty*Float.parseFloat(strength_per_value_pres_uom))/(Float.parseFloat(strength_per_pres_uom));  
												ordered_qty	=   ((in_tot_qty*dur1*Float.parseFloat(repeat_value))/Float.parseFloat(content_in_pres_base_uom))+"";//Multiplied repeat_value for ARYU-SCF-0076
												ordered_qty		=	Math.ceil(Float.parseFloat(ordered_qty))+"";//Added for ARYU-SCF-0076
											}
										}
										else {
											qty_unit			= (String)drugDetails.get("QTY_DESC_CODE");
											ing_order_uom		= (String)drugDetails.get("PRES_BASE_UOM");
											eqvl_value			=  bean.getConvFactor(ing_order_uom,qty_unit);
											if(eqvl_value.equals(""))	eqvl_value	=	"1";	
												in_tot_qty = ing_unit_qty*Float.parseFloat(eqvl_value);

											if(fract_dose.equals("Y")){
												ordered_qty	=   (new Double(Math.ceil(in_tot_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue()*dur1)+"";
											}
											else if(fract_dose.equals("N")){
												ordered_qty	=   ((in_tot_qty*dur1)/Float.parseFloat(content_in_pres_base_uom))+"";
												ordered_qty = Float.parseFloat(ordered_qty) * Float.parseFloat(repeat_value)+"";//Added for IN074292
											}
										}	
									}

									 if(fract_dose.equals("Y")){ //replaced "N" with "Y" for IN25538 --25/02/2011-- priya
										 ordered_qty=Math.ceil(Float.parseFloat(ordered_qty) * Float.parseFloat(repeat_value))+"";

									}/*else{commented else condition for  ARYU-SCF-0076
										ordered_qty=Float.parseFloat(ordered_qty) * Float.parseFloat(repeat_value)+"";

									}*/
								}
								ordered_qty = ordered_qty.equals("")?"0":ordered_qty;
								iOrdQty = Math.ceil(Float.parseFloat(ordered_qty));
							}
							if(dosage_type.equals("Q")){
								 dose_type 	=  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Quantity.label","common_labels"); 			
							}
							else{
								 dose_type 	=  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Strength.label","common_labels");
							}
							if( "Y".equals(preview_auth_status_yn)) {
								ord_auth_reqd_yn = (String) drugDetails.get("ORD_AUTH_REQD_YN");  //added for ML-MMOH-CRF-0343 -start
								ord_authorized_yn			= (String) drugDetails.get("ORD_AUTHORIZED_YN");
								display_auth_rule = "visibility:visible";
								if("Y".equals(ord_auth_reqd_yn)){
									color_auth_rule = "color:red";
									strAuthStatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.AuthorizationReqd..label", "common_labels");
									if("Y".equals(ord_authorized_yn)){
										color_auth_rule = "color:green";
										strAuthStatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Authorized.label", "common_labels");
									}
									//added for ml-mmoh-crf-0863 start
									if("Y".equals(auth_amend_pres_yn) &&  called_amend_from.equals("PH")){
										color_auth_rule = "color:green";
										strAuthStatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Authorized.label", "common_labels");
									}
									
									//added for ml-mmoh-crf-0863 end
								} 
							}//added for ML-MMOH-CRF-0343 -end
%>
							<TR>
								<TD CLASS="data"  style="font-size:10"><%=new_generic_name%></TD> <!-- Modified for MMS-DM-CRF-0177 -->
								<TD CLASS="label" style="font-size:10"><%= dose_type %></TD>
<%
								if(drugDetails.get("DOSAGE_TYPE").toString().equals("S")){
									String qty_val = (String)drugDetails.get("QTY_VALUE") == null?"":(String)drugDetails.get("QTY_VALUE");
									if(qty_val != "" && Float.parseFloat(qty_val) < 1.0)
										qty_val = Float.parseFloat(qty_val)+"";
									dispUom = (String)drugDetails.get("STRENGTHUOM")==null?(String)drugDetails.get("STRENGTH_UOM"):(String)drugDetails.get("STRENGTHUOM");
%>
									<TD CLASS="label" style="font-size:10"><%= qty_val %>&nbsp;<%=bean.getUomDisplay((String)session.getValue("facility_id"),dispUom)%></TD>
<%
								}
								else{
									String qty_val = (String)drugDetails.get("QTY_VALUE") == null?"":(String)drugDetails.get("QTY_VALUE");
									if(qty_val != "" && Float.parseFloat(qty_val) < 1.0)
										qty_val = Float.parseFloat(qty_val)+"";
									dispUom = (String)drugDetails.get("QTY_UNIT")==null?(String)drugDetails.get("QTY_UOM"):(String)drugDetails.get("QTY_UNIT");
%>					
									<TD CLASS="label" style="font-size:10"><%= qty_val %>&nbsp;<%=bean.getUomDisplay((String)session.getValue("facility_id"),dispUom)%>
									</TD>
<%
								}
%>
								<TD CLASS="data" width="20%" style="font-size:10"><%=ordered_qty%>&nbsp;<%=stock_uom%></TD>
								<td class="label" align='center' style='<%=display_auth_rule%>;'> <!-- added for ML-MMOH-CRF-0343 -->
								<label id='lbl_authorize' style='<%=display_auth_rule%>;<%=color_auth_rule%>'><%=strAuthStatus%></label>
								</td>
							</TR>
<%
		   //added for MMS Adhoc Testing-Start
			if(!drugindication_remarks.equals("")) {
%>
				  <tr>
						<td class="label" colspan=2><fmt:message key="ePH.DrugIndications.label" bundle="${ph_labels}"/>:&nbsp;<b><%=drugindication_remarks%></b><br>&nbsp;</td>
					</tr>
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

			ArrayList schedule	=	(ArrayList)bean.getScheduleFrequencyStr(drug_code,"0");
			if(display){
				freq_str = (String)bean.getTooltipStringFrFreq(schedule,"prvwString"+bean.getUomDisplay((String)session.getValue("facility_id"),infusion_rate_uom));
			}
			else{
				freq_str = (String)bean.getTooltipStringFrFreq(schedule,"prvwString"+bean.getUomDisplay((String)session.getValue("facility_id"),dispUom));
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

			<TR>
				
				<TD CLASS="data" WIDTH="20%" style="font-size:10"><fmt:message key="ePH.InfusionRate.label" bundle="${ph_labels}"/></TD>
				<TD CLASS="data" WIDTH="18%" style="font-size:10"><fmt:message key="ePH.InfuseOver.label" bundle="${ph_labels}"/></TD>
				<TD CLASS="data" WIDTH="20%" style="font-size:10"><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></TD>
				<TD CLASS="data" WIDTH="20%" style="font-size:10"><fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/></TD>
				<TD CLASS="data" WIDTH="20%" style="font-size:10"><fmt:message key="Common.enddatetime.label" bundle="${common_labels}"/></TD>
			</TR>
			<TR>
				
				<TD CLASS="label" WIDTH="20%" style="font-size:10"><%= infusion_rate %><%=bean.getUomDisplay((String)session.getValue("facility_id"),infusion_rate_uom)%> / <%=infusionRatePeriod%></TD>
				<TD CLASS="label" WIDTH="18%" style="font-size:10"><%= infusion_over_disp %>&nbsp;<%=infusion_over_uom_desc%></TD>
				<TD CLASS="label" WIDTH="20%" style="font-size:10"><%= frequency %></TD>
				<TD CLASS="label" WIDTH="20%" style="font-size:10"><%= start_date %></TD>
				<TD CLASS="label" WIDTH="20%" style="font-size:10"><%= end_date %></TD>
			</TR>
<%
			if(freq_str!=null && !freq_str.equals("")) { 
%>
				<tr><td colspan="6" class="white"></td></tr>
				<tr><td colspan="6" class="white"></td></tr>
				<tr>						
					<td colspan="5" class="label" style="font-size:10"><b><fmt:message key="Common.Schedule.label" bundle="${common_labels}"/></b> &nbsp;:&nbsp;<%=freq_str%></td>	
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
%>
					<tr>
						<td colspan=7 align="right">
							<input type="button"   class="button" value='<fmt:message key="ePH.ReleaseRx.label" bundle="${ph_labels}"/>' name="release_rx" onclick="toCloseTopShowModal('R');"></input>&nbsp;&nbsp;&nbsp; <!--added for ML-BRU-SCF-0533 [IN:036030] -->
							<INPUT TYPE="button" CLASS="button" name="RELEASE" id="RELEASE" VALUE='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="toCloseTopShowModal();">
						</td>
					</tr>
				</table>
<%
			}
			catch(Exception e){
				e.printStackTrace();
			}
%>
		</form>
	</body>
</html>

