
function reset() {
	formObj = f_query_add_mod.document.formExpiryAnalysisCriteria;
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
	
	var ret1=unescape(returnedValues);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = arr[0];
	}
}
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
	
	var ret1=unescape(returnedValues);
		 	var arr=ret1.split(","); 
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	
	if ((returnedValues != null) && (returnedValues != "")) {
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
	
		var ret1=unescape(returnedValues);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = arr[0];
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
	formObj = f_query_add_mod.document.formExpiryAnalysisCriteria;
	/*if (formObj.p_fm_slot_1_1.value != "") {
		formObj.p_fm_slot_1.value = formObj.p_fm_slot_1_1.value;
	}
	if (formObj.p_fm_slot_2_1.value != "") {
		formObj.p_fm_slot_2.value = formObj.p_fm_slot_2_1.value;
	}
	if (formObj.p_fm_slot_3_1.value != "") {
		formObj.p_fm_slot_3.value = formObj.p_fm_slot_3_1.value;
	}
	if (formObj.p_fm_slot_4_1.value != "") {
		formObj.p_fm_slot_4.value = formObj.p_fm_slot_4_1.value;
	}
	if (formObj.p_to_slot_1_1.value != "") {
		formObj.p_to_slot_1.value = formObj.p_to_slot_1_1.value;
	}
	if (formObj.p_to_slot_2_1.value != "") {
		formObj.p_to_slot_2.value = formObj.p_to_slot_2_1.value;
	}
	if (formObj.p_to_slot_3_1.value != "") {
		formObj.p_to_slot_3.value = formObj.p_to_slot_3_1.value;
	}
	if (formObj.p_to_slot_4_1.value != "") {
		formObj.p_to_slot_4.value = formObj.p_to_slot_4_1.value;
	}*/
	if (isValidFromToField(formObj.p_fm_store_code, formObj.p_to_store_code, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)) {
		if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
			if (isValidFromToField(formObj.p_fm_item_class_code, formObj.p_to_item_class_code, STRING, getLabel("Common.ItemClass.label", "Common"), messageFrame)) {
				if (isValidFromToField(formObj.p_fm_alpha_code, formObj.p_to_alpha_code, STRING,getLabel("Common.AlphaCode.label", "Common"), messageFrame)) {
					formObj.p_fm_slot_1_1.value = convertDate(formObj.p_fm_slot_1_1_a.value, "DMY", localeName);
				}
			}
		}
	}
		var fields = new Array(formObj.p_fm_slot_1_1_a, formObj.p_to_slot_1_1_a);
	var names = new Array("From Slot 1", "To Slot 1");
	var errorPage = "../../eCommon/jsp/error.jsp";
	var blankObj = null;
	blankObject = checkSTFields(fields, names, messageFrame, errorPage);
	if (blankObject == true) {
	formObj.p_fm_slot_1.value = convertDate(formObj.p_fm_slot_1_1_a.value, "DMY", localeName);
	formObj.p_fm_slot_2.value = convertDate(formObj.p_fm_slot_2_1_a.value, "DMY", localeName);
	formObj.p_fm_slot_3.value = convertDate(formObj.p_fm_slot_3_1_a.value, "DMY", localeName);
	formObj.p_fm_slot_4.value = convertDate(formObj.p_fm_slot_4_1_a.value, "DMY", localeName);
	formObj.p_to_slot_1.value = convertDate(formObj.p_to_slot_1_1_a.value, "DMY", localeName);
	formObj.p_to_slot_2.value = convertDate(formObj.p_to_slot_2_1_a.value, "DMY", localeName);
	formObj.p_to_slot_3.value = convertDate(formObj.p_to_slot_3_1_a.value, "DMY", localeName);
	formObj.p_to_slot_4.value = convertDate(formObj.p_to_slot_4_1_a.value, "DMY", localeName);
	f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    f_query_add_mod.document.forms[0].target="messageFrame";
		formObj.submit();
	}
	
}

