
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
var formObj = "";
function reset1() {
	f_query_add_mod.frameComputeStockLevelsStoresCriteria.document.formComputeStockLevelsStoresCriteria.reset();
	f_query_add_mod.frameComputeStockLevelsStoresResult.location.href = "../../eCommon/html/blank.html";
}
/*function searchCodeStore( obj) {
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";

	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql_1=" SELECT	  st.store_code code,  mm.short_desc description FROM mm_store mm, st_store st   WHERE  mm.facility_id    LIKE(?)	 AND 	 UPPER(st.store_code)   LIKE  	UPPER(?)  AND  UPPER(mm.short_desc)  LIKE	 UPPER(?)   AND  mm.eff_status='E'   AND   mm.store_code= st.store_code   ORDER BY 2";	
	dataNameArray[0]  = "facility_id";
	dataValueArray[0]  =document.forms[0].p_facility_id.value;

	dataTypeArray[0] = STRING;
	argumentArray[0] = sql_1;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	

	returnedValues = CommonLookup( getLabel("Common.Store.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = returnedValues[0];
	} 
}
*/
async function searchCodeItem(objCode) {
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
	argumentArray[0] = document.getElementById('SQL_ST_ITEM_LOOKUP').value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = objCode.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	var ret1=unescape(returnedValues);
 	var arr=ret1.split(",");
 	if(arr[0]==undefined) 
		{
 		arr[0]="";	
		}
	if ((returnedValues != null) && (returnedValues != "")) {
		objCode.value = arr[0];
		//objDesc.value = returnedValues[1];
	}
}
/*
function searchCodeItemClass( obj) {

	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	
	var sql_str="SELECT   st.item_code code, 	 mm.short_desc description    FROM   mm_item_lang_vw  mm,    st_item  st 	WHERE    st.item_code = mm.item_code  and 	mm.eff_status =	'E'	     AND    mm.language_id LIKE  '"+document.forms[0].language_id.value+"'      AND	    st .item_code   LIKE   UPPER(?)    AND upper(mm.short_desc)	 LIKE   upper(?)   order by 2";
	argumentArray[0] = sql_str;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	//alert(argumentArray);
	returnedValues = CommonLookup( getLabel("Common.ItemClass.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = returnedValues[0];
	} 
}
*/
async function searchCodeItemClass(objCode) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	argumentArray[0] = document.getElementById('SQL_ST_ITEM_CLASS_LOOKUP_LANG').value + "'" + document.forms[0].p_language_id.value + "'";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = objCode.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.ItemClass.label", "Common"), argumentArray);
	var ret1=unescape(returnedValues);
 	var arr=ret1.split(",");
 	if(arr[0]==undefined) 
		{
 		arr[0]="";	
		}
	if ((returnedValues != null) && (returnedValues != "")) {
		objCode.value = arr[0];
		//objDesc.value = returnedValues[1];
	}
}
function searchItems() {
	var arrayObject = new Array(document.formComputeStockLevelsStoresCriteria.store_code, document.formComputeStockLevelsStoresCriteria.consumption_period);
	var names = new Array(getLabel("Common.StoreCode.label", "Common"), getLabel("eST.ConsumptionPeriod.label", "ST"));
	//var arrayObject = new Array(document.formComputeStockLevelsStoresCriteria.consumption_period);
	//var names = new Array("Consumption Period");
	var blankObject = checkSTFields(arrayObject, names, parent.parent.messageFrame);
	if (blankObject != true) {
		//blankObject.focus();
		return;
	}
	/*	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";


	
	xmlDoc.loadXML(getXMLString(document.formComputeStockLevelsStoresCriteria));
	//alert((getXMLString(document.formComputeStockLevelsStoresCriteria)));
	xmlHttp.open("POST", "../../eST/jsp/ComputeStockLevelsStoresValidate.jsp?validate=FETCH_ITEM", false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;*/
	if (document.forms[0].p_stk_issue.checked) {
		document.formComputeStockLevelsStoresCriteria.p_stk_issue.value = "Y";
	} else {
		document.formComputeStockLevelsStoresCriteria.p_stk_issue.value = "N";
	}
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	//xmlDoc.loadXML(getXMLString(document.formComputeStockLevelsStoresCriteria));
	xmlDoc = new DOMParser().parseFromString(getXMLString(document.formComputeStockLevelsStoresCriteria), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/ComputeStockLevelsStoresValidate.jsp?validate=FETCH_ITEM", false);
	//xmlHttp.open( "POST", "../../eST/jsp/ComputeStockLevelsStoresValidate.jsp?validate=FETCH_ITEM&consumption_period="+ document.forms[0].consumption_period.value + "&fm_item_class_code=" + document.forms[0].fm_item_class_code.value + "&to_item_class_code=" + document.forms[0].to_item_class_code.value+"&fm_item_code="+document.forms[0].fm_item_code.value+"&to_item_code"+document.forms[0].to_item_code.value+"&store_code="+document.forms[0].store_code.value+"&buffer_percentage="+document.forms[0].buffer_percentage.value+"&p_stk_issue="+document.forms[0].p_stk_issue.value, false ) ;
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;


  //  alert(responseText);
	document.formComputeStockLevelsStoresCriteria.submit();	//parent.frameComputeStockLevelsResult.location.href="../../eST/jsp/ComputeStockLevelsResult.jsp?function_id="+document.formComputeStockLevelsCriteria.function_id.value;	
}
function apply() {
	var errorPage = "../../eCommon/jsp/error.jsp";
	var formObjResult = f_query_add_mod.frameComputeStockLevelsStoresResult.document.formComputeStockLevelsStoresResult;
	if (formObjResult == null) {
		messageFrame.location.href = errorPage + "?err_num=";
	}
	updateItemDetails(formObjResult);
	var formObj = f_query_add_mod.frameComputeStockLevelsStoresCriteria.document.formComputeStockLevelsStoresCriteria;
	if (!confirm(getMessage("OVERWRITE_STOCK_LEVELS", "ST"))) {
		messageFrame.location.href = errorPage + "?err_num=";
		return;
	}
	var store_code = f_query_add_mod.frameComputeStockLevelsStoresCriteria.document.formComputeStockLevelsStoresCriteria.store_code;
	var consumption_period = f_query_add_mod.frameComputeStockLevelsStoresCriteria.document.formComputeStockLevelsStoresCriteria.consumption_period;
	var arrayObject = new Array(store_code, consumption_period);
	var names = new Array(getLabel("Common.StoreCode.label", "Common"), getLabel("eST.ConsumptionPeriod.label", "ST"));
	//var arrayObject = new Array(document.formComputeStockLevelsStoresCriteria.consumption_period);
	//var names = new Array("Consumption Period");
	var blankObject = checkSTFields(arrayObject, names, messageFrame);
	if (blankObject != true) {
		//blankObject.focus();
		return;
	}
	//alert("resultText");
	var total_index = formObjResult.total_index.value;
	for (var i = 0; i < total_index; i++) {
		//		alert(eval("formObjResult.item_name_"+i).value+eval("formObjResult.chk_box_"+i).value);
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
				messageFrame.location.href = errorPage + "?err_num=";
				return false;
			}
		}
	}
	var resultText = eval(formApply(formObj, ST_CONTROLLER));
	//alert(resultText);
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
	if (add_obj.checked) {
		remove_obj.value = "";
		eval("document.forms[0].chk_box_" + index).value = "Y";
	} else {
		remove_obj.value = add_obj.value;
		eval("document.forms[0].chk_box_" + index).value = "N";
	}
}

