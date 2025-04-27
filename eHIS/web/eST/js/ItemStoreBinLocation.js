
var xmlDom;
var xmlHttp;
function assignBean(frmObject) {
	bean_id = frmObject.bean_id.value;
	bean_name = frmObject.bean_name.value;
	//xmlDom = new ActiveXObject("Microsoft.XMLDom");
	//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	var xmlDom = "";
	var xmlHttp = new XMLHttpRequest();
}
function create() {
	f_query_add_mod.location.href = "../../eST/jsp/ItemStoreBinLocationFrame.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
}
function displayDetail() {
	var errorPage = "../../eCommon/jsp/error.jsp";
	var fields = new Array(document.formItemStoreBinLocationHeader.store_code, document.formItemStoreBinLocationHeader.item_code);
	var names = new Array(getLabel("Common.Store.label", "Common"), getLabel("Common.item.label", "Common"));
	var blankObject = checkSTFields(fields, names, parent.parent.messageFrame, errorPage);
	if (blankObject == true) {
		document.formItemStoreBinLocationHeader.store_code.disabled = true;
		document.formItemStoreBinLocationHeader.item_desc.disabled = true;
		document.formItemStoreBinLocationHeader.item_search.disabled = true;
		document.formItemStoreBinLocationHeader.bin_location_criteria.disabled = true;
		document.formItemStoreBinLocationHeader.bin_location_search_string.disabled = true;
		document.formItemStoreBinLocationHeader.search.disabled = true;
		parent.parent.messageFrame.location.href = errorPage;
		
		parent.frameItemStoreBinLocationDetail.location.href = "../../eST/jsp/ItemStoreBinLocationDetail.jsp?store_code=" + document.formItemStoreBinLocationHeader.store_code.value + "&item_code=" + document.formItemStoreBinLocationHeader.item_code.value + "&bin_location_search_string=" + document.formItemStoreBinLocationHeader.bin_location_search_string.value + "&bin_location_criteria=" + document.formItemStoreBinLocationHeader.bin_location_criteria.value + "&mode=" + MODE_INSERT;
	
		
	} else {
		if (document.formItemStoreBinLocationHeader.item_code == blankObject) {
			document.formItemStoreBinLocationHeader.item_desc.focus();
		}
	}
}

function reset() {
	f_query_add_mod.location.reload();
}

function updateBean(formObj) {
	assignBean(formObj);
	xmlStr = getXMLString(formObj);
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "../../eST/jsp/ItemStoreBinLocationValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=1", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
}

	function formXMLString(start, end, totalRecord, formObj) {
		
		
		for (count = start; count < totalRecord; count++) {
	
		if (eval("formObj.add_bin_location_" + count) != null && eval("formObj.add_bin_location_" + count + ".checked")) {
			end++;
		}
		if ((eval("formObj.highlight_" + count + ".value")) == "DATAHIGHLIGHT") {
			if (eval("formObj.add_bin_location_" + count + ".checked")) {
				eval("formObj.db_action_" + count).value = "U";
				eval("formObj.eff_status_" + count).value = "Y";
			} else {
				eval("formObj.db_action_" + count).value = "U";
				eval("formObj.eff_status_" + count).value = "N";
				
			}
			
		} else {
			if ((eval("formObj.highlight_" + count + ".value")) == "") {
				if (eval("formObj.add_bin_location_" + count + ".checked")) {
					eval("formObj.db_action_" + count).value = "I";
					eval("formObj.eff_status_" + count).value = "Y";
				} else {
					eval("formObj.db_action_" + count).value = "I";
					eval("formObj.eff_status_" + count).value = "N";
				}
			}
		}
		
	
					
	}
	
	var xmlStr = "<root><SEARCH ";
	if (parseInt(end) > parseInt(totalRecord)) {
		end = totalRecord;
	}
	for (var i = start; i < end; i++) {
		xmlStr += " EFF_STATUS_" + i + "=\"" + eval("formObj.eff_status_" + i + ".value") + "\" " + " BIN_LOCATION_CODE_" + i + "=\"" + eval("formObj.remove_bin_location_" + i + ".value") + "\" " + " DB_ACTION_" + i + "=\"" + eval("formObj.db_action_" + i + ".value") + "\" ";
	}
	xmlStr += " /></root>";
	
	return xmlStr;
}

