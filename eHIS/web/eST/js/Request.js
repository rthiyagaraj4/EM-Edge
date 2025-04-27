/*
 ------------------------------------------------------------------------------------------------------------------------------
Date		Edit History		Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
20/04/2017	IN061750			Badmavathi B									        ML-MMOH-CRF-0567	
08/05/2018	IN067386			Shazana 												ML-MMOH-SCF-0979	
06/06/2018	IN067830			Shazana													ML-MMOH-SCF-1013
14/10/2019  IN:071343           B Haribabu                                         		GHL-CRF-0608	
3/11/2021	TFS:25345			Shazana													MO-CRF-20172-US004
-------------------------------------------------------------------------------------------------------------------------------
*/ 
var xmlDom;
var xmlHttp;
var finalizeType = "N";
var prevObj = null; 
var prevColor = null;
var uom_conv_new= null; //added for ML-MMOH-SCF-0979 

function assignBean(frmObject) {
	bean_id = frmObject.bean_id.value;
	bean_name = frmObject.bean_name.value;
	//xmlDom = new ActiveXObject("Microsoft.XMLDom");
	//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	xmlDom ="";
	xmlHttp = new XMLHttpRequest();
}
function create() {
	f_query_add_mod.location.href = "../../eST/jsp/RequestFrame.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
}
function Modify(obj) {
	/**
	* @Name - Priya
	* @Date - 21/12/2009
	* @Inc# - IN017084
	* @Desc - To avoid the duplication records display in Modify mode
	*/
	var errorPage = "../../eCommon/jsp/error.jsp";
	document.getElementById('readOnlyDiv').style.visibility='visible';
	parent.parent.messageFrame.location.href = errorPage + "?err_num="+getMessage("ST_PROCESSING_WAIT", "ST");

	var doc_no = obj.cells[1].innerText;
	var doc_type_code = obj.cells[6].innerText;
	var item_class_desc = obj.cells[5].innerText;
	var item_class_code = obj.cells[7].innerText;
	parent.document.location.href = "../../eST/jsp/RequestFrame.jsp?mode=" + MODE_MODIFY + "&function_id=" + parent.parent.function_id + "&doc_type_code=" + doc_type_code + "&doc_no=" + doc_no + "&item_class_desc=" + item_class_desc + "&item_class_code=" + item_class_code;
}
async function deleterecord() {
	if( f_query_add_mod.RequestHeaderFrame==undefined){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	}
	var formHeader = f_query_add_mod.RequestHeaderFrame.document.formRequestHeader;
	
	if (formHeader.mode.value == MODE_MODIFY) {
		formHeader.mode.value = MODE_DELETE;
		if(formHeader.req_delete_yn.value=="N"){
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("NO_DELETE_ACCESS_FOR_USER", "ST");;
		formHeader.mode.value = MODE_MODIFY;
		return false;
		}
		var result = await confirmDelete();
		if (result == YES) {
			apply();
		} else {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + getMessage("OPER_CANCELLED", "ST");
			formHeader.mode.value = MODE_MODIFY;
		}
	} else {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
	}
}
function onSuccess() {
	var formObject = f_query_add_mod.RequestHeaderFrame.document.formRequestHeader;
	if (formObject.mode.value == MODE_DELETE) {
		f_query_add_mod.location.href = "../../eCommon/html/blank.html";
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + message;
	} else {
		if (formObject.mode.value == MODE_MODIFY) {
			if (finalizeType == YES) {
			//create();
				f_query_add_mod.location.href = "../../eCommon/html/blank.html";
			} else {
			//f_query_add_mod.document.location.reload();			
				f_query_add_mod.location.href = "../../eCommon/html/blank.html";
			}
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + message;
		} else {
			f_query_add_mod.location.href = "../../eCommon/html/blank.html";
		//reset();
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + message + "<BR>" + flag;
		}
	}
	return;
}
function displayItemDetail(idx) {
	var trObject = eval(document.getElementById('tr_'+idx));
	changeRowColor(trObject);
	var item_code = eval("document.formRequestList.item_code_" + idx + ".value");
	parent.RequestDetailFrame.document.location.href = "../../eST/jsp/RequestDetail.jsp?mode=" + MODE_MODIFY + "&function_id=" + parent.parent.function_id + "&item_code=" + item_code + "&edit=" + document.formRequestList.mode.value+"&index="+item_code;
}
function resetDetail() {
	document.location.href = "../../eST/jsp/RequestDetail.jsp?mode=" + MODE_INSERT + "&function_id=" + parent.parent.function_id;
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
}
function reset() {
	
	if(f_query_add_mod.RequestHeaderFrame!=undefined &&  f_query_add_mod.RequestHeaderFrame.document.formRequestHeader.mode.value == "1") {
	f_query_add_mod.RequestListFrame.document.location.href = "../../eST/jsp/RequestList.jsp?reset_mode=" + MODE_INSERT ; 
	f_query_add_mod.RequestDetailFrame.document.location.href = "../../eST/jsp/RequestDetail.jsp?reset_mode=" + MODE_INSERT +"&mode=" + MODE_INSERT; 
	f_query_add_mod.location.reload();
	}else{
	f_query_add_mod.location.reload();
	}
}
function query() {
	f_query_add_mod.location.href = "../../eST/jsp/RequestQueryFrame.jsp?function_id=" + function_id;
}
async function apply() {
	if( f_query_add_mod.RequestHeaderFrame==undefined){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	}
	var bean_id = "requestBean";
	var bean_name = "eST.RequestBean";
	var errorPage = "../../eCommon/jsp/error.jsp";
	var formHeader = f_query_add_mod.RequestHeaderFrame.document.formRequestHeader;
	var locale = formHeader.locale.value; 
	if (formHeader.mode.value == MODE_DELETE) {
		eval(formApply(formHeader, ST_CONTROLLER));
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "Common");
		if (result) {
			onSuccess();
		}
		return;
	}
	
	//Added by Rabbani INC NO:34758(RUT-CRF-0082) on 07/02/2013
	if(formHeader.hdr_remarks_reqd.value == "Y"){
	   var fields = new Array(formHeader.remarks);
	   var names = new Array(getLabel("Common.remarks.label", "Common"));
		blankObject = checkSTFields(fields, names, messageFrame, errorPage);
		if(!blankObject){
			return;
	   }
	  }
	 //ends
	var arrayObject = new Array(formHeader.doc_type_code, formHeader.doc_date, formHeader.request_by_store, formHeader.request_on_store);
	var names = new Array(getLabel("Common.DocType.label", "Common"), getLabel("Common.DocDate.label", "Common"), "Requested by Store", getLabel("Common.RequestedOnStore.label", "Common"));
	if (!formHeader.doc_no.disabled) {
		arrayObject[++arrayObject.length] = formHeader.doc_no;
		names[++arrayObject.length] = getLabel("Common.DocNo.label", "Common");
	}
	var formObject = f_query_add_mod.RequestListFrame.document.formRequestList;
	var total_items = formObject.total_checkboxes.value;
	/*MO-CRF-20172 starts*/
	var request_alert_yn= false; 
	if(formHeader.mode.value== "2"){
		for (count = 0; count < total_items; count++){
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&request_by_store=" + formHeader.request_by_store.value +"&request_on_store=" + formHeader.request_on_store.value +  "&item_code=" + eval("formObject.add_itm_" + count + ".value") + "&function_type=28" , false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			if(result){
				eval("formObject.add_itm_" + count).checked = false;
				request_alert_yn = true ; 
			}
		}
		if(request_alert_yn == true){
			alert(getMessage("ITEM_STORE_NO_OF_DAYS_GREATER", "ST")); 
		}
	}
	/*MO-CRF-20172 ends*/
