/*
 ------------------------------------------------------------------------------------------------------------------------------
Date		Edit History		Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
??
19/04/2017		63866			B.Badmavathi								     To change pack size
20/04/2017		63281			B.Badmavathi								     To display Available Quantity at Request Store 
08/10/2018      68642           B.Haribabu                                       TTM-SCF-0198
02/12/2019      71868          	Haribabu                                       	GHL-SCF-1471
20/10/2021		TFS-24350			Shazana		20/10/2021		Manickam		MO-CRF-20173
-------------------------------------------------------------------------------------------------------------------------------
*/
var xmlDom;
var xmlHttp;
var flag = true;
var trObject;
var close_check; //Addded for TTM-SCF-0198
function assignBean(frmObject) {
	bean_id = frmObject.bean_id.value;
	bean_name = frmObject.bean_name.value;
	//xmlDom = new ActiveXObject("Microsoft.XMLDom");
	//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	xmlDom = "";
	xmlHttp = new XMLHttpRequest();
}
function create() {
	f_query_add_mod.location.href = "../../eST/jsp/AuthorizeAtIssueStoreCreateFrame.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
}
function reset() {
	f_query_add_mod.location.reload();
}
async function query() {
	f_query_add_mod.location.href = "../../eCommon/html/blank.html";
	var retVal = await window.showModalDialog("../../eST/jsp/RequisitionIssueAuthorizeFrame.jsp?function_id=" + parent.parent.function_id, "", "dialogHeight:65vh; dialogWidth:60vw; center:0; status: no; dialogLeft :35; dialogTop :100;");
	if (retVal != null) {
		f_query_add_mod.location.href = "../../eST/jsp/AuthorizeAtIssueStoreFrame.jsp?mode=" + MODE_MODIFY + "&function_id=" + function_id + "&doc_type_code=" + retVal[0] + "&doc_no=" + retVal[1] + "&req_facility_id=" + retVal[2] + "&item_class_code=" + retVal[4] + "&item_class_desc=" + retVal[3];
	}
}

function onSuccess() {
	f_query_add_mod.location.href = "../../eCommon/html/blank.html";
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + message + "<BR>" + flag;
	return;
}
function resetDetail() {
	document.location.href = "../../eST/jsp/AuthorizeAtIssueStoreDetail.jsp?mode=" + MODE_INSERT + "&function_id=" + document.formAuthorizeAtIssueStoreDetail.function_id;
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
}
async function apply() {
	var errorPage = "../../eCommon/jsp/error.jsp";
	if(f_query_add_mod.AuthorizeAtIssueStoreHeaderFrame==undefined){
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" ;
	return;


	}
	var formHeader = f_query_add_mod.AuthorizeAtIssueStoreHeaderFrame.document.formAuthorizeAtIssueStoreHeader;
	//Added by Rabbani #inc no:29579 on 23/01/12 Starts
        if(f_query_add_mod.AuthorizeAtIssueStoreListFrame.document.formAuthorizeAtIssueStoreList.mode.value == MODE_INSERT){ 
       var locale =  f_query_add_mod.AuthorizeAtIssueStoreListFrame.document.formAuthorizeAtIssueStoreList.locale.value;
     }else{ 
	 var locale = formHeader.locale.value; 
	 }
formHeader.doc_date.value = convertDate(formHeader.doc_date.value, "DMY", locale, "en");
 //ends
	//if(formHeader.mode.value==1){
	/*current pending request checking */
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/AuthorizeAtIssueStoreValidate.jsp?bean_id=authorizeAtIssueStoreBean&bean_name=eST.AuthorizeAtIssueStoreBean&request_on_store_code=" + formHeader.request_by_store_code.value + "&function_type=16" , false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
		if(result){
		//retVal = window.showModalDialog("../../eST/jsp/PendingRequests.jsp?bean_id=authorizeAtIssueStoreBean&bean_name=eST.AuthorizeAtIssueStoreBean&request_on_store_code=" + formHeader.request_by_store_code.value, "", "dialogHeight:20; dialogWidth:41; center:0; status: no; dialogLeft :250; dialogTop :250;scroll:no");
		//Modified against TTM-SCF-0112,TTM-SCF-0124 on 22-05-2015
		retVal = await window.showModalDialog("../../eST/jsp/PendingRequests.jsp?bean_id=authorizeAtIssueStoreBean&bean_name=eST.AuthorizeAtIssueStoreBean&request_on_store_code=" + formHeader.request_by_store_code.value, "", "dialogHeight:70vh; dialogWidth:60vw; center:0; status: no; dialogLeft :350; dialogTop :175;scroll:no");
		if(retVal!=undefined){

		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;	
		xmlStr ="<root><SEARCH ";
		xmlStr += "values=\""+ retVal +"\" " ;
		xmlStr += "mode=\""+ formHeader.mode.value +"\" " ;
		xmlStr += "bean_id=\"authorizeAtIssueStoreBean\" ";
		xmlStr += "bean_name=\"eST.AuthorizeAtIssueStoreBean\" ";
		xmlStr +=" /></root>" ;		
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
		xmlHttp.open( "POST", "AuthorizeAtIssueStoreValidate.jsp?function_type=17", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);
		if(result){
		messageFrame.location.href = errorPage + "?err_num="+ getMessage("MIN_ONE_DETAIL_REQUIRED", "Common");
		return false;
		}
		}else{
			messageFrame.location.href = errorPage + "?err_num=";
			return false;
		}
	}
	//}

//return;
	var bean_id = "authorizeAtIssueStoreBean";
	var bean_name = "eST.AuthorizeAtIssueStoreBean";
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/AuthorizeAtIssueStoreValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=5" + "&checked=" + formHeader.close_upon_issue_yn.checked, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);

	if (!result) {
		messageFrame.location.href = errorPage + "?err_num=" + message;
		return;
	} else {
		
		if (f_query_add_mod.AuthorizeAtIssueStoreListFrame.document.formAuthorizeAtIssueStoreList.records.value > 1) {
			
				var responseText = formApply(formHeader, ST_CONTROLLER);
				eval(responseText);
			flag1 = (flag.split("~"))[0];
			flag2 = (flag.split("~"))[1];
			flag1 = (flag1 == "null" ? "" : flag1);
			if (result) {
				if (flag2 == "PY") {
						var PConfirm = await confirmPrinting();
					if (PConfirm == "Yes") {
						var xmlHttp = new XMLHttpRequest();
						var xmlDoc="";
						//xmlDoc.loadXML(getXMLString(null));
						xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
						//xmlHttp.open("POST", "../../eST/jsp/AuthorizeAtIssueStoreValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=8&msg=" + encodeURIComponent(message), false);
						xmlHttp.open("POST", "../../eST/jsp/AuthorizeAtIssueStoreValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=8&msg=" + encodeURIComponent(message), true);
						xmlHttp.send(xmlDoc);
						//responseText = xmlHttp.responseText;
						//eval(responseText);
					}
					  
				} else if (flag2 == "PN") {
			
						var xmlHttp = new XMLHttpRequest();
						var xmlDoc="";
						//xmlDoc.loadXML(getXMLString(null));
						xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
						//xmlHttp.open("POST", "../../eST/jsp/AuthorizeAtIssueStoreValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=8&msg=" + encodeURIComponent(message), false);
						xmlHttp.open("POST", "../../eST/jsp/AuthorizeAtIssueStoreValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=8&msg=" + encodeURIComponent(message), true);
						xmlHttp.send(xmlDoc);
						//responseText = xmlHttp.responseText;
						//eval(responseText);
					}
				messageFrame.location.href = errorPage + "?err_num=" + message + "<BR>" + (result ? flag1 : "");
				onSuccess();
			}
			if (result) {
				messageFrame.location.href = errorPage + "?err_num=" + message + "<BR>" + flag1;
			} else {
				if (message == "REQ_QTY_NOT_GR_PEND_QTY<BR>") {
					
					//messageFrame.location.href = errorPage + "?err_num=" + getMessage("REQ_QTY_NOT_GR_PEND_QTY", "ST");
					messageFrame.location.href = errorPage + "?err_num=" + getMessage("REQ_QTY_NOT_GR_PEND_QTY", "ST") + " (Item : " +flag1+" )";// decodeURIComponent(flag1,"UTF-8") GHL-SCF-1097
				} else {  //Added by Rabbani #Inc no:28775 on 19/10/12  
					if (message == "RECORD_UPDATED_BY_OTH_USER<BR>") {
					messageFrame.location.href = errorPage + "?err_num=" + getMessage("RECORD_UPDATED_BY_OTH_USER", "ST");
				} else {
					messageFrame.location.href = errorPage + "?err_num=" + getMessage("AUTH_QTY_CANNOT_BE_ZERO", "ST");
					}
				}
			} 

			if (flag == null || flag == "") {
			} else {
				//Added by suresh.r against ML-BRU-SCF-1005[IN:43173] on 28-04-2014
				//if (message == "APP-ST0040 Insufficient batch quantity<BR>") {
				if (message == "APP-ST0043 Insufficient batch quantity") {	
					messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + message + "  (Item : " +flag1 + "  )  ";//decodeURIComponent(flag1,"UTF-8") GHL-SCF-1097
					f_query_add_mod.AuthorizeAtIssueStoreListFrame.document.location.reload();
				} else {

				
				}
			}
			
			return;
		} else {
			messageFrame.location.href = errorPage + "?err_num=" + getMessage("MIN_ONE_DETAIL_REQUIRED", "Common");       
			return;
		}
	}
}
function loadRequestDetail(trObj, req_facility_id) {
	var doc_info = new Array();
	doc_info[0] = trObj.cells[7].innerText;
	doc_info[1] = trObj.cells[2].innerText;
	doc_info[2] = req_facility_id;
	doc_info[3] = trObj.cells[6].innerText;
	doc_info[4] = trObj.cells[8].innerText;
	window.returnValue = doc_info;
	window.close()
}