function query() {
	f_query_add_mod.location.href = "../../eST/jsp/ItemStoreBinLocationQueryCriteria.jsp?function_id=" + function_id;
}
function apply() {
	var errorPage = "../../eCommon/jsp/error.jsp";
	if (f_query_add_mod.frameItemStoreBinLocationHeader == null) {
		messageFrame.location.href = errorPage + "?err_num=";
		return;
	}
	var fields = new Array(f_query_add_mod.frameItemStoreBinLocationHeader.document.formItemStoreBinLocationHeader.store_code);
	var names = new Array(getLabel("Common.Store.label", "Common"));
	var blankObj = null;
	blankObject = checkSTFields(fields, names, messageFrame, errorPage);
	if (blankObject != true) {
		return;
	}
	if (!f_query_add_mod.frameItemStoreBinLocationHeader.document.formItemStoreBinLocationHeader.store_code.disabled) {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("MIN_ONE_RECORD_AVB", "ST");
		return;
	}
	var formObj1=f_query_add_mod.frameItemStoreBinLocationDetail.document.formItemStoreBinLocationDetail;
	var chkdValue = 0;
	for (count = 0; count < formObj1.total_records.value; count++) {
		if (eval("formObj1.add_bin_location_" + count) == undefined) {
			break;
		}
		if (eval("formObj1.add_bin_location_" + count) != null && eval("formObj1.add_bin_location_" + count + ".checked")) {
			chkdValue++;
		}
	}

	var formObj = f_query_add_mod.frameItemStoreBinLocationHeader.document.formItemStoreBinLocationHeader;
	var responseText = formApply(formObj, ST_CONTROLLER);
	eval(responseText);
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + message;
	if (result) {
		onSuccess();
	}
}
function onSuccess() {
	f_query_add_mod.document.location.reload();
}
async function callItemSearchScreen() {
	var formObject = document.formItemStoreBinLocationHeader;
	var search_string = "";
	if (!formObject.item_desc.readOnly) {
		search_string = formObject.item_desc.value;
	}
	var store_code = formObject.store_code.value;
	var category = "A";
	var sole_source = "A";
	var ps_item = "A";
	var mfg_item = "A";
	var expiry = "A";
	var consignment = "A";
	var item_class = "";
	
	var results =await callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment);
	if (results != null) {
		formObject.item_code.value = results[0];
		formObject.item_desc.value = results[1];
		if (formObject.item_code.value != "") {
			formObject.item_desc.readOnly = true;
		}
	}
}
function focusObject() {
	document.forms[0].elements[0].focus();
}
function addOrderByCol() {
	var i = 0;
	var from = document.getElementById("orderbycols");
	if (from.options.length > 0 && from.selectedIndex > -1) {
		var to = document.getElementById("orderbycolumns");
		var element = document.createElement("OPTION");
		element.text = from.options[from.selectedIndex].text;
		element.value = from.options[from.selectedIndex].value;
		to.add(element);
		from.remove(from.selectedIndex);
		if (from.options[i]) {
			from.options[i].selected = true;
		}
		i++;
	}
}
function removeOrderByCol() {
	var j = 0;
	var from = document.getElementById("orderbycolumns");
	if (from.options.length > 0 && from.selectedIndex > -1) {
		var to = document.getElementById("orderbycols");
		var element = document.createElement("OPTION");
		element.text = from.options[from.selectedIndex].text;
		element.value = from.options[from.selectedIndex].value;
		to.add(element);
		from.remove(from.selectedIndex);
		if (from.options[j]) {
			from.options[j].selected = true;
		}
		j++;
	}
}
function SelectAll() {
	var i = 0;
	document.getElementById('orderbycolumns').selectedIndex = 0;
	while (i < document.getElementById('orderbycolumns').length) {
		document.getElementById('orderbycolumns').options[i].selected = true;
		i++;
	}
}
function execQuery() {
	if (document.getElementById('orderbycolumns').options.length > 0) {
		SelectAll();
		document.query_form.submit();
	} else {
		alert(getMessage("ORDERBY_NOT_BLANK", "Common"));
	}
}

