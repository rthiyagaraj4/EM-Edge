 
var ordercolmns = "1";
var count = 1;
function query() {
	f_query_add_mod.location.href = "../../eST/jsp/BatchSearchFrame.jsp";
}
function searchVals() {
	objform = parent.frameSalesReturnBatchSearchQueryCriteria.document.BatchSearchCriteria_Form;
	var sal_trn_type = objform.sal_trn_type.value;
	var patient_id = objform.patient_id.value;
	var encounter_id = objform.encounter_id.value;
	var item_code_from = "";
	var store_code = "";
	item_code_from = objform.item_code_from.value;
	store_code = objform.store_code.value;
	var searchFunction = "";
	var multipleSelect = "";
	searchFunction = objform.searchFunction.value;
	multipleSelect = objform.multipleSelect.value;
	var temp_jsp = "../../eST/jsp/SalesReturnBatchSearchValidate.jsp?function_type=1&multipleSelect=" + multipleSelect + "&searchFunction=" + searchFunction + "&item_code_from=" + item_code_from + "&store_code=" + store_code + "&sal_trn_type=" + sal_trn_type + "&patient_id=" + patient_id + "&encounter_id=" + encounter_id + "&ordercolmns=" + ordercolmns + "&doc_type_code=" + objform.doc_type_code.value + "&doc_no=" + objform.doc_no.value + "&trn_type=" + objform.trn_type.value;
	var xmlStr = "<root><SEARCH /></root>";
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", temp_jsp, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	parent.frameSalesReturnBatchSearchQueryResult.document.location.href = "../../eST/jsp/SalesReturnBatchSearchQueryResult.jsp?";
}
function goNext() {
	formObj = parent.frameSalesReturnBatchSearchQueryResult.document.BatchsearchForm;
	start = parseInt(formObj.start.value) + parseInt(formObj.displaySize.value);
	end = parseInt(formObj.end.value) + parseInt(formObj.displaySize.value);
	parent.frameSalesReturnBatchSearchQueryResult.location.href = "../../eST/jsp/SalesReturnBatchSearchQueryResult.jsp?from=" + start + "&to=" + end;
}
function goPrev() {
	formObj = parent.frameSalesReturnBatchSearchQueryResult.document.BatchsearchForm;
	start = parseInt(formObj.start.value) - parseInt(formObj.displaySize.value);
	end = parseInt(formObj.end.value) - parseInt(formObj.displaySize.value);
	parent.frameSalesReturnBatchSearchQueryResult.location.href = "../../eST/jsp/SalesReturnBatchSearchQueryResult.jsp?from=" + start + "&to=" + end;
}
function ordercols(obj) {
	ordercolmns = obj;
	formObj = parent.frameSalesReturnBatchSearchQueryResult.BatchsearchForm;
	start = formObj.start.value;
	end = formObj.end.value;
	totalRecords = formObj.totalRecords.value;
	if (parseInt(end) > totalRecords) {
		end = totalRecords;
	}
	var temp_jsp;
	var xmlStr = "<root><SEARCH /></root>";
	temp_jsp = "../../eST/jsp/SalesReturnBatchSearchValidate.jsp?function_type=2&from=" + start + "&to=" + end + "&ordercolmns=" + ordercolmns;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", temp_jsp, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	parent.qryResult.location.href = "../../eST/jsp/SalesReturnBatchSearchQueryResult.jsp?from=" + start + "&to=" + end;
}
var maxAllowed = 0;
var totalChecked = 0;
function checkAllowed(obj) {
	maxAllowed = parent.frameSalesReturnBatchSearchQueryResult.document.BatchsearchForm.maxAllowed.value;
	if (obj.checked) {
		totalChecked++;
		if (totalChecked > maxAllowed) {
			alert(getMessage("ST_CANT_ENTER_MORE", "ST") + maxAllowed);
			totalChecked--;
			return false;
		} else {
			return true;
		}
	} else {
		totalChecked--;
		return true;
	}
}
function returnVals() {
	var j = 0;
	var formObj = parent.frameSalesReturnBatchSearchQueryResult.document.BatchsearchForm;
	var returnvals = "";
	var count = formObj.totalRecords.value;
	var index = "";
	var noOfCheckedRecords = "";
	for (var i = 0; i < count; i++) {
		if (formObj.elements("check" + i).checked) {
			returnvals += formObj.elements("batch_id" + i).value + "`" + formObj.elements("item_code" + i).value + "`" + formObj.elements("item_desc" + i).value + "`" + formObj.elements("store_code" + i).value + "`" + formObj.elements("store_desc" + i).value + "`" + "`" + formObj.elements("expiry_date" + i).value + "`" + formObj.elements("bin_location_code" + i).value + "`" + formObj.elements("bin_desc" + i).value + "`" + formObj.elements("trade_id" + i).value + "`" + formObj.elements("trade_name" + i).value + "`" + formObj.elements("qty_on_hand" + i).value + "`" + formObj.elements("nod" + i).value + "`" + formObj.elements("avail_qty" + i).value + "`" + formObj.elements("sal_doc_srl_no" + i).value + "`" + formObj.elements("sal_doc_date" + i).value + "`" + formObj.elements("sal_doc_no" + i).value + "`" + formObj.elements("sal_doc_type_code" + i).value + "~";
			index += i + "!";
			noOfCheckedRecords++;
		}
	}
	if (returnvals != "") {
		returnvals = returnvals.substring(0, returnvals.length - 1);
		index = index.substring(0, index.length - 1);
		var temp_jsp = "../../eST/jsp/SalesReturnBatchSearchValidate.jsp?function_type=4&index=" + index + "&noOfCheckedRecords=" + noOfCheckedRecords;
		var xmlStr = "<root><SEARCH /></root>";
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", temp_jsp, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
	}
	//window.parent.parent.returnValue = returnvals;
	//window.close();
	const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();
}