function updateItemDetails(formObj, async) {
    if (formObj == null) {
        formObj = document.formComputeStockLevelsStoresResult;
    }
    var xmlHttp = new XMLHttpRequest();
    var xmlDoc = new DOMParser().parseFromString(getXMLString(formObj), "text/xml");
    var url = "../../eST/jsp/ComputeStockLevelsStoresValidate.jsp?validate=UPDATE_DETAILS";

    if (async) {
        xmlHttp.open("POST", url, true);
        xmlHttp.send(xmlDoc);
        xmlHttp.onreadystatechange = function() {
            if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                var responseText = xmlHttp.responseText;
                eval(responseText);
            }
        };
    } else {
        xmlHttp.open("POST", url, false);
        var responseText = xmlHttp.responseText;
        eval(responseText);
    }
}

/*
function updateItemDetails(formObj) {
	if (formObj == null) {
		formObj = document.formComputeStockLevelsStoresResult;
	}
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(formObj));
	xmlDoc = new DOMParser().parseFromString(getXMLString(formObj), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/ComputeStockLevelsStoresValidate.jsp?validate=UPDATE_DETAILS", true);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
}*/
	/*
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlHttp.open( "POST", "../../eST/jsp/ComputeStockLevelsStoresValidate.jsp?validate=UPDATE_DETAILS&consumption_period="+ document.forms[0].consumption_period.value + "&fm_item_class_code=" + document.forms[0].fm_item_class_code.value + "&to_item_class_code=" + document.forms[0].to_item_class_code.value+"&fm_item_code="+document.forms[0].fm_item_code.value+"&to_item_code"+document.forms[0].to_item_code.value+"&store_code="+document.forms[0].store_code.value+"&buffer_percentage="+document.forms[0].buffer_percentage.value, false ) ;
	xmlHttp.send( xmlDoc ) ;*/
	
	
	
//	eval(responseText);	alert(getXMLString(document.formComputeStockLevelsResult));

//	document.formComputeStockLevelsCriteria.submit();	//parent.frameComputeStockLevelsResult.location.href="../../eST/jsp/ComputeStockLevelsResult.jsp?function_id="+document.formComputeStockLevelsCriteria.function_id.value;	

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
function zeroNotAllowedCheck(obj, zeroNotAllowed) {
	var formObjResult = document.formComputeStockLevelsStoresResult;
	var total_index = formObjResult.total_index.value;
	for (var i = 0; i < total_index; i++) {
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
async function searchCodeStore(objCode) {
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
	dataNameArray[1] = "facility_id";
	dataValueArray[1] = document.forms[0].p_facility_id.value;
	dataTypeArray[1] = STRING;
	argumentArray[0] = document.getElementById('SQL_ST_STORE_LOOKUP').value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = objCode.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	var ret1=unescape(returnedValues);
 	var arr=ret1.split(",");
 	if(arr[0]==undefined) 
		{
 		arr[0]="";	
		}
	if ((returnedValues != null) && (returnedValues != "")) {
		objCode.value = arr[0];
		//objDesc.value = returnedValues[1];
	}
}

