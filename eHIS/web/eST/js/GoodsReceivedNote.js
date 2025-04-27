/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		       Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
09/05/2017		IN062881		B.Badmavathi								     PO Mandatory in GRN 
27/11/2019      IN:071539               B Haribabu         28/11/2019         Manickam                NMC-JD-CRF-0029
26/05/2021      TFS-19175              Prabha              27/05/2021         Manickam                NMC-JD-CRF-0100
9/2/2022		TFS28606				Shazana															MO-CRF-20178 
23/04/2022		23925				Ramesh Goli			23/04/2022			RAMESH G    			MO-CRF-20171
--------------------------------------------------------------------------------------------------------------------------------------------
*/
var prevObj = null; 
var prevColor = null; 
var _stock_item_yn = "";
var proceed = true;
var exp_rec_count = "";
var batch_count = "";
var temp_4 = "";
var external_po_yn = "N";
function create() {
	f_query_add_mod.location.href = "../../eST/jsp/GoodsReceivedNoteFrame.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id + "&item_class=" + null;
}
function query() {
	f_query_add_mod.location.href = "../../eST/jsp/GoodsReceivedNoteQueryFrame.jsp?mode=" + MODE_MODIFY + "&function_id=" + function_id; 
	//f_query_add_mod.location.href="../../eST/jsp/GoodsReceivedNoteFrame.jsp?mode="+MODE_MODIFY+"&function_id="+function_id+"&doc_type_code=C1GRN&doc_no=107"; 
}
function reset() {
       
	if(f_query_add_mod.frameGoodsReceivedNoteHeader==undefined){
		if(external_po_yn=="Y"){
			parent.frames[2].location.reload();
		}else{
			messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		}
		return;
	}
	f_query_add_mod.location.reload();
	
	//Added by Rabbani #inc no:30127 on 09/01/12
	var flag_grn = f_query_add_mod.frameGoodsReceivedNoteHeader.document.formGoodsReceivedNoteHeader.grn_yn.value;
	 
	if(external_po_yn=="Y"){
	       if(flag_grn == "true"){
		   parent.frames[2].frames[0].location.href = "../../eCommon/jsp/commonToolbar.jsp?menu_id=MM_MENU&module_id=MM&function_id=MM_GRN&function_name="+getLabel("eST.GoodsReceivedNote.label", "ST")+"&function_type=F&access=YYYYN";
		   }else{
			parent.frames[2].frames[0].location.href = "../../eCommon/jsp/commonToolbar.jsp?menu_id=MM_MENU&module_id=MM&function_id=MM_GRN&function_name="+getLabel("eST.GoodsReceivedNote.label", "ST")+"&function_type=F&access=NYYYY";
		}
		}
//menu_id=MM_MENU&module_id=MM&function_id=MM_GRN&function_name=Goods%20Received%20Note&function_type=F&access=YYYYN
//f_query_add_mod.location.reload();
/*	alert("here");
	//f_query_add_mod.location.reload();
		if(external_po_yn=="Y"){
			parent.frames[2].frames[0].location.href = "../../eCommon/jsp/commonToolbar.jsp?access=NYYYY";
		}else{
			f_query_add_mod.location.reload();
		}
/*	if(f_query_add_mod.frameGoodsReceivedNoteHeader!=undefined){
		f_query_add_mod.frameGoodsReceivedNoteHeader.document.formGoodsReceivedNoteHeader.param1.value = null;
		f_query_add_mod.frameGoodsReceivedNoteHeader.document.formGoodsReceivedNoteHeader.item_class_code.value = null;
	}*/
}
function onSuccess() {
	f_query_add_mod.location.href = "../../eCommon/html/blank.html";
}
function showCalendarLocal(id) {
	var flag = showCalendar(id);
	document.getElementById(id).focus();
	return flag;
}
function getBatchIDFromExpiryDate(expiry_date_object, i) {
	var sys_date = document.forms[0].sys_date;
	sys_date	= sys_date.value;
	var batch_id_applicable_yn = document.forms[0].batch_id_applicable_yn;
	var formObj = document.formGoodsReceivedNoteListDetail;
	var locale = formObj.language_id.value; 
	
	if(locale != "en") {
		sys_date = convertDate(sys_date, "DMY", locale, "en");
	expiry_date_object = convertDate(expiry_date_object.value, "DMY", locale, "en");
	
	}
	else{
	sys_date = sys_date;
	expiry_date_object = expiry_date_object.value;
	}
	
	if (CheckDate(expiry_date_object)) {
		if (checkDateWithSysDate(sys_date, expiry_date_object)) {
			if ((CheckDate(expiry_date_object)) && (batch_id_applicable_yn.value == "E") && (expiry_date_object.value != "")) {
				var expiry_date = expiry_date_object;
				if(locale != "en") {
				expiry_date = convertDate(expiry_date, "DMY", "en", locale);
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
				document.getElementById("batch_id_" + i).value = result;
			}
			// begin
			 //Added by Rabbani #Inc no:40591 on 07-JUN-2013
			if(parent.frameGoodsReceivedNoteListDetail.document.forms[0].elements["expiry_date_or_receipt_date_" + i].value != parent.frameGoodsReceivedNoteListDetail.document.forms[0].elements["shelf_life_exp_date_" + i].value){ 
			getShelfLifeExpiryDate(expiry_date_object,i);
			}
			// end
		} else {
			alert(getMessage("NOT_LESS_THAN_SYSDATE", "ST"));
		//	for (var i = 0; i < 10; i++) { 
			parent.frameGoodsReceivedNoteListDetail.document.forms[0].elements["expiry_date_or_receipt_date_" + i].select();
			parent.frameGoodsReceivedNoteListDetail.document.forms[0].elements["expiry_date_or_receipt_date_" + i].focus();
			parent.frameGoodsReceivedNoteListDetail.document.forms[0].elements["expiry_date_or_receipt_date_" + i].value = "";
			//expiry_date_object.select();
			//expiry_date_object.focus();
			return false; 
		//	}  
		}
	}
	else {
		//	for (var i = 0; i < 10; i++) {
			parent.frameGoodsReceivedNoteListDetail.document.forms[0].elements["expiry_date_or_receipt_date_" + i].select();
			parent.frameGoodsReceivedNoteListDetail.document.forms[0].elements["expiry_date_or_receipt_date_" + i].focus();
			parent.frameGoodsReceivedNoteListDetail.document.forms[0].elements["expiry_date_or_receipt_date_" + i].value = "";
			//expiry_date_object.select();
			//expiry_date_object.focus();
			return false;
		//	}
	}
}
async function deleterecord() {
	if(f_query_add_mod.frameGoodsReceivedNoteHeader==undefined){
		if(external_po_yn=="Y"){
			parent.frames[2].location.reload();
		}else{
			messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		}
		return;
	}
	var errorPage = "../../eCommon/jsp/error.jsp";
	var formObj = f_query_add_mod.frameGoodsReceivedNoteHeader.document.formGoodsReceivedNoteHeader;
	var prevMode = formObj.mode.value;
	if (prevMode == MODE_INSERT) {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("OPER_CANCELLED", "ST");
		return;
	}
	formObj.mode.value = MODE_DELETE;

	if(formObj.grn_delete_yn.value=="N"){
	
	messageFrame.location.href = errorPage + "?err_num=" +getMessage("NO_DELETE_ACCESS_FOR_USER", "ST");
	formObj.mode.value = MODE_MODIFY;
	return false;
	}
 
 	if (await confirmDelete() != YES) {
 
		//alert(prevMode);YY
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("OPER_CANCELLED", "ST"); //+ "<BR>" + flag;
		formObj.mode.value = MODE_MODIFY;
		return;
	} 
	var responseText = formApply(formObj, ST_CONTROLLER);
//	alert(responseText);
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
	xmlHttp.open("POST", "../../eST/jsp/GoodsReceivedNoteValidate.jsp?patient_id=" + _patient_id + "&validate=PATIENT_NAME", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
//	alert(responseText);
	eval(responseText);
	if (!result) {
		alert(getMessage(flag, "ST"));
		formObj.patient_id.focus();
	}
}
function setPatientName(_patient_name) {
	document.formGoodsReceivedNoteHeader.patient_name.innerText = _patient_name;
}
 function callItemSearchScreen() {
	//alert("a3");
	var index = "";
	var search_string = "";
	parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	if (!parent.frameGoodsReceivedNoteListHeader.formGoodsReceivedNoteListHeader.item_desc.readOnly) {
		search_string = parent.frameGoodsReceivedNoteListHeader.formGoodsReceivedNoteListHeader.item_desc.value;
	}
	var store_code = parent.parent.frameGoodsReceivedNoteHeader.formGoodsReceivedNoteHeader.store_code.value;//parent
	var category = "A";
	var sole_source = "A";
	var ps_item = "A";
	var mfg_item = "A";
	var expiry = "A";
	var consignment = "A";
	var item_class = parent.parent.frameGoodsReceivedNoteHeader.formGoodsReceivedNoteHeader.item_class_code.value;//parent
	var item_class_check = parent.parent.frameGoodsReceivedNoteHeader.formGoodsReceivedNoteHeader.item_class_check.value;//parent

	var supp_code = parent.parent.frameGoodsReceivedNoteHeader.formGoodsReceivedNoteHeader.supp_code.value;//parent
	if(supp_code==""){
		alert("APP-000001 Supplier Cannot be blank");
		return;
	}


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
		//var retVal = callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment);
		
		var retVal = await callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment);
		var ret1=unescape(retVal);
	//	alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	
		if (retVal != null || retVal != undefined ) {
		
	
		parent.parent.frameGoodsReceivedNoteHeader.document.formGoodsReceivedNoteHeader.store_code_disabled.value = "disabled";
		document.formGoodsReceivedNoteListHeader.item_code.value = arr[0];
		document.formGoodsReceivedNoteListHeader.item_desc.value = arr[1];
		/** @Name - Priya
			* @Date - 10/02/2010
			* @Inc# - 19092
			* @Desc - 'Allow Decimal Y/N' value of the selected item is assigned to the hidden field 'dec_allowed_yn'
			*/
		document.formGoodsReceivedNoteListHeader.dec_allowed_yn.value = arr[27];
		document.formGoodsReceivedNoteListHeader.item_desc.readOnly = true;
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
		document.getElementById('pur_uom_conv').value = "1";
		document.getElementById('pur_uom_code').value = arr[13];
		if (arr[13] == "") {
		
			alert(getMessage("PUR_SALE_UOM_UNDEFINED", "ST"));
			parent.frameGoodsReceivedNoteListHeader.location.reload();
			return;
			//refreshDetails(index);
		}
		var trade_id_applicable_yn = arr[17];
		var batch_id_applicable_yn = arr[18];
		
		var formObj = document.formGoodsReceivedNoteListHeader;

		var xmlHttp = new XMLHttpRequest();
		//var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		  var xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/GoodsReceivedNoteValidate.jsp?item_code=" + formObj.item_code.value + "&store_code=" + store_code + "&validate=GET_STATUS", false);
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
			var nn = formObj.index.value;
			refreshDetails();
			return;
		}
		var formObj = document.formGoodsReceivedNoteListHeader;
		var xmlHttp = new XMLHttpRequest();
		//var xmlDoc="";
		var xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/GoodsReceivedNoteValidate.jsp?item_code=" + formObj.item_code.value + "&validate=DISP_PUR_COST&store_code=" + store_code, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
	
		if (!responseText) {
		
			parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "ST");
			var nn = formObj.index.value; 
			refreshDetails(nn);
			return;
		}
		var formObj = document.formGoodsReceivedNoteListHeader;
		var xmlHttp = new XMLHttpRequest();
		//var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		var xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/GoodsReceivedNoteValidate.jsp?item_code=" + formObj.item_code.value + "&store_code=" + store_code + "&uom_code=" + document.formGoodsReceivedNoteListHeader.uom_code.value + "&validate=SET_PUR_UOM_LIST", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		//alert(responseText);
		eval(responseText);
	
		if (!responseText) {
	
			parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "ST");
			var nn = formObj.index.value;
			refreshDetails(nn);
			return;
		} 
		//Added by Rabbani #inc no:30127 on 09/01/12 Starts
	   var  flag_grn = parent.parent.frameGoodsReceivedNoteHeader.document.formGoodsReceivedNoteHeader.grn_yn.value; 
	   var external_po_yn_1 = parent.parent.frameGoodsReceivedNoteHeader.document.formGoodsReceivedNoteHeader.external_po_yn.value;
	     if(external_po_yn_1 =="Y" && flag_grn == "true" ){		 
	  var formObj = document.formGoodsReceivedNoteListHeader;
		var xmlHttp = new XMLHttpRequest();
		//var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		var xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/GoodsReceivedNoteValidate.jsp?item_code=" + formObj.item_code.value + "&validate=CONSIGNMENT_ITEM", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		
		if (!responseText) {
		
			alert(getMessage("CONSIGNMENT_ITEM", "ST"));
			var nn = formObj.index.value;
			refreshDetails();
			return;
		}
     }  
	 //ends
		checkUOMConvFactor();
		setDecimalParameters(arr[27],arr[28],formObj);  
		var grn_newfields_applicable= document.formGoodsReceivedNoteListHeader.grn_newfields_applicable.value;//added for MO-CRF-20165 start 
		if(grn_newfields_applicable == "true"){ 
			document.formGoodsReceivedNoteListHeader.manufacturer_id.disabled=false;
			checkManufacturerId();
		}//end 
		parent.frameGoodsReceivedNoteListDetail.location.href = "../../eST/jsp/GoodsReceivedNoteListDetail.jsp?item_code=" + arr[0] + "&index=" + formObj.index.value + "&tmp_conv=" + formObj.tmp_conv.value+"&gen_uom_desc="+arr[25]+"&manufacturer_id="+arr[12]+"&supplier_id="+supp_code;	
		
			if(document.formGoodsReceivedNoteListHeader.item_2d_barcode_yn.value !=undefined && document.formGoodsReceivedNoteListHeader.item_2d_barcode_yn.value=="Y")//Added for MOHE-CRF-0167
		
		     setTimeout('assignData();',1000);
			
		
		document.formGoodsReceivedNoteListHeader.item_qty_normal.focus();
				
		}
	}
}
function checkUOMConvFactor() {
	var formObj = document.formGoodsReceivedNoteListHeader;
	//if (formObj.uom_code.value == formObj.pur_uom_code.value) {
	//	setUOMConvFactor("1");
	//	return;
	//}

	var xmlHttp = new XMLHttpRequest();
	//var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	var xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	//xmlHttp.open("POST", "../../eST/jsp/GoodsReceivedNoteValidate.jsp?uom_code=" + formObj.uom_code.value + "&pur_uom_code=" + formObj.pur_uom_code.value + "&validate=GET_CONV_FACTOR" + "&item_code=" + formObj.item_code.value+"&store_code="+formObj.store_code.value, false);//Commented by suresh.r 19-11-2013 against MMS-SCF-0166
	xmlHttp.open("POST", "../../eST/jsp/GoodsReceivedNoteValidate.jsp?uom_code=" + formObj.uom_code.value + "&pur_uom_code=" + formObj.pur_uom_code.value + "&validate=GET_CONV_FACTOR" + "&item_code=" + formObj.item_code.value+"&store_code="+formObj.store_code.value+"&val_unitcost=N", false);//Added by suresh.r 19-11-2013 against MMS-SCF-0166 
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	//alert(responseText);
	eval(responseText);

	if (!responseText) {
	
		parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "ST");
		formObj.pur_uom_code.value = formObj.uom_code.value;
		formObj.pur_uom_code.focus();
		setUOMConvFactor("1");
	}
}
function setUOMConvFactor(_value) {
	document.getElementById('id_pur_uom_conv').innerHTML = _value;
	document.getElementById('pur_uom_conv').value = _value;
}
function setStockDetails(_stock_item_yn, _store_item_unit_cost) {
	if (_stock_item_yn == "N") {
		alert(getMessage("NOT_STOCK_ITEM", "ST"));
		parent.frameGoodsReceivedNoteListHeader.location.reload();
		parent.frameGoodsReceivedNoteListDetail.location.reload();
		//refreshDetails();
	}
	//se{
	//ocument.formGoodsReceivedNoteListHeader.grn_unit_cost_in_pur_uom.value=_store_item_unit_cost;
//ocument.formGoodsReceivedNoteListHeader.user_grn_unit_cost_in_pur_uom.value=setNumber(_store_item_unit_cost,3);
	//}
}
function set_unit_cost(_last_pur_cost) {
	/**
	 * @Name - Priya
	 * @Date - 28/05/2010
	 * @Inc# - 
	 * @Desc -  To round up unit cost with no_of_decimals_for_cost
	 */
	var no_of_decimals_for_cost = eval(document.formGoodsReceivedNoteListHeader.no_of_decimals_for_cost.value);
	var last_pur_cost = setNumber(_last_pur_cost, no_of_decimals_for_cost);
	document.formGoodsReceivedNoteListHeader.grn_unit_cost_in_pur_uom.value = last_pur_cost;
	document.formGoodsReceivedNoteListHeader.user_grn_unit_cost_in_pur_uom.value = last_pur_cost;
	document.formGoodsReceivedNoteListHeader.tmp_cost.value = last_pur_cost;
	document.formGoodsReceivedNoteListHeader.grn_unit_cost_in_pur_uom.value = document.formGoodsReceivedNoteListHeader.user_grn_unit_cost_in_pur_uom.value;
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
	temp_4 = "";
	var uploadFileCount=0; //23925
	parent.parent.parent.messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";	
	var formObj = parent.frameGoodsReceivedNoteListHeader.document.formGoodsReceivedNoteListHeader;
	var arrayObject = new Array(formObj.item_code, formObj.item_cost_value);
//var names = new Array("Item", "GRN Value");
	var names = new Array(getLabel("Common.item.label", "Common"), getLabel("eST.GRNValue.label", "ST"));
	//var blankObject = getBlankField(arrayObject, names, parent.parent.parent.messageFrame);
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
		/*	if (formObj.item_qty_sample.value!="") {
			item_qty=parseFloat(item_qty)+parseFloat(formObj.item_qty_sample.value);
		}*/
		if (parseFloat(item_qty) == 0) {
			alert(getMessage("ONE_QTY_MUST", "ST"));
			formObj.apply.disabled = false;
			return;
		}
		var sum = 0;
		var proceed = true;
//Starts here....
	var batch_arr = new Array();
	var batch_value = 0;
	for (var b = 0; b < eval(formObjDtl.total_records.value); b++) {
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
	var lesser_sale_price_yn= formObjDtl.lesser_sale_price_yn.value;
//Eneded here
	//	for (var i=0;i<10&&proceed;i++ ){	
		

		for (var i = 0; i < eval(formObjDtl.total_records.value); i++) {
			if (formObjDtl.elements["grn_item_qty_" + i].value != "") {
				var qty = formObjDtl.elements["grn_item_qty_" + i].value;
				if (qty == "") {
					qty = 0;
				}
				if (!isNaN(qty)) {
					sum += parseFloat(qty);
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
										proceed = false;
										formObjDtl.elements["sale_price_" + i].focus();
										formObj.apply.disabled = false;
										return;
									}else{
										//Added by suresh.r 21-11-2013 against MMS-SCF-0166  beg
										if(!validateSalePrice(eval('formObjDtl.elements["sale_price_" + i].value'))){
											formObjDtl.elements["sale_price_" + i].focus();
											formObj.apply.disabled = false;
											proceed = false;
											return;
										}
										//Added by suresh.r 21-11-2013 against MMS-SCF-0166  end
										/*Commented by suresh.r 21-11-2013 against MMS-SCF-0166 beg
										if((eval('formObjDtl.elements("sale_price_" + i).value')<eval(formObj.user_grn_unit_cost_in_pur_uom.value)) && lesser_sale_price_yn == "Y"){
											alert(getMessage("SALE_PRICE_NOT_LESSER_UNIT_PRICE", "ST"));
											formObjDtl.elements("sale_price_" + i).focus();
											formObj.apply.disabled = false;
											proceed = false;
											return;
										}Commented by suresh.r 21-11-2013 against MMS-SCF-0166 end*/
									}
								} else {
									if (proceed) {
										var xmlHttp = new XMLHttpRequest();
										var xmlDoc="";
										//xmlDoc.loadXML(getEnhancedXMLString(formObjDtl));
										var xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObjDtl), "text/xml");
										xmlHttp.open("POST", "../../eST/jsp/GoodsReceivedNoteValidate.jsp?expiry_receipt_date=" + formObjDtl.elements["expiry_date_or_receipt_date_" + i].value + "&batch_id=" + formObjDtl.elements["batch_id_" + i].value + "&item_code=" + formObj.item_code.value + "&validate=CHECK_CONFIRM", false);
										xmlHttp.send(xmlDoc);
										responseText = trimString(xmlHttp.responseText);
										var status_flags_1 = new Array();
										var status_flags = responseText;
										status_flags_1 = status_flags.split("##");
										var temp_1 = status_flags_1[0];
										var temp_2 = status_flags_1[1];
										var temp_3 = status_flags_1[2];
										if (temp_1 == "C" || temp_1 == "S") {
											temp_4 += temp_2 + ", Expiry Dt : " + temp_3 + "   \n";
										} else {
											proceed = true;
										}
									}
								}
								//23925 Start.
								if(formObjDtl.elements["fileupload_"+i].value!="" && formObjDtl.elements["fileupload_"+i].value!=null){
									formObjDtl.elements["fileRef_"+i].value="GRN_"+formObjDtl.elements["item_code"].value+"_"+formObjDtl.elements["batch_id_" + i].value+"_"+formObjDtl.elements["formatedDate"].value;
									uploadFileCount++;
								}	
								//23925 End.
								
							}
						}
					}
				}
			}
		}
		if (temp_4.length > 0) {
			var confirmmsg = "Notified/Suspended Batch(es) :-\n " + temp_4 + " \n Do you want to proceed ?";
			if (window.confirm(confirmmsg)) {
				proceed = true;
			} else {
				temp_4 = "";
				proceed = false;
			}
		}
		if (!proceed) {
			formObj.apply.disabled = false;
			return;
		}
	
		if (setNumber(sum,parseInt(formObj.no_deci.value)) != item_qty) {
		///alert(sum);
			alert(getMessage("QUANTIY_MUST_BE_EQUAL", "ST"));
			formObj.apply.disabled = false;
			return;
		}


		var po_interface_yn = formObj.po_interface_yn.value;
		var	delivery_date = formObj.delivery_date.value;
		var receipt_date  = parent.parent.frameGoodsReceivedNoteHeader.document.formGoodsReceivedNoteHeader.receipt_date.value;
		var delv_date_override_yn = formObj.delv_date_override_yn.value;
		var price_override_yn = formObj.price_override_yn.value;
		var by_po = formObj.by_po.value;

		if(po_interface_yn=="Y" && by_po == "Y"){	
			if(delv_date_override_yn=="W"){
					if(delivery_date!=receipt_date){
					var confirmdate = confirm(" Delivery Due Date and Goods Receipt Date are not the same. \n Do you wish to continue?");
						if(!confirmdate){
						formObj.apply.disabled = false;
						return;
						}
					}
			}else if(delv_date_override_yn=="E"){
					if(delivery_date!=receipt_date){
						alert(" Delivery Due Date and Goods Receipt Date are not the same.");
						formObj.apply.disabled = false;
						return;
					}
					
			}

			if(price_override_yn=="W"){
					if(parseFloat(formObj.grn_unit_cost_in_pur_uom.value)!=parseFloat(formObj.po_unit_cost_in_pur_uom.value)){
						var confirmdate = confirm(" PO Value and GRN Value are not same. Do you wish to Continue?");
						if(!confirmdate){
						formObj.apply.disabled = false;
						return;
						}
					}
			}else if (price_override_yn=="E"){
					if(parseFloat(formObj.grn_unit_cost_in_pur_uom.value)!=parseFloat(formObj.po_unit_cost_in_pur_uom.value)){
						alert(" PO Value and GRN Value are not same.");
						formObj.apply.disabled = false;
						return;
					}
			}
		}



		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getEnhancedXMLString(formObjDtl));
		var xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObjDtl), "text/xml");
		if(uploadFileCount>0){
			parent.parent.frameGoodsReceivedNoteList.frameGoodsReceivedNoteListDetail.document.formGoodsReceivedNoteListDetail.submit();
			//alert("Attached Files Uploaded Successfully.");
		}
		  //23925
		
		
		var delayInMilliseconds = 1000 * (uploadFileCount+1); //1 second.
		setTimeout(function(){
			if(uploadFileCount>0){
				alert("Attached Files Uploaded Successfully.");
			}
		
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
		/**
			* @Name - Priya 
			* @Date - 17/12/2009
			* @Inc# - IN017176
			* @Desc - To Display the character ® properly in Item desc without junck characters
			* added 'encodeURIComponent(formObj.item_desc.value,"UTF-8")' in the next line code
			*/
		var manufacturer_id= "";//added for MO-CRF-20165 START
		var item_remarks_desc = "";
		var catalog_code="";
		var manufac_remarks = ""; //MO-CRF-20178
		if(formObj.manufacturer_id!=undefined){
			manufacturer_id = formObj.manufacturer_id.value ;
		}
		if(formObj.remarks!=undefined){
			item_remarks_desc = formObj.remarks.value;
		}
		if(formObj.catalog_code!=undefined){
			catalog_code = formObj.catalog_code.value;
		}//END 
		if(formObj.manufac_remarks!= undefined){//MO-CRF-20178 START
			manufac_remarks = formObj.manufac_remarks.value;  
		}//END  
		formObj.grn_unit_cost_in_pur_uom.value = formObj.user_grn_unit_cost_in_pur_uom.value;
		xmlHttp.open("POST", "../../eST/jsp/GoodsReceivedNoteValidate.jsp?index=" + formObj.index.value + "&doc_srl_no=" + formObj.doc_srl_no.value + "&item_code=" + formObj.item_code.value + "&item_desc=" + encodeURIComponent(formObj.item_desc.value,"UTF-8") + "&item_qty_normal=" + formObj.item_qty_normal.value + "&item_qty_bonus=" + formObj.item_qty_bonus.value + "&item_qty_sample=" + formObj.item_qty_sample.value + "&label_reqd_yn=" + formObj.label_reqd_yn.checked + "&replace_on_expiry_yn=" + formObj.replace_on_expiry_yn.checked + "&item_cost_value=" + formObj.item_cost_value.value + "&no_of_labels=" + formObj.no_of_labels.value + "&grn_unit_cost_in_pur_uom=" + formObj.grn_unit_cost_in_pur_uom.value + "&uom_code=" + formObj.uom_code.value + "&pur_uom_code=" + formObj.pur_uom_code.value + "&expiry_yn=" + formObj.expiry_yn.value + "&uom_desc=" + document.getElementById('id_uom').innerText + "&pur_uom_conv=" + document.getElementById('pur_uom_conv').value + "&to_conv_fact=" + formObj.tmp_conv.value+ "&po_cost=" +po_cost + "&po_discount=" +po_discount+ "&po_tax=" + po_tax+"&allow_yn="+formObj.allow_deci_yn.value+"&no_decimals="+formObj.no_deci.value+"&pur_uom_conv_id=" + document.getElementById('id_pur_uom_conv').innerText+"&ordered_qty="+formObj.ordered_qty.value+"&delivery_date="+formObj.delivery_date.value +"&conversion_rate-="+formObj.conversion_rate.value+  "&manufacturer_id=" + manufacturer_id + "&remarks_desc=" + item_remarks_desc + "&catalog_code=" + catalog_code + "&manufac_remarks="+ manufac_remarks +"&validate=ADD_TO_LIST", false);//modified for MO-CRF-20165 END,manufac_remarks added for MO-CRF-20178  
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if (result) {
			parent.parent.frameGoodsReceivedNoteHeader.formGoodsReceivedNoteHeader.preview.disabled = false;
			refreshDetails(formObj.index.value);
		} else {
			formObj.apply.disabled = false;
			parent.parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
			parent.frameGoodsReceivedNoteListDetail.location.href = "../../eCommon/html/blank.html";
		}	
		
		}, delayInMilliseconds); 
		
	} else {
	//	blankObject.focus();
	}
}

