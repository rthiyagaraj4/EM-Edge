
var ordercolmns = "1";
var count = 1;
function query() {
	f_query_add_mod.location.href = "../../eST/jsp/BatchSearchFrame.jsp";
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
	dataNameArray[0] = "facility_id";
	dataValueArray[0] = document.forms[0].facility_id.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] = document.forms[0].SQL_ST_STORE_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
//		objCode.value = returnedValues[1];
//		document.getElementById("td_storedesc").innerText=returnedValues[1]
	}
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
	argumentArray[0] = document.forms[0].SQL_ST_ITEM_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
function searchVals() {
	//alert(parent.frames[0].document.forms[0].name);
	objform = parent.frameBatchSearchIssueReturnQueryCriteria.document.BatchSearchCriteria_Form;
	//search_string=objform.search_string.value;
	var item_code_from = "";
	var store_code_from = "";
	var store_code_to = "";
	var searchFunction = "";
	var multipleSelect = "";
	var issue_doc_no = "";
	item_code_from = objform.item_code_from.value;
	store_code_from = objform.store_code_from.value;
	store_code_to = objform.store_code_to.value;
	searchFunction = objform.searchFunction.value;
	multipleSelect = objform.multipleSelect.value;
	issue_doc_no = objform.issue_doc_no.value;
 
	var temp_jsp = "../../eST/jsp/BatchSearchIssueReturnValidate.jsp?function_type=1&multipleSelect=" + multipleSelect + "&searchFunction=" + searchFunction + "&item_code_from=" + item_code_from + "&store_code_from=" + store_code_from + "&store_code_to=" + store_code_to + "&ordercolmns=" + ordercolmns + "&issue_doc_no=" + issue_doc_no + "&doc_type_code=" + objform.doc_type_code.value + "&doc_no=" + objform.doc_no.value + "&trn_type=" + objform.trn_type.value+"&seq_no="+objform.seq_no.value;
	var xmlStr = "<root><SEARCH /></root>";
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", temp_jsp, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;

	//alert(responseText);
	parent.frameBatchSearchIssueReturnQueryResult.document.location.href = "../../eST/jsp/BatchSearchIssueReturnQueryResult.jsp?";
}
function goNext() {
	formObj = parent.frameBatchSearchIssueReturnQueryResult.document.BatchsearchForm;
	start = parseInt(formObj.start.value) + parseInt(formObj.displaySize.value);
	end = parseInt(formObj.end.value) + parseInt(formObj.displaySize.value);
	parent.frameBatchSearchIssueReturnQueryResult.location.href = "../../eST/jsp/BatchSearchIssueReturnQueryResult.jsp?from=" + start + "&to=" + end;
}
function goPrev() {
	formObj = parent.frameBatchSearchIssueReturnQueryResult.document.BatchsearchForm;
	start = parseInt(formObj.start.value) - parseInt(formObj.displaySize.value);
	end = parseInt(formObj.end.value) - parseInt(formObj.displaySize.value);
	parent.frameBatchSearchIssueReturnQueryResult.location.href = "../../eST/jsp/BatchSearchIssueReturnQueryResult.jsp?from=" + start + "&to=" + end;
}
function ordercols(obj) {
	ordercolmns = obj;
	formObj = parent.frameBatchSearchIssueReturnQueryResult.BatchsearchForm;
	start = formObj.start.value;
	end = formObj.end.value;
	totalRecords = formObj.totalRecords.value;
	if (parseInt(end) > totalRecords) {
		end = totalRecords;
	}
	var temp_jsp;
	var xmlStr = "<root><SEARCH /></root>";
	temp_jsp = "../../eST/jsp/BatchSearchIssueReturnValidate.jsp?function_type=2&from=" + start + "&to=" + end + "&ordercolmns=" + ordercolmns;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", temp_jsp, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	parent.qryResult.location.href = "../../eST/jsp/BatchSearchIssueReturnQueryResult.jsp?from=" + start + "&to=" + end;
}
var maxAllowed = 0;
var totalChecked = 0;
function checkAllowed(obj) {
	maxAllowed = parent.frameBatchSearchIssueReturnQueryResult.document.BatchsearchForm.maxAllowed.value;
	//alert(maxAllowed);
	if (obj.checked) {
		totalChecked++;
		//alert(totalChecked);
		if (totalChecked > maxAllowed) {
//			alert("Cannot enter more than "+maxAllowed);
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
	var formObj = parent.frameBatchSearchIssueReturnQueryResult.document.BatchsearchForm;
	var returnvals = "";
	var count = formObj.totalRecords.value;
	//=alert(count);
	var index = "";
	var noOfCheckedRecords = "";
	for (var i = 0; i < count; i++) {
		if (formObj.elements.namedItem("check" + i).checked) {
			returnvals += formObj.elements.namedItem("batch_id" + i).value + "`" + formObj.elements.namedItem("item_code" + i).value + "`" + formObj.elements.namedItem("item_desc" + i).value + "`" + formObj.elements.namedItem("store_code" + i).value + "`" + formObj.elements.namedItem("store_desc" + i).value + "`" + "`" + formObj.elements.namedItem("expiry_date" + i).value + "`" + formObj.elements.namedItem("bin_location_code" + i).value + "`" + formObj.elements.namedItem("bin_desc" + i).value + "`" + formObj.elements.namedItem("trade_id" + i).value + "`" + formObj.elements.namedItem("trade_name" + i).value + "`" + formObj.elements.namedItem("qty_on_hand" + i).value + "`" + formObj.elements.namedItem("nod" + i).value + "`" + formObj.elements.namedItem("avail_qty" + i).value + "`" + formObj.elements.namedItem("source_doc_type_code" + i).value + "`" + formObj.elements.namedItem("source_doc_no" + i).value + "`" + formObj.elements.namedItem("source_doc_srl_no" + i).value + "`" + formObj.elements.namedItem("source_doc_date" + i).value + formObj.elements.namedItem("source_seq_no" + i).value + "~";
			index += i + "!";
			noOfCheckedRecords++;
		}
	}

    //alert(noOfCheckedRecords);
	if (returnvals != "") {
		returnvals = returnvals.substring(0, returnvals.length - 1);
		index = index.substring(0, index.length - 1);
		var temp_jsp = "../../eST/jsp/BatchSearchIssueReturnValidate.jsp?function_type=4&index=" + index + "&noOfCheckedRecords=" + noOfCheckedRecords;
		var xmlStr = "<root><SEARCH /></root>";
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", temp_jsp, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		//alert(responseText);
	}
	//window.parent.parent.returnValue = returnvals;
	//alert(returnvals);
	//window.close();
	
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = returnvals;
	
	const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();
    
}

