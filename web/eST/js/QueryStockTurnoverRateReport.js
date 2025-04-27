
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
var formObj = "";
var flag = false;
var flag2 = true;
var flag3 = true;
var flag4 = true;
var flag5 = true;
function reset() {
	formObj = f_query_add_mod.document.formQueryStockTurnoverRate;
	formObj.reset();
}
function numbervalidation() {
	if ((event.keyCode >= 48) && (event.keyCode <= 57)) {
		return true;
	} else {
		event.keyCode = 0;
	}
}
function fromname() {
	alert(document.formQueryStockTurnoverRate.p_facility_id.value);
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
//	argumentArray[0] = "test";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
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
	var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) {
		return false;
	}  // Not a valid key
	//if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		//return (event.keyCode -= 32);
	return true;
}
function run() {
	formObj = f_query_add_mod.document.formQueryStockTurnoverRate;
	if (f_query_add_mod.document.formQueryStockTurnoverRate) {
		if (isValidFromToField(formObj.p_fm_year, formObj.p_to_year, STRING, getLabel("Common.year_fs.label", "Common"), messageFrame)) {
			if (isValidFromToField(formName.p_fm_item_code, formName.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
				if (isValidFromToField(formName.p_fm_item_class, formName.p_to_item_class, STRING, getLabel("Common.ItemClass.label", "Common"), messageFrame)) {
					if (isValidFromToField(formName.p_fr_alp_code, formName.p_to_alp_code, STRING,getLabel("Common.AlphaCode.label", "Common"), messageFrame)) {
						f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
						f_query_add_mod.document.forms[0].target="messageFrame"
						formObj.submit();
					}
				}
			}
		}
	}
}

