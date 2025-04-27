var toolBarString = "";
function create() {
	f_query_add_mod.location.href = "../../eST/jsp/ItemHeaderAddModify.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
}
function query() {
	callItemSearchScreen();
}
function apply() {
	var formObj = f_query_add_mod.document.formItemHeader;
	if(formObj==undefined){
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" ;
	return
	}
	var fields = new Array(formObj.item_code);
	var names = new Array(getLabel("Common.code.label", "Common"));
	var errorPage = "../../eCommon/jsp/error.jsp";
	var blankObject = null;

	blankObject = checkSTFields(fields, names, messageFrame, errorPage);
	if (blankObject == true) {
		if (!validateRecordsValues(f_query_add_mod.document.formItemHeader, messageFrame)) {
			return;
		}
		if (f_query_add_mod.document.getElementById("td_short_desc").innerText == "") {
			return;
		}
		eval(formApply(formObj, ST_CONTROLLER));
	
		messageFrame.location.href = errorPage + "?err_num=" + message;
		if (result) {
			if (flag != "") {
				alert(flag + ". " + getLabel("eST.ItemnotmappedtoDrug.label", "ST"));
			}
			onSuccess();
		}
	}
}
function reset() {
	if (f_query_add_mod.document.formItemHeader != null) {
		f_query_add_mod.location.reload();
	}
	if (f_query_add_mod.document.query_form != null) {
		f_query_add_mod.document.query_form.reset();
	}
}
async function onSuccess() {
	var mode = f_query_add_mod.document.formItemHeader.mode.value;
	var item_code = f_query_add_mod.document.formItemHeader.item_code.value;
	var long_desc = f_query_add_mod.document.formItemHeader.long_desc.value;
	var base_unit_code = f_query_add_mod.document.formItemHeader.sale_uom.value;
	var base_unit_desc = f_query_add_mod.document.getElementById("sale_uom").options[f_query_add_mod.document.getElementById("sale_uom").selectedIndex].text;
	var medical_item_yn = f_query_add_mod.document.formItemHeader.medical_item_yn.value;
	var drug_item_yn = f_query_add_mod.document.formItemHeader.drug_item_yn.value;
	var short_desc = f_query_add_mod.document.getElementById("td_short_desc").innerText;
	var drug_chk = f_query_add_mod.document.formItemHeader.drug_item_yn.checked;
	var med_item_chk = f_query_add_mod.document.formItemHeader.medical_item_yn.checked;
	var or_status = f_query_add_mod.document.formItemHeader.or_status.value;
	var bean_id = f_query_add_mod.document.formItemHeader.bean_id.value;
	var bean_name = f_query_add_mod.document.formItemHeader.bean_name.value;
	if (mode == MODE_INSERT) {
		reset();
	} else {
		f_query_add_mod.document.location.reload();
	}
	var chk = false;
	
	if (med_item_chk && !drug_chk) {
		if (mode == MODE_MODIFY && or_status == "true") {
			chk = confirm(getMessage("MODIFY_ORDER_INFO", "PH"));
			mode = MODE_MODIFY;
		} else {
			chk = confirm(getMessage("SETUP_ORDER_INFO", "PH"));
			mode = MODE_INSERT;
		}
	}
	if (chk) {
		var dialogHeight = "90vh";
		var dialogWidth = "90vw";
		var dialogTop = "10";
		var dialogLeft = "50";
		var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogLeft:" + dialogLeft + "; dialogTop:" + dialogTop + "; status=no";
		var url = "../../eOR/jsp/OROrderCatalog.jsp?mode=" + mode + "&order_catalog_code=" + item_code + "&long_desc=" + encodeURIComponent(long_desc) + "&short_desc=" + encodeURIComponent(short_desc) + "&module_id=OT&order_category=PH&sql_order_type=MS&order_type=MS&sql_setting=&sql_auth_level=&uom_desc=" + encodeURIComponent(base_unit_desc) + "&uom_code=" + base_unit_code;


		var arguments = "";
		var retVal = await top.window.showModalDialog(url, arguments, features);
		
		if(restoreToolbar(bean_id,bean_name)){
			create();
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		}
	} else {
		reset();
	}
}
function restoreToolbar(bean_id,bean_name){
	var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();

    var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
    xmlStr +=" /></root>";
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST","ItemValidate.jsp?func_mode=toolBar&"+toolBarString+"&bean_id="+bean_id+"&bean_name"+bean_name,false);
    xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);
	return true
}

