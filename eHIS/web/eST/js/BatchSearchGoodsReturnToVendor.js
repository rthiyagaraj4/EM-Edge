
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
	objform = parent.frameBatchSearchGoodsReturnToVendorQueryCriteria.document.BatchSearchCriteria_Form;
	/*
	var fields = new Array ( objform.grn_doc_type_code,objform.grn_doc_no);
	var names =  new Array ( "GRN Doc Type","GRN Doc No");
	var obj=null;
	var errors ="";

	for( var i=0;i<fields.length; i++ ) 
	{
		if(trimCheck(fields[i].value)) 
			fields[i].value = trimString(fields[i].value);
		else
		{
			if(obj==null)
				obj=fields[i];
			errors = errors + "APP-000001 " + names[i] + " cannot be blank...";
			alert (errors);
			obj.focus();
			return;
		}
	}
*/
	
	//search_string=objform.search_string.value;
	var item_code = "";
	var store_code = "";
	var supp_code = "";
	var po_no = "";
	var grn_doc_type_code = "";
	var grn_doc_no = "";
	var searchFunction = "";
	var multipleSelect = "";
	item_code = objform.item_code.value;
	store_code = objform.store_code.value;
	supp_code = objform.supp_code.value;
	grn_doc_type_code = objform.grn_doc_type_code.value;
	grn_doc_no = objform.grn_doc_no.value;
	po_no = objform.po_no.value;
	searchFunction = objform.searchFunction.value;
	multipleSelect = objform.multipleSelect.value;
