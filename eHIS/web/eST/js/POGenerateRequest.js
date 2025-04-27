var function_id = "";
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
var finalizeType;

function onSuccess() {
	reset();
}

function reset() {
	f_query_add_mod.POGenerateRequestHeaderFrame.document.formPOGenerateRequest.reset();
	var formObject = f_query_add_mod.POGenerateRequestHeaderFrame.document.formPOGenerateRequest;
	var errorPage = "../../eCommon/jsp/error.jsp";
	assignBean(formObject);
	var xmlHttp = new XMLHttpRequest();
	xmlStr = getEnhancedXMLString(formObject);
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/POGenerateRequestValidate.jsp?function_type=RESET", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
	f_query_add_mod.POGenerateRequestDetailFrame.location.href = "../../eCommon/html/blank.html";
	formObject.to_department.selectedIndex = 2;
}

function toggleCheck(formObject1) {

	var formObject = parent.POGenerateRequestDetailFrame.document.formPOGenerateRequestDetail;
	var allElements = formObject.elements;
	var ischecked = formObject1.checked;
	for (i = 0; i < allElements.length; i++) {
		if (allElements[i].type == "checkbox") {
			if (!allElements[i].disabled) {
				allElements[i].checked = ischecked;
			}
		}
	}
}

function showCheckTickdisabled() {
	var formObject1 =parent.POGenerateRequestDetailFrame.document.formPOGenerateRequestDetail;
	if(formObject1.checkAll!=undefined){
	var ischecked = formObject1.checkAll.checked;
	if (ischecked == false) {
		formObject1.checkAll.disabled = false;
	}
	formObject1.checkAll.checked = true;
	}
}

async function apply() {
	var errorPage = "../../eCommon/jsp/error.jsp";
	var formHeader = f_query_add_mod.POGenerateRequestHeaderFrame.document.formPOGenerateRequest;
	var locale = formHeader.locale.value;
	var arrayObject = new Array(formHeader.doc_type_code, formHeader.doc_date, formHeader.requisition_by_store, formHeader.to_department);
	var names = new Array(getLabel("Common.DocType.label", "Common"), getLabel("Common.DocDate.label", "Common"), getLabel("Common.ReqByStore.label", "Common"), getLabel("eST.ToDepartment.label", "ST"));
	if (!formHeader.doc_no.disabled) {
		arrayObject[arrayObject.length] = formHeader.doc_no;
		names[names.length] = getLabel("Common.DocNo.label", "Common");
	}
	var blankObject = checkSTFields(arrayObject, names, messageFrame, errorPage);
	if (blankObject != true) {
		return;
	}
	var formObject = f_query_add_mod.POGenerateRequestDetailFrame.document.formPOGenerateRequestDetail;

	var total_items = formObject.total_checkboxes.value;
	
	var chkdValue = 0;
	for (count = 0; count < total_items; count++) {
		if (!eval("formObject.add_itm_" + count + ".checked")) {
			chkdValue++;
		}
	}
	if (total_items == chkdValue) {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("MIN_ONE_DETAIL_REQUIRED", "common");
		return;
	}
	formObject.mode.value = formHeader.mode.value;
	formObject.doc_type_code.value = formHeader.doc_type_code.value;
	formObject.doc_no.value = formHeader.doc_no.value;
	formObject.doc_date.value = convertDate(formHeader.doc_date.value, "DMY", locale, "en");
	formObject.doc_ref.value = formHeader.doc_ref.value;
	formObject.requisition_by_store.value = formHeader.requisition_by_store.value;
	formObject.to_department.value = formHeader.to_department.value;
	formObject.item_class_code.value = formHeader.item_class_code.value;
	formObject.effective_date.value = convertDate(formHeader.effective_date.value, "DMY", locale, "en");
	formObject.autono_yn.value = formHeader.autono_yn.value;
	formObject.item_from_code.value = formHeader.item_from_code.value;
	formObject.item_to_code.value = formHeader.item_to_code.value;
	formObject.alpha_from_code.value = formHeader.alpha_from_code.value;
	formObject.alpha_to_code.value = formHeader.alpha_to_code.value;
	
	
	if (formHeader.authorize_yn.value == YES) {
		finalizeType = await confirmFinalize();
		if(finalizeType=="")
		{
		messageFrame.location.href = errorPage + "?err_num=";
		return false;
		}
	}
	formObject.finalize_yn.value = finalizeType;
	var responseText = formApply(formObject, ST_CONTROLLER);
	var responseText = formApply(f_query_add_mod.POGenerateRequestDetailFrame.document.formPOGenerateRequestDetail, ST_CONTROLLER);
		eval(responseText);
	flag1 = (flag.split("~"))[0];
	flag2 = (flag.split("~"))[1];
	flag1 = (flag1 == "null" ? "" : flag1);
	onSuccess();
	if (result) {
		messageFrame.location.href = errorPage + "?err_num=" + encodeURIComponent(message) + "<br>" + flag1;
	} else {
		messageFrame.location.href = errorPage + "?err_num=" + message;
	}
}