/*current pending request checking */

	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&request_by_store=" + formHeader.request_by_store.value +"&request_on_store=" + formHeader.request_on_store.value + "&function_type=23" , false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	if(result){
		//retVal = window.showModalDialog("../../eST/jsp/PendingRequests.jsp?bean_id=requestBean&bean_name=eST.RequestBean&request_by_store=" + formHeader.request_by_store.value, "", "dialogHeight:20; dialogWidth:41; center:0; status: no; dialogLeft :250; dialogTop :250;scroll:no");
		//Modified against TTM-SCF-0112,TTM-SCF-0124 on 22-05-2015
		retVal = await window.showModalDialog("../../eST/jsp/PendingRequests.jsp?bean_id=requestBean&bean_name=eST.RequestBean&request_by_store=" + formHeader.request_by_store.value, "", "dialogHeight:50vh; dialogWidth:60vw; center:0; status: no; dialogLeft :350; dialogTop :175;scroll:no");
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
//	return false;
/*Pending Requests End*/
	
	
	var chkdValue = 0;
	for (count = 0; count < total_items; count++) {
		if (!eval("formObject.add_itm_" + count + ".checked")) {
			chkdValue++;
		}
	}
	if (total_items == chkdValue) {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("MIN_ONE_DETAIL_REQUIRED", "Common");
		return;
	}
	for (count = 0; count < total_items; count++) {
		if (eval("formObject.add_itm_" + count + ".checked")) {
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&item_code=" + eval("formObject.add_itm_" + count + ".value") + "&function_type=20", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			if (!result) {
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("QTY_CANNOT_BE_ZERO_ALL_RECORDS", "ST");
				return;
			}
		}
	}
	formObject.mode.value = formHeader.mode.value;
	formObject.doc_type_code.value = formHeader.doc_type_code.value;
	formObject.doc_no.value = formHeader.doc_no.value;
	 //commented by Rabbani #inc no:29579
    //formObject.doc_date.value = formHeader.doc_date.value; 
	//Added by Rabbani #inc no:29579
	formObject.doc_date.value = convertDate(formHeader.doc_date.value, "DMY", locale, "en");
	formObject.doc_ref.value = formHeader.doc_ref.value;
	formObject.request_by_store.value = formHeader.request_by_store.value;
	formObject.request_on_store.value = formHeader.request_on_store.value;
	formObject.item_class_code.value = formHeader.item_class_code.value;
	formObject.autono_yn.value = formHeader.autono_yn.value;
	formObject.request_type.value = formHeader.request_type.value;
	checkCanAuthorize(formObject.request_by_store);
	formHeader.authorize_yn.value = formHeader.authorize_yn.value.substring(0, 1);

	if (f_query_add_mod.RequestHeaderFrame.formRequestHeader.request_type.value == "N") {
		if (formHeader.authorize_yn.value == "Y") {
			
			//added for SKR-CRF-0039 By Ganga on 5th Aug 2013
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			var xmlStr	="<root><SEARCH " ;
			xmlStr+=" function_type=\"2\" ";		
			xmlStr +=" /></root>" ; 
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?trn_type=REQ&store_code="+formHeader.request_by_store.value, false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);		
			
			//finalizeType = confirmAuthorize(); commented
			if(result){
				finalizeType = await confirmAuthorize();	
			}else{
				finalizeType = YES;
			}
			//Added ends			
			
		if(finalizeType=="")
		{
		messageFrame.location.href = errorPage + "?err_num=";
		return false;
		}
		}
	} else {
		if (f_query_add_mod.RequestHeaderFrame.formRequestHeader.request_type.value == "S") {
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&store_code=" + formHeader.request_by_store.value + "&function_type=9" + "", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			formObject.finalize_yn.value = "N";
			if (result && message == "Y") {
							
				//added for SKR-CRF-0039 By Ganga on 5th Aug 2013
				var xmlHttp = new XMLHttpRequest();
				var xmlDoc="";
				var xmlStr	="<root><SEARCH " ;
				xmlStr+=" function_type=\"2\" ";		
				xmlStr +=" /></root>" ; 
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?trn_type=REQ&store_code="+formHeader.request_by_store.value, false);
				xmlHttp.send(xmlDoc);
				responseText = xmlHttp.responseText;
				eval(responseText);		
				
				//finalizeType = confirmAuthorize(); commented
				if(result){
					finalizeType = await confirmAuthorize();	
				}else{
					finalizeType = YES;
				}
				//Added ends				
				
			}
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "ST");
		}
	}
	
	
	if (finalizeType == "") {
		finalizeType = "N";
	}
	
	formObject.finalize_yn.value = finalizeType;
	var responseText = formApply(formObject, ST_CONTROLLER);
	eval(responseText);
	flag1 = (flag.split("~"))[0];
	flag2 = (flag.split("~"))[1];
	flag1 = (flag1 == "null" ? "" : flag1);
	if (result) {
		if (flag2 == "PY") {
            			 
				 // if(formObject.finalize_yn.value=="Yes")
				  //{
			var PConfirm = await confirmPrinting();
			if (PConfirm == "Yes") {
				var xmlHttp = new XMLHttpRequest();
				var xmlDoc="";
				//xmlDoc.loadXML(getXMLString(null));
				xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
				//xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?function_type=12&msg=" + encodeURIComponent(message) + "&bean_id=" + bean_id + "&bean_name=" + bean_name, false);
				xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?function_type=12&msg=" + encodeURIComponent(message) + "&bean_id=" + bean_id + "&bean_name=" + bean_name, true);
				xmlHttp.send(xmlDoc);
				//responseText = xmlHttp.responseText;
				//eval(responseText);
			}
					//}
		} else 	if (flag2 == "PN") {
   
				var xmlHttp = new XMLHttpRequest();
				var xmlDoc="";
				//xmlDoc.loadXML(getXMLString(null));
				xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
				//xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?function_type=12&msg=" + encodeURIComponent(message) + "&bean_id=" + bean_id + "&bean_name=" + bean_name, false);
				xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?function_type=12&msg=" + encodeURIComponent(message) + "&bean_id=" + bean_id + "&bean_name=" + bean_name, true);
				xmlHttp.send(xmlDoc);
				//responseText = xmlHttp.responseText;
				//eval(responseText);
		}
		messageFrame.location.href = errorPage + "?err_num=" + message + "<BR>" + (result ? flag1 : "");
		onSuccess();
		if (result) {
			messageFrame.location.href = errorPage + "?err_num=" + message + "<BR>" + flag1;
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
			f_query_add_mod.frameRequestDetail.location.href = "../../eST/jsp/RequestDetail.jsp?function_id=" + function_id + "&index=" + message + "&arr=" + arr;
		}else
			messageFrame.location.href = errorPage + "?err_num=" + message;
	}
	if(formHeader.sales_req_yn.value == "Y"){
		var display_msg = message;
		 display_msg = (display_msg.split("."))[0];
		 var sales_req_flag = display_msg +   "                                   " + flag1;
		 alert(sales_req_flag);
         window.close();
	}
}
function validateDocType(doc_type_code) {
	if (doc_type_code.value == "") {
		return;
	}
	var arrayObject = new Array();
	arrayObject[0] = doc_type_code;
	assignBean(f_query_add_mod.RequestHeaderFrame.document.formRequestHeader);
	xmlStr = getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=1", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
function checkCanAuthorize(request_by_store) {
	if (request_by_store.value == "") {
		return;
	}
	var arrayObject = new Array();
	arrayObject[0] = request_by_store;
	assignBean(f_query_add_mod.RequestHeaderFrame.document.formRequestHeader);
	xmlStr = getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=3", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
function populateToStoresInQuery(request_by_store) {
	if (request_by_store.value == "") {
		clearListItems("document.forms[0].request_on_store");
		return;
	}
	clearListItems("document.forms[0].request_on_store");
	var arrayObject = new Array();
	arrayObject[0] = request_by_store;
//	assignBean(f_query_add_mod.RequestQueryHeader.document.formRequestQueryCriteria);
	assignBean(parent.frames[0].document.forms[0]);
	xmlStr = getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=15", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
function loadItemClasses(request_by_store, request_on_store) {
	if (request_by_store.value == "" || request_on_store.value == "") {
		clearListItems("document.formRequestHeader.item_class_code");
		return;
	}
	var arrayObject = new Array();
	arrayObject[0] = request_by_store;
	arrayObject[1] = request_on_store;
	assignBean(f_query_add_mod.RequestHeaderFrame.document.formRequestHeader);
	xmlStr = getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=4", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
function loadItemClassesInQuery(request_by_store, request_on_store) {
	if (request_by_store.value == "" || request_on_store.value == "") {
		clearListItems("document.forms[0].item_class_code");
		return;
	}
	var arrayObject = new Array();
	arrayObject[0] = request_by_store;
	arrayObject[1] = request_on_store;
	assignBean(parent.frames[0].document.forms[0]);
	xmlStr = getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=16", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
function validateDocNo(enable) {
	headerForm = f_query_add_mod.RequestHeaderFrame.document.formRequestHeader;
	if (enable) {
		headerForm.autono_yn.value = YES;
	} else {
	}
}
function setAuthorize(authorizeValue) {
	f_query_add_mod.RequestHeaderFrame.document.formRequestHeader.authorize_yn.value = authorizeValue;
}
async function addItemRecord() {
	var formObject = document.formRequestDetail;
	var errorPage = "../../eCommon/jsp/error.jsp";
	var arrayObject = new Array(formObject.req_uom_qty);
	var names = new Array(getLabel("eST.ReqUOMQty.label", "ST"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.messageFrame, errorPage);
	if (blankObject != true) {
		return;
	}
	var formHeader = parent.RequestHeaderFrame.document.formRequestHeader;
	/*if (formHeader.request_by_store.value == formHeader.request_on_store.value) {
		parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("REQ_ON_REQ_BY_CANNOT_BE_SAME", "ST");
		formHeader.request_by_store.focus();
		return;
	}*/

	//Added by sakti against ML-BRU-SCF-1091.1 to restrict adding items based on transaction per record
	if(formHeader.mode.value == "2") {
		var formList = parent.RequestListFrame.document.formRequestList;
		var trn_per_record = formObject.trn_per_record.value ;
		var exist  = false;
		if(trn_per_record != "" ) {
			var chkdValue = 1;
			for (var count = 0; count < formList.total_checkboxes.value; count++) {
				if(eval("parent.RequestListFrame.document.formRequestList.item_code_" + count+ ".value") == formObject.item_code.value) {
						exist = true;
				}
				if (eval("formList.add_itm_" + count + ".checked")) {
					chkdValue++;
				}
			}
	
	var confirmProceed = "Yes";
	if(chkdValue - trn_per_record == "1" && !exist) {
		confirmProceed = await confirmYesNo("No. of items per doc exceeds the setup limit. New Doc no will be generated for the remaining items.Do you want to proceed ?");
	}
	
	if(confirmProceed=="No" || confirmProceed==""){
		return;
		}
	}
	//Added by sakti against ML-BRU-SCF-1091.1 to restrict adding items based on transaction per record ends
}
	
	
	
	var store_code = formHeader.request_by_store.value;
	var to_store_code = formHeader.request_on_store.value;
	var item_code = formObject.item_code.value;
	//09/02/12
	//starts
		  var request_type = parent.RequestHeaderFrame.formRequestHeader.request_type.value;
		  if(request_type == "S"){
			var bean_id = "requestBean";
	        var bean_name = "eST.RequestBean";
            var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&item_code=" + item_code + "&request_type=" + request_type + "&function_type=25", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			
			eval(responseText);
			if (!result) {
			alert(getMessage("INVALID_ITEM_FOR_REQ_TYPE", "ST"));
			parent.parent.messageFrame.location.href = errorPage;
			parent.RequestDetailFrame.location.reload();
			return;
			}
			}
			//ends
	
	var bean_id = "requestBean";
	var bean_name = "eST.RequestBean";
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));	
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	//formObject.uom.value = formObject.temp_uom.value;
	/* This Check is not Required as the same is done at the time of item search...
	xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&item_code=" + item_code + "&store_code=" + store_code + "&store_code_to=" + to_store_code+ "&function_type=6" + "", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;	
	eval(responseText);
	if (!result) {
		//parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("NOT_STOCK_ITEM", "ST"); PE
		parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
		return;
	}*/
	/* PE Commented
	xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&item_code=" + item_code + "&store_code=" + to_store_code + "&function_type=7" + "", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;		   
	eval(responseText);
	if (!result) {
		parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
		return;
	}
	/*
	Commented for PE...Open this block if problem exists.....Commented as this check is done twice...
	xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&item_code=" + item_code + "&store_code=" + store_code + "&function_type=6" + "", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;		   
	eval(responseText);
	if (!result) {
		alert("last one..");
		parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("NOT_STOCK_ITEM", "ST");
		return;
	}*/
	formObject.request_by_store.value = formHeader.request_by_store.value;
	formObject.request_on_store.value = formHeader.request_on_store.value;
	formObject.mode.value = formHeader.mode.value;
	var stock_item_yn = "N";
	if (formObject.stock_item_yn.checked) {
		stock_item_yn = "Y";
	}
	formObject.stock_item_yn.value = stock_item_yn;
//	formObject.item_desc.value = encodeURIComponent(formObject.item_desc.value,"UTF-8");commented for [IN:055189]
	assignBean(formObject);
	xmlStr = getEnhancedXMLString(formObject);
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	/* PE Commented
	if ((formObject.mode.value == MODE_INSERT) || ((formObject.mode.value == MODE_MODIFY) && (formObject.editing.value == 2))) {
		function_type = 2;
	} else {
		if ((formObject.mode.value == MODE_MODIFY) && (formObject.editing.value == 1)) {
			function_type = 5;
		}
	}
	alert("function_type==>"+function_type);
	xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=" + function_type, false);*/
	xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=2", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
	if (!result) {
		parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
		return;
	}
	parent.parent.messageFrame.location.href = errorPage;
	//parent.RequestListFrame.document.location.reload();
/*	index = formObject.srl_no.value;
	if (index != -1) {
		index = index - 1;
	}
*/	
	if(formObject.index.value==""){
		formObject.index.value=formObject.item_code.value;
	}
	parent.RequestListFrame.document.location.href = "RequestList.jsp?index=" + formObject.index.value;
	formObject.add.value = getLabel("Common.Add.label", "Common");
	formHeader.request_by_store.disabled = true;
	formHeader.request_on_store.disabled = true;
	formHeader.item_class_code.disabled = true;
	formObject.item_desc.readOnly = false;
	parent.RequestHeaderFrame.formRequestHeader.request_type.disabled = true;
	if (formObject.editing.value == "1") {
		formObject.item_desc.readOnly = false;
		formObject.add.disabled = true;
		document.getElementById('uom_label').innerHTML = "&nbsp;";
		document.getElementById('Qty_onhand_label').innerHTML = "&nbsp;";
		document.getElementById('max_stk_qty_label').innerHTML = "&nbsp;";
		document.location.href = "../../eST/jsp/RequestDetail.jsp?mode=" + MODE_INSERT + "&function_id=" + parent.parent.function_id;
	} else {
		document.location.href = "../../eST/jsp/RequestDetail.jsp?mode=" + MODE_INSERT + "&function_id=" + parent.parent.function_id;
	}
}
//Added for ML-MMOH-CRF-0567 starts 
function reqUOM(){
	var formObject = document.formRequestDetail;
	var store_code;
	store_code = parent.RequestHeaderFrame.document.getElementById('request_on_store').value;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?store_code=" + store_code+"&item_code="+formObject.item_code.value+ "&bean_id=" + formObject.bean_id.value + "&bean_name=" + formObject.bean_name.value +"&function_type=27", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	if(result){
		formObject.pur_uom_code.disabled = true;
		formObject.req_uom_qty.focus();
	}
	else{
		formObject.pur_uom_code.focus();
	}
	return;
}
//Added for ML-MMOH-CRF-0567 ends
async function callItemSearch() {
	var formHeader = parent.RequestHeaderFrame.document.formRequestHeader;
	var errorPage = "../../eCommon/jsp/error.jsp";
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	formHeader.request_by_store.value = formHeader.from_store_code.value;
	formHeader.request_on_store.value = formHeader.to_store_code.value;
	var arrayObject = new Array(formHeader.request_by_store, formHeader.request_on_store);
	var names = new Array(getLabel("Common.ReqByStore.label", "Common"), getLabel("Common.ReqOnStore.label", "Common"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.messageFrame, errorPage);
	if (blankObject != true) {
		return;
	}
	var formObject = document.formRequestDetail;
	formObject.item_class_desc.value = formHeader.item_class_desc.value;
	var item_class_desc = formHeader.item_class_des.value;
	var search_string = formObject.item_desc.value;
	var store_code = formHeader.request_by_store.value;
	var store_code_to = formHeader.request_on_store.value;
	var mode = formHeader.mode.value;
	var category = "";
	var sole_source = "A";
	var ps_item = "A";
	var mfg_item = "A";
	var expiry = "A";
	var consignment = "A";
	var issue_history_durn =formObject.issue_history_durn.value;//Added for MO-CRF-20166
	if (mode == 2) {
		var item_class = formHeader.item_class_code1.value;
		if (item_class == "null") {
			item_class = "";
		}
	} else {
		var item_class = formHeader.item_class_code.value;
	}
	
	
	//formHeader.item_class_code.[formHeader.item_class_code.selectedIndex].text=item_class;
	var to_store_code = formHeader.from_store_code.value;
	var chkitemstorecmb = "Y";
	var kit = "Y";
	/* Modified on 11/1/2006 by Rammohan.C
		chkitemstorecmb is added to display the  item check check box in  item search  query criteria page and it is used to check the item which exist in both the stores.
		 If that check box is checked it will display the items which is associated in both the stores and also have qty_on_hand >0 . If  there is no to_store  code , then assign blank to it.
		 */
//	var results = callItemSearchWindow(search_string,store_code,category,sole_source,ps_item,mfg_item,expiry, item_class,consignment);
	//var results = callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment, chkitemstorecmb, store_code_to, "", item_class_desc, kit);
	 
	var results = await callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment,"", chkitemstorecmb, store_code_to, "", item_class_desc, kit);
	
	if (results != null) {
		
		var bean_id = "requestBean";
		var bean_name = "eST.RequestBean";
		//alert("kittt" +results[0]);
		if (results[0] == "kit") {
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?kit_template_code=" + results[1] + "&store_code=" + store_code + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&store_code_to="+store_code_to+"&function_type=17", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			return;
		}
		var item_code = results[0];
	/**
	* @Name - Mahesh
	* @Date - 12/01/2010
	* @Inc# - IN015496
	* @Desc - Decimal Allowed yn is set form JS.
	*/
		document.formRequestDetail.dec_allowed_yn.value = results[27];
		document.formRequestDetail.no_of_decimals.value = results[28];

		//if(results[27]=="Y"){
			//document.formRequestDetail.req_uom_qty.maxlength=12;
			//document.formRequestDetail.document.getElementById('req_uom_qty').maxLength=15;
		//}
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&item_code=" + item_code + "&store_code=" + to_store_code + "&function_type=6&store_code_to=" + store_code_to, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if (result) {
//			formObject.stock_item_yn.checked = true;
			//parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
			var request_type = parent.RequestHeaderFrame.formRequestHeader.request_type.value;
			var bean_id = "requestBean";
			var bean_name = "eST.RequestBean";
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";

// ===================== Start of MIn Max Validation by Rammohan.C 10/30/2006 ==========
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&item_code=" + results[0] + "&store_code=" + formHeader.request_by_store.value+"&no_of_decimals="+results[28]+"&dec_allowed_yn="+results[27]+ "&function_type=13" + "", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			if (!result) {
				parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "ST");
				document.location.href = "../../eST/jsp/RequestDetail.jsp?mode=" + MODE_INSERT + "&function_id=" + parent.parent.function_id;
				return;
			}

// ===================== End of MIn Max Validation by Rammohan.C 10/30/2006 ==========
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&item_code=" + results[0] + "&uom_code=" + results[13] + "&request_type=" + request_type + "&req_uom_code=" + results[26] + "&store_code=" + formHeader.request_by_store.value + "&function_type=8" + "", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			if (!result) {
				parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message);
				document.location.href = "../../eST/jsp/RequestDetail.jsp?mode=" + MODE_INSERT + "&function_id=" + parent.parent.function_id;
				return;
			}
			
			//08/02/12
			if(request_type == "S"){
			var bean_id = "requestBean";
	        var bean_name = "eST.RequestBean";
            var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			
			xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&item_code=" + results[0] + "&request_type=" + request_type + "&function_type=25", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			
			eval(responseText);
			if (!result) {
			alert(getMessage("INVALID_ITEM_FOR_REQ_TYPE", "ST"));
			parent.parent.messageFrame.location.href = errorPage;
			//parent.RequestListFrame.document.location.href="RequestList.jsp";
			parent.RequestDetailFrame.location.reload();
			
			//refreshDetails();
			}
			}
			//ends
			
			
			
		} else {
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?";
			//err_num="+ getMessage(message);
			if (message == "PHY_INV_PROCESS_INITIATED") {
				alert(getMessage(message, "ST") + "\n" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + formObject.phy_inv_id.value);
			} else {
				alert(getMessage(message, "ST"));
			}
			document.location.href = "../../eST/jsp/RequestDetail.jsp?mode=" + MODE_INSERT + "&function_id=" + parent.parent.function_id;
			return;
			//refreshDetails();
		}
		formObject.item_code.value = results[0];
		formObject.item_desc.value = results[1];
		formObject.item_desc.readOnly = true;
		formObject.uom.value = results[13];// 3 changed to 13 on Wednesday, December 31, 2003
		formObject.temp_uom.value = results[15];
		formObject.add.disabled = false;
		document.getElementById('uom_label').innerHTML = "<B>" + results[15] + "</B>"; 
        //alert(formObject.uom.value);
