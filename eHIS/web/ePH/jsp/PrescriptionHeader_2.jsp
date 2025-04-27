<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* , eCommon.Common.*,java.math.*,eCommon.XSSRequestWrapper" %> <!-- java.math.* Added for ML-MMOH-CRF-1004 -->

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>  
<html>
	<head>
<%
 		request.setCharacterEncoding("UTF-8"); 
		//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	    request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	    response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	    response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	    //ends
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../js/Prescription_1.js"></script>
		<script language="JavaScript" src="../js/Prescription_2.js"></script>
		<script language="JavaScript" src="../js/PrescriptionTest.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<!-- <script language="JavaScript" src="../js/PhMessages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../js/PregnancyCategory.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	try{
		String iv_prep_yn = request.getParameter("iv_prep_yn");
		if(iv_prep_yn == null) 
			iv_prep_yn="";
			
		String facility_id		= (String) session.getValue("facility_id");
		String patient_id		= request.getParameter("patient_id"); 
		String encounter_id		= request.getParameter("encounter_id");
		String patient_class	= request.getParameter("patient_class");
		String act_patient_class= request.getParameter("patient_class");
		if(encounter_id==null || encounter_id.equals("") || encounter_id.equals("null"))  // if condition is added for  ML-MMOH-CRF-0343 [IN:057182]
			act_patient_class = "XT";
		if(patient_class.equals("DC")) 
			patient_class="IP";
		if(!patient_class.equals("IP")) 
			patient_class="OP";

		String location_type	= request.getParameter("location_type");
		String location_code	= request.getParameter("location_code");
		String bean_id					= "@PrescriptionBean_1"+patient_id+encounter_id;
		String mode						= CommonRepository.getCommonKeyValue( "MODE_MODIFY" );
		String bean_name				= "ePH.PrescriptionBean_1";
		PrescriptionBean_1 bean			= (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request);
		bean.setLanguageId(locale);
		bean.setActPatientClass_frm_Hdr(act_patient_class); // RUT-CRF-0062 - 32086 Added to get Build MAR Rule 
		bean.setEncounterId(encounter_id); //MMS-KH-CRF-0029
		int adr_count =(int)bean.getADRCount(patient_id,"%");
		String presBean_id			= "PrescriptionBean"+patient_id+encounter_id;
		String presBean_name		= "ePH.PrescriptionBean";
		PrescriptionBean presBean		= (PrescriptionBean)getBeanObject(presBean_id, presBean_name, request );
		presBean.setLanguageId(locale);
		boolean default_dose_type_yn = presBean.isSiteSpecific("OR", "OR_ORDER_SET"); // Added for ML-MMOH-CRF-1004
		String bl_disp_charge_dtl_in_rx_yn	= "";
		String bl_install_yn				= (String) session.getValue( "bl_operational" )==null?"N":(String) session.getValue( "bl_operational" ) ;
		String dc_mar_appl_yn				= "";
		String em_mar_appl_yn				= "";
		String ip_mar_appl_yn				= "";
		String op_mar_appl_yn				= "";
		String disch_med_mar_appl_yn		= "";
		String max_durn_for_ip_pres			= "";
		String chk_for_ip_max_durn_action	= "";
		String max_durn_for_op_pres			= "";
		String chk_for_op_max_durn_action	= "";
		String max_durn_for_dm_pres			= "";//added for ML-MMOH-SCF-0498 --chithra	
		String chk_for_dm_max_durn_action	= "";//added for ML-MMOH-SCF-0498	
		String trade_display_yn				= "";
		String narcotic_aprvl_form_req_yn	= "";
		String print_narcotic_form_by_default = "";
		String mandatory_rem_on_prn_freq_yn = "";
		String max_length_prn_reason		= "";
		String rx_qty_by_pres_base_uom_yn	= "";
		String atc_allergy_alert_level	= "";
		String drug_interaction_check_yn	= "";
		String  print_mar_label_yn="";//added for crf Bru-HIMS-CRF-093[29960]
		String diag_for_medn_order_by="P"; //MMS-SCF-0325 [IN:048069]
		String preview_rx_yn ="";//added for ML-MMOH-CRF-0341 [IN:057179]
		String drug_indication_mdry="";//added for jd-crf-0220
				ArrayList param_vals				= bean.getParameterValues();
		if(param_vals!=null && param_vals.size()!=0) {
			if(bl_install_yn!=null && bl_install_yn.equals("Y")){
				bl_disp_charge_dtl_in_rx_yn =	(String)param_vals.get(2);
			}
			dc_mar_appl_yn =	(String)param_vals.get(5);
			em_mar_appl_yn =	(String)param_vals.get(6);
			ip_mar_appl_yn =	(String)param_vals.get(7);
			op_mar_appl_yn =	(String)param_vals.get(8);
			disch_med_mar_appl_yn =	(String)param_vals.get(9);
			narcotic_aprvl_form_req_yn		=	(String)param_vals.get(12);
			print_narcotic_form_by_default	=	(String)param_vals.get(13);
			//mandatory_rem_on_prn_freq_yn =(String)param_vals.get(14);
			rx_qty_by_pres_base_uom_yn		=   (String)param_vals.get(14);
			atc_allergy_alert_level			=   (String)param_vals.get(15);
			print_mar_label_yn			=   (String)param_vals.get(17); //added for MMS-QH-CRF-0080 [IN:038064]			
			max_length_prn_reason			=   (String)param_vals.get(18);// incresing get value +1 for CRF MMS-QH-CRF-0068 [IN:037980]-start

			/*max_durn_for_ip_pres =	(String)param_vals.get(12);
			chk_for_ip_max_durn_action =	(String)param_vals.get(13);
			max_durn_for_op_pres =	(String)param_vals.get(14);
			chk_for_op_max_durn_action =	(String)param_vals.get(15);
			trade_display_yn =	(String)param_vals.get(18);*/
			max_durn_for_ip_pres =	(String)param_vals.get(25);//added for ML-MMOH-SCF-0498			
			diag_for_medn_order_by=(String)param_vals.get(20);//20 //MMS-SCF-0325 [IN:048069]
			preview_rx_yn		=	(String)param_vals.get(22);//22//added for ML-MMOH-CRF-0341 [IN:057179]

			chk_for_ip_max_durn_action =	(String)param_vals.get(26);
			max_durn_for_op_pres =	(String)param_vals.get(27);
			chk_for_op_max_durn_action =	(String)param_vals.get(28);//added for ML-MMOH-SCF-0498	
			max_durn_for_dm_pres=(String)param_vals.get(29);
			chk_for_dm_max_durn_action=(String)param_vals.get(30);//end
			trade_display_yn =	(String)param_vals.get(31);
			drug_interaction_check_yn =	(String)param_vals.get(32);
			drug_indication_mdry=bean.getDrugIndicationMdry();//added for jd-crf-0220
			System.out.println("drug_indication_mdry prescriptionheader_2"+drug_indication_mdry);
	
			// incresed get value by one for CRF MMS-QH-CRF-0068 [IN:037980]-end
		}
		String or_bean_name				= "eOR.OrderEntryBean";
		String or_bean_id						= "@orderentrybean"+patient_id+encounter_id;
		OrderEntryBean orbean			= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name,request ) ;
		orbean.setLanguageId(locale);
		
		String iv_bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
		String iv_bean_name			= "ePH.IVPrescriptionBean";
		IVPrescriptionBean iv_bean	= (IVPrescriptionBean)getBeanObject( iv_bean_id,iv_bean_name,request) ;
		iv_bean.setLanguageId(locale);
		iv_bean.setIVCalcInfuseBy(bean.getIVCalcInfuseBy()); //Added for MMS-QH-CRF-0080 [IN:038064]
		String called_from		=	orbean.getCalledFromFunction(); //Added for Bru-HIMS-CRF-400 [IN:044502] start
		String order_id ="";
		if(called_from.equals("RENEW_ORDER")){
			StringBuilder sbRenewOrderIds = new StringBuilder();
			HashMap hmRenewOrders = orbean.getRenewOrderIds();
			if(hmRenewOrders!=null && hmRenewOrders.size()>0){
				List renewDrugList = new ArrayList(hmRenewOrders.keySet());
				for(int i=0; i<renewDrugList.size(); i++){
					if(i == (renewDrugList.size()-1))
						sbRenewOrderIds.append( (String)hmRenewOrders.get((String)renewDrugList.get(i)));
					else
						sbRenewOrderIds.append( (String)hmRenewOrders.get((String)renewDrugList.get(i))+"' , '");
				}
			}
			order_id = sbRenewOrderIds.toString();
		}
		else //Bru-HIMS-CRF-400 [IN:044502] -end
			order_id			= (String) orbean.getOrderId();
		String order_line_num	= (String) orbean.getOrderLineNo();
		String attend_pract_id	= (String) orbean.getAttendPractitionerId();
		String pract_id			= (String) orbean.getPractitionerId();
		String servide_code		= (String) orbean.getServiceCode();
		String resp_id			= (String) orbean.getResponsibilityId();

		String height_unit		= "";
		String weight_unit		= "";	
		String priority			= "";
		String or_date_time		= "";
		String practioner		= "";	
		String take_home_medi	= "";
		String priority_code = "";
		String diag_text		= "";
		String height			= "";
		String weight			= "";
		String bsa				= "";
		String take_home_chk	= "";
		String schedule_yn		= "";
		String bmi              = "";
		String home_leave_med   ="";
		String home_leave_chk   ="", home_leave_yn_val="",leave_fm =null,leave_to=null;
		int homeleave_rec =0;//added for crf Bru-HIMS-CRF-093[29960]
		String excludeADRAllergyAlert_yn = bean.getExcludeADRAllergyAlert();//Added for HSA-SCF-0011 [IN:042444]
		if(patient_class.equals("IP")){			//if block added  for Bru-HIMS-CRF-093 [IN:029960]
			homeleave_rec=(int)presBean.getHomeLeaveYn(encounter_id,facility_id);
		}
		HashMap homeleave_vals	=	presBean.getHomeLeaveDates(encounter_id,facility_id);//Added for Bru-HIMS-CRF-093-DD1[IN047223]--start
		ArrayList takeHomeDates = new ArrayList();
		if(homeleave_vals.size()>0){
			leave_fm = (String)homeleave_vals.get("LEAVE_FR_DATE");
			leave_to = (String)homeleave_vals.get("LEAVE_TO_DATE");
			takeHomeDates.add(leave_fm);
			takeHomeDates.add(leave_to);
			bean.setTakeHomeDates(takeHomeDates);//Added for Bru-HIMS-CRF-093-DD1[IN047223]--end
		}
		int administered_yn     =0;
		HashMap drugDetails		= null;

		if(patient_class.equals("IP") && !order_line_num.equals("")) {
			order_line_num	=	"1";
		}
		bean.setPatientClass(patient_class);
		bean.setamendOrderID(order_id);
		ArrayList drugData		= new ArrayList();
		
		if(iv_prep_yn.equals("7")|| iv_prep_yn.equals("8")){
			drugData	=  bean.loadAmendDetailsForTPN(order_id,patient_id,order_line_num,called_from);
		}
		else if(iv_prep_yn.equals("1")|| iv_prep_yn.equals("2") || iv_prep_yn.equals("3")|| iv_prep_yn.equals("4") || iv_prep_yn.equals("5")){
			drugData   =  iv_bean.loadAmendDetails(order_id,patient_id,act_patient_class);  // RUT-CRF-0062 Added actual patient class to get the Build MAR Rule
		}
		else {
			drugData   = bean.loadAmendDetails(order_id,patient_id,order_line_num,called_from,resp_id); 
		}
		int medication_rec=(int)bean.getHomeMecdicationYn(encounter_id,facility_id);
		if(bl_install_yn.equals("Y"))
            presBean.getDecimalFormatString();

		bean.savePresRemarks(bean.getAmendRemarks(order_id));
		iv_bean.setAmendRemarks(iv_bean.getAmendRemarks(order_id));
		String order_remarks	=	bean.getAmendRemarks(order_id);
		String allergic_yn		=	"";
		String problem_ind="";
		String oncology_bean_id				= "@OncologyRegimenBean"+patient_id+encounter_id;
		String oncology_bean_name			= "ePH.OncologyRegimenBean";
		OncologyRegimenBean oncology_bean	= (OncologyRegimenBean)getBeanObject( oncology_bean_id, oncology_bean_name, request );
		oncology_bean.setLanguageId(locale);
		HashMap	regimenValues				= (HashMap)oncology_bean.getRegimenValues(servide_code);
		if(regimenValues!=null){
			 problem_ind					=	(String)regimenValues.get("problem_ind");
		}
		if(iv_prep_yn.equals("9")  || iv_prep_yn.equals("0")){
			HashMap CYTOHeaderDetails = oncology_bean.getExistingCYTOOrderDetails(order_id);
			priority		= (String) CYTOHeaderDetails.get("PRIORITY");
			or_date_time	= (String) CYTOHeaderDetails.get("ORD_DATE_TIME");
			practioner		= (String) CYTOHeaderDetails.get("PRACTITIONER_NAME");
			height			= (String) CYTOHeaderDetails.get("HEIGHT");
			weight			= (String) CYTOHeaderDetails.get("WEIGHT");
			bsa				= (String) CYTOHeaderDetails.get("BSA");
			diag_text		= (String) CYTOHeaderDetails.get("DIAG_TEXT");
			schedule_yn		= (String) CYTOHeaderDetails.get("SCHEDULED_YN");
			take_home_medi	= (String) CYTOHeaderDetails.get("TAKE_HOME");
			height_unit		= (String) CYTOHeaderDetails.get("HEIGHT_UOM");
			weight_unit		= (String) CYTOHeaderDetails.get("WEIGHT_UOM");
		}
		int num =0;
		   num=  bean.loadallergydetail(patient_id);
		
		if(num>0){
			allergic_yn="YES";
		}
		else{
			allergic_yn="NO";
		}
		//check for recorded diagnosis
		int diag_size = 0;
		ArrayList diagnosis	=	bean.checkDiagnosis(patient_id, encounter_id, diag_for_medn_order_by);			
		if(diagnosis != null){
			diag_size	=	(diagnosis).size();
		}

		if(drugData!= null && drugData.size()>0){
			for(int i=0;i<drugData.size();i++){
				drugDetails		= (HashMap)drugData.get(i);
				priority		= (String) drugDetails.get("PRIORITY");
				or_date_time	= (String) drugDetails.get("ORD_DATE_TIME");
				practioner		= (String) drugDetails.get("PRACTITIONER_NAME");
				height			= (String) drugDetails.get("HEIGHT");
				weight			= (String) drugDetails.get("WEIGHT");
				bsa				= (String) drugDetails.get("BSA");
				if(!bsa.equals("") && default_dose_type_yn){ // Added for ML-MMOH-CRF-1004 - Start
					bsa = BigDecimal.valueOf(Double.valueOf(bsa)).setScale(2, BigDecimal.ROUND_UP).toString();
				} // Added for ML-MMOH-CRF-1004 - End
				diag_text		= (String) drugDetails.get("DIAG_TEXT");
				schedule_yn		= (String) drugDetails.get("SCHEDULED_YN");
				take_home_medi	= (String) drugDetails.get("TAKE_HOME");
				height_unit		= (String) drugDetails.get("HEIGHT_UOM");
				weight_unit		= (String) drugDetails.get("WEIGHT_UOM");
				mandatory_rem_on_prn_freq_yn = (String) drugDetails.get("MANDATORY_REM_ON_PRN_FREQ_YN");
				home_leave_med = drugDetails.get("HOME_LEAVE")==null?"":(String) drugDetails.get("HOME_LEAVE"); //added for Bru-HIMS-CRF-093
			}	
		}
			if(homeleave_rec>0 ||  home_leave_med.equals("Y")){//added for Bru-HIMS-CRF-093 -start
				home_leave_yn_val	= "Y";
			}
			else{
				home_leave_yn_val	= "N"; 
			}
			home_leave_chk="";
			if( home_leave_med.equals("Y")){
				home_leave_chk="checked";
			} //added for Bru-HIMS-CRF-093 -end

			if(height_unit==null)
				height_unit= com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Cms.label", "ph_labels");
			if(weight_unit==null)
				weight_unit= com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Kgs.label", "common_labels");
			if(!height.equals("") && !weight.equals("")) {
				bmi=(Float.parseFloat(weight)/((Float.parseFloat(height)/100)*(Float.parseFloat(height)/100)))+"";	
				int index	=	bmi.indexOf(".");
		
				if(bmi.length()>=(index+3) ) {
					bmi	=(bmi.substring(0,index+3));
				}	
			}
			if(bmi.equals("0.0")) bmi= "";
			if(take_home_medi!=null && ( take_home_medi.equals("Y") || take_home_medi.equals("D")) ){
				take_home_chk="checked";
			}
			else{
				take_home_chk="";
			}
