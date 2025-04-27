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

	f_query_add_mod.location.href = "../../ePO/jsp/AmendPOQueryFrame.jsp?function_id=" + function_id;
}



function updateValues() {
	var formObject = document.formAmendPOHeader;
	if (formObject.to_store_code) {
		formObject.request_by_pu.value = formObject.from_store_code.value;
		formObject.request_on_supp.value = formObject.to_store_code.value;
		//formObject.item_class.value = formObject.item_class_code.value;
		//formObject.item_class_des.value = formObject.item_class_desc.value;
	}
}

	function setStore_code(obj){
		var formObject = document.formPurchaseOrderDetail;
		formObject.store_name.value = obj.value;
	}

	function callItemSearch() {
	
	var formHeader = parent.POHeaderFrame.document.formPurchaseOrderHeader;
	var errorPage = "../../eCommon/jsp/error.jsp";
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	formHeader.request_by_pu.value = formHeader.from_purchase_unit.value;
	formHeader.request_on_supp.value = formHeader.to_supplier.value;
	
	formHeader.purchase_type.value = formHeader.purchase_type.value;
	formHeader.po_mode.value = formHeader.po_mode.value;
	formHeader.currency_code.value = formHeader.currency_code.value;
	
	var arrayObject = new Array(formHeader.request_by_pu, formHeader.request_on_supp,formHeader.purchase_type,formHeader.po_mode,formHeader.currency_code);
	var names = new Array(getLabel("ePO.PORaisedBy.label", "PO"),getLabel("ePO.Supplier.label", "PO"),getLabel("ePO.PurchaseType.label", "PO"),getLabel("ePO.POMode.label", "PO"),getLabel("ePO.TransactionCurrency.label", "PO"));
	var blankObject = checkPOFields(arrayObject, names, parent.parent.messageFrame, errorPage);
	if (blankObject != true) {
		return;
	}
	
	var formObject = document.formPurchaseOrderDetail;
	
	var search_string = formObject.item_desc.value;
	//var store_code = formObject.store_name.value;
	//var store_code_to = formHeader.request_on_supp.value;
	var mode = formHeader.mode.value;
	var category = "";
	var sole_source = "A";
	var ps_item = "A";
	var mfg_item = "A";
	var expiry = "A";
	var consignment = "A";
//	var to_store_code = formHeader.from_store_code.value;
	var chkitemstorecmb = "Y";
	var kit = "Y";
	
	store_code = 'BANK'
	var results = callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, "", consignment, chkitemstorecmb, "", "", "","");// kit);
	if (results != null) {
	
	
		var bean_id = "purchaseOrderBean";
		var bean_name = "ePO.PurchaseOrderBean";
		var item_code = results[0];
		formObject.item_code.value = results[0];
		formObject.item_desc.value = results[1];
		formObject.item_desc.readOnly = true;
		formObject.add.disabled = false;
		
	}
	
}