//		formObject.uom.value =  results[25];
		
		if (formObject.pur_uom_code.value == "") {
		    formObject.pur_uom_code.value = results[13];
		}
		
			// ===================== Pur/Sale Am Uom  Validation by Rams 4/22/2009 ==========
			var bean_id = "requestBean";
	        var bean_name = "eST.RequestBean";
            var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			
			xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?function_type=22&bean_id=" + bean_id + "&bean_name=" + bean_name+"&pur_uom_code="+formObject.pur_uom_code.value, false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			
			eval(responseText);
			if (!result) {
			alert(getMessage("PUR_SALE_UOM_UNDEFINED", "ST"));
			parent.parent.messageFrame.location.href = errorPage;
			//parent.RequestListFrame.document.location.href="RequestList.jsp";
			parent.RequestDetailFrame.location.reload();
			
			//refreshDetails();
			}
		// =====================End Pur/Sale Am Uom  Validation by Rams 4/22/2009 ==========
		document.getElementById('id_pur_uom_conv').innerHTML = "1";
		document.formRequestDetail.conv_fact.value = "1";
		if(issue_history_durn !="")//Added for MO-CRF-20166
		document.getElementById('iss_history').style.visibility  = "visible";//Added for MO-CRF-20166
		checkUOMConvFactor();
		 reqUOM();//Added for ML-MMOH-CRF-0567
		formObject.pur_uom_code.focus();
		formHeader.store_code_disabled.value = "disabled";
		if (result && retVal[27] == "N") {
			var bean_id = "requestBean";
	        var bean_name = "eST.RequestBean";
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?function_type=24&bean_id=" + bean_id + "&bean_name=" + bean_name+"&item_code=" + formObject.item_code.value + "&fm_store_code=" + store_code + "&to_store_code=" + store_code_to+"&issue_uom_code="+formObject.pur_uom_code.value, false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
		}
	}
}
function setParentStoreCode(store_code) {
	f_query_add_mod.RequestHeaderFrame.document.formRequestHeader.request_on_store.value = store_code;
}
function selectUOMcode(default_uom) {
	parent.frames[2].document.formRequestDetail.pur_uom_code.value = default_uom;
}
function defaultFirstElement() {
	var formObject = document.formRequestHeader;
	if ((formObject.mode.value == MODE_INSERT) && (formObject.request_by_store.length > 0)) {
		formObject.request_by_store.selectedIndex = 1;
		formObject.request_by_store.focus();
		formObject.request_on_store.focus();
	}
	if (formObject.mode.value == MODE_INSERT) {
		formObject.doc_type_code.focus();
	}
}
function updateValues() {
	var formObject = document.formRequestHeader;
    if(parent.RequestListFrame.document.formRequestList!=null && parent.RequestListFrame.document.formRequestList.total_checkboxes!=null)
	{
	var total_checkboxes =parent.RequestListFrame.document.formRequestList.total_checkboxes.value;//added for MO-CRF-20172
    }	
	var request_alert_yn= false; 
	var bean_id = "requestBean";
	var bean_name = "eST.RequestBean"; //END 
	if (formObject.to_store_code) {
		formObject.request_by_store.value = formObject.from_store_code.value;
		formObject.request_on_store.value = formObject.to_store_code.value;
		formObject.item_class.value = formObject.item_class_code.value;
		formObject.item_class_des.value = formObject.item_class_desc.value;
	}
	if(formObject.mode.value == "2"){//added for MO-CRF-20172
		for (count = 0; count < total_checkboxes; count++){
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&request_by_store=" + formObject.request_by_store.value +"&request_on_store=" + formObject.request_on_store.value +  "&item_code=" + eval("parent.RequestListFrame.document.formRequestList.add_itm_" + count + ".value") + "&function_type=28" , false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			if(result){
				eval("parent.RequestListFrame.document.formRequestList.add_itm_" + count).checked = false;
				request_alert_yn = true ; 
			}
		}
		if(request_alert_yn == true){
			alert(getMessage("ITEM_STORE_NO_OF_DAYS_GREATER", "ST")); 
		}
	}//END  
}
/* Code added for display Conv Factor */
function checkUOMConvFactor() {
	var formObj = document.formRequestDetail;
	/*added for ml-mmoh-scf-0979 start*/
	var store_code = parent.RequestHeaderFrame.document.formRequestHeader.request_by_store.value;
	var to_store_code = parent.RequestHeaderFrame.document.formRequestHeader.request_on_store.value;
	/*added for ml-mmoh-scf-0979 end*/
	
	//if (formObj.uom.value == formObj.pur_uom_code.value) {
	//	setUOMConvFactor("1");
	//	return;
	//}
	//alert("uom:" +formObj.uom.value);
	//alert("pur_uom_code:" +formObj.pur_uom_code.value);
	var formObj = document.formRequestDetail;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?uom=" + formObj.uom.value + "&pur_uom_code=" + formObj.pur_uom_code.value + "&bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value + "&function_type=10" + "&item_code=" + formObj.item_code.value + "&store_code=" + store_code, false);//added for ML-MMOH-SCF-0979
	//xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?uom=" + formObj.uom.value + "&pur_uom_code=" + formObj.pur_uom_code.value + "&bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value + "&function_type=10" + "&item_code=" + formObj.item_code.value, false);// COMMENTED for ML-MMOH-SCF-0979
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	//alert(responseText);
	eval(responseText);
	if (!result) {
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "ST");
		formObj.pur_uom_code.value = formObj.uom.value;
		formObj.pur_uom_code.focus();
		setUOMConvFactor("1");
	}
}
function setUOMConvFactor(_value) {
	document.getElementById('id_pur_uom_conv').innerHTML = _value;
	document.formRequestDetail.conv_fact.value = _value;
	document.formRequestDetail.uom_conv_text.value = _value;
}
function calRequestQty() {
	var formObj = document.formRequestDetail;
	var dec_allowed_yn = document.formRequestDetail.dec_allowed_yn.value;
	var no_of_decimals = document.formRequestDetail.no_of_decimals.value;
	var uom_convFactor = uom_conv_new;//ADDED FOR ML-MMOH-SCF-0979
	formObj.required_qty.value = "";
	var confact=parseFloat(document.formRequestDetail.conv_fact.value);//ADDED FOR ML-MMOH-SCF-0979
	calculateConversion();//added for ML-MMOH-CRF-1200
	//alert("formObj.req_uom_qty.value==="+formObj.req_uom_qty.value+"uom_convFactor==="+uom_convFactor+"confact==="+confact+"dec_allowed_yn=="+dec_allowed_yn);
	if (formObj.req_uom_qty.value == "") {
	} else {
		if(dec_allowed_yn=="Y"){
			formObj.required_qty.value =(parseFloat(document.formRequestDetail.conv_fact.value) * parseFloat(formObj.req_uom_qty.value)).toFixed(no_of_decimals);
			toConvFactor();
		}else{
			if(formObj.req_uom_qty.value%formObj.issue_uom_multiples.value !=0){
					alert("Req UOM Qty Should Be In Multiples Of "+formObj.issue_uom_multiples.value);
					formObj.required_qty.value = "";
					//formObj.req_uom_qty.focus();
					return false;
			}else{
						//added for ML-MMOH-SCF-1013						
						formObj.required_qty.value = (formObj.req_uom_qty.value * formObj.batch_multiples.value)/formObj.issue_uom_multiples.value ;//added for ML-MMOH-CRF-1200						
			}
		}
		if (formObj.max_stk_qty.value != null) {              // ========== Start of Min Max Validation by Rammohan.C === 
		}
		if (parseInt(formObj.required_qty.value)/parseInt(formObj.frm_tmp_conv.value) + parseInt(formObj.qty_on_hand.value) > parseInt(formObj.max_stk_qty.value)) {
			alert(getLabel("eST.exceedmaxStockLevel.label", "ST"));
		} //exceed max Stock Level
	}
	return true;
}
function changeRowColor(obj) {
	tot = document.forms[0].total_checkboxes.value;
	tot = tot - 1;
	if (prevObj != null) {
		for (k = 1; k < 10; k++) {
			prevObj.cells[k].className = prevColor;
		}
	}
	prevObj = obj;
	prevColor = obj.cells[1].className;
	for (k = 1; k < 10; k++) {
		obj.cells[k].className = "STLIGHTPINK";
	}
}
function updateCheckStatus(obj_item_code) {
	var check_status = "";
	var usage_type   = "" ; //17/09/12
	var formObj = document.formRequestList;
	assignBean(formObj);
	if (obj_item_code.checked) {
		check_status = "Y";
		usage_type   = "O";
	} else {
		check_status = "N";
		usage_type   = "P";
	}
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?item_code=" + obj_item_code.value + "&check_status=" + check_status + "&bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value+"&usage_type=" +usage_type + "&function_type=11", false);
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	eval(responseText);
}
function issueUOMQtyChk() {
	var formObj = document.formRequestDetail;
	toConvFactor();
	
	var dec_allowed_yn = document.formRequestDetail.dec_allowed_yn.value;
	if(dec_allowed_yn=="N"){
		var conv_factor = lcm(formObj.frm_tmp_conv.value, formObj.to_tmp_conv.value);
		var dec_factor = (formObj.required_qty.value) % (conv_factor);

		if (dec_factor > 0 && conv_factor > 1) {
			alert("Requested Quantity Should Be In Multiples Of " + conv_factor);
			return false;
		}else{
			return true;
		}
	}
	return true;
}
function setTempConvFactor(frm_tmp, to_tmp) {
	if (document.formRequestDetail == null) {
		parent.frames[2].frames[0].document.formRequestDetail.frm_tmp_conv.value = frm_tmp;
		parent.frames[2].frames[0].document.formRequestDetail.to_tmp_conv.value = to_tmp;
	} else {
		document.formRequestDetail.frm_tmp_conv.value = frm_tmp;
		document.formRequestDetail.to_tmp_conv.value = to_tmp;
	}
}
function toConvFactor() {
	var bean_id = "requestBean";
	var bean_name = "eST.RequestBean";
	var formObj = document.formRequestDetail;
	var item_code = "";
	if (formObj == null) {
		formObj = parent.frames[2].frames[0].document.formRequestDetail;
		var frm_store_code = parent.RequestHeaderFrame.document.formRequestHeader.request_by_store.value;
		var to_store_code = parent.RequestHeaderFrame.document.formRequestHeader.request_on_store.value;
	} else {
		var frm_store_code = parent.RequestHeaderFrame.document.formRequestHeader.request_by_store.value;
		var to_store_code = parent.RequestHeaderFrame.document.formRequestHeader.request_on_store.value;
	}
	item_code = formObj.item_code.value;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=14" + "&frm_store_code=" + frm_store_code + "&to_store_code=" + to_store_code + "&item_code=" + item_code, false);
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	//alert(responseText);
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
function kitGetStatus() {
    //alert("kitGet===========>");
	var formObj = document.formRequestDetail;
	var formHeader = parent.RequestHeaderFrame.document.formRequestHeader;
	var bean_id = "requestBean";
	var bean_name = "eST.RequestBean";
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&item_code=" + formObj.item_code.value + "&store_code=" + formHeader.request_by_store.value+"&no_of_decimals="+formObj.no_of_decimals.value+"&dec_allowed_yn="+formObj.dec_allowed_yn.value + "&function_type=13" + "", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	//alert("responseText===13========>" +responseText);
	eval(responseText);
	
	/*if(!result){
				parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage(message,"ST");
			document.location.href = "../../eST/jsp/RequestDetail.jsp?mode="+MODE_INSERT+"&function_id="+parent.parent.function_id;
			return;
	}*/
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&item_code=" + formObj.item_code.value + "&uom_code=" + formObj.uom.value + "&request_type=" + formHeader.request_type.value + "&store_code=" + formHeader.request_by_store.value + "&function_type=8" + "", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	/*if(!result){
				parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage(message);
			document.location.href = "../../eST/jsp/RequestDetail.jsp?mode="+MODE_INSERT+"&function_id="+parent.parent.function_id;
			return;
	}*/
	checkUOMConvFactor();
	//alert("responseText===903========>" +responseText);
	addToList1();
}
function kitNextItem() {
	parent.RequestDetailFrame.kitNextItemValidate();
}
function kitNextItemValidate() {
	
	var bean_id = "requestBean";
	var bean_name = "eST.RequestBean";
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=17", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	return;
}
function addToList1() {

   //alert("addtolist");
	var formObject = document.formRequestDetail;
	var errorPage = "../../eCommon/jsp/error.jsp";
	var arrayObject = new Array(formObject.req_uom_qty);
	var names = new Array(getLabel("eST.ReqUOMQty.label", "ST"));
	var err = "";
	var blankObject = checkSTFields(arrayObject, names, parent.parent.messageFrame, errorPage);
	if (blankObject != true) {
		return;
	}
	var formHeader = parent.RequestHeaderFrame.document.formRequestHeader;
	
	if (formHeader.request_by_store.value == formHeader.request_on_store.value) {
		parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("REQ_ON_REQ_BY_CANNOT_BE_SAME", "ST");
		formHeader.request_by_store.focus();
		return;
	}
	var store_code = formHeader.request_by_store.value;
	var to_store_code = formHeader.request_on_store.value;
	var item_code = formObject.item_code.value;
	var bean_id = "requestBean";
	var bean_name = "eST.RequestBean";
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&item_code=" + item_code + "&store_code=" + store_code + "&function_type=6" + "&store_code_to=" + to_store_code, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;	
	//alert("responseText=======952===>>>" +responseText);
	eval(responseText);
	//alert("check_box_status" +formObject.check_box_status.value);
	if (!result) {
		err = "err";
		formObject.check_box_status.value = "";
	}
	//alert("check_box_status==========>>>" +formObject.check_box_status.value);
	/*if(!result) {
		parent.parent.messageFrame.location.href = errorPage+"?err_num="+getMessage("NOT_STOCK_ITEM","ST");
		return;
	}*/
	/* PE Comment
	xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&item_code=" + item_code + "&store_code=" + to_store_code + "&function_type=7" + "", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;		   
	eval(responseText);
	if (!result) {
		err = "err";
		formObject.check_box_status.value = "";
	}
	/*if(!result) {
		parent.parent.messageFrame.location.href = errorPage+"?err_num="+getMessage(message,"ST");
		return;
	}*/
	/*xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&item_code=" + item_code + "&store_code=" + store_code + "&function_type=6" + "&store_code_to=" + to_store_code, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;		   
	eval(responseText);
	if (!result) {
		err = "err";
		formObject.check_box_status.value = "";
	}*/
	/*if(!result) {
		parent.parent.messageFrame.location.href = errorPage+"?err_num="+getMessage("NOT_STOCK_ITEM","ST");
		return;
	}*/
	formObject.request_by_store.value = formHeader.request_by_store.value;
	formObject.request_on_store.value = formHeader.request_on_store.value;
	formObject.mode.value = formHeader.mode.value;
	var stock_item_yn = "N";
	if (formObject.stock_item_yn.checked) {
		stock_item_yn = "Y";
	}
	formObject.stock_item_yn.value = stock_item_yn;
	assignBean(formObject);
	xmlStr = getEnhancedXMLString(formObject);
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	if ((formObject.mode.value == MODE_INSERT) || ((formObject.mode.value == MODE_MODIFY) && (formObject.editing.value == 2))) {
		function_type = 18;
	} else {
		if ((formObject.mode.value == MODE_MODIFY) && (formObject.editing.value == 1)) {
			function_type = 5;
		}
	}
	xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=" + function_type, false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
	if (!result) {
		parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
		return;
	}
	parent.parent.messageFrame.location.href = errorPage;
	//parent.RequestListFrame.document.location.reload();
	/*index = formObject.srl_no.value;
	if (index != -1) {
		index = index - 1;
	}*/
	
	if(formObject.index.value==""){
		formObject.index.value=formObject.item_code.value;
	}
	//Commented by Rabbani #Inc no:39550(AAKH-SCF-0050) on 06-JUN-2013
	//parent.RequestListFrame.document.location.href = "RequestList.jsp?index=" +  formObject.index.value + "&err=" + err + "&kit12=kit";
	formObject.add.value = getLabel("Common.Add.label", "Common");
	formHeader.request_by_store.disabled = true;
	formHeader.request_on_store.disabled = true;
	formHeader.item_class_code.disabled = true;
	formObject.item_desc.readOnly = false;
	parent.RequestHeaderFrame.formRequestHeader.request_type.disabled = true;
	if (formObject.editing.value == "1") {
		formObject.item_desc.readOnly = false;
		formObject.add.disabled = true;
		document.getElementById('uom_label').innerHTML = "&nbsp;";
		document.getElementById('Qty_onhand_label').innerHTML = "&nbsp;";
		document.getElementById('max_stk_qty_label').innerHTML = "&nbsp;";
		formObject.reset();
	} else {
		document.location.href = "../../eST/jsp/RequestDetail.jsp?mode=" + MODE_INSERT + "&function_id=" + parent.parent.function_id;
	}
	kitNextItemValidate();//Added by Rabbani #Inc no:39550(AAKH-SCF-0050) on 06-JUN-2013
}
function statusOfItem() {
	var bean_id = "requestBean";
	var bean_name = "eST.RequestBean";
	var formHeader = parent.RequestHeaderFrame.document.formRequestHeader;
	var store_code = formHeader.request_by_store.value;
	var to_store_code = formHeader.request_on_store.value;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?function_type=19&store_code=" + store_code + "&to_store_code=" + to_store_code + "&bean_id=" + bean_id + "&bean_name=" + bean_name, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
function displayMessage(errorList) {
	var item_store = "";
	var phy_inv = "";
	var non_stock = "";
	var no_stock = "";
	errorList = errorList.substring(1, errorList.length - 1);
	errorList = errorList.split(",");
	for (var i = 0; i < errorList.length; i++) {
		if (trimString(errorList[i]) == "REQ_ON_ITEM_STORE_NOT_FOUND") {
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
				} else {
					if (trimString(errorList[i]) == "STOCK_NOT_AVAILABLE") {
						if (no_stock == "") {
							no_stock = no_stock + " " + trimString(errorList[i + 1]);
						} else {
							no_stock = no_stock + "," + trimString(errorList[i + 1]);
						}
					}
				}
			}
		}
	}
	var err_text = "";
	if (item_store != "") {
		err_text = err_text + getMessage("REQ_ON_ITEM_STORE_NOT_FOUND", "ST") + " for " + item_store + "\n";
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
	if (err_text != "") {
		alert(err_text);
	}
}
function dispMess(id) {
	alert(getMessage("PHY_INV_PROCESS_INITIATED", "ST") + "\n" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + id);
}