var prevObj = null;
var prevColor = null;
var prevSerColor = null;
function changeRowColor(obj) {
	if (prevObj != null) {
		if(document.formAuthorizeAtIssueStoreList.view_cost.value=='N')
	{
		for (k = 1; k < 9; k++) {//8 Modified for MMS-DM-CRF-0097
			prevObj.cells[k].className = prevColor;
		}
		prevObj.cells[0].className = prevSerColor;
	}
	if(document.formAuthorizeAtIssueStoreList.view_cost.value=='Y')
	{
		for (k = 1; k < 11; k++) {//10 Modified for MMS-DM-CRF-0097
			prevObj.cells[k].className = prevColor;
		}
		prevObj.cells[0].className = prevSerColor;
	}
	}
	prevObj = obj;
	prevColor = obj.cells[1].className;
	prevSerColor = obj.cells[0].className;
	if(document.formAuthorizeAtIssueStoreList.view_cost.value=='N')
	{
	for (k = 1; k < 9; k++) {//8 Modified for MMS-DM-CRF-0097
		obj.cells[k].className = "STLIGHTPINK";
	}
	}
	if(document.formAuthorizeAtIssueStoreList.view_cost.value=='Y')
	{
	for (k = 1; k < 11; k++) {//10 Modified for MMS-DM-CRF-0097
		obj.cells[k].className = "STLIGHTPINK";
	}
	}
}
function changeSetRowColor(obj) {
	if (prevObj != null) {
		if(document.formAuthorizeAtIssueStoreList.view_cost.value=='N')
	{
		for (k = 1; k < 9; k++) {//8 Modified for MMS-DM-CRF-0097
			prevObj.cells[k].className = prevColor;
		}
		prevObj.cells[0].className = prevSerColor;
	}
	if(document.formAuthorizeAtIssueStoreList.view_cost.value=='Y')
		{
		for (k = 1; k < 11; k++) {//10 Modified for MMS-DM-CRF-0097
			prevObj.cells[k].className = prevColor;
		}
		prevObj.cells[0].className = prevSerColor;
		}
	}

	prevObj = obj;
	prevColor = obj.cells[1].className;
	prevSerColor = obj.cells[0].className;
	if(document.formAuthorizeAtIssueStoreList.view_cost.value=='Y')
		{
	for (k = 1; k < 11; k++) {//10 Modified for MMS-DM-CRF-0097
		obj.cells[k].className = "STLIGHTCREAM";
	}
		}
		if(document.formAuthorizeAtIssueStoreList.view_cost.value=='N')
	{
			for (k = 1; k < 9; k++) {//8 Modified for MMS-DM-CRF-0097
		obj.cells[k].className = "STLIGHTCREAM";
	}
		}

}
function displayItemDetail(idx) {
	var formHeader = parent.AuthorizeAtIssueStoreHeaderFrame.document.formAuthorizeAtIssueStoreHeader;
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
	var item_code = eval("document.formAuthorizeAtIssueStoreList.item_code_" + idx + ".value");
	var item_qty = eval("document.formAuthorizeAtIssueStoreList.issuing_item_qty_" + idx + ".value");
	var trObject = eval(document.getElementById('tr_' + idx));
	changeRowColor(trObject);
	parent.AuthorizeAtIssueStoreDetailFrame.document.location.href = "../../eST/jsp/AuthorizeAtIssueStoreDetail.jsp?mode=" + MODE_MODIFY + "&function_id=" + parent.parent.function_id + "&item_code=" + item_code + "&request_by_store_code=" + formHeader.request_by_store_code.value + "&request_on_store_code=" + formHeader.request_on_store_code.value + "&edit=" + formHeader.mode.value;
	/*var store_code = parent.AuthorizeAtIssueStoreHeaderFrame.document.formAuthorizeAtIssueStoreHeader.from_store_code.value;
	var formObj1 = parent.AuthorizeAtIssueStoreHeaderFrame.document.formAuthorizeAtIssueStoreHeader;
	var formObj = document.formAuthorizeAtIssueStoreDetail;
	parent.AuthorizeAtIssueStoreBatchSearchFrame.document.location.href = "../../eST/jsp/AuthorizeAtIssueStoreBatchSearch.jsp?function=changebatch&batchsearch=newbatch&store_code=" + store_code + "&item_code=" + item_code + "&item_qty=" + item_qty + "&function_id" + parent.parent.function_id + "&doc_type_code" + formObj1.doc_type_code.value + "&trn_type" + formObj1.trn_type.value + "&doc_no" + formObj1.doc_no.value + "&index=" + formObj.index.value;
	*/
}
function updateItemRecord() {
	var formObject = document.formAuthorizeAtIssueStoreDetail;
	var formHeader = parent.AuthorizeAtIssueStoreHeaderFrame.document.formAuthorizeAtIssueStoreHeader;//26677
	if(formHeader.close_upon_issue_yn.checked && formObject.close_item.checked){
		alert(getMessage("CANNOT_USE_ITEM_DOCUMENT_LEVEL_CLOSE", "ST"));
		formObject.close_item.checked=false;
		formObject.document.getElementById("Remarkslabel").style.visibility="hidden";  
		return;
	}//end 
	var errorPage = "../../eCommon/jsp/error.jsp";
	if(formObject.iss_uom_qty_chk.value == ""){//Added for ML-MMOH-SCF-0635 starts
		formObject.iss_uom_qty_chk.value = formObject.iss_uom_qty.value;
	}
	if(formObject.total_batch_qty.value == 0){
		formObject.total_batch_qty.value = "";
	}//Added for ML-MMOH-SCF-0635 ends
	/*var closeItemYN = "N";//MO-CRF-20173 START
	if (formObject.close_item.checked) {
		closeItemYN = "Y";
	}*/ //END 
	
	if(document.formAuthorizeAtIssueStoreDetail.allow_batch_search.value == "Y"){
	if((parseFloat(formObject.iss_uom_qty_chk.value) == parseFloat(formObject.iss_uom_qty.value)) && formObject.total_batch_qty.value == "" ){
		//if (document.formAuthorizeAtIssueStoreDetail.allow_remarks.value == "N" && (parseFloat(document.formAuthorizeAtIssueStoreDetail.iss_uom_qty.value) != parseFloat(document.formAuthorizeAtIssueStoreDetail.iss_uom_qty_chk.value))) {
		if (document.formAuthorizeAtIssueStoreDetail.allow_remarks.value == "N" && (parseFloat(document.formAuthorizeAtIssueStoreDetail.iss_uom_qty.value) != parseFloat(document.formAuthorizeAtIssueStoreDetail.pending_item_qty_chk.value))) {
		var arrayObject = new Array(formObject.req_item_qty, formObject.issuing_qty,formObject.remarks_desc);
		var names = new Array(getLabel("Common.ReqQuantity.label", "Common"), getLabel("Common.IssueQuantity.label", "Common"), getLabel("Common.remarks.label", "Common"));
		document.formAuthorizeAtIssueStoreDetail.remarks_mandatory.style.visibility = "visible";
	}else{
		var arrayObject = new Array(formObject.req_item_qty, formObject.issuing_qty);
		var names = new Array(getLabel("Common.ReqQuantity.label", "Common"), getLabel("Common.IssueQuantity.label", "Common"));
	}	
	var blankObject = checkSTFields(arrayObject, names, parent.parent.messageFrame, errorPage);
	if (blankObject != true) {
		return;
	}else{
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="
	}
	var formHeader = parent.AuthorizeAtIssueStoreHeaderFrame.document.formAuthorizeAtIssueStoreHeader;
	if (formHeader != null) {
		formObject.request_by_store_code.value = formHeader.request_by_store_code.value;
		formObject.request_on_store_code.value = formHeader.request_on_store_code.value;
	}
	if (formObject.mode.value == "1") {
		if (parseFloat(formObject.issuing_qty.value) / parseFloat(formObject.frm_tmp_conv.value) > parseFloat(formObject.qty_on_store.value)) {
			parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("REQ_QTY_NOT_GR_PEND_QTY", "ST");
			return;
		}
	}
	if (formObject.mode.value == "2") {
		if (parseFloat(formObject.issuing_qty.value) / parseFloat(formObject.frm_tmp_conv.value) > parseFloat(formObject.qty_on_store.value)) {
			parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("REQ_QTY_NOT_GR_PEND_QTY", "ST");
			return;
		}
	}		

	if (parseFloat(formObject.req_item_qty.value) <= 0) {
		parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("REQ_QTY_CANNOT_BE_ZERO", "ST");
		return;
	}
	var stock_item_yn = "N";
	if (formObject.mode.value == "1") { 
	}
	if (formObject.stock_item_yn.checked) {
		stock_item_yn = "Y";
	}

	// update exp records
	
		var bean_id = "authorizeAtIssueStoreBean";
		var bean_name = "eST.AuthorizeAtIssueStoreBean";
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getEnhancedXMLString(formObject));
		xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObject), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/AuthorizeAtIssueStoreValidate.jsp?item_code=" + formObject.item_code.value+ "&function_type=20&bean_id=" + bean_id + "&bean_name=" + bean_name, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		window.close();  
	
	//end 
	
	
	
	formObject.stock_item_yn.value = stock_item_yn;
	assignBean(formObject);
	xmlStr = getEnhancedXMLString(formObject);
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/AuthorizeAtIssueStoreValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=1", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
	message = getMessage(message, "ST");
	if (!result) {
		parent.parent.messageFrame.location.href = errorPage + "?err_num=" + message;
		return;
	}
	document.location.href = "../../eST/jsp/AuthorizeAtIssueStoreDetail.jsp?mode=" + MODE_INSERT + "&function_id=" + parent.parent.function_id;
	parent.AuthorizeAtIssueStoreListFrame.document.location.href = "../../eST/jsp/AuthorizeAtIssueStoreList.jsp?item_code=" + formObject.item_code.value + "&mode=" + MODE_INSERT + "&function_id=" + parent.parent.function_id;
	}else{
	
	//Added By Sakti Sankar on 14/05/2013 to allow modify zero authorized record 
	if(formObject.total_batch_qty.value == "") {
		formObject.total_batch_qty.value = 0;
	}
	//Added ends
	if(formObject.iss_uom_qty.value==""){//Added for ML-MMOH-SCF-0635
		parent.parent.messageFrame.location.href = errorPage + "?err_num=" + "APP-000001 Authorize Quantity Cannot be blank";
		return;
	} 
	if(parseFloat(formObject.total_batch_qty.value) == parseFloat(formObject.issuing_qty.value)){	//Modified iss_uom_qty to issuing_qty against ML-BRU-SCF-1710
	
	//if (document.formAuthorizeAtIssueStoreDetail.allow_remarks.value == "N" && (parseFloat(document.formAuthorizeAtIssueStoreDetail.iss_uom_qty.value) != parseFloat(document.formAuthorizeAtIssueStoreDetail.iss_uom_qty_chk.value))) {
	if (document.formAuthorizeAtIssueStoreDetail.allow_remarks.value == "N" && (parseFloat(document.formAuthorizeAtIssueStoreDetail.iss_uom_qty.value) != parseFloat(document.formAuthorizeAtIssueStoreDetail.pending_item_qty_chk.value))) {
		var arrayObject = new Array(formObject.req_item_qty, formObject.issuing_qty,formObject.remarks_desc);
		var names = new Array(getLabel("Common.ReqQuantity.label", "Common"), getLabel("Common.IssueQuantity.label", "Common"), getLabel("Common.remarks.label", "Common"));
		document.formAuthorizeAtIssueStoreDetail.remarks_mandatory.style.visibility = "visible";
	}else{
		var arrayObject = new Array(formObject.req_item_qty, formObject.issuing_qty);
		var names = new Array(getLabel("Common.ReqQuantity.label", "Common"), getLabel("Common.IssueQuantity.label", "Common"));
	}	
	var blankObject = checkSTFields(arrayObject, names, parent.parent.messageFrame, errorPage);
	if (blankObject != true) {
		return;
	}else{
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="
	}
	var formHeader = parent.AuthorizeAtIssueStoreHeaderFrame.document.formAuthorizeAtIssueStoreHeader;
	if (formHeader != null) {
		formObject.request_by_store_code.value = formHeader.request_by_store_code.value;
		formObject.request_on_store_code.value = formHeader.request_on_store_code.value;
	}
	if (formObject.mode.value == "1") {
		if (parseFloat(formObject.issuing_qty.value) / parseFloat(formObject.frm_tmp_conv.value) > parseFloat(formObject.qty_on_store.value)) {
			parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("REQ_QTY_NOT_GR_PEND_QTY", "ST");
			return;
		}
	}
	if (formObject.mode.value == "2") {
		if (parseFloat(formObject.issuing_qty.value) / parseFloat(formObject.frm_tmp_conv.value) > parseFloat(formObject.qty_on_store.value)) {
			parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("REQ_QTY_NOT_GR_PEND_QTY", "ST");
			return;
		}
	}		

	if (parseFloat(formObject.req_item_qty.value) <= 0) {
		parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("REQ_QTY_CANNOT_BE_ZERO", "ST");
		return;
	}
	var stock_item_yn = "N";
	if (formObject.mode.value == "1") {
	}
	if (formObject.stock_item_yn.checked) {
		stock_item_yn = "Y";
	}

	// update exp records
	
		var bean_id = "authorizeAtIssueStoreBean";
		var bean_name = "eST.AuthorizeAtIssueStoreBean";
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getEnhancedXMLString(formObject));
		xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObject), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/AuthorizeAtIssueStoreValidate.jsp?item_code=" + formObject.item_code.value+ "&function_type=20&bean_id=" + bean_id + "&bean_name=" + bean_name, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		window.close(); 	
	
	//end 
	
	
	
	formObject.stock_item_yn.value = stock_item_yn;
	assignBean(formObject);
	xmlStr = getEnhancedXMLString(formObject);
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/AuthorizeAtIssueStoreValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=1", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
	message = getMessage(message, "ST");
	if (!result) {
		parent.parent.messageFrame.location.href = errorPage + "?err_num=" + message;
		return;
	}
	document.location.href = "../../eST/jsp/AuthorizeAtIssueStoreDetail.jsp?mode=" + MODE_INSERT + "&function_id=" + parent.parent.function_id;
	parent.AuthorizeAtIssueStoreListFrame.document.location.href = "../../eST/jsp/AuthorizeAtIssueStoreList.jsp?item_code=" + formObject.item_code.value + "&mode=" + MODE_INSERT + "&function_id=" + parent.parent.function_id;
	}else{
		alert("Issue UOM Quantity should be equal to Total Batch Quantity  \n Please Check View Batch Details");
	}
	}
	}else{
		//if (document.formAuthorizeAtIssueStoreDetail.allow_remarks.value == "N" && (parseFloat(document.formAuthorizeAtIssueStoreDetail.iss_uom_qty.value) != parseFloat(document.formAuthorizeAtIssueStoreDetail.iss_uom_qty_chk.value))) {
		if (document.formAuthorizeAtIssueStoreDetail.allow_remarks.value == "N" && (parseFloat(document.formAuthorizeAtIssueStoreDetail.iss_uom_qty.value) != parseFloat(document.formAuthorizeAtIssueStoreDetail.pending_item_qty_chk.value))) {
		var arrayObject = new Array(formObject.req_item_qty, formObject.issuing_qty,formObject.remarks_desc);
		var names = new Array(getLabel("Common.ReqQuantity.label", "Common"), getLabel("Common.IssueQuantity.label", "Common"), getLabel("Common.remarks.label", "Common"));
		document.formAuthorizeAtIssueStoreDetail.remarks_mandatory.style.visibility = "visible";
	}else{
		var arrayObject = new Array(formObject.req_item_qty, formObject.issuing_qty);
		var names = new Array(getLabel("Common.ReqQuantity.label", "Common"), getLabel("Common.IssueQuantity.label", "Common"));
	}	
	var blankObject = checkSTFields(arrayObject, names, parent.parent.messageFrame, errorPage);
	if (blankObject != true) {
		return;
	}else{
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="
	}
	var formHeader = parent.AuthorizeAtIssueStoreHeaderFrame.document.formAuthorizeAtIssueStoreHeader;
	if (formHeader != null) {
		formObject.request_by_store_code.value = formHeader.request_by_store_code.value;
		formObject.request_on_store_code.value = formHeader.request_on_store_code.value;
	}
	if (formObject.mode.value == "1") {
		if (parseFloat(formObject.issuing_qty.value) / parseFloat(formObject.frm_tmp_conv.value) > parseFloat(formObject.qty_on_store.value)) {
			parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("REQ_QTY_NOT_GR_PEND_QTY", "ST");
			return;
		}
	}
	if (formObject.mode.value == "2") {
		if (parseFloat(formObject.issuing_qty.value) / parseFloat(formObject.frm_tmp_conv.value) > parseFloat(formObject.qty_on_store.value)) {
			parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("REQ_QTY_NOT_GR_PEND_QTY", "ST");
			return;
		}
	}		

	if (parseFloat(formObject.req_item_qty.value) <= 0) {
		parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("REQ_QTY_CANNOT_BE_ZERO", "ST");
		return;
	}
	var stock_item_yn = "N";
	if (formObject.mode.value == "1") {
	}
	if (formObject.stock_item_yn.checked) {
		stock_item_yn = "Y";
	}

	// update exp records
	
		var bean_id = "authorizeAtIssueStoreBean";
		var bean_name = "eST.AuthorizeAtIssueStoreBean";
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getEnhancedXMLString(formObject));
		xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObject), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/AuthorizeAtIssueStoreValidate.jsp?item_code=" + formObject.item_code.value+ "&function_type=20&bean_id=" + bean_id + "&bean_name=" + bean_name, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		window.close();    
	
	//end 
	
	
	
	formObject.stock_item_yn.value = stock_item_yn;
	assignBean(formObject);
	xmlStr = getEnhancedXMLString(formObject);
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/AuthorizeAtIssueStoreValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=1", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
	message = getMessage(message, "ST");
	if (!result) {
		parent.parent.messageFrame.location.href = errorPage + "?err_num=" + message;
		return;
	}
	document.location.href = "../../eST/jsp/AuthorizeAtIssueStoreDetail.jsp?mode=" + MODE_INSERT + "&function_id=" + parent.parent.function_id;
	parent.AuthorizeAtIssueStoreListFrame.document.location.href = "../../eST/jsp/AuthorizeAtIssueStoreList.jsp?item_code=" + formObject.item_code.value + "&mode=" + MODE_INSERT + "&function_id=" + parent.parent.function_id;
	}
}
async function showRemarks() {
	await window.showModalDialog("../../eST/jsp/AuthorizeAtIssueStoreRemarks.jsp?function_id=" + parent.parent.function_id, "", "dialogHeight:40vh; dialogWidth:40vw; center:0; status: no; dialogLeft :75; dialogTop :250;");
}
//MO-CRF-20173
async function showRemarksOnClose(remarksDesc){
	var formObject = document.formAuthorizeAtIssueStoreDetail;
	var closeRemarksDesc = formObject.closeRemarksDesc.value;  
	var item_code = formObject.item_code.value;
	await window.showModalDialog("../../eST/jsp/AuthorizeAtIssueStoreCloseRemarks.jsp?function_id=" + parent.parent.function_id + "&closeRemarksDesc=" +closeRemarksDesc + "&remarksDesc=" +remarksDesc.value + "&item_code=" +formObject.item_code.value, "", "dialogHeight:30vh; dialogWidth:35vw; center:0; status: no; dialogLeft :75; dialogTop :250;");	
}
//MO-CRF-20173
function updateCloseRemarks() {
	//alert("updateCloseRemarks");   
	formObject = document.formAuthorizeAtIssueStoreCloseRemarks;
	flag = true;
	/*if (formObject.close_remarks.value == "") {
		alert(getMessage("ADJ_REMARKS_NOT_BLANK", "ST"));
		flag = false;
		return;
	}*/
	if (!setTextAreaMaxLength(formObject.close_remarks, 201)) {
		alert(getMessage("REMARKS_CHAR_EXCEEDS_LIMIT", "ST"));
		return;
	}
	assignBean(formObject);
	//xmlStr = getXMLString(formObject); //Commented by Sakti Sankar against Inc#37941
	xmlStr = getEnhancedXMLString(formObject); //Added by Sakti Sankar against Inc#37941
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/AuthorizeAtIssueStoreValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&item_code=" + formObject.itemCode.value + "&function_type=23", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
	window.close();
}
function setValueCheck(obj){
	var formObject = document.formAuthorizeAtIssueStoreDetail;
	//alert("closeItemList: "+formObject.closeItemList.value);
	var formHeader = parent.AuthorizeAtIssueStoreHeaderFrame.document.formAuthorizeAtIssueStoreHeader;
	if(obj.checked){
		   obj.value = "Y";
		   document.getElementById('Remarkslabel').style.visibility="visible";  
		   formHeader.closeRemarks.value ="Y"; 
		  }else{
			  obj.value = "N";
			  document.getElementById('Remarkslabel').style.visibility="hidden";   
		  }
	if(formHeader.close_upon_issue_yn.checked && obj.checked ){
		alert(getMessage("CANNOT_USE_ITEM_DOCUMENT_LEVEL_CLOSE", "ST"));
		document.formAuthorizeAtIssueStoreDetail.close_item.checked=false;
		document.formAuthorizeAtIssueStoreDetail.document.getElementById('Remarkslabel').style.visibility="hidden";  
		return;
	}
}
function setValueCloseUponIssue(obj){
	var frmObj = document.formAuthorizeAtIssueStoreHeader;
	var closeItemVal = "";
	/*xmlStr = getEnhancedXMLString(frmObj); //Added by Sakti Sankar against Inc#37941
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "../../eST/jsp/AuthorizeAtIssueStoreValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=24", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;*/
	var bean_id = "authorizeAtIssueStoreBean";
	var bean_name = "eST.AuthorizeAtIssueStoreBean";
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/AuthorizeAtIssueStoreValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=24", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	if(result){
		closeItemVal = "Y";
		if(obj.checked){
			//if(frmObj.closeRemarks.value=="Y"){
				alert(getMessage("CANNOT_USE_ITEM_DOCUMENT_LEVEL_CLOSE", "ST"));
				frmObj.close_upon_issue_yn.checked=false; 
			
		}
	}
}
//MO-CRF-20173 END 
function updateRemarks() { 
	formObject = document.formAuthorizeAtIssueStoreRemarks;
	flag = true;
	if (formObject.remarks.value == "") {
		alert(getMessage("ADJ_REMARKS_NOT_BLANK", "ST"));
		flag = false;
		return;
	}
	if (!setTextAreaMaxLength(formObject.remarks, 201)) {
		alert(getMessage("REMARKS_CHAR_EXCEEDS_LIMIT", "ST"));
		return;
	}
	assignBean(formObject);
	//xmlStr = getXMLString(formObject); //Commented by Sakti Sankar against Inc#37941
	xmlStr = getEnhancedXMLString(formObject); //Added by Sakti Sankar against Inc#37941
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/AuthorizeAtIssueStoreValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=2", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
	window.close();
}
async function callItemSearch() {
	var formHeader = parent.AuthorizeAtIssueStoreHeaderFrame.document.formAuthorizeAtIssueStoreHeader;
	formHeader.request_by_store_code.value = formHeader.to_store_code.value;
	formHeader.request_on_store_code.value = formHeader.from_store_code.value;
	var errorPage = "../../eCommon/jsp/error.jsp";
	var formObject = document.formAuthorizeAtIssueStoreDetail;
	var search_string = formObject.item_desc.value;
	var store_code = formHeader.request_on_store_code.value;
	var mode = formHeader.mode.value;
	var category = "";
	var sole_source = "A";
	var ps_item = "A";
	var mfg_item = "A";
	var expiry = "A";
	var consignment = "A";
	
	if (mode == 2) {
		var item_class = formHeader.item_class_code1.value;
		if (item_class == "null") {
			item_class = "";
		}
	} else {
		var item_class = formHeader.item_class_code.value;
	}
	var arrayObject = new Array(formHeader.request_by_store_code, formHeader.request_on_store_code);
	var names = new Array(getLabel("Common.ReqOnStore.label", "Common"), getLabel("Common.ReqByStore.label", "Common"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.messageFrame, errorPage);
	if (blankObject != true) {
		return;
	}
	var kit = "Y";
	//Modified by Sakti against AMS-CRF-0011 trn_type passing
	var results = await callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment,"REQ", "", "", "", "", kit);
	if (results != null) {
		var bean_id = "authorizeAtIssueStoreBean";
		var bean_name = "eST.AuthorizeAtIssueStoreBean";
		if (results[0] == "kit") {
		
			formObject.request_by_store_code.value = formHeader.request_by_store_code.value;
			formObject.request_on_store_code.value = formHeader.request_on_store_code.value;
			
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/AuthorizeAtIssueStoreValidate.jsp?kit_template_code=" + results[1] + "&store_code=" + store_code + "&function_type=11" + "&bean_id=" + bean_id + "&bean_name=" + bean_name+"&request_by_store_code="+formHeader.request_by_store_code.value, false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			return;
		}
		var item_code = results[0];
	/**
	* @Name - Mahesh
	* @Date - 19/01/2010
	* @Inc# - IN015496
	* @Desc - Decimal Allowed yn is set form JS.
	*/
		document.formAuthorizeAtIssueStoreDetail.dec_allowed_yn.value = results[27];
		document.formAuthorizeAtIssueStoreDetail.no_of_decimals.value = results[28];
		var store_code = formHeader.request_by_store_code.value;
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/AuthorizeAtIssueStoreValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&item_code=" + item_code + "&uom_code=" + results[13] + "&store_code=" + formHeader.request_on_store_code.value + "&function_type=4" + "&req_by_Store=" + formHeader.request_by_store_code.value, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if (result) {
			formObject.stock_item_yn.checked = true;
		} else {
			
			if (message == "PHY_INV_PROCESS_INITIATED") {
				parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "ST") + "<br>" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + formObject.phy_inv_id.value;
			} else {
				parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "ST");
			}
			document.location.href = "../../eST/jsp/AuthorizeAtIssueStoreDetail.jsp?mode=" + MODE_INSERT + "&function_id=" + document.formAuthorizeAtIssueStoreDetail.function_id;
			return;
		}
		formObject.request_by_store_code.value = formHeader.request_by_store_code.value;
		formObject.request_on_store_code.value = formHeader.request_on_store_code.value;
		formObject.item_code.value = results[0];
		formObject.item_desc.value = results[1];
		formObject.item_desc.readOnly = true;
		formObject.add.disabled = false;
		formObject.ItemDetails.disabled = false;
		document.getElementById('uom_label').innerHTML = "<B>" + results[15] + "</B>";
		loadItemDetails();
		formHeader.store_code_disabled.value = "disabled";
		formObject.pur_uom_code.value = results[13];
		formObject.iss_uom_code.value = results[13];
		formObject.uom.value = results[13];
		formObject.uom_desc.value = results[15];
		document.getElementById('id_pur_uom_conv').innerHTML = "1";
		document.getElementById('id_iss_uom_conv').innerHTML = "1";
		document.formAuthorizeAtIssueStoreDetail.req_conv_fact.value = "1";
		document.formAuthorizeAtIssueStoreDetail.iss_conv_fact.value = "1";
		checkUOMConvFactor();
		checkISSUOMConvFactor();
	if (document.formAuthorizeAtIssueStoreDetail.dec_allowed_yn.value == "N") {
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/AuthorizeAtIssueStoreValidate.jsp?item_code=" + document.formAuthorizeAtIssueStoreDetail.item_code.value + "&fm_store_code=" + formHeader.from_store_code.value + "&to_store_code=" + formHeader.to_store_code.value+"&issue_uom_code="+document.formAuthorizeAtIssueStoreDetail.pur_uom_code.value + "&function_type=18&bean_id=" + bean_id + "&bean_name=" + bean_name+"&req_string='REQ_UOM'", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if(result){
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/AuthorizeAtIssueStoreValidate.jsp?item_code=" + document.formAuthorizeAtIssueStoreDetail.item_code.value + "&fm_store_code=" + formHeader.from_store_code.value + "&to_store_code=" + formHeader.to_store_code.value+"&issue_uom_code="+document.formAuthorizeAtIssueStoreDetail.iss_uom_code.value + "&function_type=18&bean_id=" + bean_id + "&bean_name=" + bean_name+"&req_string=''", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
		}
	}
		document.formAuthorizeAtIssueStoreDetail.req_uom_qty.focus();
	}
}
function loadItemDetails() {
	var formObject = document.formAuthorizeAtIssueStoreDetail;
	assignBean(formObject);
	xmlStr = getXMLString(formObject);
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/AuthorizeAtIssueStoreValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=3", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
	if (!result) {
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "ST");
		document.location.href = "../../eST/jsp/AuthorizeAtIssueStoreDetail.jsp?mode=" + MODE_INSERT + "&function_id=" + document.formAuthorizeAtIssueStoreDetail.function_id;
	}
}
function updateValues() {
	var formObject = document.formAuthorizeAtIssueStoreHeader;
	formObject.request_by_store_code.value = formObject.to_store_code.value;
	formObject.request_on_store_code.value = formObject.from_store_code.value;
}
function checkDocDate(formObj) {
	if (isValidFromToField(formObj.from_doc_date, formObj.to_doc_date, DATE, getLabel("Common.DocDate.label", "Common"))) 
	{
		formObj.action="../../eST/jsp/RequisitionIssueAuthorizeQueryResult.jsp";
		formObj.target="RIAuthorizeQueryResultFrame"
		formObj.submit();
	} else 
	{
		return;
	}
}
function isValidFromToField(fromObj, toObj, dataType, stLegend) {
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
		if (stFromValue > stToValue) {
			bReturn = false;
		}
	}
	if ((!bReturn)) {
		var stMessage = getMessage("LESS_OR_EQUAL_VALIDATE", "ST");
		stMessage = stMessage.replace(/@/g, stLegend);
		alert(stMessage);
		toObj.focus();
	}
	return bReturn;
}

