var sort_by = "";
function reset() {
	frames[1].document.forms[0].reset();
} 
function query() {
	f_query_add_mod.location.href = "../../eST/jsp/DrugStockStatusReport.jsp";
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
	dataValueArray[0] = document.DrugStockStatusReportCriteria_form.p_language_id.value;
	dataTypeArray[0] = STRING;
	dataNameArray[1] = "facility_id";
	dataValueArray[1] = document.DrugStockStatusReportCriteria_form.p_facility_id.value;
	dataTypeArray[1] = STRING;	
	var sql = "SELECT    DISTINCT A.STORE_CODE CODE, A.SHORT_DESC DESCRIPTION FROM MM_STORE_LANG_VW A, ST_STORE C, ST_ACC_ENTITY_PARAM D, ST_USER_ACCESS_FOR_STORE E WHERE A.LANGUAGE_ID LIKE ? AND A.FACILITY_ID LIKE ? AND A.STORE_CODE LIKE UPPER (?) AND UPPER (A.SHORT_DESC) LIKE UPPER (?) AND A.EFF_STATUS = 'E' AND A.STORE_CODE = C.STORE_CODE AND C.STORE_TYPE_FLAG != 'N' AND E.USER_ID LIKE DECODE(D.RESTRICT_VIEW_STK_STATUS , 'ALL','%', '"+document.forms[0].p_user_name.value+"') AND C.STORE_CODE = E.STORE_CODE";
	argumentArray[0] = encodeURIComponent(sql)+" ORDER BY 2";
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

function CheckForSpecialChars(event) {
	var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-.";
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) {
		return false;
	} 
	return true;
}

function run() {
	if (f_query_add_mod.document.DrugStockStatusReportCriteria_form) {
		formObj = f_query_add_mod.document.DrugStockStatusReportCriteria_form;
				if (isValidFromToField(formObj.p_fr_st_code, formObj.p_to_st_code, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)) {
						if (isValidFromToField(formObj.p_fr_item_class, formObj.p_to_item_class, STRING, getLabel("Common.ItemClass.label", "Common"), messageFrame)) {

		if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING,getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
		
				if (isValidFromToField(formObj.p_fr_alpa_code, formObj.p_to_alpa_code, STRING, getLabel("Common.AlphaCode.label", "Common"), messageFrame)) {
					if (isValidFromToField(formObj.analysis_code1_from, formObj.analysis_code1_to, DOUBLE,getLabel("eMM.ItemAnalysisCode.label", "MM") , messageFrame)) {
						if (isValidFromToField(formObj.analysis_code2_from, formObj.analysis_code2_to, DOUBLE,getLabel("eMM.ItemAnalysisCode.label", "MM") , messageFrame)) {
							if (isValidFromToField(formObj.analysis_code3_from, formObj.analysis_code3_to, DOUBLE,getLabel("eMM.ItemAnalysisCode.label", "MM") , messageFrame)) {
						formObj.submit();
							}
						}
					}
				 }
				}
			}
		}
	}
}