function changeOrder(order) {
	var bean_id = "requestBean";
	var bean_name = "eST.RequestBean";
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?function_type=21&bean_id=" + bean_id + "&bean_name=" + bean_name+"&order="+order, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	if (result) {
		parent.RequestListFrame.document.location.href = "RequestList.jsp?";
		parent.RequestDetailFrame.document.location.href = "../../eST/jsp/RequestDetail.jsp?mode=" + MODE_INSERT + "&function_id=" + parent.parent.function_id;
	}
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
	* @Name - Priya
	* @Date - 21/12/2009
	* @Inc# - IN017084
	* @Desc - To avoid the duplication records display in Modify mode
	*/
function clearMessageFrame(){
var errorPage = "../../eCommon/jsp/error.jsp";
parent.messageFrame.location.href = errorPage + "?err_num=";
}




/*function isValidNumberNew(fld, e, maxInt, deci) {
	var disp_allowed_yn = "Y";
	if(document.forms[0].dec_allowed_yn.value!=undefined){
		disp_allowed_yn = document.forms[0].dec_allowed_yn.value;
	}
	//alert(document.forms[0].dec_allowed_yn.value);
	if(disp_allowed_yn=="N"){
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
}*/


function CheckQuantity(obj) {
	if(document.formRequestDetail.dec_allowed_yn.value=="Y"){
		if (!checkDoubleFormat(obj,false)) {
			return false;
		}
	}else{
		if (!checkIntegerFormat(obj,false)) {
			return false;
		}
	}
}



