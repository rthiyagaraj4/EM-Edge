function create() {
	f_query_add_mod.location.href = "../../eST/jsp/OpeningStockFrame.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
}
function reset() {
	f_query_add_mod.location.reload();
}
function onSuccess() {
	f_query_add_mod.location.href = "../../eST/jsp/OpeningStockFrame.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
}
 function callItemSearchScreen() {
	var search_string = parent.frameOpeningStockListHeader.formOpeningStockListHeader.item_desc.value;
	var store_code = parent.parent.frameOpeningStockHeader.document.getElementById('store_code').value;
	var errorPage = "../../eCommon/jsp/error.jsp";
	var category = "A";
	var sole_source = "A";
	var ps_item = "A";
	var mfg_item = "A";
	var expiry = "A";
	var consignment = "A";
	var item_class = parent.parent.frameOpeningStockHeader.document.OpeningStockHeader.item_class_code.value;
	var item_class_check = parent.parent.frameOpeningStockHeader.document.OpeningStockHeader.item_class_check.value;
	if (item_class_check == "Y") {
		if ((item_class == "") || (item_class == "null")) {
			alert(getMessage("ITEM_CLASS_CANNOT_BLANK", "ST"));
		}
		if ((item_class_check == "Y") && ((item_class != "") && (item_class != "null"))) {
			sub1();
		}
	} else {
		sub1();
	}
	async function sub1() {
		var retVal =await callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment);
		var str =unescape(retVal);
		var arr = str.split(",");
		if (retVal != null) {
			var item_code = arr[0];
			var xmlHttp = new XMLHttpRequest();
			var xmlString = getXMLString(null);  
			var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/OpeningStockValidate.jsp?validate=VALIDATE_ITEM_CODE" + "&item_code=" + item_code + "&store_code=" + store_code + "", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			if (result) {
				parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");//getMessage("NOT_STOCK_ITEM");
				cancel_me();
				return;
			}
			var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/OpeningStockValidate.jsp?validate=ITEM_CODE" + "&item_code=" + item_code + "&store_code=" + store_code + "", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			if (result) {
				parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("OPENING_STOCK_DUPLICATE_ITEM", "ST");
				return;
			}
			parent.parent.parent.messageFrame.location = errorPage;
			document.formOpeningStockListHeader.item_code.value = arr[0];
			/** @Name - Priya
			* @Date - 23/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - To enable remarks look up button
			*/
			document.formOpeningStockListHeader.remark.disabled = false;
			 /**END**/
			/** @Name - Priya
			* @Date - 13/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - 'Allow Decimal Y/N' value of the selected item is assigned to the hidden field 'dec_allowed_yn'
			*/
			document.formOpeningStockListHeader.dec_allowed_yn.value = arr[27];
			if(document.formOpeningStockListHeader.dec_allowed_yn.value == "Y"){
			document.formOpeningStockListHeader.no_of_decimals.value=arr[28];
			}else{
				document.formOpeningStockListHeader.no_of_decimals.value=0;
			}
			/**END**/
			document.formOpeningStockListHeader.item_desc.value = arr[1];
			document.formOpeningStockListHeader.expiry_yn.value = arr[2];
			document.formOpeningStockListHeader.uom.value = arr[15];
			document.formOpeningStockListHeader.uom_code.value = arr[13];
			//document.formOpeningStockListHeader.document.getElementById("td_uom").innerHTML = "  <b> " + arr[15] + "</b>";
			document.getElementById("td_uom").innerHTML = "  <b> " + arr[15] + "</b>";
			document.formOpeningStockListHeader.trade_id_applicable_yn.value = arr[17];
			document.formOpeningStockListHeader.batch_id_applicable_yn.value = arr[18];
			document.getElementById("td_gen_uom").innerHTML = "  <b> " + arr[25] + "</b>";
			document.formOpeningStockListHeader.gen_uom.value = arr[25];
			//parent.frameOpeningStockListDetail.location.href = "../../eST/jsp/OpeningStockListDetail.jsp?item_desc=" + escape(retVal[1]) + "&item_code=" + retVal[0] + "&expiry_yn=" + retVal[2] + "&uom_code=" + retVal[13] + "&uom=" + retVal[15]+ "&batch_id_applicable_yn=" + retVal[18] + "&trade_id_applicable_yn=" + retVal[17]+ "&manufacturer_id=" + retVal[12] + "    ";
			//Added  by Rabbani #Inc no:43124 (RUT-SCF-0290) on 11-sep-2013
			parent.frameOpeningStockListDetail.location.href = "../../eST/jsp/OpeningStockListDetail.jsp?item_desc=" + escape(arr[1]) + "&item_code=" + arr[0] + "&expiry_yn=" + arr[2] + "&uom_code=" + arr[13] + "&uom=" + escape(arr[15]) + "&batch_id_applicable_yn=" + arr[18] + "&trade_id_applicable_yn=" + arr[17]+ "&manufacturer_id=" + arr[12] + "    ";
			//assignExpData();
			if(document.formOpeningStockListHeader.item_2d_barcode_yn.value !=undefined && document.formOpeningStockListHeader.item_2d_barcode_yn.value=="Y")//Added for MOHE-CRF-0167
			     setTimeout('assignData();',1000);
		}
		parent.parent.parent.f_query_add_mod.frameOpeningStockHeader.OpeningStockHeader.store_code_disabled.value = "disabled";
		parent.frameOpeningStockListHeader.formOpeningStockListHeader.adj_item_qty.focus();
	}
}
function ComputeCost() {
	var quantity = document.formOpeningStockListHeader.adj_item_qty.value;
	var value = document.formOpeningStockListHeader.item_cost_value.value;
	var cost = value / quantity;
	if (!(quantity != "" && value != "")) {
		document.getElementById("td_cost").innerText = "";
		document.formOpeningStockListHeader.item_unit_cost.value = "";
	} else {
		/**
		 * @Name - Priya
		 * @Date - 31/05/2010
		 * @Inc# - 
		 * @Desc -  To round up  td_cost with no_of_decimals_for_cost
		 */
		var no_of_decimals_for_cost =  document.formOpeningStockListHeader.no_of_decimals_for_cost.value;
		var x = setNumber(cost, no_of_decimals_for_cost);
		document.getElementById("td_cost").innerHTML = "<b>" + x + "</b>";
		//document.formOpeningStockListHeader.item_unit_cost.value=cost;
		document.formOpeningStockListHeader.item_unit_cost.value = x;
	}
}
function CheckQuantity() {
	if (document.formOpeningStockListHeader.adj_item_qty.value != null) {
		if (document.formOpeningStockListHeader.adj_item_qty.value == 0) {
			alert(getMessage("CANNOT_BE_ZERO", "Common"));
		}
	}
	isValidDouble(document.formOpeningStockListHeader.adj_item_qty);
	ComputeCost();
}
function CheckValue() {
	if (document.formOpeningStockListHeader.item_cost_value.value != null) {
		if (document.formOpeningStockListHeader.item_cost_value.value == 0) {
			alert(getMessage("CANNOT_BE_ZERO", "Common"));
		}
	}
	if (isValidDouble(document.formOpeningStockListHeader.quantity)) {
	}
	ComputeCost();
}
/*function ValidateItemCode(obj)
{
	if(document.formOpeningStockList.doc_type_code.value=="") return;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/OpeningStockItemValidate.jsp?validate=ITEM_CODE&doc_type_code=" + document.formStGeneralHeaderForSingleStore.doc_type_code.value, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);
}
*/
function setRemarks(){
 var formObj = document.formOpeningStockListHeader ;
 formObj.remarks.value=formObj.remarks.value ;

}
function addToList(obj) {

	var operation = obj;
	var formObj = parent.frameOpeningStockListHeader.document.formOpeningStockListHeader;
	var formObj1 = parent.parent.frameOpeningStockList.frameOpeningStockListDetail.document.formOpeningStockListDetail;
	var proceed = false;
	var messageFrame = parent.parent.messageFrame;
	var errorPage = "../../eCommon/jsp/error.jsp";
	var remarks = getLabel("Common.remarks.label", "Common");
	if (!SPCheckMaxLen(remarks, formObj.remarks, 200)) {
		return;
	}

	//To check that the sum of qty in detail esp = quantity in dtl
	var total_qty = 0;
	//var quantity=parent.frameOpeningStockListHeader.document.forms[0].adj_item_qty.value;
	var quantity = parent.frameOpeningStockListHeader.document.forms[0].tot_qty.value;
	var value = parent.frameOpeningStockListHeader.document.forms[0].item_cost_value.value;
	var arrayObject = new Array(parent.frameOpeningStockListHeader.document.forms[0].adj_item_qty, parent.frameOpeningStockListHeader.document.forms[0].item_cost_value);
	var names = new Array(getLabel("Common.Quantity.label", "Common"), getLabel("Common.Value.label", "Common"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.parent.messageFrame, errorPage);
	if (blankObject != true) {
		//blankObject.focus();
		return;
	}
	/*if(value == null || value == "") {
		alert(getMessage("VALUE_CANNOT_BE_BLANK"));
		parent.frameOpeningStockListHeader.document.forms[0].item_cost_value.focus();
		return;
	} */

	var no_of_batches_entered = 0;
	proceed = true;
	for (var i = 0; i < 10 && proceed; i++) {
		if (parent.frameOpeningStockListDetail.document.forms[0].elements["item_qty_" + i].value != "") {
			/**
			* @Name - Priya
			* @Date - 20/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - parseFloat is changed into eval as item_qty_ is having double values 
			*/
			item_qty = parent.frameOpeningStockListDetail.document.forms[0].elements["item_qty_" + i].value;
			if (item_qty == "") {
					item_qty = 0;
				}
			total_qty += parseFloat(item_qty);
			
			/**END**/
			// check for mandatory fields in detail frame
			if (parent.frameOpeningStockListDetail.document.forms[0].elements["expiry_date_or_receipt_date_" + i].value == "") {
				parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("DATE_NOT_BLANK", "ST");
				parent.frameOpeningStockListDetail.document.forms[0].elements["expiry_date_or_receipt_date_" + i].focus();
				proceed = false;
			} else {
				if (parent.frameOpeningStockListDetail.document.forms[0].elements["batch_id_" + i].value == "") {
					parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("BATCH_ID_NOT_BLANK", "ST");
					parent.frameOpeningStockListDetail.document.forms[0].elements["batch_id_" + i].focus();
					proceed = false;
				} else {
					if (parent.frameOpeningStockListDetail.document.forms[0].elements["trade_id_" + i].value == "") {
						parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("TRADE_ID_NOT_BLANK", "ST");
						parent.frameOpeningStockListDetail.document.forms[0].elements["trade_id_" + i].focus();
						proceed = false;
					} else {
						if (parent.frameOpeningStockListDetail.document.forms[0].elements["bin_location_code_" + i].value == "") {
							parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("BIN_LOCN_NOT_BLANK", "ST");
							proceed = false;
							parent.frameOpeningStockListDetail.document.forms[0].elements["bin_location_code_" + i].focus();
						} else {
							proceed = true;
							no_of_batches_entered = no_of_batches_entered + 1;
						}
					}
				}
			}
		}
	}
	if (proceed == true) {
		if (no_of_batches_entered <= 0) {
			parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("BATCH_DETAILS_NOT_BLANK", "ST");
			return;
		}
	}
	var no_of_decimals = parent.frameOpeningStockListHeader.document.forms[0].no_of_decimals.value;
	total_qty=total_qty.toFixed(no_of_decimals);

	if (proceed) {
		if (total_qty == quantity) {
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObj1), "text/xml");
			//xmlDoc.loadXML(getEnhancedXMLString(formObj1));
			/**
			* @Name - Priya 
			* @Date - 17/12/2009
			* @Inc# - IN017176
			* @Desc - To Display the character ® properly in Item desc without junck characters
			* added 'encodeURIComponent(formObj.item_desc.value,"UTF-8")' in the next line code
			*/
			//Added  by Rabbani #Inc no:43124 (RUT-SCF-0290) on 11-sep-2013
			if(formObj.doc_srl_no.value!="-1") {
			formObj1.uom.value    = parent.frameOpeningStockListHeader.document.getElementById("td_uom").innerHTML;
			formObj.gen_uom.value = parent.frameOpeningStockListHeader.document.getElementById("td_gen_uom").innerHTML;
			}
			
			//xmlHttp.open("POST", "../../eST/jsp/OpeningStockValidate.jsp?operation=" + operation + "&doc_srl_no=" + formObj.doc_srl_no.value + "&item_code=" + formObj.item_code.value + "&item_desc=" + encodeURIComponent(formObj.item_desc.value,"UTF-8") + "&adj_item_qty=" + formObj.adj_item_qty.value + "&item_unit_cost=" + formObj.item_unit_cost.value + "&item_cost_value=" + formObj.item_cost_value.value + "&remarks=" + encodeURIComponent(formObj.remarks.value,"UTF-8") + "&expiry_yn=" + formObj1.expiry_yn.value + "&batch_id_applicable_yn=" + formObj1.batch_id_applicable_yn.value + "&trade_id_applicable_yn=" + formObj1.trade_id_applicable_yn.value + "&stock_uom_code=" + formObj.uom_code.value + "&uom=" +  formObj1.uom.value+ "&gen_uom=" +formObj.gen_uom.value+ "&max_stk_qty=" + formObj.max_stk_qty.value + "&mm_trn_qty=" + formObj.tot_qty.value + "&validate=ADD_TO_LIST", false);
			
			//Added  by Rabbani #Inc no:43124 (RUT-SCF-0290) on 11-sep-2013
			xmlHttp.open("POST", "../../eST/jsp/OpeningStockValidate.jsp?operation=" + operation + "&doc_srl_no=" + formObj.doc_srl_no.value + "&item_code=" + formObj.item_code.value + "&item_desc=" + encodeURIComponent(formObj.item_desc.value,"UTF-8") + "&adj_item_qty=" + formObj.adj_item_qty.value + "&item_unit_cost=" + formObj.item_unit_cost.value + "&item_cost_value=" + formObj.item_cost_value.value + "&remarks=" + encodeURIComponent(formObj.remarks.value,"UTF-8") + "&expiry_yn=" + formObj1.expiry_yn.value + "&batch_id_applicable_yn=" + formObj1.batch_id_applicable_yn.value + "&trade_id_applicable_yn=" + formObj1.trade_id_applicable_yn.value + "&stock_uom_code=" + formObj.uom_code.value + "&uom=" + encodeURIComponent(formObj1.uom.value,"UTF-8") + "&gen_uom=" +encodeURIComponent(formObj.gen_uom.value,"UTF-8")+ "&max_stk_qty=" + formObj.max_stk_qty.value + "&mm_trn_qty=" + formObj.tot_qty.value + "&validate=ADD_TO_LIST", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			if (result) {
				refreshDetails(formObj.doc_srl_no.value);
			} else {
				parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "Common");
			}
		} else {
			alert(getMessage("QUANTIY_MUST_BE_EQUAL", "ST"));
		}
	}
}

