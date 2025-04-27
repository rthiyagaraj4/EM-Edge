//saved on 07/11/2005
/***********saved on 25th October 2005 ******************/
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  
01/12/2020  	  IN8219           Prabha	   1/12/2020	 Manickavasagam J          MMS-DM-CRF-0177
22/05/2023        44841            Ayesha      22/05/2023    Mohamed Suhail           MMS-DM-CRF-0233
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
var function_id = "PH_FACILITY_PARAM" ;
var result = false ;
var message = "" ;
var flag = "" ;  
function Display(mode,exists){
	var outpatient=document.getElementById('outpatient_table');
	//var commontable=document.parameter_facility_form.all.common_table;//commented CRF-713 INC 12785  for general tab
	var general=document.getElementById('general_table'); //Added CRF-713 INC 12785  for general tab
	var patientCol1=document.getElementById('outpatient');

	var ivadmixture =document.getElementById('ivadmixture_table');
	var medicationAdministration = document.getElementById('medicationadministration_table');
	var adr=document.getElementById('adr_table');
	var directdispense =document.getElementById('DirectDispensingRules_table');
	var databaseinterface =document.getElementById('drug_database_interface_table');
	var ward_ack_required_yn =document.getElementById('ward_ack_required_yn');//added for mms-kh-crf-0014
    var ward_ack_mar_required_yn=document.getElementById('ward_ack_mar_required_yn');//added for mms-kh-crf-0014
	if (document.parameter_facility_form.licenceRights.value != "PHBASIC"){
		var inpatient=document.getElementById('inpatient_table');
		var patientCol2=document.getElementById('inpatient');
		if(document.parameter_facility_form.PhVersionNo.value=="3")
			var patientCol3=document.getElementById('ivadmixture');
		var patientCol4=document.getElementById('medicationAdministration');
		var patientCol5=document.getElementById('ADRRules');
		var patientCol6=document.getElementById('DirectDispensingRules');
		var patientCol7=document.getElementById('DrugDatabaseInterface');
		document.getElementById("dup_drug_op").style.display="none";
	}
	else {
		document.getElementById("inpatient_base_table").style="display";
		document.getElementById("op_stock_header").innerText=getLabel("ePH.StockRulesOutpatient.label","PH");
		document.getElementById("dup_drug_legend_op").innerText=getLabel("ePH.AllowDuplicateDrugforInpatient.label","PH");
	}
	
	if(mode=="DrugDatabaseInterface_tab"){
		//databaseinterface.style.display="inline";
		//databaseinterface.style.visibility="visible";
		//commontable.style.visibility="visible"; //commented CRF-713 INC 12785  for general tab
		general.style.display="none";//Added CRF-713 INC 12785  for general tab 
     //	patientCol6.src="../../ePH/images/Direct-Dispensing-Rules_Click.gif";
		outpatient.style.display="none";
		inpatient.style.display="none";
		ivadmixture.style.display="none";
		adr.style.display="none";
		directdispense.style.display="none";
        medicationAdministration.style.display="none";
	    directdispense.style.visibility="hidden";

	    databaseinterface.style="display";
		databaseinterface.style.visibility="visible";
		//patientCol7.src="../../ePH/images/Drug Database Interface_click.gif";
	}

	if(mode=="outpatient_tab"){
		outpatient.style="display";
		outpatient.style.visibility="visible";
		outpatient.style.backgroundColor = "#e2e3f0";
		//commontable.style.visibility="visible";//commented CRF-713 INC 12785  for general tab
		general.style.display="none";//Added CRF-713 INC 12785  for general tab 
		inpatient.style.display="none";
		if (document.parameter_facility_form.licenceRights.value != "PHBASIC"){
			//patientCol1.src="../../ePH/images/Outpatient_click.gif";
			//inpatient_tab.style.display="none";
			//patientCol2.src="../../ePH/images/Inpatient.gif";
			//patientCol4.src="../../ePH/images/Medication Administration_click.gif";
			if(document.parameter_facility_form.PhVersionNo.value=="3"){
				//patientCol3.src="../../ePH/images/IV Admixture.gif";
				ivadmixture.style.display="none";
			}
			medicationAdministration.style.display="none";
			adr.style.display="none";
			directdispense.style.display="none";
			 databaseinterface.style.display="none";
			//patientCol5.src="../../ePH/images/ADRTDMRules_click.gif";
			//patientCol6.src="../../ePH/images/Direct-Dispensing-Rules_Click.gif";
		}
	}
	else if(mode=="inpatient_tab" && exists=="YES"){
		outpatient.style.display="none";
		//commontable.style.visibility="visible";//commented CRF-713 INC 12785  for general tab
		general.style.display="none";//Added CRF-713 INC 12785  for general tab 
		inpatient.style="display";
		inpatient.style.visibility="visible";
		inpatient.style.backgroundColor = "#e2e3f0";
		//patientCol1.src="../../ePH/images/Outpatient.gif";
		//patientCol2.src="../../ePH/images/Inpatient_click.gif";
		if(document.parameter_facility_form.PhVersionNo.value=="3"){
			//patientCol3.src="../../ePH/images/IV Admixture.gif";
		}
		adr.style.display="none";
		directdispense.style.display="none";
		//patientCol4.src="../../ePH/images/Medication Administration_click.gif";
		ivadmixture.style.display="none";
		medicationAdministration.style.display="none";
		 databaseinterface.style.display="none";
		//patientCol5.src="../../ePH/images/ADRTDMRules_click.gif";
		//patientCol6.src="../../ePH/images/Direct-Dispensing-Rules_Click.gif";
	}
	else if (mode=="inpatient_tab" && exists=="NO"){
		alert(getMessage("PH_IP_NOT_INSTALLED","PH"));
	}
	else if(mode=="ivadmixture_tab"){
	
		disablefields();
		//patientCol1.src="../../ePH/images/Outpatient.gif";
		//patientCol2.src="../../ePH/images/Inpatient.gif";
		//patientCol3.src="../../ePH/images/IV Admixture_click.gif";
		//patientCol4.src="../../ePH/images/Medication Administration_click.gif";
		//alert("mode ivadmixture_tabafter disa--"+mode);
		outpatient.style.display="none";
		//commontable.style.visibility="visible";//commented CRF-713 INC 12785  for general tab
		general.style.display="none";//Added CRF-713 INC 12785  for general tab 
		inpatient.style.display="none";
		medicationAdministration.style.display="none";
		 databaseinterface.style.display="none";
		ivadmixture.style="display";
		ivadmixture.style.visibility="visible";
		ivadmixture.style.backgroundColor = "#e2e3f0";
		adr.style.display="none";
		directdispense.style.display="none";
		//patientCol5.src="../../ePH/images/ADRTDMRules_click.gif";
			//patientCol6.src="../../ePH/images/Direct-Dispensing-Rules_Click.gif";
	}
	else if(mode=="medicationAdministration_tab"){
		//patientCol1.src="../../ePH/images/Outpatient.gif";
		//patientCol2.src="../../ePH/images/Inpatient.gif";
		if(document.parameter_facility_form.PhVersionNo.value=="3"){
			//patientCol3.src="../../ePH/images/IV Admixture.gif";
		}
		//patientCol4.src="../../ePH/images/Medication Administration.gif"; 
		adr.style.display="none";
		outpatient.style.display="none";
		//commontable.style.visibility="visible"; //commented CRF-713 INC 12785  for general tab
		general.style.display="none";//Added CRF-713 INC 12785  for general tab 
		inpatient.style.display="none";
		ivadmixture.style.display="none";
		databaseinterface.style.display="none";
		medicationAdministration.style="display";
		medicationAdministration.style.visibility="visible";
		medicationAdministration.style.backgroundColor = "#e2e3f0";
		adr.style.display="none";
		directdispense.style.display="none";
		//added for mm-kh-crf-0014 start
		
		if(document.parameter_facility_form.ward_ack_required_yn.checked)
			{
			ward_ack_mar_required_yn.disabled=false;
			}
		else
			{
			ward_ack_mar_required_yn.disabled=true;
			ward_ack_mar_required_yn.checked=false;
			
			}
	//added for mm-kh-crf-0014 end
		//patientCol5.src="../../ePH/images/ADRTDMRules_click.gif";
		//patientCol6.src="../../ePH/images/Direct-Dispensing-Rules_Click.gif";
	}
	else if(mode == "ADRRules_tab"){
		//patientCol5.src="../../ePH/images/ADRTDMRules.gif";
		outpatient.style.display="none";
		//commontable.style.visibility="visible"; //commented CRF-713 INC 12785  for general tab
		general.style.display="none";//Added CRF-713 INC 12785  for general tab 
		inpatient.style.display="none";
		directdispense.style.display="none";
		ivadmixture.style.display="none";
		 databaseinterface.style.display="none";
		adr.style="display";
		adr.style.visibility="visible";
		adr.style.backgroundColor = "#e2e3f0";
		//patientCol3.src="../../ePH/images/IV Admixture.gif";
		medicationAdministration.style.display="none";
		//patientCol4.src="../../ePH/images/Medication Administration_click.gif";
		//patientCol1.src="../../ePH/images/Outpatient.gif";
		//patientCol2.src="../../ePH/images/Inpatient.gif";
		//patientCol6.src="../../ePH/images/Direct-Dispensing-Rules_Click.gif";
		//patientCol7.src="../../ePH/images/Drug Database Interface.gif";
		
	}
	else if(mode == "DirectDispensingRules_tab" ){
		//patientCol6.src="../../ePH/images/Direct-Dispensing-Rules.gif";
		outpatient.style.display="none";
		//commontable.style.visibility="visible";//commented CRF-713 INC 12785  for general tab
		general.style.display="none";//Added CRF-713 INC 12785  for general tab 
		inpatient.style.display="none";
		ivadmixture.style.display="none";
		adr.style.display="none";
		 databaseinterface.style.display="none";
	    directdispense.style="display";
		directdispense.style.visibility="visible";
		directdispense.style.backgroundColor = "#e2e3f0";
		//patientCol3.src="../../ePH/images/IV Admixture.gif";
		medicationAdministration.style.display="none";
		//patientCol4.src="../../ePH/images/Medication Administration_click.gif";
		//patientCol1.src="../../ePH/images/Outpatient.gif";
		//patientCol2.src="../../ePH/images/Inpatient.gif";
		//patientCol5.src="../../ePH/images/ADRTDMRules_click.gif";
		//patientCol7.src="../../ePH/images/Drug Database Interface.gif";
		
	}
	else if(mode == "general_tab"){//Start of Add 1st part of CRF-713 INC 12785  for general tab
		outpatient.style.display="none";
		outpatient.style.visibility="hidden";
		inpatient.style.display="none";
		ivadmixture.style.display="none";
		adr.style.display="none";
		directdispense.style.display="none";
        medicationAdministration.style.display="none";
	    directdispense.style.visibility="hidden";
	    databaseinterface.style.display="none";
		databaseinterface.style.visibility="hidden";
		general.style="display";
		general.style.visibility="visible";
		general.style.backgroundColor = "#e2e3f0";
	}//End of Add 1st part of CRF-713 INC 12785  for general tab
}

