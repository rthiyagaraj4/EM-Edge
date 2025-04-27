
function reset() {
	formObj = f_query_add_mod.document.formCancelCountSheetReportCriteria;
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
	var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		if(arr[1]==undefined)
 		{
	 		arr[0]="";	
	 		arr[1]="";	
 		}
	else{
		obj.value=arr[0];
	}
	/*if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	} */
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
	 	arr=ret1.split(",");
		if(arr[1]==undefined)
 		{
	 		arr[0]="";	
	 		arr[1]="";	
 		}
	else{
		obj.value=arr[0];
	}
	/*if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	} */
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
	 	arr=ret1.split(",");
		if(arr[1]==undefined)
 		{
	 		arr[0]="";	
	 		arr[1]="";	
 		}
	else{
		obj.value=arr[0];
	}
	/*if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	} */
}
async function searchUserCode(target) {
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
		retVal = await CommonLookup(getLabel("Common.user.label", "Common"), argumentArray);
		var ret1=unescape(retVal);
		 var arr=ret1.split(",");
			if(arr[1]==undefined) 
			{
				arr[0]="";	
				arr[1]="";	
			}
		if(retVal != null && retVal != "")
		{
		  target.value=arr[0];
		}
		/*var ret1=unescape(retVal);
	 	var arr=ret1.split(",");
	 	console.log(arr);
		if(arr[1]==undefined)
 		{
	 		arr[0]="";	
	 		arr[1]="";	
 		}
	} else {
		retVal = "";
		target.value = arr[0];
	}*/
	/*if (retVal != null && retVal != "") {
		target.value = arr[0];
//		htarget.value=retVal[0];
	} */
}
}
async function run() {
	formObj = f_query_add_mod.document.formCancelCountSheetReportCriteria;
	if (formObj) {
		if (isValidFromToField(formObj.p_fm_store_code, formObj.p_to_store_code, STRING,getLabel("Common.StoreCode.label", "Common"), messageFrame)) {
			if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
				if (isValidFromToField(formObj.p_fm_item_class_code, formObj.p_to_item_class_code, STRING, getLabel("Common.ItemClass.label", "Common"), messageFrame)) {
					if (isValidFromToField(formObj.p_fm_phyinv_id, formObj.p_to_phyinv_id, STRING, "Phyical Inventory ID", messageFrame)) {
						if (isValidFromToField(formObj.p_fm_cancelled_date, formObj.p_to_cancelled_date, STRING, "Cancelled Date", messageFrame)) {
							if (isValidFromToField(formObj.p_fm_user_id, formObj.p_to_user_id, STRING, getLabel("Common.user.label", "Common"), messageFrame)) {
								f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
								f_query_add_mod.document.forms[0].target="messageFrame";
								formObj.submit();
							}
						}
					}
				}
			}
		}
	}
}