function assignBean(formObject) {
	if (formObject == null) {
		bean_id = document.formPOGenerateRequest.bean_id.value;
		bean_name = document.formPOGenerateRequest.bean_name.value;
	} else {
		bean_id = formObject.bean_id.value;
		bean_name = formObject.bean_name.value;
	}
	/*xmlDom = new ActiveXObject("Microsoft.XMLDom");
	xmlHttp = new ActiveXObject("Microsoft.XMLHTTP"); */
	var xmlDom ="";
	var xmlHttp = new XMLHttpRequest();
}

function validateDocNo(doc_type_code) {
	if (document.formPOGenerateRequest.mode.value == MODE_INSERT) {
		if (doc_type_code.value == "") {
	document.formPOGenerateRequest.doc_no.disabled = true;
	document.formPOGenerateRequest.doc_no.readonly = true;
	document.formPOGenerateRequest.doc_no.value = "";
	document.getElementById("doc_no_gif").style.visibility = 'hidden';
			return;
		}
		var xmlHttp = new XMLHttpRequest();
		var arrayObject = new Array();
		arrayObject[0] = doc_type_code;
		assignBean();
		xmlStr = getXMLString(arrayObject);
		//xmlDom.loadXML(xmlStr);
		xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "POGenerateRequestValidate.jsp?function_type=VALIDATEDOCNO", false);
		xmlHttp.send(xmlDom);
		responseText = xmlHttp.responseText;
		return responseText;
	}
}

function assignBinLocationDesc(ListObject) {
	document.formPOGenerateRequest.bin_location_code.value = ListObject.options[ListObject.selectedIndex].text;
}

function errorDisplay() {
	document.formPOGenerateRequest.doc_ref.focus();
}

function enableDocNo(obj) {
	if(obj=="N"){
	document.formPOGenerateRequest.doc_no.disabled = false;
	document.formPOGenerateRequest.doc_no.readonly = false;
	document.formPOGenerateRequest.doc_no.focus();
	document.formPOGenerateRequest.autono_yn.value = NO;
	document.getElementById("doc_no_gif").style.visibility = 'visible';
	}else{
	document.formPOGenerateRequest.doc_no.disabled = true;
	document.formPOGenerateRequest.doc_no.readonly = true;
	document.formPOGenerateRequest.doc_no.value = "";
	document.formPOGenerateRequest.doc_date.focus();
	document.formPOGenerateRequest.autono_yn.value = YES;
	document.getElementById("doc_no_gif").style.visibility = 'hidden';
	}
}

