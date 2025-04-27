var xmlDom;
var xmlHttp;
var finalizeType = "N";
var prevObj = null;
var prevColor = null;
var l_exp_appro_date = ""; //41554 by Ganga 
 
function create() {
	f_query_add_mod.location.href = "../../ePO/jsp/TenderFrame.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
}

function reset() {
	f_query_add_mod.location.reload();
}

function query() {
	f_query_add_mod.location.href = "../../ePO/jsp/TenderQueryFrame.jsp?function_id=" + function_id;
}

function updateValues() {
	var formObject = document.formPurchaseOrderHeader;
	if (formObject.to_store_code) {
		formObject.request_by_pu.value = formObject.from_store_code.value;
		formObject.request_on_supp.value = formObject.to_store_code.value;
	}
}

function setStore_code(obj){
	var formObject = document.formPurchaseOrderDetail;
	formObject.store_name.value = obj.value;
}

async function deleterecord() {
	if( f_query_add_mod.TndrHeaderFrame==undefined){
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
	}else{
	var formHeader = f_query_add_mod.TndrHeaderFrame.document.formTenderHeader;
	if (formHeader.mode.value == MODE_MODIFY) {
		formHeader.mode.value = MODE_DELETE;
	if(formHeader.prq_delete_yn.value=="N"){
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("NO_DELETE_ACCESS_FOR_USER", "PO");;
	formHeader.mode.value = MODE_MODIFY;	
		return false;
}

		var result = await confirmDelete();
		if (result == YES) {
			apply();
		} else {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + getMessage("OPER_CANCELLED", "PO");
			formHeader.mode.value = MODE_MODIFY;
		}
	} else {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
	}
	}
}

function addItemRecord() {
	var formObject = document.formTenderDetail;
	var errorPage = "../../eCommon/jsp/error.jsp";
	var formHeader = parent.TndrHeaderFrame.document.formTenderHeader;
	var bean_id = "tenderBean";
	var bean_name = "ePO.TenderBean";
	
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));	
	
	
	
	var arrayObject = new Array(formObject.item_desc,formObject.tender_qty,formObject.tender_uom,formHeader.tender_type);
	var names = new Array(getLabel("Common.item.label", "Common"),getLabel("ePO.TndrQty.label", "PO"),getLabel("ePO.TndrUOM.label", "PO"),getLabel("ePO.TndrType.label", "PO"));
		
	if(formHeader.autono_yn.value=="No"){
		arrayObject[arrayObject.length] = formHeader.doc_no;
		names[names.length] = getLabel("ePO.TndrNo.label", "PO");
	}
	
	var blankObject = checkPOFields(arrayObject, names, parent.parent.messageFrame, errorPage);
	if (blankObject != true) {
		return;
	}
	
	
	
	var formHeader = parent.TndrHeaderFrame.document.formTenderHeader;
	// store_code = "";
	//var item_code = formObject.item_code.value;
	
	formObject.mode.value = formHeader.mode.value;
	assignBean(formObject);
	xmlStr = getEnhancedXMLString(formObject);
	xmlDom.loadXML(xmlStr);
	
	if ((formObject.mode.value == MODE_INSERT) || ((formObject.mode.value == MODE_MODIFY) && (formObject.editing.value == 2))) {
		function_type ="EDITING";
	} else {
		 function_type="";
		if ((formObject.mode.value == MODE_MODIFY) && (formObject.editing.value == 1)) {
			function_type ="MODIFYMODE";
		}
	}
	xmlHttp.open("POST", "../../ePO/jsp/TenderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=" + function_type, false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
	var mod_id="PO";
	if(message=="DUPLICATE_CODE_EXISTS")
		mod_id="Common";
	if (!result) {
		parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, mod_id);
		return;
	}
	parent.parent.messageFrame.location.href = errorPage;
	index = formObject.srl_no.value;
	if (index != -1) {
		index = index - 1;
	}
	parent.TndrListFrame.document.location.href = "../../ePO/jsp/TenderList.jsp?index=" + index  +"&mode=" + MODE_INSERT  ;
	formObject.add.value = getLabel("Common.Add.label", "Common");
	formHeader.tender_type.disabled = true;
	formObject.item_desc.readOnly = false;	
	if (formObject.editing.value == "1") {
	 	formObject.add.disabled = true;
	//	document.getElementById("batch_td").disabled = true;
	
		formObject.reset();
		formObject.item_desc.focus();
	} else {
		
		document.location.href = "../../ePO/jsp/TenderDetails.jsp?mode=" + MODE_INSERT + "&function_id=" + parent.parent.function_id ;
		
		
	}
	
	
}


function assignBean(frmObject) {
	bean_id = frmObject.bean_id.value;
	bean_name = frmObject.bean_name.value;
	xmlDom = new ActiveXObject("Microsoft.XMLDom");
	xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
}

function updateCheckStatus(obj_item_code) {
	var check_status = "";
	var formObj = document.formTenderList;
	assignBean(formObj);
	if (obj_item_code.checked) {
		check_status = "Y";
	} else {
		check_status = "N";
	}
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../ePO/jsp/TenderValidate.jsp?item_code=" + obj_item_code.value + "&check_status=" + check_status + "&bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value + "&function_type=UPDATECHECKSTATUS", false);
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	eval(responseText);
}


function displayItemDetail(idx) {
	//var formHeader = parent.TndrHeaderFrame.document.formTenderHeader;
	
	var trObject = eval("document.getElementById("tr_")" + idx);

	changeRowColor(trObject);
	
	var item_code = eval("document.formTenderList.item_code_" + idx + ".value");
	var po_no  =  eval("document.formTenderList.po_no_" + idx + ".value");
//	var delv_date  =  eval("document.formQuotationList.delv_date_" + idx + ".value");
//	var request_no  =  eval("document.formQuotationList.request_no_" + idx + ".value");	
	
	parent.TndrDetailFrame.document.location.href = "../../ePO/jsp/TenderDetails.jsp?mode=" + MODE_MODIFY + "&function_id=" + parent.parent.function_id + "&item_code=" + item_code  + "&po_no=" + po_no + "&edit=" + document.formTenderList.mode.value;
	hide = 'yes';
	resizeFrames();
}

function changeRowColor(obj) {
	tot = document.forms[0].total_checkboxes.value;
	tot = tot - 1;
	if (prevObj != null) {
		for (var k = 1; k < 9; k++) {
			prevObj.cells(k).className = prevColor;
		}
	}
	prevObj = obj;
	prevColor = obj.cells(1).className;
	for (var k = 1; k < 9; k++) {
		obj.cells(k).className = "STLIGHTPINK";
	}
}


function resetDetail() {
	document.location.href = "../../ePO/jsp/TenderDetails.jsp?mode=" + MODE_INSERT + "&function_id=" + parent.parent.function_id;
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
}



