function run() {
	var frmObject = f_query_criteria.document.formPhRepMednRecon;
	messageFrame.location.href="../../eCommon/jsp/error.jsp?" ;
	var fields = new Array (frmObject.p_patient_id ,frmObject.p_disp_date);
	var names   = new Array(getLabel("Common.patientId.label","common"), getLabel("ePH.PrintDate.label","PH")) ;
	if(f_query_criteria.checkFields( fields, names, messageFrame)){
		var locale = frmObject.locale.value;
		frmObject.p_dispense_date.value=convertDate(frmObject.p_disp_date.value,'DMY',locale,"en");
		frmObject.submit();
	} 
}

function reset() {
    f_query_criteria.formPhRepMednRecon.reset();
	f_query_criteria.formPhRepMednRecon.patient_detail.innerText="";	
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

function callPatientSearch(target){
	var patient_id = PatientSearch();
	if(patient_id != null && patient_id != "" )  {
		target.value = patient_id;
		getPatentDetails(target);
		target.focus();
     }
}

function CheckDateT(obj){
	var locale=document.formPhRepMednRecon.p_language_id.value;
	if(obj.value!=""){
		if(!validDate(obj.value, 'DMY',locale)){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			obj.select();
			obj.focus();
			return false;
		}
	}
	else{
		obj.value=convertDate(obj,'DMY',locale,'en');
	}
}

function getPatentDetails(patientIdObj) {
	patient_id = patientIdObj.value;
	document.getElementById("patient_detail").innerText="";
	if(patient_id=="" || trimString(patient_id)==""){
		patientIdObj.value = "";
		return false;
	}
	else if(patient_id.length < patientIdObj.maxLength){
		alert(getMessage("PH_NOT_VALID_PATIENT","PH"));
		patientIdObj.value = "";
		return false;
	}
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	xmlStr ="<root><SEARCH " ;
	xmlStr+= "patient_id=\"" + patient_id + "\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "PhReportsValidation.jsp?validate=getPatentDetails"+"&patient_id=" + patient_id, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText) ;
}

function mergedPatientAlert(main_patientid){ 
	msg = getMessage('PATIENT_MERGED_VALID','MP');
	msg= msg.replace('#',main_patientid);
	alert(msg);
	document.formPhRepMednRecon.p_patient_id.value=main_patientid;    
}

function dispPatientDtails(p_name,p_age,p_sex){
	document.getElementById("patient_detail").innerText=  decodeURIComponent(p_name,"UTF-8")+" / "+p_age+" / " +p_sex;
}

function alertInvalidPat(){
	alert(getMessage("PH_NOT_VALID_PATIENT","PH"));
	document.formPhRepMednRecon.p_patient_id.value = "";
	return false;
}
