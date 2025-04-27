	<%
	System.out.println("==============in==========>MedicationAdministrationFTDrugDtls01.jsp");
	String parvalues=request.getParameter("parvalues");
	String[] arrParValues = parvalues.split("~");	
	%> 
	<input type="hidden" name="current_date_time" id="current_date_time"	value="<%=arrParValues[0]%>">
	<input type="hidden" name="encounter_id" id="encounter_id"		value="<%=arrParValues[1]%>">
	<input type="hidden" name="admin_due_date" id="admin_due_date"		value="<%=arrParValues[2]%>">
	<input type="hidden" name="assign_bed_num" id="assign_bed_num"		value="<%=arrParValues[3]%>">
	<input type="hidden" name="disp_locn_code" id="disp_locn_code"		value="<%=arrParValues[4]%>">
	<input type="hidden" name="nursing_unit" id="nursing_unit"		value="<%=arrParValues[5]%>">
	<input type="hidden" name="patient_id_selected" id="patient_id_selected" value="<%=arrParValues[6]%>">
	<input type="hidden" name="patient_id" id="patient_id"			value="<%=arrParValues[7]%>">
	<input type="hidden" name="order_id" id="order_id"			value="<%=arrParValues[8]%>">
	<input type="hidden" name="order_line_no" id="order_line_no"		value="<%=arrParValues[9]%>">			
	<input type="hidden" name="row_no" id="row_no"				value="<%=arrParValues[10]%>">
	<input type="hidden" name="bean_id" id="bean_id"				value="<%=arrParValues[11]%>">
	<input type="hidden" name="bean_name" id="bean_name"			value="<%=arrParValues[12]%>">
	<input type="hidden" name="mode" id="mode"				value="<%=arrParValues[13]%>">	
	<input type="hidden" name="tot_no_of_records" id="tot_no_of_records"	value="<%=arrParValues[14]%>">	
	<input type="hidden" name="non_iv_records" id="non_iv_records"		value="<%=arrParValues[15]%>">
	<input type="hidden" name="alt_non_iv_records" id="alt_non_iv_records"	value="<%=arrParValues[16]%>">
	<input type="hidden" name="new_non_iv_records" id="new_non_iv_records"	value="<%=arrParValues[17]%>">
	<input type="hidden" name="func_mode" id="func_mode"			value="<%=arrParValues[18]%>">
	<input type="hidden" name="drugCode" id="drugCode"			value="<%=arrParValues[19]%>">
	<input type="hidden" name="selDateTime" id="selDateTime"			value="<%=arrParValues[20]%>">
	<input type="hidden" name="hold_discontinue_yn" id="hold_discontinue_yn" value="<%=arrParValues[21]%>">
	<input type="hidden" name="adr_recorded" id="adr_recorded"		value="N">
	<input type="hidden" name="admin_recorded" id="admin_recorded"		value="N">
	<input type="hidden" name="locale" id="locale"				value="<%=arrParValues[22]%>">
	<input type="hidden" name="from_time" id="from_time"			value="<%=arrParValues[23]%>">
	<input type="hidden" name="freq_nature" id="freq_nature"			value="<%=arrParValues[24]%>"><!-- Add for SKR-SCF-0304[29563] -->
	<input type="hidden" name="userAuthPINYN" id="userAuthPINYN"			value="<%=arrParValues[24]%>"><!-- Add for SKR-SCF-0035 [IN029926] -->
	<input type="hidden" name="admin_from_date" id="admin_from_date"			value="<%=arrParValues[25]%>"><!--added for AAKH-CRF-0024 [IN:038260]-->
	<input type="hidden" name="admin_to_date" id="admin_to_date"			value="<%=arrParValues[26]%>"><!-- added for AAKH-CRF-0024 [IN:038260]  -->
	<input type="hidden" name="dob" id="dob"			value="<%=arrParValues[27]%>"> <!--IN066125 -->
	<input type="hidden" name="isSite_spec_patient_stock" id="isSite_spec_patient_stock" value="<%=arrParValues[28]%>"> <!-- GHL-CRF-0482-->

