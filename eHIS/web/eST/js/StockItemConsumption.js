/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
06/02/2017		IN0061112		Badmavathi B							GHL-CRF-0413 - Barcode search
24/05/2017		IN063603		Badmavathi B							GHL-CRF-0456
29/05/2017		IN063673		Badmavathi B							GHL-SCF-1169  - 'Process Expired Batches'-> unchecked , 'Use After Expiry' -> checked
06/11/2017		IN064968 			Shazana Hasan						MMS-DM-CRF-0112 - Barcode Item Desc Decoding
15/11/2017		INC065695			Shazana Hasan						MMS-DM-CRF-0112 - Barcode search
---------------------------------------------------------------------------------------------------------
*/
var prevObj = null;
var prevColor = null;
var result = false;//ADDEDFOR TH-KW-CRF-0043

function create() {
	f_query_add_mod.location.href = "../../eST/jsp/StockItemConsumptionFrame.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
}
function query() {
	f_query_add_mod.location.href = "../../eST/jsp/StockItemConsumptionQueryFrame.jsp?mode=" + MODE_MODIFY + "&function_id=" + function_id + "&doc_type_code=C1SAL&doc_no=29";
}
function reset() {
	f_query_add_mod.location.reload();
}
function onSuccess() {
	f_query_add_mod.location.href = "../../eCommon/html/blank.html";
}
function disableEncounter() {
	if(document.formStockItemConsumptionHeader.encounter_id!=undefined || document.formStockItemConsumptionHeader.encounter_id!=null)
		document.formStockItemConsumptionHeader.encounter_id.disabled = true;
}
function checkTRNType(obj) {
	document.formStockItemConsumptionHeader.patient_id.value = "";
	document.formStockItemConsumptionHeader.patient_name.value = "";
	document.formStockItemConsumptionHeader.encounter_id.disabled = (obj.value == "R" || obj.value == "C");
	if (obj.value == "R" || obj.value == "C") {
		document.formStockItemConsumptionHeader.encounter_id.value = "";
		document.getElementById("id_encounter_id_gif").style.visibility = "hidden";
	} else {
		document.getElementById("id_encounter_id_gif").style.visibility = "visible";
	}
	if (obj.value == "C") {
		document.formStockItemConsumptionHeader.patient_id.value = "";
		document.getElementById("id_patient_id_gif").style.visibility = "hidden";
	} else {
		document.getElementById("id_patient_id_gif").style.visibility = "visible";
	}
	var listObject = document.formStockItemConsumptionHeader.encounter_id;
	if(document.formStockItemConsumptionHeader.encounter_id.options.length>1){
		var select_option = "---" + getLabel("Common.defaultSelect.label", "Common") + "---";
		var len = listObject.options.length;
		for (i = 0; i < len; i++) {
			listObject .remove(0);
		}
		var listOption = createListOption("", select_option);
		listObject.add(listOption);
	}

}
function deleterecord() {
	var errorPage = "../../eCommon/jsp/error.jsp";
	var formObj = f_query_add_mod.frameStockItemConsumptionHeader.document.formStockItemConsumptionHeader;
	var prevMode = formObj.mode.value;
	if (prevMode == MODE_INSERT) {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("OPER_CANCELLED", "ST");
		return;
	}
	formObj.mode.value = MODE_DELETE;
	if (confirmDelete() != YES) {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("OPER_CANCELLED", "ST") + "<BR>" + flag;
		return;
	}
	var responseText = formApply(formObj, ST_CONTROLLER);
	eval(responseText);
	messageFrame.location.href = errorPage + "?err_num=" + message + "<BR>" + flag;
	if (result) {
		onSuccess();
	} else {
		formObj.mode.value = prevMode;
	}
}
async function searchPatient() {
	var patient_id = await PatientSearch();
	var formObj = document.forms[0];
	if (!((patient_id == null) || (patient_id == ""))) {
		formObj.patient_id.value = patient_id;
	}
	formObj.patient_id.focus();
}
function getPatientName(_patient_id) {
	var formObj = document.formStockItemConsumptionHeader;
	var new_con_screen_yn =formObj.new_con_screen_yn.value;//Added for TH-KW-CRF-0042
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/StockItemConsumptionValidate.jsp?patient_id=" + _patient_id +"&new_con_screen_yn="+new_con_screen_yn+ "&sal_type=" + document.formStockItemConsumptionHeader.sal_trn_type.value + "&validate=PATIENT_NAME", false);//  new_con_screen_ynAdded for TH-KW-CRF-0042
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	if (!result) {
		alert(getMessage(flag, "ST"));
		formObj.patient_id.focus();
	}
}
function setPatientName(_patient_name) {
	document.formStockItemConsumptionHeader.patient_name.innerText = _patient_name;
}
async function callItemSearchScreen() {
	var search_string = "";
	parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	if (!parent.frameStockItemConsumptionListHeader.formStockItemConsumptionListHeader.item_desc.readOnly) {
		search_string = parent.frameStockItemConsumptionListHeader.formStockItemConsumptionListHeader.item_desc.value;
	}
	var store_code = parent.parent.frameStockItemConsumptionHeader.formStockItemConsumptionHeader.store_code.value;
	var category = "A";
	var sole_source = "A";
	var ps_item = "A";
	var mfg_item = "A";
	var expiry = "A";
	var consignment = "A";
	var chkitemstorecmb = "N";
	var kit = "Y";
	var item_class = parent.parent.frameStockItemConsumptionHeader.formStockItemConsumptionHeader.item_class_code.value;
	var item_class_check = parent.parent.frameStockItemConsumptionHeader.formStockItemConsumptionHeader.item_class_check.value;
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
		//Modified by Sakti against AMS-CRF-0011 trn_type passing
		var retVal = await callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment,"CON", chkitemstorecmb, "", "", "", kit);//modified 'SAL' to 'CON' against GHL-CRF-0456 
		if (retVal != null) {
			if (retVal[0] == "kit") {
				var xmlHttp = new XMLHttpRequest();
				var xmlDoc="";
				//xmlDoc.loadXML(getXMLString(null));
				xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
				xmlHttp.open("POST", "../../eST/jsp/StockItemConsumptionValidate.jsp?kit_template_code=" + retVal[1] + "&validate=KIT_TEMPLATE&store_code=" + store_code, false);
				xmlHttp.send(xmlDoc);
				responseText = xmlHttp.responseText;
				eval(responseText);
				return;
			}
			parent.parent.frameStockItemConsumptionHeader.document.formStockItemConsumptionHeader.store_code_disabled.value = "disabled";
		//parent.parent.frameStockItemConsumptionHeader.document.formStockItemConsumptionHeader.store_code="disabled";
			document.formStockItemConsumptionListHeader.item_code.value = retVal[0];
			document.formStockItemConsumptionListHeader.item_desc.value = retVal[1];
			document.formStockItemConsumptionListHeader.item_desc.readOnly = true;
			document.formStockItemConsumptionListHeader.expiry_yn.value = retVal[2];
			document.formStockItemConsumptionListHeader.uom_code.value = retVal[13];
			document.getElementById("id_store_item_unit_cost").innerHTML = retVal[14];
			document.getElementById("id_uom").innerHTML = retVal[15];
			/**
				* @Name - Suri
				* @Date - 19/01/2010
				* @Inc# - IN015496
				* @Desc - Code added to accept decimal values dynamically.
				* @ getAllowDecimalsYN() return's 'Y' that accept decimal values dynamically.other wise it should not accept decimal values dynamically. 
			*/
			document.formStockItemConsumptionListHeader.dec_allowed_yn.value = retVal[27];
			var formObj = document.formStockItemConsumptionListHeader;
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/StockItemConsumptionValidate.jsp?item_code=" + formObj.item_code.value + "&store_code=" + store_code +"&dec_allowed_yn=" + formObj.dec_allowed_yn.value+"&item_qty=" + formObj.item_qty.value + "&validate=GET_STATUS", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			if (!result) {
				parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?";//err_num="+ getMessage(message);
				if (message == "PHY_INV_PROCESS_INITIATED") {
					alert(getMessage(message, "ST") + "\n" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + formObj.phy_inv_id.value);
				} else {
					alert(getMessage(message, "ST"));
				}
//			refreshDetails();
				parent.frameStockItemConsumptionListHeader.location.href = "../../eST/jsp/StockItemConsumptionListHeader.jsp";
			}
			document.formStockItemConsumptionListHeader.item_qty.focus();
		}
	}
}
function setStockDetails(_stock_item_yn, _store_item_unit_cost, _available_stock,_conv_factor) {//Modified by suresh.r on 21-08-2014 added _conv_factor against Inc#50616
	document.formStockItemConsumptionListHeader.stock_item_yn.value = _stock_item_yn;
	if (_stock_item_yn == "Y") {
		//document.getElementById("id_store_item_unit_cost").innerText = _store_item_unit_cost;
		//Modified by suresh.r on 21-08-2014 against Inc#50616 beg
		var no_of_decimals_for_cost = eval(document.formStockItemConsumptionListHeader.no_of_decimals_for_cost.value);
		var unit_cost = _store_item_unit_cost*_conv_factor;
		document.getElementById("id_store_item_unit_cost").innerText = setNumber(unit_cost,no_of_decimals_for_cost);
		//Modified by suresh.r on 21-08-2014 against Inc#50616 end
		 document.getElementById("id_stock_available").innerText = _available_stock;
		if (_available_stock == "0") {
			//parent.location.reload();
		}
	} else {
		document.formStockItemConsumptionListHeader.batchsearch.disabled = true;
		document.formStockItemConsumptionListHeader.edit.disabled = true;
	}
}
function ComputeCost() {
	var quantity = document.formStockItemConsumptionListHeader.item_qty.value;
	var cost = document.getElementById("id_store_item_unit_cost").innerText;
	 /** @Name - Priya
	* @Date - 07/06/2010
	* @Inc# -  
	* @Desc - To round up id_item_sal_value with no_of_decimals_for_cost.
	*/
	 /** @Name - Priya
	* @Date - 14/06/2010
	* @Inc# - 22075 
	* @Desc - Removed an extra ';' from the below coding as it was giving script error.
	*/
	var no_of_decimals_for_cost = eval(document.formStockItemConsumptionListHeader.no_of_decimals_for_cost.value);
	if (isNaN(quantity) || isNaN(cost)) {
		document.getElementById("id_item_sal_value").innerText = "";
		return;
	}
	var value = setNumber(quantity * cost, no_of_decimals_for_cost);
	document.getElementById("id_item_sal_value").innerText = value;
}
function CheckQuantity() {
	var fields = new Array();
	fields[0] = document.formStockItemConsumptionListHeader.item_code;
	var dec_allowed_yn = document.formStockItemConsumptionListHeader.dec_allowed_yn.value;
	var names = new Array(getLabel("Common.item.label", "Common"));

	var blankObject = checkSTFields(fields, names, parent.parent.parent.messageFrame);
	 //alert("dec_allowed_yn--->"+dec_allowed_yn)
	if(blankObject==true){
		if(dec_allowed_yn=='N'){
			if (!checkIntegerFormat(document.formStockItemConsumptionListHeader.item_qty)) {
				return false;
				}
		}else if(dec_allowed_yn=='Y'){
		 if (!checkDoubleFormat(document.formStockItemConsumptionListHeader.item_qty)) {
		  	return false;
			}
		}
		parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		calTotalQty();
		ComputeCost();
		if (document.formStockItemConsumptionListHeader.stock_item_yn.value == "N") {
			return true;
		}
		if (parseFloat(document.formStockItemConsumptionListHeader.item_qty.value) > parseFloat(document.getElementById("id_stock_available").innerText)) {
			alert(getMessage("QTY_NOT_GRT_AVLQTY", "ST"));
			document.formStockItemConsumptionListHeader.tot_item_qty.value="";
			//document.formStockItemConsumptionListHeader.item_qty.focus();
			document.formStockItemConsumptionListHeader.item_qty.value = "";
			return false;
		}
	}else{
		document.formStockItemConsumptionListHeader.item_qty.value = "";
	}
}
function CheckValue() {
	if (document.formStockItemConsumptionListHeader.item_cost_value.value != null) {
		if (document.formStockItemConsumptionListHeader.item_cost_value.value == 0) {
			alert(getMessage("CANNOT_BE_ZERO", "Common"));
		}
	}
	if (isValidDouble(document.formStockItemConsumptionListHeader.quantity)) {
	}
	ComputeCost();
}
function addToList() {
	var formObj = parent.frameStockItemConsumptionListHeader.document.formStockItemConsumptionListHeader;
	/*
	if (!formObj.item_desc.readOnly) {
		if(!validateCommonCodeSearch(formObj.item_code, formObj.item_desc)){
			alert(message);
			return;
		}
	}
*/
	//var arrayObject = new Array(formObj.item_code,formObj.item_qty);
	var fields = new Array();
	fields[0] = formObj.item_code;
	fields[1] = formObj.item_qty;
	var names = new Array(getLabel("Common.item.label", "Common"), getLabel("Common.Quantity.label", "Common"));
	var blankObject = checkSTFields(fields, names, parent.parent.parent.messageFrame);
	var store_code = parent.parent.frameStockItemConsumptionHeader.document.formStockItemConsumptionHeader.store_code.value;
	
	if (blankObject == true) {
		//formObj.apply.disabled = true;  Commented against GHL-SCF-1169
		if (parent.frameStockItemConsumptionListDetail.document.formStockItemConsumptionListDetail == null && formObj.stock_item_yn.value == "Y") {
			var formObj = document.formStockItemConsumptionListHeader;//alert("inside edit");
			var _item_code = formObj.item_code.value;
			//var item_qty=formObj.item_qty.value;
			var item_qty = formObj.tot_item_qty.value;
			parent.frameStockItemConsumptionListDetail.location.href = "../../eST/jsp/StockItemConsumptionListDetail.jsp?function=edit&store_code=" + store_code + "&item_code=" + _item_code + "&item_qty=" + item_qty + "&function_id=" + parent.parent.function_id + "&addToList=true";
			return;
		}
		if (formObj.stock_item_yn.value == "Y") {
//var formObj=  parent.frameStockItemConsumptionListHeader.document.formStockItemConsumptionListHeader;
			var formObjDtl = parent.parent.frameStockItemConsumptionList.frameStockItemConsumptionListDetail.document.formStockItemConsumptionListDetail;
			var no_of_decimals=formObjDtl.no_of_decimals.value;
			var proceed = false;
			var messageFrame = parent.parent.messageFrame;
			var errorPage = "../../eCommon/jsp/error.jsp";
			//var item_qty=formObj.item_qty.value;
			var item_qty = formObj.tot_item_qty.value;
			_total_checkboxes = formObjDtl.total_checkboxes.value;
			expired_batch = formObjDtl.expired_batch.value;
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
			if(formObjDtl.dec_allowed_yn.value=='Y')
      {
				sum=sum.toFixed(no_of_decimals);
      }
			if (sum != item_qty) {
				alert(getMessage("QUANTIY_MUST_BE_EQUAL", "ST"));
				formObj.apply.disabled = false;
				return;
			}
		}
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		if (formObj.stock_item_yn.value == "Y") {
			//xmlDoc.loadXML(getEnhancedXMLString(formObjDtl));
			xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObjDtl), "text/xml");
		} else {
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		}

	//	xmlHttp.open("POST", "../../eST/jsp/StockItemConsumptionValidate.jsp?index="+formObj.index.value+"&doc_srl_no="+formObj.doc_srl_no.value+"&item_code="+formObj.item_code.value+"&item_desc="+formObj.item_desc.value+"&item_qty="+formObj.item_qty.value+"&item_unit_cost="+formObj.item_unit_cost.value +"&item_cost_value="+formObj.item_cost_value.value+"&remarks="+formObj.remarks.value+"&expiry_yn="+formObjDtl.expiry_yn.value+"&batch_id_applicable_yn="+formObjDtl.batch_id_applicable_yn.value+"&trade_id_applicable_yn="+formObjDtl.trade_id_applicable_yn.value+"&stock_uom_code="+ formObj.uom_code.value+"&uom="+ formObjDtl.uom.value+"&validate=ADD_TO_LIST", false);
		/**
			* @Name - Priya 
			* @Date - 22/12/2009
			* @Inc# - IN017176
			* @Desc - To Display the character ® properly in Item desc without junck characters
			* added 'encodeURIComponent(formObj.item_desc.value,"UTF-8")' in the next line code
			*/
			if(formObj.remarks.value == "" || formObj.remarks.value == null){
			formObj.remarks_code_1.value = "";
			}
		//Commented and Added by suresh.r on 14-04-2014 against #048584(SKR-SCF-0987)
		//xmlHttp.open("POST", "../../eST/jsp/StockItemConsumptionValidate.jsp?index=" + formObj.index.value + "&doc_srl_no=" + formObj.doc_srl_no.value + "&item_code=" + formObj.item_code.value + "&item_desc=" + encodeURIComponent(formObj.item_desc.value,"UTF-8") + "&item_qty=" + formObj.item_qty.value + "&item_unit_cost=" + document.getElementById("id_store_item_unit_cost").innerText + "&item_cost_value=" + parent.frameStockItemConsumptionListHeader.document.getElementById("id_item_sal_value").innerText + "&expiry_yn=" + formObj.expiry_yn.value + "&uom_code=" + formObj.uom_code.value + "&stock_item_yn=" + formObj.stock_item_yn.value + "&remarks=" + escape(formObj.remarks.value)+ "&remarks_code=" + formObj.remarks_code_1.value + "&uom_desc=" + document.getElementById("id_uom").innerText + "&stock_available=" + document.getElementById("id_stock_available").innerText + "&expired_batch=" + expired_batch + "&ex_param_days=" + formObjDtl.ex_param_days.value + "&mm_trn_qty=" + sum +"&batchsearch="+formObjDtl.batchsearch.value+ "&batch_records=" + formObjDtl.total_checkboxes.value+"&dec_allowed_yn="+formObj.dec_allowed_yn.value+"&kit_temp_code="+formObj.kit_temp_code.value+"&usage_type="+formObj.usage_type.value+"&validate=ADD_TO_LIST", false);//02/08/12
		xmlHttp.open("POST", "../../eST/jsp/StockItemConsumptionValidate.jsp?index=" + formObj.index.value +"&site="+formObj.site.value+ "&doc_srl_no=" + formObj.doc_srl_no.value + "&item_code=" + formObj.item_code.value + "&item_desc=" + encodeURIComponent(formObj.item_desc.value,"UTF-8") + "&item_qty=" + formObj.item_qty.value + "&item_unit_cost=" + document.getElementById("id_store_item_unit_cost").innerText + "&item_cost_value=" + parent.frameStockItemConsumptionListHeader.document.getElementById("id_item_sal_value").innerText + "&expiry_yn=" + formObj.expiry_yn.value + "&uom_code=" + formObj.uom_code.value + "&stock_item_yn=" + formObj.stock_item_yn.value + "&remarks=" + escape(formObj.remarks.value)+ "&remarks_code=" + formObj.remarks_code_1.value + "&uom_desc=" + encodeURIComponent(document.getElementById("id_uom").innerText,"UTF-8") + "&stock_available=" + document.getElementById("id_stock_available").innerText + "&expired_batch=" + expired_batch + "&ex_param_days=" + formObjDtl.ex_param_days.value + "&mm_trn_qty=" + sum +"&batchsearch="+formObjDtl.batchsearch.value+ "&batch_records=" + formObjDtl.total_checkboxes.value+"&dec_allowed_yn="+formObj.dec_allowed_yn.value+"&kit_temp_code="+formObj.kit_temp_code.value+"&usage_type="+formObj.usage_type.value+"&validate=ADD_TO_LIST", false);//02/08/12//Added site for GHL-CRF-0413
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;

		eval(responseText);
		if (result) {
			parent.parent.frameStockItemConsumptionHeader.formStockItemConsumptionHeader.preview.disabled = false;
			parent.parent.frameStockItemConsumptionDetail.location.href = "../../eST/jsp/StockItemConsumptionDetail.jsp?index=" + formObj.index.value + "&store_code=" + store_code + "&avail_qty=" + document.getElementById("id_stock_available").innerText;
			refreshDetail();//formObj.index.value,parent.parent.frameStockItemConsumptionHeader.document.formStockItemConsumptionHeader.store_code.value,document.getElementById("id_stock_available").innerText);
		} else {
			formObj.apply.disabled = false;
			parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
			parent.frameStockItemConsumptionListDetail.location.href = "../../eCommon/html/blank.html";
		}
	}
}

