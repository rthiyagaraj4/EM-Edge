/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		       Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
19/05/2017		IN062881		B.Badmavathi								    Unit Cost Mandatory in GRN 
--------------------------------------------------------------------------------------------------------------------------------------------
*/
var batch_retval = "";
function create() {
	f_query_add_mod.location.href = "../../eST/jsp/ReplacementGRNFrame.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
}
function query() {
	f_query_add_mod.location.href = "../../eST/jsp/ReplacementGRNQueryFrame.jsp?mode=" + MODE_MODIFY + "&function_id=" + function_id + "&doc_type_code=C1GRN&doc_no=107"; 
	//f_query_add_mod.location.href="../../eST/jsp/GoodsReceivedNoteFrame.jsp?mode="+MODE_MODIFY+"&function_id="+function_id+"&doc_type_code=C1GRN&doc_no=107"; 
}
function reset() {
	f_query_add_mod.location.reload();
}
function onSuccess() {
	f_query_add_mod.location.href = "../../eCommon/html/blank.html";
}
function showCalendarLocal(id) {
	var flag = showCalendar(id);
	document.getElementById(id).focus();
	return flag;
}
function CheckForSpecialChars(event) {
	var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
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
function getBatchIDFromExpiryDate(expiry_date_object, i) {
	var sys_date = document.forms[0].sys_date;
	var batch_id_applicable_yn = document.forms[0].batch_id_applicable_yn;
	if (CheckDate(expiry_date_object)) {
		if (checkDateWithSysDate(sys_date, expiry_date_object)) {
			if ((CheckDate(expiry_date_object)) && (batch_id_applicable_yn.value == "E") && (expiry_date_object.value != "")) {
				var expiry_date = expiry_date_object.value;
				var result = "";
				var start_index = 0;
				var end_index = 0;
				while (expiry_date.indexOf("/") != -1) {
					end_index = expiry_date.indexOf("/");
					result += expiry_date.substring(start_index, end_index);
					expiry_date = expiry_date.substring(end_index + 1);
				}
				result += expiry_date;
				document.getElementById("batch_id_" + i).value = result;
			}
			// begin
			getShelfLifeExpiryDate(expiry_date_object,i);
			// end
		} else {
			alert(getMessage("NOT_LESS_THAN_SYSDATE", "ST"));
			expiry_date_object.select();
			expiry_date_object.focus();
			expiry_date_object.value = "";
		}
	}
}
function deleterecord() {
	var errorPage = "../../eCommon/jsp/error.jsp";
	var formObj = f_query_add_mod.frameGoodsReceivedNoteHeader.document.formGoodsReceivedNoteHeader;
	var prevMode = formObj.mode.value;
	if (prevMode == MODE_INSERT) {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("OPER_CANCELLED", "ST");
		return;
	}
	formObj.mode.value = MODE_DELETE;
	if (confirmDelete() != YES) {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("OPER_CANCELLED", "ST");// + "<BR>" + flag;
		formObj.mode.value = MODE_MODIFY;
		return;
	}
	var responseText = formApply(formObj, ST_CONTROLLER);
	eval(responseText);
	messageFrame.location.href = errorPage + "?err_num=" + message;
	if (result) {
		onSuccess();
	} else {
		formObj.mode.value = prevMode;
	}
}
function searchPatient() {
	var patient_id = PatientSearch();
	var formObj = document.forms[0];
	if (!((patient_id == null) || (patient_id == ""))) {
		formObj.patient_id.value = patient_id;
	}
	formObj.patient_id.focus();
}
function getPatientName(_patient_id) {
	var formObj = document.formGoodsReceivedNoteHeader;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	var xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/ReplacementGRNValidate.jsp?patient_id=" + _patient_id + "&validate=PATIENT_NAME", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	if (!responseText) {
		alert(getMessage(flag, "ST"));
		formObj.patient_id.focus();
	}
}
function setPatientName(_patient_name) {
	document.formGoodsReceivedNoteHeader.patient_name.innerText = _patient_name;
}
function callItemSearchScreen() {
	
	var search_string = "";
	parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	if (!parent.frameGoodsReceivedNoteListHeader.formGoodsReceivedNoteListHeader.item_desc.readOnly) {
		search_string = parent.frameGoodsReceivedNoteListHeader.formGoodsReceivedNoteListHeader.item_desc.value;
	}
	var store_code = parent.parent.frameGoodsReceivedNoteHeader.formGoodsReceivedNoteHeader.store_code.value;
	var category = "A";
	var sole_source = "A";
	var ps_item = "A";
	var mfg_item = "A";
	var expiry = "A";
	var consignment = "A";
	var item_class = parent.parent.frameGoodsReceivedNoteHeader.formGoodsReceivedNoteHeader.item_class_code.value;
	var item_class_check = parent.parent.frameGoodsReceivedNoteHeader.formGoodsReceivedNoteHeader.item_class_check.value;
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
		
		var retVal = await callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment);
		
		 var ret1=unescape(retVal);
	
		 	var arr=ret1.split(",");
			
		if (retVal != null) {
			parent.parent.frameGoodsReceivedNoteHeader.document.formGoodsReceivedNoteHeader.store_code_disabled.value = "disabled";
			document.formGoodsReceivedNoteListHeader.item_code.value = arr[0];
			/** @Name - Priya
			* @Date - 10/02/2010
			* @Inc# - 19092
			* @Desc - 'Allow Decimal Y/N' value of the selected item is assigned to the hidden field 'dec_allowed_yn'
			*/
			document.formGoodsReceivedNoteListHeader.dec_allowed_yn.value = arr[27];
			document.formGoodsReceivedNoteListHeader.item_desc.value = arr[1];
			document.formGoodsReceivedNoteListHeader.item_desc.readOnly = true;
			document.formGoodsReceivedNoteListHeader.user_grn_unit_cost_in_pur_uom.readOnly = true;
//		document.formGoodsReceivedNoteListHeader.expiry_yn.value=retVal[2];
			var var_replace_on_expiry_yn = arr[2];
			if (var_replace_on_expiry_yn == "N") {
				document.formGoodsReceivedNoteListHeader.replace_on_expiry_yn.checked = false;
				document.formGoodsReceivedNoteListHeader.replace_on_expiry_yn.disabled = true;
				document.formGoodsReceivedNoteListHeader.dis_expiry_yn.disabled = true;
				document.formGoodsReceivedNoteListHeader.expiry_yn.value = "N";
			} else {
				document.formGoodsReceivedNoteListHeader.replace_on_expiry_yn.disabled = false;
				document.formGoodsReceivedNoteListHeader.expiry_yn.checked = true;
				document.formGoodsReceivedNoteListHeader.expiry_yn.value = "Y";
			}
			document.formGoodsReceivedNoteListHeader.uom_code.value = arr[13];
//		document.getElementById("id_store_item_unit_cost").innerHTML=retVal[14];
			document.getElementById('id_uom').innerHTML = arr[15];
			document.getElementById('id_pur_uom_conv').innerHTML = "1";
			document.getElementById('pur_uom_conv').value	   = "1";
			document.getElementById('pur_uom_code').value = arr[13];
			if (arr[13] == "") {
				alert(getMessage("PUR_SALE_UOM_UNDEFINED", "ST"));
				refreshDetails();
			}
			var trade_id_applicable_yn = arr[17];
			var batch_id_applicable_yn = arr[18];
			var formObj = document.formGoodsReceivedNoteListHeader;
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			var xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/ReplacementGRNValidate.jsp?item_code=" + formObj.item_code.value + "&store_code=" + store_code + "&validate=GET_STATUS", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			if (!responseText) {
				parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?";//err_num="+ getMessage(message);
				if (message == "PHY_INV_PROCESS_INITIATED") {
					alert(getMessage(message, "ST") + "\n" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + formObj.phy_inv_id.value);
				} else {
					alert(getMessage(message, "ST"));
				}
				refreshDetails();
				return;
			}
			var formObj = document.formGoodsReceivedNoteListHeader;
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			var xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/ReplacementGRNValidate.jsp?item_code=" + formObj.item_code.value + "&validate=DISP_PUR_COST&store_code=" + store_code, false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			if (!responseText) {
				parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "ST");
				refreshDetails();
				return;
			}
			var formObj = document.formGoodsReceivedNoteListHeader;
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			var xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/ReplacementGRNValidate.jsp?item_code=" + formObj.item_code.value + "&store_code=" + store_code + "&uom_code=" + document.formGoodsReceivedNoteListHeader.uom_code.value + "&validate=SET_PUR_UOM_LIST" + "&item_code=" + formObj.item_code.value, false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			if (!responseText) {
				parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "ST");
				refreshDetails();
				return;
			}
