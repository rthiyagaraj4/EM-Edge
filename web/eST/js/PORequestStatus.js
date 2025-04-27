 var prevObj = null;
var prevColor = null;
function reset() {
f_query_add_mod.criteria.document.formPORequestStatusQueryCriteria.reset();
f_query_add_mod.frames[1].location.href = '../../eCommon/html/blank.html';
}




function populateToStoresInQuery(request_by_store) {
	if (request_by_store.value == "") {
		clearListItems("document.forms[0].request_on_department");
		return;
	}
parent.frames[1].location.href = "../../eCommon/html/blank.html" ;
	var arrayObject = new Array();
	arrayObject[0] = request_by_store;
	var frmObject = parent.frames[0].document.forms[0];
	bean_id = frmObject.bean_id.value;
	bean_name = frmObject.bean_name.value;
	xmlDom = "";
	var xmlHttp = new XMLHttpRequest();
//	xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	xmlStr = getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/PORequestStatusValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&request_by_store=" + request_by_store.value + "&&Validate=GETDEPARTMENT", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	return responseText;
}

function populateItemClasses(request_by_store, request_on_department) {
	/**
			* @Name - Priya
			* @Date - 29/01/2010
			* @Inc# - IN018492
			* @Desc - As Item Classes have to be populated based on the selected store & not based on the department, the if condition has been modified
			*/
	if (request_by_store.value == "") {
		clearListItems("document.forms[0].item_class_code");
		return;
	}
	var xmlHttp = new XMLHttpRequest();
	var arrayObject = new Array();
	arrayObject[0] = request_by_store;
	arrayObject[1] = request_on_department;
	assignBean(parent.frames[0].document.forms[0]);
	xmlStr = getXMLString(arrayObject);
//	xmlDom.loadXML(xmlStr);
    xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/PORequestStatusValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&Validate=GETITEMCLASSES", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	return responseText;
}

async function searchItemCode(objCode) {
	var search_string = "";
	search_string = document.formPORequestStatusQueryCriteria.item_code.value;
	var store_code = "";
	var category = "A";
	var sole_source = "A";
	var ps_item = "A";
	var mfg_item = "A";
	var expiry = "A";
	var consignment = "A";
	var item_class = "";
	var retVal = await callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment);
	if (retVal != null) {
		document.formPORequestStatusQueryCriteria.item_code.value = retVal[0];
	}
}
function searchPORequestResults() {
	/**
	* @Name - Priya
	* @Date - 29/01/2010
	* @Inc# - IN018492
	* @Desc - To check whether From date is less than or equal to to date & display the correct error message
	*/
	var messageFrame=parent.parent.messageFrame;
	var formObj = parent.parent.f_query_add_mod.frames[0].document.forms[0]; 		
	if (isValidFromToField(formObj.from_doc_date, formObj.to_doc_date, DATE, getLabel("Common.date.label", "Common"), messageFrame)) {
		formObj.action = "../../eST/jsp/PORequestStatusQueryResult.jsp";
		formObj.method = "post" ;
		formObj.target = "result";
		formObj.submit();
		messageFrame.location.href="../../eCommon/jsp/error.jsp?error_value=0&err_num=";
	}else{
		parent.parent.f_query_add_mod.frames[1].location.href="../../eCommon/html/blank.html";
	}
}


function assignBean(frmObject) {
	bean_id = frmObject.bean_id.value;
	bean_name = frmObject.bean_name.value;
	//xmlDom = new ActiveXObject("Microsoft.XMLDom");
//	xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    xmlDom = "";
	var xmlHttp = new XMLHttpRequest();
}


async function displayPending(trObj) {
	var doc_no = trObj.cells[1].innerText;
	var doc_type_code = trObj.cells[8].innerText;
	var doc_type_desc = trObj.cells[0].innerText;
	changeColor(trObj, 7);
	retVal = await window.showModalDialog("../../eST/jsp/PORequestStatusFrameList.jsp?function_id=" + parent.parent.function_id + "&doc_type_code=" + doc_type_code + "&doc_no=" + doc_no + "&doc_type_desc=" + doc_type_desc, "", "dialogHeight:55vh; dialogWidth:65vw; center:0; status: no; dialogLeft :75; dialogTop :250;");
	retainColor(trObj, 7);
}

function changeColor(obj, n) {
	prevColor = obj.cells[0].className;
	for (k = 0; k < n; k++) {
		obj.cells[k].className = "STLIGHTPINK";
	}
}
function retainColor(obj, n) {
	for (k = 0; k < n; k++) {
		obj.cells[k].className = prevColor;
	}
}
function changeRowColor(obj, n) {
	if (prevObj != null) {
		for (k = 0; k < n; k++) {
			prevObj.cells[k].className = prevColor;
		}
	}
	prevObj = obj;
	prevColor = obj.cells(0).className;
	for (k = 0; k < n; k++) {
		obj.cells[k].className = "STLIGHTPINK";
	}
}



async function displayAuditInfo(trObj) {
	var added_by_name			=	trObj.cells[12].innerText;
	var modified_by_name		=	trObj.cells[13].innerText;
	var modified_date			=	trObj.cells[11].innerText;
	var request_status			=	trObj.cells[6].innerText;
	var doc_no					=	trObj.cells[1].innerText;
	var doc_type_desc			=	trObj.cells[0].innerText;
	
	changeColor(trObj, 7);

	retVal						= await	window.showModalDialog("../../eST/jsp/PORequestStatusAuditInfo.jsp?function_id=" + parent.parent.function_id + "&added_by_id=" + added_by_name + "&modified_by_id=" + modified_by_name + "&modified_date=" + modified_date + "&request_status=" + request_status + "&doc_no=" + doc_no + "&doc_type_desc=" + doc_type_desc, "", "dialogHeight:10vh; dialogWidth:20vw; center:1; status: no; dialogLeft :475; dialogTop :250;scroll:no");
	retainColor(trObj, 7);
}