function checkUOMConvFactor() {
	var formObj = document.formAuthorizeAtIssueStoreDetail;
	//if (formObj.uom.value == formObj.pur_uom_code.value) {
	//	setUOMReqConvFactor("1");
//		return;
	//}
	var formObj = document.formAuthorizeAtIssueStoreDetail;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/AuthorizeAtIssueStoreValidate.jsp?uom=" + formObj.uom.value + "&pur_uom_code=" + formObj.pur_uom_code.value + "&iss_uom_code=" + formObj.iss_uom_code.value + "&bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value + "&function_type=6" + "&item_code=" + formObj.item_code.value, false);
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	eval(responseText);
	if (!result) {
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "ST");
		formObj.pur_uom_code.value = formObj.uom.value;
		formObj.pur_uom_code.focus();
	}
}
function checkISSUOMConvFactor() {
	var formObj = document.formAuthorizeAtIssueStoreDetail;
//	if (formObj.uom.value == formObj.iss_uom_code.value) {
	//	setUOMIssConvFactor("1");
	//	return;
//	}
	var formObj = document.formAuthorizeAtIssueStoreDetail;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/AuthorizeAtIssueStoreValidate.jsp?uom=" + formObj.uom.value + "&pur_uom_code=" + formObj.pur_uom_code.value + "&iss_uom_code=" + formObj.iss_uom_code.value + "&bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value + "&function_type=7" + "&item_code=" + formObj.item_code.value, false);
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	eval(responseText);
	if (!result) {
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "ST");
		formObj.iss_uom_code.value = formObj.uom.value;
		
	}
}
function setUOMReqConvFactor(_value) {
	document.getElementById('id_pur_uom_conv').innerHTML = _value;
	document.formAuthorizeAtIssueStoreDetail.req_conv_fact.value = _value;
	document.formAuthorizeAtIssueStoreDetail.req_uom_qty.focus();
}
function setUOMIssConvFactor(_value) {
	document.getElementById('id_iss_uom_conv').innerHTML = _value;
	document.formAuthorizeAtIssueStoreDetail.iss_conv_fact.value = _value;
}
function calRequestQty() {
	var formObj = document.formAuthorizeAtIssueStoreDetail;
	var no_of_decimals=document.formAuthorizeAtIssueStoreDetail.no_of_decimals.value;
	var dec_allowed_yn=document.formAuthorizeAtIssueStoreDetail.dec_allowed_yn.value;
	formObj.req_item_qty.value = "";
	if (formObj.req_uom_qty.value == "" || document.getElementById('id_pur_uom_conv').innerText == "") {
	} else {
		if(dec_allowed_yn=="Y"){
			formObj.req_item_qty.value =(parseFloat(formObj.req_conv_fact.value) * parseFloat(formObj.req_uom_qty.value)).toFixed(no_of_decimals);
			toConvFactor();
		}else{
			if(formObj.req_uom_qty.value%formObj.req_uom_multiples.value !=0){
					alert("Req UOM Qty Should Be In Multiples Of "+formObj.req_uom_multiples.value);
					formObj.req_item_qty.value = "";
					//formObj.req_uom_qty.focus();
					return false;
			}else{
				formObj.req_item_qty.value = (formObj.req_uom_qty.value * formObj.req_batch_multiples.value)/formObj.req_uom_multiples.value ;
			}
		}
		if (formObj.req_by_max_stk_level.value != null) {         
		}
		if ((parseInt(formObj.req_item_qty.value)/parseInt(formObj.to_tmp_conv.value)) + parseInt(formObj.req_by_qty_on_hand.value) > parseInt(formObj.req_by_max_stk_level.value)) {
			alert(getLabel("eST.exceedmaxStockLevel.label", "ST")); 
		}
	}
}
function calIssueQty() {

	var formObj = document.formAuthorizeAtIssueStoreDetail;
	formObj.issuing_qty.value = "";
	var no_of_decimals=document.formAuthorizeAtIssueStoreDetail.no_of_decimals.value;
	var dec_allowed_yn=document.formAuthorizeAtIssueStoreDetail.dec_allowed_yn.value;

	if (formObj.iss_uom_qty.value == "" || document.getElementById('id_iss_uom_conv').innerText == "") {
	} else {
		if(dec_allowed_yn=="Y"){
			toConvFactor();
			formObj.issuing_qty.value = (parseFloat(formObj.iss_uom_qty.value) * parseFloat(document.getElementById('iss_conv_fact').value)).toFixed(no_of_decimals);
			//Added against ML-BRU-SCF-1710 starts
			formObj.iss_uom_qty_chk.value = parseFloat(formObj.iss_uom_qty.value);
			if(formObj.available_qty.value > ((parseFloat(formObj.iss_uom_qty.value) * parseFloat(document.getElementById('iss_conv_fact').value)).toFixed(no_of_decimals)))
				formObj.total_batch_qty.value = (parseFloat(formObj.iss_uom_qty.value) * parseFloat(document.getElementById('iss_conv_fact').value)).toFixed(no_of_decimals); 
			//Added against ML-BRU-SCF-1710 ends
		}else{
			//formObj.issuing_qty.value = parseFloat(formObj.iss_uom_qty.value) * parseFloat(document.getElementById("iss_conv_fact").value);
			if(formObj.iss_uom_qty.value%formObj.issue_uom_multiples.value !=0){
					alert("Issue UOM Qty Should Be In Multiples Of "+formObj.issue_uom_multiples.value);
					formObj.iss_uom_qty.focus();
					formObj.issuing_qty.value = "";
					return false;
			}else{
				formObj.issuing_qty.value = (formObj.iss_uom_qty.value * formObj.batch_multiples.value)/formObj.issue_uom_multiples.value ;
				//Added against ML-BRU-SCF-1710 starts
				formObj.iss_uom_qty_chk.value = formObj.iss_uom_qty.value ;
				if(formObj.available_qty.value > ((formObj.iss_uom_qty.value * formObj.batch_multiples.value)/formObj.issue_uom_multiples.value))
					formObj.total_batch_qty.value = (formObj.iss_uom_qty.value * formObj.batch_multiples.value)/formObj.issue_uom_multiples.value ; 
				//Added against ML-BRU-SCF-1710 ends
			}
		}
		if (formObj.req_on_min_stk_level.value != null) {
		}
		
		if ((parseInt(formObj.req_on_qty_on_hand.value) - (parseInt(formObj.issuing_qty.value)/parseInt(formObj.frm_tmp_conv.value))) < parseInt(formObj.req_on_min_stk_level.value)) {
			alert(getLabel("eST.BelowMinStockLevel.label", "ST")); 
			
		}
	}
}

