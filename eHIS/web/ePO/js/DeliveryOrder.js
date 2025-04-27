/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
04/06/2019		IN070421		   B Haribabu					B Haribabu		ML-BRU-SCF-1954

---------------------------------------------------------------------------------------------------------
*/
var xmlDom;
var xmlHttp;
var finalizeType = "No";
var prevObj = null;
var prevColor = null;

function create() {
	f_query_add_mod.location.href = "../../ePO/jsp/DeliveryOrderFrame.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
}

function reset() {
	f_query_add_mod.location.reload();
}

function query() {
	f_query_add_mod.location.href = "../../ePO/jsp/DeliveryOrderQueryFrame.jsp?function_id=" + function_id;
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
//	alert('deleterecord');
	if( f_query_add_mod.DOHeaderFrame==undefined){
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
	}else{
	var formHeader = f_query_add_mod.DOHeaderFrame.document.formDeliveryOrderHeader;
	if (formHeader.mode.value == MODE_MODIFY) {
		formHeader.mode.value = MODE_DELETE;
//	alert(formHeader.prq_delete_yn.value);
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
	var formObject = document.formDeliveryOrderDetail;
	var errorPage = "../../eCommon/jsp/error.jsp";
	var formHeader = parent.DOHeaderFrame.document.formDeliveryOrderHeader;
	var bean_id = "deliveryOrderBean";
	var bean_name = "ePO.DeliveryOrderBean";
	
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));	
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");	
	
	xmlHttp.open("POST", "../../ePO/jsp/DeliveryOrderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=POREQDFORDO" + "", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	var item_desc; //Added by B.Badmavathi against ML-BRU-SCF-1616
	var patr = /%/g;//Added for IN070421
	formObject.item_desc.value=formObject.item_desc.value.replace(patr,"%25");//Added for IN070421
	 formObject.item_desc.value = decodeURIComponent(formObject.item_desc.value,"UTF-8");
	if(!result || formObject.item_desc.disabled == true){
	
	var arrayObject = new Array(formObject.item_desc,formObject.delivery_qty,formObject.delivery_uom,formHeader.delivery_type,formHeader.supplier_code,formHeader.currency_code,formHeader.exc_rate);
	var names = new Array(getLabel("Common.item.label", "Common"),getLabel("ePO.DeliveryQty.label", "PO"),getLabel("ePO.DeliveryUOM.label", "PO"),getLabel("ePO.DOType.label", "PO"),getLabel("ePO.Supplier.label", "PO"),getLabel("ePO.TransactionCurrency.label", "PO"),getLabel("ePO.ExchangeRate.label", "PO"));
		
	if(formHeader.autono_yn.value=="No"){
		arrayObject[arrayObject.length] = formHeader.doc_no;
		names[names.length] = getLabel("ePO.DONo.label", "PO");
	}
	
	var blankObject = checkPOFields(arrayObject, names, parent.parent.messageFrame, errorPage);
	if (blankObject != true) {
		return;
	}
	
	
	
	var formHeader = parent.DOHeaderFrame.document.formDeliveryOrderHeader;
	var store_code = "";
	var item_code = formObject.item_code.value;
	
	
	var po_no = formObject.po_no.value ; 
	var delv_date = formObject.delv_date.value ; 
	var request_no = formObject.request_no.value ; 
	var itm_cd = "";
	if(po_no!="")
		itm_cd = item_code+po_no+delv_date+request_no;
		

	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));	
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");	
	
	xmlHttp.open("POST", "../../ePO/jsp/DeliveryOrderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&item_code=" + item_code + "&itm_cd=" + itm_cd + "&po_no=" + po_no + "&delv_date=" + delv_date + "&request_no=" + request_no + "&store_code=" + store_code + "&function_type=ADDITEMRECORD" + "", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
//	alert(responseText);
	eval(responseText);
	
	var delv_qty = formObject.delivery_qty.value ; 
	
	if(!result){
//	alert("Please enter the batch details for the Item.");
	alert(getMessage("BATCH_DTLS","PO"));  
	return;
	}else{
	  if(flag!=delv_qty){
	 // alert("Delivery quantity is mismatch in batch details");
	  alert(getMessage("DELV_QTY_MISMATCH","PO"));  
	  return;
	  }
	}
	
	
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
	xmlHttp.open("POST", "../../ePO/jsp/DeliveryOrderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=" + function_type, false);
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
	var supp_code = formHeader.supplier_code.value;
	var currency_code = formHeader.currency_code.value;
	var local_currency = formHeader.local_currency.value;
	parent.DOListFrame.document.location.href = "../../ePO/jsp/DeliveryOrderList.jsp?index=" + index + "&supp_code=" + supp_code +"&currency_code="+currency_code +"&local_currency="+ local_currency;
	formObject.add.value = getLabel("Common.Add.label", "Common");
	formHeader.supplier_code.disabled = true;
	formHeader.delivery_type.disabled = true;
	formHeader.currency_code.disabled = true;
	formHeader.exc_rate.disabled = true;
	formObject.item_desc.readOnly = false;
	if (formObject.editing.value == "1") {
	 	formObject.add.disabled = true;
	//	document.getElementById("batch_td").disabled = true;
		formObject.reset();
		formObject.item_desc.focus();
	} else {
		var supplier_code = formHeader.supplier_code.value;
		var currency_code = formHeader.currency_code.value;
		document.location.href = "../../ePO/jsp/DeliveryOrderDetails.jsp?mode=" + MODE_INSERT +  "&to_supplier=" + supplier_code + "&currency_code=" + currency_code +"&local_currency="+ local_currency + "&function_id=" + parent.parent.function_id ;
		
	}
	
	}else{
	//	alert("Please select the Purchase Order(s) for this Delivery Order.");
		alert(getMessage("PUR_ORD_FOR_DELV_ORD","PO"));  
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
	var formObj = document.formDeliveryOrderList;
	assignBean(formObj);
	if (obj_item_code.checked) {
		check_status = "Y";
	} else {
		check_status = "N";
	}
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");	
	xmlHttp.open("POST", "../../ePO/jsp/DeliveryOrderValidate.jsp?item_code=" + obj_item_code.value + "&check_status=" + check_status + "&bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value + "&function_type=UPDATECHECKSTATUS", false);
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	eval(responseText);
}


function displayItemDetail(idx) {
	var formHeader = parent.DOHeaderFrame.document.formDeliveryOrderHeader;

	var to_supplier = formHeader.supplier_code.value;
	var currency_code = formHeader.currency_code.value;
	var local_currency = formHeader.local_currency.value;
	
	var trObject = eval(document.getElementById("tr_" + idx));

	changeRowColor(trObject);
	
	var item_code = eval("document.formDeliveryOrderList.item_code_" + idx + ".value");
	var po_no  =  eval("document.formDeliveryOrderList.po_no_" + idx + ".value");
	var delv_date  =  eval("document.formDeliveryOrderList.delv_date_" + idx + ".value");
	var request_no  =  eval("document.formDeliveryOrderList.request_no_" + idx + ".value");	
	
	parent.DODetailFrame.document.location.href = "../../ePO/jsp/DeliveryOrderDetails.jsp?mode=" + MODE_MODIFY + "&function_id=" + parent.parent.function_id + "&item_code=" + item_code  + "&po_no=" + po_no + "&request_no=" + request_no +"&delv_date="+ delv_date + "&to_supplier=" + to_supplier +  "&currency_code=" + currency_code + "&local_currency="+ local_currency+"&edit=" + document.formDeliveryOrderList.mode.value;
	hide = 'yes';
	resizeFrames();
}

function changeRowColor(obj) {
	tot = document.forms[0].total_checkboxes.value;
	tot = tot - 1;
	if (prevObj != null) {
		for (k = 1; k < 14; k++) {
			prevObj.cells(k).className = prevColor;
		}
	}
	prevObj = obj;
	prevColor = obj.cells(1).className;
	for (k = 1; k < 14; k++) {
		obj.cells(k).className = "STLIGHTPINK";
	}
}


function resetDetail() {
	document.location.href = "../../ePO/jsp/DeliveryOrderDetails.jsp?mode=" + MODE_INSERT + "&function_id=" + parent.parent.function_id;
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
}



async function apply() {

	var bean_id = "deliveryOrderBean";
	var bean_name = "ePO.DeliveryOrderBean";
	var errorPage = "../../eCommon/jsp/error.jsp";
	if(f_query_add_mod.DOHeaderFrame==undefined)
	{
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	return;
	}
	var formHeader = f_query_add_mod.DOHeaderFrame.document.formDeliveryOrderHeader;
	if (formHeader.mode.value == MODE_DELETE) {
		eval(formApply(formHeader, PO_CONTROLLER));
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "ST");
		if (result) {
			onSuccess();
		}
		return;
	}
	
	if (!formHeader.doc_no.disabled) {
		var arrayObject = new Array(formHeader.doc_no);
		var names = new Array(getLabel("ePO.DONo.label", "PO"));		
		var blankObject = checkPOFields(arrayObject, names, messageFrame, errorPage);
		if (blankObject != true) {
		return; 
		}
	}
	
	if (!formHeader.exc_rate.disabled) {
		var arrayObject = new Array(formHeader.exc_rate);
		var names = new Array(getLabel("ePO.ExchangeRate.label", "PO"));		
		var blankObject = checkPOFields(arrayObject, names, messageFrame, errorPage);
		if (blankObject != true) {
		return; 
		}
	}
	
	
	var formObject = f_query_add_mod.DOListFrame.document.formDeliveryOrderList;
	var total_items = formObject.total_checkboxes.value;
	
	var chkdValue = 0;
	for (count = 0; count < total_items; count++) {
		if (!eval("formObject.add_itm_" + count + ".checked")) {
			chkdValue++;
		}
	}
	
	if (total_items == chkdValue) {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("MIN_ONE_DETAIL_REQUIRED", "Common");
		return;
	}
	
		
	for (i= 0; i < total_items; i++) {
	if (eval("formObject.add_itm_" + i + ".checked")) {	
		var itm_cd = eval("formObject.item_code_"+i+".value");
		var po_no = eval("formObject.po_no_"+i+".value");
		var delv_date = eval("formObject.delv_date_"+i+".value");
		var request_no = eval("formObject.request_no_"+i+".value");
				
		if(po_no!="")
		itm_cd = itm_cd+po_no+delv_date+request_no;
		var itm_cd1 = eval("formObject.item_code_"+i+".value");
		
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");	
		xmlHttp.open("POST", "../../ePO/jsp/DeliveryOrderValidate.jsp?function_type=CHECHBATCHDETAILS&bean_id=" + bean_id + "&bean_name=" + bean_name + "&itm_cd="+ itm_cd + "&mode=" + formHeader.mode.value +"&itm_cd1="+ itm_cd1 +"&po_no="+ po_no +"&delv_date="+ delv_date +"&request_no="+ request_no, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if(!result) break;
	}	
		
	}	
	
	formObject.mode.value = formHeader.mode.value;
	formObject.doc_no.value = formHeader.doc_no.value;
	formObject.doc_date.value = formHeader.doc_date.value;
	formObject.doc_ref.value = formHeader.doc_ref.value;
	formObject.request_on_supp.value = formHeader.supplier_code.value;
	formObject.autono_yn.value = formHeader.autono_yn.value;
	formObject.delivery_type.value = formHeader.delivery_type.value;
	formObject.currency_code.value = formHeader.currency_code.value;
	formObject.exc_rate.value = formHeader.exc_rate.value;
	formObject.local_currency.value = formHeader.local_currency.value;
	
	
	
	checkCanAuthorize();			
	formHeader.authorize_yn.value = formHeader.authorize_yn.value.substring(0, 1);
	
	if(result){
		if (formHeader.authorize_yn.value == "Y") {
			finalizeType = await confirmFinalize();
			if(finalizeType==""){
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
				return;
			}
		}
	}else{
	//	messageFrame.location.href = errorPage + "?err_num=" + "APP-000001 Batch Details Cannot be Blank";
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("BAT_DTLS_CANNOT_BLANK","PO");
		
				return;
	}	
	
	if (finalizeType == "") {
		finalizeType = "No";
	}
	formObject.finalize_yn.value = finalizeType;
	var responseText = formApply(formObject, PO_CONTROLLER);
	//alert(responseText);
	eval(responseText);
	flag1 = (flag.split("~"))[0];
	flag2 = (flag.split("~"))[1];
	flag1 = (flag1 == "null" ? "" : flag1);
		
	if (result) {
	
		
		var PConfirm = await confirmPrinting();
			if (PConfirm == "Yes") {
				var xmlHttp = new XMLHttpRequest();
				var xmlDoc="";
				//xmlDoc.loadXML(getXMLString(null));
				xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
				xmlHttp.open("POST", "../../ePO/jsp/DeliveryOrderValidate.jsp?function_type=PRINTONLINEDOC&msg=" + encodeURIComponent(message) + "&bean_id=" + bean_id + "&bean_name=" + bean_name , false);
				xmlHttp.send(xmlDoc);
				responseText = xmlHttp.responseText;
				eval(responseText);
			}
		
		messageFrame.location.href = errorPage + "?err_num=" + message + "<BR>" + (result ? flag1 : "");
		onSuccess();
	}else{
		if(message == "Doc No Null<BR>"){
		//	alert("Document number setup is not available. Please set the same and retry the transaction.");
			alert(getMessage("DOC_NO_NULL","PO"));  
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
			return;
		}else{
		messageFrame.location.href = errorPage + "?err_num=" + message;
		}
	}	
	
}

function onSuccess() {
	var formObject = f_query_add_mod.DOHeaderFrame.document.formDeliveryOrderHeader;
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

	var do_no = obj.cells[1].innerText;
	var delivery_type_code = obj.cells[4].innerText;

	parent.document.location.href = "../../ePO/jsp/DeliveryOrderFrame.jsp?mode=" + MODE_MODIFY + "&function_id=" + parent.parent.function_id + "&delivery_type_code=" + delivery_type_code + "&do_no=" + do_no ;
	
	
}


function close_modal() {
	window.close();
	
}

function setCurrCode(obj_currency){
		var formHeader = document.formDeliveryOrderHeader;
		
		var formObject = parent.DODetailFrame.document.formDeliveryOrderDetail;
		var bean_id = "deliveryOrderBean";
	var bean_name = "ePO.DeliveryOrderBean";
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../ePO/jsp/DeliveryOrderValidate.jsp?function_type=SETCURRCODE&tran_currency=" + obj_currency.value +"&local_currency=" + formHeader.local_currency.value + "&bean_id=" + bean_id + "&bean_name=" + bean_name, false);
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

function onLoadCurrCode(obj_currency,local_currency){

		if(parent.DODetailFrame.document.getElementById("currency_label_1")!=undefined){
			parent.DODetailFrame.document.getElementById("currency_label_1").innerHTML =  obj_currency ; 
		//	parent.DODetailFrame.document.getElementById("currency_label_2").innerHTML =  obj_currency ; 
		//	parent.DODetailFrame.document.getElementById("currency_label_3").innerHTML =  obj_currency ; 
			parent.DODetailFrame.document.getElementById("currency_label_4").innerHTML =  obj_currency ; 
		}	
		if(parent.DOListFrame.document.getElementById("currency_label_5")!=undefined){
			//parent.DOListFrame.document.getElementById("currency_label_5").innerHTML =  obj_currency  ; 
			//parent.DOListFrame.document.getElementById("currency_label_6").innerHTML =  obj_currency  ; 
			parent.DOListFrame.document.getElementById("currency_label_7").innerHTML =  obj_currency  ;
			parent.DOListFrame.document.getElementById("currency_label_8").innerHTML =  local_currency  ;
		}
		
		
		
	
}

function loadDelDate(obj_date){
	//alert(obj_date);

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
		var formObject = document.formDeliveryOrderDetail;
		var ord_qty = formObject.delivery_qty.value ; 
		var unit_price = formObject.delivery_price.value ; 
	//	var tot_value = ord_qty * unit_price ; 
		var net_amount = ord_qty * unit_price ;
	
		formObject.net_amount.value  = parseFloat(net_amount).toFixed(3) ;
		formObject.net_amount.disabled=true;

}

function calculatePrice(){
		var formObject = document.formDeliveryOrderDetail;
		var ord_qty = formObject.delivery_qty.value ; 
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

		var formObject = document.formDeliveryOrderDetail;
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
		//  alert("Discount Percentage should be less than 100");
		  alert(getMessage("DISCOUNT_PER_LT_100","PO"));  
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
		 // alert("Discount Amount should be less than Gross Amount");
		  alert(getMessage("DISCOUNT_AMT_LT_GROSS","PO"));  
		  formObject.dis_value.focus();
		  }
		}
		}
		
		
		
		
}

