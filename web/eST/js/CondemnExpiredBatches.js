/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
12/08/2015	  	IN0037679	   		Karthi	 									SRR20056-SCF-9534
06/02/2017		IN0063027			Badmavathi B							GHL-CRF-0413.7 - US009 - Barcode search
06/11/2019      IN0071698           B Haribabu                                  Alpha incident       
---------------------------------------------------------------------------------------------------------
*/
var headTop = -1;
var FloatHead;
//Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013 Starts
var chk_val = true;  
function create(){
  f_query_add_mod.location.href="../../eST/jsp/CondemnExpiredBatchesFrame.jsp?mode="+MODE_INSERT+"&function_id="+function_id; 
}
function query() {
		f_query_add_mod.location.href="../../eST/jsp/CondemnExpiredBatchesQueryFrame.jsp?mode="+MODE_MODIFY+"&function_id="+function_id;
}
async function deleterecord()
{
	if(  f_query_add_mod.frameExpiredBatchesList==undefined){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	}
		var formObj = f_query_add_mod.frameExpiredBatchesList.document.formCondemnExpiredBatchesList;
	    if(formObj.mode.value==MODE_MODIFY){
		f_query_add_mod.frameExpiredBatchesList.document.formCondemnExpiredBatchesList.mode.value = MODE_DELETE;
	
	/*if(f_query_add_mod.frameAdjustStockHeader.formAdjustStockHeader.trn_type.value=="ADJ" && f_query_add_mod.frameAdjustStockHeader.formAdjustStockHeader.adj_delete_yn.value=="N"){
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("NO_DELETE_ACCESS_FOR_USER", "ST");
		formObj.mode.value = MODE_MODIFY;
		return false;
	}*/
	var result = await confirmDelete();
	if(result=="")
		{
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
		return false;
		}
	   if(result==YES){
			apply();
		}else {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("OPER_CANCELLED","ST");
			f_query_add_mod.frameExpiredBatchesList.document.formCondemnExpiredBatchesList.mode.value = MODE_MODIFY;
		}
	}else {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
	}
}
//ends
function reset() {
	f_query_add_mod.location.reload();
}
async function ModifyDocDetails() {
	var tit = "TITLE";
	//var retVal = window.showModalDialog("../../eST/jsp/CondemnExpiredBatchesCreateHeader.jsp", "", "dialogHeight:8; dialogWidth: 50; center: 1; status: no; dialogTop :80; scroll: no");
	//Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013  Starts
	var retVal = await window.showModalDialog("../../eST/jsp/CondemnExpiredBatchesCreateHeader.jsp?chk_val="+chk_val, "", "dialogHeight:40vh; dialogWidth: 50vw; center: 1; status: no; dialogTop :2px; scroll: no");
	if(chk_val == false){
	       while(retVal == undefined){
			alert('Please Press Ok Button'); 
			retVal = await window.showModalDialog("../../eST/jsp/CondemnExpiredBatchesCreateHeader.jsp?chk_val="+chk_val, "", "dialogHeight:40vh; dialogWidth: 50vw; center: 1; status: no; dialogTop :2px; scroll: no");
			}
	} //ends
	if (retVal) {
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		// xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/CondemnExpiredBatchesHeaderValidate.jsp?validate=UPDATE_VALUES", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		responseText = responseText.replace(/<[^>]*>/g, '');
		eval(responseText);
	}
}
function toggleCheck(formObject) {
	var allElements = formObject.elements;
	var ischecked = formObject.checkAll.checked;
	for (i = 0; i < allElements.length; i++) {
		if (allElements[i].type == "checkbox") {
			allElements[i].checked = ischecked;
		}
	}
	//Added for GHL-CRF-0413.7 starts
	 if(formObject.site.value=="true"){
		 var count= 0;
		 var total_checkboxes = formObject.totalRecords.value;
			for (p = 0; p < total_checkboxes; p++) {
				if (eval("formObject.remove_" + p + ".checked")) {
					count++;
				}
			}
			parent.frameCondemnExpiredBatchesCriteria.document.formCondemnExpiredBatchesCriteria.querySelector("#selected_records").innerHTML = " " +count+" of "+total_checkboxes+" Records Selected";
		 }
	//Added for GHL-CRF-0413.7 ends	
}
async function callItemSearchScreenFrom() {
	var search_string = document.formCondemnExpiredBatchesCriteria.p_fm_item_code.value;
	var store_code = "";
	var category = "A";
	var sole_source = "A";
	var ps_item = "A";
	var mfg_item = "A";
	var expiry = "A";
	var consignment = "A";
	var item_class = "";
	//Modified by Sakti against AMS-CRF-0011 trn_type passing
	retVal = await callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment,"CEB");
	if (retVal != null) {
		document.formCondemnExpiredBatchesCriteria.p_fm_item_code.value = retVal[0].split(',')[0];
	}
}
async function callItemSearchScreenTo() {
	var search_string = document.formCondemnExpiredBatchesCriteria.p_to_item_code.value;
	var store_code = "";
	var category = "A";
	var sole_source = "A";
	var ps_item = "A";
	var mfg_item = "A";
	var expiry = "A";
	var consignment = "A";
	var item_class = "";
	//Modified by Sakti against AMS-CRF-0011 trn_type passing
	retVal = await callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment,"CEB");
	if (retVal != null) {
		document.formCondemnExpiredBatchesCriteria.p_to_item_code.value = retVal[0].split(',')[0];
	}
}
async function searchFromStoreCode() {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.forms[0].p_language_id.value;
	dataTypeArray[0] = STRING;
	dataNameArray[1] = "facility_id";
	dataValueArray[1] = document.forms[0].p_facility_id.value;
	dataTypeArray[1] = STRING;
	//Commented By Rabbani #Inc no:45695 on 17-12-2013
	//dataNameArray[2] = "user_id";
	//dataValueArray[2] = document.forms[0].user_id.value;
	//dataTypeArray[2] = STRING;
	//argumentArray[0] = document.formCondemnExpiredBatchesCriteria.SQL_ST_STORE_LOOKUP_FOR_CONDEMN.value;
	//argumentArray[0] = "SELECT ST.STORE_CODE CODE, MM.SHORT_DESC DESCRIPTION FROM MM_STORE_LANG_VW MM, ST_STORE ST,ST_USER_ACCESS_FOR_STORE US WHERE MM.EFF_STATUS = 'E' AND LANGUAGE_ID LIKE ? AND MM.FACILITY_ID LIKE (?) AND US.USER_ID LIKE ? AND UPPER (ST.STORE_CODE) LIKE UPPER (?) AND UPPER (MM.SHORT_DESC) LIKE UPPER (?) AND MM.STORE_CODE = ST.STORE_CODE AND US.CNDMN_EXP_BTCH_ALLOWED_YN = 'Y' AND ST.CNDMN_EXP_BTCH_ALLOWED_YN = 'Y' AND ST.STORE_CODE = US.STORE_CODE ORDER BY 2";
	//Added By Rabbani #Inc no:45695 on 17-12-2013
	var user = document.forms[0].user_id.value;
	argumentArray[0] = "SELECT ST.STORE_CODE CODE, MM.SHORT_DESC DESCRIPTION FROM MM_STORE_LANG_VW MM, ST_STORE ST,ST_USER_ACCESS_FOR_STORE US WHERE MM.EFF_STATUS = 'E' AND LANGUAGE_ID LIKE ? AND MM.FACILITY_ID LIKE (?) AND US.USER_ID LIKE '"+user+"' AND UPPER (ST.STORE_CODE) LIKE UPPER (?) AND UPPER (MM.SHORT_DESC) LIKE UPPER (?) AND MM.STORE_CODE = ST.STORE_CODE AND US.CNDMN_EXP_BTCH_ALLOWED_YN = 'Y' AND ST.CNDMN_EXP_BTCH_ALLOWED_YN = 'Y' AND ST.STORE_CODE = US.STORE_CODE ORDER BY 2";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "4,5";
	argumentArray[5] = document.formCondemnExpiredBatchesCriteria.p_fm_store_code.value;
	/*argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;*/
	//Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013  
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	if (returnedValues != null && returnedValues != "") {
		document.formCondemnExpiredBatchesCriteria.p_fm_store_code.value = returnedValues[0].split(',')[0];
	}
}
async function searchToStoreCode() {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.forms[0].p_language_id.value;
	dataTypeArray[0] = STRING;
	dataNameArray[1] = "facility_id";
	dataValueArray[1] = document.forms[0].p_facility_id.value;
	dataTypeArray[1] = STRING;
	//Commented By Rabbani #Inc no:45695 on 17-12-2013
	//dataNameArray[2] = "user_id";
	//dataValueArray[2] = document.forms[0].user_id.value;
	//dataTypeArray[2] = STRING;
	//argumentArray[0] = "SELECT ST.STORE_CODE CODE, MM.SHORT_DESC DESCRIPTION FROM MM_STORE_LANG_VW MM, ST_STORE ST,ST_USER_ACCESS_FOR_STORE US WHERE MM.EFF_STATUS = 'E' AND LANGUAGE_ID LIKE ? AND MM.FACILITY_ID LIKE (?) AND US.USER_ID LIKE ? AND UPPER (ST.STORE_CODE) LIKE UPPER (?) AND UPPER (MM.SHORT_DESC) LIKE UPPER (?) AND MM.STORE_CODE = ST.STORE_CODE AND US.CNDMN_EXP_BTCH_ALLOWED_YN = 'Y' AND ST.CNDMN_EXP_BTCH_ALLOWED_YN = 'Y' AND ST.STORE_CODE = US.STORE_CODE ORDER BY 2";
	//Added By Rabbani #Inc no:45695 on 17-12-2013
	var user = document.forms[0].user_id.value;
	argumentArray[0] = "SELECT ST.STORE_CODE CODE, MM.SHORT_DESC DESCRIPTION FROM MM_STORE_LANG_VW MM, ST_STORE ST,ST_USER_ACCESS_FOR_STORE US WHERE MM.EFF_STATUS = 'E' AND LANGUAGE_ID LIKE ? AND MM.FACILITY_ID LIKE (?) AND US.USER_ID LIKE '"+user+"' AND UPPER (ST.STORE_CODE) LIKE UPPER (?) AND UPPER (MM.SHORT_DESC) LIKE UPPER (?) AND MM.STORE_CODE = ST.STORE_CODE AND US.CNDMN_EXP_BTCH_ALLOWED_YN = 'Y' AND ST.CNDMN_EXP_BTCH_ALLOWED_YN = 'Y' AND ST.STORE_CODE = US.STORE_CODE ORDER BY 2";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "4,5";
	argumentArray[5] = document.formCondemnExpiredBatchesCriteria.p_to_store_code.value;
	/*argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;*/
	//Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013  
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	if (returnedValues != null && returnedValues != "") {
		document.formCondemnExpiredBatchesCriteria.p_to_store_code.value = returnedValues[0].split(',')[0];
	}
}
function checkDoc_type_code() {
	if (document.formCondemnExpiredBatchesAddModify.p_doc_type_code.value == "") {
		return;
	}
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	// xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/CondemnExpiredBatchesValidate.jsp?validate=DOC_TYPE_CODE&doc_type_code=" + document.formCondemnExpiredBatchesAddModify.p_doc_type_code.value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
function isValidateDocNo(obj) {
	if (document.formCondemnExpiredBatchesAddModify.p_doc_start_num.value == "") {
		return;
	}
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	// xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/CondemnExpiredBatchesValidate.jsp?validate=DOC_NO&doc_no=" + document.formCondemnExpiredBatchesAddModify.p_doc_start_num.value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	if (!result) {
		document.formCondemnExpiredBatchesAddModify.p_doc_start_num.focus();
	}
}
function enableDocNo(booleanValue) {
	if (booleanValue) {
		document.formCondemnExpiredBatchesAddModify.p_doc_start_num.value = "";
	}
	document.formCondemnExpiredBatchesAddModify.p_doc_start_num.disabled = booleanValue;
}
function saveAndExit() {
	var formObj = document.formCondemnExpiredBatchesCreate;
	var fields = new Array(formObj.doc_type_code);
	var names = new Array(getLabel("Common.DocType.label", "Common"));
	var index = 1;
	if (!formObj.doc_no.disabled) {
		fields[index] = formObj.doc_no;
		names[index++] = "Doc No";
	}
	fields[index] = formObj.doc_date;
	names[index++] = "Adj Doc Date";
	//Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013  Starts
	if(formObj.val_chk.value == "false"){
	fields[index] = formObj.adj_remarks;
	names[index++] = " Remarks";
	}
	//ends
	var obj = null;
	var errors = "";
	for (var i = 0; i < fields.length; i++) {
		if (trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		} else {
			if (obj == null) {
				obj = fields[i];
			}
			errors = errors + "APP-000001 " + names[i] + " cannot be blank...";
			alert(errors);
			obj.focus();
			return;
		}
	}
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObj), "text/xml");
	// xmlDoc.loadXML(getEnhancedXMLString(formObj));
	var doc_date =formObj.doc_date.value;//Modidied for IN:0071698 //convertDate(formObj.doc_date.value, "DMY", formObj.language_id.value, "en"); // Added for SRR20056-SCF-9534
	//xmlHttp.open("POST", "../../eST/jsp/CondemnExpiredBatchesHeaderValidate.jsp?validate=SET_DETAILS&doc_type_code=" + formObj.doc_type_code.value + "&doc_no=" + formObj.doc_no.value + "&doc_ref=" + formObj.doc_ref.value + "&doc_date=" + formObj.doc_date.value + "&adj_remarks=" + formObj.remarks_code.value + "", false);
	//Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013 
	
	xmlHttp.open("POST", "../../eST/jsp/CondemnExpiredBatchesHeaderValidate.jsp?validate=SET_DETAILS&doc_type_code=" + formObj.doc_type_code.value + "&doc_no=" + formObj.doc_no.value + "&doc_ref=" + formObj.doc_ref.value + "&doc_date=" + doc_date + "&adj_remarks=" +encodeURIComponent(formObj.adj_remarks.value) + "", false); // Modified for SRR20056-SCF-9534
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	responseText = responseText.replace(/<[^>]*>/g, '');
	eval(responseText);
	window.returnValue = result;
	if (result) {
		parent.document.getElementById("dialog_tag").close();
	} else {
		alert(getMessage(message, "ST"));
	}
}
function loadData() {
	var formObj = document.formCondemnExpiredBatchesCriteria;
	var site = formObj.site.value; 	//Added for GHL-CRF-0413.7 
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObj), "text/xml");
	// xmlDoc.loadXML(getEnhancedXMLString(formObj));
	var locale = formObj.p_language_id.value;
	var from_date = convertDate(formObj.p_fm_cut_off_date.value, "DMY", locale, "en");
	var to_date = convertDate(formObj.p_to_cut_off_date.value, "DMY", locale, "en");
	var from_store = formObj.p_fm_store_code.value;
	var to_store = formObj.p_to_store_code.value;
	var from_item = formObj.p_fm_item_code.value;
	var to_item = formObj.p_to_item_code.value;
	/*if(from_date != null && from_date != "" && to_date != null && to_date != "") {
		if(to_date < from_date) {
			var stMessage	=	getMessage("LESS_OR_EQUAL_VALIDATE");
			stMessage	=	stMessage.replace(/@/g, "Cut-off Date")
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+stMessage;
			return;
		}
		
		alert(parent.parent.frames[2].name);
			

	}
	
	if(from_store != null && from_store != "" && to_store != null && to_store != "") {
		if(to_store < from_store) {
			var stMessage	=	getMessage("LESS_OR_EQUAL_VALIDATE");
			stMessage	=	stMessage.replace(/@/g, "Store Code")
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+stMessage;
			return;
		}
	}

	if(from_item != null && from_item != "" && to_item != null && to_item != "") {
		if(to_item < from_item) {
			var stMessage	=	getMessage("LESS_OR_EQUAL_VALIDATE");
			stMessage	=	stMessage.replace(/@/g, "Item Code")
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+stMessage;
			return;
		}
	}
	*/