//	alert("calling validate page..");
	var temp_jsp = "../../eST/jsp/BatchSearchGoodsReturnToVendorValidate.jsp?function_type=1&multipleSelect=" + multipleSelect + "&searchFunction=" + searchFunction + "&item_code=" + item_code + "&store_code=" + store_code + "&grn_doc_type_code=" + grn_doc_type_code + "&grn_doc_no=" + grn_doc_no + "&po_no=" + po_no + "&supp_code=" + supp_code + "&ordercolmns=" + ordercolmns + "&doc_type_code=" + objform.doc_type_code.value + "&doc_no=" + objform.doc_no.value + "&trn_type=" + objform.trn_type.value;
	var xmlStr = "<root><SEARCH /></root>";
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", temp_jsp, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;

	//alert(responseText);
	parent.frameBatchSearchGoodsReturnToVendorQueryResult.document.location.href = "../../eST/jsp/BatchSearchGoodsReturnToVendorQueryResult.jsp?item_code=" + item_code;
}
function goNext() {
	formObj = parent.frameBatchSearchGoodsReturnToVendorQueryResult.document.BatchsearchForm;
	start = parseInt(formObj.start.value) + parseInt(formObj.displaySize.value);
	end = parseInt(formObj.end.value) + parseInt(formObj.displaySize.value);
	parent.frameBatchSearchGoodsReturnToVendorQueryResult.location.href = "../../eST/jsp/BatchSearchGoodsReturnToVendorQueryResult.jsp?from=" + start + "&to=" + end;
}
function goPrev() {
	formObj = parent.frameBatchSearchGoodsReturnToVendorQueryResult.document.BatchsearchForm;
	start = parseInt(formObj.start.value) - parseInt(formObj.displaySize.value);
	end = parseInt(formObj.end.value) - parseInt(formObj.displaySize.value);
	parent.frameBatchSearchGoodsReturnToVendorQueryResult.location.href = "../../eST/jsp/BatchSearchGoodsReturnToVendorQueryResult.jsp?from=" + start + "&to=" + end;
}
function CheckForSpecialChars(event) {
	var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) {
		return false;
	}  // Not a valid key
	if ((event.keyCode >= 97) && (event.keyCode <= 122)) {
		return (event.keyCode -= 32);
	}
	return true;
}
function ordercols(obj) {
	ordercolmns = obj;
	formObj = parent.frameBatchSearchGoodsReturnToVendorQueryResult.BatchsearchForm;
	start = formObj.start.value;
	end = formObj.end.value;
	totalRecords = formObj.totalRecords.value;
	if (parseInt(end) > totalRecords) {
		end = totalRecords;
	}
	var temp_jsp;
	var xmlStr = "<root><SEARCH /></root>";
	temp_jsp = "../../eST/jsp/BatchSearchGoodsReturnToVendorValidate.jsp?function_type=2&from=" + start + "&to=" + end + "&ordercolmns=" + ordercolmns;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", temp_jsp, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	parent.qryResult.location.href = "../../eST/jsp/BatchSearchGoodsReturnToVendorQueryResult.jsp?from=" + start + "&to=" + end;
}
var maxAllowed = 0;
var totalChecked = 0;
var doc_key = null;
function checkAllowed(obj, doctypedocno) {
	maxAllowed = parent.frameBatchSearchGoodsReturnToVendorQueryResult.document.BatchsearchForm.maxAllowed.value;
	//alert(maxAllowed);
	if (obj.checked) {
		if ((parent.frameBatchSearchGoodsReturnToVendorQueryCriteria.doc_key != null) && (parent.frameBatchSearchGoodsReturnToVendorQueryCriteria.doc_key != doctypedocno)) {
			alert(getMessage("NO_MULTI_GRN_FOR_ITEM", "ST"));
			return false;
		}
		parent.frameBatchSearchGoodsReturnToVendorQueryCriteria.doc_key = doctypedocno;
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
		if (totalChecked == 0) {
			parent.frameBatchSearchGoodsReturnToVendorQueryCriteria.doc_key = null;
		}
		return true;
	}
}
function returnVals() {
	var j = 0;
	var formObj =parent.frameBatchSearchGoodsReturnToVendorQueryResult.document.BatchsearchForm;
	var returnvals = "";
	var count = 0;
	if(formObj.totalRecords)
		count = formObj.totalRecords.value;
	//alert(count);
	var index = "";
	var noOfCheckedRecords = "";
	for (var i = 0; i < count; i++) {
		if (formObj.elements["check" + i].checked) {
			returnvals += formObj.elements["batch_id" + i].value + "`" + formObj.elements["item_code" + i].value + "`" + formObj.elements["item_desc" + i].value + "`" + formObj.elements["store_code" + i].value + "`" + formObj.elements["store_desc" + i].value + "`" + "`" + formObj.elements["expiry_date" + i].value + "`" + formObj.elements["bin_location_code" + i].value + "`" + formObj.elements["bin_desc" + i].value + "`" + formObj.elements["trade_id" + i].value + "`" + formObj.elements["trade_name" + i].value + "`" + formObj.elements["qty_on_hand" + i].value + "`" + formObj.elements["nod" + i].value + "`" + formObj.elements["avail_qty" + i].value + "`" + formObj.elements["grn_unit_cost_in_pur_uom" + i].value + "`" + formObj.elements["grn_doc_srl_no" + i].value + "`" + formObj.elements["grn_doc_date" + i].value + "`" + formObj.elements["grn_doc_no" + i].value + "`" + formObj.elements["grn_doc_type_code" + i].value + "~";
			index += i + "!";
			noOfCheckedRecords++;
		}
	}

    //alert(noOfCheckedRecords);
	if (returnvals != "") {
		returnvals = returnvals.substring(0, returnvals.length - 1);
		index = index.substring(0, index.length - 1);
		var temp_jsp = "../../eST/jsp/BatchSearchGoodsReturnToVendorValidate.jsp?function_type=4&index=" + index + "&noOfCheckedRecords=" + noOfCheckedRecords;
		var xmlStr = "<root><SEARCH /></root>";
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", temp_jsp, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
	//	alert(responseText);
		eval(responseText);
	}
	//window.parent.parent.returnValue = returnvals;
	//alert(returnvals);
	//window.close();
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = returnvals;
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close(); 
}