function calculateDisAmount(){
		
		var formObject = document.formDeliveryOrderDetail;
		var dis_type = formObject.dis_type.value ; 
		var tot_value = formObject.tot_value.value
		var dis_amt = formObject.dis_amt.value ; 
		var discount_amt;
		var dis_value=0;
		
		if(dis_type=="P"){
		  discount_amt = (dis_amt/tot_value) * 100;
		  dis_value = discount_amt;
		}else if(dis_type=="A"){
		
			dis_value = dis_amt;
		}
		//alert(dis_value);
		if(isNaN(dis_value))
		formObject.dis_value.value  = 0;
		else
		formObject.dis_value.value  = parseFloat(dis_value).toFixed(3) ;
}

function calculateNetAmt(){
		
		var formObject = document.formDeliveryOrderList;
		var gross_poAmt = formObject.gross_poAmt.value ; 
		var addi_dist = formObject.addi_dist.value ; 
		var net_amt;
		var discount_amt;
	
		if(parseFloat(gross_poAmt) > 0){
			
			document.getElementById("gross_poAmt_label").innerHTML = "" + parseFloat(gross_poAmt).toFixed(3) + ""; 
		if(parseFloat(gross_poAmt) > parseFloat(addi_dist)){
		// alert('true');
		  net_amt = gross_poAmt - addi_dist;	
		  document.getElementById("net_poAmt_label").innerHTML = "" + net_amt.toFixed(3) + ""; 
		  document.getElementById("net_poAmt").value = net_amt;
		}else{
		//	alert("Discount Amount should be less than Gross Amount");
			alert(getMessage("DISCOUNT_AMT_LT_GROSS","PO"));  
			formObject.addi_dist.focus();
		}
	}	
	loadExRate();
	

}

