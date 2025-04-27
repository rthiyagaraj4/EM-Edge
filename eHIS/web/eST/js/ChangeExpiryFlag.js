/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
03/09/2020      IN073900            Haribabu                                MMS-DM-CRF-0174.2
---------------------------------------------------------------------------------------------------------
*/
function create() {
	f_query_add_mod.location.href = "../../eST/jsp/ChangeExpiryFlagFrame.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
}
function reset() {
	f_query_add_mod.location.reload();
}
function onSuccess() {
	f_query_add_mod.location.href = "../../eST/jsp/ChangeExpiryFlagFrame.jsp";
//	f_query_add_mod.location.href="../../eCommon/html/blank.html";
}
function callItemSearchScreenExpFlag(e,barcode) {//Added for GHL-CRF-413 starts
	if(e.keyCode==13 || e.keyCode== 9  || e.keyCode== 0){
		var bar_code	= barcode.value;
		if (bar_code != ''){
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/ChangeExpiryFlagValidate.jsp?validate=BARCODE&barcode=" + bar_code, false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			if(result){
				callItemSearchScreenForBarcode(bar_code);// Modified fro IN:073900
				 parent.frames[0].document.forms[0].barcode.value = "";
				 parent.frames[0].document.forms[0].barcode.disabled = true;
			}
			else{
				alert(getMessage("ST_INVALID_BAR_CODE", "ST"));
				parent.frames[0].document.forms[0].barcode.value = "";
				parent.frames[0].document.forms[0].barcode.disabled = false;
				parent.frames[0].document.forms[0].barcode.focus();
			}
		}
	}
}//Added for GHL-CRF-413 ends
async function callItemSearchScreen() {
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	var search_string = parent.frameChangeExpiryFlagHeader.document.formChangeExpiryFlagHeader.item_desc.value;
	var store_code = "";
	var category = "A";
	var sole_source = "A";
	var ps_item = "A";
	var mfg_item = "A";
	var expiry = "A";
	var consignment = "A";
	var item_class = "";
	//Modified by Sakti against AMS-CRF-0011 trn_type passing
	var retVal = await callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment,"CHANGE_EXP");
	if (retVal != null) {
		document.formChangeExpiryFlagHeader.item_code.value = retVal[0];
		document.formChangeExpiryFlagHeader.item_desc.disabled = true;
		document.formChangeExpiryFlagHeader.item_search.disabled = true;
		document.formChangeExpiryFlagHeader.item_desc.value = retVal[1];
		document.formChangeExpiryFlagHeader.expiry_yn.value = retVal[2];
		document.formChangeExpiryFlagHeader.trade_id_applicable_yn.value = retVal[17];
		document.formChangeExpiryFlagHeader.batch_id_applicable_yn.value = retVal[18];
		if (retVal[2] == "Y") {
			document.formChangeExpiryFlagHeader.expiry_yn.checked = true;
			document.formChangeExpiryFlagHeader.item_flag.value = "Y";
			document.formChangeExpiryFlagHeader.change_flag.value = "Y";
		} else {
			document.formChangeExpiryFlagHeader.expiry_yn.checked = false;
			document.formChangeExpiryFlagHeader.item_flag.value = "N";
			document.formChangeExpiryFlagHeader.change_flag.value = "N";
		}
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/ChangeExpiryFlagValidate.jsp?validate=QOH&item_code=" + retVal[0]+"&expiry_yn="+retVal[2], false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
//	alert(responseText)
		eval(responseText);
		parent.frameChangeExpiryFlagTabs.location.href = "../../eST/jsp/ChangeExpiryFlagTabs.jsp?item_code=" + retVal[0];
		parent.frameChangeExpiryFlagDetail.location.href = "../../eST/jsp/ChangeExpiryFlagEnterprise.jsp?item_code=" + retVal[0];

//added on 24/08/2004
		document.formChangeExpiryFlagHeader.expiry_yn.disabled = "true";
		//setExpiryFlag();
	}
}
function populateData(item_code, doc_srl_no, expiry_yn, batch_id_applicable_yn, trade_id_applicable_yn, uom) {
	parent.frameOpeningStockList.frameOpeningStockListHeader.location.href = "../../eST/jsp/OpeningStockListHeader.jsp?item_code=" + item_code + "&doc_srl_no=" + doc_srl_no + "&uom=" + uom;
	parent.frameOpeningStockList.frameOpeningStockListDetail.location.href = "../../eST/jsp/OpeningStockListDetail.jsp?item_code=" + item_code + "&doc_srl_no=" + doc_srl_no + "&expiry_yn=" + expiry_yn + "&batch_id_applicable_yn=" + batch_id_applicable_yn + "&uom=" + uom + "&trade_id_applicable_yn=" + trade_id_applicable_yn + "&uom=" + uom;
}
function ValidateItem(obj) {
	var formObj = parent.frameOpeningStockListHeader.document.formOpeningStockListHeader;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/OpeningStockValidate.jsp?validate=ITEM_CODE&search_code=" + escape(formObj.item_desc.value), false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
async function searchCodeItem(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	argumentArray[0] = document.forms[0].SQL_SS_ITEM_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
function populateEnterpise() {
	setExpiryFlag('TAB');
	var item_code = parent.frameChangeExpiryFlagHeader.document.formChangeExpiryFlagHeader.item_code.value;
	parent.frameChangeExpiryFlagDetail.location.href = "../../eST/jsp/ChangeExpiryFlagEnterprise.jsp?item_code=" + item_code;
}
function populateStore() {
	setExpiryFlag('TAB');
	var item_code = parent.frameChangeExpiryFlagHeader.document.formChangeExpiryFlagHeader.item_code.value;
	parent.frameChangeExpiryFlagDetail.location.href = "../../eST/jsp/ChangeExpiryFlagStore.jsp?item_code=" + item_code;
}
function populateBatch() {
	setExpiryFlag('TAB');
	var item_code = parent.frameChangeExpiryFlagHeader.document.formChangeExpiryFlagHeader.item_code.value;
	var expiry_yn = parent.frameChangeExpiryFlagHeader.document.formChangeExpiryFlagHeader.expiry_yn.checked;
	parent.frameChangeExpiryFlagDetail.location.href = "../../eST/jsp/ChangeBatchDetails.jsp?item_code=" + item_code + "&expiry_yn=" + expiry_yn;

//	parent.frameChangeExpiryFlagDetail.document.formChangeExpiryFlagDetail.expiry_date_or_receipt_date0.focus();
}
function setQty(qty) {
//	parent.frameChangeExpiryFlagHeader.document.formChangeExpiryFlagHeader.qoh.value=qty;
	if (qty != "null") {
		parent.frameChangeExpiryFlagHeader.document.getElementById("td_qoh").innerHTML = "<b>" + qty + "</b>";
	} else {
		parent.frameChangeExpiryFlagHeader.document.getElementById("td_qoh").innerHTML = "<b>" + "0" + "</b>";
	}
}
function enableDisableExpiryFlag() {
	var flag1 = parent.frameChangeExpiryFlagHeader.document.formChangeExpiryFlagHeader.change_flag.value;
	var flag2 = parent.frameChangeExpiryFlagHeader.document.formChangeExpiryFlagHeader.expiry_yn.value;
	noRecords = document.formChangeExpiryFlagEnterprise.noRecords.value;
	change_flag_ph_item_assoc_check = parent.frameChangeExpiryFlagHeader.document.formChangeExpiryFlagHeader.change_flag_ph_item_assoc_check.value;
	if (noRecords == "true" || change_flag_ph_item_assoc_check == "Y") {
		parent.frameChangeExpiryFlagHeader.document.formChangeExpiryFlagHeader.expiry_yn.disabled = true;
		parent.frameChangeExpiryFlagHeader.document.formChangeExpiryFlagHeader.finalize.value = "true";
	} else {
		if (noRecords == "false" && (flag1 == flag2)) {
			parent.frameChangeExpiryFlagHeader.document.formChangeExpiryFlagHeader.expiry_yn.disabled = false;
			parent.frameChangeExpiryFlagHeader.document.formChangeExpiryFlagHeader.finalize.value = "false";
		}
	}
	parent.frameChangeExpiryFlagHeader.document.formChangeExpiryFlagHeader.noPendingRecords.value= noRecords;
}
async function callBatchSearch(store_code) {
	var retVal = await window.showModalDialog("../jsp/ChangeBatchDetails.jsp?store_code=" + store_code, "dialogHeight:20vh; dialogWidth: 40vw; center: 1; status: no; dialogTop :150;");
	if (!(retVal == null)) {
	}
}
function checkSysdate(obj, sysdate) {
	if (CheckDate(obj)) {
		var expiry_yn = document.formChangeBatchDetails.expiry_date.value;
		if (expiry_yn == "Y") {
			if (checkDateWithSysDate(obj, sysdate)) {
				alert(getMessage("NOT_LESS_THAN_SYSDATE", "ST"));
				obj.select();
				obj.focus();
				return false;
			}
		} else {
			if (expiry_yn == "N") {
		//date validation ????
			}
		}
	} else {
		return false;
	}
}
function setExpiryFlag(From) {
	var expiry_yn = "";
	var formObj = document.formChangeExpiryFlagHeader;
	if (formObj == null) {
		formObj = parent.frames[0].document.formChangeExpiryFlagHeader;
	}
	if (formObj.expiry_yn.checked) {
		expiry_yn = "Y";
		//document.formChangeExpiryFlagHeader.expiry_yn.disabled="true";
		formObj.expiry_yn.value = "Y";
		formObj.change_flag.value = "Y";
	} else {
		expiry_yn = "N";
			//document.formChangeExpiryFlagHeader.expiry_yn.disabled="true";
		formObj.expiry_yn.value = "N";
		formObj.change_flag.value = "N";
	}
		
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/ChangeExpiryFlagValidate.jsp?validate=EXPIRY&expiry_yn=" + formObj.expiry_yn.value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
//	alert(responseText)
	eval(responseText);

	if(From == "CB" && parent.frames[2].document.forms[0].name == "formChangeBatchDetails"){
		
	   parent.frames[2].location.href = "../../eST/jsp/ChangeBatchDetails.jsp?item_code=" + formObj.item_code.value + "&expiry_yn=" + formObj.expiry_yn.value;
	   
	}
}

// TO know if the user has gone to the Batch Details TAB
function tab3Selected() {
	parent.frameChangeExpiryFlagHeader.document.formChangeExpiryFlagHeader.tab3Selected.value = "Yes";
}

//If the user clicks on 'APPLY' when not in Batch Details TAB, but has gone to that TAB once
function loadBatchDetails() {
	//var formObj = parent.frames[2].document.forms[0];
	//var formObj1 = parent.frames[0].document.forms[0];
	//var batchCount = parent.frames[2].document.forms[0].batchCount.value;
	var formObj=  parent.frameChangeExpiryFlagDetail.document.forms[0];
	var batchCount = parent.frameChangeExpiryFlagDetail.document.getElementById('batchCount').value;
	var expiry_yn = parent.frameChangeExpiryFlagHeader.document.getElementById('expiry_yn').value;
	var batchreload = parent.frameChangeExpiryFlagHeader.document.getElementById('batch_reload').value;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getEnhancedXMLString(formObj));
	xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObj), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/ChangeExpiryFlagValidate.jsp?validate=BATCH_DETAILS&batchCount=" + batchCount+"&batchchange="+batchreload+"&expiry_yn="+expiry_yn, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	//alert(responseText)
	eval(responseText);
}
function loadBatchDetails1() {
//	var formObj=  parent.frameChangeExpiryFlagDetail.document.formChangeExpiryFlagDetails;
	var formObj = f_query_add_mod.frames[2].document.forms[0];
	var batchCount = f_query_add_mod.frames[2].document.forms[0].batchCount.value;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getEnhancedXMLString(formObj));
	xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObj), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/ChangeExpiryFlagValidate.jsp?validate=BATCH_DETAILS&batchCount=" + batchCount, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	//alert(responseText)
	eval(responseText);
}
function apply() {
	
	var errorPage = "../../eCommon/jsp/error.jsp";
	var formObj = f_query_add_mod.frameChangeExpiryFlagDetail.document.formChangeBatchDetails;
	var formObj1 = f_query_add_mod.frameChangeExpiryFlagHeader.document.formChangeExpiryFlagHeader;
	var fields = new Array(formObj1.item_desc);
	var names = new Array(getLabel("Common.ItemCode.label", "Common"));
	var blankObj = null;
	blankObject = getBlankField(fields, names, messageFrame, errorPage);
	if (blankObject == null) {
		if (formObj1.finalize.value == "false") {
			if ((f_query_add_mod.frames[2].document.forms[0].name == "formChangeBatchDetails") && (formObj1.finalize.value == "false")) {
				loadBatchDetails1();
			} else {
				var item_code = f_query_add_mod.frameChangeExpiryFlagHeader.document.formChangeExpiryFlagHeader.item_code.value;
				var expiry_yn = f_query_add_mod.frameChangeExpiryFlagHeader.document.formChangeExpiryFlagHeader.expiry_yn.checked;
				f_query_add_mod.frames[2].location.href = "../../eST/jsp/ChangeBatchDetails.jsp?item_code=" + item_code + "&expiry_yn=" + expiry_yn + "&applyOnLoad=Yes";
				return;
			}
			f_query_add_mod.frames[2].document.forms[0].item_code.value = f_query_add_mod.frameChangeExpiryFlagHeader.document.formChangeExpiryFlagHeader.item_code.value;
			if (f_query_add_mod.frameChangeExpiryFlagHeader.document.formChangeExpiryFlagHeader.expiry_yn.checked) {
				f_query_add_mod.frames[2].document.forms[0].expiry_yn.value = "Y";
			} else {
				f_query_add_mod.frames[2].document.forms[0].expiry_yn.value = "N";
			}
			var responseText = formApply(formObj, ST_CONTROLLER);
			eval(responseText);
			messageFrame.location.href = errorPage + "?err_num=" + message;
			if (result) {
				onSuccess();
			}
		} else {
			if(formObj1.change_flag_ph_item_assoc_check.value == "Y" && (formObj1.noPendingRecords.value == "false")){
				 messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + getMessage("ST_EXPIRY_FLAG_NOT_CHANGED_FOR_DRUGS", "ST");
			}  
			else{
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + getMessage("PEND_TRANS", "ST");
			}
		}
	} else {
	
		//blankObject.focus();
	}
}
function setFlagForPHAssoc(stPHAssocaited) {

	var formObj = document.formChangeExpiryFlagHeader;
	if (stPHAssocaited == "Y") {
		formObj.change_flag_ph_item_assoc_check.value = "Y";
	} else {
		formObj.change_flag_ph_item_assoc_check.value = "N";
	}
}

