/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
1/2/2018		IN0066368			shazana									GHL-CRF-0503 split batch
---------------------------------------------------------------------------------------------------------
*/
var ordercolmns = "1";
var count = 1;
function query() {
	f_query_add_mod.location.href = "../../eST/jsp/BatchSearchFrameForBarcode.jsp";
}
function reset() {
	f_query_add_mod.location.reload();
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
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	    obj.focus();
		if(document.forms[0].item_code_to != undefined)
		document.forms[0].item_code_to.value = returnedValues[0];
	}
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
	dataValueArray[1] = document.forms[0].facility_id.value;
	dataTypeArray[1] = STRING;
	argumentArray[0] = document.forms[0].SQL_ST_STORE_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
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

function searchVals() {
	objform = parent.frameBatchSearchQueryCriteria.document.BatchSearchCriteria_Form;
	var item_code_from = "";
	var item_code_to = "";
	var store_code_from = "";
	var store_code_to = "";
	var manufacturer_code = "";
	var perod_of_expiry = "";
	var includeZeroStockBatches = "";
	var includeExpiredBatches = "";
	var includeSuspendedBatches = "";
	var searchFunction = "";
	var multipleSelect = "";
	var batch_id = "";
	var Trade_code = "";
	var barcode = "";
	var allow_zero_batches= "";//Added for GHL-CRF-0503
	item_code_from = objform.item_code_from.value;
	item_code_to = objform.item_code_to.value;
	store_code_from = objform.store_code_from.value;
	store_code_to = objform.store_code_to.value;
	manufacturer_code = objform.manufacturer_code.value;
	period_of_expiry = objform.period_of_expiry.value;
	searchFunction = objform.searchFunction.value;
	multipleSelect = objform.multipleSelect.value;
	includeZeroStockBatches = objform.includeZeroStockBatches.checked ? "Y" : "N";
	includeExpiredBatches = objform.includeExpiredBatches.checked ? "Y" : "N";
	includeSuspendedBatches = objform.includeSuspendedBatches.checked ? "Y" : "N";
	batch_id = objform.batch_id.value;
	Trade_code = objform.Trade_code.value;
	p_list_all_trades_yn = objform.p_list_all_trades_yn.value;
	barcode = objform.barcode.value;
	allow_zero_batches=objform.allow_zero_batches.value;//Added against GHL-CRF-0503
	
	var item_class_from = objform.item_class_from.value;
	var item_class_to = objform.item_class_to.value;
	var drug_type = "%";
	if(objform.drug_type!=undefined){
		drug_type=objform.drug_type.value;
	}
	var errorPage = "../../eCommon/jsp/error.jsp";
	if(parent.parent.messageFrame!=null){
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?";
	}
	if (isValidFromToField(objform.item_code_from, objform.item_code_to, STRING, getLabel("Common.item.label", "Common"), parent.parent.frames[2])){
	if (isValidFromToField(objform.item_class_from, objform.item_class_to, STRING, getLabel("Common.ItemClass.label", "Common"), parent.parent.frames[2])){
	if (isValidFromToField(objform.store_code_from, objform.store_code_to, STRING, getLabel("Common.Store.label", "Common"), parent.parent.frames[2])){
			//Added against GHL-CRF-0446 starts
			var src_batch_id = objform.src_batch_id.value;//alert("@99"+src_batch_id);
			var src_bin_location_code = objform.src_bin_location_code.value;//alert("@100"+src_bin_location_code);
			var src_expiry_date = objform.src_expiry_date.value;//alert("@101"+src_expiry_date);
			//var temp_jsp = "../../eST/jsp/BatchSearchValidateForBarcode.jsp?function_type=1&multipleSelect=" + multipleSelect + "&searchFunction=" + searchFunction + "&includeSuspendedBatches=" + includeSuspendedBatches + "&includeExpiredBatches=" + includeExpiredBatches + "&includeZeroStockBatches=" + includeZeroStockBatches + "&item_code_from=" + item_code_from + "&item_code_to=" + item_code_to + "&store_code_from=" + store_code_from + "&store_code_to=" + store_code_to + "&manufacturer_code=" + manufacturer_code + "&period_of_expiry=" + period_of_expiry + "&batch_id=" + batch_id + "&ordercolmns=" + ordercolmns + "&Trade_code=" + Trade_code + "&doc_type_code=" + objform.doc_type_code.value + "&doc_no=" + objform.doc_no.value + "&trn_type=" + objform.trn_type.value+"&item_class_from="+item_class_from+"&item_class_to="+item_class_to+"&barcode="+barcode+"&drug_type="+drug_type;
			var temp_jsp = "../../eST/jsp/BatchSearchValidateForBarcode.jsp?function_type=1&multipleSelect=" + multipleSelect + "&searcFunction=" + searchFunction + "&includeSuspendedBatches=" + includeSuspendedBatches + "&includeExpiredBatches=" + includeExpiredBatches + "&includeZeroStockBatches=" + includeZeroStockBatches + "&item_code_from=" + item_code_from + "&item_code_to=" + item_code_to + "&store_code_from=" + store_code_from + "&store_code_to=" + store_code_to + "&manufacturer_code=" + manufacturer_code + "&period_of_expiry=" + period_of_expiry + "&batch_id=" + batch_id + "&ordercolmns=" + ordercolmns + "&Trade_code=" + Trade_code + "&doc_type_code=" + objform.doc_type_code.value + "&doc_no=" + objform.doc_no.value + "&trn_type=" + objform.trn_type.value+"&item_class_from="+item_class_from+"&item_class_to="+item_class_to+"&barcode="+barcode+ "&src_batch_id=" + src_batch_id + "&src_bin_location_code=" + src_bin_location_code + "&src_expiry_date=" + src_expiry_date + "&allow_zero_batches=" + allow_zero_batches + "&drug_type=" + drug_type;    //Added allow_zero_batches for GHL-CRF-0503
			//Added against GHL-CRF-0446 ends
		var xmlStr = "<root><SEARCH /></root>";
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", temp_jsp, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;

		parent.frameBatchSearchQueryResult.document.location.href = "../../eST/jsp/BatchSearchQueryResultForBarcode.jsp?p_list_all_trades_yn=" + p_list_all_trades_yn;
	}	
	}
	}	
}
function activeLink() {
	formObjCriteria = parent.frameBatchSearchQueryCriteria.document.BatchSearchCriteria_Form;
	formObjResult = parent.frameBatchSearchQueryResult.document.BatchsearchForm;
	if (formObjResult != null || formObjResult != undefined) {
		if ((parseInt(formObjResult.start) != undefined) && parseInt(formObjResult.start.value) != 0) {
			parent.frameBatchSearchQueryCriteria.BatchSearchCriteria_Form.previous.disabled = false;
		} else {
			parent.frameBatchSearchQueryCriteria.BatchSearchCriteria_Form.previous.disabled = true;
		}
		if ((parseInt(formObjResult.start) != undefined) && !((parseInt(formObjResult.start.value) + parseInt(formObjResult.displaySize.value)) >= formObjResult.totalRecords.value)) {
			parent.frameBatchSearchQueryCriteria.BatchSearchCriteria_Form.next.disabled = false;
		} else {
			parent.frameBatchSearchQueryCriteria.BatchSearchCriteria_Form.next.disabled = true;
		}
	}
}
function goNext() {
	formObj = parent.frameBatchSearchQueryResult.document.BatchsearchForm;
	if((parseInt(formObj.start) != undefined) || (parseInt(formObj.end) != undefined))
	{
	start = parseInt(formObj.start.value) + parseInt(formObj.displaySize.value);
	end = parseInt(formObj.end.value) + parseInt(formObj.displaySize.value);
	parent.frameBatchSearchQueryResult.document.location.href = "../../eST/jsp/BatchSearchQueryResultForBarcode.jsp?from=" + start + "&to=" + end;
}
}
function goPrev() {
	formObj = parent.frameBatchSearchQueryResult.document.BatchsearchForm;
	if((parseInt(formObj.start) != undefined) || (parseInt(formObj.end) != undefined))
	{
	start = parseInt(formObj.start.value) - parseInt(formObj.displaySize.value);
	end = parseInt(formObj.end.value) - parseInt(formObj.displaySize.value);
	parent.frameBatchSearchQueryResult.location.href = "../../eST/jsp/BatchSearchQueryResultForBarcode.jsp?from=" + start + "&to=" + end;
}
}
function ordercols(obj) {
	ordercolmns = obj;
	formObj = parent.frameBatchSearchQueryResult.BatchsearchForm;
	start = formObj.start.value;
	end = formObj.end.value;
	totalRecords = formObj.totalRecords.value;
	if (parseInt(end) > totalRecords) {
		end = totalRecords;
	}
	var temp_jsp;
	var xmlStr = "<root><SEARCH /></root>";
	temp_jsp = "../../eST/jsp/BatchSearchValidateForBarcode.jsp?function_type=2&from=" + start + "&to=" + end + "&ordercolmns=" + ordercolmns;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", temp_jsp, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	parent.qryResult.location.href = "../../eST/jsp/BatchSearchQueryResultForBarcode.jsp?from=" + start + "&to=" + end;
}
var maxAllowed = 0;
var totalChecked = 0;
function checkAllowed(obj) {
	maxAllowed = parent.frameBatchSearchQueryResult.document.BatchsearchForm.maxAllowed.value;
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
	var count = 0;
	var j = 0;
	var formObj = parent.frameBatchSearchQueryResult.document.BatchsearchForm;
	var returnvals = "";
	if ((formObj != null) && (formObj != undefined)) {
		count = formObj.totalRecords.value;
	}
	var index = "";
	var noOfCheckedRecords = "";
	for (var i = 0; i < count; i++) {
		if (formObj.elements("check" + i).checked) {
			var expiry_date = "";
			var locale = formObj.locale.value;
			expiry_date = formObj.elements("expiry_date" + i).value;
			expiry_date = convertDate(expiry_date, "DMY", locale, "en");
			//returnvals += formObj.elements("batch_id" + i).value + "`" + formObj.elements("item_code" + i).value + "`" + formObj.elements("item_desc" + i).value + "`" + formObj.elements("store_code" + i).value + "`" + formObj.elements("store_desc" + i).value + "`" + formObj.elements("trade_id_applicable_yn" + i).value + "`" + expiry_date + "`" + formObj.elements("bin_location_code" + i).value + "`" + formObj.elements("bin_desc" + i).value + "`" + formObj.elements("trade_id" + i).value + "`" + formObj.elements("trade_name" + i).value + "`" + formObj.elements("qty_on_hand" + i).value + "`" + formObj.elements("nod" + i).value + "`" + formObj.elements("manufacturer_id" + i).value + "`" + formObj.elements("manufacturer_name" + i).value + "`" + formObj.elements("avail_qty" + i).value + "`" + formObj.elements("expiry_yn" + i).value + "~";
			returnvals += formObj.elements("batch_id" + i).value + "`" + formObj.elements("item_code" + i).value + "`" + formObj.elements("item_desc" + i).value + "`" + formObj.elements("store_code" + i).value + "`" + formObj.elements("store_desc" + i).value + "`" + formObj.elements("trade_id_applicable_yn" + i).value + "`" + expiry_date + "`" + formObj.elements("bin_location_code" + i).value + "`" + formObj.elements("bin_desc" + i).value + "`" + formObj.elements("trade_id" + i).value + "`" + formObj.elements("trade_name" + i).value + "`" + formObj.elements("qty_on_hand" + i).value + "`" + formObj.elements("nod" + i).value + "`" + formObj.elements("manufacturer_id" + i).value + "`" + formObj.elements("manufacturer_name" + i).value + "`" + formObj.elements("avail_qty" + i).value + "`" + formObj.elements("expiry_yn" + i).value+ "`" + formObj.elements("barcode_id" + i).value  + "~";//Added barcode_id against GHL-CRF-0446
			index += i + "!";
			noOfCheckedRecords++;
		}
	}
	if (returnvals != "") {
		returnvals = returnvals.substring(0, returnvals.length - 1);
		index = index.substring(0, index.length - 1);
		var temp_jsp = "../../eST/jsp/BatchSearchValidateForBarcode.jsp?function_type=4&index=" + index + "&noOfCheckedRecords=" + noOfCheckedRecords;
		var xmlStr = "<root><SEARCH /></root>";
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", temp_jsp, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;

		window.parent.parent.returnValue = returnvals;
		window.close();
	}else{
		alert("Atleast One Batch need to Selected.");	  
	}
	
	
}
async function showHistory1 (trObj, index,index1) {
	var trObj = eval("document.getElementById('tr_')" + index + "");
	var item_code = eval("document.BatchsearchForm.item_code" + index1 + ".value");
	var item_desc = eval("document.BatchsearchForm.item_desc" + index1 + ".value");
	var expiry_date = trObj.cells[1].innerText;
	var batch_id = trObj.cells[2].innerText;
	var trade_name = trObj.cells[3].innerText;
	var manufacturer_name = trObj.cells[4].innerText;
	var uom_desc = trObj.cells[6].innerText;

	retVal =await window.showModalDialog("../../eST/jsp/SuspendOrReinstateBatchHistory.jsp?function_id=" + parent.parent.function_id + "&item_code=" + escape(item_code) + "&batch_id=" + batch_id + "&expiry_date=" + expiry_date + "&trade_name=" + trade_name + "&item_desc=" + encodeURIComponent(item_desc,"UTF-8") + "&uom_desc=" + escape(uom_desc) + "&manufacturer_name=" + escape(manufacturer_name), "", "dialogHeight:30vh; dialogWidth:55vw; center:0; status: no; dialogLeft :75; dialogTop :250;");
}