//	if (doDateCheck(formObj.p_fm_cut_off_date, formObj.p_to_cut_off_date, parent.parent.frames[2] ))
	if (isValidFromToField(formObj.p_fm_cut_off_date, formObj.p_to_cut_off_date, DATE, getLabel("Common.date.label", "Common"), parent.parent.frames[2])) {
		if (isValidFromToField(formObj.p_fm_store_code, formObj.p_to_store_code, STRING, getLabel("Common.StoreCode.label", "Common"), parent.parent.frames[2])) {
			if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), parent.parent.frames[2])) {
				//xmlHttp.open("POST", "../../eST/jsp/CondemnExpiredBatchesHeaderValidate.jsp?validate=LOAD_DATA&from_date=" + from_date + "&to_date=" + to_date + "&from_store=" + formObj.p_fm_store_code.value + "&to_store=" + formObj.p_to_store_code.value + "&from_item=" + formObj.p_fm_item_code.value + "&to_item=" + formObj.p_to_item_code.value + "&batch_id=" + formObj.p_batch_id.value + "", false);
				//Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013
				xmlHttp.open("POST", "../../eST/jsp/CondemnExpiredBatchesHeaderValidate.jsp?validate=LOAD_DATA&from_date=" + from_date + "&to_date=" + to_date + "&from_store=" + formObj.p_fm_store_code.value + "&to_store=" + formObj.p_to_store_code.value + "&from_item=" + formObj.p_fm_item_code.value + "&to_item=" + formObj.p_to_item_code.value + "&batch_id=" + formObj.p_batch_id.value + "&exp_yn=" +formObj.condemn_type.value + "", false);
				xmlHttp.send(xmlDoc);
				responseText = xmlHttp.responseText;
				responseText = responseText.replace(/<[^>]*>/g, '');
//	alert("responseText : "+responseText);
				eval(responseText); 
				window.returnValue = result;
				parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
//	alert("result : "+result);
				if (result) {
					parent.frameExpiredBatchesList.location.href = "../../eST/jsp/CondemnExpiredBatchesList.jsp?condemn_type="+formObj.condemn_type.value+"&site="+site;	//Added site for GHL-CRF-0413.7 
				} else {
					alert(getMessage(message, "ST"));
				}
			}
		}
	}
}
function setDocumentDetails(_doc_type_desc, _doc_no, _doc_date, _doc_ref, _doc_type_code, _adj_remarks) {
	/*document.getElementById("doc_type_desc").innerHTML = "<b>" + _doc_type_desc + "</b>";
	document.getElementById("adj_doc_date").innerHTML = "<b>" + _doc_date + "</b>";
	document.getElementById("adj_doc_type_code").value = _doc_type_code;
	document.getElementById("doc_ref_id").innerHTML = "<b>" + _doc_ref + "</b>";
	//document.getElementById("adj_remarks").innerHTML ="<b>"+_adj_remarks+"</b>";	*/
	//Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013
	
	 if(chk_val == true){
	 // var formObj = document.formCondemnExpiredBatchesCreate;
		document.getElementById("doc_type_desc").innerHTML = "<b>" + _doc_type_desc + "</b>";
		document.getElementById("adj_doc_date").innerHTML = "<b>" + _doc_date + "</b>";
		document.getElementById("adj_doc_type_code").value = _doc_type_code;
		document.getElementById("doc_ref_id").innerHTML = "<b>" + _doc_ref + "</b>";
		document.getElementById("hdr_remarks").value =   decodeURIComponent(_adj_remarks,"UTF-8");
		
	}else{
	  //var formObj = f_query_add_mod.frameCondemnExpiredBatchesAddModify.document.formCondemnExpiredBatchesCreate;
		f_query_add_mod.frameCondemnExpiredBatchesAddModify.document.getElementById("doc_type_desc").innerHTML = "<b>" + _doc_type_desc + "</b>";
		f_query_add_mod.frameCondemnExpiredBatchesAddModify.document.getElementById("adj_doc_date").innerHTML = "<b>" + _doc_date + "</b>";
		f_query_add_mod.frameCondemnExpiredBatchesAddModify.document.getElementById("adj_doc_type_code").value = _doc_type_code;
		f_query_add_mod.frameCondemnExpiredBatchesAddModify.document.getElementById("doc_ref_id").innerHTML = "<b>" + _doc_ref + "</b>";
		f_query_add_mod.frameCondemnExpiredBatchesAddModify.document.getElementById("hdr_remarks").value = decodeURIComponent(_adj_remarks,"UTF-8");
	}
}
async function apply() {
	if( f_query_add_mod.frameExpiredBatchesList == null || f_query_add_mod.frameExpiredBatchesList.formCondemnExpiredBatchesList==undefined){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	}
	var errorPage = "../../eCommon/jsp/error.jsp";
	var arrayObject = new Array(f_query_add_mod.frameCondemnExpiredBatchesAddModify.document.getElementById("adj_doc_type_code"));
	var names = new Array(getLabel("Common.documenttype.label", "Common"));
	var blankObject = checkSTFields(arrayObject, names,messageFrame);
	if (!blankObject)
		return;
	var checkedValues="";
	var formObjcheck = f_query_add_mod.frameExpiredBatchesList.formCondemnExpiredBatchesList;
	var total_checkboxes = formObjcheck.totalRecords.value;
	//Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013		
	var disposable_yn = formObjcheck.disposable_yn.value;
	var canProcess = 0;
	var noDetailExists = false;
	for (i = 0; i < total_checkboxes; i++) {
		if (eval("formObjcheck.remove_" + i + ".checked")) {
		//if(eval("formObjcheck.remarks_desc_" + i + ".value") != ""){
			 //var obj = eval("formObjcheck.remove_" + i + ".value")+"||"+eval("formObjcheck.trn_remarks_code_" + i + ".value");
			 var obj = eval("formObjcheck.remove_" + i + ".value");
			 //} 
			  
			var obj1 = eval("formObjcheck.remove_" + i);
			obj1.value =  obj;
			
			checkedValues = checkedValues+obj+"~";
		} else {
			canProcess++;
		}
	}
	if (total_checkboxes == canProcess) {
		noDetailExists = true;
	}
	//if (noDetailExists) {
	if (noDetailExists && !(formObjcheck.mode.value==MODE_DELETE)) { //Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("MIN_ONE_DETAIL_REQUIRED", "Common");
		return;
	}
	//Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013
	if(formObjcheck.mode.value==MODE_DELETE) 
	{
		eval(formApply(formObjcheck, ST_CONTROLLER));
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
		if(result) {
			onSuccess();
		}
		return;
	}

/*****/
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;	
	xmlStr ="<root><SEARCH ";
	xmlStr += "checkedValues=\""+ checkedValues +"\" " ;
	xmlStr += "bean_id=\"condemnExpiredBatchesHeaderBean\" ";
	xmlStr += "bean_name=\"eST.CondemnExpiredBatchesHeaderBean\" ";
	xmlStr +=" /></root>" ;		
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
	xmlHttp.open( "POST", "CondemnExpiredBatchesHeaderValidate.jsp?validate=CHECKEDCOMMITED", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText=responseText.replace(/<\/?[^>]+(>|$)/g, "");
	eval(responseText);

	if(result){
	messageFrame.location.href = errorPage + "?err_num="+"Cannot Condemn for store : <B>"+ message+ "<BR>"+flag + " </B>"+ "  " +"     Committed Qty found";
	return false;
	}

/*******/

	var formObject = f_query_add_mod.frameExpiredBatchesList.document.formCondemnExpiredBatchesList;
	var total_items = formObject.total_checkboxes.value;
	var chkdValue = 0;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObject), "text/xml");
	//xmlDoc.loadXML(getEnhancedXMLString(formObject));
	xmlHttp.open("POST", "../../eST/jsp/CondemnExpiredBatchesHeaderValidate.jsp?validate=VALIDATE", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	responseText=responseText.replace(/<\/?[^>]+(>|$)/g, "");
	
	//alert("responseText : "+responseText);
	eval(responseText);
	
	if (result) {
		var mode = formObject.mode.value;
		//Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013 Starts
		if(disposable_yn == "N"){
		var confirmation = await confirmFinalize();  
		if(confirmation==""){
				messageFrame.location.href = errorPage + "?err_num=";
				return;
			}
			   if(confirmation=="Yes") {
				formObject.finalized.value="Y";
			    }else{
				formObject.finalized.value="N";
				}
				//alert(f_query_add_mod.frameCondemnExpiredBatchesAddModify.document.getElementById("hdr_remarks").value);
			if(formObject.finalized.value =="Y" && (f_query_add_mod.frameCondemnExpiredBatchesAddModify.document.getElementById("hdr_remarks").value == "") ){
				alert("Condemn Remarks cannot be blank ");
				chk_val = false;
				var DocDetails = await ModifyDocDetails();
				confirmation = await confirmFinalize();  
				if(confirmation==""){
				messageFrame.location.href = errorPage + "?err_num=";
				return;
			      }
				if(confirmation=="Yes") {
					formObject.finalized.value="Y";
				}else{
					formObject.finalized.value="N";
				}
			}  
			
		}//ends
		 for (i = 0; i < total_items; i++) {
		 if (eval("formObject.remove_" + i + ".checked")) {
		 var obj_1 = eval("formObject.remove_"+i).value;
		     if(formObject.finalized.value == "N"  && formObject.mode.value== MODE_MODIFY){
		      var item_code = (obj_1.split("||"))[0];
			  var store_code = (obj_1.split("||"))[1];
			  var batch_id = (obj_1.split("||"))[2];
			  var bin_loc = (obj_1.split("||"))[3];
			  var exp_date = (obj_1.split("||"))[4];
			  var trade_id = (obj_1.split("||"))[5];
			  var exp_yn = (obj_1.split("||"))[7];
			 var proposed_qty = eval("formObject.propsed_qty_" + i + ".value");
			 var obj_new = item_code+"||"+store_code+"||"+batch_id+"||"+bin_loc+"||"+exp_date+"||"+trade_id+"||"+proposed_qty+"||"+exp_yn;
			 
			 eval("formObject.remove_"+i).value = "";
			 eval("formObject.remove_"+i).value = obj_new;
			 }
		    if(eval("formObject.remarks_desc_" + i + ".value") != ""){
		     eval("formObject.remove_"+i).value = eval("formObject.remove_"+i).value+"||"+eval("formObject.trn_remarks_code_"+i).value;
			 }
		  }
		 }
		var responseText = formApply(formObject, ST_CONTROLLER);
		responseText=responseText.replace(/<\/?[^>]+(>|$)/g, "");
		eval(responseText);
// Added for online printing on 10/1/2004
		flag1 = (flag.split("~"))[0];
		flag2 = (flag.split("~"))[1];
		flag1 = (flag1 == "null" ? "" : flag1);
		if (result) {
			if (flag2 == "PY") {
				var PConfirm = await confirmPrinting();
				if (PConfirm == "Yes") {
					var xmlHttp = new XMLHttpRequest();
					var xmlDoc="";
					// xmlDoc.loadXML(getXMLString(null));
					xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
					xmlHttp.open("POST", "../../eST/jsp/CondemnExpiredBatchesHeaderValidate.jsp?validate=printOnlineDoc&msg=" + encodeURIComponent(message), false);
					xmlHttp.send(xmlDoc);
					responseText = xmlHttp.responseText;
					eval(responseText);
				}
			}
			else if (flag2 == "PN") { //Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			// xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/CondemnExpiredBatchesHeaderValidate.jsp?validate=printOnlineDoc&msg=" + encodeURIComponent(message), false);
			xmlHttp.send(xmlDoc);
	   }
			messageFrame.location.href = errorPage + "?err_num=" + message + "<BR>" + (result ? flag1 : "");
			onSuccess();
			//Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 01-MAR-2013		
			//alert(disposable_yn);
            if(disposable_yn == "Y"){
			 var display_msg = message;
			 display_msg = (display_msg.split("."))[0];
			var disposable_flag = display_msg + " " + flag1;
			 alert(disposable_flag);
             window.close();
			 }
		}
// Online printing Ends here 10/1/2004
		if (result) {
		 
			onSuccess();
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + message + "<BR>" + flag1;
			//Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 01-MAR-2013		
            if(disposable_yn == "Y"){
			var display_flag = message;
			 display_msg = (display_flag.split("."))[0];
			  var disposable_flag1 = display_msg + " " + flag1;
			  alert(disposable_flag1);
              window.close();
			 } //ends
		} else {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + message;
		}
	} else {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("MIN_ONE_DETAIL_REQUIRED", "Common");
	}
}
function onSuccess() {
	//f_query_add_mod.document.location.reload();
	f_query_add_mod.location.href="../../eCommon/html/blank.html";
}
function CheckForSpecialChars(event) {
	var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*/-";
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) {
		return false;
	}  // Not a valid key
	if ((event.keyCode >= 97) && (event.keyCode <= 122)) {
		return (event.keyCode -= 32);
	}
	return true;
}
// Added on 10/26/2004 for Transaction Remarks 
async function searchRemarks(objCode, objDesc, locale, sql_mm_trn_remarks_lookup1) {

//	objCode_value = trimString(objCode.value);
//	objDesc_value = trimString(objDesc.value);
	objCode_value = "";
	objDesc_value = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	/*dataNameArray[0] = "language_id";
	dataValueArray[0] = locale.value;
	dataTypeArray[0] = STRING;
	dataNameArray[1] = "module_id";
	dataValueArray[1] = "ST";
	dataTypeArray[1] = STRING;
	dataNameArray[2] = "trn_type";
	dataValueArray[2] = "CEB";
	dataTypeArray[2] = STRING;
	argumentArray[0] = sql_mm_trn_remarks_lookup1.value;*/
	argumentArray[0] = "SELECT DISTINCT MM.TRN_REMARKS_CODE  CODE,MM.REMARKS_DESC  DESCRIPTION FROM  MM_TRN_REMARKS_LANG_VW  MM, ST_TRN_TYPE_FOR_REMARKS ST WHERE  ST.EFF_STATUS = 'E'   AND  ST.TRN_REMARKS_CODE = MM.TRN_REMARKS_CODE  AND UPPER(MM.MODULE_ID) LIKE  UPPER('ST')   AND  UPPER(ST.TRN_TYPE)  LIKE  UPPER('CEB')     AND  MM.TRN_REMARKS_CODE LIKE   UPPER(?)     AND  UPPER(MM.REMARKS_DESC) LIKE  UPPER(?) AND MM.LANGUAGE_ID =" + "'" + locale.value + "'";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.remarks.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
	}
}

