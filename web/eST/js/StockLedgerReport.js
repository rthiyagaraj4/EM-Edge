
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
	if ((returnedValues != null) && (returnedValues != "")) {
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		obj.value = arr[0];
	}
}
async function searchCodeItemClass(obj) {
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
	returnedValues = await CommonLookup(getLabel("Common.ItemClass.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		obj.value = arr[0];
	}
}
async function searchAlphaCode(obj) {
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
	returnedValues = await CommonLookup(getLabel("Common.AlphaCode.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
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
	if ((returnedValues != null) && (returnedValues != "")) {
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		obj.value = arr[0];
	}
}
function checkMonYear() {
	formObj = f_query_add_mod.document.StockLedgerReportCriteria;
	var p_fm_year = formObj.p_fm_year.value;
	var p_to_year = formObj.p_to_year.value;
	var p_fm_month = formObj.p_fm_month.value;
	var p_to_month = formObj.p_to_month.value;
	var curr_proc_year = formObj.curr_proc_year.value;
	var curr_proc_month = formObj.curr_proc_month.value;
	var fromPeriod = parseFloat(formatNumber(p_fm_year, 4) + formatNumber(p_fm_month, 2));
	var toPeriod = parseFloat(formatNumber(p_to_year, 4) + formatNumber(p_to_month, 2));
	var currPeriod = parseFloat(formatNumber(curr_proc_year, 4) + formatNumber(curr_proc_month, 2));
	if ((formObj.p_fm_year.value.length != 4) || (formObj.p_to_year.value.length != 4)) {
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
						if (doDateCheck(formObj.fm_date, formObj.to_date, messageFrame)) {
							formObj.fm_date.value = convertDate(formObj.fm_date_1.value, "DMY", formObj.p_language_id.value, "en");
							formObj.to_date.value = convertDate(formObj.to_date_1.value, "DMY", formObj.p_language_id.value, "en");
						}
					}
				}
			}
		}
		
		//Added by Rabbani validation of From Store & ToStore on 28/03/12 Starts
		var p_fr_str_code = f_query_add_mod.document.StockLedgerReportCriteria.p_fr_str_code.value;
		var p_to_str_code = f_query_add_mod.document.StockLedgerReportCriteria.p_to_str_code.value;
	  if(p_fr_str_code==""){
		alert(getMessage("FROM_STORE_NOT_DEFINED", "ST"));
		f_query_add_mod.document.StockLedgerReportCriteria.p_fr_str_code.focus();
		return;
		}  
		if(p_to_str_code==""){
		alert("APP-ST0117 To Store Cannot be blank...");
		f_query_add_mod.document.StockLedgerReportCriteria.p_to_str_code.focus();
		return;
		} 
		 var p_from_year = f_query_add_mod.document.StockLedgerReportCriteria.p_fm_year.value;
		 var p_to_year = f_query_add_mod.document.StockLedgerReportCriteria.p_to_year.value;
		 if(p_from_year == 0000 ){
		  alert(getMessage("INVALID_YEAR_FORMAT", "SM"));
	     f_query_add_mod.document.StockLedgerReportCriteria.p_fm_year.select();
	     f_query_add_mod.document.StockLedgerReportCriteria.p_fm_year.focus();
	    return;
	  }
		if(p_to_year == 0000 ){
		alert(getMessage("INVALID_YEAR_FORMAT", "SM"));
	    f_query_add_mod.document.StockLedgerReportCriteria.p_to_year.select();
	    f_query_add_mod.document.StockLedgerReportCriteria.p_to_year.focus();
	   return;
	  } 
		//ends
		var fm_date_1 = f_query_add_mod.document.StockLedgerReportCriteria.fm_date_1.value;
		if(fm_date_1==""){
		alert(getMessage("FROM_DATE_NOT_BLANK", "ST"));
		f_query_add_mod.document.StockLedgerReportCriteria.fm_date_1.focus();
		return;
		}

		var to_date_1 = f_query_add_mod.document.StockLedgerReportCriteria.to_date_1.value;
		if(to_date_1==""){
		alert(getMessage("TO_DATE_NOT_BLANK", "ST"));
		f_query_add_mod.document.StockLedgerReportCriteria.to_date_1.focus();
		return;
		}

		if (isValidFromToField(formObj.fm_date_1, formObj.to_date_1, DATE, getLabel("Common.date.label", "Common"))) {
						formObj.action="../../eCommon/jsp/report_options.jsp";
						formObj.target="messageFrame";
						formObj.submit();
					}

		//formObj.to_date.value = convertDate(formObj.to_date_1.value, "DMY", formObj.p_language_id.value, "en");
		 
	//formObj.submit();
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



