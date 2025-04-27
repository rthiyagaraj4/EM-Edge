/*
-------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name			INC Number       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------------------------
27/02/2014				42063			        Suresh R						27/02/2014           Suresh R       AMS-CRF-0054(Added Item Based IssueReturn)

27/10/2014				HSA-CRF-0171			Sakti Sankar		48543											In Issue Return,Remove the validation 
																													of Issue Doc.Type.Users just need to 
																													find the Issue Doc No. Once user select item 
																													to be returned in the list, system should auto 
																													default the value of Issue Doc. Type
06/02/2017				IN0061112		Badmavathi B											GHL-CRF-0413 - Barcode search
08/06/2017				IN064208		Badmavathi B											GHL-CRF-0464
11/08/2020              IN073577               Haribabu                                                                   MMS-DM-CRF-0174.2
30/12/2020      TFSid:11896      B Haribabu          30/12/2020          ST-MMS-DM-CRF-0174.2/03(TF) - Request Issue
--------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
var prevObj = null;
var prevColor = null;
var maxReturnableQuantity = "";
var cost_value = "";
var doc_no="";
var finalizeType;
async function deleterecord() {
if(f_query_add_mod.frameIssueReturnHeader==undefined){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	}
	var errorPage = "../../eCommon/jsp/error.jsp";
	var formObj = f_query_add_mod.frameIssueReturnHeader.document.formIssueReturnHeader;
	var prevMode = formObj.mode.value;
	if (prevMode == MODE_INSERT) {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("OPER_CANCELLED", "ST");
		return;
	}
	if(formObj.ret_delete_yn.value=="N"){
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("NO_DELETE_ACCESS_FOR_USER", "ST");;
	formObj.mode.value=MODE_MODIFY;
	return false;
}
	var result = await confirmDelete();
	if (result != YES) {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("OPER_CANCELLED", "ST");
		formObj.mode.value=MODE_MODIFY;
		return;
	}
	f_query_add_mod.frameIssueReturnHeader.document.formIssueReturnHeader.mode.value = MODE_DELETE;
	var responseText = formApply(formObj, ST_CONTROLLER);
	//alert(responseText);
	eval(responseText);
	if (result) {
		onSuccess();
		messageFrame.location.href = errorPage + "?err_num=" + message;
	} else {
		formObj.mode.value = prevMode;
	}
}
function create() {
	f_query_add_mod.location.href = "../../eST/jsp/IssueReturnFrame.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
}
function query() {
	f_query_add_mod.location.href = "../../eST/jsp/IssueReturnQueryFrame.jsp?mode=" + MODE_MODIFY + "&function_id=" + function_id;
}
function reset() {
	f_query_add_mod.location.reload();
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
	var doc_type_code = obj.cells[5].innerText;
	var item_class_desc = obj.cells[8].innerText;
	var item_class_code = obj.cells[7].innerText;
	if (item_class_desc == "null") {
		item_class_desc = "";
	}
	parent.document.location.href = "../../eST/jsp/IssueReturnFrame.jsp?mode=" + MODE_MODIFY + "&function_id=" + parent.parent.function_id + "&doc_type_code=" + doc_type_code + "&doc_no=" + doc_no + "&item_class_desc=" + item_class_desc + "&item_class_code=" + item_class_code;
}
//function name modified by suresh.r on 09-06-2014 against ML-BRU-SCF-1360
//function callItemSearchScreen() {
async function callItemSearchScreen_Main() {
	var search_string = "";
	parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	if (!document.formIssueReturnListHeader.item_desc.readOnly) {
		search_string = document.formIssueReturnListHeader.item_desc.value;
	}
	var fm_store_code = parent.parent.frameIssueReturnHeader.document.formIssueReturnHeader.from_store_code.value;
	var to_store_code = parent.parent.frameIssueReturnHeader.document.formIssueReturnHeader.to_store_code.value;
	var mode = parent.parent.frameIssueReturnHeader.document.formIssueReturnHeader.mode.value;
	var category = "A";
	var sole_source = "A";
	var ps_item = "A";
	var mfg_item = "A";
	var expiry = "A";
	var consignment = "A";

	//var item_class =parent.parent.frameIssueReturnHeader.document.formIssueReturnHeader.item_class_code.value;
	if (mode == 2) {
		var item_class = parent.parent.frameIssueReturnHeader.document.formIssueReturnHeader.item_class_code1.value;
		if (item_class == "null") {
			item_class = "";
		}
	} else {
		var item_class = parent.parent.frameIssueReturnHeader.document.formIssueReturnHeader.item_class_code.value;
	}
	//Modified by Sakti against AMS-CRF-0011 trn_type passing
	var retVal = await callItemSearchWindow(search_string, fm_store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment,"RET");
	if (retVal != null) {
		parent.parent.frameIssueReturnHeader.document.formIssueReturnHeader.store_code_disabled.value = "disabled";
		document.formIssueReturnListHeader.item_desc.value = retVal[1];
		document.getElementById('id_uom').innerHTML = "&nbsp;&nbsp;<b>" + retVal[15] + "</b>";
		document.formIssueReturnListHeader.item_desc.readOnly = true;
		document.formIssueReturnListHeader.ItemDetails.disabled = false;
		document.formIssueReturnListHeader.item_code.value = retVal[0];
		document.formIssueReturnListHeader.uom_code.value = retVal[13];
		document.formIssueReturnListHeader.uom_desc.value = retVal[15];
		document.getElementById('id_uom_base').innerHTML = "&nbsp;&nbsp;<b>" + retVal[25] + "</b>"; //Added against inc#50521 to display base UOM
		//document.formIssueReturnListHeader.item_unit_cost.value = retVal[14]; Comented against inc#50521 to display base unit cost from validate
		document.formIssueReturnListHeader.fm_store_code.value = fm_store_code;
		document.formIssueReturnListHeader.to_store_code.value = to_store_code;
		var formObj = document.formIssueReturnListHeader;
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/IssueReturnValidate.jsp?item_code=" + formObj.item_code.value + "&fm_store_code=" + fm_store_code + "&to_store_code=" + to_store_code + "&validate=GET_STATUS", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		//alert(responseText);
		eval(responseText);
		if (result) {
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/IssueReturnValidate.jsp?item_code=" + formObj.item_code.value + "&fm_store_code=" + fm_store_code + "&to_store_code=" + to_store_code + "&validate=MIN_MAX_STATUS", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			//alert(responseText);
			eval(responseText);
		}
		
		if (!result) {
			parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?";//num="+ getMessage(message,"ST");
			if (message == "PHY_INV_PROCESS_INITIATED") {
				alert(getMessage(message, "ST") + "\n" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + formObj.phy_inv_id.value);
			} else {
				alert(getMessage(message, "ST"));
			}
			refreshDetails();
		}else{
			document.formIssueReturnListHeader.item_qty.focus();
		}
		if (result && retVal[27] == "N") {
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/IssueReturnValidate.jsp?item_code=" + formObj.item_code.value + "&fm_store_code=" + fm_store_code + "&to_store_code=" + to_store_code+"&return_uom_code="+document.formIssueReturnListHeader.return_uom_code.value + "&validate=CONV_CALCULATE", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
		}
		
	}
	
}
function showPendingQty(pendingQty) {
	document.getElementById('id_uom').innerHTML = "&nbsp;&nbsp;<b>" + retVal[15] + "<b>";
	parent.frameIssueReturnListHeader.document.getElementById('pending_qty').innerHTML = "&nbsp;&nbsp;<b>" + pendingQty + "</b>";
	parent.frameIssueReturnListHeader.document.formIssueReturnListHeader.Max_Returnable_Qty.value = pendingQty;
	maxReturnableQuantity = pendingQty;
}
function noPendingQty() {
	alert(getMessage("MAX_RET_QTY_ZERO", "ST"));
	cancel_me();
}
function cancel_me() {
	parent.frameIssueReturnListHeader.location.href = "../../eST/jsp/IssueReturnListHeader.jsp";
	parent.frameIssueReturnListDetail.location.href = "../../eCommon/html/blank.html";
	//Added for GHL-CRF-0413 starts
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/IssueReturnValidate.jsp?validate=clearTmpBean", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	//Added for GHL-CRF-0413 ends
}
function ChackIssueQty(obj) {
	var trn_type=document.formIssueReturnListHeader.trn_type.value;// added for GHL-CRF-0464
	if (document.getElementById('pending_qty').innerHTML != "&nbsp;") {
		if (obj.value == "" && document.formIssueReturnListHeader.item_desc.value != "" && (parseInt(document.getElementById('pending_qty').innerText) != 0)) {
			alert(getMessage("RET_QTY_CANNOT_BLANK", "ST"));
			document.formIssueReturnListHeader.item_qty.focus();
			return false;
		} else {
			var penQty = document.getElementById('pending_qty').innerText;
			checkDoubleFormat(obj);
			var issQty = document.formIssueReturnListHeader.item_qty.value;
			if ((parseInt(issQty) > parseInt(penQty)) && (parseInt(penQty) != 0)) { //maxReturnableQuantity)){
			//	if(trn_type!="RET"&&trn_type!="SRT")//Added For GHL-CSt-0464 start removed for GHL-CSt-0464
				alert(getMessage("RET_QTY_NOT_GRT_MAX_RET_QTY", "ST"));
		//	else if(trn_type=="RET") removed for GHL-CSt-0464
		//		alert(getMessage("TFR_QTY_LESS_THAN_AVL_QTY_BARCODE", "ST"));//end GHL-SCF-0464 removed for GHL-CSt-0464
			//  document.formIssueReturnListHeader.item_qty.value="";
			//	document.formIssueReturnListHeader.item_qty.focus(); Commented against GHL-CRF-0464
				return false;
			}
			return true;
		}
	} else {
		return true;
	}
}
function checkLength() {
	var formObj = document.formIssueReturnListHeader;
	var remarks = getLabel("Common.remarks.label", "Common");
	if (!SPCheckMaxLen(remarks, formObj.remarks, 200)) {
		return false;
	}
	return true;
}
function validateForm() {
	var errorPage = "../../eCommon/jsp/error.jsp";
	var message = "";
	var formObj = f_query_add_mod.frameIssueReturnList.document.formIssueReturnListHeader;
	if (!checkLength1()) {
		message = "REMARKS_CHAR_EXCEEDS_LIMIT";
		messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
		return false;
	}
	return true;
}
function checkLength1() {
	var formObj = f_query_add_mod.frameIssueReturnListHeader.document.formIssueReturnListHeader;
	var remarks = getLabel("Common.remarks.label", "Common");
	if (!SPCheckMaxLen(remarks, formObj.remarks, 200)) {
		return false;
	}
	return true;
}
function onSuccess() {
	f_query_add_mod.location.href = "../../eCommon/html/blank.html";
//	messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ message+"<BR>"+flag;
	return;
}
async function apply() {
	if(f_query_add_mod.frameIssueReturnDetail==undefined){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	}
	var formObj = f_query_add_mod.frameIssueReturnDetail.document.formIssueReturnDetail;
	totalCBox = parseInt(formObj.total_checkboxes.value);
	var checkBoxObj = null;
	var forDeletion = "";
	var noDetailExists = true;
	var errorPage = "../../eCommon/jsp/error.jsp";
	for (i = 0; i < totalCBox; i++) {
		checkBoxObj = eval("formObj.checkbox" + i);
		if (checkBoxObj.checked) {
			forDeletion += ("Y,");
		} else {
			forDeletion += ("N,"); 
			noDetailExists = false;
		}
	}
	if (noDetailExists) {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("MIN_ONE_DETAIL_REQUIRED", "Common");
		return;
	}
	var formObj = f_query_add_mod.frameIssueReturnHeader.document.formIssueReturnHeader;
	  var locale = formObj.locale.value;
	  formObj.doc_date.value = convertDate(formObj.doc_date.value, "DMY", locale, "en");
	forDeletion = forDeletion.substring(0, forDeletion.length - 1);
	formObj.records_to_delete.value = forDeletion;
	finalizeType = "N";
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/IssueReturnValidate.jsp?validate=CHECK_FINALIZE_ALLOWED&fm_store_code=" + formObj.from_store_code.value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
		//alert(responseText);
	if (formObj.finalize_allowed_yn.value == "Y") {
		
		//added for SKR-CRF-0039 By Ganga on 5th Aug 2013
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		var xmlStr	="<root><SEARCH " ;
		xmlStr+=" function_type=\"2\" ";		
		xmlStr +=" /></root>" ; 
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?trn_type=" + formObj.trn_type.value + "&store_code="+formObj.from_store_code.value, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);		
		
		var response = "";
		//var response = confirmFinalize(); commented
		if(result){
			response = await confirmFinalize();	
		}else{
			response = YES;
		}
		//Added ends
		
		
		if(response=="")
		{
		messageFrame.location.href = errorPage + "?err_num=";
		return false;
		}
		if (response == YES) {
			formObj.finalized_yn.value = "Y";
		} else {
			formObj.finalized_yn.value = "N";
		}
	}
	var responseText = formApply(formObj, ST_CONTROLLER);
	eval(responseText);
	flag1 = (flag.split("~"))[0];
	flag2 = (flag.split("~"))[1];
	flag1 = (flag1 == "null" ? "" : flag1);
	if (result) {
		if (flag2 == "PY") {
				//  if(formObj.finalize_allowed_yn.value=="Y")
				  //{
			var PConfirm = await confirmPrinting();
			if (PConfirm == "Yes") {
				var xmlHttp = new XMLHttpRequest();
				var xmlDoc="";
				//xmlDoc.loadXML(getXMLString(null));
				xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
				//xmlHttp.open("POST", "../../eST/jsp/IssueReturnValidate.jsp?validate=printOnlineDoc&msg=" + encodeURIComponent(message), false);
				xmlHttp.open("POST", "../../eST/jsp/IssueReturnValidate.jsp?validate=printOnlineDoc&msg=" + encodeURIComponent(message), true);
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
				//xmlHttp.open("POST", "../../eST/jsp/IssueReturnValidate.jsp?validate=printOnlineDoc&msg=" + encodeURIComponent(message), false);
				xmlHttp.open("POST", "../../eST/jsp/IssueReturnValidate.jsp?validate=printOnlineDoc&msg=" + encodeURIComponent(message), true);
				xmlHttp.send(xmlDoc);
				//responseText = xmlHttp.responseText;
				//eval(responseText);
		}
		messageFrame.location.href = errorPage + "?err_num=" + message + "<BR>" + (result ? flag1 : "");
		onSuccess();
	}
	if (result) {
		messageFrame.location.href = errorPage + "?err_num=" + message + "<BR>" + flag1;
		f_query_add_mod.location.href = "../../eCommon/html/blank.html";
	} else {
		messageFrame.location.href = errorPage + "?err_num=" + message;
	}
	if (result) {
	} else {
		if (flag != "") {
			if (isNaN(flag)) {
				f_query_add_mod.frameIssueReturnDetail.location.href = "../../eST/jsp/IssueReturnDetail.jsp?function_id=" + function_id + "&item_code=" + flag;
			} else {
				f_query_add_mod.frameIssueReturnDetail.location.href = "../../eST/jsp/IssueReturnDetail.jsp?function_id=" + function_id + "&index=" + flag;
			}
		}
	}
}
async function callIssRetBatchSearch() {
	
 	
	 	
	
	if (parent.frameIssueReturnListDetail.document.formIssueReturnListDetail != null) {
		if (!confirm(getMessage("BATCH_REFRESHED", "ST"))) {
			return;
		}
	}
	var formObj = document.formIssueReturnListHeader;
	var fm_store_code = parent.parent.frameIssueReturnHeader.document.formIssueReturnHeader.from_store_code.value;
	var to_store_code = parent.parent.frameIssueReturnHeader.document.formIssueReturnHeader.to_store_code.value;
	var issue_doc_no = parent.parent.frameIssueReturnHeader.document.formIssueReturnHeader.issue_doc_no.value;
	var doc_type_code = parent.parent.frameIssueReturnHeader.document.formIssueReturnHeader.doc_type_code.value;
	var doc_no = parent.parent.frameIssueReturnHeader.document.formIssueReturnHeader.doc_no.value;
	var trn_type = parent.parent.frameIssueReturnHeader.document.formIssueReturnHeader.trn_type.value;
	var mode = parent.parent.frameIssueReturnHeader.document.formIssueReturnHeader.mode.value;//Added by suresh.r on 24-01-2014 against AMS-CRF-0054
	var _item_code = formObj.item_code.value;
	var item_qty = formObj.item_qty.value;
	var searchFunction = "Y";
	var multipleSelect = "Y";
	var batch_retval = "";
	var seq_no = formObj.seq_no.value;
 
	batch_retval = await callIssRetBatchSearchWindow(_item_code, fm_store_code, to_store_code, searchFunction, multipleSelect, issue_doc_no, doc_type_code, doc_no, trn_type,seq_no,mode);//mode Added by suresh.r on 24-01-2014 against AMS-CRF-0054
	if (batch_retval != null && batch_retval!="" && batch_retval!=undefined) {
		parent.frameIssueReturnListDetail.location.href = "../../eST/jsp/IssueReturnListDetail.jsp?function=search&fm_store_code=" + fm_store_code + "to_store_code=" + to_store_code + "&item_code=" + _item_code + "&item_qty=" + item_qty + "&index=" + formObj.index.value + "&function_id" + parent.parent.function_id;
	}
}
async function callIssRetBatchSearchWindow(item_code, fm_store_code, to_store_code, searchFunction, multipleSelect, issue_doc_no, doc_type_code, doc_no, trn_type,seq_no,mode) {//mode Added by suresh.r on 24-01-2014 against AMS-CRF-0054
	//retVal = window.showModalDialog("../jsp/BatchSearchIssueReturnFrame.jsp?item_code=" + item_code + "&fm_store_code=" + fm_store_code + "&to_store_code=" + to_store_code + "&searchFunction=" + searchFunction + "&multipleSelect=" + multipleSelect + "&issue_doc_no=" + issue_doc_no + "&doc_type_code=" + doc_type_code + "&doc_no=" + doc_no + "&trn_type=" + trn_type+"&seq_no="+seq_no, "", "dialogHeight:30; dialogWidth:50; center:0; status: no; dialogLeft :200; dialogTop :100;");
	//Added by suresh.r on 24-01-2014 against AMS-CRF-0054
	retVal = await window.showModalDialog("../jsp/BatchSearchIssueReturnFrame.jsp?item_code=" + item_code + "&fm_store_code=" + fm_store_code + "&to_store_code=" + to_store_code + "&searchFunction=" + searchFunction + "&multipleSelect=" + multipleSelect + "&issue_doc_no=" + issue_doc_no + "&doc_type_code=" + doc_type_code + "&doc_no=" + doc_no + "&trn_type=" + trn_type+"&seq_no="+seq_no+"&mode="+mode, "", "dialogHeight:90vh; dialogWidth:90vw; center:0; status: no; dialogLeft :200; dialogTop :100;");
	return retVal;
}
function editViewBatch() {
	var formObj = document.formIssueReturnListHeader;
	//need to check which store to pass
	var fm_store_code = parent.parent.frameIssueReturnHeader.document.formIssueReturnHeader.from_store_code.value;
	var to_store_code = parent.parent.frameIssueReturnHeader.document.formIssueReturnHeader.to_store_code.value;
	if (parent.frameIssueReturnListDetail.document.formIssueReturnListDetail != null) {
		if (!confirm(getMessage("BATCH_REFRESHED", "ST"))) {
			return;
		}
	}
	var arrayObject = new Array(formObj.item_code, formObj.item_qty);
	var names = new Array(getLabel("Common.item.label", "Common"), getLabel("Common.Quantity.label", "Common"));

	//var blankObject = checkSTFields(arrayObject, names, parent.parent.parent.messageFrame);
	var blankObject = checkSTFields(arrayObject, names, parent.parent.parent.messageFrame);
	if (blankObject == true) {
		var _item_code = formObj.item_code.value;
		var item_qty = formObj.ret_qty.value;
		parent.frameIssueReturnListDetail.location.href = "../../eST/jsp/IssueReturnListDetail.jsp?function=edit&fm_store_code=" + fm_store_code + "&to_store_code=" + to_store_code + "&item_code=" + _item_code + "&item_qty=" + item_qty + "&index=" + formObj.index.value + "&function_id" + parent.parent.function_id + "&tmp_conv=" + formObj.tmp_conv.value;
	}
}
function checkBatchQty(obj, available_qty) {

	if(document.formIssueReturnListDetail.dec_allowed_yn.value=="Y"){
		if (checkDoubleFormat(obj)) {
			if (parseFloat(available_qty) < parseFloat(obj.value)) {
				//added for GHL-CRF-0464 start
							alert(getMessage("TFR_QTY_LESS_THAN_AVL_QTY_BARCODE", "ST"));
							obj.value=available_qty; // End GHL-CRF-0464
								obj.focus();
			}
		}
	}else{
		if (checkIntegerFormat(obj)) {
			if (parseFloat(available_qty) < parseFloat(obj.value)) {

				//added for GHL-CRF-0464 start
					alert(getMessage("TFR_QTY_LESS_THAN_AVL_QTY_BARCODE", "ST"));
					obj.value=available_qty;// End GHL-CRF-0464
							obj.focus();
			}
		}
	}
}
//Added against GHL-CRF-0413 starts
function addToListforBarcode() {
	var formObj = parent.frameIssueReturnListHeader.document.formIssueReturnListHeader;
	var arrayObject = new Array(formObj.item_code, formObj.item_qty);
	var names = new Array(getLabel("Common.item.label", "Common"), getLabel("Common.Quantity.label", "Common"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.parent.messageFrame);
	if(parent.frameIssueReturnListDetail.document.formIssueReturnListDetail != undefined) {
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/IssueReturnValidate.jsp?doc_srl_no_forbean=" + parent.frames[1].document.forms[0].doc_srl_no_forbean.value + "&item_code="+formObj.item_code.value+"&barcode="+formObj.barcode.value+ "&validate=SET_IN_BEAN_RET", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
	}
	if (blankObject == true) {
		/* If EDIT/VIEW is clicked CODE to be executed Start here*/

	//	formObj.apply.disabled=true;
		if (parent.frameIssueReturnListDetail.document.formIssueReturnListDetail == null) {
			var formObj = document.formIssueReturnListHeader;
			var fm_store_code = parent.parent.frameIssueReturnHeader.document.formIssueReturnHeader.from_store_code.value;
			var to_store_code = parent.parent.frameIssueReturnHeader.document.formIssueReturnHeader.to_store_code.value;
			var _item_code = formObj.item_code.value;
			var item_qty = eval((formObj.item_qty.value) * (formObj.frm_tmp_conv.value));
			parent.frameIssueReturnListDetail.location.href = "../../eST/jsp/IssueReturnListDetail.jsp?function=edit&fm_store_code=" + fm_store_code + "&to_store_code=" + to_store_code + "&item_code=" + _item_code + "&item_qty=" + item_qty + "&index=" + formObj.index.value + "&function_id" + parent.parent.function_id + "&addToList=true" + "&tmp_conv=" + formObj.tmp_conv.value + "&frm_store_uom_desc=" + formObj.frm_store_uom_desc.value + "&to_store_uom_desc=" + formObj.to_store_uom_desc.value;
			/*
   		   var errorPage	 = "../../eCommon/jsp/error.jsp"
           parent.parent.parent.messageFrame.location.href = errorPage+"?err_num="+ getMessage("BATCH_RECORD_NOT_FOUND");
            */
			parent.parent.frameIssueReturnHeader.document.formIssueReturnHeader.preview.disabled = false;
			return;
		}
		/* If EDIT/VIEW is clicled CODE to be executed Ends here*/
		parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
		var formObjDtl = parent.parent.frameIssueReturnList.frameIssueReturnListDetail.document.formIssueReturnListDetail;
		var doc_srl_no_forbean = formObjDtl.doc_srl_no_forbean.value;//Added against GHL-CRF-0413.3 
		var proceed = false;
		var messageFrame = parent.parent.messageFrame;
		var errorPage = "../../eCommon/jsp/error.jsp";
		var frm_tmp_conv =1.0; 
		var item_qty = formObj.ret_qty.value * frm_tmp_conv;//Modified for IN073577
		_total_checkboxes = formObjDtl.total_checkboxes.value;
		var sum = 0;
		for (i = 0; i < _total_checkboxes; i++) {
			var qty = eval("formObjDtl.item_qty_" + i).value;
			if (qty == "") {
				qty = 0;
			}
			if (!isNaN(qty)) {
				sum += parseFloat(qty);
			}
		}
		var dec_allowed_yn=	formObj.dec_allowed_yn.value;
		var no_of_decimals=formObj.no_of_decimals.value;
		if(dec_allowed_yn=="Y"){
			item_qty=item_qty.toFixed(no_of_decimals);
			sum=sum.toFixed(no_of_decimals);
		}else{
			item_qty=item_qty.toFixed(0);
			sum=sum.toFixed(0);
		}
		if (sum != item_qty) {
			alert(getMessage("QUANTIY_MUST_BE_EQUAL", "ST"));
			formObj.apply.disabled = false;
			return;
		}
		for (i = 0; i < _total_checkboxes; i++) {
			var bin_location_name = "bin_location_code_" + i;
			var bin_location_code = eval("formObjDtl.to_bin_location_code_" + i).value;
			if (bin_location_code == "") {
				alert(getMessage("BIN_LOCN_NOT_BLANK", "ST"));
				eval("formObjDtl.to_bin_location_code_" + i).focus();
				formObj.apply.disabled = false;
				return;
			}
		}
		ComputeCost();
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		/*
		if (formObj.stock_item_yn.value=='Y') {
			xmlDoc.loadXML(getEnhancedXMLString(formObjDtl));
		}
		else{
			xmlDoc.loadXML(getXMLString(null));
		} */
		//xmlDoc.loadXML(getEnhancedXMLString(formObjDtl));
		xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObjDtl), "text/xml");
		/**
			* @Name - Priya 
			* @Date - 18/12/2009
			* @Inc# - IN017176
			* @Desc - To Display the character ® properly in Item desc without junck characters
			* added 'encodeURIComponent(formObj.item_desc.value,"UTF-8")' in the next line code
			*/
			xmlHttp.open("POST", "../../eST/jsp/IssueReturnValidate.jsp?index=" + formObj.index.value +"&seq_no="+parent.frames[0].document.forms[0].seq_no.value+ "&doc_srl_no_forbean="+doc_srl_no_forbean+"&site="+formObj.site.value+"&doc_srl_no=" + formObj.doc_srl_no.value + "&fm_store_code=" + formObj.fm_store_code + "&to_store_code=" + formObj.to_store_code + "&item_code=" + formObj.item_code.value  + "&item_qty=" + formObj.item_qty.value + "&uom_code=" + formObj.uom_code.value + "&item_unit_cost=" + formObj.item_unit_cost.value + "&item_unit_cost_org=" + formObj.item_unit_cost_org.value + "&item_cost_value=" + parent.frames[0].document.forms[0].item_qty.value * parent.frames[0].document.forms[0].item_unit_cost.value + "&Max_Returnable_Qty=" + formObj.Max_Returnable_Qty.value + "&remarks=" + encodeURIComponent(formObj.remarks.value) + "&uom_desc=" + document.getElementById('id_uom').innerText + "&stock_available=" + document.getElementById('pending_qty').innerText + "&frm_store_qty_on_hand=" + formObj.frm_store_qty_on_hand.value + "&frm_store_min_stk_level=" + formObj.frm_store_min_stk_level.value + "&frm_store_max_stk_level=" + formObj.frm_store_max_stk_level.value + "&frm_store_reorder_level=" + formObj.frm_store_reorder_level.value + "&to_store_qty_on_hand=" + formObj.to_store_qty_on_hand.value + "&to_store_min_stk_level=" + formObj.to_store_min_stk_level.value + "&to_store_max_stk_level=" + formObj.to_store_max_stk_level.value + "&to_store_reorder_level=" + formObj.to_store_reorder_level.value + "&validate=ADD_TO_LIST" + "&to_conv_fact=" + formObj.tmp_conv.value + "&frm_conv_fact=" + formObj.frm_tmp_conv.value + "&batch_records=" + formObjDtl.total_checkboxes.value + "&stock_uom=" + document.getElementById('id_uom').innerText+"&remarks_code=" + escape(formObj.remarks_code.value)+"&from_multiples="+formObj.from_multiples.value+"&to_multiples="+formObj.to_multiples.value+"&batch_multiples="+formObj.batch_multiples.value+"&issue_uom_multiples="+formObj.issue_uom_multiples.value+ "&item_desc=" + encodeURIComponent(formObj.item_desc.value,"UTF-8") +"&uom_desc_base=" + document.getElementById('id_uom_base').innerText, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if (result) {
			refreshDetails(formObj.index.value);
			parent.parent.frameIssueReturnHeader.document.formIssueReturnHeader.preview.disabled = false;
		} else {
			formObj.apply.disabled = false;
			parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
			parent.frameIssueReturnListDetail.location.href = "../../eCommon/html/blank.html";
		}
	}
}
//Added against GHL-CRF-0413 ends
function addToList(){
	var formObj = parent.frameIssueReturnListHeader.document.formIssueReturnListHeader;
	var arrayObject = new Array(formObj.item_code, formObj.item_qty);
	var names = new Array(getLabel("Common.item.label", "Common"), getLabel("Common.Quantity.label", "Common"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.parent.messageFrame);
	if (blankObject == true) {
		/* If EDIT/VIEW is clicked CODE to be executed Start here*/
	//	formObj.apply.disabled=true;
		if (parent.frameIssueReturnListDetail.document.formIssueReturnListDetail == null) {
			var formObj = document.formIssueReturnListHeader;
			var fm_store_code = parent.parent.frameIssueReturnHeader.document.formIssueReturnHeader.from_store_code.value;
			var to_store_code = parent.parent.frameIssueReturnHeader.document.formIssueReturnHeader.to_store_code.value;
			var _item_code = formObj.item_code.value;
			var item_qty = eval((formObj.item_qty.value) * (formObj.frm_tmp_conv.value));
			parent.frameIssueReturnListDetail.location.href = "../../eST/jsp/IssueReturnListDetail.jsp?function=edit&fm_store_code=" + fm_store_code + "&to_store_code=" + to_store_code + "&item_code=" + _item_code + "&item_qty=" + item_qty + "&index=" + formObj.index.value + "&function_id" + parent.parent.function_id + "&addToList=true" + "&tmp_conv=" + formObj.tmp_conv.value + "&frm_store_uom_desc=" + formObj.frm_store_uom_desc.value + "&to_store_uom_desc=" + formObj.to_store_uom_desc.value;
			/*
   		   var errorPage	 = "../../eCommon/jsp/error.jsp"
           parent.parent.parent.messageFrame.location.href = errorPage+"?err_num="+ getMessage("BATCH_RECORD_NOT_FOUND");
            */
			parent.parent.frameIssueReturnHeader.document.formIssueReturnHeader.preview.disabled = false;
			return;
		}
		/* If EDIT/VIEW is clicled CODE to be executed Ends here*/
		parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
		var formObjDtl = parent.parent.frameIssueReturnList.frameIssueReturnListDetail.document.formIssueReturnListDetail;
		var proceed = false;
		var messageFrame = parent.parent.messageFrame;
		var errorPage = "../../eCommon/jsp/error.jsp";
		var item_qty = formObj.item_qty.value * formObj.frm_tmp_conv.value;
		_total_checkboxes = formObjDtl.total_checkboxes.value;
		var sum = 0;
		for (i = 0; i < _total_checkboxes; i++) {
			var qty = eval("formObjDtl.item_qty_" + i).value;
			if (qty == "") {
				qty = 0;
			}
			if (!isNaN(qty)) {
				sum += parseFloat(qty);
			}
		}
		var dec_allowed_yn=	formObj.dec_allowed_yn.value;
		var no_of_decimals=formObj.no_of_decimals.value;
		if(dec_allowed_yn=="Y"){
			item_qty=item_qty.toFixed(no_of_decimals);
			sum=sum.toFixed(no_of_decimals);
		}else{
			item_qty=item_qty.toFixed(0);
			sum=sum.toFixed(0);
		}
		if (sum != item_qty) {
			alert(getMessage("QUANTIY_MUST_BE_EQUAL", "ST"));
			formObj.apply.disabled = false;
			return;
		}
		for (i = 0; i < _total_checkboxes; i++) {
			var bin_location_name = "bin_location_code_" + i;
			var bin_location_code = eval("formObjDtl.to_bin_location_code_" + i).value;
			if (bin_location_code == "") {
				alert(getMessage("BIN_LOCN_NOT_BLANK", "ST"));
				eval("formObjDtl.to_bin_location_code_" + i).focus();
				formObj.apply.disabled = false;
				return;
			}
		}
		ComputeCost();
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		/*
		if (formObj.stock_item_yn.value=='Y') {
			xmlDoc.loadXML(getEnhancedXMLString(formObjDtl));
		}
		else{
			xmlDoc.loadXML(getXMLString(null));
		} */
		//xmlDoc.loadXML(getEnhancedXMLString(formObjDtl));
		xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObjDtl), "text/xml");
		/**
			* @Name - Priya 
			* @Date - 18/12/2009
			* @Inc# - IN017176
			* @Desc - To Display the character ® properly in Item desc without junck characters
			* added 'encodeURIComponent(formObj.item_desc.value,"UTF-8")' in the next line code
			*/
		xmlHttp.open("POST", "../../eST/jsp/IssueReturnValidate.jsp?index=" + formObj.index.value + "&site="+formObj.site.value+"&doc_srl_no=" + formObj.doc_srl_no.value + "&fm_store_code=" + formObj.fm_store_code + "&to_store_code=" + formObj.to_store_code + "&item_code=" + formObj.item_code.value  + "&item_qty=" + formObj.item_qty.value + "&uom_code=" + formObj.uom_code.value + "&item_unit_cost=" + formObj.item_unit_cost.value + "&item_unit_cost_org=" + formObj.item_unit_cost_org.value + "&item_cost_value=" + formObj.item_cost_value.value + "&Max_Returnable_Qty=" + formObj.Max_Returnable_Qty.value + "&remarks=" + encodeURIComponent(formObj.remarks.value) + "&uom_desc=" + document.getElementById('id_uom').innerText + "&stock_available=" + document.getElementById('pending_qty').innerText + "&frm_store_qty_on_hand=" + formObj.frm_store_qty_on_hand.value + "&frm_store_min_stk_level=" + formObj.frm_store_min_stk_level.value + "&frm_store_max_stk_level=" + formObj.frm_store_max_stk_level.value + "&frm_store_reorder_level=" + formObj.frm_store_reorder_level.value + "&to_store_qty_on_hand=" + formObj.to_store_qty_on_hand.value + "&to_store_min_stk_level=" + formObj.to_store_min_stk_level.value + "&to_store_max_stk_level=" + formObj.to_store_max_stk_level.value + "&to_store_reorder_level=" + formObj.to_store_reorder_level.value + "&validate=ADD_TO_LIST" + "&to_conv_fact=" + formObj.tmp_conv.value + "&frm_conv_fact=" + formObj.frm_tmp_conv.value + "&batch_records=" + formObjDtl.total_checkboxes.value + "&stock_uom=" + document.getElementById('id_uom').innerText+"&remarks_code=" + escape(formObj.remarks_code.value)+"&from_multiples="+formObj.from_multiples.value+"&to_multiples="+formObj.to_multiples.value+"&batch_multiples="+formObj.batch_multiples.value+"&issue_uom_multiples="+formObj.issue_uom_multiples.value+ "&item_desc=" + encodeURIComponent(formObj.item_desc.value,"UTF-8") +"&uom_desc_base=" + document.getElementById('id_uom_base').innerText, false);//Added Site against GHL-CRF-0413
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		//alert(responseText);
		eval(responseText);
		if (result) {
			refreshDetails(formObj.index.value);
			parent.parent.frameIssueReturnHeader.document.formIssueReturnHeader.preview.disabled = false;
		} else {
			formObj.apply.disabled = false;
			parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
			parent.frameIssueReturnListDetail.location.href = "../../eCommon/html/blank.html";
		}
	}
}
function refreshDetails(index) {
   //parent.parent.frameIssueReturnDetail.location.reload();
	var formObj = parent.frameIssueReturnListHeader.document.formIssueReturnListHeader;
	var fm_store_code = parent.parent.frameIssueReturnHeader.document.formIssueReturnHeader.from_store_code.value;
	parent.parent.frameIssueReturnDetail.location.href = "../../eST/jsp/IssueReturnDetail.jsp?index=" + index + "&tmp_conv=" + formObj.tmp_conv.value + "&frm_tmp_conv=" + formObj.frm_tmp_conv.value + "&ret_qty=" + formObj.ret_qty.value + "&store_code=" + fm_store_code;
	parent.frameIssueReturnListHeader.location.href = "../../eST/jsp/IssueReturnListHeader.jsp";
	parent.frameIssueReturnListDetail.location.href = "../../eCommon/html/blank.html";
    //parent.parent.frameIssueReturnDetail.location.reload();
}
/*function refreshDetails(){
	//parent.parent.frameIssueReturnDetail.location.href="../../eST/jsp/IssueReturnDetail.jsp?";
	parent.frameIssueReturnListHeader.location.href='../../eST/jsp/IssueReturnListHeader.jsp';
	parent.frameIssueReturnListDetail.location.href='../../eCommon/html/blank.html';
}*/
function ComputeCost() {
	var quantity = document.formIssueReturnListHeader.ret_qty.value;
	var unit_cost = document.formIssueReturnListHeader.item_unit_cost_org.value;
	
	var no_of_decimals_for_cost = document.formIssueReturnListHeader.no_of_decimals_for_cost.value;
	if (isNaN(quantity) || isNaN(unit_cost)) {
		cost_value = "";
		return;
	}
	//cost_value = setNumber(quantity * unit_cost, no_of_decimals_for_cost);
	cost_value = (eval(quantity)/eval(document.formIssueReturnListHeader.frm_tmp_conv.value)) * unit_cost;
	document.formIssueReturnListHeader.item_cost_value.value = setNumber(cost_value, no_of_decimals_for_cost);
	
}
function stock_item_check() {
	alert(getMessage("NOT_STOCK_ITEM", "ST"));
	document.formIssueReturnListHeader.item_desc.value = "";
	document.getElementById('id_uom').innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	document.formIssueReturnListHeader.item_desc.readOnly = false;
	document.formIssueReturnListHeader.item_code.value = "";
	document.formIssueReturnListHeader.uom_code.value = "";
	document.formIssueReturnListHeader.item_unit_cost.value = "";
}
function modifyData(index) {
	var formObj = document.formIssueReturnDetail;
	var to_store_code = parent.frameIssueReturnHeader.document.formIssueReturnHeader.to_store_code.value;
	var fm_store_code = parent.frameIssueReturnHeader.document.formIssueReturnHeader.from_store_code.value;
	var trObject = eval(document.getElementById('tr_' + index));
	changeRowColor(trObject);
	parent.frameIssueReturnList.location.href = "../../eST/jsp/IssueReturnListFrame.jsp?function=modify&index=" + index + "&function_id" + parent.parent.function_id + "&to_store_code=" + to_store_code + "&fm_store_code=" + fm_store_code + "&ret_qty=" + formObj.ret_qty.value;
}
function setFinalize_allowed(_finalize_allowed_yn) {
	f_query_add_mod.frameIssueReturnHeader.document.formIssueReturnHeader.finalize_allowed_yn.value = _finalize_allowed_yn;
}
function changeRowColor(obj) {
	tot = document.forms[0].total_checkboxes.value;
	tot = tot - 1;
	if (prevObj != null) {
		for (k = 0; k < 2; k++) {
			prevObj.cells[k].className = prevColor;
		}
	}
	prevObj = obj;
	prevColor = obj.cells[1].className;
	for (k = 0; k < 2; k++) {
		obj.cells[k].className = "STLIGHTPINK";
	}
}
async function previewDetails() {
	var from_store_code = document.formIssueReturnHeader.from_store_code.value;
	var to_store_code = document.formIssueReturnHeader.to_store_code.value;
	var doc_type_code = document.formIssueReturnHeader.doc_type_code.value;
	var doc_date = document.formIssueReturnHeader.doc_date.value;
	var doc_ref = document.formIssueReturnHeader.doc_ref.value;
	var mode = document.formIssueReturnHeader.mode.value;
	var item_class_desc = document.formIssueReturnHeader.item_class_desc1.value;
	if (mode == 2) {
		var item_class_code = document.formIssueReturnHeader.item_class_code1.value;
	} else {
		var item_class_code = document.formIssueReturnHeader.item_class_code.value;
	}
	if (item_class_code == "null") {
		item_class_desc = "";
		item_class_code = "";
	}
	var retVal = "";
	var dialogHeight = "80vh";
	var dialogWidth = "80vw";
	var dialogTop = "100";
	var center = "1";
	var status = "no";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments = "";
	var url = "../../eST/jsp/IssueReturnPreviewDetails.jsp?from_store_code=" + from_store_code + "&doc_type_code=" + doc_type_code + "&to_store_code=" + to_store_code + "&doc_date=" + doc_date + "&doc_ref=" + doc_ref + "&item_class_code=" + item_class_code + "&item_class_desc=" + item_class_desc;
	retVal = await window.showModalDialog(url, arguments, features);
}
function checkminmaxstatus() {
	var formObj = document.formIssueReturnListHeader;
	if ((parseInt(formObj.frm_store_qty_on_hand.value) - parseInt(formObj.item_qty.value)) < parseInt(formObj.frm_store_min_stk_level.value)) {
		alert(getLabel("eST.BelowMinStkinFromStore.label", "ST")); //Below Min Stock Level in From Store
	}
	if ((parseInt(formObj.to_store_qty_on_hand.value) + parseInt(formObj.item_qty.value)) > parseInt(formObj.to_store_max_stk_level.value)) {
		alert(getLabel("eST.ExceedsMaxStkinToStore.label", "ST")); //Exceeds Max Stock Level in To Store
	}
}
function checkSTFields(fields, names, messageFrame) {
	var errors = "";
	for (var i = 0; i < fields.length; i++) {
		if (trimCheck(fields[i].value)) 
			fields[i].value = trimString(fields[i].value);
		else
			errors += getSTMessage("SHOULD_NOT_BE_BLANK", "Common", new Array(names[i])) + "<br>";
	}
	if (errors.length != 0) {
		messageFrame.document.location.href = "../../eCommon/jsp/error.jsp?err_num=" + errors;
		return false;
	}
	return true;
}
function getSTMessage(message_ref, moduleId, param) {
	if (param == null)
		param = new Array();

	var xmlHttp;
	if (navigator.appName.indexOf("Internet") == -1) {
		xmlHttp = new XMLHttpRequest();
	} else {
		//xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		xmlHttp = new XMLHttpRequest();
	}
	message_ref = message_ref.toUpperCase();
	moduleId = moduleId.toLowerCase();
	var urlString = "?msgId=" + message_ref + "&moduleId=" + moduleId;
	for (var i = 1; i <= param.length; i++) {
		urlString += "&" + i + "=" + param[i - 1];
	}
	xmlHttp.open("POST", "../../eCommon/jsp/MessageContainer.jsp" + urlString, false);
	xmlHttp.setRequestHeader("Content-Type", "text/html;charset=UTF-8");
	xmlHttp.send();
	var xmlText = xmlHttp.responseText;
	return (xmlHttp.responseText);
}
function issueUOMQtyChk() {
	var formObj = document.formIssueReturnListHeader;
	if(formObj.dec_allowed_yn.value=="N"){
		return true;
	}
	toConvFactor();
	if(formObj.dec_allowed_yn.value=="N"){
	var conv_factor = lcm(formObj.frm_tmp_conv.value, formObj.tmp_conv.value);
	var dec_factor = (formObj.ret_qty.value) % (conv_factor);
	if (dec_factor > 0 && conv_factor > 1) {
		alert("Quantity Should Be In Multiples Of " + conv_factor);
		return false;
	}else {
		return true;
	}
	}
	return true;
}
/*function issueUOMQtyChk() {
	var formObj = document.formIssueReturnListHeader;
	toConvFactor();
	var dec_factor = ((formObj.ret_qty.value)) % (formObj.tmp_conv.value);
	if (dec_factor > 0) {
		alert("Quantity Should Be In Multiples Of " + formObj.tmp_conv.value);
		return false;
	} else {
		return true;
	}
}*/
function setTempConvFactor(tmp) {
	
	if (document.formIssueReturnListHeader == null) {
		parent.frames[2].frames[0].document.formIssueReturnListHeader.tmp_conv.value = tmp;
	} else {
		document.formIssueReturnListHeader.tmp_conv.value = tmp;
	}
}
function setFromTempConvFactor(frm_tmp) {
	if (document.formIssueReturnListHeader == null) {
		parent.frames[2].frames[0].document.formIssueReturnListHeader.frm_tmp_conv.value = frm_tmp;
	} else {
		document.formIssueReturnListHeader.frm_tmp_conv.value = frm_tmp;
	}
}
function toConvFactor() {
	var formObj = document.formIssueReturnListHeader;
	var item_code = "";
	if (formObj == null) {
		formObj = parent.frames[2].frames[0].document.formIssueReturnListHeader;
		var to_store_code = parent.frameIssueReturnHeader.document.formIssueReturnHeader.to_store_code.value;
		var fm_store_code = parent.frameIssueReturnHeader.document.formIssueReturnHeader.from_store_code.value;
	} else {
		var to_store_code = parent.parent.frameIssueReturnHeader.document.formIssueReturnHeader.to_store_code.value;
		var fm_store_code = parent.parent.frameIssueReturnHeader.document.formIssueReturnHeader.from_store_code.value;
		item_code = formObj.item_code.value;//Added by suresh.r on 24-01-2014 against AMS-CRF-0054
	}
	//item_code = formObj.item_code.value;//Commented by suresh.r on 24-01-2014 against AMS-CRF-0054
	if (parent.frameIssueReturnDetail != null) {
		var formObj1 = parent.frameIssueReturnDetail.document.formIssueReturnDetail;
		item_code = formObj1.item_code.value;
	}
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/IssueReturnValidate.jsp?validate=setToConv" + "&to_store_code=" + to_store_code + "&fm_store_code=" + fm_store_code + "&item_code=" + item_code, false);
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
//	alert(responseText);
	eval(responseText);

}
function totalqty() {
	var formObj = document.formIssueReturnListHeader;
	if (formObj == null && formObj.item_qty.value != "") {
		formObj = parent.frames[2].frames[0].document.formIssueReturnListHeader;
	}
	if(formObj.dec_allowed_yn.value=="N"){
		if (formObj.item_qty.value != "") {
			if(formObj.item_qty.value%formObj.from_multiples.value !=0){//Modified for IN073577
				alert("Return Qty Should Be In Multiples Of "+formObj.from_multiples.value);//Modified for IN073577
				formObj.item_qty.focus();
				formObj.ret_qty.value = "";
			}else{
				
				formObj.ret_qty.value = (formObj.item_qty.value*formObj.batch_multiples.value) / formObj.from_multiples.value;//Modified for IN073577
			}
		}
	}else{
		toConvFactor();
		if(formObj.item_qty.value != ""){
			formObj.ret_qty.value = (formObj.item_qty.value * formObj.frm_tmp_conv.value).toFixed(formObj.no_of_decimals.value);
		}
	}
}
function populateToStoresInQuery(request_by_store) {
	if (request_by_store.value == "") {
		clearListItems("document.forms[0].to_store");
		return;
	}
	clearListItems("document.forms[0].to_store");
	var arrayObject = new Array();
	arrayObject[0] = request_by_store;
	var frmObject = parent.frames[0].document.forms[0];
	bean_id = frmObject.bean_id.value;
	bean_name = frmObject.bean_name.value;
	//xmlDom = new ActiveXObject("Microsoft.XMLDom");
	//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	xmlHttp = new XMLHttpRequest();	
	xmlDom = "";
	xmlStr = getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/IssueReturnValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&request_by_store=" + request_by_store.value + "&validate=POPULATE_TO_STORES", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	//alert(responseText);
	eval(responseText);
}
function dispMess(id) {
	alert(getMessage("PHY_INV_PROCESS_INITIATED", "ST") + "\n" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + id);
}
async function ItemDetail() {
	var frmObj = document.formIssueReturnListHeader;
	var store_code = parent.parent.frameIssueReturnHeader.document.formIssueReturnHeader.from_store_code.value;
	var to_store_code = parent.parent.frameIssueReturnHeader.document.formIssueReturnHeader.to_store_code.value;
	await window.showModalDialog("../../eST/jsp/MinMaxItemDetails.jsp?item_desc=" + encodeURIComponent(frmObj.item_desc.value ) + "&fm_store_code=" + store_code + "&to_store_code=" + to_store_code + "&item_code=" + frmObj.item_code.value, "", "dialogHeight:90vh; dialogWidth:100vw; center:0; status: no; dialogLeft :100; dialogTop :100; scroll: no");
}
function LoadDocNo(obj) {
	//Added By Ramana CV For the LookUp
	// Comented by sakti against HSA-CRF-0171 to enable always to issue_doc_no_search button Inc# 48543
	/*if(obj.value!="")
	document.formIssueReturnHeader.issue_doc_no_search.disabled=false;
	else
		document.formIssueReturnHeader.issue_doc_no_search.disabled=true;*/
	if(document.formIssueReturnHeader.issue_doc_no.value!=""){
		var xmlHttp = new XMLHttpRequest(); 
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/IssueReturnValidate.jsp?validate=CLEAR_DATA", false);
		xmlHttp.send(xmlDoc);
		var responseText = xmlHttp.responseText;
		//alert(responseText);
		eval(responseText);
		document.formIssueReturnHeader.issue_doc_no.value = "";
		parent.parent.f_query_add_mod.frameIssueReturnDetail.location.href="../../eST/jsp/IssueReturnDetail.jsp";
		parent.parent.f_query_add_mod.frameIssueReturnList.location.href="../../eST/jsp/IssueReturnListFrame.jsp";
	}
}

