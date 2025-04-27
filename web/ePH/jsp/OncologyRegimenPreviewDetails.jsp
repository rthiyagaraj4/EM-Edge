<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*,eOR.*,eOR.Common.* , ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<%
    request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String locale			= (String)session.getAttribute("LOCALE");
	
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String patient_id			= request.getParameter("patient_id");
	String encounter_id			= request.getParameter("encounter_id");
	String locn_code			= request.getParameter("locn_code");
	String pract_name			= request.getParameter("pract_name") ;	
	pract_name					= java.net.URLDecoder.decode(pract_name,"UTF-8");	
	String bean_id				= "@OncologyRegimenBean"+patient_id+encounter_id;
	String bean_name			= "ePH.OncologyRegimenBean";
	OncologyRegimenBean bean	= (OncologyRegimenBean)getBeanObject(bean_id, bean_name, request);
	String or_bean_name			="eOR.OrderEntryBean";
	String or_bean_id			="@orderentrybean"+patient_id+encounter_id;
	String display_auth_rule ="visibility:hidden", color_auth_rule = "RED", ord_auth_reqd_yn = "", ord_authorized_yn = "", strAuthStatus="-" ;  //added for ML-MMOH-CRF-0343
	OrderEntryBean orbean = (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
	eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) orbean.getOrderEntryRecordBean();

	String pres_bean_id_1			= "@PrescriptionBean_1"+patient_id+encounter_id;
	String pres_bean_name_1		= "ePH.PrescriptionBean_1";
	PrescriptionBean_1 pres_bean_1 = (PrescriptionBean_1)getBeanObject( pres_bean_id_1, pres_bean_name_1, request ) ;	

	String pres_bean_id			= "@PrescriptionBean"+patient_id+encounter_id;
	String pres_bean_name		= "ePH.PrescriptionBean";
	PrescriptionBean pres_bean = (PrescriptionBean)getBeanObject( pres_bean_id, pres_bean_name, request ) ;	

	String patient_name					= "";
	String patient_class                = "";
	String sex							= "";
	String age							= "";
	String strength_per_value_pres_uom	= "";
	String strength_per_pres_uom		= "";
	String ing_order_qty				= "";
	String drugindication_remarks		= "";//added for MMS Adhoc Testing
	//String dosage_type                  = "";
	String pres_remarks					= "";
	String existing_order_id            = "";
	int    size                         = 0;
	int    count                        = 0;
	//int    count1                       = 0;
	 //ML-MMOH-CRF-0345 - start
	String cycle_freq_yn				= "";
	String cycle_checked_yn			= "";//ML-MMOH-CRF-1004
	String no_of_cycle				= "";
	String srl_no					= "";
	String cycle_start_date			= "";
	String cycle_end_date			= "";
	String mfr_yn					= "N";//ML-MMOH-CRF-1014
	HashMap hm = bean.getCycleDetails();
	HashMap hm_details = null;
	ArrayList time_list = new ArrayList();
	ArrayList time = new ArrayList();//added for ML-MMOH-CRF-1224
	 //ML-MMOH-CRF-0345 - end
	ArrayList pat_details				= bean.getPatientDetails(patient_id);
	String ord_date						=bean.getOrderDate();
	String Display="";//added for ml-mmoh-crf-1224
	String Display1="";//added for ml-mmoh-crf-1224
	String sch_start_date  = "";//added for ml-mmoh-crf-1224
	String sch_end_date	= "";//added for ml-mmoh-crf-1224
	String disp_route_shadule=request.getParameter("site_spec_YN");//ADDED FOR ML-MMOH-CRF-1224
    	String preview_auth_status_yn = pres_bean_1.getPreviewAuthStatus(); //added for ML-MMOH-CRF-0343
	if( "Y".equals(preview_auth_status_yn)) {   // if condition added for ML-MMOH-CRF-0343
		display_auth_rule = "visibility:visible";   
	}
	if (pat_details.size() != 0) {
		patient_name			= (String)pat_details.get(0);
		sex						= (String)pat_details.get(1);
		age						= (String)pat_details.get(2);
	}
    ArrayList drugList1 = bean.getDrugDetails(); 
	if (drugList1!=null && drugList1.size() != 0) {
		 for(int i=0;i<drugList1.size();i++) {
			HashMap drugDetails1 = (HashMap)drugList1.get(i);
			patient_class=(String)drugDetails1.get("PATIENT_CLASS");
			if(patient_class!=null && !patient_class.equals(""))
				break;
		 }
	}

	String locn_desc			=   bean.getLocationDesc(patient_class, locn_code);
	String called_from			=	orbean.getCalledFromFunction();
	String uom="";
	
	if(sex.equalsIgnoreCase("female"))
		sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
	else if(sex.equalsIgnoreCase("male"))
		sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
	else if(sex.equalsIgnoreCase("unknown"))
		sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
