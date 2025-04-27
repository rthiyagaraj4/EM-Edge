var xmlDom;
var xmlHttp;
var finalizeType = "N";
var prevObj = null;
var prevColor = null;

function create() {

	f_query_add_mod.location.href = "../../eST/jsp/PORequestFrame.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
}

function reset() {
	f_query_add_mod.location.reload();
}
function query() {
	f_query_add_mod.location.href = "../../eST/jsp/PORequestQueryFrame.jsp?function_id=" + function_id;
}



function updateValues() {
	var formObject = document.formPORequestHeader;
	
	if (formObject.to_store_code) {
		formObject.request_by_store.value = formObject.from_store_code.value;
		formObject.request_on_store.value = formObject.to_store_code.value;
		formObject.item_class.value = formObject.item_class_code.value;
		formObject.item_class_des.value = formObject.item_class_desc.value;
	}
}



	async function callItemSearch() {
	
	var formHeader = parent.PORequestHeaderFrame.document.formPORequestHeader;
	var errorPage = "../../eCommon/jsp/error.jsp";
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	formHeader.request_by_store.value = formHeader.from_store_code.value;
	formHeader.request_on_store.value = formHeader.to_store_code.value;
	var arrayObject = new Array(formHeader.request_by_store, formHeader.request_on_store);
	var names = new Array(getLabel("Common.ReqByStore.label", "Common"),getLabel("eST.ToDepartment.label", "ST"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.messageFrame, errorPage);
	if (blankObject != true) {
		return;
	}
	var formObject = document.formPORequestDetail;
	formObject.item_class_desc.value = formHeader.item_class_desc.value;
	var item_class_desc = formHeader.item_class_des.value;
	var search_string = formObject.item_desc.value;
	var store_code = formHeader.request_by_store.value;
	var store_code_to = formHeader.request_on_store.value;
	var mode = formHeader.mode.value;
	var category = "";
	var sole_source = "A";
	var ps_item = "A";
	var mfg_item = "A";
	var expiry = "A";
	var consignment = "A";
	if (mode == 2) {
		var item_class = formHeader.item_class_code1.value;
		if (item_class == "null") {
			item_class = "";
		}
	} else {
		var item_class = formHeader.item_class_code.value;
	}
	
	
	var to_store_code = formHeader.from_store_code.value;
	var chkitemstorecmb = "Y";
	var kit = "Y";
	var results = await callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment, chkitemstorecmb, "", "", item_class_desc,"");// kit);
	if (results != null) {
		var bean_id = "porequestBean";
		var bean_name = "eST.PORequestBean";
		var item_code = results[0];
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		var xmlString = getXMLString(null);
        var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/PORequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&item_code=" + item_code + "&store_code=" + to_store_code + "&function_type=BATCHDETAILS&store_code_to=" + store_code_to, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
			if (result) {
			var request_type = parent.PORequestHeaderFrame.formPORequestHeader.request_type.value;
			var bean_id = "porequestBean";
			var bean_name = "eST.PORequestBean";
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
            var xmlString = getXMLString(null);
            var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
			//xmlDoc.loadXML(getXMLString(null));
			xmlHttp.open("POST", "../../eST/jsp/PORequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&item_code=" + results[0] + "&store_code=" + formHeader.request_by_store.value + "&function_type=CONVFACTTEMP" + "", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			if (!result) {
				parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "ST");
				document.location.href = "../../eST/jsp/PORequestDetail.jsp?mode=" + MODE_INSERT + "&function_id=" + parent.parent.function_id;
				return;
			}
            var xmlString = getXMLString(null);
            var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
			//xmlDoc.loadXML(getXMLString(null));
			xmlHttp.open("POST", "../../eST/jsp/PORequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&item_code=" + results[0] + "&uom_code=" + results[13] + "&request_type=" + request_type + "&req_uom_code=" + results[26] + "&store_code=" + formHeader.request_by_store.value + "&function_type=DEFAULTUOM" + "", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			
			eval(responseText);
			if (!result) {
				parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message);
				document.location.href = "../../eST/jsp/PORequestDetail.jsp?mode=" + MODE_INSERT + "&function_id=" + parent.parent.function_id;
				return;
			}
		} 
		else {
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?";
			if (message == "PHY_INV_PROCESS_INITIATED") {
				alert(getMessage(message, "ST") + "\n" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + formObject.phy_inv_id.value);
			} else {
				alert(getMessage(message, "ST"));
			}
			document.location.href = "../../eST/jsp/PORequestDetail.jsp?mode=" + MODE_INSERT + "&function_id=" + parent.parent.function_id;
			return;
		}
		formObject.item_code.value = results[0];
		formObject.item_desc.value = results[1];
		formObject.item_desc.readOnly = true;
		formObject.uom.value = results[13];
		formObject.temp_uom.value = results[15];
	/**
	* @Name - krishna
	* @Date - 22/01/2010
	* @Inc# - IN015496
	* @Desc - Decimal Allowed yn is set form JS.
	*/
		document.formPORequestDetail.dec_allowed_yn.value = results[27];
		document.formPORequestDetail.no_of_decimals.value=retVal[28];
		formObject.add.disabled = false;
		document.getElementById("uom_label").innerHTML = "<B>" + results[15] + "</B>"; 
		if (formObject.pur_uom_code.value == "") {
			alert(getMessage("PUR_SALE_UOM_UNDEFINED", "ST"));
			parent.parent.messageFrame.location.href = errorPage;
			parent.PORequestDetailFrame.location.reload();
		}
		document.getElementById("id_pur_uom_conv").innerHTML = "1";
		document.getElementById("id_pur_uom_conv1").value = "1";
		document.formPORequestDetail.conv_fact.value = "1";
		formObject.pur_uom_code.focus();
		formHeader.store_code_disabled.value = "disabled";
	}
}

