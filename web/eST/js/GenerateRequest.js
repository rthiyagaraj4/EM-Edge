/*
 ------------------------------------------------------------------------------------------------------------------------------
Date		Edit History		Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
14/10/2019  IN:071343           B Haribabu                                         		GHL-CRF-0608	
26/11/2020     6626                      Haribabu                                                   ML-MMOH-SCF1642
-------------------------------------------------------------------------------------------------------------------------------
*/
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
	f_query_add_mod.GenerateRequestHeaderFrame.document.formGenerateRequest.reset();
	var formObject = f_query_add_mod.GenerateRequestHeaderFrame.document.formGenerateRequest;
	var errorPage = "../../eCommon/jsp/error.jsp";
	assignBean(formObject);
	xmlStr = getEnhancedXMLString(formObject);
	xmlDom = "";
	xmlHttp = new XMLHttpRequest();
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/GenerateRequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=4", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
	f_query_add_mod.GenerateRequestDetailFrame.location.href = "../../eCommon/html/blank.html";
	//formObject.requisition_on_store.selectedIndex = 2;
}
function toggleCheck(formObject1) {
	
	//var firstElement=formObject1.checked;
	var formObject = parent.GenerateRequestDetailFrame.document.formGenerateRequestDetail;
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
/* @Name - Priya
 * @Date - 13/07/2010
 * @Inc# - 22634
 * @Desc - header is moved to GenerateRequestDetailFrame   
*/
function showCheckTickdisabled() {
	var formObject1 = parent.GenerateRequestDetailFrame.document.formGenerateRequesthtml;
	var ischecked = formObject1.checkAll.checked;
	if (ischecked == false) {
		formObject1.checkAll.disabled = false;
	}
	formObject1.checkAll.checked = true;
}
async function apply() {
	var errorPage = "../../eCommon/jsp/error.jsp";
	var formHeader = f_query_add_mod.GenerateRequestHeaderFrame.document.formGenerateRequest;
	var locale = formHeader.locale.value;
	var arrayObject = new Array(formHeader.doc_type_code, formHeader.doc_date, formHeader.requisition_by_store, formHeader.requisition_on_store);
	var names = new Array(getLabel("Common.DocType.label", "Common"), getLabel("Common.DocDate.label", "Common"), getLabel("Common.ReqByStore.label", "Common"), getLabel("Common.ReqOnStore.label", "Common"));
	if (!formHeader.doc_no.disabled) {
		arrayObject[arrayObject.length] = formHeader.doc_no;
		names[names.length] = "Doc No";
	}
	var blankObject = checkSTFields(arrayObject, names, messageFrame, errorPage);
	if (blankObject != true) {
		return;
	}
	var checkedValues="";
	var formObject = f_query_add_mod.GenerateRequestDetailFrame.document.formGenerateRequestDetail;
	var total_items = formObject.total_checkboxes.value;
	var chkdValue = 0;
	for (count = 0; count < total_items; count++) {
		if (eval("formObject.add_itm_" + count + ".checked")) {
			checkedValues = checkedValues+eval("formObject.add_itm_"+count).value + "~";
		}
	}
/*current pending request checking begin*/



	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;	
	var xmlStr ="<root><SEARCH ";//Modified for 6626
	xmlStr += "checkedValues=\""+ checkedValues +"\" " ;
	xmlStr += "request_by_store=\""+ formHeader.requisition_by_store.value +"\" " ;
	xmlStr += "bean_id=\"generateRequestBean\" ";
	xmlStr += "bean_name=\"eST.GenerateRequestBean\" ";
	xmlStr +=" /></root>" ;		
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
	xmlHttp.open( "POST", "GenerateRequestValidate.jsp?function_type=13", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);

	if(result){
		//retVal = window.showModalDialog("../../eST/jsp/PendingRequests.jsp?bean_id=generateRequestBean&bean_name=eST.GenerateRequestBean&request_by_store="+formHeader.requisition_by_store.value, "", "dialogHeight:20; dialogWidth:41; center:0; status: no; dialogLeft :250; dialogTop :250;scroll:no");
		//Modified against TTM-SCF-0112,TTM-SCF-0124 on 22-05-2015
		retVal = await window.showModalDialog("../../eST/jsp/PendingRequests.jsp?bean_id=generateRequestBean&bean_name=eST.GenerateRequestBean&request_by_store="+formHeader.requisition_by_store.value, "", "dialogHeight:50vh; dialogWidth:60vw; center:0; status: no; dialogLeft :350; dialogTop :175;scroll:no");
		if(retVal!=undefined){
			var val = retVal.split("~");
			for (var i=0;i<val.length ;i++ ){
				if(val[i]!=""){
					for(var j=0;j<total_items;j++){
						if (eval("formObject.item_code_" + j + ".value")==val[i]){
							eval("formObject.add_itm_" + j).checked = false;
						}
					}
				}
			}
		}else{
			messageFrame.location.href = errorPage + "?err_num=";
			return false;
		}
	}


/*current pending request checking end*/
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
	if (formObject.requisition_by_store.value == formHeader.requisition_on_store.value) {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("REQ_ON_REQ_BY_CANNOT_BE_SAME", "ST");
		formHeader.requisition_by_store.focus();
		return;
	}
	formObject.requisition_by_store.value = formHeader.requisition_by_store.value;
	formObject.requisition_on_store.value = formHeader.requisition_on_store.value;
	formObject.item_class_code.value = formHeader.item_class_code.value;
	formObject.autono_yn.value = formHeader.autono_yn.value;
	formObject.effective_date.value = convertDate(formHeader.effective_date.value, "DMY", locale, "en");
	formObject.autono_yn.value = formHeader.autono_yn.value;
	formObject.item_from_code.value = formHeader.item_from_code.value;
	formObject.item_to_code.value = formHeader.item_to_code.value;
	formObject.alpha_from_code.value = formHeader.alpha_from_code.value;
	formObject.alpha_to_code.value = formHeader.alpha_to_code.value;
	if (formHeader.authorize_yn.value == YES) {
		finalizeType = await confirmAuthorize();
		if(finalizeType=="")
		{
		messageFrame.location.href = errorPage + "?err_num=";
		return false;
		}
	}
	formObject.finalize_yn.value = finalizeType;
	formHeader.finalize_yn.value = finalizeType;//Added for 6626
	var responseText = formApply(formHeader, ST_CONTROLLER);//Modified for 6626
	eval(responseText);
	flag1 = (flag.split("~"))[0];
	flag2 = (flag.split("~"))[1];
	flag1 = (flag1 == "null" ? "" : flag1);
	if (result) {
		if (flag2 == "PY") {
			if (formObject.finalize_yn.value == "Yes") {
				var PConfirm = await confirmPrinting();
				if (PConfirm == "Yes") {
					//xmlDom = new ActiveXObject("Microsoft.XMLDom");
					//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
					xmlDom = "";
					xmlHttp =  new XMLHttpRequest();
					//xmlDom.loadXML("<SEARCH/>");
					xmlDom = new DOMParser().parseFromString("<SEARCH/>", "text/xml");
					//xmlHttp.open("POST", "../../eST/jsp/GenerateRequestValidate.jsp?bean_id=generateRequestBean&bean_name=eST.GenerateRequestBean&function_type=7&msg=" + encodeURIComponent(message), false);
					xmlHttp.open("POST", "../../eST/jsp/GenerateRequestValidate.jsp?bean_id=generateRequestBean&bean_name=eST.GenerateRequestBean&function_type=7&msg=" + encodeURIComponent(message), true);
					xmlHttp.send(xmlDom);
					//responseText = xmlHttp.responseText;
					//eval(responseText);
					onSuccess();
							
				}
			}
		} else 	if (flag2 == "PN") {
		
					//xmlDom = new ActiveXObject("Microsoft.XMLDom");
					//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
					xmlDom = "";
					xmlHttp =  new XMLHttpRequest();
					//xmlDom.loadXML("<SEARCH/>");
					xmlDom = new DOMParser().parseFromString("<SEARCH/>", "text/xml");
					//xmlHttp.open("POST", "../../eST/jsp/GenerateRequestValidate.jsp?bean_id=generateRequestBean&bean_name=eST.GenerateRequestBean&function_type=7&msg=" + encodeURIComponent(message), false);
					xmlHttp.open("POST", "../../eST/jsp/GenerateRequestValidate.jsp?bean_id=generateRequestBean&bean_name=eST.GenerateRequestBean&function_type=7&msg=" + encodeURIComponent(message), true);
					xmlHttp.send(xmlDom);
					//responseText = xmlHttp.responseText;
					//eval(responseText);
					onSuccess();
			}
		messageFrame.location.href = errorPage + "?err_num=" + encodeURIComponent(message) + "<BR>" + (result ? flag1 : "");
		onSuccess();
		if (result) {
			messageFrame.location.href = errorPage + "?err_num=" + encodeURIComponent(message) + "<BR>" + flag1;
		} else {
			messageFrame.location.href = errorPage + "?err_num=" + message;
		}
	} else {
		if (flag != "") {
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&item_code=" + item_code + "&store_code=" + to_store_code + "function_type=12&msg" + message, false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
            		//code remodev from heer 				
			f_query_add_mod.frameRequestDetail.location.href = "../../eST/jsp/RequestDetail.jsp?function_id=" + function_id + "&index=" + message + "&arr=" + arr;
		}
	}
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + message + "<br>" + flag1;

}
function assignBean(formObject) {
	if (formObject == null) {
		bean_id = document.formGenerateRequest.bean_id.value;
		bean_name = document.formGenerateRequest.bean_name.value;
	} else {
		bean_id = formObject.bean_id.value;
		bean_name = formObject.bean_name.value;
	}
	//xmlDom = new ActiveXObject("Microsoft.XMLDom");
	//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	xmlDom = "";
	xmlHttp =  new XMLHttpRequest();
}
function validateDocNo(doc_type_code) {
	if (document.formGenerateRequest.mode.value == MODE_INSERT) {
		if (doc_type_code.value == "") {
			return;
		}
		var arrayObject = new Array();
		arrayObject[0] = doc_type_code;
		assignBean();
		xmlStr = getXMLString(arrayObject);
		//xmlDom.loadXML(xmlStr);
		xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "GenerateRequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=doc_type_code&function_type=1", false);
		xmlHttp.send(xmlDom);
		responseText = xmlHttp.responseText;
		eval(responseText);
	}
}
function assignBinLocationDesc(ListObject) {
	document.formGenerateRequest.bin_location_code.value = ListObject.options[ListObject.selectedIndex].text;
}
function errorDisplay() {
	document.formGenerateRequest.doc_ref.focus();
}
function enableDocNo() {
	GenerateRequest = document.formGenerateRequest;
	GenerateRequest.doc_no.disabled = false;
	GenerateRequest.doc_no.readonly = false;
	GenerateRequest.doc_no.focus();
	GenerateRequest.autono_yn.value = NO;
}
function disableDocNo() {
	GenerateRequest = document.formGenerateRequest;
	GenerateRequest.doc_no.disabled = true;
	GenerateRequest.doc_no.readonly = true;
	GenerateRequest.doc_no.value = "";
	GenerateRequest.doc_date.focus();
	GenerateRequest.autono_yn.value = YES;
}
async function callItemSearchScreen(objCode, objDesc) {
	var consignment = document.formGenerateRequest.consignment.value;
	var search_string = objCode.value;
	var store_code = document.formGenerateRequest.requisition_by_store.value;
	var category = "A";
	var sole_source = "A";
	var ps_item = "A";
	var mfg_item = "A";
	var expiry = "A";
	var consignment = "A";
	var item_class = "";
	var retValue = await callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment);
	
	//search_string,store_code,category,sole_source,ps_item,mfg_item,expiry,item_class,consignment
	if (retValue != null) {
		objCode.value = retValue[0];
		objDesc.value = retValue[1];

	} else {
		objCode.value = "";
		objDesc.value = "";
	}
}
async function searchItemClassCode(objCode, objDesc) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	argumentArray[0] = document.formGenerateRequest.SQL_ST_ITEM_CLASS_LOOKUP_LANG.value + "'" + document.forms[0].p_language_id.value + "'";
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
	returnedValues = await CommonLookup(getLabel("Common.ItemClass.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
		objDesc.readOnly = true;
	}
}
function getItemRecord() {
	var errorPage = "../../eCommon/jsp/error.jsp";
	var arrayObject = new Array(document.formGenerateRequest.doc_type_code, document.formGenerateRequest.doc_date, document.formGenerateRequest.requisition_by_store, document.formGenerateRequest.requisition_on_store);

	

	var names = new Array(getLabel("Common.DocType.label", "Common"), getLabel("Common.DocDate.label", "Common"), getLabel("Common.ReqByStore.label", "Common"), getLabel("Common.ReqOnStore.label", "Common"));
	if (!document.formGenerateRequest.doc_no.disabled) {
		arrayObject[arrayObject.length] = document.formGenerateRequest.doc_no;
		names[names.length] = getLabel("Common.DocNo.label", "Common");
	}
	//Added by suresh.r on 30-03-2015 against ML-HSA-SCF-0208 beg
	if (document.formGenerateRequest.item_class_yn.value=='Y') {
		arrayObject[arrayObject.length] = document.formGenerateRequest.item_class_code;
		names[names.length] = getLabel("Common.ItemClass.label", "Common");
	}
	//Added by suresh.r on 30-03-2015 against ML-HSA-SCF-0208 end
	var blankObject = checkSTFields(arrayObject, names, parent.parent.messageFrame, errorPage);
	if (blankObject != true) {
		return;
	}
	if (document.formGenerateRequest.requisition_by_store.value == document.formGenerateRequest.requisition_on_store.value) {
		alert(getMessage("REQ_ON_REQ_BY_CANNOT_BE_SAME", "ST"));
		return;
	}
	if (!isValidFromToField(document.formGenerateRequest.item_from_code, document.formGenerateRequest.item_to_code, STRING, "Item Code", parent.parent.messageFrame)) {
		return;
	}
	if (!isValidFromToField(document.formGenerateRequest.alpha_from_code, document.formGenerateRequest.alpha_to_code, STRING, "Alpha Code", parent.parent.messageFrame)) {
		return;
	}
	var viewitem = document.formGenerateRequest.viewitems.value;
	var formObject = document.formGenerateRequest;
	var errorPage = "../../eCommon/jsp/error.jsp";
	assignBean(formObject);
	xmlStr = getEnhancedXMLString(formObject);
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/GenerateRequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=2&viewitem=" + viewitem, false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
	parent.GenerateRequestDetailFrame.document.location.href = "GenerateRequestDetail.jsp?store_code=" + document.formGenerateRequest.requisition_on_store.value + "&store_code_by=" + document.formGenerateRequest.requisition_by_store.value;
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
}
function setAuthorize(authorizeValue) {
	document.formGenerateRequest.authorize_yn.value = authorizeValue;
}
function setParentStoreCode(store_code) {
	document.formGenerateRequest.requisition_on_store.value = store_code;
}
function checkCanAuthorize(requisition_by_store) {
	if (requisition_by_store.value == "") {
		return;
	}
	var arrayObject = new Array();
	arrayObject[0] = requisition_by_store;
	assignBean(document.formGenerateRequest);
	xmlStr = getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/GenerateRequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=3", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
function populateItemClass(requisition_by_store, requisition_on_store) {
	if (requisition_by_store.value == "" || requisition_on_store == "") {
		return;
	}
	var arrayObject = new Array();
	arrayObject[0] = requisition_by_store;
	arrayObject[1] = requisition_on_store;
	assignBean(document.formGenerateRequest);
	xmlStr = getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/GenerateRequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=5", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
function checkDate(obj, sysdate, locale) {
	//if(CheckDate(obj)){
	if (validDateObj(obj, "DMY", locale)) {
		//if(!(checkDateNotLessSysDate(obj,sysdate))){
		if (isAfter(sysdate.value,obj.value, "DMY", locale)) {
			alert(getMessage("NOT_LESS_THAN_SYSDATE", "ST"));
			obj.focus();
			return false;
		}
	}
}
function defaultFirstElement() {
	var formObject = document.formGenerateRequest;
	if ((formObject.mode.value == MODE_INSERT) && (formObject.requisition_by_store.length > 0)) {
		formObject.requisition_by_store.selectedIndex = 1;
		formObject.requisition_by_store.focus();
		formObject.requisition_on_store.focus();
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
	if (max_stock_qty>0 && obj.value > max_stock_qty) {
		var confirm_result = confirm(getMessage("QTY_GREATER_THAN_MAX_QTY", "ST") + "  Proceed ?");
		if (!confirm_result) {
			obj.value = original_value;
			obj.focus();
			return;
		}else{
			checkBoxObject.checked = true;
			checkBoxObject.disabled = false;
		}
	}else {
		if (obj.value == "") {
			checkBoxObject.checked = false;
			checkBoxObject.disabled = true;
			return;
		} else {
			checkBoxObject.disabled = false;
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
			checkBoxObject.disabled = true;
		} else {
			checkBoxObject.disabled = false;
			checkBoxObject.checked = true;
		}
	}
}
function checksysdate(obj, locale) {
	//if(CheckDate(obj)){
	//if (validDateObj(obj, "DMY", locale)) {
		 if (CheckDateLeap(obj, "DMY", locale)) { //added forSRR20056-SCF-9522 by Badmavathi on 19/08/2015
		var formObject = document.formGenerateRequest;
		var errorPage = "../../eCommon/jsp/error.jsp";
		assignBean(formObject);
		xmlStr = getEnhancedXMLString(formObject);
		//xmlDom.loadXML(xmlStr);
		xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/GenerateRequestValidate.jsp?documentdate=" + convertDate(obj.value, "DMY", locale, "en") + "&function_type=9" + "&bean_id=" + bean_id + "&bean_name=" + bean_name, false);
		xmlHttp.send(xmlDom);
		responseText = xmlHttp.responseText;
		eval(responseText);
	}
}
function curr_date_grt_sysdaete() {
	alert(getMessage("ST_DOC_DT_NOT_GR_SYSDATE", "ST"));
	document.formGenerateRequest.doc_date.value="";
	document.formGenerateRequest.doc_date.focus();
}
function setItemDesc(obj) {
	var item_class_desc = obj[obj.selectedIndex].text;
	var item_class_code = obj.value;
	document.formGenerateRequest.item_class_code.value = item_class_code;
	if ((obj[obj.selectedIndex].text != ("---Select---")) && (obj.selectedIndex != 0)) {
		if (obj[obj.selectedIndex].text == ("---Select---")) {
			obj[obj.selectedIndex].text = "";
		}
		var arrayObject = new Array();
		var bean_id = "generateRequestBean";
		var bean_name = "eST.GenerateRequestBean";
		//var xmlDom = new ActiveXObject("Microsoft.XMLDom");
		//var xmlHttp = new XMLHttpRequest();
		var xmlDom = "";
		var xmlHttp =  new XMLHttpRequest();
		var xmlStr = getXMLString(arrayObject);
		xmlStr = getXMLString(arrayObject);
		//xmlDom.loadXML(xmlStr);
		xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/GenerateRequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=10" + "&item_class_desc=" + item_class_desc + "&item_class_code=" + item_class_code, false);
		xmlHttp.send(xmlDom);
		responseText = xmlHttp.responseText;
		eval(responseText);
	} else {
		return "";
	}
}
function quantityCheck(obj, store_code, item_code,issue_uom_multiples,i) {//Modified for 6626
	var arrayObject = new Array();
	var bean_id = "generateRequestBean";
	var bean_name = "eST.GenerateRequestBean";
	//var xmlDom = new ActiveXObject("Microsoft.XMLDom");
	var xmlDom = "";
	var xmlHttp =  new XMLHttpRequest();
	var xmlStr = getXMLString(arrayObject);
	xmlStr = getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/GenerateRequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=12" + "&store_code=" + store_code + "&item_code=" + item_code + "&item_qty=" + obj.value+"&on_store="+parent.GenerateRequestHeaderFrame.document.formGenerateRequest.requisition_on_store.value+"&issue_uom_multiples="+issue_uom_multiples+"&index="+i, false);//Modified for 6626
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
	if (!result && flag != "" && eval(flag) > 1 ) {
		alert("Req Qty Should Be In Multiples Of " + flag);
		obj.select();
	}
}


function checkSysdate(receiptdate, sysdate, locale) {//added locale for SRR20056-SCF-9522 by Badmavathi on 19/08/2015
	if(receiptdate.value!=""){
		//var flag = ChkDate(receiptdate);
		var flag = CheckDateLeap(receiptdate,'DMY',locale)//changed for SRR20056-SCF-9522 by Badmavathi on 19/08/2015
	/*	if (!flag) {commented for SRR20056-SCF-9522 by Badmavathi on 19/08/2015
			alert(getMessage("INVALID_DATE_FMT", "ST"));
			receiptdate.select();
			receiptdate.focus();
			return false;
		}*/
		if (flag) {
			if (checkdateWithSysDate(receiptdate, sysdate)) {
				alert(getMessage("NOT_LESS_THAN_SYSDATE", "ST"));
				//receiptdate.select();
				receiptdate.value="";
				receiptdate.focus();
				return false;
			}
		}
	}
}

function checkdateWithSysDate(entered_date, sys_date) {
	/*Entered Date Should not be less than sysdate Krishna 1/13/2009*/
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
function appendValues(){
	var values = "";
	var total_values = document.formPendingDetail.total_values.value;
	for(var i =0; i<total_values;i++){
		if(eval("document.formPendingDetail.discard_"+i).checked ==true){
			values = values+eval("document.formPendingDetail.item_code_"+i).value + "~";
		}
	}
	document.formPendingDetail.checked_values.value = values;
}

function isValidNumber(fld, e, maxInt, deci,allow_yn) {
	/**
	* @Name - Mahesh
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
//Added for IN:071343 start
function checkQty1(obj, checkBoxObject, max_stock_qty, original_value,no_of_decimals,qty_on_hand,conv_factor) {//Added conv_factor for MMS-MD-SCF-0277
	
	if (max_stock_qty>0 && parseInt(obj.value)+parseInt(qty_on_hand*conv_factor) > parseInt(max_stock_qty*conv_factor)) {//multiplied with conv_factor for MMS-MD-SCF-0277
		//var confirm_result = confirm(getMessage("QTY_GREATER_THAN_MAX_QTY", "ST") + "  Proceed ?");
		var exc_qty=""+(parseInt(obj.value)+parseInt(qty_on_hand) - parseInt(max_stock_qty));
		alert( getMessage("EXCEED_MAX_STOCK", "ST")  +" "+ exc_qty +" Qty" );
			obj.value = original_value;
			obj.focus();
			return;
	}else {
		if (obj.value == "") {
			checkBoxObject.checked = false;
			checkBoxObject.disabled = true;
			return;
		} else {
			checkBoxObject.disabled = false;
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
			checkBoxObject.disabled = true;
		} else {
			checkBoxObject.disabled = false;
			checkBoxObject.checked = true;
		}
	}
}
//Added for IN:071343 end