async function callItemSearchScreen(objCode, objDesc) {
	var consignment = document.formPOGenerateRequest.consignment.value;
	var search_string = objCode.value;
	var store_code = document.formPOGenerateRequest.requisition_by_store.value;
	var category = "A";
	var sole_source = "A";
	var ps_item = "A";
	var mfg_item = "A";
	var expiry = "A";
	var consignment = "A";
	var item_class = "";
	var retValue = await callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment);
	var ret1=unescape(retValue);
 	arr=ret1.split(",");
	if(arr[1]==undefined)
		{
 		arr[0]="";	
 		arr[1]="";	
		}
   else{
	   objCode.value=arr[0];
	   objDesc.value=arr[1];
      }

	/*if (retValue != null) {
		objCode.value = retValue[0];
		objDesc.value = retValue[1];
	} else {
		objCode.value = "";
		objDesc.value = "";
	} */
}

function searchItemClassCode(objCode, objDesc) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	argumentArray[0] = document.formPOGenerateRequest.SQL_ST_ITEM_CLASS_LOOKUP_LANG.value + "'" + document.forms[0].p_language_id.value + "'";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	if (objDesc.readOnly) {
		argumentArray[5] = "";
	} else {
		argumentArray[5] = objDesc.value;
	}
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.ItemClass.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
		objDesc.readOnly = true;
	}
}

function getItemRecord() {
	var errorPage = "../../eCommon/jsp/error.jsp";
	var arrayObject = new Array(document.formPOGenerateRequest.doc_type_code, document.formPOGenerateRequest.doc_date, document.formPOGenerateRequest.requisition_by_store, document.formPOGenerateRequest.to_department);
	var names = new Array(getLabel("Common.DocType.label", "Common"), getLabel("Common.DocDate.label", "Common"), getLabel("Common.ReqByStore.label", "Common"), getLabel("eST.ToDepartment.label", "ST"));
	if (!document.formPOGenerateRequest.doc_no.disabled) {
		arrayObject[arrayObject.length] = document.formPOGenerateRequest.doc_no;
		names[names.length] = getLabel("Common.DocNo.label", "Common");
	}

	var blankObject = checkSTFields(arrayObject, names, parent.parent.messageFrame, errorPage);
	if (blankObject != true) {
		return;
	}
	if (!isValidFromToField(document.formPOGenerateRequest.item_from_code, document.formPOGenerateRequest.item_to_code, STRING, getLabel("Common.ItemCode.label", "Common"), parent.parent.messageFrame)) {
		return;
	}
	if (!isValidFromToField(document.formPOGenerateRequest.alpha_from_code, document.formPOGenerateRequest.alpha_to_code, STRING, getLabel("Common.AlphaCode.label", "Common"), parent.parent.messageFrame)) {
		return;
	}
	var formObject = document.formPOGenerateRequest;
	var viewitem = document.formPOGenerateRequest.viewitems.value;
	var errorPage = "../../eCommon/jsp/error.jsp";
	var xmlHttp = new XMLHttpRequest();
	assignBean();
	xmlStr = getEnhancedXMLString(formObject);
	//xmlDom.loadXML(xmlStr);
    var xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/POGenerateRequestValidate.jsp?function_type=FINDRECORDS", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
	parent.POGenerateRequestDetailFrame.document.location.href = "POGenerateRequestDetail.jsp?to_department=" + document.formPOGenerateRequest.to_department.value + "&requisition_by_store=" + document.formPOGenerateRequest.requisition_by_store.value;
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
}

function setAuthorize(authorizeValue) {
	document.formPOGenerateRequest.authorize_yn.value = authorizeValue;
}

function setParentStoreCode(store_code) {
	document.formPOGenerateRequest.to_department.value = store_code;
}

function checkCanAuthorize(requisition_by_store) {
	if (requisition_by_store.value == "") {
		clearListItems('formPOGenerateRequest.to_department');
		return;
	}
	var xmlHttp = new XMLHttpRequest();
	var arrayObject = new Array();
	arrayObject[0] = requisition_by_store;
	assignBean(document.formPOGenerateRequest);
	xmlStr = getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/POGenerateRequestValidate.jsp?function_type=CHECKCANAUTHORIZE&requisition_by_store="+requisition_by_store.value, false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
}

