
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
var formObj = "";
function reset() {
	var formObj = f_query_add_mod.document.formStockTransactionType;
	if (formObj == undefined && formObj == null) {
		var formObj = f_query_add_mod.frames[0].document.forms[0];
		f_query_add_mod.frames[1].location.href = "../../eCommon/html/blank.html";
	}
	formObj.reset();
}
async function searchCodeStore(obj) {
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
	argumentArray[0] = document.getElementById("SQL_ST_STORE_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		obj.value = arr[0];
	}
}
async function searchCodeItem(obj) {
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
	returnedValues = await CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		obj.value = arr[0];
	}
}
async function searchCodeItemClass(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	argumentArray[0] = document.getElementById("SQL_ST_ITEM_CLASS_LOOKUP_LANG").value + "'" + document.forms[0].p_language_id.value + "'";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.ItemClass.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		obj.value = arr[0];
	}
}


/*function searchManuId(obj) {

    var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var sql =  "SELECT  MANUFACTURER_ID CODE ,SHORT_NAME DESCRIPTION  FROM AM_MANUFACTURER_LANG_VW  WHERE eff_status='E'  AND UPPER(MANUFACTURER_ID) LIKE UPPER(?) AND UPPER(SHORT_NAME) LIKE UPPER(?) AND LANGUAGE_ID =  ";
	argumentArray[0] = sql + "'" + document.forms[0].p_language_id.value + "'";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.Manufacturer.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
  
}*/
function run() {
	if (f_query_add_mod.document.formStockTransactionType) {
		formObj = f_query_add_mod.document.formStockTransactionType;
		
    /*var arrayObject = new Array(formObj.p_fm_store_code,formObj.p_to_store_code);
	var names = new Array(getLabel("eST.FromStore.label", "eST"), getLabel("Common.ToStore.label", "common"));
	var blankObject = checkSTFields(arrayObject, names, messageFrame);
	if(blankObject==false){
		return;
	}*/
	
	if(formObj.p_fm_store_code.value==""){
		alert(getMessage("FROM_STORE_NOT_DEFINED", "ST"));
		formObj.p_fm_store_code.focus();
		return;
		}
		if(formObj.p_to_store_code.value==""){
		alert("APP-ST0117 To Store Cannot be blank...");
		formObj.p_to_store_code.focus();
		return;
		}
	
	formObj.p_fm_date.value = convertDate(formObj.p_trn_date_from.value, "DMY", formObj.p_language_id.value, "en");		 
	formObj.p_to_date.value = convertDate(formObj.p_trn_date_to.value, "DMY", formObj.p_language_id.value, "en");
     if(formObj.p_trn_date_to.value != "" && formObj.p_trn_date_from.value != "" ){
		  if(!isBefore(formObj.p_fm_date.value,formObj.p_to_date.value,"DMY",'en'.value)) {
          alert(getMessage("FM_DATE_GR_TO_DATE", "ST"));
          formObj.p_trn_date_to.focus();
           return ;	
         } 
	  }
	   if(formObj.p_trn_date_from.value == ""){
	   alert(getMessage("FROM_DATE_NOT_BLANK", "ST"));
       formObj.p_trn_date_from.focus();
       return ;	
	   }
	   if(formObj.p_trn_date_to.value == ""){
	   alert(getMessage("TO_DATE_NOT_BLANK", "ST"));
       formObj.p_trn_date_to.focus();
       return ;	
	   }
	
	
		
		if (isValidFromToField(formObj.p_fm_store_code, formObj.p_to_store_code, STRING,getLabel("Common.StoreCode.label", "Common"), messageFrame)) {
			if (isValidFromToField(formObj.p_fm_item_class, formObj.p_to_item_class, STRING, getLabel("Common.ItemClass.label", "Common"), messageFrame)) {
			if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
		 
			

				    f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    		        f_query_add_mod.document.forms[0].target="messageFrame"
					formObj.submit();
				 
			}
		  }
		}
	}
}

function CheckForSpecialChars(event) {
	var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-.";
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) {
		return false;
	}  // Not a valid key
	//if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	//	return (event.keyCode -= 32);
	return true; 
}



function checkDocDate(formObj) {
	if (isValidFromToField(formObj.p_trn_date_from, formObj.p_trn_date_to, DATE, getLabel("Common.date.label", "Common"))) {
	} else {
		return false;
	}
}
 function isValidFromToField(fromObj, toObj, dataType, stLegend) {
	var bReturn = true;
	var stFromValue = fromObj.value;
	var stToValue = toObj.value;
	if ((!trimCheck(stFromValue)) || (!trimCheck(stToValue))) {
		return bReturn;
	}
	if (dataType == null) {
		dataType = STRING;
	}
	switch (dataType) {
	  case INT:
	  case LONG:
	  case FLOAT:
	  case DOUBLE:
		if (parseFloat(stFromValue) > parseFloat(stToValue)) {
			bReturn = false;
		}
		break;
	  case DATE:
		var arFromDate = stFromValue.split("/");
		var arToDate = stToValue.split("/");
		if (Date.parse("" + arFromDate[1] + "/" + arFromDate[0] + "/" + arFromDate[2] + "/") > Date.parse("" + arToDate[1] + "/" + arToDate[0] + "/" + arToDate[2] + "/")) {
			bReturn = false;
		}
		break;
	  default:
		if (stFromValue > stToValue) {
			bReturn = false;
		}
	}
	if ((!bReturn)) {
		var stMessage = getMessage("LESS_OR_EQUAL_VALIDATE", "ST");
		stMessage = stMessage.replace(/@/g, stLegend);
		alert(stMessage);
		toObj.focus();
	}
	return bReturn;
}
