/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
03/05/2017		IN:064126		Badmavathi B									Search criteria Item class not working
---------------------------------------------------------------------------------------------------------
*/
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
var formName = "";
var flag = false;
function reset() {
	frames[1].document.forms[0].reset();
	flag = false;
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
	/* if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	} */
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
async function searchAlphaCode(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	argumentArray[0] = document.getElementById("SQL_ST_ALPHA_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.AlphaCode.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
function run() {
	formName = parent.frames[2].frames[1].document.forms[0];
	if (formName.selectsummary.checked) {
		formName.P_SUMMARY.value = "D";
	}
	if (f_query_add_mod.document.formVarianceReportQueryCriteria) {  
		if (isValidFromToField(formName.p_fr_st_code, formName.p_to_st_code, STRING,getLabel("Common.StoreCode.label", "Common"), messageFrame)) {
			if (isValidFromToField(formName.p_fm_item_code, formName.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), "", messageFrame)) {
				//if (isValidFromToField(formName.p_fm_item_class, formName.p_to_item_class, STRING,getLabel("Common.ItemClass.label", "Common"), "", messageFrame))  Modified against IN:064126
				if (isValidFromToField(formName.p_fm_item_class_code, formName.p_to_item_class_code, STRING,getLabel("Common.ItemClass.label", "Common"), "", messageFrame)) {
		//	if(doDateCheck(formName.p_fr_Date, formName.p_to_Date,messageFrame))
				}
			}
		}
		flag = true;
	}
	var formObj = f_query_add_mod.document.forms[0];
	var fields = new Array(formObj.p_PHY_INV_ID);
	var names = new Array(getLabel("eST.PhyInventoryID.label", "ST"));
	var errorPage = "../../eCommon/jsp/error.jsp";
	var blankObj = null;
	blankObject = checkSTFields(fields, names, messageFrame, errorPage);
	if (blankObject == true) {
		if (flag) {
			formName.submit();
		}
	}
}
function assignValue(obj) {
	if (obj.checked == true) {
		obj.value = "Y";
	} else {
		obj.value = "N";
	}
}

