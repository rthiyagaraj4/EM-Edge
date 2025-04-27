 
/*ML-MMOH-SCF-1065 STARTS*/
var UOM_Desc='';
var Equivalen_uom_desc='';

function onSuccess() {
	f_query_add_mod.document.location.reload();
}
function reset() {
	f_query_add_mod.document.formProductTransferRequestAddModify.repack_item.disabled = false;
	var from_element = f_query_add_mod.document.getElementById("from_item_uom_desc");
	from_element.innerHTML = "&nbsp;";
	var to_element = f_query_add_mod.document.getElementById("to_item_uom_desc");
	to_element.innerHTML = "&nbsp;";
	//f_query_add_mod.document.formProductTransferRequestAddModify.to_item_uom_desc.innerHTML = "&nbsp;";
	//f_query_add_mod.document.formProductTransferRequestAddModify.from_item_uom_desc.innerHTML = "&nbsp;";
	f_query_add_mod.document.formProductTransferRequestAddModify.reset();
}
function apply() {
	//var formObj = f_query_add_mod.document.formProductTransferRequestAddModify;
	var formObj = f_query_add_mod.document.formProductTransferRequestAddModify;
	formObj.p_request_no.value = formObj.request_no.value;

	//var fields	= new Array ( formObj.store,formObj.repack_item, formObj.required_qty,formObj.item_used,formObj.repack_factor,formObj.quantity);
	//var names	= new Array ( "Request Store","Required Repack Item","Required Quantity","Item to be Used","Repack Factor","Quantity");
	var fields = new Array();
	fields[0] = formObj.store;
	fields[1] = formObj.repack_item;
	fields[2] = formObj.required_qty;
	fields[3] = formObj.item_used;
	fields[4] = formObj.repack_factor;
	fields[5] = formObj.quantity;
	//var names = new Array(getLabel("eST.RequestStore.label", "ST"), getLabel("eST.RequiredItem.label", "ST"), getLabel("eST.RequiredQuantity.label", "ST"), getLabel("eST.Itemtobeused.label", "ST"), getLabel("eST.RepackSize.label", "ST"), getLabel("Common.Quantity.label", "Common"));
	//Added By Rabbani #Inc no:44721 on 06-JAN-2014
	var names = new Array(getLabel("eST.RepackStore.label", "ST"), getLabel("eST.RequiredItem.label", "ST"), getLabel("eST.RequiredQuantity.label", "ST"), getLabel("eST.Itemtobeused.label", "ST"), getLabel("eST.RepackSize.label", "ST"), getLabel("Common.Quantity.label", "Common"));
	var errorPage = "../../eCommon/jsp/error.jsp";
	//var blankObject = null;
	var blankObject = checkSTFields(fields, names, messageFrame);
	if (blankObject == true) {
		if (!checkRemarksLength()) {
			message = "REMARKS_CHAR_EXCEEDS_LIMIT";
			messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
			return false;
		}
		var xmlHttp = new XMLHttpRequest();
		//var xmlDoc="";
		//xmlDoc.loadXML(getEnhancedXMLString(formObj));
		var xmlString = getEnhancedXMLString(formObj);  
		var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/ProductTransferRequestValidate.jsp?store_code=" + formObj.store.value + "&from_item_code=" + formObj.from_item_code.value + "&to_item_code=" + formObj.to_item_code.value + "&fm_stk_uom_conv_factor=" + formObj.repack_factor.value + "&to_stk_uom_conv_factor=1" + "&required_qty=" + formObj.required_qty.value + "&quantity=" + formObj.quantity.value + "&requested_by=" + formObj.requested_by.value + "&remarks=" + formObj.remarks_code_1.value + "&label=setvalue", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if (!result) {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "ST");
		} else {
			var resultText = formApply(formObj, ST_CONTROLLER);
			eval(resultText);
			var num_prreq = getLabel("eST.ProductTransferReqNo.label", "ST");
			message = message + num_prreq + " : " + formObj.request_no.value;
			messageFrame.location.href = errorPage + "?err_num=" + message;
		}
		if (result) {
			//Online Printing  Starts...
			var xmlHttp = new XMLHttpRequest();
			//var xmlDoc="";
			//xmlDoc.loadXML(getEnhancedXMLString(formObj));
			var xmlString = getEnhancedXMLString(formObj);  
			var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
			//xmlHttp.open("POST", "../../eST/jsp/ProductTransferRequestValidate.jsp?store_code=" + formObj.store.value + "&req_no=" + formObj.request_no.value + "&label=print", false);
			xmlHttp.open("POST", "../../eST/jsp/ProductTransferRequestValidate.jsp?store_code=" + formObj.store.value + "&req_no=" + formObj.request_no.value + "&label=print", true);
			xmlHttp.send(xmlDoc);
			//responseText = xmlHttp.responseText;
			//eval(responseText);
			if (!result) {
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "ST");
			}
			//Online Printing Ends
			onSuccess();
		}
	}
}
function checkRemarksLength() {
	var formObj = f_query_add_mod.document.formProductTransferRequestAddModify;
	if (!SPCheckMaxLen(getLabel("Common.remarks.label", "Common"), formObj.remarks, 200)) {
		return false;
	}
	return true;
}
var item_codee="";//ML-MMOH-SCF-1065
async function callItemSearchScreenfrom(item_code) {
	item_codee=item_code;////ML-MMOH-SCF-1065
	if (document.formProductTransferRequestAddModify.to_item_code.value == "") {
		alert("Requested Item Cannot Be Blank");
		document.formProductTransferRequestAddModify.item_used.value = "";
		document.formProductTransferRequestAddModify.repack_item.focus();
		return;
	}
	//document.formProductTransferRequestAddModify.document.getElementById("from_item_uom_desc").innerHTML = "&nbsp;";
	var from_element = document.getElementById("from_item_uom_desc");
	from_element.innerHTML = "&nbsp;";
	document.formProductTransferRequestAddModify.from_item_code.value = "";
	document.formProductTransferRequestAddModify.from_repack_uom_code.value = "";
	document.formProductTransferRequestAddModify.from_trade_id_yn.value = "";
	document.formProductTransferRequestAddModify.repack_item.disabled = true;
	parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	var store_code = document.formProductTransferRequestAddModify.store.value;
	var search_string = item_code;
	var category = "A";
	var sole_source = "A";
	var mfg_item = "A";
	var expiry = "A";
	var consignment = "A";
	var ps_item = "A";
	var item_class = ""; 
	//Added by suresh.r on 17-06-2014 against ML-BRU-SCF-1375 passing trn_type,search_no beg
	//from_retValue = callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment);
	from_retValue = await callItemSearchWindow_PRD(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment,"PRQ","1");
	//Added by suresh.r on 17-06-2014 against ML-BRU-SCF-1375 end
	if (from_retValue != null) {
		Equivalen_uom_desc=from_retValue[15];//ML-MMOH-SCF-1065
		document.formProductTransferRequestAddModify.from_item_code.value = from_retValue[0];
		document.formProductTransferRequestAddModify.item_used.value = from_retValue[1];
		document.formProductTransferRequestAddModify.from_repack_uom_code.value = from_retValue[13];
		document.formProductTransferRequestAddModify.from_trade_id_yn.value = from_retValue[17];
		//document.formProductTransferRequestAddModify.from_item_uom_desc.innerHTML = "&nbsp;" + getLabel("Common.uom.label", "Common") + "&nbsp;" + "<b>" + from_retValue[15] + "</b>&nbsp;";
		var from_elem = document.getElementById("from_item_uom_desc");
		from_elem.innerHTML = "&nbsp;" + getLabel("Common.uom.label", "Common") + "&nbsp;" + "<b>" + from_retValue[15] + "</b>&nbsp;";
		var formObj = parent.f_query_add_mod.document.formProductTransferRequestAddModify;
		var xmlHttp = new XMLHttpRequest();
		//var xmlDoc="";
		//xmlDoc.loadXML(getEnhancedXMLString(formObj));
		var xmlString = getEnhancedXMLString(formObj);  
		var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/ProductTransferRequestValidate.jsp?item_code=" + from_retValue[0] + "&store_code=" + store_code + "&label=from" + "&stk_uom=" + formObj.from_repack_uom_code.value + "&stk_uom_to=" + formObj.to_repack_uom_code.value + "&repack_group2=" + formObj.repack_group2.value + "&to_item_code=" + formObj.to_item_code.value + "&from_trade_id_yn=" + formObj.from_trade_id_yn.value + "&to_trade_id_yn=" + formObj.to_trade_id_yn.value, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		/*if (!result) {
			parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ getMessage("REPACKING_GROUPS_DIFFERENT");
		}*/
	}
}
async function callItemSearchScreento(item_code) {
	//document.formProductTransferRequestAddModify.document.getElementById("to_item_uom_desc").innerHTML = "&nbsp;";
	var to_element = document.getElementById("to_item_uom_desc");
	to_element.innerHTML = "&nbsp;";
	document.formProductTransferRequestAddModify.to_item_code.value = "";
	document.formProductTransferRequestAddModify.to_repack_uom_code.value = "";
	document.formProductTransferRequestAddModify.to_trade_id_yn.value = "";
	var store_code = document.formProductTransferRequestAddModify.store.value;
	var search_string = item_code;
	var category = "A";
	var sole_source = "A";
	var mfg_item = "A";
	var expiry = "A";
	var consignment = "A";
	var ps_item = "A";
	var item_class = "";
	//Added by suresh.r on 17-06-2014 against ML-BRU-SCF-1375 passing trn_type,search_no beg
	//to_retValue = callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment);
	to_retValue = await callItemSearchWindow_PRD(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment,"PRQ","2");
	//Added by suresh.r on 17-06-2014 against ML-BRU-SCF-1375 end
	if (to_retValue != null) {
		UOM_Desc=to_retValue[15];//ML-MMOH-SCF-1065
		document.formProductTransferRequestAddModify.to_item_code.value = to_retValue[0];
		document.formProductTransferRequestAddModify.repack_item.value = to_retValue[1];
		document.formProductTransferRequestAddModify.to_repack_uom_code.value = to_retValue[13];
		document.formProductTransferRequestAddModify.to_trade_id_yn.value = to_retValue[17];
		//document.formProductTransferRequestAddModify.document.getElementById("to_item_uom_desc").innerHTML = getLabel("Common.uom.label", "Common") + "&nbsp;" + "<b>" + to_retValue[15] + "</b>&nbsp;";
		var to_element = document.getElementById("to_item_uom_desc");
		to_element.innerHTML = getLabel("Common.uom.label", "Common") + "&nbsp;" + "<b>" + to_retValue[15] + "</b>&nbsp;";
		
		var formObj = parent.f_query_add_mod.document.formProductTransferRequestAddModify;
		var xmlHttp = new XMLHttpRequest();
		//var xmlDoc="";
		//xmlDoc.loadXML(getEnhancedXMLString(formObj));
		var xmlString = getEnhancedXMLString(formObj);  
		var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/ProductTransferRequestValidate.jsp?item_code=" + to_retValue[0] + "&store_code=" + store_code + "&label=to" + "&stk_uom=" + formObj.to_repack_uom_code.value, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if (!result) {
			parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "ST");
		}
	//document.formProductTransferRequestAddModify.required_qty.focus();		
	}
}
function repacking_groups_different() {
	alert(getMessage("REPACKING_GROUPS_DIFFERENT", "ST"));
	parent.f_query_add_mod.document.formProductTransferRequestAddModify.from_item_code.value = "";
	parent.f_query_add_mod.document.formProductTransferRequestAddModify.item_used.value = "";
	parent.f_query_add_mod.document.getElementById("from_item_uom_desc").innerHTML = "";
	parent.f_query_add_mod.document.formProductTransferRequestAddModify.item_used.focus();
	parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("REPACKING_GROUPS_DIFFERENT", "ST");
}
function conv_factor_not_defined() {
	alert(getMessage("CONV_FACTOR_NOT_DEFINED", "ST"));
	parent.f_query_add_mod.document.formProductTransferRequestAddModify.from_item_code.value = "";
	parent.f_query_add_mod.document.formProductTransferRequestAddModify.item_used.value = "";
	parent.f_query_add_mod.document.getElementById("from_item_uom_desc").innerHTML = "";
	parent.f_query_add_mod.document.formProductTransferRequestAddModify.item_used.focus();
	parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("CONV_FACTOR_NOT_DEFINED", "ST");
}
function Trade_ID_not_applicable() {
	alert(getMessage("ONLY_TRADE_SPEC_ITEM_ALWD", "ST"));
	parent.f_query_add_mod.document.formProductTransferRequestAddModify.from_item_code.value = "";
	parent.f_query_add_mod.document.formProductTransferRequestAddModify.item_used.value = "";
	parent.f_query_add_mod.document.formProductTransferRequestAddModify.from_trade_id_yn.value = "";
	parent.f_query_add_mod.document.getElementById("from_item_uom_desc").innerHTML = "";
	parent.f_query_add_mod.document.formProductTransferRequestAddModify.item_used.focus();
	parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("ONLY_TRADE_SPEC_ITEM_ALWD", "ST");
}
function Item_difference() {
	alert(getMessage("TO_AND_FM_ITEM_NOT_SAME", "ST"));
	parent.f_query_add_mod.document.formProductTransferRequestAddModify.from_item_code.value = "";
	parent.f_query_add_mod.document.formProductTransferRequestAddModify.item_used.value = "";
	parent.f_query_add_mod.document.getElementById("from_item_uom_desc").innerHTML = "";
	parent.f_query_add_mod.document.formProductTransferRequestAddModify.item_used.focus();
	parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("TO_AND_FM_ITEM_NOT_SAME", "ST");
}
/*ML-MMOH-SCF-1065*/
var confactor="";
var frmuom="";
var toouom="";
function getconvfact(fromuom,touom)
{
	frmuom=fromuom;
	toouom=touom;
}
/*ML-MMOH-SCF-1065*/
function calculateQTY() {
	var formobj = document.formProductTransferRequestAddModify;
	//parent.f_query_add_mod.document.formProductTransferRequestAddModify.from_item_code.value;
	var formObj = parent.f_query_add_mod.document.formProductTransferRequestAddModify;
	var xmlHttp = new XMLHttpRequest();
	//var xmlDoc="";
	//xmlDoc.loadXML(getEnhancedXMLString(formObj));
	var xmlString = getEnhancedXMLString(formObj);  
	var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/ProductTransferRequestValidate.jsp?item_code=" + item_codee + "&store_code=" + formobj.store.value+"&UOM_Desc=" +UOM_Desc+"&Equivalen_uom_desc=" +Equivalen_uom_desc+"&lang_id="+formobj.lang_id.value+"&label=convfactor",false);
	xmlHttp.send(xmlDoc); 
	responseText = xmlHttp.responseText;
	eval(responseText);
	if (!result) {
		parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "ST");
	}
	
	
		if(formobj.required_qty.value==""&& formobj.repack_factor.value=="")
		return;
	if (formobj.required_qty.value == 0 && formobj.required_qty.value != "") {
		alert(getMessage("CANNOT_BE_ZERO", "Common"));
		formobj.required_qty.value = "";
		formobj.required_qty.focus();
	} else {
		if (formobj.required_qty.value != "" && formobj.repack_factor.value != "" && formobj.eqvlvalue.value != "") {
			
			if(formobj.allow_deci_yn_from.value=='N') 
			{
            formobj.qty.value = formobj.required_qty.value;
		//	formobj.quantity.value = ((formobj.required_qty.value * formobj.repack_factor.value) / formobj.eqvlvalue.value);
    //ML-MMOH-SCF-1065
            if(frmuom>toouom)
            {
            	formobj.quantity.value = ((formobj.required_qty.value * formobj.repack_factor.value) * frmuom);
            }	
            else
            {
            	
            	if(formobj.required_qty.value%toouom!=0 )
            	{
            		alert("It should be multiple of -"+toouom);
            		formobj.required_qty.focus();
            		formobj.required_qty.value="";
					formobj.qty.value="";
            		
            		return false;
            	}	
            	formobj.quantity.value = ((formobj.required_qty.value * formobj.repack_factor.value) / toouom);
            }	
 			formobj.quantity.value = Math.ceil(formobj.quantity.value);
			}

			if(formobj.allow_deci_yn_from.value=='Y') 
			{
            var qty = (Math.ceil(formobj.req_qty.value) == formobj.required_qty.value ? formobj.req_qty.value : formobj.required_qty.value);
			formobj.quantity.value = ((((qty * formobj.repack_factor.value) / formobj.eqvlvalue.value)).toFixed(parseInt(formobj.no_deci_from.value)));
			}
			
			formobj.remarks.focus();
		}
	}
}
function calRequireQTY() {
	var formobj = document.formProductTransferRequestAddModify;
	//ML-MMOH-SCF-1065
	var formObj = parent.f_query_add_mod.document.formProductTransferRequestAddModify;
	var xmlHttp = new XMLHttpRequest();
	//var xmlDoc="";
	//xmlDoc.loadXML(getEnhancedXMLString(formObj));
	var xmlString = getEnhancedXMLString(formObj);  
	var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/ProductTransferRequestValidate.jsp?item_code=" + item_codee + "&store_code=" + formobj.store.value+"&UOM_Desc=" +UOM_Desc+"&Equivalen_uom_desc=" +Equivalen_uom_desc+"&lang_id="+formobj.lang_id.value+"&label=convfactor",false);
	xmlHttp.send(xmlDoc);
	
	responseText = xmlHttp.responseText;
	eval(responseText);
	if (!result) {
		parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "ST");
	}
	
	
	if(formobj.required_qty.value==""&& formobj.repack_factor.value=="")
		return;
	if (formobj.quantity.value == 0 && formobj.quantity.value != "") {
		alert(getMessage("CANNOT_BE_ZERO", "Common"));
		formobj.quantity.value = "";
		formobj.quantity.focus();
	} else {
		if (formobj.quantity.value != "" && formobj.eqvlvalue.value != "" && formobj.eqvlvalue.value != "") {
		     if(formobj.allow_deci_yn_to.value=='N')
			{
			formobj.req_qty.value = formobj.quantity.value;
			/*ML-MMOH-1065 starts*/

			if(frmuom>toouom)
	            {
	            	if(formobj.quantity.value%frmuom!=0)
	            	{
	            		alert("It should be multiple of-"+frmuom);
						formobj.quantity.value="";
						formobj.required_qty.value="";
	            		return;
	            	}	
	            	
	            	formobj.required_qty.value = ((formobj.quantity.value * formobj.repack_factor.value ) / frmuom);
	            }	
	            else
	            {

	            		         if(formobj.required_qty.value%toouom!=0)
	         	            	{
	         	            		alert("It should be multiple of :"+toouom);
									formobj.quantity.value="";
									formobj.req_qty.value="";
	         	            		return false;
	         	            	}	
	            	
	            	formobj.required_qty.value = ((formobj.quantity.value * formobj.repack_factor.value ) * frmuom);
	            }	
			/*GHL-CRF-0557 ends*/
			 
			 
			formobj.required_qty.value = Math.ceil(formobj.required_qty.value);
			
			}

			 if(formobj.allow_deci_yn_to.value=='Y')
			{
       	   var qty = (Math.ceil(formobj.qty.value) == formobj.quantity.value ? formobj.qty.value : formobj.quantity.value);
		   formobj.required_qty.value = ((((qty * formobj.eqvlvalue.value) / formobj.repack_factor.value)).toFixed(parseInt(formobj.no_deci_to.value)));
			}
				formobj.remarks.focus();
		}
	}
}
function checkLength() {
	var formObj = document.formProductTransferRequestAddModify;
	if (!SPCheckMaxLen(getLabel("Common.remarks.label", "Common"), formObj.remarks, 200)) {
		return false;
	}
	return true;
}
/*
	
//f_query_add_mod.document.location.href="../../eST/jsp/ItemHeaderAddModify.jsp?mode="+MODE_MODIFY+"&item_code="+retValue[0]+"&item_name="+escape(retValue[1])+"&m_ps_item_yn="+retValue[10]+"&m_sole_source_yn="+retValue[11]+"&m_gen_uom="+retValue[13]+"&m_gen_uom_code="+retValue[15]+"&m_manufacturer_id="+retValue[16]+"&m_long_desc="+retValue[9];
	
*/
function geteqvalvalue() {
	var formobj = document.formProductTransferRequestAddModify;
	formobj.repack_factor.value = formobj.eqvlvalue.value;
}
function phy_inv_progress() {
	var formobj = parent.f_query_add_mod.document.formProductTransferRequestAddModify;
	alert(getMessage("PHY_INV_PROCESS_INITIATED", "ST") + "\n" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + formobj.phy_inv_id.value);
	formobj.repack_item.value = "";
	formobj.to_item_code.value = "";
	var from_element = parent.f_query_add_mod.document.getElementById("to_item_uom_desc");
	from_element.innerHTML = "";
	//formobj.document.getElementById("to_item_uom_desc").innerHTML = "";
	formobj.repack_item.focus();
}
function phy_inv_progress1() {
	var formobj = parent.f_query_add_mod.document.formProductTransferRequestAddModify;
	alert(getMessage("PHY_INV_PROCESS_INITIATED", "ST") + "\n" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + formobj.phy_inv_id.value);
	formobj.item_used.value = "";
	formobj.from_item_code.value = "";
	var from_element = parent.f_query_add_mod.document.getElementById("from_item_uom_desc");
	from_element.innerHTML = "";
	//formobj.document.getElementById("from_item_uom_desc").innerHTML = "";
	formobj.item_used.focus();
}
async function searchRemarks(objCode, objDesc) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.formProductTransferRequestAddModify.lang_id.value;
	dataTypeArray[0] = STRING;
	dataNameArray[1] = "module_id";
	dataValueArray[1] = "ST";
	dataTypeArray[1] = STRING;
	dataNameArray[2] = "trn_type";
	dataValueArray[2] = document.formProductTransferRequestAddModify.rem_trans_type.value;
	dataTypeArray[2] = STRING;
	argumentArray[0] = document.formProductTransferRequestAddModify.SQL_ST_TRN_REMARKS_LOOKUP_SELECT.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "4,5";
	argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	retVal = await CommonLookup(getLabel("Common.remarks.label", "Common"), argumentArray);
	var ret1=unescape(retVal);
							var arr=ret1.split(",");
							if(arr[1]==undefined) 
							{
								arr[0]="";	
								arr[1]="";	
							}	
	if ((retVal != null) && (retVal != "")) {
		objCode.value = arr[0];
		objDesc.value = arr[1];
	}
}

