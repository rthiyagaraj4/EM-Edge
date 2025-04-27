
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
var formObj = "";
function reset() {
	formObj = f_query_add_mod.document.formStockHandledByMedStoreReport;
	formObj.reset();
}
function numbervalidation() {
	if ((event.keyCode >= 48) && (event.keyCode <= 57)) {
		return true;
	} else {
		event.keyCode = 0;
	}
}
function searchCodeStore(obj) {
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
	returnedValues = CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
function run() {
	var blankObject = null;
	var fields = new Array();
	var fieldNames = new Array();
	formObj = f_query_add_mod.document.formStockHandledByMedStoreReport;
	if (formObj.p_fm_year.value.length != 4) {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("INVALID_YR_FORMAT", "SM");//Invalid Year Format";
		return false;
	}
	if (formObj.p_to_year.value.length != 4) {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("INVALID_YR_FORMAT", "SM");//Invalid Year Format";
		return false;
	}
	fields[0] = formObj.p_facility_id;
	fieldNames[0] = getLabel("Common.FacilityName.label", "Common");
	fields[1] = formObj.p_fm_store_code;
	fieldNames[1] = getLabel("Common.FromStore.label", "Common");
	fields[2] = formObj.p_to_store_code;
	fieldNames[2] =getLabel("Common.ToStore.label", "Common") ;
	fields[3] = formObj.p_fm_year;
	fieldNames[3] = "From Year";
	fields[4] = formObj.p_to_year;
	fieldNames[4] ="To Year";
	blankObject = checkSTFields(fields, fieldNames, messageFrame);
	if (blankObject == true) {
		if (isValidFromToField(formObj.p_fm_store_code, formObj.p_to_store_code, STRING, getLabel("Common.Store.label", "Common"), messageFrame)) {
			if (isValidFromToField(formObj.p_fm_year, formObj.p_to_year, STRING, getLabel("Common.year.label", "Common"), messageFrame)) {
				formObj.submit();
			}
		}
	}
}
function disptoyear() {
	formObj = document.formStockHandledByMedStoreReport;
	if (formObj.p_fm_year.value != "") {
		formObj.p_to_year.value = formObj.p_fm_year.value;
	}
}