function mandatorygif() {
	if (document.forms[0].close_upon_issue_yn.checked) {
		document.getElementById('mgif').style.display = "inline";
	} else {
		document.getElementById('mgif').style.display = "none";
	}
}
function phy_inv_progress() {
	alert(getMessage("PHY_INV_PROCESS_INITIATED", "ST") + "\n" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + document.formAuthorizeAtIssueStoreDetail.phy_inv_id.value);
	document.formAuthorizeAtIssueStoreDetail.item_desc.value = "";
	document.formAuthorizeAtIssueStoreDetail.item_desc.focus();
	return;
}
function issueUOMQtyChk() {
	var formObj = document.formAuthorizeAtIssueStoreDetail;
	toConvFactor();
if(document.formAuthorizeAtIssueStoreDetail.dec_allowed_yn.value=="N")
{
	var conv_factor = lcm(formObj.frm_tmp_conv.value, formObj.to_tmp_conv.value);
	var dec_factor = (formObj.issuing_qty.value) % (conv_factor);
	if (dec_factor > 0 && conv_factor > 1 && (formObj.kit_item_yn.value=="N" || formObj.kit_item_yn.value=='')) {
		alert("Issue Quantity Should Be In Multiples Of " + conv_factor);
		return false;
	
	} else {
		return true;
	}
	}
		return true;
}
function setTempConvFactor(frm_tmp, to_tmp) {
	if (document.formAuthorizeAtIssueStoreDetail == null) {
		parent.frames[2].frames[0].document.formAuthorizeAtIssueStoreDetail.frm_tmp_conv.value = frm_tmp;
		parent.frames[2].frames[0].document.formAuthorizeAtIssueStoreDetail.to_tmp_conv.value = to_tmp;
	} else {
		document.formAuthorizeAtIssueStoreDetail.frm_tmp_conv.value = frm_tmp;
		document.formAuthorizeAtIssueStoreDetail.to_tmp_conv.value = to_tmp;
	}
}
function toConvFactor() {
	var bean_id = "authorizeAtIssueStoreBean";
	var bean_name = "eST.AuthorizeAtIssueStoreBean";
	var formObj = document.formAuthorizeAtIssueStoreDetail;
	var item_code = "";
	if (formObj == null) {
		formObj = parent.frames[2].frames[0].document.formAuthorizeAtIssueStoreDetail;
		var to_store_code = parent.AuthorizeAtIssueStoreHeaderFrame.document.formAuthorizeAtIssueStoreHeader.to_store_code.value;
		var frm_store_code = parent.AuthorizeAtIssueStoreHeaderFrame.document.formAuthorizeAtIssueStoreHeader.from_store_code.value;
	} else {
		var to_store_code = parent.AuthorizeAtIssueStoreHeaderFrame.document.formAuthorizeAtIssueStoreHeader.to_store_code.value;
		var frm_store_code = parent.AuthorizeAtIssueStoreHeaderFrame.document.formAuthorizeAtIssueStoreHeader.from_store_code.value;
	}
	item_code = formObj.item_code.value;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/AuthorizeAtIssueStoreValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=9" + "&to_store_code=" + to_store_code + "&frm_store_code=" + frm_store_code + "&item_code=" + item_code, false);
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	eval(responseText);
}
function lcm(frm_tmp, to_tmp) {
	var lowest = frm_tmp < to_tmp ? frm_tmp : to_tmp;
	var hcd = 1;
	for (var i = lowest; i > 1; i--) {
		if (frm_tmp % i == 0 && to_tmp % i == 0) {
			hcd = i;
			break;
		}
	}
	var lcm = (frm_tmp * to_tmp) / hcd;
	return lcm;
}
function populateToStoresInQuery(request_on_store) {
	if (request_on_store.value == "") {
		clearListItems("document.forms[0].request_by_store");
		return;
	}
	var arrayObject = new Array();
	clearListItems("document.forms[0].request_by_store");
	assignBean(parent.frames[0].document.forms[0]);
	xmlStr = getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/AuthorizeAtIssueStoreValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&request_on_store=" + request_on_store.value + "&function_type=10", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
function kitGetStatus(uom_code) {
	var formObject = document.formAuthorizeAtIssueStoreDetail;
	var bean_id = "authorizeAtIssueStoreBean";
	var bean_name = "eST.AuthorizeAtIssueStoreBean";
	assignBean(formObject);
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/AuthorizeAtIssueStoreValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&item_code=" + formObject.item_code.value + "&uom_code=" + formObject.uom.value + "&store_code=" + formObject.request_on_store_code.value + "&function_type=13" + "&req_by_Store=" + formObject.request_by_store_code.value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	xmlStr = getXMLString(formObject);
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/AuthorizeAtIssueStoreValidate.jsp?function_type=3&bean_id=" + bean_id + "&bean_name=" + bean_name, false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
	formObject.pur_uom_code.value = uom_code;
	formObject.iss_uom_code.value = uom_code;
	document.getElementById('id_pur_uom_conv').innerHTML = "1";
	document.getElementById('id_iss_uom_conv').innerHTML = "1";
	document.formAuthorizeAtIssueStoreDetail.req_conv_fact.value = "1";
	document.formAuthorizeAtIssueStoreDetail.iss_conv_fact.value = "1";
	//document.formAuthorizeAtIssueStoreDetail.req_uom_qty.value = "0";
	//document.formAuthorizeAtIssueStoreDetail.req_item_qty.value = "0";
	//document.formAuthorizeAtIssueStoreDetail.iss_uom_qty.value = "0";
	//document.formAuthorizeAtIssueStoreDetail.issuing_qty.value = "0";
	checkUOMConvFactor();
	checkISSUOMConvFactor();
	addToList1();
}
function example1() {
	parent.AuthorizeAtIssueStoreDetailFrame.example();
}
function example() {
	var bean_id = "authorizeAtIssueStoreBean";
	var bean_name = "eST.AuthorizeAtIssueStoreBean";
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/AuthorizeAtIssueStoreValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=11", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	return;
}
function addToList1() {
	var formObject = document.formAuthorizeAtIssueStoreDetail;
	var errorPage = "../../eCommon/jsp/error.jsp";
	var formHeader = parent.AuthorizeAtIssueStoreHeaderFrame.document.formAuthorizeAtIssueStoreHeader;
	if (formHeader != null) {
		formObject.request_by_store_code.value = formHeader.request_by_store_code.value;
		formObject.request_on_store_code.value = formHeader.request_on_store_code.value;
	}
	if(formObject.kit_item_yn.value=="N"){
	if (parseFloat(formObject.issuing_qty.value) > parseFloat(formObject.qty_on_store.value)) {
		parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("REQ_QTY_NOT_GR_PEND_QTY", "ST");
		return;
	}
	}
	var stock_item_yn = "N";
	if (formObject.stock_item_yn.checked) {
		stock_item_yn = "Y";
	}
	formObject.stock_item_yn.value = stock_item_yn;
	assignBean(formObject);
	xmlStr = getEnhancedXMLString(formObject);
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/AuthorizeAtIssueStoreValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=1", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
	document.location.href = "../../eST/jsp/AuthorizeAtIssueStoreDetail.jsp?mode=" + MODE_INSERT + "&function_id=" + parent.parent.function_id;
	parent.AuthorizeAtIssueStoreListFrame.document.location.href = "../../eST/jsp/AuthorizeAtIssueStoreList.jsp?item_code=" + formObject.item_code.value + "&mode=" + MODE_INSERT + "&function_id=" + parent.parent.function_id + "&kit12=kit12";
	example();
}
function statusOfItem() {
	var bean_id = "authorizeAtIssueStoreBean";
	var bean_name = "eST.AuthorizeAtIssueStoreBean";
	var formHeader = parent.AuthorizeAtIssueStoreHeaderFrame.document.formAuthorizeAtIssueStoreHeader;
	var to_store_code = formHeader.request_by_store_code.value;
	var store_code = formHeader.request_on_store_code.value;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/AuthorizeAtIssueStoreValidate.jsp?function_type=12&store_code=" + store_code + "&to_store_code=" + to_store_code + "&bean_id=" + bean_id + "&bean_name=" + bean_name, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
function displayMessage(errorList) {
	var item_store = "";
	var phy_inv = "";
	var non_stock = "";
	var no_stock = "";
	var insuff_stock = "";
	errorList = errorList.substring(1, errorList.length - 1);
	errorList = errorList.split(",");
	for (var i = 0; i < errorList.length; i++) {
		if (trimString(errorList[i]) == "ITEM_STORE_NOT_FOUND") {
			if (item_store == "") {
				item_store = item_store + " " + trimString(errorList[i + 1]);
			} else {
				item_store = item_store + ", " + trimString(errorList[i + 1]);
			}
		} else {
			if (trimString(errorList[i]) == "PHY_INV_PROCESS_INITIATED") {
				if (phy_inv == "") {
					phy_inv = phy_inv + " " + trimString(errorList[i + 1]);
				} else {
					phy_inv = phy_inv + "," + trimString(errorList[i + 1]);
				}
			} else {
				if (trimString(errorList[i]) == "NOT_STOCK_ITEM") {
					if (non_stock == "") {
						non_stock = non_stock + " " + trimString(errorList[i + 1]);
					} else {
						non_stock = non_stock + "," + trimString(errorList[i + 1]);
					}
				} else if(trimString(errorList[i]) == "STOCK_NOT_AVAILABLE"){
					if (trimString(errorList[i]) == "STOCK_NOT_AVAILABLE") {
						if (no_stock == "") {
							no_stock = no_stock + " " + trimString(errorList[i + 1]);
						} else {
							no_stock = no_stock + "," + trimString(errorList[i + 1]);
						}
					}
				}else {
					if (trimString(errorList[i]) == "INSUFFICIENT_BATCH_QTY") {
						if (insuff_stock == "") {
							insuff_stock = insuff_stock + " " + trimString(errorList[i + 1]);
						} else {
							insuff_stock = insuff_stock + "," + trimString(errorList[i + 1]);
						}
					}
				}
			}
		}
		i++;
	}
	var err_text = "";
	if (item_store != "") {
		err_text = err_text + getMessage("ITEM_STORE_NOT_FOUND", "ST") + " for " + item_store + "\n";
	}
	if (phy_inv != "") {
		err_text = err_text + getMessage("PHY_INV_PROCESS_INITIATED", "ST") + " for " + phy_inv + "\n";
	}
	if (non_stock != "") {
		err_text = err_text + getMessage("NOT_STOCK_ITEM", "ST") + " " + non_stock + "\n";
	}
	if (no_stock != "") {
		err_text = err_text + getMessage("STOCK_NOT_AVAILABLE", "ST") + " " + no_stock + "\n";
	}
	if (insuff_stock != "") {
		err_text = err_text + getMessage("INSUFFICIENT_BATCH_QTY", "ST") + " " + insuff_stock + "\n";
	}
	if (err_text != "") {
		alert(err_text);
	}
	var formObject = document.formAuthorizeAtIssueStoreDetail;
	parent.AuthorizeAtIssueStoreListFrame.document.location.href = "../../eST/jsp/AuthorizeAtIssueStoreList.jsp?mode=" + MODE_INSERT + "&function_id=" + parent.parent.function_id;
}
function dispMess(id) {
	alert(getMessage("PHY_INV_PROCESS_INITIATED", "ST") + "\n" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + id);
}
async function ItemDetail() {
	var frmObj = document.formAuthorizeAtIssueStoreDetail;
	var fm_store_code = parent.AuthorizeAtIssueStoreHeaderFrame.document.formAuthorizeAtIssueStoreHeader.request_on_store_code.value;
	var to_store_code = parent.AuthorizeAtIssueStoreHeaderFrame.document.formAuthorizeAtIssueStoreHeader.request_by_store_code.value;
	
	await window.showModalDialog("../../eST/jsp/MinMaxItemDetails.jsp?item_desc=" + encodeURIComponent(frmObj.item_desc.value )+ "&fm_store_code=" + fm_store_code + "&to_store_code=" + to_store_code + "&item_code=" + frmObj.item_code.value, "", "dialogHeight:70vh; dialogWidth:80vw; center:0; status: no; dialogLeft :130; dialogTop :480; scroll: no");
}
function changeOrder() {
	var bean_id = "authorizeAtIssueStoreBean";
	var bean_name = "eST.AuthorizeAtIssueStoreBean";
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/AuthorizeAtIssueStoreValidate.jsp?function_type=14&bean_id=" + bean_id + "&bean_name=" + bean_name, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	if (result) {
		parent.AuthorizeAtIssueStoreListFrame.document.location.href = "../../eST/jsp/AuthorizeAtIssueStoreList.jsp?";
		parent.AuthorizeAtIssueStoreDetailFrame.document.location.href = "../../eST/jsp/AuthorizeAtIssueStoreDetail.jsp?mode=" + MODE_INSERT + "&function_id=" + parent.parent.function_id;
	}
}
async function searchRemarks(objCode, objDesc) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.formAuthorizeAtIssueStoreRemarks.lang_id.value;
	dataTypeArray[0] = STRING;
	dataNameArray[1] = "module_id";
	dataValueArray[1] = "ST";
	dataTypeArray[1] = STRING;
	dataNameArray[2] = "trn_type";
	dataValueArray[2] = document.formAuthorizeAtIssueStoreRemarks.rem_trans_type.value;
	dataTypeArray[2] = STRING;
	argumentArray[0] = document.formAuthorizeAtIssueStoreRemarks.SQL_ST_TRN_REMARKS_LOOKUP_SELECT.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "4,5";
	argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup(getLabel("Common.remarks.label", "Common"), argumentArray);
	var ret1=unescape(returnedValues);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if ((returnedValues != null) && (returnedValues != "")) {
		objCode.value = arr[0];
		objDesc.value = arr[1];
	}else {
  				objCode.value = "";
	    	objDesc.value = "";
	}
}
//MO-CRF-20173
async function searchCloseRemarks (objCode, objDesc){
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.formAuthorizeAtIssueStoreCloseRemarks.lang_id.value;
	dataTypeArray[0] = STRING;
	dataNameArray[1] = "module_id";
	dataValueArray[1] = "ST";
	dataTypeArray[1] = STRING;
	dataNameArray[2] = "trn_type";
	dataValueArray[2] = document.formAuthorizeAtIssueStoreCloseRemarks.rem_trans_type.value;
	dataTypeArray[2] = STRING;
	argumentArray[0] = document.formAuthorizeAtIssueStoreCloseRemarks.SQL_ST_TRN_REMARKS_LOOKUP_SELECT.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "4,5";
	argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.remarks.label", "Common"), argumentArray);
	if(returnedValues != null && returnedValues != "" )
	{
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}										
		 	objCode.value = arr[0];
			objDesc.value = arr[1];	  			  
	}
	/*if ((returnedValues != null) && (returnedValues != "")) {
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
	}*/
}
async function callItemSearchScreen_qry (obj) {
	
	
	var search_string=obj.value;
	var store_code="";
	var category ="A";
	var sole_source ="A";
	var ps_item ="A";
	var mfg_item ="A";
	var expiry ="A";
	var consignment ="A";
	var item_class ="";
	var store_disable ="Y";

	//Modified by Sakti against AMS-CRF-0011 trn_type passing
	var retVal=await callItemSearchWindow(search_string,store_code,category,sole_source,ps_item,mfg_item,expiry,item_class,consignment,"REQ","","",store_disable);
	if(retVal!=null)
	{
	
	
	var item_C = retVal[0];
		document.formRequisitionIssueQueryCriteria.item_code.value = item_C;
				
	}
}