async function apply() {

	//var bean_id = "tenderBean";
	//var bean_name = "ePO.TenderBean";
	var errorPage = "../../eCommon/jsp/error.jsp";
	if(f_query_add_mod.TndrHeaderFrame==undefined)
	{
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	return;
	}
	var formHeader = f_query_add_mod.TndrHeaderFrame.document.formTenderHeader;
	if (formHeader.mode.value == MODE_DELETE) {
		eval(formApply(formHeader, PO_CONTROLLER));
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "ST");
		if (result) {
			onSuccess();
		}
		return;
	}
	var arrayObject = new Array(formHeader.from_purchase_unit,formHeader.doc_date);
	var names = new Array(getLabel("ePO.PORaisedBy.label", "PO"),getLabel("ePO.TndrDate.label", "PO"));
	var blankObject = checkPOFields(arrayObject, names, messageFrame, errorPage);
	if (blankObject != true) {
	    formHeader.from_purchase_unit.focus();
		return; 
		}
	
	if (!formHeader.doc_no.disabled) {
		var arrayObject = new Array(formHeader.doc_no);
		var names = new Array(getLabel("ePO.TndrNo.label", "PO"));		
		var blankObject = checkPOFields(arrayObject, names, messageFrame, errorPage);
		if (blankObject != true) {
		return; 
		}
	}
	
		
	
	var formObject = f_query_add_mod.TndrListFrame.document.formTenderList;
	var total_items = formObject.total_checkboxes.value;
	
	var chkdValue = 0;
	for (var count = 0; count < total_items; count++) {
		if (!eval("formObject.add_itm_" + count + ".checked")) {
			chkdValue++;
		}
	}
	if (total_items == chkdValue) {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("MIN_ONE_DETAIL_REQUIRED", "Common");
		return;
	}
	
	formObject.mode.value = formHeader.mode.value;
	formObject.doc_no.value = formHeader.doc_no.value;
	formObject.doc_date.value = formHeader.doc_date.value;
	formObject.doc_ref.value = formHeader.doc_ref.value;
	formObject.autono_yn.value = formHeader.autono_yn.value;
	formObject.tender_type.value = formHeader.tender_type.value;
	formObject.request_by_pu.value = formHeader.from_purchase_unit.value;
	formObject.local_currency.value = formHeader.local_currency.value;	
	
	
	var expiry_date 	=  formHeader.expiry_date.value;
	var approval_date 	=  formHeader.approval_date.value;
	var contract_date 	=  formHeader.contract_date.value;
	var max_date 		= formHeader.doc_date.value;

	
	if (expiry_date.length > 0 && max_date.length > 0) {
		var expDateArray = expiry_date.split("/");
		var maxDateArray = max_date.split("/");
		var expDateObject = new Date(expDateArray[2], (expDateArray[1] - 1), expDateArray[0]);
		var maxDateObject = new Date(maxDateArray[2], (maxDateArray[1] - 1), maxDateArray[0]);
		if (Date.parse(maxDateObject) > Date.parse(expDateObject)) {		 
			alert("Tender Expiry date should be greater than or equal to Tender date");	
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
			return false;
		}
	}
	if (approval_date.length > 0 && max_date.length > 0) {
		var expDateArray = approval_date.split("/");
		var maxDateArray = max_date.split("/");
		var expDateObject = new Date(expDateArray[2], (expDateArray[1] - 1), expDateArray[0]);
		var maxDateObject = new Date(maxDateArray[2], (maxDateArray[1] - 1), maxDateArray[0]);
		if (Date.parse(maxDateObject) > Date.parse(expDateObject)) {		 
			alert("Tender Approval date should be greater than or equal to Tender date");	
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
			return false;
		}
	}
	if (contract_date.length > 0 && max_date.length > 0) {
		var expDateArray = contract_date.split("/");
		var maxDateArray = max_date.split("/");
		var expDateObject = new Date(expDateArray[2], (expDateArray[1] - 1), expDateArray[0]);
		var maxDateObject = new Date(maxDateArray[2], (maxDateArray[1] - 1), maxDateArray[0]);
		if (Date.parse(maxDateObject) > Date.parse(expDateObject)) {		 
			alert("Tender Contract sign date should be greater than or equal to Tender date");	
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
			return false;
		}
	}
	
	
	
	checkCanAuthorize(formObject.request_by_pu);			
	formHeader.authorize_yn.value = formHeader.authorize_yn.value.substring(0, 1);
	
//	if(result){
		if (formHeader.authorize_yn.value == "Y") {
			finalizeType = await confirmFinalize();
			if(finalizeType==""){
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
				return;
			}
		}

	if (finalizeType == "") {
		finalizeType = "N";
	}
	formObject.finalize_yn.value = finalizeType;
	var responseText = formApply(formObject, PO_CONTROLLER);
//	alert(responseText);
	eval(responseText);
	flag1 = (flag.split("~"))[0];
	flag2 = (flag.split("~"))[1];
	flag1 = (flag1 == "null" ? "" : flag1);
		
	if (result) {
	
		
	/*	var PConfirm = confirmPrinting();
			if (PConfirm == "Yes") {
				var xmlHttp = new XMLHttpRequest();
				var xmlDoc="";
				xmlDoc.loadXML(getXMLString(null));
				xmlHttp.open("POST", "../../ePO/jsp/DeliveryOrderValidate.jsp?function_type=PRINTONLINEDOC&msg=" + encodeURIComponent(message) + "&bean_id=" + bean_id + "&bean_name=" + bean_name , false);
				xmlHttp.send(xmlDoc);
				responseText = xmlHttp.responseText;
				eval(responseText);
			}
	*/		
		
		messageFrame.location.href = errorPage + "?err_num=" + message + "<BR>" + (result ? flag1 : "");
		onSuccess();
	}else{
		if(message == "Doc No Null<BR>"){
			alert(getMessage("DOC_NO_NULL", "PO"));
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
			return;
		}else{
		messageFrame.location.href = errorPage + "?err_num=" + message;
		}
	}
}

function onSuccess() {
	var formObject = f_query_add_mod.TndrHeaderFrame.document.formTenderHeader;
	if (formObject.mode.value == MODE_DELETE) {
		f_query_add_mod.location.href = "../../eCommon/html/blank.html";
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + message;
	} else {
		if (formObject.mode.value == MODE_MODIFY) {
			if (finalizeType == YES) {
				f_query_add_mod.location.href = "../../eCommon/html/blank.html";
			} else {
				f_query_add_mod.location.href = "../../eCommon/html/blank.html";
			}
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + message;
		} else {
			f_query_add_mod.location.href = "../../eCommon/html/blank.html";
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + message + "<BR>" + flag;
		}
	}
	return;
}

