function reset() {
	formObj = f_query_add_mod.document.formABCAnalysisReportCriteria;
	formObj.p_range_low_a.disabled = false;
	formObj.p_range_high_a.disabled = false;
	formObj.p_range_low_b.disabled = false;
	formObj.p_range_high_b.disabled = false;
	formObj.p_range_low_c.disabled = false;
	formObj.p_range_high_c.disabled = false; 
	formObj.reset(); 
}
async function searchCodeItem(obj) {
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
	returnedValues = await CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		obj.value = arr[0];
	}
}
async function searchCodeItemClass(obj) {
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
	returnedValues = await CommonLookup(getLabel("Common.ItemClass.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		obj.value = arr[0];
	}
}
function toggleCutOffRange(obj) {
	var formObj = document.formABCAnalysisReportCriteria;
	formObj.p_range_low_a.disabled = (obj.value == "");
	formObj.p_range_high_a.disabled = (obj.value == "");
	formObj.p_range_low_b.disabled = (obj.value == "");
	formObj.p_range_high_b.disabled = (obj.value == "");
	formObj.p_range_low_c.disabled = (obj.value == "");
	formObj.p_range_high_c.disabled = (obj.value == "");
	if (obj.value == "") {
		formObj.p_range_low_a.value = "";
		formObj.p_range_high_a.value = "";
		formObj.p_range_low_b.value = "";
		formObj.p_range_high_b.value = "";
		formObj.p_range_low_c.value = "";
		formObj.p_range_high_c.value = "";
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
function run() {
	formObj = f_query_add_mod.document.formABCAnalysisReportCriteria;
	if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
		if (isValidFromToField(formObj.p_fm_item_class_code, formObj.p_to_item_class_code, STRING, getLabel("Common.ItemClass.label", "Common"), messageFrame)) {
			if (isValidFromToField(formObj.p_fm_alpha_code, formObj.p_to_alpha_code, STRING, getLabel("Common.AlphaCode.label", "Common"), messageFrame)) {
				if (isValidFromToField(formObj.p_range_low_a, formObj.p_range_high_a, INT, "Cutoff Range for A", messageFrame)) {
					if (isValidFromToField(formObj.p_range_low_b, formObj.p_range_high_b, INT, "Cutoff Range for B", messageFrame)) {
						if (isValidFromToField(formObj.p_range_low_c, formObj.p_range_high_c, INT, "Cutoff Range for C", messageFrame)) {
							
							formObj.submit();
						}
					}
				}
			}
		}
	}
}

//Added for ML-MMOH-CRF-1884
async function searchCodeStore(obj) {
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
	argumentArray[5] = obj.value.toUpperCase();
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		obj.value = arr[0];
	}
}
//END for ML-MMOH-CRF-1884