// To refresh detail frame on click of Add
function refreshDetails(index, store_code, avail_qty) {
//	parent.parent.frameStockItemConsumptionDetail.location.reload();
	parent.parent.frameStockItemConsumptionDetail.location.href = "../../eST/jsp/StockItemConsumptionDetail.jsp?index=" + index + "&store_code=" + store_code + "&avail_qty=" + avail_qty;
	parent.frameStockItemConsumptionListHeader.location.href = "../../eST/jsp/StockItemConsumptionListHeader.jsp";
	parent.frameStockItemConsumptionListDetail.location.href = "../../eCommon/html/blank.html";
//	parent.frameStockItemConsumptionListDetail.location.href='../../eST/jsp/SalesListDetail.jsp';
//	parent.frameStockItemConsumptionListDetail.location.reload();
}
function refreshDetail() {
	parent.frameStockItemConsumptionListHeader.location.href = "../../eST/jsp/StockItemConsumptionListHeader.jsp";
	parent.frameStockItemConsumptionListDetail.location.href = "../../eCommon/html/blank.html";
}
async function apply() {
	var formObj = f_query_add_mod.frameStockItemConsumptionHeader.document.formStockItemConsumptionHeader;//Added for TH-KW-CRF-0043
	var new_con_screen_yn =f_query_add_mod.frameStockItemConsumptionHeader.document.formStockItemConsumptionHeader.new_con_screen_yn.value;//Added for TH-KW-CRF-0042

	if(new_con_screen_yn=="N"){
	if(f_query_add_mod.frameStockItemConsumptionDetail==undefined){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	}
	var bean_id = "stockItemConsumptionBean";
	var bean_name = "eST.StockItemConsumptionBean";
	var formObjDtl = f_query_add_mod.frameStockItemConsumptionDetail.document.formStockItemConsumptionDetail;////Added for TH-KW-CRF-0043
	totalCBox = parseInt(f_query_add_mod.frameStockItemConsumptionDetail.document.formStockItemConsumptionDetail.total_checkboxes.value);
	var checkBoxObj = null;
	var forDeletion = "";
	var noDetailExists = true;
	var errorPage = "../../eCommon/jsp/error.jsp";
	for (i = 0; i < totalCBox; i++) {
		checkBoxObj = eval("formObjDtl.checkbox" + i);//Added for TH-KW-CRF-0043
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
	for (i = 0; i < f_query_add_mod.frameStockItemConsumptionDetail.document.formStockItemConsumptionDetail.total_checkboxes.value; i++) {
		if ((eval("f_query_add_mod.frameStockItemConsumptionDetail.document.formStockItemConsumptionDetail.checkbox" + i).checked)) {
		} else {
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/StockItemConsumptionValidate.jsp?validate=ZERO_QUANTITY&index=" + i, false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			if (!result) {
				messageFrame.location.href = errorPage + "?err_num=" + getMessage("ISS_QTY_CANNOT_BE_ZERO", "ST");
				return;
			}
		}
	}
	
	 //Added by Rabbani INC NO:34758(RUT-CRF-0082) on 07/02/2013 Starts
	   if( formObj.hdr_remarks_reqd.value == "Y"){
	   var fields = new Array(formObj.remarks);
	   var names = new Array(getLabel("Common.remarks.label", "Common"));
		blankObject = checkSTFields(fields, names, messageFrame, errorPage);
		if(!blankObject){
		   formObj.remarks.focus();
			return;
		 }
		}
	}
	if(new_con_screen_yn=="Y"){
		var formHdrList =f_query_add_mod.frameStockItemConsumptionDetail.document.formStockItemConsumptionListHeader;
		var total_records = formHdrList.total_records.value;
		var errorPage = "../../eCommon/jsp/error.jsp";
		//alert("total_records===="+total_records)
		for (var z=0;z< total_records;z++){
			 var allow_yn = false;
			 //alert(eval("formHdrList.document.getElementById("select_")"+z).checked)
				if(eval(formHdrList.document.getElementById("select_"+z)).checked){
					if(eval(formHdrList.document.getElementById("store_qty_"+z)).value=="" || eval(formHdrList.document.getElementById("store_qty_"+z)).value=="0" ){
						alert("Selected record Value cannot be empty or zero");
						 return;
					}
                     allow_yn = true;
					 break;
				}
		     } 
		 if(!allow_yn){
	          messageFrame.location.href = errorPage + "?err_num=" + getMessage("ATLEAST_ONE_SELECTED", "Common");
			 return ;
		 }
	}
		//ends
	var arrayObject = new Array();
	
	var names = new Array();
	if (formObj.sal_trn_type.value != "R" && (formObj.sal_trn_type.value != "C" || new_con_screen_yn=="Y")) {// new_con_screen_yn Added for TH-KW-CRF-0042
	 if(formObj.patient_id.value!=""){
		arrayObject[0] = formObj.encounter_id;
		names[0] = getLabel("Common.encounterid.label", "Common");
	 }
	}
	if (formObj.sal_trn_type.value != "C") {
		if (formObj.sal_trn_type.value == "R") {
			arrayObject[0] = formObj.patient_id;
			names[0] = getLabel("Common.patientId.label", "Common");
		} else {
			arrayObject[1] = formObj.patient_id;
			names[1] = getLabel("Common.patientId.label", "Common");
		}
	}
	var blankObject = checkSTFields(arrayObject, names, messageFrame);
	if (blankObject == true) {
	

		//code added to set Authorize "Y" ....not calling validate function...
		if(new_con_screen_yn=="N"){
		forDeletion = forDeletion.substring(0, forDeletion.length - 1);
		formObj.records_to_delete.value = forDeletion;
		}/*else{
			for(var k=0;k<total_records;k++){
			      forDeletion += ("N,");
			}
			forDeletion=forDeletion.substring(0, forDeletion.length - 1);
			formObj.records_to_delete.value = forDeletion;
		}*/
		formObj.finalized_yn.value = "Y";
		/*		
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eST/jsp/StockItemConsumptionValidate.jsp?validate=CHECK_AUTHORIZE_ALLOWED&store_code="+formObj.store_code.value, false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		alert(responseText);
		eval(responseText);
		alert("hi 1"); 

		if (formObj.authorize_allowed_yn.value=="Y") {
					alert("hi 2"); 
			var response	=	confirmFinalize();
					alert("hi 3"); 
			if (response==YES) {
				formObj.finalized_yn.value="Y";
			}
		}

*/
		/*
		
		if (formObj.stock_item_yn.value=='Y') {
			xmlDoc.loadXML(getEnhancedXMLString(formObjDtl));
		}
		else{
		}

	//	xmlHttp.open("POST", "../../eST/jsp/StockItemConsumptionValidate.jsp?index="+formObj.index.value+"&doc_srl_no="+formObj.doc_srl_no.value+"&item_code="+formObj.item_code.value+"&item_desc="+formObj.item_desc.value+"&item_qty="+formObj.item_qty.value+"&item_unit_cost="+formObj.item_unit_cost.value +"&item_cost_value="+formObj.item_cost_value.value+"&remarks="+formObj.remarks.value+"&expiry_yn="+formObjDtl.expiry_yn.value+"&batch_id_applicable_yn="+formObjDtl.batch_id_applicable_yn.value+"&trade_id_applicable_yn="+formObjDtl.trade_id_applicable_yn.value+"&stock_uom_code="+ formObj.uom_code.value+"&uom="+ formObjDtl.uom.value+"&validate=ADD_TO_LIST", false);
		xmlHttp.open("POST", "../../eST/jsp/StockItemConsumptionValidate.jsp?index="+formObj.index.value+"&doc_srl_no="+formObj.doc_srl_no.value+"&item_code="+formObj.item_code.value+"&item_desc="+formObj.item_desc.value+"&item_qty="+formObj.item_qty.value+"&item_unit_cost="+document.getElementById("id_store_item_unit_cost").innerText +"&item_cost_value="+parent.frameStockItemConsumptionListHeader.document.getElementById("id_item_sal_value").innerText+"&expiry_yn="+formObj.expiry_yn.value+"&uom_code="+formObj.uom_code.value+"&stock_item_yn="+formObj.stock_item_yn.value+"&remarks="+escape(formObj.remarks.value)+"&uom_desc="+ document.getElementById("id_uom").innerText+"&stock_available="+document.getElementById("id_stock_available").innerText+"&validate=ADD_TO_LIST", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
//		alert(responseText);
		eval(responseText);
*/

//
		var responseText = formApply(formObj, ST_CONTROLLER);
		eval(responseText);

        //messageFrame.location.href = errorPage+"?err_num="+ message +"<BR>"+ flag;
		flag1 = (flag.split("~"))[0];
		flag2 = (flag.split("~"))[1];
		flag1 = (flag1 == "null" ? "" : flag1);
		if (result) {
			if (flag2 == "PY") {
				if (formObj.finalized_yn.value == "Y") {
					var PConfirm = await confirmPrinting();
					if (PConfirm == "Yes") {
						var xmlHttp = new XMLHttpRequest();
						var xmlDoc="";
						//xmlDoc.loadXML(getXMLString(null));
						xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
						//xmlHttp.open("POST", "../../eST/jsp/StockItemConsumptionValidate.jsp?validate=printOnlineDoc&msg=" + encodeURIComponent(message) + "&bean_id=" + bean_id + "&bean_name=" + bean_name, false);
						xmlHttp.open("POST", "../../eST/jsp/StockItemConsumptionValidate.jsp?validate=printOnlineDoc&msg=" + encodeURIComponent(message) + "&bean_id=" + bean_id + "&bean_name=" + bean_name, true);
						xmlHttp.send(xmlDoc);
						//responseText = xmlHttp.responseText;
						//alert("responseText 1 " + responseText ) ;
						//eval(responseText);
					}
				}
			} else	if (flag2 == "PN") {
						var xmlHttp = new XMLHttpRequest();
						var xmlDoc="";
						//xmlDoc.loadXML(getXMLString(null));
						xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
						//xmlHttp.open("POST", "../../eST/jsp/StockItemConsumptionValidate.jsp?validate=printOnlineDoc&msg=" + encodeURIComponent(message) + "&bean_id=" + bean_id + "&bean_name=" + bean_name, false);
						xmlHttp.open("POST", "../../eST/jsp/StockItemConsumptionValidate.jsp?validate=printOnlineDoc&msg=" + encodeURIComponent(message) + "&bean_id=" + bean_id + "&bean_name=" + bean_name, true);
						xmlHttp.send(xmlDoc);
						//responseText = xmlHttp.responseText;
						//alert("responseText 1 " + responseText ) ;
						//eval(responseText);
			}
			messageFrame.location.href = errorPage + "?err_num=" + message + "<BR>" + (result ? flag1 : "");
			onSuccess();
		} else {
			if (flag != "") {
				//xmlDoc.loadXML(getXMLString(null));
				xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
				xmlHttp.open("POST", "../../eST/jsp/StockItemConsumptionValidate.jsp?validate=GET_INDEX&item_code=" + flag, false);
				xmlHttp.send(xmlDoc);
				responseText = xmlHttp.responseText;
				eval(responseText);
				f_query_add_mod.frameStockItemConsumptionDetail.location.href = "../../eST/jsp/StockItemConsumptionDetail.jsp?function_id=" + function_id + "&index=" + flag;
			}
		}
		messageFrame.location.href = errorPage + "?err_num=" + message + "<BR>" + flag1;
		if (result) {
			onSuccess();
		}
	}
}
function setAuthorize_allowed(_authorize_allowed_yn) {
	f_query_add_mod.frameStockItemConsumptionHeader.document.formStockItemConsumptionHeader.authorize_allowed_yn.value = _authorize_allowed_yn;
}
function cancel_me() {
	parent.frameStockItemConsumptionListHeader.location.href = "../../eST/jsp/StockItemConsumptionListHeader.jsp";
	parent.parent.frameStockItemConsumptionList.frameStockItemConsumptionListDetail.location.href = "../../eCommon/html/blank.html";
	//Added for GHL-CRF-0413 starts
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/StockItemConsumptionValidate.jsp?validate=clearTmpBean", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	//Added for GHL-CRF-0413 ends
}
function editViewBatch() {
	var formObj = document.formStockItemConsumptionListHeader;//parent.frameStockItemConsumptionListHeader.formStockItemConsumptionListHeader;
	var store_code = parent.parent.frameStockItemConsumptionHeader.document.formStockItemConsumptionHeader.store_code.value;
	if (parent.frameStockItemConsumptionListDetail.document.formStockItemConsumptionListDetail != null) {
		if (!confirm(getMessage("BATCH_REFRESHED", "ST"))) {
			return;
		}
	}
	/*
			var formObj=document.formStockItemConsumptionListHeader;
			var store_code=parent.parent.frameStockItemConsumptionHeader.document.formStockItemConsumptionHeader.store_code.value;
			var _item_code=formObj.item_code.value;
			var item_qty=formObj.item_qty.value;
			parent.frameStockItemConsumptionListDetail.location.href="../../eST/jsp/SalesListDetail.jsp?function=edit&store_code="+store_code+"&item_code="+_item_code+"&item_qty="+item_qty+"&function_id="+parent.parent.function_id+"&addToList=true";
			return;
		}


if (!formObj.item_desc.readOnly) {
		if(!validateCommonCodeSearch(formObj.item_code, formObj.item_desc)){
			alert(message);
			return;
		}
	}
*/
	var arrayObject = new Array(formObj.item_code, formObj.item_qty);
	var names = new Array(getLabel("Common.item.label", "Common"), getLabel("Common.Quantity.label", "Common"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.parent.messageFrame);
	if (blankObject == true) {
		var _item_code = formObj.item_code.value;
		var item_qty = formObj.tot_item_qty.value;
		parent.frameStockItemConsumptionListDetail.location.href = "../../eST/jsp/StockItemConsumptionListDetail.jsp?function=edit&store_code=" + store_code + "&item_code=" + _item_code + "&expiry_yn=" + formObj.expiry_yn.value + "&item_qty=" + item_qty + "&index=" + formObj.index.value + "&function_id" + parent.parent.function_id;
	} else {
		if (formObj.item_code.value.length > 0) {
			formObj.item_qty.focus();
		} else {
			formObj.item_desc.focus();
		}
	}
}
async function callBatchSearch(called_from,new_item_code,new_item_qty,new_store_code,row_no,item_qty,temp_conv) {//Parameters added for TH-KW-CRF-0043
	if(called_from !="NEWSCREEN"){//if condition added for TH-KW-CRF-0043
	var formObj = document.formStockItemConsumptionListHeader;
	var store_code = parent.parent.frameStockItemConsumptionHeader.document.formStockItemConsumptionHeader.store_code.value;
	if (parent.frameStockItemConsumptionListDetail.document.formStockItemConsumptionListDetail != null) {
		if (!confirm(getMessage("BATCH_REFRESHED", "ST"))) {
			return;
		}
	}
	var barcode ="";
	/*
	if (!formObj.item_desc.readOnly) {
		if(!validateCommonCodeSearch(formObj.item_code, formObj.item_desc)){
			alert(message);
			return;
		}
	}
*/
     var _item_code = formObj.item_code.value;
	 var item_qty = formObj.item_qty.value;
	var arrayObject = new Array(formObj.item_code, formObj.item_qty);
	var names = new Array(getLabel("Common.item.label", "Common"), getLabel("Common.Quantity.label", "Common"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.parent.messageFrame);
	}else{//Adding start for TH-KW-CRF-0043
     var  _item_code = new_item_code;
	 var store_code =new_store_code;
	 var item_qty   = new_item_qty
	 var blankObject = true
	}//Adding end for TH-KW-CRF-0043
	if (blankObject == true) {
		
		var includeZeroStockBatches = "N";
		var includeExpiredBatches = "N";
		var includeSuspendedBatches = "N";
		var searchFunction = "Y";
		var multipleSelect = "Y";
		var retval = await callBatchSearchWindow(_item_code, store_code, includeZeroStockBatches, includeExpiredBatches, includeSuspendedBatches, searchFunction, multipleSelect,"","","","","",called_from,item_qty,temp_conv);//,"","","","","",called_from,item_qty,temp_conv Added for TH-KW-CRF-0043
		if (retval != null && retval !="" && retval !=undefined) {
			if(called_from !="NEWSCREEN"){//if condition added for TH-KW-CRF-0043
			parent.frameStockItemConsumptionListDetail.location.href = "../../eST/jsp/StockItemConsumptionListDetail.jsp?function=search&store_code=" + store_code + "&item_code=" + _item_code + "&expiry_yn=" + formObj.expiry_yn.value + "&index=" + formObj.index.value + "&item_qty=" + item_qty + "&function_id" + parent.parent.function_id;
			}else{//Adding start for TH-KW-CRF-0043
                var call ="batchsearch";
				var xmlHttp = new XMLHttpRequest();
	            var xmlDoc="";
				//xmlDoc.loadXML(getXMLString(null));
				xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
				xmlHttp.open("POST", "../../eST/jsp/StockItemConsumptionValidate.jsp?store_code="+new_store_code+"&item_code="+new_item_code+"&barcode="+barcode+"&call="+call+"&row_no="+row_no+"&item_qty="+new_item_qty+ "&validate=setBeanDetails", false);
				xmlHttp.send(xmlDoc);
				responseText = xmlHttp.responseText;
				eval(responseText);

			}//Adding end for TH-KW-CRF-0043
	//		parent.frameUrgentIssueListDetail.location.href="../../eST/jsp/GeneralBatchList.jsp?Param=BATCH";
		}
	} else {
		//blankObject.focus();
		if (formObj.item_code.value.length > 0) {
			formObj.item_qty.focus();
		} else {
			formObj.item_desc.focus();
		}
	}
}
function checkBatchQty(obj, available_qty) {
	if (checkDoubleFormat(obj)) {
		if (parseFloat(available_qty) < parseFloat(obj.value)) {
			alert(getMessage("QTY_NOT_GRT_AVLQTY", "ST"));
			obj.value='';//Edge Having issue as it is going in loop, so have to clear.
			obj.focus();
		}
	}
}
function checkRemarksLength(obj) {
	//if (!setTextAreaMaxLength(obj, 200)) {
	if (!setTextAreaMaxLength(obj, 201)) {
		alert(getMessage("REMARKS_CHAR_EXCEEDS_LIMIT", "ST"));
		obj.focus();
	}
}
function modifyData(index) {
	var trObject = eval(document.getElementById("tr_" + index));
	changeRowColor(trObject);
	parent.frameStockItemConsumptionList.location.href = "../../eST/jsp/StockItemConsumptionListFrame.jsp?function=modify&index=" + index + "&function_id" + parent.parent.function_id;
}
function Modify(obj) {
	var doc_no = obj.cells[1].innerText;
	var doc_type_code = obj.cells[4].innerText;
	parent.document.location.href = "../../eST/jsp/StockItemConsumptionFrame.jsp?mode=" + MODE_MODIFY + "&function_id=" + parent.parent.function_id + "&doc_type_code=" + doc_type_code + "&doc_no=" + doc_no;
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

/// Addded on Friday, July 30, 2004 
async function previewDetails() {
	var store_code = document.formStockItemConsumptionHeader.store_code.value;
	var doc_type_code = document.formStockItemConsumptionHeader.doc_type_code.value;
	var patient_id = document.formStockItemConsumptionHeader.patient_id.value;
	var patient_name = document.formStockItemConsumptionHeader.patient_name.value;
	var encounter = document.formStockItemConsumptionHeader.encounter_id.value;
	
	if (encounter == "" || encounter == null) {
		encounter == "";
	} else {
		encounter = document.formStockItemConsumptionHeader.encounter_id.options[document.formStockItemConsumptionHeader.encounter_id.options.selectedIndex].text;
	}
	
	var retVal = "";
	var dialogHeight = "70vh";
	var dialogWidth = "60vw";
	var dialogTop = "200";
	var center = "1";
	var status = "no";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments = "";
	var url = "../../eST/jsp/StockItemConsPreviewDetails.jsp?store_code=" + encodeURIComponent(store_code) + "&doc_type_code=" + encodeURIComponent(doc_type_code) + "&patient_id=" + patient_id + "&patient_name=" +encodeURIComponent(patient_name)+ "&encounter=" + encounter;
	retVal = await window.showModalDialog(url, arguments, features);
}

// Ends Friday, July 30, 2004

//added on December 10,2004
async function showHistory(trObj, index) {
	var trObj = eval(document.getElementById("tr_" + index));
	var item_desc = parent.frameStockItemConsumptionListHeader.document.formStockItemConsumptionListHeader.item_desc.value;
	var item_code = parent.frameStockItemConsumptionListHeader.document.formStockItemConsumptionListHeader.item_code.value;
	var manufacturer_name = eval("document.formStockItemConsumptionListDetail.manufacturer_name_" + index + ".value");
	var expiry_date = trObj.cells[0].innerText.substring(0, 10);
	var batch_id = trObj.cells[1].innerText;
	var trade_name = trObj.cells[2].innerText;
	var uom_desc = parent.frameStockItemConsumptionListHeader.document.getElementById("id_uom").innerHTML;
	retvalue = await window.showModalDialog("../../eST/jsp/SuspendOrReinstateBatchHistory.jsp?function_id=" + parent.parent.function_id + "&item_code=" + escape(item_code) + "&batch_id=" + batch_id + "&expiry_date=" + expiry_date + "&trade_name=" + trade_name + "&item_desc=" + escape(item_desc) + "&uom_desc=" + escape(uom_desc) + "&manufacturer_name=" + escape(manufacturer_name), "", "dialogHeight:30vh; dialogWidth:55vw; center:0; status: no; dialogLeft :75; dialogTop :250;");
}
function kitGetStatus() {
	var store_code = parent.parent.frameStockItemConsumptionHeader.document.formStockItemConsumptionHeader.store_code.value;
	var formObj = document.formStockItemConsumptionListHeader;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/StockItemConsumptionValidate.jsp?item_code=" + formObj.item_code.value + "&store_code=" + store_code + "&item_qty=" + formObj.item_qty.value + "&validate=GET_STATUS", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	if (!result) {
		if (message == "RECORD_ALREADY_EXISTS") {
			alert(getMessage(message, "ST"));
				//refreshDetails();
			return;
		}
		addToList1();
	}
	if (result) {
		/*			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			xmlDoc.loadXML(getXMLString(null));
			xmlHttp.open("POST", "../../eST/jsp/StockItemConsumptionValidate.jsp?item_code="+formObj.item_code.value+"&store_code="+store_code+"&validate=MIN_MAX_STATUS", false);
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText;
			//alert(responseText);
			eval(responseText);*/
		addToList();
	}
}
function kitNextItem() {
	parent.frameStockItemConsumptionList.frameStockItemConsumptionListHeader.kitNextItemValidate();
}
function kitNextItemValidate() {
	var store_code = parent.parent.frameStockItemConsumptionHeader.document.formStockItemConsumptionHeader.store_code.value;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/StockItemConsumptionValidate.jsp?validate=KIT_TEMPLATE&store_code=" + store_code, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
function addToList1() {
	var formObj = parent.frameStockItemConsumptionListHeader.document.formStockItemConsumptionListHeader;
	/*
	if (!formObj.item_desc.readOnly) {
		if(!validateCommonCodeSearch(formObj.item_code, formObj.item_desc)){
			alert(message);
			return;
		}
	}
*/
	//var arrayObject = new Array(formObj.item_code,formObj.item_qty);
	var fields = new Array();
	fields[0] = formObj.item_code;
	fields[1] = formObj.item_qty;
	var names = new Array(getLabel("Common.item.label", "Common"), getLabel("Common.Quantity.label", "Common"));
	var blankObject = checkSTFields(fields, names, parent.parent.parent.messageFrame);
	var store_code = parent.parent.frameStockItemConsumptionHeader.document.formStockItemConsumptionHeader.store_code.value;
	if (blankObject == true) {
		formObj.apply.disabled = true;
		if (parent.frameStockItemConsumptionListDetail.document.formStockItemConsumptionListDetail == null) {
			var formObj = document.formStockItemConsumptionListHeader;
			var _item_code = formObj.item_code.value;
			var item_qty = formObj.item_qty.value;
			parent.frameStockItemConsumptionListDetail.location.href = "../../eST/jsp/StockItemConsumptionListDetail.jsp?function=edit&store_code=" + store_code + "&item_code=" + _item_code + "&item_qty=" + item_qty + "&function_id=" + parent.parent.function_id + "&addToList=true&kit=kit";
			return;
		}

		//if (formObj.stock_item_yn.value=='Y') {
		var formObjDtl = parent.parent.frameStockItemConsumptionList.frameStockItemConsumptionListDetail.document.formStockItemConsumptionListDetail;
		var proceed = false;
		var messageFrame = parent.parent.messageFrame;
		var errorPage = "../../eCommon/jsp/error.jsp";
		var item_qty = formObj.item_qty.value;
		_total_checkboxes = formObjDtl.total_checkboxes.value;
		expired_batch = formObjDtl.expired_batch.value;
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
		//}
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//if (formObj.stock_item_yn.value == "Y") {
			//xmlDoc.loadXML(getEnhancedXMLString(formObjDtl));
			xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObjDtl), "text/xml");
		//} else {
			//xmlDoc.loadXML(getXMLString(null));
		//}
		/**
			* @Name - Priya 
			* @Date - 22/12/2009
			* @Inc# - IN017176
			* @Desc - To Display the character ® properly in Item desc without junck characters
			* added 'encodeURIComponent(formObj.item_desc.value,"UTF-8")' in the next line code
			*/
		//xmlHttp.open("POST", "../../eST/jsp/StockItemConsumptionValidate.jsp?index=" + formObj.index.value + "&doc_srl_no=" + formObj.doc_srl_no.value + "&item_code=" + formObj.item_code.value + "&item_desc=" + encodeURIComponent(formObj.item_desc.value,"UTF-8") + "&item_qty=" + formObj.item_qty.value + "&item_unit_cost=" + document.getElementById("id_store_item_unit_cost").innerText + "&item_cost_value=" + parent.frameStockItemConsumptionListHeader.document.getElementById("id_item_sal_value").innerText + "&expiry_yn=" + formObj.expiry_yn.value + "&uom_code=" + formObj.uom_code.value + "&stock_item_yn=" + formObj.stock_item_yn.value + "&remarks=" + escape(formObj.remarks.value) + "&uom_desc=" + document.getElementById("id_uom").innerText + "&stock_available=" + document.getElementById("id_stock_available").innerText + "&expired_batch=" + expired_batch + "&ex_param_days=" + formObjDtl.ex_param_days.value + "&mm_trn_qty=" + sum +"&batchsearch="+formObjDtl.batchsearch.value+ "&batch_records=" + formObjDtl.total_checkboxes.value+"&dec_allowed_yn="+formObj.dec_allowed_yn.value+"&kit_temp_code="+formObj.kit_temp_code.value+"&usage_type="+formObj.usage_type.value+ "&validate=ADD_TO_LIST", false);
		
		//Added by Rabbani #Inc no:39734(RUT-SCF-0268) on 08-MAY-2013
		if(formObj.remarks.value == "" || formObj.remarks.value == null){
			formObj.remarks_code_1.value = "";
		  }
		//Commented and Added by suresh.r on 14-04-2014 against #048584(SKR-SCF-0987)
		//xmlHttp.open("POST", "../../eST/jsp/StockItemConsumptionValidate.jsp?index=" + formObj.index.value + "&doc_srl_no=" + formObj.doc_srl_no.value + "&item_code=" + formObj.item_code.value + "&item_desc=" + encodeURIComponent(formObj.item_desc.value,"UTF-8") + "&item_qty=" + formObj.item_qty.value + "&item_unit_cost=" + document.getElementById("id_store_item_unit_cost").innerText + "&item_cost_value=" + parent.frameStockItemConsumptionListHeader.document.getElementById("id_item_sal_value").innerText + "&expiry_yn=" + formObj.expiry_yn.value + "&uom_code=" + formObj.uom_code.value + "&stock_item_yn=" + formObj.stock_item_yn.value + "&remarks=" + escape(formObj.remarks.value) + "&uom_desc=" + document.getElementById("id_uom").innerText + "&stock_available=" + document.getElementById("id_stock_available").innerText + "&expired_batch=" + expired_batch + "&ex_param_days=" + formObjDtl.ex_param_days.value + "&mm_trn_qty=" + sum +"&batchsearch="+formObjDtl.batchsearch.value+ "&batch_records=" + formObjDtl.total_checkboxes.value+"&dec_allowed_yn="+formObj.dec_allowed_yn.value+"&kit_temp_code="+formObj.kit_temp_code.value+"&usage_type="+formObj.usage_type.value+"&remarks_code="+formObj.remarks_code_1.value+ "&validate=ADD_TO_LIST", false);
		xmlHttp.open("POST", "../../eST/jsp/StockItemConsumptionValidate.jsp?index=" + formObj.index.value + "&doc_srl_no=" + formObj.doc_srl_no.value + "&item_code=" + formObj.item_code.value + "&item_desc=" + encodeURIComponent(formObj.item_desc.value,"UTF-8") + "&item_qty=" + formObj.item_qty.value + "&item_unit_cost=" + document.getElementById("id_store_item_unit_cost").innerText + "&item_cost_value=" + parent.frameStockItemConsumptionListHeader.document.getElementById("id_item_sal_value").innerText + "&expiry_yn=" + formObj.expiry_yn.value + "&uom_code=" + formObj.uom_code.value + "&stock_item_yn=" + formObj.stock_item_yn.value + "&remarks=" + escape(formObj.remarks.value) + "&uom_desc=" + encodeURIComponent(document.getElementById("id_uom").innerText,"UTF-8") + "&stock_available=" + document.getElementById("id_stock_available").innerText + "&expired_batch=" + expired_batch + "&ex_param_days=" + formObjDtl.ex_param_days.value + "&mm_trn_qty=" + sum +"&batchsearch="+formObjDtl.batchsearch.value+ "&batch_records=" + formObjDtl.total_checkboxes.value+"&dec_allowed_yn="+formObj.dec_allowed_yn.value+"&kit_temp_code="+formObj.kit_temp_code.value+"&usage_type="+formObj.usage_type.value+"&remarks_code="+formObj.remarks_code_1.value+ "&validate=ADD_TO_LIST", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		if (result) {
			parent.parent.frameStockItemConsumptionHeader.formStockItemConsumptionHeader.preview.disabled = false;
			parent.parent.frameStockItemConsumptionDetail.location.href = "../../eST/jsp/StockItemConsumptionDetail.jsp?function_id=" + parent.parent.function_id + "&index=" + formObj.index.value + "&kit12=kit&store_code=" + store_code + "&avail_qty=" + document.getElementById("id_stock_available").innerText;
			refreshDetail();
		} else {
			parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
		}
	}
}
function statusOfItem() {
	var store_code = parent.parent.frameStockItemConsumptionHeader.document.formStockItemConsumptionHeader.store_code.value;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/StockItemConsumptionValidate.jsp?validate=ERROR_MESSAGE&store_code=" + store_code, false);
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
		obj.focus();
		return false;
	} else {
		if ((parseFloat(obj.value) == 0) && zeroNotAllowed) {
			
			alert(getMessage("CANNOT_BE_ZERO", "Common"));
			document.formStockItemConsumptionListHeader.tot_item_qty.value="";
			obj.value = "";
			return false;
		}
	}
	return true;
}
async function searchRemarks(objCode, objDesc,called_from,row_no) {//Added called_from,row_no for TH-KW-CRF-0043
     var item_code ="";
	 if(called_from =="NEWSCREEN"){//Adding start for TH-KW-CRF-0043
		  var item_qty             = eval("document.formStockItemConsumptionListHeader.store_qty_"+row_no).value;
		  item_code        =eval("document.formStockItemConsumptionListHeader.item_code_"+row_no).value;
	   if(item_qty==""){
		   alert("Please enter quantity to proceed with remarks selection");
		     return;
	   }
	 }//Adding end for TH-KW-CRF-0043
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	//dataValueArray[0] = document.formStockItemConsumptionListHeader.lang_id.value;
	dataValueArray[0] = document.forms[0].lang_id.value; //Added by Rabbani #Inc no:39734(RUT-SCF-0268) on 24-MAY-2013
	dataTypeArray[0] = STRING;
	dataNameArray[1] = "module_id";
	dataValueArray[1] = "ST";
	dataTypeArray[1] = STRING;
	dataNameArray[2] = "trn_type";
	//dataValueArray[2] = document.formStockItemConsumptionListHeader.rem_trans_type.value;
	//dataValueArray[2] = document.forms[0].rem_trans_type.value;//Added by Rabbani #Inc no:39734(RUT-SCF-0268) on 24-MAY-2013
	dataValueArray[2] = "CON"; //Added by Rabbani #49759(ML-BRU-SCF-1377) on 18-06-2014
	dataTypeArray[2] = STRING;
//	argumentArray[0]		 =		"SELECT DISTINCT mm.trn_remarks_code  code,mm.remarks_desc  description FROM  mm_trn_remarks_lang_vw  mm, ST_TRN_TYPE_FOR_REMARKS st WHERE  st.eff_status = 'E'   AND  st.trn_remarks_code = mm.trn_remarks_code AND   UPPER(mm.language_id) LIKE  UPPER(?) AND UPPER(mm.module_id) LIKE  UPPER(?)   AND  UPPER(st.trn_type)  LIKE  UPPER(?)     AND  mm.trn_remarks_code LIKE   UPPER(?)     AND  UPPER(mm.remarks_desc) LIKE  UPPER(?)  ";
	//argumentArray[0] = document.formStockItemConsumptionListHeader.SQL_ST_TRN_REMARKS_LOOKUP_SELECT.value;
	argumentArray[0] = document.forms[0].SQL_ST_TRN_REMARKS_LOOKUP_SELECT.value;//Added by Rabbani #Inc no:39734(RUT-SCF-0268) on 24-MAY-2013
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
		if(called_from =="NEWSCREEN"){
			var remarks =eval("document.formStockItemConsumptionListHeader.remarks_"+row_no).value;
			 var xmlHttp = new XMLHttpRequest();
	         var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/StockItemConsumptionValidate.jsp?item_code="+item_code+"&remarks="+remarks+ "&validate=SaveRemarks", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
		}
	}
}
function calTotalQty() {
	var item_qty = document.formStockItemConsumptionListHeader.item_qty.value;
	document.formStockItemConsumptionListHeader.tot_item_qty.value="";
	if(item_qty!="" ){
	var store_code = document.formStockItemConsumptionListHeader.store_code.value;
	var item_code = document.formStockItemConsumptionListHeader.item_code.value;
	var dec_allowed_yn = document.formStockItemConsumptionListHeader.dec_allowed_yn.value;

	var formObj = document.formStockItemConsumptionListHeader;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/StockItemConsumptionValidate.jsp?validate=TOTAL_QTY" + "&store_code=" + store_code + "&item_code=" + item_code + "&item_qty=" + item_qty+"&dec_allowed_yn="+dec_allowed_yn, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	/*if( !result ) {
				if(message=="Multiple"){
				alert("Mutilpe uom");
				cancel_me();
				return;
					}
				}	*/

	}
}