%>
			<script>	
				parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.ph_load_yn.value="Y";
			</script>
<%
			if(called_from.equals("RENEW_ORDER")) {
				mode						= CommonRepository.getCommonKeyValue( "MODE_INSERT" );
				or_date_time				=DateUtils.getCurrentDate("DMYHM",locale);
				bean.setCalledFrom(called_from);
				iv_bean.setOrderDate(or_date_time);
			}
			else if(called_from.equals("AMEND_ORDER")) {
				mode						= CommonRepository.getCommonKeyValue( "MODE_MODIFY" );
				bean.setCalledFrom(called_from);	
				 administered_yn =iv_bean.administered_yn(order_id,encounter_id);
				 if(!iv_prep_yn.equals("")){
					 if(!locale.equals("en"))
						 if(!iv_prep_yn.equals("9")  && !iv_prep_yn.equals("0")){
						    or_date_time = DateUtils.convertDate(or_date_time, "DMYHM","en",locale);
					     }
				 }
			}
			//getting the External Drug Interface Controls 
			String param_bean_id					= "@DrugInterfaceControlBean"+patient_id;
			String param_bean_name				= "ePH.DrugInterfaceControlBean";
			DrugInterfaceControlBean param_bean			= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
			String drug_db_interface_yn			=	param_bean.getDrugDBInterface_yn(facility_id);    
			String drug_db_product_id			=	param_bean.getDrugDBProductID(facility_id);    
			String drug_db_dosecheck_yn			=	param_bean.getDrugDBDosecheck_yn(facility_id);    
			String drug_db_duptherapy_yn		=	param_bean.getDrugDBDuptherapy_yn(facility_id);
			String drug_db_interact_check_yn	=	param_bean.getDrugDBInteract_check_yn(facility_id);  
			String drug_db_contraind_check_yn	=	param_bean.getDrugDBContraind_check_yn(facility_id);
			String drug_db_allergy_check_yn		=	param_bean.getDrugDBAllergy_check_yn(facility_id);   
			param_bean.clear();

			if(priority.equalsIgnoreCase("Routine")){
				priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
				priority_code = "R";
			}
			else if(priority.equalsIgnoreCase("Urgent")){
				priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
				priority_code = "U";
			}
