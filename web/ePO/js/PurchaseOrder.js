var xmlDom;
var xmlHttp;
var finalizeType = "No";
var prevObj = null;
var prevColor = null;

function create() {

	f_query_add_mod.location.href = "../../ePO/jsp/PurchaseOrderFrame.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
}

function reset() {
	f_query_add_mod.location.reload();
}

function query() {
	f_query_add_mod.location.href = "../../ePO/jsp/PurchaseOrderQueryFrame.jsp?function_id=" + function_id;
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
	//alert('deleterecord');
	if( f_query_add_mod.POHeaderFrame==undefined){
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
	}else{
	var formHeader = f_query_add_mod.POHeaderFrame.document.formPurchaseOrderHeader;
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
	var formObject = document.formPurchaseOrderDetail;
	var formHeader = parent.POHeaderFrame.document.formPurchaseOrderHeader;
	if(formHeader.blanket_po_yn.checked){
		formHeader.blanket_po_yn.value = "Y";
		var arrayObject = new Array(formHeader.from_purchase_unit, formHeader.to_supplier,formHeader.purchase_type,formHeader.po_mode,formHeader.currency_code,formHeader.exc_rate,formHeader.valid_upto);
		var names = new Array(getLabel("ePO.PORaisedBy.label", "PO"),getLabel("ePO.Supplier.label", "PO"),getLabel("ePO.PurchaseType.label", "PO"),getLabel("ePO.POMode.label", "PO"),getLabel("ePO.TransactionCurrency.label", "PO"),getLabel("ePO.ExchangeRate.label", "PO"),getLabel("ePO.ValidUpto.label", "PO"));
		if(formHeader.autono_yn.value=="No"){
			arrayObject[arrayObject.length] = formHeader.doc_no;
			names[names.length] = getLabel("ePO.PONo.label", "PO");
		}		
		var blankObject = checkPOFields(arrayObject, names, parent.parent.messageFrame, errorPage);
		if (blankObject != true) {
			return;
		}		
	}else{
		formHeader.blanket_po_yn.value = "N";
		var arrayObject = new Array(formHeader.from_purchase_unit, formHeader.to_supplier,formHeader.purchase_type,formHeader.po_mode,formHeader.currency_code,formHeader.exc_rate);
		var names = new Array(getLabel("ePO.PORaisedBy.label", "PO"),getLabel("ePO.Supplier.label", "PO"),getLabel("ePO.PurchaseType.label", "PO"),getLabel("ePO.POMode.label", "PO"),getLabel("ePO.TransactionCurrency.label", "PO"),getLabel("ePO.ExchangeRate.label", "PO"));
		if(formHeader.autono_yn.value=="No"){
			arrayObject[arrayObject.length] = formHeader.doc_no;
			names[names.length] = getLabel("ePO.PONo.label", "PO");
		}
		var blankObject = checkPOFields(arrayObject, names, parent.parent.messageFrame, errorPage);
		if (blankObject != true) {
			return;
		}
	}
	
	var errorPage = "../../eCommon/jsp/error.jsp";
	if(formObject.app_ref.checked){
		var arrayObject = new Array(formObject.item_desc,formObject.order_qty,formObject.uom,formObject.ref_value,formObject.del_date);
		var names = new Array(getLabel("Common.item.label", "Common"),getLabel("ePO.OrderQty.label", "PO"),getLabel("ePO.OrderUOM.label", "PO"),getLabel("ePO.ApprovalReference.label", "PO"),"Delivery Schedule Date");
		if(formHeader.autono_yn.value=="No"){
			arrayObject[arrayObject.length] = formHeader.doc_no;
			names[names.length] = getLabel("ePO.PONo.label", "PO");
		}
		if(formObject.budget_check_yn.value=="Y"){
			arrayObject[arrayObject.length] = formObject.commit_code;
			names[names.length] = getLabel("ePO.CommitmentCode.label", "PO");
			arrayObject[arrayObject.length] = formObject.dept_id;
			names[names.length] = getLabel("ePO.DeptId.label", "PO");
			arrayObject[arrayObject.length] = formObject.acc_no;
			names[names.length] = getLabel("ePO.AcctNumber.label", "PO");
			
		}		
		var blankObject = checkPOFields(arrayObject, names, parent.parent.messageFrame, errorPage);
		if (blankObject != true) {
			return;
		}
	}else {	
		var arrayObject = new Array(formObject.item_desc,formObject.order_qty,formObject.uom,formObject.del_date);
		var names = new Array(getLabel("Common.item.label", "Common"),getLabel("ePO.OrderQty.label", "PO"),getLabel("ePO.OrderUOM.label", "PO"),"Delivery Schedule Date");
			
		if(formHeader.autono_yn.value=="No"){
			arrayObject[arrayObject.length] = formHeader.doc_no;
			names[names.length] = getLabel("ePO.PONo.label", "PO");
		}
		if(formObject.budget_check_yn.value=="Y"){
			arrayObject[arrayObject.length] = formObject.commit_code;
			names[names.length] = getLabel("ePO.CommitmentCode.label", "PO");
			arrayObject[arrayObject.length] = formObject.dept_id;
			names[names.length] = getLabel("ePO.DeptId.label", "PO");
			arrayObject[arrayObject.length] = formObject.acc_no;
			names[names.length] = getLabel("ePO.AcctNumber.label", "PO");			
		}		
		var blankObject = checkPOFields(arrayObject, names, parent.parent.messageFrame, errorPage);
		if (blankObject != true) {
			return;
		}
	}	
	
	//var formHeader = parent.POHeaderFrame.document.formPurchaseOrderHeader;
	var store_code = formHeader.request_by_pu.value;
	var to_store_code = formHeader.request_on_supp.value;
	var item_code = formObject.item_code.value;
	var bean_id = "purchaseOrderBean";
	var bean_name = "ePO.PurchaseOrderBean";

	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));	
	
	xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&item_code=" + item_code + "&store_code=" + store_code + "&function_type=ADDITEMRECORD" + "", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;	
	eval(responseText);
	
	if(formObject.budget_check_yn.value=="Y"){	
		xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&commit_code=" + formObject.commit_code.value + "&dept_id=" + formObject.dept_id.value +"&eff_from="+formObject.eff_from.value +"&acc_no="+formObject.acc_no.value+  "&net_amount=" + formObject.net_amount.value +"&dept_desc="+ encodeURIComponent(formObject.dept_id[formObject.dept_id.selectedIndex].text)+ "&function_type=COMMITCODE" + "", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;	
		eval(responseText);
		if(message=="BAL_BUD_LESS_THAN_ORDER_QTY")
			mod_id="PO";
		if (!result) {
		//	parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, mod_id);
		alert("Budget Exceeded.\n Net Amount is greater than Balance Budget Amount.\n \n Net Amount = "+formObject.net_amount.value +", Balance Budget Amount = "+formObject.bal_budget.value+"\n Commitment Code = "+ formObject.temp_commt.value +" \n Department  = "+formObject.dept_desc.value );
	//	alert(getMessage("BUDGET_EXCEEDED","PO") "\n" getMessage("NET_AMT_GR_BAL_AMT","PO") "\n\n" getMessage("NET_AMT","PO") " =  "+formObject.net_amount.value + ", " getMessage("BAL_BUD_AMT","PO") " = " +formObject.bal_budget.value+ "\n" getMessage("COMMIT_CODE","PO") " = " + formObject.temp_commt.value + "\n" getMessage("DEPT","PO") " = " +formObject.dept_desc.value ");  
			return; 
		}
	}
	
	formObject.request_by_pu.value = formHeader.request_by_pu.value;
	formObject.request_on_supp.value = formHeader.request_on_supp.value;
	formObject.mode.value = formHeader.mode.value;
	formObject.temp_commt.value = decodeURIComponent(formObject.temp_commt.value,"UTF-8");
	
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

	
	xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=" + function_type, false);
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
	var supp_code = formHeader.to_supplier.value;
	var currency_code = formHeader.currency_code.value;
	var po_mode = formHeader.po_mode.value;
	parent.POListFrame.document.location.href = "../../ePO/jsp/PurchaseOrderList.jsp?index=" + index + "&supp_code=" + supp_code + "&currency_code=" + currency_code + "&po_mode=" +po_mode;
	formObject.add.value = getLabel("Common.Add.label", "Common");
	formHeader.po_mode.disabled = true;
	formHeader.from_purchase_unit.disabled = true;
	formHeader.to_supplier.disabled = true;
	formHeader.purchase_type.disabled = true;
	if(formHeader.blanket_po_yn != undefined){
	formHeader.blanket_po_yn.disabled = true;
	formHeader.val_img.disabled = true;
	formHeader.valid_upto.disabled = true;
	}
	formHeader.currency_code.disabled = true;
	formHeader.exc_rate.disabled = true;
	formHeader.exp_date.disabled = true;
	formHeader.exp_img.disabled = true;
