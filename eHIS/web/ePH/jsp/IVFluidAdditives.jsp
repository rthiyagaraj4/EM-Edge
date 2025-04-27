<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
16/4/2020		IN072917			Shazana												SKR-SCF-1317
07/06/2020      IN072753           Prabha											   NMC-JD-CRF-0046
15/07/2020      IN:073424		   Prabha												SKR-SCF-1391
06/01/2021		TFS-7345           Prabha      06/01/2020	  Manickavasagam J         MMS-DM-CRF-0177
12/02/2021      TFS-13907     	   Prabha 		12/02/2021     Manickam           	   PH-eCommon label issue in various transactions
2/3/2021		15129				Shazana						Manickam				ph eCommon labels issue 		
--------------------------------------------------------------------------------------------------------------
*/
%> 


<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.sql.*,webbeans.eCommon.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
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
		String locale			= (String)session.getAttribute("LOCALE");	
		String sStyle= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link> 
		<!-- 	import the calendar script -->
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script> 
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/DrugNameCommonLookup.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/IVPrescription.js"></SCRIPT>
	</HEAD>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
		<FORM name="formIVPrescriptionAdditives" id="formIVPrescriptionAdditives">
<%
	Connection con			= null;    //added for GHL-CRF-0549
	try{
		con						   = ConnectionManager.getConnection(request);//added for GHL-CRF-0549
   	  	boolean item_type_site_app = eCommon.Common.CommonBean.isSiteSpecific(con,"PH","ITEM_TYPE_APP");//added for GHL-CRF-0549
   	 boolean strength_display_app =eCommon.Common.CommonBean.isSiteSpecific(con,"PH","STRENGTH_DISPLAY_APP");//added for NMC-JD-CRF-0026
   	boolean op_take_home_med_flag = eCommon.Common.CommonBean.isSiteSpecific(con,"PH", "OP_TAKE_HOME_MEDICATION");//added for NMC-JD-CRF-0063[13355]
   	boolean req_diag_pres_found=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REQ_DIAG_PRES_FOUND");
			String patient_id		= request.getParameter("patient_id");
			String encounter_id		= request.getParameter("encounter_id");
			String act_patient_class	= request.getParameter("act_patient_class")==null?"":request.getParameter("act_patient_class");
			String patient_class	= request.getParameter("patient_class")==null?act_patient_class:request.getParameter("patient_class");
			String start_date		= request.getParameter("start_date");
			String order_type_flag	= request.getParameter("order_type_flag");
			if(order_type_flag == null){ order_type_flag="";}
			String prev_order		= request.getParameter("prev_order")== null?"":request.getParameter("prev_order");   // Modified For IN:062361
			
			if(prev_order == null){ prev_order="";}
			String order_id1        = request.getParameter("order_id");
			String iv_prep_default	= request.getParameter("iv_prep_default")==null?act_patient_class:request.getParameter("iv_prep_default");
			String order_set_code	= request.getParameter("order_set_code")==null?act_patient_class:request.getParameter("order_set_code");
			String form_code		= "";
			String route_code		= "";
			String order_type_code	= "";
			String selected1		= "selected";
			String selected2		= "";
			String take_home_medication	= request.getParameter("take_home_medication")==null?"":request.getParameter("take_home_medication"); // Added For IN:062361
			String priority	= request.getParameter("priority")==null?"":request.getParameter("priority");   // Added For IN:062361
			
			//GHL-CRF-0549 - start
			String disp_by_alt_form_param = "";
			String disp_by_alt_form_drug = "";
			String item_type = "";
			String mm_item_low_cost_yn = ""; 
			String mm_item_high_margin_yn = "";
			String mm_item_Innovator_yn  = "";
			String allow_alternate_yn ="N"; //GHL-CRF-0549
			String allow_alternate_disabled	= "";
			String allow_alternate_checked = "";
			String allow_alternate		   = "N";
			//GHL-CRF-0549 - end
			//added for NMC-LD-CRF-0026 START	
			String strength_label_display="";
			if(strength_display_app){
				
				strength_label_display="display:inline;";
				
			}
			else{
				strength_label_display="display:none;";
				
			}
			//added for NMC-LD-CRF-0026 END
			ArrayList orderSetCodes	=new ArrayList();
			int t					= 0;
			String mode1= request.getParameter("mode");
			if(mode1==null) mode1	= "";
			String mode				= CommonRepository.getCommonKeyValue( "MODE_MODIFY" ); 
			String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
			String bean_name		= "ePH.IVPrescriptionBean";
			IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject( bean_id, bean_name, request ) ;
			bean.setOrderDate(com.ehis.util.DateUtils.convertDate(start_date,"DMYHM",locale,"en"));
			bean.setPatientClass(patient_class);
			bean.setPatId(patient_id);
			bean.setEncId(encounter_id);
			bean.setMode( mode ) ;
			String param_volume_cal=bean.getParamVolumeCalc();//aDDED FOR AAKH-CRF-0094
			String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
			String or_bean_name		= "eOR.OrderEntryBean";
			OrderEntryBean ORbean	= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name , request) ;
			String locn_type		= (String)ORbean.getLocationType();
			String locn_code		= (String)ORbean.getLocationCode();
			String pract_id			= (String)ORbean.getPractitionerId();
			String pract_name		= (String)ORbean.getPractitionerName();
			if(prev_order.equals("previous")){
				ORbean.setOrderId(order_id1);
			}
			String order_id			= (String)ORbean.getOrderId();
			bean.setLocationType(locn_type);
			bean.setLocationCode(locn_code);
			bean.setPractionerID(pract_id);
			String end_date			= "";
			String mfr_display		= "hidden";
			String remarksDisplay	= "display:inline";
			//String drug_code	= "";
			HashMap hm_fluid_details = null;
			String act_pat_class		= request.getParameter("act_pat_class")==null?"":request.getParameter("act_pat_class");  //RUT-CRF-0062
			if(bean.getAmendFluidDetails()==null){
				bean.loadAmendDetails(order_id, patient_id,act_pat_class);  //RUT-CRF-0062
			}else if(bean.getAmendFluidDetails() !=null && (bean.getAmendFluidDetails()).size()==0){
				bean.loadAmendDetails(order_id, patient_id,act_pat_class); //RUT-CRF-0062
			}
			hm_fluid_details = bean.getAmendFluidDetails();
			if(hm_fluid_details !=null){
				if(hm_fluid_details.size()>0){
					//drug_code	=	(String)hm_fluid_details.get("drug_code");
					start_date	=	(String)hm_fluid_details.get("START_DATE_TIME");
					end_date	=	(String)hm_fluid_details.get("END_DATE_TIME");
					start_date	=	bean.getOrderDate();
				}
			}

			if(start_date.equals(""))
				start_date = bean.getSysdate();
			String buildMAR_yn		= "";
			String MAR_app_yn		= "";
			String buildMAR_checked = "";
			
			String buildMAR_enable  = ""; // RUT-CRF-0062 [IN029600] Added to get Build MAR Rule CRF 0062 -- begin
			String buildMAR_rule	= "";  
			String facility_id		=(String)session.getValue("facility_id");	// RUT-CRF-0062 [IN029600] Added to get Build MAR Rule CRF 0062 -- end
			/* Commented for SRR20056-CRF-0649.1 to (deselect)enable BuildMAR fo rIP
			String buildMAR_enable	= "";				 SRR20056-CRF-0649.1 */
			MAR_app_yn				= request.getParameter("MAR_app_yn")==null?"":request.getParameter("MAR_app_yn");
			buildMAR_yn				= MAR_app_yn;
			
			//Start of NMC-JD-CRF-0046
			String ext_disp_appl_yn="";
			String  disp_loc = (String)bean.getDisp_locn_code();
			ext_disp_appl_yn = bean.getExtDispYN(disp_loc);
		       //End of NMC-JD-CRF-0046
			
			
			/*  RUT-CRF-0062 [IN029600] Commented to set Build MAR value based on Build MAR Rule
			if(MAR_app_yn.equals("Y")){
				/* Commented for SRR20056-CRF-0649.1 to (deselect)enable BuildMAR fo rIP
				if(patient_class.equals("IP"))
					buildMAR_enable ="disabled";
				 SRR20056-CRF-0649.1 
				if(buildMAR_yn.equals("Y"))
				buildMAR_checked ="Checked";
			}*/
			ArrayList ExistingIVRecords;
			HashMap record;
			String catalog_desc			="";
			String qty_value			="";
			String infusion_rate		="";
			String infusion_over		="";
			String infuse_over_hr		="";
			String infuse_over_mi		="";
			String durnn_value			="";
			String start_date_time		="";
			String end_date_time		="";
			String readonly				="readonly";
			String disable				="disabled";
			String order_catalog_code	="";
			String stock_value			="";
			String stock_uom			="";
			String durn_unit			="H";
			String qty_unit				="";
			String actveVal				="hidden";
			String base_volume			="";
			String qty_unit_disp		="";
			String mfr_yn				="";
			String mfr_remarks			="";
			int i						=0;
			String row_count			="";
			int fluid_adr_count			=0;
			String fluid_adr_dispaly	="hidden";
			String disable_for_mfr		="";
			int totRec					=0;
			String perf_locn_code		=""; // Added for Bru-HIMS-CRF-347 [IN:037862] -- Begin
			String perf_locn_desc		=""; // Added for Bru-HIMS-CRF-347 [IN:037862] -- Begin
			String per_facility_id		=""; // Added for Bru-HIMS-CRF-347 [IN:037862] -- Begin
			String  act_strength_value="";//added for NMC-JD-CRF-0026
			String  strength_uom_desc="";//added for NMC-JD-CRF-0026
			String  strength_per_value_pres_uom_val="";//added for NMC-JD-CRF-0026
			String  pres_base_uom_desc="";//added for NMC-JD-CRF-0026
			String diagnosis_found_yn="";//added for mms-dm-crf-0204
			String new_generic_name = ""; //Added for MMS-DM-CRF-0177
					
			HashMap mfr_recs			= new HashMap();
			ArrayList mfr_rec_detail	= new ArrayList();
			if(patient_class!=null ){//added for NMC-JD-CRF-0063 [13355] start
				if(patient_class.equals("EM")|| patient_class.equals("OP") ){  
					if(op_take_home_med_flag){
						bean.setTakeHomeMedicationOp("Y");
					}else{
						bean.setTakeHomeMedicationOp("N");
					}
				}
			}//END
			if(mode1.equals("amend")){
				bean.setOrderID(order_id1);
			}
			String iv_calc_infuse_by=bean.getIVCalcInfuseBy(); //added for SKR-CRF-0035
			if(order_type_flag.equals("Existing")||mode1.equals("amend")){	 
				String iv_calc_infuse_display="",  order_uom="", iv_durn_display; //iv_durn_display added for SKR-SCF-1077 [IN:054499]
				String order_qty = "";
				if(iv_calc_infuse_by.equals("I")){
					iv_calc_infuse_display="display:inline;";
					iv_durn_display="display:none;"; //added for SKR-SCF-1077 [IN:054499]
				}
				else{
					iv_calc_infuse_display="display:none;";
					iv_durn_display="display:inline;"; //added for SKR-SCF-1077 [IN:054499]
				} //added for SKR-CRF-0035 end
				ExistingIVRecords=new ArrayList();
				String answer = request.getParameter("answer")== null?"": request.getParameter("answer"); 
				ExistingIVRecords=(ArrayList)bean.getExistingIVRecords(order_id1,answer,act_pat_class);  //passed answer for IN24251 --16/12/2010-- priya
				ArrayList ord_disp_location = null; // Added For IN:062361
				for(i=0;i<ExistingIVRecords.size();i++){
					System.out.println("---->246 ExistingIVRecords><-----"+ExistingIVRecords);
					record=new HashMap();
					record=(HashMap)ExistingIVRecords.get(i);
					order_uom = (String)record.get("ORDER_UOM");
					mfr_yn = (String)record.get("MFR_YN");
					mfr_remarks = (String)record.get("MFR_REMARKS");
					order_catalog_code=(String)record.get("ORDER_CATALOG_CODE");
					catalog_desc=(String)record.get("CATALOG_DESC");
					start_date_time=(String)record.get("START_DATE_TIME");
					qty_value=(String)record.get("QTY_VALUE");
					infusion_rate=(String)record.get("INFUSION_RATE");
					infusion_over=(String)record.get("INFUSE_OVER");
					allow_alternate = (String)record.get("ALLOW_ALTERNATE_YN")==null?"N":(String)record.get("ALLOW_ALTERNATE_YN"); //GHL-CRF-0549
					 //ADDED FOR NMC-JD-CRF-0026 START
					System.out.println("---->246 DIAGNOSIS_FOUND_YN><-----"+(String)record.get("DIAGNOSIS_FOUND_YN"));
					
					 act_strength_value					= (String) record.get("STRENGTH_VALUE");
					  strength_uom_desc					= bean.getUomDisplay((String)session.getValue("facility_id"),(String) record.get("STRENGTH_UOM"));
					  strength_per_value_pres_uom_val		= (String) record.get("STRENGTH_PER_VALUE_PRES_UOM");
					  pres_base_uom_desc					= bean.getUomDisplay((String)session.getValue("facility_id"),(String) record.get("PRES_BASE_UOM"));
						if(req_diag_pres_found){
							diagnosis_found_yn= (String)record.get("DIAGNOSIS_FOUND_YN");//added for mms-dm-crf-0204	
						}
						else{
							diagnosis_found_yn="G";//added for mms-dm-crf-0204
						}
						System.out.println("---->246 DIAGNOSIS_FOUND_YN><-----"+diagnosis_found_yn);
					String strength_disply=act_strength_value+" "+strength_uom_desc+" / "+strength_per_value_pres_uom_val+" "+pres_base_uom_desc;
					//ADDED FOR NMC-JD-CRF-0026 END
					allow_alternate_disabled = "disabled";
					if(allow_alternate.equals("Y")){
					 allow_alternate_checked = "checked";
					}
					// Starting of IN:062361
					if(prev_order.equals("previous")){
						 
						 ord_disp_location  = (ArrayList) bean.getOrderDispenseLocation(locn_type,locn_code,take_home_medication,priority,"5","",patient_id,encounter_id);
						 perf_locn_code = (String)(ord_disp_location.get(0)) ==null?"":(String)ord_disp_location.get(0);
						 perf_locn_desc = (String)(ord_disp_location.get(2)) ==null?"":(String)ord_disp_location.get(2);;
					}else{
						perf_locn_code=(String)record.get("DISP_LOCN_CODE");  // Added for Bru-HIMS-CRF-347 [IN:037862] -- Begin
						perf_locn_desc=(String)record.get("DISP_LOCN_DESC");  // Added for Bru-HIMS-CRF-347 [IN:037862] -- Begin
						
					}//End of IN:062361
					per_facility_id=(String)record.get("PER_FACILITY_ID");  // Added for Bru-HIMS-CRF-347 [IN:037862] -- Begin
					if(infusion_over.indexOf(".") != -1){
						infuse_over_hr = infusion_over.substring(0,infusion_over.indexOf("."));
						Double temp = new Double(infusion_over);
						temp = temp*60;
						temp = (temp%60);
						infuse_over_mi = temp+""; // infuse_over_mi = xx.0
						infuse_over_mi = infuse_over_mi.substring(0,infuse_over_mi.indexOf(".")); // infuse_over_mi = xx
					}
					else{
						infuse_over_hr = infusion_over;
						infuse_over_mi = "";
					}
					infuse_over_hr = infuse_over_hr.equals("")?"0":infuse_over_hr;
					infuse_over_mi = infuse_over_mi.equals("")?"0":infuse_over_mi;
					durnn_value=(String)record.get("DURN_VALUE");
					qty_unit=(String)record.get("QTY_UNIT");
					end_date_time=(String)record.get("END_DATE_TIME");
					durnn_value = mfr_yn.equals("Y")?"":durnn_value;
					if(!mfr_yn.equals("Y") && ((String)record.get("INFUSION_PER_UNIT")).equals("M")){
						selected1 = "";
						selected2 = "selected";
					}
					else{
						selected2 = "";
						selected1 = "selected";
					}
					fluid_adr_count = bean.getADRCount(patient_id,order_catalog_code);
					if(fluid_adr_count>0){
						fluid_adr_dispaly ="visible";
					}
					else{
						fluid_adr_dispaly ="hidden";
					}

					if(record.get("BUILD_MAR_YN")==null || record.get("BUILD_MAR_YN").equals("")){
						record.put("BUILD_MAR_YN",MAR_app_yn);
					}
					buildMAR_yn = (String) record.get("BUILD_MAR_YN");
					bean.setBuildMAR_yn(buildMAR_yn); //   RUT-CRF-0062 [IN029600] 
					/*	if(MAR_app_yn.equals("Y")){		//Commented for SRR20056-CRF-0649.1 to (deselect)enable BuildMAR fo rIP
						if(patient_class.equals("IP"))
							buildMAR_enable ="disabled";
						SRR20056-CRF-0649.1	*/
						/*RUT-CRF-0062 [IN029600] Commented to set the Build MAR Value based on Build  MAR Rule -- begin
						if(buildMAR_yn!= null && buildMAR_yn.equals("Y"))
							buildMAR_checked ="Checked";
						else
							buildMAR_checked="";
					}*/
					
					if(i==0){// Disable property will be loaded based on Buil MAR Rule , Checked Property will be loaded based on Existing value for the first drug selected
						if(buildMAR_yn.equals("Y"))
							buildMAR_checked ="Checked";
						else
							buildMAR_checked="";
						buildMAR_rule = record.get("BUILD_MAR_RULE").toString();

						if(buildMAR_rule.equals("CE")){
							buildMAR_enable="";
						}
						else if(buildMAR_rule.equals("UE")){
							buildMAR_enable="";
						}
						else if(buildMAR_rule.equals("CD")){
							buildMAR_enable="disabled";
						}
						else if(buildMAR_rule.equals("UD")){
							buildMAR_enable="disabled";
						}
						
						if(ext_disp_appl_yn.equals("Y"))   //ADDED FOR NMC-JD-CRF-0046--AMEND ORDER
						{
							buildMAR_enable="disabled";
							buildMAR_checked="";
							buildMAR_yn = "N";
						}
						
						bean.setBuildMAR_yn(buildMAR_yn);
					}
					// RUT-CRF-0062 [IN029600] Commented to set the Build MAR Value based on Build  MAR Rule -- end
					row_count=(i+1)+"";
					String temp_end_date_time = "";	
					if(!mode1.equals("amend")){
						if(end_date_time!=null && !(end_date_time.equals(""))){//Code added for IN23819 -- 21/09/2010-- priya
							 temp_end_date_time = DateUtils.convertDate(end_date_time, "DMYHM",locale,"en");
						}
						start_date_time=(String)bean.comp_date_time(temp_end_date_time,order_id,row_count); //passed temp_end_date_time instead of end_date_time for IN23819 -- 21/09/2010-- priya
						if(start_date_time!=null && !(start_date_time.equals(""))){//Code added for IN23819 -- 21/09/2010-- priya
							start_date_time = DateUtils.convertDate(start_date_time, "DMYHM","en",locale);
						}
						end_date_time = bean.populateEndDate(start_date_time, durnn_value, durn_unit);
					}								
					ArrayList stockDetails = bean.getStockDetails(order_catalog_code, "1");
					if(stockDetails.size()>0) {
						stock_value	=(String)stockDetails.get(0);
						base_volume = stock_value;
						stock_uom	=(String)stockDetails.get(1);
					}
					if(prev_order.equals("previous")){
						actveVal = "visible";
					}
					qty_unit_disp = bean.getUomDisplay((String)session.getValue("facility_id"),qty_unit);
					order_qty = Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(stock_value))+"";
					order_qty = order_qty.substring(0,order_qty.indexOf(".")); 
					if(mfr_yn.equals("Y")){
						disable_for_mfr = "disabled";
						mfr_recs = bean.getMFRRecs();
						totRec = Integer.parseInt((String)mfr_recs.get("totRec")==null?"0":(String)mfr_recs.get("totRec"));
						qty_value = "0";
						for(int k=1; k<=totRec; k++){
							mfr_rec_detail = (ArrayList)mfr_recs.get("MFR"+k);
							qty_value = (Float.parseFloat(qty_value)+Float.parseFloat((String)mfr_rec_detail.get(0)==null?"0":(String)mfr_rec_detail.get(0)))+""; //volume
						
							if(k == 1)
								start_date_time = (String)mfr_rec_detail.get(6);
							end_date_time = (String)mfr_rec_detail.get(7);
						}
					}
 %>
					<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="1" style="border-color:#004080;">
						<tr>
							<td>
<%
							if(i==0){
%>
								<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
									<TR>
										<TD colspan="9" class="label" align="right" ><fmt:message key="ePH.BuildMAR.label" bundle="${ph_labels}"/>
<%
										if(MAR_app_yn.equals("Y")){ 
											if(!ext_disp_appl_yn.equals(""))  //nmc-jd-crf-0046
											{
%>
											<!--  RUT-CRF-0062 [IN029600]  buildMAR_enable added below to enable/disable based on Build MAR Rule -->
											<input type='checkbox' name='buildMAR_yn' id='buildMAR_yn' value='<%=buildMAR_yn%>' <%=buildMAR_checked%> <%=buildMAR_enable%>  onclick='assignValue(this);'>
<%
										}
										}
										
										else{
%>
											<input type='checkbox' name='buildMAR_yn' id='buildMAR_yn' value='N' disabled>
<%
										}
%>
										</TD>
									</TR>
								</table>
<%
							}
%>
							</td>
						</tr>
						<tr>
							<td>
								<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
									<TR>  
										<td class="fields" width="8%">
											<img  style="visibility:<%=fluid_adr_dispaly%>"id="ADR_img_<%=i+1%>" src='../../ePH/images/ADR.gif' height =20 width =20 title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>' ></img>&nbsp;
											<input type="checkbox" name="active<%=i+1%>" id="active<%=i+1%>" value="Y" checked style="visibility:<%=actveVal%>">&nbsp;
											<label style="color:red;font-weight:bold"><fmt:message key="ePH.Fluid.label" bundle="${ph_labels}"/>
										</td>
										<TD width="20%" class="fields">
											<INPUT TYPE="text" name="FLUID_NAME<%=i+1%>" id="FLUID_NAME<%=i+1%>" VALUE="<%= catalog_desc%>" <%=readonly%>  SIZE="40" MAXLENGTH="40" onChange="searchIVFluid1(formIVPrescriptionAdditives,'D', FLUID_NAME<%=i+1%>,1)"><!-- added for SKR-SCF-1391 -->
<%-- 											<input type="button" class="button" name="fluid_search1" id="fluid_search1" value="?" <%=disable%> onfocus="searchIVFluid1(formIVPrescriptionAdditives,'D', FLUID_NAME<%=i+1%>,1)" onclick="searchIVFluid1(formIVPrescriptionAdditives,'D', FLUID_NAME<%=i+1%>,1)" > --%><!-- COMMENTED for SKR-SCF-1317 -->
												<input type="button" class="button" name="fluid_search1" id="fluid_search1" value="?" <%=disable%> onclick="searchIVFluid1(formIVPrescriptionAdditives,'D', FLUID_NAME<%=i+1%>,1)" ><!-- REMOVED onfocus for SKR-SCF-1317 -->
										</TD>
										<td class="label" width='9%'>  <!-- newly added for  Bru-HIMS-CRF-347 [IN:037862]  -->
											<label style="visibility:visible" id="disp_locn1"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/> </label>
										</td>
										<td class="label"  width='11%' nowrap><!--now rap added for MMS Internal Testing -->
											<label style="visibility:visible" id="disp_locn_desc<%=i+1%>"><b><%=perf_locn_desc%></b></label>
											<input type='hidden' name="per_facility_id<%=i+1%>" id="per_facility_id<%=i+1%>" value='<%=per_facility_id%>' />
											<input type='hidden' name="disp_locn_code<%=i+1%>" id="disp_locn_code<%=i+1%>" value='<%=perf_locn_code%>' />
											<input type='hidden' name="disp_locn_type<%=i+1%>" id="disp_locn_type<%=i+1%>" value=' '/><!--Added for MMS Internal Testing -->
										</td>
										<td class="label" width="17%" id='tdDuration<%=i+1%>' style='<%=iv_durn_display%>'>
											<label  id="duration<%=i+1%>"><fmt:message key="Common.duration.label" bundle="${common_labels}"/></label>
											<INPUT TYPE="text" name="DURATION<%=i+1%>" id="DURATION<%=i+1%>" SIZE="1" MAXLENGTH="3" CLASS="number" value="<%= durnn_value  %>" onBlur="CheckNum(this);chkDurationAD(DURATION<%=i+1%>,<%=i+1%>);strtEndDateTime(<%=i+1%>); return validateDuration(this,INFUSION_PERIOD_VALUE<%=i+1%>,InfusionRateUnit<%=i+1%>,INFUSION_PERIOD_VALUE_MIN<%=i+1%>,'<%=iv_calc_infuse_by%>');" onKeyPress="return allowValidNumber(this,event,3,0);"  tabIndex="-1" <%=disable_for_mfr%>>
											<label id='durn_unit<%=i+1%>' class="label" ><b><fmt:message key="Common.hours.label" bundle="${common_labels}"/></b>	</label>
											<br><label id="ForRepeat_leg<%=i+1%>"><fmt:message key="ePH.ForRepeat.label" bundle="${ph_labels}"/></label><!-- added Bllow label ForRepeat for the INC NO:32739 By chandrashekar raju--></label>
										</td> 
										<td class="label" width='8%'>
											<label style="visibility:visible" id="start_time_leg1"><fmt:message key="Common.StartTime.label" bundle="${common_labels}"/></label>
										</td>
										<td class="label" width='10%' nowrap><!--now rap added for MMS Internal Testing -->
											<INPUT TYPE="text" name="START_DATE<%=i+1%>" id="START_DATE<%=i+1%>" VALUE="<%= start_date_time %>"   SIZE="14" MAXLENGTH="16" onBlur="chkDurationAD(DURATION<%=i+1%>,<%=i+1%>); strtEndDateTime(<%=i+1%>);" style="visibility:visible" <%=disable_for_mfr%>>
											<IMG SRC="../../eCommon/images/CommonCalendar.gif" id="Calendar<%=i+1%>" onclick="showCalendar('START_DATE<%=i+1%>',null,'hh:mm');document.formIVPrescriptionAdditives.START_DATE<%=i+1%>.focus();return false;" style="visibility:visible" <%=disable_for_mfr%>>
										</td> 
										<td class="label" width='7%' >
											<label style="visibility:visible" id="end_time_leg1"><fmt:message key="Common.EndTime.label" bundle="${common_labels}"/></label>
										</td>
										<td class="label" width='8%'><INPUT TYPE="text" name="END_DATE<%=i+1%>" id="END_DATE<%=i+1%>" VALUE="<%= end_date_time %>"  SIZE="14" MAXLENGTH="16" READONLY style="visibility:visible" <%=disable_for_mfr%>>		
										</TD>
										<INPUT TYPE="hidden" name="FLUID_CODE<%=i+1%>" id="FLUID_CODE<%=i+1%>" VALUE="<%=order_catalog_code %>">
										<input type="hidden" name="INF_RATE_UOM<%=i+1%>" id="INF_RATE_UOM<%=i+1%>" value="">
										<INPUT TYPE="hidden" name="stock_uom_code<%=i+1%>" id="stock_uom_code<%=i+1%>" VALUE="<%=stock_uom %>">
										<input type="hidden" name="stock_value<%=i+1%>" id="stock_value<%=i+1%>" value="<%=qty_value%>">
										<input type="hidden" name="base_volume<%=i+1%>" id="base_volume<%=i+1%>" value="<%=base_volume%>">
										<INPUT TYPE="hidden" name="INFUSION_PERIOD_UOM<%=i+1%>" id="INFUSION_PERIOD_UOM<%=i+1%>" VALUE='' >
										<INPUT TYPE="hidden" name="infusion_over_insert_value<%=i+1%>" id="infusion_over_insert_value<%=i+1%>" VALUE='<%=infusion_over%>' >
										<INPUT TYPE="hidden" name="mfr_yn<%=i+1%>" id="mfr_yn<%=i+1%>" VALUE='<%=mfr_yn%>' >
										<INPUT TYPE="hidden" name="volume_reference<%=i+1%>" id="volume_reference<%=i+1%>"  >
									</TR>
									<%//added for NMC-JD-CRF-0026 START
									if(strength_display_app){%>
									<tr>
									<td class="label" nowrap style="visibility:visible" id="TDstrenght<%=i+1%>"  >
										<label <%=strength_label_display%>><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></label>
									    <%if(act_strength_value != null && act_strength_value !="" && !act_strength_value.equals("0")){ %>
									    <label id="strength_label<%=i+1%>" class="label" style="font-size:12px;" <%=strength_label_display%>><%=strength_disply%></label></td>
										<%} %>
									</tr>
									<%}//added for NMC-JD-CRF-0026 END%>
									<tr>
										<td class="label" nowrap>
											<label style="visibility:visible" id="inf_rate_leg1"><fmt:message key="ePH.InfusionRate.label" bundle="${ph_labels}"/></label>
										</td>
										<td class="fields">
											<% if(param_volume_cal.equals("N")){  %>
											<INPUT TYPE="text" CLASS="number" name="INF_RATE<%=i+1%>" id="INF_RATE<%=i+1%>" SIZE="3" MAXLENGTH="7"  onBlur="CheckNum(this);calVolumeInfuseRate(this,volumePerUnit<%=i+1%>,INF_RATE<%=i+1%>,infusionOverStr<%=i+1%>,<%=i+1%>);chkDurationAD(DURATION<%=i+1%>,<%=i+1%>);strtEndDateTime(<%=i+1%>);" onKeyPress="return allowValidNumber(this,event,6,2);" style="visibility:visible" value="<%= infusion_rate  %>"  <%=disable_for_mfr%>>&nbsp;
											<%}else{   %>
											<INPUT TYPE="text" CLASS="number" name="INF_RATE<%=i+1%>" id="INF_RATE<%=i+1%>" SIZE="3" MAXLENGTH="7"  onBlur="CheckNum(this);validateRate(this,volume<%=i+1%>,INFUSION_PERIOD_VALUE<%=i+1%>,DURATION<%=i+1%>,infusionOverStr<%=i+1%>,'<%=i+1%>');chkDurationAD(DURATION<%=i+1%>,<%=i+1%>);strtEndDateTime(<%=i+1%>);" onKeyPress="return allowValidNumber(this,event,6,2);" style="visibility:visible" value="<%= infusion_rate  %>"  <%=disable_for_mfr%>>&nbsp;
											<%}
											%>
											<!-- <label id='uom_display1' class="label"><b><%=qty_unit %>/Hr</b></label> -->
											<label id='uom_display1' class="label" style="font-size:9px;"><b><%=qty_unit_disp %></b></label>
											<% if(param_volume_cal.equals("N")){  %>
											<select name="InfusionRateUnit<%=i+1%>" id="InfusionRateUnit<%=i+1%>" onChange="ChangeInfuseOverTime(this,'<%=i+1%>');calVolumeInfuseRate(this,volumePerUnit<%=i+1%>,INF_RATE<%=i+1%>,infusionOverStr<%=i+1%>,<%=i+1%>);" style="visibility:visible" <%=disable_for_mfr%>>
											<%}else{   %>
											<select name="InfusionRateUnit<%=i+1%>" id="InfusionRateUnit<%=i+1%>" onChange="ChangeInfuseOverTime(this,'<%=i+1%>');validateRate(INF_RATE<%=i+1%>,volume<%=i+1%>,INFUSION_PERIOD_VALUE<%=i+1%>,DURATION<%=i+1%>,infusionOverStr<%=i+1%>,'<%=i+1%>')" style="visibility:visible" <%=disable_for_mfr%>>
											<%}
											%>
											
											<option value="M" <%=selected2%> ><fmt:message key="Common.Minute(s).label" bundle="${common_labels}"/></option>
											<option value="H" <%=selected1%> ><fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></option>
											</select>
										</td>
										<td class="label" style='<%=iv_calc_infuse_display%>' id="tdOrderQty_leg<%=i+1%>"><fmt:message key="ePH.OrderQuantity.label" bundle="${ph_labels}"/> <!--added for SKR-CRF-0035 start-->
										</td>
										<td class="label" id="tdOrd_qty<%=i+1%>" style='<%=iv_calc_infuse_display%>'>
											<%if(param_volume_cal.equals("N")){ %>
											<input type='text' class="NUMBER" name='order_qty<%=i+1%>' id='order_qty<%=i+1%>' size="1" maxlength="3" value='<%=order_qty%>' disabled>&nbsp;
											<%}else { %>
											<input type='text' class="NUMBER" name='order_qty<%=i+1%>' id='order_qty<%=i+1%>' size="1" maxlength="3" value='<%=order_qty%>' onKeyPress="return allowValidNumber(this,event,2,0);" onchange="calcTotalVolume('<%=i+1%>')">&nbsp;
											<%} %>
											<label id="ord_qty_uom<%=i+1%>" class="label" style="font-size:9px;"><%=bean.getUomDisplay(facility_id,order_uom)%></label>
										</td>
										<td class="label" style='<%=iv_calc_infuse_display%>' id="tdVolumePerUnit<%=i+1%>">
											<label id="volumePerUnit_leg<%=i+1%>"><fmt:message key="Common.volume.label" bundle="${common_labels}"/>/<fmt:message key="Common.Unit.label" bundle="${common_labels}"/></label>&nbsp;
											<input type="text" name="volumePerUnit<%=i+1%>" id="volumePerUnit<%=i+1%>" size="3" class="NUMBER" readOnly value='<%=stock_value%>' >&nbsp;
											<label id="volPerUnitUom_leg<%=i+1%>" class="label" style="font-size:9px;"><b><%=qty_unit_disp %></label>
										</td>
										<td class="label" colspan='2'>
											<label style='<%=iv_calc_infuse_display%>' id="Totalvolume_leg<%=i+1%>"><fmt:message key="Common.total.label" bundle="${common_labels}"/></label>&nbsp;
					
											<label id="volume_leg<%=i+1%>"><fmt:message key="Common.volume.label" bundle="${common_labels}"/></label>&nbsp;
											<%if(param_volume_cal.equals("N")){ 

											
												if(mfr_yn.equals("Y")){ 
												%>
												<input type="text" disabled name="volume<%=i+1%>" id="volume<%=i+1%>" size="3" MAXLENGTH="5" class="NUMBER" style="visibility:visible" Value="<%=qty_value %>"  disabled  >
												<%	
											}
											else{
												%>
												<input type="text" name="volume<%=i+1%>" id="volume<%=i+1%>" size="3" MAXLENGTH="5" class="NUMBER" style="visibility:visible" Value="<%=qty_value %>"  disabled >
											<%			
											}

                                   			  }else { 											
												if(mfr_yn.equals("Y")){ 
											%>
												

											<input type="text" disabled name="volume<%=i+1%>" id="volume<%=i+1%>" size="3" MAXLENGTH="5" class="NUMBER" style="visibility:visible" Value="<%=qty_value %>"  onBlur="CheckNum(this); setStockValue(this,'<%=i+1%>'); validateRate(INF_RATE<%=i+1%>,volume<%=i+1%>,INFUSION_PERIOD_VALUE<%=i+1%>,DURATION<%=i+1%>,infusionOverStr<%=i+1%>,'<%=i+1%>');chkDurationAD(DURATION<%=i+1%>,<%=i+1%>);strtEndDateTime(<%=i+1%>);" onKeyPress="return allowValidNumber(this,event,3,0);" >
									<%		}
											else{
											%>
												<input type="text" name="volume<%=i+1%>" id="volume<%=i+1%>" size="3" MAXLENGTH="5" class="NUMBER" style="visibility:visible" Value="<%=qty_value %>"  onBlur="CheckNum(this); setStockValue(this,'<%=i+1%>'); validateRate(INF_RATE<%=i+1%>,volume<%=i+1%>,INFUSION_PERIOD_VALUE<%=i+1%>,DURATION<%=i+1%>,infusionOverStr<%=i+1%>,'<%=i+1%>');chkDurationAD(DURATION<%=i+1%>,<%=i+1%>);strtEndDateTime(<%=i+1%>);" onKeyPress="return allowValidNumber(this,event,3,0);" >
											<%			
											}

                                            } %>
											<label id="vol_uom<%=i+1%>" class="label" style="font-size:9px;"><b><%=qty_unit_disp %></label> <!--added for SKR-CRF-0035 End -->
										</td>
										<td class="label" colspan='2'>
											<label style="visibility:visible" id="infuse_over_leg1"><fmt:message key="ePH.InfuseOver.label" bundle="${ph_labels}"/></label>&nbsp;
											<% if(param_volume_cal.equals("N")){  %>
											<INPUT TYPE="text" name="INFUSION_PERIOD_VALUE<%=i+1%>" id="INFUSION_PERIOD_VALUE<%=i+1%>" VALUE= "<%=infuse_over_hr %>" SIZE="1" MAXLENGTH="7" CLASS="number" onBlur="CheckNum(this);checkHr(this,DURATION<%=i+1%>,'<%=i+1%>');calVolumeInfuseRate(this,volumePerUnit<%=i+1%>,INF_RATE<%=i+1%>,infusionOverStr<%=i+1%>,<%=i+1%>);chkDurationAD(DURATION<%=i+1%>,<%=i+1%>);strtEndDateTime(<%=i+1%>);" onKeyPress="return allowValidNumber(this,event,3,0);" style="visibility:visible" tabIndex="-1" <%=disable_for_mfr%>>
											<%}else{   %>
											<INPUT TYPE="text" name="INFUSION_PERIOD_VALUE<%=i+1%>" id="INFUSION_PERIOD_VALUE<%=i+1%>" VALUE= "<%=infuse_over_hr %>" SIZE="1" MAXLENGTH="7" CLASS="number" onBlur="CheckNum(this);checkHr(this,DURATION<%=i+1%>,'<%=i+1%>');calculateRate(this,volume<%=i+1%>,INF_RATE<%=i+1%>,infusionOverStr<%=i+1%>,'<%=i+1%>');chkDurationAD(DURATION<%=i+1%>,<%=i+1%>);strtEndDateTime(<%=i+1%>);" onKeyPress="return allowValidNumber(this,event,3,0);" style="visibility:visible" tabIndex="-1" <%=disable_for_mfr%>>
											<%}
											%>
											
											<label class="label" style="visibility:visible" id="colon<%=i+1%>"><b>:</b></label>
											<% if(param_volume_cal.equals("N")){  %>
											<INPUT TYPE="text" name="INFUSION_PERIOD_VALUE_MIN<%=i+1%>" id="INFUSION_PERIOD_VALUE_MIN<%=i+1%>" VALUE= "<%=infuse_over_mi %>" SIZE="1" MAXLENGTH="2" CLASS="number" onBlur="CheckNum(this);checkHr(this,DURATION<%=i+1%>,'<%=i+1%>');calVolumeInfuseRate(this,volumePerUnit<%=i+1%>,INF_RATE<%=i+1%>,infusionOverStr<%=i+1%>,<%=i+1%>);chkDurationAD(DURATION<%=i+1%>,<%=i+1%>);strtEndDateTime(<%=i+1%>);" onKeyPress="return allowValidNumber(this,event,3,0);" style="visibility:visible" tabIndex="-1" <%=disable_for_mfr%>>
											<%}else{   %>
											<INPUT TYPE="text" name="INFUSION_PERIOD_VALUE_MIN<%=i+1%>" id="INFUSION_PERIOD_VALUE_MIN<%=i+1%>" VALUE= "<%=infuse_over_mi %>" SIZE="1" MAXLENGTH="2" CLASS="number" onBlur="CheckNum(this);checkHr(this,DURATION<%=i+1%>,'<%=i+1%>');calculateRate(this,volume<%=i+1%>,INF_RATE<%=i+1%>,infusionOverStr<%=i+1%>,'<%=i+1%>');chkDurationAD(DURATION<%=i+1%>,<%=i+1%>);strtEndDateTime(<%=i+1%>);" onKeyPress="return allowValidNumber(this,event,3,0);" style="visibility:visible" tabIndex="-1" <%=disable_for_mfr%>>
											<%}
											%>
											
											<label class="label" style="visibility:visible" id="hr<%=i+1%>"><b><fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></b></label>
											<br><label align="left"  width='15%'class='label' id="infusionOverStr<%=i+1%>" style="visibility:visible"></label>
										</td>
											<%				
						
								if(item_type_site_app){ //GHL-CRF-549
			%>					<td CLASS="label" nowrap id="allow_alternate<%=i+1%>"><fmt:message 						key="ePH.AllowAlternate.label" bundle="${ph_labels}"/>&nbsp;
								<input type='checkbox' onclick ="setAllowAlternate(this)" name='allow_alternate_yn<%=i+1%>' id='allow_alternate_yn<%=i+1%>' value='N' <%=allow_alternate_disabled%> <%=allow_alternate_checked%>  > </td><!-- GHL-CRF-0549-->
			<%
								} 
								//GHL-CFR-0549 - end
			%>

									</tr>
<%
									if(mfr_yn.equals("Y")){
%>
										<tr>
											<td colspan='9' class="label" >
											<a HREF="#" onMouseOver="changeCursor(this);" onClick="showMultipleFlowRate('<%=patient_id %>','<%=encounter_id %>','<%=mode1%>','<%=i+1%>');" id='mfrLink<%=i+1%>'><fmt:message key="ePH.MultipleFlowRate.label" bundle="${ph_labels}"/></a><img src="../../eCommon/images/enabled.gif"  id='MFR_Indicator<%=i+1%>'> &nbsp;&nbsp;<a href="#"  onMouseOver="changeCursor(this);" onClick="showMFRRemarks('<%=i+1%>');" id='mfrRemarksLink<%=i+1%>'>&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.MFRRemarks.label" bundle="${ph_labels}"/></a><!-- Modified for TFS-13907 -->
											<input type="hidden" name="mfr_remarks<%=i+1%>" id="mfr_remarks<%=i+1%>"		value="<%=mfr_remarks%>">
											</td>
										</tr>
									<%			
									}
									else{
										%>			
										<tr>
											<td colspan='9' class="label" >
											<a href="#"  onMouseOver="changeCursor(this);" onClick="showMFRRemarks('<%=i+1%>');" id='mfrRemarksLink<%=i+1%>'>&nbsp;&nbsp;&nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a>
											<input type="hidden" name="mfr_remarks<%=i+1%>" id="mfr_remarks<%=i+1%>"		value="<%=mfr_remarks%>">
											</td>
										</tr>			
									<%
									}
								%>
								</table>
							</td>
						</tr>
					</table>	
					<%
					if(!mfr_yn.equals("Y")){
%>
						<script>
							eval(document.getElementById("infusionOverStr"+<%=i+1%>)).innerHTML  = "["+ '<%=infuse_over_hr%>'+" Hrs "+ '<%=infuse_over_mi%>' + " Mins]";
						</script>
<%
					}
%>
					<script>
						setInf_unit(<%=i+1%>);  
					</script>	
<%		
				}
			}
			else {
				if(iv_prep_default.equals("5") && !order_set_code.equals("")){
					orderSetCodes = bean.getOrdersetCodes(order_set_code);
				}
				if((orderSetCodes!= null) && (orderSetCodes.size() != 0 )){
					int te=0;
					String sQtyValue	= "";
					String sQtyUnit		= "";
					String sReqdROpt	= "";
					String sTimeFrame	= "0";
					String sChekBox		= "";
					ArrayList orderSetValues = bean.getOrderSetValues();
					start_date=bean.getSysdate();
					for(te=0;te<orderSetCodes.size();te++){
						order_set_code=(String)orderSetCodes.get(te);
						fluid_adr_count = bean.getADRCount(patient_id,order_set_code);
						if(fluid_adr_count>0){
							fluid_adr_dispaly ="visible";
						}
						else{
							fluid_adr_dispaly ="hidden";
						}
						String drug_desc=bean.getDrugDesc(order_set_code);
						if(drug_desc== null){drug_desc="";}
						order_type_code	= bean.getOrderType(order_set_code);
						bean.setFluidDetails(order_set_code,"","","",""); // CRF-0062 NEWLY ADDED
						ArrayList stockDetails = bean.getStockDetails(order_set_code, "1");
						String infuse	=	bean.getInfuseOverValue(order_set_code,"");
						String inf="";
						String stock_uom_code="";
						java.util.StringTokenizer sts =null;
						int inf_rate=0;
						if(infuse != null && !infuse.equals("")){
							sts = new java.util.StringTokenizer(infuse,"::");
						}
						while(sts.hasMoreTokens()){
							inf=	(String)sts.nextToken();
							sts.nextToken();
							sts.nextToken();
							sts.nextToken();
						}
						if(te==0){//  RUT-CRF-0062 [IN029600] To get Build MAR Rule flag  -- begin
							HashMap fluidDtls = (HashMap) bean.getFluidDetails();
							buildMAR_rule =fluidDtls.get("BUILD_MAR_RULE").toString();
							buildMAR_yn="N";
							if(buildMAR_rule==null)		
								buildMAR_rule="";
										
							if(buildMAR_rule.equals("CE")){
								buildMAR_checked ="checked";		
								buildMAR_enable="";
								buildMAR_yn="Y";
							}
							else if(buildMAR_rule.equals("UE")){
								buildMAR_checked ="";		
								buildMAR_enable="";
							}
							else if(buildMAR_rule.equals("CD")){
								buildMAR_checked ="checked";		
								buildMAR_enable="disabled";
								buildMAR_yn="Y";
							}
							else if(buildMAR_rule.equals("UD")){
								buildMAR_checked ="";		
								buildMAR_enable="disabled";
							}
							bean.setBuildMAR_yn(buildMAR_yn);
						}//  RUT-CRF-0062 [IN029600] To get Build MAR Rule flag  -- end

						if(inf.indexOf(".") != -1){
							infuse_over_hr = inf.substring(0,inf.indexOf("."));
							Double temp = new Double(inf);
							temp = temp*60;
							temp = (temp%60);
							infuse_over_mi = temp+""; // infuse_over_mi = xx.0
							infuse_over_mi = infuse_over_mi.substring(0,infuse_over_mi.indexOf(".")); // infuse_over_mi = xx
						}
						else{
							infuse_over_hr = inf;
							infuse_over_mi = "";
						}
						infuse_over_hr = infuse_over_hr.equals("")?"0":infuse_over_hr;
						infuse_over_mi = infuse_over_mi.equals("")?"0":infuse_over_mi;
						if (stockDetails!=null && stockDetails.size() != 0){
							stock_value=(String)stockDetails.get(0);
							base_volume = stock_value;
							stock_uom_code=(String)stockDetails.get(1);
							//start_date=bean.getSysdate();
							if(orderSetValues.size() > 0){
								for(int si=0; si<orderSetValues.size(); si=si+8){
									if(orderSetValues.get(si).equals(order_set_code)){
										sQtyValue	= (String)orderSetValues.get(si+1);
										sQtyUnit	= (String)orderSetValues.get(si+2);
										sReqdROpt	= (String)orderSetValues.get(si+6);
										sTimeFrame	= (String)orderSetValues.get(si+7);
									}
								}
							}
							if(sReqdROpt.equals("R")) sChekBox = "disabled"; else sChekBox = "";
							stock_value		= sQtyValue;
							stock_uom_code  = sQtyUnit;
							start_date		= bean.populateEndDate(start_date, sTimeFrame, "H");
							if(!inf.equals("") && !inf.equals("0")){
							  inf_rate=new Float(Math.ceil((Float.parseFloat(stock_value)/Float.parseFloat(inf)))).intValue();
							}
							end_date		= bean.populateEndDate(start_date, inf, "H");
%>						
							<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="1" style="border-color:#004080;">
								<tr>
									<td>
<%
									if(te == 0){
%>
										<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
											<TR>
												<TD colspan="9" class="label"align="right"><fmt:message key="ePH.BuildMAR.label" bundle="${ph_labels}"/>
<%
												if(MAR_app_yn.equals("Y")){ //RUT-CRF-0062 [IN029600]  buildMAR_enable added below to enable/disable based on Build MAR Rule
													if(!ext_disp_appl_yn.equals("")) { //nmc-jd-crf-0046
														
%>
													<input type='checkbox' name='buildMAR_yn' id='buildMAR_yn' value='<%=buildMAR_yn%>' <%=buildMAR_checked%> <%=buildMAR_enable%>  onclick='assignValue(this);'>
<%
												}}
												else{
%>
													<input type='checkbox' name='buildMAR_yn' id='buildMAR_yn' value='N' disabled>
<%
												}
%>
												</TD>
											</TR>
										</table>
<%
									}
%>
									</td>
								</tr>
							</TABLE>
							<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
								<TR>
									<td class="fields" width="8%">
										<img style="visibility:<%=fluid_adr_dispaly%>" id="ADR_img_<%=te+1%>" src='../../ePH/images/ADR.gif' height =20 width =20 title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>' ></img>&nbsp;
										<input type="checkbox" checked name="active<%=te+1%>" id="active<%=te+1%>" value="Y"  style="visibility:visible" <%=sChekBox%> >&nbsp;
										<label style="color:red;font-weight:bold"><fmt:message key="ePH.Fluid.label" bundle="${ph_labels}"/>
									</td>
									<TD width="20%" class="fields">
										<INPUT TYPE="text" name="FLUID_NAME<%=te+1%>" id="FLUID_NAME<%=te+1%>" VALUE="<%=new_generic_name%>" <%=readonly%>  SIZE="40" MAXLENGTH="40"  onChange="searchIVFluid1(formIVPrescriptionAdditives,'D', FLUID_NAME<%=te+1%>,1)"><!-- added for SKR-SCF-1391 --> <!-- Modified for MMS-DM-CRF-0177 -->
<%-- 										<input type="button" class="button" name="fluid_search<%=te+1%>" id="fluid_search<%=te+1%>" value="?" onfocus="searchIVFluid1(formIVPrescriptionAdditives,'D', FLUID_NAME<%=te+1%>,1)"  onclick="searchIVFluid1(formIVPrescriptionAdditives,'D', FLUID_NAME<%=te+1%>,1)" >  --%><!-- COMMENTED for SKR-SCF-1317 -->
											<input type="button" class="button" name="fluid_search<%=te+1%>" id="fluid_search<%=te+1%>" value="?"  onclick="searchIVFluid1(formIVPrescriptionAdditives,'D', FLUID_NAME<%=te+1%>,1)" ><!-- removed onfocus for SKR-SCF-1317 -->
										<img style="visibility:hidden"  name="flude_img<%=te+1%>" src="../../ePH/images/FD-ICON-rollOverInformationIcon.gif" height=20  width=20 onClick="openEDLDetails(FLUID_CODE<%=te+1%>.value);">
									</TD>
									<td class="label" width='9%'>  <!-- newly added for  Bru-HIMS-CRF-347 [IN:037862]  -->
										<label style="visibility:visible" id="disp_locn1"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/> </label>
									</td>
									<td class="label"  width='11%'>
										<label style="visibility:visible" id="disp_locn_desc<%=te+1%>"><b></b></label>
										<input type='hidden' name="per_facility_id<%=te+1%>" id="per_facility_id<%=te+1%>" value='' />
										<input type='hidden' name="disp_locn_code<%=te+1%>" id="disp_locn_code<%=te+1%>" value='' />
									</td>
									<td class="label" width="17%" id='tdDuration<%=te+1%>' style='visibility:hidden;'>
										<label id="duration<%=te+1%>"><fmt:message key="Common.duration.label" bundle="${common_labels}"/>&nbsp;&nbsp;
										<INPUT TYPE="text" name="DURATION<%=te+1%>" id="DURATION<%=te+1%>" SIZE="1" MAXLENGTH="3" CLASS="number" value="<%=inf.equals("0") ? "24":inf%>" onBlur="CheckNum(this);chkDurationAD(DURATION<%=te+1%>,<%=te+1%>);strtEndDateTime(<%=te+1%>);return validateDuration(this,INFUSION_PERIOD_VALUE<%=te+1%>,InfusionRateUnit<%=te+1%>,INFUSION_PERIOD_VALUE_MIN<%=te+1%>,'<%=iv_calc_infuse_by%>');" onKeyPress="return allowValidNumber(this,event,3,0);" tabIndex="-1">						
										<label id='durn_unit<%=te+1%>' class="label" >
										<b><fmt:message key="Common.hours.label" bundle="${common_labels}"/></b></label>
										<br><label id="ForRepeat_leg<%=te+1%>"><fmt:message key="ePH.ForRepeat.label" bundle="${ph_labels}"/></label><!-- added Bllow label ForRepeat for the INC NO:32739 By chandrashekar raju--></label>
										</label>
									</td>
									<td  class="label"  width="8%">
										<label style="visibility:visible" id="start_time_leg<%=te+1%>"><fmt:message key="Common.StartTime.label" bundle="${common_labels}"/></label>
									</td>
									<td  class="label"  width="10%">
										<INPUT TYPE="text" name="START_DATE<%=te+1%>" id="START_DATE<%=te+1%>" VALUE="<%= start_date%>"   SIZE="13" MAXLENGTH="16" onBlur="chkDurationAD(DURATION<%=te+1%>,<%=te+1%>); strtEndDateTime(<%=te+1%>);" style="visibility:visible">
										<IMG SRC="../../eCommon/images/CommonCalendar.gif" id="Calendar<%=te+1%>" onclick="showCalendar('START_DATE<%=te+1%>',null,'hh:mm');document.formIVPrescriptionAdditives.START_DATE<%=te+1%>.focus();return false;" style="visibility:visible">
									</td>
									<td class="label" width="7%">
										<label style="visibility:visible" id="end_time_leg<%=te+1%>"><fmt:message key="Common.EndTime.label" bundle="${common_labels}"/> </label>
									</td>
									<td class="label" width="8%">
										<INPUT TYPE="text" name="END_DATE<%=te+1%>" id="END_DATE<%=te+1%>" VALUE="<%= end_date%>"  SIZE="13" MAXLENGTH="16" READONLY style="visibility:visible">	
									</TD>
									<INPUT TYPE="hidden" name="FLUID_CODE<%=te+1%>" id="FLUID_CODE<%=te+1%>" VALUE="<%=order_set_code %>">
									<input type="hidden" name="INF_RATE_UOM<%=te+1%>" id="INF_RATE_UOM<%=te+1%>" value="<%=stock_uom_code %>">
									<INPUT TYPE="hidden" name="stock_uom_code<%=te+1%>" id="stock_uom_code<%=te+1%>" VALUE="<%=stock_uom_code %>">
									<input type="hidden" name="stock_value<%=te+1%>" id="stock_value<%=te+1%>" value="<%=stock_value %>">
									<input type="hidden" name="base_volume<%=te+1%>" id="base_volume<%=te+1%>" value="<%=base_volume%>">
									<input type="hidden" name="sTimeFrame<%=te+1%>" id="sTimeFrame<%=te+1%>" value="<%=sTimeFrame%>">
									<INPUT TYPE="hidden" name="INFUSION_PERIOD_UOM<%=te+1%>" id="INFUSION_PERIOD_UOM<%=te+1%>" VALUE='' >
									<INPUT TYPE="hidden" name="infusion_over_insert_value<%=te+1%>" id="infusion_over_insert_value<%=te+1%>" VALUE='<%=infusion_over%>' >
									<INPUT TYPE="hidden" name="mfr_yn<%=te+1%>" id="mfr_yn<%=te+1%>" VALUE='' >
									<INPUT TYPE="hidden" name="volume_reference<%=t+1%>" id="volume_reference<%=t+1%>"  >
								</TR>
								<tr>
									<td class="label" nowrap>
										<label style="visibility:visible" id="inf_rate_leg<%=te+1%>"><fmt:message key="ePH.InfusionRate.label" bundle="${ph_labels}"/></label>
									</td>
									<td class="fields">
										<!-- If else condtions added for aakh-crf-0094 start-->
										<% if(param_volume_cal.equals("N")){  %>
											<INPUT TYPE="text" CLASS="number" name="INF_RATE<%=te+1%>" id="INF_RATE<%=te+1%>" SIZE="3" MAXLENGTH="7"  value='<%=inf_rate%>'  onBlur="CheckNum(this);calVolumeInfuseRate(this,volumePerUnit<%=te+1%>,INF_RATE<%=te+1%>,infusionOverStr<%=te+1%>,<%=te+1%>);chkDurationAD(DURATION<%=te+1%>,<%=te+1%>); strtEndDateTime(<%=te+1%>);" onKeyPress="return allowValidNumber(this,event,6,2);" style="visibility:visible"  >&nbsp;
											<%}else{   %>
											<INPUT TYPE="text" CLASS="number" name="INF_RATE<%=te+1%>" id="INF_RATE<%=te+1%>" SIZE="3" MAXLENGTH="7"  value='<%=inf_rate%>'  onBlur="CheckNum(this);validateRate(this,volume<%=te+1%>,INFUSION_PERIOD_VALUE<%=te+1%>,DURATION<%=te+1%>,infusionOverStr<%=te+1%>,'<%=te+1%>');chkDurationAD(DURATION<%=te+1%>,<%=te+1%>); strtEndDateTime(<%=te+1%>);" onKeyPress="return allowValidNumber(this,event,6,2);" style="visibility:visible"  >&nbsp;
											<%}
											%>
										
										<label id='uom_display<%=te+1%>' class="label"><b><%=bean.getUomDisplay((String)session.getValue("facility_id"),stock_uom_code)%>/</b></label>
										<% if(param_volume_cal.equals("N")){  %>
											<select name="InfusionRateUnit<%=te+1%>" id="InfusionRateUnit<%=te+1%>" onChange="ChangeInfuseOverTime(this,<%=te+1%>);calVolumeInfuseRate(this,volumePerUnit<%=te+1%>,INF_RATE<%=te+1%>,infusionOverStr<%=te+1%>,<%=te+1%>);" style="visibility:visible">
											<%}else{   %>
											<select name="InfusionRateUnit<%=te+1%>" id="InfusionRateUnit<%=te+1%>" onChange="ChangeInfuseOverTime(this,<%=te+1%>);validateRate(INF_RATE<%=te+1%>,volume<%=te+1%>,INFUSION_PERIOD_VALUE<%=te+1%>,DURATION<%=te+1%>,infusionOverStr<%=te+1%>,'<%=te+1%>')" style="visibility:visible">
											<%}
											%>
										<!-- If else condtions added for aakh-crf-0094 end-->
										<option value="M" <%=selected2%> ><fmt:message key="Common.Minute(s).label" bundle="${common_labels}"/></option>
										<option value="H" <%=selected1%> ><fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></option>
										</select>						
									</td>
									<td class="label" style="display:none;" id="tdOrderQty_leg<%=te+1%>"><fmt:message key="ePH.OrderQuantity.label" bundle="${ph_labels}"/> <!--added for SKR-CRF-0035 start-->
									</td>
									<td class="label" id="tdOrd_qty<%=te+1%>" style="display:none;">
										<input type='text' class="NUMBER" name='order_qty<%=te+1%>' id='order_qty<%=te+1%>' size="1" maxlength="3" onKeyPress="return allowValidNumber(this,event,2,0);"  onchange="calcTotalVolume('<%=te+1%>')">&nbsp;
										<label id="ord_qty_uom<%=te+1%>" class="label" style="font-size:9px;"></label>
									</td>
									<td class="label"  style="display:none;" id="tdVolumePerUnit<%=te+1%>">
										<label id="volumePerUnit_leg<%=te+1%>"><fmt:message key="Common.volume.label" bundle="${common_labels}"/>/<fmt:message key="Common.Unit.label" bundle="${common_labels}"/></label>&nbsp;
										<input type="text" name="volumePerUnit<%=te+1%>" id="volumePerUnit<%=te+1%>" size="3" class="NUMBER" readOnly>&nbsp;
										<label id="volPerUnitUom_leg<%=te+1%>" class="label" style="font-size:9px;"></label>
										
									</td>
									<td class="label" colspan='2'>
										<label style="display:none" id="Totalvolume_leg<%=te+1%>"><fmt:message key="Common.total.label" bundle="${common_labels}"/></label>&nbsp;
										<label style="visibility:hidden" id="volume_leg<%=te+1%>"><fmt:message key="Common.volume.label" bundle="${common_labels}"/></label>&nbsp;
										<input type="text" name="volume<%=te+1%>" id="volume<%=te+1%>" size="3" MAXLENGTH="5" class="NUMBER" style="visibility:visible" Value="<%=stock_value%>" onblur="setStockValue(this,'<%=te+1%>'); validateRate(INF_RATE<%=te+1%>,volume<%=te+1%>,INFUSION_PERIOD_VALUE<%=te+1%>,DURATION<%=te+1%>,infusionOverStr<%=te+1%>,'<%=te+1%>'); chkDurationAD(DURATION<%=te+1%>,<%=te+1%>); CalculateDateTime(END_DATE<%=te+1%>,START_DATE<%=te+2%>); strtEndDateTime(<%=te+1%>);" onKeyPress="return allowValidNumber(this,event,3,0);" >
										<label id="vol_uom<%=te+1%>"  class="label" style="visibility:hidden;font-size:9px;"><b>&nbsp<%=bean.getUomDisplay((String)session.getValue("facility_id"),stock_uom_code)%></b></label><!--added for SKR-CRF-0035 End-->
									</td>
									<td class="label" colspan='2'>
										<label style="visibility:visible" id="infuse_over_leg<%=te+1%>"><fmt:message key="ePH.InfuseOver.label" bundle="${ph_labels}"/></label> &nbsp;
									<!-- If else condtions added for aakh-crf-0094 start -->
										<% if(param_volume_cal.equals("N")){  %>
											<INPUT TYPE="text" name="INFUSION_PERIOD_VALUE<%=te+1%>" id="INFUSION_PERIOD_VALUE<%=te+1%>" VALUE= "<%=infuse_over_hr%>" SIZE="1" MAXLENGTH="7" CLASS="number" onBlur="CheckNum(this);checkHr(this,DURATION<%=te+1%>,'<%=te+1%>');calVolumeInfuseRate(this,volumePerUnit<%=te+1%>,INF_RATE<%=te+1%>,infusionOverStr<%=te+1%>,<%=te+1%>); strtEndDateTime(<%=te+1%>);" onKeyPress="return allowValidNumber(this,event,3,0);" style="visibility:visible" tabIndex="-1"><label class="label" style="visibility:visible" id="colon<%=i+1%>"><b>:</b></label>
											<%}else{   %>
											<INPUT TYPE="text" name="INFUSION_PERIOD_VALUE<%=te+1%>" id="INFUSION_PERIOD_VALUE<%=te+1%>" VALUE= "<%=infuse_over_hr%>" SIZE="1" MAXLENGTH="7" CLASS="number" onBlur="CheckNum(this);checkHr(this,DURATION<%=te+1%>,'<%=te+1%>');calculateRate(this,volume<%=te+1%>,INF_RATE<%=te+1%>,infusionOverStr<%=te+1%>,'<%=te+1%>');chkDurationAD(DURATION<%=te+1%>,<%=te+1%>); strtEndDateTime(<%=te+1%>);" onKeyPress="return allowValidNumber(this,event,3,0);" style="visibility:visible" tabIndex="-1"><label class="label" style="visibility:visible" id="colon<%=i+1%>"><b>:</b></label>
											<%}
											%>
										
										<% if(param_volume_cal.equals("N")){  %>
											<INPUT TYPE="text" name="INFUSION_PERIOD_VALUE_MIN<%=te+1%>" id="INFUSION_PERIOD_VALUE_MIN<%=te+1%>" VALUE= "<%=infuse_over_mi%>" SIZE="1" MAXLENGTH="2" CLASS="number" onBlur="CheckNum(this);checkHr(this,DURATION<%=te+1%>,'<%=te+1%>');calVolumeInfuseRate(this,volumePerUnit<%=te+1%>,INF_RATE<%=te+1%>,infusionOverStr<%=te+1%>,<%=te+1%>);chkDurationAD(DURATION<%=te+1%>,<%=te+1%>); strtEndDateTime(<%=te+1%>);" onKeyPress="return allowValidNumber(this,event,3,0);" style="visibility:visible" tabIndex="-1">
											<%}else{   %>
											<INPUT TYPE="text" name="INFUSION_PERIOD_VALUE_MIN<%=te+1%>" id="INFUSION_PERIOD_VALUE_MIN<%=te+1%>" VALUE= "<%=infuse_over_mi%>" SIZE="1" MAXLENGTH="2" CLASS="number" onBlur="CheckNum(this);checkHr(this,DURATION<%=te+1%>,'<%=te+1%>');calculateRate(this,volume<%=te+1%>,INF_RATE<%=te+1%>,infusionOverStr<%=te+1%>,'<%=te+1%>');chkDurationAD(DURATION<%=te+1%>,<%=te+1%>); strtEndDateTime(<%=te+1%>);" onKeyPress="return allowValidNumber(this,event,3,0);" style="visibility:visible" tabIndex="-1">
											<%}
											%>
													<!-- If else condtions added for aakh-crf-0094 end -->			
										<label class="label" style="visibility:visible" id="hr<%=te+1%>"><b><fmt:message key="Common.hours.label" bundle="${common_labels}"/></b>
										<br><label align="left"  width='15%'class='label' id="infusionOverStr<%=te+1%>" style="visibility:visible"></label>
									</td>
								</tr>
								<tr>
									<td colspan='9' class="label" >
										<a HREF="#" onMouseOver="changeCursor(this);" onClick="showMultipleFlowRate('<%=patient_id %>','<%=encounter_id %>','<%=mode%>','<%=te+1%>');" id='mfrLink<%=te+1%>' style="visibility:visible"><fmt:message key="ePH.MultipleFlowRate.label" bundle="${ph_labels}"/></a><img src="../../eCommon/images/disabled.gif"  id='MFR_Indicator<%=te+1%>' style="visibility:<%=mfr_display%>"> &nbsp;&nbsp;<a href="#"  onMouseOver="changeCursor(this);" onClick="showMFRRemarks('<%=te+1%>');" id='mfrRemarksLink<%=te+1%>' style="visibility:visible" >&nbsp;&nbsp;&nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a>
										<input type="hidden" name="mfr_remarks<%=te+1%>" id="mfr_remarks<%=te+1%>" value="<%=mfr_remarks%>">
									</td>
								</tr>
							</table>
							<script language="javascript">
								eval("document.formIVPrescriptionAdditives.volume"+<%=te+1%>).focus();
							</script>
						</td>
					</tr>
				</table>
<%	
			}
			//if(te !=0 ){
			start_date = end_date;
			//	}
		}
		String visblty = "hidden";
		if(te < 6){
			for(t=te;t<6;t++){ 
				if (t==te) 
					visblty = "visible"; 
				else 
					visblty = "hidden";			  
%>
				<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="1" style="border-color:#004080">
					<tr>
						<td>
							<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
								<TR>
									<TD colspan="9"></TD>
								</TR>
								<TR>
									<td class="fields" width="8%"><img  id="ADR_img_<%=t+1%>" src='../../ePH/images/ADR.gif' height =20 width =20 title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>' style="visibility:hidden" ></img>&nbsp;<input type="checkbox" name="active<%=t+1%>" id="active<%=t+1%>" value="Y" style="visibility:<%=visblty%>">&nbsp;<label style="color:red;font-weight:bold;visibility:<%=visblty%>" id="fluid_leg<%=t+1%>"><fmt:message key="ePH.Fluid.label" bundle="${ph_labels}"/></td>

									<TD class="fields" width="20%" ><INPUT TYPE="text" name="FLUID_NAME<%=t+1%>" id="FLUID_NAME<%=t+1%>" VALUE="" SIZE="40" MAXLENGTH="40"  onblur="checkValidDrug('f', this.value)"  onChange="searchIVFluid1(formIVPrescriptionAdditives,'D', FLUID_NAME<%=t+1%>,<%=t+1%>)" style="visibility:<%=visblty%>"><!-- added for SKR-SCF-1391 -->
<%-- 									<input type="button" class="button" name="fluid_search<%=t+1%>" id="fluid_search<%=t+1%>" value="?" onfocus="searchIVFluid1(formIVPrescriptionAdditives,'D', FLUID_NAME<%=t+1%>,<%=t+1%>)" onclick="searchIVFluid1(formIVPrescriptionAdditives,'D', FLUID_NAME<%=t+1%>,<%=t+1%>)" style="visibility:<%=visblty%>"> --%><!-- COMMENTED FOR SKR-SCF-1317 -->
									<input type="button" class="button" name="fluid_search<%=t+1%>" id="fluid_search<%=t+1%>" value="?"  onclick="searchIVFluid1(formIVPrescriptionAdditives,'D', FLUID_NAME<%=t+1%>,<%=t+1%>)" style="visibility:<%=visblty%>"><!-- REMOVED onfocus for SKR-SCF-1317 -->
									<img style="visibility:hidden"  name="flude_img<%=t+1%>" src="../../ePH/images/FD-ICON-rollOverInformationIcon.gif" height=20  width=20 onClick="openEDLDetails(FLUID_CODE<%=t+1%>.value);"></TD>
									<td class="label" width='9%'>  <!-- newly added for  Bru-HIMS-CRF-347 [IN:037862]  -->
										<label style="visibility:visible" id="disp_locn1"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/> </label>
									</td>
									<td class="label"  width='11%'>
										<label style="visibility:visible" id="disp_locn_desc<%=t+1%>"><b></b></label>
										<input type='hidden' name="per_facility_id<%=t+1%>" id="per_facility_id<%=t+1%>" value='' />
										<input type='hidden' name="disp_locn_code<%=t+1%>" id="disp_locn_code<%=t+1%>" value='' />
									</td>
									<td class="label" width="17%" id='tdDuration<%=t+1%>' style='visibility:hidden;'>
										<label id="duration<%=t+1%>"><fmt:message key="Common.duration.label" bundle="${common_labels}"/></label>&nbsp;&nbsp;
										<INPUT TYPE="text" name="DURATION<%=t+1%>" id="DURATION<%=t+1%>" VALUE="24" SIZE="1" MAXLENGTH="3" CLASS="number"  onBlur="chkDurationAD(DURATION<%=t+1%>,<%=t+1%>);strtEndDateTime(<%=t+1%>);return validateDuration(this,INFUSION_PERIOD_VALUE<%=t+1%>,InfusionRateUnit<%=t+1%>,INFUSION_PERIOD_VALUE_MIN<%=t+1%>,'<%=iv_calc_infuse_by%>');" onKeyPress="return allowValidNumber(this,event,3,0);" tabIndex="-1">
										<label id='durn_unit<%=t+1%>' class="label"><b><fmt:message key="Common.hours.label" bundle="${common_labels}"/></b></label>
										<br><label id="ForRepeat_leg<%=t+1%>"><fmt:message key="ePH.ForRepeat.label" bundle="${ph_labels}"/></label><!-- added Bllow label ForRepeat for the INC NO:32739 By chandrashekar raju-->
									</td>
									<td  class="label" width='8%'>
										<label style="visibility:hidden" id="start_time_leg<%=t+1%>"><fmt:message key="Common.StartTime.label" bundle="${common_labels}"/></label>
									</td>
									<td  class="label" width='10%'>
										<INPUT TYPE="text" name="START_DATE<%=t+1%>" id="START_DATE<%=t+1%>" VALUE="<%= start_date %>" SIZE="13" MAXLENGTH="16" onBlur="chkDurationAD(DURATION<%=t+1%>,<%=t+1%>);" style="visibility:hidden"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id="Calendar<%=t+1%>" onclick="showCalendar('START_DATE<%=t+1%>',null,'hh:mm');document.formIVPrescriptionAdditives.START_DATE<%=t+1%>.focus();return false;" style="visibility:hidden"></td>
									<td class="label" width='7%'>
										<label style="visibility:hidden" id="end_time_leg<%=t+1%>"><fmt:message key="Common.EndTime.label" bundle="${common_labels}"/> </label>
									</td>
									<td  class="label" width='8%'>
										<INPUT TYPE="text" name="END_DATE<%=t+1%>" id="END_DATE<%=t+1%>" VALUE="<%= end_date %>" SIZE="13" MAXLENGTH="16" READONLY style="visibility:hidden">		
									</TD>
									<INPUT TYPE="hidden" name="FLUID_CODE<%=t+1%>" id="FLUID_CODE<%=t+1%>" VALUE="">
									<input type="hidden" name="INF_RATE_UOM<%=t+1%>" id="INF_RATE_UOM<%=t+1%>" value="">
									<INPUT TYPE="hidden" name="stock_uom_code<%=t+1%>" id="stock_uom_code<%=t+1%>" VALUE="">
									<input type="hidden" name="stock_value<%=t+1%>" id="stock_value<%=t+1%>" value="">
									<input type="hidden" name="base_volume<%=t+1%>" id="base_volume<%=t+1%>" value="">
									<INPUT TYPE="hidden" name="INFUSION_PERIOD_UOM<%=t+1%>" id="INFUSION_PERIOD_UOM<%=t+1%>" VALUE='' >
									<INPUT TYPE="hidden" name="infusion_over_insert_value<%=t+1%>" id="infusion_over_insert_value<%=t+1%>" VALUE='<%=infusion_over%>' >
									<INPUT TYPE="hidden" name="mfr_yn<%=t+1%>" id="mfr_yn<%=t+1%>" VALUE='' >
									<INPUT TYPE="hidden" name="volume_reference<%=t+1%>" id="volume_reference<%=t+1%>"  >
									
								</TR>
								<tr>
									<td class="label" nowrap >
										<label style="visibility:hidden" id="inf_rate_leg<%=t+1%>"><fmt:message key="ePH.InfusionRate.label" bundle="${ph_labels}"/></label></td>
									<td class="fields">
										<!-- If else condtions added for aakh-crf-0094 start -->
										<% if(param_volume_cal.equals("N")){  %>
											<INPUT TYPE="text" CLASS="number" name="INF_RATE<%=t+1%>" id="INF_RATE<%=t+1%>" VALUE="" SIZE="3" MAXLENGTH="7"  onBlur="CheckNum(this);calVolumeInfuseRate(this,volumePerUnit<%=t+1%>,INF_RATE<%=t+1%>,infusionOverStr<%=t+1%>,<%=t+1%>); strtEndDateTime(<%=t+1%>);" onKeyPress="return allowValidNumber(this,event,6,2);" style="visibility:hidden">&nbsp;
											<%}else{   %>
											<INPUT TYPE="text" CLASS="number" name="INF_RATE<%=t+1%>" id="INF_RATE<%=t+1%>" VALUE="" SIZE="3" MAXLENGTH="7"  onBlur="CheckNum(this);validateRate(this,volume<%=t+1%>,INFUSION_PERIOD_VALUE<%=t+1%>,DURATION<%=t+1%>,infusionOverStr<%=t+1%>,'<%=t+1%>'); strtEndDateTime(<%=t+1%>);" onKeyPress="return allowValidNumber(this,event,6,2);" style="visibility:hidden">&nbsp;
											<%}
											%>
										
										<label id='uom_display<%=t+1%>' class="label"></label>
										<% if(param_volume_cal.equals("N")){  %>
											<select name="InfusionRateUnit<%=t+1%>" id="InfusionRateUnit<%=t+1%>" onChange="ChangeInfuseOverTime(this,<%=t+1%>);calVolumeInfuseRate(this,volumePerUnit<%=t+1%>,INF_RATE<%=t+1%>,infusionOverStr<%=t+1%>,<%=t+1%>);" style="visibility:hidden">
											<%}else{   %>
											<select name="InfusionRateUnit<%=t+1%>" id="InfusionRateUnit<%=t+1%>" onChange="ChangeInfuseOverTime(this,<%=t+1%>);validateRate(INF_RATE<%=t+1%>,volume<%=t+1%>,INFUSION_PERIOD_VALUE<%=t+1%>,DURATION<%=t+1%>,infusionOverStr<%=t+1%>,'<%=t+1%>')" style="visibility:hidden">
											<%}
											%>
										<!-- If else condtions added for aakh-crf-0094  end-->
										<option value="M" <%=selected2%> ><fmt:message key="Common.Minute(s).label" bundle="${common_labels}"/></option>
										<option value="H" <%=selected1%> ><fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></option>
										</select>
									</td>
									<td class="label" style="display:none;" id="tdOrderQty_leg<%=t+1%>"><fmt:message key="ePH.OrderQuantity.label" bundle="${ph_labels}"/> <!--added for SKR-CRF-0035 start-->
									</td>
									<td class="label" class="NUMBER" id="tdOrd_qty<%=t+1%>" style="display:none;">
										<input type='text' name='order_qty<%=t+1%>' id='order_qty<%=t+1%>' size="1" maxlength="3" style="display:none;" onKeyPress="return allowValidNumber(this,event,2,0);" onchange="calcTotalVolume('<%=t+1%>')">&nbsp;
										<label id="ord_qty_uom<%=t+1%>" class="label" style="font-size:9px;"></label>
									</td>
									<td class="label" style="display:none;" id='tdVolumePerUnit<%=t+1%>'>
										<label style="display:none;" id="volumePerUnit_leg<%=t+1%>"><fmt:message key="Common.volume.label" bundle="${common_labels}"/>/<fmt:message key="Common.Unit.label" bundle="${common_labels}"/></label>&nbsp;
										<input type="text" name="volumePerUnit<%=t+1%>" id="volumePerUnit<%=t+1%>" size="3" class="NUMBER" style="display:none;" readOnly>&nbsp;
										<label id="volPerUnitUom_leg<%=t+1%>" class="label" style="display:none;font-size:9px;"></label>
									</td>
									<td class="label" colspan='2'>
										<label style="display:none" id="Totalvolume_leg<%=t+1%>"><fmt:message key="Common.total.label" bundle="${common_labels}"/></label>&nbsp;
										<label style="visibility:hidden" id="volume_leg<%=t+1%>"><fmt:message key="Common.volume.label" bundle="${common_labels}"/></label>&nbsp;
										<input type="text" name="volume<%=t+1%>" id="volume<%=t+1%>" size="3" MAXLENGTH="5" class="NUMBER" style="visibility:hidden" onblur="setStockValue(this,'<%=t+1%>'); validateRate(INF_RATE<%=t+1%>,volume<%=t+1%>,INFUSION_PERIOD_VALUE<%=t+1%>,DURATION<%=t+1%>,infusionOverStr<%=t+1%>,'<%=t+1%>'); chkDurationAD(DURATION<%=t+1%>,<%=t+1%>); CalculateDateTime(END_DATE<%=t+1%>,START_DATE<%=t+2%>); strtEndDateTime(<%=t+1%>);" onKeyPress="return allowValidNumber(this,event,6,2);">&nbsp;
										<label id="vol_uom<%=t+1%>"  class="label" style="visibility:hidden;font-size:9px;"></label><!--added for SKR-CRF-0035 End-->
									</td>
									<td class="label" colspan='2'>
										<label style="visibility:hidden" id="infuse_over_leg<%=t+1%>"><fmt:message key="ePH.InfuseOver.label" bundle="${ph_labels}"/></label>&nbsp;
										<!-- If else condtions added for aakh-crf-0094  start-->
										<% if(param_volume_cal.equals("N")){  %>
											<INPUT TYPE="text" name="INFUSION_PERIOD_VALUE<%=t+1%>" id="INFUSION_PERIOD_VALUE<%=t+1%>" VALUE="" SIZE="1" MAXLENGTH="7" CLASS="number" onBlur="CheckNum(this);checkHr(this,DURATION<%=t+1%>,'<%=t+1%>');calVolumeInfuseRate(this,volumePerUnit<%=t+1%>,INF_RATE<%=t+1%>,infusionOverStr<%=t+1%>,<%=t+1%>);chkDurationAD(DURATION<%=t+1%>,<%=t+1%>);  strtEndDateTime(<%=t+1%>);" onKeyPress="return allowValidNumber(this,event,3,0);" style="visibility:hidden" tabIndex="-1"><label class="label" style="visibility:hidden" id="colon<%=t+1%>"><b>:</b></label>
											<%}else{   %>
											<INPUT TYPE="text" name="INFUSION_PERIOD_VALUE<%=t+1%>" id="INFUSION_PERIOD_VALUE<%=t+1%>" VALUE="" SIZE="1" MAXLENGTH="7" CLASS="number" onBlur="CheckNum(this);checkHr(this,DURATION<%=t+1%>,'<%=t+1%>');calculateRate(this,volume<%=t+1%>,INF_RATE<%=t+1%>,infusionOverStr<%=t+1%>,'<%=t+1%>');chkDurationAD(DURATION<%=t+1%>,<%=t+1%>);  strtEndDateTime(<%=t+1%>);" onKeyPress="return allowValidNumber(this,event,3,0);" style="visibility:hidden" tabIndex="-1"><label class="label" style="visibility:hidden" id="colon<%=t+1%>"><b>:</b></label>
											<%}
											%>
										
										<% if(param_volume_cal.equals("N")){  %>
											<INPUT TYPE="text" name="INFUSION_PERIOD_VALUE_MIN<%=t+1%>" id="INFUSION_PERIOD_VALUE_MIN<%=t+1%>" VALUE="" SIZE="1" MAXLENGTH="2" CLASS="number" onBlur="CheckNum(this);checkHr(this,DURATION<%=t+1%>,'<%=t+1%>');calVolumeInfuseRate(this,volumePerUnit<%=t+1%>,INF_RATE<%=t+1%>,infusionOverStr<%=t+1%>,<%=t+1%>);chkDurationAD(DURATION<%=t+1%>,<%=t+1%>);  strtEndDateTime(<%=t+1%>);" onKeyPress="return allowValidNumber(this,event,3,0);" style="visibility:hidden" tabIndex="-1">
											<%}else{   %>
											<INPUT TYPE="text" name="INFUSION_PERIOD_VALUE_MIN<%=t+1%>" id="INFUSION_PERIOD_VALUE_MIN<%=t+1%>" VALUE="" SIZE="1" MAXLENGTH="2" CLASS="number" onBlur="CheckNum(this);checkHr(this,DURATION<%=t+1%>,'<%=t+1%>');calculateRate(this,volume<%=t+1%>,INF_RATE<%=t+1%>,infusionOverStr<%=t+1%>,'<%=t+1%>');chkDurationAD(DURATION<%=t+1%>,<%=t+1%>);  strtEndDateTime(<%=t+1%>);" onKeyPress="return allowValidNumber(this,event,3,0);" style="visibility:hidden" tabIndex="-1">
											<%}
											%>
										<!-- If else condtions added for aakh-crf-0094 end-->
										<label class="label" style="visibility:hidden" id="hr<%=t+1%>"><b><fmt:message key="Common.hours.label" bundle="${common_labels}"/></b>
										<br><label align="left"  width='15%'class='label' id="infusionOverStr<%=t+1%>" style="visibility:hidden"></label>
									</td>
								</tr>
								<tr>
									<td colspan='9' class="label" >
										<a HREF="#" onMouseOver="changeCursor(this);" onClick="showMultipleFlowRate('<%=patient_id %>','<%=encounter_id %>','<%=mode%>','<%=t+1%>');" id='mfrLink<%=t+1%>' style="visibility:<%=mfr_display%>"><fmt:message key="ePH.MultipleFlowRate.label" bundle="${ph_labels}"/></a><img src="../../eCommon/images/disabled.gif"  id='MFR_Indicator<%=t+1%>' style="visibility:<%=mfr_display%>"> &nbsp;&nbsp;<a href="#"  onMouseOver="changeCursor(this);" onClick="showMFRRemarks('<%=t+1%>');" id='mfrRemarksLink<%=t+1%>' style="visibility:<%=mfr_display%>" >&nbsp;&nbsp;&nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a><!-- Modified for TFS-13907 -->
										<input type="hidden" name="mfr_remarks<%=t+1%>" id="mfr_remarks<%=t+1%>"		value="<%=mfr_remarks%>">
									</td>
								</tr>
							</table>
<%
						}
					}
				}
				else{ 
 %>
					<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="1" style="border-color:#004080;">
						<tr>
							<td>
								<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
									<TR>
										<TD colspan="9" align='right' class="label" > <fmt:message key="ePH.BuildMAR.label" bundle="${ph_labels}"/>&nbsp;
<%
										if(MAR_app_yn.equals("Y")){
											if(!ext_disp_appl_yn.equals("")) { //nmc-jd-crf-0046 //RUT-CRF-0062 [IN029600]  buildMAR_enable added below to enable/disable based on Build MAR Rule
												  
%>
											<input type='checkbox' name='buildMAR_yn' id='buildMAR_yn' value='<%=buildMAR_yn%>' <%=buildMAR_checked%> <%=buildMAR_enable%> onclick='assignValue(this);'>
<%
										}}
										else{
%>
											<input type='checkbox' name='buildMAR_yn' id='buildMAR_yn' value='N' disabled>
<%
										}
%>
										</TD>
									</TR>
								</table>
							</td>
						</tr>
					</table>
<%
					//Below code added and removed multiple fields and loaded using for loop 
					String fluidVisible="";
					String fluidID="";
					for(int row=1;row<=6;row++){
						if(row!=1){
							fluidVisible=" visibility:hidden;";
							fluidID="id=\"fluid_leg"+row+"\"";
						}
						else{
							fluidVisible="";
							fluidID="";
						}
%>
						<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="1" style="border-color:#004080">
							<tr>
								<td>
									<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
										<TR>
											<td  class="fields" width="8%">
												<img style="visibility:hidden" id="ADR_img_<%=row%>" src='../../ePH/images/ADR.gif' height =20 width =20 title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>' ></img>&nbsp;
												<input type="checkbox" name="active<%=row%>" id="active<%=row%>" value="Y" checked style="visibility:hidden"> &nbsp;
												<label <%=fluidID%>  style="color:red;font-weight:bold;<%=fluidVisible%>"> <fmt:message key="ePH.Fluid.label" bundle="${ph_labels}" />
											</td>

											<TD class="fields" width="20%" ><INPUT TYPE="text" name="FLUID_NAME<%=row%>" id="FLUID_NAME<%=row%>" VALUE="" SIZE="35" MAXLENGTH="40"  onblur="checkValidDrug('f', this.value)"  onChange="searchIVFluid1(formIVPrescriptionAdditives,'D', FLUID_NAME<%=row%>,<%=row%>)" style=<%=fluidVisible%>><!-- added for SKR-SCF-1391 -->
<%-- 												<input type="button" class="button" name="fluid_search<%=row%>" id="fluid_search<%=row%>" value="?" onfocus="searchIVFluid1(formIVPrescriptionAdditives,'D', FLUID_NAME<%=row%>,<%=row%>)" onclick="searchIVFluid1(formIVPrescriptionAdditives,'D', FLUID_NAME<%=row%>,<%=row%>)" style=<%=fluidVisible%>> --%><!-- COMMENTED FOR SKR-SCF-1317 -->
													<input type="button" class="button" name="fluid_search<%=row%>" id="fluid_search<%=row%>" value="?"  onclick="searchIVFluid1(formIVPrescriptionAdditives,'D', FLUID_NAME<%=row%>,<%=row%>)" style=<%=fluidVisible%>><!-- REMOVED onFocus for SKR-SCF-1317 -->
												<img style="visibility:hidden"  name="flude_img<%=row%>" src="../../ePH/images/FD-ICON-rollOverInformationIcon.gif" height=20  width=20 onClick="openEDLDetails(FLUID_CODE<%=row%>.value);"></img>
											</TD>	
											<td class="label" width='9%'> <!-- Added for Bru-HIMS-CRF-347 [IN:037862] -->
											<label style="visibility:hidden" id="disp_locn<%=row%>"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/>
											</td>
											<td class="label" width='11%'>&nbsp;
											<label id="disp_locn_desc<%=row%>" class="label"></label>
											<input type="hidden" name="disp_locn_code<%=row%>" id="disp_locn_code<%=row%>" value="">	
											<input type="hidden" name="disp_locn_type<%=row%>" id="disp_locn_type<%=row%>" value="">	
											<input type="hidden" name="per_facility_id<%=row%>" id="per_facility_id<%=row%>" value="">	
											</td>
											<td class="label" width="17%" id='tdDuration<%=row%>' style='visibility:hidden;' >
												<label id="duration<%=row%>"><fmt:message key="Common.duration.label" bundle="${common_labels}"/></label>
												&nbsp;&nbsp;
												<INPUT TYPE="text" name="DURATION<%=row%>" id="DURATION<%=row%>" VALUE="24" SIZE="1" MAXLENGTH="3" CLASS="number"  onBlur="CheckNum(this);chkDurationAD(DURATION<%=row%>,<%=row%>); strtEndDateTime(<%=row%>); return validateDuration(this,INFUSION_PERIOD_VALUE<%=row%>,InfusionRateUnit<%=row%>,INFUSION_PERIOD_VALUE_MIN<%=row%>,'<%=iv_calc_infuse_by%>');" onKeyPress="return allowValidNumber(this,event,3,0); " tabIndex="-1">
												<label id='durn_unit<%=row%>' class="label" ><b><fmt:message key="Common.hours.label" bundle="${common_labels}"/></b></label>
												<br><label id="ForRepeat_leg<%=row%>"><fmt:message key="ePH.ForRepeat.label" bundle="${ph_labels}"/></label><!-- added Bllow label ForRepeat for the INC NO:32739 By chandrashekar raju-->
											</td>
											<td  class="label" width='7%'>
											<label style="visibility:hidden" id="start_time_leg<%=row%>"><fmt:message key="Common.StartTime.label" bundle="${common_labels}"/></label>
											</td>
											<td  class="label" width='10%'>
											<INPUT TYPE="text" name="START_DATE<%=row%>" id="START_DATE<%=row%>" VALUE="<%= start_date %>" SIZE="13" MAXLENGTH="16" onBlur="chkDurationAD(DURATION<%=row%>,<%=row%>);" style="visibility:hidden">
											<IMG SRC="../../eCommon/images/CommonCalendar.gif" id="Calendar<%=row%>" onclick="showCalendar('START_DATE<%=row%>',null,'hh:mm');document.formIVPrescriptionAdditives.START_DATE<%=row%>.focus();return false;" style="visibility:hidden">
											</td>
											<td class="label"  width='8%' >
											<label style="visibility:hidden" id="end_time_leg<%=row%>"><fmt:message key="Common.EndTime.label" bundle="${common_labels}"/> </label>
											</td>
											<td  class="label" width='8%'>
											<INPUT TYPE="text" name="END_DATE<%=row%>" id="END_DATE<%=row%>" VALUE="<%= end_date %>" SIZE="13" MAXLENGTH="16" READONLY style="visibility:hidden">		
											</TD>
											<INPUT TYPE="hidden" name="FLUID_CODE<%=row%>" id="FLUID_CODE<%=row%>" VALUE="">
											<input type="hidden" name="INF_RATE_UOM<%=row%>" id="INF_RATE_UOM<%=row%>" value="">
											<INPUT TYPE="hidden" name="stock_uom_code<%=row%>" id="stock_uom_code<%=row%>" VALUE="">
											<input type="hidden" name="stock_value<%=row%>" id="stock_value<%=row%>" value="">
											<input type="hidden" name="base_volume<%=row%>" id="base_volume<%=row%>" value="">
											<INPUT TYPE="hidden" name="INFUSION_PERIOD_UOM<%=row%>" id="INFUSION_PERIOD_UOM<%=row%>" VALUE='' >
											<INPUT TYPE="hidden" name="infusion_over_insert_value<%=row%>" id="infusion_over_insert_value<%=row%>" VALUE='<%=infusion_over%>' >
											<INPUT TYPE="hidden" name="mfr_yn<%=row%>" id="mfr_yn<%=row%>" VALUE='' >
											<INPUT TYPE="hidden" name="volume_reference<%=row%>" id="volume_reference<%=row%>"  >
										</TR>
									<%//added for NMC-JD-CRF-0026 START
									if(strength_display_app){%>
									<tr>
									<td class="label" nowrap style="display:none" id="TDstrenght<%=row%>"  >
											<label style="<%=strength_label_display%>"><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></label>
									        <label  id="strength_label<%=row%>" class="label" style="font-size:12px;<%=strength_label_display%>"  ></label></td>
				
									</tr>
									<%} //added for NMC-JD-CRF-0026END
									 %>
										<tr>
											<td class="label" nowrap >
												<label style="visibility:hidden" id="inf_rate_leg<%=row%>"><fmt:message key="ePH.InfusionRate.label" bundle="${ph_labels}"/></label>
											</td>
											<td class="fields">
											<!-- If else condtions added for aakh-crf-0094 start -->
												<% if(param_volume_cal.equals("N")){
												%><INPUT TYPE="text" CLASS="number" name="INF_RATE<%=row%>" id="INF_RATE<%=row%>" VALUE="" SIZE="3" MAXLENGTH="7" 	onBlur="CheckNum(this);calVolumeInfuseRate(this,volumePerUnit<%=row%>,INF_RATE<%=row%>,infusionOverStr<%=row%>,<%=row%>);chkDurationAD(DURATION<%=row%>,<%=row%>); strtEndDateTime(<%=row%>);" onKeyPress="return allowValidNumber(this,event,6,2);" style="visibility:hidden">&nbsp;
											<% }else{ %>
												<INPUT TYPE="text" CLASS="number" name="INF_RATE<%=row%>" id="INF_RATE<%=row%>" VALUE="" SIZE="3" MAXLENGTH="7" 	onBlur="CheckNum(this);validateRate(this,volume<%=row%>,INFUSION_PERIOD_VALUE<%=row%>,DURATION<%=row%>,infusionOverStr<%=row%>,<%=row%>);chkDurationAD(DURATION<%=row%>,<%=row%>); strtEndDateTime(<%=row%>);" onKeyPress="return allowValidNumber(this,event,6,2);" style="visibility:hidden">&nbsp;
											<% }%>
										
										
												
												<label id='uom_display<%=row%>' class="label" style="font-size:9px;"></label>
												<% if(param_volume_cal.equals("N")){
												%><select name="InfusionRateUnit<%=row%>" id="InfusionRateUnit<%=row%>" onChange="calVolumeInfuseRate(this,volumePerUnit<%=row%>,INF_RATE<%=row%>,infusionOverStr<%=row%>,<%=row%>);" style="visibility:hidden">
											<% }else{ %>
												<select name="InfusionRateUnit<%=row%>" id="InfusionRateUnit<%=row%>" onChange="ChangeInfuseOverTime(this,'<%=row%>');validateRate(INF_RATE<%=row%>,volume<%=row%>,INFUSION_PERIOD_VALUE<%=row%>,DURATION<%=row%>,infusionOverStr<%=row%>,<%=row%>);chkDurationAD(DURATION<%=row%>,<%=row%>)" style="visibility:hidden">
											<% }%>
										
										<!-- If else condtions added for aakh-crf-0094 end-->
												
												<option value="M" <%=selected2%> ><fmt:message key="Common.Minute(s).label" bundle="${common_labels}"/></option>
												<option value="H" <%=selected1%> ><fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></option>
												</select>
											</td>
											<td class="label" style="display:none;" id="tdOrderQty_leg<%=row%>"><fmt:message key="ePH.OrderQuantity.label" bundle="${ph_labels}"/><!--added for SKR-CRF-0035 start-->
											</td>
											<td class="label" id="tdOrd_qty<%=row%>" style="display:none;">
											<!-- If else condtions added for aakh-crf-0094  start-->
											<% if(param_volume_cal.equals("N")){
												%><input type='text' disabled class="NUMBER" name='order_qty<%=row%>' id='order_qty<%=row%>' size="1" maxlength="3" >&nbsp;
											<% }else{ %>
												<input type='text' disabled class="NUMBER" name='order_qty<%=row%>' id='order_qty<%=row%>' size="1" maxlength="3" onKeyPress="return allowValidNumber(this,event,2,0);" onchange="calcTotalVolume('<%=row%>')" >&nbsp;
											<% }%>
										<!-- If else condtions added for aakh-crf-0094 end -->
												
												<label id="ord_qty_uom<%=row%>" class="label" style="font-size:9px;"></label>
											</td>
											<td class="label" style="display:none;" id="tdVolumePerUnit<%=row%>">
												<label id="volumePerUnit_leg<%=row%>"><fmt:message key="Common.volume.label" bundle="${common_labels}"/>/<fmt:message key="Common.Unit.label" bundle="${common_labels}"/></label>&nbsp;
												<input type="text" disabled name="volumePerUnit<%=row%>" id="volumePerUnit<%=row%>" size="3" class="NUMBER"  readOnly>&nbsp;
												<label id="volPerUnitUom_leg<%=row%>" class="label" style="font-size:9px;"></label>
												
											</td>
											<td class="label" colspan='2'>
												<label style="display:none;" id="Totalvolume_leg<%=row%>"><fmt:message key="Common.total.label" bundle="${common_labels}"/></label>&nbsp;
												<label style="visibility:hidden" id="volume_leg<%=row%>"><fmt:message key="Common.volume.label" bundle="${common_labels}"/></label>&nbsp;
												<!-- If else condtions added for aakh-crf-0094 start -->
												<% if(param_volume_cal.equals("N")){
												%><input type="text"  disabled name="volume<%=row%>" id="volume<%=row%>" size="3" MAXLENGTH="5" class="NUMBER" style="visibility:hidden">&nbsp;
											<% }else{ %>
												<input type="text" name="volume<%=row%>" id="volume<%=row%>" size="3" MAXLENGTH="5" class="NUMBER" style="visibility:hidden" onblur="setStockValue(this,<%=row%>);validateRate(INF_RATE<%=row%>,volume<%=row%>,INFUSION_PERIOD_VALUE<%=row%>,DURATION<%=row%>,infusionOverStr<%=row%>,<%=row%>); chkDurationAD(DURATION<%=row%>,<%=row%>); CalculateDateTime(END_DATE<%=row%>,START_DATE<%=row+1%>); strtEndDateTime(<%=row%>);" onKeyPress="return allowValidNumber(this,event,3,0);" >&nbsp;
											<% }%>
										
												<!-- If else condtions added for aakh-crf-0094  end -->
												<label id="vol_uom<%=row%>"  class="label" style="visibility:hidden;font-size:9px;"></label><!--added for SKR-CRF-0035 End-->
											</td>
											<TD class="label" colspan='2'>
												<label style="visibility:hidden" id="infuse_over_leg<%=row%>"><fmt:message key="ePH.InfuseOver.label" bundle="${ph_labels}"/></label>
												<!-- If else condtions added for aakh-crf-0094 start-->
												<% if(param_volume_cal.equals("N")){
												%><INPUT TYPE="text" name="INFUSION_PERIOD_VALUE<%=row%>" id="INFUSION_PERIOD_VALUE<%=row%>" VALUE="" SIZE="1" MAXLENGTH="3" CLASS="number"	onBlur="CheckNum(this);calVolumeInfuseRate(this,volumePerUnit<%=row%>,INF_RATE<%=row%>,infusionOverStr<%=row%>,<%=row%>);chkDurationAD(DURATION<%=row%>,<%=row%>); strtEndDateTime(<%=row%>);" onKeyPress="return allowValidNumber(this,event,3,0);" style="visibility:hidden" tabIndex="-1"><label class="label" style="visibility:hidden" id="colon<%=row%>"><b>:</b></label>
											<% }else{ %>
												<INPUT TYPE="text" name="INFUSION_PERIOD_VALUE<%=row%>" id="INFUSION_PERIOD_VALUE<%=row%>" VALUE="" SIZE="1" MAXLENGTH="3" CLASS="number"	onBlur="CheckNum(this);checkHr(this,DURATION<%=row%>,<%=row%>);calculateRate(this,volume<%=row%>,INF_RATE<%=row%>,infusionOverStr<%=row%>,<%=row%>);chkDurationAD(DURATION<%=row%>,<%=row%>); strtEndDateTime(<%=row%>);" onKeyPress="return allowValidNumber(this,event,3,0);" style="visibility:hidden" tabIndex="-1"><label class="label" style="visibility:hidden" id="colon<%=row%>"><b>:</b></label>
											<% }%>
										
										
										<% if(param_volume_cal.equals("N")){
												%><INPUT TYPE="text" name="INFUSION_PERIOD_VALUE_MIN<%=row%>" id="INFUSION_PERIOD_VALUE_MIN<%=row%>" VALUE="" SIZE="1" MAXLENGTH="2" CLASS="number"	onBlur="CheckNum(this);calVolumeInfuseRate(this,volumePerUnit<%=row%>,INF_RATE<%=row%>,infusionOverStr<%=row%>,<%=row%>);chkDurationAD(DURATION<%=row%>,<%=row%>); strtEndDateTime(<%=row%>);" onKeyPress="return allowValidNumber(this,event,3,0);" style="visibility:hidden" tabIndex="-1">
											<% }else{ %>
												<INPUT TYPE="text" name="INFUSION_PERIOD_VALUE_MIN<%=row%>" id="INFUSION_PERIOD_VALUE_MIN<%=row%>" VALUE="" SIZE="1" MAXLENGTH="2" CLASS="number"	onBlur="CheckNum(this);checkHr(this,DURATION<%=row%>,<%=row%>);calculateRate(this,volume<%=row%>,INF_RATE<%=row%>,infusionOverStr<%=row%>,<%=row%>);chkDurationAD(DURATION<%=row%>,<%=row%>); strtEndDateTime(<%=row%>);" onKeyPress="return allowValidNumber(this,event,3,0);" style="visibility:hidden" tabIndex="-1">
											<% }%>
										<!-- If else condtions added for aakh-crf-0094 end -->
												<label  class="label" style="visibility:hidden;font-size:9px;" id="hr<%=row%>"><b><fmt:message key="Common.hours.label" bundle="${common_labels}"/></b></label>
												<br><label style='text-align:right;'  width='15%'class='label' id="infusionOverStr<%=row%>" style="visibility:hidden"></label>
											</td>
	<%				

								if(item_type_site_app){ //GHL-CRF-549
			%>					<td CLASS="label" nowrap id="allow_alternate<%=row%>" style="visibility:hidden;"><fmt:message key="ePH.AllowAlternate.label" bundle="${ph_labels}"/>&nbsp;
								<input type='checkbox' name='allow_alternate_yn<%=row%>' id='allow_alternate_yn<%=row%>' onclick ="setAllowAlternate(this);"value='N' <%=allow_alternate_disabled%> <%=allow_alternate_checked%>  > </td><!-- GHL-CRF-0549-->
			<%
								 
								} //GHL-CFR-0549 - end
			%>

										</tr>
										<tr>
											<td  class="label" colspan='9'>
												<a HREF="#" onMouseOver="changeCursor(this);" onClick="showMultipleFlowRate('<%=patient_id %>','<%=encounter_id %>','<%=mode%>','<%=row%>');" id='mfrLink<%=row%>' style="visibility:<%=mfr_display%>"><fmt:message key="ePH.MultipleFlowRate.label" bundle="${ph_labels}"/></a><img src="../../eCommon/images/disabled.gif"  id='MFR_Indicator<%=row%>' style="visibility:<%=mfr_display%>"> &nbsp;&nbsp;<a href="#"  onMouseOver="changeCursor(this);" onClick="showMFRRemarks('<%=row%>');" id='mfrRemarksLink<%=row%>' style="visibility:<%=mfr_display%>">&nbsp;&nbsp;&nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a>
												<input type="hidden" name="mfr_remarks<%=row%>" id="mfr_remarks<%=row%>"	value="<%=mfr_remarks%>">
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
<%
					}
				} 
			} 
			if((order_type_flag.equals("Existing")||mode1.equals("amend"))&& i<6){
				String prev_Vsb = "hidden";
				for( t=i;t<6;t++){ 
					if(!mode1.equals("amend")){
						if(t==i){
							prev_Vsb = "visible";}
						else{
							prev_Vsb = "hidden";
						}			  
					}
  %>
					<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="1" style="border-color:#004080">
						<tr>
							<td>
								<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
									<TR>
											<TD colspan="9"></TD>
									</TR>
									<TR>
										<td class="fields" width="8%"><img style="visibility:hidden" id="ADR_img_<%=t+1%>" src='../../ePH/images/ADR.gif' height =20 width =20 title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>' ></img>&nbsp;<input type="checkbox" name="active<%=t+1%>" id="active<%=t+1%>" value="Y" checked style="visibility:hidden">&nbsp;<label style="color:red;font-weight:bold;visibility:<%=prev_Vsb%>" id="fluid_leg<%=t+1%>" ><fmt:message key="ePH.Fluid.label" bundle="${ph_labels}"/></td>
										<TD width="20%" class="fields">
<%-- 											<INPUT TYPE="text" name="FLUID_NAME<%=t+1%>" id="FLUID_NAME<%=t+1%>" VALUE="" SIZE="40" MAXLENGTH="40"  onblur="checkValidDrug('f', this.value)" style="visibility:<%=prev_Vsb%>"><input type="button" class="button" name="fluid_search<%=t+1%>" id="fluid_search<%=t+1%>" value="?" onfocus="searchIVFluid1(formIVPrescriptionAdditives,'D', FLUID_NAME<%=t+1%>,<%=t+1%>)" onclick="searchIVFluid1(formIVPrescriptionAdditives,'D', FLUID_NAME<%=t+1%>,<%=t+1%>)" style="visibility:<%=prev_Vsb%>"> --%><!-- COMMENTED for SKR-SCF-1317 -->
											<INPUT TYPE="text" name="FLUID_NAME<%=t+1%>" id="FLUID_NAME<%=t+1%>" VALUE="" SIZE="40" MAXLENGTH="40"  onblur="checkValidDrug('f', this.value)"  onChange="searchIVFluid1(formIVPrescriptionAdditives,'D', FLUID_NAME<%=t+1%>,<%=t+1%>)" style="visibility:<%=prev_Vsb%>"><input type="button" class="button" name="fluid_search<%=t+1%>" id="fluid_search<%=t+1%>" value="?"  onclick="searchIVFluid1(formIVPrescriptionAdditives,'D', FLUID_NAME<%=t+1%>,<%=t+1%>)" style="visibility:<%=prev_Vsb%>"><!-- REMOVED ONFocus for SKR-SCF-1317 --><!-- added for SKR-SCF-1391 -->
										</TD>
										<td class="label" width='9%'> <!-- Added for Bru-HIMS-CRF-347 [IN:037862] -->
											<label style="visibility:hidden" id="disp_locn<%=t+1%>"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/>
										</td>
										<td class="label" width='11%'>&nbsp;&nbsp;
											<label id="disp_locn_desc<%=t+1%>" class="label"></label>
											<input type="hidden" name="disp_locn_code<%=t+1%>" id="disp_locn_code<%=t+1%>" value="">	
											<input type="hidden" name="disp_locn_type<%=t+1%>" id="disp_locn_type<%=t+1%>" value="">	
											<input type="hidden" name="per_facility_id<%=t+1%>" id="per_facility_id<%=t+1%>" value="">	
										</td>
										<td class="label"  width="17%" id='tdDuration<%=t+1%>' style='visibility:hidden;'>
											<label id="duration<%=t+1%>"><fmt:message key="Common.duration.label" bundle="${common_labels}"/></label>&nbsp;<INPUT TYPE="text" name="DURATION<%=t+1%>" id="DURATION<%=t+1%>" SIZE="1" MAXLENGTH="3" CLASS="number"  value="" onBlur="chkDurationAD(DURATION<%=t+1%>,<%=t+1%>);strtEndDateTime(<%=t+1%>);return validateDuration(this,INFUSION_PERIOD_VALUE<%=t+1%>,InfusionRateUnit<%=t+1%>,INFUSION_PERIOD_VALUE_MIN<%=t+1%>,'<%=iv_calc_infuse_by%>');" onKeyPress="return allowValidNumber(this,event,3,0);" tabIndex="-1"><label id='durn_unit<%=t+1%>' class="label" ><b><fmt:message key="Common.hours.label" bundle="${common_labels}"/></b></label>
											<br><label id="ForRepeat_leg<%=t+1%>"><fmt:message key="ePH.ForRepeat.label" bundle="${ph_labels}"/></label><!-- added Bllow label ForRepeat for the INC NO:32739 By chandrashekar raju-->
										</td>
										<td ><label style="visibility:hidden" id="start_time_leg<%=t+1%>"><fmt:message key="Common.StartTime.label" bundle="${common_labels}"/></label>
										</td>
										<td class="label" width='10%'><INPUT TYPE="text" name="START_DATE<%=t+1%>" id="START_DATE<%=t+1%>" VALUE="" SIZE="13" MAXLENGTH="16" onBlur="chkDurationAD(DURATION<%=t+1%>,<%=t+1%>);strtEndDateTime(<%=t+1%>);" style="visibility:hidden"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id="Calendar<%=t+1%>" onclick="showCalendar('START_DATE<%=t+1%>',null,'hh:mm');document.formIVPrescriptionAdditives.START_DATE<%=t+1%>.focus();return false;" style="visibility:hidden">
										</td>
										<td class="label" width='7%'><label style="visibility:hidden" id="end_time_leg<%=t+1%>"><fmt:message key="Common.EndTime.label" bundle="${common_labels}"/> </label></td>
										<td class="label" width='8%'><INPUT TYPE="text" name="END_DATE<%=t+1%>" id="END_DATE<%=t+1%>" VALUE="" SIZE="13" MAXLENGTH="16" READONLY style="visibility:hidden">		
										</TD>
										<INPUT TYPE="hidden" name="FLUID_CODE<%=t+1%>" id="FLUID_CODE<%=t+1%>" VALUE="">
										<input type="hidden" name="INF_RATE_UOM<%=t+1%>" id="INF_RATE_UOM<%=t+1%>" value="">
										<INPUT TYPE="hidden" name="stock_uom_code<%=t+1%>" id="stock_uom_code<%=t+1%>" VALUE="">
										<input type="hidden" name="stock_value<%=t+1%>" id="stock_value<%=t+1%>" value="">
										<input type="hidden" name="base_volume<%=t+1%>" id="base_volume<%=t+1%>" value="">
										<INPUT TYPE="hidden" name="INFUSION_PERIOD_UOM<%=t+1%>" id="INFUSION_PERIOD_UOM<%=t+1%>" VALUE='' >
										<INPUT TYPE="hidden" name="infusion_over_insert_value<%=t+1%>" id="infusion_over_insert_value<%=t+1%>" VALUE='<%=infusion_over%>' >
										<INPUT TYPE="hidden" name="mfr_yn<%=t+1%>" id="mfr_yn<%=t+1%>" VALUE='' >
											<INPUT TYPE="hidden" name="volume_reference<%=t+1%>" id="volume_reference<%=t+1%>"  >
									</TR>
										<%//added for NMC-JD-CRF-0026 START
									if(strength_display_app){%>
									<tr>
									<td class="label" nowrap style="display:none" id="TDstrenght<%=t+1%>"  >
										<label <%=strength_label_display%>><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></label>
									    <label id="strength_label<%=t+1%>" class="label" style="font-size:12px;" <%=strength_label_display%>></label></td>
				
									</tr>
									<%}//ADDED FOR NMC-JD-CRF-0026 END
									%>
									<tr>
										<td class="label" ><label style="visibility:hidden" id="infuse_over_leg<%=t+1%>"><fmt:message key="ePH.InfuseOver.label" bundle="${ph_labels}"/></label></td>
										<td class="data" width="26%">
											<label align="left"  width='15%' class='label' id="infusionOverStr<%=t+1%>" style="visibility:hidden"></label>
										</td>
										<TD class="fields">
										<!-- If else condtions added for aakh-crf-0094 start-->
											<% if(param_volume_cal.equals("N")){  %>
											<INPUT TYPE="text" name="INFUSION_PERIOD_VALUE<%=t+1%>" id="INFUSION_PERIOD_VALUE<%=t+1%>" VALUE= "" SIZE="1" MAXLENGTH="7" CLASS="number" onBlur="CheckNum(this);checkHr(this,DURATION<%=t+1%>,'<%=t+1%>');calVolumeInfuseRate(this,volumePerUnit<%=t+1%>,INF_RATE<%=t+1%>,infusionOverStr<%=t+1%>,<%=t+1%>);chkDurationAD(DURATION<%=t+1%>,<%=t+1%>);  strtEndDateTime(<%=t+1%>);" onKeyPress="return allowValidNumber(this,event,3,0);" style="visibility:hidden" tabIndex="-1">
											<%}else{   %>
											<INPUT TYPE="text" name="INFUSION_PERIOD_VALUE<%=t+1%>" id="INFUSION_PERIOD_VALUE<%=t+1%>" VALUE= "" SIZE="1" MAXLENGTH="7" CLASS="number" onBlur="CheckNum(this);checkHr(this,DURATION<%=t+1%>,'<%=t+1%>');calculateRate(this,volume<%=t+1%>,INF_RATE<%=t+1%>,infusionOverStr<%=t+1%>,'<%=t+1%>');chkDurationAD(DURATION<%=t+1%>,<%=t+1%>);  strtEndDateTime(<%=t+1%>);" onKeyPress="return allowValidNumber(this,event,3,0);" style="visibility:hidden" tabIndex="-1">
											<%}
											%>
											
											<label class="label" style="visibility:hidden" id="colon<%=t+1%>"><B>:</B></label>
										<% if(param_volume_cal.equals("N")){  %>
											<INPUT TYPE="text" name="INFUSION_PERIOD_VALUE_MIN<%=t+1%>" id="INFUSION_PERIOD_VALUE_MIN<%=t+1%>" VALUE= "" SIZE="1" MAXLENGTH="2" CLASS="number" onBlur="CheckNum(this);checkHr(this,DURATION<%=t+1%>,'<%=t+1%>');calVolumeInfuseRate(this,volumePerUnit<%=t+1%>,INF_RATE<%=t+1%>,infusionOverStr<%=t+1%>,<%=t+1%>);chkDurationAD(DURATION<%=t+1%>,<%=t+1%>);  strtEndDateTime(<%=t+1%>);" onKeyPress="return allowValidNumber(this,event,3,0);" style="visibility:hidden" tabIndex="-1"><label class="label" style="visibility:hidden" id="hr<%=t+1%>"><b><fmt:message key="Common.hours.label" bundle="${common_labels}"/></b>
											<%}else{   %>
											<INPUT TYPE="text" name="INFUSION_PERIOD_VALUE_MIN<%=t+1%>" id="INFUSION_PERIOD_VALUE_MIN<%=t+1%>" VALUE= "" SIZE="1" MAXLENGTH="2" CLASS="number" onBlur="CheckNum(this);checkHr(this,DURATION<%=t+1%>,'<%=t+1%>');calculateRate(this,volume<%=t+1%>,INF_RATE<%=t+1%>,infusionOverStr<%=t+1%>,'<%=t+1%>');chkDurationAD(DURATION<%=t+1%>,<%=t+1%>);  strtEndDateTime(<%=t+1%>);" onKeyPress="return allowValidNumber(this,event,3,0);" style="visibility:hidden" tabIndex="-1"><label class="label" style="visibility:hidden" id="hr<%=t+1%>"><b><fmt:message key="Common.hours.label" bundle="${common_labels}"/></b>
											<%}
											%>
											<!-- If else condtions added for aakh-crf-0094 end -->
										</td>
										<td class="label" style="display:none;" id="tdOrderQty_leg<%=t+1%>"> <!--added for SKR-CRF-0035 start-->
											<fmt:message key="ePH.OrderQuantity.label" bundle="${ph_labels}"/>
										</td>
										<td class="label" id="tdOrd_qty<%=t+1%>" style="display:none;">
											<input type='text' CLASS="number" name='order_qty<%=t+1%>' id='order_qty<%=t+1%>' size="1" maxlength="3" onKeyPress="return allowValidNumber(this,event,2,0);" onchange="calcTotalVolume('<%=t+1%>')">&nbsp;
											<label id="ord_qty_uom<%=t+1%>" class="label" style="font-size:9px;"></label>
										</td>
										<td class="label" style="display:none;" id="tdVolumePerUnit<%=t+1%>">
											<label id="volumePerUnit_leg<%=t+1%>"><fmt:message key="Common.volume.label" bundle="${common_labels}"/>/<fmt:message key="Common.Unit.label" bundle="${common_labels}"/></label>&nbsp;
											<input type="text" name="volumePerUnit<%=t+1%>" id="volumePerUnit<%=t+1%>" size="3" class="NUMBER" readOnly>&nbsp;
											<label id="volPerUnitUom_leg<%=t+1%>" class="label" style="font-size:9px;"></label>
											
										</td>
										<td class="label" colspan='2'>
											<label style="display:none" id="Totalvolume_leg<%=t+1%>"><fmt:message key="Common.total.label" bundle="${common_labels}"/></label>&nbsp;
											<label style="visibility:hidden" id="volume_leg<%=t+1%>"><fmt:message key="Common.volume.label" bundle="${common_labels}"/></label>&nbsp;
											<input type="text" name="volume<%=t+1%>" id="volume<%=t+1%>" size="3" MAXLENGTH="5" class="NUMBER" style="visibility:hidden" Value="" onblur="setStockValue(this,'<%=t+1%>'); validateRate(INF_RATE<%=t+1%>,volume<%=t+1%>,INFUSION_PERIOD_VALUE<%=t+1%>,DURATION<%=t+1%>,infusionOverStr<%=t+1%>,'<%=t+1%>'); chkDurationAD(DURATION<%=t+1%>,<%=t+1%>); CalculateDateTime(END_DATE<%=t+1%>,START_DATE<%=t+2%>); strtEndDateTime(<%=t+1%>);" onKeyPress="return allowValidNumber(this,event,3,0);" >&nbsp;
											<label id="vol_uom<%=t+1%>"  class="label" style="visibility:hidden;font-size:9px;"></label><!--added for SKR-CRF-0035 End-->
										</td>
										<td  class="label" nowrap colspan='2'>
											<label style="visibility:hidden" id="inf_rate_leg<%=t+1%>"><fmt:message key="ePH.InfusionRate.label" bundle="${ph_labels}"/></label>&nbsp;
											<!-- If else condtions added for aakh-crf-0094 start-->
											<% if(param_volume_cal.equals("N")){  %>
											<INPUT TYPE="text" CLASS="number" name="INF_RATE<%=t+1%>" id="INF_RATE<%=t+1%>" SIZE="3" MAXLENGTH="7"  onBlur="CheckNum(this);validateRate(this,volume<%=t+1%>,INFUSION_PERIOD_VALUE<%=t+1%>,DURATION<%=t+1%>,infusionOverStr<%=t+1%>,'<%=t+1%>');strtEndDateTime(<%=t+1%>);" onKeyPress="return allowValidNumber(this,event,6,2);" style="visibility:hidden" value="" >&nbsp;<label id='uom_display<%=t+1%>' class="label"></label>
											<%}else{   %>
											<INPUT TYPE="text" CLASS="number" name="INF_RATE<%=t+1%>" id="INF_RATE<%=t+1%>" SIZE="3" MAXLENGTH="7"  onBlur="CheckNum(this);validateRate(this,volume<%=t+1%>,INFUSION_PERIOD_VALUE<%=t+1%>,DURATION<%=t+1%>,infusionOverStr<%=t+1%>,'<%=t+1%>');strtEndDateTime(<%=t+1%>);" onKeyPress="return allowValidNumber(this,event,6,2);" style="visibility:hidden" value="" >&nbsp;<label id='uom_display<%=t+1%>' class="label"></label>
											<%}
											%>
											
											<% if(param_volume_cal.equals("N")){  %>
											<select name="InfusionRateUnit<%=t+1%>" id="InfusionRateUnit<%=t+1%>" onChange="ChangeInfuseOverTime(this,'<%=t+1%>');calVolumeInfuseRate(this,volumePerUnit<%=t+1%>,INF_RATE<%=t+1%>,infusionOverStr<%=t+1%>,<%=t+1%>);strtEndDateTime(<%=t+1%>)" style="visibility:hidden">
											<%}else{   %>
											<select name="InfusionRateUnit<%=t+1%>" id="InfusionRateUnit<%=t+1%>" onChange="ChangeInfuseOverTime(this,'<%=t+1%>');validateRate(INF_RATE<%=t+1%>,volume<%=t+1%>,INFUSION_PERIOD_VALUE<%=t+1%>,DURATION<%=t+1%>,infusionOverStr<%=t+1%>,'<%=t+1%>');strtEndDateTime(<%=t+1%>)" style="visibility:hidden">
											<%}
											%>
											<!-- If else condtions added for aakh-crf-0094 end-->
												<option value="M" <%=selected2%> ><fmt:message key="Common.Minute(s).label" bundle="${common_labels}"/></option>
												<option value="H" <%=selected1%> ><fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></option>
											</select>
										</td>
									</tr>
									<tr>
										<td colspan='9' class="label" >
											<a HREF="#" onMouseOver="changeCursor(this);" onClick="showMultipleFlowRate('<%=patient_id %>','<%=encounter_id %>','<%=mode%>','<%=t+1%>');" id='mfrLink<%=t+1%>' style="visibility:<%=mfr_display%>"><fmt:message key="ePH.MultipleFlowRate.label" bundle="${ph_labels}"/></a><img src="../../eCommon/images/disabled.gif"  id='MFR_Indicator<%=t+1%>' style="visibility:<%=mfr_display%>"> &nbsp;&nbsp;<a href="#"  onMouseOver="changeCursor(this);" onClick="showMFRRemarks('<%=t+1%>');" id='mfrRemarksLink<%=t+1%>' style="visibility:<%=mfr_display%>" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a>
											<input type="hidden" name="mfr_remarks<%=t+1%>" id="mfr_remarks<%=t+1%>"		value="<%=mfr_remarks%>">
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
<% 
				}
			} 