// To refresh detail frame on click of Add
function refreshDetails(index) {
	if (index == "-1") {
		parent.parent.frameOpeningStockDetail.location.href = "../../eST/jsp/OpeningStockDetail.jsp?index=" + (index);
	} else {
		parent.parent.frameOpeningStockDetail.location.href = "../../eST/jsp/OpeningStockDetail.jsp?index=" + (index - 1);
	}
//sri	parent.parent.frameOpeningStockDetail.location.reload();
	parent.frameOpeningStockListHeader.location.href = "../../eST/jsp/OpeningStockListHeader.jsp";
	parent.frameOpeningStockListDetail.location.href = "../../eCommon/html/blank.html";
	parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
}
function apply() {
	var formObj = f_query_add_mod.frameOpeningStockDetail.document.formOpeningStockDetail;
	totalCBox = parseInt(formObj.total_checkboxes.value);
	var checkBoxObj = null;
	var forDeletion = "";
	var noDetailExists = true;
	var errorPage = "../../eCommon/jsp/error.jsp";
	var formObj = f_query_add_mod.frameOpeningStockDetail.document.formOpeningStockDetail;
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
	forDeletion = forDeletion.substring(0, forDeletion.length - 1);
	formObj.records_to_delete.value = forDeletion;
	var responseText = formApply(formObj, ST_CONTROLLER);
	eval(responseText);
	messageFrame.location.href = errorPage + "?err_num=" + message + "<BR>" + flag;
	if (result) {
		onSuccess();
	}
}
function populateData(item_code, doc_srl_no, expiry_yn, batch_id_applicable_yn, trade_id_applicable_yn, uom) {
	var trObject = eval(document.getElementById("tr_" + (doc_srl_no - 1)));
	changeRowColor(trObject);
	parent.frameOpeningStockList.frameOpeningStockListHeader.location.href = "../../eST/jsp/OpeningStockListHeader.jsp?item_code=" + item_code + "&doc_srl_no=" + doc_srl_no + "&uom=" + uom;
	parent.frameOpeningStockList.frameOpeningStockListDetail.location.href = "../../eST/jsp/OpeningStockListDetail.jsp?item_code=" + item_code + "&doc_srl_no=" + doc_srl_no + "&expiry_yn=" + expiry_yn + "&batch_id_applicable_yn=" + batch_id_applicable_yn + "&uom=" + uom + "&trade_id_applicable_yn=" + trade_id_applicable_yn;
}
function getBatchIDFromExpiryDate(expiry_date_object, i, flag) {

	var formObj = parent.frameOpeningStockListDetail.document.formOpeningStockListDetail;
	var localName = formObj.locale.value;
	var sys_date = document.forms[0].sys_date;
	var expiry_date_object_field = expiry_date_object;
	if(localName != "en") {
	expiry_date_object = convertDate(expiry_date_object.value, "DMY", localName, "en");
	}
	else{
		expiry_date_object = expiry_date_object.value;
	}
	if (isBefore(expiry_date_object.value, "DMY", "en")) { 
	}
	if (checkDateWithSysDatee(sys_date, expiry_date_object)) {
		if ((CheckDate(expiry_date_object_field)) && (flag == "E") && (expiry_date_object.value != "")) {
			var index = i;
			var expiry_date = expiry_date_object;
			if(localName != "en") {
				expiry_date = convertDate(expiry_date, "DMY", "en", localName);
				}
			var result = "";
			var start_index = 0;
			var end_index = 0;
			while (expiry_date.indexOf("/") != -1) {
				end_index = expiry_date.indexOf("/");
				result += expiry_date.substring(start_index, end_index);
				expiry_date = expiry_date.substring(end_index + 1);
			}
			result += expiry_date;
			parent.parent.frameOpeningStockList.frameOpeningStockListDetail.document.formOpeningStockListDetail.elements("batch_id_" + i).value = result;
		}
	} else {
		alert(getMessage("NOT_LESS_THAN_SYSDATE", "ST"));
		expiry_date_object.select();
		expiry_date_object.focus();
	}
}
function showCalendarLocal(id) {
	if(!document.getElementById(id).disabled) {
		var flag = showCalendar(id);
		document.getElementById(id).value="";//Edge Having issue as it is going in loop.
		document.getElementById(id).focus();
		return flag;
	}	
}
function cancel_me() {
	parent.frameOpeningStockListHeader.location.href = "../../eST/jsp/OpeningStockListHeader.jsp";
	parent.parent.frameOpeningStockList.frameOpeningStockListDetail.location.href = "../../eCommon/html/blank.html";
}
function ValidateItem(obj) {
	var formObj = parent.frameOpeningStockListHeader.document.formOpeningStockListHeader;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");	
	xmlHttp.open("POST", "../../eST/jsp/OpeningStockValidate.jsp?validate=ITEM_CODE&search_code=" + formObj.item_desc.value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);

	
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
var prevObj = null;
var prevColor = null;
function changeRowColor(obj) {
	tot = document.forms[0].total_checkboxes.value;
	tot = tot - 1;
	if (prevObj != null) {
		for (k = 0; k < 2; k++) {
			//prevObj.cells(k).className = prevColor;
			prevObj.cells[k].className = prevColor;
		}
	}
	prevObj = obj;
	//prevColor = obj.cells(1).className;
	prevColor = obj.cells[1].className;
	for (k = 0; k < 2; k++) {
		//obj.cells(k).className = "STLIGHTPINK";
		obj.cells[k].className = "STLIGHTPINK";
	}
}
function checkMaxLevel() {
	var formObj = document.formOpeningStockListHeader;
	if (!formObj.adj_item_qty.value == "") {
		if (formObj.max_stk_qty.value != null && !formObj.max_stk_qty.value == "") {
			if (parseFloat(formObj.adj_item_qty.value) > parseFloat(formObj.max_stk_qty.value)) {
				alert(getLabel("eST.exceedmaxStockLevel.label", "ST")); //exceed max Stock Level
			}
		}
	}
}
//12/11/2007(MM/DD/YYYY) Mahesh Conversion Factor Related Functions
function issueUOMQtyChk() {
	var formObj = parent.parent.frames[2].frames[0].document.formOpeningStockListHeader;
	toConvFactor();

	var conv_factor = formObj.tmp_conv.value;
	var dec_factor = ((formObj.tot_qty.value)) % (formObj.tmp_conv.value);
	if(formObj.dec_allowed_yn.value == 'N'){
	/*if (dec_factor > 0 && eval(conv_factor) > 1) {
		alert("Quantity Should Be In Multiples Of " + formObj.tmp_conv.value);
		return false;
	}else{
		return true;
	}*/
	} 
		return true;

}
function setTempConvFactor(tmp) {

	if (document.formOpeningStockListHeader == null) {
		parent.parent.frames[2].frames[0].document.formOpeningStockListHeader.tmp_conv.value = tmp;
	} else {
		document.formOpeningStockListHeader.tmp_conv.value = tmp;
	}
}
function toConvFactor() {
	var formObj = document.formOpeningStockListHeader;
	var item_code = "";
	if (formObj == null) {
		formObj = parent.parent.frames[2].frames[0].document.formOpeningStockListHeader;
		var store_code = document.getElementById('store_code').value;
	} else {
		//var store_code = parent.parent.frameOpeningStockHeader.document.OpeningStockHeader.store_code.value;
		var store_code = document.getElementById('store_code').value;
	}
	item_code = formObj.item_code.value;
	if (parent.frameIssueReturnDetail != null) {
		var formObj1 = parent.frameOpeningStockDetail.document.formOpeningStockDetail;
		item_code = formObj1.item_code.value;
	}
	var xmlHttp = new XMLHttpRequest();
	var xmlString = getXMLString(null);
	var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/OpeningStockValidate.jsp?validate=setToConv" + "&store_code=" + store_code + "&item_code=" + item_code, false);
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	eval(responseText);
	
}
function totalqty() {
	toConvFactor();
	var formObj = parent.parent.frames[2].frames[0].document.formOpeningStockListHeader;
	if (formObj == null) {
		formObj = parent.parent.frames[2].frames[0].document.formOpeningStockListHeader;
	}
	/** @Name - Priya
	* @Date - 15/02/2010
	* @Inc# - 19308
	* @Desc - Else is wrriten to assign empty for total qty when Item qty is empty
	*/
	if (formObj.adj_item_qty.value != "") {
		var no_of_decimals = formObj.no_of_decimals.value;
		var totalqty = eval(formObj.adj_item_qty.value * formObj.tmp_conv.value);
		formObj.tot_qty.value= totalqty.toFixed(eval(no_of_decimals));
	}else{
		formObj.tot_qty.value="";
	}
}
async function searchRemarks(objCode, objDesc) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.formOpeningStockListHeader.lang_id.value;
	dataTypeArray[0] = STRING;
	dataNameArray[1] = "module_id";
	dataValueArray[1] = "ST";
	dataTypeArray[1] = STRING;
	dataNameArray[2] = "trn_type";
	dataValueArray[2] = document.formOpeningStockListHeader.rem_trans_type.value;
	dataTypeArray[2] = STRING;
//	argumentArray[0]		 =		"SELECT DISTINCT mm.trn_remarks_code  code,mm.remarks_desc  description FROM  mm_trn_remarks_lang_vw  mm, ST_TRN_TYPE_FOR_REMARKS st WHERE  st.eff_status = 'E'   AND  st.trn_remarks_code = mm.trn_remarks_code AND   UPPER(mm.language_id) LIKE  UPPER(?) AND UPPER(mm.module_id) LIKE  UPPER(?)   AND  UPPER(st.trn_type)  LIKE  UPPER(?)     AND  mm.trn_remarks_code LIKE   UPPER(?)     AND  UPPER(mm.remarks_desc) LIKE  UPPER(?)  ";
	argumentArray[0] = document.formOpeningStockListHeader.SQL_ST_TRN_REMARKS_LOOKUP_SELECT.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "4,5";
	argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues =await CommonLookup(getLabel("Common.remarks.label", "Common"), argumentArray);
	var str =unescape(returnedValues);
	var arr = str.split(",");
	if ((returnedValues != null) && (returnedValues != "")) {
		objCode.value = arr[0];
		objDesc.value = arr[1];
	}
}