%>
			<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
				<form name="prescription_header_form" id="prescription_header_form">
					<table cellpadding=0 cellspacing=0 width="100%" align="center" border="1">
						<tr>
							<td class="label" width="9%" ><fmt:message key="Common.height.label" bundle="${common_labels}"/> :</td>
							<td class="label" width="5%" ><%=height%>&nbsp;<b><%=height_unit%></b></td>		
							<td class="label" width="8%" ><fmt:message key="Common.weight.label" bundle="${common_labels}"/> :</td>
							<td class="label" width="5%" ><%=weight%>&nbsp;<b><%=weight_unit%></b></td>		
						     <%if(default_dose_type_yn){ // if else condition Added for ML-MMOH-CRF-1004 -Start %>
						    <td class="label" width="5%" ><fmt:message key="Common.BSA.label" bundle="${common_labels}"/> :</td>
							<td class="label" width="5%" ><%=bsa%> m&sup2;</label></td>
							<td class="label" width="5%" ><fmt:message key="Common.BMI.label" bundle="${common_labels}"/> :</td>
							<td class="label" width="8%" ><%=bmi%> kg/m&sup2;</label></td>
						   <%} else{%>
							<td class="label" width="5%" ><fmt:message key="Common.BSA.label" bundle="${common_labels}"/> :</td>
							<td class="label" width="5%" ><%=bsa%></td>
							<td class="label" width="5%" ><fmt:message key="Common.BMI.label" bundle="${common_labels}"/> :</td>
							<td class="label" width="5%" ><%=bmi%></td>
							 <%} // if else condition Added for ML-MMOH-CRF-1004 -End %>
							<td class="label" width="10%" ><fmt:message key="Common.priority.label" bundle="${common_labels}"/> :&nbsp;</td>
							<td class="label" width="10%" ><b><%=priority%></b></td>
							<td class="label" width="10%" ><fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/> :</td>
							<td class="label" width="16%" ><b><%=or_date_time%></b></td>
						</tr>
					</table>
					<table cellpadding=0 cellspacing=0 width="100%" align="center" border="0">
						<tr>
							<td class="label" width="12%"  nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/> :</td>
							<td class="label" width="20%"  nowrap><%=practioner%></td>
							<td class="label" width="25%"  nowrap><fmt:message key="ePH.DischargeRx.label" bundle="${ph_labels}"/><!-- Take Home Medication -->&nbsp;&nbsp;<input type="checkbox" value='<%=take_home_medi%>' name="take_home_medication" nowrap <%=take_home_chk%> disabled></td>