function addItemRecord() {
	var formObject = document.formAmendPODetail;
	//alert(formObject.itemCode_reqNO.value);
	var formHeader = parent.AmendPOHeaderFrame.document.formAmendPOHeader;
	var errorPage = "../../eCommon/jsp/error.jsp";
	if(formObject.app_ref.checked){
	var arrayObject = new Array(formObject.item_desc,formObject.order_qty,formObject.uom,formObject.ref_value);
	var names = new Array(getLabel("Common.item.label", "Common"),getLabel("ePO.OrderQty.label", "PO"),getLabel("ePO.OrderUOM.label", "PO"),getLabel("ePO.ApprovalReference.label", "PO"));
	
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
	
	//var formHeader = parent.AmendPOHeaderFrame.document.formAmendPOHeader;
	var store_code = formHeader.request_by_pu.value;
	var to_store_code = formHeader.request_on_supp.value;
	var item_code = formObject.item_code.value;
	var bean_id = "amendPurchaseOrderBean";
	var bean_name = "ePO.AmendPurchaseOrderBean";
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));	
	
	xmlHttp.open("POST", "../../ePO/jsp/AmendPOValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&item_code=" + item_code + "&store_code=" + store_code + "&function_type=ADDITEMRECORD" + "", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;	
	//alert(responseText);
	eval(responseText);
	
	if(formObject.budget_check_yn.value=="Y"){
	xmlHttp.open("POST", "../../ePO/jsp/AmendPOValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&commit_code=" + formObject.commit_code.value + "&dept_id=" + formObject.dept_id.value +"&eff_from="+formObject.eff_from.value +"&acc_no="+formObject.acc_no.value +  "&net_amount=" + formObject.net_amount.value +"&dept_desc="+ formObject.dept_id[formObject.dept_id.selectedIndex].text + "&function_type=COMMITCODE" + "", false);
	
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;	
	//alert(responseText);
	eval(responseText);
	if(message=="BAL_BUD_LESS_THAN_ORDER_QTY")
		mod_id="ST";
	if (!result) {
		//parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, mod_id);
		alert("Budget Exceeded.\n Net Amount is greater than Balance Budget Amount.\n \n Net Amount = "+formObject.net_amount.value +", Balance Budget Amount = "+formObject.bal_budget.value+"\n Commitment Code = "+ formObject.temp_commt.value +" \n Department  = "+formObject.dept_desc.value );
	//	alert(getMessage("BUDGET_EXCEEDED","PO") \n getMessage("NET_AMT_GR_BAL_AMT","PO") \n\n getMessage("NET_AMT","PO")= "+formObject.net_amount.value +", getMessage("BAL_BUD_AMT","PO") = "+formObject.bal_budget.value+" \n getMessage("COMMIT_CODE","PO") = "+ formObject.temp_commt.value +" \n getMessage("DEPT","PO") = "+formObject.dept_desc.value ");  
		return;
	}
	
	}
	
	formObject.request_by_pu.value = formHeader.request_by_pu.value;
	formObject.request_on_supp.value = formHeader.request_on_supp.value;
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

	
	xmlHttp.open("POST", "../../ePO/jsp/AmendPOValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=" + function_type, false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	//alert(responseText);
	eval(responseText);
	var mod_id="ST";
	if(message=="DUPLICATE_CODE_EXISTS")
		mod_id="Common";
	if (!result) {
		parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, mod_id);
		return;
	}
	parent.parent.messageFrame.location.href = errorPage;
//added 	
	var xmlHttp = new XMLHttpRequest();
				var xmlDoc="";
				xmlDoc.loadXML(getXMLString(null));
				xmlHttp.open("POST", "../../ePO/jsp/AmendPOValidate.jsp?function_type=CHECKITEMAPPROVAL&bean_id=" + bean_id + "&bean_name=" + bean_name , false);
				xmlHttp.send(xmlDoc);
				responseText = xmlHttp.responseText;
			//	alert(responseText);
				eval(responseText);
			if(result)	{
			// alert("Please update item level approval reference and recommit");
			 alert(getMessage("PLS_UPDATE_ITEM_APPROVAL","PO"));  
							
			}
			
	else{
	index = formObject.srl_no.value;
	if (index != -1) {
		index = index - 1;
	}
	var supp_code = formHeader.to_supplier.value;
	var currency_code = formHeader.currency_code.value;
	var po_mode = formHeader.po_mode.value;
	parent.AmendPOListFrame.document.location.href = "../../ePO/jsp/AmendPOList.jsp?index=" + index + "&supp_code=" + supp_code + "&currency_code=" + currency_code + "&po_mode=" +po_mode;
	
	formObject.add.value = getLabel("Common.Add.label", "Common");
	formHeader.request_by_pu.disabled = true;
	formHeader.request_on_supp.disabled = true;
	//parent.POHeaderFrame.formPurchaseOrderHeader.pur_req_no.disabled = true;
	//parent.POHeaderFrame.formPurchaseOrderHeader.currency_code.disabled = true;
	
	if (formObject.editing.value == "1") {
		formObject.add.disabled = true;
		//document.getElementById("uom_label").innerHTML = "&nbsp;";
		formObject.reset();
		formObject.del_date.value = formHeader.exp_date.value;
		parent.AmendPODetailFrame.document.getElementById("acc_desc_label").innerHTML = "";
		formObject.item_desc.focus();
		document.formAmendPODetail.all.manditHidden.style.visibility="hidden";
	} else {
		var blanket_yn = formHeader.blanket_po_yn.value;
		var to_supplier = formHeader.to_supplier.value;
		var currency_code = formHeader.currency_code.value;
		document.location.href = "../../ePO/jsp/AmendPODetails.jsp?mode=" + MODE_INSERT + "&function_id=" + "&blanket_yn=" + blanket_yn + "&to_supplier=" + to_supplier + "&currency_code=" + currency_code + parent.parent.function_id ;
		
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

function assignBean(frmObject) {
	bean_id = frmObject.bean_id.value;
	bean_name = frmObject.bean_name.value;
	xmlDom = new ActiveXObject("Microsoft.XMLDom");
	xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
}


function updateCheckStatus(obj_item_code) {
	var check_status = "";
	var formObj = document.formAmendPOList;
	assignBean(formObj);
	if (obj_item_code.checked) {
		check_status = "Y";
	} else {
		check_status = "N";
	}
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../ePO/jsp/AmendPOValidate.jsp?item_code=" + obj_item_code.value + "&check_status=" + check_status + "&bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value + "&function_type=UPDATECHECKSTATUS", false);
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	//alert(responseText);
	eval(responseText);
}


function displayItemDetail(idx) {
	var formHeader = parent.AmendPOHeaderFrame.document.formAmendPOHeader;
	var del_date = formHeader.exp_date.value;
	var blanket_yn = formHeader.blanket_po_yn.value;
	var to_supplier = formHeader.to_supplier.value;
	var currency_code = formHeader.currency_code.value;
	var po_mode = formHeader.po_mode.value;
//	alert(po_mode);
	var trObject = eval("document.getElementById("tr_")" + idx);
	//changeRowColor(trObject);
	
	if(po_mode=="R")
		changeRowColor(trObject);
	else
		changeRowColor1(trObject);
		
	var item_code = eval("document.formAmendPOList.item_code_" + idx + ".value");
	var req_no  =  eval("document.formAmendPOList.req_no_" + idx + ".value");
	parent.AmendPODetailFrame.document.location.href = "../../ePO/jsp/AmendPODetails.jsp?mode=" + MODE_MODIFY + "&function_id=" + parent.parent.function_id + "&item_code=" + item_code  + "&req_no=" + req_no + "&del_date=" + del_date + "&blanket_yn=" + blanket_yn +  "&to_supplier=" + to_supplier +  "&currency_code=" + currency_code + "&edit=" + document.formAmendPOList.mode.value;
	
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
	document.location.href = "../../ePO/jsp/AmendPODetails.jsp?mode=" + MODE_INSERT + "&function_id=" + parent.parent.function_id;
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
}



function apply() {
	var bean_id = "amendPurchaseOrderBean";
	var bean_name = "ePO.AmendPurchaseOrderBean";
	var errorPage = "../../eCommon/jsp/error.jsp";
	if(f_query_add_mod.AmendPOHeaderFrame==undefined)
	{
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	return;
	}
	var formHeader = f_query_add_mod.AmendPOHeaderFrame.document.formAmendPOHeader;
	if (formHeader.mode.value == MODE_DELETE) {
		eval(formApply(formHeader, PO_CONTROLLER));
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "Common");
		if (result) {
			onSuccess();
		}
		return;
	}
	var arrayObject = new Array(formHeader.doc_type_code, formHeader.doc_date, formHeader.request_by_pu, formHeader.request_on_supp);
	var names = new Array(getLabel("Common.DocType.label", "Common"), getLabel("Common.DocDate.label", "Common"), "Requested by Store", getLabel("Common.RequestedOnStore.label", "Common"));
	if (!formHeader.doc_no.disabled) {
		arrayObject[++arrayObject.length] = formHeader.doc_no;
		names[++arrayObject.length] = getLabel("Common.DocNo.label", "Common");
	}
	
	
	var formObject = f_query_add_mod.AmendPOListFrame.document.formAmendPOList;
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
		
	
	var formDetail = f_query_add_mod.AmendPODetailFrame.document.formAmendPODetail;
	
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
	//formObject.doc_type_code.value = formHeader.doc_type_code.value;
	formObject.doc_no.value = formHeader.doc_no.value;
	formObject.doc_date.value = formHeader.doc_date.value;
	formObject.doc_ref.value = formHeader.doc_ref.value;
//	formObject.request_by_pu.value = formHeader.request_by_pu.value;
//	formObject.request_on_supp.value = formHeader.request_on_supp.value;
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
				
	//checkCanAuthorize(formObject.request_by_pu);
	formHeader.authorize_yn.value = formHeader.authorize_yn.value.substring(0, 1);
	
		if (formHeader.authorize_yn.value == "Y") {
			//finalizeType = confirmFinalize();
			//finalizeType = confirmAmend();
			finalizeType = confirm(getMessage("ORDER_AMENDED", "PO"));
			if (finalizeType == true) {
				finalizeType = "Yes";
			}else{
				finalizeType = "";
			}		
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
		xmlHttp.open("POST", "../../ePO/jsp/AmendPOValidate.jsp?function_type=OVERRIDEBUDGET&bean_id=" + bean_id + "&bean_name=" + bean_name , false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
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
			//	alert(getMessage("TRANS_NOT_PROCEED_AS_BUD_AMT_EXCEED","PO") \n\n getMessage("NET_AMT","PO")= "+formObject.net_poAmt.value +", getMessage("BAL_BUD_AMT","PO") = "+formObject.balance_amt.value+" \n getMessage("COMMIT_CODE","PO") = "+ formObject.com_code.value +","+ formObject.com_desc.value +" \n getMessage("DEPT","PO") = "+formObject.dt_code.value + ","+ formObject.dept_desc.value");  
				return;
				
			}else if(message=="OVERRIDE_NOTAPPLICABLE"){
				var responseText = formApply(formObject, PO_CONTROLLER);
			}else if(message==""){
				var responseText = formApply(formObject, PO_CONTROLLER);
			}
		}else {
			var responseText = formApply(formObject, PO_CONTROLLER);
		}
	}else if (finalizeType == "No") {
	   	//var responseText = formApply(formObject, PO_CONTROLLER);
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
		return false;
	}	
	
	} else{
		//var responseText = formApply(formObject, PO_CONTROLLER);
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
		return false;
	}
	