%>

<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../js/OncologyRegimen.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<script language="javascript" src="../js/OncologyRegimenMFR.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<!-- ML-MMOH-CRF-1014-->
	</head>

	<!-- <body> -->
	<body onMouseDown="" onKeyDown="lockKey()">
		<form name="OncologyPreviewDetails" id="OncologyPreviewDetails">

			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				<th colspan="4"><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></th>
				<tr>
					<td class="label" width="20%"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/> :&nbsp;</td>
					<td class="data" width="30%"><%= patient_name %></td>
					<td class="label" width="20%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/> :&nbsp;</td>
					<td class="data" width="30%"><%= patient_id %></td>
				</tr>
				<tr>
					<td class="label" width="20%"><fmt:message key="Common.age.label" bundle="${common_labels}"/> :&nbsp;</td>
					<td class="data" width="30%"><%= age %></td>
					<td class="label" width="20%"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/> :&nbsp;</td>
					<td class="data" width="30%"><%= encounter_id %></td>
				</tr>
				<tr>
					<td class="label" width="20%"><fmt:message key="Common.gender.label" bundle="${common_labels}"/> :&nbsp;</td>
					<td class="data" width="30%"><%= sex %></td>
					<td class="label" width="20%"><fmt:message key="Common.OrderDate.label" bundle="${common_labels}"/> :&nbsp;</td>
					<td class="data" width="30%"><%= ord_date %></td>
				</tr>
				<tr>
					<td class="label" width="20%"><fmt:message key="Common.Location.label" bundle="${common_labels}"/> :&nbsp;</td>
					<td class="data" width="30%"><%= locn_desc %></td>
					<td class="label" width="20%"><fmt:message key="Common.PrescribedBy.label" bundle="${common_labels}"/>:&nbsp;</td>
					<td class="data" width="30%"><%= pract_name %></td>
				</tr>
			</table>
