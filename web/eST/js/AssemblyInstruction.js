
function create() {
	f_query_add_mod.location.href = "../../eST/jsp/AddAssemblyInstruction.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
}
function query() {
	f_query_add_mod.location.href = "../../eST/jsp/AssemblyInstructionQueryCriteria.jsp?function_id=" + function_id;
}
function apply() {
	var arrPKFieldNames = new Array();
	arrPKFieldNames[0] = "assm_instrn_code";
	var formObj = f_query_add_mod.document.AssmblyInstrnCodeform;
	if(formObj==undefined){
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" ;
	return
	}
	var errorPage = "../../eCommon/jsp/error.jsp";
	var obj = null;
	if (f_query_add_mod.document.AssmblyInstrnCodeform.mode.value == MODE_MODIFY) {
		var fields = new Array(formObj.assm_instrn_code, formObj.description);
		var names = new Array(getLabel("Common.code.label", "Common"), getLabel("Common.description.label", "Common"));
		var blankObject = null;
		blankObject = checkSTFields(fields, names, messageFrame, errorPage);
		if (blankObject == true) {
			var responseText = formApply(formObj, ST_CONTROLLER);
			eval(responseText);
			messageFrame.location.href = errorPage + "?err_num=" + message;
			if (result) {
				onSuccess();
			}
		} else {
			return;
		}
	}
	if (formObj.mode.value == MODE_INSERT) {
		var arrFieldName = new Array();
		var arrLegends = new Array();
		var arrPKFieldNames = new Array();
		var invalidCode = "";
		arrFieldName[0] = "assm_instrn_code";
		arrFieldName[1] = "description";
		arrLegends[0] = getLabel("Common.code.label", "Common");
		arrLegends[1] = getLabel("Common.description.label", "Common");
		arrPKFieldNames[0] = "assm_instrn_code";
		var validateResult = validateBatchFields(formObj, arrFieldName, arrLegends, arrPKFieldNames);
		if (validateResult) {
			eval(formApply(formObj, ST_CONTROLLER));
			if (result) {
				onSuccess();
			}
			if (invalidCode != "null" && invalidCode != "") {
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + message + ":-" + invalidCode;
				showDuplicates(formObj, arrPKFieldNames, invalidCode, "0", messageFrame);
			} else {
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + message;
			}
		}
	}
}
function reset() {
	if (f_query_add_mod.document.AssmblyInstrnCodeform != null && f_query_add_mod.document.AssmblyInstrnCodeform.mode.value == 2) {
	//f_query_add_mod.document.AssmblyInstrnCodeform.reset();
	//	f_query_add_mod.location.reload();
	f_query_add_mod.document.location.href = "../../eST/jsp/AssemblyInstructionModify.jsp?mode=" + MODE_MODIFY +  "&assm_instrn_code=" + f_query_add_mod.document.AssmblyInstrnCodeform.assm_instrn_code.value+"&function_id=" + parent.function_id ;
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" ;

	}
	if (f_query_add_mod.document.AssmblyInstrnCodeform != null && f_query_add_mod.document.AssmblyInstrnCodeform.mode.value == 1) {
		f_query_add_mod.location.reload();
	}
	if (f_query_add_mod.document.query_form != null) {
		f_query_add_mod.document.query_form.reset();
	}
}
function onSuccess() {
	var mode = f_query_add_mod.document.AssmblyInstrnCodeform.mode.value;
	if (mode == MODE_INSERT) {
		reset();
	}
}
function Modify(obj) {
	var assm_instrn_code = obj.cells[0].innerText;
	var assm_instrn_desc = obj.cells[1].innerText;
	var eff_status = obj.cells[2].innerText;
	document.location.href = "../../eST/jsp/AssemblyInstructionModify.jsp?mode=" + MODE_MODIFY + "&function_id=" + parent.function_id + "&assm_instrn_code=" + assm_instrn_code + "&assm_instrn_desc=" + assm_instrn_desc + "&eff_status=" + eff_status;
}
function changestatus(obj) {
	if (obj.checked == true) {
		obj.value = "E";
	} else {
		obj.value = "D";
	}
}
function resetColorCode(obj) {
	var arrPKFieldNames = new Array();
	var formObj = f_query_add_mod.document.AssmblyInstrnCodeform;
	arrPKFieldNames[0] = "assm_instrn_code";
	resetDuplicateClass(formObj, arrPKFieldNames, 0, obj);
}
function validateBatchFields(formObj, arrFieldName, arrLegends, arrPKFieldNames, startIndex, objMessageFrame, errorPage) {
	if (startIndex == null) {
		startIndex = 0;
	}
	if (objMessageFrame == null) {
		objMessageFrame = messageFrame;
	} else {
		messageFrame = objMessageFrame;
	}
	if (errorPage == null) {
		errorPage = "../../eCommon/jsp/error.jsp";
	}
	var fields = new Array();
	var names = new Array();
	var masterCodes = new Array();
	var arrPKFields = null;
	var notNullIndex = 0;
	var currRowIndex = 0;
	var masterIndex = 0;
	var pkIndex = 0;
	var uniqueFields = "";
	var totalRecords = formObj.totalRecords.value;
	var totalColumns = arrFieldName.length;
	var totalPKColumns = arrPKFieldNames.length;
	totalRecords = parseFloat(totalRecords) + parseFloat(startIndex);
	/**
      * Identify the rows and respective columns in the form, which has some values entered.
      */
	for (var rowIndex = startIndex; rowIndex < totalRecords; rowIndex++) {
		var isNotNull = false;
		for (var colIndex = 0; colIndex < totalColumns; colIndex++) {
			current_field = eval("formObj." + arrFieldName[colIndex] + rowIndex);
			if (trimString(current_field.value) != "") {
				isNotNull = true;
				break;
			}
		}
		if (isNotNull) {
			currRowIndex = rowIndex + 1;
			arrPKFields = new Array();
			pkIndex = 0;
			for (var colIndex = 0; colIndex < totalColumns; colIndex++) {
				current_field = eval("formObj." + arrFieldName[colIndex] + rowIndex);
				if ((uniqueFields.indexOf(arrFieldName[colIndex]) == -1) && (trimString(current_field.value) == "")) {
					if (colIndex < 3) {
						fields[notNullIndex] = current_field;
						names[notNullIndex++] = arrLegends[colIndex]; // + " #" + currRowIndex; //" %23" + currRowIndex;
						uniqueFields += current_field.name + " ";
					}
					}
				if (colIndex < totalPKColumns) {
					pk_field = eval("formObj." + arrPKFieldNames[colIndex] + rowIndex);
					if (current_field.name == pk_field.name) {
						arrPKFields[pkIndex++] = pk_field;
					}
				}
			}
			masterCodes[masterIndex++] = arrPKFields;
		}
	}
	/**
      * If there are no values entered, the length will be zero, so alert and return.
      */
	if (masterCodes.length == 0) {
		var error_msg = getMessage("ATLEAST_ONE_RECORD_ENTERED", "Common");
		showErrorMessage(error_msg, objMessageFrame, "", "", errorPage);
		formObj.document.parentWindow.FocusFirstElement();
		return false;
	}
	/**
      * Check for the duplicating primary key columns by calling the returnDuplicates function.
      */
	var arrDuplicate = returnDuplicates(masterCodes);
	/**
      * The first index of the array will contain duplicating primary keys seperated by a delimiter ", ".
      */
	var duplicateCodes = arrDuplicate[0];
	/**
      * The second index of the array will contain duplicating primary key fields as an Array.
      */
	var duplicateField = arrDuplicate[1];
	/**
      * The third index of the array will contain duplicating primary key fields description
      * seperated by the delimeter ", " in the case of a input type is a select item.
      */
	var duplicateCodesValue = arrDuplicate[2];
	if (duplicateCodesValue == null) {
		duplicateCodesValue = "";
	}

	var inputType = "text";
	var duplicateValue = "";
	/**
      * Check for the duplicate primary key fields and if any, display the error message and
      * mark the first duplicating primary key fields using the css class "DUPLICATE".
      */
	if (duplicateCodes != "") {
		var duplicateCode = "";
		var firstIndex = duplicateCodes.indexOf(",");
		if (firstIndex == -1) {
			firstIndex = duplicateCodes.length;
		}
		var firstDuplicate = duplicateCodes.substring(0, firstIndex);
		var startingIndex = 0;
		for (var i = 0; i < duplicateField.length; i++) {
			duplicatePKFields = duplicateField[i];
			for (var pkIndex = 0; pkIndex < duplicatePKFields.length; pkIndex++) {
				if ((pkIndex % totalPKColumns) < totalPKColumns) {
					duplicateCode += duplicatePKFields[pkIndex].value + ":";
				}
				if ((pkIndex % totalPKColumns) == (totalPKColumns - 1)) {
					duplicateCode = duplicateCode.substring(0, duplicateCode.length - 1);
					if (firstDuplicate == duplicateCode) {
						for (var j = startingIndex; j <= pkIndex; j++) {
							if ((pkIndex - startingIndex) <= totalPKColumns) {
								duplicatePKFields[j].className = "DUPLICATE";
							}
						}
						startingIndex = pkIndex;
					}
					duplicateCode = "";
				}
			}
		}
		duplicatePKFields = duplicateField[0];
		if (duplicatePKFields[0].type == "select-one") {
			inputType = "select-one";
		}
		var error_msg = getMessage("DUPLICATE_CODE_EXISTS", "Common") + " : ";
		if (inputType == "text") {
			error_msg += duplicateCodes;
		} else {
			if (inputType == "select-one") {
				error_msg += duplicateCodesValue;
			}
		}
		displayErrorMessage(error_msg, objMessageFrame, "", null, errorPage);
		if (inputType != "select-one") {
			duplicatePKFields[0].select();
		}
		duplicatePKFields[0].focus();
		return false;
	}
	/**
      * Check for the mandatory fields, if anything is left out.
      * if anything left out, display the error message and return "false"
      * otherwise, return "true" to indicate the operation is success.
      */
	var firstNullObject = checkSTMandatoryFields(fields, names, objMessageFrame, errorPage);
	if (firstNullObject != null) {
		firstNullObject.className = "DUPLICATE";
		firstNullObject.focus();
		return false;
	} else {
		return true;
	}
}