//	parent.POHeaderFrame.document.getElementById("exp_img").style.visibility="hidden";
	
	formObject.item_desc.readOnly = false;	
	if (formObject.editing.value == "1") {
	 	formObject.add.disabled = true;
		formObject.reset();
		parent.PODetailFrame.document.getElementById("acc_desc_label").innerHTML = "";
		formObject.del_date.value = formHeader.exp_date.value;
		formObject.item_desc.focus();
		document.formPurchaseOrderDetail.all.manditHidden.style.visibility="hidden";
	} else {
		var blanket_yn = formHeader.blanket_po_yn.value;
		var to_supplier = formHeader.to_supplier.value;
		var currency_code = formHeader.currency_code.value;
		document.location.href = "../../ePO/jsp/PurchaseOrderDetail.jsp?mode=" + MODE_INSERT + "&blanket_yn=" + blanket_yn + "&to_supplier=" + to_supplier + "&currency_code=" + currency_code + "&function_id=" + parent.parent.function_id ;
		
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
	var formObj = document.formPurchaseOrderList;
	assignBean(formObj);
	if (obj_item_code.checked) {
		check_status = "Y";
	} else {
		check_status = "N";
	}
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderValidate.jsp?item_code=" + obj_item_code.value + "&check_status=" + check_status + "&bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value + "&function_type=UPDATECHECKSTATUS", false);
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	eval(responseText);
}