function callDrugDatabaseInterface(){
	//document.parameter_facility_form.all.drug_database_interface_tab.src='../../ePH/images/Drug Database Interface_click.gif';
	document.parameter_facility_form.drug_database_interface.style.display="inline";
	document.parameter_facility_form.drug_database_interface.style.visibility="visible";
}

function reset(){
	f_query_add_mod.document.location.href="../../ePH/jsp/ParamFacilityAddModify.jsp?function_id="+function_id;
	/*f_query_add_mod.document.parameter_facility_form.reset();
	  validateRefill(document.parameter_facility_form.refill_yn);
	*/
}
function apply() {
	var formObj = f_query_add_mod.document.parameter_facility_form ;
	if (formObj.refill_yn.checked){
		var fields = new Array ( formObj.max_refills_for_pres,formObj.max_durn_for_refill_pres );
		var names = new Array (getLabel("ePH.MaxNoofRefillsAllowed.label","PH"),getLabel("ePH.MaxDurationforRefillPrescriptions.label","PH"));
		if (! f_query_add_mod.checkFields( fields, names, messageFrame)){
			if (formObj.max_refills_for_pres.value==""){
				formObj.max_refills_for_pres.focus();
			}
			else if (formObj.max_durn_for_refill_pres.value==""){
				formObj.max_durn_for_refill_pres.focus();
			}
			return false;
		}
	}
	 //Start for MMS-DM-CRF-0233-44841 by Ayesha
	if ((formObj.print_footer_dtls_pres_yn) && (formObj.print_footer_dtls_pres_yn.checked)){

		var fields = new Array ( formObj.print_pres_dtl_en,formObj.print_pres_dtl_loc );
		var names = new Array (getLabel("ePH.FooterDescription.label","PH"),getLabel("ePH.FooterDescriptioninLocalLanguage.label","PH"));
		if (! f_query_add_mod.checkFields( fields, names, messageFrame)){
			if (formObj.print_pres_dtl_en.value==""){
				formObj.print_pres_dtl_en.focus();
			}
			else if (formObj.print_pres_dtl_loc.value==""){
				formObj.print_pres_dtl_loc.focus();
			}
			return false;
		}
	}
	//Ended for MMS-DM-CRF-0233-44841 by Ayesha
	if (formObj.licenceRights.value !="PHBASIC"){		  
		if(formObj.working_hours_of_prep_room_from.value=="" && formObj.working_hours_of_prep_room_to.value!=""){
			formObj.working_hours_of_prep_room_from.select();
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("FROM_TIME_CANNOT_BE_BLANK","PH");
			return false;
		}
		 if(formObj.working_hours_of_prep_room_from.value!="" && formObj.working_hours_of_prep_room_to.value==""){
			formObj.working_hours_of_prep_room_to.select();
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("TO_TIME_CANNOT_BE_BLANK","PH");
			return false;
		}
		if (formObj.ip_fill_prd_ahead.value=="" && (formObj.ip_fill_prd_unit.value=="H" || formObj.ip_fill_prd_unit.value=="D")){
			formObj.ip_fill_prd_ahead.focus();
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("PH_FILL_PERIOD_NOT_BLANK","PH");
			return false;
		}	
		if (formObj.allow_drug_return_yn.checked){
			var fields = new Array ( formObj.max_durn_for_op_med_rtn );
			var names = new Array (getLabel("ePH.AllowMedicationReturnWithinDays.label","PH"));
			if (! f_query_add_mod.checkFields( fields, names, messageFrame)){
				if (formObj.max_durn_for_op_med_rtn.value=="" ){
					formObj.outpatient_tab.click();
					formObj.max_durn_for_op_med_rtn.focus();
					return false;
				}
			}
			if(parseInt(formObj.max_durn_for_op_med_rtn.value)==0){
				var lbltxt = getLabel("ePH.AllowMedicationReturnWithinDays.label","PH");
				var msg = getMessage("HEIGHT_WEIGHT_CANNOT_ZERO","PH");
				msg = msg.replace('$', lbltxt);
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg;
				formObj.outpatient_tab.click();
				formObj.max_durn_for_op_med_rtn.focus();
				return false;
			}		
		}
		if (formObj.drug_db_interface_yn.checked){
			if(formObj.drug_db_interface_name.value==""){
           		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("PH_EXT_DB_NOT_BLANK","PH");
				return false;
			}		
		}
		if (formObj.mar_start_ind.value=='U'){
			if(formObj.mar_past_day.value=="" || formObj.mar_future_day.value==""){
           		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("PH_PARM_FACI_MAR_DAISP_DAYS","PH");
				return false;
			}		
		}
	}
	if (formObj.em_medctn_fwd_ip_yn.checked){ //Added for Bru-HIMS-CRF-402[IN044065] -start
		if(formObj.cary_frwd_ord_nofhrs.value=="" || parseInt(formObj.cary_frwd_ord_nofhrs.value)==0){
			var lbltxt = getLabel("ePH.EmergencyEncounterDurationWithin.label","PH");
			var msg = getMessage("HEIGHT_WEIGHT_CANNOT_ZERO","PH");
			msg = msg.replace('$', lbltxt);
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg;
			formObj.general_tab.click();
			formObj.em_medctn_fwd_ip_yn.focus();
			return false;
		}
	}//added for Bru-HIMS-CRF-402[IN044065] -end

	var fields = new Array ( ); //-Added for AMS-CRF-0009[IN:030935] -Start
	var names = new Array ();
	var count=0;
	////Added for HSA-CRF-0239 [IN:051707] by B.Badmavathi on 02/02/2016 starts
	fields[count] = formObj.working_hour_from;
	names[count++] = getLabel("Common.fromtime.label","Common");
	fields[count] = formObj.working_hour_to;
	names[count++] = getLabel("Common.totime.label","Common");
	//Added for HSA-CRF-0239 [IN:051707] by B.Badmavathi on 02/02/2016 ends
	if (formObj.disp_before_start_date_yn_ip.checked){ //from date
		fields[count] = formObj.disp_beyond_no_of_days_ip;
		names[count++] = getLabel("ePH.UptoNoofDays.label","PH")+" IP";
	}
	if (formObj.disp_beyond_earliest_start_yn_ip.checked){ //todate
		fields[count] = formObj.disp_before_no_of_days_ip;
		names[count++] = getLabel("ePH.NoofdaysAhead.label","PH")+" IP";
	}
	if (formObj.disp_before_start_date_yn.checked){
		fields[count] = formObj.disp_before_no_of_days;
		names[count++] = getLabel("ePH.NoofdaysAhead.label","PH")+" OP";
	}
	if (formObj.disp_beyond_earliest_start_yn.checked){
		fields[count] = formObj.disp_beyond_no_of_days;
		names[count++] = getLabel("ePH.UptoNoofDays.label","PH")+" OP";
	}
	//Added for MMS-DM-CRF-0177
	
	if(formObj.pre_alloc_check.value=="Y"){
    if(formObj.expiry_stock_1.checked && formObj.pre_alloc_appl_yn.checked){
    	if (formObj.durn_value.value==""){
			formObj.durn_value.focus();
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("PH_NEAR_EXPIRY_CANT_BE_BLANK","PH");
			return false;
		}	
		if(formObj.durn_type.value=='N'){
			formObj.durn_type.focus();
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("PH_NEAR_EXPIRY_CANT_BE_BLANK","PH");
			return false;
		}
    }
  }
	//Added for MMS-DM-CRF-0177
	if(count>0){
		if(!f_query_add_mod.checkFields( fields, names, messageFrame))
			return false;
	} //-Added for AMS-CRF-0009[IN:030935] End
	eval(formApply( formObj,PH_CONTROLLER ));
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
	if( result ) {
		onSuccess(); 
	}
}