function cancelData()
{
document.formIssueDocNoSearchCriteria.item_desc.value="";
document.formIssueDocNoSearchCriteria.item_code.value="";
document.formIssueDocNoSearchCriteria.doc_no.value="";
//document.formIssueDocNoSearchCriteria.frm_doc_date.value="";
//document.formIssueDocNoSearchCriteria.to_doc_date.value="";
//parent.IssueDocNoSearchResultFrame.location.href = "../../eCommon/html/blank.html";
document.formIssueDocNoSearchCriteria.item_desc.readOnly=false;
document.formIssueDocNoSearchCriteria.submit();
}


function Modify_doc(doc_no,seq_no,facility_id,doc_type) // doc_type new parameter Added by sakti against HSA-CRF-0171 to get the same from the opened window after close Inc# 48543
{
	 //doc_no = obj;
	if(doc_no.length>0)
	{
   	//returnValue=doc_no+"~"+seq_no+"~"+facility_id;
	returnValue=doc_no+"~"+seq_no+"~"+facility_id+"~"+doc_type; //Added doc_type to return the same value against HSA-CRF-0171 Inc# 48543
	parent.window.close();
	}

}
async function IssueDocSearch(obj)
{
var retVal = await window.showModalDialog("../../eST/jsp/IssueReturnDocNoSearch.jsp?function_id="+function_id +  "&doc_type_code="+obj.value + "&fm_store_code=" + document.formIssueReturnHeader.from_store_code.value+"&to_store_code=" + document.formIssueReturnHeader.to_store_code.value+"&item_class="+document.formIssueReturnHeader.item_class_code.value, "", "dialogHeight:100vh; dialogWidth:70vw; center:0; status: no; dialogLeft :20; dialogTop :110;")

	if(retVal!=undefined)
	{
		doc_no = (retVal.split("~"))[0];
		seq_no = (retVal.split("~"))[1];
		facility_id = (retVal.split("~"))[2];
		doc_type = (retVal.split("~"))[3]; //Added against HSA-CRF-0171 to separate doc_type from the returned value  Inc# 48543

		document.formIssueReturnHeader.issue_doc_no.value=doc_no;
		document.formIssueReturnHeader.issue_doc_type.value = doc_type; //Added against HSA-CRF-0171 to set default select doc_type Inc# 48543
 
		LoadDetailPage(document.formIssueReturnHeader.issue_doc_no,seq_no,facility_id);
	}
}
async function callItemSearchScreen(obj)
{

	var search_string = "";
	
	if (!document.formIssueDocNoSearchCriteria.item_desc.readOnly) {
		search_string = document.formIssueDocNoSearchCriteria.item_desc.value;
	}
	var fm_store_code = document.formIssueDocNoSearchCriteria.frm_store_code.value;
	//var to_store_code = document.formIssueDocNoSearchCriteria.to_store_code.value;
	//var mode = parent.parent.frameIssueReturnHeader.document.formIssueReturnHeader.mode.value;
	var item_class = document.formIssueDocNoSearchCriteria.item_class.value;
	var category = "A";
	var sole_source = "A";
	var ps_item = "A";
	var mfg_item = "A";
	var expiry = "A";
	var consignment = "A";

	//Modified by Sakti against AMS-CRF-0011 trn_type passing
	var retVal = await callItemSearchWindow(search_string, fm_store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment,"RET");
	if (retVal != null) {
	document.formIssueDocNoSearchCriteria.item_desc.value = retVal[1];
	document.formIssueDocNoSearchCriteria.item_desc.readOnly = true;
	document.formIssueDocNoSearchCriteria.item_code.value = retVal[0];
		}
	
}

