<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* , eCommon.Common.*,java.math.*,eCommon.XSSRequestWrapper" %> <!-- java.math.* Added for ML-MMOH-CRF-1004 -->
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
		 request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		 response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		 response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		 //ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<!-- import the calendar script -->
		<script type="text/javascript"	 src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript"	 src="../js/DirectDispensing.js"></script>
		<script language="javascript"	 src="../../eCommon/js/dchk.js"></script>
		<script language="javascript"	 src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript"	 src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript"	 src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	try{
		String licence			= (String)(PhLicenceRights.getKey());
		String facility_id		= (String) session.getValue("facility_id");
		//String bl_install_yn    = (String) session.getValue( "bl_operational" );
		String pract_id			=  request.getParameter("pract_id");
		String practioner_name	=  request.getParameter("pract_name");
		String dir_bean_id      = "DirectDispensingBean" ;
		String dir_bean_name    = "ePH.DirectDispensingBean";
		DirectDispensingBean dir_bean = (DirectDispensingBean)getBeanObject( dir_bean_id,dir_bean_name,request);
		String bl_install_yn    = dir_bean.checkforbillinginterface();
		String patient_id       = "";
		String encounter_id     = "";
		String patient_class    = "";
		String ord_locn         = "";
		String practioner_id    = "";
		String pat_details      = "";
		String pract_name		= "";
		String ord_locn_name    = "";
		String pract_name_str   = "";
		String patient_name		= "";
		String date_of_birth	= "";
		String gender			= "";
		String disp_locn_code   = "";  //code added for JD-CRF-0156[IN041737]
		int adr_count			= 0;
		ArrayList pat_det		= new ArrayList();
		patient_id=dir_bean.getPatientID();
		if(patient_id!=null && !patient_id.equals("")){
			encounter_id			= dir_bean.getEncounterID();
			if(encounter_id==null||encounter_id.equals("")){
				encounter_id="";
				dir_bean.setPatientClass("XT");
			}
			patient_class		= dir_bean.getPatientClass();
			ord_locn				= dir_bean.getOrdLocn();
			if(ord_locn==null){
				ord_locn="";
			}
			practioner_id		= dir_bean.getPractionerID();
			if(practioner_id==null ||practioner_id.equals("")){
				dir_bean.setPractionerID(pract_id);			  
				practioner_id      = pract_id;
				dir_bean.setPractionerName(practioner_name);
			}
			pat_det				=(ArrayList)dir_bean.getPatientDetails1(patient_id);
			pat_details			="<b>"+pat_det.get(0)+"/"+pat_det.get(1)+"/"+pat_det.get(2)+"</b>";
			patient_name         = (String)pat_det.get(0);
			date_of_birth	=	(String)pat_det.get(3);
			gender	=	(String)pat_det.get(2);
			gender	=	gender.substring(0,1).toUpperCase();
			pract_name			= dir_bean.getPractionerName();
			ord_locn_name		= dir_bean.getOrdLocnName();
			pract_name_str		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OrdLocnPract.label","ph_labels") + " : <b>"+ord_locn_name+"/"+pract_name+"</b>";
			adr_count = dir_bean.getADRCount(patient_id,"%");
		    disp_locn_code		= dir_bean.getDispLocnCode(); //code added for JD-CRF-0156[IN041737]	
			
		}
		String drug_bean_id = "@DrugSearchBean"+patient_id+encounter_id ;
		String drug_bean_name = "ePH.DrugSearchBean";
		DrugSearchBean drug_bean = (DrugSearchBean)getBeanObject( drug_bean_id, drug_bean_name, request ) ;
		String mode						= CommonRepository.getCommonKeyValue( "MODE_INSERT" );
		String bean_id					= "@PrescriptionBean_1"+patient_id+encounter_id;
		String bean_name				= "ePH.PrescriptionBean_1";
		PrescriptionBean_1 bean			= (PrescriptionBean_1)getBeanObject(bean_id,bean_name,request);
		String presBean_id					= "@PrescriptionBean"+patient_id+encounter_id;
		String presBean_name				= "ePH.PrescriptionBean";
		PrescriptionBean presBean			= (PrescriptionBean)getBeanObject(presBean_id,presBean_name,request);
		String param_bean_id				= "@DrugInterfaceControlBean";
		String param_bean_name				= "ePH.DrugInterfaceControlBean";
		DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
		boolean default_dose_type_yn = dir_bean.isSiteSpecific("OR", "OR_ORDER_SET"); // Added for ML-MMOH-CRF-1004
		param_bean.setLanguageId(locale);
		presBean.setLanguageId(locale);
		bean.setLanguageId(locale);
		drug_bean.setPractitionerId(pract_id);
		//declaration
		float bsa						= 0f;
		String leg_value_1				= "";
		String leg_uom_1				= "";
		String leg_value_2				= "";
		String leg_uom_2				= "";	
		String bsa_str					= "";
		//String visit_date				= "";
		String sys_date					= "";
		String calculated_date			= "";	
		String order_remarks			= "";
		String back_date				= "";
		String future_date				= "";
		String servide_code				= "";
		String service_search_yn		= "N";
		String allow_without_wt			= "";
		String allow_without_diag		= "";
		String patient_age				= "";
		String rec_date					= "";
		String bmi_str					= "";	
		String height_min				= "";
		String height_max				= "";
		String weight_min				= "";
		String weight_max				= "";
		String bl_disp_charge_dtl_in_rx_yn ="";
		String man_rem_on_prn_freq_yn   = "";
		String max_length_prn_reason	="";
		String atc_allergy_alert_level	="";
		String rx_qty_by_pres_base_uom_yn	="";
		String height_min_value			= "";
		String height_max_value			= "";
		String weight_min_value			= "";
		String weight_max_value			= "";
		String height_min_digits		= "";
		String height_max_digits		= "";
		String height_dec_digits		= "";
		String weight_dec_digits		= "";
		String weight_min_digits		= "";
		String weight_max_digits		= "";
		//end
		
		//getting the External Drug Interface Controls 
		String drug_db_interface_yn			=	param_bean.getDrugDBInterface_yn(facility_id);    
		String drug_db_dosecheck_yn			=	param_bean.getDrugDBDosecheck_yn(facility_id);    
		String drug_db_duptherapy_yn		=	param_bean.getDrugDBDuptherapy_yn(facility_id);
		String drug_db_interact_check_yn	=	param_bean.getDrugDBInteract_check_yn(facility_id);  
		String drug_db_contraind_check_yn	=	param_bean.getDrugDBContraind_check_yn(facility_id);
		String drug_db_allergy_check_yn		=	param_bean.getDrugDBAllergy_check_yn(facility_id); 	
		String Drug_db_prod_id				=	param_bean.getDrugDBProductID(facility_id); 
		param_bean.clear();

		HashMap discr_values	=	presBean.getHgtWgtDtls(patient_id);
		if(discr_values.containsKey("HEIGHT_MIN_VALUE")) {	
			height_min_value	=	(String)discr_values.get("HEIGHT_MIN_VALUE")==null?"0":(String)discr_values.get("HEIGHT_MIN_VALUE");
			height_max_value	=	(String)discr_values.get("HEIGHT_MAX_VALUE")==null?"0":(String)discr_values.get("HEIGHT_MAX_VALUE");
			height_min_digits	=	(String)discr_values.get("HEIGHT_MIN_DIGITS")==null?"0":(String)discr_values.get("HEIGHT_MIN_DIGITS");
			height_max_digits	=	(String)discr_values.get("HEIGHT_MAX_DIGITS")==null?"0":(String)discr_values.get("HEIGHT_MAX_DIGITS");
			height_dec_digits	=	(String)discr_values.get("HEIGHT_DEC_DIGITS")==null?"0":(String)discr_values.get("HEIGHT_DEC_DIGITS");
		}
		if(discr_values.containsKey("WEIGHT_MIN_VALUE")) {	
			weight_min_value	=	(String)discr_values.get("WEIGHT_MIN_VALUE")==null?"0":(String)discr_values.get("WEIGHT_MIN_VALUE");
			weight_max_value	=	(String)discr_values.get("WEIGHT_MAX_VALUE")==null?"0":(String)discr_values.get("WEIGHT_MAX_VALUE");
			weight_min_digits	=	(String)discr_values.get("WEIGHT_MIN_DIGITS")==null?"0":(String)discr_values.get("WEIGHT_MIN_DIGITS");
			weight_max_digits	=	(String)discr_values.get("WEIGHT_MAX_DIGITS")==null?"0":(String)discr_values.get("WEIGHT_MAX_DIGITS");
			weight_dec_digits	=	(String)discr_values.get("WEIGHT_DEC_DIGITS")==null?"0":(String)discr_values.get("WEIGHT_DEC_DIGITS");
		}
		/*HashMap	discr_values			=	bean.getDiscreteValues();
		if(discr_values.containsKey("HEIGHT_MIN")) {	
			height_min				= (String)discr_values.get("HEIGHT_MIN");
			height_max				= (String)discr_values.get("HEIGHT_MAX");
		}

		if(discr_values.containsKey("WEIGHT_MIN")) {	
			weight_min				= (String)discr_values.get("WEIGHT_MIN");
			weight_max				= (String)discr_values.get("WEIGHT_MAX");
		}*/

		//getting the height/uom and weight/uom values from prescription bean:

		HashMap HeaderHtWtValues	=(HashMap) presBean.loadHeaderHtWtValues(facility_id,patient_id,encounter_id,patient_class);
		if( HeaderHtWtValues.size()>1 ){
			 if(HeaderHtWtValues.containsKey("HEIGHT")){
				leg_value_1		= (String) HeaderHtWtValues.get("HEIGHT");
				leg_uom_1		= (String) HeaderHtWtValues.get("HEIGHT_UOM");
				rec_date		= (String) HeaderHtWtValues.get("OBSERV_DT");	
				if(leg_value_1.equals("0")||leg_value_1.equals("0.0")){
					leg_value_1="";
				}
			 }
			if(HeaderHtWtValues.containsKey("WEIGHT")){
				leg_value_2		= (String) HeaderHtWtValues.get("WEIGHT");
				leg_uom_2		= (String) HeaderHtWtValues.get("WEIGHT_UOM");
				rec_date		= (String) HeaderHtWtValues.get("OBSERV_DT");
				if(leg_value_2.equals("0")||leg_value_2.equals("0.0")){
					leg_value_2="";
				}
			}
			bsa				= (float) presBean.loadBSA(leg_value_1,leg_value_2);
			if(leg_uom_1==null) 
				leg_uom_1= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Cms.label","ph_labels");
  
			if(leg_uom_2==null) 
				leg_uom_2= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Kgs.label ","common_labels");
			bsa_str			= (String.valueOf(bsa));
			if(!leg_value_1.equals("") && !leg_value_2.equals("")) {
				bmi_str=(Float.parseFloat(leg_value_2)/((Float.parseFloat(leg_value_1)/100)*(Float.parseFloat(leg_value_1)/100)))+"";	
				int index	=	bmi_str.indexOf(".");
				if(bmi_str.length()>=(index+3) ) {
					bmi_str	=(bmi_str.substring(0,index+3));
				}
			}
				
			if(bsa_str.equals("0.0")) 
				bsa_str= "";
			if(bsa_str.equals("0")) 
				bsa_str= "";

			if(bmi_str.equals("0.0")) 
				bmi_str= "";
			if(bmi_str.equals("0")) 
				bmi_str= "";
			if(!bsa_str.equals("") && default_dose_type_yn){ // Added for ML-MMOH-CRF-1004 - Start
				bsa_str= BigDecimal.valueOf(Double.valueOf(bsa_str)).setScale(2, BigDecimal.ROUND_UP).toString();
			} // Added for ML-MMOH-CRF-1004 - End
		}
		/*double enc_id=0;
		if(!encounter_id.equals(""))
			enc_id=Double.parseDouble(encounter_id);

		//getting visit date/time
		visit_date		=	bean.getVisitDate(enc_id,facility_id);*/

		// check Parameter values
		ArrayList param_vals	=	bean.getParameterValues();
		if(param_vals!=null && param_vals.size()!=0) {
			allow_without_diag				=	(String)param_vals.get(16);//changed get value from 0 to 16 for Bru-HIMS-CRF-265 [IN:032315]
			allow_without_wt				=	(String)param_vals.get(1);
			bl_disp_charge_dtl_in_rx_yn		=	(String)param_vals.get(2);
			max_length_prn_reason			=   (String)param_vals.get(16);
			rx_qty_by_pres_base_uom_yn		=   (String)param_vals.get(14);
			atc_allergy_alert_level			=   (String)param_vals.get(15);
		} 
		HashMap patient_details	=	bean.getPatientDetails_1(patient_id);
		if(patient_details!=null && patient_details.size()!=0) {
			patient_age	=	(String)patient_details.get("age");
		}

		//check for recorded diagnosis
		ArrayList diagnosis	=	bean.checkDiagnosis(patient_id, "", "");
		int diag_size		=	(diagnosis).size();

		//getting system date
		sys_date=(String) presBean.getSysdate();
		//getting back date of order date/time
		HashMap BackDates=(HashMap) presBean.getBackDate(sys_date);
		if(BackDates.size()>0){
			back_date			= (String) BackDates.get("BACK_DATE");
			future_date			= (String) BackDates.get("FUTURE_DATE");
		}
		//getting the last modified order remarks
		order_remarks	= (String)bean.getPresRemarks();
		ArrayList	ht_wt_uom	=	presBean.getHTWTUOM(patient_id);
		if(ht_wt_uom!=null && ht_wt_uom.size() > 1) {
			if(leg_value_1.equals("")) {
				leg_uom_1	=	(String)ht_wt_uom.get(0);	
				if( ht_wt_uom.size() > 2) {
					leg_value_1 =	(String)ht_wt_uom.get(2);	
					if(leg_value_1.equals("0")||leg_value_1.equals("0.0")){
					   leg_value_1="";
					}
				}
			}
				
			if(leg_value_2.equals("")) {
				leg_uom_2	=	(String)ht_wt_uom.get(1);	
				if( ht_wt_uom.size() > 4) {
					leg_value_2 =	(String)ht_wt_uom.get(3);
					rec_date	=	(String)ht_wt_uom.get(4);
					if(leg_value_2.equals("0")||leg_value_2.equals("0.0")){
					   leg_value_2="";
					}
				}
			}
			bsa				= (float) presBean.loadBSA(leg_value_1,leg_value_2);
			bsa_str			= (String.valueOf(bsa));
			
			if(!leg_value_1.equals("") && !leg_value_2.equals("")) {
				bmi_str=(Float.parseFloat(leg_value_2)/((Float.parseFloat(leg_value_1)/100)*(Float.parseFloat(leg_value_1)/100)))+"";	
				int index	=	bmi_str.indexOf(".");
				if(bmi_str.length()>=(index+3) ) {
					bmi_str	=(bmi_str.substring(0,index+3));
				}
			}
			
			if(bsa_str.equals("0.0")) 
				bsa_str= "";
			if(bsa_str.equals("0")) 
				bsa_str= "";

			if(bmi_str.equals("0.0"))
				bmi_str= "";
			if(bsa_str.equals("0")) 
				bsa_str= "";
			if(!bsa_str.equals("") && default_dose_type_yn){ // Added for ML-MMOH-CRF-1004 - Start
				bsa_str= BigDecimal.valueOf(Double.valueOf(bsa_str)).setScale(2, BigDecimal.ROUND_UP).toString();
			} // Added for ML-MMOH-CRF-1004 - End
		}
		HashMap appl_orders	=	bean.getApplicableOrders(facility_id);
		if(appl_orders != null){
			man_rem_on_prn_freq_yn =(String)appl_orders.get("MANDATORY_REM_ON_PRN_FREQ_YN")==null?"N":(String)appl_orders.get("MANDATORY_REM_ON_PRN_FREQ_YN"); 
		}
		dir_bean.setExcludeADRAllergyAlert(bean.getExcludeADRAllergyAlert());//Added for HSA-SCF-0011 [IN:042444]
%>
		<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
			<form name="dir_disp_header_form" id="dir_disp_header_form">
				<table cellpadding=0 cellspacing=0 width="100%" align="center" border="0" >
					<th colspan='20'  nowrap><%=pat_details%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=pract_name_str%></th>
					<tr nowrap>
						<td class="label"  ><fmt:message key="Common.height.label" bundle="${common_labels}"/> </td>
						<td class="label" ><input type="text" name="height" id="height" size="5"  maxlength="8" value="<%=leg_value_1%>" class="NUMBER" onBlur="checkDecimal(this,'<%=height_max_digits%>','<%=height_min_digits%>','<%=height_dec_digits%>');" onchange="validateBSA();" onKeyPress="return(ChkNumberInput(this,event,'2'))" oncopy="return false" onpaste="return false" title="<%=rec_date%>"></td>
						<!-- added onKeyPress="return(ChkNumberInput(this,event,'2'))" and oncopy="return false" onpaste="return false" for [IN:037181]-->
						<td class="label" ><b><%=leg_uom_1%></b></td>
						<td class="label"  ><fmt:message key="Common.weight.label" bundle="${common_labels}"/> </td>
						<td class="label" ><input type="text" name="weight" id="weight" size="5"  maxlength="8" value="<%=leg_value_2%>" onChange="validateBSA();" onBlur="checkDecimal(this,'<%=weight_max_digits%>','<%=weight_min_digits%>','<%=weight_dec_digits%>');" class="NUMBER" onKeyPress="return(ChkNumberInput(this,event,'2'))" oncopy="return false" onpaste="return false" title="<%=rec_date%>"></td>
						<!-- added onKeyPress="return(ChkNumberInput(this,event,'2'))" and oncopy="return false" onpaste="return false" for [IN:037181]-->
						<td class="label"  ><b><%=leg_uom_2%></b></td>
					<%if(default_dose_type_yn){ // if else added for Added for ML-MMOH-CRF-1004 - Start %>
					    <td class="label"  ><fmt:message key="Common.BSA.label" bundle="${common_labels}"/> </td>
						<td class="label" ><label id="bsa_lbl"><b><%=bsa_str%></b></label><input type="hidden" name="bsa" id="bsa" size="5"  maxlength="5" value="<%=bsa_str%>"> m&sup2;</td>
						<td class="label" ><fmt:message key="Common.BMI.label" bundle="${common_labels}"/>  </td>
						<td class="label" ><label id="bmi_lbl"><b><%=bmi_str%></b></label><input type="hidden" name="bmi" id="bmi" size="5"  maxlength="5" value="<%=bmi_str%>"> kg/m&sup2;</td>
					 <%} else{ %>
						<td class="label"  ><fmt:message key="Common.BSA.label" bundle="${common_labels}"/> </td>
						<td class="label" ><label id="bsa_lbl"><b><%=bsa_str%></b></label><input type="hidden" name="bsa" id="bsa" size="5"  maxlength="5" value="<%=bsa_str%>"></td>
						<td class="label" ><fmt:message key="Common.BMI.label" bundle="${common_labels}"/>  </td>
						<td class="label" ><label id="bmi_lbl"><b><%=bmi_str%></b></label><input type="hidden" name="bmi" id="bmi" size="5"  maxlength="5" value="<%=bmi_str%>"></td>
						<%} // Added for ML-MMOH-CRF-1004 - End %>
						<td class="label"  ><a href="javascript:callOrderRemarks();" title="Clinical Comments"><fmt:message key="Common.ClinicalComments.label" bundle="${common_labels}"/>  </a>	
						<!-- code added for JD-CRF-0156[IN041737]--Start -->
<%		
						if(dir_bean.toDisplayFinancialDtl(disp_locn_code) && !encounter_id.equals("") ){	   
							ArrayList encounterId_details	 = dir_bean.getEpisodeDetails(patient_id, encounter_id);			 
							if(encounterId_details.size()>0){
								String 	latest_episode_id		 = (String)encounterId_details.get(0);					
								String  latest_patient_class	 = (String)encounterId_details.get(1);							
								String visit_id="";
								if(latest_patient_class.equals("OP") &&  encounter_id.length()>4)
									visit_id = encounter_id.substring(encounter_id.length()-4, encounter_id.length());
%>	     
								&nbsp;&nbsp;&nbsp;<img src="../../ePH/images/dollar.png" style="cursor:pointer" height="15" title="Current Encounter Financial Details" onClick="callFinancialDetailScreen('<%=patient_id%>','<%=latest_episode_id%>','<%=visit_id%>');" >	
<% 
								if(!dir_bean.getPolicyExp(encounter_id, latest_patient_class,patient_id)){  
%>
								<font style="font-size:9;" id="policy_exp"><fmt:message key="ePH.PolicyExpired.label" bundle="${ph_labels}"/></font>
								<script>
									XX1=new blinkText("XX1",'policy_exp',500,500,'darkred','#ff0000');
								</script>
<%
							}
						}
					}
%>	<!-- code added for JD-CRF-0156[IN041737]-- End -->
						<label onClick="javascript:callDiagText('<%=patient_id%>','Header');" style="visibility:hidden" id="diag_text" title="Diag Text"><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>  </label></td>						
						<td class="label" >
<%       
						if(adr_count >0){
%>   
							 <a href="javascript:callADRdetails('<%=patient_id%>');" title="Clinical Comments"><fmt:message key="ePH.ADR.label" bundle="${ph_labels}"/></a>
<%        
						}
%>		
						</td>
						<td class="label"  ><fmt:message key="ePH.OrderDate/Time.label" bundle="${ph_labels}"/>   </td>
						<td class="label" ><input type="text" name="sys_date" id="sys_date" size="15"  maxlength="17" value="<%=com.ehis.util.DateUtils.convertDate(dir_bean.getTodaysDate(),"DMYHM","en",locale)%>" onBlur="chkBackFutureOrderDate(this);"><img SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="showCalendar('sys_date',null,'hh:mm');document.dir_disp_header_form.sys_date.focus();return false;" > 
						</td>
					</tr>
				</table>
		
				<input type="hidden" name="patient_id" id="patient_id"					value="<%=patient_id%>">
				<input type="hidden" name="encounter_id" id="encounter_id"				value="<%=encounter_id%>">
				<input type="hidden" name="pract_name" id="pract_name"					value="<%=pract_name%>">
				<input type="hidden" name="height_unit" id="height_unit"					value="<%=leg_uom_1%>">
				<input type="hidden" name="weight_unit" id="weight_unit"					value="<%=leg_uom_2%>">
				<input type="hidden" name="bean_id" id="bean_id"						value="<%=dir_bean_id%>">
				<input type="hidden" name="bean_name" id="bean_name"					value="<%=dir_bean_name %>">
				<input type="hidden" name="mode" id="mode"						value="<%=mode%>">
				<input type="hidden" name="calculated_date" id="calculated_date"				value="<%=calculated_date%>">
				<input type="hidden" name="ref_sys_date" id="ref_sys_date"				value="<%=sys_date%>">		
				<input type="hidden" name="location_type" id="location_type"				value="C">
				<input type="hidden" name="location_code" id="location_code"				value="<%=ord_locn%>">		
				<input type="hidden" name="patient_class" id="patient_class"				value="<%=patient_class%>">		
				<input type="hidden" name="order_remarks" id="order_remarks"				value="<%=order_remarks%>">		
				<input type="hidden" name="source_type" id="source_type"					value="C">
				<input type="hidden" name="source_code" id="source_code"					value="<%=ord_locn%>">		
				<input type="hidden" name="facility_id" id="facility_id"					value="<%=facility_id%>">	
				<input type="hidden" name="back_date" id="back_date"					value="<%=back_date%>"	>
				<input type="hidden" name="future_date" id="future_date"					value="<%=future_date%>">
				<input type="hidden" name="licence" id="licence"						value="<%=licence%>"		>
				<input type="hidden" name="servide_code" id="servide_code"				value="<%=servide_code%>"	>
				<input type="hidden" name="service_search_yn" id="service_search_yn"			value="<%=service_search_yn%>" >		
				<input type="hidden" name="QueryString" id="QueryString"					value="<%=request.getQueryString()%>">		
				<input type="hidden" name="allow_without_wt" id="allow_without_wt"			value="<%=allow_without_wt%>">
				<input type="hidden" name="allow_without_diag" id="allow_without_diag"			value="<%=allow_without_diag%>">
				<input type="hidden" name="patient_age" id="patient_age"					value="<%=patient_age%>">
				<input type="hidden" name="diag_size" id="diag_size"					value="<%=diag_size%>"> 
				<input type="hidden" name="diag_text_size" id="diag_text_size"				value="<%=(bean.getDiagText()).size()%>">
				<input type="hidden" name="sliding_scale" id="sliding_scale"				value="">
				<input type="hidden" name="allergic_yn1" id="allergic_yn1"				value="N"> 
				<input type="hidden" name="height_min" id="height_min"					value="<%=height_min%>"> 
				<input type="hidden" name="height_max" id="height_max"					value="<%=height_max%>"> 
				<input type="hidden" name="weight_min" id="weight_min"					value="<%=weight_min%>"> 
				<input type="hidden" name="weight_max" id="weight_max"					value="<%=weight_max%>">
				<input type="hidden" name="take_home_medication" id="take_home_medication"		value="N">
				<input type="hidden" name="priority" id="priority"					value="R">
				<input type="hidden" name="pract_id" id="pract_id"					value="<%=practioner_id%>">
				<input type="hidden" name="patient_name" id="patient_name"				value="<%=patient_name%>">
				<!--External Drug Interface Controls -->	   
				<input type="hidden" name="drug_db_interface_yn" id="drug_db_interface_yn"        value="<%=drug_db_interface_yn%>"> 
				<input type="hidden" name="drug_db_dosecheck_yn" id="drug_db_dosecheck_yn"        value="<%=drug_db_dosecheck_yn%>"> 
				<input type="hidden" name="drug_db_duptherapy_yn" id="drug_db_duptherapy_yn"       value="<%=drug_db_duptherapy_yn%>"> 
				<input type="hidden" name="drug_db_interact_check_yn" id="drug_db_interact_check_yn"   value="<%=drug_db_interact_check_yn%>">
				<input type="hidden" name="drug_db_contraind_check_yn" id="drug_db_contraind_check_yn"  value="<%=drug_db_contraind_check_yn%>">
				<input type="hidden" name="drug_db_allergy_check_yn" id="drug_db_allergy_check_yn"    value="<%=drug_db_allergy_check_yn%>">
				<input type="hidden" name="Drug_db_prod_id" id="Drug_db_prod_id"			    value="<%=Drug_db_prod_id%>">	
				<!--ends here  -->
				<input type="hidden" name="language_id" id="language_id"				    value="<%=locale%>">
				<input type="hidden" name="bl_install_yn" id="bl_install_yn"			    value="<%=bl_install_yn%>">
				<input type="hidden" name="bl_disp_charge_dtl_in_rx_yn" id="bl_disp_charge_dtl_in_rx_yn" value="<%=bl_disp_charge_dtl_in_rx_yn%>">
				<input type="hidden" name="adr_count" id="adr_count"                   value="<%=adr_count%>" >
				<input type="hidden" name="date_of_birth" id="date_of_birth" value="<%=date_of_birth%>">
				<input type="hidden" name="gender" id="gender" value="<%=gender%>">
				<input type="hidden" name="man_rem_on_prn_freq_yn" id="man_rem_on_prn_freq_yn" value="<%=man_rem_on_prn_freq_yn%>">
				<input type="hidden" name="max_length_prn_reason" id="max_length_prn_reason" value="<%=max_length_prn_reason%>">
				<input type="hidden" name="atc_allergy_alert_level" id="atc_allergy_alert_level" value="<%=atc_allergy_alert_level%>">
				<input type="hidden" name="rx_qty_by_pres_base_uom_yn" id="rx_qty_by_pres_base_uom_yn" value="<%=rx_qty_by_pres_base_uom_yn%>">
				<input type="hidden" name="weight_rec_appl_age_group_check_flag" id="weight_rec_appl_age_group_check_flag" value=""> <!-- added for Bru-HIMS-CRF-079 IN[029945]  -->
				<input type="hidden" name="wt_mand_yn" id="wt_mand_yn" value=""> <!-- added for Bru-HIMS-CRF-079 IN[029945]  -->
				<input type="hidden" name="ht_mand_yn" id="ht_mand_yn" value=""> <!--  added for Bru-HIMS-CRF-079 IN[029945]  -->
				<input type="hidden" name="height_min_value" id="height_min_value" value="<%=height_min_value%>"> 
				<input type="hidden" name="height_max_value" id="height_max_value" value="<%=height_max_value%>"> 
				<input type="hidden" name="weight_min_value" id="weight_min_value" value="<%=weight_min_value%>"> 
				<input type="hidden" name="weight_max_value" id="weight_max_value" value="<%=weight_max_value%>">
				<input type="hidden" name="height_min_digits" id="height_min_digits" value="<%=height_min_digits%>"> 
				<input type="hidden" name="height_max_digits" id="height_max_digits" value="<%=height_max_digits%>"> 
				<input type="hidden" name="weight_min_digits" id="weight_min_digits" value="<%=weight_min_digits%>"> 
				<input type="hidden" name="weight_max_digits" id="weight_max_digits" value="<%=weight_max_digits%>">
			</form>
<%
			if(back_date.equals("0") && future_date.equals("0") ){
%>
				<script>
					document.dir_disp_header_form.sys_date.disabled=true;
				</script>
<%
			}
			else{
%>
				<script>
					document.dir_disp_header_form.sys_date.disabled=false;
				</script>
<%
			}
%>
			<script>
			    setTimeout("loadOtherFrames();",1500);
			</script>
		</body>
<%
		putObjectInBean(bean_id,bean,request);
		putObjectInBean(dir_bean_id,dir_bean,request); 
		putObjectInBean(drug_bean_id,drug_bean,request);
		putObjectInBean(presBean_id,presBean,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>
</html>