function AdditionalDetails(bean_id, bean_name, mode) {

	var formObj = document.formDeliveryOrderHeader;
	function_id = document.forms[0].function_id.value;
	//alert("mode = "+mode);
	var tit = "TITLE";
	var retVal = window.showModalDialog("../../ePO/jsp/DOAdditionalDetails.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +  "&function_id=" + function_id + "&mode=" + mode + "&supp_code=" + formObj.supplier_code.value , "", "dialogHeight:15; dialogWidth: 50; right: 1; status: no; dialogTop :300;scroll:no");
	
	
}


function exitAdditionalDetails(){

var formObj = document.formDOAdditionalDetails;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
		//xmlDoc.loadXML(getEnhancedXMLString(formObj));
		xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObj), "text/xml");	
		xmlHttp.open("POST", "../../ePO/jsp/DeliveryOrderValidate.jsp?bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value +  "&inv_no=" + formObj.inv_no.value +  "&pmnt_term=" + formObj.pmnt_term.value +  "&inv_date=" + formObj.inv_date.value +  "&terms_conditions=" + formObj.terms_conditions.value +  "&inv_recdBy=" + formObj.inv_recdBy.value +  "&delivery_mode=" + formObj.delivery_mode.value +  "&delivery_remarks=" + formObj.delivery_remarks.value  + "&function_type=SETADDITIONALDETAILS", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		window.close();

}


function BillToDeliverDetails(bean_id, bean_name, mode) {

	var formObj = document.formPurchaseOrderHeader;
	function_id = document.forms[0].function_id.value;
	//alert("mode = "+mode);
	var tit = "TITLE";
	var retVal = window.showModalDialog("../../ePO/jsp/BillToDeliverToDetails.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +  "&function_id=" + function_id + "&mode=" + mode , "", "dialogHeight:20; dialogWidth:50; right: 1; status: no; dialogTop :300;scroll:yes");



	
}


function exitBillToDeliverDetails(){

var formObj = document.formBillToDeliverToDetails;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
		//xmlDoc.loadXML(getEnhancedXMLString(formObj));
		xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObj), "text/xml");		
		xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderValidate.jsp?bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value + "&function_type=SETBILLTODELIVERTODETAILS", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		window.close();

}


/*function exitBillToDeliverDetails(index){

var formObj = document.formBillToDeliverToDetails;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
		xmlDoc.loadXML(getEnhancedXMLString(formObj));
			
		xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderValidate.jsp?bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value + "&index=" + index.value + "&function_type=SETBILLTODELIVERTODETAILS", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		window.close();

}
*/