function setUOMConvFactor1(_value,_rulestring) {
	//commented by Sakti sankar  against RUT-SCF-0248
	//document.getElementById("id_pur_uom_conv").innerHTML = _rulestring;
	//document.formRequestDetail.conv_fact.value = _value;
	//document.formRequestDetail.uom_conv_text.value = _rulestring;
//Added by Sakti sankar against RUT-SCF-0248 for displaying special characters
	document.getElementById('id_pur_uom_conv').innerHTML = decodeURIComponent(_rulestring,"UTF-8");
	document.formRequestDetail.conv_fact.value = decodeURIComponent(_value,"UTF-8");
	document.formRequestDetail.uom_conv_text.value = decodeURIComponent(_rulestring,"UTF-8");
	
}

function setMultiples(from,to,batch,issue) {
	if (document.formRequestDetail == null) {
		parent.frames[2].frames[0].document.formRequestDetail.from_multiples.value = from;
		parent.frames[2].frames[0].document.formRequestDetail.to_multiples.value = to;
		parent.frames[2].frames[0].document.formRequestDetail.batch_multiples.value = batch;
		parent.frames[2].frames[0].document.formRequestDetail.issue_uom_multiples.value = issue;
	} else {
		document.formRequestDetail.from_multiples.value = from;
		document.formRequestDetail.to_multiples.value = to;
		document.formRequestDetail.batch_multiples.value = batch;
		document.formRequestDetail.issue_uom_multiples.value = issue;
	}
}
function calculateConversion(){
	var store_code = parent.RequestHeaderFrame.document.formRequestHeader.request_by_store.value;
	var to_store_code = parent.RequestHeaderFrame.document.formRequestHeader.request_on_store.value;
	var item_code = document.formRequestDetail.item_code.value;// added for ML-MMOH-SCF-0979
	//alert("item_code: "+item_code);
	if (document.formRequestDetail.dec_allowed_yn.value == "N") {
		var bean_id = "requestBean";
		var bean_name = "eST.RequestBean";
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?item_code=" + document.formRequestDetail.item_code.value + "&fm_store_code=" + store_code + "&to_store_code=" + to_store_code+"&issue_uom_code="+document.formRequestDetail.pur_uom_code.value + "&function_type=24&bean_id=" + bean_id + "&bean_name=" + bean_name, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		//alert(responseText);
		eval(responseText);
	}
}
//Added by Rabbani INC NO:34758(RUT-CRF-0082) on 07/02/2013 Starts
async function showRemarks() {
	var rem = "";
	rem = await window.showModalDialog("../../eST/jsp/RequestRemarks.jsp?function_id=" + parent.parent.function_id, "", "dialogHeight:30vh; dialogWidth:40vw; center:0; status: no; dialogLeft :75; dialogTop :250;");
	while(rem == undefined){
		alert('Please Press Close Button'); 
		rem = await window.showModalDialog("../../eST/jsp/RequestRemarks.jsp?function_id=" + parent.parent.function_id, "", "dialogHeight:30vh; dialogWidth:40vw; center:0; status: no; dialogLeft :75; dialogTop :250;");
		}
	if (rem != null) {
		document.formRequestHeader.remarks.value = rem;
	}
}
async function searchRemarksHeader(objCode, objDesc) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.forms[0].lang_id_1.value;
	dataTypeArray[0] = STRING;
	dataNameArray[1] = "module_id";
	dataValueArray[1] = "ST";
	dataTypeArray[1] = STRING;
	dataNameArray[2] = "trn_type";
	if (document.forms[0].bean_trans_type.value == "") {
		dataValueArray[2] = "REQ";
	} else {
		dataValueArray[2] = document.forms[0].bean_trans_type.value;
	}
	dataTypeArray[2] = STRING;
	argumentArray[0] = document.forms[0].SQL_ST_TRN_REMARKS_LOOKUP_SELECT.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "4,5";
	argumentArray[5] = "";
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.remarks.label", "Common"), argumentArray);
	/*
	 * Code commented by Sethu on 10/07/2024
	 */
	/*
	if ((returnedValues != null) && (returnedValues != "")) {
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
	}
	*/
	/*
	 * Code added by Sethu on 10/07/2024
	 */
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
}
function updateRemarks() {
	formObject = document.formRequestRemarks;
	if (!setTextAreaMaxLength(formObject.hdr_remarks_desc, 201)) {
		alert(getMessage("REMARKS_NOT_EXCEED_200_CH", "Common"));
		return;
	}
	 
	if(formObject.hdr_remarks_rd.value == "Y"){
	if (!checkField(formObject.hdr_remarks_desc, getLabel("Common.remarks.label", "Common"))) {
		return;
	}
	}
	/*if (formObject.remarks.value == "") {
		alert(getMessage("SHOULD_NOT_BE_BLANK","Common"));
		return;
	}*/
	    var bean_id = "requestBean";
		var bean_name = "eST.RequestBean";
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(formObject)); //Comented by Sakti sankar against inc#37941 on 08/03/2013
		//xmlDoc.loadXML(getEnhancedXMLString(formObject)); //Added by Sakti sankar against inc#37941 on 08/03/2013 to accept special characters
		xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObject), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/RequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name  + "&function_type=26" , false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
	   window.returnValue = formObject.hdr_remarks_desc.value;
	   window.close();
}
//ends
//Added by Rabbani #Inc no:39550(AAKH-SCF-0050) on 06-JUN-2013
function statusOfList(){
var formObject = document.formRequestDetail;
var err = "";
	parent.RequestListFrame.document.location.href = "RequestList.jsp?index=" +formObject.index.value + "&err=" + err + "&kit12=kit";
}