async function showHistory(trObj, index) {
	var trObj = eval("document.getElementById('tr_')" + index + "");
	var item_code = eval("document.BatchsearchForm.item_code" + index + ".value");
	var item_desc = eval("document.BatchsearchForm.item_desc" + index + ".value");
	var expiry_date = trObj.cells[1].innerText;
	var batch_id = trObj.cells[2].innerText;
	var trade_name = trObj.cells[3].innerText;
	var manufacturer_name = trObj.cells[4].innerText;
	var uom_desc = trObj.cells[6].innerText;
	retVal = await window.showModalDialog("../../eST/jsp/SuspendOrReinstateBatchHistory.jsp?function_id=" + parent.parent.function_id + "&item_code=" + escape(item_code) + "&batch_id=" + batch_id + "&expiry_date=" + expiry_date + "&trade_name=" + trade_name + "&item_desc=" + escape(item_desc) + "&uom_desc=" + escape(uom_desc) + "&manufacturer_name=" + escape(manufacturer_name), "", "dialogHeight:30vh; dialogWidth:55vw; center:0; status: no; dialogLeft :75; dialogTop :250;");
}

function getTradeList()
{
 var objform = parent.frameBatchSearchQueryCriteria.document.BatchSearchCriteria_Form;
 var item_code_from = objform.item_code_from.value;
 var item_code_to = objform.item_code_to.value;

 if(item_code_to=="")
	item_code_to = item_code_from;

 var p_list_all_trades_yn = objform.p_list_all_trades_yn.value;

 var temp = "../../eST/jsp/BatchSearchValidateForBarcode.jsp?function_type=5&item_code_from="+escape(item_code_from)+"&item_code_to="+escape(item_code_to)+"&p_list_all_trades_yn="+p_list_all_trades_yn; 
 	var xmlStr = "<root><SEARCH /></root>";
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", temp, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	
}

