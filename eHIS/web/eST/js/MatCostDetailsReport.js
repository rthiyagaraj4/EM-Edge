
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
var formObj = "";
function reset() {
	formObj = f_query_add_mod.document.MatCostDetailsReportCriteria;
	formObj.reset();
//	parent.frames[1].frames[1].document.forms[0].reset();
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
	var ret1=unescape(returnedValues);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if ((returnedValues != null) && (returnedValues != "")) {
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
		var ret1=unescape(returnedValues);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = arr[0];
	}
}

async function searchCodeTrade(obj) {
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
	argumentArray[0] = document.getElementById("SQL_AM_TRADE_NAME_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.TradeName.label", "Common"), argumentArray);
			var ret1=unescape(returnedValues);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = arr[0];
	}

}
function run() {
	formObj = f_query_add_mod.document.MatCostDetailsReportCriteria;
	if (f_query_add_mod.document.MatCostDetailsReportCriteria) {
			if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
				if (isValidFromToField(formObj.p_fr_item_class, formObj.p_to_item_class, STRING, getLabel("Common.ItemClass.label", "Common"), messageFrame)) {
					if (doDateCheck(formObj.dt_from, formObj.dt_to, messageFrame)) {
								formObj.dt_from.value = convertDate(formObj.dt_from_1.value, "DMY", formObj.p_language_id.value, "en");
								formObj.dt_to.value = convertDate(formObj.dt_to_1.value, "DMY", formObj.p_language_id.value, "en");
							}
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
		}
		formObj.action="../../eCommon/jsp/report_options.jsp";

    		formObj.target="messageFrame";
		
		formObj.submit();
	}
}
function checkDocDate(formObj) {
	if (isValidFromToField(formObj.dt_from_1, formObj.dt_to_1, DATE, getLabel("Common.date.label", "Common"))) {
	} else {
		return false;
	}
}
