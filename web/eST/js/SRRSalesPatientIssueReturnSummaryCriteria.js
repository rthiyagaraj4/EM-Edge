
function reset() {
	f_query_add_mod.location.href = "../../eST/jsp/SRRSalesPatientIssueReturnSummaryCriteria.jsp";
	flag = false;
}
function blng_grp_lkup(obj){
var sql="SELECT a.blng_grp_id code, a.short_desc description FROM bl_blng_grp_lang a WHERE a.language_id LIKE ?   AND UPPER (a.blng_grp_id) LIKE UPPER (?)  AND UPPER (a.short_desc) LIKE UPPER (?) order by 2,1" ;
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.forms[0].p_language_id.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] =  sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.BillingGroup.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
		//alert(returnedValues[1]);
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

	if (f_query_add_mod.document.SRRSalesPatientIssueReturn) {
		formObj = f_query_add_mod.document.SRRSalesPatientIssueReturn;
		if (!checkMonYear()) {
			return;
		}
		
		if (isValidFromToField(formObj.p_fr_str_code, formObj.p_to_str_code, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)) {

			if (isValidFromToField(formObj.P_Privilege, formObj.P_Privilege_to, STRING, getLabel("Common.BillingGroup.label", "Common"), messageFrame)) {
             formObj.p_fm_year.value=convertDate( formObj.p_fm_year1.value,'YY',formObj.p_language_id.value,"en");
			 formObj.p_to_year.value=convertDate( formObj.p_to_year1.value,'YY',formObj.p_language_id.value,"en");
             
			formObj.submit();
		}
		}
	}
}
function checkMonYear() {
	formObj = f_query_add_mod.document.SRRSalesPatientIssueReturn;
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
