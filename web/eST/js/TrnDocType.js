
function create() {
	f_query_add_mod.location.href = "../../eST/jsp/TrnDocTypeAdd.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
}
function query() {
	f_query_add_mod.location.href = "../../eST/jsp/TrnDocTypeQueryCriteria.jsp?function_id=" + function_id;
}
function onSuccess() {
	var formObj = f_query_add_mod.document.formTrnDocType;
	if (formObj.mode.value == MODE_INSERT) {
		reset();
	} else {
		f_query_add_mod.location.reload();
	}
}
function reset() {
	if (f_query_add_mod.document.formTrnDocType != null) {
		f_query_add_mod.document.formTrnDocType.reset();
	}
	if (f_query_add_mod.document.query_form != null) {
		f_query_add_mod.document.query_form.reset();
	}
}
function apply() {
	var formObj = f_query_add_mod.document.formTrnDocType;
	var errorPage = "../../eCommon/jsp/error.jsp";
	if (formObj.mode.value == MODE_INSERT) {
		var arrFieldName = new Array();
		var arrLegends = new Array();
		var arrPKFieldNames = new Array();
		arrFieldName[0] = "doc_type_code_";
		arrFieldName[1] = "trn_type_";
		arrLegends[0] = getLabel("Common.DocType.label", "Common");
		arrLegends[1] = getLabel("Common.transactiontype.label", "Common");
		arrPKFieldNames[0] = "doc_type_code_";
		resetDuplicateClass(formObj, arrPKFieldNames);
		var validateResult = validateSTMandatoryFields(formObj, arrFieldName, arrLegends, arrPKFieldNames, null, messageFrame, errorPage);
		if (validateResult) {
			eval(formApply(formObj, ST_CONTROLLER));
			//messageFrame.location.href = errorPage+"?err_num="+ message;
			if (result) {
				onSuccess();
			}
			if (invalidCode != "null" && invalidCode != "") {
				//errorPage = errorPage + "?err_num="+ message+":-"+invalidCode;
				showDuplicates(formObj, arrPKFieldNames, invalidCode, "0", messageFrame, errorPage);
				return;
			} else {
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + message;
			}
		}
	} else {
		eval(formApply(formObj, ST_CONTROLLER));
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + message;
		if (result) {
			onSuccess();
		}
	}
}
function Modify(obj) {
	var doc_type_code = obj.cells[0].innerText;
	document.location.href = "../../eST/jsp/TrnDocTypeModify.jsp?mode=" + MODE_MODIFY + "&function_id=" + parent.function_id + "&doc_type_code=" + doc_type_code;
}
function resetColorCode(obj) {
	var arrPKFieldNames = new Array();
	var formObj = parent.f_query_add_mod.document.formTrnDocType;
	arrPKFieldNames[0] = "doc_type_code_";
	arrPKFieldNames[1] = "trn_type_";
	resetDuplicateClass(formObj, arrPKFieldNames, 0, obj);
}
function enablePHListBox(index, bValue) {
	var obj = eval("document.formTrnDocType.applicable_to_ph_" + index);
	if (!bValue) {
		obj.checked = bValue;
	}
	obj.disabled = !bValue;
}
function checkPHListBox(obj, index) {

	if(obj.value=="PRQ"||obj.value=="SPB"||obj.value=="CBL"){
	 eval("document.formTrnDocType.print_alert_reqd_yn_" + index).disabled=true;
	 eval("document.formTrnDocType.print_alert_reqd_yn_" + index).checked=false;
	 eval("document.formTrnDocType.print_alert_reqd_yn_" + index).value="N";
	}
	else{
	 eval("document.formTrnDocType.print_alert_reqd_yn_" + index).disabled=false;
	}

	if (document.formTrnDocType.PHInstalled.value == "false") {
		return;
	}
	var chkObj = eval("document.formTrnDocType.applicable_to_ph_yn_" + index);
	chkObj.disabled = !(obj.value == "SAL" || obj.value == "SRT" || obj.value == "MFG");
	if (chkObj.disabled) {
		chkObj.checked = !chkObj.disabled;
	}
}
function printreqd(obj) {
	if (obj.checked) {
		obj.value = "Y";
	} else {
		obj.value = "N";
	}
}