function selectUOMcode(default_uom) {
	parent.frames[2].document.formPORequestDetail.pur_uom_code.value = default_uom;
}

function checkUOMConvFactor() {

	var formObj = document.formPORequestDetail;
	//if (formObj.uom.value == formObj.pur_uom_code.value) {
	//	setUOMConvFactor("1");
	//	return;
	//}

	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	var xmlString = getXMLString(null);
    var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	//xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/PORequestValidate.jsp?uom=" + formObj.uom.value + "&pur_uom_code=" + formObj.pur_uom_code.value + "&bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value + "&function_type=CHECKUOMCONVFACTOR" + "&item_code=" + formObj.item_code.value, false);
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	eval(responseText);
	if (!result) {
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "ST");
		formObj.pur_uom_code.value = formObj.uom.value;
		formObj.pur_uom_code.focus();
		setUOMConvFactor("1");
	}
}

function setUOMConvFactor(_value) {
	document.getElementById("id_pur_uom_conv").innerHTML = _value;
	document.getElementById("id_pur_uom_conv1").value = _value;
	document.formPORequestDetail.conv_fact.value = _value;
}


function calRequestQty(obj) {
	var formObj = document.formPORequestDetail;
	formObj.required_qty.value = "";

if(formObj.dec_allowed_yn.value=="Y"){
		if (!checkDoubleFormat(obj,false)) {
			return false;
		}
	}else{
		if (!checkIntegerFormat(obj,false)) {
			return false;
		}
	}

	toConvFactor();
	/**
	* @Name - krishna
	* @Date - 22/01/2010
	* @Inc# - IN015496
	* @Desc - No of Decimal is brought here in order to pass a value 
	*/
	var no_of_decimals=formObj.no_of_decimals.value;
	if(formObj.dec_allowed_yn.value=="N")
		no_of_decimals=0;
	if (formObj.req_uom_qty.value == "") {
	} else {
		formObj.required_qty.value = (eval(document.getElementById("conv_fact").value) * eval(formObj.req_uom_qty.value)).toFixed(no_of_decimals);
		if (formObj.max_stk_qty.value != null) {             
		}
		if (eval(formObj.required_qty.value)/eval(formObj.frm_tmp_conv.value) + eval(formObj.qty_on_hand.value) > eval(formObj.max_stk_qty.value)) {
			alert(getLabel("eST.exceedmaxStockLevel.label", "ST"));
		} //exceed max Stock Level
	}
}


