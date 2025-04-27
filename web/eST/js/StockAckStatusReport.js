

var formObj = "";
function reset() {
	formObj = f_query_add_mod.document.StockAckStatusReportCriteria;
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
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
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


function run() {
	if (f_query_add_mod.document.StockAckStatusReportCriteria) {
		formObj = f_query_add_mod.document.StockAckStatusReportCriteria;
		
		//if (isValidFromToField(formObj.issuing_store, formObj.receiving_store, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)) {
			if (isValidFromToField(formObj.from_item_code, formObj.to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
							if (doDateCheck(formObj.from_acknowledge_date, formObj.to_acknowledge_date, messageFrame)) {
							formObj.from_acknowledge_date.value = convertDate(formObj.from_acknowledge_date.value, "DMY", formObj.p_language_id.value, "en");
							formObj.to_acknowledge_date.value = convertDate(formObj.to_acknowledge_date.value, "DMY", formObj.p_language_id.value, "en");
						}
				}
		//}
		
		var from_acknowledge_date = f_query_add_mod.document.StockAckStatusReportCriteria.from_acknowledge_date.value;
		if(from_acknowledge_date==""){
		alert(getMessage("ACK_FROM_DATE_NOT_BLANK", "ST"));
		f_query_add_mod.document.StockAckStatusReportCriteria.from_acknowledge_date.focus();
		return;
		}
		
		var issuing_store = f_query_add_mod.document.StockAckStatusReportCriteria.issuing_store.value;
		var receiving_store = f_query_add_mod.document.StockAckStatusReportCriteria.receiving_store.value;
	  if(issuing_store=="" && receiving_store == ""){
		alert(getMessage("ISS_STR_CANNOT_BLANK_REC_STR", "ST"));
		f_query_add_mod.document.StockAckStatusReportCriteria.issuing_store.focus();
		return;
		}  
			

		if (isValidFromToField(formObj.from_acknowledge_date, formObj.to_acknowledge_date, DATE, getLabel("Common.date.label", "Common"))) {
			if (isValidFromToField(formObj.from_item_code, formObj.to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    		    f_query_add_mod.document.forms[0].target="messageFrame"
				formObj.submit();
				}
						
		  }

		}
}

function isValidFromToField(fromObj, toObj, dataType, stLegend) {
	var bReturn = true;
	var stFromValue = fromObj.value;
	var stToValue = toObj.value;
	if ((!trimCheck(stFromValue)) || (!trimCheck(stToValue))) {
		return bReturn;
	}
	if (dataType == null) {
		dataType = STRING;
	}
	switch (dataType) {
	  case INT:
	  case LONG:
	  case FLOAT:
	  case DOUBLE:
		if (parseFloat(stFromValue) > parseFloat(stToValue)) {
			bReturn = false;
		}
		break;
	  case DATE:
		var arFromDate = stFromValue.split("/");
		var arToDate = stToValue.split("/");
		if (Date.parse("" + arFromDate[1] + "/" + arFromDate[0] + "/" + arFromDate[2] + "/") > Date.parse("" + arToDate[1] + "/" + arToDate[0] + "/" + arToDate[2] + "/")) {
			bReturn = false;
		}
		break;
	  default:
		if (stFromValue > stToValue) {
			bReturn = false;
		}
	}
	if ((!bReturn)) {
		var stMessage = getMessage("LESS_OR_EQUAL_VALIDATE", "ST");
		stMessage = stMessage.replace(/@/g, stLegend);
		alert(stMessage);
		toObj.focus();
		bReturn = false;
	}
		return bReturn;
}