function LoadDetailPage(obj,seq_no,facility_id) {

	var xmlHttp = new XMLHttpRequest();
	var xmlDoc	= "";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/IssueReturnValidate.jsp?validate=LOAD_DETAILS" + "&issue_doc_type_code=" + document.formIssueReturnHeader.issue_doc_type.value + "&doc_no=" + obj.value + "&to_store_code=" + document.formIssueReturnHeader.to_store_code.value + "&fm_store_code=" + document.formIssueReturnHeader.from_store_code.value+"&seq_no="+seq_no+"&facility_id="+facility_id, false);
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	eval(responseText);
	if (result) {
		parent.frameIssueReturnDetail.location.href = "../../eST/jsp/IssueReturnDetail.jsp?to_store_code=" + document.formIssueReturnHeader.to_store_code.value + "&fm_store_code=" + document.formIssueReturnHeader.from_store_code.value;
		parent.frameIssueReturnList.location.href = "../../eST/jsp/IssueReturnListFrame.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
		document.formIssueReturnHeader.preview.disabled = false;
	}
}
async function searchRemarks(objCode, objDesc) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.formIssueReturnListHeader.lang_id.value;
	dataTypeArray[0] = STRING;
	dataNameArray[1] = "module_id";
	dataValueArray[1] = "ST";
	dataTypeArray[1] = STRING;
	dataNameArray[2] = "trn_type";
	dataValueArray[2] = document.formIssueReturnListHeader.rem_trans_type.value;
	dataTypeArray[2] = STRING;
	argumentArray[0] = document.formIssueReturnListHeader.SQL_ST_TRN_REMARKS_LOOKUP_SELECT.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "4,5";
	argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.remarks.label", "Common"), argumentArray);
	/*if ((returnedValues != null) && (returnedValues != "")) {
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
	}*/
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

