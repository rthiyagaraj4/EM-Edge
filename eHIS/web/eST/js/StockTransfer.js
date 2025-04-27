var prevObj = null;
var prevColor = null;
async function deleterecord() {
	if( f_query_add_mod.frameStockTransferHeader==undefined){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	}
	var errorPage = "../../eCommon/jsp/error.jsp";
	var formObj = f_query_add_mod.frameStockTransferHeader.document.formStockTransferHeader;
	var prevMode = formObj.mode.value;
	if (prevMode == MODE_INSERT) {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("OPER_CANCELLED", "ST");
		return;
	}
if(formObj.tfr_delete_yn.value=="N"){
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("NO_DELETE_ACCESS_FOR_USER", "ST");;
	formObj.mode.value = MODE_MODIFY;
		return false;
}
	var result = await confirmDelete();
	if (result == YES) {
		f_query_add_mod.frameStockTransferHeader.document.formStockTransferHeader.mode.value = MODE_DELETE;
		var responseText = formApply(formObj, ST_CONTROLLER);
		eval(responseText);
		messageFrame.location.href = errorPage + "?err_num=" + message;
		if (result) {
			onSuccess();
		}
	} else {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + getMessage("OPER_CANCELLED", "ST");
	}
}
var finalizeType;
function create() {
	f_query_add_mod.location.href = "../../eST/jsp/StockTransferFrame.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
}
/**
	* @Name - Priya
	* @Date - 21/12/2009
	* @Inc# - IN017084
	* @Desc - To avoid the duplication records display in Modify mode
	*/
