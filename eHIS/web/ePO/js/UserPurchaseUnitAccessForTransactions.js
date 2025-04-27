
var function_id = "";
var bean_id = "";
var bean_name = "";
var xmlDoc;
var xmlDom;
var xmlHttp;
var checkArray = new Array();
var obj = null;
function create() {
	f_query_add_mod.location.href = "../../ePO/jsp/UserPurchaseUnitAccessForTransactionsMain.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
}
function query() {
	f_query_add_mod.location.href = "../../ePO/jsp/UserPurchaseUnitAccessForTransactionsQueryCriteria.jsp?function_id=" + function_id;
}
function onSuccess() {
	messageFrame.location.href = "../../eCommon/jsp/error.jsp" + "?err_num=" + message;
	f_query_add_mod.UserForPuUnitHeaderFrame.location.reload();
	f_query_add_mod.UserForPuUnitListFrame.location.href = "../../eCommon/html/blank.html";
}
function onSuccess1() {
	/*messageFrame.location.href = "../../eCommon/jsp/error.jsp" + "?err_num=" + message;
	f_query_add_mod.UserForPuUnitHeaderFrame.location.reload();
	f_query_add_mod.UserForPuUnitListFrame.location.reload();*/
	create() ;
}
function enablestorelist() {

	var formObj = document.Search_form;
	if(formObj.user_store_access_appl.checked == true){
		formObj.user_store_access_list_name.disabled = false;
	}
	else {
		formObj.user_store_access_list_name.disabled = true;
	}
}

function reset() {

if (f_query_add_mod.document.query_form != null) {
		f_query_add_mod.document.query_form.reset();
	} else	if(f_query_add_mod.UserForPuUnitHeaderFrame != undefined) {
				f_query_add_mod.UserForPuUnitHeaderFrame.location.reload();
				f_query_add_mod.location.reload();
	}
	
	
	
}
function clearDetails() {
	if(f_query_add_mod.UserForStoreListFrame != undefined || f_query_add_mod.UserForStoreListFrame != null)
		f_query_add_mod.UserForStoreListFrame.location.href = "../../eCommon/html/blank.html";
}
function searchCode(target) {
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var sql = document.forms[0].SQL_ST_USER_LOOKUP_USERACCESS.value + "'" + document.forms[0].language_id.value + "'";
	if (target.name == "user_name") {
	//	argumentArray[0]							=		document.forms[0].SQL_ST_USER_LOOKUP_USERACCESS.value
		argumentArray[0] = sql;
		argumentArray[4] = "1,2"; 
//		argumentArray[4]							=		"2,3"; 
	}
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	if (target.name == "user_name") {
		if (!document.forms[0].user_name.readOnly) {
			retVal = CommonLookup(getLabel("Common.user.label", "Common"), argumentArray);
		} else {
			retVal = "";
		}
	}
	if (retVal != null && retVal != "") {
		target.value = retVal[1];
		if (target.name == "user_name") {
			document.forms[0].user_id.value = retVal[0];
			document.forms[0].userIdSearch.disabled = true;
			document.forms[0].user_name.readOnly = true;
		}
	}
}
function searchDetails() {
	top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	var formObj = parent.UserForPuUnitHeaderFrame.document.forms[0];
	var errorPage = "../../eCommon/jsp/error.jsp";
	var user_id = formObj.user_id.value;
	var po_unit_code = formObj.po_unit_name.value;
	
	if (user_id == "") {
		parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("USER_CANNOT_BE_BLANK", "PO");
		return;
	}
	if (po_unit_code == "") {
		parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("PUR_UNIT_CANNOT_BE_BLANK", "PO");
		return;
	}
	var messageFrame = top.content.messageFrame;
	var fields = new Array(formObj.user_name, formObj.po_unit_name);
	var names = new Array(getLabel("Common.user.label", "Common"), getLabel("ePO.PurchaseUnit.label", "PO"));
	var blankObject = null;
	blankObject = checkPOFields(fields, names, messageFrame, errorPage);
	if (blankObject == true) {
		parent.UserForPuUnitListFrame.location.href = "../../ePO/jsp/UserPurchaseUnitAccessForTransactionsDetail.jsp?user_id=" + user_id + "&po_unit_code=" + po_unit_code + "&mode=" + MODE_MODIFY  ;
		
		
	}
}
function apply() {
	var messageFrame = top.content.messageFrame;
	if(f_query_add_mod.UserForPuUnitHeaderFrame==undefined)
	{
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	return;
	}
/*	var fields = new Array(f_query_add_mod.UserForPuUnitHeaderFrame.document.Search_form.user_id,f_query_add_mod.UserForPuUnitHeaderFrame.document.Search_form.po_unit_name);
	var names = new Array(getLabel("Common.user.label", "eCommon"),getLabel("eST.PurchaseUnit.label", "ST"));
	var blankObj = null;
	blankObject = checkPOFields(fields, names, messageFrame, errorPage);
	if (blankObject != true) {
	
		return;
	}
*/	
	if (f_query_add_mod.UserForPuUnitHeaderFrame.Search_form.mode.value == MODE_INSERT) {
		var user_id = f_query_add_mod.UserForPuUnitHeaderFrame.document.forms[0].user_id.value;
		var po_unit_code = f_query_add_mod.UserForPuUnitHeaderFrame.document.forms[0].po_unit_name.value;
		var fields = new Array(f_query_add_mod.UserForPuUnitHeaderFrame.document.forms[0].user_name, f_query_add_mod.UserForPuUnitHeaderFrame.document.forms[0].po_unit_name);
		var names = new Array(getLabel("Common.user.label", "Common"), getLabel("ePO.PurchaseUnit.label", "PO"));
		var errorPage = "../../eCommon/jsp/error.jsp";
		var blankObject = null;
		blankObject = checkPOFields(fields, names, messageFrame, errorPage);
		if (blankObject == true) {
			var formObj = f_query_add_mod.UserForPuUnitListFrame.document.UserAccessForStoreListForm;
			if(formObj != undefined){
			responseText = formApply(formObj, PO_CONTROLLER);
			eval(responseText);
			messageFrame.location.href = "../../eCommon/jsp/error.jsp" + "?err_num=" + message;
			if (result) {
				onSuccess();
			}
			}else{
				messageFrame.location.href = "../../eCommon/jsp/error.jsp" + "?err_num=" + getMessage("NO_CHANGES_TO_SAVE", "PO");
				return;
			}
		}
	}
	if (f_query_add_mod.UserForPuUnitHeaderFrame.Search_form.mode.value == MODE_MODIFY) {
		var formObj = f_query_add_mod.UserForPuUnitListFrame.document.UserAccessForStoreListForm;
		responseText = formApply(formObj, PO_CONTROLLER);
		eval(responseText);
		messageFrame.location.href = "../../eCommon/jsp/error.jsp" + "?err_num=" + message;
		if (result) {
			onSuccess1();
		}
	}
}
function Modify(obj) {
	var user_id = obj.cells[0].innerText;
	var user_name = obj.cells[1].innerText;
	var po_unit_code = obj.cells[2].innerText;
	var po_unit_desc = escape(obj.cells[3].innerText);
	var user_store_access_appl = obj.cells[4].innerText;
	var user_store_access_list = obj.cells[5].innerText;
	document.location.href = "../../ePO/jsp/UserPurchaseUnitAccessForTransactionsMain.jsp?mode=" + parent.MODE_MODIFY + "&function_id=" + parent.function_id + "&user_id=" + user_id + "&user_name=" + user_name + "&po_unit_code=" + po_unit_code + "&po_unit_desc=" + po_unit_desc + "&user_store_access_appl=" + user_store_access_appl + "&user_store_access_list=" + user_store_access_list ;
}