// To refresh detail frame on click of Add
function refreshDetails(index) {
//	doc_type_code, doc_no
//	parent.parent.frameGoodsReceivedNoteDetail.location.reload();
	var formObj = parent.frameGoodsReceivedNoteListHeader.document.formGoodsReceivedNoteListHeader;
	parent.parent.frameGoodsReceivedNoteDetail.location.href = "../../eST/jsp/GoodsReceivedNoteDetail.jsp?index=" + index + "&tmp_conv=" + formObj.tmp_conv.value;
	parent.frameGoodsReceivedNoteListHeader.location.href = "../../eST/jsp/GoodsReceivedNoteListHeader.jsp";
	parent.frameGoodsReceivedNoteListDetail.location.href = "../../eCommon/html/blank.html";
//	parent.frameGoodsReceivedNoteListDetail.location.href='../../eST/jsp/GoodsReceivedNoteListDetail.jsp';
//	parent.frameGoodsReceivedNoteListDetail.location.reload();
}
async function apply() {
	if(f_query_add_mod.frameGoodsReceivedNoteHeader==undefined){
		if(external_po_yn=="Y"){
			parent.frames[2].location.reload();
		}else{
			messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		}
		return;
	}

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
	var formObj = f_query_add_mod.frameGoodsReceivedNoteHeader.document.formGoodsReceivedNoteHeader;
	if (noDetailExists) {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("MIN_ONE_DETAIL_REQUIRED", "Common");
		return;
	}
	var formObj = f_query_add_mod.frameGoodsReceivedNoteHeader.document.formGoodsReceivedNoteHeader;
	//Added against GDOH-CRF-0109 starts
	var po_mandatory = formObj.po_mandatory.value;
	var arrayObject ="";
	var names = "";
	if(po_mandatory == "Y" && formObj.mode.value==1){
		arrayObject = new Array(formObj.receipt_date, formObj.supp_code,formObj.po_no);
		names = new Array(getLabel("Common.receiptdate.label", "Common"), getLabel("Common.Supplier.label", "Common"), getLabel("eST.PONo.label", "ST"));
	}
	else{
		arrayObject = new Array(formObj.receipt_date, formObj.supp_code);
//	var names = new Array("Receipt Date", "Supplier");
		names = new Array(getLabel("Common.receiptdate.label", "Common"), getLabel("Common.Supplier.label", "Common"));
	}
		//Added against GDOH-CRF-0109 ends
//	var blankObject = getBlankField(arrayObject, names, messageFrame);
	var blankObject = checkSTFields(arrayObject, names, messageFrame);
	if (blankObject == true) {
		forDeletion = forDeletion.substring(0, forDeletion.length - 1);
		formObj.records_to_delete.value = forDeletion;
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		var xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/GoodsReceivedNoteValidate.jsp?validate=CHECK_AUTHORIZE_ALLOWED&store_code=" + formObj.store_code.value, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if (formObj.finalize_allowed_yn.value == "Y") {
			if (formObj.entry_completed_yn.checked) {						
				
				//added for SKR-CRF-0039 By Ganga on 5th Aug 2013
				var xmlHttp = new XMLHttpRequest();
				var xmlDoc="";
				var xmlStr	="<root><SEARCH " ;
				xmlStr+=" function_type=\"2\" ";		
				xmlStr +=" /></root>" ; 
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?trn_type=GRN&store_code="+formObj.store_code.value, false);
				xmlHttp.send(xmlDoc);
				responseText = xmlHttp.responseText;
				eval(responseText);		
				
				var response = "";
				//response = confirmFinalize(); commented
				if(result){
					response = await confirmFinalize();	
				}else{
					response = YES;
				}
				//Added ends	
				
				if (response == YES) {
					formObj.finalized_yn.value = "Y";
				}
			}
		}
		var responseText = formApply(formObj, ST_CONTROLLER);
		eval(responseText);
		
		var flag1 = (flag.split("~"))[0];
		var flag2 = (flag.split("~"))[1];
		flag1 = (flag1 == "null" ? "" : flag1);
		if (result) {
			if (flag2 == "PY") {
				if (formObj.finalize_allowed_yn.value == "Y") {
					var PConfirm = await confirmPrinting();
					if (PConfirm == "Yes") {
						var xmlHttp = new XMLHttpRequest();
						var xmlDoc="";
						//xmlDoc.loadXML(getXMLString(null));
						var xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
						//xmlHttp.open("POST", "../../eST/jsp/GoodsReceivedNoteValidate.jsp?validate=printOnlineDoc&msg=" + encodeURIComponent(message), false);
						xmlHttp.open("POST", "../../eST/jsp/GoodsReceivedNoteValidate.jsp?validate=printOnlineDoc&msg=" + encodeURIComponent(message), true);
						xmlHttp.send(xmlDoc);
						//responseText = xmlHttp.responseText;
						//alert(responseText);
						//eval(responseText);
					}
				}
			} else 	if (flag2 == "PN") {
						var xmlHttp = new XMLHttpRequest();
						var xmlDoc="";
						//xmlDoc.loadXML(getXMLString(null));
						var xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
						//xmlHttp.open("POST", "../../eST/jsp/GoodsReceivedNoteValidate.jsp?validate=printOnlineDoc&msg=" + encodeURIComponent(message), false);
						xmlHttp.open("POST", "../../eST/jsp/GoodsReceivedNoteValidate.jsp?validate=printOnlineDoc&msg=" + encodeURIComponent(message), true);
						xmlHttp.send(xmlDoc);
						//responseText = xmlHttp.responseText;
						//alert(responseText);
						//eval(responseText);
			}
			messageFrame.location.href = errorPage + "?err_num=" + message + "<BR>" + (result ? flag1 : "");
			onSuccess();
		}
		if (result) {
			messageFrame.location.href = errorPage + "?err_num=" + message + "<BR>" + flag1;
		} else {
			messageFrame.location.href = errorPage + "?err_num=" + message;
			//messageFrame.location.href = errorPage+"?err_num="+getMessage("DUPLICATE_BATCHES","ST");
		}
		if (result) {
			onSuccess();
		} else {
			if (flag != "") {
				/*					xmlDoc.loadXML(getXMLString(null));
					xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?validate=GET_INDEX&item_code="+flag, false);
					xmlHttp.send(xmlDoc);
					responseText=xmlHttp.responseText;
					eval(responseText);			f_query_add_mod.frameIssueDetail.location.href="../../eST/jsp/IssueDetail.jsp?function_id="+function_id+"&index="+flag;*/
				f_query_add_mod.frameGoodsReceivedNoteDetail.location.href = "../../eST/jsp/GoodsReceivedNoteDetail.jsp?function_id=" + formObj.function_id.value + "&index=" + flag + "&mode=" + formObj.mode.value;
			}
		}
	} else {
		//blankObject.focus();
	}
}
function setFinalize_allowed(_finalize_allowed_yn) {
	f_query_add_mod.frameGoodsReceivedNoteHeader.document.formGoodsReceivedNoteHeader.finalize_allowed_yn.value = _finalize_allowed_yn;
}
function cancel_me() {
	parent.frameGoodsReceivedNoteListHeader.location.href = "../../eST/jsp/GoodsReceivedNoteListHeader.jsp";
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
//MO-CRF-20178
function checkManuRemarksLength(obj){
	if (!setTextAreaMaxLength(obj, 251)) {
		alert(getMessage("MANUFACTURER_REMARKS_CHAR_EXCEEDS_LIMIT", "ST"));
		obj.focus();
	}
}
function modifyData(index,by_po) {
	var trObject = eval(document.getElementById('tr_' + index));
	changeRowColor(trObject);
	var conversion_rate = '1';
	if(parent.frameGoodsReceivedNoteHeader.formGoodsReceivedNoteHeader.exchangerate!=undefined){
		conversion_rate = parent.frameGoodsReceivedNoteHeader.formGoodsReceivedNoteHeader.exchangerate.value;
	}
	parent.frameGoodsReceivedNoteList.location.href = "../../eST/jsp/GoodsReceivedNoteListFrame.jsp?function=modify&index=" + index + "&function_id=" + parent.parent.function_id +"&by_po="+by_po+"&conversion_rate="+conversion_rate;
}
function Modify(obj) {
	/**
	* @Name - Priya
	* @Date - 22/12/2009
	* @Inc# - IN017084
	* @Desc - To avoid the duplication records display in Modify mode
	*/
	var errorPage = "../../eCommon/jsp/error.jsp";
	document.getElementById('readOnlyDiv').style.visibility='visible';
	parent.parent.messageFrame.location.href = errorPage + "?err_num="+getMessage("ST_PROCESSING_WAIT", "ST");
	
	var doc_no = obj.cells[1].innerText;
	var doc_type_code = obj.cells[4].innerText;
	
	parent.document.location.href = "../../eST/jsp/GoodsReceivedNoteFrame.jsp?mode=" + MODE_MODIFY + "&function_id=" + parent.parent.function_id + "&doc_type_code=" + doc_type_code + "&doc_no=" + doc_no;
	
}
function checkSysdate(receiptdate, sysdate) {
	var flag = ChkDate(receiptdate);
	if (!flag) {
		alert(getMessage("INVALID_DATE_FMT", "ST"));
		receiptdate.value="";//Edge issue
		receiptdate.select();
		receiptdate.focus();
		return false;
	}
	if (flag) {
		if (!checkDateWithSysDate(receiptdate, sysdate)) {
			alert(getMessage("ST_DOC_DT_NOT_GR_SYSDATE", "ST"));
			receiptdate.value="";//Edge issue
			receiptdate.select();
			receiptdate.focus();
			return false;
		} else {
		}
	}
}
function checkDateWithSysDate(entered_date, sys_date) {
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
function makeValidQty(val) {
	if (val == "")
		val = "0";
	return val;
}
function calculateValue() {
	formObj = document.formGoodsReceivedNoteListHeader;
//	if ((formObj.item_qty_bonus.value!="")||(parseFloat(formObj.item_qty_bonus.value)!=0)||(formObj.item_qty_sample.value!="")||(parseFloat(formObj.item_qty_sample.value)!=0))
	if ((makeValidQty(formObj.item_qty_bonus.value) != "0") || (makeValidQty(formObj.item_qty_sample.value) != "0")) {
		formObj.user_grn_unit_cost_in_pur_uom.disabled = false;
	}else
		formObj.user_grn_unit_cost_in_pur_uom.disabled = false;
	if(formObj.po_cost!=undefined && formObj.po_cost.value!= ""){
		formObj.user_grn_unit_cost_in_pur_uom.disabled = true;
		formObj.item_cost_value.disabled = true;
	}

	if (formObj.user_grn_unit_cost_in_pur_uom.value == "") {
		formObj.user_grn_unit_cost_in_pur_uom.value = 0;
		//return;commented and added above by ganga
	}
	var item_qty = 0;
	if (formObj.item_qty_normal.value != "") {
		item_qty = parseFloat(item_qty) + parseFloat(formObj.item_qty_normal.value);
	}
	if (formObj.item_qty_bonus.value != "") {
		item_qty = parseFloat(item_qty) + parseFloat(formObj.item_qty_bonus.value);
	}
	if (item_qty != 0) {
		var item_value ="";
		//if(formObj.po_interface_yn.value == "Y"){
		//	 item_value = parseFloat(formObj.grn_unit_cost_in_pur_uom.value) * parseFloat(item_qty) * parseFloat(formObj.conversion_rate.value);
		//}else{
			item_value = parseFloat(formObj.grn_unit_cost_in_pur_uom.value) * parseFloat(item_qty);
		//}

		/**
		 * @Name - Priya
		 * @Date - 28/05/2010
		 * @Inc# - 
		 * @Desc -  To round up item_value with no_of_decimals_for_cost
		 */
	var no_of_decimals_for_cost = eval(formObj.no_of_decimals_for_cost.value);
		/*item_value = parseFloat(item_value) * 1000;
		item_value = Math.round(item_value);
		item_value = parseFloat(item_value) / 1000;*/
		formObj.item_cost_value.value = setNumber(item_value,no_of_decimals_for_cost);
	//	if (formObj.no_of_labels.value=="") {
			/** @Name - Priya
				* @Date - 10/02/2010
				* @Inc# - 19098 
				* @Desc - Math.ceil() function is used to round up the decimal value to the nearest max integer value.
			*/
		formObj.no_of_labels.value = Math.ceil(item_qty);
	//	}
	} else {
		formObj.item_cost_value.value = "";
		//formObj.user_grn_unit_cost_in_pur_uom.value="";
		formObj.no_of_labels.value="";
		
	}
}
function calculateCost() {
	formObj = document.formGoodsReceivedNoteListHeader;
	if (formObj.item_cost_value.value == "") {
		formObj.item_cost_value.value = 0;
		//return;commented and added above by ganga
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
		var item_cost = "";
		//if(formObj.po_interface_yn.value == "Y"){
		//item_cost = parseFloat(formObj.item_cost_value.value) / (parseFloat(item_qty) * parseFloat(formObj.conversion_rate.value));
		//}else{
		item_cost = parseFloat(formObj.item_cost_value.value) / parseFloat(item_qty);	
		//}
		/*item_cost = parseFloat(item_cost) * 1000;
		item_cost = Math.round(item_cost);
		item_cost = parseFloat(item_cost) / 1000;  */
		/**
		 * @Name - Priya
		 * @Date - 28/05/2010
		 * @Inc# - 
		 * @Desc -  To round up item_cost with no_of_decimals_for_cost
		 */
		var no_of_decimals_for_cost = eval(formObj.no_of_decimals_for_cost.value);
		item_cost= setNumber(item_cost,no_of_decimals_for_cost);
		formObj.user_grn_unit_cost_in_pur_uom.value = item_cost;
		formObj.grn_unit_cost_in_pur_uom.value = item_cost;
		formObj.tmp_cost.value = item_cost;
		if (formObj.no_of_labels.value == "") {
			/** @Name - Priya
				* @Date - 10/02/2010
				* @Inc# - 19098 
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
//	var doc_date	 =parent.frameGoodsReceivedNoteHeader.formGoodsReceivedNoteHeader.doc_date.value;
	var retVal = "";
	var dialogHeight = "70vh";
	var dialogWidth = "60vw";
	var dialogTop = "0vh";
	var center = "1";
	var status = "no";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments = "";
	var url = "../../eST/jsp/GrnPreviewDetails.jsp?store_code=" + store_code + "&doc_type_code=" + doc_type_code + "&supplier=" + supplier;
	retVal = await window.showModalDialog(url, arguments, features);
}
function CheckForSpecialChars(event) {
	var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-/:";// modified by chandrashekar for the incident MO-GN-5351
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


//var prevObj=null;
//var prevColor=null;
function changeRowColor(obj) {
	if (prevObj != null) {

		//for( k=0;k<2;k++)
			//prevObj.cells(k).className=prevColor;
	}
	prevObj = obj;
	prevColor = obj.cells[1].className;
	for (i = 0; i < document.forms[0].total_checkboxes.value; i++) {
		(eval(document.getElementById('tr_' + i))).cells[0].className = "QRYODD";
		(eval(document.getElementById('tr_'+ i))).cells[1].className = "QRYODD";
	}
	for (k = 0; k < 2; k++) {
		obj.cells[k].className = "STLIGHTPINK";
	}
}
function issueUOMQtyChk() {
	var formObj = document.formGoodsReceivedNoteListHeader;
	toConvFactor();
	var dec_factor = ((eval(formObj.item_qty_normal.value)+(formObj.item_qty_bonus.value==""?eval("0"):eval(formObj.item_qty_bonus.value))) * (formObj.pur_uom_conv.value)) % (formObj.tmp_conv.value);
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
	if(formObj != undefined && formObj != null){
		item_code = formObj.item_code.value;  // Added 
	}	
//	item_code = formObj.item_code.value;  // Commented 
	if (parent.frameGoodsReceivedNoteDetail != null) {
		var formObj1 = parent.frameGoodsReceivedNoteDetail.document.formGoodsReceivedNoteDetail;
		item_code = formObj1.item_code.value;
	}
	var xmlHttp = new XMLHttpRequest();
	//var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	var xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/GoodsReceivedNoteValidate.jsp?validate=setToConv" + "&store_code=" + store_code + "&item_code=" + item_code, false);
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	/*if( !result ) {
		if(message=="Multiple"){
		alert("Mutilpe uom");
			cancel_me();
			return;
		}
		}	*/
	eval(responseText);
}
function dispMess(id) {
	alert(getMessage("PHY_INV_PROCESS_INITIATED", "ST") + "\n" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + id);
}
function checkUnitCost(obj){
	//Added by suresh.r 19-11-2013 against MMS-SCF-0166  beg
	if(!validateSalePrice(obj.value)){
		obj.value = ""; // Edge has issue on focus and loop
		obj.focus();
	}
	//Added by suresh.r 19-11-2013 against MMS-SCF-0166  end
	
	/*Commented by suresh.r 19-11-2013 against MMS-SCF-0166 beg
	var unit_cost = eval(parent.parent.frameGoodsReceivedNoteList.frameGoodsReceivedNoteListHeader.document.formGoodsReceivedNoteListHeader.user_grn_unit_cost_in_pur_uom.value);
	
	
	
	if(eval(obj.value)<unit_cost && document.formGoodsReceivedNoteListDetail.lesser_sale_price_yn.value == "Y"){
		alert(getMessage("SALE_PRICE_NOT_LESSER_UNIT_PRICE", "ST"));
			obj.focus();
	}Commented by suresh.r 19-11-2013 against MMS-SCF-0166 end*/
}
function calculatePoCost(obj){
	formObj = document.formGoodsReceivedNoteListHeader;
	if((formObj.po_cost.value == "")&&(formObj.po_discount.value != ""||formObj.po_tax.value != "")){
		//alert("PO Cost Cannot Be Blank");
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
	 * @Date - 28/05/2010
	 * @Inc# - 
	 * @Desc -  To round up unit cost with no_of_decimals_for_cost
	 */
	var no_of_decimals_for_cost = eval(formObj.no_of_decimals_for_cost.value);
	if(formObj.po_cost.value == ""){
		formObj.po_discount.value = "";
		formObj.po_tax.value = "";
		formObj.user_grn_unit_cost_in_pur_uom.value = setNumber(formObj.tmp_cost.value, no_of_decimals_for_cost);
		formObj.grn_unit_cost_in_pur_uom.value = setNumber(formObj.tmp_cost.value,no_of_decimals_for_cost);
		formObj.user_grn_unit_cost_in_pur_uom.disabled = false;
		formObj.item_cost_value.disabled = false;
	}else{
		var po_cost = formObj.po_cost.value == ""?"0":formObj.po_cost.value
		var po_discount = formObj.po_discount.value == ""?"0":formObj.po_discount.value
		var po_tax = formObj.po_tax.value == ""?"0":formObj.po_tax.value
		var cost = (eval(po_cost) - eval(po_discount)) + ((po_cost)* (po_tax)/100);
		formObj.user_grn_unit_cost_in_pur_uom.value = setNumber(cost,no_of_decimals_for_cost);
		formObj.grn_unit_cost_in_pur_uom.value = setNumber(cost,no_of_decimals_for_cost);
		formObj.user_grn_unit_cost_in_pur_uom.disabled = true;
		formObj.item_cost_value.disabled = true;
	}
}
function setPOCost(obj){
	formObj = document.formGoodsReceivedNoteListHeader;
	formObj.tmp_cost.value = formObj.grn_unit_cost_in_pur_uom.value;
	//formObj.po_cost.value = obj.value;
}
function setTrn_type(obj){
	
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	var xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/GoodsReceivedNoteValidate.jsp?doc_type_code=" + obj.value + "&validate=TRNTYPE", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);	
}


function LoadDetailPage(obj) {
	formObj =document.formGoodsReceivedNoteHeader;
	var po_doc_no =document.formGoodsReceivedNoteHeader.po_no.value;
	var from_store_code =document.formGoodsReceivedNoteHeader.store_code.value;


	if(po_doc_no!="" && obj.value!="" ){
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	var xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/GoodsReceivedNoteValidate.jsp?validate=LOAD_DETAILS" + "&po_doc_type_code=" + obj.value + "&po_doc_no=" + po_doc_no + "&fm_store_code=" + from_store_code, false);
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	eval(responseText);

	if (result) {
		document.formGoodsReceivedNoteHeader.po_no.disabled = true;
		document.formGoodsReceivedNoteHeader.po_doc_type_code.disabled = true;
		//document.formGoodsReceivedNoteHeader.store_code.disabled = true;
		document.formGoodsReceivedNoteHeader.store_code_disabled.value = "disabled";
		//document.formGoodsReceivedNoteHeader.doc_type_code.disabled=true;
		parent.frameGoodsReceivedNoteDetail.location.href = "../../eST/jsp/GoodsReceivedNoteDetail.jsp?fm_store_code=" +from_store_code+"&PO_from=yes";
		parent.frameGoodsReceivedNoteList.location.href = "../../eST/jsp/GoodsReceivedNoteListFrame.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id+"&item_disabled=disabled";
		document.formGoodsReceivedNoteHeader.preview.disabled = false;
	}else{
	alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
	document.formGoodsReceivedNoteHeader.po_no.value= "";
	document.formGoodsReceivedNoteHeader.po_doc_type_code.value= "";
	document.formGoodsReceivedNoteHeader.po_doc_type_code.disabled=true;
	}
}
}

function enableDocType(obj){
	if(document.formGoodsReceivedNoteHeader.po_doc_type_code)
		document.formGoodsReceivedNoteHeader.po_doc_type_code.disabled=true;
}
async function showRemarks() {
	var rem = "";
	rem = await window.showModalDialog("../../eST/jsp/GoodsReceivedNoteRemarks.jsp?function_id=" + parent.parent.function_id, "", "dialogHeight:30vh; dialogWidth:30vw; center:0; status: no; dialogLeft :75; dialogTop :250;");
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
	if (!setTextAreaMaxLength(formObject.remarks, 183)) {//modified remarks to 182 chars for MO-CRF-20165
		alert(getMessage("REMARKS_NOT_EXCEED_182_CH", "ST")); 
		return;
	}
	
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlStr = getXMLString(formObject); //Commented by Sakti Sankar against Inc#37941 for Special character issue
	xmlStr = getEnhancedXMLString(formObject); //Added by Sakti Sankar against Inc#37941
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/GoodsReceivedNoteValidate.jsp?validate=SET_REMARKS", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	//alert(responseText);
	eval(responseText);
	window.returnValue = formObject.remarks_code_2.value;
	window.close();
}
//Added for MO-CRF-20165
function updateItemRemarks() {
	formObject = document.formReplaceGRNItemRemarks; 
	
	if (!setTextAreaMaxLength(formObject.remarks, 101)) { //modified for MO-CRF-20165 
		alert(getMessage("REMARKS_NOT_EXCEED_100_CH", "ST")); 
		return;
	}  
	var item_remarks= formObject.remarks.value;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlStr = getXMLString(formObject); //Commented by Sakti Sankar against Inc#37941 for Special character issue
	xmlStr = getEnhancedXMLString(formObject); //Added by Sakti Sankar against Inc#37941
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/GoodsReceivedNoteValidate.jsp?validate=SET_ITEM_REMARKS" + "&item_remarks=" +item_remarks, false); 
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	//alert(responseText);
	eval(responseText);
	window.returnValue = formObject.remarks.value; 
	window.close();
}

/**
	* @Name - Priya
	* @Date - 22/12/2009
	* @Inc# - IN017084
	* @Desc - To avoid the duplication records display in Modify mode
	*/
function clearMessageFrame(){
var errorPage = "../../eCommon/jsp/error.jsp";
parent.messageFrame.location.href = errorPage + "?err_num=";
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
	
	//Added by Padmapriya for INC #34926 on 21/11/2012
	var selectedText = ShowSelection(fld); 
	if(selectedText != 0){
		return true;
	}	
	//End by Padmapriya for INC #34926 on 21/11/2012
		
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
	//commented by Sakti sankar  against RUT-SCF-0248
	//document.getElementById("id_pur_uom_conv").innerHTML =_rulestring;
	//document.getElementById("pur_uom_conv").value = _value;

//Added by Sakti sankar against RUT-SCF-0248 for displaying special characters
	document.getElementById('id_pur_uom_conv').innerHTML = decodeURIComponent(_rulestring,"UTF-8");
	document.getElementById('pur_uom_conv').value = decodeURIComponent(_value,"UTF-8");
	
}

//Added By Rabbani #inc no: 27056 on 11/10/11
//starts here
async function callBatchSearchScreen() {
	 var store_batch_code =parent.parent.frameGoodsReceivedNoteHeader.formGoodsReceivedNoteHeader.store_code.value;
	var batch_item = document.formGoodsReceivedNoteListHeader.item_code.value; 
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

function batchdisable() {
 var formObj =  document.formGoodsReceivedNoteListHeader;
if ((formObj.item_code.value != "") && (formObj.item_code.value !=null)) {
			formObj.batchsearch.disabled = false;
		} else {
			formObj.batchsearch.disabled = true;
		}
}
//ends here


async function Load_PurchaseOrderDetails(obj,supp_code){
	var supp_code_non_mand=(document.formGoodsReceivedNoteHeader.supp_code_non_mand_chk.value =="Y");// Added for IN:071539
	//Modified for IN:071539 START
	if(!supp_code_non_mand){
	if(supp_code.value==""){
		alert("APP-000001 Supplier Cannot be blank");
		return;
	}
	}//Modified for IN:071539 END
	var store_code =document.formGoodsReceivedNoteHeader.store_code.value;
	var mode =document.formGoodsReceivedNoteHeader.mode.value;
	var do_no =document.formGoodsReceivedNoteHeader.do_no.value;
	var po_no="";
	var pur_unit_code="";	
	var local_currency="";
	var trans_currency="";
	var conversion_rate="";
	var invoice_no="";
	var invoice_received_by="";

	var retVal = "";
	var dialogHeight = "45vh";
	var dialogWidth = "70vw";
	var dialogTop = "100";
	var center = "1";
	var status = "no";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments = "";
	var url = "../../eST/jsp/POItemDetailFrame.jsp?po_number=" + obj.value + "&supp_code="+supp_code.value + "&store_code="+store_code+ "&mode="+mode+ "&do_no="+do_no;
	retVal = await top.window.showModalDialog(url, arguments, features);	
	if (retVal!= null){
	 retValChk = (retVal.split("||"))[0];
	 pur_unit_code =(retVal.split("||"))[1];
	 po_no =(retVal.split("||"))[2];
	 local_currency =(retVal.split("||"))[3];
	 trans_currency =(retVal.split("||"))[4];
	 conversion_rate =(retVal.split("||"))[5];
	 do_no =(retVal.split("||"))[6];
	 invoice_no =(retVal.split("||"))[7];
	 invoice_received_by =(retVal.split("||"))[8];
     }
	//Modified  for IN:071539 start
	if(supp_code_non_mand){
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	var xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/GoodsReceivedNoteValidate.jsp?validate=SUPP_CODE" + "&po_no=" + po_no, false);
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	eval(responseText);
	var supp=document.formGoodsReceivedNoteHeader.supp_code_new.value;
	setSelectedIndex(document.getElementById('supp_code'),supp);
	}
	//Modified  for IN:071539 end
	
	//Added for NMC-JD-CRF-0100-Start
		if(supp_code.value!="" && po_no!=""){
			document.formGoodsReceivedNoteHeader.supp_code.disabled = true; 
		}
	//Added for NMC-JD-CRF-0100-End
	
	if (retVal!= null && retValChk!= undefined && retValChk=="ADD") {		
		document.formGoodsReceivedNoteHeader.po_no.value = po_no;
		document.formGoodsReceivedNoteHeader.po_no.disabled = true;
		document.formGoodsReceivedNoteHeader.currency_code.value = trans_currency;
		document.formGoodsReceivedNoteHeader.currency_code.disabled = true;
		document.formGoodsReceivedNoteHeader.exchangerate.value = conversion_rate;
		//document.formGoodsReceivedNoteHeader.exchangerate.disabled = true;
		document.getElementById('localcurrency').innerText = trans_currency;
		document.formGoodsReceivedNoteHeader.grn_mode.value = "P";
		if(do_no != " " && document.formGoodsReceivedNoteHeader.do_no != undefined){
			document.formGoodsReceivedNoteHeader.do_no.value = do_no;		
			document.formGoodsReceivedNoteHeader.do_no.disabled = true;
			document.formGoodsReceivedNoteHeader.invoice_no.value = invoice_no;	
			document.formGoodsReceivedNoteHeader.invoice_received_by.value = invoice_received_by;	
			document.formGoodsReceivedNoteHeader.grn_mode.value = "D";
		}else if(do_no == null || do_no == " " || do_no==""){
			document.formGoodsReceivedNoteHeader.do_no.value = "";		
			document.formGoodsReceivedNoteHeader.do_no.disabled = false;		
		}

		parent.frameGoodsReceivedNoteDetail.location.href = "../../eST/jsp/GoodsReceivedNoteDetail.jsp?fm_store_code=" +store_code;
		parent.frameGoodsReceivedNoteList.location.href = "../../eST/jsp/GoodsReceivedNoteListFrame.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
		document.formGoodsReceivedNoteHeader.preview.disabled = false;
	}else{
	//alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
	}
}
async function searchItemCode(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0]= localeName;
	dataTypeArray[0] = STRING;
	argumentArray[0] = document.forms[0].SQL_ST_ITEM_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		var ret1=unescape(returnedValues);
		var arr=ret1.split(",");
		if(arr[1]==undefined) 
		{
			arr[0]="";	
			arr[1]="";	
		}
			 	
		//obj.value = returnedValues[1];
		//document.forms[0].item_code.value = returnedValues[0];
		obj.value = arr[1];
		document.forms[0].item_code.value = arr[0];
	}
	else
	{
		obj.value ="";
		document.forms[0].item_code.value ="";
	}
}

function enable_doc(object, batchcount, index , po_or_do){
	
	var doc_no = object.value;
	var formObj = document.forms[0];
	var prevCount = formObj.sel_doc_batch_count.value;	
	var prevdoc_no = formObj.selected_doc_no.value;	
	var prev_ind = formObj.prev_ind.value;	
	formObj.selected_doc_no.value = doc_no;	
	formObj.sel_doc_batch_count.value = batchcount;	
	formObj.prev_ind.value = index;	
	var ind =  index ;    
	// Added for IN:071539 START  
	var multi_selct_appl=(formObj.multi_selct_appl_chk.value =="Y");	
   if(multi_selct_appl){
   var totalCheckobj = eval("formObj.doc_no1_"+doc_no);
   if(object.checked == true ){
		if (totalCheckobj!= undefined ){
			totalCheckobj.checked = true;
			totalCheckobj.disabled=false;
		}
   }
   }
   // Added for IN:071539 END
	for (var index=0; index < batchcount; index++ ){
		var checkobj = eval("formObj.doc_no_"+doc_no+"_"+index);
		var itemQtyobj = eval("formObj.grn_item_qty_"+doc_no+"_"+index);
		var applyobj = eval("formObj.apply_"+doc_no);//Modified for IN:071539
		if(object.checked == true ){
			if (checkobj!= undefined && itemQtyobj!= undefined){
			checkobj.checked = true;

			if(po_or_do=="P"){
				itemQtyobj.value=eval("formObj.po_qty_"+doc_no+"_"+index).value;
				itemQtyobj.disabled=false;
			}
			else if(po_or_do=="D"){
				itemQtyobj.value=eval("formObj.do_qty_"+doc_no+"_"+index).value;
			}

			checkobj.disabled=false;			
			applyobj.disabled = false;
			}
			
		}
		
	}
	if(prevdoc_no != undefined && prevdoc_no!= null && prevdoc_no!=""  && doc_no!=prevdoc_no){
		// Added for IN:071539 START
		if(multi_selct_appl){
		var totalCheckobj = eval("formObj.doc_no1_"+prevdoc_no);
		totalCheckobj.checked = false;
		totalCheckobj.disabled=true;
		}
		eval(document.getElementById('img_next_del_date_'+prevdoc_no)).style.visibility = "hidden";
		eval(document.getElementById('next_del_date_'+prevdoc_no)).value = "";//Added for IN:071539
		// Added for IN:071539 END
		for (var batindx=0;batindx< parseInt(prevCount) ;batindx++ )
		{
			var checkobj = eval("formObj.doc_no_"+prevdoc_no+"_"+batindx);
			var itemQtyobj = eval("formObj.grn_item_qty_"+prevdoc_no+"_"+batindx);
			var applyobj = eval("formObj.apply_"+prevdoc_no);//Modified for IN:071539
			if (checkobj!= undefined && itemQtyobj!= undefined){
			checkobj.checked = false;
			itemQtyobj.value="";
			checkobj.disabled=true;
			itemQtyobj.disabled=true;
			}
			applyobj.disabled = true;
			
		}
	}
}

function getItemQty(obj,index,po_or_do,batchcount){

   var formObj = document.forms[0];
   var doc_no  = obj.value;
   var checkobj = eval("formObj.doc_no_"+doc_no+"_"+index);
   var grnitemQtyobj = eval("formObj.grn_item_qty_"+doc_no+"_"+index);
   var reqitemQtyobj = eval("formObj.req_qty_"+doc_no+"_"+index);
   var selecteditem = eval("formObj.item_code_"+doc_no+"_"+index).value;
   var applyobj = eval("formObj.apply_"+doc_no);//Added for IN:071539
   var selectedpono = "";
   var itemQtyobj="";
	
	if(po_or_do=="P")
		itemQtyobj = eval("formObj.po_qty_"+doc_no+"_"+index);
	else if(po_or_do=="D")
		itemQtyobj = eval("formObj.do_qty_"+doc_no+"_"+index);

	if (checkobj.checked == true){
		 grnitemQtyobj.value = itemQtyobj.value;
		 if(po_or_do=="P"){
		 grnitemQtyobj.disabled=false;
		 applyobj.disabled = false;//Added for IN:071539
		 }else if(po_or_do=="D"){
			 selectedpono = eval("formObj.po_no_"+doc_no+"_"+index).value;
			for(var i=0;i<batchcount;i++){
				if(i!=index && eval("formObj.item_code_"+doc_no+"_"+i).value == selecteditem  && eval("formObj.po_no_"+doc_no+"_"+i).value == selectedpono){
					eval("formObj.doc_no_"+doc_no+"_"+i).checked = true;
					eval("formObj.grn_item_qty_"+doc_no+"_"+i).value = eval("formObj.do_qty_"+doc_no+"_"+i).value;
				}
			}
		}		 
	}
	else{
		if(po_or_do=="P"){
			grnitemQtyobj.value ="";
			grnitemQtyobj.disabled=true;
		}else if(po_or_do=="D"){
			grnitemQtyobj.value ="";
			selectedpono = eval("formObj.po_no_"+doc_no+"_"+index).value;
			for(var i=0;i<batchcount;i++){
				if(i!=index && eval("formObj.item_code_"+doc_no+"_"+i).value == selecteditem  && eval("formObj.po_no_"+doc_no+"_"+i).value == selectedpono){
					eval("formObj.doc_no_"+doc_no+"_"+i).checked = false;
					eval("formObj.grn_item_qty_"+doc_no+"_"+i).value ="";
					grnitemQtyobj.value ="";
				}
			}
		}
	}
}

function ItemBatch(){
}

function onadd(batchcount){

    var formObj       = document.formPOItemDetailResult;
	var formCriteria  = parent.framePOItemDetailCriteria.document.formPOItemDetailCriteria;	
	var doc_no        = formObj.selected_doc_no.value ;	
	var pur_unit_code = "";
	var local_currency = "";
	var trans_currency = "";
	var conversion_rate = "";
	var qty_override_yn = formObj.qty_override_yn.value;
	var invoice_no="";
	var invoice_received_by="";

	var item_arr   = new Array;
	var arrayIndex = 0;	
	var pohdrStatus = "";
	
	var mandatorydate = eval(document.getElementById('img_next_del_date_'+doc_no)).style.visibility;
	var nextdeldate = eval(document.getElementById('next_del_date_'+doc_no)).value;
	if(mandatorydate=="visible"){
		if(nextdeldate==""){
		alert(getMessage("NEXT_DEL_DATE_CANNOT_BLANK","ST"));
		eval("formObj.next_del_date_"+doc_no).focus();	
		return;	
		}else{
			pohdrStatus = "PD";
		}		
	}else{
			pohdrStatus = "FD";
	}
		
	for (var index=0;index<batchcount;index++ ){	

                var checkobj  = eval("formObj.doc_no_"+doc_no+"_"+index);

				if(eval("formObj.pur_unit_code_"+doc_no+"_"+index)!= undefined)
                pur_unit_code = eval("formObj.pur_unit_code_"+doc_no+"_"+index).value;

				if(eval("formObj.local_currency_"+doc_no+"_"+index)!= undefined)
                local_currency = eval("formObj.local_currency_"+doc_no+"_"+index).value;
				
				if (eval("formObj.trans_currency_"+doc_no+"_"+index)!= undefined)
				trans_currency = eval("formObj.trans_currency_"+doc_no+"_"+index).value;

				if (eval("formObj.conversion_rate_"+doc_no+"_"+index)!= undefined)
				conversion_rate = eval("formObj.conversion_rate_"+doc_no+"_"+index).value;

				if (eval("formObj.invoice_no_"+doc_no+"_"+index)!= undefined)
				invoice_no = eval("formObj.invoice_no_"+doc_no+"_"+index).value;

				if (eval("formObj.invoice_received_by_"+doc_no+"_"+index)!= undefined)
				invoice_received_by = eval("formObj.invoice_received_by_"+doc_no+"_"+index).value;
				
				if (checkobj!= undefined && checkobj.checked == true){
					
					var myClassObj = new ItemBatch();

					myClassObj.doc_no				= eval("formObj.doc_no_"+doc_no+"_"+index).value ;
					myClassObj.item_code			= eval("formObj.item_code_"+doc_no+"_"+index).value;
					myClassObj.req_qty				= eval("formObj.req_qty_"+doc_no+"_"+index).value;
					myClassObj.item_qty             = eval("formObj.grn_item_qty_"+doc_no+"_"+index).value;
					myClassObj.po_qty				= eval("formObj.po_qty_"+doc_no+"_"+index).value;

					if(eval("formObj.req_no_"+doc_no+"_"+index).value=="")
						eval("formObj.req_no_"+doc_no+"_"+index).value = " ";

					myClassObj.req_no				= eval("formObj.req_no_"+doc_no+"_"+index).value;

					if(eval("formObj.do_no_"+doc_no+"_"+index).value=="")
						eval("formObj.do_no_"+doc_no+"_"+index).value = " ";

					myClassObj.do_no				= eval("formObj.do_no_"+doc_no+"_"+index).value;

					if(myClassObj.item_qty == myClassObj.po_qty){
						myClassObj.poitemStatus			= "FD";
					}else{
						myClassObj.poitemStatus			= "PD";
					}

					item_arr[arrayIndex++]  = myClassObj;
				}		
		}		

	if (item_arr.length == 0){
		alert(getMessage("ATLEAST_ONE_TRANS","ST"));
		return;
	}

	for (var i=0;i<item_arr.length ;i++ ){
		var item_batch = item_arr[i];

			if ((item_batch.item_qty == '' ) ||(parseFloat(item_batch.item_qty) == '0')){
				if (item_batch.item_qty == '' ){
					alert(getMessage("GRN_QTY_CANNOT_BLANK","ST"));
					eval("formObj.grn_item_qty_"+doc_no+"_"+i).focus();	
					return;
				}
				if (parseFloat(item_batch.item_qty) == '0'){
					alert(getMessage("GRN_QTY_CANNOT_ZERO","ST"));
					eval("formObj.grn_item_qty_"+doc_no+"_"+i).focus();	
					return;
				}
			}
			if(qty_override_yn=="W"){
					if(parseFloat(item_batch.item_qty) > parseFloat(item_batch.po_qty)){
					var confirmdate = confirm(" PO Quantity and GRN Quantity are not same. \n Do you wish to Continue?");
						if(!confirmdate){
						eval("formObj.grn_item_qty_"+doc_no+"_"+i).focus();	
						return;
						}
					}
			}
			else if(qty_override_yn=="E"){
					if(parseFloat(item_batch.item_qty) > parseFloat(item_batch.po_qty)){
						alert(" PO Quantity and GRN Quantity are not same.");
						eval("formObj.grn_item_qty_"+doc_no+"_"+i).focus();	
						return;
						}
			}


			if(item_batch.do_no !=  ""){
				for (var i=0;i<item_arr.length ;i++ ){
					var l_item_batch = item_arr[i];
					if(l_item_batch.do_no != ""  &&  l_item_batch.do_no != item_batch.do_no ) {
						alert("Selected items have multiple DO Numbers. Please select the Items having the same DO Number.");
						return;
					}
				}
			}

	}
	
	var loc_batch_string ="";
	var do_no="";
	for (var i=0;i<item_arr.length ;i++ ){
		var item_batch = item_arr[i];//here req_no need to be last because it will come null
		loc_batch_string = loc_batch_string+"||"+item_batch.item_code+";"+item_batch.item_qty+";"+item_batch.poitemStatus+";"+item_batch.req_no+";"+item_batch.do_no;
		if(item_batch.do_no != "" && item_batch.do_no != " ")
			do_no = item_batch.do_no;
	}
	
	formCriteria.loc_batch_string.value = loc_batch_string;	

	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getEnhancedXMLString(formCriteria));

	var selected_doc_no = formObj.selected_doc_no.value;
	var store_code      = formObj.store_code.value;

	xmlHttp.open("POST", "../../eST/jsp/GoodsReceivedNoteValidate.jsp?&doc_no="+selected_doc_no+"&validate=SET_PO_DETAILS&store_code="+store_code+"&nextdeldate="+nextdeldate+"&mode="+formObj.mode.value+"&pohdrStatus="+pohdrStatus, false);

	xmlHttp.send(xmlDoc);	
	responseText=xmlHttp.responseText;	
	eval(responseText);	
    if(result){	
		document.parentWindow.returnValue ="ADD"+"||"+pur_unit_code+"||"+doc_no+"||"+local_currency+"||"+trans_currency+"||"+conversion_rate+"||"+do_no+"||"+invoice_no+"||"+invoice_received_by;
		document.parentWindow.close();
		}else{
			if (message == "PHY_INV_PROCESS_INITIATED") {
				alert(getMessage(message, "ST") + "\n" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + formObj.phy_inv_id.value);
			} 
			else if(message == "PO_GRN_DOC_TYPE_DIFFERET"){
				
			}
			else{
				alert(getMessage(message, "ST"));
			}
		
	}
}



function calculateCostAndValue(obj) {
	formObj = parent.frameGoodsReceivedNoteList.frameGoodsReceivedNoteListHeader.document.formGoodsReceivedNoteListHeader;
	
	var no_of_decimals_for_cost = eval(formObj.no_of_decimals_for_cost.value);

	if (formObj.item_cost_value.value == "") {
		return;
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

		var item_cost ="";
		if(formObj.po_unit_cost_in_pur_uom.value != ""){
		 item_cost = parseFloat(formObj.po_unit_cost_in_pur_uom.value)  * parseFloat(obj.value);
		}else{
		 item_cost = parseFloat(formObj.user_grn_unit_cost_in_pur_uom.value)  * parseFloat(obj.value);
		}

		item_cost= setNumber(item_cost,no_of_decimals_for_cost);
		formObj.user_grn_unit_cost_in_pur_uom.value = item_cost;
		formObj.grn_unit_cost_in_pur_uom.value = item_cost;
		formObj.tmp_cost.value = item_cost;

		var item_value = parseFloat(item_cost) *  parseFloat(item_qty);
		formObj.item_cost_value.value = setNumber(item_value,no_of_decimals_for_cost);
}

function MandatoryChkForDelDate(batchcount){

	var formObj       = document.formPOItemDetailResult;
	var doc_no        = formObj.selected_doc_no.value ;	
	var check		  = false;
	// Added for IN:071539
	var multi_selct_appl=(formObj.multi_selct_appl_chk.value=="Y")
	if(multi_selct_appl){
	var myDate = new Date();
	var d = new Date(myDate.setDate(myDate.getDate() + 7));
	var day = d.getDate();
	var curr_month = d.getMonth();
	curr_month++;
	var curr_year = d.getFullYear();
	var weekDate =(day + "/" + curr_month + "/" + curr_year);
	}
	var count=batchcount;
    // Added for IN:071539
	for (var index=0;index<batchcount;index++ ){	

		var checkobj		= eval("formObj.doc_no_"+doc_no+"_"+index);
		var grn_item_qty	= eval("formObj.grn_item_qty_"+doc_no+"_"+index).value;
		var po_qty			= eval("formObj.po_qty_"+doc_no+"_"+index).value;
		
		if (checkobj!= undefined && checkobj.checked == true){			
			if(parseFloat(grn_item_qty) < parseFloat(po_qty)){
				eval(document.getElementById('img_next_del_date_'+doc_no)).style.visibility = "visible";
				// Added for IN:071539 START
				if(multi_selct_appl){
				eval(document.getElementById('next_del_date_'+doc_no)).value = weekDate;//Added for IN:071539
				}
				// Added for IN:071539 END
				check =  true;
			}else{
				if(!check){
					eval(document.getElementById('img_next_del_date_'+doc_no)).style.visibility = "hidden";
					if(multi_selct_appl){
					eval(document.getElementById('next_del_date_'+doc_no)).value = "";//Added for IN:071539
					}
				}
			}		
		}else if(checkobj.checked == false){
				eval(document.getElementById('img_next_del_date_'+doc_no)).style.visibility = "visible";
				// Added for IN:071539 START
				if(multi_selct_appl){
				eval(document.getElementById('next_del_date_'+doc_no)).value = weekDate;//Added for IN:071539
				var totalCheckobj = eval("formObj.doc_no1_"+doc_no);//Added for IN:071539
				 totalCheckobj.checked = false;//Added for IN:071539		
				
				}
				count=count-1;// Added for IN:071539
				// Added for IN:071539 END
				check =  true;
		}
	 }		
	 //Added for IN:071539 start	
	 if(multi_selct_appl){	
	if(count==0){
		//alert("Huli");
		eval(document.getElementById('img_next_del_date_'+doc_no)).style.visibility = "hidden";
		eval(document.getElementById('next_del_date_'+doc_no)).value = "";//Added for IN:071539
		eval(document.getElementById('apply_'+doc_no)).disabled = true;//Added for IN:071539
	}
	else if(count==batchcount){
		var totalCheckobj = eval("formObj.doc_no1_"+doc_no);//Added for IN:071539
		 totalCheckobj.checked = true;//Added for IN:071539
	}
	}
	 else{
		 if(count==0){
				eval(document.getElementById('img_next_del_date_'+doc_no)).style.visibility = "hidden";
				eval(document.getElementById('next_del_date_'+doc_no)).value = "";//Added for IN:071539
				eval(document.getElementById('apply_'+doc_no)).disabled = true;
	}
	}
	//Added for IN:071539 end
}

function CheckDelDateWithSysdate(obj,sys_date){	
	if(CheckDate(obj) && obj.value!=""){
		if (checkDateWithSysDate(obj,sys_date)){
			alert(getMessage("NEXT_DEL_DATE_CANNOT_LESS_SYS", "ST"));
			obj.focus();	
			return;
		}
	}
}

//Added by Padmapriya for INC #34926 on 21/11/2012
function ShowSelection(id)
{
  //var id = document.getElementById(id); commented by Ganga
  var selectedText;
  // IE version
  if (document.selection != undefined)
  {
    id.focus();
    var sel = document.selection.createRange();
    selectedText = sel.text;
  }
  // Mozilla version
  else if (id.selectionStart != undefined)
  {
    var startPos = id.selectionStart;
    var endPos = id.selectionEnd;
    selectedText = id.value.substring(startPos, endPos)
  }
   return selectedText;
}

async function DOBatchDetails(do_no,req_no,po_no,item_desc,item_code,po_srl_no) {
	if (do_no != "") {
		var retVal = "";
		var dialogHeight = "20vh";
		var dialogWidth = "60vw";
		var dialogTop = "210";
		var center = "1";
		var status = "no";
		var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments = "";
		var url = "../../eST/jsp/DOBatchDetails.jsp?do_no=" + do_no + "&req_no=" + req_no+ "&po_no=" + po_no+ "&po_srl_no=" + po_srl_no+ "&item_desc=" + encodeURIComponent(item_desc)+ "&item_code=" + item_code;
		retVal = await window.showModalDialog(url, arguments, features);	
		}
}
async function Load_DelieveryOrderDetails(obj,supp_code){
	//alert("show");
	if(supp_code.value==""){
		alert("APP-000001 Supplier Cannot be blank");
		return;
	}

	var store_code =document.formGoodsReceivedNoteHeader.store_code.value;
	var mode =document.formGoodsReceivedNoteHeader.mode.value;
	var do_no =document.formGoodsReceivedNoteHeader.do_no.value;
	var po_no =document.formGoodsReceivedNoteHeader.po_no.value;

	var local_currency="";
	var trans_currency="";
	var conversion_rate="";
	var invoice_no="";
	var invoice_received_by="";

	var retVal = "";
	var dialogHeight = "50vh";
	var dialogWidth = "70vw";
	var dialogTop = "210";
	var center = "1";
	var status = "no";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments = "";
	var url = "../../eST/jsp/DOItemDetailFrame.jsp?do_no=" + obj.value + "&supp_code="+supp_code.value + "&store_code="+store_code+ "&mode="+mode+ "&po_number="+po_no;
	retVal = await top.window.showModalDialog(url, arguments, features);	
	
	if (retVal!= null){
	 retValChk = (retVal.split("||"))[0];
	 do_no =(retVal.split("||"))[1];
	 local_currency =(retVal.split("||"))[2];
	 trans_currency =(retVal.split("||"))[3];
	 conversion_rate =(retVal.split("||"))[4];
	 po_no =(retVal.split("||"))[5];
	 invoice_no =(retVal.split("||"))[6];
	 invoice_received_by =(retVal.split("||"))[7];
     }
	if (retVal!= null && retValChk!= undefined && retValChk=="ADD") {	
		
		if(po_no != " " && po_no !="*A"){
			document.formGoodsReceivedNoteHeader.po_no.value = po_no;
			document.formGoodsReceivedNoteHeader.po_no.disabled = true;
		}else{
			document.formGoodsReceivedNoteHeader.po_no.value = "";
			document.formGoodsReceivedNoteHeader.po_no.disabled = false;
		}
		document.formGoodsReceivedNoteHeader.currency_code.value = trans_currency;
		document.formGoodsReceivedNoteHeader.currency_code.disabled = true;
		document.formGoodsReceivedNoteHeader.exchangerate.value = conversion_rate;
		//document.formGoodsReceivedNoteHeader.exchangerate.disabled = true;
		document.getElementById('localcurrency').innerText = trans_currency;
		document.formGoodsReceivedNoteHeader.grn_mode.value = "P";
		if(do_no != " " && document.formGoodsReceivedNoteHeader.do_no != undefined){
			document.formGoodsReceivedNoteHeader.do_no.value = do_no;		
			document.formGoodsReceivedNoteHeader.do_no.disabled = true;
			document.formGoodsReceivedNoteHeader.invoice_no.value = invoice_no;	
			document.formGoodsReceivedNoteHeader.invoice_received_by.value = invoice_received_by;	
			document.formGoodsReceivedNoteHeader.grn_mode.value = "D";	
		}

		parent.frameGoodsReceivedNoteDetail.location.href = "../../eST/jsp/GoodsReceivedNoteDetail.jsp?fm_store_code=" +store_code;
		parent.frameGoodsReceivedNoteList.location.href = "../../eST/jsp/GoodsReceivedNoteListFrame.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
		document.formGoodsReceivedNoteHeader.preview.disabled = false;
	}else{
	//alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
	}
}

function onadddo(batchcount){

    var formObj       = document.formDOItemDetailResult;
	var formCriteria  = parent.frameDOItemDetailCriteria.document.formDOItemDetailCriteria;	
	var doc_no        = formObj.selected_doc_no.value ;	
	var local_currency = "";
	var trans_currency = "";
	var conversion_rate = "";
	var invoice_no = "";
	var invoice_received_by = "";
	var item_arr   = new Array;
	var arrayIndex = 0;	

	for (var index=0;index<batchcount;index++ ){	

                var checkobj  = eval("formObj.doc_no_"+doc_no+"_"+index);

				if(eval("formObj.local_currency_"+doc_no+"_"+index)!= undefined)
                local_currency = eval("formObj.local_currency_"+doc_no+"_"+index).value;
				
				if (eval("formObj.trans_currency_"+doc_no+"_"+index)!= undefined)
				trans_currency = eval("formObj.trans_currency_"+doc_no+"_"+index).value;

				if (eval("formObj.conversion_rate_"+doc_no+"_"+index)!= undefined)
				conversion_rate = eval("formObj.conversion_rate_"+doc_no+"_"+index).value;

				if (eval("formObj.invoice_no_"+doc_no+"_"+index)!= undefined)
				invoice_no = eval("formObj.invoice_no_"+doc_no+"_"+index).value;

				if (eval("formObj.invoice_received_by_"+doc_no+"_"+index)!= undefined)
				invoice_received_by = eval("formObj.invoice_received_by_"+doc_no+"_"+index).value;
				
				if (checkobj!= undefined && checkobj.checked == true){
					
					var myClassObj = new ItemBatch();

					myClassObj.doc_no				= eval("formObj.doc_no_"+doc_no+"_"+index).value ;
					myClassObj.item_code			= eval("formObj.item_code_"+doc_no+"_"+index).value;
					myClassObj.item_qty             = eval("formObj.grn_item_qty_"+doc_no+"_"+index).value;
					myClassObj.do_srl_no             = eval("formObj.do_srl_no_"+doc_no+"_"+index).value;
					myClassObj.sch_date             = eval("formObj.sch_date_"+doc_no+"_"+index).value;
					myClassObj.batch_id             = eval("formObj.batch_id_"+doc_no+"_"+index).value;
					myClassObj.expiry_date             = eval("formObj.expiry_date_"+doc_no+"_"+index).value;

					if(eval("formObj.req_no_"+doc_no+"_"+index).value=="")
						eval("formObj.req_no_"+doc_no+"_"+index).value = " ";

					myClassObj.req_no				= eval("formObj.req_no_"+doc_no+"_"+index).value;

					if(eval("formObj.po_no_"+doc_no+"_"+index).value==""){
						eval("formObj.po_no_"+doc_no+"_"+index).value = " ";
						eval("formObj.po_srl_no_"+doc_no+"_"+index).value = " ";
					}

					myClassObj.po_no				= eval("formObj.po_no_"+doc_no+"_"+index).value;
					myClassObj.po_srl_no			= eval("formObj.po_srl_no_"+doc_no+"_"+index).value;

					item_arr[arrayIndex++]  = myClassObj;
				}		
		}		

	if (item_arr.length == 0){
		alert(getMessage("ATLEAST_ONE_TRANS","ST"));
		return;
	}

	for (var i=0;i<item_arr.length ;i++ ){
		var item_batch = item_arr[i];

			if ((item_batch.item_qty == '' ) ||(parseFloat(item_batch.item_qty) == '0')){
				if (item_batch.item_qty == '' ){
					alert(getMessage("GRN_QTY_CANNOT_BLANK","ST"));
					eval("formObj.grn_item_qty_"+doc_no+"_"+i).focus();	
					return;
				}
				if (parseFloat(item_batch.item_qty) == '0'){
					alert(getMessage("GRN_QTY_CANNOT_ZERO","ST"));
					eval("formObj.grn_item_qty_"+doc_no+"_"+i).focus();	
					return;
				}
			}

			if(item_batch.po_no !=  " " && item_batch.po_no !=  "" && item_batch.po_no !=  "*A"){
				for (var i=0;i<item_arr.length ;i++ ){
					var l_item_batch = item_arr[i];
					if(l_item_batch.po_no != "" && l_item_batch.po_no != "*A" &&  l_item_batch.po_no != item_batch.po_no ) {
						alert("Selected items have multiple PO Numbers. Please select the Items having the same PO Number.");
						return;
					}
				}
			}

	}
	
	var loc_batch_string ="";
	var po_no="";
	for (var i=0;i<item_arr.length ;i++ ){
		var item_batch = item_arr[i];

		loc_batch_string = loc_batch_string+"||"+item_batch.item_code+";"+item_batch.item_qty+";"+item_batch.do_srl_no+";"+item_batch.sch_date+";"+item_batch.batch_id+";"+item_batch.expiry_date+";"+item_batch.req_no+";"+item_batch.po_no+";"+item_batch.po_srl_no;

		if(item_batch.po_no != "" && item_batch.po_no != "*A")
			po_no = item_batch.po_no;
	}
	formCriteria.loc_batch_string.value = loc_batch_string;	

	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getEnhancedXMLString(formCriteria));

	var selected_doc_no = formObj.selected_doc_no.value;
	var store_code      = formObj.store_code.value;

	xmlHttp.open("POST", "../../eST/jsp/GoodsReceivedNoteValidate.jsp?&doc_no="+selected_doc_no+"&validate=SET_DO_DETAILS&store_code="+store_code+"&mode="+formObj.mode.value, false);

	xmlHttp.send(xmlDoc);	
	responseText=xmlHttp.responseText;	
	eval(responseText);	
    if(result){		
		document.parentWindow.returnValue ="ADD"+"||"+doc_no+"||"+local_currency+"||"+trans_currency+"||"+conversion_rate+"||"+po_no+"||"+invoice_no+"||"+invoice_received_by;
		document.parentWindow.close();
		}else{
			if (message == "PHY_INV_PROCESS_INITIATED") {
				alert(getMessage(message, "ST") + "\n" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + formObj.phy_inv_id.value);
			} else {
				alert(getMessage(message, "ST"));
			}
		
	}
}

function ReloadWindow(){
		var formObj =document.forms[0];

		  formObj.item_desc.value        =  "";
		  formObj.item_code.value        =  "";
		  formObj.do_no.value			 =  "";			  		  
		  formObj.from_doc_date.value	 = formObj.l_from_doc_date.value;
		  formObj.to_doc_date.value		 = formObj.l_to_doc_date.value;

		  if (formObj.doc_no != undefined)
		  {
		  formObj.doc_no.value			 =  "";
		  formObj.purchase_unit.value	 =  "";
		  }
  
		  formObj.search.click();
}

function getShelfLifeExpiryDate(expiry_date_object,i){

	var shelf_life_date = document.forms[0].shelfLifeDate;
	var toDateArray;
	var fromDateArray;
	var toDate = expiry_date_object;
	
	var fromDate = shelf_life_date.value;
	if (fromDate.length > 0 && toDate.length > 0) {
		toDateArray = fromDate.split("/");
		fromDateArray = toDate.split("/");
		var toDateObject = new Date(toDateArray[2], (toDateArray[1] - 1), toDateArray[0]);
		var fromDateObject = new Date(fromDateArray[2], (fromDateArray[1] - 1), fromDateArray[0]);
		  //Added by Rabbani #Inc no:40591 on 07-JUN-2013
		    parent.frameGoodsReceivedNoteListDetail.document.forms[0].elements["shelf_life_exp_date_" + i].value =
			parent.frameGoodsReceivedNoteListDetail.document.forms[0].elements["expiry_date_or_receipt_date_" + i].value;
		if (Date.parse(fromDateObject) <= Date.parse(toDateObject)) {
			var sh_life = confirm("Expiry Date "+toDate+" is not greater than the Shelf Life period "+fromDate+" . Do you want to Continue ? ");
			 
			if(sh_life == false){
			//	expiry_date_object.focus();
			parent.frameGoodsReceivedNoteListDetail.document.forms[0].elements["expiry_date_or_receipt_date_" + i].focus();
			 //Added by Rabbani #Inc no:40591 on 07-JUN-2013
			parent.frameGoodsReceivedNoteListDetail.document.forms[0].elements["shelf_life_exp_date_" + i].value = "";
 				return ;
			}	
		}
	}	
}
//Added by suresh.r 19-11-2013 against MMS-SCF-0166  beg
function validateSalePrice(sal_price){
	var unit_cost = eval(parent.parent.frameGoodsReceivedNoteList.frameGoodsReceivedNoteListHeader.document.formGoodsReceivedNoteListHeader.user_grn_unit_cost_in_pur_uom.value);
	var formObjDtl = parent.parent.frameGoodsReceivedNoteList.frameGoodsReceivedNoteListDetail.document.formGoodsReceivedNoteListDetail;
	if(sal_price!="" && formObjDtl.lesser_sale_price_yn.value == "Y"){
		var formObj = parent.frameGoodsReceivedNoteListHeader.formGoodsReceivedNoteListHeader;
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		var xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/GoodsReceivedNoteValidate.jsp?uom_code=" + formObj.uom_code.value + "&pur_uom_code=" + formObj.pur_uom_code.value + "&validate=GET_CONV_FACTOR" + "&item_code=" + formObj.item_code.value+"&store_code="+formObj.store_code.value+"&sal_price=" + sal_price + "&unit_cost=" + unit_cost+"&val_unitcost=Y", false);
		xmlHttp.send(xmlDoc);
		var responseText = trimString(xmlHttp.responseText);
		if(responseText=="NO"){
			alert(getMessage("SALE_PRICE_NOT_LESSER_UNIT_PRICE", "ST"));
			return false;
		}
	}
	return true;
}
//Added by suresh.r 19-11-2013 against MMS-SCF-0166  end
//Added for IN:071539
function setSelectedIndex(s, v) {

    for ( var i = 0; i < s.options.length; i++ ) {


        if ( s.options[i].value == v ) {//Changed Text to Value for NMC-JD-SCF-0326 supp code going wrongly
            s.options[i].selected = true;

            return;

        }

    }

}
function selectItems(object, batchcount,doc_no,index){
	var formObj = document.forms[0];
	var doc_no = doc_no;
	var ind =  index ;
	for (var index=0; index < batchcount; index++ ){
		var checkobj = eval("formObj.doc_no_"+doc_no+"_"+index);
		var itemQtyobj = eval("formObj.grn_item_qty_"+doc_no+"_"+index);
		var applyobj = eval("formObj.apply_"+doc_no);//Modified for IN:071539
		if(object.checked == true ){
			if (checkobj!= undefined && itemQtyobj!= undefined){
			checkobj.checked = true;
			itemQtyobj.value=eval("formObj.po_qty_"+doc_no+"_"+index).value;
			itemQtyobj.disabled=false;
			checkobj.disabled=false;			
			applyobj.disabled = false;
			eval(document.getElementById('img_next_del_date_'+doc_no)).style.visibility = "hidden";
			eval(document.getElementById('next_del_date_'+doc_no)).value = "";//Added for IN:071539
			}
			
		}
		else{
			if (checkobj!= undefined && itemQtyobj!= undefined){
				checkobj.checked = false;
				itemQtyobj.value="";
				itemQtyobj.disabled=true;
				checkobj.disabled=false;			
				applyobj.disabled = true;
				eval(document.getElementById('img_next_del_date_'+doc_no)).style.visibility = "hidden";
				eval(document.getElementById('next_del_date_'+doc_no)).value = "";//Added for IN:071539
				}
		}
		
	}
}
//Added for IN:071539 start
function diffDocType(grn_doc_type_desc,po_doc_type_desc){
	alert( getMessage("PO_GRN_DOC_TYPE_DIFFERET", "ST")+"\n"+"\n"+getLabel("eST.GRNDocType.label", "ST")+" : "+grn_doc_type_desc+"\n"+getLabel("eST.PODocType.label", "ST")+" :" );
}
//Added for IN:071539 end
//added for MO-CRF-20165 
function doDateCheckLocal(manu_date_object){
	var sys_date = document.forms[0].sys_date;
	var manufactured_date = manu_date_object.value;
	
	sys_date	= sys_date.value;    
	var flag = ChkDate(manufactured_date);
/*	if (!flag) {
		alert(getMessage("INVALID_DATE_FMT", "ST"));
		manufactured_date.select();
		manufactured_date.focus();
		return false; 
	}*/ //commented for MO-CRF-20165 
	if (flag) {
		if (!checkDateWithSysDate(manufactured_date, sys_date)) {
			alert(getMessage("ST_DATE_NOT_GRTR_FUTURE_DATE", "ST")); 
			//manufactured_date.select();//COMMENTED FOR 19510
			//manufactured_date.focus();
      parent.frameGoodsReceivedNoteListDetail.document.forms[0].elements["manufactured_date_" + i].value = "";  //19510
			return false;
		} else {
		} 
	}
} 

//MO-CRF-20165 - TFS:19510
function doDateCheckWithExpDate(entered_date, exp_date,i) {
	var enteredDateArray;
	var sysDateArray;
	var enteredDate = entered_date.value;
	var sysDate = exp_date.value; 
	if (enteredDate.length > 0 && sysDate.length > 0) {
		enteredDateArray = enteredDate.split("/");
		sysDateArray = sysDate.split("/");
		var enteredDateObject = new Date(enteredDateArray[2], (enteredDateArray[1] - 1), enteredDateArray[0]);
		var sysDateObject = new Date(sysDateArray[2], (sysDateArray[1] - 1), sysDateArray[0]);
		if (Date.parse(sysDateObject) < Date.parse(enteredDateObject)) {
			alert(getMessage("ST_DATE_NOT_GRTR_EXPIRY_DATE", "ST"));  
			parent.frameGoodsReceivedNoteListDetail.document.forms[0].elements["manufactured_date_" + i].value = "";  
			//document.formGoodsReceivedNoteListDetail.elements("manufactured_date_" + i).value = "";
			return false;
		} 
	}
}
async function showItemRemarks() {
	var rem = "";
	rem = await window.showModalDialog("../../eST/jsp/GoodsReceivedNoteItemRemarks.jsp?function_id=" + parent.parent.function_id, "", "dialogHeight:20vh; dialogWidth:30vw; center:0; status: no; dialogLeft :75; dialogTop :250;");

	if (rem != null) {
		document.formGoodsReceivedNoteListHeader.remarks.value = rem; 
	}
}

function checkManufacturerId(){ 
	var formObj = document.formGoodsReceivedNoteListHeader;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	var xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	//xmlHttp.open("POST", "../../eST/jsp/GoodsReceivedNoteValidate.jsp?uom_code=" + formObj.uom_code.value + "&pur_uom_code=" + formObj.pur_uom_code.value + "&validate=GET_CONV_FACTOR" + "&item_code=" + formObj.item_code.value+"&store_code="+formObj.store_code.value, false);//Commented by suresh.r 19-11-2013 against MMS-SCF-0166
	xmlHttp.open("POST", "../../eST/jsp/GoodsReceivedNoteValidate.jsp?" +"&validate=GET_MANUFACTURER" + "&item_code=" + formObj.item_code.value+"&val_unitcost=N", false);//Added by suresh.r 19-11-2013 against MMS-SCF-0166 
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	eval(responseText);
}//end
//23925 Start.
/*
function validateUploadImage(imageid){
	var inputFile = document.getElementById(imageid);
	if(''!=inputFile.value){	
		var objFSO = new ActiveXObject("Scripting.FileSystemObject");
		var objFile = objFSO.getFile(inputFile.value);
		var last_dot = (objFile.name).lastIndexOf('.');
		var ext = (objFile.name).slice(last_dot + 1);
		if(ext!='jpg' && ext!='JPG' && ext!='jpeg' && ext!='JPEG' && ext!='gif' && ext!='GIF' && ext!='pdf' && ext!='PDF'){
			//document.getElementById(imageid).innerHTML ="";
			alert('Invalid File Format. ');	
			try {
				document.getElementById(imageid).value = null;
			} catch(ex) { }
			if (document.getElementById(imageid).value) {
				document.getElementById(imageid).parentNode.replaceChild(document.getElementById(imageid).cloneNode(true), document.getElementById(imageid));
			}					
		}else{			
			var fileSize = objFile.size; //size in b	
			fileSize = fileSize / 1048576; //size in mb 
			if(fileSize>2){
				alert('File Size Exceeds 2 MB limit.');
				try {
					document.getElementById(imageid).value = null;
				} catch(ex) { }
				if (document.getElementById(imageid).value) {
					document.getElementById(imageid).parentNode.replaceChild(document.getElementById(imageid).cloneNode(true), document.getElementById(imageid));
				}
			}
		}
	}
   return true;	
}*/
function validateUploadImage(imageid) {
    var inputFile = document.getElementById(imageid);
    if (inputFile.files && inputFile.files[0]) {
        var file = inputFile.files[0];
        var ext = file.name.split('.').pop().toLowerCase(); // Get file extension in lowercase

        // Validate file extension
        if (['jpg', 'jpeg', 'gif', 'pdf'].indexOf(ext) === -1) {
            alert('Invalid File Format.');
            inputFile.value = ''; // Clear the file input
        } else {
            // Check file size (in MB)
            var fileSize = file.size / 1048576; // size in MB
            if (fileSize > 2) {
                alert('File Size Exceeds 2 MB limit.');
                inputFile.value = ''; // Clear the file input
            }
        }
    }
    return true;
}

//23925 End.

function getGTINDetails (e,barcode){//Adding start for MOHE-CRF-0167
	if(e.keyCode==9 || e.keyCode== 13  || e.keyCode== 0){
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		var item_code = document.formGoodsReceivedNoteListHeader.item_code.value;
		var store_code =parent.parent.frameGoodsReceivedNoteHeader.formGoodsReceivedNoteHeader.store_code.value;
		//xmlDoc.loadXML(getXMLString(null));
		var xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/GoodsReceivedNoteValidate.jsp?&barcode=" + barcode.value+"&item_code="+item_code +"&store_code="+store_code+"&validate=GET_GTIN", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if(result){
			callItemSearchScreen("BARCODE",barcode.value);
		}else{
			if(item_code==""){
			document.formGoodsReceivedNoteListHeader.barcode.value = "";
			 alert(getMessage(message, "ST"));
			}
		}
	}
}

function assignData(){
	var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		var item_code = document.formGoodsReceivedNoteListHeader.item_code.value;
		//xmlDoc.loadXML(getXMLString(null));
		var xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/GoodsReceivedNoteValidate.jsp?&item_code="+item_code +"&validate=ASSIGN_EXP", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
}//Adding end for MOHE-CRF-0167
