/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function create() {
	f_query_add_mod.location.href = "../../eSS/jsp/SsTransactionRemarksFrame.jsp?function_id=" + function_id + "&mode=" + MODE_INSERT;
}
var xmlDom;
var xmlHttp;
function assignBean(frmObject) {
	bean_id = frmObject.bean_id.value;
	bean_name = frmObject.bean_name.value;
	xmlDom ="";
	xmlHttp = new XMLHttpRequest();
}
function reset() {
	if (f_query_add_mod.SsTransactionRemarksHeaderFrame != null) {
		f_query_add_mod.location.href = "../../eSS/jsp/SsTransactionRemarksFrame.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
	}
}
function apply() {
	var errorPage = "../../eCommon/jsp/error.jsp";
	if(f_query_add_mod.SsTransactionRemarksHeaderFrame==undefined){
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" ;
	return
	}
	var fields = new Array(f_query_add_mod.SsTransactionRemarksHeaderFrame.document.frmSsTransactionRemarksHeader.transaction_type);
	var names = new Array(getLabel("Common.transactiontype.label", "Common"));
	var blankObj = null;
	blankObject = checkSSFields(fields, names, messageFrame, errorPage);
	if (blankObject != true) {
		return;
	}
	var formObj = f_query_add_mod.SsTransactionRemarksDetailFrame.document.frmSsTransactionRemarksDetail;
	
	var checkCount = parseInt(f_query_add_mod.SsTransactionRemarksHeaderFrame.document.frmSsTransactionRemarksHeader.total_count_flag.value) - 14;
	var total_remarks = formObj.total_remarks.value;
	var chkdValue = 0;
	for (count = 0; count < total_remarks; count++) {
		if (count < checkCount) {
			break;
		}
		if ((eval("formObj.highlight_" + count + ".value")) == "Y") {
			if (eval("formObj.remarks_code_" + count + ".checked")) {
				eval("formObj.db_action_" + count).value = "U";
				eval("formObj.eff_status_" + count).value = "E";
			} else {
				eval("formObj.db_action_" + count).value = "U";
				eval("formObj.eff_status_" + count).value = "D";
			}
		} else {
			if ((eval("formObj.highlight_" + count + ".value")) == "") {
				if (eval("formObj.remarks_code_" + count + ".checked")) {
					eval("formObj.db_action_" + count).value = "I";
					eval("formObj.eff_status_" + count).value = "E";
				} else {
					eval("formObj.db_action_" + count).value = "I";
					eval("formObj.eff_status_" + count).value = "D";
				}
			}
		}
	}
	for (count = 0; count < formObj.total_records.value; count++) {
		if (eval("formObj.remarks_code_" + count) == undefined) {
			break;
		}
		if (eval("formObj.remarks_code_" + count) != null && eval("formObj.remarks_code_" + count + ".checked")) {
			chkdValue++;
		}
	}
	formObj.canProcess.value = chkdValue;
	eval(formApply(formObj, SS_CONTROLLER));
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + message;
	if (result) {
		onSuccess();
	}
}
function onSuccess() {
	f_query_add_mod.document.location.reload();
}
function gettotalcheckBoxes(total_records) {
    // Check if total_count_flag is 0, and set it to total_records.value
    if (parseInt(parent.frames[0].document.forms[0].total_count_flag.value) == 0) {
        parent.frames[0].document.forms[0].total_count_flag.value = parseInt(total_records.value);
    } else {
        // Otherwise, increment the total_count_flag by the value of total_records
        parent.frames[0].document.forms[0].total_count_flag.value = parseInt(parent.frames[0].document.forms[0].total_count_flag.value) + parseInt(total_records.value);
    }

    // Define xmlStr (you will need to build the actual XML string here)
    var xmlStr = "<root><item>" + parent.frames[0].document.forms[0].total_count_flag.value + "</item></root>";

    // Create XMLHttpRequest object
    var xmlHttp = new XMLHttpRequest();

    // Parse the XML string into an XML Document object
    var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

    // Send the XML as part of the POST request
    xmlHttp.open("POST", "../../eSS/jsp/SsTransactionRemarksValidate.jsp?&total_records=" + parent.frames[0].document.forms[0].total_count_flag.value + "&function_type=4", false);
    xmlHttp.send(xmlDoc);

    // Get the response text and evaluate it
    var responseText = xmlHttp.responseText;
    eval(responseText);
}

