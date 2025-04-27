
async function ModifyDocDetails(store_code_disabled) {
	var formObj = document.forms[0];
	var bean_id = "stHeaderBean";
	var bean_name = "eST.Common.StHeaderBean";
	if (store_code_disabled == null) {
		store_code_disabled = "";
	}
	var tit = "TITLE";
	var retVal = await window.showModalDialog("../../eST/jsp/GeneralHeaderModify.jsp?store_code_disabled=" + store_code_disabled + "&param1=" + formObj.param1.value + "&bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value, "", "dialogHeight:50vh; dialogWidth: 65vw; center: 1; status: no; dialogTop :100;");
	//var retVal	=	window.open("../../eST/jsp/GeneralHeaderModify.jsp",'','dialogHeight:10; dialogWidth: 40; center: 1; status: no; dialogTop :100;');
	if (retVal) {//to update the header display..
		var xmlHttp = new XMLHttpRequest();
	/*	var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null)); */
		var xmlString = getXMLString(null);
        var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
		if (formObj.bean_id != null) {
			bean_id = formObj.bean_id.value;
		}
		if (formObj.bean_name != null) {
			bean_name = formObj.bean_name.value;
		}
		xmlHttp.open("POST", "../../eST/jsp/StHeaderValidate.jsp?validate=UPDATE_DETAILS&bean_id=" + bean_id + "&bean_name=" + bean_name, false);
		xmlHttp.send(xmlDoc);
		var responseText = xmlHttp.responseText;
		eval(responseText);
	} else {
		var xmlHttp = new XMLHttpRequest();
		/*var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null)); */
		var xmlString = getXMLString(null);
        var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
		if (formObj.bean_id != null) {
			bean_id = formObj.bean_id.value;
		}
		if (formObj.bean_name != null) {
			bean_name = formObj.bean_name.value;
		}
		var item_class_desc = "";
		var item_class_code = null;
		xmlHttp.open("POST", "../../eST/jsp/StHeaderValidate.jsp?validate=UPDATE_DETAILS&bean_id=" + bean_id + "&bean_name=" + bean_name + "&item_class_desc=" + item_class_desc + "&item_class_code=" + item_class_code, false);
		xmlHttp.send(xmlDoc);
		var responseText = xmlHttp.responseText;
		eval(responseText);
	}
//	window.open("../../eST/jsp/GeneralHeaderModify.jsp",'','dialogHeight:13; dialogWidth: 32; center: 1; status: no; dialogTop :150;');

		if(formObj.function_id != undefined && formObj.function_id.value=="ST_SALES" &&  formObj.module_id.value == "ST"){
		if(parent.frameSalesHeader.document.formSalesHeader.sal_trn_type.value == null || parent.frameSalesHeader.document.formSalesHeader.sal_trn_type.value == ""){
		parent.frameSalesHeader.document.formSalesHeader.sal_trn_type.focus();
		}else{
		checkSaleTRNType(parent.frameSalesHeader.document.formSalesHeader.sal_trn_type);	
		parent.frameSalesHeader.document.formSalesHeader.store_code_disabled.value = "disabled";
		if(parent.frameSalesHeader.document.formSalesHeader.patient_id.disabled == false)		
		parent.frameSalesHeader.document.formSalesHeader.patient_id.focus();
		}
		}
	   else if(formObj.function_id != undefined && formObj.function_id.value=="ST_SALES_RETURN" && formObj.module_id.value == "ST"){
	   	if(parent.frameSalesReturnHeader.document.formSalesReturnHeader.sal_trn_type.value == null || parent.frameSalesReturnHeader.document.formSalesReturnHeader.sal_trn_type.value  == ""){
		parent.frameSalesReturnHeader.document.formSalesReturnHeader.sal_trn_type.focus();
		}else{
		checkSaleRetTRNType(parent.frameSalesReturnHeader.document.formSalesReturnHeader.sal_trn_type);
		parent.frameSalesReturnHeader.document.formSalesReturnHeader.store_code_disabled.value = "disabled";
		if(parent.frameSalesReturnHeader.document.formSalesReturnHeader.patient_id.disabled == false)	
		parent.frameSalesReturnHeader.document.formSalesReturnHeader.patient_id.focus();
		}
		}
		if(formObj.function_id != undefined && formObj.function_id.value=="ST_STOCK_CONS"){//Adding start for TH-KW-CRF-0043
			loadDetailPage();
		}//Adding end for TH-KW-CRF-0043
		//parent.document.getElementById('dialog_tag').close();
		const dialogTag = parent.document.getElementById("dialog_tag");		
	    if(dialogTag)
		{
			dialogTag.close();
		}
}
function close_modal() {
	//window.close();
	const dialogTag = parent.parent.document.getElementById('dialog_tag');    
	dialogTag.close();
}



function saveAndExit() {
	var formObj = document.forms[0];
	var bean_id = "stHeaderBean";
	var bean_name = "eST.Common.StHeaderBean";
	var fields = new Array(formObj.doc_type_code);
	var names = new Array(getLabel("Common.DocType.label", "Common"));
	var index = 1;
	if (!formObj.doc_no.disabled) {
		fields[index] = formObj.doc_no;
		names[index++] = getLabel("Common.DocNo.label", "Common");
	}
	fields[index] = formObj.doc_date;
	names[index++] = getLabel("Common.DocDate.label", "Common");
	fields[index] = formObj.store_code;
	names[index++] = getLabel("Common.Store.label", "Common");
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
			errors = errors + "APP-000001 " + names[i] + getLabel("Common.Cannotbeblank.label", "Common");
			alert(errors);
			if (formObj.mode.value == "1") {
				obj.focus();
			} else {
				formObj.doc_date.focus();
			}
			return;
		}
	}
	if (formObj.bean_id != null) {
		bean_id = formObj.bean_id.value;
	}
	if (formObj.bean_name != null) {
		bean_name = formObj.bean_name.value;
	}
	var xmlHttp = new XMLHttpRequest();
	
	//var xmlDoc = new ActiveXObject("Microsoft.XMLDom");
	var xmlDoc="";
	//xmlDoc.loadXML(getEnhancedXMLString(formObj));
	var xmlStr = getEnhancedXMLString(formObj);
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/StHeaderValidate.jsp?validate=SET_DETAILS&doc_type_code=" + escape(formObj.doc_type_code.value) + "&doc_no=" + escape(formObj.doc_no.value) + "&doc_ref=" + escape(formObj.doc_ref.value) + "&doc_date=" + escape(formObj.doc_date.value) + "&store_code=" + escape(formObj.store_code.value) + "&bean_id=" + escape(formObj.bean_id.value) + "&bean_name=" + escape(formObj.bean_name.value) + "&item_class_code=" + escape(formObj.item_class_code.value), false);
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	eval(responseText);
	if (result) {
		var dialogBody = parent.document.getElementById('dialog-body');
	    dialogBody.contentWindow.returnValue = result;
	if(formObj.site_id.value=="MC") {
		if(formObj.function_id.value=="ST_SALES"){
		if(formObj.doc_type_code.value=="GHSKIT"){
		alert("Invalid Selection of Doc Type Code. Pls Use 'Stock Item Consumption:' function ");
		formObj.doc_type_code.focus();
		}
       else	{
			
		  // window.close();
		   const dialogTag = parent.document.getElementById("dialog_tag");    
		dialogTag.close();
	   }
		}
	
		else{
			//window.close();
			 const dialogTag =parent.document.getElementById("dialog_tag");    
			dialogTag.close();
		}
		}
		else{
			//window.close();
			
			 const dialogTag =parent.document.getElementById("dialog_tag");    
			dialogTag.close();
			}
		
		} 
		else {
		alert(getMessage(message, "ST"));
	}
}