function Modify(obj) {
	
	var tender_no = obj.cells[1].innerText;
	var tender_type_code = obj.cells[3].innerText;
	
	parent.document.location.href = "../../ePO/jsp/TenderFrame.jsp?mode=" + MODE_MODIFY + "&function_id=" + parent.parent.function_id  + "&tender_no="+tender_no+ "&tender_type_code="+tender_type_code ;
	
	
}


function close_modal() {
	window.close();
	
}

function setCurrCode(obj_currency){
		var formHeader = document.formQuotationHeader;
		
		//var formObject = parent.QuotDetailFrame.document.formQuotationDetail;
		var bean_id = "quotationBean";
	var bean_name = "ePO.QuotationBean";
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../ePO/jsp/QuotationValidate.jsp?function_type=SETCURRCODE&tran_currency=" + obj_currency.value +"&local_currency=" + formHeader.local_currency.value + "&bean_id=" + bean_id + "&bean_name=" + bean_name, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
		
/*		parent.DODetailFrame.document.getElementById("currency_label_1").innerHTML =  obj_currency.value ; 
		parent.DODetailFrame.document.getElementById("currency_label_4").innerHTML =  obj_currency.value ; 
		parent.DOListFrame.document.getElementById("currency_label_5").innerHTML =  obj_currency.value  ; 
		parent.DOListFrame.document.getElementById("currency_label_6").innerHTML =  obj_currency.value  ; 
		parent.DOListFrame.document.getElementById("currency_label_7").innerHTML =  obj_currency.value  ; 
						
		if((obj_currency.value)==(formHeader.local_currency.value)){
			document.getElementById("exc_rate").value = 1;
			document.getElementById("exc_rate").disabled = true;
		}else{
			document.getElementById("exc_rate").value = "";
			document.getElementById("exc_rate").disabled = false;
		}
	*/	
	
}


function loadDelDate(obj_date){
	parent.PODetailFrame.document.getElementById("del_date").value =  obj_date.value ; 

}

function displayValidUpto(obj_blanket){

	if(obj_blanket.checked){
		document.formPurchaseOrderHeader.all.validUptoHidden.style.visibility="visible";
		parent.PODetailFrame.document.getElementById("DelvSchHidden").style.visibility="visible";
		parent.PODetailFrame.document.getElementById("DelvSchHide").style.visibility="hidden";
				
	}else{
		document.formPurchaseOrderHeader.all.validUptoHidden.style.visibility="hidden";		
		parent.PODetailFrame.document.getElementById("DelvSchHidden").style.visibility="hidden";
		parent.PODetailFrame.document.getElementById("DelvSchHide").style.visibility="visible";
		document.formPurchaseOrderHeader.valid_upto.value = "";
	}
}



function displayDelvSche(){

	if(document.formPurchaseOrderHeader.blanket_po_yn.value != undefined && document.formPurchaseOrderHeader.blanket_po_yn.value != null)
		alert(document.formPurchaseOrderHeader.blanket_po_yn.value);
	//	parent.PODetailFrame.document.getElementById("DelvSchHidden").style.visibility="visible";
	//	parent.PODetailFrame.document.getElementById("DelvSchHide").style.visibility="hidden";	
	//	parent.PODetailFrame.document.getElementById("DelvSchHidden").style.visibility="hidden";
	//	parent.PODetailFrame.document.getElementById("DelvSchHide").style.visibility="visible";
	
}


function calculateValue(){
		var formObject = document.formTenderDetail;
		var ord_qty = formObject.tender_qty.value ; 
		var unit_price = formObject.tender_price.value ; 
		var tot_value = ord_qty * unit_price ; 
	//	var net_amount = ord_qty * unit_price ;
		
		if(tot_value != NaN){
		formObject.net_amount.value  = parseFloat(tot_value).toFixed(3) ;
		formObject.net_amount.disabled=true;
		}
}

function calculatePrice(){
		var formObject = document.formQuotationDetail;
		var ord_qty = formObject.quotation_qty.value ; 
		var net_amount = formObject.net_amount.value ; 
		var pur_price = net_amount / ord_qty ; 
		if(isNaN(pur_price)){
		formObject.pur_price.value  = 0 ;
		}else{
		formObject.pur_price.value  = parseFloat(pur_price).toFixed(3) ;
		formObject.pur_price.disabled=true;
		}

}

function calculateDiscount(){

		var formObject = document.formQuotationDetail;
		var dis_type = formObject.dis_type.value ; 
		var tot_value = formObject.tot_value.value ; 
		//var dis_amt = formObject.dis_amt.value ; 
		var dis_amt = formObject.dis_value.value ; 
		
		var net_amt;
		var discount_amt;
		var dis_value;
		if(dis_amt == null || dis_amt == ""){
			formObject.dis_amt.value  = 0.000;
		}else{
		if(dis_type=="P"){
		if(dis_amt <= 100){
		  discount_amt = (dis_amt/100) * tot_value;
		  dis_value = discount_amt;
		  net_amt = tot_value - discount_amt;
		  formObject.net_amount.value  = parseFloat(net_amt).toFixed(3) ;
		  formObject.net_amount.disabled=true;
		  formObject.dis_amt.value  = parseFloat(dis_value).toFixed(3) ;
		  formObject.dis_amt.disabled=true;
		  }else{
		  alert(getMessage("DISCOUNT_PER_LT_100", "PO"));
		  formObject.dis_value.focus();
		  }
		}else if(dis_type=="A"){

		if(parseFloat(dis_amt) <= parseFloat(tot_value)){
		  net_amt = tot_value - dis_amt;
		  dis_value = dis_amt;
		  formObject.net_amount.value  = parseFloat(net_amt).toFixed(3) ;
		  formObject.net_amount.disabled=true;
		  formObject.dis_amt.value  = parseFloat(dis_value).toFixed(3) ;
		  formObject.dis_amt.disabled=true;
		  }else{
		   alert(getMessage("DISCOUNT_AMT_LT_GROSS", "PO"));
		  formObject.dis_value.focus();
		  }
		}		
		}		
}
function calculateNetAmt(){
		
		var formObject = document.formQuotationList;
		var gross_poAmt = formObject.gross_poAmt.value ; 
		var addi_dist = formObject.addi_dist.value ; 
		var net_amt;
		//var discount_amt;
	
		if(parseFloat(gross_poAmt) > 0){
			
			document.getElementById("gross_poAmt_label").innerHTML = "" + parseFloat(gross_poAmt).toFixed(3) + ""; 
		if(parseFloat(gross_poAmt) > parseFloat(addi_dist)){
		  net_amt = gross_poAmt - addi_dist;	
		  document.getElementById("net_poAmt_label").innerHTML = "" + net_amt.toFixed(3) + ""; 
		  document.getElementById("net_poAmt").value = net_amt;
		}else{
			alert(getMessage("DISCOUNT_AMT_LT_GROSS", "PO"));
			formObject.addi_dist.focus();
		}
	}	
	loadExRate();
	

}

