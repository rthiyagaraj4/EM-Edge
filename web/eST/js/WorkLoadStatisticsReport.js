
function reset() {
	formObj = f_query_add_mod.document.formWorkLoadStatisticsReportCriteria;
	formObj.reset();
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
	 	 arr=ret1.split(",");
		obj.value = arr[0];
	}
}
async function searchUserCode(target) {
	parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.forms[0].p_language_id.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] = document.getElementById("SQL_SM_APPL_USER_USER_LOOK_UP").value;
	argumentArray[4] = "2,3";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	if (!document.forms[0].target.readOnly) {
		retVal = await CommonLookup(getLabel("Common.user.label", "common"), argumentArray);
	} else {
		retVal = "";
	}
	if (retVal != null && retVal != "") {
		var ret1=unescape(retVal);
	 	arr=ret1.split(",");
		target.value = arr[0];
//		htarget.value=retVal[0];
	}
}
function run() {
	formObj = f_query_add_mod.document.formWorkLoadStatisticsReportCriteria;
	var localeName = formObj.p_language_id.value;
	if (isValidFromToField(formObj.P_FM_USER_ID, formObj.P_TO_USER_ID, STRING,getLabel("Common.username.label", "Common"), messageFrame)) {
		if (isValidFromToField(formObj.P_FM_STORE_CODE, formObj.P_TO_STORE_CODE, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)) {
			if (isValidFromToField(formObj.P_FM_DATE, formObj.P_TO_DATE, DATE,getLabel("Common.DocDate.label", "Common"), messageFrame)) {
				formObj.P_FM_DATE.value = convertDate(formObj.P_FM_DATE_1.value, "DMY", localeName);
			}
		}
	}
	formObj.P_TO_DATE.value = convertDate(formObj.P_TO_DATE_1.value, "DMY", localeName);
	f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
   	f_query_add_mod.document.forms[0].target="messageFrame"
	formObj.submit();
}

