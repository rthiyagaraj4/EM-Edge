<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*,eOR.*,eOR.Common.* , ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
 
<%-- Mandatory declarations end --%>

<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";

%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../js/OncologyRegimen.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%

    String facility_id		= (String) session.getValue("facility_id");
	String patient_id		= request.getParameter("patient_id");
	String patient_class	= request.getParameter("act_patient_class");
	String act_patient_class= request.getParameter("act_patient_class")==null?"":request.getParameter("act_patient_class");//Added for ML-MMOH-SCF-0414
	String encounter_id		= request.getParameter("encounter_id");
	String regimen_code		= request.getParameter("regimen_code");
	String params			= request.getQueryString() ;
	String start_date		= request.getParameter("start_date");
	
	String problem_ind		= request.getParameter("problem_ind");	
	String stage			= request.getParameter("stage")==null?"":request.getParameter("stage");
	String intention		= request.getParameter("intention")==null?"":request.getParameter("intention");
	String height			= request.getParameter("height")==null?"0.0":request.getParameter("height");
	String weight			= request.getParameter("weight")==null?"0.0":request.getParameter("weight");
	String bsa				= request.getParameter("bsa")==null?"0.0":request.getParameter("bsa");
	String order_set_code	= request.getParameter("order_set_code")==null?"":request.getParameter("order_set_code");
	String iv_prep_default	= request.getParameter("iv_prep_default")==null?"":request.getParameter("iv_prep_default");
    String order_type_flag	= request.getParameter("order_type_flag") == null ? "":request.getParameter("order_type_flag");
	String serialNum		= request.getParameter("serialNum") == null ? "":request.getParameter("serialNum");	
	String drug_db_interface_yn = request.getParameter("drug_db_interface_yn") == null ? "N":request.getParameter("drug_db_interface_yn");	
	String atc_allergy_alert_level = request.getParameter("atc_allergy_alert_level") == null ? "N":request.getParameter("atc_allergy_alert_level");	
	String bean_id			= "@OncologyRegimenBean"+patient_id+encounter_id;
	String bean_name		= "ePH.OncologyRegimenBean";	
	OncologyRegimenBean bean= (OncologyRegimenBean)getBeanObject( bean_id, bean_name, request ) ;

	String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
	String or_bean_name		= "eOR.OrderEntryBean";

    HashMap patientage				=	new HashMap(); 
	patientage						=	bean.ChkAPatientAge(patient_id);
	String date_of_birth			=	CommonBean.checkForNull((String)patientage.get("DATE_OF_BIRTH"));
	String sex						=	CommonBean.checkForNull((String)patientage.get("SEX"));
	String oncology_screening_type	=	"";
	String note_type				=	"";
	String accession_num			=	"";
	String test_observ_dt_tm		=	"";
	HashMap record2					=	new HashMap(); 
	 
	record2							=	bean.ChkAdMixture();
	oncology_screening_type			=	CommonBean.checkForNull((String)record2.get("ONCOLOGY_SCREENING_TYPE"));
    note_type						=	CommonBean.checkForNull((String)record2.get("ONCOLOGY_SCREENING_FORM_ID"));
	
	   
	if(!oncology_screening_type.equals("")){
		HashMap record3=new HashMap();
		record3=bean.ChkScreeningDetails(facility_id,encounter_id,note_type);
		accession_num=CommonBean.checkForNull((String)record3.get("ACCESSION_NUM"));
	}

	
	OrderEntryBean ORbean	= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
	
	String resp_id			= (String)ORbean.getResponsibilityId();
	String pract_id			= (String)ORbean.getPractitionerId();
	String pract_name		= (String)ORbean.getPractitionerName();
	String Pract_type	    = (String)ORbean.getPractitionerType();                        
	String locn_type		= (String)ORbean.getLocationType();	
	String locn_code		= (String)ORbean.getLocationCode();	 
	String service_code		= (String)ORbean.getServiceCode();
	String def_catalog_code	= (String)ORbean.getOncologyDefCatalogCode();
	String order_id         = "";
	String orderset_disabled= "disabled"; 
	HashMap Existingrecord;
	
	if(patient_class!=null){
	    if(patient_class.trim().equals("DC")) 
			patient_class="IP";
        if(!patient_class.trim().equals("IP") && !patient_class.trim().equals("EM")) 
			patient_class="OP";
	    bean.setPatientClass(patient_class);
	}

	if(problem_ind!=null)
		bean.setProblemInd(problem_ind);
	else
		problem_ind		= bean.getProblemInd();

	ArrayList	stageValues			= bean.getStageValues(problem_ind);	
	ArrayList	intentionValues		= bean.getIntentionValues(problem_ind);