function LoadTrade(mode){
	if(document.formTenderDetail.item_code.value!="" && document.formTenderDetail.trade_id.value == ""){
		var bean_id = "tenderBean";
		var bean_name = "ePO.TenderBean";
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../ePO/jsp/TenderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&item_code=" + document.formTenderDetail.item_code.value+ "&mode=" + mode+ "&trd_id=" + document.formTenderDetail.trade_id.value + "&function_type=LOADTRADEID", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
	}
		
}
function SupplierDetails(bean_id, bean_name, mode) {
	function_id = document.forms[0].function_id.value;
	var mode_modify = 1;
	window.showModalDialog("../../ePO/jsp/TenderSupplierDetails.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +  "&function_id=" + function_id + "&mode=" + mode  + "&mode_modify="+ mode_modify, "", "dialogHeight:15; dialogWidth: 57; right: 1; status: no; dialogTop :300;scroll:yes");
}
function AddSupplierDetails(){
	var formObj = document.TndrSupplierDetailsForm;	
	for(var j=0;j<formObj.total_Records.value;j++){	
		if(eval("document.TndrSupplierDetailsForm.supp_code_"+j) != undefined){
			var supp_code     = eval("document.TndrSupplierDetailsForm.supp_code_"+j).value;
			for(var k = 0; k < formObj.total_Records.value; k++) {				
				if(eval("document.TndrSupplierDetailsForm.supp_code_"+k) != undefined){
					var supp_code1     = eval("document.TndrSupplierDetailsForm.supp_code_"+k).value;
						if(supp_code!="" && supp_code1 != "" && supp_code==supp_code1 && j!=k){
							alert(getMessage("DUPLICATE_NOT_POSSIBLE", "PO"));
							return;
						}
				}
			}
		}
	}
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getEnhancedXMLString(formObj));
	xmlHttp.open("POST", "../../ePO/jsp/TenderValidate.jsp?bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value+ "&function_type=SETSUPPLIERVALUES", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	window.returnValue = result;
	window.close();	
}

function AdditionalDetails(bean_id, bean_name, mode) {

	var formObj = document.formTenderHeader;
	function_id = document.forms[0].function_id.value;	
	var retVal = window.showModalDialog("../../ePO/jsp/TenderAdditionalDetails.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +  "&function_id=" + function_id +"&doc_date="+formObj.doc_date.value+ "&mode=" + mode  , "", "dialogHeight:15; dialogWidth: 50; center: 1; status: no; dialogTop :300;scroll:no");

	if(retVal!=undefined){
		var retSplit = retVal.split("-");
		formObj.expiry_date.value = retSplit[0];
		formObj.approval_date.value = retSplit[1];
		formObj.contract_date.value = retSplit[2];
	}
}


function exitAdditionalDetails(){

	var formObj = document.formTndrAdditionalDetails;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getEnhancedXMLString(formObj));			
	xmlHttp.open("POST", "../../ePO/jsp/TenderValidate.jsp?bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value  +  "&tender_remarks=" + encodeURIComponent(formObj.tender_remarks.value) +  "&expiry_date=" + formObj.expiry_date.value +  "&approval_date=" + formObj.approval_date.value +  "&contract_date=" + formObj.contract_date.value + "&function_type=SETADDITIONALDETAILS", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	window.returnValue = formObj.expiry_date.value +"-"+ formObj.approval_date.value +"-"+ formObj.contract_date.value;
	window.close();
}
function RejectionRemarks(remarks,codedisabled) {
	var rem = "";
	rem = window.showModalDialog("../../ePO/jsp/DORejectionRemarks.jsp?function_id=" + parent.parent.function_id + "&remarks=" +remarks + "&codedisabled=" +codedisabled, "", "dialogHeight:10; dialogWidth:30; center:0; status: no; dialogLeft :75; dialogTop :250;");
	if (rem != null && codedisabled=="") {
		document.forms[0].rejection_remarks.value = rem;
	}
}
function exitRejectionRemarks() {
	window.returnValue = document.formDORejectionRemarks.rejection_remarks.value;
	window.close();
}


function ItemRemarks(remarks,codedisabled) {
	
	var rem = "";
	rem = window.showModalDialog("../../ePO/jsp/TenderItemRemarks.jsp?function_id=" + parent.parent.function_id + "&remarks=" +encodeURIComponent(remarks) + "&codedisabled=" +codedisabled, "", "dialogHeight:10; dialogWidth:30; center:0; status: no; dialogLeft :75; dialogTop :250;");
	if (rem != null && codedisabled=="") {
		document.forms[0].item_remarks.value = rem;
	}
	
}

function ItemRemarks1(remarks,codedisabled) {
	remarks = decodeURIComponent(remarks,"UTF-8");
	var rem = "";
	rem = window.showModalDialog("../../ePO/jsp/TenderItemRemarks.jsp?function_id=" + parent.parent.function_id + "&remarks=" +encodeURIComponent(remarks) + "&codedisabled=" +codedisabled, "", "dialogHeight:10; dialogWidth:30; center:0; status: no; dialogLeft :75; dialogTop :250;");
	if (rem != null && codedisabled=="") {
		document.forms[0].item_remarks.value = rem;
	}
	
}

function exitItemRemarks(){
	window.returnValue = document.formTndrItemRemarks.item_remarks.value;
	window.close();	
}
function getUOMDesc(obj_uom) {	
	var formObj = document.formTenderDetail;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../ePO/jsp/TenderValidate.jsp?function_type=GETUOMDESC&uom_code=" + obj_uom.value + "&bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);	
}
function searchCodeItem(obj) {

	var formObject = document.formTenderDetail;
	var formHeader = parent.TndrHeaderFrame.document.formTenderHeader;
	var errorPage = "../../eCommon/jsp/error.jsp";
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	var arrayObject = new Array(formHeader.tender_type,formHeader.from_purchase_unit);
	var names = new Array(getLabel("ePO.TndrType.label", "PO"),getLabel("ePO.PORaisedBy.label", "PO"));	
	
	if(formHeader.autono_yn.value=="No"){
		arrayObject[arrayObject.length] = formHeader.doc_no;
		names[names.length] = getLabel("ePO.DONo.label", "PO");
	}
	
	var blankObject = checkPOFields(arrayObject, names, parent.parent.messageFrame, errorPage);
	if (blankObject != true) {
		return;
	}
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.forms[0].p_language_id.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] = document.getElementById("SQL_MM_ITEM_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
		formObject.item_code.value = returnedValues[0];
		formObject.item_desc.value = returnedValues[1];
		formObject.item_desc.readOnly = true;
		formObject.add.disabled = false;
		document.formTenderDetail.conv_fact.value = "1";
		document.formTenderDetail.tender_qty.focus();
		LoadTrade("1");
		
	}
	
	if(formObject.item_code.value!=""){
		var bean_id = "tenderBean";
		var bean_name = "ePO.TenderBean";
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../ePO/jsp/TenderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&item_code=" + formObject.item_code.value + "&function_type=MM_UOM", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		}
	
}

function loadManufacturer(obj_trade){
	var formObject = document.formQuotMoreDetails;
		var bean_id = "quotationBean";
		var bean_name = "ePO.QuotationBean";
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../ePO/jsp/QuotationValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&item_code=" + formObject.item_code.value + "&trade_id=" + obj_trade.value +"&function_type=LOADMANUFACTURER", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;

		eval(responseText);
}
function searchItemCode(obj) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0]= localeName;
	dataTypeArray[0] = STRING;
	argumentArray[0] = document.formPurchaseOrderSearchWindowCriteria.SQL_ST_ITEM_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = document.formPurchaseOrderSearchWindowCriteria.item_desc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[1];
		document.formPurchaseOrderSearchWindowCriteria.item_code.value = returnedValues[0];
	}
	else
	{
		obj.value ="";
		document.formPurchaseOrderSearchWindowCriteria.item_code.value ="";
	}
}

