/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			     Description
--------------------------------------------------------------------------------------------------------------
?				100					?              	  created
18/05/2021		TFS-18684       Prabha         		AMRI-CRF-0453
---------------------------------------------------------------------------------------------------------------
*/ 
//saved on 02.11.2005
function run() {
//	alert(parent.name);
//	alert(parent.frames[1].name);
	if(	parent.f_query_add_mod != undefined || 	 parent.f_query_add_mod!= null){
		var frmObject = parent.f_query_add_mod.document.formPhMednRtnCriteria;
	}
	else{
		var frmObject = f_query_add_mod.document.formPhMednRtnCriteria;
	}
	//if(f_query_add_mod.document.formPhMednRtnCriteria) {
	//var fields= new Array (frmObject.p_dispense_no);
	//var names= new Array ('Dispense No');
	//if(checkFields(fields,names,messageFrame) ) {

	var patient_id  = frmObject.p_patient_id.value;
	if (frmObject.p_patient_id.value!=""){
		frmObject.p_report_id.value="PHPRMDRT";
		frmObject.p_dispense_no.value=frmObject.disp_no.value;
		frmObject.submit();
		//frmObject.p_dispense_no.value=""; //Commented for AMRI-CRF-0453
	}
	else {
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
	}
}

function reset() {
/*	searchFrame.formPhRepDrugsByGenName.reset();*/
    f_query_add_mod.formPhMednRtnCriteria.reset();
	f_query_result.location.href="../../eCommon/html/blank.html";
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

async function callPatientSearch(target){
	var patient_id =await PatientSearch();

	if (typeof(patient_id)=="string"){
		target.value = patient_id;
	}
}

/*
function callDrugSearch(obj) {
	var arrCodeDesc = DrugSearch("D",obj);
	if(arrCodeDesc != null && arrCodeDesc != "" ) {
		document.formPhRepDispStatByDrugCriteria.drug_code.value	=	arrCodeDesc[0];
		obj.value =	arrCodeDesc[1];
	}
} */

function showResults(){
	var formObj			= document.formPhMednRtnCriteria;
	var disp_no      = formObj.p_dispense_no.value ;
	checkPatientClass(disp_no);
	var patient_id   = formObj.p_patient_id.value;
}


/*function showReportReturnMedication(disp_no,srl_no) {
   
   parent.f_query_add_mod.formPhMednRtnCriteria.p_dispense_no.value=disp_no;

   disp_no ="'"+disp_no+"~"+srl_no+"'";	
   parent.f_query_add_mod.formPhMednRtnCriteria.disp_no.value=disp_no;
   run();
}*/
function showReportReturnMedication(rtn_medn_no, rtn_date) {  
   parent.f_query_add_mod.formPhMednRtnCriteria.p_rtn_medn_no.value=rtn_medn_no;
   parent.f_query_add_mod.formPhMednRtnCriteria.p_rtn_date.value=rtn_date;
   parent.f_query_add_mod.formPhMednRtnCriteria.disp_no.value=parent.f_query_add_mod.formPhMednRtnCriteria.p_dispense_no.value;
   run();
}

function checkPatientClass(p_disp_no)	{
	//var frmObject = parent.f_query_criteria.document.formPhMednRtnCriteria;
	//	var disp_no		=	frmObject.p_disp_no.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " disp_no=\""+p_disp_no+"\"";
		xmlStr += " bean_id=\"DispMedicationAllStages\"";
		xmlStr += " bean_name=\"ePH.DispMedicationAllStages\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml"); 
		xmlHttp.open("POST","DispMedicationValidation.jsp?func_mode=get_pat_class",false);
		xmlHttp.send(xmlDoc);
		//alert(xmlHttp.responseText);
		eval(xmlHttp.responseText);
}

function assignPatientClass(pat_class) {
	var frmObject	= parent.f_query_add_mod.document.formPhMednRtnCriteria;
	var result		= pat_class.split("::");
	
	if(result != "") frmObject.p_patient_id.value=result[1];
	
	patient_id	=result[1];
	if(patient_id==undefined){
       patient_id    = frmObject.p_patient_id.value ;
	}
	var disp_no      = frmObject.p_dispense_no.value ;

	if(patient_id !="" || disp_no != ""){
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
		parent.f_query_result.location.href="../../ePH/jsp/PhRetMednResult.jsp?patient_id="+patient_id+"&disp_no="+disp_no;
	}
	else{
		if(disp_no == "" && patient_id == "" ){
			parent.f_query_result.location.href="../../eCommon/html/blank.html";
			parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("DISP_NO_OR_PATIENT_ID_NOT_BLANK","PH"); 
			frmObject.p_dispense_no.focus();
		}		
	}
}


function SubmitLink(from,to,patient_id,disp_no){
	var obj						=	document.frmPrintDispSheetResult;
	obj.from.value				=	from;
	obj.to.value				=	to;
	obj.patient_id.value		=	patient_id;
	obj.disp_no.value			=	disp_no;
	f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
	f_query_add_mod.document.forms[0].target="messageFrame";
	obj.submit();
}
 
function Duplicatecheck(){/* Below code added for ML-BRU-SCF-0621[IN036565] -- Start */
	var patientId = document.formPhMednRtnCriteria.p_patient_id.value; 
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
	document.formPhMednRtnCriteria.p_patient_id.value=main_patientid;    
}/* code added for ML-BRU-SCF-0621[IN036565] -- End */ 
