var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
var formObj = "";
function reset() {
	formObj = f_query_add_mod.document.ItemsNotCreatedReportCriteria;
	formObj.reset();
}
function run() {
	formObj = f_query_add_mod.document.ItemsNotCreatedReportCriteria;
	if (f_query_add_mod.document.ItemsNotCreatedReportCriteria) {
					formObj.dt_from.value = convertDate(formObj.dt_from_1.value, "DMY", formObj.p_language_id.value, "en");		 
					formObj.dt_to.value = convertDate(formObj.dt_to_1.value, "DMY", formObj.p_language_id.value, "en");
				    if(formObj.dt_to_1.value != "" && formObj.dt_from_1.value != "" ){
				  if(!isBefore(formObj.dt_from.value,formObj.dt_to.value,"DMY",'en'.value)) {
				        alert(getMessage("FM_DATE_GR_TO_DATE", "ST"));
				        formObj.dt_to_1.focus();
				          return ;	
				        } 
					  }
					   if(formObj.dt_from_1.value == ""){
					   alert(getMessage("FROM_DATE_NOT_BLANK", "ST"));
				       formObj.dt_from_1.focus();
				       return ;	
					   }
					   
					
					}
		
	
		
		formObj.submit();
	}

function checkDocDate(formObj) {
	if (isValidFromToField(formObj.dt_from_1, formObj.dt_to_1, DATE, getLabel("Common.date.label", "Common"))) {
	} else {
		return false;
	}
}

function searchCodeItem(obj) {
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
	}
}
function searchCodeItemClass(obj) {
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
	returnedValues = CommonLookup(getLabel("Common.ItemClass.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
