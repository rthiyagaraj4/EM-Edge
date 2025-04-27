
var function_id = "";
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
function reset() {
	f_query_add_mod.location.reload();
}
function run() {       
	if (f_query_add_mod.document.ReplacementGRNRTVStatisticReport) {
		formObj = f_query_add_mod.document.ReplacementGRNRTVStatisticReport;
		if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
			if (doDateCheck(formObj.p_fr_doc_date, formObj.p_to_doc_date, messageFrame)) {
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
				f_query_add_mod.document.forms[0].target="messageFrame"
				formObj.submit();
			}
		}
	}
}
async function searchCodeItem(obj) {
	//alert("report");
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
	//alert("ret1"+ret1);
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
function reportType() {
	if (document.ReplacementGRNRTVStatisticReport.p_report_type.value == "D") {
		document.ReplacementGRNRTVStatisticReport.p_report_id.value = "STBRPSTD";
	} else {
		document.ReplacementGRNRTVStatisticReport.p_report_id.value = "STBRPSTA";
	}
}
function doDateCheck(from, to, messageFrame) {
	if (from.value != undefined) {
		from = from.value;
	} else {
		from = from;
	}
	if (to.value != undefined) {
		to = to.value;
	} else {
		to = to;
	}
	var fromarray;
	var toarray;
	var fromdate = from;
	var todate = to;
	var arr = new Array(todate, fromdate);
	if (fromdate.length > 0 && todate.length > 0) {
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2], fromarray[1] - 1, fromarray[0]);
		var todt = new Date(toarray[2], toarray[1] - 1, toarray[0]);
		if (Date.parse(todt) < Date.parse(fromdt)) {
			var error = getMessage("REMARKS_MUST_GR_EQUAL", "common");
			error = error.replace("$", getLabel("Common.to.label", "Common"));
			//error=error.replace("#",getLabel("Common.from.label","Common"));
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + error;
			return false;
		} else {
			if (Date.parse(todt) >= Date.parse(fromdt)) {
				return true;
			}
		}
	}
	return true;
}