var hide = 'no';

function resizeFrames(){	

	var fullFrame;

	if (parent.TenderFrmS)
	{
		fullFrame = parent.TenderFrmS;
	}

	if(hide == 'no')
	{
		if (parent.TndrBlankFrame)
		{
			if(parent.TndrBlankFrame.document.getElementById('hideImg'))
			{
				parent.TndrBlankFrame.document.getElementById('hideImg').src='../../eST/images/POright.png';
				fullFrame.cols = '0px,14px,*';
				parent.TndrListFrame.document.getElementById('tndrList').style.width = "1340px";
				hide='yes';
			}	
		}	
	}
	else if(hide == 'yes')
	{
		if (parent.TndrBlankFrame){
			if(parent.TndrBlankFrame.document.getElementById('hideImg'))
			{
				parent.TndrBlankFrame.document.getElementById('hideImg').src='../../eST/images/POleft.png';	
				fullFrame.cols = '350px,14px,*';
				parent.TndrListFrame.document.getElementById('tndrList').style.width = "980px";
				hide='no';
			}
		}
	}
	
}

function checkValidateUpto(obj_validDate){
	var formObject = document.formQuotationHeader;
	
	var expDateArray;
	var valDateArray;
	var valDate = obj_validDate.value;
	var expDate = formObject.currentdate.value;
	if (expDate.length > 0 && valDate.length > 0) {
		expDateArray = expDate.split("/");
		valDateArray = valDate.split("/");
		var expDateObject = new Date(expDateArray[2], (expDateArray[1] - 1), expDateArray[0]);
		var valDateObject = new Date(valDateArray[2], (valDateArray[1] - 1), valDateArray[0]);
		if (Date.parse(valDateObject) < Date.parse(expDateObject)) {
		 
			alert(getMessage("VALID_DT_EQ_SYS_DT", "PO"));
				formObject.valid_upto.value = "";
				formObject.valid_upto.focus();
			
		}
	
	}
	
}



function perChange(obj_dis_type){
	if(obj_dis_type.value == "P")
		document.formQuotationDetail.all.PerHide.style.visibility="visible";
	else
		document.formQuotationDetail.all.PerHide.style.visibility="hidden";
}



function addRowToTable()
{  
	
  
}
function confirmOverride() {
	/** @user - ST_PREPARE_HDR */
	var retVal = "";
	var dialogHeight = "10";
	var dialogWidth = "25";
	var dialogTop = "230";
	var center = "1";
	var status = "no";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments = "";
	var url = "../../ePO/jsp/ConfirmOverride.jsp";
	retVal = window.showModalDialog(url, arguments, features);
	if (retVal == null) {
		retVal = "";
	}
	return retVal;
}


function confirmOverrideError() {
	/** @user - ST_PREPARE_HDR */
	var retVal = "";
	var dialogHeight = "10";
	var dialogWidth = "25";
	var dialogTop = "230";
	var center = "1";
	var status = "no";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments = "";
	var url = "../../ePO/jsp/ConfirmOverrideError.jsp";
	retVal = window.showModalDialog(url, arguments, features);
	if (retVal == null) {
		retVal = "";
	}
	return retVal;
}


function checkCanAuthorize(request_by_pu) {
	var bean_id = "tenderBean";
	var bean_name = "ePO.TenderBean";

	if (request_by_pu.value == "") {
		return;
	}
	var arrayObject = new Array();
	arrayObject[0] = request_by_pu;
	assignBean(f_query_add_mod.TndrHeaderFrame.document.formTenderHeader);
	var xmlDom = new ActiveXObject("Microsoft.XMLDom");
	var xmlHttp = new XMLHttpRequest();
	xmlStr = getXMLString(arrayObject);
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "../../ePO/jsp/TenderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=CHECKFORAUTHORIZE", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
 
	eval(responseText);
}

function setAuthorize(authorizeValue) {
	f_query_add_mod.TndrHeaderFrame.document.formTenderHeader.authorize_yn.value = authorizeValue;
}

function checkUOMConvFactor() {

	var formObj = document.formTenderDetail;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../ePO/jsp/TenderValidate.jsp?uom_code=" + formObj.uom.value + "&pur_uom_code=" + formObj.temp_uom_code.value + "&bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value + "&function_type=CHECKUOMCONVFACTOR" + "&item_code=" + formObj.item_code.value, false);
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	eval(responseText);
	if (!result) {
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "PO");
		//formObj.uom.value = formObj.temp_uom_code.value;
		//formObj.uom.focus();
		formObj.quotation_uom.value = formObj.temp_uom_code.value;
		formObj.quotation_uom.focus();
		
		setUOMConvFactor("1");
	}
}

function setUOMConvFactor(_value) {
	document.formDeliveryOrderDetail.conv_fact.value = _value;
}

