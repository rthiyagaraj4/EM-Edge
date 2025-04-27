var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
var formObj = "";
function reset() {
	formObj = f_query_add_mod.document.VMISalesOrConsumptionCriteria;
	frames[1].document.forms[0].reset();
	//parent.frames[1].frames[1].document.forms[0].reset();
	//frames[1].document.getElementById("p_vat_style").style.visibility = "visible";
	//frames[1].document.getElementById("p_count_style").style.visibility = "visible";
	//frames[1].document.getElementById("p_item_style").style.visibility = "visible";
	formObj.reset();
    //parent.frames[1].frames[1].document.forms[0].reset();
}
function CheckForSpecialChars(event) {
	var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-.";
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);
	if (strCheck.indexOf(key) == -1) {
		return false;
	} 
	return true;
}


async function searchCodeItem(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.forms[0].p_language_id.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] = document.getElementById("SQL_ST_ITEM_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	var str =unescape(returnedValues);
	var arr = str.split(",");
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = arr[0];
	}
}

async function searchCodeStore(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.forms[0].p_language_id.value;
	dataTypeArray[0] = STRING;
	dataNameArray[1] = "facility_id";
	dataValueArray[1] = document.forms[0].p_facility_id.value;
	dataTypeArray[1] = STRING;
	argumentArray[0] = document.getElementById("SQL_ST_STORE_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	var str =unescape(returnedValues);
	var arr = str.split(",");
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = arr[0];
	}
}



function run() {
	
	if (f_query_add_mod.document.VMISalesOrConsumptionCriteria) {
		formObj = f_query_add_mod.document.VMISalesOrConsumptionCriteria;
		if(formObj.p_store_code, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame) {
			if(formObj.p_supp_code, STRING, getLabel("Common.SupplierCode.label", "Common"), messageFrame) {
				if(formObj.p_doc_type_code, STRING, getLabel("Common.DocType.label", "Common"), messageFrame) {
					if(formObj.p_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame) {
						//if(formObj.p_vat, STRING, getLabel("eST.VAT.label", "ST"), messageFrame) {
							if (doDateCheck(formObj.p_fr_doc_date, formObj.p_to_doc_date, messageFrame)) {
								formObj.p_fr_doc_date.value = convertDate(formObj.p_fr_doc_date.value, "DMY", formObj.p_language_id.value, "en");

							}
						formObj.p_to_doc_date.value = convertDate(formObj.p_to_doc_date.value, "DMY", formObj.p_facility_id.value,formObj.p_language_id.value, "en");
						
						if(formObj.p_fr_doc_date.value==""){
						alert(getMessage("DATE_NOT_BLANK", "ST"));
						formObj.p_fr_doc_date.focus();
						return;
					}
					if (isValidFromToField(formObj.p_fr_doc_date, formObj.p_to_doc_date, DATE, getLabel("Common.date.label", "Common"))) {
						
						formObj.action="../../eCommon/jsp/report_options.jsp";
						formObj.target="messageFrame";
						formObj.submit();
					}
						//}
					}
				}
			}
		}
	}
}


function isValidFromToField(fromObj, toObj, dataType, stLegend) {
	var bReturn = true;
	var stFromValue = fromObj.value;
	var stToValue = toObj.value;
	if ((!trimCheck(stFromValue)) || (!trimCheck(stToValue))) {
		return bReturn;
	}
	if (dataType == null) {
		dataType = STRING;
	}
	switch (dataType) {
	  case INT:
	  case LONG:
	  case FLOAT:
	  case DOUBLE:
		if (parseFloat(stFromValue) > parseFloat(stToValue)) {
			bReturn = false;
		}
		break;
	  case DATE:
		var arFromDate = stFromValue.split("/");
		var arToDate = stToValue.split("/");
		if (Date.parse("" + arFromDate[1] + "/" + arFromDate[0] + "/" + arFromDate[2] + "/") > Date.parse("" + arToDate[1] + "/" + arToDate[0] + "/" + arToDate[2] + "/")) {
			bReturn = false;
		}
		break;
	  default:
		if (stFromValue > stToValue) {
			bReturn = false;
		}
	}
	if ((!bReturn)) {
		var stMessage = getMessage("LESS_OR_EQUAL_VALIDATE", "ST");
		stMessage = stMessage.replace(/@/g, stLegend);
		alert(stMessage);
		toObj.focus();
	}
	return bReturn;
}

function changeReport() {
	
	if (document.VMISalesOrConsumptionCriteria.p_report_type.value == "C") {
		document.VMISalesOrConsumptionCriteria.p_report_id.value = "STBVMICSR";
	}
	/*if (document.VMISalesOrConsumptionCriteria.p_report_type.value == "S") {
		document.VMISalesOrConsumptionCriteria.p_report_id.value = "STBVMISWS";
	}
	if (document.VMISalesOrConsumptionCriteria.p_report_type.value == "P") {
		document.VMISalesOrConsumptionCriteria.p_report_id.value = "STBVMIPWR";
	}*/
	
}

function loadcolumn(obj) {
	formObj = document.forms[0];
	
	if (obj.value == "STBVMICSR") {
		formObj.p_vat.disabled = true;
	}
	if (obj.value == "STBVMISWS") {
		formObj.p_vat.disabled = false;
	}
	if (obj.value == "STBVMIPWR") {
		formObj.p_vat.disabled = false;
	}
	
}
function setReportType() {
	var formObject = document.VMISalesOrConsumptionCriteria;
	if (formObject.p_report_id.value == "STBVMISWS" || formObject.p_report_id.value == "STBVMIPWR") {

		document.getElementById("p_vat_style").style.visibility   = "visible";
		document.getElementById("p_vat").style.visibility         = "visible";
		document.getElementById("p_count_style").style.visibility = "visible";
		document.getElementById("p_item_style").style.visibility  = "visible";
	} else {
		document.getElementById("p_vat_style").style.visibility   = "hidden";
		document.getElementById("p_vat").style.visibility         = "hidden";
		document.getElementById("p_count_style").style.visibility = "hidden";
		document.getElementById("p_item_style").style.visibility  = "hidden";
	}
}