<%
			ArrayList drugList = bean.getDrugDetails(); 
			if (drugList!=null && drugList.size() != 0) {
%>
				<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
					<tr>
						<th  width="20%"><fmt:message key="ePH.Drug/FluidDetails.label" bundle="${ph_labels}"/></th>
						<th  width="10%"><fmt:message key="Common.Dosage.label" bundle="${common_labels}"/></th>
						<th  width="10%"><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></th>
						<th  width="18%"><fmt:message key="ePH.OrderQuantity.label" bundle="${ph_labels}"/></th>
						<th  width="16%">&nbsp;&nbsp;<fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></th>
						<th  width="16%">&nbsp;&nbsp;<fmt:message key="Common.enddate.label" bundle="${common_labels}"/></th>
						<th  width="10%" style='<%=display_auth_rule%>;'>&nbsp;&nbsp;<fmt:message key="Common.status.label" bundle="${common_labels}"/></th> <!-- Added for ML-MMOH-CRF-0343 -->
					<%if(disp_route_shadule.equals("Y")){//added for ml-mmoh-crf-1224%>					   
					   <th  width="18%"><fmt:message key="ePH.Route.label" bundle="${ph_labels}"/></th>
					    <th width="18%"><fmt:message key="ePH.ScheduleDateTime.label" bundle="${ph_labels}"/></th>
					<%}%>
					</tr>
<%
					//HashMap doseUOM=bean.getDosageUOMS();
					 for(int i=0;i<drugList.size();i++) {
						HashMap drugDetails = (HashMap)drugList.get(i);
						/*if (doseUOM.containsKey( (String)drugDetails.get("DRUG_CODE"))){
							uom=(String)doseUOM.get((String)drugDetails.get("DRUG_CODE"));
						}	*/

						if(drugDetails!=null && drugDetails.size() > 0){
							
							String order_qty		="";
							String freq_nature=(String)drugDetails.get("FREQ_NATURE")==null?"F":(String)drugDetails.get("FREQ_NATURE");
							String durn_value=(String)drugDetails.get("DURN_VALUE")==null?"":(String)drugDetails.get("DURN_VALUE");
							String amend_stock_value=(String)drugDetails.get("amend_stock_value");
							String repeat_durn_type=(String)drugDetails.get("REPEAT_DURN_TYPE")==null?"D":(String)drugDetails.get("REPEAT_DURN_TYPE");
							String amend_durn_value = (String)drugDetails.get("amend_durn_value")==null?"":(String)drugDetails.get("amend_durn_value");
							String infusion_over      =(String)drugDetails.get("amend_infusion_period_value")==null?"1":(String)drugDetails.get("amend_infusion_period_value");
							String amend_durn_unit     =(String)drugDetails.get("amend_durn_unit")==null?"":(String)drugDetails.get("amend_durn_unit");
							String fract_dose_round_up_yn     =(String)drugDetails.get("FRACT_DOSE_ROUND_UP_YN")==null?"":(String)drugDetails.get("FRACT_DOSE_ROUND_UP_YN");
							String interval_value     =(String)drugDetails.get("INTERVAL_VALUE")==null?"1":(String)drugDetails.get("INTERVAL_VALUE");
							String freq_chng_durn_desc = (String)drugDetails.get("freq_chng_durn_desc");
							drugindication_remarks=	(String)drugDetails.get("DRUG_INDICATION")==null?"":(String)drugDetails.get("DRUG_INDICATION");//added for MMS Adhoc Testing
							mfr_yn = (String)drugDetails.get("mfr_yn")==null?"N":(String)drugDetails.get("mfr_yn");//ML-MMOH-CRF-1014 - start
							if(mfr_yn.equals("Y")){
								freq_chng_durn_desc = "H";
								amend_durn_unit = "H";
								amend_durn_value = "1";
							}//ML-MMOH-CRF-1014 - end
							if(!freq_chng_durn_desc.equals(amend_durn_unit)){
								amend_durn_value = (String)bean.getFreqDurnConvValue(freq_chng_durn_desc,amend_durn_value,amend_durn_unit);
							}
							strength_per_pres_uom=(String)drugDetails.get("STRENGTH_PER_PRES_UOM")==null?"":(String)drugDetails.get("STRENGTH_PER_PRES_UOM");
							strength_per_value_pres_uom	=(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM")==null?"":(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");
							String amend_repeat_value=(String)drugDetails.get("amend_repeat_value")==null?"":(String)drugDetails.get("amend_repeat_value");

							if(drugDetails.get("DOSAGE_TYPE").toString().equals("S")){
								uom = (String)drugDetails.get("STRENGTH_UOM_DESC")==null?"":(String)drugDetails.get("STRENGTH_UOM_DESC");
							}
							else{
								uom = (String)drugDetails.get("PRES_BASE_UOM_DESC")==null?"":(String)drugDetails.get("PRES_BASE_UOM_DESC");
							}

							String drug_code		= (String)drugDetails.get("DRUG_CODE");
							String ocurrance_num			= (String)drugDetails.get("OCURRANCE_NUM")==null?"":(String)drugDetails.get("OCURRANCE_NUM");
							if((called_from!=null && called_from.equals("AMEND_ORDER")) )
								ocurrance_num = (i+1)+"";
							// ML-MMOH-CRF-0345- start
							srl_no = (String)drugDetails.get("SRL_NO");
							if(hm!=null && hm.size()>0){
							  hm_details = (HashMap)hm.get(drug_code+srl_no);//
							}// ML-MMOH-CRF-0345- end

						//	dosage_type				= (String)drugDetails.get("DOSAGE_TYPE");
							cycle_freq_yn          = (String)drugDetails.get("CYCLE_FREQ_YN")==null?"":(String)drugDetails.get("CYCLE_FREQ_YN");// ML-MMOH-CRF-0345
							no_of_cycle     = (String)drugDetails.get("NO_OF_CYCLE")==null?"0":(String)drugDetails.get("NO_OF_CYCLE");// ML-MMOH-CRF-0345
						//Drug Remarks	
							Hashtable template		=	null;
							pres_remarks			= "";
							String	catalog_code	= drug_code+ocurrance_num; //added +ocurrance_num for SRR20056-SCF-7085 IN26862 "Drug"+
							String	row_value		= (catalog_code+"_"+"0");
							int seq_num1            =0;
							ArrayList seq_num		=	(ArrayList)orderEntryRecordBean.getOrderFormats(catalog_code,row_value); //added removed +ocurrance_num for SRR20056-SCF-7085 IN26862
							//ArrayList seq_num		=	(ArrayList)orderEntryRecordBean.getOrderFormats((drug_code+ocurrance_num),(drug_code+ocurrance_num)+"_0");

							if(seq_num==null){
								seq_num			=	new ArrayList();
							}				
							for(int p=0; p<seq_num.size(); p++) {
								seq_num1		= ((Integer.parseInt((String)seq_num.get(p))) );
								template	    = (java.util.Hashtable)orderEntryRecordBean.getOrderFormats(catalog_code, (catalog_code+seq_num1)); //removed +ocurrance_num for SRR20056-SCF-7085 IN26862
								if(template.get("field_values")!=null && !(((String)template.get("field_values")).trim()).equals("")){
									if(((String) template.get("field_mnemonic")).equals("PRES_REMARKS")) {
										pres_remarks = pres_remarks +"<br>"+template.get("label_text")+": "+pres_bean.getPrescriptionRemarks((String) template.get("field_values"));
									} 
									else {
										pres_remarks = pres_remarks +"<br>"+template.get("label_text")+": "+(String) template.get("field_values");
									}	
								}
							}
						  /*--------------------------------------------*/
							HashMap record_flag				=null;
						//	HashMap fluids					=null;
							HashMap Existingrecord			=null;			
							existing_order_id				= ""; 
							if(called_from!=null && called_from.equals("AMEND_ORDER")){   				 
							 
								ArrayList ExistingCYTORecords = bean.getExistingCYTORecords();							
								size                       = ExistingCYTORecords.size();
								record_flag                = (HashMap) ExistingCYTORecords.get(size-2);
								Existingrecord				= (HashMap) ExistingCYTORecords.get(count);					
								existing_order_id          = (String)Existingrecord.get("ORDER_ID");		
								if(record_flag.containsKey(existing_order_id)) {                    
									count=count+1;										
								}
								else{
								// count1=count;					 
								} 				 
								count=count+1;
							}

							if(pres_remarks.equals("")) {
								ArrayList drug_remarks	=	bean.getPrescribedRemarks(existing_order_id,"1");
					
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
							}

							String order_uom	= bean.getStockUOM(drug_code);			
							String pack_size	= bean.getPackSize(drug_code);	
							float ing_unit_qty	= Float.parseFloat((String)drugDetails.get("dose"));
							if(drugDetails.get("DOSAGE_TYPE") !=null){
							   if(drugDetails.get("DOSAGE_TYPE").toString().equals("S")) {				
									strength_per_value_pres_uom	=	(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");	
									strength_per_pres_uom		=	(String)drugDetails.get("STRENGTH_PER_PRES_UOM");
									float in_tot_qty	= 0.0f;	

									if(fract_dose_round_up_yn.equals("Y")){
										in_tot_qty	=new Double(	Math.ceil(ing_unit_qty/Float.parseFloat(strength_per_pres_uom))).floatValue() * Float.parseFloat(strength_per_value_pres_uom);
									}
									else{
										in_tot_qty	=new Double(	Math.ceil(ing_unit_qty/Float.parseFloat(strength_per_pres_uom) * Float.parseFloat(strength_per_value_pres_uom))).floatValue();
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

									ing_order_qty=in_tot_qty+"";
									ing_order_qty=(Math.ceil(Float.parseFloat(ing_order_qty)/Float.parseFloat(pack_size)))+"";
								}
								else{
									String qty_unit				= (String)drugDetails.get("QTY_DESC_CODE");
									String ing_order_uom		= (String)drugDetails.get("PRES_BASE_UOM");
									String eqvl_value			=  bean.getConvFactor(ing_order_uom,qty_unit);
									if(eqvl_value.equals(""))	eqvl_value	=	"1";
									
									float in_tot_qty	= 0.0f;
									if(fract_dose_round_up_yn.equals("Y")){
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

								   if(!fract_dose_round_up_yn.equals("Y")){
									in_tot_qty	=   new Double(Math.ceil((in_tot_qty)/Float.parseFloat(pack_size))).floatValue();
								}	
								ing_order_qty=in_tot_qty+"";
							}
							ing_order_qty=new Float(ing_order_qty).intValue()+"";
						}	
							color_auth_rule ="BLACK"; // Added for ML-MMOH-CRF-0343
 							strAuthStatus="-";     // Added for ML-MMOH-CRF-0343
							if( "Y".equals(preview_auth_status_yn)) {
								ord_auth_reqd_yn = (String) drugDetails.get("ORD_AUTH_REQD_YN");  //added for ML-MMOH-CRF-0343 -start
								ord_authorized_yn			= (String) drugDetails.get("ORD_AUTHORIZED_YN");
								if(ord_auth_reqd_yn.equals("Y")){
									color_auth_rule = "color:red";
									strAuthStatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.AuthorizationReqd..label", "common_labels");
									if(ord_authorized_yn.equals("Y")){
										color_auth_rule = "color:green";
										strAuthStatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Authorized.label", "common_labels");
									}
								} 
							}//added for ML-MMOH-CRF-0343 -end
%>
						<tr><td colspan="6">&nbsp;</tr>
						<tr> 
						<%

					if(cycle_freq_yn.equals("Y")){// ML-MMOH-CRF-0345 - start
					for(int j=0;j<Integer.parseInt(no_of_cycle);j++){
						cycle_checked_yn = "";//ML-MMOH-CRF-1004
						 Display="";//added for ml-mmoh-crf-1224
						 Display1="";//added for ml-mmoh-crf-1224
						if(hm_details!=null){
							time_list	= (ArrayList)hm_details.get("cycle_"+j);
							time		= (ArrayList)time_list.get(0);//added for ml-mmoh-crf-1224
							//day_list	= (String)time_list.get(1);
							cycle_start_date  = (String)time_list.get(3);
							cycle_end_date	= (String)time_list.get(4);
							cycle_checked_yn = (String)time_list.get(5);//ML-MMOH-CRF-1004
							String[] arrOfStr = cycle_start_date.split(" ");//added for ml-mmoh-crf-1224
							String[] arrOfStr1 = cycle_end_date.split(" ");//added for ml-mmoh-crf-1224
							sch_start_date  = arrOfStr[0];//added for ml-mmoh-crf-1224
							sch_end_date	= arrOfStr1[0];//added for ml-mmoh-crf-1224
							//added for ml-mmoh-crf-1224 start
							for(int chk=0;chk<time.size();chk++){
								String value=(String)time.get(chk);
								
								int valueInt=Integer.parseInt(value.replaceAll(":",""));
								if(valueInt>Integer.parseInt(arrOfStr[1].replaceAll(":",""))){
								
									if(chk!=0  && Display!=""){
										Display=Display+",";
							}
									Display=Display+value;
							}
								
						}
							for(int chk=0;chk<time.size();chk++){
								String value=(String)time.get(chk);
								
								int valueInt=Integer.parseInt(value.replaceAll(":",""));
								if(valueInt<Integer.parseInt(arrOfStr[1].replaceAll(":",""))){
									
									if(  chk!=0  && Display1!=""){
									
										Display1=Display1+",";
							}
									Display1=Display1+value;
							}
								
						}
						}
						//added for ml-mmoh-crf-1224 end
						
						
						if(cycle_checked_yn==null)//ML-MMOH-CRF-1004
							cycle_checked_yn = "";
						String amend_fluid_name			= (String)drugDetails.get("amend_fluid_name");
						//added for ML-MMOH-CRF-1224 START
						String style="";
						if(amend_fluid_name!=null && !amend_fluid_name.equals("") && disp_route_shadule.equals("Y")) {
							style="";
						}
						else{
							if(disp_route_shadule.equals("Y")){
							style="border-bottom: 1px solid black;border-collapse: collapse;";
							}
						}
						//ADDED FOR ML-MMOH-CRF-1224 END
						if(cycle_checked_yn.equals("Y")){
						// ML-MMOH-CRF-0345 - end
						%>
							<td width="30%" class="label" style='<%=style%>'><font size="1"><%=(drugDetails.get("DRUG_DESC")==null ? "":drugDetails.get("DRUG_DESC"))%></font></td>
							<td width="10%" class="label" style='<%=style%>'><font size="1">&nbsp;<%=(drugDetails.get("dose")==null ? "":drugDetails.get("dose")+"&nbsp;"+uom)%>&nbsp;</font></td>
							<td width="10%" class="label" style='<%=style%>'><font size="1">&nbsp;<%=(drugDetails.get("amend_frequency_desc")==null ? "":drugDetails.get("amend_frequency_desc"))%></font></td>
							<td width="18%" class="label" style='<%=style%>'><font size="1">&nbsp;<%=ing_order_qty%>&nbsp;&nbsp;<%=order_uom%></font></td>
							<td width="16%" class="label" style='<%=style%>'><font size="1"><%=(cycle_start_date==null ? "":DateUtils.convertDate(cycle_start_date, "DMYHM","en",locale)) %></font></td>
							<td width="16%" class="label" style='<%=style%>'><font size="1"><%=(cycle_end_date==null ? "":DateUtils.convertDate(cycle_end_date, "DMYHM","en",locale))%></font></td>
						    	<td class="label" align='center' style='<%=display_auth_rule%>;<%=style%>'> <!-- added for ML-MMOH-CRF-0343 -->
							<label id='lbl_authorize' style='<%=display_auth_rule%>;<%=color_auth_rule%>'><%=strAuthStatus%></label>
							</td>
							<%if(disp_route_shadule.equals("Y")){//added for ml-mmoh-crf-1224%>
							<!--added for ml-mmoh-crf-1224 start-->
							<td width="10%" class="label" style='<%=style%>' ><font size="1"><%=(drugDetails.get("ROUTE_DESC")==null ? "":drugDetails.get("ROUTE_DESC"))%></font></td>
							<td width="10%" class="label"  style='<%=style%>'><font size="1"><%if(Display!=""){%><%=sch_start_date %>&nbsp;<%=Display%><%} %></br><%if(Display1!=""){%><%=sch_end_date%>&nbsp;<%=Display1%><%} %></font></td>
							<%}%>
							<!--added for ml-mmoh-crf-1224 end-->
<%System.err.println("no_of_cycle==========334===>");
				//	}
%>
						</tr>
<%			
						
						if(amend_fluid_name!=null && !amend_fluid_name.equals("")) {
							String fluid_code=(String)drugDetails.get("amend_fluid_code");
							String fluid_dosage_uom=(String)drugDetails.get("amend_stock_uom_val");
							pack_size	= bean.getPackSize(fluid_code);			
							order_uom	= bean.getStockUOM(fluid_code);	
							order_qty		= (Math.ceil((Float.parseFloat(amend_stock_value)) / Float.parseFloat(pack_size)))+""; 
							mfr_yn = (String)(drugDetails.get("mfr_yn"))==null?"N":(String)(drugDetails.get("mfr_yn")); //added for CRF-1014


							order_qty		= (Math.ceil((Float.parseFloat(order_qty)) * (Float.parseFloat(amend_durn_value))*(Float.parseFloat(amend_repeat_value))))+"";
							// order_qty		= (Math.ceil((Float.parseFloat(order_qty)) / Float.parseFloat(pack_size)))+"";
							order_qty=new Float(order_qty).intValue()+"";
							
							color_auth_rule ="BLACK"; // Added for ML-MMOH-CRF-0343
 							strAuthStatus="-";     // Added for ML-MMOH-CRF-0343
								//if condtion ADDED FOR ML-MMOH-CRF-1224
									if(disp_route_shadule.equals("Y")){
										style="border-bottom: 1px solid black;border-collapse: collapse;";
									}
%>
							<tr>
								<td width="30%" class="label" style='<%=style%>'><font size="1"><%=(drugDetails.get("amend_fluid_name")==null ? "":drugDetails.get("amend_fluid_name"))%></font></td>
								<td width="10%" class="label" style='<%=style%>'><font size="1">&nbsp;<%=(drugDetails.get("dose")==null ? "":drugDetails.get("amend_stock_value")+"&nbsp;"+ bean.getUomDisplay((String)session.getValue("facility_id"),fluid_dosage_uom) )%></font></td>
								<td width="10%" class="label" style='<%=style%>'><font  size="1">&nbsp;<%=(drugDetails.get("amend_frequency_desc")==null ? "":drugDetails.get("amend_frequency_desc"))%></font></td>
								<td width="18%" class="label" style='<%=style%>'><font size="1">&nbsp;<%=order_qty%>&nbsp;&nbsp;<%=order_uom%></font></td>
								<!-- modified for  ml-mmoh-scf-1050 start -->
								<td width="16%" class="label" style='<%=style%>'><font size="1"><%=(cycle_start_date==null ? "":DateUtils.convertDate(cycle_start_date, "DMYHM","en",locale)) %></font></td>
								<td width="16%" class="label" style='<%=style%>'><font size="1"><%=(cycle_end_date==null ? "":DateUtils.convertDate(cycle_end_date, "DMYHM","en",locale)) %></font></td>
							    	<!-- modified for  ml-mmoh-scf-1050 end -->
							    	<td class="label" align='center' style='<%=display_auth_rule%>;<%=style%>'> <!-- added for ML-MMOH-CRF-0343 -->
								<label id='lbl_authorize' style='<%=display_auth_rule%>;<%=color_auth_rule%>'><%=strAuthStatus%></label>
							    	</td>  
							    	<!--added for ml-mmoh-crf-1224-->
							    	<%if(disp_route_shadule.equals("Y")){%>
									<td width="10%" class="label" style='<%=style%>'><font size="1">&nbsp;</font></td>
							<td width="10%" class="label" style='<%=style%>'><font size="1">&nbsp;</font></td>
							<%}%>
							<!--added for ml-mmoh-crf-1224-->
							</tr>
<%
						}
						}	
					}
					}else{%>
					
							<td width="30%" class="label"><font size="1"><%=(drugDetails.get("DRUG_DESC")==null ? "":drugDetails.get("DRUG_DESC"))%></font></td>
							
							<td width="10%" class="label"><font size="1">&nbsp;<%=(drugDetails.get("dose")==null ? "":drugDetails.get("dose")+"&nbsp;"+uom)%>&nbsp;</font></td>
							<td width="10%" class="label"><font size="1">&nbsp;<%=(drugDetails.get("amend_frequency_desc")==null ? "":drugDetails.get("amend_frequency_desc"))%></font></td>
							<td width="18%" class="label"><font size="1">&nbsp;<%=ing_order_qty%>&nbsp;&nbsp;<%=order_uom%></font></td>
							<td width="16%" class="label"><font size="1"><%=(drugDetails.get("amend_start_date")==null ? "":DateUtils.convertDate(drugDetails.get("amend_start_date").toString(), "DMYHM","en",locale)) %></font></td>
							<td width="16%" class="label"><font size="1"><%=(drugDetails.get("amend_end_date")==null ? "":DateUtils.convertDate(drugDetails.get("amend_end_date").toString(), "DMYHM","en",locale))%></font></td>
						    	<td class="label" align='center' style='<%=display_auth_rule%>;'> <!-- added for ML-MMOH-CRF-0343 -->
							<label id='lbl_authorize' style='<%=display_auth_rule%>;<%=color_auth_rule%>'><%=strAuthStatus%></label>
							</td>
							
						</tr>
<%			
						String amend_fluid_name			= (String)drugDetails.get("amend_fluid_name");
						if(amend_fluid_name!=null && !amend_fluid_name.equals("")) {
							String fluid_code=(String)drugDetails.get("amend_fluid_code");
							String fluid_dosage_uom=(String)drugDetails.get("amend_stock_uom_val");
							pack_size	= bean.getPackSize(fluid_code);			
							order_uom	= bean.getStockUOM(fluid_code);	
							order_qty		= (Math.ceil((Float.parseFloat(amend_stock_value)) / Float.parseFloat(pack_size)))+""; 
						
							order_qty		= (Math.ceil((Float.parseFloat(order_qty)) * (Float.parseFloat(amend_durn_value))*(Float.parseFloat(amend_repeat_value))))+"";
							// order_qty		= (Math.ceil((Float.parseFloat(order_qty)) / Float.parseFloat(pack_size)))+"";
							order_qty=new Float(order_qty).intValue()+"";
							
							color_auth_rule ="BLACK"; // Added for ML-MMOH-CRF-0343
 							strAuthStatus="-";     // Added for ML-MMOH-CRF-0343
%>
							<tr>
								<td width="30%" class="label"><font size="1"><%=(drugDetails.get("amend_fluid_name")==null ? "":drugDetails.get("amend_fluid_name"))%>&nbsp;<%if(mfr_yn.equals("Y")){ //ML-MMOH-CRF-1014 - start %> 
								<a HREF="#" onMouseOver="changeCursor(this);" onClick="showMultipleFlowRateOnco('<%=patient_id %>','<%=bean_id %>','<%=bean_name %>','<%=fluid_dosage_uom%>','<%=existing_order_id%>','<%=drug_code%>','<%=(String)drugDetails.get("OCURRANCE_NUM")%>');" id='mfrLink'><fmt:message key="ePH.MultipleFlowRate.label" bundle="${common_labels}"/></a><%}%>  </font></td>
								<td width="10%" class="label"><font size="1">&nbsp;<%=(drugDetails.get("dose")==null ? "":drugDetails.get("amend_stock_value")+"&nbsp;"+fluid_dosage_uom)%></font></td>
								<td width="10%" class="label"><font size="1">&nbsp;<%=(drugDetails.get("amend_frequency_desc")==null ? "":drugDetails.get("amend_frequency_desc"))%></font></td>
								<td width="18%" class="label"><font size="1">&nbsp;<%=order_qty%>&nbsp;&nbsp;<%=order_uom%></font></td>
								<td width="16%" class="label"><font size="1"><%=(drugDetails.get("amend_start_date")==null ? "":DateUtils.convertDate(drugDetails.get("amend_start_date").toString(), "DMYHM","en",locale))%></font></td>
								<td width="16%" class="label"><font size="1"><%=(drugDetails.get("amend_end_date")==null ? "":DateUtils.convertDate(drugDetails.get("amend_end_date").toString(), "DMYHM","en",locale))%></font></td>
							    	<td class="label" align='center' style='<%=display_auth_rule%>;'> <!-- added for ML-MMOH-CRF-0343 -->
								<label id='lbl_authorize' style='<%=display_auth_rule%>;<%=color_auth_rule%>'><%=strAuthStatus%></label>
							    	</td>
							<!--	<%if(mfr_yn.equals("Y")){ //ML-MMOH-CRF-1014 - start %> 
								<td class="label"  nowrap>
								<a HREF="#" onMouseOver="changeCursor(this);" onClick="showMultipleFlowRateOnco('<%=patient_id %>','<%=bean_id %>','<%=bean_name %>','<%=fluid_dosage_uom%>','<%=existing_order_id%>','<%=drug_code%>','<%=(String)drugDetails.get("OCURRANCE_NUM")%>');" id='mfrLink'><fmt:message key="ePH.MultipleFlowRate.label" bundle="${common_labels}"/></a></td><%}%>  -->
							</tr>
<%
							}
						}
						if(!pres_remarks.equals("")){
%>
						   <tr>	
								<td width="2%">&nbsp;</td>
								<td colspan="6" class="label"><b><fmt:message key="ePH.DrugRemarks.label" bundle="${ph_labels}"/>:&nbsp;&nbsp;</b><%=pres_remarks%></td>	
							</tr>
<%
						}
%>
						<tr>
							<td class="white"></td></tr><tr><td class="white"></td>
						</tr>
						<tr>
							<td class="white"></td></tr><tr><td class="white"></td>
						</tr>
<%
				//added for MMS Adhoc Testing-Start
				if(!drugindication_remarks.equals("")) {
%>

					<tr>	
						<td colspan="2" class="label"><b><fmt:message key="ePH.DrugIndications.label" bundle="${ph_labels}"/>:&nbsp;&nbsp;</b></td><td colspan="5" class="label">&nbsp;&nbsp;<%=drugindication_remarks%></td>
					</tr>
<%
						}//added for MMS Adhoc Testing-End
					}
				}  
				String clinical_comments	=	pres_bean_1.getPresRemarks();
				if(clinical_comments!=null && !clinical_comments.equals("")) {
%>
					<tr>
						<td class="white"></td></tr><tr><td class="white"></td>
					</tr>
					<tr>
						<td width="10%" colspan="2" class="data"><fmt:message key="ePH.PrescriptionRemarks.label" bundle="${ph_labels}"/>:&nbsp;&nbsp;</td>
						<td colspan="5" class="label">&nbsp;&nbsp;<%=clinical_comments%></td>	
					</tr>
<%
				}
%>
				</table>
<%
			} 
%>
		</form>
	</body>
</html>
<%
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(or_bean_id,orbean,request);
	putObjectInBean(pres_bean_id,pres_bean,request);
	putObjectInBean(pres_bean_id_1,pres_bean_1,request);
%>