function chkstatus(obj){
        var usage_type = "";
		if ((eval("document.formStockItemConsumptionDetail.checkbox" + obj).checked)){
			usage_type = "P";
		}else{
			usage_type = "O";
		}
		    var xmlHttp = new XMLHttpRequest();
	        var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/StockItemConsumptionValidate.jsp?validate=USAGE_TYPE_STATUS" + "&usage_type=" +usage_type +"&index_="+obj, false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
}

//Added by sakti against ML-BRU-SCF-0963[INC#42099]	
function Setitemdesc(obj){
	document.formStockItemConsumptionListHeader.item_desc.value = decodeURIComponent(obj.value,"UTF-8");
} 
//Added for GHL-CRF-0413 starts
function callItemQtyUpdate(){
	var Obj	=  parent.parent.frames[0].document.forms[0].defaultqty_value1;
	var bar_appl = parent.parent.frames[0].document.forms[0].barcode_applicable1;
	var barcode = document.forms[0].barcode;
	var tmp_conv= parent.frames[1].document.forms[0].tmp_conv.value;//Added by Shazana for INC065695 MMS-DM-CRF-0112
	if(bar_appl.value=='Y' && document.forms[0].item_code.value!=null){
	if(Obj.value==1 && parent.parent.frames[0].document.forms[0].editqty_appl1.value != 'Y' &&  document.forms[0].bar_or_item_code.value == 'B' ){
		if (parent.frames[1].document.forms[0] != undefined) {
			var index = parent.frames[1].document.forms[0].total_checkboxes.value ;	
				if(parent.frames[0].document.forms[0].noofbatchesforbarcode.value=="1"){
					if(parent.frames[0].document.forms[0].iss_uom_qty!=undefined){
						parent.frames[0].document.forms[0].iss_uom_qty.value = Obj.value;
					}
					if(parent.frames[0].document.forms[0].item_qty.value >Obj.value){
						if(parent.frames[0].document.forms[0].tot_item_qty!=undefined){
							parent.frames[0].document.forms[0].tot_item_qty.value = parent.frames[0].document.forms[0].item_qty.value;
							}else if(parent.frames[0].document.forms[0].ret_qty!=undefined){
								parent.frames[0].document.forms[0].ret_qty.value= parent.frames[0].document.forms[0].item_qty.value;
							}
						if (parseInt(index)==1){
							parent.frames[1].document.forms[0].item_qty_0.value = parent.frames[0].document.forms[0].item_qty.value;
						}else{
						}
					}
					else{
						parent.frames[0].document.forms[0].item_qty.value = Obj.value;
						if(parent.frames[0].document.forms[0].tot_item_qty!=undefined){
							parent.frames[0].document.forms[0].tot_item_qty.value = Obj.value;
							}else if(parent.frames[0].document.forms[0].ret_qty!=undefined){
								parent.frames[0].document.forms[0].ret_qty.value= Obj.value;
							}
						if (parseInt(index)==1){
							parent.frames[1].document.forms[0].item_qty_0.value = Obj.value;
							parent.frames[1].document.forms[0].item_qty_0.value=Obj.value*tmp_conv;//Added by Shazana for INC065695 MMS-DM-CRF-0112
						}else{
						}
					}
					var tot_item_qty = document.forms[0].tot_item_qty.value ;
					CheckQuantity();
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
				checkBatchQty(item_qty_new,avail_qty);
		}
		}else{
		}
	}
	}
}
function callBarCodeBatchSearchforBarcode(e,barcode,trntype,fromStore,toStore,formObj,bean_id,bean_name,ListHeader,ListDetail,Detail){
	if(e.keyCode==13 || e.keyCode== 9  || e.keyCode== 0){
	parent.frames[0].document.forms[0].barcode.disabled = true;
	parent.parent.frameStockItemConsumptionHeader.document.formStockItemConsumptionHeader.store_code_disabled.value = "disabled";
	var bar_code	= barcode.value;
	var trn_type	= trntype.value;
	var fromStore   = fromStore.value;
	var toStore		= toStore.value;
	var formObj		= formObj.name; 
	var barcode_appl = parent.parent.frames[0].document.forms[0].barcode_applicable1.value;
	var site = parent.frames[0].document.forms[0].site.value;
	var resultArray	;	
	var new_con_screen_yn ="";//parent.frames[0].document.forms[0].new_con_screen_yn.value;//Added for TH-KW-CRF-0042
	
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
	xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?trn_type=" + trn_type + "&bar_code=" + bar_code + "&formObj=" + formObj  +"&fromStore=" + fromStore + "&toStore=" + toStore+"&new_con_screen_yn="+new_con_screen_yn + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE" + "&jsp_page=" + ListDetail +"&frombarcode="+frombarcode+ "&site=" + site + "&validate=BARCODE", false);
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
			if( parent.frames[1].document.forms[0] !=undefined)
			 parent.frames[1].document.forms[0].batchsearch.value = "";
						if(BarcodeWithMultipleBatches=="Y")
							callBatchSearchforBarcodeMultiBatch1(fromStore,bar_code,ListDetail,BarcodeWithMultipleBatches,qtyList);
						else
							editViewBatchForBarCode1(ListDetail,fromStore,bar_code,BarcodeWithMultipleBatches,qtyList,trntype.value);
						if (parent.parent.frames[0].document.forms[0].defaultqty_appl1.value == 'Y'  && parent.parent.frames[0].document.forms[0].editqty_appl1.value=='N') {
							CheckQuantity();
							calTotalQty();
							 parent.frames[0].document.forms[0].barcode.disabled = false;
							 parent.frames[0].document.forms[0].barcode.value = "";
							 parent.frames[0].document.forms[0].barcode.focus();
						}else if(parent.parent.frames[0].document.forms[0].defaultqty_appl1.value == 'N'){
							if(document.forms[0].iss_uom_qty!=undefined)
								document.forms[0].iss_uom_qty.focus();
							else
								document.forms[0].item_qty.focus();				
						}
			}	
		else{
	 		alert(getMessage("PH_INVALID_BAR_CODE", "PH"));
			refreshDetailsforBarCode('999',ListHeader,Detail,'','','','','');
	}
		}
	else
		{
		if(getMessage(message, "ST") != ""){
			alert(getMessage(message, "ST"));
			refreshDetailsforBarCode('999',ListHeader,Detail,'','','','','');
		}else
		{
			
			refreshDetailsforBarCode('999',ListHeader,Detail,'','','','','');
	} 
		}
	}
	else
	 {	
	    parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?";	
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
}
function addToListforBarcode() {
	var formHeader	   = parent.parent.frames[0].document.forms[0];
	var formDetail     = parent.parent.frames[1].document.forms[0];
	var formListHeader = parent.frames[0].document.forms[0];
	var formListDetail = parent.frames[1].document.forms[0];
	var trn_type;
	if(formListHeader.trn_type!=undefined)
	trn_type = formListHeader.trn_type.value;
	else
	trn_type = formListHeader.trn_type1.value;
	if(formListDetail !=  null && trn_type == "CON"){
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/StockItemConsumptionValidate.jsp?doc_srl_no_forbean=" + parent.frames[1].document.forms[0].doc_srl_no_forbean.value + "&item_code="+formListHeader.item_code.value+"&barcode="+formListHeader.barcode.value+ "&validate=SET_IN_BEAN", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
	}
	var checkBoxObj = null;
	var forDeletion = "";
	var noDetailExists = true;
	for (i = 0; i < parseInt(formDetail.total_checkboxes.value); i++) {
		checkBoxObj = eval("formDetail.checkbox" + i);
		if (checkBoxObj.checked) {
			forDeletion += ("Y,");
		} else {
			forDeletion += ("N,");
			noDetailExists = false;
		}
	}
	forDeletion = forDeletion.substring(0, forDeletion.length - 1);
	formHeader.records_to_delete.value = forDeletion;
    var arrayObject = new Array(formListHeader.item_code, formListHeader.item_qty);
	var names = new Array(getLabel("Common.item.label", "Common"), getLabel("Common.Quantity.label", "Common"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.parent.messageFrame);
	if (blankObject == true) {
			if(formHeader.store_code != undefined)
			var store_code = formHeader.store_code.value;
			else
			var store_code = formHeader.from_store_code.value;
			formListHeader.apply.disabled = true;
			if (parent.frames[1].document.forms[0] == null && formListHeader.stock_item_yn.value == "Y") {
				var formObj = document.formStockItemConsumptionListHeader;
				var _item_code = formObj.item_code.value;
				var item_qty = formObj.tot_item_qty.value;
				parent.frameStockItemConsumptionListDetail.location.href = "../../eST/jsp/StockItemConsumptionListDetail.jsp?function=edit&store_code=" + store_code + "&item_code=" + _item_code + "&item_qty=" + item_qty + "&function_id=" + parent.parent.function_id + "&addToList=true";
				return;
			} 
		if (formListHeader.stock_item_yn.value == "Y") {
			var proceed = false;
			var messageFrame = parent.parent.messageFrame;
			var errorPage = "../../eCommon/jsp/error.jsp";
			var item_qty;			
			if(formListHeader.tot_item_qty!=undefined)
			item_qty = formListHeader.tot_item_qty.value;
			else if(formListHeader.ret_qty!=undefined)
			item_qty = formListHeader.ret_qty.value;
			else
			item_qty = formListHeader.item_qty.value;
			_total_checkboxes = formListDetail.total_checkboxes.value;
			var no_of_decimals = '0';
			if(formListDetail.dec_allowed_yn != undefined)
			no_of_decimals=formListDetail.no_of_decimals.value;
			else
			no_of_decimals=formListDetail.no_deci.value;
			var sum = 0;
			for (i = 0; i < _total_checkboxes; i++) {
				var qty = eval("formListDetail.item_qty_" + i).value;
				if (qty == "") {
					qty = 0;
				}
				if (!isNaN(qty)) {
					sum += parseFloat(qty);
				}
			}
		var dec_allowed_yn;
		if(formListDetail.dec_allowed_yn != undefined){
			dec_allowed_yn  = formListDetail.dec_allowed_yn.value;
			if(formListDetail.dec_allowed_yn.value=='Y')
      {
			  sum=sum.toFixed(no_of_decimals);
      }
		}else{
			dec_allowed_yn  = formListDetail.allow_deci_yn.value;
			if(formListDetail.allow_deci_yn.value=='Y')
      {
			  sum=sum.toFixed(no_of_decimals);
      } 
		}		
			if (parseInt(sum) != parseInt(item_qty)) {
				alert(getMessage("QUANTIY_MUST_BE_EQUAL", "ST"));
				formListHeader.apply.disabled = false;
				return;
			}
		}
		/*if (formListDetail.batchsearch.value == "newbatch") {
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			xmlDoc.loadXML(getEnhancedXMLString(formListHeader));
			xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?validate=setnewbatch&index=" + formListHeader.index.value + "&mode=" + formListHeader.mode.value + "&bean_id="+bean_id+"&bean_name="+bean_name+ "&doc_srl_no=" + formListHeader.doc_srl_no.value + "&item_code=" + formListHeader.item_code.value +"&BARCODE_YN=TRUE ", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			if (!result) {
				parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" + (message);
				return;
			}
		}*/
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		if (formListHeader.stock_item_yn.value == "Y") {
			//xmlDoc.loadXML(getEnhancedXMLString(formListDetail));
			xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formListDetail), "text/xml");
		} else {
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		}
		parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" ;
		var kit_temp_code = formListHeader.kit_temp_code.value;//for kit_temp
		var usage_type = formListHeader.usage_type.value;
		var kit = formListHeader.kit.value;
		var site = parent.frames[0].document.forms[0].site.value;
		xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?index=" + formListHeader.index.value +"&site="+site+  "&expired_batch=" + formListDetail.expired_batch.value+ "&doc_srl_no=" + formListHeader.doc_srl_no.value + "&item_code=" + formListHeader.item_code.value + "&item_desc=" + encodeURIComponent(formListHeader.item_desc.value) + "&item_qty=" + formListHeader.item_qty.value + "&item_unit_cost=" + document.getElementById("id_store_item_unit_cost").innerText + "&item_cost_value=" + parent.frames[0].document.getElementById("id_item_sal_value").innerText+ "&expiry_yn=" + formListHeader.expiry_yn.value + "&uom_code=" + formListHeader.uom_code.value + "&stock_item_yn=" + formListHeader.stock_item_yn.value + "&remarks=" + encodeURIComponent(formListHeader.remarks.value) + "&uom_desc=" + encodeURIComponent(document.getElementById("id_uom").innerText,"UTF-8") + "&stock_available=" + document.getElementById("id_stock_available").innerText + "&batch_records=" + formListDetail.total_checkboxes.value +"&remarks_code="+formListHeader.remarks_code_1.value+"&no_of_decimals="+formListHeader.no_of_decimals.value+"&records_to_delete="+formHeader.records_to_delete.value+"&trn_type="+trn_type+"&bean_id=stockItemConsumptionBean"+"&bean_name=eST.StockItemConsumptionBean"+"&BARCODE_YN=TRUE"+"&kit_temp_code="+kit_temp_code+"&usage_type="+usage_type+"&validate=ADD_TO_LIST", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if (result) {
			if (formHeader.preview!=undefined)
			formHeader.preview.disabled = false;
			parent.parent.frameStockItemConsumptionDetail.location.href = "../../eST/jsp/StockItemConsumptionDetail.jsp?function_id=" + parent.parent.function_id + "&index=" + formListHeader.index.value + "&kit12=kit&store_code=" + store_code + "&avail_qty=" + document.getElementById("id_stock_available").innerText;
			var arr = "";
			for (i = 0; i < parseInt(formDetail.total_checkboxes.value); i++) {
				if ((eval("formDetail.checkbox" + i).checked)) {
					arr = arr + "," + "CHECKED";
				} else {
					arr = arr + "," + "s";
				}
			}				
			refreshDetail();
		} else {
			formListHeader.apply.disabled = false;
			parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" + (message);
			parent.frames[1].location.href = "../../eCommon/html/blank.html";
		}
	} else {
	}
}
function GoBarcode(){
	if(parent.frames[0].document.forms[0] != undefined){
		if(parent.frames[0].document.forms[0].barcode != undefined && parent.frames[0].document.forms[0].barcode.value=="" && parent.frames[0].document.forms[0].barcode.disabled != true ){
			parent.frames[0].document.forms[0].barcode.select();
		}
	}
}
//Added for GHL-CRF-0413 ends
//Added by Shazana For BARCODE DECODING MMS-DM-CRF-0112
function setItemDescription(formname,item_desc){
	
	document.formStockItemConsumptionListHeader.item_desc.value=decodeURIComponent(item_desc,"UTF-8");
	
} 