function checkDate(obj, sysdate, locale) {
	if (validDateObj(obj, "DMY", locale)) {
		if (isAfter(sysdate.value,obj.value, "DMY", locale)) {
			alert(getMessage("NOT_LESS_THAN_SYSDATE", "ST"));
			obj.focus();
			return false;
		}
	}
}

function defaultFirstElement() {
	var formObject = document.formPOGenerateRequest;
	if ((formObject.mode.value == MODE_INSERT) && (formObject.requisition_by_store.length > 0)) {
		formObject.requisition_by_store.selectedIndex = 1;
		formObject.requisition_by_store.focus();
		formObject.to_department.focus();
	}
	if (formObject.mode.value == MODE_INSERT) {
		formObject.doc_type_code.focus();
	}
}

var prevObj = null;
var prevColor = null;
function changeRowColor(obj) {
	if (prevObj != null) {
		for (k = 1; k < prevObj.cells.length; k++) {
			prevObj.cells[k].className = prevColor;
		}
	}
	prevObj = obj;
	prevColor = obj.cells[1].className;
	for (k = 1; k < prevObj.cells.length; k++) {
		obj.cells[k].className = "STLIGHTPINK";
	}
}

function checkQty(obj, checkBoxObject, max_stock_qty, original_value,no_of_decimals) {

	if ( max_stock_qty > 0 && eval(obj.value) > max_stock_qty) {
		var confirm_result = confirm(getMessage("QTY_GREATER_THAN_MAX_QTY", "ST") + "  Proceed ?");
		if (!confirm_result) {
			obj.value = original_value;
			obj.focus();
		}else{
			
			checkBoxObject.checked = true;
			checkBoxObject.value ="Y";
			checkBoxObject.disabled = false;
		}
	}
		/**
	* @Name - krishna
	* @Date - 21/01/2010
	* @Inc# - IN015496
	* @Desc - else will not be performed when clicked on OK. so return is given after obj.focus and else is removed.
	*/
	//} else {
		
		if (obj.value == "") {
		
			checkBoxObject.checked = false;
			checkBoxObject.value ="N";
			checkBoxObject.disabled = true;
		} else {
			
			checkBoxObject.disabled = false;
			checkBoxObject.value ="Y";
		}
		if(eval(no_of_decimals)  > 0){
			//if (!isValidIntegerZero(obj)) {
			if (!isValidDoubleFormat(obj)) {
			
				return;
			}
		}else{
			if (!isValidIntegerZero(obj)) {
				
				return;
			}
		}
		if (parseFloat(obj.value) == 0) {
				
			checkBoxObject.checked = false;
			checkBoxObject.value ="N";
			checkBoxObject.disabled = true;
		} else {
			
			checkBoxObject.disabled = false;
			checkBoxObject.value ="Y";
			checkBoxObject.checked = true;
		}
	
}

function checksysdate(obj, locale) {
	//if (validDateObj(obj, "DMY", locale)) {by B.Badmavathi for SRR20056-SCF-9540 on 22/7/2015
		if (CheckDateLeap(obj, "DMY", locale)) {  
		var formObject = document.formPOGenerateRequest;
		var errorPage = "../../eCommon/jsp/error.jsp";
		var xmlHttp = new XMLHttpRequest();
		assignBean(formObject);
		xmlStr = getEnhancedXMLString(formObject);
		//xmlDom.loadXML(xmlStr);
		var xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/POGenerateRequestValidate.jsp?documentdate=" + convertDate(obj.value, "DMY", locale, "en") + "&function_type=ISVALIDDOCDATE", false);
		xmlHttp.send(xmlDom);
		responseText = xmlHttp.responseText;
		eval(responseText);
	}
}

function curr_date_grt_sysdaete() {
	alert(getMessage("ST_DOC_DT_NOT_GR_SYSDATE", "ST"));
	document.formPOGenerateRequest.doc_date.focus();
}