function SubmitLink(from, to) {
	if (document.frmSsTransactionRemarksDetail == null) {
		document.QueryForm.from.value = from;
		document.QueryForm.to.value = to;
		document.QueryForm.submit();
		return;
	}
	var selectedIndices = "";
	var index = 0;
	var total_remarks = document.frmSsTransactionRemarksDetail.total_remarks.value;
	var arrayObject = new Array();
	window.returnValue = false;
	formObj = parent.SsTransactionRemarksDetailFrame.document.frmSsTransactionRemarksDetail;
	formObj = parent.SsTransactionRemarksDetailFrame.document.frmSsTransactionRemarksDetail;
	var count = 0;
	for (var i = 0; i < formObj.elements.length; i++) {
		if ((formObj.elements[i].type == "checkbox") && (formObj.elements[i].name != "selectAll")) {
			alterBean(formObj.elements[i]);
		}
	}
	document.QueryForm.from.value = from;
	document.QueryForm.to.value = to;
	document.QueryForm.submit();
}
function setValue(obj) {
	var transaction_type = obj.value;
	if (obj.value != "") {
		parent.SsTransactionRemarksDetailFrame.document.location.href = "../../eSS/jsp/SsTransactionRemarksDetail.jsp?transaction_type=" + transaction_type + "&mode=" + MODE_INSERT;
	}
}
function changeStatusCheckBox(obj) {
	formObj = parent.SsTransactionRemarksDetailFrame.document.frmSsTransactionRemarksDetail;
	var count = 0;
	for (var i = 0; i < formObj.elements.length; i++) {
		if (formObj.elements[i].type == "checkbox") {
			if (obj.checked) {
				formObj.elements[i].checked = true;
				formObj.elements[i].value = "Y";
				formObj.selectAll.value = "Y";
				count = count + 1;
			} else {
				formObj.elements[i].checked = false;
				formObj.elements[i].value = "N";
				formObj.selectAll.value = "N";
			}
			if (formObj.elements[i].name != "selectAll") {
				alterBean(formObj.elements[i], count - 2);
			}
		}
	}
	formObj.count.value = count - 1;
	if (formObj.selectAll.value == "Y") {
		formObj.checked_yn.value = "Y";
	}
}
function alterBean(obj, index) {
	var name = obj.name;
	var len = obj.name.length;
	var idx = name.substring(8, len);
	var idx = name;
	formObj = parent.SsTransactionRemarksDetailFrame.document.frmSsTransactionRemarksDetail;	

	xmlStr = formXMLString(formObj.start.value, formObj.end.value, formObj.total_remarks.value, formObj);
	formValidation(xmlStr, formObj.start.value, formObj.end.value, formObj.total_remarks.value, obj.checked, idx, index);
}
function formXMLString(start, end, totalRecord, formObj) {
	for (count = start; count < totalRecord; count++) {
		if (eval("formObj.remarks_code_" + count) != null && eval("formObj.remarks_code_" + count + ".checked")) {
			end++;
		}
		if ((eval("formObj.highlight_" + count + ".value")) == "Y") {
			if (eval("formObj.remarks_code_" + count + ".checked")) {
				eval("formObj.db_action_" + count).value = "U";
				eval("formObj.eff_status_" + count).value = "E";
			} else {
				eval("formObj.db_action_" + count).value = "U";
				eval("formObj.eff_status_" + count).value = "D";
			}
		} else {
			if ((eval("formObj.highlight_" + count + ".value")) == "") {
				if (eval("formObj.remarks_code_" + count + ".checked")) {
					eval("formObj.db_action_" + count).value = "I";
					eval("formObj.eff_status_" + count).value = "E";
				} else {
					eval("formObj.db_action_" + count).value = "I";
					eval("formObj.eff_status_" + count).value = "D";
				}
			}
		}
	}
	var xmlStr = "<root><SEARCH ";
	if (parseInt(end) > parseInt(totalRecord)) {
		end = totalRecord;
	}
	for (var i = start; i < end; i++) {
		xmlStr += " EFF_STATUS_" + i + "=\"" + eval("formObj.eff_status_" + i + ".value") + "\" " + " REMARKS_CODE_" + i + "=\"" + eval("formObj.remove_remarks_code_" + i + ".value") + "\" " + " DB_ACTION_" + i + "=\"" + eval("formObj.db_action_" + i + ".value") + "\" ";
	}
	xmlStr += " /></root>";
	return xmlStr;
}
function formValidation(xmlStr, start, end, totalRecords, checked_yn, idx, index) {
	index = "-1";
	var select_all = "";
	if (formObj.checked_yn.value == "Y") {
		select_all = "Y";
	}
	formObj = parent.SsTransactionRemarksDetailFrame.document.frmSsTransactionRemarksDetail;
	assignBean(document.frmSsTransactionRemarksDetail);
	temp_jsp = "../../eSS/jsp/SsTransactionRemarksValidate.jsp?idx=" + idx + "&checked_yn=" + checked_yn + "&totalRecords=" + totalRecords + "&index=" + index + "&select_all=" + select_all + "&function_type=3" + "&bean_id=" + bean_id + "&bean_name=" + bean_name;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", temp_jsp, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	return true;
}
function activeLink() {
	formObj = parent.SsTransactionRemarksDetailFrame.document.frmSsTransactionRemarksDetail;
	if (formObj.start.value != 0) {
		parent.SsTransactionRemarksDetailFrame.document.getElementById("prev").style.visibility = "visible";
	} else {
		parent.SsTransactionRemarksDetailFrame.document.getElementById("prev").style.visibility = "hidden";
	}
	if (!((parseInt(formObj.start.value) + parseInt(formObj.displaySize.value)) >= formObj.total_records.value)) {
		parent.SsTransactionRemarksDetailFrame.document.getElementById("next").style.visibility = "visible";
	} else {
		parent.SsTransactionRemarksDetailFrame.document.getElementById("next").style.visibility = "hidden";
	}
}
function goNext(source_mode) {
	formObj = parent.SsTransactionRemarksDetailFrame.document.frmSsTransactionRemarksDetail;
	start = parseInt(formObj.start.value) + parseInt(formObj.displaySize.value);
	end = parseInt(formObj.end.value) + parseInt(formObj.displaySize.value);
	xmlStr = formXMLString(formObj.start.value, formObj.end.value, formObj.total_remarks.value, formObj);
	formValidation(xmlStr, formObj.start.value, formObj.end.value, formObj.total_remarks.value);
	if (formObj.mode.value == MODE_INSERT) {
		modeVal = MODE_INSERT;
	} else {
		modeVal = MODE_MODIFY;
	}
	if (source_mode == "select") {
		parent.SsTransactionRemarksDetailFrame.location.href = "../../eSS/jsp/SsTransactionRemarksDetail.jsp?mode=" + modeVal + "&from=" + start + "&to=" + end + "&dispMode=fromlink" + "&transaction_type=" + formObj.transaction_type.value;
	}
}
function goPrev(source_mode) {
	formObj = parent.SsTransactionRemarksDetailFrame.document.frmSsTransactionRemarksDetail;
	start = parseInt(formObj.start.value) - parseInt(formObj.displaySize.value);
	end = parseInt(formObj.end.value) - parseInt(formObj.displaySize.value);
	xmlStr = formXMLString(formObj.start.value, formObj.end.value, formObj.total_remarks.value, formObj);
	formValidation(xmlStr, formObj.start.value, formObj.end.value, formObj.total_remarks.value);
	if (formObj.mode.value == MODE_INSERT) {
		modeVal = MODE_INSERT;
	} else {
		modeVal = MODE_MODIFY;
	}
	if (source_mode == "select") {
		parent.SsTransactionRemarksDetailFrame.location.href = "../../eSS/jsp/SsTransactionRemarksDetail.jsp?mode=" + modeVal + "&from=" + start + "&to=" + end + "&dispMode=fromlink" + "&transaction_type=" + formObj.transaction_type.value;
	}
}

