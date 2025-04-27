
function create() {
	f_query_add_mod.location.href = "../../eST/jsp/DisposableAdjustmentAddMultiple.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
}
function query() {
	f_query_add_mod.location.href = "../../eST/jsp/DisposableAdjustmentQueryCriteria.jsp?mode=" + MODE_MODIFY + "&function_id=" + function_id;
}
function apply() {
	var arrPKFieldNames = new Array();
	arrPKFieldNames[0] = "store_code_";  
	arrPKFieldNames[1] = "batch_series_";  
	arrPKFieldNames[2] = "batch_id_"; 
	var formObj = f_query_add_mod.document.formDisposableAdjustment;
	var errorPage = "../../eCommon/jsp/error.jsp";
	var obj = null;
if(f_query_add_mod.document.formDisposableAdjustment==undefined){
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" ;
	return
	}
	if (f_query_add_mod.document.formDisposableAdjustment.mode.value == MODE_MODIFY) {
	
		var fields = new Array(formObj.store_code_0, formObj.batch_series_0,formObj.batch_id_0);
		
		var names = new Array(getLabel("Common.Store.label", "Common"), getLabel("eST.BatchSeries.label", "ST"), getLabel("Common.BatchID.label", "Common"));
		
		var blankObject = null;
		blankObject = checkSTFields(fields, names, messageFrame, errorPage);
		if (blankObject == true) {
			eval(formApply(formObj, ST_CONTROLLER));
			messageFrame.location.href = errorPage + "?err_num=" + message;
			if (result) {
				onSuccess();
			}
		}
	
		return;
	}
	var arrFieldName = new Array();
	var arrLegends = new Array();
	var arrPKFieldNames = new Array();
	 
	arrFieldName[0] = "store_code_";
	arrFieldName[1] = "batch_series_";
	arrFieldName[2] = "batch_id_";
	arrLegends[0] = getLabel("Common.Store.label", "Common");
	arrLegends[1] = getLabel("eST.BatchSeries.label", "ST"); 
	arrLegends[2] = getLabel("Common.BatchID.label", "Common");
	arrPKFieldNames[0] = "store_code_";
	arrPKFieldNames[1] = "batch_series_";
	arrPKFieldNames[2] = "batch_id_";
	resetDuplicateClass(formObj, arrPKFieldNames);
	if (formObj.mode.value == MODE_INSERT) {
		var validateResult = validateBatchFields(formObj, arrFieldName, arrLegends, arrPKFieldNames);
		if (validateResult) {
			eval(formApply(f_query_add_mod.document.formDisposableAdjustment, ST_CONTROLLER));
			if (result) {
				onSuccess();
			}
			if (invalidCode != "null" && invalidCode != "") {
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + message + ":-" + invalidCode;
				showDuplicates(formObj, arrPKFieldNames, invalidCode, "0", messageFrame,errorPage);
			} else {
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + message;
			}
		}
	}
}
function isInArray(_array, _value) {
	var found = false;
	for (index = 0; index < _array.length; index++) {
		if (_array[index] == _value) {
			found = true;
			break;
		}
	}
	return found;
}
function reset() {
	if (f_query_add_mod.document.formDisposableAdjustment != null && f_query_add_mod.document.formDisposableAdjustment.mode.value == 2) {
		f_query_add_mod.document.formDisposableAdjustment.reset();
	}
	if (f_query_add_mod.document.formDisposableAdjustment != null && f_query_add_mod.document.formDisposableAdjustment.mode.value == 1) {
		f_query_add_mod.location.reload();
	}
	if (f_query_add_mod.document.query_form != null) {
		f_query_add_mod.document.query_form.reset();
	}
}
function onSuccess() {
	var mode = f_query_add_mod.document.formDisposableAdjustment.mode.value;
	if (mode == MODE_INSERT) {
		reset();
	} else {
		f_query_add_mod.document.location.reload();
	}
}
function Modify(obj) {
	var store_code = obj.cells[0].innerText;
	document.location.href = "../../eST/jsp/DisposableAdjustmentAddmodify.jsp?mode=" + MODE_MODIFY + "&function_id=" + parent.function_id + "&store_code="+store_code;
}
function checkbatchid(obj, count) {
	if (eval("document.formDisposableAdjustment.auto_gen_batch_yn_" + count).checked == true) {
		eval("document.formDisposableAdjustment.auto_gen_batch_yn_" + count).value = "Y";
		//eval("document.formDisposableAdjustment.batch_id_" + count).disabled = false;
		//eval("document.formDisposableAdjustment.batch_series_" + count).disabled = false;
	} else {
		eval("document.formDisposableAdjustment.auto_gen_batch_yn_" + count).value = "N";
		eval("document.formDisposableAdjustment.batch_id_" + count).value = "";
		//eval("document.formDisposableAdjustment.batch_id_" + count).disabled = true;
		eval("document.formDisposableAdjustment.batch_series_" + count).value = "";
		//eval("document.formDisposableAdjustment.batch_series_" + count).disabled = true;
	}
}
function checksinglebatchid() {
	if (document.formDisposableAdjustment.auto_gen_batch_yn_0.checked == true) {
		document.formDisposableAdjustment.auto_gen_batch_yn_0.value = "Y";
		document.formDisposableAdjustment.batch_id_0.disabled = false;
	} else {
		document.formDisposableAdjustment.auto_gen_batch_yn_0.value = "N";
		document.formDisposableAdjustment.batch_id_0.value = "";
		document.formDisposableAdjustment.batch_id_0.disabled = true;
	}
}
function checkForNumber(batch_id) {
	if(checkIntegerFormat(document.formDisposableAdjustment.batch_id_0)){ //Added By Rabbani #Inc no: 38562 on 12-MAR-2013 
	if (parseInt(document.formDisposableAdjustment.batch_id_0.value) < parseInt(batch_id)) {
		alert(getMessage("BATCH_ID_GREATER_THAN_PREVIOUS", "ST"));
		document.formDisposableAdjustment.batch_id_0.value = batch_id;
		document.formDisposableAdjustment.batch_id_0.focus();
	}
	}
}
function resetColorCode(obj) {
	var arrPKFieldNames = new Array();
	var formObj = parent.f_query_add_mod.document.formDisposableAdjustment;
	 
	arrPKFieldNames[0] = "store_code_";
	arrPKFieldNames[1] = "batch_series_";
	arrPKFieldNames[2] = "batch_id_";
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
					} else {
						if (eval("formObj.auto_gen_batch_yn_" + rowIndex).value == "Y") {
							fields[notNullIndex] = current_field;
							names[notNullIndex++] = arrLegends[colIndex]; // + " #" + currRowIndex; //" %23" + currRowIndex;
							uniqueFields += current_field.name + " ";
						}
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

function checkForBatchSeries(batch_id) {
	if (parseInt(document.formDisposableAdjustment.batch_id_0.value) < parseInt(batch_id)) {
		alert(getMessage("BATCH_ID_GREATER_THAN_PREVIOUS", "ST"));
		document.formDisposableAdjustment.batch_id_0.value = batch_id;
		document.formDisposableAdjustment.batch_id_0.focus();
	}
}

//Function to disable all special characters in master codes.
function CheckForChars(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}
function chageBatchval(obj)
{
 if(obj.checked)
 document.formDisposableAdjustment.auto_gen_batch_yn_0.value = "Y";
 else
 document.formDisposableAdjustment.auto_gen_batch_yn_0.value = "N";
}
 

