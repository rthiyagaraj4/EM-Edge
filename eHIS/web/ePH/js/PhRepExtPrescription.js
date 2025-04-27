  //saved on 02.11.2005
var function_id = "" ;
var result = false ;
var message = "" ;
var flag = "" ;
function query(){
	f_query_add_mod.location.href="../../ePH/jsp/PhRepPrintPrescriptionQueryCriteria.jsp";	
	f_query_status.location.href="../../eCommon/html/blank.html";
}
function reset() {    
	f_query_add_mod.frmExtPrescriptionQueryCriteria.reset();  
	f_query_add_mod.frmExtPrescriptionQueryCriteria.btnPatientID.disabled=false;
	f_query_results.location.href='../../eCommon/html/blank.html'
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';   
}

// This will call common patient search
async function callPatientSearch(){

	var formObj=document.frmExtPrescriptionQueryCriteria;
	var patient_id =await PatientSearch();
	if (patient_id!= "" && patient_id != undefined){

		formObj.patient_id.value = patient_id;
		formObj.patient_id.disabled = true;
		formObj.btnPatientID.disabled = true;

		var bean_id		= formObj.bean_id.value ;
		var bean_name	= formObj.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "PhRepPrintPrescriptionValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id, false ) ;
		xmlHttp.send( xmlDoc ) ;		
		eval(xmlHttp.responseText);
	}
}
// the below method is used for leap year calculation
	function CheckDateT(obj){
		var locale=document.frmExtPrescriptionQueryCriteria.p_language_id.value;

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
function validateDate(){  
	var formObj = document.frmExtPrescriptionQueryCriteria;
	if (formObj.order_date_from.value!="" && formObj.order_date_to.value!=""){
		if(!doDateCheck(formObj.order_date_from,formObj.order_date_to,parent.messageFrame)){
			formObj.order_date_to.select();
			return false;
		}else{
			parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
		
		}
	}
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
	return true;
}

function showResults(pat_id){

if(pat_id=="") {
	if (!validateDate()) 
	{
		return;
	}
	var formObj = document.frmExtPrescriptionQueryCriteria;
	var locale			= formObj.language_id.value;
	var orig_order_id   = formObj.order_id.value;
	var patient_id      = formObj.patient_id.value;
	var order_date_from = formObj.order_date_from.value; 
	var order_date_to   = formObj.order_date_to.value; 
	var ordby=formObj.lstOrderBy.value;
	var date=new Array();
	if(order_date_from!='')
	{
		date=order_date_from.split(' ');
		if(date[1] == undefined){
        order_date_from =order_date_from+' 00:00';
		}
		order_date_from = convertDate(order_date_from,'DMYHM',locale,"en");
	}
	if(order_date_to!=''){
		date=order_date_to.split(' ');
		if(date[1] == undefined){
		order_date_to   =order_date_to+' 23:59';
		}
		order_date_to   = convertDate(order_date_to,'DMYHM',locale,"en"); 
	}
	formObj.order_date_from.value=convertDate(order_date_from,'DMYHM',"en",locale);
	formObj.order_date_to.value=convertDate(order_date_to,'DMYHM',"en",locale);
	if(patient_id !="" || orig_order_id != ""){
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="; 
	parent.f_query_results.location.href="../../ePH/jsp/PhRepExtPrescripResult.jsp?patient_id="+patient_id+"&orig_order_id="+orig_order_id+"&order_date_from="+order_date_from+"&order_date_to="+order_date_to+"&order_by="+ordby;
	//parent.f_query_status.location.href="../../ePH/jsp/PhRepPrintPrescriptionStatus.jsp";
		}else{ 
		
		if(formObj.order_id.value == "" && formObj.patient_id.value == "" ){ 
			parent.f_query_results.location.href="../../eCommon/html/blank.html";
			parent.f_query_status.location.href="../../eCommon/html/blank.html";	parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("PRES_NO_OR_PATIENT_ID_NOT_BLANK","PH") ;  
		}		
	}
} 
}

function SubmitLink(from,to,patient_id,orig_order_id,order_date_from,order_date_to,ordby){
	var obj=document.frmExtPrescriptionResult;
	obj.from.value=from;
	obj.to.value=to;
	obj.patient_id.value=patient_id;
	obj.order_id.value=orig_order_id;
	obj.order_date_from.value=order_date_from;
	obj.order_date_to.value=order_date_to;
	obj.order_by.value=ordby;
	obj.submit();
}
async function showReportPrescription(order_id,patient_id,encounter_id,patient_class,locn_code,iv_type){
	var dialogHeight= "10" ;
	var dialogWidth	= "33" ;
	var dialogTop = "200" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal =await window.showModalDialog("../../ePH/jsp/PhRepPrintIVPrescriptionWindow.jsp?order_id="+order_id+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&locn_code="+locn_code+"&iv_type='EXT'",arguments,features);
}

function showReport(){
	
	//	document.frmPrintPrescriptionReportWindow.submit();
//../../eCommon/jsp/report_options.jsp

		var bean_id		= document.frmPrintPrescriptionReportWindow.bean_id.value ;
		var bean_name	= document.frmPrintPrescriptionReportWindow.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		
		xmlStr	="<root><SEARCH " ;
		xmlStr += "p_order_id=\""+ document.frmPrintPrescriptionReportWindow.p_order_id.value +"\" " ;
		xmlStr += "p_patclass=\""+ document.frmPrintPrescriptionReportWindow.p_patclass.value +"\" " ;
		xmlStr += "p_locncode=\""+ document.frmPrintPrescriptionReportWindow.p_locncode.value +"\" " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
//		alert(xmlStr);
		xmlHttp.open( "POST", "PhRepPrintPrescriptionWindowTemp.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name , false ) ;
		xmlHttp.send( xmlDoc ) ;
	//	alert(xmlHttp.responseText);
		eval(xmlHttp.responseText);
		parent.window.close();
}

function submitTheWindow() {
	 f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
	 f_query_add_mod.document.forms[0].target="messageFrame";
	document.frmPrintPrescriptionReportWindow.submit();
}
function showPrintReport(order_id,patient_class){

	var formObj = parent.f_query_add_mod.frmExtPrescriptionQueryCriteria;


	formObj.p_order_id.value = order_id ;
	formObj.p_patclass.value = patient_class;
	formObj.action="../../eCommon/jsp/report_options.jsp";
	formObj.target="messageFrame";
	parent.f_query_add_mod.frmExtPrescriptionQueryCriteria.submit();


}


function assignNationalityHealthCardNo(nationality_desc,short_desc){


}
 
function Duplicatecheck(){   /* Below code added for ML-BRU-SCF-0621[IN036565] -- Start */
	var patientId = document.frmExtPrescriptionQueryCriteria.patient_id.value; 
	if((patientId != null) && (patientId !="")){
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
	document.frmExtPrescriptionQueryCriteria.patient_id.value=main_patientid;    
}/* code added for ML-BRU-SCF-0621[IN036565] -- End */