function onSuccess() {
	f_query_add_mod.document.location.href="../../ePH/jsp/ParamFacilityAddModify.jsp?function_id="+function_id;
}

function validateRefill(obj,flag){
	var formObj=document.parameter_facility_form.all;
	if(obj.checked){
		formObj.max_refills_for_pres.disabled=false;
		formObj.max_refills_for_pres.focus();
		formObj.max_no_of_refills_allowed_man.style.visibility="visible";
		formObj.max_durn_for_refills_pres_man.style.visibility="visible";
		formObj.max_durn_for_refill_pres.disabled=false;
		if(flag=='Y')
			formObj.print_refill_pres_with_main_yn.disabled=false;
	}
	else{
		formObj.max_refills_for_pres.value="";
		formObj.max_refills_for_pres.disabled=true;
		formObj.max_durn_for_refill_pres.value="";
		formObj.max_durn_for_refill_pres.disabled=true;
		formObj.max_no_of_refills_allowed_man.style.visibility="hidden";
		formObj.max_durn_for_refills_pres_man.style.visibility="hidden";
		formObj.print_refill_pres_with_main_yn.checked=false;
		formObj.print_refill_pres_with_main_yn.disabled=true;
	}
}

function validateDispensingRules(obj){
	var formObj=document.parameter_facility_form.all;
	if (obj.checked){
		formObj.disp_before_no_of_days.disabled=false;
		formObj.disp_before_no_of_days.focus();
	}
	else{
		formObj.disp_before_no_of_days.value="";
		formObj.disp_before_no_of_days.disabled=true;
	}
}

function validateDispensingPastOrders(obj){
	var formObj=document.parameter_facility_form.all;
	if (obj.checked){
		formObj.disp_beyond_no_of_days.disabled=false;
		formObj.disp_beyond_no_of_days.focus();
	}
	else{
		formObj.disp_beyond_no_of_days.value="";
		formObj.disp_beyond_no_of_days.disabled=true;
	}
}

function validateDispensingPastOrdersInPatient(obj){ //added for AMS-CRF-0009[IN:030935] -start
	var formObj=document.parameter_facility_form.all;
	if (obj.checked){
		formObj.disp_before_no_of_days_ip.disabled=false;
		formObj.disp_before_no_of_days_ip.focus();
		formObj.disp_before_no_of_days_ip.value=0;
	}
	else{
		formObj.disp_before_no_of_days_ip.value="";
		formObj.disp_before_no_of_days_ip.disabled=true;
	}
}

function validateDispensingRulesInPatient(obj){ //added for AMS-CRF-0009[IN:030935] -end
	var formObj=document.parameter_facility_form.all;
	if (obj.checked){
		formObj.disp_beyond_no_of_days_ip.disabled=false;
		formObj.disp_beyond_no_of_days_ip.focus();
		formObj.disp_beyond_no_of_days_ip.value=30;
		
	}
	else{
		formObj.disp_beyond_no_of_days_ip.value="";
		formObj.disp_beyond_no_of_days_ip.disabled=true;
	}
}

function validateFilling(obj){
	var formObj=document.parameter_facility_form;
	if (document.parameter_facility_form.licenceRights.value != "PHBASIC"){
		clearParmacistVerification();
		clearDispFillStage();
		if (obj.checked){
			formObj.disp_fill_stage.disabled = false;
			var element1 = document.createElement('OPTION') ;
			element1.value		=  "B" ;
			element1.text		=  "Before Allocation" ;
			var element2 = document.createElement('OPTION') ;
			element2.value		=  "A" ;
			element2.text		=  "After Allocation" ;
			formObj.disp_fill_stage.add(element1);
			formObj.disp_fill_stage.add(element2);
		}
		else{
			var element1 = document.createElement('OPTION') ;
			element1.value		=  "X" ;
			element1.text		=  "Not Applicable" ;
			formObj.disp_fill_stage.add(element1);
			formObj.disp_fill_stage.disabled = true;
			var element1 = document.createElement('OPTION') ;
			element1.value		=  "B" ;
			element1.text		=  "Separate Before Allocation" ;
			var element2 = document.createElement('OPTION') ;
			element2.value		=  "C" ;
			element2.text		=  "Combined With Allocation" ;
			formObj.disp_verf_stage.add(element1);
			formObj.disp_verf_stage.add(element2);
		}
	}
	/*if (obj.checked){
		var element1 = document.createElement('OPTION') ;
		element1.value		=  "S" ;
		element1.text		=  "Separate" ;
		var element2 = document.createElement('OPTION') ;
		element2.value		=  "B" ;
		element2.text		=  "Before Filling" ;
		var element3 = document.createElement('OPTION') ;
		element3.value		=  "A" ;
		element3.text		=  "With Allocation" ;
		formObj.disp_verf_stage.add(element1);
		formObj.disp_verf_stage.add(element2);
		formObj.disp_verf_stage.add(element3);
	}
	else{
		var element1 = document.createElement('OPTION') ;
		element1.value		=  "S" ;
		element1.text		=  "Separate" ;
		var element2 = document.createElement('OPTION') ;
		element2.value		=  "B" ;
		element2.text		=  "Before Allocation" ;
		var element3 = document.createElement('OPTION') ;
		element3.value		=  "A" ;
		element3.text		=  "With Allocation" ;
		formObj.disp_verf_stage.add(element1);
		formObj.disp_verf_stage.add(element2);
		formObj.disp_verf_stage.add(element3);
	}*/

}

function clearParmacistVerification(){
	var len =document.parameter_facility_form.disp_verf_stage.options.length;
	for(var i=0;i<=len;i++) {
		document.parameter_facility_form.disp_verf_stage.remove("disp_verf_stage") ;
	}
	/*var tp = "---Select---" ;
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ;
	document.parameter_facility_form.disp_verf_stage.add(opt);  */
}
function clearDispFillStage(){
	var len =document.parameter_facility_form.disp_fill_stage.options.length;
	for(var i=0;i<=len;i++) {
		document.parameter_facility_form.disp_fill_stage.remove("disp_fill_stage") ;
	}
}

function validateDelivery(obj){
	var formObj=document.parameter_facility_form.all;
	if (obj.checked){
		formObj.disp_cash_coll_stage.disabled=false;
	}
	else{
		formObj.disp_cash_coll_stage.value="";
		formObj.disp_cash_coll_stage.disabled=true;
	}
}
function validateMedication(obj){
	var formObj=document.parameter_facility_form.all;
	if (obj.checked){
		formObj.max_durn_for_op_med_rtn.disabled=false;
		formObj.max_durn_for_op_med_rtn.focus();
		formObj.imgForWithin.style.visibility="visible";
		formObj.max_drug_retention_bef_rtn.disabled=false;
	}
	else{
		formObj.max_durn_for_op_med_rtn.disabled=true;
		formObj.max_durn_for_op_med_rtn.value="";
		formObj.imgForWithin.style.visibility="hidden";
		formObj.max_drug_retention_bef_rtn.disabled=true;
		formObj.max_drug_retention_bef_rtn.value="";
	}
}

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

function CheckTime(obj) {
	var timefield = obj;
	if (tmchk(obj) == false) {
		alert(getMessage("INVALID_TIME_FMT",'PH'));
		timefield.select();
		timefield.focus();
		return false;
	}
	else {
		return true;
	}
}

function tmchk(obj1) {
	var strTime;
	var strHr;
	var strMi;
	var timefield = obj1;
	var strTimeArray = new Array();
	strTime = timefield.value;
	if (strTime.length == 0) 
		return true;
	strTimeArray = strTime.split(":");
	if (strTimeArray.length != 2) {
		return false;
	}
	else {
		strHr = strTimeArray[0];
		strMi = strTimeArray[1];
	}
	if (strHr.length > 2) return false;
	if (strMi.length > 2) return false;
	if (isNaN(strHr) == true) return false;
	if (isNaN(strMi) == true) return false;
	if (strHr < 0 || strHr > 23) return false;
	if (strMi < 0 || strMi > 59) return false;
}

function beforePost(xmlStr){
}

function StateCheck(){ 
	var formObj=document.frames.parameter_facility_form.display_charge_details_lkp;
	var formObj1=document.frames.parameter_facility_form.display_price_type_lkp;
	if(formObj.checked==true){
		document.parameter_facility_form.display_price_type_lkp.disabled	= false;
	}	
}