// end on 14th aug	



	
	eval(responseText);
	flag1 = (flag.split("~"))[0];
	flag2 = (flag.split("~"))[1];
	flag1 = (flag1 == "null" ? "" : flag1);
	if (result) {

			messageFrame.location.href = errorPage + "?err_num=" + message + "<BR>" + (result ? flag1 : "");
			onSuccess();
		
	}else{
		if(message=="OVERRIDE_WARNING"){
			message = "";
		}else if(message=="OVERRIDE_ERROR"){
			message = "";
		}else{
			onSuccess();
		}
		messageFrame.location.href = errorPage + "?err_num=" + message;
		
	}

}

function checkCanAuthorize(request_by_pu) {
	var bean_id = "amendPurchaseOrderBean";
	var bean_name = "ePO.AmendPurchaseOrderBean";

	if (request_by_pu.value == "") {
		return;
	}
	var arrayObject = new Array();
	arrayObject[0] = request_by_pu;
	assignBean(f_query_add_mod.AmendPOHeaderFrame.document.formAmendPOHeader);
	xmlStr = getXMLString(arrayObject);
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "../../ePO/jsp/AmendPOValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=CHECKFORAUTHORIZE", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
}

function setAuthorize(authorizeValue) {
	f_query_add_mod.AmendPOHeaderFrame.document.formAmendPOHeader.authorize_yn.value = authorizeValue;
}