function toConvFactor() {
	var bean_id = "porequestBean";
	var bean_name = "eST.PORequestBean";
	var formObj = document.formPORequestDetail;
	var item_code = "";
	if (formObj == null) {
		formObj = parent.frames[2].frames[0].document.formPORequestDetail;
		var frm_store_code = parent.PORequestHeaderFrame.document.formPORequestHeader.request_by_store.value;
		var to_store_code = parent.PORequestHeaderFrame.document.formPORequestHeader.request_on_store.value;
	} else {
		var frm_store_code = parent.PORequestHeaderFrame.document.formPORequestHeader.request_by_store.value;
		var to_store_code = parent.PORequestHeaderFrame.document.formPORequestHeader.request_on_store.value;
	}
	item_code = formObj.item_code.value;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	var xmlString = getXMLString(null);
    var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	//xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/PORequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=CALREQUESTQTY" + "&frm_store_code=" + frm_store_code + "&to_store_code=" + to_store_code + "&item_code=" + item_code, false);
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	eval(responseText);
}

function setTempConvFactor(frm_tmp, to_tmp) {


	if (document.formPORequestDetail == null) {
		parent.frames[2].frames[0].document.formPORequestDetail.frm_tmp_conv.value = frm_tmp;
		parent.frames[2].frames[0].document.formPORequestDetail.to_tmp_conv.value = to_tmp;
	} else {
		document.formPORequestDetail.frm_tmp_conv.value = frm_tmp;
		document.formPORequestDetail.to_tmp_conv.value = to_tmp;
	}
}


function issueUOMQtyChk() {
	var formObj = document.formPORequestDetail;
	toConvFactor();
	/*if(formObj.dec_allowed_yn.value=="N"){
	var conv_factor = lcm(formObj.frm_tmp_conv.value, formObj.to_tmp_conv.value);
	var dec_factor = (formObj.required_qty.value) % (conv_factor);
	if (dec_factor > 0 && conv_factor > 1) {
			alert("Requested Quantity Should Be In Multiples Of " + conv_factor);
			return false;
		}else{
			return true;
		}
	} */
	return true;
}



function addItemRecord() {
	var formObject = document.formPORequestDetail;
	var errorPage = "../../eCommon/jsp/error.jsp";
	var arrayObject = new Array(formObject.req_uom_qty);
	var names = new Array(getLabel("eST.ReqUOMQty.label", "ST"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.messageFrame, errorPage);
	if (blankObject != true) {
		return;
	}
	var formHeader = parent.PORequestHeaderFrame.document.formPORequestHeader;
	if (formHeader.request_by_store.value == formHeader.request_on_store.value) {
		parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("REQ_ON_REQ_BY_CANNOT_BE_SAME", "ST");
		formHeader.request_by_store.focus();
		return;
	}
	var store_code = formHeader.request_by_store.value;
	var to_store_code = formHeader.request_on_store.value;
	var item_code = formObject.item_code.value;
	var bean_id = "porequestBean";
	var bean_name = "eST.PORequestBean";
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));	
	var xmlString = getXMLString(null);
    var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/PORequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&item_code=" + item_code + "&store_code=" + store_code + "&function_type=ADDITEMRECORD" + "", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;	
	eval(responseText);
	
	
	formObject.request_by_store.value = formHeader.request_by_store.value;
	formObject.request_on_store.value = formHeader.request_on_store.value;
	formObject.mode.value = formHeader.mode.value;
	
	assignBean(formObject);
	xmlStr = getEnhancedXMLString(formObject);
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	if ((formObject.mode.value == MODE_INSERT) || ((formObject.mode.value == MODE_MODIFY) && (formObject.editing.value == 2))) {
		function_type ="EDITING";
	} else {
		var function_type="";
		if ((formObject.mode.value == MODE_MODIFY) && (formObject.editing.value == 1)) {
			function_type ="MODIFYMODE";
		}
	}

	
	xmlHttp.open("POST", "../../eST/jsp/PORequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=" + function_type, false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
	var mod_id="ST";
	if(message=="DUPLICATE_CODE_EXISTS")
		mod_id="Common";
	if (!result) {
		parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, mod_id);
		return;
	}
	parent.parent.messageFrame.location.href = errorPage;
	index = formObject.srl_no.value;
	if (index != -1) {
		index = index - 1;
	}
	parent.PORequestListFrame.document.location.href = "PORequestList.jsp?index=" + index;
	formObject.add.value = getLabel("Common.Add.label", "Common");
	formHeader.request_by_store.disabled = true;
	formHeader.request_on_store.disabled = true;
	formHeader.item_class_code.disabled = true;
	formObject.item_desc.readOnly = false;
	parent.PORequestHeaderFrame.formPORequestHeader.request_type.disabled = true;
	if (formObject.editing.value == "1") {
		formObject.item_desc.readOnly = false;
		formObject.add.disabled = true;
		document.getElementById("uom_label").innerHTML = "&nbsp;";
		document.getElementById("Qty_onhand_label").innerHTML = "&nbsp;";
		clearListItems('document.formPORequestDetail.pur_uom_code');
		document.getElementById("id_pur_uom_conv").innerHTML = "&nbsp;";
		formObject.reset();
	} else {
		document.location.href = "../../eST/jsp/PORequestDetail.jsp?mode=" + MODE_INSERT + "&function_id=" + parent.parent.function_id;
	}
}