//Added by sakti against ML-BRU-SCF-0963[INC#42099]	
function Setitemdesc(obj){
	document.formRequestDetail.item_desc.value = decodeURIComponent(obj.value,"UTF-8");
} 


//added for ML-MMOH-SCF-0979 START
function setUOMConvFactor2(uom_convfactor) {
	
	uom_conv_new = uom_convfactor;
	
}
//added for ML-MMOH-SCF-0979 END
//Added for IN:071343 start
function calRequestQty1() {
	var formObj = document.formRequestDetail;
	var dec_allowed_yn = document.formRequestDetail.dec_allowed_yn.value;
	var no_of_decimals = document.formRequestDetail.no_of_decimals.value;
	var uom_convFactor = uom_conv_new;//ADDED FOR ML-MMOH-SCF-0979
	formObj.required_qty.value = "";
	var confact=parseFloat(document.formRequestDetail.conv_fact.value);//ADDED FOR ML-MMOH-SCF-0979
	calculateConversion();//added for ML-MMOH-CRF-1200
	if (formObj.req_uom_qty.value == "") {
	} else {
		if(dec_allowed_yn=="Y"){
			formObj.required_qty.value =(parseFloat(document.formRequestDetail.conv_fact.value) * parseFloat(formObj.req_uom_qty.value)).toFixed(no_of_decimals);
			toConvFactor();
		}else{
			if(formObj.req_uom_qty.value%formObj.issue_uom_multiples.value !=0){
					alert("Req UOM Qty Should Be In Multiples Of "+formObj.issue_uom_multiples.value);
					formObj.required_qty.value = "";
					//formObj.req_uom_qty.focus();
					return false;
			}else{
						//added for ML-MMOH-SCF-1013						
						formObj.required_qty.value = (formObj.req_uom_qty.value * formObj.batch_multiples.value)/formObj.issue_uom_multiples.value ;//added for ML-MMOH-CRF-1200	
						//var required_qty=""+formObj.required_qty.value;
			}
		}
		
		
		
		var max_qty = parseInt(formObj.max_stk_qty.value) * parseInt(formObj.batch_multiples.value);//Added for MMS-MD-SCF-0277
		var qty_on_hand = parseInt(formObj.qty_on_hand.value) * parseInt(formObj.batch_multiples.value);//Added for MMS-MD-SCF-0277
		//replaced formObj.max_stk_qty.value with max_qty and formObj.qty_on_hand.value with qty_on_hand in below condition for MMS-MD0SCF-0227
		//alert("required_qty=="+formObj.required_qty.value+"qty_on_hand=="+qty_on_hand+"max_qty=="+max_qty+"batch_multiples=="+formObj.batch_multiples.value);
		if (formObj.max_stk_qty.value != null) {              // ========== Start of Min Max Validation by Rammohan.C === 
		if (parseInt(formObj.required_qty.value) + parseInt(qty_on_hand) > parseInt(max_qty)) {
			//var required_qty=formObj.required_qty.value;
			var exc_qty=""+((parseInt(formObj.required_qty.value) + parseInt(qty_on_hand) - parseInt(max_qty)));
			alert( getMessage("EXCEED_MAX_STOCK", "ST")  +" "+ exc_qty +" Qty" );
			formObj.req_uom_qty.select();
			formObj.req_uom_qty.focus();
			return false;
		} //exceed max Stock Level
		}
	}
	return true;
}
//Added for IN:071343 end
//Adding start for MO-CRF-20166
async function viewIssueHistory(){

	var request_on_store =parent.RequestHeaderFrame.formRequestHeader.request_on_store.value;
	var request_by_store =parent.RequestHeaderFrame.formRequestHeader.request_by_store.value;
	var item_code = document.formRequestDetail.item_code.value;
	var called_from ="REQ";
	var title ="";
	var dialogHeight= "90vh" ;
var dialogWidth	= "100vw" ;
var dialogTop	= "150" ;
var dialogLeft	= "60" ;
var center		= "1" ;
var status		= "no";
var scroll		= "yes";
var features	= "dialogLeft:" + dialogLeft + ";dialogHeight:"+dialogHeight+"; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop+";dialogTitle:"+title;
var arguments	= "" ;
 await window.showModalDialog("../../eST/jsp/IssueHistoryFrame.jsp?item_code="+item_code+"&request_by_store="+request_by_store+"&request_on_store="+request_on_store+"&called_from="+called_from,arguments,features);
}

