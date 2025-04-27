
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
12/11/2018  IN059704        PRATHYUSHA   12/11/2018          Ramesh G      AAKH-CRF-0079.2		
26/11/2018  IN069192        PRATHYUSHA   26/11/2018          Ramesh G      AAKH-CRF-0079.2	
23/12/2019  IN071639        SIVABAGYAM M 23/12/2019          Ramesh G      AAKH-CRF-0079.10
-------------------------------------------------------------------------------------------------------------------------------------
*/
var function_id = "" ;
var result = false ;
var message = "" ;
var flag = "" ;


//IN071639 STARTS
function printDetails(p_report_id){
	var formObj = document.formClaimFormsResult;
	var patient_id=formObj.patient_id.value;
	var encounter_id=formObj.encounterid.value;
	var facility_id=formObj.facility_id.value;
	var user_name=formObj.login_user_id.value;
	var language_id=formObj.language_id.value;
	var retVal="";
	if(p_report_id == ""){
			parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("INSURANCE_NOT_MATCHED","CA");
			return false;
		
	}
	var p_module_id="CA";
	var dialogHeight	= "10" ;
	var dialogWidth	= "30" ;
	var status = "no";
	var scroll = "yes";
	var dialogTop = "140";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;	
	var params = "&p_report_id="+p_report_id+"&p_module_id="+p_module_id;
	parent.f_query_print.document.CAInsuranceAuthorizationFormPrint.action = "../../eCommon/jsp/report_options.jsp?p_patient_id="+patient_id+"&p_encounter_id="+encounter_id+"&p_facility_id="+facility_id+"&user_name="+user_name+"&language_id="+language_id+params;
	parent.f_query_print.document.CAInsuranceAuthorizationFormPrint.submit();   
	}


function saveDetails(report_id,index){
	var approvalNumber=document.getElementById("approvalNum"+report_id).value;
	var patient_id=document.getElementById("patient_id").value
	var encounter_id=document.getElementById("encounterid").value
	document.getElementById("approval_number"+report_id).value=approvalNumber;
	var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    var xmlStr="<root><SEARCH ";
    xmlStr+=" approvalNumber=\""+ approvalNumber +"\" ";
    xmlStr+=" patient_id=\""+ patient_id +"\" ";
    xmlStr+=" encounter_id=\""+ encounter_id +"\" ";
    xmlStr+=" report_id=\""+ report_id +"\" ";//IN072296
    xmlStr+=" /></root>";
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	

    xmlHttp.open("POST","CAInsuranceValidate.jsp",false);
    xmlHttp.send(xmlDoc);    
    responseText = trimString(xmlHttp.responseText);
     var message=getMessage("RECORD_INSERTED","CA");
     if(parent.parent.parent.parent.messageFrame != undefined && parent.parent.parent.parent.messageFrame != null)
 		parent.parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
 	else if (parent.messageFrame != undefined && parent.messageFrame != null)
 		parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
 	else if (parent.parent.parent.document.frames.messageFrame != undefined && parent.parent.parent.document.frames.messageFrame != null)
 		parent.parent.parent.document.frames.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
		document.getElementById("savedisabled"+index).disabled=true;
		document.getElementById("printdisabled"+index).disabled=false;
}

function enableSave(index)
{
	document.getElementById("savedisabled"+index).disabled=false;
	document.getElementById("printdisabled"+index).disabled=true;
}
function disableSave(obj,obj1,index)
{
	if(document.getElementById("approval_number"+obj1).value==obj.value){		
		document.getElementById("savedisabled"+index).disabled=true;
		document.getElementById("printdisabled"+index).disabled=false;
	}
	
}
//IN071639 ENDS
function myFunction(obj) {
 
   document.formClaimFormsResult.Print.disabled=false;
   
    document.getElementById("p_report_id").value = obj;
}	
function callPatientSearch(target){
	
	var patient_id = PatientSearch();
	if (typeof(patient_id)=="string"){
		target.value = patient_id;
		
		populateEncounter(patient_id);
	}

}
function populateEncounter(patient_id) {//	 AMS-CRF-0172

	
	frmObj=document.formClaimFormsCriteria;
	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();					
	xmlStr	="<root><SEARCH " ;												
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
		xmlHttp.open( "POST", "CAInsuranceAuthorizationFormValidate.jsp?patient_id=" + patient_id+ "&identity=POPULATEENCOUNTERFOROP", false ) ;

	xmlHttp.send( xmlDoc ) ;	
	eval(xmlHttp.responseText);	
	
	
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
//added for IN069192 start
function addEncounter(code, desc, obj) {
	obj = eval(obj);
	var opt	= eval(document.createElement('OPTION'));
	opt.value =	code;
	opt.text = desc;
	obj.add(opt);
}
//added for IN069192 end
function clearData(obj) {

	obj = eval(obj);
	var len = obj.length;
	for (var i=0; i<=len; i++) {
		obj.remove("");
	}
	var opt	= document.createElement('OPTION');

}
function getResult(){
	frmObj=document.formClaimFormsCriteria;
	
	var patient_id=frmObj.Patient_Id.value;
	var encounter_id=frmObj.encounterId.value; 
	if(patient_id == ""){
	
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("PATIENT_ID_CANNOT_BE_BLANK","CA");
		    frmObj.Patient_Id.focus();	
			return false;
		
	}
	if(encounter_id == ""){
		
		
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("ENCOUNTER_ID_CANNOT_BE_BLANK","CA");
		frmObj.encounterId.focus();
		return false;
	}
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	parent.f_query_result.location.href="../../eCA/jsp/CAInsuranceAuthorizationForm.jsp?patientid="+patient_id+"&encounterid="+encounter_id;
}
//IN071639 STARTS  
function CheckForSpeclChar(event){
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ'; 
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  
    if (strCheck.indexOf(key) == -1) {
    	return false; 
    }
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}
function CheckForSpecCharsWithCopyPaste(textObj)
{
	
	var ValidChars = /^[0-9a-zA-Z\/ ]*$/; 
	var pasteData = window.clipboardData.getData("Text"); 
	pasteData = trimString(pasteData);
	
	if(ValidChars.test(pasteData))
	{
		
		textObj.value = pasteData;
	}
	else {
		alert(getMessage("CANNOT_BE_SPECIAL_CHAR","Common"));
		return false;
	}
} 
function UploadDocument()
{
	var formObj = document.formClaimFormsResult;
	var patient_id=formObj.patient_id.value;
	var encounter_id=formObj.encounterid.value;

	var dialogHeight = "40";
	var dialogWidth	= "70";
	var status = "no";
	var arguments = "";
	var function_id = "UPLOAD_DOC";
	
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll = auto; status:" + status;

	window.showModalDialog('../../eMP/jsp/MPUploadDocument.jsp?function_id='+function_id+'&patient_id='+patient_id+'&encounter_id='+encounter_id,arguments,features);			
}
//IN071639  ENDS
