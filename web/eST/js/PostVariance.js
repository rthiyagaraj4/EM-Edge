
var function_id = "";
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
var finalizeType;
function onSuccess() {
	f_query_add_mod.document.location.reload();
	return;
}
function reset() {
	f_query_add_mod.document.formPostVariance.reset();
}
function apply() {
	var fields = new Array();
	var fieldNames = new Array();
	var index = 0;
	var queryString = "";
	fields[index] = f_query_add_mod.document.formPostVariance.phy_inv_id;
	fieldNames[index++] = getLabel("eST.PhyInventoryID.label", "ST");
	fields[index] = f_query_add_mod.document.formPostVariance.doc_type_code;
	fieldNames[index++] = getLabel("Common.DocType.label", "Common");
	/*if(!f_query_add_mod.document.formPostVariance.doc_no.disabled){
		fields[index] = f_query_add_mod.document.formPostVariance.doc_no;
		fieldNames[index++]	=	"Doc No";
	}*/
	fields[index] = f_query_add_mod.document.formPostVariance.doc_date;
	fieldNames[index++] = getLabel("Common.DocDate.label", "Common");
	/*fields[index] = f_query_add_mod.document.formPostVariance.write_off_reason_code;
	fieldNames[index++]	=	"Write Off Reason";*/
	obj = checkSTFields(fields, fieldNames, messageFrame);
	if (obj != true) {
		//obj.focus();
		return;
	} else {
		validateDocDate(f_query_add_mod.document.formPostVariance.doc_date);
		if (!result) {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + message;
			return;
		}
		var responseText = formApply(f_query_add_mod.document.formPostVariance, ST_CONTROLLER);
		eval(responseText);
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + message;
		if (result) {
			onSuccess();
		}
		f_query_add_mod.FocusFirstElement();
	}
}
function assignBean() {
	bean_id = document.formPostVariance.bean_id.value;
	bean_name = document.formPostVariance.bean_name.value;
	/*xmlDom = new ActiveXObject("Microsoft.XMLDom");
	xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");*/
	var xmlDom = "";
	var xmlHttp = new XMLHttpRequest();
}

// Added by Martin
function validateDocNo(doc_type_code) {
	if (document.formPostVariance.mode.value == MODE_INSERT) {
		if (doc_type_code.value == "") {
			return;
		}
		var arrayObject = new Array();
		arrayObject[0] = doc_type_code;
		assignBean();
		xmlStr = getXMLString(arrayObject);
		xmlDom.loadXML(xmlStr);
		xmlHttp.open("POST", "../../eST/jsp/PostVarianceValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=1", false);
		xmlHttp.send(xmlDom);
		responseText = xmlHttp.responseText;
		eval(responseText);
	}
}
function validateStoreCode(store_code, bin_location_code) {
	if (store_code.value == "") {
		return;
	}
	assignBean();
	var arrayObject = new Array();
	arrayObject[0] = store_code;
	xmlStr = getXMLString(arrayObject);
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "../../eST/jsp/PostVarianceValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&bin_location_code=" + bin_location_code + "&validate=store_code&function_type=2", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
function validateDocDate(doc_date) {
	var arrayObjects = new Array();
	arrayObjects[0] = doc_date;
	if (!(f_query_add_mod.document.formPostVariance.mode.value == MODE_DELETE)) {
		bean_id = f_query_add_mod.document.formPostVariance.bean_id.value;
		bean_name = f_query_add_mod.document.formPostVariance.bean_name.value;
		/*xmlDom = new ActiveXObject("Microsoft.XMLDom");
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");*/
		var xmlDom = "";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr = getXMLString(arrayObjects);
		//xmlDom.loadXML(xmlStr);
		//var xmlString = getXMLString(null);
        var xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/PostVarianceValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=doc_date&function_type=4", false);
		xmlHttp.send(xmlDom);
		responseText = xmlHttp.responseText;
		eval(responseText);
	}
}
function enableDocNo() {
	postVarianceForm = document.formPostVariance;
	postVarianceForm.doc_no.disabled = false;
	postVarianceForm.doc_no.readonly = false;
	postVarianceForm.doc_no.focus();
	postVarianceForm.autono_yn.value = NO;
}
function disableDocNo() {
	postVarianceForm = document.formPostVariance;
	postVarianceForm.doc_no.disabled = true;
	postVarianceForm.doc_no.readonly = true;
	postVarianceForm.doc_no.value = "";
	postVarianceForm.doc_date.focus();
	postVarianceForm.autono_yn.value = YES;
}
function requestDocDateFocus(doc_date_value) {
	f_query_add_mod.document.formPostVariance.doc_date.focus();
}

