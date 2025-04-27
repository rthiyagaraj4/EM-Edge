/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
06/02/2017		IN0061112		Badmavathi B							GHL-CRF-0413 - Barcode search
24/08/2017		IN064209		Soorya Prakash M						GHL-CRF-0465
07/08/2020      IN073577        B Haribabu          07/08/2020                    MMS-DM-CRF-0174.2
07/09/2020      IN073938        B Haribabu          07/09/2020                    MMS-DM-CRF-0174.2
30/12/2020      TFSid:11896      B Haribabu          30/12/2020          ST-MMS-DM-CRF-0174.2/03(TF) - Request Issue
7/5/2022		TFS:30461		Shazana									MMS-MD-SCF-0204
---------------------------------------------------------------------------------------------------------
*/
//var for_bin_to_store = "";
var chk_req_flag = "flase";
async function deleterecord() {
	var errorPage = "../../eCommon/jsp/error.jsp";
	var formObj = f_query_add_mod.frameIssueHeader.document.formIssueHeader;
	var prevMode = formObj.mode.value;
	if (prevMode == MODE_INSERT) {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("OPER_CANCELLED", "ST");
		return;
	}
if(formObj.trn_type.value=="URG" && formObj.urg_delete_yn.value=="N"){
messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("NO_DELETE_ACCESS_FOR_USER", "ST");;
	formObj.mode.value = MODE_MODIFY;
		return false;
}

if(formObj.trn_type.value=="ISS" && formObj.iss_delete_yn.value=="N"){
messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("NO_DELETE_ACCESS_FOR_USER", "ST");;
	formObj.mode.value = MODE_MODIFY;
		return false;
}

	var result = await confirmDelete();
	if (result == "Yes") {
		f_query_add_mod.frameIssueHeader.document.formIssueHeader.mode.value = MODE_DELETE;
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
	f_query_add_mod.location.href = "../../eST/jsp/IssueFrame.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
}
function Modify(obj, checkYN, req_facility_id,siteSpecific,flag) {
	
	var errorPage = "../../eCommon/jsp/error.jsp";
	document.getElementById('readOnlyDiv').style.visibility='visible';
	parent.parent.messageFrame.location.href = errorPage + "?err_num="+getMessage("ST_PROCESSING_WAIT", "ST");
	var doc_no = obj.cells[1].innerText;
	var seq_no = obj.cells[2].innerText;
	
	if(siteSpecific=="true" && flag=="false"){
		
		var doc_type_code = obj.cells[8].innerText;
		var item_class_desc = obj.cells[7].innerText;
		}else{
		var doc_type_code = obj.cells[7].innerText;
		var item_class_desc = obj.cells[6].innerText;
		
	}
	
	parent.document.location.href = "../../eST/jsp/IssueFrame.jsp?mode=" + MODE_MODIFY + "&function_id=" + parent.parent.function_id + "&doc_type_code=" + doc_type_code + "&doc_no=" + doc_no + "&seq_no=" + seq_no + "&checkYN=" + checkYN + "&req_facility_id=" + req_facility_id + "&item_class_desc=" + item_class_desc;
}
function query() {
	f_query_add_mod.location.href = "../../eST/jsp/IssueQueryFrame.jsp?function_id=" + function_id;
//	f_query_add_mod.location.href="../../eST/jsp/IssueFrame.jsp?mode="+MODE_MODIFY+"&function_id="+function_id+"&doc_type_code=C1TFR&doc_no=165"; 
}
/*
function query() {
	var retVal=window.showModalDialog("../../eST/jsp/RequisitionIssueQueryFrame.jsp?function_id="+parent.parent.function_id,'','dialogHeight:28; dialogWidth:50; center:0; status: no; dialogLeft :35; dialogTop :100;');
	if (retVal != null) {
		f_query_add_mod.location.href="../../eST/jsp/RequisitionIssueFrame.jsp?mode="+MODE_MODIFY+"&function_id="+function_id+"&doc_type_code="+retVal[0]+"&doc_no="+retVal[1]+"&seq_no="+retVal[2];
	}
}
*/
function reset() {
	f_query_add_mod.location.reload();
}
function onSuccess() {
	f_query_add_mod.location.href = "../../eCommon/html/blank.html";
}
/*function searchPatient() {
	var patient_id = PatientSearch();
	var formObj = document.formIssueHeader;
	if (!((patient_id == null) || (patient_id == ""))) {
		formObj.patient_id.value = patient_id;
	}
	formObj.patient_id.focus();
}*/
async function callItemSearchScreen() {
	var search_string = "";
	if (!document.formIssueListHeader.item_desc.readOnly) {
		search_string = document.formIssueListHeader.item_desc.value;
	}
	var issue_history_durn = document.formIssueListHeader.issue_history_durn.value;//Added for MO-CRF-20166
	var store_code = parent.parent.frameIssueHeader.document.formIssueHeader.from_store_code.value;
	//var mode = parent.parent.frameIssueHeader.document.formIssueHeader.mode.value;
	var to_store_code = parent.parent.frameIssueHeader.document.formIssueHeader.to_store_code.value;
	var category = "A";
	var sole_source = "A";
	var ps_item = "A";
	var mfg_item = "A";
	var expiry = "A";
	var consignment = "A";
//	var havingqty="Y";
	/* Added on 5/31/2005 by Ram
		chkitemstorecmb is added to display the  item check check box in  item search  query criteria page and it is used to check the item which exist in both the stores.
		 If that check box is checked it will display the items which is associated in both the stores and also have qty_on_hand >0 . If  there is no to_store  code , then assign blank to it.
		 */

	var chkitemstorecmb = "Y";
	var kit = "Y";
	var item_class = parent.parent.frameIssueHeader.document.formIssueHeader.item_class_code.value;
	if (item_class == "null") {
		item_class = "";
	}
	//Modified by Sakti against AMS-CRF-0011 trn_type passing
	var retVal = await callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment,"URG", chkitemstorecmb, to_store_code, "", "", kit);
		if (retVal != null) {
		if (retVal[0] == "kit") {
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?kit_template_code=" + retVal[1] + "&validate=KIT_TEMPLATE&store_code=" + store_code+"&to_store_code="+to_store_code, false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			return;
		}
		parent.parent.frameIssueHeader.document.formIssueHeader.store_code_disabled.value = "disabled";
		document.formIssueListHeader.item_code.value = retVal[0];
		document.formIssueListHeader.item_desc.value = retVal[1];
		document.formIssueListHeader.item_desc.readOnly = true;
		document.formIssueListHeader.ItemDetails.disabled = false;
		document.formIssueListHeader.expiry_yn.value = retVal[2];
		document.formIssueListHeader.store_code.value = store_code;
//		document.formIssueListHeader.uom.value=retVal[15];
//		document.formIssueListHeader.document.getElementById("td_uom").innerHTML="<b>"+retVal[15]+"</b>";
		document.formIssueListHeader.uom_code.value = retVal[13];
		if(issue_history_durn !="")//Added for MO-CRF-20166
		document.getElementById('iss_history').style.visibility  = "visible";//Added for MO-CRF-20166
		
		/* @Name - Priya
		* @Date - 02/06/2010
		* @Inc# - 
		* @Desc - To round up id_item_unit_cost with no_of_decimals_for_cost 
		*/
		var no_of_decimals_for_cost = eval(document.formIssueListHeader.no_of_decimals_for_cost.value);
		var cost = setNumber(retVal[14], no_of_decimals_for_cost);
		document.getElementById('id_item_unit_cost').innerHTML = cost;
		document.formIssueListHeader.item_unit_cost.value = retVal[14];
		document.getElementById('id_uom').innerHTML = retVal[15];
		//document.getElementById('uom_desc').innerHTML=retVal[15];
		document.getElementById('uom_desc').innerHTML = retVal[25];
//		document.formIssueListHeader.trade_id_applicable_yn.value=retVal[17];
//		document.formIssueListHeader.batch_id_applicable_yn.value=retVal[18];
//		document.formIssueListHeader.uom_code.value=retVal[25];
		document.formIssueListHeader.dec_allowed_yn.value=retVal[27];
		document.formIssueListHeader.no_of_decimals.value=retVal[28];
		var formObj = document.formIssueListHeader;
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
		xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?item_code=" + formObj.item_code.value + "&store_code=" + store_code + "&item_qty=" + formObj.item_qty.value + "&to_store_code=" + to_store_code + "&validate=GET_STATUS" + "&uom_code=" + formObj.uom_code.value, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if (result) {
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?item_code=" + formObj.item_code.value + "&store_code=" + store_code + "&to_store_code=" + to_store_code + "&validate=MIN_MAX_STATUS", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
		}
		if (!result) {
			parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?";//err_num="+ getMessage(message);
			if (message == "PHY_INV_PROCESS_INITIATED") {
				alert(getMessage(message, "ST") + "\n" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + formObj.phy_inv_id.value);
			} else {
				alert(getMessage(message, "ST"));
			}
			refreshDetails();
		} else {
			document.formIssueListHeader.iss_uom_code.focus();
		}
		
		if (result && retVal[27] == "N") {
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?item_code=" + formObj.item_code.value + "&fm_store_code=" + store_code + "&to_store_code=" + to_store_code+"&issue_uom_code="+document.formIssueListHeader.iss_uom_code.value + "&validate=CONV_CALCULATE", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
		}

	}
