
var xmlDom;
var xmlHttp;
var finalizeType;
function assignBean(frmObject) {
	bean_id = frmObject.bean_id.value;
	bean_name = frmObject.bean_name.value;
	/*xmlDom = new ActiveXObject("Microsoft.XMLDom");
	xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");*/
	var xmlDom = "";
	var xmlHttp = new XMLHttpRequest();
}
function create() {
	f_query_add_mod.location.href = "../../eST/jsp/UrgentIssueFrame.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
}
function callItemSearchScreen() {
	//alert("a18");
	var search_string = parent.frameUrgentIssueListHeader.formUrgentIssueListHeader.item_desc.value;
	var store_code = parent.frameUrgentIssueListHeader.formUrgentIssueListHeader.store_code.value;
	var to_store_code = parent.parent.UrgentIssueHeaderFrame.formUrgentIssueHeader.to_store_code.value;
	var category = "A";
	var sole_source = "A";
	var ps_item = "A";
	var mfg_item = "A";
	var expiry = "A";
	var consignment = "A";
	var item_class = "";
	var retVal = callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment);
	if (retVal != null) {
		document.formUrgentIssueListHeader.item_code.value = retVal[0];
		document.formUrgentIssueListHeader.item_desc.value = retVal[1];
		document.formUrgentIssueListHeader.expiry_yn.value = retVal[2];
		document.formUrgentIssueListHeader.uom.value = retVal[15];
		document.formUrgentIssueListHeader.uom_code.value = retVal[13];
		document.formUrgentIssueListHeader.document.getElementById("td_uom").innerHTML = "<b>" + retVal[15] + "</b>";
		document.formUrgentIssueListHeader.trade_id_applicable_yn.value = retVal[17];
		document.formUrgentIssueListHeader.batch_id_applicable_yn.value = retVal[18];
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		var xml = "<root><SEARCH/></root>";
		xmlDoc.loadXML(xml);
		xmlHttp.open("POST", "../../eST/jsp/UrgentIssueValidate.jsp?store_code=" + store_code + "&to_store_code=" + to_store_code + "&item_code=" + retVal[0] + "&validate=CHECK_PROC", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		//alert(responseText)
		eval(responseText);
		if (result) {
			var errorPage = "../../eCommon/jsp/error.jsp";
			if (document.formUrgentIssueListHeader.stock_item_yn.value == "Y") {
				if (document.formUrgentIssueListHeader.stock_available_yn.value == "N") {
					alert(getMessage("STOCK_NOT_AVAILABLE", "ST"));
					parent.parent.parent.frames[2].location.href = errorPage + "?err_num=" + getMessage("STOCK_NOT_AVAILABLE");
				}
			} else {
				alert(getMessage("NOT_STOCK_ITEM", "ST"));
				parent.parent.parent.frames[2].location.href = errorPage + "?err_num=" + getMessage("NOT_STOCK_ITEM");
			}
		} else {
			var errorPage = "../../eCommon/jsp/error.jsp";
			parent.parent.parent.frames[2].location.href = errorPage + "?err_num=" + getMessage(flag);
			document.formUrgentIssueListHeader.item_desc.select();
			document.formUrgentIssueListHeader.item_desc.focus();
		}
		/*	document.getElementById("ed_lbl").innerText=""
	document.getElementById("ed_data").innerText="";
	//document.getElementById("bid_lbl").innerText=""
	document.getElementById("bid_data").innerText="";
	document.getElementById("bl_lbl").innerText="";
	document.getElementById("bl_data").innerText="";
	document.getElementById("aq_lbl").innerText=""
	document.getElementById("aq_data").innerText="";
	document.getElementById("tn_lbl").innerText="";
	document.getElementById("tn_data").innerText="";
*/
	}
}
function ValidateItem(obj) {
	/*var formObj=  parent.frameOpeningStockListHeader.document.formOpeningStockListHeader;
	var xmlHttp = new ActiveXObject("Microsoft.XMLHTTP" );
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/OpeningStockValidate.jsp?validate=ITEM_CODE&search_code=" + formObj.item_desc.value, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);*/
}
function cancel_me() {
	parent.frameUrgentIssueListHeader.location.href = "../../eST/jsp/UrgentIssueListHeader.jsp";
	parent.parent.frameUrgentIssueList.frameUrgentIssueListDetail.location.href = "../../eCommon/html/blank.html";
}
function addToList(obj) {
	var operation = obj;
	var formObj = parent.frameUrgentIssueListHeader.document.formUrgentIssueListHeader;
	var formObj1 = parent.parent.frameUrgentIssueList.frameUrgentIssueListDetail.document.formGeneralaBatchList;
	if (formObj1 == null) {
		EditToList("add");
	} else {
		var proceed = false;
		var messageFrame = parent.parent.parent.messageFrame;
		var errorPage = "../../eCommon/jsp/error.jsp";
		var fields = new Array(formObj.item_desc, formObj.required_qty);
		var names = new Array(getLabel("Common.item.label", "Common"), getLabel("Common.Quantity.label", "Common"));
		var obj = null;
		obj = getBlankField(fields, names, messageFrame, errorPage);
		if (obj == null) {
			
			//To check that the sum of qty in detail esp = quantity in dtl
			var total_checkboxes = formObj1.total_checkboxes.value;
			var total_qty = 0;
			for (i = 0; i < total_checkboxes; i++) {
				var qty = eval("formObj1.item_qty_" + i).value;
				if (qty != "") {
					if (!isNaN(qty)) {
						total_qty += parseFloat(qty);
					}
				}
			}
			var quantity = parent.frameUrgentIssueListHeader.document.forms[0].required_qty.value;
			if (total_qty == quantity) {
				//alert("sdfsdfasdfsdf before"+formObj.item_unit_cost.value);
				formObj1.item_unit_cost.value = formObj.item_unit_cost.value;
				formObj1.item_cost_value.value = formObj.item_cost_value.value;
				//alert("sdfsdfasdfsdf after"+formObj.item_unit_cost.value);
				var xmlHttp = new XMLHttpRequest();
				var xmlDoc="";
				//alert(getEnhancedXMLString(formObj1));
				xmlDoc.loadXML(getEnhancedXMLString(formObj1));
				xmlHttp.open("POST", "../../eST/jsp/UrgentIssueValidate.jsp?operation=" + operation + "&doc_srl_no=" + formObj.doc_srl_no.value + "&item_code=" + formObj.item_code.value + "&item_desc=" + formObj.item_desc.value + "&required_qty=" + formObj.required_qty.value + "&item_unit_cost=" + formObj.item_unit_cost.value + "&item_cost_value=" + formObj.item_cost_value.value + "&expiry_yn=" + formObj1.expiry_yn.value + "&batch_id_applicable_yn=" + formObj1.batch_id_applicable_yn.value + "&trade_id_applicable_yn=" + formObj1.trade_id_applicable_yn.value + "&stock_uom_code=" + formObj.uom_code.value + "&validate=EDIT_BATCH_LIST", false);
				xmlHttp.send(xmlDoc);
				responseText = xmlHttp.responseText;
				eval(responseText);
				if (result) {
					refreshDetails();
				} else {
					parent.parent.parent.frames[2].location.href = errorPage + "?err_num=" + getMessage(message);
				}
			} else {
				alert(getMessage("QUANTIY_MUST_BE_EQUAL", "ST"));
			}
		}
	}
}
function refreshDetails() {
//	alert(parent.parent.frameUrgentIssueDetail.name);
	//doc_type_code, doc_no formUrgentIssueDetail
	parent.parent.frameUrgentIssueDetail.location.reload();
	parent.frameUrgentIssueListHeader.location.href = "../../eST/jsp/UrgentIssueListHeader.jsp";
	parent.frameUrgentIssueListDetail.location.href = "../../eCommon/html/blank.html";
}
function callBatchSearch() {
	//alert(parent.frameUrgentIssueListHeader.formUrgentIssueListHeader.name);
	var objForm = parent.frameUrgentIssueListHeader.formUrgentIssueListHeader;
	var store_code = objForm.store_code.value;
	var to_store_code = objForm.to_store_code.value;
	var item_code = objForm.item_code.value;
	var includeZeroStockBatches = "N";
	var includeExpiredBatches = "N";
	var includeSuspendedBatches = "N";
	var searchFunction = "Y";
	var multipleSelect = "Y";
	var item_desc = objForm.item_desc.value;
	var required_qty = objForm.required_qty.value;
	var expiry_yn = objForm.expiry_yn.value;
	var trade_id_applicable_yn = objForm.trade_id_applicable_yn.value;
	var batch_id_applicable_yn = objForm.batch_id_applicable_yn.value;
	var uom_code = objForm.uom_code.value;
	var retval = callBatchSearchWindow(item_code, store_code, includeZeroStockBatches, includeExpiredBatches, includeSuspendedBatches, searchFunction, multipleSelect);
	if (retval != null) {
		parent.frameUrgentIssueListDetail.location.href = "../../eST/jsp/GeneralBatchList.jsp?Param=BATCH&store_code=" + store_code + "&to_store_code=" + to_store_code + "&item_code=" + item_code + "&required_qty=" + required_qty + "&expiry_yn=" + expiry_yn + "&item_desc=" + item_desc + "&trade_id_applicable_yn=" + trade_id_applicable_yn + "&batch_id_applicable_yn=" + batch_id_applicable_yn + "&uom_code=" + uom_code + "&operation=batch&qty_legend=Iss.Qty";
	}
}
function ComputeCost() {
	/*	var quantity=document.formUrgentIssueListHeader.adj_item_qty.value;
	var value=document.formUrgentIssueListHeader.item_cost_value.value;
	var cost=value/quantity;
	if(!(quantity!="" && value!="")){
		document.getElementById("td_cost").innerText="";
		document.formUrgentIssueListHeader.item_unit_cost.value="";
	}
	else{
		var x=setNumber(cost,2);
		document.getElementById("td_cost").innerHTML="<b>"+x+"</b>";
//		alert("cost : "+cost);
		document.formUrgentIssueListHeader.item_unit_cost.value=cost;
	}*/
	var quantity = document.formUrgentIssueListHeader.required_qty.value;
	var cost = document.formUrgentIssueListHeader.document.getElementById("td_unit_cost").innerText;
	var avl_qty = document.formUrgentIssueListHeader.available_stock.value;
	if (avl_qty != "" && quantity != "") {
		if (parseInt(avl_qty) < parseInt(quantity)) {
			alert(getMessage("QTY_NOT_GRT_AVLQTY", "ST"));
			document.formUrgentIssueListHeader.required_qty.value =''; //Edge Having issue as it is going in loop, so have to clear.
			document.formUrgentIssueListHeader.required_qty.focus();
		} else {
			if (quantity != "" && cost != "") {
				value = parseInt(cost) * parseInt(quantity);
				document.getElementById("val_id").innerText = "Value";
				document.getElementById("val_dat").innerText = value;
				document.formUrgentIssueListHeader.Edit.disabled = false;
				document.formUrgentIssueListHeader.batchsearch.disabled = false;
				document.formUrgentIssueListHeader.Add.disabled = false;
			} else {
				document.getElementById("val_id").innerText = "";
				document.getElementById("val_dat").innerText = "";
			}
		}
	}
}
function EditToList(obj) {
	var objForm = parent.frameUrgentIssueListHeader.formUrgentIssueListHeader;
	var store_code = objForm.store_code.value;
	var to_store_code = objForm.to_store_code.value;
	var item_code = objForm.item_code.value;
	var item_desc = objForm.item_desc.value;
	var required_qty = objForm.required_qty.value;
	var expiry_yn = objForm.expiry_yn.value;
	var trade_id_applicable_yn = objForm.trade_id_applicable_yn.value;
	var batch_id_applicable_yn = objForm.batch_id_applicable_yn.value;
	var uom_code = objForm.uom_code.value;
	//alert(objForm.item_unit_cost.value);
	parent.frameUrgentIssueListDetail.location.href = "../../eST/jsp/GeneralBatchList.jsp?Param=EDIT&store_code=" + store_code + "&to_store_code=" + to_store_code + "&item_code=" + item_code + "&required_qty=" + required_qty + "&expiry_yn=" + expiry_yn + "&item_desc=" + item_desc + "&item_unit_cost=" + objForm.item_unit_cost.value + "&item_cost_value=" + objForm.item_cost_value.value + "&trade_id_applicable_yn=" + trade_id_applicable_yn + "&batch_id_applicable_yn=" + batch_id_applicable_yn + "&uom_code=" + uom_code + "&operation=" + obj + "&qty_legend=Iss.Qty";
}
function apply() {
	var formObj = f_query_add_mod.UrgentIssueHeaderFrame.document.formUrgentIssueHeader;
	var errorPage = "../../eCommon/jsp/error.jsp";
	finalizeType = "N";
	if (formObj.authorize_yn.value == YES) {
		finalizeType = confirmAuthorize();
	}
	formObj.finalize_yn.value = finalizeType;
	eval(formApply(formObj, ST_CONTROLLER));
	messageFrame.location.href = errorPage + "?err_num=" + message + "<BR>" + flag;
	if (result) {
		onSuccess();
	}
}
function AddFromBatch(operation) {
	if (operation == "add") {
			//alert("ADD_TO_LIST");
		var formObj = parent.frameUrgentIssueListHeader.document.formUrgentIssueListHeader;
		var formObj1 = parent.parent.frameUrgentIssueList.frameUrgentIssueListDetail.document.formGeneralaBatchList;
		var proceed = false;
		var messageFrame = parent.parent.parent.messageFrame;
		var errorPage = "../../eCommon/jsp/error.jsp";
		var fields = new Array(formObj.item_desc, formObj.required_qty);
		var names = new Array(getLabel("Common.item.label", "Common"), getLabel("Common.Quantity.label", "Common"));
		var obj = null;
		obj = getBlankField(fields, names, messageFrame, errorPage);
		if (obj == null) {
			//To check that the sum of qty in detail esp = quantity in dtl
			var total_checkboxes = formObj1.total_checkboxes.value;
			var total_qty = 0;
			for (i = 0; i < total_checkboxes; i++) {
				var qty = eval("formObj1.item_qty_" + i).value;
				if (qty != "") {
					if (!isNaN(qty)) {
						total_qty += parseFloat(qty);
					}
				}
			}
			var quantity = parent.frameUrgentIssueListHeader.document.forms[0].required_qty.value;
			if (total_qty == quantity) {
				var xmlHttp = new XMLHttpRequest();
				var xmlDoc="";
				//alert(getEnhancedXMLString(formObj));
				xmlDoc.loadXML(getEnhancedXMLString(formObj));
				xmlHttp.open("POST", "../../eST/jsp/UrgentIssueValidate.jsp?operation=" + operation + "&validate=ADD_TO_LIST", false);
				xmlHttp.send(xmlDoc);
				responseText = xmlHttp.responseText;
				eval(responseText);
				if (result) {
					//refreshDetails();
				} else {
					parent.parent.parent.frames[2].location.href = errorPage + "?err_num=" + getMessage(message);
				}
			} else {
				alert(getMessage("QUANTIY_MUST_BE_EQUAL", "ST"));
			}
		}
	}
}
function onSuccess() {
	f_query_add_mod.location.href = "../../eCommon/html/blank.html";
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + message + "<BR>" + flag;
	return;
}