function CheckList(){
	var formObj=document.frames.parameter_facility_form.display_charge_details_lkp;
	var formObj1=document.frames.parameter_facility_form.display_price_type_lkp;
	if(formObj.checked==true){
		formObj1.disabled=false;
		var len = formObj1.length; 
		for (var i=0; i<len; i++) {
			formObj1.selectedIndex=0;
			if(i > 1){
				formObj1.remove(i); 
			}
		}
	}
	else{
		var opt	= document.createElement('OPTION');
		opt.value ="";
		opt.text = "Not Applicable";
		formObj1.add(opt);
		formObj1.selectedIndex=2;
		formObj1.disabled=true;
	}
}

function validateDispCashCollStage(obj){
	var formObj=document.frames.parameter_facility_form.disp_delv_reqd_yn;
	if (obj.value=="I" || obj.value=="D"){
		formObj.checked=true;
		formObj.disabled=true;
	}
	else{
		formObj.disabled=false;
	}
}

function validateForGreaterValue(preValue,obj, mode){
	var objVal = obj.value == "" ? "" : parseInt(obj.value);
	if (mode == 1) {
		if (document.parameter_facility_form.ip_fill_prd_unit.value == "D")
		objVal = 24*(objVal);
	}
	if (objVal != "" && (preValue != 0)){
		if (parseFloat(preValue) < parseFloat(objVal)){
			var msg	= getMessage("PH_ENT_VAL_GREATER_EXIST_VAL","PH");
			msg	= msg.replace('&',obj.id);
			alert(msg);
			obj.select();
			return true;
		}
	}
}
function validateInterfaceStockControl(obj){
	var formObj=document.parameter_facility_form;
	
	if (!obj.checked){
		formObj.consider_stock_for_pres_yn.checked=false;
		formObj.consider_stock_for_pres_yn.disabled=true;
	}
	else{
		formObj.consider_stock_for_pres_yn.disabled=false;
	}
}
function validateConsiderStock(obj){
	var formObj=document.parameter_facility_form;
	if (!obj.checked){
		formObj.allow_pres_without_stock_yn.checked=false;
		formObj.allow_pres_without_stock_yn.disabled=true;
	}
	else{
		formObj.allow_pres_without_stock_yn.disabled=false;
	}
}
function validateFillingStages(){
	var formObj=document.parameter_facility_form;
	clearPharmacistVerification();
	if (formObj.disp_fill_stage.value=="B"){
		var element1 = document.createElement('OPTION') ;
		element1.value		=  "F" ;
		element1.text		=  "Separate Before Fill" ;

		var element2 = document.createElement('OPTION') ;
		element2.value		=  "C" ;
		element2.text		=  "Combined With Allocation" ;

		formObj.disp_verf_stage.add(element1);
		formObj.disp_verf_stage.add(element2);
	}else{
		var element1 = document.createElement('OPTION') ;
		element1.value		=  "B" ;
		element1.text		=  "Separate Before Allocation" ;

		var element2 = document.createElement('OPTION') ;
		element2.value		=  "C" ;
		element2.text		=  "Combined With Allocation" ;

		formObj.disp_verf_stage.add(element1);
		formObj.disp_verf_stage.add(element2);
	}
}

function clearPharmacistVerification(){
	var len =document.parameter_facility_form.disp_verf_stage.options.length;
	for(var i=0;i<=len;i++) {
		document.parameter_facility_form.disp_verf_stage.remove("disp_verf_stage") ;
	}
}
function validateRecordAdmin(obj){
	if(parseFloat(obj.value)>24 ){
		//parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ getMessage("PH_DISP_MED_RECORD_ADMIN","PH");
		alert(getMessage("PH_DISP_MED_RECORD_ADMIN","PH"));
		obj.select();
		obj.focus();
	}
}

function toggleEditingFill(objVal) {
	if (objVal == "P") {
		document.parameter_facility_form.ip_fill_prd_ahead.value	= "";
		document.parameter_facility_form.ip_fill_prd_ahead.disabled	= true;
	}
	else {
		document.parameter_facility_form.ip_fill_prd_ahead.disabled	= false;
		document.parameter_facility_form.ip_fill_prd_ahead.focus();
	}
}

function checkAllowStock(obj){
		var formObj=document.parameter_facility_form;
	if (!obj.checked){
		formObj.ip_allow_stock.checked=false;
		formObj.ip_allow_stock.disabled=true;
	}
	else{
		formObj.ip_allow_stock.disabled=false;
	}
}
function disablefields(){
	/*var formObj=document.parameter_facility_form;
	formObj.alert_beyond_working_hours.disabled=true;
	formObj.iv_admixture_applicable.disabled=true;
	formObj.cdr_admixture_applicable.disabled=true;
	formObj.prep_of_tpn_non_std_regimen.disabled=true;*/

	//formObj.allow_usage_of_spil_qty_yn.disabled=true;
	//formObj.charge_qty_ind[0].value="";
	//formObj.charge_qty_ind[1].value="";
	//formObj.charge_qty_ind[0].disabled=true;
	//formObj.charge_qty_ind[1].disabled=true;
}
function enablefields(obj){
	/*var formObj=document.parameter_facility_form;
	formObj.alert_beyond_working_hours.disabled=false;
	formObj.iv_admixture_applicable.disabled=false;
	formObj.cdr_admixture_applicable.disabled=false;
	formObj.prep_of_tpn_non_std_regimen.disabled=false;*/
}
function enableqty(){
	/*alert("enableqty");
	var formObj=document.parameter_facility_form;
	alert("allow_usage_of_spil_qty_yn-->" +allow_usage_of_spil_qty_yn.value);
	formObj.allow_usage_of_spil_qty_yn.disabled=false;
	formObj.allow_usage_of_spil_qty_yn.checked=true;
	formObj.charge_qty_ind[0].disabled=false;
	formObj.charge_qty_ind[1].disabled=false;
	*/
}

function comparetime() {
	var formObj=document.parameter_facility_form;
	var obj1=formObj.working_hours_of_prep_room_from.value;
	var obj2=formObj.working_hours_of_prep_room_to.value;	
	var strHr;
	var strMi;
	
	var strHr1;
	var strMi1;

	var timefield = obj1;
	var strTimeArray = new Array();

	var timefield1 = obj2;
	var strTimeArray1 = new Array();
	if(obj1 =="" && obj2 == "" ){
		unchkfields(); disablefields();
	}
	else if(obj1!="" && obj2 == ""){
			return true;}
    else if(obj1!="" && obj2 !=""){
	    strTimeArray = timefield.split(":");
		strHr = strTimeArray[0];
		strMi = strTimeArray[1];
        strTimeArray = timefield1.split(":");
		strHr1 = strTimeArray[0];
		strMi1 = strTimeArray[1];
		if(strHr > strHr1){
		alert(getMessage("TO_TIME_MUST_BE_GREATER_THAN_FROM_TIME","PH"));
		formObj.working_hours_of_prep_room_to.select();
		return false;
		}
		if(strHr == strHr1){
			     if(strMi > strMi1){ alert(getMessage("TO_TIME_MUST_BE_GREATER_THAN_FROM_TIME","PH"));
				 formObj.working_hours_of_prep_room_to.select();
				 return false;
				 }
	    }
	}
}
function unchkfields(){
	//alert("unchkfields function");
	 var formObj=document.parameter_facility_form;
	 formObj.alert_beyond_working_hours.checked=false;
	 formObj.iv_admixture_applicable.checked=false;
	 formObj.cdr_admixture_applicable.checked=false;
	 formObj.prep_of_tpn_non_std_regimen.checked=false;
	 //formObj.allow_usage_of_spil_qty_yn.checked=false;
	 //alert(formObj.allow_usage_of_spil_qty_yn.value);
//formObj.charge_qty_ind[0].checked=false;
	 //formObj.charge_qty_ind[1].checked=false;
	 //alert("before"+formObj.charge_qty_ind.value);
	 //formObj.charge_qty_ind.value="";
	 //alert("after"+formObj.charge_qty_ind.value);
}
function chkforvalidity(){
	//alert("chkforvalidity function");
    var formObj=document.parameter_facility_form;
	var from_time=formObj.working_hours_of_prep_room_from.value;
	var to_time=formObj.working_hours_of_prep_room_to.value;
	//alert("from_time---->" +from_time);
	//alert("to_time---->" +to_time);
	if(from_time ==""){
		//alert("if")
		from_time = "00:00";}
	if(to_time == ""){
		//alert("to")
		to_time= "00:00";}
	if(from_time == "00:00"  && to_time == "00:00"){
		//alert("");
		disablefields();
		unchkfields();
    }
}
/*function chkval(){
	alert("chkval");
	var formObj=document.parameter_facility_form;
	if(formObj.iv_admixture_applicable.checked==false && formObj.cdr_admixture_applicable.checked==false && formObj.prep_of_tpn_non_std_regimen.checked==false ){
			alert("chkval");
			//alert("allow_usage_of_spil_qty_yn--->" +allow_usage_of_spil_qty_yn.value);
		//formObj.allow_usage_of_spil_qty_yn.checked=false;
		//formObj.allow_usage_of_spil_qty_yn.disabled=true;
		//formObj.charge_qty_ind[0].disabled=true;
		//formObj.charge_qty_ind[1].disabled=true;
		//formObj.charge_qty_ind[0].checked=false;
		//formObj.charge_qty_ind[1].checked=false;
		//formObj.charge_qty_ind[0].value="";
		//formObj.charge_qty_ind[1].value="";
		}
	else if(formObj.iv_admixture_applicable.checked==true || formObj.cdr_admixture_applicable.checked==true || formObj.prep_of_tpn_non_std_regimen.checked==true ){
			//formObj.allow_usage_of_spil_qty_yn.checked=true;
		}
	
}*/
function chktimefld(){   
	var formObj=document.parameter_facility_form;
	if(formObj.working_hours_of_prep_room_from.value=="" && formObj.working_hours_of_prep_room_to.value!=""){ 
		alert(getMessage("TO_TIME_MUST_BE_GREATER_THAN_FROM_TIME","PH"));
		formObj.working_hours_of_prep_room_from.select();
		return false;
	}
}

