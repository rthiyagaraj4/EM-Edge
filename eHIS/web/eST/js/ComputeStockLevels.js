
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
var formObj = "";
function reset1() {
	f_query_add_mod.frameComputeStockLevelsCriteria.document.formComputeStockLevelsCriteria.reset();
	f_query_add_mod.frameComputeStockLevelsResult.location.href = "../../eCommon/html/blank.html";
}
/*function searchCodeItem( obj) {
	var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	dataNameArray[0]   = "language_id";
	dataValueArray[0]   = document.forms[0].language_id.value;
	dataTypeArray[0]    = STRING;
	argumentArray[0] = document.getElementById("SQL_ST_ITEM_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = CommonLookup(getLabel("Common.item.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = returnedValues[0];
	} 
}

*/
/*function searchCodeItemClass( obj) {
	var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	dataNameArray[0]   = "language_id";
	dataValueArray[0]   = document.forms[0].language_id.value;
	dataTypeArray[0]    = STRING;
	argumentArray[0] = document.getElementById("SQL_ST_ITEM_CLASS_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = CommonLookup(getLabel("Common.ItemClass.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = returnedValues[0];
	} 
}
*/
function searchItems() {
	var arrayObject = new Array(document.formComputeStockLevelsCriteria.consumption_period);
	var names = new Array(getLabel("eST.ConsumptionPeriod.label", "ST"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.messageFrame);
	if (blankObject != true) {
		//blankObject.focus();
		return;
	} else {
		parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp";
	}
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(document.formComputeStockLevelsCriteria));	
	xmlDoc = new DOMParser().parseFromString(getXMLString(document.formComputeStockLevelsCriteria), "text/xml");
//	alert("form="+document.formComputeStockLevelsCriteria.name);
	xmlHttp.open("POST", "ComputeStockLevelsValidate.jsp?validate=FETCH_ITEM", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
//	alert(responseText);
	document.formComputeStockLevelsCriteria.submit();	//parent.frameComputeStockLevelsResult.location.href="../../eST/jsp/ComputeStockLevelsResult.jsp?function_id="+document.formComputeStockLevelsCriteria.function_id.value;	
	/*
	alert("chje");
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	alert("vds="+document.formComputeStockLevelsCriteria.name);
	xmlDoc.loadXML(getXMLString(document.formComputeStockLevelsCriteria));
	alert(" xmlDoc="+xmlDoc);
	xmlHttp.open("POST", "../../eST/jsp/ComputeStockLevelsValidate.jsp?validate=FETCH_ITEM", false);
	alert("");
	xmlHttp.send(xmlDoc);
	alert("3");
	responseText=xmlHttp.responseText;
	eval(responseText);
alert(responseText);
	document.formComputeStockLevelsCriteria.submit();	//parent.frameComputeStockLevelsResult.location.href="../../eST/jsp/ComputeStockLevelsResult.jsp?function_id="+document.formComputeStockLevelsCriteria.function_id.value;	
*/
}
function apply() {
	var errorPage = "../../eCommon/jsp/error.jsp";
	var formObjResult = f_query_add_mod.frameComputeStockLevelsResult.document.formComputeStockLevelsResult;
	if (formObjResult == null) {
		messageFrame.location.href = errorPage + "?err_num=";
	}
	updateItemDetails(formObjResult);
	var formObj = f_query_add_mod.frameComputeStockLevelsCriteria.document.formComputeStockLevelsCriteria;
	if (!confirm(getMessage("OVERWRITE_STOCK_LEVELS", "ST"))) {
		messageFrame.location.href = errorPage + "?err_num=";
		return;
	}
	var total_index = formObjResult.total_index.value;
	for (var i = 0; i < total_index; i++) {
		if ((eval("formObjResult.chk_box_" + i).value) == "Y") {
			var item = (eval("formObjResult.item_name_" + i).value);
			if (((eval("formObjResult.min_stk_qty_" + item).value) == 0) || ((eval("formObjResult.max_stk_qty_" + item).value) == 0) || ((eval("formObjResult.reorder_level_" + item).value) == 0) || ((eval("formObjResult.reorder_qty_" + item).value) == 0)) {
				if ((eval("formObjResult.min_stk_qty_" + item).value) == 0) {
					var obj = "formObjResult.min_stk_qty_";
				} else {
					if ((eval("formObjResult.max_stk_qty_" + item).value) == 0) {
						var obj = "formObjResult.max_stk_qty_";
					} else {
						if ((eval("formObjResult.reorder_level_" + item).value) == 0) {
							var obj = "formObjResult.reorder_level_";
						} else {
							if ((eval("formObjResult.reorder_qty_" + item).value) == 0) {
								var obj = "formObjResult.reorder_qty_";
							}
						}
					}
				}
				alert(getMessage("CANNOT_BE_ZERO", "Common"));
				//alert(item);
				eval(obj + item).focus();
				messageFrame.location.href = errorPage + "?err_num=";
				return false;
			}
		}
	}
	var resultText = formApply(formObj, ST_CONTROLLER);
	eval(resultText);
	messageFrame.location.href = errorPage + "?err_num=" + message;
	if (result) {
		reset1();
	}
}
var prevObj = null;
var prevColor = null;
function changeRowColor(obj) {
	if (prevObj != null) {
		for (k = 0; k < prevObj.cells.length; k++) {
			prevObj.cells[k].className = prevColor;
		}
	}
	prevObj = obj;
	prevColor = obj.cells[1].className;
	for (k = 0; k < prevObj.cells.length; k++) {
		obj.cells[k].className = "STLIGHTPINK";
	}
}
function updateRemove(add_obj, remove_obj, index) {
	/*	if (add_obj.checked) {
		remove_obj.value="";
	}
	else{
		remove_obj.value=add_obj.value
	}
	*/
	if (add_obj.checked) {
		remove_obj.value = "";
		eval("document.forms[0].chk_box_" + index).value = "Y";
		//alert(eval("document.forms[0].chk_box_"+index).value);
	} else {
		remove_obj.value = add_obj.value;
		eval("document.forms[0].chk_box_" + index).value = "N";
		//alert(eval("document.forms[0].chk_box_"+index).value);
	}
}
function updateItemDetails(formObj) {
	if (formObj == null) {
		formObj = document.formComputeStockLevelsResult;
	}
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(formObj));
	xmlDoc = new DOMParser().parseFromString(getXMLString(formObj), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/ComputeStockLevelsValidate.jsp?validate=UPDATE_DETAILS", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
//	eval(responseText);	alert(getXMLString(document.formComputeStockLevelsResult));

//	document.formComputeStockLevelsCriteria.submit();	//parent.frameComputeStockLevelsResult.location.href="../../eST/jsp/ComputeStockLevelsResult.jsp?function_id="+document.formComputeStockLevelsCriteria.function_id.value;	
}
function changeVal() {
	if (document.formComputeStockLevelsCriteria.excludeexternalstores.checked) {
		document.formComputeStockLevelsCriteria.excludeexternalstores.value = "N";
	} else {
		document.formComputeStockLevelsCriteria.excludeexternalstores.value = "";
	}
}
function toggleCheck(formObject) {
	var allElements = formObject.elements;
	var ischecked = formObject.checkAll.checked;
	for (i = 0; i < allElements.length; i++) {
		if (allElements[i].type == "checkbox") {
		//	allElements[i].checked=ischecked;
		}
		if (allElements[i].checked != ischecked) {
			allElements[i].click();
		}
			//allElements[i].click();
	}
}
function checkIntegerFormat(obj, zeroNotAllowed) {
	if (zeroNotAllowed == null) {
		zeroNotAllowed = true;
	}
	//alert("checkIntegerFormat");
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
			obj.focus();
			return false;
		}
	}
	return true;
}
function zeroNotAllowedCheck(obj, zeroNotAllowed) {
	var formObjResult = document.formComputeStockLevelsResult;
	var total_index = formObjResult.total_index.value;
	for (var i = 0; i < total_index; i++) {
				//alert(eval("formObjResult.item_name_"+i).value+eval("formObjResult.chk_box_"+i).value);
		if ((eval("formObjResult.chk_box_" + i).value) == "Y") {
			var item = (eval("formObjResult.item_name_" + i).value);
			if (((eval("formObjResult.min_stk_qty_" + item).value) == 0) || ((eval("formObjResult.max_stk_qty_" + item).value) == 0) || ((eval("formObjResult.reorder_level_" + item).value) == 0)) {
				if ((eval("formObjResult.min_stk_qty_" + item).value) == 0) {
					var obj = "formObjResult.min_stk_qty_";
				} else {
					if ((eval("formObjResult.max_stk_qty_" + item).value) == 0) {
						var obj = "formObjResult.max_stk_qty_";
					} else {
						if ((eval("formObjResult.reorder_level_" + item).value) == 0) {
							var obj = "formObjResult.reorder_level_";
						}
					}
				}
				alert(getMessage("CANNOT_BE_ZERO", "Common"));
				eval(obj + item).focus();
				//messageFrame.location.href=errorPage+"?err_num=";
				return false;
			}
		}
	}
	/*	if (zeroNotAllowed==null) {
		zeroNotAllowed=true
	}
	
    if(obj.value=="") return;
    if(!isValidIntegerFormat(obj)){
        alert(getMessage("INVALID_NUMBER_FORMAT","PH"));
        obj.focus();
        return false;
    }
	else if((parseFloat(obj.value)==0)&&zeroNotAllowed){
        alert(getMessage("CANNOT_BE_ZERO","Common"));
        obj.focus();
        return ;
	}
	return true;
	*/
}