function lcm(frm_tmp, to_tmp) {
	var lowest = frm_tmp < to_tmp ? frm_tmp : to_tmp;
	var hcd = 1;
	for (var i = lowest; i > 1; i--) {
		if (frm_tmp % i == 0 && to_tmp % i == 0) {
			hcd = i;
			break;
		}
	}
	var lcm = (frm_tmp * to_tmp) / hcd;
	return lcm;
}

function assignBean(frmObject) {
	bean_id = frmObject.bean_id.value;
	bean_name = frmObject.bean_name.value;
	var xmlHttp = new XMLHttpRequest();
	var xmlDom = "";
	/*xmlDom = new ActiveXObject("Microsoft.XMLDom");
	xmlHttp = new ActiveXObject("Microsoft.XMLHTTP"); */
}


function updateCheckStatus(obj_item_code) {
	var check_status = "";
	var formObj = document.formPORequestList;
	assignBean(formObj);
	if (obj_item_code.checked) {
		check_status = "Y";
	} else {
		check_status = "N";
	}
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	var xmlString = getXMLString(null);
    var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	//xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/PORequestValidate.jsp?item_code=" + obj_item_code.value + "&check_status=" + check_status + "&bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value + "&function_type=UPDATECHECKSTATUS", false);
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	eval(responseText);
}


function displayItemDetail(idx) {
	var trObject = eval(document.getElementById("tr_" + idx));
	
	changeRowColor(trObject);
	var item_code = eval("document.formPORequestList.item_code_" + idx + ".value");
	parent.PORequestDetailFrame.document.location.href = "../../eST/jsp/PORequestDetail.jsp?mode=" + MODE_MODIFY + "&function_id=" + parent.parent.function_id + "&item_code=" + item_code + "&edit=" + document.formPORequestList.mode.value;
}

function changeRowColor(obj) {
	tot = document.forms[0].total_checkboxes.value;
	tot = tot - 1;
	if (prevObj != null) {
		for (k = 1; k < 8; k++) {
			prevObj.cells[k].className = prevColor;
		}
	}
	prevObj = obj;
	prevColor = obj.cells[1].className;
	for (k = 1; k < 8; k++) {
		obj.cells[k].className = "STLIGHTPINK";
	}
}


function resetDetail() {
	document.location.href = "../../eST/jsp/PORequestDetail.jsp?mode=" + MODE_INSERT + "&function_id=" + parent.parent.function_id;
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
}