function  appedzero(obj){
	var from_val	=	obj.value;
	if(from_val != ""){
		var frm_hrs		=	new Array();
		frm_hrs=from_val.split(":");
		var strHr;
		var strMi;
		strHr = frm_hrs[0];
		strMi = frm_hrs[1];
		if(strHr.length==1) {  
			strHr	=	"0"+ strHr;
		}
		if(strMi.length==1) {  
			strMi	=	"0"+ strMi;
		}
		obj.value=strHr+":"+strMi;
	}
}

function validate(obj){
	if(CheckTime(obj) == false){
		obj.value=""; 
		obj.select();
		obj.focus();
	}
	else{
		appedzero(obj);
		comparetime();
	}
}

function applicablePatient(obj){
	var formObj=document.parameter_facility_form;
	document.parameter_facility_form.flag1.value=obj.value;
} 

 function EnableDispening(obj){
	var formObj=document.parameter_facility_form;
	if (formObj.direct_dispensing_allowed.checked ==true ){
	 	formObj.direct_dispensing_allowed.value="Y";
		document.getElementById("app_patient_class").style="display";
		document.getElementById("class_patient").style="display";
		document.getElementById("App_Encounter").style="display";
		document.getElementById("radio_encounter").style="display";
		document.getElementById("text_last").style="display";
		document.getElementById("text_encounter").style="display";
		document.getElementById("encounter_details").style="display";
		document.getElementById("check_encounter").style="display";
	 }
	 else{
        formObj.direct_dispensing_allowed.value="N";
	 	document.getElementById("app_patient_class").style.display= "none";
		document.getElementById("class_patient").style.display= "none";
		document.getElementById("App_Encounter").style.display= "none";
		document.getElementById("radio_encounter").style.display= "none";
		document.getElementById("text_last").style.display= "none";
		document.getElementById("text_encounter").style.display= "none";
		document.getElementById("encounter_details").style.display= "none";
		document.getElementById("check_encounter").style.display= "none";
	}
}

function  setEncounter(){
	var formObj=document.parameter_facility_form;
	if (formObj.Encounter_details_required.checked ==true )
		formObj.Encounter_details_required.value = "Y";
	else
		formObj.Encounter_details_required.value = "N";
}

function applicabeEncounter(obj){
	var formObj=document.parameter_facility_form;
	document.parameter_facility_form.flag.value=obj.value;
}

function chkzero(obj){
	if(obj.value =="0" || obj.value==""){
		alert(getMessage("PH_NOT_BLANK_ZERO","PH"));
		obj.focus();
	}
}

async function reporting (obj,from){	
	var formObj = document.parameter_facility_form;
	if(from=='TDM'){	
		//alert("from==TDM");
	     obj_name = formObj.tdm_reporting_type_name;
		 //alert("obj_name--->" +obj_name);
		 obj_id = formObj.tdm_reporting_id;
		 type = formObj.tdm_result_type.value;
	}
	else if(from=='PAT_COUNS'){		 
	     obj_name = formObj.pat_couns_reporting_type_name;
		 obj_id   = formObj.pat_couns_reporting_id;
		 type = formObj.pat_couns_result_type.value;
	}
	else if(from=='TPN'){		
	     obj_name = formObj.tpn_reporting_type_name;
		 obj_id = formObj.tpn_reporting_id;
		 //alert("obj_id--->" +obj_id);
		 type = formObj.tpn_screening_type.value;
	}
	else if(from=='ONCOLOGY'){		
	     obj_name = formObj.onc_reporting_type_name;
		 obj_id = formObj.onc_reporting_id;
		 type = formObj.oncology_screening_type.value;
	}

    if(type=='D'){
		//alert("type=D");
        query  = formObj.discrete_mes_query.value;
	}
	else if(type=='N' && (from=='TPN' || from=='ONCOLOGY')) {
        query  =formObj.ca_note_type_scrng_query.value;
	}
	else if(type=='N' && (from=='TDM' || from=='PAT_COUNS')) {
        query  =formObj.ca_note_type_query.value;
	}
    var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

    argumentArray[0]   = escape(query)+"'"+formObj.language_id.value+"'";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = obj_name.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ;
	
	retVal =await CommonLookup(getLabel("ePH.Reportingtype.label","PH"), argumentArray );
	var str =unescape(retVal);
	var arr = str.split(",");
	if(retVal != null && retVal != "" )  {		
		obj_name.value   = arr[1] ;
		obj_id.value     = arr[0];		
		obj_name.disabled	 =	false;
	}
 }

 function cleardata(from){
	 var formObj = document.parameter_facility_form;
	 if(from =='TDM'){
        formObj.tdm_reporting_type_name.value       = "";
	    formObj.tdm_reporting_id.value              = "";
		//alert(formObj.tdm_result_type.value);
		if(formObj.tdm_result_type.value==''){
			formObj.tdm_reporting_type_search.disabled=true;
		}
		else{
			formObj.tdm_reporting_type_search.disabled=false;
		}
	 }
	 else if(from =='PAT_COUNS'){
		formObj.pat_couns_reporting_type_name.value = "";
	    formObj.pat_couns_reporting_id.value        = "";
		//alert(formObj.pat_couns_result_type.value);
		if(formObj.pat_couns_result_type.value==''){
			formObj.pat_couns_reporting_type_search.disabled=true;
		}
		else{
			formObj.pat_couns_reporting_type_search.disabled=false;
		}
	 }
	 else if(from =='TPN'){
		formObj.tpn_reporting_type_name.value = "";
	    formObj.tpn_reporting_id.value        = "";

		//alert(formObj.tpn_screening_type.value);
		if(formObj.tpn_screening_type.value==''){
			formObj.tpn_reporting_type_search.disabled=true;
			formObj.tpn_reporting_type_name.disabled=true;
		}
		else{
			formObj.tpn_reporting_type_search.disabled=false;
			formObj.tpn_reporting_type_name.disabled=false;
		}
	 }
	 else if(from =='ONCOLOGY'){
		formObj.onc_reporting_type_name.value = "";
	    formObj.onc_reporting_id.value        = "";
		//alert(formObj.oncology_screening_type.value);
		if(formObj.oncology_screening_type.value==''){
			formObj.onc_reporting_type_search.disabled=true;
			formObj.onc_reporting_type_name.disabled=true;
		}
		else{
			formObj.onc_reporting_type_search.disabled=false;
			formObj.onc_reporting_type_name.disabled=false;
		}
	 }
 }

function selectchk(obj){
	var formObj=document.parameter_facility_form;
	if (obj.checked){
		//formObj.drug_cat_pin_auth_reqd_yn.checked=true;
		formObj.drug_cat_pin_auth_reqd_yn.disabled=false;
	}
	else{
		formObj.drug_cat_pin_auth_reqd_yn.checked=false;
		formObj.drug_cat_pin_auth_reqd_yn.disabled=true;
	}
}

function Display_IP(mode,IPExists){
	//alert("Enter");
	selectTab(mode);
	Display(mode,IPExists);
}

function SelectDefaultChk(obj){
	 //alert("SelectDefaultChk");
	var formObj=document.parameter_facility_form;
	if(obj.checked) {
		formObj.tpn_screening_type.disabled=false;
		//formObj.tpn_reporting_type_name.disabled=false;
		//	formObj.tpn_reporting_type_search.disabled=false;
		obj.value="Y";
	}
	else{
		if(formObj.tpn_screening_type.options.length > 0){
			formObj.tpn_screening_type.selectedIndex=0;
			obj.value="N";
		}
		cleardata('TPN');
		formObj.tpn_screening_type.disabled=true;
		formObj.tpn_reporting_type_search.disabled=true;
		formObj.tpn_reporting_type_name.disabled=true;
	}
}