function doDateCheckLocal(from, to) {
	var fromdate = from.value;
	var todate = to.value;
	var arFromDate = fromdate.split("/");
	var arToDate = todate.split("/");
	if (Date.parse("" + arFromDate[1] + "/" + arFromDate[0] + "/" + arFromDate[2] + "/") > Date.parse("" + arToDate[1] + "/" + arToDate[0] + "/" + arToDate[2] + "/")) {
		alert(getMessage("TO_DT_GR_FM_DT", "ST"));
		to.select();
		to.focus();
		return false;
	}
}
function checkSysdate(receiptdate, sysdate, locale) {//added locale for SRR20056-SCF-9527 by Badmavathi on 26/08/2015
	if(receiptdate.value!=""){
	//	var flag = ChkDate(receiptdate); //commented for SRR20056-SCF-9527 by Badmavathi on 26/08/2015
		var flag = CheckDateLeap(receiptdate,'DMY',locale);//added for SRR20056-SCF-9527 by Badmavathi on 26/08/2015
	/*	if (!flag) {
			alert(getMessage("INVALID_DATE_FMT", "ST"));
			receiptdate.select();
			receiptdate.focus();
			return false;
		}*///commented for SRR20056-SCF-9527 by Badmavathi on 26/08/2015
		if (flag) {
			if (checkdateWithSysDate(receiptdate, sysdate)) {
				alert(getMessage("ST_DOC_DT_NOT_GR_SYSDATE", "ST"));
				receiptdate.select();
				//receiptdate.focus();
				return false;
			}
		}
	}
}
function checkdateWithSysDate(entered_date, sys_date) {
	var fromdate = entered_date.value;
	var todate = sys_date.value;
	var arFromDate = fromdate.split("/");
	var arToDate = todate.split("/");
		if (Date.parse("" + arFromDate[1] + "/" + arFromDate[0] + "/" + arFromDate[2] + "/") > Date.parse("" + arToDate[1] + "/" + arToDate[0] + "/" + arToDate[2] + "/")) {
			return true;
		}else{
			return false;
		}
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
function CheckQuantity(obj) {

	if(document.formIssueReturnListHeader.dec_allowed_yn.value=="Y"){
		if (!checkDoubleFormat(obj,false)) {
			return false;
		}
	}else{
		if (!checkIntegerFormat(obj,false)) {
			return false;
		}
	}
}
function callItemSearchIssRetforBarcode(e,obj) {	
 	
		//if(e.keyCode==13 || e.keyCode== 9 || e.keyCode== 0){  //Check this for Key event
		var formObj = document.formIssueDocNoSearchCriteria;
		var barcode_appl = formObj.barcode_applicable1.value;

		if(barcode_appl == "Y"){
		if (obj!= undefined && obj.value!= "") {
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
 			xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?trn_type=RET" +  "&bar_code=" + formObj.item_desc.value +  "&store_code=" + formObj.to_store_code.value  + "&bean_id= issueReturnBean" + "&bean_name=eST.IssueReturnBean"+ "&formObj=formIssueDocNoSearchCriteria" + "&BARCODE_YN=TRUE&validate=SETDETAILS_RET", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);			
 			if(result){
			formObj.search.focus();
			formObj.search.click();
			}else{		
				if(message!=""){
				alert(getMessage(message, "ST"));
				formObj.item_desc.focus();
				}
			}
			}
		}else{
		callItemSearchScreen(obj);
		}
	//	}
}

//Added by sakti against ML-BRU-SCF-0963[INC#42099]	
function Setitemdesc(obj){
	document.formIssueReturnListHeader.item_desc.value = decodeURIComponent(obj.value,"UTF-8");
}   

function setMultiples(from,to,batch,issue) {
	if (document.formIssueReturnListHeader == null) {
		parent.frames[2].frames[0].document.formIssueReturnListHeader.from_multiples.value = from;
		parent.frames[2].frames[0].document.formIssueReturnListHeader.to_multiples.value = to;
		parent.frames[2].frames[0].document.formIssueReturnListHeader.batch_multiples.value = batch;
		parent.frames[2].frames[0].document.formIssueReturnListHeader.issue_uom_multiples.value = issue;
	} else {
		document.formIssueReturnListHeader.from_multiples.value = from;
		document.formIssueReturnListHeader.to_multiples.value = to;
		document.formIssueReturnListHeader.batch_multiples.value = batch;
		document.formIssueReturnListHeader.issue_uom_multiples.value = issue;
	}
}
//Added against HSA-CRF-0171 to lock back space and delte button.. used in IssueReturnHeader.jsp Inc# 48543
function isNumberKey(evt)
{

    var charCode = (evt.which) ? evt.which : evt.keyCode
    if (charCode == 8 || charCode == 46) 
    	return false;

  }
  //Added ends Inc# 48543
//Added against GHL-CRF-0413 starts
function calHeaderDetails(bar_code,item_code){
	var bar_code	= bar_code;
	var item_code	= item_code;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/IssueReturnValidate.jsp?&item_code="+item_code+"&bar_code=" + bar_code +  "&validate=HEADER_DETAILS", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText); 
}
function callBarCodeBatchSearchRETDoc(e,barcode,trntype,fromStore,toStore,formObj,bean_id,bean_name,ListHeader,ListDetail,Detail){
	if(e.keyCode==9 || e.keyCode== 13  || e.keyCode== 0){
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?&store_code="+fromStore.value+"&barcode=" + barcode.value + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE" +  "&validate=VALID_BARCODE", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if(result){
			if(parent.frames[1].document.forms[0] != null){
				var xmlHttp = new XMLHttpRequest();
				var xmlDoc="";
				//xmlDoc.loadXML(getXMLString(null));
				xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
				xmlHttp.open("POST", "../../eST/jsp/IssueReturnValidate.jsp?&store_code="+fromStore.value+"&toStore=" + toStore.value+"&item_code="+parent.frames[0].document.forms[0].item_code.value+"&barcode=" + barcode.value+"&trntype=" + trntype.value + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE" +  "&validate=VALIDATE_RET", false);
				xmlHttp.send(xmlDoc);
				responseText = xmlHttp.responseText;
				eval(responseText);
				if(result){
					var index = parent.frames[1].document.forms[0].total_checkboxes.value ;
					var xmlHttp = new XMLHttpRequest();
					var xmlDoc="";
					//xmlDoc.loadXML(getXMLString(null));
					xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
					xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?&validate=BATCH_EXP_DETAILS"+"&barcode=" + barcode.value + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE", false);
					xmlHttp.send(xmlDoc);
					responseText = xmlHttp.responseText;
					eval(responseText);
					if(result){
						var item_qty = 0;
						item_qty = parent.frames[0].document.forms[0].item_qty.value;
						var temp_item_ret_qty = parent.frames[0].document.forms[0].ret_qty.value;//Added for TFS id: 11896
						var temp_item_qty = item_qty;//Added against GHL-CRF-0464
						var incriment_val=parseFloat(parent.frames[0].document.forms[0].from_multiples.value);//Added for TFS id: 11896
						item_qty=parseFloat(item_qty)+parseFloat(incriment_val);//Added for TFS id: 11896
						var batch_item_qty = (parent.frames[0].document.forms[0].conv_factor.value);//Added for TFS id: 11896
						parent.frames[0].document.forms[0].item_qty.value =item_qty;
						var res = ChackIssueQty(parent.frames[0].document.forms[0].item_qty);
						if(res){
							if(parent.frames[0].document.forms[0].ret_qty!=undefined){
								 parent.frames[0].document.forms[0].ret_qty.value =item_qty*batch_item_qty ;//Modified for TFS id: 11896
							}
							if (parseInt(index)==1 && trntype.value == "RET"){
							//Modified for TFS id: 11896 start
								temp_item_ret_qty=parent.frames[1].document.forms[0].item_qty_0.value;
								parent.frames[1].document.forms[0].item_qty_0.value = parseInt(parent.frames[1].document.forms[0].item_qty_0.value)+parseInt(incriment_val* batch_item_qty);
								
								if (parseFloat(parent.frames[1].document.forms[0].available_qty_0.value) < parseFloat(parent.frames[1].document.forms[0].item_qty_0.value)) {
								//Modified for TFS id: 11896 end
									//Modified against GHL-CRF-0464 starts
									/*
									alert(getMessage("TFR_QTY_LESS_THAN_AVL_QTY", "ST"));
									parent.frames[1].document.forms[0].item_qty_0.focus();
									*/
									alert(getMessage("TFR_QTY_LESS_THAN_AVL_QTY_BARCODE", "ST"));
									parent.frames[1].document.forms[0].item_qty_0.value= parseInt(temp_item_ret_qty) ;//Modified for TFS id: 11896
									autoQtyUpdate();
									//Modified against GHL-CRF-0464 ends
								}
							}
							else{
								var xmlHttp = new XMLHttpRequest();
								var xmlDoc="";
								//xmlDoc.loadXML(getXMLString(null));
								xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
								xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?&validate=ITEM_QTY_INCREMENT"+"&barcode=" + barcode.value + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE", false);
								xmlHttp.send(xmlDoc);
								responseText = xmlHttp.responseText;
								eval(responseText);
								if(result){
									var resultArray	;
									resultArray = message.split(";");
									var  m   = 	resultArray[0];
									var itm_qty = eval("parent.frames[1].document.forms[0].item_qty_"+m).value;
									var temp_itm_qty = itm_qty;//Added against GHL-CRF-0464
									//itm_qty++;
									itm_qty=parseFloat(itm_qty)+(parseFloat(incriment_val)* parseFloat(batch_item_qty));//Added for TFS id: 11896
									var item_qty_ = eval("parent.frames[1].document.forms[0].item_qty_"+m);
									item_qty_.value = parseInt(itm_qty) ;
									if (parseFloat(eval("parent.frames[1].document.forms[0].available_qty_"+m).value) < parseFloat(eval("parent.frames[1].document.forms[0].item_qty_"+m).value)) {//Modified for TFS id: 11896
										//Modified against GHL-CRF-0464 starts
										/*
										alert(getMessage("TFR_QTY_LESS_THAN_AVL_QTY", "ST"));
										item_qty_.focus();
										*/
										alert(getMessage("TFR_QTY_LESS_THAN_AVL_QTY_BARCODE", "ST"));
										item_qty_.value= parseInt(temp_itm_qty) ;
										autoQtyUpdate();
										//Modified against GHL-CRF-0464 ends
								    }
								}
							}
							CheckQuantity(parent.frames[0].document.forms[0].item_qty);
							parent.frames[0].document.forms[0].barcode.value = "";
						}
						else{
							parent.frames[0].document.forms[0].item_qty.value = temp_item_qty;//Added against GHL-CRF-0464
							parent.frames[0].document.forms[0].barcode.value = "";
						}
					}
					else{
						var index = parent.frames[1].document.forms[0].total_checkboxes.value ;
						index++;
						var xmlHttp = new XMLHttpRequest();
						var xmlDoc="";
						//xmlDoc.loadXML(getXMLString(null));
						xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
						xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?&validate=BARCODECHECK_SAMEITEM"+"&store_code="+fromStore.value+"&barcode=" + barcode.value + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE", false);//"&valid_item_code=" + valid_item_code + 
						xmlHttp.send(xmlDoc);
						responseText = xmlHttp.responseText;
						eval(responseText);
						if(result)
							{
							if(parent.parent.frames[0].document.forms[0].store_code != undefined)
								var store_code = parent.parent.frames[0].document.forms[0].store_code.value;
							else
								var store_code = parent.parent.frames[0].document.forms[0].from_store_code.value;
							var index = parent.frames[1].document.forms[0].total_checkboxes.value ;
							var qtyList=[] ;
							//Added for TFS id: 11896 start
							var incriment_val=parseFloat(parent.frames[0].document.forms[0].from_multiples.value);
							var batch_item_qty = (parent.frames[0].document.forms[0].conv_factor.value);
							//Added for TFS id: 11896 end
							for(var m=0 ; m< index; m++){
								qtyList.push(	eval("parent.frames[1].document.forms[0].item_qty_"+m).value);
							}
								qtyList.push(parseInt(incriment_val)* parseInt(batch_item_qty));//Modified for TFS id: 11896
							var item_qty=0;
							item_qty = parent.frames[0].document.forms[0].item_qty.value;
							item_qty=parseFloat(item_qty)+parseFloat(incriment_val);//Modified for TFS id: 11896							
							var defaultqty_appl= parent.parent.frames[0].document.forms[0].defaultqty_appl1.value;
							var site = parent.frames[0].document.forms[0].site.value;
							var toStore		= toStore.value;
							if (toStore==undefined)
								toStore="";
							var frombarcode ="";
							if( parent.frames[0].document.forms[0].barcode != undefined){
								if(parent.frames[0].document.forms[0].barcode.value != "" )
								 frombarcode = "Y";
							}
							//var xmlHttp  = new ActiveXObject("Microsoft.XMLHTTP");
							//var xmlDoc   = new ActiveXObject("Microsoft.XMLDom");
							//xmlDoc.loadXML(getXMLString(null));
							xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
							var xmlHttp = new XMLHttpRequest();
							var xmlDoc = "";
							xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?trn_type=" + trntype.value + "&bar_code=" + barcode.value + "&formObj=" + formObj.name  +"&fromStore=" + fromStore.value + "&toStore=" + toStore + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE" + "&jsp_page=" + ListDetail + "&site=" + true +"&frombarcode="+frombarcode+ "&validate=BARCODE", false);
							xmlHttp.send(xmlDoc);
							responseText = xmlHttp.responseText;
							eval(responseText);
							if(result){
								 resultArray = message.split(";");
   								 parent.frames[0].document.forms[0].item_qty.value =item_qty;
								 CheckQuantity(parent.frames[0].document.forms[0].item_qty);
								 if(parent.frames[0].document.forms[0].ret_qty!=undefined){
								 parent.frames[0].document.forms[0].ret_qty.value =parseInt(item_qty)*parseInt(batch_item_qty) ;//Modified for TFS id: 11896
								 }
								 if (document.forms[0].bar_or_item_code.value == 'B'){
									 var  item_code   = 	resultArray[0];
									 var  batch_id    = 	resultArray[1];
									 var  expiry_date = 	resultArray[2];	
									 var  BarcodeWithMultipleBatches = resultArray[3];	
									 var xmlHttp = new XMLHttpRequest();
									 var xmlDoc="";
									 //xmlDoc.loadXML(getXMLString(null));
									 xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
									 xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?validate=BarcodeWithMultipleBatches_yn"+"&store_code="+store_code+"&item_code="+item_code+"&BarcodeWithMultipleBatches_yn=" + BarcodeWithMultipleBatches + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE", false);
									 xmlHttp.send(xmlDoc);
									 var responseText=xmlHttp.responseText;
									 eval(responseText);
									 if(result)
									    	editViewBatchForBarCode1(ListDetail,fromStore.value,barcode.value,BarcodeWithMultipleBatches,qtyList,trntype.value);
									 else
											callBatchSearchforBarcodeMultiBatch1(fromStore.value,barcode.value,ListDetail,BarcodeWithMultipleBatches,qtyList);
									 parent.frames[0].document.forms[0].barcode.value = "";
								}
								}else{
									if(getMessage(message, "ST") != ""){
										alert(getMessage(message, "ST"));
										parent.frames[0].document.forms[0].barcode.value = "";
														return false;
									}
									else{
								alert(message);
								parent.frames[0].document.forms[0].barcode.value = "";
								return false;
									}
							}
							}else{
						if (confirm("Proceed with the next Item?") == true) {
							addToListforBarcode();										
					    } else {
					    	 parent.frames[0].document.forms[0].barcode.value = "";
 					    	 return false;
						}
					}
				}
			}else{
				if(getMessage(message, "ST") != ""){
					alert(getMessage(message, "ST"));
					parent.frames[0].document.forms[0].barcode.value = "";
					return false;
				}
			else{
				alert(getMessage("ITEM_STORE_NOT_FOUND1", "ST"));
				parent.frames[0].document.forms[0].barcode.value = "";
				return false;
				}
			}
		}
		else{
			callBarCodeBatchSearchforRET1(e,barcode,trntype,fromStore,toStore,formObj,bean_id,bean_name,ListHeader,ListDetail,Detail);
		}
	}else{
		alert(getMessage("ST_INVALID_BAR_CODE", "ST"));
	    parent.frames[0].document.forms[0].barcode.value = "";
		return false;
		}
	}
}
function callBarCodeBatchSearchforRET1(e,barcode,trntype,fromStore,toStore,formObj,bean_id,bean_name,ListHeader,ListDetail,Detail){
	if(e.keyCode==9 || e.keyCode== 13  || e.keyCode== 0){
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/IssueReturnValidate.jsp?&store_code="+fromStore.value+"&toStore=" + toStore.value+"&barcode=" + barcode.value+"&trntype=" + trntype.value + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE" +  "&validate=VALIDATE_RET", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText); 
		if(result){
			var bar_code	= barcode.value;
			var trn_type	= trntype.value;
			var fromStore   = fromStore.value;
			var toStore		= toStore.value;
			var formObj		= formObj.name; 
			var barcode_appl = parent.parent.frames[0].document.forms[0].barcode_applicable1.value;
			var resultArray	;	
			if (barcode_appl=="Y" && bar_code!=""){
			if (toStore==undefined)
				toStore="";
			var frombarcode ="";
			if( parent.frames[0].document.forms[0].barcode != undefined){
				if(parent.frames[0].document.forms[0].barcode.value != "" )
				 frombarcode = "Y";
			}
			//var xmlHttp  = new ActiveXObject("Microsoft.XMLHTTP");
			//var xmlDoc   = new ActiveXObject("Microsoft.XMLDom");
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc = "";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?trn_type=" + trn_type + "&bar_code=" + bar_code + "&formObj=" + formObj  +"&fromStore=" + fromStore + "&toStore=" + toStore  + "&store_code=" + toStore +"&site=" +parent.frames[0].document.forms[0].site.value+ "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE" + "&jsp_page=" + ListDetail +"&frombarcode="+frombarcode+ "&validate=BARCODE", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			if(result){
				if (document.forms[0].bar_or_item_code.value == 'B'){
				 resultArray = message.split(";");
				 var  item_code   = 	resultArray[0];
				 var  batch_id    = 	resultArray[1];
				 var  expiry_date = 	resultArray[2];	
				 var  BarcodeWithMultipleBatches = resultArray[3];	
				 var qtyList=[] ;
				 calHeaderDetails(bar_code,item_code);
  				 if(BarcodeWithMultipleBatches=="Y")
					callBatchSearchforBarcodeMultiBatch1(fromStore,bar_code,ListDetail,BarcodeWithMultipleBatches,qtyList);
				 else
					editViewBatchForBarCode1(ListDetail,fromStore,bar_code,BarcodeWithMultipleBatches,qtyList,trntype.value);
				if (parent.parent.frames[0].document.forms[0].defaultqty_appl1.value == 'Y'  && parent.parent.frames[0].document.forms[0].editqty_appl1.value=='N') {
					checkminmaxstatus();
					totalqty();
					parent.frames[0].document.forms[0].barcode.disabled = false;
					parent.frames[0].document.forms[0].barcode.value = "";
					parent.frames[0].document.forms[0].barcode.focus();
				}else if(parent.parent.frames[0].document.forms[0].defaultqty_appl1.value == 'N'){
					if(document.forms[0].item_qty!=undefined)
						document.forms[0].item_qty.focus();
				}
				parent.frames[0].document.forms[0].apply.value ="Modify";
				parent.frames[0].document.forms[0].ItemDetails.disabled = false;
				}	
			else{
				alert(getMessage("PH_INVALID_BAR_CODE", "PH"));
				refreshDetailsforBarCode('999',ListHeader,Detail,'','','','','');
			}
		}else
		 {	
		    parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?";	//err_num=" + message;
		    if (message == "PHY_INV_PROCESS_INITIATED") {
			alert(getMessage(message, "ST") + "\n" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + document.forms[0].phy_inv_id.value);
			return;
			} else {
				if(getMessage(message, "ST") != ""){
				alert(getMessage(message, "ST"));
				refreshDetailsforBarCode('999',ListHeader,Detail,'','','','','');
			}
			else{
				alert(message);
				refreshDetailsforBarCode('999',ListHeader,Detail,'','','','','');
			}
		}
		}
	}
	}else{
		if(getMessage(message, "ST") != ""){
			alert(getMessage(message, "ST"));
			refreshDetailsforBarCode('999',ListHeader,Detail,'','','','','');
		}
		else{
			alert(getMessage("ITEM_STORE_NOT_FOUND1", "ST"));
			parent.frames[0].document.forms[0].barcode.value = "";
			return false;
		}
		}
	}
}
function setStockDetailsforBarcode(_stock_item_yn, _to_stock_item_yn, _store_item_unit_cost, _available_stock, _expired_stock,_conv_factor) {
}
function callItemQtyUpdate(){
	var itmqty ;
	if(parent.frames[0].document.forms[0].item_qty!=undefined && parent.frames[0].document.forms[0].item_qty.value != ""){
	 itmqty = parent.frames[0].document.forms[0].item_qty.value;
	}
	else{
	 itmqty = "1";
	}
	var Obj	=  parent.parent.frames[0].document.forms[0].defaultqty_value1;
	var bar_appl = parent.parent.frames[0].document.forms[0].barcode_applicable1;
	if(bar_appl.value=='Y' && document.forms[0].item_code.value!=null){
	if(Obj.value==1 && parent.parent.frames[0].document.forms[0].editqty_appl1.value != 'Y' &&  document.forms[0].bar_or_item_code.value == 'B'){ 
		if (parent.frames[1].document.forms[0] != undefined && itmqty=="1") {
			var index = parent.frames[1].document.forms[0].total_checkboxes.value ;	
				if(parent.frames[0].document.forms[0].noofbatchesforbarcode.value=="1"){
					var incriment_val=parseFloat(parent.frames[0].document.forms[0].from_multiples.value);//Added for TFS id: 11896
					var batch_item_qty = (parent.frames[0].document.forms[0].conv_factor.value);//Added for TFS id: 11896
					if(parent.frames[0].document.forms[0].iss_uom_qty!=undefined){
						parent.frames[0].document.forms[0].iss_uom_qty.value = Obj.value;
					}				
					//Modified for TFS id: 11896 start				
					parent.frames[0].document.forms[0].item_qty.value = incriment_val;
					if(parent.frames[0].document.forms[0].tot_item_qty!=undefined){
					parent.frames[0].document.forms[0].tot_item_qty.value = parseInt(incriment_val)*parseInt(batch_item_qty);
					}else if(parent.frames[0].document.forms[0].ret_qty!=undefined){
					parent.frames[0].document.forms[0].ret_qty.value= parseInt(incriment_val)*parseInt(batch_item_qty);
					}
					//Modified for TFS id: 11896 end
				}
			if (parseInt(index)==1){
				parent.frames[1].document.forms[0].item_qty_0.value = parseInt(incriment_val)*parseInt(batch_item_qty);//Modified for TFS id: 11896
			}
	  }
	}
	else if(document.forms[0].item_qty.value>0){
		if (parent.frames[1].document.forms[0] != undefined) {
		var index = parent.frames[1].document.forms[0].total_checkboxes.value ;		
		if (parseInt(index)==1 ){			
			var item_qty_new = document.forms[0].item_qty;
			parent.frames[1].document.forms[0].item_qty_0.value = document.forms[0].item_qty.value;
			var avail_qty = parent.frames[1].document.forms[0].available_qty_0.value ;
			var dec_allowed_yn = parent.frames[1].document.forms[0].dec_allowed_yn.value ;			
			var qty_val = checkBatchQtyforBarcode(item_qty_new,avail_qty,dec_allowed_yn);
			var tot_item_qty;
			if(document.forms[0].tot_item_qty!=undefined)
			var tot_item_qty = document.forms[0].tot_item_qty.value ;
			else
			var tot_item_qty = document.forms[0].ret_qty.value;
			if(qty_val)
			chargeDetailsExp(document.forms[0].item_code.value,tot_item_qty);   
		}
		}else{
		}
	}
	}
	CheckQuantity(parent.frames[0].document.forms[0].item_qty);
	ChackIssueQty(parent.frames[0].document.forms[0].item_qty);
}
function callBarCodeBatchSearchRETItem(e,barcode,trntype,fromStore,toStore,formObj,bean_id,bean_name,ListHeader,ListDetail,Detail){
	if(e.keyCode==9 || e.keyCode== 13  || e.keyCode== 0){
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?&store_code="+fromStore.value+"&barcode=" + barcode.value + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE" +  "&validate=VALID_BARCODE", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText); 
	if(result){
		if(parent.frames[1].document.forms[0] != null){
			parent.frames[0].document.forms[0].barcode.disabled = false;
		}else{
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/IssueReturnValidate.jsp?&fm_store_code="+fromStore.value+"&to_store_code=" + toStore.value+"&barcode=" + barcode.value+"&trntype=" + trntype.value + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE" +  "&validate=VALIDATE_RET_ITEMS", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText); 
			if(result){
				 parent.frames[0].document.forms[0].barcode.value = "";
				 parent.frames[0].document.forms[0].barcode.disabled = true;	 
				 callItemSearchScreen_Main();
			}else{
				alert(getMessage("ITEM_STORE_NOT_FOUND1", "ST"));
				parent.frames[0].document.forms[0].barcode.value = "";
				return false;
			}
		}
	}
	else{
		alert(getMessage("ST_INVALID_BAR_CODE", "ST"));
		parent.frames[0].document.forms[0].barcode.value = "";
		return false;
	}
	}
}	
function GoBarcode(){
	if(parent.frames[0].document.forms[0] != undefined){
		if(parent.frames[0].document.forms[0].barcode != undefined && parent.frames[0].document.forms[0].barcode.value=="" && parent.frames[0].document.forms[0].barcode.disabled != true ){
			parent.frames[0].document.forms[0].barcode.select();
		}
	}
}
//Added against GHL-CRF-0413 ends
//Added for TFS id: 11896 start
function setConvFactor(conv_factor){
	parent.frames[0].document.forms[0].conv_factor.value=conv_factor;
}
function autoQtyUpdate(){ 
	var Obj	=  parent.parent.frames[0].document.forms[0].defaultqty_value1.value;
	var site = parent.frames[0].document.forms[0].site.value;
	var bar_appl = parent.parent.frames[0].document.forms[0].barcode_applicable1.value;
	var trn_type=parent.parent.frames[0].document.forms[0].trn_type.value;
	var barcode = parent.frames[0].document.forms[0].barcode;
	var editqty = parent.parent.frames[0].document.forms[0].editqty_appl1.value;
	var bar_or_item_code = parent.frames[0].document.forms[0].bar_or_item_code.value;
	var from_multiples = parent.frames[0].document.forms[0].from_multiples.value;
	if(bar_appl=='Y' && parent.frames[0].document.forms[0].item_code.value!=null && Obj==1 && editqty != 'Y' &&  bar_or_item_code == 'B' && site){
		if (parent.frames[1].document.forms[0] != undefined && parent.frames[1].document.forms[0] != null) {
			var formObjDtl = parent.frames[1].document.forms[0];
			if(parent.frames[0].document.forms[0].tot_item_qty !=undefined)
				var item_qty = parent.frames[0].document.forms[0].tot_item_qty.value;
			if(parent.frames[0].document.forms[0].ret_qty !=undefined)
				var item_qty = parent.frames[0].document.forms[0].ret_qty.value;
			if(parent.frames[0].document.forms[0].item_qty !=undefined)// added for GHL-CRF-0465 Start
				var item_qty = parent.frames[0].document.forms[0].item_qty.value;
				if(parent.frames[0].document.forms[0].iss_uom_qty !=undefined)
					var item_qty = parent.frames[0].document.forms[0].iss_uom_qty.value;	
			var _total_checkboxes = formObjDtl.total_checkboxes.value;// GHL-CRF-0465 END
			var no_of_decimals=formObjDtl.no_of_decimals.value;
			
			var sum = 0;
			var i =0;
			for ( i = 0; i < _total_checkboxes; i++) {
				var qty = eval("formObjDtl.item_qty_" + i).value;
				if (qty == "") {
					qty = 0;
				}
				if (!isNaN(qty)) {
					sum += parseFloat(qty);
				}
			}
		if(formObjDtl.dec_allowed_yn.value=='Y')
			sum=sum.toFixed(no_of_decimals);
			if (sum != item_qty) {
				if(parent.frames[0].document.forms[0].tot_item_qty !=undefined)
					parent.frames[0].document.forms[0].tot_item_qty.value =sum;
				if(parent.frames[0].document.forms[0].ret_qty !=undefined)
					parent.frames[0].document.forms[0].ret_qty.value =sum;
				if(parent.frames[0].document.forms[0].iss_uom_qty !=undefined)//added GHL-CRF-0465
					parent.frames[0].document.forms[0].iss_uom_qty.value=sum;//added GHL-CRF-0465
				parent.frames[0].document.forms[0].item_qty.value = parseInt(item_qty)-parseInt(from_multiples);
				barcode.focus();	
			}
		}
	}
}
//Added for TFS id: 11896 end
