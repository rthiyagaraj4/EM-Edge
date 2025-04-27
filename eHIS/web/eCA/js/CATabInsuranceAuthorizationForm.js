/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      		Name        		Rev.Date				Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------------------------------
25/01/2019		IN057997			Kamalakannan G	  		25/01/2019				Ramesh G.		AAKH-CRF-0079
25/06/2019		IN070757			Sivabagyam M	  		25/06/2019				Ramesh G.		AAKH-CRF-0079.8
---------------------------------------------------------------------------------------------------------------------------------------------
*/
function getResultForTab(){
	frmObj=document.formClaimFormsCriteria;
	var patient_id=frmObj.Patient_Id.value;
	patient_id = patient_id.toUpperCase();
	var encounter_id=frmObj.encounterId.value; 
	if(patient_id == ""){
		parent.f_query_print.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("PATIENT_ID_CANNOT_BE_BLANK","CA");
		parent.f_query_result.location.href = "../../eCommon/html/blank.html";
		frmObj.Patient_Id.focus();	
		return false;
	}
	if(encounter_id == ""){
		parent.f_query_print.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("ENCOUNTER_ID_CANNOT_BE_BLANK","CA");
		parent.f_query_result.location.href = "../../eCommon/html/blank.html";
		frmObj.encounterId.focus();
		return false;
	}
	if(patient_id!=="" && encounter_id!==""){
		xmlStr = "<root><SEARCH ";
		 xmlStr += " patient_id=\"" +patient_id+ "\"";
		 xmlStr += " encounter_id=\"" +encounter_id+ "\"";
		 xmlStr += " /></root>";
		 var xmlDoc;
		 var xmlHttp;
		 xmlHttp = new XMLHttpRequest();
		 var oParser = new DOMParser();
		 xmlDoc = oParser.parseFromString(xmlStr,"text/xml");
		 xmlHttp.open("POST", "CATabIntermediateValidate.jsp?ACTION=VALIDATE_PAT_ENC", false);
		 xmlHttp.send(xmlDoc);
		 responseText = xmlHttp.responseText ;
		 eval(responseText);
	}
}
function validationCheck(pass,patient_id,encounter_id){
	if("Y"==pass){
		parent.f_query_print.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		parent.f_query_result.location.href="CATabInsuranceAuthorizationForm.jsp?patientid="+patient_id+"&encounterid="+encounter_id+"&view=TABVIEW";
	}else{
		
		parent.f_query_print.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("INVALID_INPUT","CA");
		parent.f_query_result.location.href = "../../eCommon/html/blank.html";
		return false;
	}
}
function myTabFunction(obj) {
	  document.formClaimFormsResult.View.disabled=false;
	  document.getElementsByName("p_report_id").value = obj;
	}	
function viewDetailsInTab(patient_id,encounter_id,facility_id){
	var p_report_id = document.getElementsByName("p_report_id").value;
	
	if("CAAKINFDAMAN"== p_report_id) {
		window.open("CATabInsuranceFormDaman.jsp?patientid="+patient_id+"&encounterid="+encounter_id+"&facilityid="+facility_id+"&p_report_id="+p_report_id);
	}
	else if("CAAKINFTHIQA"==p_report_id){
		window.open("CATabInsuranceFormThiqa.jsp?patientid="+patient_id+"&encounterid="+encounter_id+"&facilityid="+facility_id+"&p_report_id="+p_report_id);
}
	
	else{
		alert(getMessage("INSURANCE_NOT_MATCHED","CA"));
		return false;
	}
}

function saveData(patient_id,facility_id,encounter_id,p_report_id,added_by_id,added_at_ws_no){
   var dataURL = canvas.toDataURL();
	 var urlSplit = dataURL.split(",");
	 result = urlSplit[1];
	 xmlStr = "<root><SEARCH ";
	 xmlStr += " result=\"" +result+ "\"";
	 xmlStr += " patient_id=\"" +patient_id+ "\"";
	 xmlStr += " facility_id=\"" +facility_id+ "\"";
	 xmlStr += " encounter_id=\"" +encounter_id+ "\"";
	 xmlStr += " p_report_id=\"" +p_report_id+ "\"";
	 xmlStr += " added_by_id=\"" +added_by_id+ "\"";
	 xmlStr += " added_at_ws_no=\"" +added_at_ws_no+ "\"";
	 xmlStr += " /></root>";
	 var xmlDoc;
	 var xmlHttp;
	 xmlHttp = new XMLHttpRequest();
	 var oParser = new DOMParser();
	 xmlDoc = oParser.parseFromString(xmlStr,"text/xml");
	 xmlHttp.open("POST", "../../CATabInsurance", false);
	 xmlHttp.send(xmlDoc);
	 responseText = xmlHttp.responseText ;
	 eval(responseText);
}

function populateEncounter(patient_id) {
	 patient_id = patient_id.toUpperCase();
	 xmlStr = "<root><SEARCH ";
	 xmlStr += " /></root>";
	 var xmlDoc;
	 var xmlHttp;
	 xmlHttp = new XMLHttpRequest();
	 var oParser = new DOMParser();
	 xmlDoc = oParser.parseFromString(xmlStr,"text/xml");
	 xmlHttp.open( "POST", "CATabIntermediateValidate.jsp?patient_id=" + patient_id+ "&ACTION=POPULATEENCOUNTERFOROP", false ) ;
	 xmlHttp.send(xmlDoc);
	 responseText = xmlHttp.responseText ;
	 eval(responseText);
}
function addEncounter(code, desc, obj) {
	obj = eval(obj);
	var opt	= eval(document.createElement('OPTION'));
	opt.value =	code;
	opt.text = desc;
	obj.add(opt);
}
function addEncounterDefault(code, desc, obj,sel) {
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

}