async function displayRequestDocument(doc_no,doc_type_code) {
var dialogFeatures	= "dialogHeight:80vh; dialogWidth:100vw;dialogLeft :100; dialogTop :200; scrolling :yes; status:no";
var retVal=await window.showModalDialog('../../eST/jsp/RequestDocumentDisplay.jsp?&doc_no='+doc_no+'&doc_type_code='+doc_type_code,'',dialogFeatures);

}
async function searchRemarksItem(objCode, objDesc) {
	
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	argumentArray[0] = "SELECT ST.TRN_REMARKS_CODE CODE, REMARKS_DESC DESCRIPTION FROM ST_TRN_TYPE_FOR_REMARKS ST, MM_TRN_REMARKS_LANG_VW MM WHERE UPPER(ST.TRN_REMARKS_CODE) LIKE UPPER(?) AND UPPER(REMARKS_DESC) LIKE UPPER(?) AND ST.EFF_STATUS = 'E' AND ST.TRN_REMARKS_CODE = MM.TRN_REMARKS_CODE AND mm.eff_status = 'E' AND st.trn_type = 'REQ' AND MM.LANGUAGE_ID = '"+document.formAuthorizeAtIssueStoreDetail.language_id.value+"'";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.remarks.label", "Common"), argumentArray);
	var ret1=unescape(returnedValues);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if ((returnedValues != null) && (returnedValues != "")) {
		objCode.value = arr[0];
		objDesc.value = arr[1];
	}
}