function displayItemDetail(idx) {
	var formHeader = parent.POHeaderFrame.document.formPurchaseOrderHeader;
	var del_date = formHeader.exp_date.value;
	if(formHeader.blanket_po_yn.checked){
		formHeader.blanket_po_yn.value = "Y";
	}else{
		formHeader.blanket_po_yn.value = "N";
	}
	var blanket_yn = formHeader.blanket_po_yn.value;
	var to_supplier = formHeader.to_supplier.value;
	var currency_code = formHeader.currency_code.value;
	var po_mode = formHeader.po_mode.value;
	var trObject = eval(document.getElementById("tr_" + idx));
	if(po_mode=="R")
		changeRowColor(trObject);
	else
		changeRowColor1(trObject);
	
	var item_code = eval("document.formPurchaseOrderList.item_code_" + idx + ".value");
	var req_no  =  eval("document.formPurchaseOrderList.req_no_" + idx + ".value");
	parent.PODetailFrame.document.location.href = "../../ePO/jsp/PurchaseOrderDetail.jsp?mode=" + MODE_MODIFY + "&function_id=" + parent.parent.function_id + "&item_code=" + item_code  + "&req_no=" + req_no + "&del_date=" + del_date  + "&blanket_yn=" + blanket_yn +  "&to_supplier=" + to_supplier +  "&currency_code=" + currency_code +"&edit=" + document.formPurchaseOrderList.mode.value;
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

function changeRowColor1(obj) {
	tot = document.forms[0].total_checkboxes.value;
	tot = tot - 1;
	if (prevObj != null) {
		for (k = 1; k < 12; k++) {
			prevObj.cells(k).className = prevColor;
		}
	}
	prevObj = obj;
	prevColor = obj.cells(1).className;
	for (k = 1; k < 12; k++) {
		obj.cells(k).className = "STLIGHTPINK";
	}
}

function resetDetail() {
	document.location.href = "../../ePO/jsp/PurchaseOrderDetail.jsp?mode=" + MODE_INSERT + "&function_id=" + parent.parent.function_id;
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
}



async function apply() {
	var bean_id = "purchaseOrderBean";
	var bean_name = "ePO.PurchaseOrderBean";
	var errorPage = "../../eCommon/jsp/error.jsp";
	if(f_query_add_mod.POHeaderFrame==undefined)
	{
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	return;
	}
	var formHeader = f_query_add_mod.POHeaderFrame.document.formPurchaseOrderHeader;
	if (formHeader.mode.value == MODE_DELETE) {
		eval(formApply(formHeader, PO_CONTROLLER));
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "PO");
		if (result) {
			onSuccess();
		}
		return;
	}
	//var arrayObject = new Array(formHeader.purchase_type, formHeader.doc_date, formHeader.from_purchase_unit, formHeader.to_supplier , formHeader.exc_rate,formHeader.currency_code);
	//var names = new Array(getLabel("ePO.PurchaseType.label", "PO"), getLabel("ePO.PoDate.label", "PO"), getLabel("ePO.PORaisedBy.label", "PO"), getLabel("ePO.Supplier.label", "PO"),getLabel("ePO.ExchangeRate.label", "PO"),getLabel("ePO.TransactionCurrency.label", "PO"));
	
	if (!formHeader.doc_no.disabled) {
		var arrayObject = new Array(formHeader.doc_no);
		var names = new Array(getLabel("ePO.PONo.label", "PO"));		
		var blankObject = checkPOFields(arrayObject, names, messageFrame, errorPage);
		if (blankObject != true) {
		return; 
		}
	}
	
	
	
	var formObject = f_query_add_mod.POListFrame.document.formPurchaseOrderList;
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
	
	var formDetail = f_query_add_mod.PODetailFrame.document.formPurchaseOrderDetail;
	
	if(formDetail.budget_check_yn.value=="Y"){
		for (i= 0; i < total_items; i++) {
		var commt_code = eval("formObject.commit_code_"+i+".value");
			if(commt_code == '' || commt_code == null) {
				messageFrame.location.href = errorPage + "?err_num=" + getMessage("COMMIT_CODE_CANNOT_BLANK", "PO");
				return;
			}
		}	
	}
	
	
	
	

	formObject.mode.value = formHeader.mode.value;
	formObject.doc_no.value = formHeader.doc_no.value;
	formObject.doc_date.value = formHeader.doc_date.value;
	formObject.doc_ref.value = formHeader.doc_ref.value;
	formObject.request_by_pu.value = formHeader.from_purchase_unit.value;
	formObject.request_on_supp.value = formHeader.to_supplier.value;
	formObject.autono_yn.value = formHeader.autono_yn.value;
	formObject.purchase_type.value = formHeader.purchase_type.value;
	formObject.po_mode.value = formHeader.po_mode.value;
	formObject.currency_code.value = formHeader.currency_code.value;
	formObject.exc_rate.value = formHeader.exc_rate.value;
	formObject.local_currency.value = formHeader.local_currency.value;	
	if(formHeader.blanket_po_yn.checked){
		formHeader.blanket_po_yn.value = "Y";
	}else{
		formHeader.blanket_po_yn.value = "N";
	}
	formObject.blanket_po_yn.value = formHeader.blanket_po_yn.value;
	formObject.valid_upto.value = formHeader.valid_upto.value;
	formObject.exp_date.value = formHeader.exp_date.value;
	formObject.old_po_no.value = formHeader.old_po_no.value;
	checkCanAuthorize(formObject.request_by_pu);			
	formHeader.authorize_yn.value = formHeader.authorize_yn.value.substring(0, 1);
	
		if (formHeader.authorize_yn.value == "Y") {
			finalizeType = await confirmFinalize();
			if(finalizeType==""){
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
				return;
			}
		}
	
	if (finalizeType == "") {
		finalizeType = "No"; 
	}
//	formObject.finalize_yn.value = finalizeType;
//	var responseText = formApply(formObject, PO_CONTROLLER);

// added on 14th aug	

	formObject.finalize_yn.value = finalizeType;
	if (formHeader.authorize_yn.value == "Y") {
	if (finalizeType == "Yes") {
	if (formHeader.budget_check_yn.value == "Y") {
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderValidate.jsp?function_type=OVERRIDEBUDGET&bean_id=" + bean_id + "&bean_name=" + bean_name , false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
	//	alert(responseText);
		eval(responseText);
		
			if(message=="OVERRIDE_WARNING"){
				//var overrideType = confirmOverride();
				//if(overrideType == "Yes")
				//	var responseText = formApply(formObject, PO_CONTROLLER);
				var overrideType = confirm("Budget Amount Exceeded!  \n \n Net Amount = "+ formObject.net_poAmt.value +", Balance Budget Amount = "+ formObject.balance_amt.value+"\n Commitment Code = "+ formObject.com_code.value + ","+ decodeURIComponent(formObject.com_desc.value,"UTF-8") +" \n Department  = "+formObject.dt_code.value + ","+ formObject.dept_desc.value);
				if(overrideType == true){
					var responseText = formApply(formObject, PO_CONTROLLER);
				}else{
					messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
					return;
				}	
				
			}else if(message=="OVERRIDE_ERROR"){
				//var overrideError = confirmOverrideError();
				alert("Transaction cannot proceed as the budget amount is exceeded! \n \n Net Amount = "+ formObject.net_poAmt.value +", Balance Budget Amount = "+ formObject.balance_amt.value+" \n Commitment Code = "+ formObject.com_code.value + ","+ decodeURIComponent(formObject.com_desc.value,"UTF-8") +" \n Department  = "+formObject.dt_code.value + ","+ formObject.dept_desc.value);
		//		alert(getMessage("TRANS_NOT_PROCEED_AS_BUD_AMT_EXCEED","PO") \n\n getMessage("NET_AMT","PO")= "+formObject.net_poAmt.value +", getMessage("BAL_BUD_AMT","PO") = "+formObject.balance_amt.value+" \n getMessage("COMMIT_CODE","PO") = "+ formObject.com_code.value +","+ formObject.com_desc.value +" \n getMessage("DEPT","PO") = "+formObject.dt_code.value + ","+ formObject.dept_desc.value");  
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
				return;
				
			}else if(message=="OVERRIDE_NOTAPPLICABLE"){
				var responseText = formApply(formObject, PO_CONTROLLER);
			}else if(message==""){
				var responseText = formApply(formObject, PO_CONTROLLER);
			}
		}else{
			var responseText = formApply(formObject, PO_CONTROLLER);
		}
	}else if (finalizeType == "No") { 
		var responseText = formApply(formObject, PO_CONTROLLER);
	}	
	}else{
		var responseText = formApply(formObject, PO_CONTROLLER);
	}	
	
	
// end on 14th aug	
		
	eval(responseText);
	flag1 = (flag.split("~"))[0];
	flag2 = (flag.split("~"))[1];
	flag1 = (flag1 == "null" ? "" : flag1);
		
	if (result) {
	
		
		var PConfirm = await confirmPrinting();
			if (PConfirm == "Yes") {
				var xmlHttp = new XMLHttpRequest();
				var xmlDoc="";
				xmlDoc.loadXML(getXMLString(null));
				xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderValidate.jsp?function_type=PRINTONLINEDOC&msg=" + encodeURIComponent(message) + "&bean_id=" + bean_id + "&bean_name=" + bean_name , false);
				xmlHttp.send(xmlDoc);
				responseText = xmlHttp.responseText;
				eval(responseText);
			}
		
		messageFrame.location.href = errorPage + "?err_num=" + message + "<BR>" + (result ? flag1 : "");
		onSuccess();
		
	
		if(formObject.finalize_yn.value == "Yes"){
		var xmlHttp = new XMLHttpRequest();
				var xmlDoc="";
				xmlDoc.loadXML(getXMLString(null));
				xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderValidate.jsp?function_type=CHECKITEMAPPROVAL&bean_id=" + bean_id + "&bean_name=" + bean_name , false);
				xmlHttp.send(xmlDoc);
				responseText = xmlHttp.responseText;
				eval(responseText);
			if(result)	{
				alert(getMessage("ITEM_APPROVAL_PENDING","PO"));  
			}else{
			}
		}
		
	
	}else{
		if(message=="OVERRIDE_ERROR"){
			message = "";
		}else if(message=="OVERRIDE_WARNING"){
			message = "";
		}else if(message == "Doc No Null<BR>"){
			alert(getMessage("DOC_NO_NULL","PO"));  
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
			return;
		}else{
		messageFrame.location.href = errorPage + "?err_num=" + message;
		}
		
	}
//	}
}

