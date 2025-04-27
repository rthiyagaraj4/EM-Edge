<!DOCTYPE html>
	<%
	System.out.println("==============in==========>DispMedicationFilling01.jsp");
	String parvalues=request.getParameter("parvalues");
	String[] arrParValues = parvalues.split("~");
	String parvalues01=request.getParameter("parvalues01");
	String[] arrParValues01 = parvalues01.split("~");
	String parvalues02=request.getParameter("parvalues02");
	String[] arrParValues02 = parvalues02.split("~");
	%> 

	<input type="hidden" name="mode" id="mode" value="<%=arrParValues02[0]%>">		
	<input type="hidden" name="IssueByUOM" id="IssueByUOM" value="<%=arrParValues02[1]%>">		
	<input type="hidden" name="function_id" id="function_id" value="<%=arrParValues02[2]%>">
	<input type="hidden" name="ValuesChanged" id="ValuesChanged" value="<%=arrParValues02[3]%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=arrParValues02[4]%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=arrParValues02[5]%>">
	<input type="hidden" name="bean_id_1" id="bean_id_1" value="<%=arrParValues02[6]%>">
	<input type="hidden" name="bean_name_1" id="bean_name_1" value="<%=arrParValues02[7]%>">			
	<input type="hidden" name="approval_no" id="approval_no" value="">			
    <input type="hidden" name="pres_qty_alert" id="pres_qty_alert" value="<%=arrParValues02[8]%>">


	
	<input type="hidden" name="order_id" id="order_id" value="<%=arrParValues01[0]%>">
	<input type="hidden" name="disp_stage" id="disp_stage" value="<%=arrParValues01[1]%>">
	<input type="hidden" name="patient_id" id="patient_id" value="<%=arrParValues01[2]%>">
	<input type="hidden" name="encounter_id" id="encounter_id" value="<%=arrParValues01[3]%>">
	<input type="hidden" name="source_code" id="source_code" value="<%=arrParValues01[4]%>">
	<input type="hidden" name="source_type" id="source_type" value="<%=arrParValues01[5]%>">
	<input type="hidden" name="ordering_facility_id" id="ordering_facility_id" value="<%=arrParValues01[6]%>">
	<input type="hidden" name="ord_date_time" id="ord_date_time" value="<%=arrParValues01[7]%>">
	<input type="hidden" name="performing_pract_id" id="performing_pract_id" value="<%=arrParValues01[8]%>">
	<input type="hidden" name="module_id" id="module_id" value="<%=arrParValues01[9]%>">
	<input type="hidden" name="tot_rec" id="tot_rec" value="<%=arrParValues01[10]%>">
	<input type="hidden" name="curr_stage" id="curr_stage" value="<%=arrParValues01[11]%>">	
	
	<input type="hidden" name="disp_level" id="disp_level" value="<%=arrParValues[0]%>">
	<input type="hidden" name="disp_locn_code" id="disp_locn_code" value="<%=arrParValues[1]%>">
	<input type="hidden" name="disp_locn_catg" id="disp_locn_catg" value="<%=arrParValues[2]%>">
	<input type="hidden" name="ord_type" id="ord_type" value="<%=arrParValues[3]%>">
	<input type="hidden" name="IncludeZeroQty" id="IncludeZeroQty" value="<%=arrParValues[4]%>">
	<input type="hidden" name="EquivalentNormalOrder" id="EquivalentNormalOrder" value="<%=arrParValues[5]%>">
	<input type="hidden" name="tpn_wrksheet_rcrd" id="tpn_wrksheet_rcrd" value="<%=arrParValues[6]%>">
	
	
	<input type="hidden" name="fill_list" id="fill_list" value="<%=arrParValues[7]%>">
	<input type="hidden" name="bPatientPaid" id="bPatientPaid" value="<%=arrParValues[8]%>">
	<input type="hidden" name="iv_prep_yn" id="iv_prep_yn" value="<%=arrParValues[9]%>">		
	<input type="hidden" name="strAutoCompletePartialDisp" id="strAutoCompletePartialDisp" value="<%=arrParValues[10]%>">  
	<input type="hidden" name="no_of_decimals" id="no_of_decimals" value="<%=arrParValues[11]%>">
	<input type="hidden" name="disp_decimal_dtls_yn" id="disp_decimal_dtls_yn" value="<%=arrParValues[12]%>"> 
	<input type="hidden" name="allow_amend_alt_drug_dtl" id="allow_amend_alt_drug_dtl" value="<%=arrParValues[13]%>"> 
	<input type="hidden" name="patient_class" id="patient_class" value="<%=arrParValues[14]%>">
	<input type="hidden" name="tpn_mf_label" id="tpn_mf_label" value="<%=arrParValues[15]%>"> 
	<input type="hidden" name="displayGrossAmtYn" id="displayGrossAmtYn" value="<%=arrParValues[16]%>"> 
	<input type="hidden" name="IncludeZeroQtyForIP" id="IncludeZeroQtyForIP" value="<%=arrParValues[17]%>">
	<input type="hidden" name="intractn_req_yn" id="intractn_req_yn" value="<%=arrParValues[18]%>">
	<input type="hidden" name="approval_no_flag" id="approval_no_flag" value="<%=arrParValues[19]%>">
	<input type="hidden" name="approval_no_app_for_patient_class" id="approval_no_app_for_patient_class" value="<%=arrParValues[20]%>">
	<input type="hidden" name="finding_remarks_app" id="finding_remarks_app" value="<%=arrParValues[21]%>">	

		
		
		