<%                          
							if(home_leave_yn_val.equals("Y")){ //added for crf Bru-HIMS-CRF-093[29960] -start
%>
								<td class="label" width="25%"  nowrap><fmt:message key="ePH.HomeLeaveMedication.label" bundle="${ph_labels}"/>&nbsp;&nbsp;<input type="checkbox" name="home_leave_medication" id="home_leave_medication" nowrap <%=home_leave_chk%> disabled>
								<br>(<%=leave_fm%> - <%=leave_to%> )
								</td>
<%
							}//added for crf Bru-HIMS-CRF-093[29960] -end
%>
							<td class="label" width="23%"  nowrap><label><fmt:message key="ePH.KnownCaseofAllergy.label" bundle="${ph_labels}"/>: <b><%=allergic_yn%></b></label></td>
							<td class="label" width="15%"  nowrap>
								<a href="javascript:callOrderRemarks();" title="Remarks">&nbsp;<fmt:message key="Common.ClinicalComments.label" bundle="${common_labels}"/></a>
<%                     
							if(adr_count >0){
 %>   
								<a href="javascript:callADRdetails('<%=patient_id%>');" title="Clinical Comments">&nbsp;&nbsp;&nbsp;ADR</a>
<%                     
							}
%>
						    <label onClick="javascript:callDiagText('<%=patient_id%>','<%=encounter_id%>','Header');" style="visibility:hidden" id="diag_text" title="Diag Text">&nbsp;&nbsp;<fmt:message key="Common.diagnosis.label"  bundle="${common_labels}"/></label>
							</td>
							<td>
