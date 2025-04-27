
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
var formObj = "";
function reset() {
	f_query_add_mod.location.reload();
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
	var arr=ret1.split(",");
	if(arr[1]==undefined) 
	{
		arr[0]="";	
		arr[1]="";	
	}
	if(returnedValues != null && returnedValues != "")
	{
	    obj.value=arr[0];
	}
}
function run() {
	formObj = f_query_add_mod.document.formStockHoldingAnalysis;
	if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
		if (isValidFromToField(formObj.p_fm_batch_id, formObj.p_to_batch_id, STRING, getLabel("Common.BatchID.label", "Common"), messageFrame)) {
			if (isValidFromToField(formObj.dt_from, formObj.dt_to, DATE, getLabel("Common.expiryDate.label", "Common"), messageFrame)) {
			formObj.action="../../eCommon/jsp/report_options.jsp";

    		formObj.target="messageFrame";
				formObj.submit();
			}
		}
	}
}

