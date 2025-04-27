//Patient Search from common.js,Added newly for the CRF-072 BRU by SureshKumar T
function callPatientLookup(){
	var formObj =parent.f_query_add_mod.document.forms[0];
	var patient_id = PatientSearch();
	if(patient_id != null && patient_id != "" )  {
		formObj.patient_id.value = patient_id;
		formObj.patient_id.focus();
     }
}

function DateCheck(from,to) {
	if(from.value=="" || to.value==""){ 
		return false;
	}
	else{
		if(!isBefore(to.value,from.value,"DMY",document.forms[0].p_language_id.value)) {
			var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
			alert(errors);
			return false;
		}
	}
    return false;
}

function validate_date(Obj,ref) {
	if(document.forms[0].p_disp_date_from.value=='' || document.forms[0].p_disp_date_to.value=='')
		return false;
	else{
		if(!isBefore(document.forms[0].p_disp_date_from.value,document.forms[0].p_disp_date_to.value,"DMY",document.forms[0].p_language_id.value)) {
			var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 
			alert(errors);
			return false;
		}
	}
	return true;
}

function CheckForSpecialChars(event) {
	var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-.";
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) {
		return false;
	}  // Not a valid key
	return true;
}

function showResults(){
	var formObj = parent.f_query_add_mod.document.forms[0];
	var locale = formObj.p_language_id.value;
	var patient_id = formObj.patient_id.value;
	var p_fr_disp_date = formObj.p_disp_date_from.value;
	var order_date_from=convertDate(p_fr_disp_date,"DMY",locale); 
	var p_to_disp_date = formObj.p_disp_date_to.value;
	var order_date_to=convertDate(p_to_disp_date,"DMY",locale);
	var p_encounter= formObj.p_encounter.value;
	var p_disp_locn_code= formObj.p_disp_locn_code.value;
	var p_disp_locn_desc = formObj.p_disp_locn_code.options[formObj.p_disp_locn_code.selectedIndex].innerHTML;
	if(document.forms[0].p_disp_date_from.value!='' && document.forms[0].p_disp_date_to.value!=''){ 
		if(!isBefore(formObj.p_disp_date_to.value,formObj.currentdate.value,"DMY",document.forms[0].p_language_id.value)) {
			var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
			alert(errors);
			return false;
		}

		if(!isBefore(formObj.p_disp_date_from.value,formObj.p_disp_date_to.value,"DMY",document.forms[0].p_language_id.value)) {
			var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 			
			alert(errors);
			return false;			
		}
		if(daysBetween(formObj.p_disp_date_from.value,formObj.p_disp_date_to.value,"DMY",document.forms[0].p_language_id.value)>7){
			alert(getMessage('DATE_RANGE_WEEK','PH'));
			return false;
		}
	}
	var fields = new Array (formObj.patient_id,formObj.p_disp_date_from,formObj.p_disp_date_to,formObj.p_disp_locn_code);
	var names= new Array (getLabel("Common.patientId.label","Common"),getLabel("ePH.DispenseDateFrom.label","PH"), getLabel("Common.todate.label","Common"),getLabel("ePH.DispenseLocation.label","PH"));
	if(checkFields(fields,names,parent.messageFrame)){
		parent.f_query_results.location.href="../../ePH/jsp/MedicationPlanReportQueryResult.jsp?patient_id="+patient_id+"&order_date_from="+order_date_from+"&order_date_to="+order_date_to+"&p_disp_locn_code="+p_disp_locn_code+"&locale="+locale+"&p_encounter="+p_encounter+"&p_disp_locn_desc="+encodeURIComponent(p_disp_locn_desc);
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" ; 
	}
	else{
		parent.f_query_results.document.location.href='../../eCommon/html/blank.html';
	}
}

function reset() {
	f_query_add_mod.MedicationPlanReportform.reset();
	f_query_results.document.location.href='../../eCommon/html/blank.html';
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}


function callMediPlan(patient_id,medplanid,order_date_from,order_date_to,encounter_id,disp_locn_code,disp_locn_desc,disp_stage){
	
	var xmlStr = "<root><SEARCH ";
	xmlStr+= "medplanid  =\"" + medplanid + "\" " ;
	xmlStr+= "patient_id  =\"" + patient_id + "\" " ;
	xmlStr+= "order_date_from  =\"" + order_date_from + "\" " ;
	xmlStr+= "order_date_to  =\"" + order_date_to + "\" " ;
	xmlStr+= "encounter_id  =\"" + encounter_id + "\" " ;
	xmlStr+= "disp_locn_code  =\"" + disp_locn_code + "\" " ;
	xmlStr+= "disp_locn_desc  =\"" + encodeURIComponent(disp_locn_desc) + "\" " ;
	xmlStr+= "disp_stage  =\"" + disp_stage + "\" " ;
	xmlStr +=" /></root>";
	var temp_jsp="DispMedicationValidation.jsp?func_mode=getDetailsBasedonMedPlanid";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false); 
	xmlHttp.send(xmlDoc);
	
	callMedicationPlanner(patient_id,encounter_id,'Y',medplanid);
}

function Duplicatecheck(){   /* Below code added for ML-BRU-SCF-0621[IN036565] -- Start */
	var patientId = document.MedicationPlanReportform.patient_id.value; 
	if( (patientId != null) && (patientId !="")){
		var	bean_id			= "QueryPatientDrugProfileBean" ;
		var	bean_name		= "ePH.QueryPatientDrugProfileBean";
		var xmlStr ="<root><SEARCH ";	
		xmlStr+= "patientId=\"" + patientId + "\" " ;
		xmlStr+= "chkPatientID=\"false\" " ;	
		xmlStr+= "bean_id=\"" + bean_id + "\" " ;	
		xmlStr+= "bean_name=\"" + bean_name + "\" " ;	
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "QueryPatientDrugProfileValidation.jsp?func_mode=Duplicate&bean_id=" + bean_id + "&bean_name=" +bean_name+"&patientId="+patientId, false ) ;	
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;		
		eval(responseText);	
	}		
} 

function mergedPatientAlert(main_patientid){ 
	msg = getMessage('PATIENT_MERGED_VALID','MP');
	msg= msg.replace('#',main_patientid);
	alert(msg);
	document.MedicationPlanReportform.patient_id.value=main_patientid;    
}/* code added for ML-BRU-SCF-0621[IN036565] -- End */
