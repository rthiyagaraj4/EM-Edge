 //saved on 02.11.2005
function run() {
	
	 	var frmObject = f_query_add_mod.document.formReissueCriteria;		
		var fields= new Array (frmObject.dt_from,frmObject.dt_to);
		var names= new Array ('Date From','Date To');
		if(checkFields(fields,names,messageFrame)){
			f_query_add_mod.document.formReissueCriteria.action="../../eCommon/jsp/report_options.jsp";
			f_query_add_mod.document.formReissueCriteria.target="messageFrame";
			f_query_add_mod.document.formReissueCriteria.submit();	
	     } 
	
}
	// the below method is used for leap year calculation
	function CheckDateT(obj){
		var locale=document.formReissueCriteria.p_language_id.value;
		if(obj.value!=""){
			if(!validDate(obj.value, 'DMY',locale)){
				alert(getMessage("INVALID_DATE_FMT", "SM"));
				//obj.select();
				//obj.focus();
				obj.value=" ";
				return false;
			}
		}
		else{
			obj.value=convertDate(obj,'DMY',locale,'en');
		}
	}
function reset() {
    f_query_add_mod.formReissueCriteria.reset();
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

//for patient lookup
async function callPatientSearch(target){

	var patient_id = await PatientSearch();
 if(patient_id != null && patient_id != "" )  {		
		target.value = patient_id;
 }
}
function chkDate(dt_from,dt_to){ 
	
	var ref=parent.frames[2]; 
	if(doDateCheck(dt_from,dt_to,ref)){
		parent.frames[2].location.href='../../eCommon/jsp/error.jsp'; 
	}else{
		parent.f_query_add_mod.formReissueCriteria.dt_from.focus(); 
		parent.f_query_add_mod.formReissueCriteria.dt_from.select(); 
		
	}
}
 
function Duplicatecheck(){   /* Below code added for ML-BRU-SCF-0621[IN036565] -- Start */
	var patientId = document.formReissueCriteria.p_patient_id.value; 
	if( (patientId != null) && (patientId !="")){
		var	bean_id			= "QueryPatientDrugProfileBean" ;
		var	bean_name		= "ePH.QueryPatientDrugProfileBean";
		var xmlStr ="<root><SEARCH ";	
		xmlStr+= "patientId=\"" + patientId + "\" " ;
		xmlStr+= "chkPatientID=\"false\" " ;
		xmlStr+= "bean_id=\"" + bean_id + "\" " ;	
		xmlStr+= "bean_name=\"" + bean_name + "\" " ;	
		xmlStr +=" /></root>";
		var xmlHttp = new XMLHttpRequest() ;
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
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
	document.formReissueCriteria.p_patient_id.value=main_patientid;    
}/* code added for ML-BRU-SCF-0621[IN036565] -- End */
