/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
20/02/2017		IN0063027		Badmavathi B							GHL-CRF-0413.7 - US005 - Barcode search
---------------------------------------------------------------------------------------------------------
*/
var searchby = "D";
var function_id = "";
var bean_id = "";
var bean_name = "";
var xmlDom;  
var xmlHttp;
var xmlString;
if(top.expiryDateCheck)
{
	top.expiryDateCheck="";
	}


async function searchItemCode(objCode) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var sql = parent.PhysicalInventoryEntryHeaderFrame.formPhysicalInventoryEntryHeader.SQL_ST_ITEM_LOOKUP_LANG.value + "   AND mm.language_id='" + document.forms[0].language_id.value + "'   order by 2";
//	alert(sql);
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = objCode.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		if(returnedValues.length === 1){
			returnedValues = returnedValues[0].split(',');
		}
		objCode.value = returnedValues[0];
	}
}
function reset() {
	location.reload();
}
function query() {
	f_query_add_mod.location.href = "../../eST/jsp/PhysicalInventoryEntryFrame.jsp?function_id=" + function_id;
}
function fun_submit() {
	var frmObj = formPhysicalInventoryEntryHeader;
	if(frmObj.phy_inv_id.value==""){
		parent.frames[1].location.href = "../../eCommon/html/blank.html";
		parent.frames[2].location.href = "../../eCommon/html/blank.html";
		var msg = getLabel("eST.PhyInventoryID.label", "ST") + " " + getLabel("Common.Cannotbeblank.label", "Common");
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + msg;
		return;

	}


	frmObj.phy_inv_id.disabled=true;
	frmObj.search.disabled=true;
	//xmlDom = new ActiveXObject("Microsoft.XMLDom");
	//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	xmlHttp = new XMLHttpRequest();
    xmlDom = "";
	xmlString = "<root><SEARCH/></root>";
	//xmlDom.loadXML(xmlString);
	xmlDom = new DOMParser().parseFromString(xmlString, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/PhysicalInventoryEntryApplyAddValidate.jsp?validate=DATACORRECT&phy_inv_id=" + frmObj.phy_inv_id.value + "&store_code=" + frmObj.store_code.value + "&item_code=" + frmObj.item_code.value, false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
	

	if(result) {
		result=false;
	frmObj.phy_inv_id.disabled=true;
	frmObj.search.disabled=true;
	//xmlDom = new ActiveXObject("Microsoft.XMLDom");
	//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc = "";
	xmlString = "<root><SEARCH/></root>";
	//xmlDom.loadXML(xmlString);
	xmlDom = new DOMParser().parseFromString(xmlString, "text/xml");
	//xmlnew DOMParser().parseFromString(getXMLString(document.formComputeStockLevelsCriteria), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/PhysicalInventoryEntryApplyAddValidate.jsp?validate=LOADDETAIL&phy_inv_id=" + frmObj.phy_inv_id.value + "&store_code=" + frmObj.store_code.value + "&item_code=" + frmObj.item_code.value, false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
	}
	//Added for GHL-CRF-0413.7 starts
	if(frmObj.site.value = "true" && frmObj.barcode != undefined){
		frmObj.barcode.disabled=false;
		frmObj.barcode.focus();
	}
	//Added for GHL-CRF-0413.7 ends
	if (result) {
		parent.frames[1].location.href = "../../eST/jsp/PhysicalInventoryEntryDetail.jsp?phy_inv_id=" + frmObj.phy_inv_id.value;
	}
}
function modifyData(index) {

   if(checkDate2(top.expiryDateCheck)){
	if (index != -1) {
		var trObject = eval(document.getElementById("tr_" + index))
		changeRowColor(trObject);
	}
	var formObj = document.formPhysicalInventoryEntryDetail;
	//formObj.index.value=index;
	if (index == -1) {
		formObj = f_query_add_mod.framePhysicalInventoryDetail.document.formPhysicalInventoryEntryDetail;
		var formObj1 = parent.frames[2].f_query_add_mod.framePhysicalInventoryEntryList.framePhysicalInventoryEntryListHeader;
	} else {
		var formObj1 = parent.framePhysicalInventoryEntryList.framePhysicalInventoryEntryListHeader;
	}
	if (formObj1 != null && formObj.prev_index.value != "") {
		frmObj = formObj1.document.forms[0];
		//xmlDom = new ActiveXObject("Microsoft.XMLDom");
		//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		var xmlHttp = new XMLHttpRequest();
		var xmlDom = "";
		var arrObj = frmObj.elements;
		var frmObjs = new Array();
		if (frmObj.name == null) {
			frmObjs = frmObj;
		} else {
			frmObjs[0] = frmObj;
		}
		var xmlString = "<root><SEARCH ";
		for (var frmCount = 0; frmCount < frmObjs.length; frmCount++) {
			frmObj = frmObjs[frmCount];
			var arrObj = frmObj.elements;
			for (var i = 0; i < arrObj.length; i++) {
				var val = "";
				if (arrObj[i].type == "checkbox") {
					if (arrObj[i].checked) {
						arrObj[i].value = "Y";
						val = arrObj[i].value;
					} else {
						arrObj[i].value = "N";
						val = arrObj[i].value;
					}
				} else {
					if (arrObj[i].type == "radio") {
						if (arrObj[i].checked) {
							val = arrObj[i].value;
						}
					} else {
						if (arrObj[i].type == "select-multiple") {
							for (var j = 0; j < arrObj[i].options.length; j++) {
								if (arrObj[i].options[j].selected) {
									val += arrObj[i].options[j].value + "~";
								}
							}
							val = val.substring(0, val.lastIndexOf("~"));
						} else {
							val = arrObj[i].value;
						}
					}
				}
				val = checkSpl(val);
				xmlString += arrObj[i].name + "=\"" + val + "\" ";
			}
		}
		xmlString += " /></root>";
		//xmlDom.loadXML(xmlString);
		xmlDom = new DOMParser().parseFromString(xmlString, "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/PhysicalInventoryEntryApplyAddValidate.jsp?validate=REFRESHDETAIL&prev_index=" + formObj.prev_index.value+"&index="+index, false);
		xmlHttp.send(xmlDom);
		responseText = xmlHttp.responseText;
		eval(responseText);
		//if(result)
		//	parent.frames[1].location.href	=	"../../eST/jsp/PhysicalInventoryEntryDetail.jsp";
	}
	if (index != -1) {
		//console.log(parent.document);
		//console.log(document);
		
		var phy_inv_id = parent.PhysicalInventoryEntryHeaderFrame.document.getElementById('phy_inv_id').value;
		//var phy_inv_id = parent.PhysicalInventoryEntryHeaderFrame.document.getElementById('phy_inv_id').value;
		
		var store_code = eval("document.forms[0].store_code_" + index + ".value");
		var item_code = eval("document.forms[0].item_code_" + index + ".value");
		var store_desc = eval("document.forms[0].store_desc_" + index + ".value");
		var item_desc = eval("document.forms[0].item_desc_" + index + ".value");
		parent.frames[2].location.href = "../../eST/jsp/PhysicalInventoryEntryListFrame.jsp?mode=" + MODE_MODIFY + "&function_id=" + document.formPhysicalInventoryEntryDetail.function_id.value + "&phy_inv_id=" + phy_inv_id + "&store_code=" + store_code + "&item_code=" + item_code + "&store_desc=" + store_desc + "&item_desc=" + escape(item_desc) + "&index=" + index;
		
		parent.PhysicalInventoryEntryHeaderFrame.document.getElementById('item_code').value=item_code;
		//parent.PhysicalInventoryEntryHeaderFrame.document.getElementById('item_code').value=item_code;
		
		//parent.parent.PhysicalInventoryEntryHeaderFrame.document.getElementById('item_desc').value=item_desc;
		parent.PhysicalInventoryEntryHeaderFrame.document.getElementById('item_desc').value=item_desc;
		//parent.document.location.href="../../eSt/jsp/PhysicalInventoryEntryApplyFrame.jsp?mode="+MODE_MODIFY+"&function_id="+parent.parent.function_id+"&phy_inv_id="+phy_inv_id	+"&store_code="+store_code+"&item_code="+item_code+"&store_desc="+store_desc+"&item_desc="+escape(item_desc);
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
		document.forms[0].prev_index.value = index;
	}
  }	
}

//call when u click for modifing
function setVal(obj, index) {
	var batch_id = obj.cells[1].innerText;
	var item_qty = obj.cells[2].innerText;
	var bin_loc_code = eval("document.forms[0].bin_code_" + index + ".value");
	var new_batch_YN = eval("document.forms[0].new_batch_YN_" + index + ".value");
	//var bin_loc_code = obj.cells[3].innerText;
	var expiry_date = obj.cells[4].innerText;
	var trade_id = obj.cells[5].innerText;
	var trade_id = obj.cells[5].innerText;
	var key_value = batch_id + item_qty + bin_loc_code + expiry_date + trade_id + new_batch_YN;
	var formObj = parent.framePhysicalInventoryEntryApplyAdd.formPhysicalInventoryEntryApplyAdd;
	formObj.batch_id.value = batch_id;
	formObj.item_qty.value = item_qty;
	formObj.bin_loc_code.options.value = bin_loc_code;
	formObj.expiry_date.value = expiry_date;
	formObj.trade_id.value = trade_id;
	if (new_batch_YN == "Y") {
		formObj.new_batch_YN.checked = true;
	}
	parent.framePhysicalInventoryEntryApplyAdd.formPhysicalInventoryEntryApplyAdd.Add.value = getLabel("Common.Modify.label", "Common");
	parent.framePhysicalInventoryEntryApplyAdd.formPhysicalInventoryEntryApplyAdd.mode.value = getLabel("Common.Modify.label", "Common");
	parent.framePhysicalInventoryEntryApplyAdd.formPhysicalInventoryEntryApplyAdd.modify.value = "yes";
	parent.framePhysicalInventoryEntryApplyAdd.formPhysicalInventoryEntryApplyAdd.key_modify.value = key_value;
}
function apply() {
	
	var formObj = f_query_add_mod.PhysicalInventoryEntryHeaderFrame.document.formPhysicalInventoryEntryHeader;
	if(f_query_add_mod.framePhysicalInventoryEntryList.framePhysicalInventoryEntryListHeader != undefined)
	var formDetail = f_query_add_mod.framePhysicalInventoryEntryList.framePhysicalInventoryEntryListHeader.document.formPhyInvEntryList;

	if (formObj.phy_inv_id.value == "") {
		var msg = getLabel("eST.PhyInventoryID.label", "ST") + " " + getLabel("Common.Cannotbeblank.label", "Common");
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + msg;
		return;
	}
	if (formObj.entry_completed_yn.checked) {
		formObj.entry_completed_yn.value = "Y";
	} else {
		formObj.entry_completed_yn.value = "N";
	}
	var errorPage = "../../eCommon/jsp/error.jsp";
	if (formObj.entry_completed_yn.value == "Y") {
		if (!confirm("Batches Having Null Item Quantity Will Get Updated To Zero After Post Variance. Do You Want To Continue?")) {
			messageFrame.location.href = errorPage + "?err_num=";
			return;
		}
	}

	var index = -1;
	modifyData(index);

	if (formObj.entry_completed_yn.value == "Y") {
	var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
//			xmlDoc.loadXML(getEnhancedXMLString(formDetail));
			xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formDetail), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/PhysicalInventoryEntryApplyAddValidate.jsp?validate=CHECK_COMMITTED_QTY", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
	if (!result){
		alert(message);
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" ;
		return;
	}
	}


	var responseText = formApply(formObj, ST_CONTROLLER);
	eval(responseText);
	messageFrame.location.href = errorPage + "?err_num=" + message;
	if (result) {
		Success();
				//reset();
	}
}
function Success() {
	query();
	/*
	xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
	xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" );
	xmlString ="<root><SEARCH/></root>";
	xmlDom.loadXML(xmlString);
	xmlHttp.open("POST", "../../eST/jsp/PhysicalInventoryEntryApplyClearMap.jsp", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	alert(responseText);
	//eval(responseText);
*/
}
function assignBean(formObject) {
	bean_id = formObject.bean_id.value;
	bean_name = formObject.bean_name.value;
	// xmlDom = new ActiveXObject("Microsoft.XMLDom");
  xmlDom = "" ;
	// xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
  xmlHttp = new XMLHttpRequest();
}
function addToTable(objB) {
  // 	xmlDom = new ActiveXObject("Microsoft.XMLDom");
  xmlDom = "" ;
	// xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	xmlHttp = new XMLHttpRequest();
  var errorPage = "../../eCommon/jsp/error.jsp";
	var frmObj = formPhysicalInventoryEntryApplyAdd;
	var arrayObject = new Array(frmObj.batch_id, frmObj.item_qty, frmObj.bin_loc_code, frmObj.expiry_date, frmObj.trade_id);
	var names = new Array(getLabel("Common.BatchID.label", "Common"), getLabel("eST.ItemQuantity.label", "ST"), getLabel("Common.BinLocation.label", "Common"), getLabel("Common.expiryDate.label", "Common"), getLabel("Common.TradeID.label", "Common"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.messageFrame);
	var add_legend = getLabel("Common.Add.label", "Common");
	var new_batch_YN = "";
	if (frmObj.new_batch_YN.checked) {
		new_batch_YN = "Y";
		frmObj.new_batch_YN.value = "Y";
	} else {
		new_batch_YN = "N";
		frmObj.new_batch_YN.value = "N";
	}
	if (objB.value == add_legend) {
		var batch_id = formPhysicalInventoryEntryApplyAdd.batch_id.value;
		var item_qty = formPhysicalInventoryEntryApplyAdd.item_qty.value;
		var bin_loc_code = formPhysicalInventoryEntryApplyAdd.bin_loc_code.value;
		var expiry_date = formPhysicalInventoryEntryApplyAdd.expiry_date.value;
		var trade_id = formPhysicalInventoryEntryApplyAdd.trade_id.value;
		var key_value = batch_id + item_qty + bin_loc_code + expiry_date + trade_id + new_batch_YN;
		parent.parent.framePhysicalInventoryEntryList.framePhysicalInventoryEntryListHeader.formPhysicalInventoryEntryApplyAdd.key_modify.value = key_value;
		var arrayObject = new Array(frmObj.batch_id, frmObj.item_qty, frmObj.bin_loc_code, frmObj.expiry_date, frmObj.trade_id);
		
		var names = new Array(getLabel("Common.BatchID.label", "Common"), getLabel("eST.ItemQuantity.label", "ST"), getLabel("Common.BinLocation.label", "Common"), getLabel("Common.expiryDate.label", "Common"), getLabel("Common.TradeID.label", "Common"));
		var blankObject = checkSTFields(arrayObject, names, parent.parent.messageFrame);
		if (blankObject != true) {
//	blankObject.focus();
			return;
		}
		xmlString = "<root><SEARCH/></root>";
		// xmlDom.loadXML(xmlString);
		xmlDom = new DOMParser().parseFromString(xmlString, "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/PhysicalInventoryEntryApplyAddValidate.jsp?key_value=" + key_value + "&mode=add", false);
		xmlHttp.send(xmlDom);
		responseText = xmlHttp.responseText;
		eval(responseText);
	//	if (trimString(responseText) == "true")
	//result is a boolean variable declared in js file
		if (result) {
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + getMessage("RECORD_ALREADY_EXISTS", "ST");
			return;
		}
		frmObj.submit();
		clearAll();
	} else { //call while modifying value from the list
	}
	if (blankObject != true) {
//	blankObject.focus();
		return;
	}
	var key_value;
	var batch_id = formPhysicalInventoryEntryApplyAdd.batch_id.value;
	var item_qty = formPhysicalInventoryEntryApplyAdd.item_qty.value;
	var bin_loc_code = formPhysicalInventoryEntryApplyAdd.bin_loc_code.value;
	var expiry_date = formPhysicalInventoryEntryApplyAdd.expiry_date.value;
	var trade_id = formPhysicalInventoryEntryApplyAdd.trade_id.value;
	var key_value = batch_id + item_qty + bin_loc_code + expiry_date + trade_id + new_batch_YN;
	xmlString = "<root><SEARCH/></root>";
	//xmlDom.loadXML(xmlString);
	xmlDom = new DOMParser().parseFromString(xmlString, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/PhysicalInventoryEntryApplyAddValidate.jsp?key_value=" + key_value + "&mode=modify&dup=yes", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
	//	if (trimString(responseText) == "true")
	if (result) {
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + getMessage("RECORD_ALREADY_EXISTS", "ST");
		return;
	}
	key_value = parent.parent.framePhysicalInventoryEntryList.framePhysicalInventoryEntryListHeader.formPhysicalInventoryEntryApplyAdd.key_modify.value;
	batch_id = formPhysicalInventoryEntryApplyAdd.batch_id.value;
	item_qty = formPhysicalInventoryEntryApplyAdd.item_qty.value;
	bin_loc_code = formPhysicalInventoryEntryApplyAdd.bin_loc_code.value;
	expiry_date = formPhysicalInventoryEntryApplyAdd.expiry_date.value;
	trade_id = formPhysicalInventoryEntryApplyAdd.trade_id.value;
	var modify_value = batch_id + "~" + item_qty + "~" + bin_loc_code + "~" + expiry_date + "~" + trade_id + "~" + new_batch_YN;
	xmlString = "<root><SEARCH/></root>";
	//xmlDom.loadXML(xmlString);
	xmlDom = new DOMParser().parseFromString(xmlString, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/PhysicalInventoryEntryApplyAddValidate.jsp?key_value=" + key_value + "&mode=modify&dup=no&modify_value=" + modify_value, false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
	parent.parent.framePhysicalInventoryEntryList.framePhysicalInventoryEntryListHeader.formPhysicalInventoryEntryApplyAdd.Add.value = getLabel("Common.Add.label", "Common");
	clearAll();
	if (result) {
		parent.parent.framePhysicalInventoryEntryList.framePhysicalInventoryEntryListHeader.document.formPhysicalInventoryEntryApplyAdd.modify.value = "no";
		parent.framePhysicalInventoryEntryApplyAdded.location.href = "../../eST/jsp/PhysicalInventoryEntryApplyValues.jsp?modify=yes&fromDB=no";
		return;
	}
}
function submitCriteria() {
	var headerForm = document.formPhyInvEntryHeader;
	headerForm.submit();
}
function clearAll() {
	document.formPhysicalInventoryEntryApplyAdd.batch_id.value = "";
	document.formPhysicalInventoryEntryApplyAdd.item_qty.value = "";
	document.formPhysicalInventoryEntryApplyAdd.bin_loc_code.options[0].selected = true;
	document.formPhysicalInventoryEntryApplyAdd.expiry_date.value = "";
	document.formPhysicalInventoryEntryApplyAdd.trade_id.value = "";
	document.formPhysicalInventoryEntryApplyAdd.new_batch_YN.checked = true;
	
	//parent.framePhysicalInventoryEntryApplyAdd.formPhysicalInventoryEntryApplyAdd.Add.value = getLabel("Common.Add.label","Common");
	//parent.framePhysicalInventoryEntryApplyAdd.formPhysicalInventoryEntryApplyAdd.modify.value = "no";
	//parent.framePhysicalInventoryEntryApplyAdded.location.href="../../eST/jsp/PhysicalInventoryEntryApplyValues.jsp?modify=yes&fromDB=no";
	parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
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
function addToList() {
	var formObj = document.formPhysicalInventoryEntryApplyAdd;
	var phy_inv_id = parent.framePhysicalInventoryListDetail.document.getElementById('phy_inv_id').value;
	var store_code = eval("parent.parent.framePhysicalInventoryDetail.document.formPhysicalInventoryEntryDetail.store_code_" + formObj.index.value + ".value");
	var item_code = eval("parent.parent.framePhysicalInventoryDetail.document.formPhysicalInventoryEntryDetail.item_code_" + formObj.index.value + ".value");
	var gen_uom_desc = eval("parent.parent.framePhysicalInventoryDetail.document.formPhysicalInventoryEntryDetail.genuom_id_" + formObj.index.value + ".value");//Added by suresh.r on 29-07-2014 against MMS-SCF-0390
	if(formObj.allow_eqvl_uom.value=='Y'){
		var uom_code = formObj.uom_code.value;//Added by suresh.r on 03-03-2015 against MMS-QH-CRF-0205 Inc 52253
	}

	if(formObj.display_batch_lookup.value=='Y')
	{
		var arrayObject = new Array(formObj.batch_id, formObj.item_qty, formObj.bin_loc_code);
	   var names = new Array(getLabel("Common.BatchID.label", "Common"), getLabel("eST.ItemQuantity.label", "ST"), getLabel("Common.BinLocation.label", "Common"));
	
	}else 
	
	{
	var arrayObject = new Array(formObj.batch_id, formObj.item_qty, formObj.bin_loc_code, formObj.expiry_date, formObj.trade_id);
	var names = new Array(getLabel("Common.BatchID.label", "Common"), getLabel("eST.ItemQuantity.label", "ST"), getLabel("Common.BinLocation.label", "Common"), getLabel("Common.expiryDate.label", "Common"), getLabel("Common.TradeID.label", "Common"));
	}

	var blankObject = checkSTFields(arrayObject, names, parent.parent.parent.messageFrame);
	if (blankObject != true) {
		return;
	}
	refresh(formObj.index.value);
	xmlDom = "";
	// xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	var xmlHttp = new XMLHttpRequest();
	xmlString = "<root><SEARCH/></root>";
	//xmlDom.loadXML(xmlString);
	xmlDom = new DOMParser().parseFromString(xmlString, "text/xml");

	//added 'encodeURIComponent(formObj.batch_id.value,"UTF-8")' in the next line code against inc#38469
	//var key_add_batch=formObj.batch_id.value+formObj.bin_loc_code.value+formObj.expiry_date.value+formObj.trade_id.value;

	//var key_add_batch=encodeURIComponent(formObj.batch_id.value,"UTF-8")+formObj.bin_loc_code.value+formObj.expiry_date.value+formObj.trade_id.value;
	var key_add_batch=encodeURIComponent(formObj.batch_id.value,"UTF-8");
	//Modified by suresh.r on 29-07-2014 against MMS-SCF-0390 added gen_uom_desc
	//Modified by suresh.r Added uom_code on 03-03-2015 against MMS-QH-CRF-0205 Inc 52253
	if(formObj.allow_eqvl_uom.value=='Y'){
		xmlHttp.open("POST", "../../eST/jsp/PhysicalInventoryEntryApplyAddValidate.jsp?validate=ADDNEW&batch_id=" + encodeURIComponent(formObj.batch_id.value,"UTF-8") + "&item_qty=" + formObj.item_qty.value + "&bin_loc_code=" + formObj.bin_loc_code.value + "&expiry_date=" + formObj.expiry_date.value + "&trade_id=" + formObj.trade_id.value + "&index=" + formObj.index.value + "&new_batch_yn=Y" + "&item_code=" + item_code+"&key_add_batch="+key_add_batch+"&gen_uom_desc="+gen_uom_desc+"&uom_code="+uom_code, false);
	}else{
		xmlHttp.open("POST", "../../eST/jsp/PhysicalInventoryEntryApplyAddValidate.jsp?validate=ADDNEW&batch_id=" + encodeURIComponent(formObj.batch_id.value,"UTF-8") + "&item_qty=" + formObj.item_qty.value + "&bin_loc_code=" + formObj.bin_loc_code.value + "&expiry_date=" + formObj.expiry_date.value + "&trade_id=" + formObj.trade_id.value + "&index=" + formObj.index.value + "&new_batch_yn=Y" + "&item_code=" + item_code+"&key_add_batch="+key_add_batch+"&gen_uom_desc="+gen_uom_desc, false);
	}
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
	if(result)
	{
		//Added by suresh.r on 04-08-2014 against MMS-SCF-0390 beg
		var tmp_msg=message;tmp_flag=flag;
		if(formObj.allow_eqvl_uom.value=='Y'){//Added by suresh.r on 03-03-2015 against MMS-QH-CRF-0205 Inc 52253
			xmlHttp.open("POST", "../../eST/jsp/PhysicalInventoryEntryApplyAddValidate.jsp?validate=ALLOW_CONV_QTY&item_qty=" + (formObj.item_qty.value*formObj.conv_fact_0.value) + "&store_code=" + store_code + "&item_code=" + item_code, false);
		}else{
			xmlHttp.open("POST", "../../eST/jsp/PhysicalInventoryEntryApplyAddValidate.jsp?validate=ALLOW_CONV_QTY&item_qty=" + formObj.item_qty.value + "&store_code=" + store_code + "&item_code=" + item_code, false);
		}
		xmlHttp.send(xmlDom);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if(result)
		{
			message=tmp_msg;flag=tmp_flag;
		//Added by suresh.r on 04-08-2014 against MMS-SCF-0390 end
			if(message != "new batch") {
				var doIt= confirm("APP-ST0001 The Batch ID :"+' " '+flag+' " '+" already exists. Do you wish to continue with"+":  "+' " '+formObj.batch_id.value+' " '+" ?");
				if(doIt) {
					parent.location.href = "../../eST/jsp/PhysicalInventoryEntryListFrame.jsp?mode=" + MODE_MODIFY + "&index=" + formObj.index.value + "&fromDB=" + "&modify=" + "&store_code=" + store_code + "&item_code=" + item_code + "&phy_inv_id=" + phy_inv_id;
					parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
				}else{
					parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
					return;
				}
			}else{
					parent.location.href = "../../eST/jsp/PhysicalInventoryEntryListFrame.jsp?mode=" + MODE_MODIFY + "&index=" + formObj.index.value + "&fromDB=" + "&modify=" + "&store_code=" + store_code + "&item_code=" + item_code + "&phy_inv_id=" + phy_inv_id;
					parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
			}
		}else{//Added by suresh.r on 04-08-2014 against MMS-SCF-0390 beg
			alert(message);
			formObj.item_qty.focus();
			return;
		}//Added by suresh.r on 04-08-2014 against MMS-SCF-0390 end
	}else{
		parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + "APP-ST0001 The Batch ID already exists. Please enter a different batch id";
	}
}
function checkQuantity(i) {
	var bin_code = eval("document.forms[0].bin_loc_code_" + i);
	var trade_id = eval("document.forms[0].trade_id_" + i);
	//var check_yn = eval("document.forms[0].check_yn_"+i);
	var item_qty = eval("document.forms[0].item_qty_" + i).value;
	if (bin_code.value == "") {
		if (item_qty != "") {
			var msg = getLabel("Common.BinLocation.label", "Common") + " " + getLabel("Common.Cannotbeblank.label", "Common");
			alert(msg);
			//bin_code.focus();
			return;
		}
	}
	var tot_records = eval("document.forms[0].total_records").value;
	var tmp_flag = "1";
	for(var j=0;j<tot_records;j++){
		var item_qty_temp = eval("document.forms[0].item_qty_" + j).value;
		if(item_qty_temp!=""){
			tmp_flag = "2";
			break;
		}
	}
	if(tmp_flag=="1"){
		document.forms[0].entry_completed_yn.value = "N";
		document.forms[0].entry_completed_yn.checked = false;
	}
}
function getStore() {
	formObj = document.formPhysicalInventoryEntryHeader;
	//xmlDom = new ActiveXObject("Microsoft.XMLDom");
	//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	var xmlDom = "";
	var xmlHttp = new XMLHttpRequest();
	xmlString = "<root><SEARCH/></root>";
	//xmlDom.loadXML(xmlString);
	xmlDom = new DOMParser().parseFromString(xmlString,"text/xml");
	xmlHttp.open("POST", "../../eST/jsp/PhysicalInventoryEntryApplyAddValidate.jsp?validate=LOADSTORE&phy_inv_id=" + formObj.phy_inv_id.value, false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
//var prevObj = null; Commented for GHL-CRF-0413.7
//var prevColor = null;Commented for GHL-CRF-0413.7
function changeRowColor(obj) {
	/*
	if (prevObj != null) {
		prevObj.cells(1).className = prevColor;
	}
	prevObj = obj;
	prevColor = obj.cells(1).className;
	obj.cells(1).className = "STLIGHTPINK";
	*/
	//Added for GHL-CRF-0413.7 starts 
	var total = parent.framePhysicalInventoryDetail.document.formPhysicalInventoryEntryDetail.total_checkboxes.value;
	for(var i=0 ; i<total;i++){
		var trObject = eval(document.getElementById("tr_"+i))
		 if(trObject != undefined)
		  	trObject.cells[1].className = "QRYEVEN";
		 else{
			 trObject = eval("parent.framePhysicalInventoryDetail.document.formPhysicalInventoryEntryDetail.all.tr_"+i);
			 if(trObject != undefined)
				  	trObject.cells[1].className = "QRYEVEN";
		 }
	}
	obj.cells[1].className = "STLIGHTPINK";
	//Added for GHL-CRF-0413.7 ends
}
var prevObj_0 = null;
var prevColor_0 = null;
function colourChange(index,item_qty,totalrecs,entry_completed_yn)
{/*
	if(entry_completed_yn=='Y')
	{
	 var trObject = eval("document.getElementById("tr_")" + index);
	 if(trObject != undefined)
	  	trObject.cells(0).bgColor = "GREEN";
	 }
	else if(entry_completed_yn=='N'){
	if(item_qty>0)
	{
	var trObject = eval("document.getElementById("tr_")" + index);
	if(trObject != undefined)
	trObject.cells(0).bgColor = "ORANGE";
}else if(item_qty==0 && totalrecs>0 )
	{
	var trObject = eval("document.getElementById("tr_")" + index);
		if(trObject != undefined)
	trObject.cells(0).bgColor = "";
	}
} 
*///Added for GHL-CRF-0413.7 starts
	if(parent.framePhysicalInventoryDetail != null || parent.framePhysicalInventoryDetail!= undefined)
		var formObj = parent.framePhysicalInventoryDetail.document.formPhysicalInventoryEntryDetail;
	if(entry_completed_yn=='Y')
	{
	 var trObject = eval(document.getElementById("tr_" + index))
	 if(trObject != undefined)
	  	trObject.cells[0].bgColor = "GREEN";
	 else if(trObject == undefined &&  parent.framePhysicalInventoryDetail!= undefined){
		 trObject = eval("formObj.all.tr_" + index);
		 if(trObject != undefined)
			  	trObject.cells[0].bgColor = "GREEN";
	 }
	 }
	else if(entry_completed_yn=='N'){
	if(item_qty>0)
	{
	var trObject = eval(document.getElementById("tr_" + index))
	if(trObject != undefined)
	trObject.cells[0].bgColor = "ORANGE";
	 else if(trObject == undefined &&  parent.framePhysicalInventoryDetail!= undefined){
		 trObject = eval("formObj.all.tr_" + index);
		 if(trObject != undefined)
			  	trObject.cells[0].bgColor = "ORANGE";
	 }
}else if(item_qty==0 && totalrecs>0 )
	{
	var trObject = eval(document.getElementById("tr_" + index))
		if(trObject != undefined)
	trObject.cells[0].bgColor = "";
		 else if(trObject == undefined &&  parent.framePhysicalInventoryDetail!= undefined){
			 trObject = eval("formObj.all.tr_" + index);
			 if(trObject != undefined)
				  	trObject.cells[0].bgColor = "";
		 }
	}
} 	//Added for GHL-CRF-0413.7 ends
}
function checkyn(obj) {
	var flag ="1";
	for(var i=0;i<eval(document.formPhyInvEntryList.total_records.value);i++){
		if(eval("document.formPhyInvEntryList.item_qty_"+i).value!=""){
			if (obj.checked == true) {
				obj.value = "Y";
			} else {
				obj.value = "N";
			}
			return;
		}else{
			flag = "0";
		}
	}
	if(flag=="0" && obj.checked == true){
		alert("Enter atleast one Batch Quantity");
		obj.value="N";
		obj.checked=false;
	}
}
function checkDate1(obj)
{
	if(obj!='undefined' && obj!=null)
		top.expiryDateCheck=obj;
	
	if (obj!='undefined' && obj!=null && obj.value == "") {
		var msg = getLabel("Common.expiryDate.label", "Common") + " " + getLabel("Common.Cannotbeblank.label", "Common");
		alert(msg);
		//obj.value();
		//obj.focus();
		obj.value = '';
		       /*setTimeout(function() {
            obj.focus();
            obj.select(); 
        }, 0);  */
        return false ;
	}
	return true;
}
function checkDate2(obj)
{
	if(obj!='undefined' && obj!=null)
		top.expiryDateCheck=obj;
	
	if (top.expiryDateCheck!='undefined' && top.expiryDateCheck!=null && top.expiryDateCheck.value == "") {
		var msg = getLabel("Common.expiryDate.label", "Common") + " " + getLabel("Common.Cannotbeblank.label", "Common");
		alert(msg);
		//obj.value();
		//obj.focus();
		top.expiryDateCheck.value = '';
		       /*setTimeout(function() {
            obj.focus();
            obj.select(); 
        }, 0);  */
        return false ;
	}
	return true;
}
            
            
            
            
            
  
function refresh(index) {
	frmObj = parent.frames[0].document.forms[0];
	//xmlDom = new ActiveXObject("Microsoft.XMLDom");
	//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	
	var xmlHttp = new XMLHttpRequest();
	var xmlDom = "";
	var arrObj = frmObj.elements;
	var frmObjs = new Array();
	if (frmObj.name == null) {
		frmObjs = frmObj;
	} else {
		frmObjs[0] = frmObj;
	}
	var xmlString = "<root><SEARCH ";
	for (var frmCount = 0; frmCount < frmObjs.length; frmCount++) {
		frmObj = frmObjs[frmCount];
		var arrObj = frmObj.elements;
		for (var i = 0; i < arrObj.length; i++) {
			var val = "";
			if (arrObj[i].type == "checkbox") {
				if (arrObj[i].checked) {
					arrObj[i].value = "Y";
					val = arrObj[i].value;
				} else {
					arrObj[i].value = "N";
					val = arrObj[i].value;
				}
			} else {
				if (arrObj[i].type == "radio") {
					if (arrObj[i].checked) {
						val = arrObj[i].value;
					}
				} else {
					if (arrObj[i].type == "select-multiple") {
						for (var j = 0; j < arrObj[i].options.length; j++) {
							if (arrObj[i].options[j].selected) {
								val += arrObj[i].options[j].value + "~";
							}
						}
						val = val.substring(0, val.lastIndexOf("~"));
					} else {
						val = arrObj[i].value;
					}
				}
			}
			val = checkSpl(val);
			xmlString += arrObj[i].name + "=\"" + val + "\" ";
		}
	}
	xmlString += " /></root>";
	//xmlDom.loadXML(xmlString);
	xmlDom = new DOMParser().parseFromString(xmlString, "text/xml");

	xmlHttp.open("POST", "../../eST/jsp/PhysicalInventoryEntryApplyAddValidate.jsp?validate=REFRESHDETAIL&prev_index=" + index, false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
}

function searchVals(obj)
{
     
    var formObj = document.BatchSearchCriteria_Form;
	if(formObj==null)
    formObj=parent.frames[0].document.forms[0];
//Added By Sakti against CRF# - RUT-CRF-0081 icn#34757
	if (formObj.searchby[0].checked) {
			searchby = "D";
		}
	if (formObj.searchby[1].checked) {
			searchby = "S";
		}
		var includeExpiredBatchesasN = "";

	if(formObj.includeExpiredBatches.checked == true){
		includeExpiredBatchesasN = "Y";
	}else{
		includeExpiredBatchesasN =  "N";
	}
//Added ends
	//xmlDom = new ActiveXObject("Microsoft.XMLDom");
	//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	var xmlHttp = new XMLHttpRequest();
	var xmlDom = "";
	xmlString = "<root><SEARCH/></root>";
	//xmlDom.loadXML(xmlString);
	xmlDom = new DOMParser().parseFromString(xmlString, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/PhysicalInventoryEntryApplyAddValidate.jsp?validate=setstoreto"+"&to_store_code="+formObj.store_code_to.value+"&from_store_code="+formObj.store_code_from.value+"&batch_id="+formObj.batch_id.value+"&Trade_code="+formObj.Trade_code.value+"&cut_off_date_for_grn="+formObj.cut_off_date_for_grn.value+"&searchby="+searchby+"&period_of_expiry="+formObj.period_of_expiry.value+"&includeExpiredBatches="+includeExpiredBatchesasN, false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText); 
   
 
 parent.frameBatchSearchPhysicalInventoryEntryQueryResult.document.location.href = "../../eST/jsp/BatchSearchPhysicalInventoryEntryQueryResult.jsp?searchby="+searchby;
  
}
function sortOrder(obj,image1,image2)
{
    
	image=obj.getElementsByTagName('img')[0];
	var a = image.src.lastIndexOf('/');
	var b = image.src.substring(a+1,a+10);
	var order;
	if(b=='Ascending')
    {
	 image.src = image2;
	 order='Desc'
	}
	else
	{
       image.src = image1;
	   order='Asc';
	}
	//xmlDom = new ActiveXObject("Microsoft.XMLDom");
	//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	var xmlHttp = new XMLHttpRequest();
	var xmlDom = "";
	xmlString = "<root><SEARCH/></root>";
	//xmlDom.loadXML(xmlString);
	xmlDom = new DOMParser().parseFromString(xmlString, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/PhysicalInventoryEntryApplyAddValidate.jsp?validate=loadExpDtls"+"&order="+order+"&obj="+obj.name, false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
   searchVals();
}

// Added For the Next && Prev Buttons the Frame References are changed accordingly
function activeLink() {
//	alert(parent.frameBatchSearchQueryResult.document.forms[0].name);
	formObjCriteria = parent.frameBatchSearchPhysicalInventoryEntryQueryCriteria.document.BatchSearchCriteria_Form;
	formObjResult = parent.frameBatchSearchPhysicalInventoryEntryQueryResult.document.BatchsearchForm;
	if (formObjResult != null || formObjResult != undefined) {
		if (formObjResult.start.value != 0) {
			parent.frameBatchSearchPhysicalInventoryEntryQueryCriteria.BatchSearchCriteria_Form.previous.disabled = false;
		} else {
			parent.frameBatchSearchPhysicalInventoryEntryQueryCriteria.BatchSearchCriteria_Form.previous.disabled = true;
		}
		if (!((parseInt(formObjResult.start.value) + parseInt(formObjResult.displaySize.value)) >= formObjResult.totalRecords.value)) {
			parent.frameBatchSearchPhysicalInventoryEntryQueryCriteria.BatchSearchCriteria_Form.next.disabled = false;
		} else {
			parent.frameBatchSearchPhysicalInventoryEntryQueryCriteria.BatchSearchCriteria_Form.next.disabled = true;
		}
	}
}
function goNext() {
	formObj = parent.frameBatchSearchPhysicalInventoryEntryQueryResult.document.BatchsearchForm;
	start = parseInt(formObj.start.value) + parseInt(formObj.displaySize.value);
	end = parseInt(formObj.end.value) + parseInt(formObj.displaySize.value);
	var searchby = formObj.searchby.value;
	parent.frameBatchSearchPhysicalInventoryEntryQueryResult.document.location.href = "../../eST/jsp/BatchSearchPhysicalInventoryEntryQueryResult.jsp?from=" + start + "&to=" + end+ "&searchby=" + searchby;
}
function goPrev() {
	formObj = parent.frameBatchSearchPhysicalInventoryEntryQueryResult.document.BatchsearchForm;
	start = parseInt(formObj.start.value) - parseInt(formObj.displaySize.value);
	end = parseInt(formObj.end.value) - parseInt(formObj.displaySize.value);
	var searchby = formObj.searchby.value;
	parent.frameBatchSearchPhysicalInventoryEntryQueryResult.location.href = "../../eST/jsp/BatchSearchPhysicalInventoryEntryQueryResult.jsp?from=" + start + "&to=" + end+ "&searchby=" + searchby;
}
async function callBatchSearch() {
	
    var formObj = document.formPhysicalInventoryEntryApplyAdd;
	//var objForm = document.formPhysicalInventoryEntryHeader;
	//console.log(objForm);
	var store_code = document.getElementById('store_code').value;
	var phy_inv_id =document.getElementById('phy_inv_id').value;
	var item_code = document.getElementById('item_code').value;
//Added By Sakti against CRF# - RUT-CRF-0081 icn#34757
	var batch_id = "";
	if(formObj.display_batch_lookup.value == "B"){
		 batch_id = formObj.batch_id.value;
	}else{
		batch_id = "";
	}
//Added ends
		//var includeZeroStockBatches = "N";
		var includeZeroStockBatches = "Y";
		var includeExpiredBatches = "N";
		//var includeSuspendedBatches = "N";
		var includeSuspendedBatches = "Y";
		var searchFunction = "Y";
		var multipleSelect = "Y";
		
retVal = await parent.window.showModalDialog("../../eST/jsp/BatchSearchPhysicalInventoryEntryFrame.jsp?item_code="+item_code+"&store_code="+store_code+"&phy_inv_id="+phy_inv_id+"&to_store_code="+store_code+"&includeZeroStockBatches="+includeZeroStockBatches+"&includeExpiredBatches="+includeExpiredBatches+"&includeSuspendedBatches="+includeSuspendedBatches+"&searchFunction="+searchFunction+"&multipleSelect="+multipleSelect+"&batch_id="+batch_id,'','dialogHeight:80vh; dialogWidth:90vw; center:0; status: no; dialogLeft :200; dialogTop :10px;');

if(retVal!=undefined)
	{
if(retVal.length>0)
	{
	var bin_code;
	var trade_id;
for (var i=0;i<retVal.length;i++ )
{
	
      formObj.batch_id.value=retVal[parseInt(0)];
	   bin_code=retVal[parseInt(1)];
	  formObj.expiry_date.value=retVal[parseInt(2)];
      trade_name=retVal[parseInt(3)];
      trade_id=retVal[parseInt(4)];
	 // formObj.trade_id.add(trade_id);

}
	          listObject=  formObj.bin_loc_code;
	          listObject1=  formObj.trade_id;
	          var len = listObject.options.length;
	          var len1 = listObject1.options.length;
	    for (var k = len-1; k >=0 ; k--) {
				if(listObject.options[k].value==bin_code)
	          formObj.bin_loc_code.options.selectedIndex=k;	
	    	}
					for (var l = len1-1; l >=0 ; l--) {
				if(listObject1.options[l].value==trade_id)
	          formObj.trade_id.options.selectedIndex=l;
				
			}
	     /*for (var i = len1-1; i >= 0; i--) {
			 listObject1.remove(i);
		        }*/
		/* var opt1 = document.createElement("option");
             listObject.options.add(opt1); 
			 opt1.value=bin_code;
	         opt1.text=bin_code;*/
     /*  	var opt = document.createElement("option");
             listObject1.options.add(opt); 
			 opt.value=trade_id;
	         opt.text=trade_name;
	//formObj.bin_loc_code.options.selectedIndex=formObj.bin_loc_code.options.length-1;
	formObj.trade_id.options.selectedIndex=formObj.trade_id.options.length-1;*/

	formObj.trade_id.options.selectedIndex=formObj.trade_id.options.length-1;
	//Added By Sakti against CRF# - RUT-CRF-0081 icn#34757
	if(document.formPhysicalInventoryEntryApplyAdd.display_batch_lookup.value == "B"){
		document.formPhysicalInventoryEntryApplyAdd.new_batch_YN.checked= false;
	 }
//Added ends
	}
  }
}

function setValues(obj)
{
					index = obj.value;
					obj = eval('tr_'+index);
					var expiry_date=obj.cells[1].innerText;
					var batch_id = obj.cells[2].innerText;
					//var trade_name = obj.cells[3].innerText;
					//var trade_id = eval("document.getElementById("trade_id")"+index).value;
					//var bin_code = obj.cells[5].innerText;
					var batch_details = new Array;  
					batch_details[0]=batch_id;		
					//batch_details[1]=bin_code;		
					batch_details[2]=expiry_date;		
					//batch_details[3]=trade_name;		
					//batch_details[4]=trade_id;		
				   if(batch_details.length>0)
                	window.parent.parent.returnValue = batch_details;
				   else
                     window.parent.parent.returnValue = new Array;
}
function getVals()
{
				
	parent.parent.document.getElementById("dialog_tag").close(); 	
}


function CheckQuantity1(obj) {
	if(document.formPhysicalInventoryEntryApplyAdd.dec_allowed_yn.value=="Y"){
		if (!checkDoubleFormat(obj,false)) {
			return false;
		}
	}else{
		if (!checkIntegerFormat(obj,false)) {
			return false;
		}
	}
}

function checkCommittedQty(index,rowindex, callFrom) {//Added rowindex by suresh.r on 01-08-2014 against MMS-SCF-0390
	var formObj = document.formPhyInvEntryList;
	var tot_records = eval("document.forms[0].total_records").value;//Added by suresh.r on 01-08-2014 against MMS-SCF-0390
	var commited_qty = eval("formObj.committed_qty_"+ index +".value");
	var item_qty = eval("formObj.item_qty_"+ index +".value");
	if(document.forms[0].allow_eqvl_uom.value=="Y" && item_qty!=''){//Added by suresh.r on 01-08-2014 against 54362
		//Added getConvFact function against MMS-DM-SCF-0364 by Badmavathi B starts
		var item_code = eval("parent.parent.framePhysicalInventoryDetail.document.formPhysicalInventoryEntryDetail.item_code_" + rowindex + ".value");
		var uom_code = eval("formObj.uom_code_" + index + ".value");
		getConvFact(item_code,uom_code,index);
		//Added against MMS-DM-SCF-0364 by Badmavathi B ends
		item_qty=eval("document.forms[0].conv_fact_"+index).value*item_qty;
	}
	var qty_on_hand  = eval("formObj.qty_on_hand_"+ index +".value");
	if ( parseInt(item_qty) < parseInt(commited_qty) ){
		alert("Physical Qty cannot be less than Committed Qty \nQOH : " + qty_on_hand + "  Committed Qty : " + commited_qty + " Physical Qty : " + item_qty );
		eval("formObj.item_qty_"+ index +".focus()");
		//Added by suresh.r on 01-08-2014 against MMS-SCF-0390 beg
		for(var j=0;j<tot_records;j++){
			if(j==index){
				eval("document.forms[0].item_qty_" + j).disabled=false;
			}else{
				eval("document.forms[0].item_qty_" + j).disabled=true;
			}
		}
	}else{
		for(var j=0;j<tot_records;j++){
			eval("document.forms[0].item_qty_" + j).disabled=false;
		}
		checkAllowQty(index, rowindex);
	}//Added by suresh.r on 01-08-2014 against MMS-SCF-0390 end
}
//Added by suresh.r on 01-08-2014 against MMS-SCF-0390 beg
function checkAllowQty(index,rowindex){

	var obj=eval("document.forms[0].item_qty_"+index);
	var item_qty;//Added by suresh.r on 03-03-2015 against MMS-QH-CRF-0205 Inc 52253 
	if(document.forms[0].allow_eqvl_uom.value=='Y'){
		item_qty	 = obj.value*eval("document.forms[0].conv_fact_"+index).value;
	}else{
		item_qty	 = obj.value;
	}
	var tot_records = eval("document.forms[0].total_records").value;
	if(item_qty!=''){
		var store_code = eval("parent.parent.framePhysicalInventoryDetail.document.formPhysicalInventoryEntryDetail.store_code_" + rowindex + ".value");
		var item_code = eval("parent.parent.framePhysicalInventoryDetail.document.formPhysicalInventoryEntryDetail.item_code_" + rowindex + ".value");
		var xmlHttp = new XMLHttpRequest();
		var xmlString = getXMLString(null);  
		var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/PhysicalInventoryEntryApplyAddValidate.jsp?validate=ALLOW_CONV_QTY&item_qty=" + item_qty + "&store_code=" + store_code + "&item_code=" + item_code, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if (result) {
			for(var j=0;j<tot_records;j++){
				eval("document.forms[0].item_qty_" + j).disabled=false;
			}
		}else{
			alert(message);
			eval("obj.focus()");
			for(var j=0;j<tot_records;j++){
				if(j==index){
					eval("document.forms[0].item_qty_" + j).disabled=false;
				}else{
					eval("document.forms[0].item_qty_" + j).disabled=true;
				}
			}
		}
	}
	
}//Added by suresh.r on 01-08-2014 against MMS-SCF-0390 end
//Added by suresh.r on 03-03-2015 against MMS-QH-CRF-0205 Inc 52253 Beg
function getConvFact(item_code,uom_code,index){
		var xmlHttp = new XMLHttpRequest();
		var xmlString = getXMLString(null);  
		var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/PhysicalInventoryEntryApplyAddValidate.jsp?validate=BASE_UOM_QTY&uom_code=" + uom_code + "&item_code=" + item_code, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		eval("document.forms[0].conv_fact_" + index).value=message;
}
function set_Base_UOM_Qty(index){
	if(eval(document.getElementById("item_qty_"+index))!=""){
		
		//alert("document.getElementById('item_qty_'+index) 992 =" + document.getElementById("item_qty_"+index));
		eval(document.getElementById("id_base_uom_qty_"+index)).innerText=eval(document.getElementById("item_qty_"+index)).value*eval(document.getElementById("conv_fact_"+index)).value;
	}
}
function checkAllowQty_Add(obj){
	var item_qty;
	if(document.forms[0].allow_eqvl_uom.value=='Y'){
		item_qty	 = obj.value*eval("document.forms[0].conv_fact_0").value;
	}else{
		item_qty	 = obj.value;
	}
	if(item_qty!=''){
		var store_code = eval("document.forms[0].store_code.value");
		var item_code = eval("document.forms[0].item_code.value");
		var xmlHttp = new XMLHttpRequest();
		var xmlString = getXMLString(null);  
		var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/PhysicalInventoryEntryApplyAddValidate.jsp?validate=ALLOW_CONV_QTY&item_qty=" + item_qty + "&store_code=" + store_code + "&item_code=" + item_code, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if (!result) {
			alert(message);
			eval("obj.focus()");
		}
	}
	
}
//Added by suresh.r on 03-03-2015 against MMS-QH-CRF-0205 Inc 52253 end
//Added for GHL-CRF-0413.7 starts
function searchBarcode(e,bar_code,bean_id,bean_name){
	if(e.keyCode==13 || e.keyCode== 9  || e.keyCode== 0){
		var frmObj = formPhysicalInventoryEntryHeader;
		var barcode = bar_code.value;	
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		// xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");

		xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?&barcode=" + barcode + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE" +  "&validate=VALID_BARCODE", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if(result){
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			// xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");

			xmlHttp.open("POST", "../../eST/jsp/PhysicalInventoryEntryApplyAddValidate.jsp?&barcode=" + barcode  +"&store_code="+frmObj.store_code.value+  "&validate=VALID_BARCODE", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			if(result){
				resultArray = message.split(";");
				var  sel_item   = 	resultArray[0];
				modifyData1(sel_item);
			}
			else{
				if(getMessage(message, "ST") != ""){
					alert(getMessage(message, "ST"));//item-store combination not found
					frmObj.barcode.value = "";
					return false;
				}
				else{
				alert(getMessage("PHY_INV_BARCODE_NOT_FOUND", "ST"));//batch available in the id
				frmObj.barcode.value = "";
				return false;
				}
			}
		}else{
			alert(getMessage("ST_INVALID_BAR_CODE", "ST"));//not valid
			frmObj.barcode.value = "";
			return false;
		}
	}
}
function modifyData1(index) {
	var formObj="";
	if(parent.framePhysicalInventoryDetail.document!=null)
		 formObj = parent.framePhysicalInventoryDetail.document.formPhysicalInventoryEntryDetail;
	else
		 formObj = f_query_add_mod.framePhysicalInventoryDetail.document.formPhysicalInventoryEntryDetail;
		var trObject = eval("formObj.all.tr_" + index);
		changeRowColor(trObject);
		if (index == -1) {
			formObj = f_query_add_mod.framePhysicalInventoryDetail.document.formPhysicalInventoryEntryDetail;
			var formObj1 = parent.frames[2].f_query_add_mod.framePhysicalInventoryEntryList.framePhysicalInventoryEntryListHeader;//alert("formObj1"+formObj1.name);
		} else {
		var formObj1 = parent.framePhysicalInventoryEntryList.framePhysicalInventoryEntryListHeader;
		}
	if (formObj1 != null && formObj.prev_index.value != "") {
		frmObj = formObj1.document.forms[0];
    // xmlDom = new ActiveXObject("Microsoft.XMLDom");
    xmlDom = "" ;
		// xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    xmlHttp = new XMLHttpRequest();
		var arrObj = frmObj.elements;
		var frmObjs = new Array();
		if (frmObj.name == null) {
			frmObjs = frmObj;
		} else {
			frmObjs[0] = frmObj;
		}
		var xmlString = "<root><SEARCH ";
		for (var frmCount = 0; frmCount < frmObjs.length; frmCount++) {
			frmObj = frmObjs[frmCount];
			var arrObj = frmObj.elements;
			for (var i = 0; i < arrObj.length; i++) {
				var val = "";
				if (arrObj[i].type == "checkbox") {
					if (arrObj[i].checked) {
						arrObj[i].value = "Y";
						val = arrObj[i].value;
					} else {
						arrObj[i].value = "N";
						val = arrObj[i].value;
					}
				} else {
					if (arrObj[i].type == "radio") {
						if (arrObj[i].checked) {
							val = arrObj[i].value;
						}
					} else {
						if (arrObj[i].type == "select-multiple") {
							for (var j = 0; j < arrObj[i].options.length; j++) {
								if (arrObj[i].options[j].selected) {
									val += arrObj[i].options[j].value + "~";
								}
							}
							val = val.substring(0, val.lastIndexOf("~"));
						} else {
							val = arrObj[i].value;
						}
					}
				}
				val = checkSpl(val);
				xmlString += arrObj[i].name + "=\"" + val + "\" ";
			}
		}
		xmlString += " /></root>";
		// xmlDom.loadXML(xmlString);
		xmlDom = new DOMParser().parseFromString(xmlString, "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/PhysicalInventoryEntryApplyAddValidate.jsp?validate=REFRESHDETAIL&prev_index=" + formObj.prev_index.value+"&index="+index, false);
		xmlHttp.send(xmlDom);
		responseText = xmlHttp.responseText;
		eval(responseText);
	}
		var phy_inv_id = parent.PhysicalInventoryEntryHeaderFrame.document.formPhysicalInventoryEntryHeader.phy_inv_id.value;
		var store_code = eval("formObj.store_code_" + index + ".value");
		var item_code = eval("formObj.item_code_" + index + ".value");
		var store_desc = eval("formObj.store_desc_" + index + ".value");
		var item_desc = eval("formObj.item_desc_" + index + ".value");
		parent.frames[2].location.href = "../../eST/jsp/PhysicalInventoryEntryListFrame.jsp?mode=" + MODE_MODIFY + "&function_id=" + formObj.function_id.value + "&phy_inv_id=" + phy_inv_id + "&store_code=" + store_code + "&item_code=" + item_code + "&store_desc=" + store_desc + "&item_desc=" + escape(item_desc) + "&index=" + index ;
	    parent.PhysicalInventoryEntryHeaderFrame.formPhysicalInventoryEntryHeader.item_code.value=item_code;
		parent.PhysicalInventoryEntryHeaderFrame.formPhysicalInventoryEntryHeader.item_desc.value=item_desc;
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
		formObj.prev_index.value = index;
		setTimeout(clearBarcode, 1000);
}
function clearBarcode(){
	var index = parent.framePhysicalInventoryEntryList.framePhysicalInventoryEntryListHeader.formPhyInvEntryList.index_barcode.value;
	eval("parent.framePhysicalInventoryEntryList.framePhysicalInventoryEntryListHeader.formPhyInvEntryList.item_qty_"+ index +".focus()");
	parent.PhysicalInventoryEntryHeaderFrame.document.formPhysicalInventoryEntryHeader.barcode.value ="";
	parent.PhysicalInventoryEntryHeaderFrame.document.formPhysicalInventoryEntryHeader.barcode.focus();
}
//Added for GHL-CRF-0413.7 ends