<%
							String pregn_bean_id = "PregnancyCategory" ;
							String pregn_bean_name = "ePH.PregnancyCategoryBean";
							PregnancyCategoryBean pregn_bean = (PregnancyCategoryBean)getBeanObject( pregn_bean_id, pregn_bean_name, request ) ;
							HashMap maternityMap= pregn_bean.getPregnancyRemarks(patient_id);
							String lmpValue = maternityMap.get("LMP").toString();
							String gestationValue = maternityMap.get("GESTATION").toString();
							String eddValue = maternityMap.get("EDD").toString();
							String asOnDateValue = maternityMap.get("ASONDATE").toString();
							if (!((lmpValue.equals(""))&&(gestationValue.equals(""))&&(eddValue.equals("")))){
%>
								<td class="label"  nowrap >&nbsp;&nbsp;<a href="javascript:showPregnancyRemarks('<%=lmpValue%>','<%=gestationValue%>','<%=eddValue%>','<%=asOnDateValue%>');" title="Pregnancy Remarks ">&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.PregnancyRemarks.label" bundle="${ph_labels}"/> </a>&nbsp;&nbsp;</td>
<%
							}
%>
							</td>
							<td class="label" width="10%" nowrap>
<%
							if(diag_text!=null && !(diag_text.equals(""))){
%>
						 		<a href="javascript:callAmendDiagText('<%=diag_text%>');" title="Remarks">&nbsp;<fmt:message key="ePH.DiagnosisText.label" bundle="${ph_labels}"/></a> 
<%	
							}
							else{	
%>
								&nbsp;&nbsp;
<%
							}
