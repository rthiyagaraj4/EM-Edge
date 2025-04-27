function create() {
	f_query_add_mod.location.href = "../../eST/jsp/DirectSalesPatientModify.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
	f_query_result.location.href = "../../eST/jsp/DirectSalesPatientQueryResult.jsp?mode=" + MODE_MODIFY + "&function_id=" + function_id;
}
function apply() {
	var formObj = f_query_add_mod.document.DirectSalesPatientForm;
	if(formObj==undefined){
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" ;
	return
	}
		var mode = f_query_add_mod.document.DirectSalesPatientForm.mode.value;
	
	if (formObj.patient_id.value != "") {
       
		var blankObject = false;
		var errorPage = "../../eCommon/jsp/error.jsp";
		blankObject = checkSTFields(messageFrame, errorPage);
		if (blankObject) {
	if(mode=="1"){
	    var xmlString = getXMLString(null);
	    var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
		var xmlHttp = new XMLHttpRequest();
		//var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eST/jsp/DirectSalesPatientValidate.jsp?patient_id=" + formObj.patient_id.value + "&validate=PATIENT_ID_IN_ST", false);
		xmlHttp.send(xmlString);
		var responseText = xmlHttp.responseText;
		responseText = trimString(responseText);
		eval(responseText);
		if(result){
		messageFrame.location.href = errorPage + "?err_num=" +getMessage("CODE_ALREADY_EXISTS","Commom") 
		return false;
		}
		}
			eval(formApply(formObj, ST_CONTROLLER));
			messageFrame.location.href = errorPage + "?err_num=" + message;
			if (result) {
				onSuccess();
			}
		}
	} else {
		var formObj = f_query_add_mod.document.DirectSalesPatientForm;
		var fields = new Array(formObj.patient_id);
		var names = new Array("PatientID");
		var blankObject = null;
		var errorPage = "../../eCommon/jsp/error.jsp";
		blankObject = checkSTFields(fields, names, messageFrame, errorPage);
	}
}
function onSuccess() {
	var mode = f_query_add_mod.document.DirectSalesPatientForm.mode.value;
	if (mode == MODE_INSERT || mode == MODE_MODIFY) {
		create();
	} else {
		f_query_add_mod.document.location.reload();
	}
}
function reset() {
	var formObj = f_query_add_mod.document.DirectSalesPatientForm;
	if (f_query_add_mod.document.DirectSalesPatientForm != null) {
		create();
	}
    	
	
}
/*function searchPatientId(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	document.DirectSalesPatientForm.patient_name.value = "";
	var sql_store = document.forms[0].SQL_ST_MP_PATIENT_LOOKUP.value;
	sql_store = sql_store.replace(/lang_id/, document.DirectSalesPatientForm.locale.value);
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	argumentArray[0] = sql_store;
   
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.patientId.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		var obj1 = document.DirectSalesPatientForm.patient_name;
		obj.value = returnedValues[0];
		obj1.value = returnedValues[1];
	}
}*/

async function searchPatientId() {
	
	var patient_id = await PatientSearch();
	var formObj = document.DirectSalesPatientForm;


	if (!((patient_id == null) || (patient_id == "") || (patient_id==undefined ))) {
		  formObj.patient_id.value = patient_id;
		  var xmlString = getXMLString(null);
          var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
          var xmlHttp = new XMLHttpRequest();
          var url = "../../eST/jsp/DirectSalesPatientValidate.jsp?patient_id=" + encodeURIComponent(patient_id) + "&validate=PATIENT_NAME";
          xmlHttp.open("POST", url, false); 
          xmlHttp.setRequestHeader("Content-Type", "text/xml");
          xmlHttp.send(xmlString);
          var responseText = xmlHttp.responseText;
          responseText = trimString(responseText); 
          eval(responseText); 

	}
	
}

function Modify(obj, patientName, e) {
	var patient_id = obj;//obj.cells[0].innerText;
	var patient_name = patientName;
	f_query_add_mod.location.href = "../../eST/jsp/DirectSalesPatientModify.jsp?mode=" + MODE_MODIFY + "&function_id=" + parent.function_id + "&patient_id=" + patient_id + "&patient_name=" + patient_name + "&enabled=" + e;
}

function searchPatientId1(patient_id) {
//	var errorPage = "../../eCommon/jsp/error.jsp";
//	parent.messageFrame.location.href = errorPage + "?err_num=" ;

	if (patient_id.value != null || patient_id.value != "") {
		 var xmlString = getXMLString(null);
         var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
         var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("POST", "../../eST/jsp/DirectSalesPatientValidate.jsp?patient_id=" + patient_id.value + "&validate=PATIENT_NAME", false);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
        xmlHttp.send(xmlString);
        var responseText = xmlHttp.responseText;
        responseText = trimString(responseText); 
        eval(responseText); 

	}
	
}