function loadItemClass(request_on_store,request_by_store){

	var arrayObject = new Array();
	clearListItems("document.forms[0].item_class_code");
	assignBean(parent.frames[0].document.forms[0]);
	xmlStr = getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/AuthorizeAtIssueStoreValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&request_on_store=" + request_on_store.value +"&request_by_store=" + request_by_store.value + "&function_type=15", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
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

	/**
	* @Name - Mahesh
	* @Date - 19/01/2010
	* @Inc# - IN015496
	* @Desc - Decimal Allowed yn is set to y, then allow decimal else dont.
	*/

function CheckQuantity(obj) {
	if(document.formAuthorizeAtIssueStoreDetail.dec_allowed_yn.value=="Y"){
		if (!checkDoubleFormat(obj,false)) {
			return false;
		}
	}else{
		if (!checkIntegerFormat(obj,false)) {
			return false;
		}
	}
	if (parseFloat(document.formAuthorizeAtIssueStoreDetail.iss_uom_qty.value) > parseFloat(document.formAuthorizeAtIssueStoreDetail.available_qty.value) ) {
		alert(getMessage("QTY_NOT_GRT_AVLQTY", "ST"));
		return false;
	}
}


function setUOMReqConvFactor1(_value,_rulestring) {
	
	
	//document.getElementById("id_pur_uom_conv").innerHTML = _rulestring;
	//document.formAuthorizeAtIssueStoreDetail.req_conv_fact.value = _value;
	//document.formAuthorizeAtIssueStoreDetail.req_conv_text.value = _rulestring;

	document.getElementById('id_pur_uom_conv').innerHTML = decodeURIComponent(_rulestring,"UTF-8");
	document.formAuthorizeAtIssueStoreDetail.req_conv_fact.value = decodeURIComponent(_value,"UTF-8");
	document.formAuthorizeAtIssueStoreDetail.req_conv_text.value = decodeURIComponent(_rulestring,"UTF-8");

	document.formAuthorizeAtIssueStoreDetail.req_uom_qty.focus();
}


function setUOMIssConvFactor1(_value,_rulestring) {
	
	//document.getElementById("id_iss_uom_conv").innerHTML = _rulestring;
	//document.formAuthorizeAtIssueStoreDetail.iss_conv_fact.value = _value;
	//document.formAuthorizeAtIssueStoreDetail.iss_conv_text.value = _rulestring;

	document.getElementById('id_iss_uom_conv').innerHTML = decodeURIComponent(_rulestring,"UTF-8");
	document.formAuthorizeAtIssueStoreDetail.iss_conv_fact.value = decodeURIComponent(_value,"UTF-8");
	document.formAuthorizeAtIssueStoreDetail.iss_conv_text.value = decodeURIComponent(_rulestring,"UTF-8");
}

function setMultiples(from,to,batch,issue) {
	if (document.formAuthorizeAtIssueStoreDetail == null) {
		parent.frames[2].frames[0].document.formAuthorizeAtIssueStoreDetail.from_multiples.value = from;
		parent.frames[2].frames[0].document.formAuthorizeAtIssueStoreDetail.to_multiples.value = to;
		parent.frames[2].frames[0].document.formAuthorizeAtIssueStoreDetail.batch_multiples.value = batch;
		parent.frames[2].frames[0].document.formAuthorizeAtIssueStoreDetail.issue_uom_multiples.value = issue;
	} else {
		document.formAuthorizeAtIssueStoreDetail.from_multiples.value = from;
		document.formAuthorizeAtIssueStoreDetail.to_multiples.value = to;
		document.formAuthorizeAtIssueStoreDetail.batch_multiples.value = batch;
		document.formAuthorizeAtIssueStoreDetail.issue_uom_multiples.value = issue;
	}
}
function setMultiplesReq(from,to,batch,issue) {
	if (document.formAuthorizeAtIssueStoreDetail == null) {
		parent.frames[2].frames[0].document.formAuthorizeAtIssueStoreDetail.from_multiples.value = from;
		parent.frames[2].frames[0].document.formAuthorizeAtIssueStoreDetail.to_multiples.value = to;
		parent.frames[2].frames[0].document.formAuthorizeAtIssueStoreDetail.req_batch_multiples.value = batch;
		parent.frames[2].frames[0].document.formAuthorizeAtIssueStoreDetail.req_uom_multiples.value = issue;
	} else {
		document.formAuthorizeAtIssueStoreDetail.from_multiples.value = from;
		document.formAuthorizeAtIssueStoreDetail.to_multiples.value = to;
		document.formAuthorizeAtIssueStoreDetail.req_batch_multiples.value = batch;
		document.formAuthorizeAtIssueStoreDetail.req_uom_multiples.value = issue;
	}
}
function calculateConversion(req_string){
	var formHeader = parent.AuthorizeAtIssueStoreHeaderFrame.document.formAuthorizeAtIssueStoreHeader;
	var store_code = formHeader.from_store_code.value;
	var to_store_code = formHeader.to_store_code.value;
	var uom_code = "";
	bean_id = document.formAuthorizeAtIssueStoreDetail.bean_id.value;
	bean_name = document.formAuthorizeAtIssueStoreDetail.bean_name.value;
	if(req_string=="REQ_UOM"){
		uom_code = document.formAuthorizeAtIssueStoreDetail.pur_uom_code.value;
	}else{
		uom_code = document.formAuthorizeAtIssueStoreDetail.iss_uom_code.value;
	}
	if (document.formAuthorizeAtIssueStoreDetail.dec_allowed_yn.value == "N") {
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/AuthorizeAtIssueStoreValidate.jsp?item_code=" + document.formAuthorizeAtIssueStoreDetail.item_code.value + "&fm_store_code=" + store_code + "&to_store_code=" + to_store_code+"&issue_uom_code="+uom_code + "&function_type=18&bean_id=" + bean_id + "&bean_name=" + bean_name+"&req_string="+req_string, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
	}
}

async function callBatchSearch() {
		var formObj = document.formAuthorizeAtIssueStoreBatchSearch;
		var store_code = formObj.store_code.value;
		var _item_code = formObj.item_code.value;
		var item_qty = formObj.issuing_qty.value;
		var includeZeroStockBatches = "N";
		var includeExpiredBatches = "N";
		var includeSuspendedBatches = "N";
		var searchFunction = "Y";
		var multipleSelect = "Y";
		var retval = await callBatchSearchWindow(_item_code, store_code, includeZeroStockBatches, includeExpiredBatches, includeSuspendedBatches, searchFunction, multipleSelect, "", formObj.doc_type_code.value, formObj.doc_no.value, formObj.trn_type.value);
		if (retval != null && retval!="" && retval!=undefined) {
			window.returnValue = retval;
			parent.window.close();
		} else {
		
		}
}
async function batchDetails(){
	
	var formObj = document.formAuthorizeAtIssueStoreDetail;
	//Added for MMS-DM-SCF-0244 by B.Badmavathi on 06/06/2016 starts
	var bean_id = "authorizeAtIssueStoreBean";
	var bean_name = "eST.AuthorizeAtIssueStoreBean";
	var item_code = formObj.item_code.value;
	var fm_store_code = parent.AuthorizeAtIssueStoreHeaderFrame.document.formAuthorizeAtIssueStoreHeader.from_store_code.value;
	var to_store_code = parent.AuthorizeAtIssueStoreHeaderFrame.document.formAuthorizeAtIssueStoreHeader.to_store_code.value;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getEnhancedXMLString(formObj));
	xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObj), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/AuthorizeAtIssueStoreValidate.jsp?item_code=" + item_code + "&fm_store_code=" + fm_store_code + "&to_store_code=" + to_store_code+"&function_type=21&bean_id=" + bean_id + "&bean_name=" + bean_name, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	if(!result){
		alert("APP-ST0043 Insufficient batch quantity");
	}
	else
	{//Added for MMS-DM-SCF-0244 by B.Badmavathi on 06/06/2016 ends
	var arrayObject = new Array(formObj.item_code, formObj.issuing_qty);
	var names = new Array(getLabel("Common.item.label", "Common"), getLabel("eST.AuthorizeQuantity.label", "ST"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.messageFrame);
	if (blankObject == true) {
		var store_code = parent.AuthorizeAtIssueStoreHeaderFrame.document.formAuthorizeAtIssueStoreHeader.from_store_code.value;
		var formObj1 = parent.AuthorizeAtIssueStoreHeaderFrame.document.formAuthorizeAtIssueStoreHeader;
		var _item_code = formObj.item_code.value;
		var item_qty = formObj.issuing_qty.value;
		//Added by suresh.r on 04-07-2014 against TTM-SCF-0104 beg
		//var iss_uom_qty_chk = formObj.iss_uom_qty_chk.value;
		var iss_uom_qty_chk = formObj.issuing_qty.value;//Modified iss_uom_qty to issuing_qty against ML-BRU-SCF-1710
		//Added by suresh.r on 04-07-2014 against TTM-SCF-0104 end
		var retVal = await window.showModalDialog("../../eST/jsp/AuthorizeAtIssueStoreBatchSearch.jsp?function=changebatch&batchsearch=newbatch&store_code=" + store_code + "&item_code=" + _item_code + "&item_qty=" + item_qty + "&iss_uom_qty_chk=" + iss_uom_qty_chk + "&function_id" + parent.parent.function_id + "&doc_type_code" + formObj1.doc_type_code.value + "&trn_type" + formObj1.trn_type.value + "&doc_no" + formObj1.doc_no.value + "&index=" + formObj.index.value, "","dialogHeight:75vh; dialogWidth: 55vw; right: 1; status: no; dialogTop :300;scroll:yes");
		
		if(retVal != undefined && retVal.length == undefined){ //Added by Rabbani #42720(AMRI-SCF-10038) on 28-AUG-13
		var qty = parseInt(retVal);
		if(isNaN(qty)){
			retVal = retVal;
		}else{
			formObj.total_batch_qty.value = qty;
			retVal=null;
		}
	   }
		    
		while (retVal!=undefined && retVal != null && retVal!="" ) {
			var retVal = await window.showModalDialog("../../eST/jsp/AuthorizeAtIssueStoreBatchSearch.jsp?function=search&batchsearch=newbatch&store_code=" + store_code + "&item_code=" + _item_code + "&item_qty=" + item_qty + "&function_id" + parent.parent.function_id + "&doc_type_code" + formObj1.doc_type_code.value + "&trn_type" + formObj1.trn_type.value + "&doc_no" + formObj1.doc_no.value + "&index=" + formObj.index.value, "","dialogHeight:75vh; dialogWidth: 55vw; right: 1; status: no; dialogTop :300;scroll:yes");
						
			var qty = parseInt(retVal);
			if(isNaN(qty)){
				retVal = retVal;
			}else{
				formObj.total_batch_qty.value = qty;
				retVal=null;
			}
			
		}
	
	}	
		}//Added for MMS-DM-SCF-0244 by B.Badmavathi on 06/06/2016
}
function CheckDtlQuantity(index) {
	if(document.formAuthorizeAtIssueStoreBatchSearch.dec_allowed_yn.value=="Y"){
		if (!checkDoubleFormat(eval("document.formAuthorizeAtIssueStoreBatchSearch.item_qty_" + index))) {
			return false;
		}
	}else{
		if (!checkIntegerFormat(eval("document.formAuthorizeAtIssueStoreBatchSearch.item_qty_" + index))) {
			return false;
		}
	}
	if (parseFloat(eval("document.formAuthorizeAtIssueStoreBatchSearch.item_qty_" + index + ".value")) > parseFloat(eval(document.getElementById('id_stock_avail_' + index).innerText))) {
		alert(getMessage("QTY_NOT_GRT_AVLQTY", "ST"));
		//eval("document.formAuthorizeAtIssueStoreBatchSearch.item_qty_" + index).focus();
		eval("document.formAuthorizeAtIssueStoreBatchSearch.item_qty_" + index).value="";
		return false;
	}
}
function exitBatchSearch() {
	close_check="Y";	// Added for TTM-SCF-0198
	  
	var formObj = document.formAuthorizeAtIssueStoreBatchSearch;
		var bean_id = "authorizeAtIssueStoreBean";
		var bean_name = "eST.AuthorizeAtIssueStoreBean";
		var total_qty = 0;
		var totalRecords = formObj.total_checkboxes.value;
		for (var i = 0; i < totalRecords; i++) {
			if(eval("document.formAuthorizeAtIssueStoreBatchSearch.item_qty_"+i).value != ""){
				var qty = eval("document.formAuthorizeAtIssueStoreBatchSearch.item_qty_"+i).value;
				total_qty = total_qty + parseFloat(qty) ;
			}
			
			
		}
		
		window.returnValue = total_qty;
	
	if(parseFloat(total_qty) == parseFloat(formObj.issuing_qty.value)){	
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getEnhancedXMLString(formObj));
		xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObj), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/AuthorizeAtIssueStoreValidate.jsp?item_code=" + formObj.item_code.value+ "&item_qty=" + formObj.issuing_qty.value + "&function_type=19&bean_id=" + bean_id + "&bean_name=" + bean_name, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		window.close();
	}else{
		alert("Total Batch Quantity should be equal to Issue UOM Quantity");
	}	
}