function setUOMConvFactor1(_value,_rulestring) {

	document.getElementById("conv_fact").value = _value;
}
function showCalendarLocal(id) {
	var flag = showCalendar(id);
	document.getElementById(id).focus();
	return flag;
}
function loadExRate(){
	
		if(parent.TndrHeaderFrame.document.getElementById("exc_rate") != undefined ){
			var formHeader = parent.QuotHeaderFrame.document.formQuotationHeader;
			var formList = document.formQuotationList;
			var exc_rate = formHeader.exc_rate.value;
			var net_poAmt = formList.net_poAmt.value ;
			var netLC;
		
		if(formHeader.currency_code.value != "" && formHeader.currency_code.value != null && formHeader.local_currency.value != "" && formHeader.local_currency.value != null)	{
			
		if((formHeader.currency_code.value)==(formHeader.local_currency.value)){
			formList.all.netDoAmtHidden.style.visibility="hidden";
		}else{
			formList.all.netDoAmtHidden.style.visibility="visible";
			if(parseFloat(net_poAmt) > 0){
				netLC = net_poAmt * exc_rate ; 
				 document.getElementById("net_poAmt_label_lc").innerHTML = "" + netLC.toFixed(3) + ""; 
				document.getElementById("net_poAmt_lc").value = netLC;
			}	
		}
		}		
		}
	
}
function checkValidateQryDate(){

	var formObject = document.formTenderQueryCriteria;
	
	var toDateArray;
	var fromDateArray;
	var toDate = formObject.to_do_date.value;
	var fromDate = formObject.from_do_date.value;
	if (fromDate.length > 0 && toDate.length > 0) {
		toDateArray = fromDate.split("/");
		fromDateArray = toDate.split("/");
		var toDateObject = new Date(toDateArray[2], (toDateArray[1] - 1), toDateArray[0]);
		var fromDateObject = new Date(fromDateArray[2], (fromDateArray[1] - 1), fromDateArray[0]);
		if (Date.parse(fromDateObject) < Date.parse(toDateObject)) {
		//	alert("To date should be greater than or equal to From date");
			alert(getMessage("TO_DATE_GR_FROM_DATE","PO"));  
				formObject.to_do_date.select();
				formObject.to_do_date.focus();
			
		}else{
			document.formTenderQueryCriteria.submit();
		}
	
	}else{
		document.formTenderQueryCriteria.submit();
	}
	
}
function confirmWindow(title,header) {
	var retVal = "";
	var dialogHeight = "8";
	var dialogWidth = "30";
	var dialogTop = "230";
	var center = "1";
	var status = "no";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments = "";
	var url = "../../ePO/jsp/ConfirmWindow.jsp?title="+title + "&header="+header;
	retVal = window.showModalDialog(url, arguments, features);
	if (retVal == null) {
		retVal = "";
	}
	return retVal;
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

function showReason(trObj,index) {
	
	var item_code = document.EvaluationFactorForm.item_code.value;
	var master_code = eval ("document.EvaluationFactorForm.master_code_"+index+".value");
	var	eval_rmks = "";
	
	if(eval ("document.EvaluationFactorForm.eval_rmks_"+index) != null){
		eval_rmks = eval ("document.EvaluationFactorForm.eval_rmks_"+index+".value");
	}else{
		eval_rmks = "";
	}
	
//	if (eval ("document.EvaluationFactorForm.master_code_"+index+".selected")){
		retVal=window.showModalDialog("../../ePO/jsp/QuotEvalRemarks.jsp?function_id="+parent.parent.function_id+"&item_code="+item_code+ "&eval_rmks="+ encodeURIComponent(eval_rmks) +"&master_code="+master_code,'','dialogHeight:10; dialogWidth:32; center:0; status: no; dialogLeft :75; dialogTop :250;');
		
	/*	while(retVal == undefined){
			alert('Please Press Close Button');
			alert(getMessage("PLS_PRESS_CLOSE_BUTTON","PO"));  
			retVal=window.showModalDialog("../../ePO/jsp/QuotEvalRemarks.jsp?function_id="+parent.parent.function_id+"&item_code="+item_code+ "&eval_rmks="+ eval_rmks+"&master_code="+master_code,'','dialogHeight:10; dialogWidth:32; center:0; status: no; dialogLeft :75; dialogTop :250;');
		}
	*/	
		if(eval ("document.EvaluationFactorForm.eval_rmks_"+index) != null){
			(eval("document.EvaluationFactorForm.eval_rmks_"+index)).value=retVal;
		}	
//	}
	
}

function updateRemarks() {
	formObject = document.formEvalRemarks;
	/*if (!setTextAreaMaxLength(formObject.remarks,200)) {
		alert (getMessage('REMARKS_CHAR_EXCEEDS_LIMIT','ST'));
		return;
	}*/
/*	if (formObject.remarks.value == "") {
		checkField(formObject.remarks,getLabel("Common.remarks.label","Common"));
		return;
	}
*/	
	assignBean(formObject);
	xmlStr = getEnhancedXMLString(formObject);
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "../../ePO/jsp/QuotationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=UPDATEREMARKS", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);
	window.returnValue = formObject.remarks.value;
	window.close();
}


function showReason1(trObj,index) {
	
	var item_code = document.EvaluationFactorForm.item_code.value;
	var master_code = eval ("document.EvaluationFactorForm.master_code_"+index+".value");
	var recom_rmks = "";
	
	if(eval ("document.EvaluationFactorForm.recom_rmks_"+index) != null){
		recom_rmks = eval ("document.EvaluationFactorForm.recom_rmks_"+index+".value");
	}else{
		recom_rmks = "";
	}
	
//	if (eval ("document.EvaluationFactorForm.master_code_"+index+".selected")){
		retVal=window.showModalDialog("../../ePO/jsp/QuotRecomRemarks.jsp?function_id="+parent.parent.function_id+"&item_code="+item_code+"&recom_rmks="+encodeURIComponent(recom_rmks)+"&master_code="+master_code,'','dialogHeight:10; dialogWidth:32; center:0; status: no; dialogLeft :75; dialogTop :250;');
		
	/*	while(retVal == undefined){
			alert('Please Press Close Button');
			alert(getMessage("PLS_PRESS_CLOSE_BUTTON","PO"));  
			retVal=window.showModalDialog("../../ePO/jsp/QuotRecomRemarks.jsp?function_id="+parent.parent.function_id+"&item_code="+item_code+"&recom_rmks="+recom_rmks+"&master_code="+master_code,'','dialogHeight:10; dialogWidth:32; center:0; status: no; dialogLeft :75; dialogTop :250;');
		}
	*/	
		if(eval ("document.EvaluationFactorForm.recom_rmks_"+index) != null){
			(eval("document.EvaluationFactorForm.recom_rmks_"+index)).value=retVal;
		}	
//	}
}