function Modify(obj) {
	var code1 = obj.cells[0].innerText;
	if (code1 != null) {
		var retVal = code1.split("^");
		top.window.returnValue = retVal;
		top.close();
	} else {
		f_query_add_mod.document.location.href = "../../eCommon/html/blank.html";
	}
}
function assignBean(frmObject) {
	bean_id = frmObject.bean_id.value;
	bean_name = frmObject.bean_name.value;
	//xmlDom = new ActiveXObject("Microsoft.XMLDom");
	//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	var xmlDom = null;
	var xmlHttp = null;
	if (window.XMLHttpRequest) {
        xmlHttp = new XMLHttpRequest();
        xmlDom = document.implementation.createDocument("", "", null);
    } else if (window.ActiveXObject) { 
        /*xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        xmlDom = new ActiveXObject("Microsoft.XMLDOM");*/
		var xmlDom = "";
		var xmlHttp = new XMLHttpRequest();
    }
}
function clearDetails(detailForm) {
	detailForm.all.td_short_desc.innerText = "";
	detailForm.all.td_ps_item_yn.innerHTML = "&nbsp;";
	detailForm.all.td_sole_source_yn.innerHTML = "&nbsp;";
	detailForm.all.td_trade_id_applicable_yn.innerHTML = "&nbsp;";
	detailForm.all.td_gen_uom_code.innerText = "";
	detailForm.all.td_manufacturer.innerText = "";
	detailForm.all.td_sale_stk_uom_conv.innerHTML = "&nbsp;";
	detailForm.all.item_search.disabled = false;
	detailForm.all.item_code.disabled = false;
}
function getItemDetails(detailForm) {
	if (!(CheckForSpecialChars(document.formItemHeader.item_code))) {
		clearDetails(detailForm);
		detailForm = document.formItemHeader;
		var errorPage = "../../eCommon/jsp/error.jsp";
		if (detailForm.item_code.value != "") {
			assignBean(detailForm);
			var xmlStr = "<root><SEARCH " + detailForm.item_code.name + "=\"" + detailForm.item_code.value + "\"/></root>";
			var xmlDoc = "";
			var xmlHttp = new XMLHttpRequest();
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			//xmlDom.loadXML(xmlStr);
			xmlHttp.open("POST", "../../eST/jsp/ItemValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name, false);
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText;
			responseText = trimString(responseText);
			eval(responseText);
			if (!result) {
				checkMMInstParam(detailForm.item_code,detailForm.item_desc);
			} else {
				document.formItemHeader.item_code.blur();
				document.formItemHeader.item_code.disabled = true;
				document.formItemHeader.item_search.disabled = true;
				if(document.formItemHeader.drug_item_yn.checked == false && document.formItemHeader.medical_item_yn.checked == true){
					//document.getElementById("td_ImageFilename").style.visibility="visible";
					//document.getElementById("td_filepath").style.visibility="visible";
					document.formItemHeader.prompt_alert_yn.disabled = false;
				}else{
					document.formItemHeader.prompt_alert_yn.disabled = true;
				}
				parent.messageFrame.location.href = errorPage + "?err_num=";
			}
		} else {
			document.formItemHeader.item_search.disabled = false;
		}
	} else {
		if (document.formItemHeader.item_code.value != "") {
			document.formItemHeader.item_code.focus();
			document.formItemHeader.item_code.select();
		}
	}
}
function getUOMConvertionFactor() {
	var detailForm = document.formItemHeader;
	var errorPage = "../../eCommon/jsp/error.jsp";
	parent.messageFrame.location.href = errorPage + "?err_num=";
	if (detailForm.sale_uom.value != "") {
		var gen_uom_code = document.formItemHeader.item_gen_uom_code.value;
		var item_uom_code = document.formItemHeader.item_gen_uom_code.value;
		assignBean(detailForm);
		var xmlDom = "";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr = "<root><SEARCH " + detailForm.sale_uom.name + "=\"" + detailForm.sale_uom.value + "\"/></root>";
		//xmlDom.loadXML(xmlStr);
		xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/getUomConvertionValue.jsp?item_uom_code=" + item_uom_code + "&item_gen_uom_code=" + gen_uom_code + "&bean_id=" + bean_id + "&bean_name=" + bean_name, false);
		xmlHttp.send(xmlDom);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		eval(responseText);
		if (!result) {
			parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage(flag, "ST");
			document.getElementById("td_sale_stk_uom_conv").innerTEXT = "";
			return;
		}
	}
	return;
}
function checkMMInstParam(objCode, objDesc) {
	var detailForm = document.formItemHeader;
	var xmlDom = "";
	var xmlDom = new DOMParser().parseFromString("<root></root>", "text/xml");
	assignBean(detailForm);
	var xmlStr = "<root><SEARCH " + detailForm.item_code.name + "=\"" + detailForm.item_code.value + "\"/></root>";
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", "../../eST/jsp/ItemMMInstParam.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name, false);
	xmlHttp.send(xmlDom);
	var responseText = xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);
	if (result) {
		var sql = "";
		if (message == "P") {
			sql = document.formItemHeader.SQL_ST_ITEM_SELECT_INV_P.value;
		} else {
			sql = document.formItemHeader.SQL_ST_ITEM_SELECT_SINGLE.value;
		}
		searchItem(objCode, objDesc, sql);
		return;
	}
}
async function searchItem(objCode, objDesc, sql) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.formItemHeader.language_id.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = objCode.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues =await CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		var str =unescape(returnedValues);
	 	var arr = str.split(",");
		objCode.value = arr[0];
		objDesc.value = arr[1];
		objCode.focus();
	}
}
async function callItemSearchScreen() {
	//alert("a5");
	var search_string = "";
	var store_code = "";
	var category = "A";
	var sole_source = "A";
	var mfg_item = "A";
	var expiry = "A";
	var consignment = "A";
	var ps_item = "A";
	var item_class = "";
	retValue = await callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment);
 		
	var ret1=unescape(retValue);
	//alert("ret13 "+ret1);
		 	var arr=ret1.split(",");
	if (retValue != null) {
		  /**
			* @Name - Priya 
			* @Date - 17/12/2009
			* @Inc# - IN017176
			* @Desc - To Display ® properly in Item desc without junck characters
			* added 'unescape(retValue[1])' in the next line code
			*/
			f_query_add_mod.document.location.href = "../../eST/jsp/ItemHeaderAddModify.jsp?mode=" + MODE_MODIFY + "&item_code=" + retValue[0] + "&item_name=" + encodeURIComponent(unescape(retValue[1])) + "&m_ps_item_yn=" + retValue[10] + "&m_sole_source_yn=" + retValue[11] + "&m_gen_uom=" + retValue[13] + "&m_gen_uom_code=" + retValue[15] + "&m_manufacturer_id=" + retValue[16] + "&m_long_desc=" + retValue[9] + "&currsuppdesc=" + retValue[22] + "&long_desc=" +  encodeURIComponent(retValue[9]);
	} else {
		f_query_add_mod.document.location.href = "../../eCommon/html/blank.html";
	}
}

