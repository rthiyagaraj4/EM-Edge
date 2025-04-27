/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function create() {
	f_query_add_mod.location.href = "../../eSS/jsp/CheckListFrame.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
}
function query() {
	f_query_add_mod.location.href = "../../eSS/jsp/CheckListQueryCriteria.jsp?function_id=" + function_id;
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
	var arrayObject = new Array(formObj.checklist_code, formObj.checklist_desc);
	var names = new Array("CheckList Code", "CheckList Description");
	if (checkSTFields(arrayObject, names, messageFrame)) {
		var formObj1 = f_query_add_mod.frameKitTemplateListDetail.document.KitTemplateListDetailform;
		var canProcess = formObj1.records.value;
		var mad_records = formObj1.mad_records.value;
         if (parseInt(canProcess) == 0) {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + getMessage("MIN_ONE_ITEM_REQD", "ST");
			return;
		} else {
		 if(parseInt(mad_records)==0)
			{
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + "APP-ST0177 Atleast One Mandatory Item Record must be there";
			return;
			}
			var responseText = formApply(formObj, SS_CONTROLLER);
			responseText = responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, "");
			//alert(responseText);
			eval(responseText);
			messageFrame.location.href = errorPage + "?err_num=" + message;
			if (result) {
				onSuccess();
			}
		}
	}
}
async function callItemSearchScreen(objCode,objDesc) {
	
	var search_string = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

   	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.KitTemplateAddModifyform.locale.value;
	dataTypeArray  [0]=STRING;
	argumentArray[0] = document.KitTemplateAddModifyform.SQL_SS_ITEM_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	if(objDesc.readOnly)
		argumentArray[5] = "";
	else
		argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup(getLabel("Common.item.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		if(returnedValues.length === 1){
			returnedValues = returnedValues[0].split(',');
		}
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
		objDesc.readOnly=true;
	} 
	/*if (!document.KitTemplateAddModifyform.item_desc.readOnly) {
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
		 
	var item_class = "";
	retValue = callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment);
	if (retVal != null) {
		document.KitTemplateAddModifyform.item_code.value = retVal[0];
		document.KitTemplateAddModifyform.item_desc.value = retVal[1];
		document.KitTemplateAddModifyform.item_desc.disabled = true;
		document.KitTemplateAddModifyform.item_search.disabled = true;
		var formObj = document.KitTemplateAddModifyform;
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eST/jsp/KitTemplateValidate.jsp?item_code=" + retVal[0] + "&validate=GET_STATUS", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
	}*/
}
function addToList() {
	var formObj = parent.frameKitTemplateAddModify.document.KitTemplateAddModifyform;
	//var uom_desc = formObj.uom_code.options[formObj.uom_code.selectedIndex].text;
	var obj = formObj.mandatory_status;
	if (obj.checked == true) {
		obj.value = "Y";
	} else {
		obj.value = "N";
	}
	var mode = formObj.mode;
	var arrayObject = new Array(formObj.item_code, formObj.qty, formObj.seq_no);
	var names = new Array(getLabel("Common.item.label", "Common"), getLabel("Common.Quantity.label", "Common"),  getLabel("Common.SequenceNo.label", "Common"));
	var formObjDtl = parent.frameKitTemplateListDetail.document.KitTemplateListDetailform;
	var blankObject = checkSTFields(arrayObject, names, parent.parent.messageFrame);
	if (blankObject) {
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		//xmlDoc.loadXML(getXMLString(null));//getEnhancedXMLString(formObjDtl));
		
		xmlHttp.open("POST", "../../eSS/jsp/CheckListValidate.jsp?validate=ADD_TO_LIST&item_code=" + formObj.item_code.value + "&item_desc=" + encodeURIComponent(formObj.item_desc.value) + "&qty=" + formObj.qty.value + "&seq_no=" + formObj.seq_no.value + "&mandatory_status=" + formObj.mandatory_status.value + "&eff_status=" + formObj.eff_status.value + "&index=" + formObj.index.value + "&db_action=" + formObj.db_action.value, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		responseText = responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, "");

		//alert(responseText);
		eval(responseText);
		if (result) {
		    
					
				parent.frameKitTemplateAddModify.location.href = "../../eSS/jsp/CheckListAddModify.jsp?mode=" + MODE_INSERT;
		
			parent.frameKitTemplateListDetail.location.href = "../../eSS/jsp/CheckListListDetail.jsp?mode=" + MODE_INSERT;
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
		 
		
		}
		if (!result) {
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "ST");
		}
	}
}
function cancel_me() {
	parent.frameKitTemplateAddModify.location.href = "../../eSS/jsp/CheckListAddModify.jsp?mode=" + MODE_INSERT;
}
function ModifyData(index, obj, man_status, status, db_action) {

	var item_code = obj.cells[0].innerText;
	var item_desc = obj.cells[1].innerText;
	var qty = obj.cells[2].innerText;
	var mandatory_status = man_status;
	var seq_no = obj.cells[3].innerText;
	var eff_status = status;

	parent.frameKitTemplateAddModify.location.href = "../../eSS/jsp/CheckListAddModify.jsp?mode=" + MODE_MODIFY + "&function_id=" + parent.parent.function_id + "&item_code=" + item_code + "&item_desc=" + encodeURIComponent(item_desc) + "&qty=" + qty + "&mandatory_status=" + mandatory_status + "&seq_no=" + seq_no + "&eff_status=" + status + "&index=" + index + "&db_action=" + db_action;
}
function Modify(obj) {

	var kit_template_code = obj.cells[0].innerText;
	var kit_template_desc = obj.cells[1].innerText;
	var eff_status = obj.cells[2].innerText;

	document.location.href = "../../eSS/jsp/CheckListFrame.jsp?mode=" + MODE_MODIFY + "&function_id=" + parent.function_id + "&checklist_code=" + kit_template_code + "&checklist_desc=" + encodeURIComponent(kit_template_desc) + "&eff_status=" + eff_status;
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
function assignValue2(obj) {
	if (obj.checked == true) {
		obj.value = "Y";
	} else {
		obj.value = "N";
	}
	//document.KitTemplateMainform.mandatory_status.value = obj.value;
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
function CheckForSpecCharAlphaCode(Obj){
		
        var str = Obj.value;
        var specCharsExist = true;
        for (u=0;u<str.length;u++){
            if (((str.charCodeAt(u)>=48) && (str.charCodeAt(u)<=57))||((str.charCodeAt(u)>=65) && (str.charCodeAt(u)<=90))||((str.charCodeAt(u)>=97) && (str.charCodeAt(u)<=122))||(str.charCodeAt(u)==95)||(str.charCodeAt(u)==45)||(str.charCodeAt(u)==46));
            else{
                specCharsExist = false;
                break;
            }
        }

        if(!specCharsExist){
			
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" +  getMessage("CANNOT_BE_SPECIAL_CHAR", "Common");
			Obj.focus();
		}
    }