function activeLink() {
	formObj = parent.frameItemStoreBinLocationDetail.document.formItemStoreBinLocationDetail;
	
	if (formObj.start.value != 0) {
		parent.frameItemStoreBinLocationDetail.document.getElementById('prev').style.visibility = "visible";
	} else {
		
		parent.frameItemStoreBinLocationDetail.document.getElementById('prev').style.visibility = "hidden";
	}
	if (!((parseInt(formObj.start.value) + parseInt(formObj.displaySize.value)) >= formObj.total_records.value)) {
		parent.frameItemStoreBinLocationDetail.document.getElementById('next').style.visibility = "visible";
	} else {
		
		parent.frameItemStoreBinLocationDetail.document.getElementById('next').style.visibility = "hidden";
	}
}
function goNext(source_mode) {
	formObj = parent.frameItemStoreBinLocationDetail.document.formItemStoreBinLocationDetail;
	start = parseInt(formObj.start.value) + parseInt(formObj.displaySize.value);
	end = parseInt(formObj.end.value) + parseInt(formObj.displaySize.value);
	xmlStr = formXMLString(formObj.start.value, formObj.end.value, formObj.total_bin_codes.value, formObj);
	formValidation(xmlStr, formObj.start.value, formObj.end.value, formObj.total_bin_codes.value);
	if (formObj.mode.value == MODE_INSERT) {
		modeVal = MODE_INSERT;
	} else {
		modeVal = MODE_MODIFY;
	}
	var formOBJ=parent.frameItemStoreBinLocationHeader.document.formItemStoreBinLocationHeader;
	var item_code=formOBJ.item_code.value;
	var store_code=formOBJ.store_code.value;
	var bin_location_search_string=formOBJ.bin_location_search_string.value;
	var bin_location_criteria=formOBJ.bin_location_criteria.value;

	if (source_mode == "select") {
		parent.frameItemStoreBinLocationDetail.location.href = "../../eST/jsp/ItemStoreBinLocationDetail.jsp?mode=" + modeVal + "&from=" + start + "&to=" + end + "&dispMode=fromlink"+"&store_code=" + store_code+ "&item_code=" + item_code + "&bin_location_search_string=" +bin_location_search_string + "&bin_location_criteria=" + bin_location_criteria + "&mode=" + modeVal;
	}
}
function goPrev(source_mode) {
	formObj = parent.frameItemStoreBinLocationDetail.document.formItemStoreBinLocationDetail;
	start = parseInt(formObj.start.value) - parseInt(formObj.displaySize.value);
	end = parseInt(formObj.end.value) - parseInt(formObj.displaySize.value);
	xmlStr = formXMLString(formObj.start.value, formObj.end.value, formObj.total_bin_codes.value, formObj);
	formValidation(xmlStr, formObj.start.value, formObj.end.value, formObj.total_bin_codes.value);
	if (formObj.mode.value == MODE_INSERT) {
		modeVal = MODE_INSERT;
	} else {
		modeVal = MODE_MODIFY;
	}
		
	var formOBJ=parent.frameItemStoreBinLocationHeader.document.formItemStoreBinLocationHeader;
	var item_code=formOBJ.item_code.value;
	var store_code=formOBJ.store_code.value;
	var bin_location_search_string=formOBJ.bin_location_search_string.value;
	var bin_location_criteria=formOBJ.bin_location_criteria.value;
	
	if (source_mode == "select") {
		parent.frameItemStoreBinLocationDetail.location.href = "../../eST/jsp/ItemStoreBinLocationDetail.jsp?mode=" + modeVal + "&from=" + start + "&to=" + end + "&dispMode=fromlink"+"&store_code=" + store_code+ "&item_code=" + item_code + "&bin_location_search_string=" +bin_location_search_string + "&bin_location_criteria=" + bin_location_criteria + "&mode=" + modeVal;
	}
}
function formValidation(xmlStr, start, end, totalRecords, checked_yn, idx, index) {
	index = "-1";
	var select_all = "";
	if (formObj.checked_yn.value == "Y") {
		select_all = "Y";
	}
	formObj = parent.frameItemStoreBinLocationDetail.document.formItemStoreBinLocationDetail;
	assignBean(document.formItemStoreBinLocationDetail);
	temp_jsp = "../../eST/jsp/ItemStoreBinLocationValidate.jsp?idx=" + idx + "&checked_yn=" + checked_yn + "&totalRecords=" + totalRecords + "&index=" + index + "&select_all=" + select_all + "&function_type=3" + "&bean_id=" + bean_id + "&bean_name=" + bean_name;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", temp_jsp, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	return true;
}