%>
			<input type="hidden" name="patient_class" id="patient_class"	value="<%=patient_class%>">
			<input type="hidden" name="act_patient_class" id="act_patient_class"	value="<%=act_patient_class%>">
			<input type="hidden" name="form_code" id="form_code"		value="<%=form_code%>">
			<input type="hidden" name="route_code" id="route_code"		value="<%=route_code%>">	
			<INPUT TYPE="hidden" name="bean_id" id="bean_id"			VALUE="<%= bean_id %>">
			<INPUT TYPE="hidden" name="bean_name" id="bean_name"		VALUE="<%= bean_name %>">
			<input type="hidden" name="patient_id" id="patient_id"		value="<%= patient_id %>">
			<input type="hidden" name="encounter_id" id="encounter_id"	value="<%= encounter_id %>">
			<input type="hidden" name="order_type_code" id="order_type_code" value="<%=order_type_code%>">
			<input type="hidden" name="pract_id" id="pract_id"		value="<%=pract_id%>">
			<input type="hidden" name="pract_name" id="pract_name"		value="<%=pract_name%>">
			<input type="hidden" name="LOCN_CODE" id="LOCN_CODE"		value="<%=locn_code%>">
			<input type="hidden" name="locn_type" id="locn_type"		value="<%=locn_type%>">	
			<input type="hidden" name="base_uom" id="base_uom"		value="">
			<input type="hidden" name="mode" id="mode"			value="<%=mode%>">
			<input type="hidden" name="mode1" id="mode1"			value="<%=mode1%>">	
			<input type="hidden" name="back_date" id="back_date"		value="">
			<input type="hidden" name="future_date" id="future_date"		value="">
			<input type="hidden" name="language_id" id="language_id"		value="<%=locale%>">
			<input type="hidden" name="iv_calc_infuse_by" id="iv_calc_infuse_by" value="<%=iv_calc_infuse_by%>">
			<input type="hidden" name="param_volume_cal" id="param_volume_cal" value="<%=param_volume_cal%>"><!-- Added for AAKH-CRF_0094 -->
			<input type="hidden" name="item_type_site_app" id="item_type_site_app"	value="<%=item_type_site_app%>">
			<input type="hidden" name="ext_disp_appl_yn" id="ext_disp_appl_yn"	value="<%=ext_disp_appl_yn%>"> <!--Added for NMC-JD-CRF-0046-->
			<input type="hidden" name="new_generic_name" id="new_generic_name"	value=""> <!-- Added for MMS-DM-CRF-0177 -->
			
<script type="text/javascript">
<%if(  req_diag_pres_found && diagnosis_found_yn.equals("N") ){ %>/* added for mms-dm-crf-0204 */
callCancel('<%=diagnosis_found_yn%>'); 
<% }%>
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



		</FORM>
	</BODY>
</HTML>
<%
putObjectInBean(bean_id,bean,request);
putObjectInBean(or_bean_id,ORbean,request);
}catch(Exception e){
	e.printStackTrace();
}finally{ 
       	if(con != null)
      		ConnectionManager.returnConnection(con,request);	 //added for GHL-CRF-0549
}

%>