function defaultEncounter()
{//Added for TH-KW-CRF-0042
	document.formStockItemConsumptionHeader.encounter_id.disabled =false;
	document.getElementById("id_encounter_id_gif").style.visibility = "visible";
	if(document.formStockItemConsumptionHeader.all.encounter_id.length > 1)
	{
		document.formStockItemConsumptionHeader.all.encounter_id.selectedIndex =1;
		
	}
}

function checkBarcodeScan(e,barcode,trn_type,fromStore,toStore,formObj,bean_id,bean_name){//Adding start for TH-KW-CRF-0043
	var to_store ="";
	var index =-1;
	var call ="SCAN";
	var item_qty ="1";
	var row_no =0;
	var formObj              = document.formStockItemConsumptionListHeader;	
	if(e.keyCode==9 || e.keyCode== 13  || e.keyCode== 0){
		var new_con_screen_yn =document.formStockItemConsumptionListHeader.new_con_screen_yn.value;
	    var site =document.formStockItemConsumptionListHeader.site.value;
		//var xmlHttp  = new ActiveXObject("Microsoft.XMLHTTP");
	    //var xmlDoc   = new ActiveXObject("Microsoft.XMLDom");
	    //xmlDoc.loadXML(getXMLString(null));
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc = "";
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	    xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?trn_type=" + trn_type.value + "&bar_code=" + barcode.value +"&fromStore=" + fromStore.value + "&toStore=" + to_store+"&new_con_screen_yn="+new_con_screen_yn + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE" + "&site=" + site + "&validate=BARCODE", false);
	    xmlHttp.send(xmlDoc);
	    responseText = xmlHttp.responseText;
	    eval(responseText);
if(result){
	          
	         var resultArray	;
			 resultArray = message.split(";");
			 var  item_code   = 	resultArray[0];
			 var  batch_id    = 	resultArray[1];
			 var  expiry_date = 	resultArray[2];
			 var  BarcodeWithMultipleBatchesg = resultArray[3];
			 var temp_conv    =""; 
			 var batch_qty    ="";

			 var total_records    = formObj.total_records.value;
		   for( var j=0;j<total_records;j++){
                 temp_item_code            = eval("formObj.item_code_"+j).value;
               if(item_code==temp_item_code){
				   moveScroll(j,temp_item_code);
				   row_no =j;
				   temp_conv            = eval("formObj.tmp_conv_"+j).value;
				   eval(document.getElementById("store_qty_"+j)).innerText = item_qty;
	               eval(document.getElementById("select_"+j)).checked =true;
				   batch_qty  =  temp_conv * item_qty;
			   }
		   }
			 
			 var xmlHttp = new XMLHttpRequest();
	         var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/StockItemConsumptionValidate.jsp?store_code="+fromStore.value+"&item_code="+item_code+"&index="+index+"&barcode="+barcode.value+"&call="+call+"&item_qty="+item_qty+"&temp_conv="+temp_conv+"&batch_qty="+batch_qty+"&row_no="+row_no+ "&validate=setBeanDetails", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		}else{
			alert(getMessage("ST_INVALID_BAR_CODE", "ST"));
			return false;
		}
	}
}
function setBeanDetails(i,qty,store_code){
    var formObj              = document.formStockItemConsumptionListHeader;	
	if(qty.value !="" && qty.value !="0" ){
	var item_code            = eval("formObj.item_code_"+i).value;
	var item_qty             = qty.value;
	var trn_type  = formObj.trn_type.value;
	var doc_srl_no_forbean  =formObj.doc_srl_no_forbean.value;
	var barcode =formObj.barcode.value;
	var temp_conv = eval("formObj.tmp_conv_"+i).value;
	var batch_qty =qty.value*temp_conv;
    eval("formObj.hdr_qty_"+i).value =qty.value;
	
	
	 eval(document.getElementById("select_"+i)).checked =true;


	    var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		    //xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		    xmlHttp.open("POST", "../../eST/jsp/StockItemConsumptionValidate.jsp?store_code="+store_code+"&item_code="+item_code+"&batch_qty="+batch_qty+"&item_qty="+qty.value+"&barcode="+barcode+"&doc_srl_no_forbean="+doc_srl_no_forbean+"&temp_conv="+temp_conv+"&row_no="+i+"&validate=setBeanDetails", false);
		    xmlHttp.send(xmlDoc);
		    responseText = xmlHttp.responseText;
		    eval(responseText);
	}else{
		actionRequired(i,"N","REMOVE");
	}

}
function newAddToList(row_no,item_code,store_code,item_qty,doc_srl_no_forbean,doc_srl_no,temp_index,total_checkboxes,call,available_qty){
	//alert("item_qty=="+item_qty)
var formObj              = document.formStockItemConsumptionListHeader; 
var total_available_qty  = eval("formObj.avail_qty_"+row_no).value;
 
		if (parseFloat(item_qty) > parseFloat(available_qty)) {
			if(parseFloat(item_qty)>parseFloat(total_available_qty)){
				alert(getMessage("QTY_NOT_GRT_AVLQTY", "ST"));
				eval(document.getElementById("select_"+row_no)).checked =false;
				eval("formObj.store_qty_"+row_no).focus();
			     return false;
			}else if (parseFloat(item_qty)>parseFloat(available_qty) && call!="batchsearch")
			{
				alert("Batch avilable quantity is less than selected quantity. Please select quantity from batch search.");
		               callBatchs(row_no);	
					   return false;
			}
	   }
    
	var stock_item_yn        = eval("formObj.stock_item_yn_"+row_no).value;
	var item_unit_cost       = eval("formObj.unit_cost_"+row_no).value;
	var temp_conv            = eval("formObj.tmp_conv_"+row_no).value;
    var item_desc            = eval("formObj.item_desc_"+row_no).value;
	var expiry_yn            = eval("formObj.expiry_yn_"+row_no).value;
	var uom_code             = eval("formObj.uom_code_"+row_no).value;
	var uom_desc             = eval("formObj.uom_desc_"+row_no).value;
	var item_sal_value       = item_qty*item_unit_cost;
	var site                 = formObj.site.value;
	var no_of_decimals       = formObj.no_of_decimals.value;
	var trn_type             = formObj.trn_type.value;
	var ex_param_days        = formObj.ex_param_days.value;
	var expired_batch        = 0;
	var records_to_delete    = "0";
	var remarks              = "";
	var remarks_code         = "";
	var batchsearch          = "";	
	var kit_temp_code        = "";
	var usage_type           = "";	
	var dec_allowed_yn       = "N";
	var new_con_screen_yn    = "Y";
	var called_from          ="";

//alert("item_qty=="+item_qty+"item_unit_cost==="+item_unit_cost+"item_sal_value=="+item_sal_value);
	eval("formObj.item_value_"+row_no).value = item_sal_value;
	if(call =="SCAN")
    eval("formObj.store_qty_"+row_no).value = item_qty;

 actionRequired(row_no,"Y");
formObj.barcode.value ="";//added for 43
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?index="+temp_index+"&new_con_screen_yn="+new_con_screen_yn+"&site="+site+"&expired_batch="+expired_batch+"&doc_srl_no="+doc_srl_no+"&item_code="+item_code+"&store_code="+store_code+"&item_desc="+encodeURIComponent(item_desc)+"&item_qty="+item_qty+"&item_unit_cost="+item_unit_cost+"&called_from="+called_from+"&item_cost_value="+ item_sal_value+"&expiry_yn="+expiry_yn+"&uom_code="+uom_code+"&stock_item_yn="+stock_item_yn+"&remarks="+remarks+"&uom_desc="+encodeURIComponent(uom_desc,"UTF-8")+ "&stock_available="+total_available_qty+"&batch_records="+total_checkboxes+"&remarks_code="+remarks_code+"&no_of_decimals="+no_of_decimals+"&records_to_delete="+records_to_delete+"&trn_type="+trn_type+"&bean_id=stockItemConsumptionBean"+"&bean_name=eST.StockItemConsumptionBean"+"&BARCODE_YN=TRUE"+"&kit_temp_code="+kit_temp_code+"&usage_type="+usage_type+"&validate=ADD_TO_LIST", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
}


