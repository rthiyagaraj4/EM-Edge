
function create() {
	f_query_add_mod.location.href = "../../eST/jsp/KitTemplateFrame.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
}
function query() {
	f_query_add_mod.location.href = "../../eST/jsp/KitTemplateQueryCriteria.jsp?function_id=" + function_id;
}
function reset() {
	f_query_add_mod.location.reload();
}
function onSuccess() {
	f_query_add_mod.location.href = "../../eCommon/html/blank.html";
}
function apply() {
	var errorPage = "../../eCommon/jsp/error.jsp";
	if(f_query_add_mod.frameKitTemplateMain==undefined){
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" ;
	return
	}
	if (f_query_add_mod.frameKitTemplateMain.document.KitTemplateMainform == null) {
		return;
	}
	var formObj = f_query_add_mod.frameKitTemplateMain.document.KitTemplateMainform;
	var arrayObject = new Array(formObj.kit_template_code, formObj.kit_template_desc);
	var names = new Array(getLabel("eST.KitTemplateCode.label", "ST"), getLabel("eST.KitTemplateDescription.label", "ST"));
	if (checkSTFields(arrayObject, names, messageFrame)) {
		var formObj1 = f_query_add_mod.frameKitTemplateListDetail.document.KitTemplateListDetailform;
		var canProcess = formObj1.records.value;
		if (parseInt(canProcess) == 0) {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + getMessage("MIN_ONE_ITEM_REQD", "ST");
			return;
		} else {
			var responseText = formApply(formObj, ST_CONTROLLER);
			eval(responseText);
			messageFrame.location.href = errorPage + "?err_num=" + message;
			if (result) {
				onSuccess();
			}
		}
	}
}
async function callItemSearchScreen() {
	var search_string = "";
	if (!document.KitTemplateAddModifyform.item_desc.readOnly) {
		search_string = document.KitTemplateAddModifyform.item_desc.value;
	}
	var store_code = "";
	var to_store_code = "";
	var category = "A";
	var sole_source = "A";
	var ps_item = "A";
	var mfg_item = "A";
	var expiry = "A";
	var consignment = "A";
	/* Added on 5/31/2005 by Ram
		chkitemstorecmb is added to display the  item check check box in  item search  query criteria page and it is used to check the item which exist in both the stores.
		 If that check box is checked it will display the items which is associated in both the stores and also have qty_on_hand >0 . If  there is no to_store  code , then assign blank to it.
		 */ 
	var item_class = "";
	retVal =await callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment);
	if (retVal != null) {
		document.KitTemplateAddModifyform.item_code.value = retVal[0];
		document.KitTemplateAddModifyform.item_desc.value = retVal[1];		
		document.KitTemplateAddModifyform.item_desc.disabled = true;
		document.KitTemplateAddModifyform.item_search.disabled = true;
		/**
		* @Name - Krishna Kiran 
		* @Date - 20/01/2010
		* @Inc# - 15496 (SRR20056-CRF-0537.2)
		* @Desc - decimal allow Y/N (retVal[27])is assigned to hidden variable dec_allowed_yn.
		*/
		document.KitTemplateAddModifyform.dec_allowed_yn.value = retVal[27]; 
		
		var formObj = document.KitTemplateAddModifyform;
		var xmlString = getXMLString(null);
        var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
		var xmlHttp = new XMLHttpRequest();
		//var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eST/jsp/KitTemplateValidate.jsp?item_code=" + retVal[0] + "&validate=GET_STATUS", false);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(xmlString);
		var responseText = xmlHttp.responseText;
		responseText = trimString(responseText); 
		eval(responseText);
	}
}
function addToList() {
	var formObj = parent.frameKitTemplateAddModify.document.KitTemplateAddModifyform;
	var uom_desc = formObj.uom_code.options[formObj.uom_code.selectedIndex].text;
	var arrayObject = new Array(formObj.item_code, formObj.qty, formObj.uom_code, formObj.seq_no,formObj.usage_type);
	var names = new Array(getLabel("Common.item.label", "Common"), getLabel("Common.Quantity.label", "Common"), getLabel("Common.uom.label", "Common"), getLabel("Common.SequenceNo.label", "Common") ,getLabel("eST.UsageType.label", "ST") );
	var formObjDtl = parent.frameKitTemplateListDetail.document.KitTemplateListDetailform;
	var blankObject = checkSTFields(arrayObject, names, parent.parent.messageFrame);
	//alert("usage_type::" +formObj.usage_type.value);
	if (blankObject) {
		var xmlString = getXMLString(null);
		var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
		var xmlHttp = new XMLHttpRequest();
		//var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));//getEnhancedXMLString(formObjDtl)); //27/07/12
		xmlHttp.open("POST", "../../eST/jsp/KitTemplateValidate.jsp?validate=ADD_TO_LIST&item_code=" + formObj.item_code.value + "&item_desc=" + encodeURIComponent(formObj.item_desc.value) + "&qty=" + formObj.qty.value + "&seq_no=" + formObj.seq_no.value + "&uom_code=" + formObj.uom_code.value + "&eff_status=" + formObj.eff_status.value + "&index=" + formObj.index.value + "&db_action=" + formObj.db_action.value +"&usage_type=" + formObj.usage_type.value, false);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(xmlString);
		var responseText = xmlHttp.responseText;
		responseText = trimString(responseText);
		eval(responseText);
		if (result) {
			parent.frameKitTemplateAddModify.location.href = "../../eST/jsp/KitTemplateAddModify.jsp?mode=" + MODE_INSERT;
			parent.frameKitTemplateListDetail.location.href = "../../eST/jsp/KitTemplateListDetail.jsp?mode=" + MODE_INSERT;
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
		}
		if (!result) {
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "ST");
		}
	}
}
function cancel_me() {
	parent.frameKitTemplateAddModify.location.href = "../../eST/jsp/KitTemplateAddModify.jsp?mode=" + MODE_INSERT;
}
function ModifyData(index, obj, uom, status, db_action) {
	var item_code = obj.cells[0].innerText;
	var item_desc = obj.cells[1].innerText;
	var qty = obj.cells[2].innerText;
	var uom_code = uom;
	var seq_no = obj.cells[4].innerText;
	var eff_status = status;
	//27/07/12
	var usage_type = obj.cells[6].innerText;
	//alert("usage_type====>" +usage_type);
	/*if(usage_type=="Required"){
	alert("usage_type===r=>" +usage_type);
	 usage_type = "R";
	}else if(usage_type == "Optional/Required"){
	alert("usage_type===or=>" +usage_type);
	 usage_type = "OR";
    }else if(usage_type == "Optional/Pre-Selected"){
	  usage_type = "OPS";
	}else if(usage_type == "Optional/De-Selected"){
	   usage_type = "ODS";
	 }*/
	//27/07/12
	parent.frameKitTemplateAddModify.location.href = "../../eST/jsp/KitTemplateAddModify.jsp?mode=" + MODE_MODIFY + "&function_id=" + parent.parent.function_id + "&item_code=" + item_code + "&item_desc=" + escape(item_desc) + "&qty=" + qty + "&uom_code=" + uom_code + "&seq_no=" + seq_no + "&eff_status=" + eff_status + "&index=" + index + "&db_action=" + db_action +"&usage_type="+ usage_type ;
}
function Modify(obj) {
	var kit_template_code = obj.cells[0].innerText;
	var kit_template_desc = obj.cells[1].innerText;
	//var eff_status = obj.cells[2].innerText;
	var fontElement  = obj.cells[2].querySelector('font');
	var eff_status = fontElement.innerText || fontElement.textContent;
	document.location.href = "../../eST/jsp/KitTemplateFrame.jsp?mode=" + MODE_MODIFY + "&function_id=" + parent.function_id + "&kit_template_code=" + kit_template_code + "&kit_template_desc=" + escape(kit_template_desc) + "&eff_status=" + eff_status;
}
function assignValue(obj) {
	if (obj.checked == true) {
		obj.value = "E";
	} else {
		obj.value = "D";
	}
}
function assignValue1(obj) {
	if (obj.checked == true) {
		obj.value = "E";
	} else {
		obj.value = "D";
	}
	document.KitTemplateMainform.eff_status.value = obj.value;
}
function checkSeqNo(obj) {
	var str = obj.value;
	if (str.charAt(0) == "0" && str.length > 1) {
		var str1 = str.substring(1, str.length);
		obj.value = str1;
	}
}
function CheckForSequence(event) {
	var strCheck = "1234567890";
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) {
		return false;
	}  // Not a valid key
	return true;
}