function updateRecomRemarks() {
	formObject = document.formRecomRemarks;
	/*if (!setTextAreaMaxLength(formObject.remarks,200)) {
		alert (getMessage('REMARKS_CHAR_EXCEEDS_LIMIT','ST'));
		return;
	}*/
/*	if (formObject.remarks.value == "") {
		checkField(formObject.remarks,getLabel("Common.remarks.label","Common"));
		return;
	}
*/	
	assignBean(formObject);
	xmlStr = getEnhancedXMLString(formObject);
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "../../ePO/jsp/QuotationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=UPDATERECOMREMARKS", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);
	window.returnValue = formObject.remarks.value;
	window.close();
}
function addRow(tableID){ 
			var formObject = document.TndrSupplierDetailsForm;
			var table = document.getElementById('myTable');
		
            var rowCount = table.rows.length;            
			//var lastRowIndex = table.rows.length-1;
			//var lastCellIndex = table.rows[lastRowIndex].cells.length-1;
			var row = table.insertRow(rowCount);
		    var colCount = table.rows[0].cells.length;
		    
      for(var i=0; i<colCount+1; i++) {
    	  
            var newcell = row.insertCell(i);			
			newcell.innerHTML = table.rows[rowCount-1].cells[i].innerHTML;

			if(newcell.childNodes[0]!=null && newcell.childNodes[0].name != null) {
				var oldName =newcell.childNodes[0].name;
				var newName = getNewName(oldName,rowCount-1 );				
				newcell.innerHTML = replaceAll(newcell.innerHTML,oldName, newName);
			}
		
			if(newcell.childNodes[0]!=null && newcell.childNodes[0].onblur != null) {
				var onClick = newcell.childNodes[0].onblur;
				var ss = onClick.toString();
				var strInd = ss.lastIndexOf(')');
				var strInd1 = ss.lastIndexOf('(');
				var subStr = ss.substring(strInd1,strInd);
				var oldBlur = subStr;
				var newBlur = getNewBlur(oldBlur,rowCount-1 );
				newcell.innerHTML = replaceBlurAll(newcell.innerHTML,oldBlur, newBlur);				
			}
					
			if(newcell.childNodes[0]!=null && newcell.childNodes[0].onclick != null) {
				var onClick = newcell.childNodes[0].onclick;
				var ss = onClick.toString();
				var strInd = ss.lastIndexOf(')');
				var strInd1 = ss.lastIndexOf('(');
				var subStr = ss.substring(strInd1,strInd);
				var oldClick = subStr;
				var newClick = getNewClick(oldClick,rowCount-1 );
				newcell.innerHTML = replaceClickAll(newcell.innerHTML,oldClick, newClick);
				if(oldClick.indexOf("e") == 1){
				//	var arr = oldClick.split(',');
				//	var lc = arr[0].slice(-1);
					var lc = rowCount ; 
					var hiddenName = "eval_rmks_"+lc;
					var input = document.createElement("input");
					input.setAttribute("type", "hidden");
					input.setAttribute("name", hiddenName);
					input.setAttribute("value", "");
					//input.setAttribute("align", "center");
					formObject.appendChild(input);
					
				}else{
				//	var arr = oldClick.split(',');
				//	var lc = arr[0].slice(-1);
					var lc = rowCount ; 
					var hiddenName = "recom_rmks_"+lc;
					var input = document.createElement("input");
					input.setAttribute("type", "hidden");
					input.setAttribute("name", hiddenName);
					input.setAttribute("value", "");
					//input.setAttribute("align", "center");
					formObject.appendChild(input);				
				}
			}
			
			if(newcell.childNodes[0]!=null && newcell.childNodes[0].onchange != null) {
				var onchange = newcell.childNodes[0].onchange;
				var ss = onchange.toString();
				var strInd = ss.lastIndexOf(')');
				var strInd1 = ss.lastIndexOf('(');
				var subStr = ss.substring(strInd1,strInd);
				var oldchange = subStr;
				var newchange = getNewChange(oldchange,rowCount-1 );
				newcell.innerHTML = replaceAll(newcell.innerHTML,oldchange, newchange);				
			}
			
			switch(newcell.childNodes[0].type) {
                case "text":
                    newcell.childNodes[0].value = "";
					break;
                case "select-one":
                    newcell.childNodes[0].value = "";
                    newcell.childNodes[0].disabled = false;
					break;
				case "checkbox":
                    newcell.childNodes[0].checked = true;
					newcell.setAttribute("align", "left");//20/06/2013
                    break;	
				case "hidden":
					newcell.childNodes[0].value = "";
					break;
				
                }
		}	
		
      formObject.total_Records.value = rowCount;			
}