function changeDrug() {
	if (document.formItemHeader.medical_item_yn.checked == true) {
		document.formItemHeader.drug_item_yn.disabled = false;
		document.formItemHeader.machine_code.disabled = true;
		//document.getElementById("td_ImageFilename").style.visibility = "visible";
		//document.getElementById("td_filepath").style.visibility = "visible";
		document.formItemHeader.prompt_alert_yn.disabled = false;
	} else {
		document.formItemHeader.drug_item_yn.disabled = true;
		document.formItemHeader.drug_item_yn.checked = false;
		document.formItemHeader.drug_item_yn.value = "N";
		document.formItemHeader.expiry_yn.disabled = false;
		document.formItemHeader.expiry_yn.checked = false;
		document.formItemHeader.machine_code.disabled = false;
		//document.getElementById("td_ImageFilename").style.visibility = "hidden";
		//document.getElementById("td_filepath").style.visibility = "hidden";
		document.formItemHeader.prompt_alert_yn.disabled = true;
	}
}
function changeExpiry() {
	if (document.formItemHeader.drug_item_yn.checked == true) {
		//document.getElementById("td_ImageFilename").style.visibility = "hidden";
		//document.getElementById("td_filepath").style.visibility = "hidden";
		document.formItemHeader.expiry_yn.checked = true;
		document.formItemHeader.spare_part_id.disabled = true;
		document.formItemHeader.batch_id_applicable_yn.remove(2);
		document.formItemHeader.batch_id_applicable_yn.remove(1);
		document.formItemHeader.batch_id_applicable_yn.remove(0);
		var element1 = document.createElement("OPTION");
		element1.text = getLabel("Common.UserEnterable.label", "Common");
		element1.value = "Y";
		document.formItemHeader.batch_id_applicable_yn.add(element1, 0);
		var element2 = document.createElement("OPTION");
		element2.text = getLabel("eST.SameAsExpiryDate.label", "ST");
		element2.value = "E";
		document.formItemHeader.batch_id_applicable_yn.add(element2, 1);
		document.formItemHeader.batch_id_applicable_yn.options[0].selected = true;
		document.formItemHeader.expiry_yn.disabled = true;
		document.formItemHeader.use_after_expiry_yn.disabled = false;
		if (document.formItemHeader.drug_code_can_be_enabled.value == "true") {
			document.formItemHeader.drug_desc.disabled = false;
			document.formItemHeader.drug_search.disabled = false;
		}
		document.formItemHeader.prompt_alert_yn.disabled = true;
		document.formItemHeader.prompt_alert_yn.checked = false;
	} else {
		document.formItemHeader.expiry_yn.checked = false;
		document.formItemHeader.use_after_expiry_yn.disabled = true;
		document.formItemHeader.spare_part_id.disabled = false;
		document.formItemHeader.batch_id_applicable_yn.remove(2);
		document.formItemHeader.batch_id_applicable_yn.remove(1);
		document.formItemHeader.batch_id_applicable_yn.remove(0);
		var element1 = document.createElement("OPTION");
		element1.text = getLabel("Common.notapplicable.label", "Common");
		element1.value = "N";
		document.formItemHeader.batch_id_applicable_yn.add(element1, 0);
		var element2 = document.createElement("OPTION");
		element2.text = getLabel("Common.UserEnterable.label", "Common");
		element2.value = "Y";
		document.formItemHeader.batch_id_applicable_yn.add(element2, 1);
		document.formItemHeader.batch_id_applicable_yn.options[0].selected = true;
		document.formItemHeader.use_after_expiry_yn.disabled = true;
		document.formItemHeader.expiry_yn.disabled = false;
		if(document.formItemHeader.medical_item_yn.checked == true){
			//document.getElementById("td_ImageFilename").style.visibility = "visible";
			//document.getElementById("td_filepath").style.visibility = "visible";
		}
		document.formItemHeader.prompt_alert_yn.disabled = false;
	}
}
function changeUseAfterExpiry() {
	var varbatch_id=document.formItemHeader.batch_id_applicable_yn.value;
	if (document.formItemHeader.expiry_yn.checked == true) {
		if (document.getElementById("td_sole_source_yn").innerHTML.indexOf("disabled") == -1) {
             
			document.formItemHeader.mfg_item_yn.disabled = false;
		}
		document.formItemHeader.use_after_expiry_yn.disabled = false;
		
		document.formItemHeader.batch_id_applicable_yn.remove(2);
		document.formItemHeader.batch_id_applicable_yn.remove(1);
		document.formItemHeader.batch_id_applicable_yn.remove(0);
		var element1 = document.createElement("OPTION");
		element1.text = getLabel("Common.UserEnterable.label", "Common");
		element1.value = "Y";
		document.formItemHeader.batch_id_applicable_yn.add(element1, 0);
		var element2 = document.createElement("OPTION");
		element2.text = getLabel("eST.SameAsExpiryDate.label", "ST");
		element2.value = "E";
		document.formItemHeader.batch_id_applicable_yn.add(element2, 1);
		if(varbatch_id=="E"){
			document.formItemHeader.batch_id_applicable_yn.options[1].selected = true;
		} else{
			document.formItemHeader.batch_id_applicable_yn.options[0].selected = true;
		}
		
	} else {
		if (document.getElementById("td_sole_source_yn").innerHTML.indexOf("disabled") == -1) {
			document.formItemHeader.mfg_item_yn.checked = false;
			document.formItemHeader.mfg_item_yn.disabled = true;
		}
		document.formItemHeader.batch_id_applicable_yn.remove(2);
		document.formItemHeader.batch_id_applicable_yn.remove(1);
		document.formItemHeader.batch_id_applicable_yn.remove(0);
		var element1 = document.createElement("OPTION");
		element1.text = getLabel("Common.notapplicable.label", "Common");
		element1.value = "N";
		document.formItemHeader.batch_id_applicable_yn.add(element1, 0);
		var element2 = document.createElement("OPTION");
		element2.text = getLabel("Common.UserEnterable.label", "Common");
		element2.value = "Y";
		document.formItemHeader.batch_id_applicable_yn.add(element2, 1);
		if(varbatch_id=="Y"){
			document.formItemHeader.batch_id_applicable_yn.options[1].selected = true;
		} else{
			document.formItemHeader.batch_id_applicable_yn.options[0].selected = true;
		}
		document.formItemHeader.use_after_expiry_yn.disabled = true;
		document.formItemHeader.use_after_expiry_yn.checked = false;
	}
}
function changeSterile() {
	if (document.formItemHeader.autoclaveable_yn.checked == true) {
		document.formItemHeader.sterile_type.readOnly = false;
		document.formItemHeader.sterile_type.disabled = false;
		document.formItemHeader.sterile_search.disabled = false;

		if (document.formItemHeader.sterile_status.value == "disabled") {
			document.formItemHeader.sterile_type.disabled = true;
			document.formItemHeader.sterile_search.disabled = true;
		}
	} else {
		document.formItemHeader.sterile_type.value = "";
		document.formItemHeader.sterile_type.disabled = true;
		document.formItemHeader.sterile_search.disabled = true;
	}
}
async function searchSterile(objCode, objDesc) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	//argumentArray[0] = document.formItemHeader.SQL_ST_STERILE_SELECT.value;
	argumentArray[0] = "SELECT STERILE_TYPE CODE,SHORT_DESC DESCRIPTION FROM SS_STERILIZATION_TYPE_LANG_VW WHERE EFF_STATUS = 'E' AND STERILE_TYPE LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?) AND LANGUAGE_ID ='"+document.formItemHeader.language_id.value+"'";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = "";
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues =await CommonLookup(getLabel("eST.Sterile.label", "ST"), argumentArray);
	if (returnedValues != null && returnedValues != "" && returnedValues!=undefined) {
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
		objCode.readOnly = true;
	}
}
function checkValidInteger(obj) {
	if (obj.value == "") {
		return;
	}
	if (parseFloat(obj.value) == 0 || parseFloat(obj.value) >= 13) {
		alert(getMessage("PHY_COUNT_CANT_EXCEED_MAX", "ST"));
		obj.focus();
		return false;
	}
	return true;
}
function validateRecordsValues(formObject, msgFrame) {
	var errorPage = "../../eCommon/jsp/error.jsp";
	if (parseFloat(formObject.min_sale_qty.value) > parseFloat(formObject.max_stk_qty.value)) {
		msgFrame.location.href = errorPage + "?err_num=" + getMessage("MIN_SAL_CANT_EXCEED_MAX_LVL", "ST");
		formObject.min_sale_qty.focus();
		return false;
	}
	if (parseFloat(formObject.min_stk_qty.value) > parseFloat(formObject.max_stk_qty.value)) {
		msgFrame.location.href = errorPage + "?err_num=" + getMessage("MIN_LVL_CANT_EXCEED_MAX_LEVEL", "ST");
		formObject.min_stk_qty.focus();
		return false;
	}
	if (parseFloat(formObject.min_stk_qty.value) > parseFloat(formObject.reorder_level.value)) {
		msgFrame.location.href = errorPage + "?err_num=" + getMessage("REORDER_CANNOT_LESS_THAN_MIN", "ST");
		formObject.min_stk_qty.focus();
		return false;
	}
	if (parseFloat(formObject.reorder_level.value) > parseFloat(formObject.max_stk_qty.value)) {
		msgFrame.location.href = errorPage + "?err_num=" + getMessage("REORDER_CANNOT_EXCEED_MAX", "ST");
		formObject.reorder_level.focus();
		return false;
	}
	if (parseFloat(formObject.reorder_level.value) < parseFloat(formObject.min_stk_qty.value)) {
		msgFrame.location.href = errorPage + "?err_num=" + getMessage("REORDER_CANNOT_LESS_THAN_MIN", "ST");
		formObject.reorder_level.focus();
		return false;
	}
	if (parseFloat(formObject.reorder_qty.value) > parseFloat(formObject.max_stk_qty.value)) {
		msgFrame.location.href = errorPage + "?err_num=" + getMessage("REORDER_QTY_CANNOT_EXCEED_MAX", "ST");
		formObject.reorder_qty.focus();
		return false;
	}
	return true;
}
function test() {
	var result = false;
	flag = "ITEM_CODE_ALREADY_EXIST";
	var message = "";
	assignResult(result + "," + message + "," + flag);
}
function DrugCheck() {
	detailForm = document.formItemHeader;
	var errorPage = "../../eCommon/jsp/error.jsp";
	if (detailForm.item_code.value != "") {
		assignBean(detailForm);
		var xmlDom = "";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr = "<root><SEARCH " + detailForm.item_code.name + "=\"" + detailForm.item_code.value + "\"/></root>";
		var xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
		//xmlDom.loadXML(xmlStr);
		xmlHttp.open("POST", "../../eST/jsp/ItemDrugValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=dummy", false);
		xmlHttp.send(xmlDom);
		responseText = xmlHttp.responseText;
		responseText = trimString(responseText);
		eval(responseText);
		} else {
	}
}
function CheckForValidDrug() {
	detailForm = document.formItemHeader;
	if (document.formItemHeader.drug_desc != "") {
		assignBean(document.formItemHeader);
		var xmlDom = "";
		var xmlStr = "<root><SEARCH " + detailForm.drug_code.name + "=\"" + detailForm.drug_code.value + "\"/></root>";
		//xmlDom.loadXML(xmlStr);
		var xmlDom = new DOMParser().parseFromString("<root></root>", "text/xml");
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("POST", "../../eST/jsp/ItemDrugValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=CHECK_DRUG", false);
		xmlHttp.send(xmlDom);
		responseText = xmlHttp.responseText;
		responseText = trimString(responseText);
		eval(responseText);
	}
}
function callDrugSearch() {
	var arrCodeDesc = DrugSearch("D", document.formItemHeader.drug_desc);
	if (arrCodeDesc != null && arrCodeDesc != "") {
		document.formItemHeader.drug_code.value = arrCodeDesc[0];
		document.formItemHeader.drug_desc.value = arrCodeDesc[1];
	}
}
function ConfirmBox() {
	if (confirm("Drug Description is different from Item Description.. Do you want to overwrite the existing Drug Description..(Ok/Cancel)?")) {
		document.formItemHeader.drug_desc.disabled = false;
		document.formItemHeader.drug_search.disabled = false;
	} else {
		document.formItemHeader.item_code.focus();
	}
}
function setSpecialItemValue() {
	if (document.formItemHeader.special_req_item.checked == true) {
		document.formItemHeader.special_req_item.value = "Y";
	} else {
		document.formItemHeader.special_req_item.value = "N";
	}
}
function KeyPressSpecCharsItemCode(event) {
	var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-.*_";
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
function CheckForSpecialChars(obj) {
	var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-.*_";
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
/*function showImage(image_filename){
	var imageURL= document.formItemHeader.img_path.value+image_filename;
	var dialogHeight= "30" ;
	var dialogWidth	= "50" ;
	var dialogTop = "111" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal = window.showModalDialog("../../ePH/jsp/DrugTradeImage.jsp?imageURL="+imageURL,arguments,features);
}*/

async function showImage(image_filename){
	var bean_id = document.formItemHeader.bean_id.value;
	var bean_name = document.formItemHeader.bean_name.value;
	var item_code = document.formItemHeader.item_code.value;
	var img_path = document.formItemHeader.img_path.value;

	var imageURL= document.formItemHeader.img_path.value+image_filename;
		
	var dialogHeight= "30vh" ;
	var dialogWidth	= "50vw" ;
	var dialogTop = "111" ;
	var center = "1" ;
	var status="no";
	var scroll="auto";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal = await window.showModalDialog("../../eST/jsp/ItemImageCataloguePreviewFrame.jsp?imageURL="+imageURL+"&bean_id="+bean_id+"&bean_name="+bean_name+"&item_code="+item_code+"&img_path="+img_path,arguments,features);
	
	
}

function dispImageFile(formObj,obj){
	if(obj.value !="")
		formObj.all.td_ImageFilename.innerHTML = "<a href=\"javascript:showImage('"+obj.value+"');\">"+getLabel("Common.ImageFilename.label","Common")+"</a>";
	else
		formObj.all.td_ImageFilename.innerHTML = getLabel("Common.ImageFilename.label","Common");
}
function showSplchars(short_desc,long_desc)
{

document.getElementById("td_short_desc").innerHTML=unescape(escape(short_desc));
document.getElementById("long_desc").value=escape(long_desc);
}
function validteChange(){

var errorPage = "../../eCommon/jsp/error.jsp";
if(document.formItemHeader.consiment_tr.value=='N'){
parent.messageFrame.location.href = errorPage + "?err_num=" +getMessage("CANNOT_CHANGE_CONSIGN_FLAG","ST");
return false;
}
return true;
}