function loadDetailPage(){
	var formObj  =document.formStockItemConsumptionHeader;
	 var new_con_screen_yn =formObj.new_con_screen_yn.value;
	 if(new_con_screen_yn=="Y")
      parent.frameStockItemConsumptionDetail.location.href ="../../eST/jsp/StockItemConsumptionResult.jsp?";
}

function alertMultipleBatches(){
	alert("Multiple batches available please click on batch search and select Quantity ");
		return false ;
}
function checkNewQuantity(avial_qty,item_qty){
       if (parseFloat(item_qty) > parseFloat(avial_qty)) {
			alert(getMessage("QTY_NOT_GRT_AVLQTY", "ST"));
			return false;
	   }
}
function callBatchs (i){
	 var called_from ="NEWSCREEN";
     var formObj              = document.formStockItemConsumptionListHeader;
	 var item_code            = eval("formObj.item_code_"+i).value;
	 var item_qty             = eval("formObj.store_qty_"+i).value;
	   if(item_qty==""){
		   alert("Please enter Quantity to proceed with batch selection");
		     return;
	   }
	 var store_code           = formObj.store_code.value;
	 var temp_conv            =eval("formObj.tmp_conv_"+i).value;
	 var batch_qty            = item_qty * temp_conv;
	 callBatchSearch(called_from,item_code,item_qty,store_code,i,item_qty,temp_conv);
}
function setBeanRecords(doc_srl_no_forbean,call){
	var new_screen_yn ="Y";
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/StockItemConsumptionValidate.jsp?doc_srl_no_forbean="+doc_srl_no_forbean+"&call="+call+"&new_screen_yn="+new_screen_yn+ "&validate=SET_IN_BEAN", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
	
}
function actionRequired(row_no,checked_yn,called_from){
	 var formObj              = document.formStockItemConsumptionListHeader;
	 var store_qty            = eval("formObj.store_qty_"+row_no).value;
	 var item_code            = eval("formObj.item_code_"+row_no).value;
	  if(store_qty=="" && called_from!="REMOVE")
		     return;
	  else{
		  if(checked_yn=="N"){
		    eval("formObj.store_qty_"+row_no).value ="";
		    eval("formObj.item_value_"+row_no).value ="";
			eval("formObj.all.select_"+row_no).checked =false;
		  }

    var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/StockItemConsumptionValidate.jsp?item_code="+item_code+"&checked_yn="+checked_yn+"&row_no="+row_no+ "&validate=DeleteRecords", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);

	  }
}//Adding end for TH-KW-CRF-0043

function resultScrollFrame(){
	var formObj              = document.formStockItemConsumptionListHeader;
	var y = formObj.body.scrollTop;
	if(y == 0){
		formObj.all.divColTitle.style.position = 'static';
		formObj.all.dataTable.style.position = 'static';
		formObj.all.divColTitle.style.posTop  = 0;		
	}else{		
		formObj.all.divColTitle.style.position = 'relative';
		formObj.all.dataTable.style.position = 'relative';
		formObj.all.divColTitle.style.posTop  = y;
	}
}

function moveScroll(position,id){
	var temp_id = document.getElementById("tr_"+position);
	document.getElementById('divDataTitle').scrollTop = (temp_id.offsetTop)-40;

}
