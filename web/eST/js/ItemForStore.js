/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
24/05/2017		IN063603		Badmavathi B							GHL-CRF-0456
18/02/2020      IN:071344        B Haribabu                                   GHL-CRF-0609  
31/12/2020		TFS-8224           Prabha      31/12/2020		Manickam	  MMS-DM-CRF-0177
---------------------------------------------------------------------------------------------------------
*/
var xmlDom;
var xmlHttp;
function assignBean(frmObject) {
	bean_id = frmObject.bean_id.value;
	bean_name = frmObject.bean_name.value;
	//xmlDom = new ActiveXObject("Microsoft.XMLDom");
	//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	var xmlDom = "";
	var xmlHttp = new XMLHttpRequest();
}
function create() {
	f_query_add_mod.location.href = "../../eST/jsp/ItemForStoreMain.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
}
function Modify(obj) {
	var store_code = obj.cells[0].innerText;
	var item_code = obj.cells[1].innerText;
	var uom = obj.cells[7].innerText;
	document.location.href = "../../eST/jsp/ItemForStoreModify.jsp?mode=" + MODE_MODIFY + "&function_id=" + parent.parent.function_id + "&item_code=" + item_code + "&store_code=" + store_code + "&uom=" + uom;
}
function displayDetail() {

	var errorPage = "../../eCommon/jsp/error.jsp";
	var fields = new Array(document.frmItemForStoreHeader.store_code);
	var names = new Array(getLabel("Common.Store.label", "Common"));
	var blankObject = checkSTFields(fields, names, parent.parent.messageFrame, errorPage);
	if (blankObject == true) {
		document.frmItemForStoreHeader.store_code.disabled = true;
		parent.parent.messageFrame.location.href = errorPage;
		parent.ItemForStoreDetailFrame.location.href = "../../eST/jsp/ItemForStoreDetail.jsp?store_code=" + document.frmItemForStoreHeader.store_code.value + "&mode=" + MODE_INSERT;
	} else {
	}
}
function reset() {
		
	if (f_query_add_mod.ItemForStoreListFrame != null) {
		f_query_add_mod.location.href = "../../eST/jsp/ItemForStoreMain.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
	}
	if (f_query_add_mod.document.query_form != null) {
		f_query_add_mod.document.query_form.reset();
	}
	if (f_query_add_mod.document.formItemForStoreModify != null) {
		
		//Added for MMS-DM-CRF-0177
		if(f_query_add_mod.document.formItemForStoreModify.pre_alloc_item_store.value == "Y"){
		var near_expiry = f_query_add_mod.document.formItemForStoreModify.near_expiry.value;
		var stock_level = f_query_add_mod.document.formItemForStoreModify.stock_level.value;
		
		var formObj = f_query_add_mod.document.formItemForStoreModify;
		if(near_expiry=="checked")
			{
				var near_expiry_appl = "E";
				applicableAllocation(near_expiry_appl,formObj);
			}
		else
			{
				var near_expiry_appl = "S";
				applicableAllocation(near_expiry_appl,formObj);
			}
		}
		//Added for MMS-DM-CRF-0177
		
		f_query_add_mod.document.formItemForStoreModify.reset();
	}
}
function query() {
	f_query_add_mod.location.href = "../../eST/jsp/ItemForStoreQueryCriteria.jsp?function_id=" + function_id;
}
function apply() {
	if (f_query_add_mod.document.formItemForStoreModify != null) {
		var errorPage = "../../eCommon/jsp/error.jsp";
		if (f_query_add_mod.document.formItemForStoreModify.stock_item_yn.checked == true) {
			var arrayObject = new Array(f_query_add_mod.document.formItemForStoreModify.bin_location_code);
			var names = new Array(getLabel("Common.BinLocation.label", "Common"));
			var blankObject = checkSTFields(arrayObject, names, messageFrame, errorPage);
			if (blankObject != true) {
			return;
			} else {
			}
		}
	}
	if (f_query_add_mod.document.formItemForStoreModify != null) {
		if (!validateRecordsValues(f_query_add_mod.document.formItemForStoreModify, messageFrame)) {
			return;
		}
		if (f_query_add_mod.document.formItemForStoreModify.Eff_status.value == "") {
			f_query_add_mod.document.formItemForStoreModify.Eff_status = "D";
		}
		
		//Added for MMS-DM-CRF-0177 - Start
		
		var frmObj = f_query_add_mod.document.formItemForStoreModify;
		if(frmObj.pre_alloc_item_store.value=="Y")
			{
			if(frmObj.expiry_stock_1.checked){
		    	if (frmObj.durn_value.value==""){
		    		frmObj.durn_value.focus();
		    		messageFrame.location.href = errorPage + "?err_num=" + getMessage("PH_NEAR_EXPIRY_CANT_BE_BLANK", "ST");
					return false;
				}	
				if(frmObj.durn_type.value=='N'){
					frmObj.durn_type.focus();
					messageFrame.location.href = errorPage + "?err_num=" + getMessage("PH_NEAR_EXPIRY_CANT_BE_BLANK", "ST");
					return false;
				}
		    }
		}
		
         	//Added for MMS-DM-CRF-0177 - End
		var responseText = formApply(f_query_add_mod.document.formItemForStoreModify, ST_CONTROLLER);
		eval(responseText);
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + message;
		if (result) {
			onSuccess();
		}
		return;
	}
	if(f_query_add_mod.ItemForStoreListFrame==undefined){
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" ;
	return
	}
	var formObject = f_query_add_mod.ItemForStoreListFrame.document.formItemForStoreList;
	var total_items = formObject.total_checkboxes.value;
	var chkdValue = 0;
	var blankBin = "";
	for (count = 0; count < total_items; count++) {
		if (!eval("formObject.remove_" + count + ".checked")) {
			chkdValue++;
		}
	}
	if (total_items == chkdValue) {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("MIN_ONE_DETAIL_REQUIRED", "Common");
		return;
	}
	eval(formApply(formObject, ST_CONTROLLER));
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + message;
	if (result) {
		onSuccess();
	}
	if (invalidCode != "null" && invalidCode != "") {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + message + ":-" + invalidCode;
		f_query_add_mod.ItemForStoreListFrame.document.location.reload();
	}
}
function onSuccess() {
	f_query_add_mod.document.location.reload();
}
function populateBinLocation() {
	var store_code = document.formItemForStoreSingleDetail.store_code;
	var item_code = document.formItemForStoreSingleDetail.item_code;
	loadBinLocations(store_code, item_code);
}
function loadBinLocations(store_code, item_code) {
	if (store_code.value == "") {
		return;
	}
	assignBean(document.formItemForStoreSingleDetail);
	var arrayObject = new Array();
	arrayObject[0] = store_code;
	arrayObject[1] = item_code;
	xmlStr = getXMLString(arrayObject);
	 
	//xmlDom.loadXML(xmlStr);
	var xmlHttp = new XMLHttpRequest();
	var xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/ItemForStoreValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=1", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
	document.getElementById("bin_mandiatory").style.visibility = "hidden";
}
function updateSingle() {
	var formObject = document.formItemForStoreSingleDetail;
	var errorPage = "../../eCommon/jsp/error.jsp";
	var arrayObject = new Array(formObject.store_code, formObject.item_desc);
	var names = new Array(getLabel("Common.Store.label", "Common"), getLabel("Common.item.label", "Common"));
	if (formObject.stock_item_yn.checked == true) {
		var arrayObject = new Array(formObject.store_code, formObject.item_desc, formObject.bin_location_code, formObject.issue_uom);
		var names = new Array(getLabel("Common.Store.label", "Common"), getLabel("Common.item.label", "Common"), getLabel("Common.BinLocation.label", "Common"), getLabel("eST.IssueUOM.label", "ST"));
	} else {
		var arrayObject = new Array(formObject.store_code, formObject.item_desc, formObject.issue_uom);
		var names = new Array(getLabel("Common.Store.label", "Common"), getLabel("Common.item.label", "Common"), getLabel("eST.IssueUOM.label", "ST"));
	}
	var blankObject = checkSTFields(arrayObject, names, parent.parent.messageFrame, errorPage);
	if (blankObject != true) {
		return;
	}
	if ((!formObject.item_desc.readOnly) && (!validateCommonCodeSearch(formObject.item_code, formObject.item_desc, 1))) {
		parent.parent.messageFrame.location.href = errorPage + "?err_num=" + message;
		return;
	}
	if (!validateRecordsValues(formObject, parent.parent.messageFrame)) {
		return;
	}
	

	var storeValueIndex = formObject.store_code.selectedIndex;
	formObject.store_desc.value = formObject.store_code.options[parseFloat(storeValueIndex)].text;
	if (formObject.bin_location_code.value == "") {
		formObject.bin_location_desc.value = "";
	} else {
		var binLocationValueIndex = formObject.bin_location_code.selectedIndex;
		formObject.bin_location_desc.value = formObject.bin_location_code.options[parseFloat(binLocationValueIndex)].text;
	}
	
	//Added for MMS-DM-CRF-0177 - Start
	var frmObj = document.formItemForStoreSingleDetail;
	
	if(frmObj.pre_alloc_item_store.value=="Y")
		{
		if(frmObj.expiry_stock_1.checked){
	    	if (frmObj.durn_value.value==""){
	    		frmObj.durn_value.focus();
	    		parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("PH_NEAR_EXPIRY_CANT_BE_BLANK", "ST");
				return false;
			}	
			if(frmObj.durn_type.value=='N'){
				frmObj.durn_type.focus();
				parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("PH_NEAR_EXPIRY_CANT_BE_BLANK", "ST");
				return false;
			}
	    }
	}
	//Added for MMS-DM-CRF-0177 - End
	
	parent.parent.messageFrame.location.href = errorPage;
	assignBean(formObject);
	xmlStr = getEnhancedXMLString(formObject);
	//xmlDom.load
	var xmlHttp = new XMLHttpRequest();
	var xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/ItemForStoreValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=2", false);
	xmlHttp.send(xmlStr);
	responseText = xmlHttp.responseText;
	eval(responseText);
	if (!result) {
		parent.parent.messageFrame.location.href = errorPage + "?err_num=" + message;
		return;
	}
	parent.parent.messageFrame.location.href = errorPage;
	parent.ItemForStoreListFrame.document.location.reload();
	parent.ItemForStoreTabFrame.document.location.href = "ItemForStoreTab.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
	if (formObject.editing.value == "1") {
		formObject.reset();
	} else {
		formObject.document.location.href = "../../eST/jsp/ItemForStoreTab.jsp?mode=" + MODE_INSERT;
	}
	formObject.add_single.value = getLabel("Common.Add.label", "Common");
}
function isSTValidFromToField(fromObj, toObj, dataType, stLegend, messageFrame, errorPage) {
	var bReturn = true;
	var stFromValue = fromObj.value;
	var stToValue = toObj.value;
	if ((!trimCheck(stFromValue)) || (!trimCheck(stToValue))) {
		return bReturn;
	}
	if (dataType == null) {
		dataType = STRING;
	}
	switch (dataType) {
	  case INT:
	  case LONG:
	  case FLOAT:
	  case DOUBLE:
		if (parseFloat(stFromValue) > parseFloat(stToValue)) {
			bReturn = false;
		}
		break;
	  case DATE:
		var arFromDate = stFromValue.split("/");
		var arToDate = stToValue.split("/");
		if (Date.parse("" + arFromDate[1] + "/" + arFromDate[0] + "/" + arFromDate[2] + "/") > Date.parse("" + arToDate[1] + "/" + arToDate[0] + "/" + arToDate[2] + "/")) {
			bReturn = false;
		}
		break;
	  default:
		if (stFromValue.toUpperCase() > stToValue.toUpperCase()) {
			bReturn = false;
		}
	}
	if ((!bReturn) && (messageFrame != null)) {
		if (errorPage == null) {
			errorPage = "../../eCommon/jsp/error.jsp";
		}
		var stMessage = getMessage("LESS_OR_EQUAL_VALIDATE", "ST");
		stMessage = stMessage.replace(/@/g, stLegend);
		messageFrame.location.href = errorPage + "?err_num=" + stMessage;
		toObj.focus();
	}
	return bReturn;
}
function updateMultiple() {
	var formObject = document.formItemForStoreMultipleDetail;
	var errorPage = "../../eCommon/jsp/error.jsp";
	var ItemAnalysis_legend_1 = getLabel("Common.ItemAnalysis.label", "Common") + " 1";
	var ItemAnalysis_legend_2 = getLabel("Common.ItemAnalysis.label", "Common") + " 2";
	var ItemAnalysis_legend_3 = getLabel("Common.ItemAnalysis.label", "Common") + " 3";
	if (!isSTValidFromToField(formObject.from_store_code, formObject.to_store_code, STRING, getLabel("Common.Store.label", "Common"), parent.parent.messageFrame, errorPage)) {
		formObject.from_store_code.readOnly=false;
		formObject.to_store_code.readOnly=false;
	
		return;
	}
	if (!isSTValidFromToField(formObject.from_item_code, formObject.to_item_code, STRING, getLabel("Common.item.label", "Common"), parent.parent.messageFrame, errorPage)) {
		formObject.to_item_code.readOnly=false;
		formObject.from_store_code.readOnly=false;
		return;
	}
	if (!isValidFromToField(formObject.m_item_analysis_from_1, formObject.m_item_analysis_to_1, STRING, ItemAnalysis_legend_1, parent.parent.messageFrame, errorPage)) {
		
		return;
	}
	if (!isSTValidFromToField(formObject.m_item_analysis_from_2, formObject.m_item_analysis_to_2, STRING, ItemAnalysis_legend_2, parent.parent.messageFrame, errorPage)) {
		return;
	}
	if (!isSTValidFromToField(formObject.m_item_analysis_from_3, formObject.m_item_analysis_to_3, STRING, ItemAnalysis_legend_3, parent.parent.messageFrame, errorPage)) {
		return;
	}
	var arrayObject = new Array();
	var names = new Array();
	if (parseFloat(formObject.m_min_stock_qty.value) > parseFloat(formObject.m_max_stock_qty.value)) {
		parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("MIN_CANNOT_EXCEED_MAX", "ST");
		formObject.m_min_stock_qty.focus();
		return;
	}
	if (parseFloat(formObject.m_reorder_level.value) > parseFloat(formObject.m_max_stock_qty.value)) {
		parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("REORDER_CANNOT_EXCEED_MAX", "ST");
		formObject.m_reorder_level.focus();
		return;
	}
	if (parseFloat(formObject.m_reorder_level.value) < parseFloat(formObject.m_min_stock_qty.value)) {
		parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("REORDER_CANNOT_LESS_THAN_MIN", "ST");
		formObject.m_reorder_level.focus();
		return;
	}
	parent.parent.messageFrame.location.href = errorPage;
	assignBean(formObject);
	xmlStr = getEnhancedXMLString(formObject);
	//xmlDom.loadXML(xmlStr);
	var xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", "../../eST/jsp/ItemForStoreValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=3", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
	parent.ItemForStoreListFrame.document.location.reload();
	parent.ItemForStoreTabFrame.document.location.reload();
}
function displayItemForStoreDtls(idx) {
	var errorPage = "../../eCommon/jsp/error.jsp";
	var itemCodeElement = document.querySelector('input[name="item_code_' + idx + '"]');
	var qryString = "item_code=" + itemCodeElement.value;
	//var qryString = "item_code=" + eval(document.formItemForStoreList.item_code_+" + idx + ").value;
	//qryString = qryString + "&store_code=" + eval(document.formItemForStoreList.store_code_+" + idx + ").value;
	var qryString = qryString + "&store_code=" + document.querySelector('input[name="store_code_' + idx + '"]').value;
    //qryString = qryString + "&mode=" + document.formItemForStoreList.mode.value;
    qryString = qryString + "&mode=" + document.querySelector('input[name="mode"]').value;
    parent.ItemForStoreTabFrame.location.href = "../../eST/jsp/ItemForStoreTab.jsp?" + qryString;
	parent.parent.messageFrame.location.href = errorPage;
}
async function searchStoreCode(objCode, objDesc) {
	if (!(objCode.disabled)) {
		var argumentArray = new Array();
		var dataNameArray = new Array();
		var dataValueArray = new Array();
		var dataTypeArray = new Array();
		dataNameArray[0] = "facility_id";
		dataValueArray[0] = document.formItemForStoreMultipleDetail.facility_id.value;
		dataTypeArray[0] = STRING;
		argumentArray[0] = escape(document.formItemForStoreMultipleDetail.SQL_ST_ITEM_STORE_LOOKUP.value) + "'" + document.formItemForStoreMultipleDetail.language_id.value + "'";
		argumentArray[1] = dataNameArray;
		argumentArray[2] = dataValueArray;
		argumentArray[3] = dataTypeArray;
		argumentArray[4] = "2,3";
		argumentArray[5] = objCode.value;
		argumentArray[6] = CODE_LINK;
		argumentArray[7] = CODE_DESC;
		returnedValues =await CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
		var ret1=unescape(returnedValues);
		 var arr=ret1.split(",");
			if(arr[1]==undefined) 
			{
				arr[0]="";	
				arr[1]="";	
			}

		if (returnedValues != null && returnedValues != "" && returnedValues!=undefined) {
			objCode.value = arr[0];
			objDesc.value = arr[1];
			objCode.readOnly = true;
		}
	}
}
async function searchItemCode(objCode, objDesc) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	argumentArray[0] = document.formItemForStoreSingleDetail.SQL_ST_ITEM_LOOKUP.value;
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
	returnedValues =await CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	if (returnedValues != null && returnedValues != "" && returnedValues!=undefined) {
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
		objDesc.readOnly = true;
	}
}
function clearSingleForm() {
	if (document.formItemForStoreSingleDetail != null) {
		if (document.formItemForStoreSingleDetail.editing.value == "1") {
			var formObject = document.formItemForStoreSingleDetail;
			formObject.item_desc.readOnly = false;
			formObject.dis_abled.value = "disabled";
			formObject.item_search.enabled = true;
			formObject.reset();
			formObject.bin_location_code.disabled = true;
			formObject.issue_uom.disabled = true;
			formObject.sales_allowed_yn.disabled = true;//Added against GHL-CRF-0456
			formObject.consumption_allowed_yn.disabled = true;//Added against GHL-CRF-0456
			if (!formObject.store_code.disabled) {
				formObject.store_code.focus();
			} else {
				formObject.stock_item_yn.focus();
			}
		} else {
			if (document.formItemForStoreSingleDetail.editing.value == "2") {
				parent.ItemForStoreTabFrame.document.location.href = "ItemForStoreTab.jsp?mode=" + MODE_INSERT;
			}
		}
	}
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	return;
}
function clearMultipleForm() {
	if (document.formItemForStoreMultipleDetail != null) {
		var formObject = document.formItemForStoreMultipleDetail;
		formObject.reset();
		formObject.from_store_code.disabled = false;
		formObject.to_store_code.disabled = false;
		formObject.from_item_code.disabled = false;
		formObject.to_item_code.disabled = false;
		formObject.from_store_code.focus();
	}
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	return;
}
function validateRecordsValues(formObject, msgFrame) {
	var errorPage = "../../eCommon/jsp/error.jsp";
	if (parseFloat(formObject.min_stock_qty.value) > parseFloat(formObject.max_stock_qty.value)) {
		msgFrame.location.href = errorPage + "?err_num=" + getMessage("MIN_CANNOT_EXCEED_MAX", "ST");
		formObject.min_stock_qty.focus();
		return false;
	}
	if (parseFloat(formObject.reorder_level.value) > parseFloat(formObject.max_stock_qty.value)) {
		msgFrame.location.href = errorPage + "?err_num=" + getMessage("REORDER_CANNOT_EXCEED_MAX", "ST");
		formObject.reorder_level.focus();
		return false;
	}
	if (parseFloat(formObject.reorder_level.value) < parseFloat(formObject.min_stock_qty.value)) {
		msgFrame.location.href = errorPage + "?err_num=" + getMessage("REORDER_CANNOT_LESS_THAN_MIN", "ST");
		formObject.reorder_level.focus();
		return false;
	}
	

	return true;
}
function setStoreFocus() {
	var formObject = document.formItemForStoreSingleDetail;
	setTimeout(document.getElementById("tab1").scrollIntoView(), 75);
	if (!formObject.store_code.disabled) {
		formObject.store_code.focus();
	}
}
function setFromStoreFocus() {

	
	setTimeout(document.getElementById("tab7").scrollIntoView(), 75);
	if( !document.formItemForStoreMultipleDetail.from_store_code.disabled ){
	document.formItemForStoreMultipleDetail.from_store_code.focus();
	}
}
function setItemDesc() {
	document.formItemForStoreSingleDetail.item_desc.title = document.formItemForStoreSingleDetail.item_desc.value;
}
async function callItemSearchScreen() {
	var formObject = document.formItemForStoreSingleDetail;
	if (formObject.store_code.value == "") {
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("STORE_CANNOT_BE_BLANK", "ST");
		formObject.store_code.focus();
		return;
	}
	var search_string = "";
	if (!formObject.item_desc.readOnly) {
		search_string = formObject.item_desc.value;
	}
	var store_code = "";
	var category = formObject.medical_item_yn.value;
	var sole_source = "A";
	var ps_item = "A";
	var mfg_item = "A";
	var expiry = "A";
	var consignment = "A";
	var item_class = "";
	
	var results =await callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment);
	if (results != null) {
		formObject.item_code.value = results[0];
		formObject.item_desc.value = results[1];
		if (formObject.item_code.value != "") {
			formObject.item_desc.readOnly = true;
		}
		assignBean(formObject);
		xmlStr = getEnhancedXMLString(formObject);
		//xmlDom.loadXML(xmlStr); 
		var xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("POST", "../../eST/jsp/ItemForStoreValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&request_uom=" + results[13] + "&function_type=4", false);
		xmlHttp.send(xmlDom);
		responseText = xmlHttp.responseText;
		eval(responseText);
		formObject.request_uom.value = results[13];
		formObject.issue_uom.value = results[13];
		formObject.consumption_allowed_yn.checked = true;//Added for GHL-CRF-0456
		formObject.consumption_allowed_yn.disabled = false;//Added for GHL-CRF-0456
		populateBinLocation();
		//defaultBinLocCode(formObject.store_code);
	}
}
async function callMultipleItemSearchScreen(item_code, item_desc) { 
	var search_string = "";
	if (!item_code.disabled) {
		search_string = item_code.value.toUpperCase();
	}
	var store_code = "";
	var category = "A";
	var sole_source = "A";
	var ps_item = "A";
	var mfg_item = "A";
	var expiry = "A";
	var results =await callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry);
	if (results != null) {
		item_code.value = results[0];
		item_desc.value = results[1];
		item_code.readOnly =true;
	}
}
//Thursday, July 01, 2004 
function Stk_item_create_Checked(store_code) {
	var formObj = document.formItemForStoreSingleDetail;
	if (formObj.stock_item_yn.checked == true) {
		formObj.reorder_freq_days.value = "";
		formObj.reorder_freq_days.disabled = true;
		formObj.lead_days.value = "";
		formObj.lead_days.disabled = false;
		formObj.min_stock_days.value = "";
		formObj.min_stock_days.disabled = false;
		formObj.min_stock_percentage.value = "";
		formObj.min_stock_percentage.disabled = false; 
		formObj.issue_uom.disabled = false;
		formObj.bin_location_code.disabled = false;
		document.getElementById("bin_mandiatory").style.visibility = "visible";
		if (store_code.value!= "") {
		defaultBinLocCode(store_code)	

		}

	} else {
		formObj.reorder_freq_days.disabled = false;
		formObj.reorder_freq_days.value = "";
		formObj.lead_days.value = "";
		formObj.lead_days.disabled = true;
		formObj.min_stock_days.value = "";
		formObj.min_stock_days.disabled = true;
		formObj.min_stock_percentage.value = "";
		formObj.min_stock_percentage.disabled = true;
		formObj.bin_location_code.value = ""; 
		formObj.issue_uom.disabled = true;
		formObj.bin_location_code.disabled = true;
		document.getElementById("bin_mandiatory").style.visibility = "hidden";
	}
}
//Thursday, July 01, 2004 Added by Phani
function Stk_itemChecked() {
	var formObj = document.formItemForStoreMultipleDetail;
	if (formObj.m_stock_item_yn.checked == true) {
		formObj.m_reorder_freq_days.value = "";
		formObj.m_reorder_freq_days.disabled = true;
		formObj.m_min_stock_percentage.value = "";
		formObj.m_min_stock_percentage.disabled = false;
		formObj.m_lead_days.value = "";
		formObj.m_lead_days.disabled = false;
		formObj.m_min_stock_days.value = "";
		formObj.m_min_stock_days.disabled = false;
	} else {
		formObj.m_reorder_freq_days.value = "";
		formObj.m_reorder_freq_days.disabled = false;
		formObj.m_min_stock_percentage.value = "";
		formObj.m_min_stock_percentage.disabled = true;
		formObj.m_lead_days.value = "";
		formObj.m_lead_days.disabled = true;
		formObj.m_min_stock_days.value = "";
		formObj.m_min_stock_days.disabled = true;
	}
}

