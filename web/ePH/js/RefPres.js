 //saved on 02.11.2005
var function_id = "" ;
var result = false ;
var message = "" ;
var flag = "" ;

function reset() {
	
	f_query_add_mod.frmReferralPrescriptionQueryCriteria.reset();
	f_query_add_mod.document.frames.frmReferralPrescriptionQueryCriteria.patient_name.innerText="";
	f_query_add_mod.document.frames.frmReferralPrescriptionQueryCriteria.patient_sex.innerText="";
	f_query_add_mod.document.frames.frmReferralPrescriptionQueryCriteria.patient_age.innerText="";
	f_query_add_mod.document.frames.frmReferralPrescriptionQueryCriteria.btnPatientID.disabled=false;
	f_query_results.location.href="../../eCommon/html/blank.html";
	
}

// the below method is used for leap year calculation
	function CheckDateT(obj){
		var locale=document.frmReferralPrescriptionQueryCriteria.p_language_id.value;
		if(obj.value!=""){
			if(!validDate(obj.value, 'DMY',locale)){
				alert(getMessage("INVALID_DATE_FMT", "SM"));
				//obj.select();
				//obj.focus();
				obj.value="";
				return false;
			}
		}
		else{
			obj.value=convertDate(obj,'DMY',locale,'en');
		}
	}


async function callPatientSearch(){

	var formObj=document.frmReferralPrescriptionQueryCriteria;
	var patient_id = await PatientSearch();
	if (patient_id!= "" && patient_id != undefined){

		formObj.p_patient_id.value = patient_id;
		formObj.p_patient_id.disabled = true;
		formObj.btnPatientID.disabled = true;

		var bean_id		= formObj.bean_id.value ;
		var bean_name	= formObj.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "AdrReportingValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id+"&validate=CALLPATIENT", false ) ;
			//alert('xmlHttp.xmlDoc  ---  :'+xmlDoc);
		xmlHttp.send( xmlDoc ) ;
		//alert('xmlHttp.responseText  ---  :'+xmlHttp.responseText);
		eval(xmlHttp.responseText);
	}
}

function getPatientValues(){

	var formObj=document.frames.frmReferralPrescriptionQueryCriteria;
	var patient_id = formObj.p_patient_id.value;
	if (patient_id!= "" && patient_id != undefined){
		
//		formObj.p_patient_id.disabled = true;
//		formObj.btnPatientID.disabled = true;

		var bean_id		= formObj.bean_id.value ;
		var bean_name	= formObj.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "AdrReportingValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id+"&validate=CALLPATIENT", false ) ;
		xmlHttp.send( xmlDoc ) ;
		//alert('xmlHttp.responseText  ---  :'+xmlHttp.responseText);
		eval(xmlHttp.responseText);
	}
}


function assignPatientLine(p_name,p_age,p_sex){

	/*document.frames.frmReferralPrescriptionQueryCriteria.patient_name.style.display="inline";
	document.frames.frmReferralPrescriptionQueryCriteria.patient_name.innerText=p_name;
	document.frames.frmReferralPrescriptionQueryCriteria.patient_sex.style.display="inline";
	document.frames.frmReferralPrescriptionQueryCriteria.patient_sex.innerText=p_sex;	
	document.frames.frmReferralPrescriptionQueryCriteria.patient_age.style.display="inline";
	document.frames.frmReferralPrescriptionQueryCriteria.patient_age.innerText=p_age;
	*/
	document.getElementById('patient_name').style="display";
	document.getElementById('patient_name').innerText=p_name;
	document.getElementById('patient_sex').style="display";
	document.getElementById('patient_sex').innerText=p_sex;	
	document.getElementById('patient_age').style="display";;
	document.getElementById('patient_age').innerText=p_age;
	
	
}

function showResults(){
	
	var formObj = document.frmReferralPrescriptionQueryCriteria;
		
	patient_id = formObj.p_patient_id.value;
	var locale				=	formObj.language_id.value;
	var order_date_from		=	convertDate(formObj.order_date_from.value,'DMY',locale,"en"); 
	var order_date_to		=	convertDate(formObj.order_date_to.value,'DMY',locale,"en");
	var ordby=formObj.lstOrderBy.value;
//	order_date_from = formObj.order_date_from.value;
//	order_date_to = formObj.order_date_to.value;

	if(patient_id !=""){
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
	
		parent.f_query_results.location.href="../../ePH/jsp/RefPresQueryResult.jsp?patient_id="+patient_id+"&order_date_from="+order_date_from+"&order_date_to="+order_date_to+"&order_by="+ordby;
		
	}else{
		alert(getMessage('PATIENT_ID_REQUIRED','PH'));
	}
}

function showReport(rprt_id,faclty_id,order_id,disp_no){
	//alert('in showreport :'+rprt_id+' '+faclty_id+' '+order_id+' '+disp_no);

	var formObj = parent.f_query_add_mod.frmReferralPrescriptionQueryCriteria;

	formObj.p_order_id.value = order_id;
	formObj.p_disp_no.value = disp_no;
	parent.f_query_add_mod.document.frmReferralPrescriptionQueryCriteria.submit();
	//parent.f_query_results.location.href="../../eCommon/html/blank.html"; //PH-COMMON-Referral Prescription-Prescription List gets blank // TFS id - 54140
	
}

function Duplicatecheck(){   /* Below code added for ML-BRU-SCF-0621[IN036565] -- Start */ 
	var patientId = document.frmReferralPrescriptionQueryCriteria.p_patient_id.value; 
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
	document.frmReferralPrescriptionQueryCriteria.p_patient_id.value=main_patientid;    
}/* code added for ML-BRU-SCF-0621[IN036565] -- End */
