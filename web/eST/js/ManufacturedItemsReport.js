
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
var formObj = "";
function reset() {
	f_query_add_mod.location.href = "../../eST/jsp/ManufacturedItemsReportCriteria.jsp";
}

function run(){
    formObj = f_query_add_mod.document.formmanufacturedItemsReportCriteria;
   
    formObj.DT_FROM.value = convertDate(formObj.fm_date.value, "DMY", formObj.p_language_id.value, "en");		 
	formObj.DT_TO.value = convertDate(formObj.to_date.value, "DMY", formObj.p_language_id.value, "en");
     if(formObj.fm_date.value != "" && formObj.to_date.value != "" ){
		  if(!isBefore(formObj.DT_FROM.value,formObj.DT_TO.value,"DMY",'en'.value)) {
          alert(getMessage("FM_DATE_GR_TO_DATE", "ST"));
          formObj.to_date.focus();
           return ;	
         } 
	  }
	   if(formObj.fm_date.value == ""){
	   alert(getMessage("FROM_DATE_NOT_BLANK", "ST"));
       formObj.fm_date.focus();
       return ;	
	   }
	   if(formObj.p_report_by.value == "DT")
	   formObj.p_report_id.value = "STBMFGLISD" ;
	   else
	   formObj.p_report_id.value = "STBMFGLISS";
	   f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    	f_query_add_mod.document.forms[0].target="messageFrame"
        formObj.submit();		
}

function checkDocDate(formObj) {
	if (isValidFromToField(formObj.fm_date, formObj.to_date, DATE, getLabel("Common.date.label", "Common"))) {
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
function loadData()
{
  /*formObj = document.formTransactionListReportCriteria;
  
  if(formObj.P_TRN_TYPE.value == "ISS" || formObj.P_TRN_TYPE.value == "URG"){
  formObj.p_transaction_mode.value = "";
  formObj.p_transaction_mode.style.visibility="visible";
  document.getElementById("trn_mode_img").style.visibility="visible";
  document.getElementById("mode").style.visibility="visible";
  }else{
  formObj.p_transaction_mode.style.visibility ="hidden";
  document.getElementById("trn_mode_img").style.visibility="hidden";
  document.getElementById("mode").style.visibility="hidden";
  }
   */
}
async function searchCodeItem(obj) {
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
	returnedValues = await CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		obj.value = arr[0];
	}
}

