  //for patient lookup


function query(){
	f_query_criteria.location.href="../../ePH/jsp/PendingMedicationOrderStatusCriteria.jsp";
}



async function callPatientSearch(target){
	var patient_id = await PatientSearch();
	if (typeof(patient_id)=="string"){
		target.value = patient_id;
	}
}
function loadorders(){

	var frmObj=parent.f_query_criteria.document.formPendingOrderCriteria;
	var fields=new Array();
	fields[0]=frmObj.patient_id;
	//fields[1]=frmObj.disp_location;
	
	
	var names=new Array();
	names[0]	= getLabel("Common.patientId.label","Common");
	//names[1]	= getLabel("ePH.DispenseLocation.label","PH");
	
	var errorPage	= "../../eCommon/jsp/error.jsp" ;
	var blankObject  = checkFields( fields, names, parent.messageFrame, errorPage) ;
	if (blankObject!=true){
		return;
	}
	else{
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
	}

	var disp_locn_code	    =	parent.f_query_criteria.document.formPendingOrderCriteria.disp_location.value;
	var patient_id		    =	parent.f_query_criteria.document.formPendingOrderCriteria.patient_id.value;
	var ordering_facility_code	=	parent.f_query_criteria.document.formPendingOrderCriteria.order_facility.value;
  	parent.f_order_detail.location.href="../../ePH/jsp/PendingMedicationOrderStatusOrderDetails.jsp?patient_id="+patient_id+"&ordering_facility_code="+ordering_facility_code+"&disp_locn_code="+disp_locn_code+"&called_from=pendingorders";
}

function reset(){
	f_query_criteria.document.formPendingOrderCriteria.reset();
	f_order_detail.location.href = '../../eCommon/html/blank.html';
    f_query_criteria.location.href="../../ePH/jsp/PendingMedicationOrderStatusCriteria.jsp";   // Added for SKR-SCF-1108 [IN:057252]

}

async function callPendingrefillorders(patient_id,order_id){
	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
	var dialogTop = "10" ;
	var center = "1" ;
	var status="NO";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../ePH/jsp/PendingRefillOrders.jsp?patient_id="+patient_id+"&order_id="+order_id,arguments,features);

}

async function  callDispLocSearch(target)
{//new modification added for for MOHE-SCF-0202 AND 201


	var ordering_facility_id = document.formPendingOrderCriteria.order_facility.options[document.formPendingOrderCriteria.order_facility.selectedIndex].value;
	
	var language_id    = document.formPendingOrderCriteria.locale.value;
  // alert("ordering_facility_id-------->"+ordering_facility_id);
   //alert("language_id-------->"+language_id);
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();

	dataNameArray[0]   = "FACILITY_ID" ;
	dataValueArray[0]  = ordering_facility_id;
	dataTypeArray[0]   = STRING ;
//added for mohe-scf-0201
	var parNameArray  = new Array() ;
	var parValueArray  = new Array() ;
	parNameArray[0] ="~LOCALE_ID`";
	parValueArray[0]=language_id; 

//	argumentArray[0]   = sql+"'"+language_id+"' order by 2";
	argumentArray[0]   = "";//removed for mohe-scf-0201
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4]   = "2,3";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;
	
	//added for mohe-scf-0201
	argumentArray[12]  = "SQL_PH_DISP_LOCN_LANG_VW_SELECT";
	argumentArray[13]  = "ePH.Common.PhRepository";
	argumentArray[14]  = parNameArray
	argumentArray[15]  = parValueArray

	returnedValues = await CommonLookup(getLabel("ePH.DispenseLocation.label","PH"), argumentArray );
	if ((returnedValues != null) && (returnedValues != "")) {
		target.value = returnedValues[0];
	}
}

function getPatientDtl(obj, patient_len){
	if(obj.value !=null && obj.value!=''){
		var patient_id = obj.value;
		if(patient_id.length == parseInt(patient_len)){
			parent.f_query_criteria.location.href="../../ePH/jsp/PendingMedicationOrderStatusCriteria.jsp?patient_id="+patient_id;
		chkPatientID(); //code added for ML-BRU-SCF-0621[IN036565]
		}
		else{
			alert(getMessage("PH_NOT_VALID_PATIENT","PH"));
			obj.focus;
			return false;
		}		
	}
} 

/* Below code added for ML-BRU-SCF-0621[IN036565] -- Start */ 
function chkPatientID(){ 
	var patient_id = document.formPendingOrderCriteria.patient_id.value; 
	if( (patient_id != null) && (patient_id !="")){		
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="";
		xmlStr ="<root><SEARCH " ;
		xmlStr+= "bean_id  ='PHReportsBean' " ;
		xmlStr+= "bean_name = 'ePH.PHReportsBean' " ;
		xmlStr	+= "patient_id=\""+ patient_id + "\" ";
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "ReportsValidate.jsp?called_from=patientsearch", false ) ;
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
	} 
}
function chkpatID(yes_no){
	var frmObj = "";
	formObj=document.formPendingOrderCriteria;
	if(yes_no == "N"){
		alert(getMessage("PH_NOT_VALID_PATIENT","PH"));
		formObj.patient_id.value="";
		formObj.patient_id.focus();
	}		
}
function Duplicatecheck(){  /* code added for ML-BRU-SCF-0621[IN036565] -- start */  
	var patientId = document.formPendingOrderCriteria.patient_id.value; 
	if( (patientId != null) && (patientId !="")){
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
	document.formPendingOrderCriteria.patient_id.value=main_patientid;  
}/* code added for ML-BRU-SCF-0621[IN036565] -- End */