async function displayAuditInfo(trObj) {
	var formObj = document.formIssueHistoryResult;
	var added_by_id				=	trObj.cells[15].innerText;
	var modified_by_id			=	trObj.cells[16].innerText;
	var modified_date			=	trObj.cells[17].innerText;
	var request_status			=	trObj.cells[12].innerText;
	var doc_no					=	trObj.cells[2].innerText;
	var doc_type_desc			=	trObj.cells[0].innerText;
	var doc_type_code			=	trObj.cells[14].innerText;
	
	var sch_code				=	"";
	var called_from             = "ISS_HISTORY";
	

	if(sch_code!=""){
		added_by_id=getLabel("eST.AutoRequest.label", "ST");
		req_authorized_by_id=getLabel("eST.AutoRequest.label", "ST");
	}	
	changeColor(trObj, 14);
	retVal						=	await window.showModalDialog("../../eST/jsp/RequestStatusAuditInfo.jsp?function_id=" + parent.parent.function_id + "&added_by_id=" + added_by_id + "&doc_type_code=" + doc_type_code + "&modified_by_id=" + modified_by_id + "&modified_date=" + modified_date+"&called_from="+called_from + "&request_status=" + request_status + "&doc_no=" + doc_no + "&doc_type_desc=" + doc_type_desc, "", "dialogHeight:13vh; dialogWidth:25vw; center:1; status: no; dialogLeft :475; dialogTop :250;scroll:no");
	retainColor(trObj, 14);
}

function changeColor(obj, n) {
	prevColor = obj.cells[0].className;
	for (k = 0; k < n; k++) {
		obj.cells[k].className = "STLIGHTPINK";
	}
}
function retainColor(obj, n) {
	for (k = 0; k < n; k++) {
		obj.cells[k].className = prevColor;
	}
}

/*function SubmitLink(from,to,item_code,store,locale,called_from){
	var obj						=	document.formIssueHistoryResult;
	obj.from.value				=	from;
	obj.to.value				=	to;
	obj.item_code.value		=	item_code;
	obj.store_code.value			=	store;
	obj.locale.value			=	locale;
	obj.called_from.value			=	called_from;
	obj.submit();
}*/


//Adding end for MO-CRF-20166
