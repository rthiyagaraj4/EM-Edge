function run() {
	var frmObject = f_query_criteria.document.formPatientDrugProfileList;
	var opt;
	var result = [];
	var status_append = "";
	var status_append1 = "";
	var status1 = "";
	var inc = 0;
	var inc1 = 0;
	var status = frmObject.p_status.options;
	for (var i=0; i<status.length; i++) {
	    opt = status[i];
	    if (opt.selected) {
	      result.push(opt.value);
	    }
	    if(opt.value != "ALL"){
	    	if(inc1>0)
				status_append1 = status_append1.concat(","+"'"+opt.value+"'");
			else{
				status_append1 = status_append1.concat("'"+opt.value+"'");
				inc1++;
			}
		}
	}
	for(var j=0; j < result.length ; j++){
		if(result[j] == "ALL"){
			status_append = status_append1;
			break;
		}
		else{
			if(inc>0){
				status_append = status_append.concat(","+"'"+result[j]+"'");
			}
			else{
				status_append = status_append.concat("'"+result[j]+"'");
				inc++;
			}
		}
	}
	status1 = "AND ORDER_LINE_STATUS in ("+status_append+")";
	frmObject.p_order_status.value = status1;
	var fields= new Array (frmObject.p_patient_id);
	var names= new Array (getLabel("Common.patientId.label","Common"));
	var msgFrame= frames[2];
	if(checkFields(fields,names,msgFrame) ){
		
		frmObject.submit();
	}
	
}

function reset() {
	f_query_criteria.formPatientDrugProfileList.reset();
	clearData(f_query_criteria.formPatientDrugProfileList.p_encounter_id);
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

async function callPatientSearch(target){
	var patient_id =await PatientSearch();
	if(patient_id != null && patient_id != "" )  {		
		target.value = patient_id;		
	}
}

function validate_date(Obj) {
	if(document.forms[0].p_period_from.value=='' || document.forms[0].p_period_to.value==''){ 
		return false;
	}
	else{
		if(!isBefore(document.forms[0].p_period_from.value,document.forms[0].p_period_to.value,"DMY",document.forms[0].p_language_id.value)) {
			var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 
			alert(errors);
			Obj.select();
			Obj.focus();
			return false;
		}
	}
	return true;
}

function DateCheck(from,to) {
    if(from.value=="" || to.value==""){ 
		return false;
	}
	else{
		if(!isBefore(to.value,from.value,"DMY",document.forms[0].p_language_id.value)) {
			var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
			if(errors.indexOf("Date")>-1){
				errors = errors.replace("Date",getLabel("Common.periodfrom.label","Common")+" / "+getLabel("Common.periodto.label","Common"));
			}
			if(errors.indexOf("system")>-1){
				errors = errors.replace("system",getLabel("Common.current.label","Common"));
			}
			alert(errors);
			to.select();
			to.focus();
			return false;
		}
	}
	return true;
}

function CheckDateT(obj){
	var locale=document.formPatientDrugProfileList.p_language_id.value;
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
	return true;
}

function Duplicatecheck(){
	var patientId = document.formPatientDrugProfileList.p_patient_id.value; 
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

function populateEncounter() {
	patient_id = document.formPatientDrugProfileList.p_patient_id.value;
	if(patient_id != ""){
		frmObj=document.formPatientDrugProfileList;
		patientClass = frmObj.p_patient_class.value;
		if(patientClass == 'XT'){
			var p_encounter_id = frmObj.p_encounter_id;
			clearData(p_encounter_id);
			return;
		}
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();					
		xmlStr	="<root><SEARCH " ;												
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "PhReportsValidation.jsp?patient_id=" + patient_id+ "&patientClass=" + patientClass+"&validate=POPULATEENCOUNTER", false ) ;		
		xmlHttp.send( xmlDoc ) ;	
		eval(xmlHttp.responseText);	
	}
}

function addDataDefault(code, desc, obj,sel) {
	obj = eval(obj);
	var opt	= eval(document.createElement('OPTION'));
	opt.value =	code;
	opt.text = desc;
	if(sel == "selected") 
		opt.selected = true; 
	obj.add(opt);
}

function clearData(obj) {
	obj = eval(obj);
	var len = obj.length;
	for (var i=0; i<=len; i++) {
		obj.remove("");
	}
	var opt	= document.createElement('OPTION');
	addDataDefault('',getLabel("Common.all.label","Common"),obj,'');
}