function Modify(obj) {
 	var errorPage = "../../eCommon/jsp/error.jsp";
	document.getElementById('readOnlyDiv').style.visibility='visible';
	parent.parent.messageFrame.location.href = errorPage + "?err_num="+getMessage("ST_PROCESSING_WAIT", "ST");
	var doc_no = obj.cells[1].innerText;
	var doc_type_code = obj.cells[6].innerText;
	var item_class_desc = obj.cells[5].innerText;
	//var item_class_code = obj.cells[7].innerText;
	var item_class_code = obj.cells[8].innerText;
	//var store_code  = obj.cells[3].innerText;  //14/09/11
	var store_code  = obj.cells[7].innerText;  //14/09/11
	parent.document.location.href = "../../eST/jsp/StockTransferFrame.jsp?mode=" + MODE_MODIFY + "&function_id=" + parent.parent.function_id + "&doc_type_code=" + doc_type_code + "&doc_no=" + doc_no + "&store_code=" + store_code +"&item_class_desc=" + item_class_desc + "&item_class_code=" + item_class_code;
}
function query() {
	f_query_add_mod.location.href = "../../eST/jsp/StockTransferQueryFrame.jsp?function_id=" + function_id;
}
function reset() {
	f_query_add_mod.location.reload();
}
function onSuccess() {
	f_query_add_mod.location.href = "../../eCommon/html/blank.html";
}
function searchPatient() {
	var patient_id = PatientSearch();
	var formObj = document.formStockTransferHeader;
	if (!((patient_id == null) || (patient_id == ""))) {
		formObj.patient_id.value = patient_id;
	}
	formObj.patient_id.focus();
}
async function callItemSearchScreen() {
	var search_string = "";
	parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	if (!document.formStockTransferListHeader.item_desc.readOnly) {
		search_string = document.formStockTransferListHeader.item_desc.value;
	}
	var store_code = parent.parent.frameStockTransferHeader.document.formStockTransferHeader.from_store_code.value;
	var to_store_code = parent.parent.frameStockTransferHeader.document.formStockTransferHeader.to_store_code.value;
	var category = "A";
	var sole_source = "A";
	var ps_item = "A";
	var mfg_item = "A";
	var expiry = "A";
	var consignment = "A";
	var item_class = parent.parent.frameStockTransferHeader.document.formStockTransferHeader.item_class_code.value;
//	var havingqty="Y";
	/* Added on 6/1/2005 by Ram
		chkitemstorecmb is added to display the  item check check box in  item search  query criteria page and it is used to check the item which exist in both the stores.
		 If that check box is checked it will display the items which is associated in both the stores and also have qty_on_hand >0 . If  there is no to_store  code , then assign blank to it.
		 */
	var chkitemstorecmb = "Y";
	var kit = "Y";
//	var retVal=callItemSearchWindow(search_string,store_code,category,sole_source,ps_item,mfg_item,expiry,item_class,consignment);
	//Modified by Sakti against AMS-CRF-0011 trn_type passing
	var retVal = await callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment,"TFR", chkitemstorecmb, to_store_code, "", "", kit);
	if (retVal != null) {
		if (retVal[0] == "kit") {
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/StockTransferValidate.jsp?kit_template_code=" + retVal[1] + "&validate=KIT_TEMPLATE&store_code=" + store_code+"&to_store_code="+to_store_code, false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			return;
		}
		parent.parent.frameStockTransferHeader.document.formStockTransferHeader.store_code_disabled.value = "disabled";
		document.formStockTransferListHeader.item_code.value = retVal[0];
		document.formStockTransferListHeader.item_desc.value = retVal[1];
		document.formStockTransferListHeader.item_desc.readOnly = true;
		document.formStockTransferListHeader.ItemDetails.disabled = false;
		document.formStockTransferListHeader.expiry_yn.value = retVal[2];
		document.formStockTransferListHeader.uom_code.value = retVal[13];
		document.getElementById('id_item_unit_cost').innerHTML = retVal[14];
		document.getElementById('id_uom').innerHTML = retVal[15];
		setDecimalParameters(retVal[27],retVal[28]);
		var formObj = document.formStockTransferListHeader;
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		if(to_store_code==""||to_store_code==null){
			var msg="APP-000001 " +getLabel("Common.ToStore.label", "Common")+" "+ getLabel("Common.Cannotbeblank.label", "Common");
			alert(msg);
			refreshDetails();
			return;
		}
		xmlHttp.open("POST", "../../eST/jsp/StockTransferValidate.jsp?item_code=" + formObj.item_code.value + "&store_code=" + store_code + "&item_qty=" + formObj.item_qty.value + "&to_store_code=" + to_store_code + "&validate=GET_STATUS", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if (result) {
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/StockTransferValidate.jsp?item_code=" + formObj.item_code.value + "&store_code=" + store_code + "&to_store_code=" + to_store_code + "&validate=MIN_MAX_STATUS", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
		}
		if (!result) {
			parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";//?err_num="+ getMessage(message);
			if (message == "PHY_INV_PROCESS_INITIATED") {
				alert(getMessage(message, "ST") + "\n" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + formObj.phy_inv_id.value);
			} else {
				alert(getMessage(message, "ST"));
			}
			refreshDetails();
		}
		if (result && retVal[27] == "N") {			
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/StockTransferValidate.jsp?item_code=" + formObj.item_code.value + "&fm_store_code=" + store_code + "&to_store_code=" + to_store_code + "&validate=CONV_CALCULATE", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
		}
		document.formStockTransferListHeader.item_qty.focus();
	}
}
function setStockDetails(_stock_item_yn, _to_stock_item_yn, _store_item_unit_cost, _available_stock, _conv_factor, _expired_stock) {
var allow_deci_yn = document.formStockTransferListHeader.allow_deci_yn.value;
if(allow_deci_yn=='N')
document.formStockTransferListHeader.no_deci.value = '0';
var num  = parseFloat(_available_stock/_conv_factor);
		document.getElementById('id_stock_available').innerText = num.toFixed(parseInt(document.formStockTransferListHeader.no_deci.value))
	//document.getElementById('lb_frm_store_qty_on_hand').innerText=(_available_stock/_conv_factor);
	document.getElementById('frm_store_qty_on_hand').value = parseFloat(_available_stock / _conv_factor);
	/**
	 * @Name - Priya
	 * @Date - 18/05/2010
	 * @Inc# - 
	 * @Desc -  As Item unit cost is already rounded up in validate page, the below round up function is removed
	 */
	//var unit_cost = setNumber(_store_item_unit_cost, 3);
	/*var unit_cost = _store_item_unit_cost;
	document.getElementById('id_item_unit_cost').innerText = unit_cost;
	document.getElementById('item_unit_cost').value = _store_item_unit_cost;*/
	//Modified by suresh.r on 11-08-2014 against Inc#50616 beg
	var unit_cost = _store_item_unit_cost*_conv_factor;
	var no_of_decimals_for_cost = eval(document.formStockTransferListHeader.no_of_decimals_for_cost.value);
	document.getElementById('id_item_unit_cost').innerText = setNumber(unit_cost,no_of_decimals_for_cost);
	document.getElementById('id_item_unit_cost').title =unit_cost;
	document.getElementById('item_unit_cost').value = setNumber(unit_cost,no_of_decimals_for_cost);
	//Modified by suresh.r on 11-08-2014 against Inc#50616 end
	document.formStockTransferListHeader.stock_item_yn.value = _stock_item_yn;
	/*	if (_to_stock_item_yn=="N") {
		document.formStockTransferListHeader.batchsearch.disabled=true;
		document.formStockTransferListHeader.edit.disabled=true;
		alert(getMessage("NOT_STOCK_ITEM","ST"));
		parent.location.reload();
	}*/
	if (_stock_item_yn == "Y") {
		if (_available_stock == "0") {
			//alert(getMessage("STOCK_NOT_AVAILABLE","ST"));
			//parent.location.reload();
		}
	} else {
		document.formStockTransferListHeader.batchsearch.disabled = true;
		document.formStockTransferListHeader.edit.disabled = true;
		//alert(getMessage("NOT_STOCK_ITEM","ST"));
		//parent.location.reload();
	}
}
function ComputeCost() {
	var quantity = document.formStockTransferListHeader.item_qty.value;
	var cost = document.getElementById('item_unit_cost').value;
	if (isNaN(quantity) || isNaN(cost)) {
		document.getElementById('id_item_sal_value').innerText = "";
		return;
	}
	/**
	 * @Name - Priya
	 * @Date - 26/05/2010
	 * @Inc# - 
	 * @Desc -  To round up item cost value based on the no_of_decimals_for_cost column in st_acc_entity_param table
	 */
	var no_of_decimals_for_cost = eval(document.formStockTransferListHeader.no_of_decimals_for_cost.value);
	var value = setNumber(quantity * cost, no_of_decimals_for_cost);
	//var value = setNumber(quantity * cost, 3);
	document.getElementById('id_item_sal_value').innerText = value;
}
function CheckQuantity() {
	if (!checkDoubleFormat(document.formStockTransferListHeader.item_qty)) {
		return false;
	}
	if (parseFloat(document.formStockTransferListHeader.item_qty.value) > parseFloat(document.getElementById('id_stock_available').innerText)) {
		alert(getMessage("QTY_NOT_GRT_AVLQTY", "ST"));
		document.formStockTransferListHeader.item_qty.value ="";//Edge Having issue as it is going in loop, so have to clear.
		document.formStockTransferListHeader.item_qty.focus();
		return false;
	}
	ComputeCost();
}
function CheckDtlQuantity(index) {
	if (!checkDoubleFormat(eval("document.formStockTransferListDetail.item_qty_" + index))) {
		return false;
	}
	if (parseFloat(eval("document.formStockTransferListDetail.item_qty_" + index + ".value")) > parseFloat(eval(document.getElementById('id_stock_avail_'+ index).innerText))) {
		alert(getMessage("QTY_NOT_GRT_AVLQTY", "ST"));
		eval("document.formStockTransferListDetail.item_qty_" + index + ".value()=''");//Edge Having issue as it is going in loop, so have to clear.
		eval("document.formStockTransferListDetail.item_qty_" + index + ".focus()");
		return false;
	}
}
function CheckValue() {
	if (document.formStockTransferListHeader.item_cost_value.value != null) {
		if (document.formStockTransferListHeader.item_cost_value.value == 0) {
			alert(getMessage("CANNOT_BE_ZERO", "Common"));
		}
	}
	if (isValidDouble(document.formStockTransferListHeader.quantity)) {
	}
	ComputeCost();
}
function addToList() {
	var formObj = parent.frameStockTransferListHeader.document.formStockTransferListHeader;
	var arrayObject = new Array(formObj.item_code, formObj.item_qty);
	var names = new Array(getLabel("Common.item.label", "Common"), getLabel("Common.Quantity.label", "Common"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.parent.messageFrame);
	var store_code = parent.parent.frameStockTransferHeader.document.formStockTransferHeader.from_store_code.value;
	if (blankObject == true) {
		if (parent.frameStockTransferListDetail.document.formStockTransferListDetail == null) {
			var formObj = document.formStockTransferListHeader;
			var _item_code = formObj.item_code.value;
			// Needs To Be changed,.....................3/11/2010
			var item_qty = 0.0;
			item_qty = formObj.ret_qty.value;
			parent.frameStockTransferListDetail.location.href = "../../eST/jsp/StockTransferListDetail.jsp?function=edit&store_code=" + store_code + "&item_code=" + _item_code + "&item_qty=" + item_qty + "&function_id=" + parent.parent.function_id + "&addToList=true" + "&tmp_conv=" + formObj.tmp_conv.value + "&frm_tmp_conv=" + formObj.frm_tmp_conv.value + "&kit=kit";
			return;
		}
		var formObjDtl = parent.parent.frameStockTransferList.frameStockTransferListDetail.document.formStockTransferListDetail;
		var proceed = false;
		var messageFrame = parent.parent.messageFrame;
		var errorPage = "../../eCommon/jsp/error.jsp";
		var item_qty = formObj.ret_qty.value;
		/*if(formObj.kit_item_yn.value=="N" || formObj.kit_item_yn.value==''){
			item_qty = formObj.item_qty.value * formObj.frm_tmp_conv.value;
		}else{
			item_qty = formObj.item_qty.value;
		}*/
		_total_checkboxes = formObjDtl.total_checkboxes.value;
		var sum = 0.0;
		for (i = 0; i < _total_checkboxes; i++) {
			var qty = eval("formObjDtl.item_qty_" + i).value;
			if (qty == "") {
				qty = 0;
			}
			if (!isNaN(qty)) {
				sum += parseFloat(qty);
			}
			if (eval("formObjDtl.to_bin_location_code_" + i).value == "") {
				/**
				 * @Name - Priya
				 * @Date - 18/06/2010
				 * @Inc# - 22197
				 * @Desc -  To give correct alert message
				 */
				//alert(getMessage("TO_BIN_LOC_NOT_BLANK", "ST"));
				var alertMsg = getMessage("CAN_NOT_BE_BLANK", "common");
				alertMsg = alertMsg.replace("$", getLabel("eST.ToStoreMasterBin.label", "ST"));
				alert(alertMsg);
				return;
			}
		}
		/*if (eval(formObj.item_qty.value)==""){
		alert(getMessage("QTY_TO_TFER_NOT_BLANK","ST"));
		return;
	}*/
		if (setNumber(sum,parseInt(formObj.no_deci.value))!= setNumber(item_qty,parseInt(formObj.no_deci.value))) {
			alert(getMessage("QUANTIY_MUST_BE_EQUAL", "ST"));
			return;
		}
	
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getEnhancedXMLString(formObjDtl));
		xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObjDtl), "text/xml");
		storealt = parent.parent.frames[0].document.forms[0].from_store_code.value;
		/**
			* @Name - Priya 
			* @Date - 18/12/2009
			* @Inc# - IN017176
			* @Desc - To Display the character ® properly in Item desc without junck characters
			* added 'encodeURIComponent(formObj.item_desc.value,"UTF-8")' in the next line code
			*/
		var item_qty = formObj.item_qty.value * formObj.frm_tmp_conv.value;
		xmlHttp.open("POST", "../../eST/jsp/StockTransferValidate.jsp?index=" + formObj.index.value + "&doc_srl_no=" + formObj.doc_srl_no.value + "&item_code=" + formObj.item_code.value + "&store_code=" + store_code + "&uom_code=" + formObj.uom_code.value + "&item_desc=" + encodeURIComponent(formObj.item_desc.value,"UTF-8") + "&item_qty=" + formObj.item_qty.value + "&item_unit_cost=" + document.getElementById('item_unit_cost').value + "&stock_item_yn=" + formObj.stock_item_yn.value + "&item_cost_value=" + document.getElementById('id_item_sal_value').innerText + "&expiry_yn=" + formObj.expiry_yn.value + "&store_alt_code=" + storealt + "&uom_desc=" + encodeURIComponent(document.getElementById('id_uom').innerText,"UTF-8") + "&stock_available=" + document.getElementById('id_stock_available').innerText + "&expired_batch=" + formObjDtl.expired_batch.value + "&ex_param_days=" + formObjDtl.ex_param_days.value + "&frm_store_qty_on_hand=" + formObj.frm_store_qty_on_hand.value + "&frm_store_min_stk_level=" + formObj.frm_store_min_stk_level.value + "&frm_store_max_stk_level=" + formObj.frm_store_max_stk_level.value + "&frm_store_reorder_level=" + formObj.frm_store_reorder_level.value + "&to_store_qty_on_hand=" + formObj.to_store_qty_on_hand.value + "&to_store_min_stk_level=" + formObj.to_store_min_stk_level.value + "&to_store_max_stk_level=" + formObj.to_store_max_stk_level.value + "&to_store_reorder_level=" + formObj.to_store_reorder_level.value + "&to_conv_fact=" + formObj.tmp_conv.value + "&frm_conv_fact=" + formObj.frm_tmp_conv.value + "&frm_store_uom_desc=" + formObj.frm_store_uom_desc.value + "&batch_records=" + formObjDtl.total_checkboxes.value + "&to_store_uom_desc=" + formObj.to_store_uom_desc.value +"&allow_yn="+formObj.allow_deci_yn.value+"&no_decimals="+formObj.no_deci.value+"&kit_item_yn="+formObj.kit_item_yn.value+"&from_multiples="+formObj.from_multiples.value+"&to_multiples="+formObj.to_multiples.value+"&batch_multiples="+formObj.batch_multiples.value+"&usage_type="+formObj.usage_type.value+"&validate=ADD_TO_LIST", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if (result) {
			var formObj = document.formStockTransferListHeader;
			var store_code = parent.parent.frameStockTransferHeader.document.formStockTransferHeader.from_store_code.value;
			//alert("store_code alert:" +store_code);
			var arr = "";
			for (i = 0; i < parent.parent.frameStockTransferDetail.document.forms[0].total_checkboxes.value; i++) {
				if ((eval("parent.parent.frameStockTransferDetail.document.forms[0].checkbox" + i).checked)) {
					arr = arr + "," + "CHECKED";
				} else {
					arr = arr + "," + "s";
				}
			}
			parent.parent.frameStockTransferDetail.location.href = "../../eST/jsp/StockTransferDetail.jsp?function_id=" + parent.parent.function_id + "&item_code=" + formObj.item_code.value + "&index=" + formObj.index.value + "&avail_qty=" + document.getElementById('id_stock_available').innerText + "&store_code=" + store_code + "&arr=" + arr + "&tmp_conv=" + formObj.tmp_conv.value + "&frm_tmp_conv=" + formObj.frm_tmp_conv.value + "&kit12=" + formObj.kit.value;
			refreshDetails();
	 	
		} else {
			parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
		}
	}
}
function refreshDetails() {
   //parent.parent.frameStockTransferDetail.location.reload();
	parent.frameStockTransferListHeader.location.href = "../../eST/jsp/StockTransferListHeader.jsp";
	parent.frameStockTransferListDetail.location.href = "../../eCommon/html/blank.html";
	
	//parent.document.getElementById("frameStockTransferListHeader").style.height="42vh"; //Edge
	//parent.document.getElementById("frameStockTransferListDetail").style.height="58vh"; //Edge
}
async function apply() {
if( f_query_add_mod.frameStockTransferDetail==undefined){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	}
	var formObj = f_query_add_mod.frameStockTransferDetail.document.formStockTransferDetail;
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
	for (i = 0; i < f_query_add_mod.frameStockTransferDetail.document.formStockTransferDetail.total_checkboxes.value; i++) {
		if ((eval("f_query_add_mod.frameStockTransferDetail.document.formStockTransferDetail.checkbox" + i).checked)) {
		} else {
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/StockTransferValidate.jsp?validate=ZERO_QUANTITY&index=" + i, false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			if (!result) {
				messageFrame.location.href = errorPage + "?err_num=" + getMessage("ISS_QTY_CANNOT_BE_ZERO", "ST");
				return;
			}
		}
	}
	xmlHttp.open("POST", "../../eST/jsp/StockTransferValidate.jsp?validate=VALIDATE_DATA", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	if (!result) {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST") + " " + getLabel("eST.forItemCode.label", "ST") + " - " + flag;
		return;
	}
	var formObj = f_query_add_mod.frameStockTransferHeader.document.formStockTransferHeader;
	forDeletion = forDeletion.substring(0, forDeletion.length - 1);
	formObj.records_to_delete.value = forDeletion;
	finalizeType = "N";
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/StockTransferValidate.jsp?validate=CHECK_AUTHORIZE_ALLOWED&store_code=" + formObj.from_store_code.value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
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
		//Added ended
		
		
		if(response=="")
		{
		messageFrame.location.href = errorPage + "?err_num=";
		return false;
		}
		if (response == YES) {
			formObj.finalize_yn.value = YES;
		}
	}
	/*	if (formObj.authorize_yn.value==YES)
	{
		finalizeType = confirmFinalize();
	}
	formObj.finalize_yn.value = finalizeType;
    */
	responseText = formApply(formObj, ST_CONTROLLER);
	eval(responseText);
	flag1 = (flag.split("~"))[0];
	flag2 = (flag.split("~"))[1];
	flag1 = (flag1 == "null" ? "" : flag1);
	if (result) {
		if (flag2 == "PY") {
				  //if(formObj.finalize_allowed_yn.value=="Y")
				 // {
			var PConfirm =  await confirmPrinting();

			if (PConfirm == "Yes") {
				var xmlHttp = new XMLHttpRequest();
				var xmlDoc="";
				//xmlDoc.loadXML(getXMLString(null));
				xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
				//xmlHttp.open("POST", "../../eST/jsp/StockTransferValidate.jsp?validate=printOnlineDoc&msg=" + encodeURIComponent(message), false);
				xmlHttp.open("POST", "../../eST/jsp/StockTransferValidate.jsp?validate=printOnlineDoc&msg=" + encodeURIComponent(message), true);
				xmlHttp.send(xmlDoc);
				//responseText = xmlHttp.responseText;
				//eval(responseText);
			}
			 // }
		} else 	if (flag2 == "PN") {
				var xmlHttp = new XMLHttpRequest();
				var xmlDoc="";
				//xmlDoc.loadXML(getXMLString(null));
				xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
				//xmlHttp.open("POST", "../../eST/jsp/StockTransferValidate.jsp?validate=printOnlineDoc&msg=" + encodeURIComponent(message), false);
				xmlHttp.open("POST", "../../eST/jsp/StockTransferValidate.jsp?validate=printOnlineDoc&msg=" + encodeURIComponent(message), true);
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
		messageFrame.location.href = errorPage + "?err_num=" + message;
	}


	flg = flag.split("~");
	messageFrame.location.href = errorPage + "?err_num=" + message + "<BR>" + ((result) ? flag1 : flg[0]);
	if (result) {
		onSuccess();
	} else {
		if (flag != "") {
			for (i = 0; i < (frames[1].frames[1].document.getElementById('tab1').rows.length) - 1; i++) {
				obj2 = eval(frames[1].frames[1].document.getElementById('tr_' + i));
				if (i % 2 == 0) {
					bg = "QRYEVEN";
				} else {
					bg = "QRYODD";
				}
				for (k = 0; k < 2; k++) {
					obj2.cells[k].className = bg;
				}
			}
			obj2 = eval(frames[1].frames[1].document.getElementById('tr_' + flg[1]));
			for (k = 0; k < 2; k++) {
				obj2.cells[k].className = "STLIGHTPINK";
			}
				//f_query_add_mod.frameStockTransferDetail.location.href="../../eST/jsp/StockTransferDetail.jsp?function_id="+function_id+"&index="+flg[1];
		}
	}
}
function cancel_me() {
	parent.frameStockTransferListHeader.location.href = "../../eST/jsp/StockTransferListHeader.jsp";
	parent.parent.frameStockTransferList.frameStockTransferListDetail.location.href = "../../eCommon/html/blank.html";
}
function editViewBatch() {
	parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	var formObj = document.formStockTransferListHeader;
	var arrayObject = new Array(formObj.item_code, formObj.item_qty);
	var names = new Array(getLabel("Common.item.label", "Common"), getLabel("Common.Quantity.label", "Common"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.parent.messageFrame);
	if (blankObject == true) {
		var store_code = parent.parent.frameStockTransferHeader.document.formStockTransferHeader.from_store_code.value;
		var _item_code = formObj.item_code.value;
		var item_qty = formObj.ret_qty.value;
	
		parent.frameStockTransferListDetail.location.href = "../../eST/jsp/StockTransferListDetail.jsp?function=edit&store_code=" + store_code + "&item_code=" + _item_code + "&item_qty=" + item_qty + "&function_id" + parent.parent.function_id + "&tmp_conv=" + formObj.tmp_conv.value + "&frm_tmp_conv=" + formObj.frm_tmp_conv.value;
	}
}
async function callBatchSearch() {
	parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	var formObj = document.formStockTransferListHeader;//parent.frameStockTransferListHeader.formStockTransferListHeader;
	var arrayObject = new Array(formObj.item_code, formObj.item_qty);
	var names = new Array(getLabel("Common.item.label", "Common"), getLabel("Common.Quantity.label", "Common"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.parent.messageFrame);
	if (blankObject == true) {
		var store_code = parent.parent.frameStockTransferHeader.document.formStockTransferHeader.from_store_code.value;
		var formObj1 = parent.parent.frameStockTransferHeader.document.formStockTransferHeader;
		var _item_code = formObj.item_code.value;
		var item_qty = formObj.ret_qty.value;
		
		var includeZeroStockBatches = "N";
		var includeExpiredBatches = "Y";
		var includeSuspendedBatches = "N";
		var searchFunction = "Y";
		var multipleSelect = "Y";
		var retval = await callBatchSearchWindow(_item_code, store_code, includeZeroStockBatches, includeExpiredBatches, includeSuspendedBatches, searchFunction, multipleSelect, "", formObj1.doc_type_code.value, formObj1.doc_no.value, formObj1.trn_type.value);
		if (retval != null && retval!="" && retval!=undefined) {
			parent.frameStockTransferListDetail.location.href = "../../eST/jsp/StockTransferListDetail.jsp?function=search&batchsearch=newbatch&store_code=" + store_code + "&item_code=" + _item_code + "&item_qty=" + item_qty + "&function_id" + parent.parent.function_id + "&index=" + formObj.index.value + "&tmp_conv=" + formObj.tmp_conv.value + "&frm_tmp_conv=" + formObj.frm_tmp_conv.value;
		}
	}
}
function modifyData(index, item_code) {
 	var formObj = document.formStockTransferDetail;
	var to_store_code = parent.frameStockTransferHeader.document.formStockTransferHeader.to_store_code.value;
	  var store_code = parent.frameStockTransferHeader.document.formStockTransferHeader. from_store_code.value;
	var trObject = eval(document.getElementById('tr_'+ index));
	 changeRowColor(trObject);

	parent.frameStockTransferList.location.href = "../../eST/jsp/StockTransferListFrame.jsp?function=modify&index=" + index + "&function_id=" + parent.parent.function_id + "&item_code=" + item_code + "&to_store_code=" + to_store_code +"&store_code=" + store_code + "&ret_qty=" + formObj.ret_qty.value+"&allow_deci_yn="+formObj.allow_deci_yn.value+"&no_deci="+formObj.no_deci.value+ "&BARCODE_YN=" + formObj.BARCODE_YN.value;
}
function setFinalize_allowed(_finalize_allowed_yn) {
	f_query_add_mod.frameStockTransferHeader.document.formStockTransferHeader.finalize_allowed_yn.value = _finalize_allowed_yn;
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
async function showHistory(trObj, index) {
	var trObj = eval(document.getElementById('tr_'+ index));
	var item_desc = parent.frameStockTransferListHeader.document.formStockTransferListHeader.item_desc.value;
	var item_code = parent.frameStockTransferListHeader.document.formStockTransferListHeader.item_code.value;
	var manufacturer_name = eval("document.formStockTransferListDetail.manufacturer_name_" + index + ".value");
	var expiry_date = trObj.cells[0].innerText.substring(0, 10);
	var batch_id = trObj.cells[1].innerText;
	var trade_name = trObj.cells[2].innerText;
	var uom_desc = parent.frameStockTransferListHeader.document.getElementById('id_uom').innerHTML;
	retvalue = await window.showModalDialog("../../eST/jsp/SuspendOrReinstateBatchHistory.jsp?function_id=" + parent.parent.function_id + "&item_code=" + escape(item_code) + "&batch_id=" + batch_id + "&expiry_date=" + expiry_date + "&trade_name=" + trade_name + "&item_desc=" + escape(item_desc) + "&uom_desc=" + escape(uom_desc) + "&manufacturer_name=" + escape(manufacturer_name), "", "dialogHeight:30vh; dialogWidth:55vw; center:0; status: no; dialogLeft :75; dialogTop :250;");
}
function checkminmaxstatus() {
 
	var formObj = document.formStockTransferListHeader;
	if ((parseInt(formObj.frm_store_qty_on_hand.value) - parseInt(formObj.item_qty.value)) < parseInt(formObj.frm_store_min_stk_level.value)) {
		alert(getLabel("eST.BelowMinStkinFromStore.label", "ST")); //Below Min Stock Level in From Store
	}
	if ((parseInt(formObj.to_store_qty_on_hand.value) + parseInt(formObj.item_qty.value)) > parseInt(formObj.to_store_max_stk_level.value)) {
		alert(getLabel("eST.ExceedsMaxStkinToStore.label", "ST")); //Exceeds Max Stock Level in To Store
	}
}
function issueUOMQtyChk() {
	var formObj = document.formStockTransferListHeader;
	var allow_yn = formObj.allow_deci_yn.value;
	if(allow_yn=="N"){
		return true;
	}
	var no_decimals= formObj.no_deci.value;
	toConvFactor();
	
	
	// For the CRF 537.3 Test Purpose 3/10/2010 Rams
	//alert("frm_conv"+formObj.frm_tmp_conv.value)
	//alert("to_conv"+formObj.tmp_conv.value)
	//alert("conv_factor"+conv_factor)

/*	var dec_factor = (formObj.ret_qty.value) % (conv_factor);
var conv_factor = lcm(formObj.frm_tmp_conv.value, formObj.tmp_conv.value);
   Here the LOC is moved inside the Condition as per the FD The Lcm should be calculated only when Item does not allow decimals
 alert("dec_factor   "+dec_factor);
*/

	if(allow_yn=='N')
	{
     //alert();
	  //var conv_factor =  formObj.frm_tmp_conv.value;
	  var conv_factor = lcm(formObj.frm_tmp_conv.value, formObj.tmp_conv.value);
    	var dec_factor = (formObj.ret_qty.value) % (conv_factor);
    	   if (dec_factor > 0 && (formObj.kit_item_yn.value=="N" || formObj.kit_item_yn.value=="")) {
	     	   alert("Quantity Should Be In Multiples Of " + (conv_factor/(formObj.frm_tmp_conv.value)));
		     return false;
	       }else 
		     return true;
	}else 
		{
		var conv_factor = formObj.tmp_conv.value;
		return true;
		}
	
	//}
	//if(allow_yn=='Y')
	//	return true;
}
function setTempConvFactor(tmp) {
	if (document.formStockTransferListHeader == null) {
		parent.frames[2].frames[0].document.formStockTransferListHeader.tmp_conv.value = tmp;
	} else {
		document.formStockTransferListHeader.tmp_conv.value = tmp;
	}
}
function setFromTempConvFactor(frm_tmp) {
	if (document.formStockTransferListHeader == null) {
		parent.frames[2].frames[0].document.formStockTransferListHeader.frm_tmp_conv.value = frm_tmp;
	} else {
		document.formStockTransferListHeader.frm_tmp_conv.value = frm_tmp;
	}
}
 /* Added: By Rams 
        Date: 1/7/2010
		Purpose: For the Decimal CRF Phase II
     */
function setDecimalParameters(allow_yn,no_decimals) {
		
	//alert(no_decimals);
		document.formStockTransferListHeader.allow_deci_yn.value = allow_yn;
		document.formStockTransferListHeader.no_deci.value = no_decimals;
      
}
function toConvFactor() {
	var formObj = document.formStockTransferListHeader;
	var item_code = "";
	if (formObj == null) {
		formObj = parent.frames[2].frames[0].document.formStockTransferListHeader;
		var to_store_code = parent.frameStockTransferHeader.document.formStockTransferHeader.to_store_code.value;
		var fm_store_code = parent.frameStockTransferHeader.document.formStockTransferHeader.from_store_code.value;
	} else {
		var to_store_code = parent.parent.frameStockTransferHeader.document.formStockTransferHeader.to_store_code.value;
		var fm_store_code = parent.parent.frameStockTransferHeader.document.formStockTransferHeader.from_store_code.value;
	}
	 item_code = formObj.item_code.value;
	if (parent.frameStockTransferDetail != null) {
		var formObj1 = parent.frameStockTransferDetail.document.formStockTransferDetail;
		item_code = formObj1.item_code.value;
	}
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/StockTransferValidate.jsp?validate=setToConv" + "&to_store_code=" + to_store_code + "&item_code=" + item_code + "&fm_store_code=" + fm_store_code, false);
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	eval(responseText);
}
function totalqty() {
 
	var formObj = document.formStockTransferListHeader;
	if (formObj == null) {
		formObj = parent.frames[2].frames[0].document.formStockTransferListHeader;
	}
	if(formObj.allow_deci_yn.value=="N"){
		if (formObj.item_qty.value != "" && (formObj.kit_item_yn.value=="N" || formObj.kit_item_yn.value=='' )) {
			if(formObj.item_qty.value%formObj.from_multiples.value !=0){
				alert("Quantity Should Be In Multiples Of "+formObj.from_multiples.value);
				
				//formObj.item_qty.focus();
				 
				formObj.ret_qty.value = "";
			}else{
				formObj.ret_qty.value = (formObj.item_qty.value/formObj.from_multiples.value) * formObj.batch_multiples.value;
					if(formObj.bar_or_item_code.value=="B" &&  parent.frames[1].document.forms[0]!=undefined && parent.frames[1].document.forms[0].total_checkboxes.value==1){
					parent.frames[1].document.forms[0].item_qty_0.value =formObj.ret_qty.value;
					}
					//alert("672====>"+formObj.ret_qty.value);
			}
		}else{ //17/09/12
		            formObj.ret_qty.value =formObj.item_qty.value;
					if(formObj.bar_or_item_code.value=="B" &&  parent.frames[1].document.forms[0]!=undefined && parent.frames[1].document.forms[0].total_checkboxes.value==1){
					parent.frames[1].document.forms[0].item_qty_0.value =formObj.ret_qty.value;
					}
		}
	}else{
		toConvFactor();
		var formObj = document.formStockTransferListHeader;
		if (formObj == null) {
			formObj = parent.frames[2].frames[0].document.formStockTransferListHeader;
		}

		if (formObj.item_qty.value != "" && (formObj.kit_item_yn.value=="N" || formObj.kit_item_yn.value=='' )) {
		  //is used as per the FD 537.3 Rule No 2.1/2.2
			//if(formObj.allow_deci_yn.value=="Y")
			formObj.ret_qty.value = (formObj.item_qty.value * formObj.frm_tmp_conv.value).toFixed(parseInt(document.formStockTransferListHeader.no_deci.value));
					if(formObj.bar_or_item_code.value=="B" &&  parent.frames[1].document.forms[0]!=undefined && parent.frames[1].document.forms[0].total_checkboxes.value==1){
					parent.frames[1].document.forms[0].item_qty_0.value =formObj.ret_qty.value;
					}
			/*if(formObj.allow_deci_yn.value=="N")
			formObj.ret_qty.value =formObj.item_qty.value;*/
		}else{
			formObj.ret_qty.value =formObj.item_qty.value;
					if(formObj.bar_or_item_code.value=="B" &&  parent.frames[1].document.forms[0]!=undefined && parent.frames[1].document.forms[0].total_checkboxes.value==1){
					parent.frames[1].document.forms[0].item_qty_0.value =formObj.ret_qty.value;
					}
					
					//alert("695===>" +formObj.ret_qty.value);
		}
	}
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
function populateStoresInQuery(request_by_store) {
	if (request_by_store.value == "") {
		clearListItems("document.forms[0].to_store");
		return;
	}
	var arrayObject = new Array();
	assignBean(document.formStockTransferQueryCriteria);
	xmlStr = getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(getXMLString(xmlStr), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/StockTransferValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=POPULATE_TO_STORES" + "&request_by_store=" + request_by_store.value, false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
function assignBean(frmObject) {
	bean_id = frmObject.bean_id.value;
	bean_name = frmObject.bean_name.value;
	//xmlDom = new ActiveXObject("Microsoft.XMLDom");
	//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	xmlDom = "";
	xmlHttp = new XMLHttpRequest();
}
function populateItemClassesInQuery(request_by_store, request_on_store) {
	if (request_by_store.value == "" || request_on_store.value == "") {
		clearListItems("document.forms[0].item_class_code");
		return;
	}
	assignBean(document.formStockTransferQueryCriteria);
	var arrayObject = new Array();
	xmlStr = getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(getXMLString(xmlStr), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/StockTransferValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=POPULATE_ITEM_CLASSES" + "&request_by_store=" + request_by_store.value + "&request_on_store=" + request_on_store.value, false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
function kitGetStatus() {
	var store_not_found = "";
	var to_store_code = parent.parent.frameStockTransferHeader.document.formStockTransferHeader.to_store_code.value;
	var store_code = parent.parent.frameStockTransferHeader.document.formStockTransferHeader.from_store_code.value;
	var formObj = document.formStockTransferListHeader;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/StockTransferValidate.jsp?item_code=" + formObj.item_code.value + "&store_code=" + store_code + "&item_qty=" + formObj.item_qty.value + "&to_store_code=" + to_store_code + "&validate=GET_STATUS", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	if (!result) {
		if (message == "RECORD_ALREADY_EXISTS") {
			alert(getMessage(message, "ST"));
			refreshDetails();
			return;
		}
		if(parent.parent.frameStockTransferHeader.document.formStockTransferHeader.barcode_applicable1.value=="Y")
		addToListforBarCode1('stockTransferBean','eST.StockTransferBean','StockTransferListHeader','StockTransferListDetail','StockTransferDetail');
		else
		addToList1();

	}
	if (result) {
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/StockTransferValidate.jsp?item_code=" + formObj.item_code.value + "&store_code=" + store_code + "&to_store_code=" + to_store_code + "&validate=MIN_MAX_STATUS", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		//addToList();//COMMENTED BY GANGA

		if(parent.parent.frameStockTransferHeader.document.formStockTransferHeader.barcode_applicable1.value=="Y")
		addToListforBarCode('stockTransferBean','eST.StockTransferBean',parent.parent.frameStockTransferHeader.document.formStockTransferHeader.barcode_applicable1,'StockTransferListHeader','StockTransferListDetail','StockTransferDetail');
		else
		addToList();
	}
}
function kitNextItem() {
	parent.frameStockTransferList.frameStockTransferListHeader.kitNextItemValidate();
}
function kitNextItemValidate() {
	var store_code = parent.parent.frameStockTransferHeader.document.formStockTransferHeader.from_store_code.value;
	var to_store_code = parent.parent.frameStockTransferHeader.document.formStockTransferHeader.to_store_code.value;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/StockTransferValidate.jsp?validate=KIT_TEMPLATE&store_code=" + store_code+"&to_store_code="+to_store_code, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
function addToList1() {
	 
	
	var formObj = parent.frameStockTransferListHeader.document.formStockTransferListHeader;
	var arrayObject = new Array(formObj.item_code, formObj.item_qty);
	var names = new Array(getLabel("Common.item.label", "Common"), getLabel("Common.Quantity.label", "Common"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.parent.messageFrame);
	var store_code = parent.parent.frameStockTransferHeader.document.formStockTransferHeader.from_store_code.value;

	//alert("addolist1");
	if (blankObject == true) {
	
		if (parent.frameStockTransferListDetail.document.formStockTransferListDetail == null) {
		//alert("ffff"+parent.frameStockTransferListDetail.document.formStockTransferListDetail);
			var formObj = document.formStockTransferListHeader;
			var _item_code = formObj.item_code.value;
			var item_qty = formObj.ret_qty.value;
		
			var mode = parent.parent.frameStockTransferHeader.document.formStockTransferHeader.mode.value;
			parent.frameStockTransferListDetail.location.href = "../../eST/jsp/StockTransferListDetail.jsp?function=edit&store_code=" + store_code + "&item_code=" + _item_code + "&item_qty=" + item_qty + "&function_id=" + parent.parent.function_id + "&addToList=true" + "&tmp_conv=" + formObj.tmp_conv.value + "&frm_tmp_conv=" + formObj.frm_tmp_conv.value + "&kit=kit"+"&allow_deci_yn="+formObj.allow_deci_yn.value+"&no_deci="+formObj.no_deci.value;
			return;
		}
		var formObjDtl = parent.parent.frameStockTransferList.frameStockTransferListDetail.document.formStockTransferListDetail;
		//alert("formObjDtl==814==>" +formObjDtl);
		var proceed = false;
		var messageFrame = parent.parent.messageFrame;
		var errorPage = "../../eCommon/jsp/error.jsp";
		var item_qty = formObj.item_qty.value;
		_total_checkboxes = formObjDtl.total_checkboxes.value;
		//alert("check_boxes====>"+_total_checkboxes);
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getEnhancedXMLString(formObjDtl));
		xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObjDtl), "text/xml");
		/**
			* @Name - Priya 
			* @Date - 22/12/2009
			* @Inc# - IN017176
			* @Desc - To Display the character ® properly in Item desc without junck characters
			* added 'encodeURIComponent(formObj.item_desc.value,"UTF-8")' in the next line code
			*/
		
		storealt = parent.parent.frames[0].document.forms[0].from_store_code.value;
		//Commented and Added by suresh.r on 14-04-2014 against #048585(SKR-SCF-0988)
		//xmlHttp.open("POST", "../../eST/jsp/StockTransferValidate.jsp?index=" + formObj.index.value + "&doc_srl_no=" + formObj.doc_srl_no.value + "&item_code=" + formObj.item_code.value + "&store_code=" + store_code + "&uom_code=" + formObj.uom_code.value + "&item_desc=" + encodeURIComponent(formObj.item_desc.value,"UTF-8") + "&item_qty=" + formObj.item_qty.value + "&item_unit_cost=" + document.getElementById("item_unit_cost").value + "&stock_item_yn=" + formObj.stock_item_yn.value + "&item_cost_value=" + document.getElementById("id_item_sal_value").innerText + "&expiry_yn=" + formObj.expiry_yn.value + "&store_alt_code=" + storealt + "&uom_desc=" + document.getElementById("id_uom").innerText + "&stock_available=" + document.getElementById("id_stock_available").innerText + "&expired_batch=" + formObjDtl.expired_batch.value + "&ex_param_days=" + formObjDtl.ex_param_days.value + "&frm_store_qty_on_hand=" + formObj.frm_store_qty_on_hand.value + "&frm_store_min_stk_level=" + formObj.frm_store_min_stk_level.value + "&frm_store_max_stk_level=" + formObj.frm_store_max_stk_level.value + "&frm_store_reorder_level=" + formObj.frm_store_reorder_level.value + "&to_store_qty_on_hand=" + formObj.to_store_qty_on_hand.value + "&to_store_min_stk_level=" + formObj.to_store_min_stk_level.value + "&to_store_max_stk_level=" + formObj.to_store_max_stk_level.value + "&to_store_reorder_level=" + formObj.to_store_reorder_level.value + "&to_conv_fact=" + formObj.tmp_conv.value + "&frm_conv_fact=" + formObj.frm_tmp_conv.value + "&frm_store_uom_desc=" + formObj.frm_store_uom_desc.value + "&batch_records=" + formObjDtl.total_checkboxes.value + "&to_store_uom_desc=" + formObj.to_store_uom_desc.value +"&allow_yn="+formObj.allow_deci_yn.value+"&no_decimals="+formObj.no_deci.value+"&kit_item_yn="+formObj.kit_item_yn.value+"&from_multiples="+formObj.from_multiples.value+"&to_multiples="+formObj.to_multiples.value+"&batch_multiples="+formObj.batch_multiples.value+"&kit_temp_code="+formObj.kit_temp_code.value+"&usage_type="+formObj.usage_type.value+"&validate=ADD_TO_LIST", false);
		xmlHttp.open("POST", "../../eST/jsp/StockTransferValidate.jsp?index=" + formObj.index.value + "&doc_srl_no=" + formObj.doc_srl_no.value + "&item_code=" + formObj.item_code.value + "&store_code=" + store_code + "&uom_code=" + formObj.uom_code.value + "&item_desc=" + encodeURIComponent(formObj.item_desc.value,"UTF-8") + "&item_qty=" + formObj.item_qty.value + "&item_unit_cost=" + document.getElementById('item_unit_cost').value + "&stock_item_yn=" + formObj.stock_item_yn.value + "&item_cost_value=" + document.getElementById('id_item_sal_value').innerText + "&expiry_yn=" + formObj.expiry_yn.value + "&store_alt_code=" + storealt + "&uom_desc=" + encodeURIComponent(document.getElementById('id_uom').innerText,"UTF-8") + "&stock_available=" + document.getElementById('id_stock_available').innerText + "&expired_batch=" + formObjDtl.expired_batch.value + "&ex_param_days=" + formObjDtl.ex_param_days.value + "&frm_store_qty_on_hand=" + formObj.frm_store_qty_on_hand.value + "&frm_store_min_stk_level=" + formObj.frm_store_min_stk_level.value + "&frm_store_max_stk_level=" + formObj.frm_store_max_stk_level.value + "&frm_store_reorder_level=" + formObj.frm_store_reorder_level.value + "&to_store_qty_on_hand=" + formObj.to_store_qty_on_hand.value + "&to_store_min_stk_level=" + formObj.to_store_min_stk_level.value + "&to_store_max_stk_level=" + formObj.to_store_max_stk_level.value + "&to_store_reorder_level=" + formObj.to_store_reorder_level.value + "&to_conv_fact=" + formObj.tmp_conv.value + "&frm_conv_fact=" + formObj.frm_tmp_conv.value + "&frm_store_uom_desc=" + formObj.frm_store_uom_desc.value + "&batch_records=" + formObjDtl.total_checkboxes.value + "&to_store_uom_desc=" + formObj.to_store_uom_desc.value +"&allow_yn="+formObj.allow_deci_yn.value+"&no_decimals="+formObj.no_deci.value+"&kit_item_yn="+formObj.kit_item_yn.value+"&from_multiples="+formObj.from_multiples.value+"&to_multiples="+formObj.to_multiples.value+"&batch_multiples="+formObj.batch_multiples.value+"&kit_temp_code="+formObj.kit_temp_code.value+"&usage_type="+formObj.usage_type.value+"&validate=ADD_TO_LIST", false);
				
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		//alert("responseText 837===>" +responseText);
		if (result) {
					//parent.parent.frameStockTransferHeader.formStockTransferHeader.preview.disabled = false;
			var arr = "";
			for (i = 0; i < parent.parent.frameStockTransferDetail.document.forms[0].total_checkboxes.value; i++) {
				if ((eval("parent.parent.frameStockTransferDetail.document.forms[0].checkbox" + i).checked)) {
					arr = arr + "," + "CHECKED";
				} else {
					arr = arr + "," + "s";
				}
			}
			parent.parent.frameStockTransferDetail.location.href = "../../eST/jsp/StockTransferDetail.jsp?function_id=" + parent.parent.function_id + "&index=" + formObj.index.value + "&arr=" + arr + "&tmp_conv=" + formObj.tmp_conv.value + "&kit12=kit"+"&store_code=" + store_code  +"&allow_yn="+formObj.allow_deci_yn.value+"&no_decimals="+formObj.no_deci.value;
			refreshDetails();
		} else {
			parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
		}
	}
}
function statusOfItem() {
	var store_code = parent.parent.frameStockTransferHeader.document.formStockTransferHeader.from_store_code.value;
	var to_store_code = parent.parent.frameStockTransferHeader.document.formStockTransferHeader.to_store_code.value;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/StockTransferValidate.jsp?validate=ERROR_MESSAGE&store_code=" + store_code + "&to_store_code=" + to_store_code, false);
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
}
function checkIntegerFormat(obj, zeroNotAllowed) {
	if (zeroNotAllowed == null) {
		zeroNotAllowed = true;
	}
	if (obj.value == "") {
		return;
	}
	if (!isValidIntegerFormat(obj)) {
		alert(getMessage("INVALID_NUMBER_FORMAT", "PH"));
		obj.value=""; //Edge Issue
		obj.focus();
		return false;
	} else {
		if ((parseFloat(obj.value) == 0) && zeroNotAllowed) {
			alert(getMessage("CANNOT_BE_ZERO", "Common"));
			obj.value = "";
			return false;
		}
	}
	return true;
}
function dispMess(id) {
	alert(getMessage("PHY_INV_PROCESS_INITIATED", "ST") + "\n" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + id);
}
async function ItemDetail() {

	var frmObj = document.formStockTransferListHeader;
	var store_code = parent.parent.frameStockTransferHeader.document.formStockTransferHeader.from_store_code.value;
	var to_store_code = parent.parent.frameStockTransferHeader.document.formStockTransferHeader.to_store_code.value;
	await window.showModalDialog("../../eST/jsp/MinMaxItemDetails.jsp?trn_type=TFR&item_desc=" + encodeURIComponent(frmObj.item_desc.value ) + "&fm_store_code=" + store_code + "&to_store_code=" + to_store_code + "&item_code=" + frmObj.item_code.value, "", "dialogHeight:80vh; dialogWidth:80vw; center:0; status: no; dialogLeft :150; dialogTop :300; scroll: no");
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
function allow_restrict_decimals(obj,event)
{
var allow_yn =	document.formStockTransferListHeader.allow_deci_yn.value ;
var  no_decimals = document.formStockTransferListHeader.no_deci.value ;

 if(allow_yn=='N')
	   obj.onkeypress=function(){return isValidInteger()};
	
	if(allow_yn=='Y')
	{
	   obj.onkeypress=function(){return isValidNumber(obj,event,7,parseInt(no_decimals))};
      
	}
}
function allow_restrict_decimals1(obj,event)
{
	
var allow_yn =	document.formStockTransferListDetail.allow_deci_yn.value ;
var  no_decimals = document.formStockTransferListDetail.no_deci.value ;
if(allow_yn=='N')
obj.onkeypress=function(){return isValidInteger()};

if(allow_yn=='Y')
	   obj.onkeypress=function(){return isValidNumber(obj,event,7,parseInt(no_decimals))};
}


function setMultiples(from,to,batch) {
	if (document.formStockTransferListHeader == null) {
		parent.frames[2].frames[0].document.formStockTransferListHeader.from_multiples.value = from;
		parent.frames[2].frames[0].document.formStockTransferListHeader.to_multiples.value = to;
		parent.frames[2].frames[0].document.formStockTransferListHeader.batch_multiples.value = batch;
	} else {
		document.formStockTransferListHeader.from_multiples.value = from;
		document.formStockTransferListHeader.to_multiples.value = to;
		document.formStockTransferListHeader.batch_multiples.value = batch;
	}
}
//Added By Rabbani #inc no:28266 on 16/09/11 
	//Starts Here
 function getstorecode() {
  
            var formobj = document.formStockTransferListHeader; 
            var from_store_code= parent.parent.frameStockTransferHeader.document.formStockTransferHeader.from_store_code.value;
            var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/StockTransferValidate.jsp?from_store_code=" + from_store_code + "&validate=COST_PRICE", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			//return result;
			 var cost_price_label = document.getElementById('id_item_unit_cost_label');
			 var cost_price = document.getElementById('id_item_unit_cost');
			 var sale_price_label = document.getElementById('id_item_sal_value_label');
			 var sale_price = document.getElementById('id_item_sal_value');
			 
			 if(result)
			 {
			  
			 cost_price_label.style.visibility ='visible';
			 cost_price.style.visibility ='visible';
			 sale_price_label.style.visibility ='visible';
			 sale_price.style.visibility ='visible';
	         }
	         else
	         {
			 
			 cost_price_label.style.visibility ='hidden';
	         cost_price.style.visibility ='hidden';
			 sale_price_label.style.visibility ='hidden';
	         sale_price.style.visibility ='hidden';
	         }
			}
			
 


 function setStockDetailsforBarcode(_stock_item_yn, _to_stock_item_yn, _store_item_unit_cost, _available_stock, _expired_stock,_conv_factor) {//Modified by suresh.r added _conv_factor on 11-08-2014 against Inc#50616
 
	var allow_deci_yn = document.formStockTransferListHeader.allow_deci_yn.value;	
	if(allow_deci_yn=='N')
	document.formStockTransferListHeader.no_deci.value = '0';
	document.getElementById('id_stock_available').innerText = parseFloat(_available_stock).toFixed(parseInt(document.formStockTransferListHeader.no_deci.value));
	document.getElementById('frm_store_qty_on_hand').value = parseFloat(_available_stock);
	/*document.getElementById('id_item_unit_cost').innerText = _store_item_unit_cost;
	document.getElementById('item_unit_cost').value = _store_item_unit_cost;
	//Modified by suresh.r on 11-08-2014 against Inc#50616*/
	var unit_cost = _store_item_unit_cost*_conv_factor;
	var no_of_decimals_for_cost = eval(document.formStockTransferListHeader.no_of_decimals_for_cost.value);
	document.getElementById('id_item_unit_cost').innerText = setNumber(unit_cost,no_of_decimals_for_cost);
	document.getElementById('id_item_unit_cost').title =unit_cost;
	document.getElementById('item_unit_cost').value = setNumber(unit_cost,no_of_decimals_for_cost);
	document.formStockTransferListHeader.stock_item_yn.value = _stock_item_yn;
	if (_stock_item_yn == "Y") {
		if (_available_stock == "0") {
		}
	} else {
		document.formStockTransferListHeader.batchsearch.disabled = true;
		document.formStockTransferListHeader.edit.disabled = true;
	}
}
function calIssueQty(){
}


function assignUOMDesc(frm_store_uom_desc,to_store_uom_desc){
	document.getElementById('frm_store_uom_desc').value = frm_store_uom_desc;
	document.getElementById('to_store_uom_desc').value =  to_store_uom_desc;
}


function chkstatus(obj){
        var usage_type = "";
		if ((eval("document.forms[0].checkbox" + obj).checked)){
			usage_type = "P";
		}else{
			usage_type = "O";
		}
		    var xmlHttp = new XMLHttpRequest();
	        var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
	        xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/StockTransferValidate.jsp?usage_type="+usage_type+"&index_="+obj+"&BARCODE_YN="+document.formStockTransferDetail.BARCODE_YN.value+"&validate=USAGE_TYPE_STATUS", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
}
//<!--Added by Ganga for #inc no :35661 (PMG2012-CRF-0012) on 21/11/2012 -->
async function callBatchSearchScreen(store_batch_code,item_code) {
	var batch_item = item_code;
	var batch_store = store_batch_code;
	var includeZeroStockBatches = "Y";
	var includeExpiredBatches = "Y";
	var includeSuspendedBatches = "Y";
	var searchFunction = "N";
	var multipleSelect = "N";
	var itemStoreDisable = "Y";
	var cuttOffDate = "";
	var doc_type_code = "";
	var doc_no = "";
	var trn_type = "";
	var retval = await callBatchSearchWindow(batch_item, batch_store, includeZeroStockBatches, includeExpiredBatches, includeSuspendedBatches, searchFunction, multipleSelect,cuttOffDate, doc_type_code, doc_no, trn_type,itemStoreDisable);	
}

//Added by sakti against ML-BRU-SCF-0963[INC#42099]	
function Setitemdesc(obj){
	document.formStockTransferListHeader.item_desc.value = decodeURIComponent(obj.value,"UTF-8");
} 
function getGTINDetails (e,barcode){//Adding start for MOHE-CRF-0167
	if(e.keyCode==9 || e.keyCode== 13  || e.keyCode== 0){
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		var item_code = document.formStockTransferListHeader.item_code.value;
		var store_code = parent.parent.frameStockTransferHeader.document.getElementById('td_from_store_code').value;
		var bar_code = barcode.value;
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/StockTransferValidate.jsp?barcode=" + barcode.value+"&item_code="+item_code +"&store_code="+store_code+"&validate=GET_GTIN", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if(result){
			
			callItemSearchScreen("BARCODE",barcode.value);
			
			if(document.formStockTransferListHeader.item_code.value!="" && message==""){
				item_code = document.formStockTransferListHeader.item_code.value;
				parent.frameStockTransferListDetail.location.href = "../../eST/jsp/StockTransferListDetail.jsp?bar_code="+bar_code+"&item_code="+item_code+"&store_code="+store_code+"&function=2DBARCODE";
				if(document.formStockTransferListHeader.item_qty.value==""){
				document.formStockTransferListHeader.item_qty.value=1;
				document.formStockTransferListHeader.item_qty.onblur();
				} else {
				document.formStockTransferListHeader.item_qty.value=Number(document.formStockTransferListHeader.item_qty.value)+1;
				document.formStockTransferListHeader.item_qty.onblur();
				}
			}			 
		}else{
		if(message!="") {
				 alert(getMessage(message, "ST"));
		} else {
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/StockTransferValidate.jsp?&validate=BARCODECHECK_SAMEITEM"+"&store_code="+store_code+"&barcode=" + bar_code+"&item_code="+item_code, false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);	
			if(result){
				if(document.formStockTransferListHeader.item_code.value!="" && message==""){
					item_code = document.formStockTransferListHeader.item_code.value;
					parent.frameStockTransferListDetail.location.href = "../../eST/jsp/StockTransferListDetail.jsp?bar_code="+bar_code+"&item_code="+item_code+"&store_code="+store_code+"&function=2DBARCODE";
					if(document.formStockTransferListHeader.item_qty.value==""){
						document.formStockTransferListHeader.item_qty.value=1;
						document.formStockTransferListHeader.item_qty.onblur();
						} else {
						document.formStockTransferListHeader.item_qty.value=Number(document.formStockTransferListHeader.item_qty.value)+1;
						document.formStockTransferListHeader.item_qty.onblur();
						}	
				}
				else {
				document.formStockTransferListHeader.barcode.value = "";
				if(message!="")
				 alert(getMessage(message, "ST"));
				}
			}else{
				if (confirm("Proceed with the next Item?") == true) {
					document.formStockTransferListHeader.apply.onclick();
						if(message!=""){
							 alert(getMessage(message, "ST"));
               }
			    } else {
					if(message!=""){
						 alert(getMessage(message, "ST"));
					}
			    	document.formStockTransferListHeader.barcode.value = "";
			    	return false;
			    }	
			}

			}
		} 
		
	}
}