function replaceAll(inputString, regExpr, newString)
 {
    var outputStr = "";
    var pivot;
    while(inputString.indexOf(regExpr) != - 1)
    {
        inputString = inputString.replace(regExpr,newString);
        pivot = inputString.indexOf(newString) + newString.length;
        outputStr = outputStr + inputString.substring(0, pivot) ;
        inputString = inputString.substring(pivot,inputString.length);
    }
    outputStr = outputStr + inputString;
//	alert("outputStr = "+outputStr);
    return outputStr;
 }

 function getNewName(oldName,rowIndex )
 {
    var arr = oldName.split('_');
      arr[arr.length - 1] = rowIndex;
      var str = "";
      for (var arrIndex = 0; arrIndex < arr.length; arrIndex++)
      {
           str += arr[arrIndex];
           if (arrIndex != arr.length - 1)
           {
                 str += "_";
           }
      }
	  
      return str;
 }
 
  function getNewClick(oldName,rowIndex )
 {
	var st = oldName;
	var arr = oldName.split(',');
	var str = st.replace(arr[1],rowIndex);
	return str;
		
 }
 
 function getNewBlur(oldName,rowIndex )
 {
	var st = oldName;
	var arr = oldName.split(',');
	var str = st.replace(arr[1],rowIndex);
	return str;
		
 }
 
 function getNewChange(oldName,rowIndex )
 {
	var st = oldName;
	var arr = oldName.split(',');
	var str = st.replace(arr[1],rowIndex);
	return str;
		
 }
 function replaceClickAll(inputString, regExpr, newString)
 {
	var outputStr = "";
    var pivot;
    while(inputString.indexOf("show") != - 1)
    {
        inputString = inputString.replace(regExpr,newString);
		pivot = inputString.indexOf(newString) + newString.length;
	    outputStr = outputStr + inputString.substring(0, pivot) ;
	    inputString = inputString.substring(pivot,inputString.length);
    }
    outputStr = outputStr + inputString;
	return outputStr;
 }

 function replaceBlurAll(inputString, regExpr, newString)
 {
	
    var outputStr = "";
    var pivot;
    while(inputString.indexOf("maxW") != - 1)
    {
        inputString = inputString.replace(regExpr,newString);
		pivot = inputString.indexOf(newString) + newString.length;
	    outputStr = outputStr + inputString.substring(0, pivot) ;
	    inputString = inputString.substring(pivot,inputString.length);
    }
    outputStr = outputStr + inputString;
	return outputStr;
 }
 

 function searchRemarksHeader(objCode, objDesc) {
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
	if (document.forms[0].bean_master_type.value == "") {
		dataValueArray[2] = "POQUOT";
	} else {
		dataValueArray[2] = document.forms[0].bean_master_type.value;
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
	returnedValues = CommonLookup(getLabel("Common.remarks.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
	}
}

function getContactDetails(obj,i){		
	
	var formObject = document.TndrSupplierDetailsForm;
	assignBean(formObject);
	xmlStr = getEnhancedXMLString(formObject);
	xmlDom.loadXML(xmlStr);
	/*if(obj.value == "")
	{
	eval("formObject.supp_code_"+i).value = "";
	eval("formObject.contact_person_"+i).value = "";
	eval("formObject.contact_number_"+i).value = "";
	eval("formObject.email_id_"+i).value = "";
	} */
	//if(obj.value != ""){
	xmlHttp.open("POST", "../../ePO/jsp/TenderValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&supp_code="+obj.value+"&count="+ i +"&function_type=UPDATECONTACTDETAILS", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);
	//}
	
}

function checkDocDate(obj,curr_date){


	var formObject = document.formTenderHeader;
	var expDateArray;
	var valDateArray;
	var expDate = obj.value;
	var valDate = curr_date;
	
	if (expDate.length > 0 && valDate.length > 0) {
		expDateArray = expDate.split("/");
		valDateArray = valDate.split("/");
		var expDateObject = new Date(expDateArray[2], (expDateArray[1] - 1), expDateArray[0]);
		var valDateObject = new Date(valDateArray[2], (valDateArray[1] - 1), valDateArray[0]);
		//if (Date.parse(valDateObject) != Date.parse(expDateObject)) { //commented by Rabbani For validation of Tenderdate on 21/06/2013
		  if (Date.parse(expDateObject) > Date.parse(valDateObject)) { 
			alert("Tender date cannot be greater than System Date"); //41553 By Ganga
			formObject.doc_date.value="";
			formObject.doc_date.focus();
		  }
	}
}
function checkExpDate(obj){
	var formObject = document.formTndrAdditionalDetails;
	var expDateArray;
	var valDateArray;
	var appDateArray;
	var expDate = obj.value;
	var valDate = formObject.doc_date.value;
	var appDate = formObject.approval_date.value;
	
	if (expDate.length > 0 && valDate.length > 0) {
		expDateArray = expDate.split("/");
		valDateArray = valDate.split("/");
		var expDateObject = new Date(expDateArray[2], (expDateArray[1] - 1), expDateArray[0]);
		var valDateObject = new Date(valDateArray[2], (valDateArray[1] - 1), valDateArray[0]);
		if (Date.parse(valDateObject) > Date.parse(expDateObject)) {
			alert("Tender Expiry date should be greater than or equal to Tender date");
			formObject.expiry_date.value="";
			formObject.expiry_date.focus();
			return false;
		}
	}
	if (expDate.length > 0 && appDate.length > 0) {
		expDateArray = expDate.split("/");
		appDateArray = appDate.split("/");
		var expDateObject = new Date(expDateArray[2], (expDateArray[1] - 1), expDateArray[0]);
		var appDateObject = new Date(appDateArray[2], (appDateArray[1] - 1), appDateArray[0]);
		if (Date.parse(appDateObject) > Date.parse(expDateObject)) {
			alert("Tender Expiry date should be greater than or equal to Tender approval date");
			formObject.expiry_date.value="";
			formObject.expiry_date.focus();		
		}		
	}
}
function checkApprovalDate(obj){
	var formObject = document.formTndrAdditionalDetails;
	var expDateArray;
	var valDateArray;
	var tndrExpDateArray;
	var expDate = obj.value;
	var valDate = formObject.doc_date.value;
	var tndrExpDate = formObject.expiry_date.value;
	
	if (expDate.length > 0 && valDate.length > 0 ) {
		expDateArray = expDate.split("/");
		valDateArray = valDate.split("/");
		var expDateObject = new Date(expDateArray[2], (expDateArray[1] - 1), expDateArray[0]);
		var valDateObject = new Date(valDateArray[2], (valDateArray[1] - 1), valDateArray[0]);
		if (Date.parse(valDateObject) > Date.parse(expDateObject)) {
			alert("Tender Approval date should be greater than or equal to Tender date");
			formObject.approval_date.value="";
			formObject.approval_date.focus();
			return false;
		}
		
	}
	
	if (expDate.length > 0 && tndrExpDate.length > 0 ) {
		expDateArray = expDate.split("/");
		tndrExpDateArray = tndrExpDate.split("/");
		var expDateObject = new Date(expDateArray[2], (expDateArray[1] - 1), expDateArray[0]);
		var tndrExpDateObject = new Date(tndrExpDateArray[2], (tndrExpDateArray[1] - 1), tndrExpDateArray[0]);
		if (Date.parse(expDateObject) > Date.parse(tndrExpDateObject)) {
			alert("Tender Approval date should be less than or equal to Tender expiry date");
			formObject.approval_date.value="";
			formObject.approval_date.focus();
		}
	}
}

function checkContractDate(obj){
	var formObject = document.formTndrAdditionalDetails;
	var expDateArray;
	var valDateArray;	
	var expDate = obj.value;
	var valDate = formObject.doc_date.value;
		
	if (expDate.length > 0 && valDate.length > 0) {
		expDateArray = expDate.split("/");
		valDateArray = valDate.split("/");
		var expDateObject = new Date(expDateArray[2], (expDateArray[1] - 1), expDateArray[0]);
		var valDateObject = new Date(valDateArray[2], (valDateArray[1] - 1), valDateArray[0]);
		if (Date.parse(valDateObject) > Date.parse(expDateObject)) {
			alert("Tender Contract sign date should be greater than or equal to Tender date");
			formObject.contract_date.value="";
			formObject.contract_date.focus();
		}
	}	
}
//Added by Rabbani For validation of Supplier check box on 21/06/2013
function setstatus(obj,count){
	var formObject = document.TndrSupplierDetailsForm;
	var allElements	=	formObject.elements;
	var SelectAll = "Y"; 
	if(eval("formObject.Select_supp_"+count+".checked")) {
	eval("formObject.Select_supp_"+count).value = "Y";
	}else{
	eval("formObject.Select_supp_"+count).value = "N";
	}
	
	for (var i=0; i<allElements.length; i++) 
	{
		if (allElements[i].type=="checkbox")
			if (!allElements[i].checked && allElements[i].name != "SelectAll"){
				formObject.SelectAll.checked=false;
				SelectAll = "N";
			}
	}
	
	if(SelectAll=="Y")
		formObject.SelectAll.checked=true;
	
}
function toggleCheck(formObject){
	var allElements	=	formObject.elements;
	var ischecked=formObject.SelectAll.checked;
	for (var i=0; i<allElements.length; i++) 
	{
		if (allElements[i].type=="checkbox")
			if (!allElements[i].disabled)
				allElements[i].checked=ischecked;
	}
}

function setstatusforSelectAll(){
	var formObject = document.TndrSupplierDetailsForm;
	var allElements	=	formObject.elements;
	var SelectAll	="Y";
	for (var i=0; i<allElements.length; i++)
	{
		if (allElements[i].type=="checkbox")
			if (!allElements[i].checked){
				SelectAll = "N";
			}
	}
	
	if(SelectAll=="N")
		formObject.SelectAll.checked=false;
	
}

//ends