checkUOMConvFactor();


			formObj.batch_search.disabled = false;
			parent.frameGoodsReceivedNoteListDetail.location.href = "../../eST/jsp/ReplacementGRNListDetail.jsp?item_code=" + arr[0] + "&index=" + formObj.index.value + "&tmp_conv=" + formObj.tmp_conv.value+"&gen_uom_desc="+arr[25];
			setDecimalParameters(arr[27],arr[28],formObj);
	
			document.formGoodsReceivedNoteListHeader.item_qty_normal.focus();
		}
	}
}
function checkUOMConvFactor() {
	var formObj = document.formGoodsReceivedNoteListHeader;
	//if (formObj.uom_code.value == formObj.pur_uom_code.value) {
	//	return;
	//}
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	var xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/ReplacementGRNValidate.jsp?uom_code=" + formObj.uom_code.value + "&pur_uom_code=" + formObj.pur_uom_code.value + "&validate=GET_CONV_FACTOR" + "&item_code=" + formObj.item_code.value, false);
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	eval(responseText);
	//alert("reponse alert 256"+responseText);
	if (!responseText) {
		//alert("inside the if");
		parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "ST");
		//alert("parent.parent.parent.messageFrame.location"+parent.parent.parent.messageFrame.location);
		formObj.pur_uom_code.value = formObj.uom_code.value;
		formObj.pur_uom_code.focus();
		setUOMConvFactor("1");
		
	}
}
function setUOMConvFactor(_value) {
	//alert("setUOMConvFactor");
	document.getElementById('id_pur_uom_conv').innerHTML	 = _value;
	document.getElementById('pur_uom_conv').value			 = _value;
}
function setStockDetails(_stock_item_yn, _store_item_unit_cost) {
	if (_stock_item_yn == "N") {
		alert(getMessage("NOT_STOCK_ITEM", "ST"));
		refreshDetails();
	} else {
		/**
		 * @Name - Priya
		 * @Date - 31/05/2010
		 * @Inc# - 
		 * @Desc -  As last_pur_cost is rounded up already in validate jsp the setnumber function is removed
		 */
		document.formGoodsReceivedNoteListHeader.grn_unit_cost_in_pur_uom.value = _store_item_unit_cost;
		document.formGoodsReceivedNoteListHeader.user_grn_unit_cost_in_pur_uom.value = _store_item_unit_cost;
		document.formGoodsReceivedNoteListHeader.rtv_unit_cost.value = _store_item_unit_cost;
	}
}
function CheckQuantity() {
	if (!checkIntegerFormat(document.formGoodsReceivedNoteListHeader.item_qty)) {
		return false;
	}
	ComputeCost();
	if (document.formGoodsReceivedNoteListHeader.stock_item_yn.value == "N") {
		return true;
	}
	if (parseFloat(document.formGoodsReceivedNoteListHeader.item_qty.value) > parseFloat(document.getElementById('id_stock_available').innerText)) {
		alert(getMessage("QTY_NOT_GRT_AVLQTY", "ST"));
		document.formGoodsReceivedNoteListHeader.item_qty.focus();
		return false;
	}
}
function CheckValue() {
	if (document.formGoodsReceivedNoteListHeader.item_cost_value.value != null) {
		if (document.formGoodsReceivedNoteListHeader.item_cost_value.value == 0) {
			alert(getMessage("CANNOT_BE_ZERO", "Common"));
		}
	}
	if (isValidDouble(document.formGoodsReceivedNoteListHeader.quantity)) {
	}
	ComputeCost();
}
function addToList() {
	var formObj = parent.frameGoodsReceivedNoteListHeader.document.formGoodsReceivedNoteListHeader;
//Added against GDOH-CRF-0109 starts
	var check_uc = formObj.check_uc.value;
	var arrayObject ;
	var names;
	if(check_uc=="true"){
		 arrayObject = new Array(formObj.item_code, formObj.item_cost_value,formObj.user_grn_unit_cost_in_pur_uom);
		 names = new Array(getLabel("Common.item.label", "Common"), getLabel("eST.GRNValue.label", "ST"),getLabel("Common.UnitCost.label", "Common"));
	}else{
		 arrayObject = new Array(formObj.item_code, formObj.item_cost_value);
		 names = new Array(getLabel("Common.item.label", "Common"), getLabel("eST.GRNValue.label", "ST"));
	}
//Added against GDOH-CRF-0109  ends
	//var arrayObject = new Array(formObj.item_code, formObj.item_cost_value);
	//var names = new Array(getLabel("Common.item.label", "Common"), getLabel("eST.GRNValue.label", "ST"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.parent.messageFrame);
	if (blankObject == true) {
		formObj.apply.disabled = true;
		var formObjDtl = parent.parent.frameGoodsReceivedNoteList.frameGoodsReceivedNoteListDetail.document.formGoodsReceivedNoteListDetail;

		var messageFrame = parent.parent.messageFrame;
		var errorPage = "../../eCommon/jsp/error.jsp";
		var item_qty = 0;//formObj.item_qty_normal.value;
		if (formObj.item_qty_normal.value != "") {
			item_qty = parseFloat(item_qty) + parseFloat(formObj.item_qty_normal.value);
		}
		if (formObj.item_qty_bonus.value != "") {
			item_qty = parseFloat(item_qty) + parseFloat(formObj.item_qty_bonus.value);
		}
		/*if (formObj.item_qty_sample.value!="") {
			item_qty=parseFloat(item_qty)+parseFloat(formObj.item_qty_sample.value);
		}*/
		if (parseFloat(item_qty) == 0) {
			alert(getMessage("ONE_QTY_MUST", "ST"));
			formObj.apply.disabled = false;
			return;
		}
	var batch_arr = new Array();
	var batch_value = 0;
	for (var b = 0; b < 10; b++) {
		var q_batch = formObjDtl.elements["grn_item_qty_" + b].value;
		if (q_batch != "") {
			var ex_date = formObjDtl.elements["expiry_date_or_receipt_date_" + b].value;
	//var ex_date = convertDate(formObjDtl.elements("expiry_date_or_receipt_date_"+b).value,"DMY",locale,"en");
	//convertDate(ex_date,"DMY",locale,"en");
			var b_id = formObjDtl.elements["batch_id_" + b].value;
			var t_name = formObjDtl.elements["trade_id_" + b].value;
			var bin_loc = formObjDtl.elements["bin_location_code_" + b].value;
			//var bin_loc_code = parent.frameOpeningStockListHeader.document.formOpeningStockListHeader.bin_location_code.value;
			var rec_1 = ex_date + trimString(b_id) + t_name + bin_loc;
			batch_arr[batch_value] = rec_1;
			batch_value++;
		}
	}
	for (var c = 0; c < batch_arr.length; c++) {
		var check_arr = batch_arr[c];
		for (var f = c + 1; f < batch_arr.length; f++) {
			if (check_arr == batch_arr[f]) {
				formObj.apply.disabled = false;
				parent.parent.parent.frames[2].location.href = errorPage + "?err_num=" + getMessage("BATCH_DTL_ALREADY_EXIST", "ST");
				return;
			}
		}
	}
		var sum = 0;
		var proceed = true;
		var lesser_sale_price_yn= formObjDtl.lesser_sale_price_yn.value;
		for (var i = 0; i < 10 && proceed; i++) {
			if (formObjDtl.elements["grn_item_qty_" + i].value != "") {
				var qty = formObjDtl.elements["grn_item_qty_" + i].value;
				
				if (qty == "") {
					qty = 0;
				}
				if (!isNaN(qty)) {
					sum= sum+parseFloat(qty);
				  //alert("LOOP   "+sum);
				}
				if (formObjDtl.elements["expiry_date_or_receipt_date_" + i].value == "") {
					alert(getMessage("DATE_NOT_BLANK", "ST"));
					formObjDtl.elements["expiry_date_or_receipt_date_" + i].focus();
					proceed = false;
				} else {
					if (formObjDtl.elements["batch_id_" + i].value == "") {
						alert(getMessage("BATCH_ID_NOT_BLANK", "ST"));
						formObjDtl.elements["batch_id_" + i].focus();
						proceed = false;
					} else {
						if (formObjDtl.elements["trade_id_" + i].value == "") {
							alert(getMessage("TRADE_ID_NOT_BLANK", "ST"));
							proceed = false;
							formObjDtl.elements["trade_id_" + i].focus();
						} else {
							if (formObjDtl.elements["bin_location_code_" + i].value == "") {
								alert(getMessage("BIN_LOCN_NOT_BLANK", "ST"));
								proceed = false;
								formObjDtl.elements["bin_location_code_" + i].focus();
							}else {
								if(formObjDtl.sale_price_appl_yn.value=="Y"){
									if (formObjDtl.elements["sale_price_" + i].value == "") {
										alert(getMessage("SALE_PRICE_NOT_BLANK", "ST"));
										formObjDtl.elements["sale_price_" + i].value="";
										proceed = false;
										formObjDtl.elements["sale_price_" + i].focus();
									}else{
										if((eval('formObjDtl.elements["sale_price_" + i].value')<eval(formObj.user_grn_unit_cost_in_pur_uom.value)) && lesser_sale_price_yn == "Y"){
											alert(getMessage("SALE_PRICE_NOT_LESSER_UNIT_PRICE", "ST"));
											formObjDtl.elements["sale_price_" + i].value="";
											formObjDtl.elements["sale_price_" + i].focus();
											formObj.apply.disabled = false;
											proceed = false;
											return;
										}
									}
								} else {
									proceed = true;
								}
							}
						}
					}
				}
			}
		}
		if (!proceed) {
			formObj.apply.disabled = false;
			return;
		}
		if (setNumber(sum,parseInt(formObj.no_deci.value)) != item_qty) {
			
			alert(getMessage("QUANTIY_MUST_BE_EQUAL", "ST"));
			formObj.apply.disabled = false;
			return;
		}
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getEnhancedXMLString(formObjDtl));
		xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObjDtl), "text/xml");
		/*if(formObj.replace_on_expiry_yn.checked)
				expiry_yn = "Y"
			else
				expiry_yn = "N"
				*/
		var po_cost		= "";
		var po_discount	= "";
		var po_tax		= "";
		if(formObj.po_details_applicable_yn.value=="Y"){
			po_cost		= formObj.po_cost.value
			po_discount = formObj.po_discount.value
			po_tax		= formObj.po_tax.value
		}
		formObj.grn_unit_cost_in_pur_uom.value = formObj.user_grn_unit_cost_in_pur_uom.value;
		/**
			* @Name - Priya 
			* @Date - 17/12/2009
			* @Inc# - IN017176
			* @Desc - To Display the character ® properly in Item desc without junck characters
			* added 'encodeURIComponent(formObj.item_desc.value,"UTF-8")' in the next line code
			*/
		xmlHttp.open("POST", "../../eST/jsp/ReplacementGRNValidate.jsp?index=" + formObj.index.value + "&doc_srl_no=" + formObj.doc_srl_no.value + "&item_code=" + formObj.item_code.value + "&item_desc=" + encodeURIComponent(formObj.item_desc.value,"UTF-8") + "&item_qty_normal=" + formObj.item_qty_normal.value + "&item_qty_bonus=" + formObj.item_qty_bonus.value + "&item_qty_sample=" + formObj.item_qty_sample.value + "&label_reqd_yn=" + formObj.label_reqd_yn.checked + "&replace_on_expiry_yn=" + formObj.replace_on_expiry_yn.checked + "&item_cost_value=" + formObj.item_cost_value.value + "&no_of_labels=" + formObj.no_of_labels.value + "&grn_unit_cost_in_pur_uom=" + formObj.grn_unit_cost_in_pur_uom.value + "&rtv_unit_cost=" + formObj.rtv_unit_cost.value + "&uom_code=" + formObj.uom_code.value + "&pur_uom_code=" + formObj.pur_uom_code.value + "&expiry_yn=" + formObj.expiry_yn.value + "&uom_desc=" + document.getElementById('id_uom').innerText + "&pur_uom_conv=" + document.getElementById('pur_uom_conv').value + "&to_conv_fact=" + formObj.tmp_conv.value+ "&po_cost=" +po_cost + "&po_discount=" +po_discount+ "&po_tax=" + po_tax +"&allow_yn="+formObj.allow_deci_yn.value+"&no_decimals="+formObj.no_deci.value+"&pur_uom_conv_id=" + document.getElementById('id_pur_uom_conv').innerText + "&validate=ADD_TO_LIST", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if (responseText) {
			parent.parent.frameGoodsReceivedNoteHeader.formGoodsReceivedNoteHeader.preview.disabled = false;
			refreshDetails();
		} else {
			formObj.apply.disabled = false;
			parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
			//parent.frameGoodsReceivedNoteListDetail.location.href='../../eCommon/html/blank.html';
		}
	} else {
	//	blankObject.focus();
	}
}