function BatchDetails1(bean_id, bean_name, mode,po_no,item_code,item_desc,delivery_price,delv_date,request_no,order_qty,temp_uom,temp_uom_code,po_srl_no,facility_id,store_code) {
	item_desc = decodeURIComponent(item_desc,"UTF-8");//Added by B.Badmavathi against ML-BRU-SCF-1616
	var patr = /%/g;//Added for IN070421
	item_desc=item_desc.replace(patr,"%25");//Added for IN070421
	function_id = document.forms[0].function_id.value;
	var mode_modify = 2;
	var tit = "TITLE";
	//var retVal = window.showModalDialog("../../ePO/jsp/DOBatchDetails.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +  "&function_id=" + function_id + "&mode=" + mode + "&item_desc=" + item_desc + "&order_qty=" + order_qty + "&item_code=" + item_code + "&temp_uom=" + temp_uom + "&temp_uom_code=" + temp_uom_code +  "&delv_date=" + delv_date + "&delivery_price=" + delivery_price +"&po_no=" + po_no + "&request_no=" + request_no +"&po_srl_no="+po_srl_no +"&facility_id="+ facility_id+"&store_code=" + store_code + "&mode_modify="+ mode_modify, "", "dialogHeight:20; dialogWidth: 70; right: 1; status: no; dialogTop :300;scroll:yes");
	
/*	while(retVal == undefined){
		alert('Please Press OK Button');
		var retVal = window.showModalDialog("../../ePO/jsp/DOBatchDetails.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +  "&function_id=" + function_id + "&mode=" + mode + "&item_desc=" + item_desc + "&order_qty=" + order_qty + "&item_code=" + item_code + "&temp_uom=" + temp_uom + "&temp_uom_code=" + temp_uom_code +  "&delv_date=" + delv_date + "&delivery_price=" + delivery_price +"&po_no=" + po_no + "&request_no=" + request_no +"&po_srl_no="+po_srl_no +"&facility_id="+ facility_id+"&store_code=" + store_code + "&mode_modify="+ mode_modify, "", "dialogHeight:20; dialogWidth: 70; right: 1; status: no; dialogTop :300;scroll:yes");
	
	}	
*/		 //Added by B.Badmavathi against ML-BRU-SCF-1616
	var retVal = window.showModalDialog("../../ePO/jsp/DOBatchDetails.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +  "&function_id=" + function_id + "&mode=" + mode + "&item_desc=" + encodeURIComponent(item_desc) + "&order_qty=" + order_qty + "&item_code=" + item_code + "&temp_uom=" + temp_uom + "&temp_uom_code=" + temp_uom_code +  "&delv_date=" + delv_date + "&delivery_price=" + delivery_price +"&po_no=" + po_no + "&request_no=" + request_no +"&po_srl_no="+po_srl_no +"&facility_id="+ facility_id+"&store_code=" + store_code + "&mode_modify="+ mode_modify, "", "dialogHeight:20; dialogWidth: 70; right: 1; status: no; dialogTop :300;scroll:yes");
	

}


function BatchDetails(bean_id, bean_name, mode) {

	var formObject = document.formDeliveryOrderDetail;
	var item_desc = formObject.item_desc.value ; 
	var patr = /%/g;//Added for IN070421
	item_desc=item_desc.replace(patr,"%25");//Added for IN070421
	var order_qty = formObject.delivery_qty.value ; 
	var item_code = formObject.item_code.value ; 
	var temp_uom = formObject.temp_delv_uom_desc.value ; 
	var temp_uom_code = 	formObject.delivery_uom.value;
	var po_no = formObject.po_no.value ; 
	var delv_date = formObject.delv_date.value ; 
	var delivery_price = formObject.delivery_price.value ;  
	var po_srl_no = formObject.po_srl_no.value ; 
	var request_no = formObject.request_no.value ; 
	var facility_id = formObject.facility_id.value;
	var store_code = formObject.req_store.value;
	
//	alert(facility_id);
	var mode_modify = 1;
	
	function_id = document.forms[0].function_id.value;
	
	var tit = "TITLE";
	//var retVal = window.showModalDialog("../../ePO/jsp/DOBatchDetails.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +  "&function_id=" + function_id + "&mode=" + mode + "&item_desc=" + item_desc + "&order_qty=" + order_qty + "&item_code=" + item_code + "&temp_uom=" + temp_uom + "&temp_uom_code=" + temp_uom_code +  "&delv_date=" + delv_date + "&delivery_price=" + delivery_price +"&po_no=" + po_no + "&request_no=" + request_no +"&po_srl_no="+po_srl_no + "&mode_modify="+ mode_modify +"&store_code="+store_code+ "&facility_id=" + facility_id , "", "dialogHeight:20; dialogWidth: 70; right: 1; status: no; dialogTop :300;scroll:yes");
/*	while(retVal == undefined){
		alert('Please Press OK Button');
		var retVal = window.showModalDialog("../../ePO/jsp/DOBatchDetails.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +  "&function_id=" + function_id + "&mode=" + mode + "&item_desc=" + item_desc + "&order_qty=" + order_qty + "&item_code=" + item_code + "&temp_uom=" + temp_uom + "&temp_uom_code=" + temp_uom_code +  "&delv_date=" + delv_date + "&delivery_price=" + delivery_price +"&po_no=" + po_no + "&request_no=" + request_no +"&po_srl_no="+po_srl_no + "&mode_modify="+ mode_modify +"&store_code="+store_code+ "&facility_id=" + facility_id , "", "dialogHeight:20; dialogWidth: 70; right: 1; status: no; dialogTop :300;scroll:yes");	
	}		
*/	//Added by B.Badmavathi against ML-BRU-SCF-1616
	var retVal = window.showModalDialog("../../ePO/jsp/DOBatchDetails.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +  "&function_id=" + function_id + "&mode=" + mode + "&item_desc=" + encodeURIComponent(item_desc) + "&order_qty=" + order_qty + "&item_code=" + item_code + "&temp_uom=" + temp_uom + "&temp_uom_code=" + temp_uom_code +  "&delv_date=" + delv_date + "&delivery_price=" + delivery_price +"&po_no=" + po_no + "&request_no=" + request_no +"&po_srl_no="+po_srl_no + "&mode_modify="+ mode_modify +"&store_code="+store_code+ "&facility_id=" + facility_id , "", "dialogHeight:20; dialogWidth: 70; right: 1; status: no; dialogTop :300;scroll:yes");

}

function exitBatchDetails(){
//	alert('exitBatchDetails');
	var formObj = document.formDOBatchDetails;
	var total_qty = 0;
	var free_qty = 0;
	var sample_qty = 0;
	var check;
	var totalRecords = formObj.totalRecords.value;
	// &&  eval("document.formDOBatchDetails.delivery_uom_0").value != ""
	if(eval("document.formDOBatchDetails.delivery_qty_0").value != ""  && eval("document.formDOBatchDetails.batch_id_0").value != "" && eval("document.formDOBatchDetails.expiry_date_0").value != "" && eval("document.formDOBatchDetails.trade_id_0").value != "" &&  eval("document.formDOBatchDetails.facility_id_0").value != "" && eval("document.formDOBatchDetails.req_store_code_0").value != ""  ) {
	
	for (var i = 0; i < totalRecords; i++) {
		if(eval("document.formDOBatchDetails.delivery_qty_"+i).value != "" ){
		    formObj.delivery_qty.value = eval("document.formDOBatchDetails.delivery_qty_"+i).value;
			total_qty = total_qty + parseInt(formObj.delivery_qty.value) ;
			}
			
		}
		
		for (var i = 0; i < totalRecords; i++) {
		
			for (var j = i+1; j < totalRecords; j++) {
			if(eval("document.formDOBatchDetails.delivery_qty_"+j).value != "" ){
				
				if((eval("document.formDOBatchDetails.batch_id_"+i).value ==  eval("document.formDOBatchDetails.batch_id_"+j).value) && (eval("document.formDOBatchDetails.expiry_date_"+i).value ==  eval("document.formDOBatchDetails.expiry_date_"+j).value)){
					if((eval("document.formDOBatchDetails.facility_id_"+i).value ==  eval("document.formDOBatchDetails.facility_id_"+j).value) && (eval("document.formDOBatchDetails.req_store_code_"+i).value ==  eval("document.formDOBatchDetails.req_store_code_"+j).value) ){
		    
					check = true;
					break;
				}else{
					check = false;
				}
				}else{
					check = false;
				}
				}
			}
			if(check == true) break;
		}
	
		var po_no =  formObj.po_no.value;
		var delv_date =  formObj.delv_date.value;
		var item_code = formObj.item_code.value;
		var request_no = formObj.request_no.value;
		
		if(po_no!="")
		item_code = item_code+po_no+delv_date+request_no;
		
		if(check != true){
		if(total_qty == formObj.tot_qty.value){
					var xmlHttp = new XMLHttpRequest();
					var xmlDoc="";
					//xmlDoc.loadXML(getEnhancedXMLString(formObj));
					xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObj), "text/xml");	
					xmlHttp.open("POST", "../../ePO/jsp/DeliveryOrderValidate.jsp?bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value+ "&item_code=" + item_code + "&function_type=SETBATCHVALUES", false);
					xmlHttp.send(xmlDoc);
					responseText = xmlHttp.responseText;
				//	alert(responseText);
					eval(responseText);
					window.returnValue = result;
					window.close();
		
		}else{
		//	alert("Total Quantity should be equal to Delivery Quantity");
			alert(getMessage("TOT_QTY_EQ_DELV_QTY","PO"));  
		}}else{
		//	alert("Batch Id, Expiray Date, Facility Id, Store Cannot be same");
			alert(getMessage("BAT_EXP_CANNOT_SAME","PO"));  
		}
		
	}else{
	//	alert("Atleast one batch Details has to be record");
		alert(getMessage("ATLEAST_ONE_BATCH_DTLS","PO"));  
	}
	
}


function StoreDetails(bean_id, bean_name, mode,req_no) {
//	alert(req_no);
	function_id = document.forms[0].function_id.value;
	
	var tit = "TITLE";
	var retVal = window.showModalDialog("../../ePO/jsp/StoreDetails.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +  "&function_id=" + function_id + "&mode=" + mode +"&req_no=" +req_no, "", "dialogHeight:10; dialogWidth: 50; right: 1; status: no; dialogTop :300;scroll:no");

}
function exitStoreDetails(){
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
	rem = window.showModalDialog("../../ePO/jsp/DOItemRemarks.jsp?function_id=" + parent.parent.function_id + "&remarks=" +encodeURIComponent(remarks) + "&codedisabled=" +codedisabled, "", "dialogHeight:10; dialogWidth:30; center:0; status: no; dialogLeft :75; dialogTop :250;");
	if (rem != null && codedisabled=="") {
		document.forms[0].item_remarks.value = rem;
	}
	
}
function ItemRemarks1(remarks,codedisabled) {
	remarks = decodeURIComponent(remarks,"UTF-8");
	var rem = "";
	rem = window.showModalDialog("../../ePO/jsp/DOItemRemarks.jsp?function_id=" + parent.parent.function_id + "&remarks=" +encodeURIComponent(remarks) + "&codedisabled=" +codedisabled, "", "dialogHeight:10; dialogWidth:30; center:0; status: no; dialogLeft :75; dialogTop :250;");
	if (rem != null && codedisabled=="") {
		document.forms[0].item_remarks.value = rem;
	}
	
}


function exitItemRemarks(){
	window.returnValue = document.formDOItemRemarks.item_remarks.value;
	window.close();	
}


function MoreDetails(bean_id, bean_name, mode,po_no,item_code,delv_date,request_no) {

	function_id = document.forms[0].function_id.value;
	
	var tit = "TITLE";
	var retVal = window.showModalDialog("../../ePO/jsp/DOMoreDetails.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +  "&function_id=" + function_id + "&mode=" + mode +"&po_no=" +po_no + "&item_code=" + item_code + "&delv_date=" + delv_date + "&request_no="+ request_no , "", "dialogHeight:10; dialogWidth: 50; right: 1; status: no; dialogTop :300;scroll:no");

}
function exitMoreDetails(){
	window.close();	
}

/*function RejectionRemarks(bean_id, bean_name, mode , RejectionRemarks) {

	function_id = document.forms[0].function_id.value;
	
	var tit = "TITLE";
	var retVal = window.showModalDialog("../../ePO/jsp/DORejectionRemarks.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +  "&function_id=" + function_id + "&mode=" + mode + "&RejectionRemarks=" + RejectionRemarks , "", "dialogHeight:10; dialogWidth: 30; right: 1; status: no; dialogTop :300;scroll:no");

}
function exitRejectionRemarks(){
	
	window.returnValue = document.formDORejectionRemarks.rejection_remarks.value;
	window.close();	
}
*/

/*function ItemRemarks(bean_id, bean_name, mode , ItemRemarks) {

	function_id = document.forms[0].function_id.value;
	
	var tit = "TITLE";
	var retVal = window.showModalDialog("../../ePO/jsp/DOItemRemarks.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +  "&function_id=" + function_id + "&mode=" + mode +  "&ItemRemarks=" + ItemRemarks, "", "dialogHeight:10; dialogWidth: 30; right: 1; status: no; dialogTop :300;scroll:no");

}

function exitItemRemarks(){
	window.returnValue = document.formDOItemRemarks.item_remarks.value;
	window.close();	
}
*/


function checkAppvlRef(obj_aprvlRef){
		
		var formObject = document.formPurchaseOrderDetail;
		if(obj_aprvlRef.checked){
			formObject.ref_value.disabled=false;
			document.formPurchaseOrderDetail.all.manditHidden.style.visibility="visible";		
		}
		else{
    		formObject.ref_value.disabled=true;
			document.formPurchaseOrderDetail.all.manditHidden.style.visibility="hidden";		
			document.formPurchaseOrderDetail.ref_value.value="";
		}

}



function loadCurrency(tran_currency) {
	
	var formObj = document.formDeliveryOrderHeader;
	if(formObj.currency_code.value != null && formObj.currency_code.value != "" && formObj.currency_code.value != undefined) {
		formObj.currency_code.disabled = true;
	}
	var bean_id = "deliveryOrderBean";
	var bean_name = "ePO.DeliveryOrderBean";
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");	
	xmlHttp.open("POST", "../../ePO/jsp/DeliveryOrderValidate.jsp?function_type=LOADCURRENCY&localCurrency=" + formObj.local_currency.value +"&tran_currency=" + tran_currency + "&bean_id=" + bean_id + "&bean_name=" + bean_name, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	
	
}

function loadDeptId(obj_commitCode) {
	
	var formObj = document.formPurchaseOrderDetail;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");	
	xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderValidate.jsp?function_type=LOADDEPTID&commit_code=" + obj_commitCode.value + "&bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	
}

function loadAccNo(obj_deptId) {
	
	var formObj = document.formPurchaseOrderDetail;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");	
	xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderValidate.jsp?function_type=LOADACCNO&dept_id=" + obj_deptId.value + "&commit_code=" + formObj.commit_code.value + "&bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	
}

function loadAccDesc(obj_accNo) {
	
	var formObj = document.formPurchaseOrderDetail;
	var formObj = document.formPurchaseOrderDetail;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");	
	xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderValidate.jsp?function_type=LOADACCDESC&acc_no=" + obj_accNo.value + "&commit_code=" + formObj.commit_code.value + "&dept_id=" + formObj.dept_id.value + "&bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	
}

function getUOMDesc(obj_uom) {
	
	var formObj = document.formDeliveryOrderDetail;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");	
	xmlHttp.open("POST", "../../ePO/jsp/DeliveryOrderValidate.jsp?function_type=GETUOMDESC&uom_code=" + obj_uom.value + "&bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	
}

function getCOMMNTDesc(obj_commt) {
	
	var formObj = document.formPurchaseOrderDetail;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");	
	xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderValidate.jsp?function_type=GETCOMMNTDESC&commt_code=" + obj_commt.value + "&bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	
}




function searchCodeItem(obj) {

	var formObject = document.formDeliveryOrderDetail;

	var formHeader = parent.DOHeaderFrame.document.formDeliveryOrderHeader;
	var errorPage = "../../eCommon/jsp/error.jsp";
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
			
	var arrayObject = new Array(formHeader.delivery_type, formHeader.supplier_code,formHeader.currency_code,formHeader.exc_rate);
	var names = new Array(getLabel("ePO.DOType.label", "PO"),getLabel("ePO.Supplier.label", "PO"),getLabel("ePO.TransactionCurrency.label", "PO"),getLabel("ePO.ExchangeRate.label", "PO"));
	
	
	if(formHeader.autono_yn.value=="No"){
		arrayObject[arrayObject.length] = formHeader.doc_no;
		names[names.length] = getLabel("ePO.DONo.label", "PO");
	}
	
	var blankObject = checkPOFields(arrayObject, names, parent.parent.messageFrame, errorPage);
	if (blankObject != true) {
		return;
	}
	
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.forms[0].p_language_id.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] = document.getElementById("SQL_ST_ITEM_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	//alert(returnedValues);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
		formObject.item_code.value = returnedValues[0];
		formObject.item_desc.value = returnedValues[1];
		formObject.item_desc.readOnly = true;
		formObject.add.disabled = false;
		document.formDeliveryOrderDetail.conv_fact.value = "1";
		document.formDeliveryOrderDetail.delivery_qty.focus();
	}
		
		if(formObject.item_code.value!=""){
		var bean_id = "deliveryOrderBean";
		var bean_name = "ePO.DeliveryOrderBean";
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");	
		xmlHttp.open("POST", "../../ePO/jsp/DeliveryOrderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&item_code=" + formObject.item_code.value + "&function_type=MM_UOM", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		}
		

}



function searchDetails(){
	
	var formHeader = parent.POHeaderFrame.document.formPurchaseOrderHeader;
	var errorPage = "../../eCommon/jsp/error.jsp";
		
	var arrayObject = new Array(formHeader.from_purchase_unit, formHeader.to_supplier,formHeader.purchase_type);
	var names = new Array(getLabel("ePO.PORaisedBy.label", "PO"),getLabel("ePO.Supplier.label", "PO"),getLabel("ePO.PurchaseType.label", "PO"));
	
	
	if(formHeader.autono_yn.value=="No"){
		arrayObject[arrayObject.length] = formHeader.doc_no;
		names[names.length] = getLabel("ePO.PONo.label", "PO");
	}
	
	var blankObject = checkPOFields(arrayObject, names, parent.parent.messageFrame, errorPage);
	if (blankObject != true) {
		return;
	}
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";

	var retValChk="";
	var retVal="";
	var dialogHeight= "32";
	var dialogWidth	= "70";
	var dialogTop   = "250";
	var dialogLeft  = "20";
	var center      = "0";
	var status      = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: yes " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + "; dialogLeft :" + dialogLeft ;
	var arguments	= "" ;
	//var url = "../../ePO/jsp/PurchaseOrderSearchWindowFrame.jsp";
	var url = "../../ePO/jsp/PurchaseOrderSearchWindowFrame.jsp?&po_purchase_unit="+formHeader.from_purchase_unit.value + "&mode="+formHeader.mode.value +"&po_no="+formHeader.doc_no.value;

	retVal = window.showModalDialog(url,arguments,features);	
	//alert(formHeader.po_mode.value);
    if (retVal!= null){
	 retValChk = retVal
     }
	if(retValChk=="ADD"){

		var html = "<html><body><form name='dummyFormSubmit' id='dummyFormSubmit'  action='../../ePO/jsp/DeliveryOrderDetails.jsp?&function=edit"+"&addToList=true"+"&po_mode=R' method='post'>";
		html+="</form></body></html>";
		parent.frames[3].document.body.insertAdjacentHTML("AfterBegin",html);
		parent.frames[3].dummyFormSubmit.submit();
		//parent.POListFrame.document.location.href="../../ePO/jsp/PurchaseOrderFrame.jsp";
		//parent.POHeaderFrame.document.formPurchaseOrderHeader.encounter_id.disabled = true;
		//parent.POHeaderFrame.document.formPurchaseOrderHeader.sal_trn_type.disabled = true;
		//parent.POHeaderFrame.document.formPurchaseOrderHeader.patient_id.disabled = true;

	}
}

//04/06/12
function ReloadPurchaseOrderWindow(){
		var criteriaformObj =document.formPurchaseOrderSearchWindowCriteria;

		  criteriaformObj.item_desc.value     =  "";
		  criteriaformObj.item_code.value     =  "";
		 // criteriaformObj.Store.value       =  "";
		   
		 // criteriaformObj.Facility.value   =  "";
		 // criteriaformObj.PurchaseUnit.value   =  "";	
		//  criteriaformObj.ReqDocNO.value   =  "";
		  
		  criteriaformObj.search.click();
		  criteriaformObj.item_desc.focus();
}

//05/06/12
/*function enable_doc(object, batchcount){

	var doc_no = object.value;
	var formObj = document.formPurchaseOrderSearchWindowResult;

	for (var index=0; index < batchcount; index++ ){

		var checkobj = eval("formObj.doc_no_"+doc_no+"_"+index);
		var itemQtyobj = eval("formObj.order_qty_"+doc_no+"_"+index);

		if(object.checked == true ){
			if (checkobj!= undefined && itemQtyobj!= undefined){
			checkobj.checked = true;
			//itemQtyobj.value=eval("formObj.req_qty_"+doc_no+"_"+index).value;
			itemQtyobj.value=eval("formObj.pending_qty_"+doc_no+"_"+index).value;
			checkobj.disabled=false;
			itemQtyobj.disabled=false;			
			}
			
		}else{
			if (checkobj!= undefined && itemQtyobj!= undefined){
			checkobj.checked = false;
			itemQtyobj.value="";
			checkobj.disabled=true;
			itemQtyobj.disabled=true;
			}
			
		}
		
	}
}
*/
function getItemQty(obj,index){

   var formObj = document.formPurchaseOrderSearchWindowResult;
   var req_no  = obj.value;
   var checkobj = eval("formObj.doc_no_"+req_no+"_"+index);
   var itemQtyobj = eval("formObj.order_qty_"+req_no+"_"+index);
   //var reqqtyobj = eval("formObj.req_qty_"+req_no+"_"+index);
   var reqqtyobj = eval("formObj.pending_qty_"+req_no+"_"+index);

	if (checkobj.checked == true){
	 itemQtyobj.value = reqqtyobj.value;
	 itemQtyobj.disabled=false;
	}
	else{
	itemQtyobj.value ="";
	itemQtyobj.disabled=true;
	}
}
function ItemBatch(){
}
//06/06/12
function modeorder(obj){

//alert(obj)
 var formObject = document.formPurchaseOrderHeader;
 //alert(formObject.po_mode.value);
 
             var reqid_label = document.getElementById('reqid');
			 var reqiddocno = document.getElementById('reqiddocno');
			 var doc_search = document.getElementById('doc_search');
			 
			  if(formObject.po_mode.value == "R")
			 { 
			 reqid_label.style.visibility ='visible';
			 reqiddocno.style.visibility ='visible';
			 doc_search.style.visibility ='visible';
			 Blanket_order.style.visibility='hidden';
			 parent.POListFrame.document.location.href = "../../ePO/jsp/PurchaseOrderList.jsp?po_mode=" + formObject.po_mode.value ;
			 
			 }else{
			 reqid_label.style.visibility ='hidden';
	         reqiddocno.style.visibility ='hidden';
			 doc_search.style.visibility ='hidden';
			 Blanket_order.style.visibility='visible';
			 parent.POListFrame.document.location.href = "../../ePO/jsp/PurchaseOrderList.jsp";
			 }


}

function loadPOMode(obj){

//alert(obj);
 var formObject = document.formPurchaseOrderHeader;
 //alert(formObject.po_mode.value);
 
             var reqid_label = document.getElementById('reqid');
			 var reqiddocno = document.getElementById('reqiddocno');
			 var doc_search = document.getElementById('doc_search');
			 
			  if(formObject.po_mode.value == "R")
			 { 
			 reqid_label.style.visibility ='visible';
			 reqiddocno.style.visibility ='visible';
			 doc_search.style.visibility ='visible';
			 Blanket_order.style.visibility='hidden';
			 
			 }else{
			 reqid_label.style.visibility ='hidden';
	         reqiddocno.style.visibility ='hidden';
			 doc_search.style.visibility ='hidden';
			 Blanket_order.style.visibility='visible';
			 }


}



function searchItemCode(obj) {
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
		document.formPurchaseOrderSearchWindowCriteria.item_code.value =""
	}
}

var hide = 'no';

function resizeFrames(){	

	var fullFrame;

	if (parent.DeliveryOrderFrmS)
	{
		fullFrame = parent.DeliveryOrderFrmS;
	}

	if(hide == 'no')
	{
		if (parent.DOBlankFrame)
		{
			if(parent.DOBlankFrame.document.getElementById('hideImg'))
			{
				parent.DOBlankFrame.document.getElementById('hideImg').src='../../eST/images/POright.png'
				fullFrame.cols = '0px,14px,*';
				parent.DOListFrame.document.getElementById('doList').style.width = "1340px";
				hide='yes';
			}	
		}	
	}
	else if(hide == 'yes')
	{
		if (parent.DOBlankFrame){
			if(parent.DOBlankFrame.document.getElementById('hideImg'))
			{
				parent.DOBlankFrame.document.getElementById('hideImg').src='../../eST/images/POleft.png'			
				fullFrame.cols = '350px,14px,*';
				parent.DOListFrame.document.getElementById('doList').style.width = "980px";
				hide='no';
			}
		}
	}
	
}



function perChange(obj_dis_type){
	if(obj_dis_type.value == "P")
		document.formDeliveryOrderDetail.all.PerHide.style.visibility="visible";
	else
		document.formDeliveryOrderDetail.all.PerHide.style.visibility="hidden";
}



function addRowToTable()
{  
	
/*	alert('addRowToTable');
	var formObj = document.formDeliverySchedule;

	var totalRecords = formObj.totalRecords.value;

		var table=document.getElementById("myTable");
		var lastRow = table.rows.length;
		alert(lastRow);
		var iteration = lastRow;	
		var row = table.insertRow(lastRow);

		var cell1=row.insertCell(0);

		var el = document.createElement('input');
		el.setAttribute('type', 'text');
		el.setAttribute('name', 'order_qty' + iteration);
		el.setAttribute('size', '10');
		cell1.appendChild(el).innerHTML;

		var cell2=row.insertCell(1);
		var el1 = document.createElement('input');
		el1.setAttribute('type', 'text');
		el1.setAttribute('name', 'del_due_dt' + iteration);
		el1.setAttribute('size', '10');
		el1.onblur = function() {addRowToTable();};
		//cell2.appendChild(el1).innerHTML;
		
		var el2 = document.createElement('img');
	//	el2.setAttribute('src', "../../eCommon/images/CommonCalendar.gif");
		el2.src = "../../eCommon/images/CommonCalendar.gif" ;
		el2.onclick = function() {showCalendar('del_due_dt'+ iteration);};
		cell2.appendChild(el1).innerHTML;
		cell2.appendChild(el2).innerHTML;

		*/
  
}


function checkCanAuthorize() {
	var bean_id = "deliveryOrderBean";
	var bean_name = "ePO.DeliveryOrderBean";

//	if (request_by_pu.value == "") {
//		return;
//	}
//	var arrayObject = new Array();
	//arrayObject[0] = request_by_pu;
	assignBean(f_query_add_mod.DOHeaderFrame.document.formDeliveryOrderHeader);
	var xmlDom = new ActiveXObject("Microsoft.XMLDom");
	var xmlHttp = new XMLHttpRequest();
	xmlStr = getXMLString(null);
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "../../ePO/jsp/DeliveryOrderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=CHECKFORAUTHORIZE", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
//	alert(responseText);
	eval(responseText);
}

function setAuthorize(authorizeValue) {
	f_query_add_mod.DOHeaderFrame.document.formDeliveryOrderHeader.authorize_yn.value = authorizeValue;
}


function docnoEnableYN(purchase_unit) {
		if (purchase_unit.value != null) {
		
			var bean_id = "purchaseOrderBean";
			var bean_name = "ePO.PurchaseOrderBean";
			var xmlDom = new ActiveXObject("Microsoft.XMLDom");
			var xmlHttp = new XMLHttpRequest();
			var xmlStr = getXMLString(null);
			xmlDom.loadXML(xmlStr);
			xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&purchase_unit=" + purchase_unit.value + "&function_type=DOCNO_ENABLE_YN", false);
			xmlHttp.send(xmlDom);
			responseText = xmlHttp.responseText;
			eval(responseText);
			
	} 
}
function checkUOMConvFactor() {

	var formObj = document.formDeliveryOrderDetail;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");	
	//xmlHttp.open("POST", "../../ePO/jsp/DeliveryOrderValidate.jsp?uom_code=" + formObj.uom.value + "&pur_uom_code=" + formObj.temp_uom_code.value + "&bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value + "&function_type=CHECKUOMCONVFACTOR" + "&item_code=" + formObj.item_code.value, false);
	//Added by suresh.r on 11-03-2015 against ML-BRU-SCF-1476(Inc 52684),ML-BRU-SCF-1385.1(Inc 52685)
	xmlHttp.open("POST", "../../ePO/jsp/DeliveryOrderValidate.jsp?uom_code=" + formObj.uom.value + "&pur_uom_code=" + formObj.delivery_uom.value + "&bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value + "&function_type=CHECKUOMCONVFACTOR" + "&item_code=" + formObj.item_code.value, false);
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	eval(responseText);
	if (!result) {
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "PO");
		//formObj.uom.value = formObj.temp_uom_code.value;
		//formObj.uom.focus();
		formObj.delivery_uom.value = formObj.temp_uom_code.value;
		formObj.delivery_uom.focus();
		
		setUOMConvFactor("1");
	}
	//out.println("document.getElementById("temp_delv_uom_code").value = '" +  uom_code +"'; ");
	//	out.println("document.getElementById("temp_delv_uom_desc").value = '" +  uom_desc +"'; ");
}

function setUOMConvFactor(_value) {
	document.formDeliveryOrderDetail.conv_fact.value = _value;
}

function setUOMConvFactor1(_value,_rulestring) {

	document.getElementById("conv_fact").value = _value;
}

function onadd(){
	
    var formObj           = document.formPOItemDetailResult;
	var formCriteria      = parent.framePOItemDetailCriteria.document.formPOItemDetailCriteria;	
	var formObject;

	var total =formObj.total.value;

	var item_arr   = new Array;
	var arrayIndex = 0;	
	var req_no = "";
	var batchcount ="";
	
	var tran_arr   = new Array;
	var arrayIndex1 = 0;	
	var req_no1 = "";
	var batchcount1 ="";

for (var i = 0; i < total; i++ ){

		var reqnoobj	= eval("formObj.doc_no_check_"+i);
			
			if(reqnoobj.checked && reqnoobj.checked == true ){
				
				req_no1 = reqnoobj.value;

				batchcount1 = eval("formObj.batchcount_"+req_no1+"_"+i).value;
			//	alert(batchcount1);
				for (var index=0;index < batchcount1;index++ ){	
						if(index == 0){
						
							var checkobj  = eval("formObj.doc_no_"+req_no1+"_"+index);

							if (checkobj!= undefined && checkobj.checked == true){
								
								var myClassObj = new ItemBatch();

								myClassObj.trans_currency    	 = eval("formObj.trans_currency_"+req_no1+"_"+index).value;
								tran_arr[arrayIndex1++]  = myClassObj;
							}
							}else{
								break;
							}
							
					}
			}
	}


for (var i=0;i<tran_arr.length ;i++ ){
		var tran_batch = tran_arr[i];
		for(var j=i+1;j<tran_arr.length;j++){
			var tran_batch1 = tran_arr[j];
			if(tran_batch.trans_currency != tran_batch1.trans_currency){
				//	alert("Transaction Currency should be same");  
					alert(getMessage("TRANS_CURR_SHOULD_SAME","PO"));  
					return;
			}
		}
	
}


	for (var i = 0; i < total; i++ ){

		var reqnoobj	= eval("formObj.doc_no_check_"+i);
			
			if(reqnoobj.checked && reqnoobj.checked == true ){
				
				po_no = reqnoobj.value;

				batchcount = eval("formObj.batchcount_"+po_no+"_"+i).value;
				for (var index=0;index < batchcount;index++ ){	

							var checkobj  = eval("formObj.doc_no_"+po_no+"_"+index);

							if (checkobj!= undefined && checkobj.checked == true){
								
								var myClassObj = new ItemBatch();

								myClassObj.po_no            = eval("formObj.doc_no_"+po_no+"_"+index).value ;
								myClassObj.item_code         = eval("formObj.item_code_"+po_no+"_"+index).value;						
								myClassObj.req_qty           = eval("formObj.req_qty_"+po_no+"_"+index).value;								
								myClassObj.delv_date     	 = eval("formObj.delv_date_"+po_no+"_"+index).value;
								myClassObj.request_no     	 = eval("formObj.req_no_"+po_no+"_"+index).value;
								
								item_arr[arrayIndex++]  = myClassObj;
							}		
					}
			}
	}
	if (item_arr.length == 0){
		alert(getMessage("ATLEAST_ONE_TRANS","PO"));  
		return;
	}

	for (var i=0;i<item_arr.length ;i++ ){
		var item_batch = item_arr[i];
		po_no = item_batch.po_no;
		if ((item_batch.order_qty == '' ) || (parseInt(item_batch.order_qty) == '0')){
			if (item_batch.order_qty == '' ){
				alert(getMessage("ORDER_QTY_CANNOT_BLANK","PO"));
				eval("formObj.order_qty_"+po_no+"_"+i).focus();	
				return;
			}
			if (parseInt(item_batch.order_qty) == '0'){
				alert(getMessage("ORDER_QTY_CANNOT_ZERO","PO"));
				eval("formObj.order_qty_"+po_no+"_"+i).focus();	
				return;
			}
		}else if ((item_batch.pending_qty*1) < (item_batch.order_qty*1)){
		//	alert("Order Quantity should not be greater than pending quantity");
			alert(getMessage("ORDER_QTY_NOT_GRT_MAX_REQ_QTY","PO"));
			eval("formObj.order_qty_"+po_no+"_"+i).focus();			
			return;
		}
	}
	var loc_batch_string ="";
	for (var i=0;i<item_arr.length ;i++ ){
		var item_batch = item_arr[i];
		//loc_batch_string = loc_batch_string+"||"+item_batch.req_no+";"+item_batch.item_code+";"+item_batch.delv_date;
		loc_batch_string = loc_batch_string+"||"+item_batch.po_no+";"+item_batch.item_code+";"+item_batch.delv_date+";"+item_batch.request_no;
		
		
	}
	formCriteria.loc_batch_string.value = loc_batch_string;	
	var bean_id = "deliveryOrderBean";
	var bean_name = "ePO.DeliveryOrderBean";
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getEnhancedXMLString(formCriteria));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");	
	xmlHttp.open("POST", "../../ePO/jsp/DeliveryOrderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +"&function_type=LOAD_DETAILS_NEW" +"&tran_currency_temp=" +formObj.tran_currency_temp.value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
//	alert(responseText);
	eval(responseText);
   if(result){		
		document.parentWindow.returnValue ="ADD"+","+flag;
		document.parentWindow.close();
	}else{
	//	alert("Duplicate Purchase Order not allowed");
		alert(getMessage("DUPLICATE_PO_NOT_ALLOW","PO"));
	}	
}


function Load_PurchaseOrderDetails(obj,supp_code){

	var formHeader = parent.DOHeaderFrame.document.formDeliveryOrderHeader;
	var errorPage = "../../eCommon/jsp/error.jsp";
		
	var arrayObject = new Array(formHeader.delivery_type, formHeader.supplier_code);
	var names = new Array(getLabel("ePO.DOType.label", "PO"),getLabel("ePO.Supplier.label", "PO"));
	
	var blankObject = checkPOFields(arrayObject, names, parent.parent.messageFrame, errorPage);
	if (blankObject != true) {
		return;
	}
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	
	
/*	if(supp_code.value==""){
		alert("APP-000001 Supplier Cannot be blank");
		return;
	}
*/	
	
	var formObject = parent.DOListFrame.document.formDeliveryOrderList;
	formObject.reset();
//	alert(formObject);
	
	var store_code =document.formDeliveryOrderHeader.store_code.value;
	var mode =document.formDeliveryOrderHeader.mode.value;
	var tran_currency = document.formDeliveryOrderHeader.currency_code.value;
	var tran_currency_temp = document.formDeliveryOrderHeader.currency_code.value;
	
/*	var bean_id = "deliveryOrderBean";
	var bean_name = "ePO.DeliveryOrderBean";
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../ePO/jsp/DeliveryOrderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +"&function_type=CHECK_REQ_KEY" +"&tran_currency_temp=" +tran_currency_temp, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	
	if(result){
		var title = "Confirm";
		var header = "Do you wish to refresh Purchase Order Search Details ? ";
		confirmType = confirmWindow(title,header);
		
		if(confirmType == "Yes"){
			//var tran_currency = "";
			var tran_currency = document.formDeliveryOrderHeader.currency_code.value;
		} else {
			//var tran_currency = document.formDeliveryOrderHeader.currency_code.value;
			return;
		}
	*/	
	/*	var poRefresh = confirm("Do you wish to refresh Purchase Order Search Details ? ");
		if(poRefresh == true){
			var tran_currency = "";
		}else{
			var tran_currency = document.formDeliveryOrderHeader.currency_code.value;
		}
	*/	
//	}
	
	var po_no="";
	var pur_unit_code="";	
	var local_currency="";
	var trans_currency="";
	var conversion_rate="";


	var retVal = "";
	var retValChk = "";
	var dialogHeight = "32";
	var dialogWidth = "70";
	var dialogTop = "210";
	var center = "1";
	var status = "no";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments = "";
	var url = "../../ePO/jsp/POItemDetailFrame.jsp?po_number=" + obj.value + "&supp_code="+supp_code.value + "&store_code="+store_code+ "&mode="+mode + "&tran_currency=" + tran_currency + "&tran_currency_temp=" + tran_currency_temp;
	retVal = window.showModalDialog(url, arguments, features);	
	
	if (retVal!= null){
	 retValChk = retVal
     }
	 var retSplit = retValChk.split(",");
	if(retSplit[0]=="ADD"){
		
		var html = "<html><body><form name='dummyFormSubmit' id='dummyFormSubmit'  action='../../ePO/jsp/DeliveryOrderList.jsp?&function=edit"+"&addToList=true"+"&po_mode=R' method='post'>";
		html+="</form></body></html>";
		parent.frames[3].document.body.insertAdjacentHTML("AfterBegin",html);
		parent.frames[3].dummyFormSubmit.submit();

	}
	if(retSplit[1] != null){
		loadCurrency(retSplit[1]);
	}
	
}

function enable_doc(object, batchcount,cnt){

	var doc_no = object.value;
	var formObj = document.formPOItemDetailResult;

	for (var index=0; index < batchcount; index++ ){
		var checkobj = eval("formObj.doc_no_"+doc_no+"_"+index);
		var checkobj1 = eval("formObj.doc_no_select_"+cnt);
		
		if(object.checked == true ){
			if (checkobj!= undefined ){
				//checkobj.checked = true;
				checkobj.disabled=false;
				checkobj1.disabled=false;
			}
		}else{
			if (checkobj!= undefined){
				checkobj.checked = false;
				checkobj.disabled=true;
				checkobj1.disabled=true;
				checkobj1.checked=false;
			}
		}
		
	}
}

function enable_all_doc(object, batchcount){

	var doc_no = object.value;
	var formObj = document.formPOItemDetailResult;

	for (var index=0; index < batchcount; index++ ){
		var checkobj = eval("formObj.doc_no_"+doc_no+"_"+index);
		if(object.checked == true ){
			if (checkobj!= undefined ){
				checkobj.checked = true;
				checkobj.disabled=false;
			}
		}else{
			if (checkobj!= undefined){
				checkobj.checked = false;
				//checkobj.disabled=true;
			}
		}
		
	}
}

function checkWithPOQty(obj,poQty){
	var formObject = document.formDeliveryOrderDetail;
	if(parseInt(obj.value) > parseInt(poQty)){
	//	alert("Delivery Quantity cannot be greater than Pending Quantity");
		alert(getMessage("DELV_QTY_NOT_GR_PEN_QTY","PO"));
		formObject.delivery_qty.focus();
	}
}



function loadStore(obj,ct){

var formObj = document.formDOBatchDetails;

	var bean_id = "deliveryOrderBean";
	var bean_name = "ePO.DeliveryOrderBean";
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");	
	xmlHttp.open("POST", "../../ePO/jsp/DeliveryOrderValidate.jsp?function_type=LOADSTORE&facility_id=" + obj.value + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&count=" + ct , false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
//	alert(responseText);
	eval(responseText);

}


function loadUOM(obj,item_code,ct,delivery_uom_code){

var formObj = document.formDOBatchDetails;

	var bean_id = "deliveryOrderBean";
	var bean_name = "ePO.DeliveryOrderBean";
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");	
	xmlHttp.open("POST", "../../ePO/jsp/DeliveryOrderValidate.jsp?function_type=LOADUOM&store_code=" + obj.value + "&item_code=" + item_code + "&count=" + ct+ "&delivery_uom_code=" + delivery_uom_code + "&bean_id=" + bean_id + "&bean_name=" + bean_name, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
//	alert(responseText);
	eval(responseText);

}

function checkDelvUOM(ct){
	
	var formObj = document.formDOBatchDetails;
	var delv_price = eval("document.formDOBatchDetails.delivery_price_" + ct); 
	var delv_uom = eval("document.formDOBatchDetails.delivery_uom_" + ct);
	var req_store = eval("document.formDOBatchDetails.req_store_code_" + ct);
	if(req_store.value != null && req_store.value != ""){
		if(delv_uom.value != "" && delv_uom.value != null){
		//	delv_price.value = formObj.do_delivery_price.value;
		}else{
		//	alert("Item - Store combination does not exist");
			alert(getMessage("ITEM_STORE_DOES_NOT_EXIST","PO"));
			req_store.focus();
		}
	}
}


function showCalendarLocal(id) {
	var flag = showCalendar(id);
	document.getElementById(id).focus();
	return flag;
}

function getBatchIDFromExpiryDate(expiry_date_object, i) {
		
	var formObj = document.formDOBatchDetails;
	var sys_date = formObj.sys_date;
	sys_date	= sys_date.value;
	var batch_id_applicable_yn = formObj.batch_id_applicable_yn;
//	alert("batch_id_applicable_yn = "+batch_id_applicable_yn);
	
	var locale = formObj.language_id.value; 
	
	if(locale != "en") {
		sys_date = convertDate(sys_date, "DMY", locale, "en");
	expiry_date_object = convertDate(expiry_date_object.value, "DMY", locale, "en");
	
	}
	else{
	sys_date = sys_date;
	expiry_date_object = expiry_date_object.value;
	}
//	alert("expiry_date_object = "+expiry_date_object);
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
				//document.getElementById("batch_id_" + i).value = result;
				formObj.elements("batch_id_"+i).value = result;
			}
			// begin
			if(formObj.elements("expiry_date_" + i).value != formObj.elements("shelf_life_exp_date_" + i).value){  //Added for #Inc no:40591 on 07-JUN-2013
			getShelfLifeExpiryDate(expiry_date_object,i);
			}
			// end
		} else {
			alert(getMessage("NOT_LESS_THAN_SYSDATE", "PO"));
		//	for (var i = 0; i < 10; i++) {
				formObj.elements("expiry_date_"+i).select();
				formObj.elements("expiry_date_"+i).focus();
				formObj.elements("expiry_date_"+i).value = "";
				return false;
		//	}
		}
	}
	else {
		//	for (var i = 0; i < 10; i++) {
				formObj.elements("expiry_date_"+i).select();
				formObj.elements("expiry_date_"+i).focus();
				formObj.elements("expiry_date_"+i).value = "";
				return false;
		//	}
	}
	
}
function loadExRate(){
	
		if(parent.DOHeaderFrame.document.getElementById("exc_rate") != undefined ){
			var formHeader = parent.DOHeaderFrame.document.formDeliveryOrderHeader;
			var formList = document.formDeliveryOrderList;
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

function loadExRateHdr(){
	
		if(parent.DOHeaderFrame.document.getElementById("exc_rate") != undefined ){
			var formHeader = parent.DOHeaderFrame.document.formDeliveryOrderHeader;
			var formList = parent.DOListFrame.document.formDeliveryOrderList;
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
				formList.all.net_poAmt_label_lc.innerHTML = "" + netLC.toFixed(3) + ""; 
				formList.all.net_poAmt_lc.value = netLC;
				
			}	
		}
		}		
		}
	
}


function checkValidate(obj_toDate){
	var formObject = document.formPOItemDetailCriteria;
	
	var toDateArray;
	var fromDateArray;
	var toDate = obj_toDate.value;
	var fromDate = formObject.from_doc_date.value;
	if (fromDate.length > 0 && toDate.length > 0) {
		toDateArray = fromDate.split("/");
		fromDateArray = toDate.split("/");
		var toDateObject = new Date(toDateArray[2], (toDateArray[1] - 1), toDateArray[0]);
		var fromDateObject = new Date(fromDateArray[2], (fromDateArray[1] - 1), fromDateArray[0]);
		if (Date.parse(fromDateObject) < Date.parse(toDateObject)) {
		//	alert("To date should be greater than or equal to From date");
			alert(getMessage("NOT_LESS_THAN_SYSDATE", "PO"));
				formObject.to_doc_date.select();
				formObject.to_doc_date.focus();
			
		}
	
	}
	
}
function checkValidateQryDate(){

	var formObject = document.formDeliveryOrderQueryCriteria;
	
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
			alert(getMessage("TO_DATE_GR_FROM_DATE", "PO"));
				formObject.to_do_date.select();
				formObject.to_do_date.focus();
		}else{
			document.formDeliveryOrderQueryCriteria.submit();
		}
	
	}else{
		document.formDeliveryOrderQueryCriteria.submit();
	}
	
}

