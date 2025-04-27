  //saved on 02.11.2005
// lookup for Drug Name
async function searchDrugName(){
	var formObj = document.formUnutilizedDrugs;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0]   = escape(document.getElementById("sql_ph_drug_search_select2").value)+"'"+document.getElementById("language_id").value+"'";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = formObj.drug_name.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 
	retVal = await CommonLookup(getLabel("Common.DrugName.label","Common"), argumentArray );

	if(retVal != null && retVal != "" ) {
		var ret1=unescape(retVal);
		 	arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		formObj.drug_name.value = arr[1] ;
		formObj.drug_code.value = arr[0];
		formObj.drug_name.disabled  = true;
		formObj.drug_name_search.disabled = true;
		
	}
}

function run(){
	
	if(f_query_criteria.document.formUnutilizedDrugs){
		if(f_query_criteria.document.formUnutilizedDrugs.p_order_status.value == 'DC'){
			var fields = new Array(f_query_criteria.document.formUnutilizedDrugs.p_nursing_unit,f_query_criteria.document.formUnutilizedDrugs.or_date,f_query_criteria.document.formUnutilizedDrugs.p_disc_date_time,f_query_criteria.document.formUnutilizedDrugs.p_order_status);
			var names = new Array (getLabel("Common.nursingUnit.label","Common"),getLabel("ePH.OrderDateTimeFrom.label","PH"),getLabel("ePH.DiscontinuedDateTimeFrom.label","PH"),getLabel("Common.status.label","Common"));
		}
		else{
			 var fields = new Array(f_query_criteria.document.formUnutilizedDrugs.p_nursing_unit,f_query_criteria.document.formUnutilizedDrugs.or_date,f_query_criteria.document.formUnutilizedDrugs.p_order_status);
			 var names = new Array (getLabel("Common.nursingUnit.label","Common"),getLabel("ePH.OrderDateTimeFrom.label","PH"),getLabel("Common.status.label","Common"));
		}
		if(f_query_criteria.checkFields( fields, names, messageFrame)){
			f_query_criteria.document.formUnutilizedDrugs.p_date.value=convertDate(f_query_criteria.document.formUnutilizedDrugs.or_date.value,'DMY',f_query_criteria.document.formUnutilizedDrugs.language_id.value,'en');
			f_query_criteria.document.formUnutilizedDrugs.action="../../eCommon/jsp/report_options.jsp";
			f_query_criteria.document.formUnutilizedDrugs.target="messageFrame";
			f_query_criteria.document.formUnutilizedDrugs.submit();
		}
	}
}
// the below method is used for leap year calculation
function CheckDateT(obj){
	var locale=document.formUnutilizedDrugs.p_language_id.value;
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

function reset(){
	var formObj=f_query_criteria.document.formUnutilizedDrugs;
	formObj.drug_name_search.disabled=false;
	f_query_criteria.document.formUnutilizedDrugs.reset();
}

async function callPatientSearch(target){
	var patient_id = await PatientSearch();
	if(patient_id != null && patient_id != "" ){		
		target.value = patient_id;
	}
}

function assignValue(){
	if(document.formUnutilizedDrugs.P_Discontinue_yn.checked==true){
		document.formUnutilizedDrugs.p_discontinue_yn.value="Y";
	}
	else{
		document.formUnutilizedDrugs.p_discontinue_yn.value="N";
	}
}

function assignValueForEx(){
	if(document.formUnutilizedDrugs.P_expiry_order_yn.checked==true){
		document.formUnutilizedDrugs.p_expiry_order_yn.value="Y";
	}
	else{
		document.formUnutilizedDrugs.p_expiry_order_yn.value="N";
	}
}
 
function Duplicatecheck(){   /* Below code added for ML-BRU-SCF-0621[IN036565] -- Start */
	var patientId = document.formUnutilizedDrugs.p_patient_id.value; 
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
	document.formUnutilizedDrugs.p_patient_id.value=main_patientid;    
}/* code added for ML-BRU-SCF-0621[IN036565] -- End */