%>			
							</td>			
						</tr>
					</table>
<%
	//This part is commented and new variable priority_code is introduced to store the priority in hidden variable
	// IN24413 --14/10/2010-- priya
			/*		if(priority.startsWith("R") || priority.startsWith("r")) { 
						priority	=	"R";
					}
					else  if(priority.startsWith("U") || priority.startsWith("u")) {
						priority	=	"U";
					} */

%>
					<input type="hidden" value="<%=presBean_id%>" name="presBean_id">
					<input type="hidden" value="<%=presBean_name %>" name="presBean_name">
					<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
					<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
					<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>">
					<input type="hidden" name="order_line_num" id="order_line_num" value="<%=order_line_num%>">
					<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
					<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
					<input type="hidden" name="priority" id="priority" value="<%= priority_code %>">
					<input type="hidden" name="or_date_time" id="or_date_time" value="<%= or_date_time %>">
					<input type="hidden" name="patient_class" id="patient_class" value="<%= patient_class %>">
					<input type="hidden" name="actual_patient_class" id="actual_patient_class" value="<%=act_patient_class%>">
					<input type="hidden" name="mode" id="mode" value="<%=mode%>">
					<input type="hidden" name="location_type" id="location_type" value="<%=location_type%>">
					<input type="hidden" name="location_code" id="location_code" value="<%=location_code%>">
					<input type="hidden" name="source_type" id="source_type" value="<%=location_type%>">
					<input type="hidden" name="source_code" id="source_code" value="<%=location_code%>">
					<input type="hidden" value="<%=facility_id%>" name="facility_id">		
					<input type="hidden" name="order_remarks" id="order_remarks" value="<%=order_remarks%>">
					
					<input type="hidden" value="<%=schedule_yn%>" name="schedule_yn">	
					<input type="hidden" value="<%=called_from%>" name="called_from">
					<input type="hidden" value="<%=or_date_time%>" name="sys_date">
					<input type="hidden" value="<%=attend_pract_id%>" name="attend_pract_id">
					<input type="hidden" value="<%=pract_id%>" name="pract_id">
					<input type="hidden" name="pract_name" id="pract_name" value="<%=practioner%>" >	
					<input type="hidden" value="<%=resp_id%>" name="resp_id">
					<input type="hidden" value="<%=iv_prep_yn%>" name="iv_prep_yn">
					<input type="hidden" name="allergic_yn" id="allergic_yn" value="<%=allergic_yn%>">		
					<input type="hidden" name="patient_height" id="patient_height" value="<%=height%>"> 
					<input type="hidden" name="bed_num" id="bed_num"					  value=""> 
					<input type="hidden" name="room_num" id="room_num"					  value=""> 
					<input type="hidden" name="height" id="height"					  value="<%=height%>"> 
					<input type="hidden" name="height_unit" id="height_unit"				  value="<%=height_unit%>">
					<input type="hidden" name="patient_weight" id="patient_weight"			  value="<%=weight%>">
					<input type="hidden" name="weight" id="weight"					  value="<%=weight%>">
					<input type="hidden" name="weight_unit" id="weight_unit"				  value="<%=weight_unit%>">
					<input type="hidden" name="bsa" id="bsa"						  value="<%=bsa%>">
					<input type="hidden" name="bmi" id="bmi"						  value="<%=bmi%>">	
					<input type="hidden" name="administered_yn" id="administered_yn"           value="<%=administered_yn%>">
					<input type="hidden" name="problem_ind" id="problem_ind"               value="<%=problem_ind%>">		
					<input type="hidden" name="diag_size" id="diag_size"                 value="<%=diag_size%>">
					<input type="hidden" name="take_home_medi_val" id="take_home_medi_val"        value="<%=take_home_medi%>">
					
					<!--External Drug Interface Controls -->	   
					<input type="hidden" name="drug_db_interface_yn" id="drug_db_interface_yn"       value="<%=drug_db_interface_yn%>"> 
					<input type="hidden" name="drug_db_product_id" id="drug_db_product_id"         value="<%=drug_db_product_id%>"> 
					<input type="hidden" name="drug_db_dosecheck_yn" id="drug_db_dosecheck_yn"       value="<%=drug_db_dosecheck_yn%>"> 
					<input type="hidden" name="drug_db_duptherapy_yn" id="drug_db_duptherapy_yn"      value="<%=drug_db_duptherapy_yn%>"> 
					<input type="hidden" name="drug_db_interact_check_yn" id="drug_db_interact_check_yn"  value="<%=drug_db_interact_check_yn%>">
					<input type="hidden" name="drug_db_contraind_check_yn" id="drug_db_contraind_check_yn" value="<%=drug_db_contraind_check_yn%>">
					<input type="hidden" name="drug_db_allergy_check_yn" id="drug_db_allergy_check_yn"   value="<%=drug_db_allergy_check_yn%>">
					<input type="hidden" name="adr_count" id="adr_count"                  value="<%=adr_count%>">
					<input type="hidden" name="narcotic_aprvl_form_req_yn" id="narcotic_aprvl_form_req_yn" value="<%=narcotic_aprvl_form_req_yn%>"> 
					<input type="hidden" name="print_narcotic_form_by_default" id="print_narcotic_form_by_default" value="<%=print_narcotic_form_by_default%>"> 

					<!--Billing Display flags -->	   
					<input type="hidden" name="bl_disp_charge_dtl_in_rx_yn" id="bl_disp_charge_dtl_in_rx_yn" value="<%=bl_disp_charge_dtl_in_rx_yn%>">
					<input type="hidden" name="bl_install_yn" id="bl_install_yn" value="<%=bl_install_yn%>">
					<input type="hidden" name="dc_mar_appl_yn" id="dc_mar_appl_yn" value="<%=dc_mar_appl_yn%>">
					<input type="hidden" name="em_mar_appl_yn" id="em_mar_appl_yn" value="<%=em_mar_appl_yn%>">
					<input type="hidden" name="ip_mar_appl_yn" id="ip_mar_appl_yn" value="<%=ip_mar_appl_yn%>">
					<input type="hidden" name="op_mar_appl_yn" id="op_mar_appl_yn" value="<%=op_mar_appl_yn%>">
					<input type="hidden" name="disch_med_mar_appl_yn" id="disch_med_mar_appl_yn" value="<%=disch_med_mar_appl_yn%>">
					<input type="hidden" name="max_durn_for_ip_pres" id="max_durn_for_ip_pres" value="<%=max_durn_for_ip_pres%>">
					<input type="hidden" name="chk_for_ip_max_durn_action" id="chk_for_ip_max_durn_action" value="<%=chk_for_ip_max_durn_action%>">
					<input type="hidden" name="max_durn_for_op_pres" id="max_durn_for_op_pres" value="<%=max_durn_for_op_pres%>">
					<input type="hidden" name="chk_for_op_max_durn_action" id="chk_for_op_max_durn_action" value="<%=chk_for_op_max_durn_action%>">
					<input type="hidden" name="max_durn_for_dm_pres" id="max_durn_for_dm_pres" value="<%=max_durn_for_dm_pres%>"><!--  added for ML-MMOH-SCF-0498	-->
					<input type="hidden" name="chk_for_dm_max_durn_action" id="chk_for_dm_max_durn_action" value="<%=chk_for_dm_max_durn_action%>"><!--  added for ML-MMOH-SCF-0498	-->
					<input type="hidden" name="trade_display_yn" id="trade_display_yn" value="<%=trade_display_yn%>">
					<input type="hidden" name="man_rem_on_prn_freq_yn" id="man_rem_on_prn_freq_yn" value="<%=mandatory_rem_on_prn_freq_yn%>">
					<input type="hidden" name="max_length_prn_reason" id="max_length_prn_reason" value="<%=max_length_prn_reason%>">
					<input type="hidden" name="rx_qty_by_pres_base_uom_yn" id="rx_qty_by_pres_base_uom_yn" value="<%=rx_qty_by_pres_base_uom_yn%>">
					<input type="hidden" name="atc_allergy_alert_level" id="atc_allergy_alert_level" value="<%=atc_allergy_alert_level%>">
					<input type="hidden" name="drug_interaction_check_yn" id="drug_interaction_check_yn" value="<%=drug_interaction_check_yn%>">
					<input type="hidden" name="print_mar_label_yn" id="print_mar_label_yn" value="<%=print_mar_label_yn%>"><!-- added for MMS-QH-CRF-0080 [IN:038064] -->
					<input type="hidden" name="buildMAR_yn" id="buildMAR_yn" value="N"><!-- added for MMS-QH-CRF-0080 [IN:038064] -->
					<input type="hidden" name="excludeADRAllergyAlert_yn" id="excludeADRAllergyAlert_yn" value="<%=excludeADRAllergyAlert_yn%>"><!--Added for HSA-SCF-0011 [IN:042444] -->
					<input type="hidden" name="preview_rx_yn" id="preview_rx_yn" value="<%=preview_rx_yn%>"><!-- //added for ML-MMOH-CRF-0341 [IN:057179] -->
					 <input type="hidden" name="drug_indication_mdry" id="drug_indication_mdry" value="<%=drug_indication_mdry%>"><!-- Added for JD-CRF-0220 -->
			</form>
		</body>
<%
		if(iv_prep_yn.equals("1") || iv_prep_yn.equals("2") || iv_prep_yn.equals("3") || iv_prep_yn.equals("4") || iv_prep_yn.equals("5") || iv_prep_yn.equals("6") || iv_prep_yn.equals("7") || iv_prep_yn.equals("8") ||iv_prep_yn.equals("9")  || iv_prep_yn.equals("0")){
%>
		<script>loadAllOtherFrames();</script>
<%
		}
		else{
%>
			<script>loadAllOtherFrames_1();</script>
<%
		}
		putObjectInBean(bean_id,bean,request);
		putObjectInBean(oncology_bean_id,oncology_bean,request);
		putObjectInBean(iv_bean_id,iv_bean,request);
		putObjectInBean(or_bean_id,orbean,request);
		putObjectInBean(presBean_id,presBean,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}
 %>
</html>

