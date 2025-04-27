
var formObj = "";
function reset() {
	formObj = f_query_add_mod.document.formQAPReport;
	formObj.reset();
}
function setreportid() {
	formObj = parent.f_query_add_mod.document.formQAPReport;
	if (formObj.qapreportoption.value == "A") {
		formObj.p_report_id.value = "STBANSTK";
	} else {
		if (formObj.qapreportoption.value == "B") {
			formObj.p_report_id.value = "STBSTKWO";
		}
	}
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
	formObj = f_query_add_mod.document.formQAPReport;
	fields[0] = formObj.qapreportoption;
	fieldNames[0] = "QAP Report";
	fields[1] = formObj.p_facility_id;
	fieldNames[1] = "Facility Name";
	fields[2] = formObj.p_store_code;
	fieldNames[2] = "Store Code";
	blankObject = checkSTFields(fields, fieldNames, messageFrame);
	if (blankObject == true) {
		if (!checkDateMonYear()) {
			return;
		}
		formObj.submit();
	} else {
	}
}
function checkDateMonYear() {
	formObj = f_query_add_mod.document.formQAPReport;
	if (formObj.P_FM_YEAR.value.length != 4) {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("MONTH_YEAR_INVALID", "SM");//Invalid Year Format";
		return false;
	}
	if (formObj.P_TO_YEAR.value.length != 4) {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("MONTH_YEAR_INVALID", "SM");//Invalid Year Format";
		return false;
	}
	if (formObj.P_FM_MOVE_MONTH.value > 12) {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("MONTH_YEAR_INVALID", "SM");//Invalid Month Format";
		return false;
	}
	if (formObj.P_TO_MOVE_MONTH.value > 12) {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("MONTH_YEAR_INVALID", "SM");//Invalid Month Format";
		return false;
	}
	var pmonth = formObj.P_FM_MOVE_MONTH.value;
	if (parseInt(formObj.P_FM_MOVE_MONTH.value) > 0 && parseInt(formObj.P_FM_MOVE_MONTH.value) < 10 || parseInt(formObj.P_FM_MOVE_MONTH.length) < 2) {
		var fm_month = "0" + formObj.P_FM_MOVE_MONTH.value;
	} else {
		var fm_month = formObj.P_FM_MOVE_MONTH.value;
	}
	var curmonth = formObj.P_TO_MOVE_MONTH.value;
	if (parseInt(formObj.P_TO_MOVE_MONTH.value) > 0 && parseInt(formObj.P_TO_MOVE_MONTH.value) < 10 || formObj.P_TO_MOVE_MONTH.length < 2) {
		var p_month = "0" + formObj.P_TO_MOVE_MONTH.value;
	} else {
		var p_month = formObj.P_TO_MOVE_MONTH.value;
	}
	pmonth = formObj.P_FM_YEAR.value + fm_month;
	curmonth = formObj.P_TO_YEAR.value + p_month;
	if (curmonth - pmonth > 100) {
		alert(getMessage("PERIOD_N_GR_TN_12_MONTH", "ST"));
		formObj.P_FM_MOVE_MONTH.focus();
		return;
	}
	if (pmonth <= curmonth) {
		return true;
	} else {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("TO_DT_GR_EQ_FM_DT", "SM");//Should be Less than Current month";
		return false;
	}
	return true;
}