function setDecimalParameters(allow_yn,no_decimals,label) {
if(allow_yn=='N')
          no_decimals ='0';

	if(label=='from')
	{
		document.formProductTransferRequestAddModify.allow_deci_yn_from.value = allow_yn;
        document.formProductTransferRequestAddModify.no_deci_from.value = no_decimals;
	}
     
	  if(label=='to')
	{
		document.formProductTransferRequestAddModify.allow_deci_yn_to.value = allow_yn;
		document.formProductTransferRequestAddModify.no_deci_to.value = no_decimals;
	}
}
function allow_restrict_decimals1(obj,event)
{
	
var allow_yn =	document.formProductTransferRequestAddModify.allow_deci_yn_from.value ;
var  no_decimals = document.formProductTransferRequestAddModify.no_deci_from.value ;
if(allow_yn=='N')
obj.onkeypress=function(){return isValidInteger()};

if(allow_yn=='Y')
	   obj.onkeypress=function(){return isValidNumber(obj,event,7,parseInt(no_decimals))};
}
function allow_restrict_decimals(obj,event)
{
	
var allow_yn =	document.formProductTransferRequestAddModify.allow_deci_yn_to.value ;
var  no_decimals = document.formProductTransferRequestAddModify.no_deci_to.value ;
if(allow_yn=='N')
obj.onkeypress=function(){return isValidInteger()};

if(allow_yn=='Y')
	   obj.onkeypress=function(){return isValidNumber(obj,event,7,parseInt(no_decimals))};
}