/*	ArrayList	active_orders		= bean.getPatientActiveOrders(patient_id);

	StringBuffer drug_description	=	new StringBuffer();
	int size						=	active_orders.size();
	HashMap	record1					=	new HashMap();

	for(int i=0; i<size; i++){
		record1					=	(HashMap)active_orders.get(i);
		drug_description.append((String)record1.get("drug_desc"));
		drug_description.append(" , ");
	}*/

	if(order_type_flag.equals("Existing")){
		order_id=request.getParameter("order_id");	

		bean.setExistingCYTORecords(order_id,"","","",atc_allergy_alert_level); // RUT-CRF-0062 [IN029600]  NEWLY ADDED TO GET BUILD MAR RULE
		ArrayList getExistingCYTORecords = bean.getExistingCYTORecords(); 	 
		if(getExistingCYTORecords.size()>0){
			Existingrecord				   = (HashMap) getExistingCYTORecords.get(0);	
			stage							   = (String)Existingrecord.get("STAGE_CODE")==null?"":(String)Existingrecord.get("STAGE_CODE");
			intention					       = (String)Existingrecord.get("INTENTION_CODE")==null?"":(String)Existingrecord.get("INTENTION_CODE");
			def_catalog_code			       = (String)Existingrecord.get("REGIMEN_CODE")==null?"":(String)Existingrecord.get("REGIMEN_CODE");
		}
	}
	if(iv_prep_default.equals("C")){
		def_catalog_code=order_set_code;
		orderset_disabled="";
	}


	String drug_priv_appln_yn	= (String) session.getValue("PrivilegeApplicability");
	if(drug_priv_appln_yn == null){drug_priv_appln_yn = "N";}