//Added for TTM-SCF-0198 start 
function exitBatchSearch1() {
	var formObj = document.formAuthorizeAtIssueStoreBatchSearch;
	var bean_id = "authorizeAtIssueStoreBean";
	var bean_name = "eST.AuthorizeAtIssueStoreBean";
	var total_qty = 0;
	var totalRecords = formObj.total_checkboxes.value;
	var total_batchqty=0;
	var test="N";
	var prathyusha="N";
	for (var i = 0; i < totalRecords; i++) {
		
		if(close_check !="Y"){
		if(eval("document.formAuthorizeAtIssueStoreBatchSearch.Batchqty"+i).value != eval("document.formAuthorizeAtIssueStoreBatchSearch.item_qty_"+i).value){
		(eval("document.formAuthorizeAtIssueStoreBatchSearch.item_qty_"+i).value) = (eval("document.formAuthorizeAtIssueStoreBatchSearch.Batchqty"+i).value);
		
		}
		}
	if(eval("document.formAuthorizeAtIssueStoreBatchSearch.Batchqty"+i).value == ""){
	  total_batchqty=total_batchqty+0;
	
	}
	
	   else{
	   total_batchqty=total_batchqty+parseFloat(eval("document.formAuthorizeAtIssueStoreBatchSearch.Batchqty"+i).value);
	  
	  }
		if(eval("document.formAuthorizeAtIssueStoreBatchSearch.item_qty_"+i).value != ""){
			var qty = eval("document.formAuthorizeAtIssueStoreBatchSearch.item_qty_"+i).value;
			total_qty = total_qty + parseFloat(qty) ;
		}
		
		
	}
	
	//window.returnValue = total_qty;
if( parseFloat(total_batchqty) != 0 ){
if(parseFloat(total_qty) == parseFloat(formObj.issuing_qty.value)){	
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getEnhancedXMLString(formObj));
	xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObj), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/AuthorizeAtIssueStoreValidate.jsp?item_code=" + formObj.item_code.value+ "&item_qty=" + formObj.issuing_qty.value + "&function_type=19&bean_id=" + bean_id + "&bean_name=" + bean_name, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	//window.close();
}else{
	alert("Total Batch Quantity should be equal to Issue UOM Quantity");
}	
}

}//Added for TTM-SCF-0198 end