async function apply() {
	var bean_id = "porequestBean";
	var bean_name = "eST.PORequestBean";
	var errorPage = "../../eCommon/jsp/error.jsp";
	if(f_query_add_mod.PORequestHeaderFrame==undefined)
	{
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	return;
	}
	var formHeader = f_query_add_mod.PORequestHeaderFrame.document.formPORequestHeader;
	if (formHeader.mode.value == MODE_DELETE) {
		eval(formApply(formHeader, ST_CONTROLLER));
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "Common");
		if (result) {
			onSuccess();
		}
		return;
	}
	var arrayObject = new Array(formHeader.doc_type_code, formHeader.doc_date, formHeader.request_by_store, formHeader.request_on_store);
	var names = new Array(getLabel("Common.DocType.label", "Common"), getLabel("Common.DocDate.label", "Common"), "Requested by Store", getLabel("Common.RequestedOnStore.label", "Common"));
	if (!formHeader.doc_no.disabled) {
		arrayObject[++arrayObject.length] = formHeader.doc_no;
		names[++arrayObject.length] = getLabel("Common.DocNo.label", "Common");
	}
	var formObject = f_query_add_mod.PORequestListFrame.document.formPORequestList;
	var total_items = formObject.total_checkboxes.value;
	var chkdValue = 0;
	for (count = 0; count < total_items; count++) {
		if (!eval("formObject.add_itm_" + count + ".checked")) {
			chkdValue++;
		}
	}
	if (total_items == chkdValue) {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("MIN_ONE_DETAIL_REQUIRED", "Common");
		return;
	}
	for (count = 0; count < total_items; count++) {
		if (eval("formObject.add_itm_" + count + ".checked")) {
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			var xmlString = getXMLString(null);
            var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
		//	xmlDoc.loadXML(getXMLString(null));
			xmlHttp.open("POST", "../../eST/jsp/PORequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&item_code=" + eval("formObject.add_itm_" + count + ".value") + "&function_type=ISSQTYCANNOTBEZERO", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			if (!result) {
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("ISS_QTY_CANNOT_BE_ZERO", "ST");
				return;
			}
		}
	}

	formObject.mode.value = formHeader.mode.value;
	formObject.doc_type_code.value = formHeader.doc_type_code.value;
	formObject.doc_no.value = formHeader.doc_no.value;
	formObject.doc_date.value = formHeader.doc_date.value;
	formObject.doc_ref.value = formHeader.doc_ref.value;
	formObject.request_by_store.value = formHeader.request_by_store.value;
	formObject.request_on_store.value = formHeader.request_on_store.value;
	formObject.item_class_code.value = formHeader.item_class_code.value;
	formObject.autono_yn.value = formHeader.autono_yn.value;
	formObject.request_type.value = formHeader.request_type.value;
	formObject.doc_type_code.value = formHeader.doc_type_code1.value;
	checkCanAuthorize(formObject.request_by_store);
	formHeader.authorize_yn.value = formHeader.authorize_yn.value.substring(0, 1);
	

	if (f_query_add_mod.PORequestHeaderFrame.formPORequestHeader.request_type.value == "R") {
		if (formHeader.authorize_yn.value == "Y") {
			finalizeType =await confirmFinalize();
			if(finalizeType==""){
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
				return;
			}
		}
	} else {
		if (f_query_add_mod.PORequestHeaderFrame.formPORequestHeader.request_type.value == "U") {
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			var xmlString = getXMLString(null);
            var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
		//	xmlDoc.loadXML(getXMLString(null));
			xmlHttp.open("POST", "../../eST/jsp/PORequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&store_code=" + formHeader.request_by_store.value + "&function_type=AUTHORIZE" + "", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			formObject.finalize_yn.value = "N";
			if (result && message == "Y") {
				finalizeType =await confirmFinalize();
				if(finalizeType==""){
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
				return;
			}
			}
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "ST");
		}
	}


	if (finalizeType == "") {
		finalizeType = "N";
	}
	formObject.finalize_yn.value = finalizeType;
	var responseText = formApply(formObject, ST_CONTROLLER);
	
	eval(responseText);
	flag1 = (flag.split("~"))[0];
	flag2 = (flag.split("~"))[1];
	flag1 = (flag1 == "null" ? "" : flag1);
	if (result) {

		messageFrame.location.href = errorPage + "?err_num=" + message + "<BR>" + (result ? flag1 : "");
		onSuccess();
	
	}else{
		messageFrame.location.href = errorPage + "?err_num=" + message;
	}
}

function checkCanAuthorize(request_by_store) {
	var bean_id = "porequestBean";
	var bean_name = "eST.PORequestBean";

	if (request_by_store.value == "") {
		return;
	}
    var xmlHttp = new XMLHttpRequest();
	var arrayObject = new Array();
	arrayObject[0] = request_by_store;
	assignBean(f_query_add_mod.PORequestHeaderFrame.document.formPORequestHeader);
	xmlStr = getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	var xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/PORequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=CHECKFORAUTHORIZE", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
}

function setAuthorize(authorizeValue) {
	f_query_add_mod.PORequestHeaderFrame.document.formPORequestHeader.authorize_yn.value = authorizeValue;
}


