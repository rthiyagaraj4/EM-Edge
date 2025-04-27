
async function ModifyDocDetails(issue_flag, bean_id, bean_name, mode, from_store_legend, to_store_legend, fromstorecode, doctypecode, documentdate) {
	store_code_disabled = document.forms[0].store_code_disabled.value;
	function_id = document.forms[0].function_id.value;
	item_class_code = document.forms[0].item_class_code.value;
	item_class_desc = document.forms[0].item_class_desc.value;
	if (document.forms[0].store_code_disabled.value == "disabled") {
		document.forms[0].store_code_disabled.value;
	}
	//Added by Rabbani#AMS-CRF-0068(49822) on 12-AUG-2014  Starts
     var sales_req_yn = document.forms[0].sales_req_fm_store.value;
     //var to_store_code = document.forms[0].to_store_code.value;
	 
	var tit = "TITLE";
	//Added by Rabbani#AMS-CRF-0068(49822) on 12-AUG-2014  Starts
	var retVal = await window.showModalDialog("../../eST/jsp/GeneralDuoHeaderModify.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&issue_flag=" + issue_flag + "&from_store_legend=" + from_store_legend + "&to_store_legend=" + to_store_legend + "&fromstorecode=" + fromstorecode + "&doctypecode=" + doctypecode + "&documentdate=" + documentdate + "&store_code_disabled=" + store_code_disabled + "&function_id=" + function_id + "&mode=" + mode+ "&sales_req_yn=" + sales_req_yn, "", "dialogHeight:50vh; dialogWidth: 65vw; center: 1; status: no; dialogTop :100;scroll:no");
//	var retVal = window.showModalDialog("../../eST/jsp/GeneralDuoHeaderModify.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&issue_flag=" + issue_flag + "&from_store_legend=" + from_store_legend + "&to_store_legend=" + to_store_legend + "&fromstorecode=" + fromstorecode + "&doctypecode=" + doctypecode + "&documentdate=" + documentdate + "&store_code_disabled=" + store_code_disabled + "&function_id=" + function_id + "&mode=" + mode+ "&sales_req_yn=" + sales_req_yn+ "&to_store_code=" + to_store_code+ "&doc_no=" + document.forms[0].doc_no.value+ "&doc_type_code=" + document.forms[0].doc_type_code.value+ "&doc_date=" + document.forms[0].doc_date.value+ "&trn_type=" + document.forms[0].trn_type.value, "", "dialogHeight:10; dialogWidth: 63; center: 1; status: no; dialogTop :100;scroll:no");

	if (retVal) {
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/StDuoHeaderValidate.jsp?validate=UPDATE_DETAILS", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
	}
}
function close_modal() {
	//window.close();
    const dialogTag = parent.document.getElementById("dialog_tag");    
    dialogTag.close();
}
function assignBean(frmObject) {
	bean_id = frmObject.bean_id.value;
	bean_name = frmObject.bean_name.value;
	//xmlDom = new ActiveXObject("Microsoft.XMLDom");
	//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	xmlDom = "";
	xmlHttp = new XMLHttpRequest();
}
function loadItemClasses(request_on_store, request_by_store) {
	if (request_by_store.value == "" || request_on_store.value == "") {
		clearListItems("document.formStGeneralHeaderForMultiStore.item_class_code");
		return;
	}
	var arrayObject = new Array();
	arrayObject[0] = request_by_store;
	arrayObject[1] = request_on_store;
	var bean_id = "stDuoHeaderBean";
	var bean_name = "eST.Common.StDuoHeaderBean";
	//var xmlDom = new ActiveXObject("Microsoft.XMLDom");
	var xmlDom = "";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr = getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/StDuoHeaderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=RELOAD_ITEM_CLASSES", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
function saveAndExit() {
	var formObj = document.formStGeneralHeaderForMultiStore;
	var fields = new Array(formObj.doc_type_code);
	var names = new Array(getLabel("Common.DocType.label", "Common"));
	var index = 1;
	if (!formObj.doc_no.disabled) {
		fields[index] = formObj.doc_no;
		names[index++] = getLabel("Common.DocNo.label", "Common");
	}
	fields[index] = formObj.doc_date;
	names[index++] = getLabel("Common.DocDate.label", "Common");
	fields[index] = formObj.from_store_code;
	names[index++] = getLabel("Common.FromStore.label", "Common");
	fields[index] = formObj.to_store_code;
	if(formObj.function_id.value=="ST_PO_REQUEST_FN"){
		names[index++] = getLabel("eST.ToDepartment.label", "ST");
	}else{
	names[index++] = getLabel("Common.ToStore.label", "Common");
	}
	if (formObj.item_classDisable.value == "Y") {
		fields[index] = formObj.item_class_code;
		names[index++] = getLabel("Common.ItemClass.label", "Common");
	}
	var obj = null;
	var errors = "";
	for (var i = 0; i < fields.length; i++) {
		if (trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		} else {
			if (obj == null) {
				obj = fields[i];
			}
			errors = errors + "APP-000001 " + names[i] +" "+ getLabel("Common.Cannotbeblank.label", "Common");
			alert(errors);
			if(obj.disabled==false){
				obj.focus();
			}
			return;
		}
	}
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	
	//xmlDoc.loadXML(getEnhancedXMLString(formObj));
	
	xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObj), "text/xml");
	
	xmlHttp.open("POST", "../../eST/jsp/StDuoHeaderValidate.jsp?validate=SET_DETAILS&doc_type_code=" + formObj.doc_type_code.value + "&doc_ref=" + formObj.doc_ref.value + "&doc_no=" + formObj.doc_no.value + "&doc_ref=" + formObj.doc_ref.value + "&doc_date=" + formObj.doc_date.value + "&from_store_code=" + formObj.from_store_code.value + "&to_store_code=" + formObj.to_store_code.value + "&item_class_code=" + formObj.item_class_code.value + "&finalize_yn=" + formObj.finalize_yn.value + "&autono_yn=" + formObj.autono_yn.value + "&mode=" + formObj.mode.value, false);
	xmlHttp.send(xmlDoc);
	
	responseText = xmlHttp.responseText;
	
	eval(responseText);
	
	//window.returnValue = result;
	//let dialogBody = parent.parent.document.getElementById('dialog-body');

    
	if (result) {
		//window.close();
	    //const dialogTag = parent.parent.document.getElementById("dialog_tag");  
		var dialogBody = parent.document.getElementById('dialog-body');
		dialogBody.contentWindow.returnValue = result;
		const dialogTag = parent.document.getElementById("dialog_tag");		
	    dialogTag.close();
	} else {
		alert(getMessage(message, "ST"));
	}
}
function setDocumentDetails(_doc_type_desc, _doc_no, _from_store_desc, _to_store_desc, _item_class, _doc_date, _doc_ref, _to_store_code, _from_store_code, _item_class_code, _finalize_yn, _autono_yn, _item_class_desc,doc_type_code) {

	document.getElementById("item_class_legend").innerHTML = "<b>" + _item_class + "</b>";
	document.getElementById("doc_type_desc").innerHTML = "<b>" + _doc_type_desc + "</b>";
	document.getElementById("doc_no").innerHTML = "<b>" + _doc_no + "</b>";
	document.getElementById("td_from_store_code").innerHTML = "<b>" + _from_store_desc + "</b>";
	document.getElementById("td_to_store_code").innerHTML = "<b>" + _to_store_desc + "</b>";	
	//document.getElementById("item_class").innerHTML				=		"<b>"+_item_class+"</b>";
	document.getElementById("td_doc_date").innerHTML = "<b>" + _doc_date + "</b>";
	document.getElementById("doc_ref_id").innerHTML = "<b>" + _doc_ref + "</b>";
	document.getElementById("to_store_code").value = _to_store_code;
	document.getElementById("td_to_store_code").value = _to_store_code;
	document.getElementById("from_store_code").value = _from_store_code;
	document.getElementById("td_from_store_code").value = _from_store_code;
	document.getElementById("item_class_code").value = _item_class_code;
	//document.getElementById("item_class").value					=		_item_class_code;
	document.getElementById("item_class_desc").value = _item_class;
	document.getElementById("doc_ref").value = _doc_ref;
	document.getElementById("doc_date").value = _doc_date;
	document.forms[0].doc_no.value = _doc_no;
	document.getElementById("finalize_yn").value = _finalize_yn;
	document.getElementById("autono_yn").value = _autono_yn;
	document.getElementById("doc_type_code").value = doc_type_code;
}
function checkDoc_type_code() {
	if (document.formStGeneralHeaderForMultiStore.doc_type_code.value == "") {
		return;
	}
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/StHeaderValidate.jsp?validate=DOC_TYPE_CODE&doc_type_code=" + document.formStGeneralHeaderForMultiStore.doc_type_code.value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
function enableDocNo(bValue) {
	if (!bValue) {
		document.formStGeneralHeaderForMultiStore.doc_no.value = "";
		document.formStGeneralHeaderForMultiStore.autono_yn.value = "Yes";
	} else {
		document.formStGeneralHeaderForMultiStore.autono_yn.value = "No";
	}
	document.formStGeneralHeaderForMultiStore.doc_no.disabled = !bValue;
}
function ValidateDate(obj, sys_date) {
	if (CheckDate(obj)) {
		if (!checkDateWithSysDate(obj, sys_date)) {
			alert(getMessage("ST_DOC_DT_NOT_GR_SYSDATE", "ST"));
			obj.select();
			obj.focus();
		}
	}
}
function focusElement() {
	if (document.formStGeneralHeaderForMultiStore.to_store_code.disabled == false) {
		document.formStGeneralHeaderForMultiStore.to_store_code.focus();
	} else {
		document.formStGeneralHeaderForMultiStore.doc_ref.focus();
	}
}
function setParentStoreCode(store_code) {
	document.formStGeneralHeaderForMultiStore.to_store_code.value = store_code;
	var to_store_code = document.formStGeneralHeaderForMultiStore.to_store_code.value;
	var arrayObject = new Array();
	arrayObject[0] = to_store_code;
	var bean_id = "stDuoHeaderBean";
	var bean_name = "eST.Common.StDuoHeaderBean";
	//var xmlDom = new ActiveXObject("Microsoft.XMLDom");
	var xmlDom = "";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr = getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/StDuoHeaderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=SET_TO_STORE_CODE", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
function loadParentStore(issue_flag, store_code) {
	if (store_code != null) {
		document.forms[0].from_store_code.value = store_code.value;
		
		if (issue_flag == "") {
			var arrayObject = new Array();
			arrayObject[0] = store_code;
			var bean_id = "stDuoHeaderBean";
			var bean_name = "eST.Common.StDuoHeaderBean";
			//var xmlDom = new ActiveXObject("Microsoft.XMLDom");
			var xmlDom = "";
			var xmlHttp = new XMLHttpRequest();
			var xmlStr = getXMLString(arrayObject);
			//xmlDom.loadXML(xmlStr);
			xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/StDuoHeaderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=LOAD_PARENT_STORE", false);
			xmlHttp.send(xmlDom);
			responseText = xmlHttp.responseText;
			eval(responseText);
			
		} else {
			var arrayObject = new Array();
			arrayObject[0] = store_code;
			arrayObject[1] = issue_flag;
			var bean_id = "stDuoHeaderBean";
			var bean_name = "eST.Common.StDuoHeaderBean";
			//var xmlDom = new ActiveXObject("Microsoft.XMLDom");
			var xmlDom = "";
			var xmlHttp = new XMLHttpRequest();
			var xmlStr = getXMLString(arrayObject);
			//xmlDom.loadXML(xmlStr);
			xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/StDuoHeaderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=LOAD_PARENT_STORE_ISSUE", false);
			xmlHttp.send(xmlDom);
			responseText = xmlHttp.responseText;
			eval(responseText);
		}
	}
}
function setToStore(obj) {

	//document.formStGeneralHeaderForMultiStore.to_store_code.value = obj[obj.selectedIndex].value;
	document.formStGeneralHeaderForMultiStore.to_store_code.value = obj[obj.selectedIndex].value;
}
function setItemDesc(obj) {
	var item_class_desc = obj[obj.selectedIndex].text;
	var item_class_code = obj.value;
	document.formStGeneralHeaderForMultiStore.item_class_code.value = item_class_code;
	var arrayObject = new Array();
	var bean_id = "stDuoHeaderBean";
	var bean_name = "eST.Common.StDuoHeaderBean";
	//var xmlDom = new ActiveXObject("Microsoft.XMLDom");
	var xmlDom = "";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr = getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/StDuoHeaderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=ITEM_CLASS" + "&item_class_desc=" + item_class_desc + "&item_class_code=" + item_class_code, false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
function errorDisplay() {
	alert(getMessage("FROM_STORE_NOT_DEFINED", "ST"));
	//document.formStGeneralHeaderForMultiStore.from_store_code.disabled==false) {
	document.formStGeneralHeaderForMultiStore.from_store_code.focus();
}
function setItemDesc(obj) {
	var item_class_desc = obj[obj.selectedIndex].text;
	var item_class_code = obj.value;
	document.formStGeneralHeaderForMultiStore.item_class_code.value = item_class_code;
	//if ((obj[obj.selectedIndex].text != ("---Select---")) && (obj.selectedIndex != 0)) {
		if (obj.value=="") {
			obj[obj.selectedIndex].text = "--- "+getLabel("Common.defaultSelect.label", "Common")+" ---";
			item_class_desc = "";
		}
		var arrayObject = new Array();
		var bean_id = "stDuoHeaderBean";
		var bean_name = "eST.Common.StDuoHeaderBean";
		//var xmlDom = new ActiveXObject("Microsoft.XMLDom");
		var xmlDom = "";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr = getXMLString(arrayObject);
		//xmlStr = getXMLString(arrayObject);
		//xmlDom.loadXML(xmlStr);
		xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/StDuoHeaderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=ITEM_CLASS" + "&item_class_desc=" + item_class_desc + "&item_class_code=" + item_class_code, false);
		xmlHttp.send(xmlDom);
		responseText = xmlHttp.responseText;
		eval(responseText);
	/*} else {
		return "";
	}*/
}
function setItem_class(item_class_code) {
	document.formStGeneralHeaderForMultiStore.item_class_code.value = item_class_code;
	var obj = document.formStGeneralHeaderForMultiStore.item_class_code;
}