%>

	
	<body onMouseDown="" onKeyDown="lockKey()">
		<form name="onCologyOptions" id="onCologyOptions">
		<!-- Below table for Ongology details-->
			<table border="0" width="100%" cellspacing="0" cellpadding="0">
				<tr>
					<td width="15%">
					<input type="button" class="button" value='<fmt:message key="ePH.CurrentRx.label" bundle="${ph_labels}"/>' onClick="javascript:callActiveOrders('<%=patient_id%>','<%=encounter_id%>');"></td>
					<td class="CURRTEXT" width="85%">&nbsp;
					<!-- <marquee scrollamount="3" title='<fmt:message key="ePH.ClickCurrentRxbuttontoViewCurrentMedication.label" bundle="${ph_labels}"/>'><font  style="font-weight:bold;color:black" size=1>&nbsp;</font></marquee> -->
					</td>
					<%if(!oncology_screening_type.equals("")){%>
					<td class="label" width="15%"><input type='button' class='button' onClick="ScreeningDetails('<%=patient_id%>','<%=encounter_id%>','<%=note_type%>','<%=patient_class%>','<%=accession_num%>','<%=oncology_screening_type%>','<%=date_of_birth%>','<%=sex%>')" value='<fmt:message key="ePH.ScreeningDetails.label" bundle="${ph_labels}"/>'></td> <%}%><td class="label" width="15%"><input type='button' class='button' onClick="showDrugProfile('<%=patient_id%>','Prescription','<%=encounter_id%>')" value='<fmt:message key="Common.DrugProfile.label" bundle="${common_labels}"/>'></td> <!--  encounter_id Added for AAKH-CRF-0088.2 --> 
				</tr>
				<th colspan="5"><font style="font-size:9"><fmt:message key="ePH.RegimenDetails.label" bundle="${ph_labels}"/></font></th>
				<input type="hidden" name="bean_id" id="bean_id"			value="<%= bean_id %>">
				<input type="hidden" name="bean_name" id="bean_name"		value="<%= bean_name %>">
				<input type="hidden" name="patient_id" id="patient_id"		value="<%= patient_id %>">
				<input type="hidden" name="encounter_id" id="encounter_id"	value="<%= encounter_id %>">
				<input type="hidden" name="start_date" id="start_date"		value="<%=start_date%>">
				
				<input type="hidden" name="patient_class" id="patient_class"	value="<%= patient_class %>">
				<input type="hidden" name="resp_id" id="resp_id"			value="<%= resp_id %>">
				<input type="hidden" name="pract_id" id="pract_id"		value="<%= pract_id %>">
				<input type="hidden" name="pract_name" id="pract_name"		value="<%= pract_name %>">	
				<input type="hidden" name="locn_type" id="locn_type"		value="<%= locn_type %>">
				<input type="hidden" name="locn_code" id="locn_code"		value="<%= locn_code %>">
				<input type="hidden" name="problem_ind" id="problem_ind"		value="<%=problem_ind%>">
				<input type="hidden" name="params" id="params"			value="<%=params%>">
				<input type="hidden" name="dose" id="dose"			value="">
				<input type="hidden" name="order_type_flag" id="order_type_flag"	value="<%= order_type_flag %>">
				<input type="hidden" name="iv_prep_default" id="iv_prep_default" value="<%=iv_prep_default%>">
				<input type="hidden" name="order_id" id="order_id"		value="<%=order_id%>">
				
				<input type="hidden" name="accession_num" id="accession_num"		value="<%=accession_num%>">
				<input type="hidden" name="test_observ_dt_tm" id="test_observ_dt_tm"		value="<%=test_observ_dt_tm%>">

				<input type="hidden" name="facility_id_1" id="facility_id_1"		value="<%=facility_id%>">
				<input type="hidden" name="service_code_1" id="service_code_1"	    value="<%=service_code%>">
				<input type="hidden" name="Pract_type_1" id="Pract_type_1"	    value="<%=Pract_type%>">
				<input type="hidden" name="Language_id_1" id="Language_id_1"	    value="<%=locale%>">
				<input type="hidden" name="drug_priv_appln_yn" id="drug_priv_appln_yn"	    value="<%=drug_priv_appln_yn%>">
				<input type="hidden" name="drug_db_interface_yn" id="drug_db_interface_yn"  value="<%=drug_db_interface_yn%>">
				<input type="hidden" name="act_patient_class" id="act_patient_class" value="<%=act_patient_class%>"><!-- Added for ML-MMOH-SCF-0414 -->
				<input type="hidden" name="sql_ph_oncology_regimen_select" id="sql_ph_oncology_regimen_select"	value="<%=PhRepository.getPhKeyValue("SQL_PH_ONCOLOGY_REGIMEN_SELECT1")%>">
			</table>