//Thursday, July 01, 2004 
function Stk_item_qry_Checked() {
	var formObj = document.formItemForStoreModify;
	if (formObj.stock_item_yn.checked == true) {
		formObj.reorder_freq_days.value = "";
		formObj.reorder_freq_days.disabled = true;
		formObj.lead_days.disabled = false;
		formObj.min_stock_days.disabled = false;
		formObj.min_stock_percentage.disabled = false; 
		formObj.bin_location_code.disabled = false;
		formObj.phy_inv_type.disabled = false;
		formObj.phy_inv_count_per_year.disabled = false;
		document.getElementById("bin_mandiatory").style.visibility = "visible";
	} else {
		formObj.reorder_freq_days.value = "";
		formObj.reorder_freq_days.disabled = false;
		formObj.lead_days.disabled = true;
		formObj.min_stock_days.disabled = true;
		formObj.min_stock_percentage.disabled = true; 
		formObj.issue_uom.disabled = true;
		formObj.bin_location_code.disabled = true;
		formObj.bin_location_code.value = "";
		formObj.phy_inv_type.disabled = true;
		formObj.phy_inv_count_per_year.disabled = true;
		document.getElementById("bin_mandiatory").style.visibility = "hidden";
		if(document.formItemForStoreSingleDetail!=undefined){
		document.formItemForStoreSingleDetail.bin_location_code.value = "";
		}else{
			formObj.bin_location_code.value = "";
		}
	}
}
function setMedicalItem(medical_item_yn) {
	document.formItemForStoreSingleDetail.medical_item_yn.value = medical_item_yn;
}
function callSameForm() {
	parent.document.location.href = "../../eST/jsp/ItemForStoreMoreFields.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
}
//Added for GHL-CRF-0456 starts
function cons_Checked(){
	var formObj = document.formItemForStoreModify;
	if (formObj.consumption_allowed_yn.checked) {
		formObj.consumption_allowed_yn.value ="Y";
	}
	else
		formObj.consumption_allowed_yn.value = "N";
}
function sales_Checked(){
	var formObj = document.formItemForStoreModify;
	if (formObj.sales_allowed_yn.checked) {
		formObj.sales_allowed_yn.value ="Y";
	}
	else
		formObj.sales_allowed_yn.value = "N";
}
//Added for GHL-CRF-0456 ends
function eff_status_Checked() {
	var formObj = document.formItemForStoreModify;
	if (formObj.Eff_status.checked) {
		//Modified for IN:071344 start
		if(formObj.auto_rol_yn.value=="Y"){
			formObj.bin_location_code.disabled = false;
			formObj.stock_item_yn.disabled = false;
			formObj.reorder_freq_days.disabled = false;
			formObj.request_uom.disabled = false;
			formObj.Eff_status.value = "E";
			formObj.req_gen_stg.disabled = false;
		}
		else{
			formObj.min_stock_qty.disabled = false;
			formObj.bin_location_code.disabled = false;
			formObj.stock_item_yn.disabled = false;
			formObj.max_stock_qty.disabled = false;
			formObj.reorder_level.disabled = false;
			formObj.reorder_freq_days.disabled = false;
			formObj.request_uom.disabled = false;
			formObj.Eff_status.value = "E";
			formObj.req_gen_stg.disabled = false;
			formObj.reorder_qty.disabled = false;
		}
		//Modified for IN:071344 end

	} else {
		if(formObj.effect_change.value=="Y"){
		formObj.Eff_status.value = "D";
		formObj.min_stock_qty.disabled = true;
		formObj.bin_location_code.disabled = true;
		formObj.stock_item_yn.disabled = true;
		formObj.max_stock_qty.disabled = true;
		formObj.reorder_level.disabled = true;
		formObj.reorder_freq_days.disabled = true;
		formObj.lead_days.disabled = true;
		formObj.min_stock_days.disabled = true;
		formObj.min_stock_percentage.disabled = true;
		formObj.request_uom.disabled = true;
		formObj.issue_uom.disabled = true;
		formObj.req_gen_stg.disabled = true;
		formObj.reorder_qty.disabled = true;

		}else{
		
		formObj.Eff_status.checked=true;
		formObj.Eff_status.value = "E";
		alert(getMessage("UNFINALIZED_TRN_EXITS_ST_PARAM","ST"));
		return;

		}
	}
}
function chkReorderQty(max_qty, re_qty) {
	var formObj = parent.messageFrame;
	if (formObj == null || formObj == undefined) {
		formObj = parent.parent.messageFrame;
	}
	if (max_qty.value != "") {
		if (eval(re_qty.value) > eval(max_qty.value)) {
			formObj.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("RQTY_NOT_GRTR_MAX_STK", "ST");
			re_qty.focus();
		}
	}
}
function setBinLocCode(bin_loc_code) {
	document.formItemForStoreSingleDetail.bin_location_code.value = bin_loc_code;
}