function onSuccess() {
	var formObject = f_query_add_mod.POHeaderFrame.document.formPurchaseOrderHeader;
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

	var po_no = obj.cells[1].innerText;
	var purchase_type_code = obj.cells[5].innerText;

	parent.document.location.href = "../../ePO/jsp/PurchaseOrderFrame.jsp?mode=" + MODE_MODIFY + "&function_id=" + parent.parent.function_id + "&purchase_type_code=" + purchase_type_code + "&po_no=" + po_no ;
	
	
}


function close_modal() {
	window.close();
	
}

function setCurrCode(obj_currency){
		var formHeader = document.formPurchaseOrderHeader;
		
		var formObject = parent.PODetailFrame.document.formPurchaseOrderDetail;
		parent.PODetailFrame.document.getElementById("currency_label_1").innerHTML =  obj_currency.value ; 
		parent.PODetailFrame.document.getElementById("currency_label_2").innerHTML =  obj_currency.value ; 
		parent.PODetailFrame.document.getElementById("currency_label_3").innerHTML =  obj_currency.value ; 
		parent.PODetailFrame.document.getElementById("currency_label_4").innerHTML =  obj_currency.value ; 
		parent.POListFrame.document.getElementById("currency_label_5").innerHTML =  obj_currency.value  ; 
		parent.POListFrame.document.getElementById("currency_label_6").innerHTML =  obj_currency.value  ; 
		parent.POListFrame.document.getElementById("currency_label_7").innerHTML =  obj_currency.value  ; 
		parent.PODetailFrame.document.getElementById("currency_label_8").innerHTML =  obj_currency.value ; 
		
		if((obj_currency.value)==(formHeader.local_currency.value)){
			document.getElementById("exc_rate").value = 1;
			document.getElementById("exc_rate").disabled = true;
		}else{
			document.getElementById("exc_rate").value = "";
			document.getElementById("exc_rate").disabled = false;
		}
	
}

function onLoadCurrCode(obj_currency){

		if(parent.PODetailFrame.document.getElementById("currency_label_1")!=undefined){
		parent.PODetailFrame.document.getElementById("currency_label_1").innerHTML =  obj_currency ; 
		parent.PODetailFrame.document.getElementById("currency_label_2").innerHTML =  obj_currency ; 
		parent.PODetailFrame.document.getElementById("currency_label_3").innerHTML =  obj_currency ; 
		parent.PODetailFrame.document.getElementById("currency_label_4").innerHTML =  obj_currency ; 
		parent.PODetailFrame.document.getElementById("currency_label_8").innerHTML =  obj_currency ;
		}	
		if(parent.POListFrame.document.getElementById("currency_label_5")!=undefined){
		parent.POListFrame.document.getElementById("currency_label_5").innerHTML =  obj_currency  ; 
		parent.POListFrame.document.getElementById("currency_label_6").innerHTML =  obj_currency  ; 
		parent.POListFrame.document.getElementById("currency_label_7").innerHTML =  obj_currency  ;
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
		var formObject = document.formPurchaseOrderDetail;
		var ord_qty = formObject.order_qty.value ; 
		var unit_price = formObject.unit_price.value ; 
		var tot_value = ord_qty * unit_price ; 
		formObject.tot_value.value  = parseFloat(tot_value).toFixed(3) ;
		formObject.tot_value.disabled=true;

}

function calculatePrice(){
		var formObject = document.formPurchaseOrderDetail;
		var ord_qty = formObject.order_qty.value ; 
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

		var formObject = document.formPurchaseOrderDetail;
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
		  alert(getMessage("DISCOUNT_AMT_LT_GROSS","PO"));  
		  formObject.dis_value.focus();
		  }
		}
		}
		
		
		
		
}

function calculateDisAmount(){
		
		var formObject = document.formPurchaseOrderDetail;
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
		if(isNaN(dis_value))
		formObject.dis_value.value  = 0;
		else
		formObject.dis_value.value  = parseFloat(dis_value).toFixed(3) ;
}

function calculateNetAmt(){
		
		var formObject = document.formPurchaseOrderList;
		var gross_poAmt = formObject.gross_poAmt.value ; 
		var addi_dist = formObject.addi_dist.value ; 
		var net_amt;
		var discount_amt;
	
		if(parseFloat(gross_poAmt) > 0){
			
			document.getElementById("gross_poAmt_label").innerHTML = "" + parseFloat(gross_poAmt).toFixed(3) + ""; 
		if(parseFloat(gross_poAmt) > parseFloat(addi_dist)){
		  net_amt = gross_poAmt - addi_dist;	
		  document.getElementById("net_poAmt_label").innerHTML = "" + net_amt.toFixed(3) + ""; 
		  document.getElementById("net_poAmt").value = net_amt;
		}else{
			alert(getMessage("DISCOUNT_AMT_LT_GROSS","PO"));  
			formObject.addi_dist.focus();
		}
	}	

}