// Ends of 10/26/2004

async function searchRemarksCode(obj,obj1) {
	var argumentArray	= new Array();
	var dataNameArray	= new Array();
	var dataValueArray	= new Array();
	var dataTypeArray	= new Array();
	/*dataNameArray[0]		=		"language_id" ;
	dataValueArray[0]		=		document.formAdjustStockListHeader.language_id.value;
	dataTypeArray[0]		=		STRING ;

	dataNameArray[0]		=		"module_id" ;
	dataValueArray[0]		=		"ST";
	dataTypeArray[0]		=		STRING ; 
	

	dataNameArray[1]		=		"trn_type" ;
	dataValueArray[1]		=		"CEB";
	dataTypeArray[1]		=		STRING ;*/	

	//argumentArray[0]		=		document.formAdjustStockListHeader.SQL_ST_TRN_REMARKS_LOOKUP_SELECT.value;	
	argumentArray[0] = "SELECT DISTINCT MM.TRN_REMARKS_CODE  CODE,MM.REMARKS_DESC  DESCRIPTION FROM  MM_TRN_REMARKS_LANG_VW  MM, ST_TRN_TYPE_FOR_REMARKS ST WHERE  ST.EFF_STATUS = 'E'   AND  ST.TRN_REMARKS_CODE = MM.TRN_REMARKS_CODE  AND UPPER(MM.MODULE_ID) LIKE  UPPER('ST')   AND  UPPER(ST.TRN_TYPE)  LIKE  UPPER('CEB')     AND  MM.TRN_REMARKS_CODE LIKE   UPPER(?)     AND  UPPER(MM.REMARKS_DESC) LIKE  UPPER(?) AND MM.LANGUAGE_ID =" + "'" + document.formCondemnExpiredBatchesList.language_id.value + "'";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj1.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.remarks.label", "Common"), argumentArray);
	
	
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0].split(',')[0];
		obj1.value = returnedValues[0].split(',')[1];
	}
}
function processScroll()
	{
		
		if (headTop < 0)
		{
			saveHeadPos();
			
		}
		if (headTop>0)
		{
			if (document.documentElement && document.documentElement.scrollTop)
				theTop = document.documentElement.scrollTop;
			else if (document.body)
				theTop = document.body.scrollTop;

			if (theTop>headTop){
				FloatHead.style.top = (theTop-headTop) + 'px';
				
			}
			else{
				FloatHead.style.top = '0px';
				
			}
		}
	}

	function saveHeadPos()
	{
		parTable = document.getElementById("divHeadSep");
		if (parTable != null)
		{
			headTop = parTable.offsetTop + 3;
			FloatHead = document.getElementById("heading");
			
			FloatHead.style.position = "relative";
			
		}
	}
	//Added by Sakti sankar against AAKH-CRF-0022-Inc#38258	
