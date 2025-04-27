
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
var formObj = "";
function reset() {
	frames[1].document.forms[0].reset();
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


function run(){
  formObj = f_query_add_mod.document.formCancelRequestReportCriteria
 //if (isValidFromToField(formObj.p_req_by_store_code, formObj.p_req_on_store_code, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)) {
 
 if(((formObj.p_req_by_store_code.value).toUpperCase()==""&& (formObj.p_req_on_store_code.value).toUpperCase()=="")||!((formObj.p_req_by_store_code.value).toUpperCase() == (formObj.p_req_on_store_code.value).toUpperCase())){
   formObj.fm_date.value = convertDate(formObj.p_req_date_from.value, "DMY", formObj.p_language_id.value, "en");		 
	formObj.to_date.value = convertDate(formObj.p_req_date_to.value, "DMY", formObj.p_language_id.value, "en");
     if(formObj.p_req_date_to.value != "" && formObj.p_req_date_from.value != "" ){
		  if(!isBefore(formObj.fm_date.value,formObj.to_date.value,"DMY",'en'.value)) {
       alert(getMessage("FM_DATE_GR_TO_DATE", "ST"));
       formObj.p_req_date_to.focus();
       return ;	
        } 
	   }
	   f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
	   f_query_add_mod.document.forms[0].target="messageFrame"
       formObj.submit();
				}else{
				 alert(getMessage("REQ_ON_REQ_BY_CANNOT_BE_SAME", "ST"));
					formObj.p_req_on_store_code.select();
					return;
				}
}

function checkDocDate(formObj) {
   
	if (isValidFromToField(formObj.p_req_date_from, formObj.p_req_date_to, DATE, getLabel("Common.date.label", "Common"))) {
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
