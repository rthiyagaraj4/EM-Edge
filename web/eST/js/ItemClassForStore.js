
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
	f_query_add_mod.location.href = "../../eST/jsp/ItemClassForStoreMain.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
}
function displayDetail() {
	var errorPage = "../../eCommon/jsp/error.jsp";
	var fields = new Array(document.frmItemClassForStoreHeader.store_code);
	var names = new Array(getLabel("Common.Store.label", "Common"));
	var blankObject = checkSTFields(fields, names, parent.parent.messageFrame, errorPage);
	if (blankObject == true) {
		document.frmItemClassForStoreHeader.store_code.disabled = true;
		parent.parent.messageFrame.location.href = errorPage;
		parent.ItemClassForStoreDetailFrame.location.href = "../../eST/jsp/ItemClassForStoreDetail.jsp?store_code=" + document.frmItemClassForStoreHeader.store_code.value + "&mode=" + MODE_INSERT;
	}
}
function reset() {
	if (f_query_add_mod.ItemClassForStoreHeaderFrame != null) {
		f_query_add_mod.location.href = "../../eST/jsp/ItemClassForStoreMain.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
	}
	if (f_query_add_mod.document.query_form != null) {
		f_query_add_mod.document.query_form.reset();
	}
}
function SubmitLink(from, to) {
	if (document.formItemClassForStoreDetail == null) {
		document.QueryForm.from.value = from;
		document.QueryForm.to.value = to;
		document.QueryForm.submit();
		return;
	}
	var selectedIndices = "";
	var index = 0;
	var total_item_class = document.formItemClassForStoreDetail.total_item_class.value;
	var arrayObject = new Array();
	window.returnValue = false;
	for (count = 0; count < total_item_class; count++) {
		arrayObject[index++] = eval("document.formItemClassForStoreDetail.remove_item_class_" + count);
		if (eval("document.formItemClassForStoreDetail.item_class_" + count) != null && eval("document.formItemClassForStoreDetail.item_class_" + count + ".checked")) {
			window.returnValue = true;
			arrayObject[index++] = eval("document.formItemClassForStoreDetail.item_class_" + count);
		}
	}
	assignBean(document.formItemClassForStoreDetail);
	var xmlStr = getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	var xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", "../../eST/jsp/ItemClassForStoreValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=1", false);
	xmlHttp.send(xmlStr);
	var responseText = xmlHttp.responseText;
	responseText = trimString(responseText); 
	eval(responseText);
	document.QueryForm.from.value = from;
	document.QueryForm.to.value = to;
	document.QueryForm.submit();
}
function query() {
	f_query_add_mod.location.href = "../../eST/jsp/ItemClassForStoreQueryCriteria.jsp?function_id=" + function_id;
}
function apply() {
	var errorPage = "../../eCommon/jsp/error.jsp";
	if (f_query_add_mod.ItemClassForStoreHeaderFrame == null) {
		messageFrame.location.href = errorPage + "?err_num=";
		return;
	}
	var fields = new Array(f_query_add_mod.ItemClassForStoreHeaderFrame.document.frmItemClassForStoreHeader.store_code);
	var names = new Array(getLabel("Common.Store.label", "Common"));
	var blankObj = null;
	blankObject = checkSTFields(fields, names, messageFrame, errorPage);
	if (blankObject != true) {
	
		return;
	}
	if (!f_query_add_mod.ItemClassForStoreHeaderFrame.document.frmItemClassForStoreHeader.store_code.disabled) {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("MIN_ONE_RECORD_AVB", "ST");
		return;
	}
	var formObj = f_query_add_mod.ItemClassForStoreDetailFrame.document.formItemClassForStoreDetail;
	formObj.total_item_class.value = f_query_add_mod.ItemClassForStoreHeaderFrame.document.frmItemClassForStoreHeader.total_count_flag.value;
	var total_item_class = formObj.total_item_class.value;
	var chkdValue = 0;
	for (count = 0; count < total_item_class; count++) {
		if (eval("formObj.item_class_" + count) != null && eval("formObj.item_class_" + count + ".checked")) {
			chkdValue++;
		}
	}
	formObj.canProcess.value = chkdValue;
	if (parseFloat(formObj.canProcess.value) <= 0 && formObj.PreviousListValueExit.value == "N") {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("MIN_ONE_DETAIL_REQUIRED", "Common");
		return;
	}
	eval(formApply(formObj, ST_CONTROLLER));
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + message;
	if (result) {
		onSuccess();
	}
}
function onSuccess() {
	f_query_add_mod.document.location.reload();
}
function gettotalcheckBoxes(item_class_count) {
	if (parseInt(parent.frames[0].document.frmItemClassForStoreHeader.total_count_flag.value) == 0) {
		parent.frames[0].document.frmItemClassForStoreHeader.total_count_flag.value = parseInt(item_class_count.value);
	} else {
		parent.frames[0].document.frmItemClassForStoreHeader.total_count_flag.value = parseInt(parent.frames[0].document.frmItemClassForStoreHeader.total_count_flag.value) + parseInt(item_class_count.value);
	}
}