async function callItemSpcfnWindow(item_code,item_name) {
		var retVal		=await	window.showModalDialog("../../eST/jsp/DisplayItemspecification.jsp?item_name=" + encodeURIComponent(item_name,"UTF-8")+"&item_code=" + item_code , "", "dialogHeight:15vh; dialogWidth:50vw; center:0; status: no; dialogLeft :120; dialogTop :250;scroll:yes");
}

function onMOut(obj) {
    obj.style.display='none';
	/*obj.innerHTML = "";
	obj.style.width = 0;
	obj.style.borderColor = "";
	obj.style.borderWidth = "";
	obj.style.borderStyle = "";*/
}

function onMOver(obj, e, item_specfn_name,item_remarks,item_name) {

	item_remarks = decodeURIComponent(item_remarks,"UTF-8");
	item_specfn_name = decodeURIComponent(item_specfn_name,"UTF-8");
	item_name = decodeURIComponent(item_name,"UTF-8");

	if(item_remarks.length > 100) {//Added against inc#39623 for displaying 100 characters in tooltip
		item_remarks =  item_remarks.substring(0, 100);
		item_remarks = item_remarks + " ...";
	}
	if(item_specfn_name.length > 100) {
		item_specfn_name =  item_specfn_name.substring(0, 100);
		item_specfn_name = item_specfn_name + " ...";
	}
//Added ends

	//obj.style.left = e.x - 180;
    obj.style.display='inline';
    bodwidth  = document.body.document.getElementById('divHeadSep').offsetWidth;
    bodheight = document.body.document.getElementById('divHeadSep').offsetHeight;
    var x     = event.x;
    var y     = event.y;

    y += document.body.document.getElementById('divHeadSep').scrollTop;
    x += document.body.document.getElementById('divHeadSep').scrollLeft;

	obj.style.posLeft= x+10;

//alert('y='+y+' x='+x+ " bodheight="+bodheight+" obj.offsetHeight="+obj.offsetHeight);


	if((y+25) > (bodheight - obj.offsetHeight ) ){
		//obj.style.posTop = y - (obj.offsetHeight+10);
		y = (bodheight+document.body.document.getElementById('divHeadSep').scrollTop) - (obj.offsetHeight+25);

//alert('y='+y+' scrollTop='+document.body.document.getElementById('divHeadSep').scrollTop);

		if(y < document.body.document.getElementById('divHeadSep').scrollTop)
			y = document.body.document.getElementById('divHeadSep').scrollTop+5;
		//if((y+obj.offsetHeight) >  bodheight)
		obj.style.posTop = y;
	}
	else
		obj.style.posTop = y+10;



//alert('obj.style.posTop='+obj.style.posTop);

	//obj.style.left = 30; //Added against inc#39529 for fixed size of tooltip
	//obj.style.top = e.y + 30;
	obj.style.borderColor = "";
	obj.style.borderWidth = "thin";
	obj.style.borderStyle = "groove";
	obj.style.width = 30;
		
	if(item_specfn_name != "" && item_remarks !="" ) {
		
	obj.innerHTML = "<table cellspacing='0' cellpadding='0' border='1'  ><tr><td class='ITEMSELECT' width=300 nowrap align=left> <b>" + "Item "+ " :</b>"+ item_name+ "</td></tr><tr></tr><tr><th width=300 nowrap align=center>" + getLabel("eMM.ItemRemarks.label", "MM") + "</th></tr><tr><td class='OAQRYEVEN' align='left'  >" + item_remarks + "</td> </tr> <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr> <tr><th width=300 nowrap align=center>" + getLabel("eMM.ItemSpecification.label", "MM") + "</tr></th><tr><td class='OAQRYODD' align='left' >" +  item_specfn_name + "</td></tr></table>";
	} 
	else if(item_remarks !="" )  {
		
	obj.innerHTML = "<table cellspacing='0' cellpadding='0' border='1' height=100% ><tr><td class='ITEMSELECT' width=300 nowrap align=left><b> " + "Item "+ " :</b>"+  item_name+ "</td></tr><tr></tr><tr><th width=300 nowrap align=center>" + getLabel("eMM.ItemRemarks.label", "MM") + "</th></tr><tr><td class='OAQRYEVEN' align='left'  >" + item_remarks +"</td> </tr> </table>";
	}
	else if(item_specfn_name !="" ) {
		
	obj.innerHTML = "<table cellspacing='0' cellpadding='0' border='1' height=100% ><tr><td class='ITEMSELECT' width=300 nowrap align=left><b> " + "Item "+ " :</b>"+  item_name+ "</td></tr> <tr><th width=300 nowrap align=center>" + getLabel("eMM.ItemSpecification.label", "MM") + "</tr></th><tr><td class='OAQRYODD' align='left' >" +  item_specfn_name + "</td></tr></table>";
	}
}
//Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013 Starts
function checkForMandatory(){
parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
var from_doc_date=document.formCondemnExpiredBatchesQueryCriteria.from_doc_date ;
var to_doc_date=document.formCondemnExpiredBatchesQueryCriteria.to_doc_date ;
var sysdate=document.formCondemnExpiredBatchesQueryCriteria.sysdate ;
var errorPage = "../../eCommon/jsp/error.jsp";
var arrayObject = new Array(document.formCondemnExpiredBatchesQueryCriteria.from_doc_date,document.formCondemnExpiredBatchesQueryCriteria.to_doc_date);
var names = new Array(getLabel("eST.FromDocDate.label", "ST"),getLabel("eST.ToDocDate.label", "ST"));
var blankObject = checkSTFields(arrayObject, names, parent.parent.messageFrame, errorPage);
	if (blankObject != true) {
		return;
	}
var flag1=false;
	
var flag2=false;
flag1=checkSysdate(sysdate,from_doc_date);
flag2=checkSysdateTo(to_doc_date,from_doc_date);

if(flag1!=false)
{
	if(flag2!=false) {
		document.formCondemnExpiredBatchesQueryCriteria.action="../../eST/jsp/CondemnExpiredBatchesQueryResult.jsp";
		document.formCondemnExpiredBatchesQueryCriteria.target="CondemnExpiredBatchesQueryResult";
		document.formCondemnExpiredBatchesQueryCriteria.submit();
	}
}
}