/**
	* @Name - Mahesh
	* @Date - 13/01/2010
	* @Inc# - IN015496
	* @Desc - function to validate decimal numbers for cost value
	*/
function isValidNumberCost(fld, e, maxInt, deci) {
	

	/*var disp_allowed_yn = "Y";
	if(document.forms[0].dec_allowed_yn!=undefined){
		disp_allowed_yn = document.forms[0].dec_allowed_yn.value;
	}
	if(disp_allowed_yn=="N"){
		deci = 0;
	}		*/
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
function checkDateWithSysDatee(entered_date, sys_date) {
	var enteredDateArray;
	var sysDateArray;
	//var enteredDate = entered_date.value;
	//var sysDate = sys_date.value;
	if (entered_date.length > 0 && sys_date.length > 0) {
		enteredDateArray = entered_date.split("/");
		sysDateArray = sys_date.split("/");
		var enteredDateObject = new Date(enteredDateArray[2], (enteredDateArray[1] - 1), enteredDateArray[0]);
		var sysDateObject = new Date(sysDateArray[2], (sysDateArray[1] - 1), sysDateArray[0]);
		if (Date.parse(sysDateObject) < Date.parse(enteredDateObject)) {
			/**
			  * If the sys_date is less than the entered_date date,
			  * i.e., The Entered date is greater than the Current System Date
			  * Then return false to indicate it is wrong..
			  */
			return false;
		} else {
			if (Date.parse(sysDateObject) >= Date.parse(enteredDateObject)) {
				return true;
			}
		}
	}
	return true;
}
function getGTINDetails (e,barcode){//Adding start for MOHE-CRF-0167
	if(e.keyCode==9 || e.keyCode== 13  || e.keyCode== 0){
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		var item_code = document.formOpeningStockListHeader.item_code.value;
		var store_code =parent.parent.frameOpeningStockHeader.OpeningStockHeader.store_code.value;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		//xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eST/jsp/OpeningStockValidate.jsp?&barcode=" + barcode.value+"&item_code="+item_code +"&store_code="+store_code+"&validate=GET_GTIN", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if(result){
			
			callItemSearchScreen("BARCODE",barcode.value);
			
		}else{
			if(item_code==""){
			document.formOpeningStockListHeader.barcode.value = "";
			 alert(getMessage(message, "ST"));
			}
		}
		
	}
}
function assignData(){
	var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		var item_code = document.formOpeningStockListHeader.item_code.value;
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	
		xmlHttp.open("POST", "../../eST/jsp/OpeningStockValidate.jsp?&item_code="+item_code +"&validate=ASSIGN_EXP", false);
			
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;

		eval(responseText);
	
}//Adding end for MOHE-CRF-0167