async function searchItemClass(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	argumentArray[0] = document.getElementById("SQL_ST_ITEM_CLASS_LOOKUP_LANG").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.ItemClass.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}

async function searchTradeName(obj,item_code_from,item_code_to) {

	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray[0] = "language_id";
	dataValueArray[0]= localeName;
	dataTypeArray[0] = STRING;

	argumentArray[0] = "select code , description from (SELECT distinct nvl(a.trade_id,c.DFLT_TRADE_ID) code , nvl(b.short_name,c.DFLT_TRADE_ID) description FROM mm_trade_name_for_item a, am_trade_name_lang_vw b,mm_parameter c WHERE a.trade_id = b.trade_id AND LANGUAGE_ID LIKE ? AND b.eff_status = 'E' AND (item_code BETWEEN NVL ('"+item_code_from.value+"', '!') AND NVL ('"+item_code_to.value+"', '~'))) where  upper(code) LIKE  upper(?) AND upper(description)  LIKE  upper(?) ORDER BY 2";

	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value.toUpperCase();
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.TradeName.label", "common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[1];
		document.getElementById("Trade_code").value=returnedValues[0];
	}
	else{
		obj.value ="";
		document.getElementById("Trade_code").value="";
	}
}

function clearTradeid(){
	var trade_desc = document.getElementById("Trade_desc").value;
		if(trade_desc=="")
		document.getElementById("Trade_code").value="";
}