function checkSysdate(receiptdate, sysdate, locale) {
	if(receiptdate.value!=""){
		var flag = CheckDateLeap(receiptdate,'DMY',locale);
/*		var flag = ChkDate(receiptdate);Commented by B.Badmavathi for SRR20056-SCF-9540 on 22/7/2015
		if (!flag) {
			alert(getMessage("INVALID_DATE_FMT", "ST"));
			receiptdate.select();
			receiptdate.focus();
			return false;
		}*/
		if (flag) {
			if (checkdateWithSysDate(receiptdate, sysdate)) {
				alert(getMessage("NOT_LESS_THAN_SYSDATE", "ST"));
				receiptdate.select();
				return false;
			}
		}
	}
}

function checkdateWithSysDate(entered_date, sys_date) {
	var enteredDateArray;
	var sysDateArray;
	var enteredDate = entered_date.value;
	var sysDate = sys_date.value;
	if (enteredDate.length > 0 && sysDate.length > 0) {
		enteredDateArray = enteredDate.split("/");
		sysDateArray = sysDate.split("/");
		var enteredDateObject = new Date(enteredDateArray[2], (enteredDateArray[1] - 1), enteredDateArray[0]);
		var sysDateObject = new Date(sysDateArray[2], (sysDateArray[1] - 1), sysDateArray[0]);
		if (Date.parse(sysDateObject) <= Date.parse(enteredDateObject)) {
				
			return false;
		} else {
			if (Date.parse(sysDateObject) > Date.parse(enteredDateObject)) {
				return true;
			}
		}
	}
	return true;
}

function assignValue(obj) {
	if (obj.checked == true) {
		obj.value = "Y";
	} else {
		obj.value = "N";
	}
	
}
function isValidNumber(fld, e, maxInt, deci,allow_yn) {
	/**
	* @Name - krishna
	* @Date - 12/01/2010
	* @Inc# - IN015496
	* @Desc - Code added to accept decimal values dynamically.
	*/

	var disp_allowed_yn = "Y";
	if(document.forms[0].dec_allowed_yn!=undefined){
		disp_allowed_yn = document.forms[0].dec_allowed_yn.value;
	}
	if(allow_yn=="N" ){
		deci = 0;
	}
	var count = fld.value.length;
	var whichCode = (window.Event) ? e.which : e.keyCode;
	if (count >= maxInt) {
		if (count == maxInt) {
			var dotOccurance = fld.value.indexOf(".");
			if (((dotOccurance >= maxInt) || (dotOccurance == -1)) && (count == maxInt)) {
				if (whichCode != 46) {
					if (deci > 1) {
						fld.value = fld.value + ".";
					}
				}
			}
		} else {
			if (count > maxInt) {
				var objectValue = fld.value;
				var dotOccurance = objectValue.indexOf(".");
				if ((objectValue.charAt(maxInt)) != ".") {
					if (dotOccurance == -1) {
						if (deci != 0) {
							fld.value = objectValue.substring(0, maxInt) + ".";
						} else {
							fld.value = objectValue.substring(0, maxInt);
						}
						return false;
					}
				}
			}
		}
	}
	var strCheck = ".0123456789";
	if (deci == 0) {
		strCheck = "0123456789";
	}
	var fldvalue = fld.value;
	var whichCode = (window.Event) ? e.which : e.keyCode;
	if (whichCode == 13) {
		return true;  // Enter
	}
	var pointCount = 0;
	for (var i = 0; i < fldvalue.length; i++) {
		if (fldvalue.charAt(i) == ".") {
			pointCount++;
		}
	}
	if (pointCount > 0 && whichCode == 46) {
		return false;
	}
	var fldValue = fld.value;
	var dotIndex = fldValue.indexOf(".");
	var fldLength = fldValue.length;
	if (dotIndex != -1) {
		if (fldLength > (dotIndex + deci)) {
			return false;
		}
	}
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) {
		return false;  // Not a valid key
	}
	return true;
}