function setBatchReload(value){
	parent.frames[0].document.forms[0].batch_reload.value=value;
}


function checkSameBatchExpiry(obj,batch_id,row){ 	
	 var  expiry_date= obj.value;
	 var duplicate_batch_id = new Array();
	 var batch_id_count =0;
	 var expiry_date_modify_flag ="N";
	 for(i=0;i<arr_batch_id.length;i++){
		if(batch_id == arr_batch_id[i] && (i!=row)){
			duplicate_batch_id[batch_id_count]=i;
			batch_id_count++;
			if(obj.value!=(eval("document.forms[0].expiry_date_or_receipt_date"+i).value)){
				expiry_date_modify_flag="Y";
			}
		}
	 }
	 if(batch_id_count>0 && expiry_date_modify_flag=="Y"){			 
		 if(confirm(getMessage("EXPIRY_DATE_CHANGE_OF_IDENTICAL_BATCHES","ST")+" " +expiry_date)){
		   for(j=0;j<batch_id_count;j++){
			eval("document.forms[0].expiry_date_or_receipt_date"+duplicate_batch_id[j]).value = expiry_date;		
		   }
		 }else{
		   obj.value = eval("document.forms[0].expiry_date_or_receipt_date"+duplicate_batch_id[0]).value;
		 }	   
		 
	 }
}
// Modified for IN:073900 start
async function callItemSearchScreenForBarcode(barcode_id) {
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	var search_string = parent.frameChangeExpiryFlagHeader.document.formChangeExpiryFlagHeader.item_code.value;
	var store_code = "";
	var category = "A";
	var sole_source = "A";
	var ps_item = "A";
	var mfg_item = "A";
	var expiry = "A";
	var consignment = "A";
	var item_class = "";
	var retVal = await callItemSearchWindow1(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment,"CHANGE_EXP",barcode_id);
	if (retVal != null) {
		document.formChangeExpiryFlagHeader.item_code.value = retVal[0];
		document.formChangeExpiryFlagHeader.item_desc.disabled = true;
		document.formChangeExpiryFlagHeader.item_search.disabled = true;
		document.formChangeExpiryFlagHeader.item_desc.value = retVal[1];
		document.formChangeExpiryFlagHeader.expiry_yn.value = retVal[2];
		document.formChangeExpiryFlagHeader.trade_id_applicable_yn.value = retVal[17];
		document.formChangeExpiryFlagHeader.batch_id_applicable_yn.value = retVal[18];
		if (retVal[2] == "Y") {
			document.formChangeExpiryFlagHeader.expiry_yn.checked = true;
			document.formChangeExpiryFlagHeader.item_flag.value = "Y";
			document.formChangeExpiryFlagHeader.change_flag.value = "Y";
		} else {
			document.formChangeExpiryFlagHeader.expiry_yn.checked = false;
			document.formChangeExpiryFlagHeader.item_flag.value = "N";
			document.formChangeExpiryFlagHeader.change_flag.value = "N";
		}
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/ChangeExpiryFlagValidate.jsp?validate=QOH&item_code=" + retVal[0]+"&expiry_yn="+retVal[2], false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		parent.frameChangeExpiryFlagTabs.location.href = "../../eST/jsp/ChangeExpiryFlagTabs.jsp?item_code=" + retVal[0];
		parent.frameChangeExpiryFlagDetail.location.href = "../../eST/jsp/ChangeExpiryFlagEnterprise.jsp?item_code=" + retVal[0];
		document.formChangeExpiryFlagHeader.expiry_yn.disabled = "true";
	}
}
// Modified for IN:073900 end