function defaultBinLocCode(store_code){

	assignBean(document.formItemForStoreSingleDetail);
	var arrayObject = new Array();
	arrayObject[0] = store_code;
	xmlStr = getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	var xmlDom = "";
	var xmlHttp = new XMLHttpRequest();
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	xmlHttp.open("POST", "../../eST/jsp/ItemForStoreValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=5", false);
	xmlHttp.send(xmlDom);
		
	responseText = xmlHttp.responseText;
	eval(responseText);

//	alert('defaultBinLocCode after responseText')	

}

//Added for MMS-DM-CRF-0177 - Start

function checkSplChars(obj)	{
	if(!CheckChars(obj))	{
		alert(getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","PH"));
		obj.select();
	}
}

function ChkNumberInput1(fld,frmObj)
{
	var duration_value="";
	duration_value=fld.value;
	var check="0123456789";
	var durn_value_new="";
	for(i=0;i<duration_value.length;i++)
	{
		if(check.indexOf(duration_value.charAt(i))==-1){
			durn_value_new=durn_value_new;
		}
		else if(durn_value_new.length==0 && duration_value.charAt(i)==0){
			durn_value_new=durn_value_new;
		}
		else{
			durn_value_new+=duration_value.charAt(i);
		}
			
	}
	frmObj.durn_value.value = durn_value_new;
}

function applicableAllocation(near_expiry_appl,formObj){
	formObj.near_expiry_appl.value=near_expiry_appl;
	var chkdisable = formObj.near_expiry_appl.value;
	if(chkdisable=="E")
	  {
		formObj.durn_value.disabled = false;
		formObj.durn_type.disabled = false;
		formObj.expiry_stock_1.checked=true;
		formObj.expiry_stock_2.checked=false;
	  }
	else
	  {
		formObj.durn_value.disabled = true;
		formObj.durn_type.disabled = true;
		formObj.durn_value.value="";
		formObj.durn_type.value="N";
		formObj.expiry_stock_2.checked=true;
		formObj.expiry_stock_1.checked=false;
		formObj.durn_value_in_days.value="";
	 }
}

function ChkDuration(obj,obj1,formObj)
{
	var durn_type = formObj.durn_type.value;
		if(durn_type=='D'){
			obj = obj.value * 1
			}
		if(durn_type=='M'){
			obj = obj.value * 30
			}
		if(durn_type=='Y'){
			obj = obj.value * 365
			}
		formObj.durn_value_in_days.value=obj;
}

function validateDuration(obj1,obj2)
{
	var res=CheckNum(obj1);
	if(res!=undefined && res==true){
		if(obj2.value=='D'){
			return true;
			}
		if(obj2.value=='M'){
			return true;
				}
		if(obj2.value=='Y'){
			return true;
			}
	  }
}

function searchDrugYN()
{
	var formObj = document.formItemForStoreSingleDetail.all;
	formObj.pre_alloc_1.style.visibility = "visible";
	formObj.pre_check.style.visibility = "visible";
	formObj.durn_value_1.style.visibility = "visible";
	formObj.durn_type_1.style.visibility = "visible";
	formObj.expiry_stock_1.style.visibility = "visible";
	formObj.expiry_stock_2.style.visibility = "visible";
	formObj.pre_alloc_item_store.value="Y";
}

//Added for MMS-DM-CRF-0177 - End

//Added for MO-CRF-20172
function checkIntegerFormat1(obj, zeroNotAllowed) {
	if (zeroNotAllowed == null) {
		zeroNotAllowed = true;
	}
	//alert("checkIntegerFormat");
	if (obj.value == "") {
		return;
	}
	if (!isValidIntegerFormat(obj)) {
		alert(getMessage("INVALID_NUMBER_FORMAT", "PH")); 
		obj.focus();
		return false;
	} else {
		if ((parseFloat(obj.value) == 0) && zeroNotAllowed) {
			alert(getMessage("CANNOT_BE_ZERO", "ST"));  
			obj.focus();
			return false;
		}
	}
	return true;
}
function scrollToTab7() {
	var tab7 = document.getElementById('tab7');
	if (tab7) {
    	tab7.scrollIntoView();
        var formItem = document.forms['formItemForStoreMultipleDetail'];
        if (formItem && !formItem.from_store_code.disabled) {
        	formItem.from_store_code.focus();
        }
    }
}