function addToList() {

	//toConvFactor();
		
		var formObjDtl = document.formAuthorizeAtIssueStoreBatchSearch;
		
	//	var formObj = parent.parent.parent.AuthorizeAtIssueStoreDetailFrame.document.formAuthorizeAtIssueStoreDetail;
		var proceed = false;
		var messageFrame = parent.parent.messageFrame;
		var errorPage = "../../eCommon/jsp/error.jsp";
	//	var item_qty = formObj.issuing_qty.value;
		var item_qty = 2;
		_total_checkboxes = formObjDtl.total_checkboxes.value;
		var sum = 0;
		//var remarks_1 = formObj.remarks.value;
		//var remarks_code = formObj.remarks_code.value;
		
		for (i = 0; i < _total_checkboxes; i++) {
			var qty = eval("formObjDtl.item_qty_" + i).value;
			if (qty == "") {
				qty = 0;
			}
			if (!isNaN(qty)) {
				sum += parseFloat(qty);
			}
			/*if (document.formAuthorizeAtIssueStoreDetail.for_bin_to_store_hidden.value != "N") {
				if (eval("formObjDtl.to_bin_location_code_" + i).value == "") {
					alert(getMessage("TO_BIN_LOC_NOT_BLANK", "ST"));
					return;
				}
			}
			*/
			
		}
	//	if(parent.document.formAuthorizeAtIssueStoreDetail.dec_allowed_yn.value == "Y"){
	//		sum = sum.toFixed(document.formAuthorizeAtIssueStoreDetail.no_of_decimals.value);
	//	}
		sum = sum.toFixed(3);
		if (sum != item_qty) {
			alert(getMessage("QUANTIY_MUST_BE_EQUAL", "ST"));
			//return;
		}
	
	/*	if (formObjDtl.batchsearch.value == "newbatch") {
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			xmlDoc.loadXML(getXMLString(null));
			xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?validate=setnewbatch&index=" + formObj.index.value, false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			if (!result) {
				parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
				return;
			}
		}
	
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getEnhancedXMLString(formObjDtl));
		

		xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?index=" + formObj.index.value + "&doc_srl_no=" + formObj.doc_srl_no.value + "&item_code=" + formObj.item_code.value + "&store_code=" + formObj.store_code.value + "&uom_code=" + formObj.uom_code.value + "&item_desc=" + encodeURIComponent(formObj.item_desc.value,"UTF-8") + "&item_qty=" + formObj.item_qty.value + "&item_unit_cost=" + document.getElementById('item_unit_cost').value + "&stock_item_yn=" + formObj.stock_item_yn.value + "&item_cost_value=" + document.getElementById('id_item_sal_value').innerText + "&expiry_yn=" + formObj.expiry_yn.value + "&uom_desc=" + document.getElementById('uom_desc').innerText + "&stock_uom_desc=" + document.getElementById("id_uom").innerText + "&stock_available=" + document.getElementById('id_stock_available').innerText + "&validate=ADD_TO_LIST&for_bin_to_store_hidden=" + document.formIssueListHeader.for_bin_to_store_hidden.value + "&iss_uom_code=" + formObj.iss_uom_code.value + "&uom_conv_code=" + formObj.iss_conv_fact.value + "&iss_uom_qty=" + formObj.iss_uom_qty.value + "&expired_batch=" + formObjDtl.expired_batch.value + "&ex_param_days=" + formObjDtl.ex_param_days.value + "&frm_store_qty_on_hand=" + formObj.frm_store_qty_on_hand.value + "&frm_store_min_stk_level=" + formObj.frm_store_min_stk_level.value + "&frm_store_max_stk_level=" + formObj.frm_store_max_stk_level.value + "&frm_store_reorder_level=" + formObj.frm_store_reorder_level.value + "&to_store_qty_on_hand=" + formObj.to_store_qty_on_hand.value + "&to_store_min_stk_level=" + formObj.to_store_min_stk_level.value + "&to_store_max_stk_level=" + formObj.to_store_max_stk_level.value + "&to_store_reorder_level=" + formObj.to_store_reorder_level.value + "&to_conv_fact=" + formObj.tmp_conv.value + "&frm_conv_fact=" + formObj.frm_conv_fact.value + "&frm_store_uom_desc=" + formObj.frm_store_uom_desc.value + "&to_store_uom_desc=" + formObj.to_store_uom_desc.value + "&batch_records=" + formObjDtl.total_checkboxes.value + "&remarks=" + encodeURIComponent(formObj.remarks.value,"UTF-8")+"&kit_item_yn="+formObj.kit_item_yn.value+"&kit_template_uom="+formObj.kit_template_uom.value+ "&remarks_code=" + formObj.remarks_code.value+"&iss_uom_conv_text="+document.getElementById('id_iss_uom_conv').innerHTML+"&from_multiples="+formObj.from_multiples.value+"&to_multiples="+formObj.to_multiples.value+"&batch_multiples="+formObj.batch_multiples.value+"&issue_uom_multiples="+formObj.issue_uom_multiples.value, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);

		if (result) {
			parent.parent.frameIssueHeader.formIssueHeader.preview.disabled = false;
			var arr = "";
			for (i = 0; i < parent.parent.frameIssueDetail.document.forms[0].total_checkboxes.value; i++) {
				if ((eval("parent.parent.frameIssueDetail.document.forms[0].checkbox" + i).checked)) {
					arr = arr + "," + "CHECKED";
				} else {
					arr = arr + "," + "s";
				}
			}

			parent.parent.frameIssueDetail.location.href = "../../eST/jsp/IssueDetail.jsp?function_id=" + parent.parent.function_id + "&index=" + formObj.index.value + "&arr=" + arr + "&tmp_conv=" + formObj.tmp_conv.value + "&kit12=" + formObj.kit.value+"&search_str="+encodeURIComponent(parent.parent.frameIssueDetail.document.formIssueDetail.search_str.value);
			refreshDetails();
		} else {
			parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
		}
	}
	*/

}

function valueChange(obj) {
			//if (document.formAuthorizeAtIssueStoreDetail.iss_uom_qty_chk.value == obj.value) {
			if (parseFloat(document.formAuthorizeAtIssueStoreDetail.pending_item_qty_chk.value) == obj.value) {
			document.formAuthorizeAtIssueStoreDetail.remarks_mandatory.style.visibility = "hidden";
		} else {
			document.formAuthorizeAtIssueStoreDetail.remarks_mandatory.style.visibility = "visible";
			
		}
	
	}
	
	
//Added by sakti against ML-BRU-SCF-0963[INC#42099]	
function Setitemdesc(obj){
	document.formAuthorizeAtIssueStoreDetail.item_desc.value = decodeURIComponent(obj.value,"UTF-8");
} 

//Added for IN:071868 start
function resetQty(issuomqty){
	var formObject = document.formAuthorizeAtIssueStoreDetail;
	var bean_id = "authorizeAtIssueStoreBean";
	var bean_name = "eST.AuthorizeAtIssueStoreBean";
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getEnhancedXMLString(formObject));
	xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObject), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/AuthorizeAtIssueStoreValidate.jsp?item_code=" + formObject.item_code.value+ "&function_type=22&bean_id=" + bean_id + "&bean_name=" + bean_name, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
//Added for IN:071868 end
//Adding start for MO-CRF-20166
async function viewIssueHistory(){

	var to_store =parent.AuthorizeAtIssueStoreHeaderFrame.document.formAuthorizeAtIssueStoreHeader.to_store_code.value
	var from_store =parent.AuthorizeAtIssueStoreHeaderFrame.document.formAuthorizeAtIssueStoreHeader.from_store_code.value
	var item_code = document.formAuthorizeAtIssueStoreDetail.item_code.value;
	var called_from ="AUT";
	var title ="";
	var dialogHeight= "90vh" ;
var dialogWidth	= "80vw" ;
var dialogTop	= "150" ;
var dialogLeft	= "80" ;
var center		= "1" ;
var status		= "no";
var scroll		= "yes";
var features	= "dialogLeft:" + dialogLeft + ";dialogHeight:"+dialogHeight+"; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop+";dialogTitle:"+title;
var arguments	= "" ;
 await window.showModalDialog("../../eST/jsp/IssueHistoryFrame.jsp?item_code="+item_code+"&request_by_store="+from_store+"&request_on_store="+to_store+"&called_from="+called_from,arguments,features);
}
//Adding end for MO-CRF-20166
