
function reset() {
	formObj = f_query_add_mod.document.formStockFSMoveReportCriteria;
	formObj.reset();
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
function searchCodeItem(obj) {
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
	argumentArray[5] = obj.value.toUpperCase();
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
function searchCodeItemClass(obj) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	argumentArray[0] = document.getElementById("SQL_ST_ITEM_CLASS_LOOKUP_LANG").value + "'" + document.forms[0].p_language_id.value + "'";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value.toUpperCase();
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.ItemClass.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}

//MONTH_YEAR_INVALID
function chkMonth(month) {
	if (parseInt(month.value) > 12) {
		alert(getMessage("MONTH_YEAR_INVALID"));
		month.value = "";
		month.focus();
		return false;
	}
	if (parseInt(month.value) < 10) {
		month.value = eval(month.value);
	}
}
function CheckForSpecialChars(event) {
	var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-.";
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) {
		return false;
	}  // Not a valid key
	//if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	//	return (event.keyCode -= 32);
	return true;
}
function chkYear(year) {
	if (parseInt(year.value.length) < 4) {
		alert(getMessage("MONTH_YEAR_INVALID"));
		year.value = "";
		year.focus();
		return false;
	}
}
function run() {
	formObj = f_query_add_mod.document.formStockFSMoveReportCriteria;
	if (formObj.p_order_option.value == "S") {
		formObj.p_report_id.value = "STBFSMOS";
	} else {
		formObj.p_report_id.value = "STBFSMOV";
	}
	if (formObj.p_rep_option.value == "A") {
		formObj.p_order_by.value = "";
	} else {
		if (formObj.p_rep_option.value == "Q") {
			formObj.p_order_by.value = "Order by 5 desc";
		} else {
			if (formObj.p_rep_option.value == "V") {
				formObj.p_order_by.value = "Order by 6 desc ";
			} else {
				if (formObj.p_rep_option.value == "N") {
					formObj.p_order_by.value = "Order by 2 desc";
				}
			}
		}
	}
	if (!chkdateandmonth()) {
		return;
	}
	flag = true;
	if (flag) {
		if (isValidFromToField(formObj.p_fm_store_code, formObj.p_to_store_code, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)) {
			if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
				if (isValidFromToField(formObj.p_fm_item_class_code, formObj.p_to_item_class_code, STRING, getLabel("Common.ItemClass.label", "Common"), messageFrame)) {
					if (isValidFromToField(formObj.p_fm_alpha_code, formObj.p_to_alpha_code, STRING, getLabel("Common.AlphaCode.label", "Common"), messageFrame)) {
						if (isValidFromToField(formObj.p_fm_value, formObj.p_to_value, INT, getLabel("Common.Range.label", "Common"), messageFrame)) {
							formObj.submit();
						}
					}
				}
			}
		}
	}
}
function chkdateandmonth() {
	formObj = f_query_add_mod.document.formStockFSMoveReportCriteria;
	if (formObj.p_fm_year.value != "") {
		if (formObj.p_fm_year.value.length != 4) {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("INVALID_YR_FORMAT");//Invalid Year Format";
			return false;
		}
	}
	if (formObj.p_to_year.value != "") {
		if (formObj.p_to_year.value.length != 4) {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("INVALID_YR_FORMAT");//Invalid Year Format";
			return false;
		}
	}
	if ((formObj.p_fm_month.value != "" && formObj.p_fm_year.value != "" && formObj.p_to_month.value != "" && formObj.p_to_year.value != "")) {
		var from = formObj.p_fm_month.value;
		var to = formObj.p_to_month.value;
		if (formObj.p_fm_month.value > 0 && formObj.p_fm_month.value < 10 && from.length < 2) {
			var fm_month = "0" + formObj.p_fm_month.value;
		} else {
			var fm_month = formObj.p_fm_month.value;
		}
		if (formObj.p_to_month.value > 0 && formObj.p_to_month.value < 10 && to.length < 2) {
			var p_month = "0" + formObj.p_to_month.value;
		} else {
			var p_month = formObj.p_to_month.value;
		}
		from = formObj.p_fm_year.value + fm_month;
		to = formObj.p_to_year.value + p_month;
		if (from <= to) {
			return true;
		} else {
			if (from > to) {
				alert(getMessage("FM_M0NTH_YEAR_SHOULD_LESS"));
				return false;
			}
		}
	}
	return true;
}
function disRange(obj) {
	if (obj.options.selectedIndex == 0) {
		document.formStockFSMoveReportCriteria.p_fm_value.value = "";
		document.formStockFSMoveReportCriteria.p_fm_value.disabled = true;
		document.formStockFSMoveReportCriteria.p_to_value.value = "";
		document.formStockFSMoveReportCriteria.p_to_value.disabled = true;
	} else {
		document.formStockFSMoveReportCriteria.p_fm_value.disabled = false;
		document.formStockFSMoveReportCriteria.p_to_value.disabled = false;
	}
}

