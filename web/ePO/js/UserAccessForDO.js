
var function_id = "";
var bean_id = "";
var bean_name = "";
var xmlDoc;
var xmlDom;
var xmlHttp;
var checkArray = new Array();
var obj = null;
function create() {
	f_query_add_mod.location.href = "../../ePO/jsp/UserAccessForDOMain.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
}
function query() {
	f_query_add_mod.location.href = "../../ePO/jsp/UserAccessForDOQueryCriteria.jsp?function_id=" + function_id;
}
function onSuccess() {
	messageFrame.location.href = "../../eCommon/jsp/error.jsp" + "?err_num=" + message;
	f_query_add_mod.UserAccessForDOHeaderFrame.location.reload();
	f_query_add_mod.UserAccessForDOListFrame.location.href = "../../eCommon/html/blank.html";
}
function onSuccess1() {
	/*messageFrame.location.href = "../../eCommon/jsp/error.jsp" + "?err_num=" + message;
	f_query_add_mod.UserAccessForDOHeaderFrame.location.reload();
	f_query_add_mod.UserAccessForDOListFrame.location.reload();*/
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
	} else	if(f_query_add_mod.UserAccessForDOHeaderFrame != undefined) {
				f_query_add_mod.UserAccessForDOHeaderFrame.location.reload();
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
	var formObj = parent.UserAccessForDOHeaderFrame.document.forms[0];
	var errorPage = "../../eCommon/jsp/error.jsp";
	var user_id = formObj.user_id.value;
//	var po_unit_code = formObj.po_unit_name.value;
		
	if (user_id == "") {
		parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("USER_CANNOT_BE_BLANK", "PO");
		return;
	}

	var messageFrame = top.content.messageFrame;
	var fields = new Array(formObj.user_name);
	var names = new Array(getLabel("Common.user.label", "Common"));
	var blankObject = null;
	blankObject = checkPOFields(fields, names, messageFrame, errorPage);
	if (blankObject == true) {
		parent.UserAccessForDOListFrame.location.href = "../../ePO/jsp/UserAccessForDODetail.jsp?user_id=" + user_id + "&mode=" + MODE_MODIFY  ;
		
		
	}
}
function apply() {
	var messageFrame = top.content.messageFrame;
	if(f_query_add_mod.UserAccessForDOHeaderFrame==null)
	{
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	return;
	}
/*	var fields = new Array(f_query_add_mod.UserAccessForDOHeaderFrame.document.Search_form.user_id);
	var names = new Array(getLabel("Common.user.label", "eCommon"));
	var blankObj = null;
	blankObject = checkPOFields(fields, names, messageFrame, errorPage);
	if (blankObject != true) {
	
		return;
	}
*/	
	
	
	if (f_query_add_mod.UserAccessForDOHeaderFrame.Search_form.mode.value == MODE_INSERT) {
		var user_id = f_query_add_mod.UserAccessForDOHeaderFrame.document.forms[0].user_id.value;
		var fields = new Array(f_query_add_mod.UserAccessForDOHeaderFrame.document.forms[0].user_name);
		var names = new Array(getLabel("Common.user.label", "Common"));
		var errorPage = "../../eCommon/jsp/error.jsp";
		var blankObject = null;
		blankObject = checkPOFields(fields, names, messageFrame, errorPage);
		if (blankObject == true) {
			var formObj = f_query_add_mod.UserAccessForDOListFrame.document.UserAccessForStoreListForm;
			if(formObj != undefined){
			responseText = formApply(formObj, PO_CONTROLLER);
			eval(responseText);
			messageFrame.location.href = "../../eCommon/jsp/error.jsp" + "?err_num=" + message;
			if (result) {
				onSuccess();
			}
			}else{
				messageFrame.location.href = "../../eCommon/jsp/error.jsp" + "?err_num=" + getMessage("NO_CHANGES_TO_SAVE", "PO") ; 
				return;
			}
		}
	}
	if (f_query_add_mod.UserAccessForDOHeaderFrame.Search_form.mode.value == MODE_MODIFY) {
		var formObj = f_query_add_mod.UserAccessForDOListFrame.document.UserAccessForStoreListForm;
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
	
	document.location.href = "../../ePO/jsp/UserAccessForDOMain.jsp?mode=" + parent.MODE_MODIFY + "&function_id=" + parent.function_id + "&user_id=" + user_id + "&user_name=" + user_name  ;
}

function delvTranChange(obj_tran){
	
	if(obj_tran.checked){
		document.UserAccessForStoreListForm.do_order_finalize_allowed_yn.disabled = false;
		document.UserAccessForStoreListForm.do_order_cancel_allowed_yn.disabled = false;
		document.UserAccessForStoreListForm.do_order_delete_allowed_yn.disabled = false;
		
	}else{
		document.UserAccessForStoreListForm.do_order_finalize_allowed_yn.disabled = true;
		document.UserAccessForStoreListForm.do_order_cancel_allowed_yn.disabled = true;
		document.UserAccessForStoreListForm.do_order_delete_allowed_yn.disabled = true;
		
		document.UserAccessForStoreListForm.do_order_finalize_allowed_yn.checked = "";
		document.UserAccessForStoreListForm.do_order_cancel_allowed_yn.checked = "";
		document.UserAccessForStoreListForm.do_order_delete_allowed_yn.checked = "";
		
		}
}

function quotTranChange(obj_tran){

	if(obj_tran.checked){
		document.UserAccessForStoreListForm.quot_order_finalize_allowed_yn.disabled = false;
		document.UserAccessForStoreListForm.quot_order_cancel_allowed_yn.disabled = false;
		document.UserAccessForStoreListForm.quot_order_delete_allowed_yn.disabled = false;
		
	}else{
		document.UserAccessForStoreListForm.quot_order_finalize_allowed_yn.disabled = true;
		document.UserAccessForStoreListForm.quot_order_cancel_allowed_yn.disabled = true;
		document.UserAccessForStoreListForm.quot_order_delete_allowed_yn.disabled = true;
		
		document.UserAccessForStoreListForm.quot_order_finalize_allowed_yn.checked = "";
		document.UserAccessForStoreListForm.quot_order_cancel_allowed_yn.checked = "";
		document.UserAccessForStoreListForm.quot_order_delete_allowed_yn.checked = "";
		
	}
} 