function chk_doc_type(){
var formObj = document.formStGeneralHeaderForSingleStore;
  if(formObj.site_id.value=="MC") {
	 if(formObj.function_id.value=="ST_SALES"){
		if(formObj.doc_type_code.value=="GHSKIT"){
		alert("Invalid Selection of Doc Type Code. Pls Use 'Stock Item Consumption:' function ");
		formObj.doc_type_code.focus();
		}
	 }
   }
}


function setDocumentDetails(_doc_type_desc, _doc_no, _store_desc, _doc_date, _doc_ref, _doc_type_code, _store_code, item_class_code) {
	document.getElementById("doc_type_desc").innerText = _doc_type_desc;
	if (_doc_no != "") {
		_doc_no = "/" + _doc_no;
	}
	document.getElementById("doc_no").innerText = _doc_no;
	document.getElementById("store_desc").innerText = _store_desc;
	document.getElementById("doc_date").innerText = _doc_date;
	if (_doc_ref != "") {
		document.getElementById("doc_ref_legend").innerHTML = "Doc Ref:&nbsp;";
	} else {
		document.getElementById("doc_ref_legend").innerHTML = "&nbsp;";
	}
	document.getElementById("doc_ref").innerText = _doc_ref;
	document.getElementById("doc_type_code").value = _doc_type_code;
	document.getElementById("store_code").value = _store_code;
	document.getElementById("item_class_code").value = item_class_code;
	document.getElementById("param1").value = "a";
}
function checkDoc_type_code() {
	if (document.formStGeneralHeaderForSingleStore.doc_type_code.value == "") {
		return;
	}
	var xmlHttp = new XMLHttpRequest();
	//var xmlDoc="";anbu
	//xmlDoc.loadXML(getXMLString(null));anbu
	var xmlString = getXMLString(null);
    var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/StHeaderValidate.jsp?validate=DOC_TYPE_CODE&doc_type_code=" + document.formStGeneralHeaderForSingleStore.doc_type_code.value + "&bean_id=" + document.formStGeneralHeaderForSingleStore.bean_id.value + "&bean_name=" + document.formStGeneralHeaderForSingleStore.bean_name.value, false);
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	eval(responseText);
}
function enableDocNo(bValue) {
	if (!bValue) {
		document.formStGeneralHeaderForSingleStore.doc_no.value = "";
	}
	document.formStGeneralHeaderForSingleStore.doc_no.disabled = !bValue;
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

//added for Item Class Modify 15/11/2003
function loadItemClasses(request_on_store, request_by_store) {
	if (request_by_store.value == "" || request_on_store.value == "") {
		clearListItems("document.formStGeneralHeaderForSingleStore.item_class_code");
		return;
	}
	var formObj = document.formStGeneralHeaderForSingleStore;
	var bean_id = "StHeaderBean";
	var bean_name = "eST.Common.StHeaderBean";
	var xmlHttp = new XMLHttpRequest();
	//var xmlDoc="";anbu
	//xmlDoc.loadXML(getXMLString(null));anbu
	var xmlString = getXMLString(null);
    var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/StHeaderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=RELOAD_ITEM_CLASSES" + "&request_on_store=" + request_on_store.value + "&request_by_store=" + request_by_store.value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
function setItemClass(obj) {
	var item_class_desc = obj[obj.selectedIndex].text;
	var item_class_code = obj.value;
	document.formStGeneralHeaderForSingleStore.item_class_code.value = item_class_code;
	if ((obj[obj.selectedIndex].text != ("---Select---")) && (obj.selectedIndex != 0)) {
		if (obj[obj.selectedIndex].text == ("---Select---")) {
			obj[obj.selectedIndex].text = "";
		}
		var arrayObject = new Array();
		var bean_id = "stHeaderBean";
		var bean_name = "eST.Common.StHeaderBean";
		//var xmlDom = new ActiveXObject("Microsoft.XMLDom");
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr = getXMLString(arrayObject);
		xmlStr = getXMLString(arrayObject);
		//xmlDom.loadXML(xmlStr);
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/StHeaderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=ITEM_CLASS" + "&item_class_desc=" + item_class_desc + "&item_class_code=" + item_class_code, false);
		xmlHttp.send(xmlDoc);
	var	responseText = xmlHttp.responseText;
		//alert("responseText"+responseText);
		eval(responseText);
		//alert(eval(responseText));
	} else {
		return "";
	}
}

