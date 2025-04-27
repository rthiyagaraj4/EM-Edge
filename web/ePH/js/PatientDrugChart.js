  //saved on 02.11.2005
var function_id = "" ;
var result = false ;
var message = "" ;
var flag = "" ;
function reset() {
	f_query_add_mod.PatientDrugChartQueryCriteria.reset();
	f_query_add_mod.PatientDrugChartQueryCriteria.patient_id.disabled = false;
	f_query_results.location.href="../../eCommon/html/blank.html";
}
// This will call common patient search
async function callPatientSearch(){
	var formObj=document.PatientDrugChartQueryCriteria;
	var patient_id = await PatientSearch();
	if (patient_id!= "" && patient_id != undefined){
		formObj.patient_id.value = patient_id;
		formObj.patient_id.disabled = true;
	}
}

function showResults(){ 
    var formObj = document.PatientDrugChartQueryCriteria;
	var patient_id      = formObj.patient_id.value ;
	//var nurs_unit    = formObj.nurs_unit.value;	//Commented and added below  ML-BRU-SCF-0498 [IN035593]   Nursing Unit Modified as Location
	var locn_type       = formObj.locn_type.value;
	var locn_name       = formObj.locn_name.value;
	var locn_code       = formObj.locn_code.value;
	var fields= new Array (formObj.locn_type,formObj.locn_name,formObj.patient_id);
		var names= new Array (getLabel("Common.locationtype.label","Common"),getLabel("Common.Location.label","Common"),getLabel("Common.patientId.label","Common"));
		if(checkFields(fields,names,parent.messageFrame) ){
			 parent.f_query_results.location.href="../../ePH/jsp/PatientDrugChartResult.jsp?patient_id="+patient_id+"&locn_type="+locn_type+"&locn_name="+locn_name+"&locn_code="+locn_code;  //added below  ML-BRU-SCF-0498 [IN035593]
	}
	formObj.patient_id.disabled=false; //Added for [IN:044712]
} 
 
function SubmitLink(from,to,patient_id,nursing_unit_code){
	var obj=document.frames.patientDrugChartReportResult;
	obj.from.value=from;
	obj.to.value=to;
	obj.patient_id.value=patient_id;
	obj.nursing_unit_code.value=nursing_unit_code;
	obj.submit();
}
function showPrintReport(patient_id){ 
	var formObj = parent.f_query_add_mod.PatientDrugChartQueryCriteria;
	formObj.p_patient_id.value =patient_id ;
	parent.f_query_add_mod.PatientDrugChartQueryCriteria.submit();
}

function resetLocation(){//adding start for scf ML-BRU-SCF-0498 [IN:035593]
	var formObj = document.PatientDrugChartQueryCriteria;
	formObj.locn_code.value="";
	formObj.locn_name.value="";
}

async function locationLookup(target){
	var formObj = document.PatientDrugChartQueryCriteria;
	var locn_type=formObj.locn_type.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	if (locn_type!=""){
		var retVal = "";
		if (locn_type=="N"){
			argumentArray[0]   = escape(formObj.SQL_PH_PRINT_PRESCRIPTIONS_SELECT2.value)+"'"+formObj.language_id.value+"'";
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;
			retVal = await CommonLookup(getLabel("Common.nursingUnit.label","Common"), argumentArray );
			/*if(retVal != null && retVal != "" )  {
				formObj.locn_code.value=retVal[0];
				target.value = retVal[1] ;
			} */
		}
		else if (locn_type=="C"){
			argumentArray[0]   =  escape(formObj.SQL_PH_PRINT_PRESCRIPTIONS_SELECT1.value)+"'"+formObj.language_id.value+"'";
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			retVal = await CommonLookup( getLabel("Common.clinic.label","Common"), argumentArray );
		}
		if(retVal != null && retVal != "" )  {
			var ret1=unescape(retVal)
                var arr=ret1.split(",");
				if(arr[1]==undefined) 
				{
		 		arr[0]="";	
		 		arr[1]="";	
				} 
			formObj.locn_code.value=arr[0];
			target.value = arr[1] ;
		}
		else{
			formObj.locn_code.value="";
			target.value = "" ;
		}
	}
	else{
		formObj.locn_type.focus()
	}
}
//adding end for scf ML-BRU-SCF-0498 [IN:035593]
function chkPatientID(patient_id){
	var formObj=document.PatientDrugChartQueryCriteria;
	if(patient_id == undefined)
		patient_id = formObj.patient_id.value;
	if (patient_id!= "" ){
		formObj.patient_id.value = patient_id;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="";
		xmlStr ="<root><SEARCH " ;
		xmlStr+= "bean_id  ='PHReportsBean' " ;
		xmlStr+= "bean_name = 'ePH.PHReportsBean' " ;
		xmlStr		    += " patient_id=\""+ patient_id + "\" ";
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "ReportsValidate.jsp?called_from=patientsearch", false ) ;
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
	} 
}

function chkpatID(yes_no){
	var frmObj = "";
	formObj=document.PatientDrugChartQueryCriteria;
	if(yes_no == "N"){
		alert(getMessage("PH_NOT_VALID_PATIENT","PH"));
		formObj.patient_id.value="";
		formObj.patient_id.focus();
	}
	else if(yes_no == "Y"){
		formObj.patient_id.disabled = true;
	}
}

function Duplicatecheck(){   /* Below code added for ML-BRU-SCF-0621[IN036565] -- Start */ 
	var patientId = document.PatientDrugChartQueryCriteria.patient_id.value; 
	if(patientId != null && patientId !=""){
		var	bean_id			= "QueryPatientDrugProfileBean" ;
		var	bean_name		= "ePH.QueryPatientDrugProfileBean";
		var xmlStr ="<root><SEARCH ";	
		xmlStr+= "patientId=\"" + patientId + "\" " ;
		xmlStr+= "chkPatientID=\"true\" " ;			
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
	document.PatientDrugChartQueryCriteria.patient_id.value=main_patientid; 
}/* code added for ML-BRU-SCF-0621[IN036565] -- End */