//	checkUOMConvFactor();
}
/*function setStockDetails(_stock_item_yn, _store_item_unit_cost, _available_stock){
	document.getElementById('id_stock_available').innerText=_available_stock;
	document.getElementById('id_store_item_unit_cost').innerText=_store_item_unit_cost;
	document.formSalesListHeader.stock_item_yn.value=_stock_item_yn;
	if (_stock_item_yn=="Y") {
		if (_available_stock=="0"){
			alert(getMessage("STOCK_NOT_AVAILABLE"));
			parent.location.reload();
		}
	}
	else{
		document.formSalesListHeader.batchsearch.disabled=true;
		document.formSalesListHeader.edit.disabled=true;
	}
}
*/
function checkRemarksLength(obj) {
	if (!setTextAreaMaxLength(obj, 200)) {
		alert(getMessage("REMARKS_CHAR_EXCEEDS_LIMIT", "ST"));
		obj.focus();
	}
}
function setStockDetails(_stock_item_yn, _to_stock_item_yn, _store_item_unit_cost, _available_stock, _conv_factor) {
	//for_bin_to_store = _to_stock_item_yn;
	var formObj = "";
	if (document.formIssueListHeader == null || document.formIssueListHeader == undefined) {
		formObj = parent.frameIssueList.frameIssueListHeader;
	} else {
		formObj = parent.frameIssueListHeader;
	}
	formObj.document.formIssueListHeader.for_bin_to_store_hidden.value = _to_stock_item_yn;
	
	if(formObj.document.formIssueListHeader.dec_allowed_yn.value=="Y")
	formObj.document.getElementById('id_stock_available').innerText = parseFloat(_available_stock / _conv_factor).toFixed(formObj.document.formIssueListHeader.no_of_decimals.value);
	else
     formObj.document.getElementById('id_stock_available').innerText = parseFloat(_available_stock / _conv_factor).toFixed(0);
	//formObj.document.getElementById("lb_frm_store_qty_on_hand").innerText=(_available_stock/_conv_factor);
	formObj.document.getElementById('frm_store_qty_on_hand').value = parseFloat(_available_stock / _conv_factor).toFixed(formObj.document.formIssueListHeader.no_of_decimals.value);
	/* @Name - Priya
	* @Date - 02/06/2010
	* @Inc# - 
	* @Desc - As _store_item_unit_cost is rounded up in the validate jsp itself , the below code is commented
	*/
	//var unit_cost = setNumber(_store_item_unit_cost, 3);
	//formObj.document.getElementById("id_item_unit_cost").innerText = unit_cost;
	//formObj.document.getElementById("id_item_unit_cost").innerText = _store_item_unit_cost;
	//formObj.document.getElementById("item_unit_cost").value = _store_item_unit_cost;

	//Modified against inc#50521 to display base unit cost
	formObj.document.getElementById('id_item_unit_cost').innerText = setNumber(_store_item_unit_cost*_conv_factor,3);
	formObj.document.getElementById('id_item_unit_cost').title = _store_item_unit_cost*_conv_factor;

	formObj.document.getElementById('item_unit_cost').value = setNumber(_store_item_unit_cost*_conv_factor,3);

	formObj.document.formIssueListHeader.stock_item_yn.value = _stock_item_yn; 
	/*	alert("_to_stock_item_yn"+_to_stock_item_yn);
	if (_to_stock_item_yn=="N") {
		document.formIssueListHeader.batchsearch.disabled=true;
		document.formIssueListHeader.edit.disabled=true;
		alert(getMessage("NOT_STOCK_ITEM"));
		parent.location.reload();
	}
*/
	if (_stock_item_yn == "Y") {
		if (_available_stock == "0") {
		//	parent.location.reload();
		}
	} else {
		formObj.document.formIssueListHeader.batchsearch.disabled = true;
		formObj.document.formIssueListHeader.edit.disabled = true;
		//alert(getMessage("NOT_STOCK_ITEM"));
	//	parent.location.reload();
	}
}
function ComputeCost() {
	var quantity = document.formIssueListHeader.item_qty.value;
	var cost = document.getElementById('item_unit_cost').value;
	
	/* @Name - Priya
	* @Date - 02/06/2010
	* @Inc# - 
	* @Desc - To round up id_item_sal_value with no_of_decimals_for_cost 
	*/
	var no_of_decimals_for_cost = eval(document.formIssueListHeader.no_of_decimals_for_cost.value);
	if (isNaN(quantity) || isNaN(cost)) {
		document.getElementById('id_item_sal_value').innerText = "";
		return;
	}
	var value = (eval(quantity)/eval(document.formIssueListHeader.frm_conv_fact.value)) * cost;
	
	document.getElementById('id_item_sal_value').innerText = setNumber(value, no_of_decimals_for_cost);
}
function CheckQuantity() {
	if(document.formIssueListHeader.dec_allowed_yn.value=="Y"){
		if (!checkDoubleFormat(document.formIssueListHeader.iss_uom_qty)) {
			return false;
		}
	}else{
		if (!checkIntegerFormat(document.formIssueListHeader.iss_uom_qty)) {
			return false;
		}
	}
	//if (parseFloat(document.formIssueListHeader.item_qty.value) > (parseFloat(document.getElementById("id_stock_available").innerText) * eval(document.formIssueListHeader.iss_conv_fact.value))) {
	//commented for RUT-SCF-0291 [IN:043126] by Ganga and added below condition 
	
	
	//if (parseFloat(document.formIssueListHeader.item_qty.value) > (parseFloat(document.getElementById("id_stock_available").innerText) * eval(document.formIssueListHeader.batch_multiples.value))) {
		if (parseFloat(document.formIssueListHeader.item_qty.value) > (parseFloat(document.getElementById('id_stock_available').innerText) * eval(document.formIssueListHeader.frm_conv_fact.value))) {
		alert(getMessage("QTY_NOT_GRT_AVLQTY", "ST"));
		document.formIssueListHeader.iss_uom_qty.focus();
//		document.formIssueListHeader.item_qty.focus();
		document.formIssueListHeader.item_qty.value="";
		return false;
	}
	ComputeCost();
	return true;
}
function CheckDtlQuantity(index) {
	//alert(document.formIssueListDetail.dec_allowed_yn.value);
	if(document.formIssueListDetail.dec_allowed_yn.value=="Y"){
		if (!checkDoubleFormat(eval("document.formIssueListDetail.item_qty_" + index))) {
			return false;
		}
	}else{
		if (!checkIntegerFormat(eval("document.formIssueListDetail.item_qty_" + index))) {
			return false;
		}
	}/*commanded for GHL-CRF-0465-start
	if (parseFloat(eval("document.formIssueListDetail.item_qty_" + index + ".value")) > parseFloat(eval("document.getElementById('id_stock_avail_')" + index + ".innerText"))) {
		alert(getMessage("QTY_NOT_GRT_AVLQTY", "ST"));
		eval("document.formIssueListDetail.item_qty_" + index).focus();
		return false;
	} end GHL-CRF-0465*/
//added for GHl-CRf-0465 start
}
function CheckDtlQuantity1(index)
{
	if (parseFloat(eval("document.formIssueListDetail.item_qty_" + index + ".value")) > parseFloat(eval(document.getElementById('id_stock_avail_'+ index).innerText))) {
		
		if(parent.parent.frameIssueHeader.document.formIssueHeader.trn_type.value=="ISS"){
			 if(parent.frames[0].document.forms[0].auth_qty_1.value==parent.frames[0].document.forms[0].issue_qty_1.value){ //added for GHL-CRF-0465
		alert(getMessage("QTY_NOT_GRT_AVLQTY", "ST")+" for scanned/selected batch");
		var avail_val=eval("parent.frames[1].document.forms[0].item_qty_" + index) ;// addedd for available qty replacement GHL-CRF-0465 start
		avail_val.value=eval("parent.frames[1].document.forms[0].all.id_stock_avail_" + index + ".innerText");
		parent.frameIssueListHeader.document.formIssueListHeader.barcode.focus();
		}
		}else{
			 alert(getMessage("QTY_NOT_GRT_AVLQTY", "ST"));
				eval("document.formIssueListDetail.item_qty_" + index).focus();
		}
	}
}
//added for GHL-CRF-0465 start
function CumValue(index,obj)
{	
if(parent.parent.frameIssueHeader.document.formIssueHeader.trn_type.value=="ISS"){
	
var formObjDtl = parent.frames[1].document.forms[0];
	var _total_checkboxes = formObjDtl.total_checkboxes.value;// GHL-CRF-0465 END
	var no_of_decimals=formObjDtl.no_of_decimals.value;
	var old_qty = parent.frames[0].document.forms[0].auth_qty_1.value;//added for GHL-CRF-0465
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
	 if(parent.frames[0].document.forms[0].auth_qty_1.value==parent.frames[0].document.forms[0].issue_qty_1.value){//added for GHL-CRF-0465
	if(parseFloat(sum)>parseFloat(old_qty)){
		var confirm1=confirm(getMessage("ISS_QTY_EXCEED_AUTHORIZED_QTY", "ST"));
	}
	 }
	if(confirm1==false){
		var indexPosition=eval("document.formIssueListDetail.item_qty_" + index );
	indexPosition.value="";
	obj.focus();
	}
return false;
}
}//added for GHL-CRF-0465 end
function CheckValue() {
	if (document.formIssueListHeader.item_cost_value.value != null) {
		if (document.formIssueListHeader.item_cost_value.value == 0) {
			alert(getMessage("CANNOT_BE_ZERO", "Common"));
		}
	}
	if (isValidDouble(document.formIssueListHeader.quantity)) {
	}
	ComputeCost();
}
function addToList() {
	toConvFactor();
	var formObj = parent.frameIssueListHeader.document.formIssueListHeader;

    if(formObj.iss_uom_code.value == ""){
	alert("Issue Uom Cannot be blank..");
    formObj.iss_uom_code.focus();
    return;
	}
    var arrayObject;
    var names;
	if (parent.parent.frameIssueHeader.document.formIssueHeader.trn_type.value == "ISS" && document.formIssueListHeader.iss_uom_qty.value != "" && document.formIssueListHeader.iss_uom_qty.value != document.formIssueListHeader.iss_uom_qty_chk.value) {
		arrayObject = new Array(formObj.item_code, formObj.item_qty, formObj.remarks);
		names = new Array(getLabel("Common.item.label", "Common"), getLabel("Common.Quantity.label", "Common"), getLabel("Common.remarks.label", "Common"));
		document.formIssueListHeader.remarks_mandatory.style.visibility = "visible";
	} else {
		arrayObject = new Array(formObj.item_code, formObj.item_qty);
		names = new Array(getLabel("Common.item.label", "Common"), getLabel("Common.Quantity.label", "Common"));
	}
	var blankObject = checkSTFields(arrayObject, names, parent.parent.parent.messageFrame);
	if (parent.parent.frameIssueHeader.document.formIssueHeader.trn_type.value == "ISS" && document.formIssueListHeader.iss_uom_qty.value != "" && document.formIssueListHeader.iss_uom_qty.value != document.formIssueListHeader.iss_uom_qty_chk.value) {
		var formObject = document.formIssueListHeader;
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlStr = getXMLString(formObject);Commended by sakti due to problem for special character in remarks
		xmlStr = getEnhancedXMLString(formObject);
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?validate=SET_REMARKS", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
	}
	if (blankObject == true) {
		    //alert(parent.frameIssueListDetail.document.formIssueListDetail);
		if (parent.frameIssueListDetail.document.formIssueListDetail == null) {
			
			var formObj = document.formIssueListHeader;
			var store_code = parent.parent.frameIssueHeader.document.formIssueHeader.from_store_code.value;
			var _item_code = formObj.item_code.value;
			var item_qty = formObj.item_qty.value;
			var _remarks=formObj.remarks.value;
			var remarks_code=formObj.remarks_code.value;
			var mode = parent.parent.frameIssueHeader.document.formIssueHeader.mode.value;
			parent.frameIssueListDetail.location.href = "../../eST/jsp/IssueListDetail.jsp?function=edit&store_code=" + store_code + "&item_code=" + _item_code + "&item_qty=" + item_qty +"&remarks="+_remarks+"&remarks_code="+remarks_code+ "&function_id=" + parent.parent.function_id + "&kit=kit" + "&addToList=true";
			return;
		}
		var formObjDtl = parent.parent.frameIssueList.frameIssueListDetail.document.formIssueListDetail;
		var proceed = false;
		var messageFrame = parent.parent.messageFrame;
		var errorPage = "../../eCommon/jsp/error.jsp";
		var item_qty = formObj.item_qty.value;
		_total_checkboxes = formObjDtl.total_checkboxes.value;
		var sum = 0;
		var remarks_1 = formObj.remarks.value;
		var remarks_code = formObj.remarks_code.value;
		
		for (i = 0; i < _total_checkboxes; i++) {
			var qty = eval("formObjDtl.item_qty_" + i).value;
			if (qty == "") {
				qty = 0;
			}
			if (!isNaN(qty)) {
				sum += parseFloat(qty);
			}
			if (document.formIssueListHeader.for_bin_to_store_hidden.value != "N") {
				if (eval("formObjDtl.to_bin_location_code_" + i).value == "") {
					alert(getMessage("TO_BIN_LOC_NOT_BLANK", "ST"));
					return;
				}
			}
			/*	if ((eval("formObjDtl.item_qty_"+i).value)==""){
			alert(getMessage("QTY_TO_TFER_NOT_BLANK"));
			return;
		}*/
		}
		if(document.formIssueListHeader.dec_allowed_yn.value == "Y"){
			sum = sum.toFixed(document.formIssueListHeader.no_of_decimals.value);
		}
		if (sum != item_qty) {
			alert(getMessage("QUANTIY_MUST_BE_EQUAL", "ST"));
			return;
		}
	
		if (formObjDtl.batchsearch.value == "newbatch") {
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?validate=setnewbatch&index=" + formObj.index.value, false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			if (!result) {
				parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
				return;
			}
		}
	
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
			
		//xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?index=" + formObj.index.value + "&doc_srl_no=" + formObj.doc_srl_no.value + "&item_code=" + formObj.item_code.value + "&store_code=" + formObj.store_code.value + "&uom_code=" + formObj.uom_code.value + "&item_desc=" + encodeURIComponent(formObj.item_desc.value,"UTF-8") + "&item_qty=" + formObj.item_qty.value + "&item_unit_cost=" + document.getElementById("item_unit_cost").value + "&stock_item_yn=" + formObj.stock_item_yn.value + "&item_cost_value=" + document.getElementById("id_item_sal_value").innerText + "&expiry_yn=" + formObj.expiry_yn.value + "&uom_desc=" + document.getElementById("uom_desc").innerText + "&stock_uom_desc=" + encodeURIComponent(document.getElementById("id_uom").innerText,"UTF-8") + "&stock_available=" + document.getElementById("id_stock_available").innerText + "&validate=ADD_TO_LIST&for_bin_to_store_hidden=" + document.formIssueListHeader.for_bin_to_store_hidden.value + "&iss_uom_code=" + formObj.iss_uom_code.value + "&uom_conv_code=" + formObj.iss_conv_fact.value + "&iss_uom_qty=" + formObj.iss_uom_qty.value + "&expired_batch=" + formObjDtl.expired_batch.value + "&ex_param_days=" + formObjDtl.ex_param_days.value + "&frm_store_qty_on_hand=" + formObj.frm_store_qty_on_hand.value + "&frm_store_min_stk_level=" + formObj.frm_store_min_stk_level.value + "&frm_store_max_stk_level=" + formObj.frm_store_max_stk_level.value + "&frm_store_reorder_level=" + formObj.frm_store_reorder_level.value + "&to_store_qty_on_hand=" + formObj.to_store_qty_on_hand.value + "&to_store_min_stk_level=" + formObj.to_store_min_stk_level.value + "&to_store_max_stk_level=" + formObj.to_store_max_stk_level.value + "&to_store_reorder_level=" + formObj.to_store_reorder_level.value + "&to_conv_fact=" + formObj.tmp_conv.value + "&frm_conv_fact=" + formObj.frm_conv_fact.value + "&frm_store_uom_desc=" + formObj.frm_store_uom_desc.value + "&to_store_uom_desc=" + formObj.to_store_uom_desc.value + "&batch_records=" + formObjDtl.total_checkboxes.value + "&remarks=" + encodeURIComponent(formObj.remarks.value,"UTF-8")+"&kit_item_yn="+formObj.kit_item_yn.value+"&kit_template_uom="+formObj.kit_template_uom.value+ "&remarks_code=" + formObj.remarks_code.value+"&iss_uom_conv_text="+document.getElementById("id_iss_uom_conv").innerHTML+"&from_multiples="+formObj.from_multiples.value+"&to_multiples="+formObj.to_multiples.value+"&batch_multiples="+formObj.batch_multiples.value+"&issue_uom_multiples="+formObj.issue_uom_multiples.value+"&kit_temp_code="+formObj.kit_temp_code.value+"&usage_type="+formObj.usage_type.value+"&barcode_scanned_yn="+formObj.barcode_scanned_yn.value, false); 
		
       //Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014		
		//xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?index=" + formObj.index.value + "&doc_srl_no=" + formObj.doc_srl_no.value + "&item_code=" + formObj.item_code.value + "&store_code=" + formObj.store_code.value + "&uom_code=" + formObj.uom_code.value + "&item_desc=" + encodeURIComponent(formObj.item_desc.value,"UTF-8") + "&item_qty=" + formObj.item_qty.value + "&item_unit_cost=" + document.getElementById("item_unit_cost").value + "&stock_item_yn=" + formObj.stock_item_yn.value + "&item_cost_value=" + document.getElementById("id_item_sal_value").innerText + "&expiry_yn=" + formObj.expiry_yn.value + "&uom_desc=" + document.getElementById("uom_desc").innerText + "&stock_uom_desc=" + encodeURIComponent(document.getElementById("id_uom").innerText,"UTF-8") + "&stock_available=" + document.getElementById("id_stock_available").innerText + "&validate=ADD_TO_LIST&for_bin_to_store_hidden=" + document.formIssueListHeader.for_bin_to_store_hidden.value + "&iss_uom_code=" + formObj.iss_uom_code.value + "&uom_conv_code=" + formObj.iss_conv_fact.value + "&iss_uom_qty=" + formObj.iss_uom_qty.value + "&expired_batch=" + formObjDtl.expired_batch.value + "&ex_param_days=" + formObjDtl.ex_param_days.value + "&frm_store_qty_on_hand=" + formObj.frm_store_qty_on_hand.value + "&frm_store_min_stk_level=" + formObj.frm_store_min_stk_level.value + "&frm_store_max_stk_level=" + formObj.frm_store_max_stk_level.value + "&frm_store_reorder_level=" + formObj.frm_store_reorder_level.value + "&to_store_qty_on_hand=" + formObj.to_store_qty_on_hand.value + "&to_store_min_stk_level=" + formObj.to_store_min_stk_level.value + "&to_store_max_stk_level=" + formObj.to_store_max_stk_level.value + "&to_store_reorder_level=" + formObj.to_store_reorder_level.value + "&to_conv_fact=" + formObj.tmp_conv.value + "&frm_conv_fact=" + formObj.frm_conv_fact.value + "&frm_store_uom_desc=" + formObj.frm_store_uom_desc.value + "&to_store_uom_desc=" + formObj.to_store_uom_desc.value + "&batch_records=" + formObjDtl.total_checkboxes.value + "&remarks=" + encodeURIComponent(formObj.remarks.value,"UTF-8")+"&kit_item_yn="+formObj.kit_item_yn.value+"&kit_template_uom="+formObj.kit_template_uom.value+ "&remarks_code=" + formObj.remarks_code.value+"&iss_uom_conv_text="+document.getElementById("id_iss_uom_conv").innerHTML+"&from_multiples="+formObj.from_multiples.value+"&to_multiples="+formObj.to_multiples.value+"&batch_multiples="+formObj.batch_multiples.value+"&issue_uom_multiples="+formObj.issue_uom_multiples.value+"&kit_temp_code="+formObj.kit_temp_code.value+"&usage_type="+formObj.usage_type.value+"&barcode_scanned_yn="+formObj.barcode_scanned_yn.value+"&iss_item_hold_yn="+formObj.iss_item_hold_yn.value+"&iss_item_hold_qty="+formObj.iss_item_hold_qty.value+"&iss_item_hold_chk="+formObj.iss_item_hold_chk.value, false);
		//Commented and Added by suresh.r on 14-04-2014 against #048583(SKR-SCF-0986)
		
		xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?index=" + formObj.index.value + "&doc_srl_no=" + formObj.doc_srl_no.value + "&item_code=" + formObj.item_code.value + "&store_code=" + formObj.store_code.value + "&uom_code=" + formObj.uom_code.value + "&item_desc=" + encodeURIComponent(formObj.item_desc.value,"UTF-8") + "&item_qty=" + formObj.item_qty.value + "&item_unit_cost=" + document.getElementById('item_unit_cost').value + "&stock_item_yn=" + formObj.stock_item_yn.value + "&item_cost_value=" + document.getElementById('id_item_sal_value').innerText + "&expiry_yn=" + formObj.expiry_yn.value + "&uom_desc=" + encodeURIComponent(document.getElementById('uom_desc').innerText,"UTF-8") + "&stock_uom_desc=" + encodeURIComponent(document.getElementById('id_uom').innerText,"UTF-8") + "&stock_available=" + document.getElementById('id_stock_available').innerText + "&validate=ADD_TO_LIST&for_bin_to_store_hidden=" + document.formIssueListHeader.for_bin_to_store_hidden.value + "&iss_uom_code=" + formObj.iss_uom_code.value + "&uom_conv_code=" + formObj.iss_conv_fact.value + "&iss_uom_qty=" + formObj.iss_uom_qty.value + "&expired_batch=" + formObjDtl.expired_batch.value + "&ex_param_days=" + formObjDtl.ex_param_days.value + "&frm_store_qty_on_hand=" + formObj.frm_store_qty_on_hand.value + "&frm_store_min_stk_level=" + formObj.frm_store_min_stk_level.value + "&frm_store_max_stk_level=" + formObj.frm_store_max_stk_level.value + "&frm_store_reorder_level=" + formObj.frm_store_reorder_level.value + "&to_store_qty_on_hand=" + formObj.to_store_qty_on_hand.value + "&to_store_min_stk_level=" + formObj.to_store_min_stk_level.value + "&to_store_max_stk_level=" + formObj.to_store_max_stk_level.value + "&to_store_reorder_level=" + formObj.to_store_reorder_level.value + "&to_conv_fact=" + formObj.tmp_conv.value + "&frm_conv_fact=" + formObj.frm_conv_fact.value + "&frm_store_uom_desc=" + formObj.frm_store_uom_desc.value + "&to_store_uom_desc=" + formObj.to_store_uom_desc.value + "&batch_records=" + formObjDtl.total_checkboxes.value + "&remarks=" + encodeURIComponent(formObj.remarks.value,"UTF-8")+"&kit_item_yn="+formObj.kit_item_yn.value+"&kit_template_uom="+formObj.kit_template_uom.value+ "&remarks_code=" + formObj.remarks_code.value+"&iss_uom_conv_text="+encodeURIComponent(document.getElementById('id_iss_uom_conv').innerHTML,"UTF-8")+"&from_multiples="+formObj.from_multiples.value+"&to_multiples="+formObj.to_multiples.value+"&batch_multiples="+formObj.batch_multiples.value+"&issue_uom_multiples="+formObj.issue_uom_multiples.value+"&kit_temp_code="+formObj.kit_temp_code.value+"&usage_type="+formObj.usage_type.value+"&barcode_scanned_yn="+formObj.barcode_scanned_yn.value+"&iss_item_hold_yn="+formObj.iss_item_hold_yn.value+"&iss_item_hold_qty="+formObj.iss_item_hold_qty.value+"&iss_item_hold_chk="+formObj.iss_item_hold_chk.value, false);
		
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);

		if (result) {
			parent.parent.frameIssueHeader.formIssueHeader.preview.disabled = false;
			var arr = "";
			for (i = 0; i < parent.parent.frameIssueDetail.document.forms[0].total_checkboxes.value; i++) {
				if ((eval("parent.parent.frameIssueDetail.document.forms[0].checkbox" + i).checked)) {
					arr = arr + "," + "CHECKED";
				} else {
					arr = arr + "," + "s";
				}
			}
			parent.parent.frameIssueDetail.location.href = "../../eST/jsp/IssueDetail.jsp?function_id=" + parent.parent.function_id + "&index=" + formObj.index.value + "&arr=" + arr + "&tmp_conv=" + formObj.tmp_conv.value + "&kit12=" + formObj.kit.value+"&mode="+parent.parent.frameIssueHeader.document.formIssueHeader.mode.value+"&search_str="+encodeURIComponent(parent.parent.frameIssueDetail.document.formIssueDetail.search_str.value);
			refreshDetails();
		} else {
			parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
		}
		 
	}
	

}

