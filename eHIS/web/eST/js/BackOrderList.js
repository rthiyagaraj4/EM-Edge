 function reset() {
	f_query_add_mod.formRequestStatusQueryCriteria.reset();
}
function populateReqByStores(request_type){
    var arrayObject = new Array();
    arrayObject[0] = request_type;
    var frmObject = document.forms[0];
    bean_id = frmObject.bean_id.value;
    bean_name = frmObject.bean_name.value;
    xmlDom = "";
    xmlHttp = new XMLHttpRequest();
    xmlStr = getXMLString(arrayObject);
    xmlHttp.open("POST", "../../eST/jsp/RequestStatusValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&request_type=" + request_type.value + "&function_type=3", false);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(getXMLString(arrayObject));
    responseText = xmlHttp.responseText;
    eval(responseText); 
}
/*
function populateReqByStores(request_type){
	var arrayObject = new Array();
	arrayObject[0] = request_type;
	var frmObject = document.forms[0];
	bean_id = frmObject.bean_id.value;
	bean_name = frmObject.bean_name.value;
	xmlDom = "";
	xmlHttp = new XMLHttpRequest();
	xmlStr = getXMLString(arrayObject);
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "../../eST/jsp/RequestStatusValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&request_type=" + request_type.value + "&function_type=3", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
}*/

function populateToStoresInQuery(request_by_store) {
	if (request_by_store.value == "") {
		clearListItems("document.forms[0].request_on_store");
		return;
	}
	var arrayObject = new Array();
	arrayObject[0] = request_by_store;
	var frmObject = document.forms[0];
	bean_id = frmObject.bean_id.value;
	bean_name = frmObject.bean_name.value;
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr = getXMLString(arrayObject);
	  xmlDom.loadXML(xmlStr );
	xmlHttp.open("POST", "../../eST/jsp/RequestStatusValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&request_by_store=" + request_by_store.value + "&&function_type=1", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
function populateItemClasses(request_by_store, request_on_store) {
    var arrayObject = new Array();
    arrayObject[0] = request_by_store;
    arrayObject[1] = request_on_store;
    assignBean(document.forms[0]);
    xmlStr = getXMLString(arrayObject);
    xmlHttp.open("POST", "../../eST/jsp/RequestStatusValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +"&request_by_store=" + request_by_store.value + "&request_on_store=" + request_on_store.value + "&function_type=2", false);
    xmlHttp.send(xmlStr);
    responseText = xmlHttp.responseText;
    eval(responseText);
}
/*
function populateItemClasses(request_by_store, request_on_store) {
	var arrayObject = new Array();
	arrayObject[0] = request_by_store;
	arrayObject[1] = request_on_store;
	assignBean(document.forms[0]);
	xmlStr = getXMLString(arrayObject);
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "../../eST/jsp/RequestStatusValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +"&request_by_store="+request_by_store.value+"&request_on_store="+request_on_store.value+ "&function_type=2", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
}*/

function assignBean(frmObject) {
    bean_id = frmObject.bean_id.value;
    bean_name = frmObject.bean_name.value;
    xmlDom = new DOMParser().parseFromString("", "application/xml");
    xmlHttp = new XMLHttpRequest();
}

/*
function assignBean(frmObject) {
	bean_id = frmObject.bean_id.value;
	bean_name = frmObject.bean_name.value;
	xmlDom = new ActiveXObject("Microsoft.XMLDom");
	xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
}*/

async function searchItemCode(objCode) {
	var search_string = "";
	//search_string = document.forms[0].item_desc.value;
	search_string = document.forms[0].item_code.value;
	var store_code = document.forms[0].request_by_store.value;
	var category = "A";
	var sole_source = "A";
	var ps_item = "A";
	var mfg_item = "A";
	var expiry = "A";
	var consignment = "A";
	var item_class = document.forms[0].item_class_code.value;
	var retVal = await callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment);
	if (retVal != null) {
		document.formRequestStatusQueryCriteria.item_code.value = retVal[0];
		//document.formRequestStatusQueryCriteria.item_desc.value = retVal[1];
	}
}


function run() {
	formObj = f_query_add_mod.document.formRequestStatusQueryCriteria;
	var currentdate=getCurrentDate("DMY",formObj.p_language_id.value);
	var localename=formObj.p_language_id.value;
	if(formObj.from_doc_date.value!=""){
		if(!isBefore(formObj.from_doc_date.value, currentdate, "DMY", localename)){
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("ST_DOC_DT_NOT_GR_SYSDATE","ST");
			formObj.from_doc_date.select();
			formObj.from_doc_date.focus();
			return;
		}
	}
	if(formObj.to_doc_date.value!=""){
		if(!isBefore(formObj.to_doc_date.value, currentdate, "DMY", localename)){
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("ST_DOC_DT_NOT_GR_SYSDATE","ST");
			formObj.to_doc_date.select();
			formObj.to_doc_date.focus();
			return;
		}
	}
	if (doDateCheck(formObj.from_doc_date, formObj.to_doc_date, messageFrame)) {
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
		f_query_add_mod.document.forms[0].target="messageFrame"
		formObj.submit();
	}
}