// To refresh detail frame on click of Add
function refreshDetails() {
	//doc_type_code, doc_no
	parent.parent.frameGoodsReceivedNoteDetail.location.reload();
	parent.frameGoodsReceivedNoteListHeader.location.href = "../../eST/jsp/ReplacementGRNListHeader.jsp";
	parent.frameGoodsReceivedNoteListDetail.location.href = "../../eCommon/html/blank.html";
//	parent.frameGoodsReceivedNoteListDetail.location.href='../../eST/jsp/GoodsReceivedNoteListDetail.jsp';
//	parent.frameGoodsReceivedNoteListDetail.location.reload();
}
async function apply() {
	var formObj = f_query_add_mod.frameGoodsReceivedNoteDetail.document.formGoodsReceivedNoteDetail;
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
	var formObj = f_query_add_mod.frameGoodsReceivedNoteHeader.document.formGoodsReceivedNoteHeader;
	var arrayObject = new Array(formObj.receipt_date, formObj.supp_code);
	var names = new Array(getLabel("Common.receiptdate.label", "Common"), getLabel("Common.Supplier.label", "Common"));
	var blankObject = checkSTFields(arrayObject, names, messageFrame);
	if (blankObject == true) {
		forDeletion = forDeletion.substring(0, forDeletion.length - 1);
		formObj.records_to_delete.value = forDeletion;
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		var xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/ReplacementGRNValidate.jsp?validate=CHECK_AUTHORIZE_ALLOWED&store_code=" + formObj.store_code.value, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		formObj.finalize_allowed_yn.value == "Y";
		formObj.finalized_yn.value = "Y";
		if (formObj.finalize_allowed_yn.value == "Y") {
			if (formObj.entry_completed_yn.checked) {
				var response = await confirmFinalize();
				if (response == YES) {
					formObj.finalized_yn.value = "Y";
				}
			}
		}
		var responseText = formApply(formObj, ST_CONTROLLER);
		eval(responseText);
		  //Added by Rabbani #Inc no :42903(TTM-SCF-0026) on 05-AUG-13
		flag1 = (flag.split("~"))[0];
		flag2 = (flag.split("~"))[1];
		flag1 = (flag1 == "null" ? "" : flag1);
	  //ends
		//messageFrame.location.href = errorPage + "?err_num=" + message + "<BR>" + flag;
		if (result) {
		  //Added by Rabbani #Inc no :42903(TTM-SCF-0026) on 05-AUG-13
		           if (flag2 == "PY") {
				   if (formObj.finalize_allowed_yn.value == "Y") {
					var PConfirm = await confirmPrinting();
					if (PConfirm == "Yes") {
						var xmlHttp = new XMLHttpRequest();
						var xmlDoc="";
						//xmlDoc.loadXML(getXMLString(null));
						var xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
						xmlHttp.open("POST", "../../eST/jsp/ReplacementGRNValidate.jsp?validate=printOnlineDoc&msg=" + encodeURIComponent(message), true);
						xmlHttp.send(xmlDoc); 
					}
				}
			  } else if (flag2 == "PN") {
						var xmlHttp = new XMLHttpRequest();
						var xmlDoc="";
						//xmlDoc.loadXML(getXMLString(null));
						var xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
						xmlHttp.open("POST", "../../eST/jsp/ReplacementGRNValidate.jsp?validate=printOnlineDoc&msg=" + encodeURIComponent(message), true);
						xmlHttp.send(xmlDoc);
			}
			messageFrame.location.href = errorPage + "?err_num=" + message + "<BR>" + flag1;
			//ends
			onSuccess();
		}
		if (result) {
			messageFrame.location.href = errorPage + "?err_num=" + message + "<BR>" + flag1;
		} else {
			messageFrame.location.href = errorPage + "?err_num=" + message;
		}
	}
}
function setFinalize_allowed(_finalize_allowed_yn) {
	f_query_add_mod.frameGoodsReceivedNoteHeader.document.formGoodsReceivedNoteHeader.finalize_allowed_yn.value = _finalize_allowed_yn;
}
function cancel_me() {
	parent.frameGoodsReceivedNoteListHeader.location.href = "../../eST/jsp/ReplacementGRNListHeader.jsp";
	parent.parent.frameGoodsReceivedNoteList.frameGoodsReceivedNoteListDetail.location.href = "../../eCommon/html/blank.html";
}
function checkBatchQty(obj, available_qty) {
	if (checkIntegerFormat(obj)) {
		if (parseFloat(available_qty) < parseFloat(obj.value)) {
			alert("QTY_GREATER_THAN_AVAIL", "ST");
			obj.focus();
		}
	}
}
function checkRemarksLength(obj) {
	if (!setTextAreaMaxLength(obj, 200)) {
		alert(getMessage("REMARKS_CHAR_EXCEEDS_LIMIT", "ST"));
		obj.focus();
	}
}
function modifyData(index) {
	parent.frameGoodsReceivedNoteList.location.href = "../../eST/jsp/ReplacementGRNListFrame.jsp?function=modify&index=" + index + "&function_id=" + parent.parent.function_id;
}
function Modify(obj) {
	var doc_no = obj.cells[1].innerText;
	var doc_type_code = obj.cells[4].innerText;
	parent.document.location.href = "../../eST/jsp/ReplacementGRNFrame.jsp?mode=" + MODE_MODIFY + "&function_id=" + parent.parent.function_id + "&doc_type_code=" + doc_type_code + "&doc_no=" + doc_no;
}
function checkSysdate(receiptdate, sysdate) {
	var flag = ChkDate(receiptdate);
	if (!flag) {
		alert(getMessage("INVALID_DATE_FMT", "ST"));
		receiptdate.value=""; // Edge Issue
		receiptdate.select();
		receiptdate.focus();
		return false;
	}
	if (flag) {
		if (!checkdateWithSysDate(receiptdate, sysdate)) {
			alert(getMessage("ST_DOC_DT_NOT_GR_SYSDATE", "ST"));
			receiptdate.value=""; // Edge Issue
			receiptdate.select();
			receiptdate.focus();
			return false;
		} else {
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
function makeValidQty(val) {
	if (val == "") {
		val = "0";
	}
	return val;
}
function calculateValue() {
	formObj = document.formGoodsReceivedNoteListHeader;
//	if ((formObj.item_qty_bonus.value!="")||(parseFloat(formObj.item_qty_bonus.value)!=0)||(formObj.item_qty_sample.value!="")||(parseFloat(formObj.item_qty_sample.value)!=0))
	if ((makeValidQty(formObj.item_qty_bonus.value) != "0") || (makeValidQty(formObj.item_qty_sample.value) != "0"))
		formObj.user_grn_unit_cost_in_pur_uom.disabled = true;
	else
		formObj.user_grn_unit_cost_in_pur_uom.disabled = false;
	if(formObj.po_details_applicable_yn.value=="Y"){
		if(formObj.po_cost!=undefined && formObj.po_cost.value!= ""){
			formObj.user_grn_unit_cost_in_pur_uom.disabled = true;
			formObj.item_cost_value.disabled = true;
		}
	}

	if (formObj.user_grn_unit_cost_in_pur_uom.value == "") {
		return;
	}
	var item_qty = 0;
	if (formObj.item_qty_normal.value != "") {
		item_qty = parseFloat(item_qty) + parseFloat(formObj.item_qty_normal.value);
	}
	if (formObj.item_qty_bonus.value != "") {
		item_qty = parseFloat(item_qty) + parseFloat(formObj.item_qty_bonus.value);
	}
	if (item_qty != 0) {
		var item_value = parseFloat(formObj.grn_unit_cost_in_pur_uom.value) * parseFloat(item_qty);
		/**
		 * @Name - Priya
		 * @Date - 31/05/2010
		 * @Inc# - 
		 * @Desc -  To round up item_cost_value value based on the no_of_decimals_for_cost column in st_acc_entity_param table
		 */
	var no_of_decimals_for_cost= eval(formObj.no_of_decimals_for_cost.value);
		/*item_value = parseFloat(item_value) * 1000;
		item_value = Math.round(item_value);
		item_value = parseFloat(item_value) / 1000;*/

		formObj.item_cost_value.value = setNumber(item_value,no_of_decimals_for_cost);
//		if (formObj.no_of_labels.value=="") {
		/** @Name - Priya
				* @Date - 10/02/2010
				* @Inc# - 19092 
				* @Desc - Math.ceil() function is used to round up the decimal value to the nearest max integer value.
			*/
		formObj.no_of_labels.value = Math.ceil(item_qty);
	//	}
	} else {
		formObj.item_cost_value.value = "";
	}
}
function calculateCost() {
	formObj = document.formGoodsReceivedNoteListHeader;
	if (formObj.item_cost_value.value == "") {
		return;
	}
	var item_qty = 0;
	if (formObj.item_qty_normal.value != "") {
		item_qty = parseFloat(item_qty) + parseFloat(formObj.item_qty_normal.value);
	}
	if (formObj.item_qty_bonus.value != "") {
		item_qty = parseFloat(item_qty) + parseFloat(formObj.item_qty_bonus.value);
	}
	/*	if (formObj.item_qty_sample.value!="") 
		item_qty=parseFloat(item_qty)+parseFloat(formObj.item_qty_sample.value);
*/
	if (item_qty != 0) {
		var item_cost = parseFloat(formObj.item_cost_value.value) / parseFloat(item_qty);
		/**
		 * @Name - Priya
		 * @Date - 31/05/2010
		 * @Inc# - 
		 * @Desc -  To round up item_cost_value value based on the no_of_decimals_for_cost column in st_acc_entity_param table
		 */
	var no_of_decimals_for_cost= eval(formObj.no_of_decimals_for_cost.value);
		/*item_cost = parseFloat(item_cost) * 1000;
		item_cost = Math.round(item_cost);
		item_cost = parseFloat(item_cost) / 1000;*/
		item_cost = setNumber(item_cost,no_of_decimals_for_cost);
		formObj.user_grn_unit_cost_in_pur_uom.value = item_cost;
		formObj.grn_unit_cost_in_pur_uom.value = item_cost;
		formObj.tmp_cost.value = item_cost;
		if (formObj.no_of_labels.value == "") {
			/** @Name - Priya
				* @Date - 10/02/2010
				* @Inc# - 19092 
				* @Desc - Math.ceil() function is used to round up the decimal value to the nearest max integer value.
			*/
			formObj.no_of_labels.value = Math.ceil(item_qty);
		}
	} else {
		formObj.user_grn_unit_cost_in_pur_uom.value = "";
		formObj.grn_unit_cost_in_pur_uom.value = "";
	}
}
async function previewDetails() {
	var store_code = document.formGoodsReceivedNoteHeader.store_code.value;
	var doc_type_code = document.formGoodsReceivedNoteHeader.doc_type_code.value;
	var supplier = "";
	if (document.formGoodsReceivedNoteHeader.supp_code.value != "") {
		supplier = document.formGoodsReceivedNoteHeader.supp_code.options[document.formGoodsReceivedNoteHeader.supp_code.options.selectedIndex].text;
	} else {
		supplier = "";
	}
	//var supplier = document.formGoodsReceivedNoteHeader.supp_code.options[document.formGoodsReceivedNoteHeader.supp_code.options.selectedIndex].text;
//	var doc_date	 =parent.frameGoodsReceivedNoteHeader.formGoodsReceivedNoteHeader.doc_date.value;
	var retVal = "";
	var dialogHeight = "90vh";
	var dialogWidth = "80vw";
	var dialogTop = "200";
	var center = "1";
	var status = "no";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments = "";
	var url = "../../eST/jsp/ReplaceGrnPreviewDetails.jsp?store_code=" + store_code + "&doc_type_code=" + doc_type_code + "&supplier=" + supplier;
	retVal = await window.showModalDialog(url, arguments, features);
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
async function callRTVBatchSearch() {
	var formObj = document.formGoodsReceivedNoteListHeader;
	formObj.user_grn_unit_cost_in_pur_uom.readOnly = false;
	if (!confirm(getMessage("RTV_REF_REFRESHED", "ST"))) {
		return;
	}	//alert(parent.parent.frameGoodsReceivedNoteHeader.document.formGoodsReceivedNoteHeader.supp_code);
	var arrayObject = new Array(parent.parent.frameGoodsReceivedNoteHeader.document.formGoodsReceivedNoteHeader.supp_code, formObj.item_code);
	var names = new Array(getLabel("Common.Supplier.label", "Common"), getLabel("Common.item.label", "Common"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.parent.messageFrame);
	if (blankObject == true) {
		var _store_code = parent.parent.frameGoodsReceivedNoteHeader.document.formGoodsReceivedNoteHeader.store_code.value;
		var _supp_code = parent.parent.frameGoodsReceivedNoteHeader.document.formGoodsReceivedNoteHeader.supp_code.value;
		var _item_code = formObj.item_code.value;
		batch_retval = await callRTVBatchSearchWindow(_item_code, _store_code, _supp_code);
 
		
		if (batch_retval != "" || batch_retval == null) {
			//parent.frameGoodsReceivedNoteListDetail.location.href="../../eST/jsp/ReplacementGRNListDetail.jsp?index="+formObj.index.value+"&item_code="+formObj.item_code.value+"&function_id"+parent.parent.function_id;
			document.getElementById('associatedrtv').disabled = false;
			// Added on 4/18/2005 by Ram for RTV_unit_cost checking,,,
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			var xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/ReplacementGRNValidate.jsp?validate=CHECK_RTV_UNIT_COST&item_code=" + _item_code, false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
 			if (responseText) {
				if (flag != formObj.grn_unit_cost_in_pur_uom.value) {
					resflag = confirm(getMessage("CST_CHG_TO_RTV_CST", "ST"));
					if (resflag) {
						set_unit_cost(flag);
						if(formObj.po_details_applicable_yn.value=="Y"){
							formObj.po_cost.value = "";
							formObj.po_discount.value = "";
							formObj.po_tax.value = "";
						}
						formObj.user_grn_unit_cost_in_pur_uom.disabled = false;
						formObj.item_cost_value.disabled = false;
					} else {
						refreshDetails();
						return;
					}
				}
			} else {
				set_unit_cost(formObj.rtv_unit_cost.value);
			}
		} else {
			document.getElementById('associatedrtv').disabled = true;
		}
	}
}
async function callRTVBatchSearchWindow(item_code, _store_code, _supp_code) {
	retVal = await window.showModalDialog("../../eST/jsp/ReplaceGRNBatchSearchFrame.jsp?item_code=" + item_code + "&store_code=" + _store_code + "&supp_code=" + _supp_code, "", "dialogHeight:90vh; dialogWidth:80vw; center:0; status: no; dialogLeft :200; dialogTop :100;");
    //retVal=window.open("../../eST/jsp/BatchSearchGoodsReturnToVendorFrame.jsp?item_code="+item_code+"&store_code="+_store_code+"&supp_code="+_supp_code,'','dialogHeight:30; dialogWidth:50; center:0; status: no; dialogLeft :200; dialogTop :100;');
	if (retVal == null) {
		retVal = "";
	}
	return retVal;
}
async function callRTVRefPreview() {
	if (document.getElementById('associatedrtv').disabled == true) {
		return;
	} else {
		var item_code = document.formGoodsReceivedNoteListHeader.item_code.value;
		var item_desc = document.formGoodsReceivedNoteListHeader.item_desc.value;
		var retVal = "";
		var dialogHeight = "90vh";
		var dialogWidth = "80vw";
		var dialogTop = "200";
		var center = "1";
		var status = "no";
		var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments = "";
		/**
			* @Name - Priya 
			* @Date - 15/06/2010
			* @Inc# - IN022070
			* @Desc - To Display the Item desc without junck characters
			* added 'encodeURIComponent(item_desc,"UTF-8")' in the next line code
			*/
		var url = "../../eST/jsp/ReplaceGrnRtvRefPreviewDetails.jsp?item_code=" + item_code + "&item_desc=" + encodeURIComponent(item_desc,"UTF-8");
		retVal = await window.showModalDialog(url, arguments, features);
	}
}
/*function changeunitcost()
{
	resflag=confirm(getMessage("Unit Cost will be changed based on RTV Unit Cost ..."));
	var formObj=document.formGoodsReceivedNoteListHeader;
	if (resflag)
	{
		formObj.grn_unit_cost_in_pur_uom.value =formObj.grn_unit_cost_in_pur_uom.value;
	}
}*/
function set_unit_cost(last_pur_cost) {
	var formObj = document.formGoodsReceivedNoteListHeader;
	formObj.grn_unit_cost_in_pur_uom.value = last_pur_cost;
	/**
	 * @Name - Priya
	 * @Date - 31/05/2010
	 * @Inc# - 
	 * @Desc -  As last_pur_cost is rounded up already in validate jsp the setnumber function is removed
	 */
	formObj.user_grn_unit_cost_in_pur_uom.value = last_pur_cost;
	formObj.grn_unit_cost_in_pur_uom.value = formObj.user_grn_unit_cost_in_pur_uom.value;
//formObj.rtv_unit_cost.value=formObj.user_grn_unit_cost_in_pur_uom.value;
	document.formGoodsReceivedNoteListHeader.tmp_cost.value = last_pur_cost;
	calculateValue();
}
function chk_RTV_Cost_change() {
	var formObj = document.formGoodsReceivedNoteListHeader;
	if (formObj.user_grn_unit_cost_in_pur_uom.value != formObj.rtv_unit_cost.value) {
		resflag = confirm("Unit Cost will be changed ..");
		if (!resflag) {
			if (formObj.rtv_unit_cost.value == "null") {
				formObj.rtv_unit_cost.value = "0";
			}
			formObj.user_grn_unit_cost_in_pur_uom.value = formObj.rtv_unit_cost.value;
			formObj.grn_unit_cost_in_pur_uom.value = formObj.rtv_unit_cost.value;
		}
	}
}
function issueUOMQtyChk() {
	var formObj = document.formGoodsReceivedNoteListHeader;
	toConvFactor();
	var dec_factor = ((formObj.no_of_labels.value) * (formObj.pur_uom_conv.value)) % (formObj.tmp_conv.value);
	/*if(formObj.dec_allowed_yn.value=="N"){
	if (dec_factor > 1) {
		alert("Total Quantity Should Be In Multiples Of " + formObj.tmp_conv.value);
		return false;
	} else {
		return true;
	}
	}*/
	return true;
}
function setTempConvFactor(tmp) {
	if (document.formGoodsReceivedNoteListHeader == null) {
		parent.frames[2].frames[0].document.formGoodsReceivedNoteListHeader.tmp_conv.value = tmp;
	} else {
		document.formGoodsReceivedNoteListHeader.tmp_conv.value = tmp;
	}
}
function toConvFactor() {
	var formObj = document.formGoodsReceivedNoteListHeader;
	var item_code = "";
	if (formObj == null) {
		formObj = parent.frames[2].frames[0].document.formGoodsReceivedNoteListHeader;
		var store_code = parent.frameGoodsReceivedNoteHeader.formGoodsReceivedNoteHeader.store_code.value;
	} else {
		var store_code = parent.parent.frameGoodsReceivedNoteHeader.formGoodsReceivedNoteHeader.store_code.value;
	}
	item_code = formObj.item_code.value;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	var xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/ReplacementGRNValidate.jsp?validate=setToConv" + "&store_code=" + store_code + "&item_code=" + item_code, false);
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	eval(responseText);
}
function checkUnitCost(obj){
	var unit_cost = eval(parent.parent.frameGoodsReceivedNoteList.frameGoodsReceivedNoteListHeader.document.formGoodsReceivedNoteListHeader.user_grn_unit_cost_in_pur_uom.value);
	if(eval(obj.value)<unit_cost && document.formGoodsReceivedNoteListDetail.lesser_sale_price_yn.value == "Y"){
		alert(getMessage("SALE_PRICE_NOT_LESSER_UNIT_PRICE", "ST"));
		obj.focus();
	}
}
function calculatePoCost(obj){
	formObj = document.formGoodsReceivedNoteListHeader;
	if((formObj.po_cost.value == "")&&(formObj.po_discount.value != ""||formObj.po_tax.value != "")){
		alert("PO Cost Cannot Be Blank");
		formObj.po_discount.value = "";
		formObj.po_tax.value = "";
	}
	if(eval(formObj.po_cost.value)<eval(formObj.po_discount.value)){
		alert("Discount Cannot Be Greater Than PO Cost");
		formObj.po_discount.focus();
		return;
	}
	/**
	 * @Name - Priya
	 * @Date - 31/05/2010
	 * @Inc# - 
	 * @Desc -  To round up user_grn_unit_cost_in_pur_uom & grn_unit_cost_in_pur_uom values based on the no_of_decimals_for_cost column in st_acc_entity_param table
	 */
	var no_of_decimals_for_cost= eval(formObj.no_of_decimals_for_cost.value);
	if(formObj.po_cost.value == ""){
		formObj.po_discount.value = "";
		formObj.po_tax.value = "";
		formObj.user_grn_unit_cost_in_pur_uom.value = setNumber(formObj.tmp_cost.value, no_of_decimals_for_cost);
		formObj.grn_unit_cost_in_pur_uom.value = setNumber(formObj.tmp_cost.value, no_of_decimals_for_cost);
		formObj.user_grn_unit_cost_in_pur_uom.disabled = false;
		formObj.item_cost_value.disabled = false;
	}else{
		var po_cost = formObj.po_cost.value == ""?"0":formObj.po_cost.value
		var po_discount = formObj.po_discount.value == ""?"0":formObj.po_discount.value
		var po_tax = formObj.po_tax.value == ""?"0":formObj.po_tax.value
		var cost = (eval(po_cost) - eval(po_discount)) + ((po_cost)* (po_tax)/100);
		formObj.user_grn_unit_cost_in_pur_uom.value = setNumber(cost, no_of_decimals_for_cost);
		formObj.grn_unit_cost_in_pur_uom.value = setNumber(cost, no_of_decimals_for_cost);
		formObj.user_grn_unit_cost_in_pur_uom.disabled = true;
		formObj.item_cost_value.disabled = true;
	}
}
function setPOCost(obj){
	formObj = document.formGoodsReceivedNoteListHeader;
	formObj.tmp_cost.value = formObj.grn_unit_cost_in_pur_uom.value;
	//formObj.po_cost.value = obj.value;
}
async function showRemarks() {
	var rem = "";
	rem = await window.showModalDialog("../../eST/jsp/ReplaceGRNRemarks.jsp?function_id=" + parent.parent.function_id, "", "dialogHeight:33vh; dialogWidth:37vw; center:0; status: no; dialogLeft :75; dialogTop :250;");
	if (rem != null) {
		
		document.formGoodsReceivedNoteHeader.remarks.value = rem;
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
		dataValueArray[2] = "GRN";
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
	var ret1=unescape(returnedValues);
//	alert("ret1"+ret1);
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
function updateRemarks() {
	formObject = document.formReplaceGRNRemarks;
	if (!setTextAreaMaxLength(formObject.remarks, 200)) {
		alert(getMessage("REMARKS_NOT_EXCEED_200_CH", "Common"));
		return;
	}
	
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlStr = getXMLString(formObject); //Commented by Sakti Sankar against Inc#37941 for Special character issue
	//xmlStr = getEnhancedXMLString(formObject); //Added by Sakti Sankar against Inc#37941
	var xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObject), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/ReplacementGRNValidate.jsp?validate=SET_REMARKS", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	//alert(responseText);
	eval(responseText);
	window.returnValue = formObject.remarks_code_2.value;
	window.close();
}
function setDecimalParameters(allow_yn,no_decimals,frmObject) {
		
	
		frmObject.allow_deci_yn.value = allow_yn;
		frmObject.no_deci.value = no_decimals;

}
function allow_restrict_decimals(obj,event)
{
var allow_yn =	document.formGoodsReceivedNoteListHeader.allow_deci_yn.value ;
var  no_decimals = document.formGoodsReceivedNoteListHeader.no_deci.value ;

 if(allow_yn=='N')
	   obj.onkeypress=function(){return isValidInteger()};
	
	if(allow_yn=='Y')
	{
	   obj.onkeypress=function(){return isValidNumber(obj,event,12,parseInt(no_decimals))};
      
	}
}//formGoodsReceivedNoteListDetail
function allow_restrict_decimals1(obj,event)
{
	
var allow_yn =	document.formGoodsReceivedNoteListDetail.allow_deci_yn.value ;
var  no_decimals = document.formGoodsReceivedNoteListDetail.no_deci.value ;
if(allow_yn=='N')
obj.onkeypress=function(){return isValidInteger()};

if(allow_yn=='Y')
	   obj.onkeypress=function(){return isValidNumber(obj,event,12,parseInt(no_decimals))};
}
function allow_restrict_decimals2(obj,event)
{
	
var allow_yn =	document.BatchsearchForm.allow_deci_yn.value ;
var  no_decimals = document.BatchsearchForm.no_deci.value ;
if(allow_yn=='N')
obj.onkeypress=function(){return isValidInteger()};

if(allow_yn=='Y')
	   obj.onkeypress=function(){return isValidNumber(obj,event,12,parseInt(no_decimals))};
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

function setUOMConvFactor1(_value,_rulestring) {
	document.getElementById('id_pur_uom_conv').innerHTML = _rulestring;
	document.getElementById('pur_uom_conv').value = _value;
}
function getShelfLifeExpiryDate(expiry_date_object,i){

	var shelf_life_date = document.forms[0].shelfLifeDate;
	var toDateArray;
	var fromDateArray;
	var toDate = expiry_date_object.value;
	var fromDate = shelf_life_date.value;
	if (fromDate.length > 0 && toDate.length > 0) {
		toDateArray = fromDate.split("/");
		fromDateArray = toDate.split("/");
		var toDateObject = new Date(toDateArray[2], (toDateArray[1] - 1), toDateArray[0]);
		var fromDateObject = new Date(fromDateArray[2], (fromDateArray[1] - 1), fromDateArray[0]);
		if (Date.parse(fromDateObject) <= Date.parse(toDateObject)) {
			var sh_life = confirm("Expiry Date "+toDate+" is not greater than the Shelf Life period "+fromDate+" . Do you want to Continue ? ");
			if(sh_life == false){
				expiry_date_object.focus();
				return;
			}	
		}
	}	
}


