function run() {
	var frmObject = f_query_criteria.document.formPhBalMednSheetCriteria;
	if(f_query_criteria.document.formPhBalMednSheetCriteria) {
		var tmp_disp_no = frmObject.p_disp_no.value;
		getSelectedDispNos();
		var disp_no = frmObject.p_disp_no.value;
		if(disp_no==''){
			messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+ getMessage("ATLEAST_ONE_SELECTED","Common") ;
			return false;
		}
		//f_query_criteria.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
		//f_query_criteria.document.forms[0].target="messageFrame";
		f_query_criteria.document.formPhBalMednSheetCriteria.submit();
		frmObject.p_disp_no.value = tmp_disp_no;
	}
}

function changeLanguage(locLang){//newly added by manickam for CRF-0075
	var langVal = locLang.value;
	if(langVal=="E"){
		document.formPhBalMednSheetCriteria.p_language_id.value='en';
	}
	else{
		document.formPhBalMednSheetCriteria.p_language_id.value=langVal;
	}
}

function reset() {
    f_query_criteria.formPhBalMednSheetCriteria.reset();
	f_query_result.location.href="../../eCommon/html/blank.html?";
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

//for patient lookup
async function callPatientSearch(target){
	var patient_id = await PatientSearch();
	if(patient_id != null && patient_id != "" )  {		
		target.value = patient_id;
	}
}

/*function searchPractitionerName(target, mode) {
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	dataNameArray[0]	= "APPL_USER_ID" ;
	dataValueArray[0]	= f_query_criteria.document.formPhMednStatByPractCriteria.p_user_name.value;
	dataTypeArray[0]	= STRING ;
	dataNameArray[1]	= "FACILITY_ID" ;
	dataValueArray[1]	= f_query_criteria.document.formPhMednStatByPractCriteria.p_facility_code.value;
	dataTypeArray[1]	= STRING ;
	dataNameArray[2]	= "FACILITY_ID" ;
	dataValueArray[2]	= f_query_criteria.document.formPhMednStatByPractCriteria.p_facility_code.value;
	dataTypeArray[2]	= STRING ;
	argumentArray[0] = f_query_criteria.document.formPhMednStatByPractCriteria.sql_ph_medn_stat_pract_select1.value;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "4,5";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;
	retArray = CommonLookup( "Practitioner Search", argumentArray );
	if(retArray != null && retArray != "") {
		if (mode == 1)
			f_query_criteria.document.formPhMednStatByPractCriteria.pract_id.value = retArray[0];
		else if (mode == 2)
			f_query_criteria.document.formPhMednStatByPractCriteria.tpract_id.value = retArray[0];
		target.value = retArray[1];
	}
}

function callDrugSearch(obj) {
	var arrCodeDesc = DrugSearch("D",obj);
	if(arrCodeDesc != null && arrCodeDesc != "" ) {
		document.formPhRepDispStatByDrugCriteria.drug_code.value	=	arrCodeDesc[0];
		obj.value =	arrCodeDesc[1];
	}
}*/

function GoBack() {
	alert(getMessage("PH_MEDN_PRN_WARN","PH"));
	//history.go(-1);
	window.location.href = '../../eCommon/jsp/dmenu.jsp';
}

/*function ValidateFrom(from,to) {
	var result	=	true;
	if(!ValidateDateTime(from,to)) {
	alert("Should be Greater than Current Time");
	to.select();
	result	=	false;
	}
	return result;
}

function ValidateFrom(from,to,en) {
	var result	=	true;
	if(!ValidateDateTime(from,to)) {
		alert("Should be Greater than Current Time");
		to.select();
		result	=	false;
	}
	else{
		if(!ValidateDateTime(to,en)) {
			alert("Should be Less than Sysdate ");
        	to.select();
			result	=	false;
		}
	}
	return result;
}

function ValidateTo(from,to,en) {
	var result	=	true;
	if(!ValidateDateTime(from,to)) {
		alert("Should be Greater than From Time");
		to.select();
		to.focus();
		result	=	false;
	}
	else{
		if(!ValidateDateTime(to,en)) {
			alert("Should be Less than Sysdate + 1 ");
        	to.select();
			result	=	false;
			to.focus();
		}
	}
	return result;
}*/

function showResults(){
	var disp_no = parent.f_query_criteria.document.formPhBalMednSheetCriteria.p_disp_no.value;
	var patient_id = parent.f_query_criteria.document.formPhBalMednSheetCriteria.p_patient_id.value;
	if(disp_no != "" || patient_id != "" ){					 
		parent.f_query_result.location.href="../../ePH/jsp/PhBalMednSheetResult.jsp?disp_no="+disp_no+"&patient_id="+patient_id+"&callFrom=SEARCH";
	}
	else{
		alert(getMessage("EITHER_DISP_PATIENT_REQ","PH"));
	}
}

function showReport(disp_no){
	parent.f_query_criteria.document.formPhBalMednSheetCriteria.p_disp_no.value=disp_no;
	//ChangePrintLangId();  //commented by manickam for CRF-075
	parent.f_query_criteria.document.formPhBalMednSheetCriteria.submit();
}

function SubmitLink(from,to,patient_id,disp_no){
	var obj						=	document.frmPrintDispSheetResult;
	obj.from.value				=	from;
	obj.to.value				=	to;
	obj.patient_id.value		=	patient_id;
	obj.disp_no.value			=	disp_no;
	obj.submit();
}


function ChangePrintLangId(){//Code Added For FD-Bru-HIMS-CRF-075 - Start
   var checkLang = parent.f_query_criteria.document.formPhBalMednSheetCriteria.label_language.value;
   if(checkLang =="E"){
     parent.f_query_criteria.document.formPhBalMednSheetCriteria.p_language_id.value ="en";
   }
   else{
     parent.f_query_criteria.document.formPhBalMednSheetCriteria.p_language_id.value=parent.f_query_criteria.document.formPhBalMednSheetCriteria.newLocalLanguage.value;
   }
}//Code Added For FD-Bru-HIMS-CRF-075 - End

function Duplicatecheck(){   /* Below code added for ML-BRU-SCF-0621[IN036565] -- Start */ 
	var patientId = document.formPhBalMednSheetCriteria.p_patient_id.value; 
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
	document.formPhBalMednSheetCriteria.p_patient_id.value=main_patientid;    
}/* code added for ML-BRU-SCF-0621[IN036565] -- End */ 

function storeSeleciton(checkObj, dispNo){ //Added for Bru-HIMS-CRF-415 [IN:045556] -start
	var selected="";
	if(checkObj.checked == true)
		selected = 'Y';
	else
		selected = 'N';
	var xmlStr ="<root><SEARCH ";	
	xmlStr+= "selected=\"" + selected + "\" " ;
	xmlStr+= "dispNo=\"" + dispNo + "\" " ;
	xmlStr +=" /></root>";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "PhReportsValidation.jsp?validate=storeSeleciton", false ) ;	
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;		
}

function getSelectedDispNos(){
	var xmlStr ="<root><SEARCH ";	
	xmlStr +=" /></root>";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "PhReportsValidation.jsp?validate=getSelectedDispNos", false ) ;	
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
}

function setSelectedDispNos(selectedDispNos){
	f_query_criteria.document.formPhBalMednSheetCriteria.p_disp_no.value=selectedDispNos;
}//Added for Bru-HIMS-CRF-415 [IN:045556] -End