function poTranChange(obj_tran){
	
	if(obj_tran.checked){
		document.UserAccessForStoreListForm.pur_order_finalize_allowed_yn.disabled = false;
		document.UserAccessForStoreListForm.pur_order_amend_allowed_yn.disabled = false;
		document.UserAccessForStoreListForm.pur_order_cancel_allowed_yn.disabled = false;
		document.UserAccessForStoreListForm.pur_order_delete_allowed_yn.disabled = false;
	}else{
		document.UserAccessForStoreListForm.pur_order_finalize_allowed_yn.disabled = true;
		document.UserAccessForStoreListForm.pur_order_amend_allowed_yn.disabled = true;
		document.UserAccessForStoreListForm.pur_order_cancel_allowed_yn.disabled = true;
		document.UserAccessForStoreListForm.pur_order_delete_allowed_yn.disabled = true;
		document.UserAccessForStoreListForm.pur_order_finalize_allowed_yn.checked = "";
		document.UserAccessForStoreListForm.pur_order_amend_allowed_yn.checked = "";
		document.UserAccessForStoreListForm.pur_order_cancel_allowed_yn.checked = "";
		document.UserAccessForStoreListForm.pur_order_delete_allowed_yn.checked = "";
		}
}

function prTranChange(obj_tran){

	if(obj_tran.checked){
		document.UserAccessForStoreListForm.pur_req_finalize_allowed_yn.disabled = false;
		document.UserAccessForStoreListForm.pur_req_cancel_allowed_yn.disabled = false;
		document.UserAccessForStoreListForm.pur_req_delete_allowed_yn.disabled = false;
		document.UserAccessForStoreListForm.user_store_access_list.disabled = false;
	}else{
		document.UserAccessForStoreListForm.pur_req_finalize_allowed_yn.disabled = true;
		document.UserAccessForStoreListForm.pur_req_cancel_allowed_yn.disabled = true;
		document.UserAccessForStoreListForm.pur_req_delete_allowed_yn.disabled = true;
		document.UserAccessForStoreListForm.user_store_access_list.disabled = true;
		document.UserAccessForStoreListForm.pur_req_finalize_allowed_yn.checked = "";
		document.UserAccessForStoreListForm.pur_req_cancel_allowed_yn.checked = "";
		document.UserAccessForStoreListForm.pur_req_delete_allowed_yn.checked = "";
		document.UserAccessForStoreListForm.user_store_access_list.value = "";
		document.UserAccessForStoreListForm.user_store_access_appl.value = "N";
	}
}
//Added by Rabbani #inc no:30078(Bru-HIMS-CRF-119) on 27-MAY-2013
function poTndrChange(obj_tran){
	
	if(obj_tran.checked){
		document.UserAccessForStoreListForm.tndr_finalize_allowed_yn.disabled = false;
		document.UserAccessForStoreListForm.tndr_cancel_allowed_yn.disabled = false;
		document.UserAccessForStoreListForm.tndr_delete_allowed_yn.disabled = false;
	}else{
		document.UserAccessForStoreListForm.tndr_finalize_allowed_yn.disabled = true;
		document.UserAccessForStoreListForm.tndr_cancel_allowed_yn.disabled = true;
		document.UserAccessForStoreListForm.tndr_delete_allowed_yn.disabled = true;
		document.UserAccessForStoreListForm.tndr_finalize_allowed_yn.checked = "";
		document.UserAccessForStoreListForm.tndr_cancel_allowed_yn.checked = "";
		document.UserAccessForStoreListForm.tndr_delete_allowed_yn.checked = "";
		}
}
