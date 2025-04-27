
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
var formObj = "";
function reset() {
	formObj = f_query_add_mod.document.StockLedgerReportCriteria;
	formObj.reset();
//	parent.frames[1].frames[1].document.forms[0].reset();
}
function searchCodeItem(obj) {
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
	returnedValues = CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
function searchCodeItemClass(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	argumentArray[0] = document.getElementById("SQL_ST_ITEM_CLASS_LOOKUP_LANG").value + "'" + document.forms[0].p_language_id.value + "'";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.ItemClass.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
function searchAlphaCode(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	argumentArray[0] = document.forms[0].SQL_ST_ALPHA_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.AlphaCode.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
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
function checkMonYear() {
	formObj = f_query_add_mod.document.StockLedgerReportCriteria;
/*	var doc_date = formObj.p_dt_from_1.value;
	var split_date = doc_date.split("/");
	var day = split_date[0];
	var month = split_date[1];
	var year = split_date[2];
	alert(day);
	alert(month);
	alert(year);*/
	var p_fm_year = formObj.p_fm_year1.value;
	var p_to_year = formObj.p_to_year1.value;
	var p_fm_month = formObj.p_fm_month.value;
	var p_to_month = formObj.p_to_month.value;
	var curr_proc_year = formObj.curr_proc_year.value;
	var curr_proc_month = formObj.curr_proc_month.value;
	var fromPeriod = parseFloat(formatNumber(p_fm_year, 4) + formatNumber(p_fm_month, 2));
	var toPeriod = parseFloat(formatNumber(p_to_year, 4) + formatNumber(p_to_month, 2));
	var currPeriod = parseFloat(formatNumber(curr_proc_year, 4) + formatNumber(curr_proc_month, 2));
	if ((formObj.p_fm_year1.value.length != 4) || (formObj.p_to_year1.value.length != 4)) {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("MONTH_YEAR_INVALID", "SM");
		return false;
	} else {
		if ((formObj.p_fm_month.value > 12) || (formObj.p_to_month.value > 12) || (formObj.p_fm_month.value < 1) || (formObj.p_to_month.value < 1)) {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("MONTH_YEAR_INVALID", "SM");
			return false;
		} else {
			if (fromPeriod > toPeriod) {
				var stMessage = getMessage("LESS_OR_EQUAL_VALIDATE", "ST");
				stMessage = stMessage.replace(/@/g, "Month/Year");
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + stMessage;
				return false;
			} else {
				if (toPeriod > currPeriod) {
					messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("CANNOT_BE_GT_CURR_PERIOD", "ST");
					return false;
				}
			}
		}
	}
	return true;
}
function formatNumber(number, length) {
	var returnNumber = "" + number;
	if (isNaN(returnNumber)) {
		returnNumber = "0";
	}
	var numberLength = length - returnNumber.length;
	for (i = 0; i < numberLength; i++) {
		returnNumber = "0" + returnNumber;
	}
	return returnNumber;
}
/*
function validateMonYear(){
   formObj=f_query_add_mod.document.StockLedgerReportCriteria;
   if (parseFloat(formObj.p_fm_year.value)>parseFloat(formObj.p_to_year.value))  
	{
	   messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=FROM YEAR should be Lesser than TO YEAR";
	   return false;
   }
   else{
	   if (formObj.p_fm_month.value>formObj.p_to_month.value) 
	   {
		   messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=FROM MONTH should be Lesser than TO MONTH";
		   return false;
	   }
   }
   return true;
}
*/
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
function run() {
	if (f_query_add_mod.document.StockLedgerReportCriteria) {
		formObj = f_query_add_mod.document.StockLedgerReportCriteria;
		if (!checkMonYear()) {
			return;
		}
		/*			if (!validateMonYear())
			{ return;
			}*/
		if (isValidFromToField(formObj.p_fr_str_code, formObj.p_to_str_code, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)) {

			
			if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {

				
				if (isValidFromToField(formObj.p_fr_item_class, formObj.p_to_item_class, STRING, getLabel("Common.ItemClass.label", "Common"), messageFrame)) {

					
					if (isValidFromToField(formObj.p_fr_alpa_code, formObj.p_to_alpa_code, STRING, getLabel("Common.AlphaCode.label", "Common"), messageFrame)) {

						
						if (isValidFromToField(formObj.p_dt_from_1, formObj.p_dt_to_1, DATE, getLabel("Common.DocDate.label", "Common"), messageFrame)) {

					formObj.dt_from.value = convertDate(formObj.p_dt_from_1.value, "DMY", formObj.p_language_id.value, "en");
					formObj.dt_to.value = convertDate(formObj.p_dt_to_1.value, "DMY", formObj.p_language_id.value, "en");
					formObj.p_to_year.value = convertDate(formObj.p_to_year1.value, "YY", formObj.p_language_id.value, "en");
					formObj.p_fm_year.value = convertDate(formObj.p_fm_year1.value, "YY", formObj.p_language_id.value, "en");
										

													if (doDateCheck(formObj.dt_from, formObj.dt_to, messageFrame)) {

													formObj.submit();}
												}
					}
				}
			}
		}
		
	}
}
function searchsuppliercode(obj){
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
	argumentArray[0] = document.getElementById("SQL_AP_SUPPLIER_SELECT_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.Supplier.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}