async function deleterecord() {
	if( f_query_add_mod.PORequestHeaderFrame==undefined){
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
	}else{
	var formHeader = f_query_add_mod.PORequestHeaderFrame.document.formPORequestHeader;
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


function onSuccess() {
	var formObject = f_query_add_mod.AmendPOHeaderFrame.document.formAmendPOHeader;
	if (formObject.mode.value == MODE_DELETE) {
		f_query_add_mod.location.href = "../../eCommon/html/blank.html";
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + message;
	} else {
		if (formObject.mode.value == MODE_MODIFY) {
			if (finalizeType == YES) {
			//create();
				f_query_add_mod.location.href = "../../eCommon/html/blank.html";
			} else {
			//f_query_add_mod.document.location.reload();			
				f_query_add_mod.location.href = "../../eCommon/html/blank.html";
			}
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + message;
		} else {
			f_query_add_mod.location.href = "../../eCommon/html/blank.html";
		//reset();
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + message + "<BR>" + flag;
		}
	}
	return;
}



function populateToStoresInQuery(request_by_store) {
	if (request_by_store.value == "") {
		clearListItems("document.forms[0].request_on_store");
		return;
	}
	clearListItems("document.forms[0].request_on_store");
	var arrayObject = new Array();
	var bean_id = "stporequestBean";
	var bean_name = "ePO.STPORequestBean";

	arrayObject[0] = request_by_store;
	assignBean(parent.frames[0].document.forms[0]);


	xmlStr = getXMLString(arrayObject);
	xmlDom.loadXML(xmlStr);
	
	xmlHttp.open("POST", "../../ePO/jsp/STPORequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=LOADDEPARTMENT", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
	parent.PORequestQueryResult.location.href = "../../eCommon/html/blank.html" ;

}
function loadItemClassesInQuery(request_by_store, request_on_store) {
	if (request_by_store.value == "" || request_on_store.value == "") {
		clearListItems("document.forms[0].item_class_code");
		return;
	}
	var bean_id = "stporequestBean";
	var bean_name = "ePO.STPORequestBean";

	var arrayObject = new Array();
	arrayObject[0] = request_by_store;
	arrayObject[1] = request_on_store;
	assignBean(parent.frames[0].document.forms[0]);
	xmlStr = getXMLString(arrayObject);
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "../../ePO/jsp/STPORequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=LOADITEAMCLASS", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
	parent.PORequestQueryResult.location.href = "../../eCommon/html/blank.html" ;

}

function Modify(obj) {

	var po_no = obj.cells[1].innerText;
	var purchase_type_code = obj.cells[5].innerText;
		
	parent.document.location.href = "../../ePO/jsp/AmendPurchaseOrderFrame.jsp?mode=" + MODE_MODIFY + "&function_id=" + parent.parent.function_id + "&purchase_type_code=" + purchase_type_code + "&po_no=" + po_no ;
}
function dispMess(id) {
	alert(getMessage("PHY_INV_PROCESS_INITIATED", "ST") + "\n" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + id);
}
function setUOMConvFactor1(_value,_rulestring) {


	document.getElementById("id_pur_uom_conv").innerHTML = _rulestring;
	document.getElementById("id_pur_uom_conv1").value = _rulestring;
	document.getElementById("conv_fact").value = _value;
}

function close_modal() {
	
	window.close();
	
}

function loadPOMode(obj){

 var formObject = document.formAmendPOHeader;
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



function setCurrCode(obj_currency){
		var formHeader = document.formAmendPOHeader;
		
		var formObject = parent.AmendPODetailFrame.document.formAmendPODetail;
		parent.AmendPODetailFrame.document.getElementById("currency_label_1").innerHTML =  obj_currency.value ; 
		parent.AmendPODetailFrame.document.getElementById("currency_label_2").innerHTML =  obj_currency.value ; 
		parent.AmendPODetailFrame.document.getElementById("currency_label_3").innerHTML =  obj_currency.value ; 
		parent.AmendPODetailFrame.document.getElementById("currency_label_4").innerHTML =  obj_currency.value ; 
		parent.AmendPOListFrame.document.getElementById("currency_label_5").innerHTML =  obj_currency.value  ; 
		parent.AmendPOListFrame.document.getElementById("currency_label_6").innerHTML =  obj_currency.value  ; 
		parent.AmendPOListFrame.document.getElementById("currency_label_7").innerHTML =  obj_currency.value  ; 
		
		if((obj_currency.value)==(formHeader.local_currency.value)){
			document.getElementById("exc_rate").value = 1;
			document.getElementById("exc_rate").disabled = true;
		}else{
			document.getElementById("exc_rate").value = "";
			document.getElementById("exc_rate").disabled = false;
		}
	
}

function loadDelDate(obj_date){
	//alert(obj_date);

	parent.AmendPODetailFrame.document.getElementById("del_date").value =  obj_date.value ; 

}

function displayValidUpto(obj_blanket){

	if(obj_blanket.checked){
		document.formAmendPOHeader.all.validUptoHidden.style.visibility="visible";
		parent.AmendPODetailFrame.document.getElementById("DelvSchHidden").style.visibility="visible";
		parent.AmendPODetailFrame.document.getElementById("DelvSchHide").style.visibility="hidden";
		
	}else{
		document.formAmendPOHeader.all.validUptoHidden.style.visibility="hidden";
		parent.AmendPODetailFrame.document.getElementById("DelvSchHidden").style.visibility="hidden";
		parent.AmendPODetailFrame.document.getElementById("DelvSchHide").style.visibility="visible";
		document.formAmendPOHeader.valid_upto.value = "";
	}
}


function calculateValue(){
		var formObject = document.formAmendPODetail;
		var ord_qty = formObject.order_qty.value ; 
		var unit_price = formObject.unit_price.value ; 
		var tot_value = ord_qty * unit_price ; 
		formObject.tot_value.value  = parseFloat(tot_value).toFixed(3) ;
		formObject.tot_value.disabled=true;

}

function calculatePrice(){
		var formObject = document.formAmendPODetail;
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

		var formObject = document.formAmendPODetail;
		var dis_type = formObject.dis_type.value ; 
		var tot_value = formObject.tot_value.value ; 
		//var dis_amt = formObject.dis_amt.value ; 
		var dis_amt = formObject.dis_value.value ; 
		var net_amt;
		var discount_amt;
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
			//	alert("Discount Amount should be less than Gross Amount");
				alert(getMessage("DISCOUNT_AMT_LT_GROSS","PO"));  
				formObject.dis_value.focus();
			}
		}
		}
	

}
function calculateDisAmount(){
		
		var formObject = document.formAmendPODetail;
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
		
		var formObject = document.formAmendPOList;
		var gross_poAmt = formObject.gross_poAmt.value ; 
		var addi_dist = formObject.addi_dist.value ; 
		var net_amt;
		var discount_amt;
		if(parseFloat(gross_poAmt) > 0){
			document.getElementById("gross_poAmt_label").innerHTML = "" + parseFloat(gross_poAmt).toFixed(3) + ""; 
			if(parseFloat(gross_poAmt) > parseFloat(addi_dist) ){
		// alert('true');
		  net_amt = gross_poAmt - addi_dist;	
		  document.getElementById("net_poAmt_label").innerHTML = "" + net_amt.toFixed(3) + ""; 
		  document.getElementById("net_poAmt").value = net_amt;
		}else{
		//	alert("Discount should be less than Gross Amount");
			alert(getMessage("DISCOUNT_AMT_LT_GROSS","PO")); 
		}
	}
}




function AdditionalDetails(bean_id, bean_name, mode) {

	var formObj = document.formAmendPOHeader;
	function_id = document.forms[0].function_id.value;
	var tit = "TITLE";
	var retVal = window.showModalDialog("../../ePO/jsp/AmendAdditionalDetails.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +  "&function_id=" + function_id + "&mode=" + mode + "&supp_code=" + formObj.supp_code.value, "", "dialogHeight:20; dialogWidth: 70; right: 1; status: no; dialogTop :300;scroll:no");
	
	
}


function exitAdditionalDetails(){

var formObj = document.formAdditionalDetails;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
		xmlDoc.loadXML(getEnhancedXMLString(formObj));
			
		xmlHttp.open("POST", "../../ePO/jsp/AmendPOValidate.jsp?bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value +  "&qnt_ref=" + formObj.qnt_ref.value +  "&pmnt_term=" + formObj.pmnt_term.value +  "&acc_no=" + formObj.acc_no.value +  "&terms_conditions=" + formObj.terms_conditions.value +  "&supp_address_1=" + formObj.supp_address_1.value +  "&delivery_mode=" + formObj.delivery_mode.value +  "&supp_address_2=" + formObj.supp_address_2.value +  "&deliver_to_address=" + formObj.deliver_to_address.value +  "&supp_address_3=" + formObj.supp_address_3.value +  "&bill_to_address=" + formObj.bill_to_address.value  + "&function_type=SETADDITIONALDETAILS", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		window.close();

}

function BillToDeliverDetails(bean_id, bean_name, mode) {

	var formObj = document.formAmendPOHeader;
	function_id = document.forms[0].function_id.value;
	var tit = "TITLE";
	var retVal = window.showModalDialog("../../ePO/jsp/AmendBillToDeliverToDetails.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +  "&function_id=" + function_id + "&mode=" + mode , "", "dialogHeight:20; dialogWidth:50; right: 1; status: no; dialogTop :300;scroll:yes");



	
}


function exitBillToDeliverDetails(){

var formObj = document.formAmendBillToDeliverToDetails;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
		xmlDoc.loadXML(getEnhancedXMLString(formObj));
			
		xmlHttp.open("POST", "../../ePO/jsp/AmendPOValidate.jsp?bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value + "&function_type=SETBILLTODELIVERTODETAILS", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		window.close();

}




function DeliverySchedule(bean_id, bean_name, mode) {

	var formObject = document.formAmendPODetail;
	var item_desc = formObject.item_desc.value ; 
	var order_qty = formObject.order_qty.value ; 
	var item_code = formObject.item_code.value ; 
	var temp_uom = formObject.temp_uom.value ; 
	var del_date = formObject.del_date.value ; 
	
	function_id = document.forms[0].function_id.value;
	
	var tit = "TITLE";
	var retVal = window.showModalDialog("../../ePO/jsp/AmendDeliverySchedule.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +  "&function_id=" + function_id + "&mode=" + mode + "&item_desc=" + item_desc + "&order_qty=" + order_qty + "&item_code=" + item_code + "&temp_uom=" + temp_uom + "&del_date=" + del_date, "", "dialogHeight:25; dialogWidth: 40; right: 1; status: no; dialogTop :300;scroll:yes");

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
		xmlHttp.open("POST", "../../ePO/jsp/AmendPOValidate.jsp?bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value +  "&item_code=" + item_code + "&function_type=SETDELIVERYVALUES", false);
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
	rem = window.showModalDialog("../../ePO/jsp/AmendItemRemarks.jsp?function_id=" + parent.parent.function_id + "&remarks=" +encodeURIComponent(remarks) + "&codedisabled=" +codedisabled, "", "dialogHeight:10; dialogWidth:30; center:0; status: no; dialogLeft :75; dialogTop :250;");
	if (rem != null && codedisabled=="") {
		document.forms[0].item_remarks.value = rem;
	}
	
}

function ItemRemarks1(remarks,codedisabled) {
	remarks = decodeURIComponent(remarks,"UTF-8");
	var rem = "";
	rem = window.showModalDialog("../../ePO/jsp/AmendItemRemarks.jsp?function_id=" + parent.parent.function_id + "&remarks=" +encodeURIComponent(remarks) + "&codedisabled=" +codedisabled, "", "dialogHeight:10; dialogWidth:30; center:0; status: no; dialogLeft :75; dialogTop :250;");
	if (rem != null && codedisabled=="") {
		document.forms[0].item_remarks.value = rem;
	}
	
}

function exitItemRemarks(){
	window.returnValue = document.formItemRemarks.item_remarks.value;
	window.close();	
}

function OrderRemarks(bean_id, bean_name, mode) {

	function_id = document.forms[0].function_id.value;
	
	var tit = "TITLE";
	var retVal = window.showModalDialog("../../ePO/jsp/AmendOrderRemarks.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +  "&function_id=" + function_id + "&mode=" + mode, "", "dialogHeight:10; dialogWidth: 30; right: 1; status: no; dialogTop :300;scroll:no");

}
function exitOrderRemarks(){
	
	var formObj = document.formOrderRemarks;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
		xmlDoc.loadXML(getEnhancedXMLString(formObj));
		xmlHttp.open("POST", "../../ePO/jsp/AmendPOValidate.jsp?bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value +  "&order_remarks=" + formObj.order_remarks.value + "&function_type=SETORDERVALUES", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		window.close();
}
function checkAppvlRef(obj_aprvlRef){
		
		var formObject = document.formAmendPODetail;
		if(obj_aprvlRef.checked){
			formObject.ref_value.disabled=false;
			document.formAmendPODetail.all.manditHidden.style.visibility="visible";		
		}
		else{
    		formObject.ref_value.disabled=true;
			document.formAmendPODetail.all.manditHidden.style.visibility="hidden";	
			document.formAmendPODetail.ref_value.value="";	
		}

}



function loadCurrency(obj_supp) {
	
	var formObj = document.formAmendPOHeader;
	formObj.supp_code.value = obj_supp.value;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../ePO/jsp/PurchaseOrderValidate.jsp?function_type=LOADCURRENCY&supplier=" + obj_supp.value + "&localCurrency=" + formObj.local_currency.value + "&bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	//alert(responseText);
	eval(responseText);
	
}

function loadDeptId1(commitCode,dept_no) {

	var formObj = document.formAmendPODetail;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../ePO/jsp/AmendPOValidate.jsp?function_type=LOADDEPTID1&commit_code=" + commitCode +"&dept_id="+ dept_no + "&bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
}	


function loadDeptId(obj_commitCode) {
	
	var formObj = document.formAmendPODetail;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../ePO/jsp/AmendPOValidate.jsp?function_type=LOADDEPTID&commit_code=" + obj_commitCode.value + "&bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	
}

function loadAccNo(obj_deptId) {
	
	var formObj = document.formAmendPODetail;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../ePO/jsp/AmendPOValidate.jsp?function_type=LOADACCNO&dept_id=" + obj_deptId.value + "&commit_code=" + formObj.commit_code.value + "&dept_desc="+ formObj.dept_id[formObj.dept_id.selectedIndex].text + "&bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	
}

function loadAccDesc(obj_accNo) {
	
	var formObj = document.formAmendPODetail;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../ePO/jsp/AmendPOValidate.jsp?function_type=LOADACCDESC&acc_no=" + obj_accNo.value + "&commit_code=" + formObj.commit_code.value + "&dept_id=" + formObj.dept_id.value + "&dept_desc="+ formObj.dept_id[formObj.dept_id.selectedIndex].text+ "&bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	formObj.acc_desc.value = decodeURIComponent(formObj.acc_desc.value,"UTF-8");
	document.getElementById("acc_desc_label").innerHTML = formObj.acc_desc.value;
		
}

function getUOMDesc(obj_uom) {
	
	var formObj = document.formAmendPODetail;
/*	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../ePO/jsp/AmendPOValidate.jsp?function_type=GETUOMDESC&uom_code=" + obj_uom.value + "&bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
*/
	document.getElementById("temp_uom_code").value = obj_uom.value;
	document.getElementById("temp_uom").value = formObj.uom[formObj.uom.selectedIndex].text;		
	
}

function getCOMMNTDesc(obj_commt) {
	
	var formObj = document.formAmendPODetail;
/*	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../ePO/jsp/AmendPOValidate.jsp?function_type=GETCOMMNTDESC&commt_code=" + obj_commt.value + "&bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
*/
	document.getElementById("temp_commt").value = formObj.commit_code[formObj.commit_code.selectedIndex].text;	
	
}




function searchCodeItem(obj) {

	var formObject = document.formAmendPODetail;

	var formHeader = parent.AmendPOHeaderFrame.document.formAmendPOHeader;
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
	//alert(returnedValues);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
		formObject.item_code.value = returnedValues[0];
		formObject.item_desc.value = returnedValues[1];
		formObject.item_desc.readOnly = true;
		formObject.add.disabled = false;
		document.formAmendPODetail.conv_fact.value = "1";
		document.formAmendPODetail.order_qty.focus();
	}
	
	if(formObject.item_code.value!=""){
		var bean_id = "amendPurchaseOrderBean";
		var bean_name = "ePO.AmendPurchaseOrderBean";
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../ePO/jsp/AmendPOValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&item_code=" + formObject.item_code.value + "&function_type=MM_UOM", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		}
	
}

//12/06/12 Rabbani Starts
function searchDetails(){

	var formHeader = parent.AmendPOHeaderFrame.document.formAmendPOHeader;
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
	//var url = "../../ePO/jsp/AmendPOSearchWindowFrame.jsp";
	var url = "../../ePO/jsp/AmendPOSearchWindowFrame.jsp?&po_purchase_unit="+formHeader.from_purchase_unit.value;
	

	retVal = window.showModalDialog(url,arguments,features);	

    if (retVal!= null){
	 retValChk = retVal
     }
	if(retValChk=="ADD"){
		var html = "<html><body><form name='dummyFormSubmit' id='dummyFormSubmit'  action='../../ePO/jsp/AmendPOList.jsp?&function=edit"+"&addToList=true' method='post'>";
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

    var formObj           = document.formAmendPOSearchWindowResult;
	var formCriteria      = parent.frameAmendPOSearchWindowCriteria.document.formAmendPOSearchWindowCriteria;	
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
			alert(getMessage("ORDER_QTY_NOT_GRT_MAX_REQ_QTY","PO"));
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
	
	var bean_id = "amendPurchaseOrderBean";
	var bean_name = "ePO.AmendPurchaseOrderBean";
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getEnhancedXMLString(formCriteria));
	xmlHttp.open("POST", "../../ePO/jsp/AmendPOValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +"&function_type=LOAD_DETAILS_NEW", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;	
	eval(responseText);
   if(result){		
		document.parentWindow.returnValue ="ADD";
		document.parentWindow.close();
	}	
}
//ends
//04/06/12
function ReloadPurchaseOrderWindow(){
		var criteriaformObj =document.formAmendPOSearchWindowCriteria;

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
	var formObj = document.formAmendPOSearchWindowResult;

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

   var formObj = document.formAmendPOSearchWindowResult;
   var req_no  = obj.value;
   var checkobj = eval("formObj.doc_no_"+req_no+"_"+index);
   var itemQtyobj = eval("formObj.order_qty_"+req_no+"_"+index);
  // var reqqtyobj = eval("formObj.req_qty_"+req_no+"_"+index);
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

 var formObject = document.formAmendPOHeader;

             var reqid_label = document.getElementById('reqid');
			 var reqiddocno = document.getElementById('reqiddocno');
			 var doc_search = document.getElementById('doc_search');
			 
			  if(formObject.po_mode.value == "R")
			 { 
			 reqid_label.style.visibility ='visible';
			 reqiddocno.style.visibility ='visible';
			 doc_search.style.visibility ='visible';
			 
			 }else{
			 reqid_label.style.visibility ='hidden';
	         reqiddocno.style.visibility ='hidden';
			 doc_search.style.visibility ='hidden';
			 
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
	argumentArray[0] = document.formAmendPOSearchWindowCriteria.SQL_ST_ITEM_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = document.formAmendPOSearchWindowCriteria.item_desc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[1];
		document.formAmendPOSearchWindowCriteria.item_code.value = returnedValues[0];
	}
	else
	{
		obj.value ="";
		document.formAmendPOSearchWindowCriteria.item_code.value =""
	}
}

var hide = 'no';

function resizeFrames(){	

	var fullFrame;

	if (parent.AmendPurchaseOrderFrmS)
	{
		fullFrame = parent.AmendPurchaseOrderFrmS;
	}

	if(hide == 'no')
	{
		if (parent.AmendPOBlankFrame)
		{
			if(parent.AmendPOBlankFrame.document.getElementById('hideImg'))
			{
				parent.AmendPOBlankFrame.document.getElementById('hideImg').src='../../eST/images/POright.png'
				fullFrame.cols = '0px,14px,*';
				parent.AmendPOListFrame.document.getElementById('amendList').style.width = "1340px";
				hide='yes';
			}	
		}	
	}
	else if(hide == 'yes')
	{
		if (parent.AmendPOBlankFrame){
			if(parent.AmendPOBlankFrame.document.getElementById('hideImg'))
			{
				parent.AmendPOBlankFrame.document.getElementById('hideImg').src='../../eST/images/POleft.png'			
				fullFrame.cols = '350px,14px,*';
				parent.AmendPOListFrame.document.getElementById('amendList').style.width = "980px";
				hide='no';
			}
		}
	}
}

function onLoadCurrCode(obj_currency){

		if(parent.AmendPODetailFrame.document.getElementById("currency_label_1")!=undefined){
		parent.AmendPODetailFrame.document.getElementById("currency_label_1").innerHTML =  obj_currency ; 
		parent.AmendPODetailFrame.document.getElementById("currency_label_2").innerHTML =  obj_currency ; 
		parent.AmendPODetailFrame.document.getElementById("currency_label_3").innerHTML =  obj_currency ; 
		parent.AmendPODetailFrame.document.getElementById("currency_label_4").innerHTML =  obj_currency ;
		parent.AmendPODetailFrame.document.getElementById("currency_label_8").innerHTML =  obj_currency ;
		}
		if(parent.AmendPOListFrame.document.getElementById("currency_label_5")!=undefined){	
		parent.AmendPOListFrame.document.getElementById("currency_label_5").innerHTML =  obj_currency  ; 
		parent.AmendPOListFrame.document.getElementById("currency_label_6").innerHTML =  obj_currency  ; 
		parent.AmendPOListFrame.document.getElementById("currency_label_7").innerHTML =  obj_currency  ; 
		}
}	
	


function perChange(obj_dis_type){
	if(obj_dis_type.value == "P")
		document.formAmendPODetail.all.perHidden.style.visibility="visible";
	else
		document.formAmendPODetail.all.perHidden.style.visibility="hidden";
}



function confirmOverride() {
	
	var retVal = "";
	var dialogHeight = "8";
	var dialogWidth = "19";
	var dialogTop = "230";
	var center = "1";
	var status = "no";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments = "";
	var url = "../../ePO/jsp/AmendConfirmOverride.jsp";
	retVal = window.showModalDialog(url, arguments, features);
	if (retVal == null) {
		retVal = "";
	}
	return retVal;
}


function confirmOverrideError() {
	
	var retVal = "";
	var dialogHeight = "8";
	var dialogWidth = "19";
	var dialogTop = "230";
	var center = "1";
	var status = "no";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments = "";
	var url = "../../ePO/jsp/AmendConfirmOverrideError.jsp";
	retVal = window.showModalDialog(url, arguments, features);
	if (retVal == null) {
		retVal = "";
	}
	return retVal;
}


function confirmAmend() {
	
	var retVal = "";
	var dialogHeight = "8";
	var dialogWidth = "25";
	var dialogTop = "230";
	var center = "1";
	var status = "no";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments = "";
	var url = "../../ePO/jsp/ConfirmAmend.jsp";
	retVal = window.showModalDialog(url, arguments, features);
	if (retVal == null) {
		retVal = "";
	}
	return retVal;
}


function checkUOMConvFactor() {

	var formObj = document.formAmendPODetail;
	
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../ePO/jsp/AmendPOValidate.jsp?uom_code=" + formObj.uom.value + "&pur_uom_code=" + formObj.temp_uom_code.value + "&bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value + "&function_type=CHECKUOMCONVFACTOR" + "&item_code=" + formObj.item_code.value, false);
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
	document.formAmendPODetail.conv_fact.value = _value;
}

function setUOMConvFactor1(_value,_rulestring) {

	document.getElementById("conv_fact").value = _value;
}


function StoreDetails(bean_id, bean_name, mode,req_no) {
//	alert(req_no);
	function_id = document.forms[0].function_id.value;
	
	var tit = "TITLE";
	var retVal = window.showModalDialog("../../ePO/jsp/AmendStoreDetails.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +  "&function_id=" + function_id + "&mode=" + mode +"&req_no=" +req_no, "", "dialogHeight:10; dialogWidth: 50; right: 1; status: no; dialogTop :300;scroll:no");

}
function exitStoreDetails(){
	window.close();	
}

function checkValidateQryDate(){

	var formObject = document.formAmendPOQueryCriteria;
	
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
			document.formAmendPOQueryCriteria.submit();
		}
	
	}else{
		document.formAmendPOQueryCriteria.submit();
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