// To refresh detail frame on click of Add 
function refreshDetails() {
	// doc_type_code, doc_no
	var mode = parent.parent.frameIssueHeader.document.formIssueHeader.mode.value;
	parent.frameIssueListHeader.location.href = "../../eST/jsp/IssueListHeader.jsp?mode=" + mode;
	parent.frameIssueListDetail.location.href = "../../eCommon/html/blank.html";
	parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
    // parent.frameIssueListDetail.location.href='../../eST/jsp/IssueListDetail.jsp';
    // parent.frameIssueListDetail.location.reload();
}
async function apply() {

     //Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014
     if(f_query_add_mod.frameIssueHeader.formIssueHeader.close_yn.checked && f_query_add_mod.frameIssueHeader.formIssueHeader.records_exist_seq_no.value  == "Y"){
	 
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage('CANNOT_CLOSE_MULTIPLE_SEQ_EXIST','ST');
			//messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + "APP-ST0215 Cannot 'Close Upon issue' as there are Unfinalized Issue sequence docs";
			//f_query_add_mod.frameIssueHeader.formIssueHeader.close_yn.checked = false;
			return;
		 
    }
	//Commented by Rabbani INC NO:34758(RUT-CRF-0082) on 07/02/2013
	//if (f_query_add_mod.frameIssueHeader.formIssueHeader.close_yn.checked) {
	 //Added by Rabbani INC NO:34758(RUT-CRF-0082) on 07/02/2013
	if (f_query_add_mod.frameIssueHeader.formIssueHeader.close_yn.checked || f_query_add_mod.frameIssueHeader.formIssueHeader.hdr_remarks_reqd.value == "Y") {
		if (f_query_add_mod.frameIssueHeader.formIssueHeader.remarks.value == "") {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("ADJ_REMARKS_NOT_BLANK", "ST");
			f_query_add_mod.frameIssueHeader.formIssueHeader.remarks.value = "";
			return;
		}
	} else {
			 //f_query_add_mod.frameIssueHeader.formIssueHeader.remarks.value = "" ;
	}
	var formObj = f_query_add_mod.frameIssueDetail.document.formIssueDetail;
	var remarks = formObj.remarks.value;
	
	//f_query_add_mod.frameIssueList.frameIssueListHeader.document.formIssueListHeader.remarks.value=remarks;
	//	var formObj=  parent.parent.frameIssueDetail.document.formIssueDetail; 
	totalCBox = parseInt(formObj.total_checkboxes.value);
	var checkBoxObj = null;
	var forDeletion = "";
	var noDetailExists = true;
	var errorPage = "../../eCommon/jsp/error.jsp";
	//Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014
	var holdcheckBox = null;
	var forhold = "";
	var hold_yn = "N";
	var noDetailholdExists = true;
	var chkdValue = 0;
	var chkditemvalue = 0;
	//ENDS
	for (i = 0; i < totalCBox; i++) {
		checkBoxObj = eval("formObj.checkbox" + i);
		if (checkBoxObj.checked) {
			forDeletion += ("Y,");
			chkdValue++;
		} else {
			forDeletion += ("N,");
			noDetailExists = false;
		}
	}
	if(f_query_add_mod.frameIssueHeader.formIssueHeader.trn_type.value == "ISS"){ //Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014
	for (i = 0; i < totalCBox; i++) {
	holdcheckBox = eval("formObj.hold_" + i);
	if (holdcheckBox.checked) {
		forhold += ("Y,");
		hold_yn = "Y";
		chkditemvalue++;
	}else{
		forhold += ("N,");
		noDetailholdExists = false;
	}
   }
  }
	
	if (noDetailExists) {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("MIN_ONE_DETAIL_REQUIRED", "Common");
		return;
	}
	//Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014
	if(f_query_add_mod.frameIssueHeader.formIssueHeader.trn_type.value == "ISS"){
	if(noDetailholdExists){
	messageFrame.location.href = errorPage + "?err_num=" + getMessage("MIN_ONE_DETAIL_REQUIRED", "Common");
		return;
	}
	if(totalCBox == chkdValue+chkditemvalue){
	messageFrame.location.href = errorPage + "?err_num=" + getMessage("MIN_ONE_DETAIL_REQUIRED", "Common");
	return;
	}
   }
   //ends
	//Added for RUT-CRF-0079
	if(f_query_add_mod.frameIssueDetail.formIssueDetail.validatebarcode.value=="true"  && f_query_add_mod.frameIssueHeader.formIssueHeader.mode.value =="2"){
		var confirmScannedBarcode = "Yes";
		for (var i = 0; i < f_query_add_mod.frameIssueDetail.formIssueDetail.total_checkboxes.value; i++) {	
				if (eval("f_query_add_mod.frameIssueDetail.formIssueDetail.barcode_item_exist_" + i).value != "M") {
					 // confirmScannedBarcode = confirm(getMessage("BARCODE_SCANNING_NOT_COMPLETE","ST"));
					  confirmScannedBarcode = await confirmYesNo(getMessage("BARCODE_SCANNING_NOT_COMPLETE","ST"));
					  break;
				}
		}
		if(confirmScannedBarcode=="No" || confirmScannedBarcode==""){
			messageFrame.location.href = errorPage + "?err_num=";
			return;
		}//ended
	}
	for (i = 0; i < f_query_add_mod.frameIssueDetail.document.formIssueDetail.total_checkboxes.value; i++) {
		if ((eval("f_query_add_mod.frameIssueDetail.document.formIssueDetail.checkbox" + i).checked)) {
		} else {
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?validate=ZERO_QUANTITY&index=" + i, false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			if (!result) {
				messageFrame.location.href = errorPage + "?err_num=" + getMessage("ISS_QTY_CANNOT_BE_ZERO", "ST");
				return;
			}
		}
	}
	var formObj = f_query_add_mod.frameIssueHeader.document.formIssueHeader;
	 //Commented by Rabbani INC NO:34758(RUT-CRF-0082) on 07/02/2013
	//if(formObj.close_yn.value=="Y"){
	//Added by Rabbani INC NO:34758(RUT-CRF-0082) on 07/02/2013
	if(formObj.close_yn.value=="Y" || formObj.hdr_remarks_reqd.value=="Y"){ 
		var fields = new Array(formObj.remarks);
		var names = new Array(getLabel("Common.remarks.label", "Common"));
		blankObject = checkSTFields(fields, names, messageFrame, errorPage);
		if(!blankObject){
			return;
		}
	}
	forDeletion = forDeletion.substring(0, forDeletion.length - 1);
	formObj.records_to_delete.value = forDeletion;
	
	if(f_query_add_mod.frameIssueHeader.formIssueHeader.trn_type.value == "ISS"){ //Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014
	forhold = forhold.substring(0, forhold.length - 1);
	formObj.records_to_hold.value = forhold; 
	
	formObj.hold_yn.value = hold_yn; 
	}  
	
	finalizeType = "N";
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	var validate_for_bin_to_store_hidden = "Y";// f_query_add_mod.frameIssueList.frameIssueListHeader.formIssueListHeader.for_bin_to_store_hidden.value;	
	var arr = "";
	for (i = 0; i < f_query_add_mod.frameIssueDetail.document.formIssueDetail.total_checkboxes.value; i++) {
		if ((eval("f_query_add_mod.frameIssueDetail.document.formIssueDetail.checkbox" + i).checked)) {
			arr = arr + "," + "CHECKED";
		} else {
			arr = arr + "," + "s";
		}
	}
	xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?validate=VALIDATE_DATA&for_bin_to_store_hidden=" + validate_for_bin_to_store_hidden, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	if (!result) {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST") + " " + getLabel("eST.forItemCode.label", "ST") + " - " + flag;
		return;
	}

	if (result) {
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?validate=CHECK_AUTHORIZE_ALLOWED&store_code=" + formObj.from_store_code.value, false);
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
			if(response==""){
				messageFrame.location.href = errorPage + "?err_num=";
				return;
			}

			if (response == YES) {
				formObj.finalize_yn.value = YES;
			} else {
				formObj.finalize_yn.value = NO;
			}
		}
		
		var responseText = formApply(formObj, ST_CONTROLLER);
		eval(responseText);
		flag1 = (flag.split("~"))[0];
		flag2 = (flag.split("~"))[1];
		flag1 = (flag1 == "null" ? "" : flag1);

		if (result) {
			if (flag2 == "PY") {
			//	  if(formObj.finalize_allowed_yn.value=="Y")
				  //{
				var PConfirm = confirmPrinting();
				if (PConfirm == "Yes") {
					var xmlHttp = new XMLHttpRequest();
					var xmlDoc="";
					//xmlDoc.loadXML(getXMLString(null));
					xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
					//xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?validate=printOnlineDoc&msg=" + encodeURIComponent(message), false);
					xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?validate=printOnlineDoc&msg=" + encodeURIComponent(message), true);
					xmlHttp.send(xmlDoc);
					//responseText = xmlHttp.responseText;
					//eval(responseText);
				} else {
					messageFrame.location.href = errorPage + "?err_num=" + message;
				}
				  //}
			}else 	if (flag2 == "PN") {
		
					var xmlHttp = new XMLHttpRequest();
					var xmlDoc="";
					//xmlDoc.loadXML(getXMLString(null));
					xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
					//xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?validate=printOnlineDoc&msg=" + encodeURIComponent(message), false);
					xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?validate=printOnlineDoc&msg=" + encodeURIComponent(message), true);
					xmlHttp.send(xmlDoc);
					//responseText = xmlHttp.responseText;
					//eval(responseText);
			}
			messageFrame.location.href = errorPage + "?err_num=" + message + "<BR>" + (result ? flag1 : "");
			onSuccess();
		} else {
		 
			var mess = message;
			if (flag != "") {
				//xmlDoc.loadXML(getXMLString(null));
				xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
				xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?validate=GET_INDEX&item_code=" + flag, false);
				xmlHttp.send(xmlDoc);
				responseText = xmlHttp.responseText;
				eval(responseText);
				//f_query_add_mod.frameIssueDetail.location.href = "../../eST/jsp/IssueDetail.jsp?function_id=" + function_id + "&index=" + message + "&arr=" + arr+"&mode="+parent.parent.frameIssueHeader.document.formIssueHeader.mode.value+"&search_str="+encodeURIComponent(f_query_add_mod.frameIssueDetail.document.formIssueDetail.search_str.value);
				//Modified by suresh.r on 05-02-2015 against GHL-SCF-865
				f_query_add_mod.frameIssueDetail.location.href = "../../eST/jsp/IssueDetail.jsp?function_id=" + function_id + "&index=" + message + "&arr=" + arr+"&mode="+f_query_add_mod.frameIssueHeader.formIssueHeader.mode.value+"&search_str="+encodeURIComponent(f_query_add_mod.frameIssueDetail.document.formIssueDetail.search_str.value);
                    // messageFrame.location.href = errorPage+"?err_num="+ getMessage(message)  ;
			}
			messageFrame.location.href = errorPage + "?err_num=" + mess;
		}
	} else {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST") + getLabel("eST.forItemCode.label", "ST") + " - " + flag;
		/*xmlDoc.loadXML(getXMLString(null));
				xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?validate=GET_INDEX&item_code="+flag, false);
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText;
				eval(responseText);
			*/
		//f_query_add_mod.frameIssueDetail.location.href = "../../eST/jsp/IssueDetail.jsp?function_id=" + function_id+"&mode="+parent.parent.frameIssueHeader.document.formIssueHeader.mode.value+"&search_str="+encodeURIComponent(f_query_add_mod.frameIssueDetail.document.formIssuedetail.search_str.value);
		//Modified by suresh.r on 05-02-2015 against GHL-SCF-865
		f_query_add_mod.frameIssueDetail.location.href = "../../eST/jsp/IssueDetail.jsp?function_id=" + function_id+"&mode="+f_query_add_mod.frameIssueHeader.formIssueHeader.mode.value+"&search_str="+encodeURIComponent(f_query_add_mod.frameIssueDetail.formIssueDetail.search_str.value);
	}
}
function cancel_me() {
	parent.frameIssueListHeader.location.href = "../../eST/jsp/IssueListHeader.jsp";
	parent.parent.frameIssueList.frameIssueListDetail.location.href = "../../eCommon/html/blank.html";
	//Added for GHL-CRF-0413 starts
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?validate=clearTmpBean", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	//Added for GHL-CRF-0413 ends
}
function editViewBatch() {
	var formObj = document.formIssueListHeader;//parent.frameIssueListHeader.formIssueListHeader;
	var arrayObject = new Array(formObj.item_code, formObj.item_qty);
	var names = new Array(getLabel("Common.item.label", "Common"), getLabel("Common.Quantity.label", "Common"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.parent.messageFrame);
	if (blankObject == true) {
		var store_code = parent.parent.frameIssueHeader.document.formIssueHeader.from_store_code.value;
		var _item_code = formObj.item_code.value;
		var item_qty = formObj.item_qty.value;
		parent.frameIssueListDetail.location.href = "../../eST/jsp/IssueListDetail.jsp?function=edit&store_code=" + store_code + "&item_code=" + _item_code + "&item_qty=" + item_qty + "&function_id" + parent.parent.function_id;
	}
}
async function callBatchSearch() {
	var formObj = document.formIssueListHeader;//parent.frameIssueListHeader.formIssueListHeader;
	var arrayObject = new Array(formObj.item_code, formObj.item_qty);
	var names = new Array(getLabel("Common.item.label", "Common"), getLabel("Common.Quantity.label", "Common"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.parent.messageFrame);
	if (blankObject == true) {
//	var objForm=parent.frameUrgentIssueListHeader.formUrgentIssueListHeader;
		var store_code = parent.parent.frameIssueHeader.document.formIssueHeader.from_store_code.value;
		var formObj1 = parent.parent.frameIssueHeader.document.formIssueHeader;
		var _item_code = formObj.item_code.value;
		var item_qty = formObj.item_qty.value;
		var includeZeroStockBatches = "N";
		var includeExpiredBatches = "N";
		var includeSuspendedBatches = "N";
		var searchFunction = "Y";
		var multipleSelect = "Y";
		var retval = await callBatchSearchWindow(_item_code, store_code, includeZeroStockBatches, includeExpiredBatches, includeSuspendedBatches, searchFunction, multipleSelect, "", formObj1.doc_type_code.value, formObj1.doc_no.value, formObj1.trn_type.value);
		if (retval != null && retval!="" && retval!=undefined) {
			parent.frameIssueListDetail.location.href = "../../eST/jsp/IssueListDetail.jsp?function=search&batchsearch=newbatch&store_code=" + store_code + "&item_code=" + _item_code + "&item_qty=" + item_qty + "&function_id" + parent.parent.function_id + "&index=" + formObj.index.value + "";
//		parent.frameUrgentIssueListDetail.location.href="../../eST/jsp/GeneralBatchList.jsp?Param=BATCH";
		} else {
		//blankObject.focus();
		}
	}
}
var prevObj = null;
var prevColor = null;
function changeRowColor(obj,index) {
	if (prevObj != null) {
		//Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-FEB-2014
		var n = 2;;
		if(parent.frameIssueHeader.document.formIssueHeader.trn_type.value == "ISS")
			n =3;

			
		//for (var k = 0; k < 2; k++) {
		for (var k = 0; k < n; k++) { //Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-FEB-2014
			if(prevObj.cells[k].className !="FOREDITOR")//added for RUT-CRF-0079 By Ganga on 1st AUG 2013 
				prevObj.cells[k].className = prevColor;
		}
	}
	prevObj = obj;
	prevColor = obj.cells[1].className;
	 
	//for (var k = 0; k < 2; k++) {
		for (var k = 0; k < n; k++) { //Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-feb-2014
		if (eval("document.formIssueDetail.barcode_item_exist_"+index)!= undefined && eval("document.formIssueDetail.barcode_item_exist_"+index).value=="M")//added for RUT-CRF-0079 By Ganga on 1st AUG 2013 
			obj.cells[k].className = "FOREDITOR";
		else
			obj.cells[k].className = "STLIGHTPINK";
	}
}
function modifyData(index,barcode_scanned_yn) {
	//kitGetStatus(item_code);
	var to_store_code = parent.frameIssueHeader.document.formIssueHeader.to_store_code.value;
	var trObject = eval(document.getElementById('tr_' + index));
	changeRowColor(trObject,index);
	parent.frameIssueList.location.href = "../../eST/jsp/IssueListFrame.jsp?function=modify&index=" + index + "&function_id" + parent.parent.function_id + "&to_store_code=" + to_store_code + "&BARCODE_YN=" + document.formIssueDetail.BARCODE_YN.value+ "&barcode_scanned_yn=" + barcode_scanned_yn + "&mode=" + parent.frameIssueHeader.document.formIssueHeader.mode.value;
}
function setFinalize_allowed(_finalize_allowed_yn) {
	f_query_add_mod.frameIssueHeader.document.formIssueHeader.finalize_allowed_yn.value = _finalize_allowed_yn;
}
async function showRemarks() {   
  var close_yn         =  document.formIssueHeader.close_yn.value;
  var hdr_remarks_reqd = document.formIssueHeader.hdr_remarks_reqd.value;
	var rem = "";
	rem = await window.showModalDialog("../../eST/jsp/IssueRemarks.jsp?function_id=" + parent.parent.function_id+ "&close_yn="+ close_yn + "&hdr_remarks_reqd=" +hdr_remarks_reqd, "", "dialogHeight:30vh; dialogWidth:35vw; center:0; status: no; dialogLeft :75; dialogTop :250;");
	 while(rem == undefined){
		alert('Please Press Close Button');
	rem = await window.showModalDialog("../../eST/jsp/IssueRemarks.jsp?function_id=" + parent.parent.function_id+ "&close_yn="+ close_yn + "&hdr_remarks_reqd=" +hdr_remarks_reqd, "", "dialogHeight:30vh; dialogWidth:35vw; center:0; status: no; dialogLeft :75; dialogTop :250;");
	}
	if (rem != null) {
		document.formIssueHeader.remarks.value = rem;
	}
}
function updateRemarks() {
	formObject = document.formIssueRemarks;
	if (!setTextAreaMaxLength(formObject.remarks, 201)) {
		alert(getMessage("REMARKS_NOT_EXCEED_200_CH", "Common"));
		return;
	}
	if(formObject.close_yn.value == "Y" || formObject.hdr_remarks_reqd.value == "Y" ){
	if (!checkField(formObject.remarks, getLabel("Common.remarks.label", "Common"))) {
		return;
	}
	}
	/*if (formObject.remarks.value == "") {
		alert(getMessage("SHOULD_NOT_BE_BLANK","Common"));
		return;
	}*/
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlStr = getXMLString(formObject); //Commented by Sakti Sankar against Inc#37941
	xmlStr = getEnhancedXMLString(formObject); //Added by Sakti Sankar against Inc#37941
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?validate=SET_REMARKS", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	window.returnValue = formObject.remarks.value;
	window.close();
}
function setCloseYN() {
       
	var close_yn = "";
	//Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 12-Feb-2014 Starts
	  if(document.formIssueHeader.close_yn.checked){
	    if(document.formIssueHeader.trn_type.value == "ISS"){
		if(document.formIssueHeader.records_exist_seq_no.value  == "Y"){
			alert(getMessage('CANNOT_CLOSE_MULTIPLE_SEQ_EXIST','ST'));
			//alert("APP-ST0215 Cannot 'Close Upon issue' as there are Unfinalized Issue sequence docs");
			document.formIssueHeader.close_yn.checked = false;
			return;
		}
		
			var formobjDtl = parent.frameIssueDetail.document.formIssueDetail;
			var totalCBox = formobjDtl.total_checkboxes.value;
			var  iss_close_yn = "Y";
			var  iss_close_count = 0;
			for (i = 0; i < totalCBox; i++) {
				if(eval("formobjDtl.hold_" + i).checked){
				alert(getMessage('CANNOT_CLOSE_HOLD_ITEMS_EXIST','ST'));
				//alert("APP-ST0216 Cannot 'Close Upon issue' as there are Items marked On Hold");  
				document.formIssueHeader.close_yn.checked = false;
				iss_close_yn = "N";
				iss_close_count++;
          	    return;
				}
			 }
			 if(iss_close_yn == "N" || iss_close_count == 0){
			 for (i = 0; i < totalCBox; i++) {
			    //eval("formobjDtl.hold_" + i).checked = false;
			    eval("formobjDtl.hold_" + i).disabled = true;
			   // eval("formobjDtl.checkbox" + i).checked = false;
			   // eval("formobjDtl.checkbox" + i).disabled = true;	    
 		  }
		 }
	  }
   }else{
		if(document.formIssueHeader.trn_type.value == "ISS"){
			var formobjDtl = parent.frameIssueDetail.document.formIssueDetail;
			var totalCBox = formobjDtl.total_checkboxes.value;
			for (i = 0; i < totalCBox; i++) {
				// eval("formobjDtl.checkbox" + i).disabled = false;
				if(eval("formobjDtl.item_hold_close_yn_" + i).value == "Y")
			    eval("formobjDtl.hold_" + i).disabled = false;
 		    }
	     } 	
	 } //ends  MO-CRF-20048
	
	//Commented by Rabbani INC NO:34758(RUT-CRF-0082) on 07/02/2013
	//if (document.formIssueHeader.close_yn.checked) {
	//Added by Rabbani INC NO:34758(RUT-CRF-0082) on 07/02/2013
	if (document.formIssueHeader.close_yn.checked || document.formIssueHeader.hdr_remarks_reqd.value == "Y") { 
		document.getElementById('remarks_jif').style.visibility = "visible";
		document.formIssueHeader.close_yn.value = "Y";
		close_yn = "Y";
	} else {
		document.getElementById('remarks_jif').style.visibility = "hidden";
		document.formIssueHeader.close_yn.value = "N";
		close_yn = "N";
	}
	//parent.frameIssueDetail.document.formIssueDetail.close_yn.value = close_yn;	
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?close=" + close_yn + "&validate=SET_CLOSE_YN", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
}

//code added for displaying conv.factor...
function checkUOMConvFactor() {
	var formObj = document.formIssueListHeader;
	
	//if (formObj.uom_code.value == formObj.iss_uom_code.value) {
	//	setUOMIssConvFactor("1");
	//	return;
	//}
	//alert(parent.parent.frameIssueHeader.document.formIssueHeader.from_store_code.value);
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?uom_code=" + formObj.uom_code.value + "&iss_uom_code=" + formObj.iss_uom_code.value + "&validate=setUOM" + "&item_code=" + formObj.item_code.value+"&store_code="+parent.parent.frameIssueHeader.document.formIssueHeader.from_store_code.value, false);
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	eval(responseText);
	if (!result) {
		parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "ST");
	
		//formObj.iss_uom_code.value=formObj.uom_code.value;
		formObj.iss_uom_code.focus();
		document.getElementById('id_iss_uom_conv').innerHTML = "";
		//setUOMIssConvFactor("1");
	}
}
function toConvFactor() {
	var formObj = document.formIssueListHeader;
	var item_code = "";
	if (formObj == null) {
		formObj = parent.frames[2].frames[0].document.formIssueListHeader;
		var to_store_code = parent.frameIssueHeader.document.formIssueHeader.to_store_code.value;
		var store_code = parent.frameIssueHeader.document.formIssueHeader.from_store_code.value;
	} else {
		var to_store_code = parent.parent.frameIssueHeader.document.formIssueHeader.to_store_code.value;
		var store_code = parent.parent.frameIssueHeader.document.formIssueHeader.from_store_code.value;
	}
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	item_code = formObj.item_code.value;
	if (parent.frameIssueDetail != null) {
		var formObj1 = parent.frameIssueDetail.document.formIssueDetail;
		item_code = formObj1.item_code.value;
	}
	xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?validate=setToConv" + "&to_store_code=" + to_store_code + "&store_code=" + store_code + "&item_code=" + item_code + "&iss_uom_code=" + formObj.iss_uom_code.value, false);
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	eval(responseText);
}
function setUOMIssConvFactor(_value) {
	document.getElementById('id_iss_uom_conv').innerHTML = _value;
	document.formIssueListHeader.iss_conv_fact.value = _value;
	document.formIssueListHeader.iss_uom_conv.value = _value;
}
function issueUOMQtyChk() {
	var formObj = document.formIssueListHeader;
	var allow_yn = formObj.dec_allowed_yn.value;
	if(allow_yn=="N"){
		return true;
	}
	toConvFactor();
	var dec_allowed_yn =document.formIssueListHeader.dec_allowed_yn.value;
	if(dec_allowed_yn=="N")
	{
	var conv_factor = lcm(formObj.frm_conv_fact.value, formObj.tmp_conv.value);
	// To be changed for 537.3 Ramana C 3/19/2010
	var dec_factor = (formObj.item_qty.value) % (conv_factor);
	if (dec_factor > 0 && conv_factor > 1) {
		alert("Quantity Should Be In Multiples Of " + conv_factor);
		return false;
	}else
		return true;
	}
		return true;
	
}
function setTempConvFactor(tmp) {
	if (document.formIssueListHeader == null) {
		parent.frames[2].frames[0].document.formIssueListHeader.tmp_conv.value = tmp;
	} else {
		document.formIssueListHeader.tmp_conv.value = tmp;
	}
}
function setFrmTempConvFactor(tmp) {
	if (document.formIssueListHeader == null) {
		parent.frames[2].frames[0].document.formIssueListHeader.frm_conv_fact.value = tmp;
	} else {
		document.formIssueListHeader.frm_conv_fact.value = tmp;
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
function calIssueQty() {
	
	var formObj = document.formIssueListHeader;
	
	 
	if(formObj.dec_allowed_yn.value=="N"){
		if (formObj.iss_uom_qty.value != ""){
			if(formObj.iss_uom_qty.value%formObj.issue_uom_multiples.value !=0){
					alert("Issue UOM Quantity Should Be In Multiples Of "+formObj.issue_uom_multiples.value);
					//formObj.iss_uom_qty.focus();
					formObj.item_qty.value = "";
			}else{
				formObj.item_qty.value = (formObj.iss_uom_qty.value * formObj.batch_multiples.value)/formObj.issue_uom_multiples.value ;
								
					if(formObj.bar_or_item_code.value=="B" &&  parent.frames[1].document.forms[0]!=undefined && parent.frames[1].document.forms[0].total_checkboxes.value==1){
					parent.frames[1].document.forms[0].item_qty_0.value =formObj.item_qty.value;
					CheckDtlQuantityBarcode(0);
					}
			}
		}
	}else{
		formObj.item_qty.value = "";
		if (formObj.iss_uom_qty.value == "" || document.getElementById('id_iss_uom_conv').innerText == "") {
		} else {
			//if(formObj.dec_allowed_yn.value=='Y')
			formObj.item_qty.value = (parseFloat(formObj.iss_uom_qty.value) * parseFloat(formObj.iss_uom_conv.value)).toFixed(formObj.no_of_decimals.value);
					if(formObj.bar_or_item_code.value=="B" &&  parent.frames[1].document.forms[0]!=undefined && parent.frames[1].document.forms[0].total_checkboxes.value==1){
					parent.frames[1].document.forms[0].item_qty_0.value =formObj.item_qty.value;
					CheckDtlQuantityBarcode(0);
					}
		 //if(formObj.dec_allowed_yn.value=='N')
			 //formObj.item_qty.value = formObj.iss_uom_qty.value; 
		}
	}
}

// Added on Thursday, August 05, 2004
async function previewDetails() {
	var total_checkboxes = parent.frameIssueDetail.document.formIssueDetail.total_checkboxes.value;
	var checkedbox = "";
	for (var i = 0; i <= total_checkboxes - 1; i++) {
		if (eval("parent.frameIssueDetail.document.formIssueDetail.checkbox" + i + ".checked")) {
			checkedbox = checkedbox + "@" + i;
		}
	}
	var from_store_code = document.formIssueHeader.from_store_code.value;
	var to_store_code = document.formIssueHeader.to_store_code.value;
	//var item_class_code	=document.formIssueHeader.item_class_code.value;
	var item_class_code = document.formIssueHeader.item_class_code.value;
	var item_class_desc = document.formIssueHeader.item_class_desc1.value;
	var doc_type_code = document.formIssueHeader.doc_type_code.value;
	var doc_ref = document.formIssueHeader.doc_ref.value;
	var doc_date = document.formIssueHeader.doc_date.value;
	var remarks = document.formIssueHeader.remarks.value;
	var mode = document.formIssueHeader.mode.value;
	var retVal = "";
	var dialogHeight = "90vh";
	var dialogWidth = "65vw";
	var dialogTop = "100";
	var center = "1";
	var status = "no";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments = "";
	var url = "../../eST/jsp/IssuePreviewDetails.jsp?from_store_code=" + from_store_code + "&to_store_code=" + to_store_code + "&item_class_code=" + item_class_code + "&doc_type_code=" + doc_type_code + "&doc_ref=" + doc_ref + "&remarks=" + remarks + "&doc_date=" + doc_date + "&checkedbox=" + checkedbox + "&item_class_desc=" + item_class_desc + "&mode=" + mode;
	retVal = await window.showModalDialog(url, arguments, features);
}

// Ends of Thursday, August 05, 2004
async function showHistory(trObj, index) {
	var trObj = eval(document.getElementById('tr_'+ index));
	var item_desc = parent.frameIssueListHeader.document.formIssueListHeader.item_desc.value;
	var item_code = parent.frameIssueListHeader.document.formIssueListHeader.item_code.value;
	var manufacturer_name = eval("document.formIssueListDetail.manufacturer_name_" + index + ".value");
	var expiry_date = trObj.cells[0].innerText.substring(0, 10);
	var batch_id = trObj.cells[1].innerText;
	var trade_name = trObj.cells[2].innerText;
	var uom_desc = parent.frameIssueListHeader.document.getElementById('id_uom').innerHTML;
	retvalue =await  window.showModalDialog("../../eST/jsp/SuspendOrReinstateBatchHistory.jsp?function_id=" + parent.parent.function_id + "&item_code=" + escape(item_code) + "&batch_id=" + batch_id + "&expiry_date=" + expiry_date + "&trade_name=" + trade_name + "&item_desc=" + escape(item_desc) + "&uom_desc=" + escape(uom_desc) + "&manufacturer_name=" + escape(manufacturer_name), "", "dialogHeight:30vh; dialogWidth:55vw; center:0; status: no; dialogLeft :75; dialogTop :250;");
}
function checkminmaxstatus() {
	var formObj = document.formIssueListHeader;
	toConvFactor();
	if ((parseInt(formObj.frm_store_qty_on_hand.value) - parseInt(formObj.item_qty.value)/parseInt(formObj.frm_conv_fact.value)) < parseInt(formObj.frm_store_min_stk_level.value)) {
		alert(getLabel("eST.BelowMinStkinFromStore.label", "ST")); //Below Min Stock Level in From Store
	}
	if ((parseInt(formObj.to_store_qty_on_hand.value) + parseInt(formObj.item_qty.value)/parseInt(formObj.tmp_conv.value)) > parseInt(formObj.to_store_max_stk_level.value)) {
		alert(getLabel("eST.ExceedsMaxStkinToStore.label", "ST")); //Exceeds Max Stock Level in To Store
	}
}
function populateToStoresInQuery(request_by_store) {
	if (request_by_store.value == "") {
		clearListItems("document.forms[0].to_store");
		return;
	}
	var arrayObject = new Array();
	clearListItems("document.forms[0].to_store");
//	assignBean(f_query_add_mod.RequestQueryHeader.document.formRequestQueryCriteria);
	assignBean(parent.frames[0].document.forms[0]);
	xmlStr = getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&request_by_store=" + request_by_store.value + "&validate=POPULATE_TO_STORE", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
function loadItemClassesInQuery(request_by_store, request_on_store) {
	if (request_by_store.value == "" || request_on_store.value == "") {
		clearListItems("document.forms[0].item_class_code");
		return;
	}
	var arrayObject = new Array();
	arrayObject[0] = request_by_store;
	arrayObject[1] = request_on_store;
	assignBean(parent.frames[0].document.forms[0]);
	xmlStr = getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=LOAD_ITEM_CLASS" + "&request_on_store=" + request_on_store.value + "&request_by_store=" + request_by_store.value, false);
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
function kitGetStatus() {
	//var store_not_found = "";
	var to_store_code = parent.parent.frameIssueHeader.document.formIssueHeader.to_store_code.value;
	var store_code = parent.parent.frameIssueHeader.document.formIssueHeader.from_store_code.value;
	var formObj = document.formIssueListHeader;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?item_code=" + formObj.item_code.value + "&store_code=" + store_code + "&item_qty=" + formObj.item_qty.value + "&to_store_code=" + to_store_code+"&kit_temp_code="+formObj.kit_temp_code.value+"&usage_type="+formObj.usage_type.value+ "&validate=GET_STATUS", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	if (!result) {
		if (message == "RECORD_ALREADY_EXISTS") {
			alert(getMessage(message, "ST"));
			refreshDetails();
			return;
		}
		if(parent.parent.frameIssueHeader.document.formIssueHeader.barcode_applicable1.value=="Y")
		addToListforBarCode1('issueBean','eST.IssueBean','IssueListHeader','IssueListDetail','IssueDetail');
		else
		addToList1();

	}
	if (result) {
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?item_code=" + formObj.item_code.value + "&store_code=" + store_code + "&to_store_code=" + to_store_code+ "&validate=MIN_MAX_STATUS", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		//addToList();//COMMENTED BY GANGA

		if(parent.parent.frameIssueHeader.document.formIssueHeader.barcode_applicable1.value=="Y")
		addToListforBarCode('issueBean','eST.IssueBean',parent.parent.frameIssueHeader.document.formIssueHeader.barcode_applicable1,'IssueListHeader','IssueListDetail','IssueDetail');
		else
		addToList();
		
	}
}
function example1(){
	parent.frameIssueList.frameIssueListHeader.example();
}
function example() {
	var store_code = parent.parent.frameIssueHeader.document.formIssueHeader.from_store_code.value;
	var to_store_code = parent.parent.frameIssueHeader.document.formIssueHeader.to_store_code.value;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?validate=KIT_TEMPLATE&store_code=" + store_code+"&to_store_code="+to_store_code, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
function addToList1() {
	toConvFactor();
	var formObj = parent.frameIssueListHeader.document.formIssueListHeader;
	var arrayObject = new Array(formObj.item_code, formObj.item_qty);
	var names = new Array(getLabel("Common.item.label", "Common"), getLabel("Common.Quantity.label", "Common"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.parent.messageFrame);
	if (blankObject == true) {
		if (parent.frameIssueListDetail.document.formIssueListDetail == null) {
			
			var formObj = document.formIssueListHeader;
			var store_code = parent.parent.frameIssueHeader.document.formIssueHeader.from_store_code.value;
			var _item_code = formObj.item_code.value;
			var item_qty = formObj.item_qty.value;
			var mode = parent.parent.frameIssueHeader.document.formIssueHeader.mode.value;
			parent.frameIssueListDetail.location.href = "../../eST/jsp/IssueListDetail.jsp?function=edit&store_code=" + store_code + "&item_code=" + _item_code + "&item_qty=" + item_qty + "&function_id=" + parent.parent.function_id + "&addToList=true&kit=kit";
			return;
		}
		var formObjDtl = parent.parent.frameIssueList.frameIssueListDetail.document.formIssueListDetail;
		var proceed = false;
		var messageFrame = parent.parent.messageFrame;
		var errorPage = "../../eCommon/jsp/error.jsp";
		var item_qty = formObj.item_qty.value;
		_total_checkboxes = formObjDtl.total_checkboxes.value;
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
		
		//xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?index=" + formObj.index.value + "&doc_srl_no=" + formObj.doc_srl_no.value + "&item_code=" + formObj.item_code.value + "&store_code=" + formObj.store_code.value + "&uom_code=" + formObj.uom_code.value + "&item_desc=" + encodeURIComponent(formObj.item_desc.value,"UTF-8") + "&item_qty=" + formObj.item_qty.value + "&item_unit_cost=" + document.getElementById("item_unit_cost").value + "&stock_item_yn=" + formObj.stock_item_yn.value + "&item_cost_value=" + document.getElementById("id_item_sal_value").innerText + "&expiry_yn=" + formObj.expiry_yn.value + "&uom_desc=" + document.getElementById("uom_desc").innerText + "&stock_uom_desc=" + encodeURIComponent(document.getElementById("id_uom").innerText,"UTF-8")  + "&stock_available=" + document.getElementById("id_stock_available").innerText + "&validate=ADD_TO_LIST&for_bin_to_store_hidden=" + document.formIssueListHeader.for_bin_to_store_hidden.value + "&iss_uom_code=" + formObj.iss_uom_code.value + "&uom_conv_code=" + formObj.iss_conv_fact.value + "&iss_uom_qty=" + formObj.iss_uom_qty.value + "&expired_batch=" + formObjDtl.expired_batch.value + "&ex_param_days=" + formObjDtl.ex_param_days.value + "&frm_store_qty_on_hand=" + formObj.frm_store_qty_on_hand.value + "&frm_store_min_stk_level=" + formObj.frm_store_min_stk_level.value + "&frm_store_max_stk_level=" + formObj.frm_store_max_stk_level.value + "&frm_store_reorder_level=" + formObj.frm_store_reorder_level.value + "&to_store_qty_on_hand=" + formObj.to_store_qty_on_hand.value + "&to_store_min_stk_level=" + formObj.to_store_min_stk_level.value + "&to_store_max_stk_level=" + formObj.to_store_max_stk_level.value + "&to_store_reorder_level=" + formObj.to_store_reorder_level.value + "&to_conv_fact=" + formObj.tmp_conv.value + "&frm_conv_fact=" + formObj.frm_conv_fact.value + "&frm_store_uom_desc=" + formObj.frm_store_uom_desc.value + "&to_store_uom_desc=" + formObj.to_store_uom_desc.value + "&batch_records=" + formObjDtl.total_checkboxes.value+"&remarks="+formObjDtl.remarks.value+"&kit_item_yn="+formObj.kit_item_yn.value+"&kit_template_uom="+formObj.kit_template_uom.value+"&remarks_code="+formObjDtl.remarks_code.value+"&iss_uom_conv_text="+document.getElementById("id_iss_uom_conv").innerHTML+"&from_multiples="+formObj.from_multiples.value+"&to_multiples="+formObj.to_multiples.value+"&batch_multiples="+formObj.batch_multiples.value+"&issue_uom_multiples="+formObj.issue_uom_multiples.value+"&kit_temp_code="+formObj.kit_temp_code.value+"&usage_type="+formObj.usage_type.value, false);
		//Commented and Added by suresh.r on 14-04-2014 against #048583(SKR-SCF-0986)
		xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?index=" + formObj.index.value + "&doc_srl_no=" + formObj.doc_srl_no.value + "&item_code=" + formObj.item_code.value + "&store_code=" + formObj.store_code.value + "&uom_code=" + formObj.uom_code.value + "&item_desc=" + encodeURIComponent(formObj.item_desc.value,"UTF-8") + "&item_qty=" + formObj.item_qty.value + "&item_unit_cost=" + document.getElementById('item_unit_cost').value + "&stock_item_yn=" + formObj.stock_item_yn.value + "&item_cost_value=" + document.getElementById('id_item_sal_value').innerText + "&expiry_yn=" + formObj.expiry_yn.value + "&uom_desc=" + encodeURIComponent(document.getElementById('uom_desc').innerText,"UTF-8") + "&stock_uom_desc=" + encodeURIComponent(document.getElementById('id_uom').innerText,"UTF-8")  + "&stock_available=" + document.getElementById('id_stock_available').innerText + "&validate=ADD_TO_LIST&for_bin_to_store_hidden=" + document.formIssueListHeader.for_bin_to_store_hidden.value + "&iss_uom_code=" + formObj.iss_uom_code.value + "&uom_conv_code=" + formObj.iss_conv_fact.value + "&iss_uom_qty=" + formObj.iss_uom_qty.value + "&expired_batch=" + formObjDtl.expired_batch.value + "&ex_param_days=" + formObjDtl.ex_param_days.value + "&frm_store_qty_on_hand=" + formObj.frm_store_qty_on_hand.value + "&frm_store_min_stk_level=" + formObj.frm_store_min_stk_level.value + "&frm_store_max_stk_level=" + formObj.frm_store_max_stk_level.value + "&frm_store_reorder_level=" + formObj.frm_store_reorder_level.value + "&to_store_qty_on_hand=" + formObj.to_store_qty_on_hand.value + "&to_store_min_stk_level=" + formObj.to_store_min_stk_level.value + "&to_store_max_stk_level=" + formObj.to_store_max_stk_level.value + "&to_store_reorder_level=" + formObj.to_store_reorder_level.value + "&to_conv_fact=" + formObj.tmp_conv.value + "&frm_conv_fact=" + formObj.frm_conv_fact.value + "&frm_store_uom_desc=" + formObj.frm_store_uom_desc.value + "&to_store_uom_desc=" + formObj.to_store_uom_desc.value + "&batch_records=" + formObjDtl.total_checkboxes.value+"&remarks="+formObjDtl.remarks.value+"&kit_item_yn="+formObj.kit_item_yn.value+"&kit_template_uom="+formObj.kit_template_uom.value+"&remarks_code="+formObjDtl.remarks_code.value+"&iss_uom_conv_text="+encodeURIComponent(document.getElementById('id_iss_uom_conv').innerHTML,"UTF-8")+"&from_multiples="+formObj.from_multiples.value+"&to_multiples="+formObj.to_multiples.value+"&batch_multiples="+formObj.batch_multiples.value+"&issue_uom_multiples="+formObj.issue_uom_multiples.value+"&kit_temp_code="+formObj.kit_temp_code.value+"&usage_type="+formObj.usage_type.value, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if (result) {
			parent.parent.frameIssueHeader.formIssueHeader.preview.disabled = false;
			var arr = "";
			for (i = 0; i < parent.parent.frameIssueDetail.document.forms[0].total_checkboxes.value; i++) {
				if ((eval("parent.parent.frameIssueDetail.document.forms[0].checkbox" + i).checked)) {
					arr = arr + "," + "CHECKED";
				} else {
					arr = arr + "," + "s";
				}
			}
			parent.parent.frameIssueDetail.location.href = "../../eST/jsp/IssueDetail.jsp?function_id=" + parent.parent.function_id + "&index=" + formObj.index.value + "&arr=" + arr + "&tmp_conv=" + formObj.tmp_conv.value + "&kit12=kit"+"&search_str="+encodeURIComponent(parent.parent.frameIssueDetail.document.formIssueDetail.search_str.value)+"&kit_temp_code="+formObj.kit_temp_code.value+"&usage_type="+formObj.usage_type.value+"&mode="+parent.parent.frameIssueHeader.document.formIssueHeader.mode.value;
			refreshDetails();
		} else {
			parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
		}
	}
}
function statusOfItem() {
	var store_code = parent.parent.frameIssueHeader.document.formIssueHeader.from_store_code.value;
	var to_store_code = parent.parent.frameIssueHeader.document.formIssueHeader.to_store_code.value;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?validate=ERROR_MESSAGE&store_code=" + store_code + "&to_store_code=" + to_store_code, false);
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
			obj.value = "";
        //obj.focus();
			return false;
		}
	}
	return true;
}
function checkLength() {
	var formObj = document.formIssueListHeader;
	var remarks = getLabel("Common.remarks.label", "Common");
	if (!SPCheckMaxLen(remarks, formObj.remarks, 300)) {
		return false;
	}
	return true;
}
function dispMess(id) {
	alert(getMessage("PHY_INV_PROCESS_INITIATED", "ST") + "\n" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + id);
}
async function ItemDetail() {
	var frmObj = document.formIssueListHeader;
	var store_code = parent.parent.frameIssueHeader.document.formIssueHeader.from_store_code.value;
	var to_store_code = parent.parent.frameIssueHeader.document.formIssueHeader.to_store_code.value;
	var doc_no = parent.parent.frameIssueHeader.document.formIssueHeader.doc_no.value;
	if (doc_no != "") {
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?validate=QUANTITY&doc_no=" + doc_no + "&item_code=" + frmObj.item_code.value + "&store_code=" + store_code, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
	}
	await window.showModalDialog("../../eST/jsp/MinMaxItemDetails.jsp?item_desc=" + encodeURIComponent(frmObj.item_desc.value ) + "&fm_store_code=" + store_code + "&to_store_code=" + to_store_code + "&item_code=" + frmObj.item_code.value + "&iss_qty=" + frmObj.doc_qty.value, "", "dialogHeight:50vh; dialogWidth:65vw; center:0; status: no; dialogLeft :150; dialogTop :300; scroll: no");
}
function valueChange(obj) {
	if (parent.parent.frameIssueHeader.document.formIssueHeader.trn_type.value == "ISS") {
		if (document.formIssueListHeader.iss_uom_qty_chk.value == obj.value) {
			document.formIssueListHeader.remarks_mandatory.style.visibility = "hidden";
		} else {
			document.formIssueListHeader.remarks_mandatory.style.visibility = "visible";
			document.formIssueListHeader.remark.disabled = false;
		}
		//Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 12-Feb-2014 Starts
		if (parseInt(document.formIssueListHeader.iss_item_hold_qty.value) == parseInt(obj.value)) {
			document.formIssueListHeader.iss_item_hold_yn.value = "Y";
		}else{
			document.formIssueListHeader.iss_item_hold_yn.value = "N";
			document.formIssueListHeader.iss_item_hold_chk.value = "N";
		} 
		//ends
	} else {
		document.formIssueListHeader.remarks_mandatory.style.visibility = "hidden";
		document.formIssueListHeader.remark.disabled = false;
		document.formIssueListHeader.iss_item_hold_yn.value = "Y"; //Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 12-Feb-2014
	}
}
async function searchRemarks(objCode, objDesc) {
	
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.formIssueListHeader.lang_id.value;
	dataTypeArray[0] = STRING;
	dataNameArray[1] = "module_id";
	dataValueArray[1] = "ST";
	dataTypeArray[1] = STRING;
	dataNameArray[2] = "trn_type";
	//dataValueArray[2] = document.formIssueListHeader.rem_trans_type.value;
	if (document.forms[0].bean_trans_type_1.value == "ISS")document.forms[0].mode.value = "2";
	

	if (document.forms[0].bean_trans_type_1.value == "URG") {
		dataValueArray[2] = "URG";
	} else if ((document.forms[0].bean_trans_type_1.value == "ISS")&&(document.forms[0].mode.value == "2")){
		dataValueArray[2] = "ISS";
	}
	else if(document.forms[0].mode.value =="1"){
		dataValueArray[2] = "URG";
	}
	
	dataTypeArray[2] = STRING;
	//argumentArray[0]		 =		"SELECT DISTINCT mm.trn_remarks_code  code,mm.remarks_desc  description FROM  mm_trn_remarks_lang_vw  mm, ST_TRN_TYPE_FOR_REMARKS st WHERE  st.eff_status = 'E'   AND  st.trn_remarks_code = mm.trn_remarks_code AND   UPPER(mm.language_id) LIKE  UPPER(?) AND UPPER(mm.module_id) LIKE  UPPER(?)   AND  UPPER(st.trn_type)  LIKE  UPPER(?)     AND  mm.trn_remarks_code LIKE   UPPER(?)     AND  UPPER(mm.remarks_desc) LIKE  UPPER(?) ";
	argumentArray[0] = document.formIssueListHeader.SQL_ST_TRN_REMARKS_LOOKUP_SELECT.value;
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
		dataValueArray[2] = "URG";
	} else {
		dataValueArray[2] = document.forms[0].bean_trans_type.value;
	}
	dataTypeArray[2] = STRING;
  
//	argumentArray[0]		 =		"SELECT DISTINCT mm.trn_remarks_code  code,mm.remarks_desc  description FROM  mm_trn_remarks_lang_vw  mm, ST_TRN_TYPE_FOR_REMARKS st WHERE  st.eff_status = 'E'   AND  st.trn_remarks_code = mm.trn_remarks_code AND   UPPER(language_id) LIKE  UPPER(?) AND UPPER(module_id) LIKE  UPPER(?)   AND  UPPER(ST.trn_type)  LIKE  UPPER(?)     AND  MM.trn_remarks_code LIKE   UPPER(?)     AND  UPPER(remarks_desc) LIKE  UPPER(?)  ";
	argumentArray[0] = document.forms[0].SQL_ST_TRN_REMARKS_LOOKUP_SELECT.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "4,5";
	argumentArray[5] = "";
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

function searchResult(){
	var order_by = document.formIssueQueryCriteria.trn_type.value+","+document.formIssueQueryCriteria.doc_type_order.value+" "+document.formIssueQueryCriteria.order.value;
	document.formIssueQueryCriteria.orderbycolumns.value = order_by;
	document.formIssueQueryCriteria.action="../../eST/jsp/IssueQueryResult.jsp"
	document.formIssueQueryCriteria.target="IssueQueryResult";
	document.formIssueQueryCriteria.submit();
}

function locateItem(e,obj){
	if(e.keyCode== 0){
		var arr = "";
		for (i = 0; i < document.forms[0].total_checkboxes.value; i++) {
			if ((eval("document.forms[0].checkbox" + i).checked)) {
				arr = arr + "," + "CHECKED";
			} else {
				arr = arr + "," + "s";
			}
		}
		//parent.parent.frameIssueDetail.location.href = "../../eST/jsp/IssueDetail.jsp?function_id=" + parent.parent.function_id + "&index=" + formObj.index.value + "&arr=" + arr + "&tmp_conv=" + formObj.tmp_conv.value + "&kit12=" + formObj.kit.value;
		document.location.href = "../../eST/jsp/IssueDetail.jsp?function_id="+ function_id+"&search_str="+encodeURIComponent(obj.value)+ "&arr=" + arr+"&mode="+parent.frameIssueHeader.document.formIssueHeader.mode.value+"&locate_item=Y";
		parent.frameIssueList.location.href = "../../eST/jsp/IssueListFrame.jsp?mode="+document.formIssueDetail.mode.value;
	}
}
function clearMessageFrame(){
var errorPage = "../../eCommon/jsp/error.jsp";
parent.messageFrame.location.href = errorPage + "?err_num=";
}


function setUOMIssConvFactor1(_value,_rulestring) {
	//document.getElementById("id_iss_uom_conv").innerHTML = _rulestring;
	//document.formIssueListHeader.iss_conv_fact.value = _value;
	//document.formIssueListHeader.iss_uom_conv.value = _value;

	document.getElementById('id_iss_uom_conv').innerHTML = decodeURIComponent(_rulestring,"UTF-8");
	document.formIssueListHeader.iss_conv_fact.value = decodeURIComponent(_value,"UTF-8");
	document.formIssueListHeader.iss_uom_conv.value = decodeURIComponent(_value,"UTF-8");
///iss_uom_conv
}
function setMultiples(from,to,batch,issue) {
	if (document.formIssueListHeader == null) {
		parent.frames[2].frames[0].document.formIssueListHeader.from_multiples.value = from;
		parent.frames[2].frames[0].document.formIssueListHeader.to_multiples.value = to;
		parent.frames[2].frames[0].document.formIssueListHeader.batch_multiples.value = batch;
		parent.frames[2].frames[0].document.formIssueListHeader.issue_uom_multiples.value = issue;
	} else {
		document.formIssueListHeader.from_multiples.value = from;
		document.formIssueListHeader.to_multiples.value = to;
		document.formIssueListHeader.batch_multiples.value = batch;
		document.formIssueListHeader.issue_uom_multiples.value = issue;
	}
}
function calculateConversion(){
	var store_code = parent.parent.frameIssueHeader.document.formIssueHeader.from_store_code.value;
	var to_store_code = parent.parent.frameIssueHeader.document.formIssueHeader.to_store_code.value;
	if (document.formIssueListHeader.dec_allowed_yn.value == "N") {
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?item_code=" + document.formIssueListHeader.item_code.value + "&fm_store_code=" + store_code + "&to_store_code=" + to_store_code+"&issue_uom_code="+document.formIssueListHeader.iss_uom_code.value + "&validate=CONV_CALCULATE", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
	}
}


 function setStockDetailsforBarcode(_stock_item_yn, _to_stock_item_yn, _store_item_unit_cost, _available_stock, _expired_stock,_conv_factor) {
 
	var allow_deci_yn = document.formIssueListHeader.dec_allowed_yn.value;	
	if(allow_deci_yn=='N')
	document.formIssueListHeader.no_of_decimals.value = '0';
	document.getElementById('id_stock_available').innerText = parseFloat(_available_stock).toFixed(parseInt(document.formIssueListHeader.no_of_decimals.value));
	document.getElementById('frm_store_qty_on_hand').value = parseFloat(_available_stock);

	//document.getElementById("id_item_unit_cost").innerText = _store_item_unit_cost;
	//document.getElementById("item_unit_cost").value = _store_item_unit_cost;

	document.getElementById('id_item_unit_cost').innerText = setNumber(_store_item_unit_cost*_conv_factor,3);
	document.getElementById('id_item_unit_cost').title = _store_item_unit_cost*_conv_factor;
	document.getElementById('item_unit_cost').value = setNumber(_store_item_unit_cost*_conv_factor,3);

	document.formIssueListHeader.stock_item_yn.value = _stock_item_yn;
	document.formIssueListHeader.for_bin_to_store_hidden.value = _to_stock_item_yn;

	if (_stock_item_yn == "Y") {
		if (_available_stock == "0") {
		}
	} else {
		document.formIssueListHeader.batchsearch.disabled = true;
		document.formIssueListHeader.edit.disabled = true;
	}
}

function totalqty(){
}

function assignUOMDesc(frm_store_uom_desc,to_store_uom_desc){
	document.getElementById('frm_store_uom_desc').value = frm_store_uom_desc;
	document.getElementById('to_store_uom_desc').value =  to_store_uom_desc;
}
function chkstatus(obj){
        var usage_type = "";
		if ((eval("document.formIssueDetail.checkbox" + obj).checked)){
		  //Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014
			if(eval("document.formIssueDetail.hold_" + obj) != undefined){
			eval("document.formIssueDetail.hold_" + obj).checked = false;
			} //ends
			usage_type = "P";
		}else{
			usage_type = "O";
		}
		    var xmlHttp = new XMLHttpRequest();
	        var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?usage_type="+usage_type+"&index_="+obj+"&BARCODE_YN="+document.formIssueDetail.BARCODE_YN.value+"&validate=USAGE_TYPE_STATUS", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
}
//This Function is added for RUT-CRF-0079 By Ganga on 1st AUG 2013 
function CallBarcodeVerifyItems(e,obj){
	var barcode = obj.value;
	if((e.keyCode==13 || e.keyCode== 9) && barcode != "" && parent.frameIssueHeader.formIssueHeader.mode.value =="2") {
		var xmlHttp = new XMLHttpRequest();
        var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?barcode="+barcode+"&validate=BARCODE_ITEM_EXISTS", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		obj.value="";//This is done for 42985
	}
}
function changeRowColorForBarcode(index) {
	for (var i=0;i<parseInt(index);i++){
		for (var k = 0; k < 2; k++) {
			if (eval("document.formIssueDetail.barcode_item_exist_"+i)!= undefined && eval("document.formIssueDetail.barcode_item_exist_"+i).value=="M")
				eval(document.getElementById('tr_'+i)).cells[k].className = "FOREDITOR";
		}
	}
}
function blockFormSubmit() {
		document.getElementById('formIssueDetail').onsubmit = function() {            
            return false;
        }
}//ends
//Added by sakti against ML-BRU-SCF-0963[INC#42099]	
function Setitemdesc(obj){
	document.formIssueListHeader.item_desc.value = decodeURIComponent(obj.value,"UTF-8");
}  
//Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-FEB-2014
function chkholdstatus(obj){
    
    var iss_item_hold_yn = "";
    var iss_item_hold_chk = "";
	if ((eval("document.formIssueDetail.hold_" + obj).checked)){
		//eval("document.formIssueDetail.checkbox" + obj).disabled = true;
		 if(parent.frameIssueHeader.document.formIssueHeader.close_yn.value == "Y"){
		    	alert("Items cannot be hold if close upon issue is checked...! ");
		    	eval("document.formIssueDetail.hold_"+obj).checked = false;
		    	return;
		    	
		    }
	    eval("document.formIssueDetail.checkbox" + obj).checked = false;
		iss_item_hold_chk =  "Y";
		
	}else{
		iss_item_hold_chk = "N";
	}
	  var xmlHttp = new XMLHttpRequest(); 
      var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/IssueValidate.jsp?usage_type=O"+"&index_="+obj+"&BARCODE_YN="+document.formIssueDetail.BARCODE_YN.value+"&iss_item_hold_chk="+iss_item_hold_chk+"&validate=USAGE_TYPE_STATUS", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText; 
		eval(responseText);
	
}
//ends
//Added for GHL-CRF-0413 starts
function callItemQtyUpdate(){
       // Modified for IN073577 start
	//var Obj	=  parent.parent.frames[0].document.forms[0].defaultqty_value1;
	var Obj	=  parent.frames[0].document.forms[0].issue_uom_multiples;
	// Modified for IN073577 end
	var bar_appl = parent.parent.frames[0].document.forms[0].barcode_applicable1;
	var barcode = document.forms[0].barcode;
	if(bar_appl.value=='Y' && document.forms[0].item_code.value!=null){
	// Modified for IN073577 start
	//if(Obj.value==1 && parent.parent.frames[0].document.forms[0].editqty_appl1.value != 'Y' &&  document.forms[0].bar_or_item_code.value == 'B' ){
	if( parent.parent.frames[0].document.forms[0].editqty_appl1.value != 'Y' &&  document.forms[0].bar_or_item_code.value == 'B' ){	
	// Modified for IN073577 end
		if (parent.frames[1].document.forms[0] != undefined) {
			var index = parent.frames[1].document.forms[0].total_checkboxes.value ;	
				if(parent.frames[0].document.forms[0].noofbatchesforbarcode.value=="1"){
					if(parent.frames[0].document.forms[0].iss_uom_qty!=undefined && index == 1){
						parent.frames[0].document.forms[0].iss_uom_qty.value = Obj.value;
						if(parent.frames[0].document.forms[0].trn_type_barcode.value =="ISS")//Added against GHL-CRF-0413.2-US002
							valueChange1(Obj.value);
					}
					if(parseFloat(parent.frames[0].document.forms[0].item_qty.value) > parseFloat(Obj.value)){//Modified for In:073938
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
						parent.frames[0].document.forms[0].item_qty.value = (Obj.value* parent.frames[0].document.forms[0].batch_multiples.value)/parent.frames[0].document.forms[0].issue_uom_multiples.value;
						if(parent.frames[0].document.forms[0].tot_item_qty!=undefined){
							parent.frames[0].document.forms[0].tot_item_qty.value = Obj.value;
							}else if(parent.frames[0].document.forms[0].ret_qty!=undefined){
								parent.frames[0].document.forms[0].ret_qty.value= Obj.value;
							}
						if (parseInt(index)==1){
							parent.frames[1].document.forms[0].item_qty_0.value = (Obj.value* parent.frames[0].document.forms[0].batch_multiples.value)/parent.frames[0].document.forms[0].issue_uom_multiples.value;
						}
					}
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
	}CheckQuantity();
}
function callBarCodeBatchSearchforBarcode(e,barcode,trntype,fromStore,toStore,formObj,bean_id,bean_name,ListHeader,ListDetail,Detail){
	if(e.keyCode==13 || e.keyCode== 9  || e.keyCode== 0){
	parent.frames[0].document.forms[0].barcode.disabled = true;
	var bar_code	= barcode.value;
	var trn_type	= trntype.value;
	var fromStore   = fromStore.value;
	var toStore		= toStore.value;
	var formObj		= formObj.name; 
	var barcode_appl = parent.parent.frames[0].document.forms[0].barcode_applicable1.value;
	var site = parent.frames[0].document.forms[0].site.value;
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
	//xmlDoc.loadXML(getXMLString(null));
	var	xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?trn_type=" + trn_type + "&bar_code=" + bar_code + "&formObj=" + formObj  +"&fromStore=" + fromStore + "&toStore=" + toStore + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE" + "&jsp_page=" + ListDetail + "&site=" + site +"&frombarcode="+frombarcode+ "&validate=BARCODE", false);
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
						checkminmaxstatus();
						totalqty();
						calIssueQty();
						CheckQuantity();
						 parent.frames[0].document.forms[0].barcode.disabled = false;
						 parent.frames[0].document.forms[0].barcode.value = "";
						 parent.frames[0].document.forms[0].barcode.focus();
					}else if(parent.parent.frames[0].document.forms[0].defaultqty_appl1.value == 'N'){
						if(document.forms[0].iss_uom_qty!=undefined)
							document.forms[0].iss_uom_qty.focus();
						else
							document.forms[0].item_qty.focus();				
					}
					 changeButtonLegend();//Added against GHL-CRF-0413.2-US002
		}	
		else{
	 		alert(getMessage("PH_INVALID_BAR_CODE", "PH"));
			refreshDetailsforBarCode('999',ListHeader,Detail,'','','','','');
			}
		}else{//Added against GHL-CRF-0413.2-US002
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
function valueChange1(obj) {//Added against GHL-CRF-0413.2-US002 starts
	var curr_qty = obj;
	var old_qty = parent.frames[0].document.forms[0].auth_qty.value;
	if (curr_qty == old_qty) {
		document.formIssueListHeader.remarks_mandatory.style.visibility = "hidden";
	} else {
		document.formIssueListHeader.remarks_mandatory.style.visibility = "visible";
		document.formIssueListHeader.remark.disabled = false;
	}
}
function changeButtonLegend(){
	if (document.formIssueListHeader.trn_type_barcode.value == "ISS")
		document.formIssueListHeader.apply.value = "Modify";
}
function CheckDtlQuantityBarcode(index) {
	if (parseFloat(eval("parent.frames[1].document.forms[0].item_qty_" + index + ".value")) > parseFloat(eval("parent.frames[1].document.forms[0].all.id_stock_avail_" + index + ".innerText"))) {
		alert(getMessage("QTY_NOT_GRT_AVLQTY", "ST"));
		eval("parent.frames[1].document.forms[0].item_qty_" + index).focus();
		return false;
	}
}
//added for GHL-CRF-0465 start
function CheckDtlQuantityBarcode1(index,temp_var,temp_value) {
	var qty_value=eval("parent.frames[1].document.forms[0].item_qty_" + index + ".value");
		//if (parseFloat(eval("parent.frames[1].document.forms[0].item_qty_" + index + ".value")) > parseFloat("parent.frames[1].document.forms[0].available_qty_"+index+".value")) {
	if (parseFloat(eval("parent.frames[1].document.forms[0].item_qty_" + index + ".value")) > parseFloat(eval("parent.frames[1].document.forms[0].all.id_stock_avail_" + index + ".innerText"))) {
		alert(getMessage("QTY_NOT_GRT_AVLQTY", "ST")+" for scanned/selected batch");
		var avail_val=eval("parent.frames[1].document.forms[0].item_qty_" + index) ;
		avail_val.value=eval("parent.frames[1].document.forms[0].all.id_stock_avail_" + index + ".innerText");
		if(temp_var)
		parent.frames[0].document.forms[0].barcode.focus();//added for GHL-CRF-0465			
			
	}
	if(!temp_var)	{
	var confirmcheck=confirm(getMessage("ISS_QTY_EXCEED_AUTHORIZED_QTY", "ST"));
		if(!confirmcheck){
			var item=eval("parent.frames[1].document.forms[0].item_qty_" + index);
		item.value=temp_value;	
		autoQtyUpdate();
		}
		
	}
	return false;

}//END GHL-CRF-0465
function GoBarcode(){
	if(parent.frames[0].document.forms[0] != undefined){
		if(parent.frames[0].document.forms[0].barcode != undefined && parent.frames[0].document.forms[0].barcode.value=="" && parent.frames[0].document.forms[0].barcode.disabled != true ){
			parent.frames[0].document.forms[0].barcode.select();
		}
	}
}
//Added for GHL-CRF-0413  ends

//added for AMRI-CRF-0382 start
function changeMode(obj,urg_doctype_codes){
	//alert("Jai hebhuli");
	var docType=obj.value;
	var flag = false;
	var urg_doctype_codes_String = urg_doctype_codes.split("@");
	//alert("urg_doctype_codes_String>>" + urg_doctype_codes_String+" ,docType>"+docType);
	for(i =0; i < urg_doctype_codes_String.length ;i++) {
		if(docType == urg_doctype_codes_String[i])
			{
			 flag =true;
			 break;
			}
		 flag = false;
	}
	if(flag==true){
		document.getElementById("fromauthdate").style.display="none";
		document.getElementById("fromauthdate1").style.display="none";
		document.getElementById("toauthdate").style.display="none";
		document.getElementById("toauthdate1").style.display="none";
		}
	else{
		document.getElementById("fromauthdate").style.display="inline";
		document.getElementById("fromauthdate1").style.display="inline";
		document.getElementById("toauthdate").style.display="inline";
		document.getElementById("toauthdate1").style.display="inline";
		
	}
	
} 

function onChangeFilter(obj,siteSpecific,urg_doctype_codes){
	var docType=obj.value;
	var flag = false;
	var doctypeorderlength=document.getElementById('doc_type_order').length;
	var urg_doctype_codes_String = urg_doctype_codes.split("@");
	for(i =0; i < urg_doctype_codes_String.length ;i++) {
		if(docType == urg_doctype_codes_String[i])
			{
			 flag =true;
			 break;
			}
		 flag = false;
	}
	if(flag != true && siteSpecific == "true" && doctypeorderlength == 3 )
	{
		var option = document.createElement("OPTION");
		option.value = "hdr.added_date";
		option.text = getLabel("eST.AuthorizeDate.label", "ST");
		document.getElementById('doc_type_order').add(option,0);
		option.selected=true;
	}
	else if(flag == true && doctypeorderlength == 4 )
		{
		document.getElementById('doc_type_order').remove(0);
		}
	
	}
function onloadvalidation(){
	
	if( document.getElementById("siteid").value == "true" && document.getElementById('doc_type_order').length == 3 ){
		var option = document.createElement("OPTION");
		option.value = "hdr.added_date";
		option.text = getLabel("eST.AuthorizeDate.label", "ST");
		document.getElementById('doc_type_order').add(option,0);
		option.selected=true;
	}
}
function fromDateCheck(obj)
{
var locale = document.formIssueQueryCriteria.locale.value;
if(document.formIssueQueryCriteria.from_authorize_date.value != "" && document.formIssueQueryCriteria.to_authorize_date.value != "" ){
	  if(!isBefore(document.formIssueQueryCriteria.from_authorize_date.value,document.formIssueQueryCriteria.to_authorize_date.value,"DMY",locale)) {
	
	alert(getMessage("FROM_AUTH_DATE_CHECK", "ST"));
	obj.value=document.formIssueQueryCriteria.start_date.value;
	}
}
}
function toDateCheck(obj)
{
var locale = document.formIssueQueryCriteria.locale.value;
if(document.formIssueQueryCriteria.from_authorize_date.value != "" && document.formIssueQueryCriteria.to_authorize_date.value != "" ){
		  if(!isBefore(document.formIssueQueryCriteria.from_authorize_date.value,document.formIssueQueryCriteria.to_authorize_date.value,"DMY",locale)) {
	
	alert(getMessage("TO_AUTH_DATE_CHECK", "ST"));
	obj.value=document.formIssueQueryCriteria.end_date.value;
	}
	}
}
//added for AMRI-CRF-0382 end
//Added for TFS id: 11896
function autoQtyUpdate(){ 
	var Obj	=  parent.parent.frames[0].document.forms[0].defaultqty_value1.value;
	var site = parent.frames[0].document.forms[0].site.value;
	var bar_appl = parent.parent.frames[0].document.forms[0].barcode_applicable1.value;
	var trn_type=parent.parent.frames[0].document.forms[0].trn_type.value;
	var barcode = parent.frames[0].document.forms[0].barcode;
	var editqty = parent.parent.frames[0].document.forms[0].editqty_appl1.value;
	var bar_or_item_code = parent.frames[0].document.forms[0].bar_or_item_code.value;
	var issue_uom_multiples=1;
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
				if(parent.frames[0].document.forms[0].issue_uom_multiples.value !=undefined)
					 issue_uom_multiples = parent.frames[0].document.forms[0].issue_uom_multiples.value;
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
					parent.frames[0].document.forms[0].iss_uom_qty.value=parseFloat(item_qty)-parseFloat(issue_uom_multiples);//added GHL-CRF-0465
				parent.frames[0].document.forms[0].item_qty.value = sum;
				barcode.focus();	
			}
		}
	}
}
//Added for TFS id: 11896 end

//Adding start for MO-CRF-20166
async function viewIssueHistory(){

	var request_on_store =parent.parent.frameIssueHeader.document.formIssueHeader.to_store_code.value
	var request_by_store =parent.parent.frameIssueHeader.document.formIssueHeader.from_store_code.value
	var item_code = document.formIssueListHeader.item_code.value;
	var called_from ="ISS";
	var title ="";
	var dialogHeight= "100vh" ;
var dialogWidth	= "100vw" ;
var dialogTop	= "150" ;
var dialogLeft	= "80" ;
var center		= "1" ;
var status		= "no";
var scroll		= "yes";
var features	= "dialogLeft:" + dialogLeft + ";dialogHeight:"+dialogHeight+"; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop+";dialogTitle:"+title;
var arguments	= "" ;
 await window.showModalDialog("../../eST/jsp/IssueHistoryFrame.jsp?item_code="+item_code+"&request_by_store="+request_by_store+"&request_on_store="+request_on_store+"&called_from="+called_from,arguments,features);
}
//Adding end for Mo-CRF-20166
//MMS-MD-SCF-0204    
function batchUomMultiples(obj, uom, mode) {
	var tmp_conv=Math.floor(document.formIssueListDetail.tmp_conv_fac.value);
	var index=parent.frameIssueListHeader.document.formIssueListHeader.index.value;
	if(index=="-1"){
		var factor=uom;
	}
	else{
		var factor=tmp_conv;
	}
	if(obj.value!=0 && obj.value!=null && obj.value!=undefined ){
	var remin=parseFloat(obj.value)%parseFloat(factor)
			if (!(remin==0)) {
				alert(getMessage("BATCH_QTY_MULTIPLE_STORE_UOM", "ST")+" "+ factor);
				obj.value="";
				obj.focus();
			}
	}
}