function alterBean(obj, index) {
	var name = obj.name;
	var len = obj.name.length;
	var idx = name.substring(8, len);
	var idx = name;
	formObj = parent.frameItemStoreBinLocationDetail.document.formItemStoreBinLocationDetail;	
	
	xmlStr = formXMLString(formObj.start.value, formObj.end.value, formObj.total_bin_codes.value, formObj);
	formValidation(xmlStr, formObj.start.value, formObj.end.value, formObj.total_bin_codes.value, obj.checked, idx, index);
}
function getTotalCheckBoxes(total_records) {

	if (parseInt(parent.frames[0].document.forms[0].total_count_flag.value) == 0) {
		parent.frames[0].document.forms[0].total_count_flag.value = parseInt(total_records.value);
	} else {
		parent.frames[0].document.forms[0].total_count_flag.value = parseInt(parent.frames[0].document.forms[0].total_count_flag.value) + parseInt(total_records.value);
	}
	var xmlString = getXMLString(null);
    var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	var xmlHttp = new XMLHttpRequest();
	//var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/ItemStoreBinLocationValidate.jsp?&total_records=" + parent.frames[0].document.forms[0].total_count_flag.value + "&function_type=4", false);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(xmlString);
	var responseText = xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);
}
function SubmitLink(from, to) {
	if (document.formItemStoreBinLocationDetail == null) {
		document.QueryForm.from.value = from;
		document.QueryForm.to.value = to;
		document.QueryForm.submit();
		return;
	}
	var selectedIndices = "";
	var index = 0;
	var total_remarks = document.formItemStoreBinLocationDetail.total_bin_codes.value;
	var arrayObject = new Array();
	window.returnValue = false;
	formObj = parent.frameItemStoreBinLocationDetail.document.formItemStoreBinLocationDetail;
	formObj = parent.frameItemStoreBinLocationDetail.document.formItemStoreBinLocationDetail;
	var count = 0;
	for (var i = 0; i < formObj.elements.length; i++) {
		if ((formObj.elements(i).type == "checkbox") && (formObj.elements(i).name != "selectAll")) {
			alterBean(formObj.elements(i));
		}
	}
	document.QueryForm.from.value = from;
	document.QueryForm.to.value = to;
	document.QueryForm.submit();
}
function checkStock(index)
{
	
	if((eval("document.formItemStoreBinLocationDetail.add_bin_location_" + index + ".checked")==false)&&(eval("document.formItemStoreBinLocationDetail.highlight_" + index + ".value")=="DATAHIGHLIGHT"))
	{
		
			assignBean(document.formItemStoreBinLocationDetail);
			xmlStr = getXMLString(document.formItemStoreBinLocationDetail);
			//xmlDom.loadXML(xmlStr);
			var xmlDom = "";
			var xmlHttp = new XMLHttpRequest();
			var bin_locn_code=eval("formObj.add_bin_location_" + index).value;
		
			xmlHttp.open("POST", "../../eST/jsp/ItemStoreBinLocationValidate.jsp?bean_id=" + bean_id +"&index="+index+"&bin_location_code="+bin_locn_code+ "&bean_name=" + bean_name + "&function_type=2", false);
			xmlHttp.send(xmlDom);
			responseText = xmlHttp.responseText;
			eval(responseText);
			
	}
}
function getGTINDetails (e,barcode){//Adding start for MOHE-CRF-0167
	if(e.keyCode==9 || e.keyCode== 13  || e.keyCode== 0){
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		var item_code = document.formItemStoreBinLocationHeader.item_code.value;
		var store_code = document.formItemStoreBinLocationHeader.store_code.value;
		bean_id = document.formItemStoreBinLocationHeader.bean_id.value;
		bean_name = document.formItemStoreBinLocationHeader.bean_name.value;
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eST/jsp/ItemStoreBinLocationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&barcode=" + barcode.value+"&item_code="+item_code +"&store_code="+store_code+"&function_type=5", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if(result){
			
			callItemSearchScreen("BARCODE",barcode.value);
			
		}else{
			if(item_code==""){
			document.formItemStoreBinLocationHeader.barcode.value = "";
			 alert(getMessage(message, "ST"));
			}
		}
		
	}
}