function checkSysdate(receiptdate, sysdate) {
	//SRR20056-SCF-9534_IN037679-RF [IN056899]
	var formObj = document.formCondemnExpiredBatchesQueryCriteria;
	var locale = formObj.language_id.value;
	//SRR20056-SCF-9534_IN037679-RF [IN056899]
	var errorPage = "../../eCommon/jsp/error.jsp";
	var arrayObject = new Array(document.formCondemnExpiredBatchesQueryCriteria.from_doc_date);
	if(receiptdate.value!=""){
		//var flag = ChkDate(receiptdate); - commented for SRR20056-SCF-9534_IN037679-RF [IN056899]
		var flag = CheckDateLeap(receiptdate,'DMY',locale);  // added for SRR20056-SCF-9534_IN037679-RF [IN056899]
		if (!flag) {
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("INVALID_DATE_FMT", "ST");
			return false;
		}

		if (flag) {
			if (checkdateWithSysDate(receiptdate, sysdate)) {
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("FRM_DOC_DATE_NOT_LESS_SYSDATE","ST");
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

function checkSysdateTo(receiptdate, sysdate) {
	//SRR20056-SCF-9534_IN037679-RF [IN056899]
	var formObj = document.formCondemnExpiredBatchesQueryCriteria;
	var locale = formObj.language_id.value;
	//SRR20056-SCF-9534_IN037679-RF [IN056899]
	var errorPage = "../../eCommon/jsp/error.jsp";
	var arrayObject = new Array(document.formCondemnExpiredBatchesQueryCriteria.from_doc_date);
	if(receiptdate.value!=""){
		//var flag = ChkDate(receiptdate);  - commented for SRR20056-SCF-9534_IN037679-RF [IN056899]
		var flag = CheckDateLeap(receiptdate,'DMY',locale); // added for SRR20056-SCF-9534_IN037679-RF [IN056899]
		if (!flag) {

		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("INVALID_DATE_FMT", "ST");
			return false;
		}

		if (flag) {
			if (checkdateWithSysDateTo(receiptdate, sysdate)) {
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("TO_DOC_DATE_NOT_LESS_FRM_DOC_DATE","ST");
			return false;
						
			}
			}
	}
}
function checkdateWithSysDateTo(entered_date, sys_date) {
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
function Modify(obj,doc_type_code,local) {
	
	var errorPage = "../../eCommon/jsp/error.jsp";
	document.getElementById("readOnlyDiv").style.visibility='visible';
	var doc_no		= obj.cells[1].innerText;
	var doc_date	= obj.cells[2].innerText;
	//var doc_ref	    = obj.cells[3].innerText;
	//var remarks  	= obj.cells[4].innerText;
    doc_date        = convertDate(doc_date,'DMY',local,"en");
    var doc_ref	    = "";
	var remarks  	= "";
 
	parent.document.location.href="../../eST/jsp/CondemnExpiredBatchesFrame.jsp?mode="+MODE_MODIFY+"&function_id="+parent.parent.function_id+"&doc_type_code="+doc_type_code+"&doc_no="+doc_no+"&doc_date="+doc_date+"&doc_ref="+doc_ref+"&remarks="+remarks; 

}
function changestatus(index,obj){
	var formObject         =   document.formCondemnExpiredBatchesList;
	var total_check_boxes =   formObject.total_checkboxes.value;
	 var check_all = true;
	 for(i=0; i<total_check_boxes;i++){
	 if(eval("formObject.remove_"+i).checked == false)
	   check_all = false;
	 }
	 if(check_all)
		 formObject.checkAll.checked = true;
		 else
		 formObject.checkAll.checked = false;
	//Added site for GHL-CRF-0413.7 starts
	 if(formObject.site.value=="true"){
	 var count= 0;
	 var total_checkboxes = formObject.totalRecords.value;
		for (var k = 0; k < total_checkboxes; k++) {
			if (eval("formObject.remove_" + k + ".checked")) {
				count++;
			}
		}
		parent.frameCondemnExpiredBatchesCriteria.document.formCondemnExpiredBatchesCriteria.querySelector("#selected_records").innerHTML = " " +count+" of "+total_checkboxes+" Records Selected";
	 }
	 //Added site for GHL-CRF-0413.7 ends
}
function loadLegend(obj){
	frmObject = document.formCondemnExpiredBatchesCriteria;
	if(obj.value == "Y"){
		frmObject.all.cutoffdate.innerText = "Cut-off Date for Expiry"+ "  ";
	}else{
		frmObject.all.cutoffdate.innerText = "Cut-off Date for Receipt"+ "  ";
	}
}
function checkMaxLengthPaste(obj,maxlength)
{
                var len; 
                var txt = clipboardData.getData("Text"); 
                txt = obj.value + txt ;
                len = parseInt(txt.length); 
                if ( len >  maxlength ) 
                { 
                        event.returnValue=false; 
                        txt = txt.substring(0, maxlength);                
                        obj.value = txt;                           
                        
                } 
}
//ends
//Added for GHl-CRF-0413.7 starts
var prevObj = null;
function changeRowColor(obj,i,count) {
	if(count==1){
		prevObj = null;
	}
	if (prevObj != null) {
		for(var j=0;j<9;j++){	
			prevObj.cells(j).className = "QRYEVEN";
		}
	}
	prevObj = obj;
	if(eval("parent.frameExpiredBatchesList.document.formCondemnExpiredBatchesList.remove_"+i+".checked") == true){
		for(var k=0;k<9;k++){	
			obj.cells(k).className = "STLIGHTPINK";
		}
	}else{
		for(var m=0;m<9;m++){	
			obj.cells(m).className = "QRYEVEN";
		}
	}
}
function processCheckBox(formObject){
	var site = formObject.site.value;
	if(site == "true"){	
		var totalRecords = formObject.totalRecords.value;
		//console.log();
		parent.frameCondemnExpiredBatchesCriteria.document.formCondemnExpiredBatchesCriteria.querySelector('#selected_records').innerHTML = " 0 of "+totalRecords+" Records Selected";
		parent.frameCondemnExpiredBatchesCriteria.document.formCondemnExpiredBatchesCriteria.barcode.disabled = false;
		parent.frameCondemnExpiredBatchesCriteria.document.formCondemnExpiredBatchesCriteria.barcode.focus();
		parent.frameCondemnExpiredBatchesCriteria.document.formCondemnExpiredBatchesCriteria.barcode.value="";
		var allElements = formObject.elements;
		formObject.checkAll.checked = false;
		var ischecked = formObject.checkAll.checked;
		for (i = 0; i < allElements.length; i++) {
			if (allElements[i].type == "checkbox") {
				allElements[i].checked = ischecked;
			}
		}
	}
}
function searchBarcode(e,bar_code){
	if(e.keyCode==13 || e.keyCode== 9  || e.keyCode== 0){
		var barcode = bar_code.value;
		document.formCondemnExpiredBatchesCriteria.barcode.value ="";
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		// xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?&barcode=" + barcode + "&bean_id=" + "condemnExpiredBatchesHeaderBean" + "&bean_name=" + "eST.CondemnExpiredBatchesHeaderBean" + "&BARCODE_YN=TRUE" +  "&validate=VALID_BARCODE", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText); 
		if(result){
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			// xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/CondemnExpiredBatchesHeaderValidate.jsp?&barcode=" + barcode  +  "&validate=VALID_BARCODE", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if(result){
			var formObjcheck = parent.frameExpiredBatchesList.document.formCondemnExpiredBatchesList;
			resultArray = message.split(";");
			var  sel_checkbox   = 	resultArray[0];
			eval("formObjcheck.remove_"+sel_checkbox).checked = true;
			var total_checkboxes = formObjcheck.totalRecords.value;
			var count= 0;
			for (var i = 0; i < total_checkboxes; i++) {
				if (eval("formObjcheck.remove_" + i + ".checked")) {
					count++;
				}
			}
			if(count==total_checkboxes)
				formObjcheck.checkAll.checked = true;
			document.formCondemnExpiredBatchesCriteria.querySelector("#selected_records").innerHTML = " " +count+" of "+total_checkboxes+" Records Selected";
			var trObject = eval("formObjcheck.all.tr_" + sel_checkbox);
			changeRowColor(trObject,sel_checkbox,count);
		}
		else{
			alert(getMessage("CONDEMN_BATCH_BARCODE_NOT_FOUND", "ST"));
			document.formCondemnExpiredBatchesCriteria.barcode.value = "";
			return false;
		}
		}else{
			alert(getMessage("ST_INVALID_BAR_CODE", "ST"));
			document.formCondemnExpiredBatchesCriteria.barcode.value = "";
			return false;
		}
	}
}
//Added for GHL-CRF-0413.7 ends