function OncologyChk(obj){
	var formObj=document.parameter_facility_form;
	if(obj.checked) {
		formObj.oncology_screening_type.disabled=false;
		formObj.onc_reporting_type_search.disabled=false;
	}
	else{
		if(formObj.oncology_screening_type.options.length > 0){
			//document.prescription_detail_form.qty_desc.selectedIndex=0;
			formObj.oncology_screening_type.selectedIndex=0;
		}
		cleardata('ONCOLOGY');
		formObj.oncology_screening_type.disabled=true;
		formObj.onc_reporting_type_search.disabled=true;
		formObj.onc_reporting_type_name.disabled=true;
	}
}

 function disableextdatabasevalues(obj){
   var formObj=document.parameter_facility_form;
   if(obj.checked){
	   obj.value='Y';
       formObj.drug_db_interface_name.disabled=false;
		/**	* @Name - Mahesh
		* @Date - 04/01/2010
		* @Inc# - IN012503
		* @Desc - If CIMS, Dosage and Contra CheckBoxes will be disabled else will be enabled.
		*/
		if(formObj.drug_db_interface_name.value=="CIMS"){
		   //formObj.drug_db_dosecheck_yn.disabled=true;
		   //formObj.drug_db_contracheck_yn.disabled=true; // remove it in June 2012, integration given for contraindication also
		   formObj.drug_db_contracheck_yn.disabled=false; // Added in june 2012
	   }
	   else{
		   formObj.drug_db_dosecheck_yn.disabled=false;
		   formObj.drug_db_contracheck_yn.disabled=false;
	   }
	   formObj.drug_db_duptherapy_yn.disabled=false;
	   formObj.drug_db_interaction_yn.disabled=false;
	   formObj.drug_db_alergycheck_yn.disabled=false;
	   formObj.drug_db_name_img.style.visibility="visible";
	}
	else{
		obj.value='N';
        formObj.drug_db_interface_name.selectedIndex=0;
		formObj.drug_db_dosecheck_yn.checked =false;
		formObj.drug_db_duptherapy_yn.checked=false;
		formObj.drug_db_interaction_yn.checked=false;
		formObj.drug_db_contracheck_yn.checked=false;
		formObj.drug_db_alergycheck_yn.checked=false;

		formObj.drug_db_interface_name.disabled=true;
		formObj.drug_db_dosecheck_yn.disabled  =true;
		formObj.drug_db_duptherapy_yn.disabled =true;
		formObj.drug_db_interaction_yn.disabled=true;
		formObj.drug_db_contracheck_yn.disabled=true;
		formObj.drug_db_alergycheck_yn.disabled=true;
		formObj.drug_db_name_img.style.visibility="hidden";
	}
 }

 function  appedzero(obj){
	if(obj.value != null && obj.value != ""){
		var from_val	=	obj.value;
		var frm_hrs		=	new Array();
		if(from_val.indexOf(":") != -1){
			frm_hrs=from_val.split(":");
			var strHr;
			var strMi;
			strHr = frm_hrs[0];
			strMi = frm_hrs[1];
			if(strHr.length==1) { strHr	= "0"+ strHr; }else if(strHr.length==0){strHr = "00"; }else if(strHr.length>2){strHr = "00"; }
			if(strMi.length==1) { strMi	= "0"+ strMi; }else if(strMi.length==0){strMi = "00"; }else if(strMi.length>2){strMi = "00"; }
			obj.value=strHr+":"+strMi;
		}
		else{
			if(from_val.length == 1){
				obj.value= "0"+from_val+":"+"00";
			}
			else if (from_val.length == 2){
				obj.value= from_val+":"+"00";
			}
		}
	}
}

function validateAdministerBeforeScheduleTime(obj1,obj2){
	var res=CheckNum(obj1);
	if(res!=undefined && res==true){
		var temptime=obj1.value;
		if(temptime.indexOf('.')==-1){			
			if(obj2.value=='M'){
				if(parseInt(temptime)>59 || parseInt(temptime)<0 ){
				  //alert(getMessage('INVALID_TIME_MINUTE','PH'));	Commented for inc 13449
				  alert(getMessage('PH_RECORD_ADMINISTRATION_BEFORE_SCHEDULE_TIME_MIN','PH'));
				  obj1.select();
				  obj1.focus();
				  return false;
				}
				else{
					return true;
				}
			}
			if(obj2.value=='H'){
				if(parseInt(temptime)>24 || parseInt(temptime)<1 ){
					// alert(getMessage('INVALID_TIME_HOUR_1_24','PH'));Commented for inc 13449
					alert(getMessage('PH_RECORD_ADMINISTRATION_BEFORE_SCHEDULE_TIME_HRS','PH'));
					obj1.select();
					obj1.focus();
					return false;
				}
				else{
					return true;
				}
			}
		}
		else{
			alert(getMessage("NO_DECIMAL","PH"));
			obj1.select();
			obj1.focus();
			return false
		}
		
	}
	else
		return false;
}
//To check zeros
function checkIsNotZero(obj, appendObj){
	if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0)
	    return true;
	else {
		if ( obj.value.length > 0 && obj.value==0){
			alert(getMessage("ZERO_NOT_ALLOWED","PH")+" " + appendObj);
			obj.select();
			obj.focus();
			return false;
		}
	}
}