<%
			if (serialNum.equals("")&& !order_type_flag.equals("Existing") ) {
%>
				<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
					<tr>
						<td width="10%" class="label"><fmt:message key="Common.Stage.label" bundle="${common_labels}"/>&nbsp;</TD>
						<td >
							<select name="stage" id="stage"><option value =''>&nbsp;&nbsp;&nbsp;&nbsp;-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;&nbsp;&nbsp;</option>
<%			
							if(stageValues!=null)	{
								for(int i=0;i<stageValues.size();i++){
									String[] record = ((String[])stageValues.get(i));					
%>
									<option value=<%=record[0]%>> <%=record[1]%>
<%
								}
							}
%>
							</select>
						</td>
						<td width="10%" class="label"><fmt:message key="ePH.Intention.label" bundle="${ph_labels}"/>&nbsp;</TD>
						<td >
							<select name="intention" id="intention"><option value =''>&nbsp;&nbsp;&nbsp;&nbsp;-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;&nbsp;&nbsp;</option>
<%			
							if(intentionValues!=null)	{
								for(int i=0;i<intentionValues.size();i++){
									String[] record = ((String[])intentionValues.get(i));
%>
									<option value=<%=record[0]%>> <%=record[1]%>
<%
								}
							} 
%>
							</select>
						</td>
						<td width="10%" class="label"><fmt:message key="ePH.Regimen.label" bundle="${ph_labels}"/>&nbsp;</TD>
						<td class="label" nowrap>
							<input type='text' name='regimen_desc' id='regimen_desc' size='45'  value='' OnBlur="searchRegimen();"><input type="button" name="btnregimen" id="btnregimen" value="?" class="button" onClick="searchRegimen();" ><img  src="../../eCommon/images/mandatory.gif" id='bl_overriden_action_reason_img' ></img>
							<input type='hidden' name='regimen' id='regimen' value='<%=order_set_code%>'>
					   </td>
					   <td class="button">
							<!-- <input type="button" name="btn_add_drug" id="btn_add_drug" value='<fmt:message key="Common.Schedule.label" bundle="${common_labels}"/>' class="button" onClick="" disabled> -->&nbsp;&nbsp;&nbsp;
						</td>
					</tr>	
				</table>
				<Script>
						
					if(document.onCologyOptions.regimen.value!=""){
						loadDrugDetails(document.onCologyOptions.regimen);
					}
				</script>
<%
			}
			else if(!serialNum.equals("") && !order_type_flag.equals("Existing")) {
				int srlNo		= 0;
				srlNo			= Integer.parseInt(serialNum);

				ArrayList drugList			= bean.getDrugDetails();
				ArrayList 	regimenValues		= bean.getRegimen(locn_type,locn_code,service_code,pract_id,Pract_type,patient_class,patient_id);	

				HashMap drugDetails			= (HashMap)drugList.get(srlNo-1);
				String generic_id			= (String)drugDetails.get("GENERIC_ID");
				String drug_desc			= (String)drugDetails.get("DRUG_DESC");
				String drug_code			= (String)drugDetails.get("DRUG_CODE");
				String min_daily_dose		= (String)drugDetails.get("MIN_DAILY_DOSE");
				String min_unit_dose		= (String)drugDetails.get("MIN_UNIT_DOSE");
				String generic_name			= (String)drugDetails.get("GENERIC_NAME");
				String daily_dose			= (String)drugDetails.get("DAILY_DOSE");
				String unit_dose			= (String)drugDetails.get("UNIT_DOSE");
				String mono_graph			= (String)drugDetails.get("MONO_GRAPH");
				String limit_ind			= (String)drugDetails.get("LIMIT_IND");
				String allergy_yn			= (String)drugDetails.get("ALLERGY_YN");
				String current_rx			= (String)drugDetails.get("CURRENT_RX");
				String srl_no				= (String)drugDetails.get("SRL_NO");
				String strength_value		= (String)drugDetails.get("STRENGTH_VALUE");
				String strength_uom_desc	= (String)drugDetails.get("STRENGTH_UOM_DESC");
				String strength_uom			= (String)drugDetails.get("STRENGTH_UOM");
				String form_code			= (String)drugDetails.get("FORM_CODE");
				String pres_qty_value		= (String)drugDetails.get("PRES_QTY_VALUE");
				String pres_base_uom		= (String)drugDetails.get("PRES_BASE_UOM");
				String freq_code			= (String)drugDetails.get("FREQ_CODE");
				String durn_value			= (String)drugDetails.get("DURN_VALUE");
				String durn_type			= (String)drugDetails.get("DURN_TYPE");
				String or_durn_desc			= (String)drugDetails.get("OR_DURN_DESC");
				String auth_yn_val			= (String)drugDetails.get("AUTH_YN_VAL");
				String approval_yn_val		= (String)drugDetails.get("APPROVAL_YN_VAL");
				String cosign_yn_val		= (String)drugDetails.get("COSIGN_YN_VAL");
				String auth_yn				= (String)drugDetails.get("AUTH_YN");
				String approval_yn			= (String)drugDetails.get("APPROVAL_YN");
				String cosign_yn			= (String)drugDetails.get("COSIGN_YN");
				String consent_reqd_yn		= (String)drugDetails.get("CONSENT_REQD_YN");
				String order_type_code		= (String)drugDetails.get("ORDER_TYPE_CODE");
				String route_code			= (String)drugDetails.get("ROUTE_CODE");
				String end_date				= (String)drugDetails.get("END_DATE");
				String dup_drug_desc		= (String)drugDetails.get("CURRENTRX_REMARKS");
				String allergy_desc			= (String)drugDetails.get("ALLERGY_REMARKS");
				String exceed_dose_desc		= (String)drugDetails.get("DOSE_REMARKS");
				String bms_qty				= (String)drugDetails.get("BMS_QTY");
				String dflt_qty_uom			= (String)drugDetails.get("DFLT_QTY_UOM");
				String tab_qty_value		= (String)drugDetails.get("TAB_QTY_VALUE");
				String qty_desc_code		= (String)drugDetails.get("QTY_DESC_CODE");

				//String	dose				= ((String)drugDetails.get("dose")==null ? "":(String)drugDetails.get("dose"));
%>
				<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
					<tr>
						<td width="10%" class="label"><fmt:message key="Common.Stage.label" bundle="${common_labels}"/>&nbsp;</TD>
						<td >
							<select name="stage" id="stage" <%=orderset_disabled%>><option value =''>&nbsp;&nbsp;&nbsp;&nbsp;-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;&nbsp;&nbsp;</option>
<%			
							if(stageValues!=null)	{
								for(int i=0;i<stageValues.size();i++){
									String[] record = ((String[])stageValues.get(i));
									if(stage.equalsIgnoreCase(record[0])) {
%>						
										<option value=<%=record[0]%> selected> <%=record[1]%>
<%					
									} 
									else {  
%>
										<option value=<%=record[0]%>> <%=record[1]%>
<%
									}
								}
							} 
%>
							</select>
						</td>
						<td width="10%" class="label"><fmt:message key="ePH.Intention.label" bundle="${ph_labels}"/>&nbsp;</TD>
						<td >
							<select name="intention" id="intention" <%=orderset_disabled%>><option value =''>&nbsp;&nbsp;&nbsp;&nbsp;-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;&nbsp;&nbsp;</option>
<%			
							if(intentionValues!=null)	{
								for(int i=0;i<intentionValues.size();i++){
									String[] record = ((String[])intentionValues.get(i));
									if(intention.equalsIgnoreCase(record[0])) {
%>						
										<option value=<%=record[0]%> selected> <%=record[1]%>
<%					
									}
									else { 
%>
										<option value=<%=record[0]%>> <%=record[1]%>
<%					
									}
								}
							}
%>
							</select>
						</td>
						<td  ></td>
						<td width="10%" class="label"><fmt:message key="ePH.Regimen.label" bundle="${ph_labels}"/>&nbsp;</TD>
						<td >
							<select name="regimen" id="regimen" onChange="loadDrugDetails(this)" disabled><option value =''>&nbsp;&nbsp;&nbsp;&nbsp;-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;&nbsp;&nbsp;</option>
<%				
							if(regimenValues!=null)	{
								for(int i=0;i<regimenValues.size();i++){
									String[] record = ((String[])regimenValues.get(i));
									if(regimen_code.equalsIgnoreCase(record[0])) {
%>
										<option value=<%=record[0]%> selected> <%=record[1]%>
<%
									}
									else {  
%>
										<option value=<%=record[0]%>> <%=record[1]%>
<%
									} 
								}
							} 
%>
							</select>
							<img src="../../eCommon/images/mandatory.gif" BORDER="0"></img>
						</td>
						<td class="button">
							<input type="button" name="btn_add_drug" id="btn_add_drug" value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/> <fmt:message key="Common.New.label" bundle="${common_labels}"/> <fmt:message key="Common.Drug.label" bundle="${common_labels}"/>' class="button" onClick="addNewDrug();" >&nbsp;&nbsp;&nbsp;
<!-- 							refreshLocation('<%=patient_id%>','<%=encounter_id%>','<%=problem_ind%>','<%=start_date%>','') -->
						</td>
					</tr>
				</table>

				<input type="hidden" name="drug_code" id="drug_code" value="<%= drug_code %>">
				<input type="hidden" name="drug_desc" id="drug_desc" value="<%= drug_desc %>">
				<input type="hidden" name="generic_id" id="generic_id" value="<%= generic_id %>">
				<input type="hidden" name="generic_name" id="generic_name" value="<%= generic_name %>">
				<input type="hidden" name="daily_dose" id="daily_dose" value="<%= daily_dose %>">
				<input type="hidden" name="unit_dose" id="unit_dose" value="<%= unit_dose %>">
				<input type="hidden" name="mono_graph" id="mono_graph" value="<%= mono_graph %>">
				<input type="hidden" name="limit_ind" id="limit_ind" value="<%= limit_ind %>">
				<input type="hidden" name="allergy_yn" id="allergy_yn" value="<%= allergy_yn %>">
				<input type="hidden" name="current_rx" id="current_rx" value="<%= current_rx %>">
				<input type="hidden" name="srl_no" id="srl_no" value="<%= srl_no %>">
				<input type="hidden" name="form_code" id="form_code" value="<%= form_code %>">
				<input type="hidden" name="pres_qty_value" id="pres_qty_value" value="<%= pres_qty_value %>">
				<input type="hidden" name="pres_base_uom" id="pres_base_uom" value="<%= pres_base_uom %>">
				<input type="hidden" name="freq_code" id="freq_code" value="<%= freq_code %>">
				<input type="hidden" name="durn_type" id="durn_type" value="<%= durn_type %>">
				<input type="hidden" name="or_durn_desc" id="or_durn_desc" value="<%= or_durn_desc %>">
				<input type="hidden" name="approval_yn_val" id="approval_yn_val" value="<%= approval_yn_val %>" >
				<input type="hidden" name="auth_yn_val" id="auth_yn_val" value="<%= auth_yn_val %>">
				<input type="hidden" name="cosign_yn_val" id="cosign_yn_val" value="<%= cosign_yn_val %>">
				<input type="hidden" name="order_type_code" id="order_type_code" value="<%= order_type_code %>">
				<input type="hidden" name="drug_codes" id="drug_codes"		value="<%= bean.getDrugCodes() %>">
				<input type="hidden" name="auth_yn" id="auth_yn" value="<%= auth_yn %>">
				<input type="hidden" name="approval_yn" id="approval_yn" value="<%= approval_yn %>">
				<input type="hidden" name="cosign_yn" id="cosign_yn" value="<%= cosign_yn %>">
				<input type="hidden" name="consent_reqd_yn" id="consent_reqd_yn" value="<%= consent_reqd_yn %>">
				<input type="hidden" name="allergy_desc" id="allergy_desc" value="<%= allergy_desc %>">
				<input type="hidden" name="exceed_dose_desc" id="exceed_dose_desc" value="<%= exceed_dose_desc %>">
				<input type="hidden" name="dup_drug_desc" id="dup_drug_desc" value="<%= dup_drug_desc %>">
				<input type="hidden" name="uom_code" id="uom_code" value="<%= strength_uom %>">
				<input type="hidden" name="strength_uom_desc" id="strength_uom_desc" value="<%= strength_uom_desc %>">
				<input type="hidden" name="str_val" id="str_val" value="<%= strength_value %>">
				<input type="hidden" name="bms_qty" id="bms_qty" value="<%= bms_qty %>">
				<input type="hidden" name="dflt_qty_uom" id="dflt_qty_uom" value="<%= dflt_qty_uom %>">
				<input type="hidden" name="tab_qty_value" id="tab_qty_value" value="<%= tab_qty_value %>">
				<input type="hidden" name="qty_desc_code" id="qty_desc_code" value="<%= qty_desc_code %>">
				<input type="hidden" name="route_code" id="route_code" value="<%= route_code %>">
				<input type="hidden" name="str_desc" id="str_desc" value="">
				<input type="hidden" name="durn_value" id="durn_value" value="<%= durn_value %>">
				<input type="hidden" name="end_date" id="end_date" value="<%= end_date %>">
				<input type="hidden" name="SRL_NO" id="SRL_NO" value="<%= srlNo %>">
				<input type="hidden" name="min_unit_dose" id="min_unit_dose" value="<%=min_unit_dose%>">
				<input type="hidden" name="min_daily_dose" id="min_daily_dose" value="<%=min_daily_dose%>">
				<input type="hidden" name="exceedDosageReasonMand" id="exceedDosageReasonMand" value="N">
				<input type="hidden" name="atc_allergy_alert_level" id="atc_allergy_alert_level" value='<%=atc_allergy_alert_level%>'>
<%
			}
			else if(order_type_flag.equals("Existing")){
				ArrayList 	regimenValues		= bean.getRegimen(locn_type,locn_code,service_code,pract_id,Pract_type,patient_class,patient_id);	
%>
		
				<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
					<tr>
						<td width="10%" class="label"><fmt:message key="Common.Stage.label" bundle="${common_labels}"/>&nbsp;</TD>
						<td >
							<select name="stage" id="stage" disabled ><option value =''>&nbsp;&nbsp;&nbsp;&nbsp;-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;&nbsp;&nbsp;</option>
<%
							
							if(stageValues!=null)	{
								for(int i=0;i<stageValues.size();i++){
									String[] record = ((String[])stageValues.get(i));
									if(stage.equalsIgnoreCase(record[0])) {
%>
										<option value=<%=record[0]%> selected> <%=record[1]%>
<%     
									}
									else{
%>
										<option value=<%=record[0]%>> <%=record[1]%>
<%			 
									}	
								}
							} 
%>
							</select>
						</td>
						<td width="10%" class="label"><fmt:message key="ePH.Intention.label" bundle="${ph_labels}"/>&nbsp;</TD>
						<td >
							<select name="intention" id="intention"  disabled ><option value =''>&nbsp;&nbsp;&nbsp;&nbsp;-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;&nbsp;&nbsp;</option>
<%	
							if(intentionValues!=null)	{
								for(int i=0;i<intentionValues.size();i++){
									String[] record = ((String[])intentionValues.get(i));
									if(intention.equalsIgnoreCase(record[0])) {
%>						
										<option value=<%=record[0]%> selected> <%=record[1]%>
<%					
									} 
									else{
%>
										<option value=<%=record[0]%>> <%=record[1]%>
<%				
									}
								}
							} 
%>
							</select>
						</td>
				
						<td width="10%" class="label"><fmt:message key="ePH.Regimen.label" bundle="${ph_labels}"/>&nbsp;</TD>
						<td >
							<select name="regimen" id="regimen" onChange="loadDrugDetails(this)" disabled ><option value =''>&nbsp;&nbsp;&nbsp;&nbsp;-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;&nbsp;&nbsp;</option>
<%			
							if(regimenValues!=null)	{
								for(int i=0;i<regimenValues.size();i++){
									String[] record = ((String[])regimenValues.get(i));
									if(def_catalog_code.equals(record[0])) {
%>
										<option value=<%=record[0]%> SELECTED> <%=record[1]%>
<%
									}
									else {  
%>
										<option value=<%=record[0]%> > <%=record[1]
%>
<%
									}
								}
							} 
%>
							</select>
						<img src="../../eCommon/images/mandatory.gif" BORDER="0"></img>
						</td>
					</tr>
				</table>
				<Script>
					//alert("in 493 options.jsp document.onCologyOptions.regimen.value=="+document.onCologyOptions.regimen.value);
					if(document.onCologyOptions.regimen.value!=""){
						loadDrugDetails(document.onCologyOptions.regimen);
					}
				</script>
<%
			}
%>
		</form>
		<script>	
			if(document.forms[0].stage.disabled==false)  //Added for online help --incident num:20123 on 22/3/10
			document.forms[0].stage.focus();
		</script>
		
	</body>
</html>
<%
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(or_bean_id,ORbean,request);
%>