function checkValidatePODate(obj_toDate){
	var formObject = document.formPOItemDetailCriteria;
	
	var toDateArray;
	var fromDateArray;
	var toDate = obj_toDate.value;
	var fromDate = formObject.from_doc_date.value;
	if (fromDate.length > 0 && toDate.length > 0) {
		toDateArray = fromDate.split("/");
		fromDateArray = toDate.split("/");
		var toDateObject = new Date(toDateArray[2], (toDateArray[1] - 1), toDateArray[0]);
		var fromDateObject = new Date(fromDateArray[2], (fromDateArray[1] - 1), fromDateArray[0]);
		if (Date.parse(fromDateObject) < Date.parse(toDateObject)) {
		//	alert("To date should be greater than or equal to From date");
			alert(getMessage("TO_DATE_GR_FROM_DATE", "PO"));
				formObject.to_doc_date.select();
				formObject.to_doc_date.focus();
				return;
		}
	
	}
	
}


function chekValidateFromDate(){
   var from_doc_date    =  document.formPOItemDetailCriteria.from_doc_date.value ;
   var to_doc_date =  document.formPOItemDetailCriteria.to_doc_date.value ;
  
    if(to_doc_date != "" && from_doc_date != ""){
	   if(!isBefore(from_doc_date,to_doc_date,"DMY",document.forms[0].language_id.value)) {
       // alert(getMessage("FM_DATE_GR_TO_DATE", "ST"));
	  // alert("From Date cannot be greater than To date");
	   alert(getMessage("FM_DATE_GR_TO_DATE", "PO"));
	   document.formPOItemDetailCriteria.from_doc_date.focus();
		return ;
	}  else {
       document.formPOItemDetailCriteria.submit();
	   }
	} else {
       document.formPOItemDetailCriteria.submit();
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

function enableBatch(obj){
	
	if(obj != null){
		document.getElementById("batch_td").disabled=false;
	}else{
		document.getElementById("batch_td").disabled=true;
	}
	
}


function checkMaxLengthPaste(obj,maxlength)
{


                var len; 
                var txt = clipboardData.getData("Text"); 
                txt = obj.value + txt 
                len = parseInt(txt.length); 
                if ( len >  maxlength ) 
                { 
                        event.returnValue=false; 
                        txt = txt.substring(0, maxlength);                
                        obj.value = txt;                           
                        
                } 
          
    
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
		dataValueArray[2] = "DLVORD";
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

function getShelfLifeExpiryDate(expiry_date_object,i){

	var formObj = document.formDOBatchDetails;
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
		formObj.elements("shelf_life_exp_date_" + i).value = formObj.elements("expiry_date_" + i).value; //Added for #Inc no:40591 on 07-JUN-2013
		if (Date.parse(fromDateObject) <= Date.parse(toDateObject)) {
			var sh_life = confirm("Expiry Date "+toDate+" is not greater than the Shelf Life period "+fromDate+" . Do you want to Continue ? ");
			if(sh_life == false){
				formObj.elements("expiry_date_" + i).focus();
				formObj.elements("shelf_life_exp_date_" + i).value = ""; //Added for #Inc no:40591 on 07-JUN-2013
				return;
			}	
		}
	}	
}

//Added by B.Badmavathi against ML-BRU-SCF-1616 beg
function CheckForSpecialChars1(event) {
	var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ/:-";
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) {
		return false;
	}  // Not a valid key
	if ((event.keyCode >= 97) && (event.keyCode <= 122)) {
		return (event.keyCode -= 32);
	}
	return true;
} //Added by B.Badmavathi against ML-BRU-SCF-1616 end