function checkSplChars(obj)	{
	if(!CheckChars(obj))	{
		alert(getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","PH"));
		obj.select();
	}
}
//Added for  CRF-713 INC 12785  
function validateNarcoticAprvlForm(obj){
	var formObj=document.parameter_facility_form.all;
	if(obj.checked){
		formObj.print_narcotic_form_by_default.disabled=false;
	}
	else{
		formObj.print_narcotic_form_by_default.checked=false;
		formObj.print_narcotic_form_by_default.disabled=true;
	}
}
/**
	* @Name - Mahesh
	* @Date - 04/01/2010
	* @Inc# - IN012503
	* @Desc - To Disable Some CheckBoxes if CIMS is selected.
	*/

function disableContraCheck(){
	if(document.parameter_facility_form.drug_db_interface_name.value=="CIMS"){
		document.parameter_facility_form.drug_db_contracheck_yn.checked		= false;	//  Added in June 2012
		document.parameter_facility_form.drug_db_contracheck_yn.disabled	= false;	//  Added in June 2012		
	}
	else{
		document.parameter_facility_form.drug_db_dosecheck_yn.checked	= false;
		document.parameter_facility_form.drug_db_dosecheck_yn.disabled	= false;
		document.parameter_facility_form.drug_db_contracheck_yn.checked		= false;
		document.parameter_facility_form.drug_db_contracheck_yn.disabled	= false;
	}
}//  RUT-CRF-0062 [IN029600]  Added to validate Rule Based Check box  begin

function validateInpat(fldobj){
	if(fldobj.checked){
		document.parameter_facility_form.inpatient_yn_rule_check.checked	= false;
		document.parameter_facility_form.inpatient_yn_rule_check.disabled	= false;
	}
	else{
		document.parameter_facility_form.inpatient_yn_rule_check.checked	= false;
		document.parameter_facility_form.inpatient_yn_rule_check.disabled = true;
	}
}

function validateOutpat(fldobj){
	if(fldobj.checked){
		document.parameter_facility_form.outpatient_yn_rule_check.checked	= false;
		document.parameter_facility_form.outpatient_yn_rule_check.disabled	= false;
	}
	else{
		document.parameter_facility_form.outpatient_yn_rule_check.checked	= false;
		document.parameter_facility_form.outpatient_yn_rule_check.disabled = true;
	}
}

function validateDayCare(fldobj){
	if(fldobj.checked){
		document.parameter_facility_form.daycare_yn_rule_check.checked	= false;
		document.parameter_facility_form.daycare_yn_rule_check.disabled	= false;
	}
	else{
		document.parameter_facility_form.daycare_yn_rule_check.checked	= false;
		document.parameter_facility_form.daycare_yn_rule_check.disabled = true;
	}
}

function validateEmer(fldobj){
	if(fldobj.checked){
		document.parameter_facility_form.emergency_yn_rule_check.checked	= false;
		document.parameter_facility_form.emergency_yn_rule_check.disabled	= false;
	}
	else{
		document.parameter_facility_form.emergency_yn_rule_check.checked	= false;
		document.parameter_facility_form.emergency_yn_rule_check.disabled = true;
	}
}

function validateDischMed(fldobj){
	if(fldobj.checked){
		document.parameter_facility_form.dischmedic_yn_rule_check.checked	= false;
		document.parameter_facility_form.dischmedic_yn_rule_check.disabled	= false;
	}
	else{
		document.parameter_facility_form.dischmedic_yn_rule_check.checked	= false;
		document.parameter_facility_form.dischmedic_yn_rule_check.disabled = true;
	}
}//  RUT-CRF-0062 [IN029600]  Added to validate Rule Based Check box  -- end

function getMARDefDispDays(obj_mar_start_ind){
	mar_start_ind = obj_mar_start_ind.value;
	if(mar_start_ind == 'S'){
		document.parameter_facility_form.mar_week_day_start.style="display";
		document.parameter_facility_form.mar_week_day_start.value='1';
		document.getElementById("defDispDayUserDefined").style.display='none';
		document.parameter_facility_form.mar_past_day.value="";
		document.parameter_facility_form.mar_future_day.value="";
	}
	else if(mar_start_ind == 'U'){
		document.parameter_facility_form.mar_week_day_start.style.display='none';
		document.parameter_facility_form.mar_past_day.value="";
		document.parameter_facility_form.mar_future_day.value="";
		document.getElementById("defDispDayUserDefined").style="display";
	}
	else{
		document.parameter_facility_form.mar_week_day_start.style.display='none';
		document.getElementById("defDispDayUserDefined").style.display='none';
		document.parameter_facility_form.mar_past_day.value="";
		document.parameter_facility_form.mar_future_day.value="";
	}
}

function enableDisableNewMARFields(obj_mar_new_funct_yn){
	document.parameter_facility_form.mar_start_ind.value="S";
	document.parameter_facility_form.mar_week_day_start.style="display";
	document.parameter_facility_form.mar_week_day_start.value='1';
	document.getElementById("defDispDayUserDefined").style.display='none';
	document.parameter_facility_form.mar_past_day.value="";
	document.parameter_facility_form.mar_future_day.value="";
	document.parameter_facility_form.mar_default_order_by.value="O";
	document.parameter_facility_form.mar_disc_dose_yn.value="Y";
	document.parameter_facility_form.mar_disc_dose_yn.checked=false;
	document.parameter_facility_form.mar_iv_compl_dt_ind.value="I";
	if(obj_mar_new_funct_yn.checked == true){
		document.parameter_facility_form.mar_start_ind.disabled=false;
		document.parameter_facility_form.mar_week_day_start.disabled=false;
		document.parameter_facility_form.mar_default_order_by.disabled=false;
		document.parameter_facility_form.mar_disc_dose_yn.disabled=false;
		document.parameter_facility_form.mar_iv_compl_dt_ind.disabled=false;
	}
	else{
		document.parameter_facility_form.mar_start_ind.disabled=true;
		document.parameter_facility_form.mar_week_day_start.disabled=true;
		document.parameter_facility_form.mar_default_order_by.disabled=true;
		document.parameter_facility_form.mar_disc_dose_yn.disabled=true;
		document.parameter_facility_form.mar_iv_compl_dt_ind.disabled=true;
	}
}

function checkMaxDays(callFrom){
	var formObj = document.parameter_facility_form;
	var past_days = formObj.mar_past_day.value;
	var furure_days= formObj.mar_future_day.value;
	if(furure_days=="")
		furure_days=0;
	if(past_days=="")
		past_days=0;
	var totDays = parseInt(past_days)+parseInt(furure_days);
	if(parseInt(totDays)>6){
		alert(getMessage("PH_PARM_FACI_MAR_DAISP_DAYS_COUNT","PH"));
		if(callFrom =='P'){
			var tmpDays=(6 -  parseInt(past_days));
			if(tmpDays<0)
				tmpDays=0;
			formObj.mar_future_day.value = tmpDays;
			if(past_days>6)
				 formObj.mar_past_day.value = 6;
		}
		else{
			var tmpDays=(6 -  parseInt(furure_days));
			if(tmpDays<0)
				tmpDays=0;
			formObj.mar_past_day.value =  tmpDays;
			if(past_days>6)
				 formObj.mar_future_day.value = 6;
		}
	}
}

function enableWitness(obj){
	var witnessObj = document.parameter_facility_form.witness_for_verbal_order_yn;
	if(obj.checked == true){
		witnessObj.disabled=false;
	}
	else{
		witnessObj.checked=false;
		witnessObj.disabled=true;
	}
}

function enableEncouterPeriod(obj){
	var encouterPeriodObj = document.parameter_facility_form.cary_frwd_ord_nofhrs;
	var cary_frwd_ord_nofhrs_man = document.parameter_facility_form.cary_frwd_ord_nofhrs_man;
	encouterPeriodObj.value="";
	if(obj.checked==true){
		encouterPeriodObj.disabled=false;
		cary_frwd_ord_nofhrs_man.style="display";
	}
	else{
		encouterPeriodObj.disabled=true;
		cary_frwd_ord_nofhrs_man.style.display = 'none';
	}
}

function enableDefSelct(obj){
	var objEnable = document.parameter_facility_form.can_discon_dup_orders_def_sel
	if(obj.checked == true)
		objEnable.disabled = false;
	else{
		objEnable.checked = false;
		objEnable.disabled = true;
	}
}
//Added for HSA-CRF-0239 by B.Badmavathi on 30/01/2016
async function callGenericSearch(obj) {
	var formObj = parent.f_query_add_mod.document.parameter_facility_form;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	argumentArray[0] = document.forms[0].sql_ph_generic_name_select_lookup.value;
	dataNameArray  [0]="LANGUAGE_ID";
	dataValueArray [0]=document.forms[0].locale.value;
	dataTypeArray  [0]=STRING;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues =await CommonLookup(getLabel("Common.GenericName.label","Common"), argumentArray );
	var str =unescape(returnedValues);
	var arr = str.split(",");
	if((returnedValues != null) && (returnedValues != "") )  {
	 		obj.value = arr[1];
			formObj.generic_code.value = arr[0];
	} 
}
//Added for HSA-CRF-0239 [IN:051707] by B.Badmavathi on 02/02/2016 starts
function validate1(obj){
	if(CheckTime(obj) == false){
		obj.value=""; 
		obj.select();
		obj.focus();}
	else{
	appedzero(obj);
	comparetime1();
	}
}
function comparetime1() {
	var formObj=document.parameter_facility_form;
	var obj1=formObj.working_hour_from.value;
	var obj2=formObj.working_hour_to.value;
	var strHr;
	var strMi;
	var strHr1;
	var strMi1;
	var timefield = obj1;
	var strTimeArray = new Array();
	var timefield1 = obj2;
	var strTimeArray1 = new Array();
	 if(obj1!="" && obj2 !=""){	
		strTimeArray = timefield.split(":");
		strHr = strTimeArray[0];
		strMi = strTimeArray[1];
        	strTimeArray = timefield1.split(":");
		strHr1 = strTimeArray[0];
		strMi1 = strTimeArray[1];
		if(strHr > strHr1){ 
			alert(getMessage("TO_TIME_MUST_BE_GREATER_THAN_FROM_TIME","PH"));
			formObj.working_hours_to.focus();
			return false;
		}
		if(strHr == strHr1){
		     if(strMi > strMi1){ 
				  alert(getMessage("TO_TIME_MUST_BE_GREATER_THAN_FROM_TIME","PH"));
				  formObj.working_hours_to.focus();
				 return false;
			 }
	    	}
	}
}
//Added for HSA-CRF-0239 [IN:051707] by B.Badmavathi on 02/02/2016 ends
//Added by prathyusha  for JD-CRF-198 start
function SelectAmendDrugDefaultChk(obj){
	var formObj=document.parameter_facility_form;
	if(obj.checked) {
		obj.value="Y";
	}
	else{
		obj.value="N";
	}
}
//Added by prathyusha for JD-CRF-198 End

//Added for MO-CRF-20085.1  By Prathyusha on 05/18/2016 start
function chkSkipDuplicate(obj){
	var formObj=document.parameter_facility_form.all;
	var name=obj.name;
	if(name =="allow_duplicate_drug_op"){
		
		if(obj.checked) {
			document.parameter_facility_form.skip_duplicate_alert_op.disabled	= false;
			}
		else{
			document.parameter_facility_form.skip_duplicate_alert_op.disabled	= true;
			document.parameter_facility_form.skip_duplicate_alert_op.checked	= "";
			document.parameter_facility_form.overlap_duration_op.disabled	= true;
			document.parameter_facility_form.overlap_duration_op.value	= "";
			
			}
	}
	else if(name =="allow_duplicate_drug_ip"){
		
		if(obj.checked) {
			document.parameter_facility_form.skip_duplicate_alert_ip.disabled	= false;
			}
		else{
			document.parameter_facility_form.skip_duplicate_alert_ip.disabled	= true;
			document.parameter_facility_form.skip_duplicate_alert_ip.checked	= "";
			document.parameter_facility_form.overlap_duration_ip.disabled	= true;
			document.parameter_facility_form.overlap_duration_ip.value	= "";
			}
	}
}
//Modified for for MO-CRF-20085.1 modified  By Prathyusha on 05/26/2016 
	function skipDuplicate(obj){
		var formObj=document.parameter_facility_form.all;
		var name=obj.name;
	
		if(name =="skip_duplicate_alert_op"){
		if(obj.checked) {
			
			obj.value="Y";
			document.parameter_facility_form.overlap_duration_op.disabled	= false;
			}
		else{
	         obj.value="N";
	         document.parameter_facility_form.overlap_duration_op.disabled	= true;
	         }
	}
	else if(name == "skip_duplicate_alert_ip"){
		if(obj.checked) {
			
			obj.value="Y";
			document.parameter_facility_form.overlap_duration_ip.disabled	= false;
			document.parameter_facility_form.overlap_duration_ip.value	= "";
			}
		else{
	         obj.value="N";
	         document.parameter_facility_form.overlap_duration_op.disabled	= true;
	         document.parameter_facility_form.overlap_duration_ip.value	= "";
	         }
	}
}
//Added for MO-CRF-20085.1  By Prathyusha on 05/18/2016 end
	
	//Added for MMS-DM-CRF-0177 -Start
	
function applicableAllocation(near_expiry_appl_yn){
	var formObj=document.parameter_facility_form;
	document.parameter_facility_form.near_expiry_appl_yn.value=near_expiry_appl_yn;
	var chkdisable = document.parameter_facility_form.near_expiry_appl_yn.value;
	if(chkdisable=="E")
		{
		document.parameter_facility_form.durn_value.disabled = false;
		document.parameter_facility_form.durn_type.disabled = false;
		document.parameter_facility_form.expiry_stock_1.checked=true;
		document.parameter_facility_form.expiry_stock_2.checked=false;
		}
	else
		{
		document.parameter_facility_form.durn_value.disabled = true;
		document.parameter_facility_form.durn_type.disabled = true;
		document.parameter_facility_form.durn_value.value="";
		document.parameter_facility_form.durn_type.value="N";
		document.parameter_facility_form.expiry_stock_2.checked=true;
		document.parameter_facility_form.expiry_stock_1.checked=false;
		document.parameter_facility_form.durn_value_in_days.value="";
		}
}

function validateDuration(obj1,obj2)
{
	var res=CheckNum(obj1);
	if(res!=undefined && res==true){
		if(obj2.value=='D'){
			return true;
			}
		if(obj2.value=='M'){
			return true;
				}
		if(obj2.value=='Y'){
			return true;
			}
	  }
}

function ChkDuration(obj,obj1)
{
	var formObj=document.parameter_facility_form;
	var durn_type = formObj.durn_type.value;
		if(durn_type=='D'){
			obj = obj.value * 1
			}
		if(durn_type=='M'){
			obj = obj.value * 30
			}
		if(durn_type=='Y'){
			obj = obj.value * 365
			}
		document.parameter_facility_form.durn_value_in_days.value=obj;
}

function validatePreAllocationCheck(obj)
{
	if(obj.checked)
		{ 
			document.parameter_facility_form.durn_value.disabled = false;
			document.parameter_facility_form.durn_type.disabled = false;
			document.parameter_facility_form.expiry_stock_1.checked=true;
			document.parameter_facility_form.expiry_stock_2.checked=false;
			document.parameter_facility_form.expiry_stock_1.disabled=false;
			document.parameter_facility_form.expiry_stock_2.disabled=false;
			document.parameter_facility_form.near_expiry_appl_yn.value="E";
		}
	else
		{
			document.parameter_facility_form.durn_value.value="";
			document.parameter_facility_form.durn_type.value="N";
			document.parameter_facility_form.durn_value_in_days.value="";
		    document.parameter_facility_form.durn_value.disabled = true;
			document.parameter_facility_form.durn_type.disabled = true;
			document.parameter_facility_form.expiry_stock_1.checked=false;
			document.parameter_facility_form.expiry_stock_2.checked=false;
			document.parameter_facility_form.expiry_stock_1.disabled=true;
			document.parameter_facility_form.expiry_stock_2.disabled=true;
		}
}

function ChkNumberInput1(fld)
{
var duration_value="";
duration_value=fld.value;
var check="0123456789";
var durn_value_new="";
for(i=0;i<duration_value.length;i++)
{
	if(check.indexOf(duration_value.charAt(i))==-1){
		durn_value_new=durn_value_new;
	}
	else if(durn_value_new.length==0 && duration_value.charAt(i)==0){
		durn_value_new=durn_value_new;
	}
	else{
		durn_value_new+=duration_value.charAt(i);
	}
		
}
document.parameter_facility_form.durn_value.value = durn_value_new;
}

//Added for MMS-DM-CRF-0177 - End

//added for ML-MMOH-CRF-1637
function assignValue(obj){
 
 if(obj.checked==true){
   document.parameter_facility_form.pat_trans_other_type.disabled=false;
   obj.value="Y";
   pat_trans_other_type_def = document.parameter_facility_form.pat_trans_other_type_def.value;
   if(pat_trans_other_type_def=="Y"){
	   document.parameter_facility_form.pat_trans_other_type.checked=true;
      document.parameter_facility_form.pat_trans_other_type.value="Y";
   }
 }else{
   
   document.parameter_facility_form.pat_trans_other_type.checked=false;
   document.parameter_facility_form.pat_trans_other_type.value="N";
   document.parameter_facility_form.pat_trans_other_type.disabled=true;
 }

}

//added for ML-BRU-CRF-0630
function assignSensitive(obj,name){
 
 if(obj.checked==true){
	 obj.value="Y";

	 if(name=="sensitive_diagnosis_prescriptionreport_yn") //other checkbox should be disabled and viceversa
	 {
			document.parameter_facility_form.sensitive_diagnosis_indicator_prescriptionreport_yn.disabled=true;
			document.parameter_facility_form.sensitive_diagnosis_indicator_prescriptionreport_yn.value="N";
			document.parameter_facility_form.sensitive_diagnosis_indicator_prescriptionreport_yn.checked=false;
	 } else 
	 {
			document.parameter_facility_form.sensitive_diagnosis_prescriptionreport_yn.disabled=true;
			document.parameter_facility_form.sensitive_diagnosis_prescriptionreport_yn.value="N";
			document.parameter_facility_form.sensitive_diagnosis_prescriptionreport_yn.checked=false;
	 }
 }else{
	 obj.value="N";
	 document.parameter_facility_form.sensitive_diagnosis_prescriptionreport_yn.disabled=false;
	 document.parameter_facility_form.sensitive_diagnosis_indicator_prescriptionreport_yn.disabled=false;
 }

}

//added for ML-BRU-CRF-0630
function assignQuotaLimit(obj,name){
 
 if(obj.checked==true){
	 obj.value="Y";

	 if(name=="quota_limit_calculation_required_yn") //other checkbox should be disabled and viceversa
	 {
			document.parameter_facility_form.active_prescription_enabled_for_quota_limit_yn.disabled=false;
	 }
 }else{
	 obj.value="N";
	 
	 if(name=="quota_limit_calculation_required_yn") //other checkbox should be disabled and viceversa
	 {
			document.parameter_facility_form.active_prescription_enabled_for_quota_limit_yn.disabled=true;
			document.parameter_facility_form.active_prescription_enabled_for_quota_limit_yn.checked=false;
			document.parameter_facility_form.active_prescription_enabled_for_quota_limit_yn.value="N";
	 } 

	  
 }

}

//Start for MMS-CRF-0233-44841  By Ayesha 
function checkMaxLength(obj)
{
	var val = "";
	val = obj.value;
	if(obj.value.length > 100) {
			alert(getMessage("FOOTER_DESC_CANNOT_EXCEED","PH"));
			msg = msg.replace("#",100);
			obj.value = val.substring(0,100);
		
	}
}

function checkMaxLengthLoc(obj)
{
	var val = "";
	val = obj.value;
	if(obj.value.length > 100) {
		alert(getMessage("FOOTER_DESC_IN_LOCAL_CANNOT_EXCEED","PH"));
		msg = msg.replace("#",100);
		obj.value = val.substring(0,100);
		
	}
}

function SpecialChar(e) {
	var keyCode = e.keyCode || e.which;
	//Regex to allow only Alphabets Numbers and ()[] , . :
	var pattern = /^[ A-Za-z0-9:,.()\[\]]*$/;
	//Validating the textBox value against our regex pattern.
	var isValid = pattern.test(String.fromCharCode(keyCode));

	return isValid;
}

function SpecialCharArabic(e) {
	var keyCode = e.keyCode || e.which;
		
	var pattern =/[\u0600-\u06ff0-9\s.,:()\[\]]|[\u0750-\u077f]|[\ufb50-\ufc3f]|[\ufe70-\ufefc]/g;
	var isValid = pattern.test(String.fromCharCode(keyCode));
	
	return isValid;
}

function validateFooter(obj){
	var formObj=document.parameter_facility_form.all;
	if(obj.checked){
		formObj.print_pres_dtl_en.disabled=false;
		formObj.print_pres_dtl_en.focus();
		formObj.print_pres_dtl_en_man.style.visibility="visible";
		formObj.print_pres_dtl_loc_man.style.visibility="visible";
		formObj.print_pres_dtl_loc.disabled=false;
	
	}
	else{
		formObj.print_pres_dtl_en.value="";
		formObj.print_pres_dtl_en.disabled=true;
		formObj.print_pres_dtl_loc.value="";
		formObj.print_pres_dtl_loc.disabled=true;
		formObj.print_pres_dtl_en_man.style.visibility="hidden";
		formObj.print_pres_dtl_loc_man.style.visibility="hidden";
	}
}

function EnableDisableTextArea(Print_Footer_Details) {

    var txtArea1 = document.getElementById("txt_Area_1");
	var txtArea2 = document.getElementById("txt_Area_2");
    txtArea1.disabled = Print_Footer_Details.checked ? false : true;
	txtArea2.disabled = Print_Footer_Details.checked ? false : true;
    if (!txtArea1.disabled && !txtArea2.disabled) {
        txtArea1.focus();
		txtArea2.focus();
    }
}

// Ended for MMS-CRF-0233-44841 by Ayesha Khan