function deleterecord() {
	if( f_query_add_mod.PORequestHeaderFrame==undefined){
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
	}else{
	var formHeader = f_query_add_mod.PORequestHeaderFrame.document.formPORequestHeader;
	if (formHeader.mode.value == MODE_MODIFY) {
		formHeader.mode.value = MODE_DELETE;

	if(formHeader.prq_delete_yn.value=="N"){
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("NO_DELETE_ACCESS_FOR_USER", "ST");;
	formHeader.mode.value = MODE_MODIFY;	
		return false;
}

		var result = confirmDelete();
		if (result == YES) {
			apply();
		} else {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + getMessage("OPER_CANCELLED", "ST");
			formHeader.mode.value = MODE_MODIFY;
		}
	} else {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
	}
	}
}


function onSuccess() {
	var formObject = f_query_add_mod.PORequestHeaderFrame.document.formPORequestHeader;
	if (formObject.mode.value == MODE_DELETE) {
		f_query_add_mod.location.href = "../../eCommon/html/blank.html";
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + message;
	} else {
		if (formObject.mode.value == MODE_MODIFY) {
			if (finalizeType == YES) {
			//create();
				f_query_add_mod.location.href = "../../eCommon/html/blank.html";
			} else {
			//f_query_add_mod.document.location.reload();			
				f_query_add_mod.location.href = "../../eCommon/html/blank.html";
			}
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + message;
		} else {
			f_query_add_mod.location.href = "../../eCommon/html/blank.html";
		//reset();
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + message + "<BR>" + flag;
		}
	}
	return;
}



function populateToStoresInQuery(request_by_store) {
	if (request_by_store.value == "") {
		clearListItems("document.forms[0].request_on_store");
		return;
	}
	clearListItems("document.forms[0].request_on_store");
	var arrayObject = new Array();
	var bean_id = "porequestBean";
	var bean_name = "eST.PORequestBean";

	arrayObject[0] = request_by_store;
	assignBean(parent.frames[0].document.forms[0]);

    var xmlHttp = new XMLHttpRequest();
	xmlStr = getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	var xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/PORequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=LOADDEPARTMENT", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
	parent.PORequestQueryResult.location.href = "../../eCommon/html/blank.html" ;

}
function loadItemClassesInQuery(request_by_store, request_on_store) {
	if (request_by_store.value == "" || request_on_store.value == "") {
		clearListItems("document.forms[0].item_class_code");
		return;
	}
	var bean_id = "porequestBean";
	var bean_name = "eST.PORequestBean";

	var arrayObject = new Array();
	arrayObject[0] = request_by_store;
	arrayObject[1] = request_on_store;
	assignBean(parent.frames[0].document.forms[0]);
	xmlStr = getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	var xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/PORequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=LOADITEAMCLASS", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
	parent.PORequestQueryResult.location.href = "../../eCommon/html/blank.html" ;

}

function Modify(obj) {
	var doc_no = obj.cells[1].innerText;
	var doc_type_code = obj.cells[6].innerText;
	var item_class_desc = obj.cells[5].innerText;
	var item_class_code = obj.cells[7].innerText;

	parent.document.location.href = "../../eST/jsp/PORequestFrame.jsp?mode=" + MODE_MODIFY + "&function_id=" + parent.parent.function_id + "&doc_type_code=" + doc_type_code + "&doc_no=" + doc_no + "&item_class_desc=" + item_class_desc + "&item_class_code=" + item_class_code;
}
function dispMess(id) {
	alert(getMessage("PHY_INV_PROCESS_INITIATED", "ST") + "\n" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + id);
}
function setUOMConvFactor1(_value,_rulestring) {


	document.getElementById("id_pur_uom_conv").innerHTML = _rulestring;
	document.getElementById("id_pur_uom_conv1").value = _rulestring;
	document.getElementById("conv_fact").value = _value;
}

function searchResult() {
	// As date is having issue have to set it and resubmit again 
	
	document.formPORequestQueryCriteria.action="../../eST/jsp/PORequestQueryResult.jsp"
	document.formPORequestQueryCriteria.target="PORequestQueryResult"
	document.formPORequestQueryCriteria.submit();
	
}