function AdditionalDetails(bean_id, bean_name, mode) {

	var formObj = document.formPurchaseOrderHeader;
	function_id = document.forms[0].function_id.value;
	var tit = "TITLE";
	var retVal = window.showModalDialog("../../ePO/jsp/AdditionalDetailsModify.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +  "&function_id=" + function_id + "&mode=" + mode + "&supp_code=" + formObj.supp_code.value + "&po_mode=" + formObj.po_mode.value, "", "dialogHeight:20; dialogWidth: 70; right: 1; status: no; dialogTop :300;scroll:no");
	
	
}


function exitAdditionalDetails(){

var formObj = document.formAdditionalDetails;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
		xmlDoc.loadXML(getEnhancedXMLString(formObj));
			
		xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderValidate.jsp?bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value +  "&qnt_ref=" + formObj.qnt_ref.value +  "&pmnt_term=" + formObj.pmnt_term.value +  "&acc_no=" + formObj.acc_no.value +  "&terms_conditions=" + formObj.terms_conditions.value +  "&supp_address_1=" + formObj.supp_address_1.value +  "&delivery_mode=" + formObj.delivery_mode.value +  "&supp_address_2=" + formObj.supp_address_2.value +  "&deliver_to_address=" + formObj.deliver_to_address.value +  "&supp_address_3=" + formObj.supp_address_3.value +  "&bill_to_address=" + formObj.bill_to_address.value  + "&function_type=SETADDITIONALDETAILS", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		window.close();

}


function BillToDeliverDetails(bean_id, bean_name, mode) {

	var formObj = document.formPurchaseOrderHeader;
	function_id = document.forms[0].function_id.value;
	var tit = "TITLE";
	var retVal = window.showModalDialog("../../ePO/jsp/BillToDeliverToDetails.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +  "&function_id=" + function_id + "&mode=" + mode , "", "dialogHeight:20; dialogWidth:50; right: 1; status: no; dialogTop :300;scroll:yes");



	
}


function exitBillToDeliverDetails(){

var formObj = document.formBillToDeliverToDetails;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
		xmlDoc.loadXML(getEnhancedXMLString(formObj));
			
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

function DeliverySchedule(bean_id, bean_name, mode) {

	var formObject = document.formPurchaseOrderDetail;
	var item_desc = formObject.item_desc.value ; 
	var order_qty = formObject.order_qty.value ; 
	var item_code = formObject.item_code.value ; 
	var temp_uom = formObject.temp_uom.value ; 
	var del_date = formObject.del_date.value ; 
	var req_no = formObject.req_no.value ; 
	
	function_id = document.forms[0].function_id.value;
	
	var tit = "TITLE";
	var retVal = window.showModalDialog("../../ePO/jsp/DeliveryScheduleModify.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +  "&function_id=" + function_id + "&mode=" + mode + "&item_desc=" + item_desc + "&order_qty=" + order_qty + "&item_code=" + item_code + "&temp_uom=" + temp_uom + "&del_date=" + del_date +"&req_no=" + req_no, "", "dialogHeight:20; dialogWidth: 30; right: 1; status: no; dialogTop :300;scroll:yes");

}

function exitDeliverySchedule(){
	var formObj = document.formDeliverySchedule;
	var total_qty = 0;
	var totalRecords = formObj.totalRecords.value;
	if(eval("document.formDeliverySchedule.order_qty_0").value != ""){
	for (var i = 0; i < totalRecords; i++) {
		if(eval("document.formDeliverySchedule.order_qty_"+i).value != ""){
		    formObj.order_qty.value = eval("document.formDeliverySchedule.order_qty_"+i).value;
			total_qty = total_qty + parseInt(formObj.order_qty.value) ;
			formObj.del_due_dt.value = eval("document.formDeliverySchedule.del_due_dt_"+i).value;
			}
			
		}
		
		var req_no =  formObj.req_no.value;
		var item_code = formObj.item_code.value;
		if(req_no!="")
		item_code = item_code+req_no;

		if(total_qty == formObj.tot_qty.value){		
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getEnhancedXMLString(formObj));
		xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderValidate.jsp?bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value+ "&item_code=" + item_code + "&function_type=SETDELIVERYVALUES", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
	window.close();
	}else{
		alert(getMessage("TOTQTY_EQ_ORDQTY","PO"));  
	}
	}else{
		alert(getMessage("ATLEAST_ONE_DELV_SCH_RECORD","PO"));  
	}
}



function ItemRemarks(remarks,codedisabled) {
	
	var rem = "";
	rem = window.showModalDialog("../../ePO/jsp/ItemRemarksModify.jsp?function_id=" + parent.parent.function_id + "&remarks=" +encodeURIComponent(remarks) + "&codedisabled=" +codedisabled, "", "dialogHeight:10; dialogWidth:30; right:1; status: no; dialogTop :250;");
	if (rem != null && codedisabled=="") {
		document.forms[0].item_remarks.value = rem;
	}
	
}
function ItemRemarks1(remarks,codedisabled) {
	remarks = decodeURIComponent(remarks,"UTF-8");
	var rem = "";
	rem = window.showModalDialog("../../ePO/jsp/ItemRemarksModify.jsp?function_id=" + parent.parent.function_id + "&remarks=" +encodeURIComponent(remarks) + "&codedisabled=" +codedisabled, "", "dialogHeight:10; dialogWidth:30; right:1; status: no; dialogTop :250;");
	if (rem != null && codedisabled=="") {
		document.forms[0].item_remarks.value = rem;
	}
	
}

function exitItemRemarks(){
	window.returnValue = document.formItemRemarks.item_remarks.value;
	window.close();	
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


function OrderRemarks(bean_id, bean_name, mode) {

	function_id = document.forms[0].function_id.value;
	
	var tit = "TITLE";
	var retVal = window.showModalDialog("../../ePO/jsp/OrderRemarksModify.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +  "&function_id=" + function_id + "&mode=" + mode, "", "dialogHeight:10; dialogWidth: 30; right: 1; status: no; dialogTop :300;scroll:no");

}
function exitOrderRemarks(){
	
	var formObj = document.formOrderRemarks;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
		xmlDoc.loadXML(getEnhancedXMLString(formObj));
		xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderValidate.jsp?bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value +  "&order_remarks=" + formObj.order_remarks.value + "&function_type=SETORDERVALUES", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		window.close();
}
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



function loadCurrency(obj_supp) {
	var formObj = document.formPurchaseOrderHeader;
	formObj.supp_code.value = obj_supp.value;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderValidate.jsp?function_type=LOADCURRENCY&supplier=" + obj_supp.value + "&localCurrency=" + formObj.local_currency.value + "&bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	
}
function loadDeptId1(commitCode,dept_no) {

	var formObj = document.formPurchaseOrderDetail;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderValidate.jsp?function_type=LOADDEPTID1&commit_code=" + commitCode +"&dept_id="+ dept_no + "&bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
}	

function loadDeptId(obj_commitCode) {

	var formObj = document.formPurchaseOrderDetail;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderValidate.jsp?function_type=LOADDEPTID&commit_code=" + obj_commitCode.value + "&bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
}

function loadAccNo(obj_deptId) {	
	var formObj = document.formPurchaseOrderDetail;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderValidate.jsp?function_type=LOADACCNO&dept_id=" + obj_deptId.value + "&commit_code=" + formObj.commit_code.value + "&bean_id=" + formObj.bean_id.value + "&dept_desc="+ encodeURIComponent(formObj.dept_id[formObj.dept_id.selectedIndex].text) + "&bean_name=" + formObj.bean_name.value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);	
}

function loadAccDesc(obj_accNo) {
	
	var formObj = document.formPurchaseOrderDetail;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderValidate.jsp?function_type=LOADACCDESC&acc_no=" + obj_accNo.value + "&commit_code=" + formObj.commit_code.value + "&dept_id=" + formObj.dept_id.value + "&dept_desc="+ encodeURIComponent(formObj.dept_id[formObj.dept_id.selectedIndex].text)+ "&bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);	
	formObj.acc_desc.value = decodeURIComponent(formObj.acc_desc.value,"UTF-8");
	document.getElementById("acc_desc_label").innerHTML = formObj.acc_desc.value;
}

function getUOMDesc(obj_uom) {	
	var formObj = document.formPurchaseOrderDetail;
/*	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderValidate.jsp?function_type=GETUOMDESC&uom_code=" + obj_uom.value + "&bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
*/
	document.getElementById("temp_uom_code").value = obj_uom.value;
	document.getElementById("temp_uom").value = formObj.uom[formObj.uom.selectedIndex].text;	
}

function getCOMMNTDesc(obj_commt) {	
	var formObj = document.formPurchaseOrderDetail;
/*	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderValidate.jsp?function_type=GETCOMMNTDESC&commt_code=" + obj_commt.value + "&bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);	
*/	
	document.getElementById("temp_commt").value = formObj.commit_code[formObj.commit_code.selectedIndex].text;
}

function searchCodeItem(obj) {

	var formObject = document.formPurchaseOrderDetail;
	var formHeader = parent.POHeaderFrame.document.formPurchaseOrderHeader;
	var errorPage = "../../eCommon/jsp/error.jsp";
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	formHeader.request_by_pu.value = formHeader.from_purchase_unit.value;
	formHeader.request_on_supp.value = formHeader.to_supplier.value;
	formHeader.purchase_type.value = formHeader.purchase_type.value;
	formHeader.po_mode.value = formHeader.po_mode.value;
	formHeader.currency_code.value = formHeader.currency_code.value;
	
		
	if(formHeader.blanket_po_yn.checked){
		formHeader.blanket_po_yn.value = "Y";
		var arrayObject = new Array(formHeader.request_by_pu, formHeader.request_on_supp,formHeader.purchase_type,formHeader.po_mode,formHeader.currency_code,formHeader.exc_rate,formHeader.valid_upto,formHeader.exp_date);
		var names = new Array(getLabel("ePO.PORaisedBy.label", "PO"),getLabel("ePO.Supplier.label", "PO"),getLabel("ePO.PurchaseType.label", "PO"),getLabel("ePO.POMode.label", "PO"),getLabel("ePO.TransactionCurrency.label", "PO"),getLabel("ePO.ExchangeRate.label", "PO"),getLabel("ePO.ValidUpto.label", "PO"),getLabel("ePO.ExpDelDate.label", "PO"));
		if(formHeader.autono_yn.value=="No"){
			arrayObject[arrayObject.length] = formHeader.doc_no;
			names[names.length] = getLabel("ePO.PONo.label", "PO");
		}	
		var blankObject = checkPOFields(arrayObject, names, parent.parent.messageFrame, errorPage);
		if (blankObject != true) {
			return;
		}	
	}else{
		formHeader.blanket_po_yn.value = "N";
		var arrayObject = new Array(formHeader.request_by_pu, formHeader.request_on_supp,formHeader.purchase_type,formHeader.po_mode,formHeader.currency_code,formHeader.exc_rate,formHeader.exp_date);
		var names = new Array(getLabel("ePO.PORaisedBy.label", "PO"),getLabel("ePO.Supplier.label", "PO"),getLabel("ePO.PurchaseType.label", "PO"),getLabel("ePO.POMode.label", "PO"),getLabel("ePO.TransactionCurrency.label", "PO"),getLabel("ePO.ExchangeRate.label", "PO"),getLabel("ePO.ExpDelDate.label", "PO"));
		if(formHeader.autono_yn.value=="No"){
			arrayObject[arrayObject.length] = formHeader.doc_no;
			names[names.length] = getLabel("ePO.PONo.label", "PO");
		}	
		var blankObject = checkPOFields(arrayObject, names, parent.parent.messageFrame, errorPage);
		if (blankObject != true) {
			return;
		}
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
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
		formObject.item_code.value = returnedValues[0];
		formObject.item_desc.value = returnedValues[1];
		formObject.item_desc.readOnly = true;
		formObject.add.disabled = false;
		document.formPurchaseOrderDetail.conv_fact.value = "1";
		document.formPurchaseOrderDetail.order_qty.focus();
	}
		
		if(formObject.item_code.value!=""){
		var bean_id = "purchaseOrderBean";
		var bean_name = "ePO.PurchaseOrderBean";
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&item_code=" + formObject.item_code.value + "&function_type=MM_UOM", false);
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
    if (retVal!= null){
	 retValChk = retVal
     }
	if(retValChk=="ADD"){

		var html = "<html><body><form name='dummyFormSubmit' id='dummyFormSubmit'  action='../../ePO/jsp/PurchaseOrderList.jsp?&function=edit"+"&addToList=true"+"&po_mode=R' method='post'>";
		html+="</form></body></html>";
		parent.frames[3].document.body.insertAdjacentHTML("AfterBegin",html);
		parent.frames[3].dummyFormSubmit.submit();
		//parent.POListFrame.document.location.href="../../ePO/jsp/PurchaseOrderFrame.jsp";
		//parent.POHeaderFrame.document.formPurchaseOrderHeader.encounter_id.disabled = true;
		//parent.POHeaderFrame.document.formPurchaseOrderHeader.sal_trn_type.disabled = true;
		//parent.POHeaderFrame.document.formPurchaseOrderHeader.patient_id.disabled = true;

	}
}

function onadd(){

    var formObj           = document.formPurchaseOrderSearchWindowResult;
	var formCriteria      = parent.framePurchaseOrderSearchWindowCriteria.document.formPurchaseOrderSearchWindowCriteria;	
	var formObject;

	var total =formObj.total.value;

	var item_arr   = new Array;
	var arrayIndex = 0;	
	var req_no = "";
	var batchcount ="";

	for (var i = 0; i < total; i++ ){

		var reqnoobj	= eval("formObj.doc_no_check_"+i);
			
			if(reqnoobj.checked && reqnoobj.checked == true ){
				
				req_no = reqnoobj.value;

				batchcount = eval("formObj.batchcount_"+req_no+"_"+i).value;

				for (var index=0;index < batchcount;index++ ){	

							var checkobj  = eval("formObj.doc_no_"+req_no+"_"+index);

							if (checkobj!= undefined && checkobj.checked == true){
								
								var myClassObj = new ItemBatch();

								myClassObj.req_no            = eval("formObj.doc_no_"+req_no+"_"+index).value ;
								myClassObj.item_code         = eval("formObj.item_code_"+req_no+"_"+index).value;						
								myClassObj.req_qty           = eval("formObj.req_qty_"+req_no+"_"+index).value;								
								myClassObj.order_qty         = eval("formObj.order_qty_"+req_no+"_"+index).value;								
								myClassObj.pending_qty       = eval("formObj.pending_qty_"+req_no+"_"+index).value;
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
		req_no = item_batch.req_no;
		if ((item_batch.order_qty == '' ) || (parseInt(item_batch.order_qty) == '0')){
			if (item_batch.order_qty == '' ){
				alert(getMessage("ORDER_QTY_CANNOT_BLANK","PO"));
				eval("formObj.order_qty_"+req_no+"_"+i).focus();	
				return;
			}
			if (parseInt(item_batch.order_qty) == '0'){
				alert(getMessage("ORDER_QTY_CANNOT_ZERO","PO"));
				eval("formObj.order_qty_"+req_no+"_"+i).focus();	
				return;
			}
		}else if ((item_batch.pending_qty*1) < (item_batch.order_qty*1)){
			alert(getPOMessage("ORDER_QTY_NOT_GRT_MAX_REQ_QTY","PO"));
			eval("formObj.order_qty_"+req_no+"_"+i).focus();			
			return;
		}
	}
	var loc_batch_string ="";
	for (var i=0;i<item_arr.length ;i++ ){
		var item_batch = item_arr[i];
		loc_batch_string = loc_batch_string+"||"+item_batch.req_no+";"+item_batch.item_code+";"+item_batch.order_qty;
	}
	formCriteria.loc_batch_string.value = loc_batch_string;	
	
	var bean_id = "purchaseOrderBean";
	var bean_name = "ePO.PurchaseOrderBean";
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getEnhancedXMLString(formCriteria));
	xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +"&function_type=LOAD_DETAILS_NEW", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;	
	eval(responseText);
   if(result){		
		document.parentWindow.returnValue ="ADD";
		document.parentWindow.close();
	}else{
	//	alert("Duplicate Purchase Request not allowed");
		alert(getPOMessage("DUPLICATE_REQ_NOT_ALLOWED","PO"));
	}	
}
//ends
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
function enable_doc(object, batchcount){

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

		var formObject = document.formPurchaseOrderHeader;
 
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

 var formObject = document.formPurchaseOrderHeader;
 
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

	if (parent.PurchaseOrderFrmS)
	{
		fullFrame = parent.PurchaseOrderFrmS;
	}

	if(hide == 'no')
	{
		if (parent.POBlankFrame)
		{
			if(parent.POBlankFrame.document.getElementById('hideImg'))
			{
				parent.POBlankFrame.document.getElementById('hideImg').src='../../eST/images/POright.png'
				fullFrame.cols = '0px,14px,*';
				parent.POListFrame.document.getElementById('poList').style.width = "1340px";
				hide='yes';
			}	
		}	
	}
	else if(hide == 'yes')
	{
		if (parent.POBlankFrame){
			if(parent.POBlankFrame.document.getElementById('hideImg'))
			{
				parent.POBlankFrame.document.getElementById('hideImg').src='../../eST/images/POleft.png'			
				fullFrame.cols = '350px,14px,*';
				parent.POListFrame.document.getElementById('poList').style.width = "980px";
				hide='no';
			}
		}
	}
	
}

function checkValidate(obj_validDate){
	var formObject = document.formPurchaseOrderHeader;
	
	var expDateArray;
	var valDateArray;
	var valDate = obj_validDate.value;
	var expDate = formObject.exp_date.value;
	if (expDate.length > 0 && valDate.length > 0) {
		expDateArray = expDate.split("/");
		valDateArray = valDate.split("/");
		var expDateObject = new Date(expDateArray[2], (expDateArray[1] - 1), expDateArray[0]);
		var valDateObject = new Date(valDateArray[2], (valDateArray[1] - 1), valDateArray[0]);
		if (Date.parse(valDateObject) < Date.parse(expDateObject)) {
			alert(getMessage("VALID_DT_GR_EXP_DELV_DT","PO"));  
				formObject.valid_upto.value = "";
				formObject.valid_upto.select();
				formObject.valid_upto.focus();
			
		}
	
	}
	
}

	
function checkexpdate(obj_expDate){
	var formObject = document.formPurchaseOrderHeader;
	if(formObject.blanket_po_yn.checked){
	var expDateArray;
	var valDateArray;
	var expDate = obj_expDate.value;
	var valDate = formObject.valid_upto.value;
	if (expDate.length > 0 && valDate.length > 0) {
		expDateArray = expDate.split("/");
		valDateArray = valDate.split("/");
		var expDateObject = new Date(expDateArray[2], (expDateArray[1] - 1), expDateArray[0]);
		var valDateObject = new Date(valDateArray[2], (valDateArray[1] - 1), valDateArray[0]);
		if (Date.parse(valDateObject) < Date.parse(expDateObject)) {
			alert(getMessage("EXP_DT_LE_VALID_DT","PO"));  
		//	formObject.exp_date.value = "";
			formObject.exp_date.select();
			formObject.exp_date.focus();
		}
	
	}
}
}

function checkDocDate(){
	var formObject = document.formPurchaseOrderHeader;
	var expDateArray;
	var valDateArray;
	var expDate = formObject.exp_date.value;
	
	var valDate = formObject.doc_date.value;
	if (expDate.length > 0 && valDate.length > 0) {
		expDateArray = expDate.split("/");
		valDateArray = valDate.split("/");
		var expDateObject = new Date(expDateArray[2], (expDateArray[1] - 1), expDateArray[0]);
		var valDateObject = new Date(valDateArray[2], (valDateArray[1] - 1), valDateArray[0]);
		if (Date.parse(valDateObject) > Date.parse(expDateObject)) {
			//alert("Expected delivery date should be greater than or equal to PO date");
			alert(getMessage("EXPECTED_DELV_DT_GR_PO_DT","PO"));  
			//formObject.exp_date.value = "";
			formObject.exp_date.select();
			formObject.exp_date.focus();
		}
	}
}

function perChange(obj_dis_type){
	if(obj_dis_type.value == "P")
		document.formPurchaseOrderDetail.all.perHidden.style.visibility="visible";
	else
		document.formPurchaseOrderDetail.all.perHidden.style.visibility="hidden";
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
	var bean_id = "purchaseOrderBean";
	var bean_name = "ePO.PurchaseOrderBean";

	if (request_by_pu.value == "") {
		return;
	}
	var arrayObject = new Array();
	arrayObject[0] = request_by_pu;
	assignBean(f_query_add_mod.POHeaderFrame.document.formPurchaseOrderHeader);
	xmlStr = getXMLString(arrayObject);
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=CHECKFORAUTHORIZE", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	//alert(responseText);
	eval(responseText);
}

function setAuthorize(authorizeValue) {
	f_query_add_mod.POHeaderFrame.document.formPurchaseOrderHeader.authorize_yn.value = authorizeValue;
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

	var formObj = document.formPurchaseOrderDetail;
	
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderValidate.jsp?uom_code=" + formObj.uom.value + "&pur_uom_code=" + formObj.temp_uom_code.value + "&bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value + "&function_type=CHECKUOMCONVFACTOR" + "&item_code=" + formObj.item_code.value, false);
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	eval(responseText);
	if (!result) {
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "PO");
		formObj.uom.value = formObj.temp_uom_code.value;
		formObj.uom.focus();
		setUOMConvFactor("1");
	}
}

function setUOMConvFactor(_value) {
	document.formPurchaseOrderDetail.conv_fact.value = _value;
}

function setUOMConvFactor1(_value,_rulestring) {

	document.getElementById("conv_fact").value = _value;
}

function checkValidateQryDate(){

	var formObject = document.formPurchaseOrderQueryCriteria;
	
	var toDateArray;
	var fromDateArray;
	var toDate = formObject.to_po_date.value;
	var fromDate = formObject.from_po_date.value;
	if (fromDate.length > 0 && toDate.length > 0) {
		toDateArray = fromDate.split("/");
		fromDateArray = toDate.split("/");
		var toDateObject = new Date(toDateArray[2], (toDateArray[1] - 1), toDateArray[0]);
		var fromDateObject = new Date(fromDateArray[2], (fromDateArray[1] - 1), fromDateArray[0]);
		if (Date.parse(fromDateObject) < Date.parse(toDateObject)) {
		//	alert("To date should be greater than or equal to From date");
			alert(getMessage("TO_DATE_GR_FROM_DATE","PO"));  
				formObject.to_po_date.select();
				formObject.to_po_date.focus();
		}else{
			document.formPurchaseOrderQueryCriteria.submit();
		}
	
	}else{
		document.formPurchaseOrderQueryCriteria.submit();
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
		dataValueArray[2] = "PORDER";
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

function isValidNumber1(fld, e, maxInt, deci){

    var count=fld.value.length;
    var whichCode = (window.Event) ? e.which : e.keyCode;


	if(whichCode==45)
		return true;

    if(count>=maxInt) {
        if(count==maxInt) {
            var dotOccurance = fld.value.indexOf('.');

            if(((dotOccurance>=maxInt)||(dotOccurance==-1)) && (count==maxInt)) {
                if(whichCode!=46 ) {
					if(deci>1) { 
						fld.value = fld.value+".";
					}
                }
            }
        }
        else if(count>maxInt) {
            var objectValue = fld.value;
            var dotOccurance = objectValue.indexOf('.');
            if((objectValue.charAt(maxInt))!='.') {
                if(dotOccurance==-1) {
                    if(deci!=0) {
						fld.value = objectValue.substring(0,maxInt)+".";
					}
					else {
						fld.value = objectValue.substring(0,maxInt);
					}
                    return false;
                }
            }
        }
    }
	var strCheck = '.0123456789';

	if(deci==0) {
	   strCheck = '0123456789';
	}

    var fldvalue=fld.value;
    var whichCode = (window.Event) ? e.which : e.keyCode;
    if (whichCode == 13) {
		return true;  
	}
    var pointCount=0;
    for(var i=0;i<fldvalue.length;i++) {
        if(fldvalue.charAt(i)=='.') pointCount++;
    }
    if (pointCount>0 && whichCode == 46) {
		return false;
	}

    var fldValue    =   fld.value;
    var dotIndex    =   fldValue.indexOf(".");
    var fldLength   =   fldValue.length;
    if(dotIndex!=-1) {
        if( fldLength > (dotIndex+deci) ) {
			return false;
		}
	}

    key = String.fromCharCode(whichCode);  // Get key value from key code
	
    if (strCheck.indexOf(key) == -1) {
		return false;  // Not a valid key
	}
    return true;


}




