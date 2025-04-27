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
		if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
			f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
		f_query_add_mod.document.forms[0].target="messageFrame"
				 formObj.submit();
	}		
}

function checkDocDate(formObj) {
	if (isValidFromToField(formObj.dt_from_1, formObj.dt_to_1, DATE, getLabel("Common.date.label", "Common"))) {
	} else {
		return false;
	}
}

async function searchCodeItem(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var sql = "	select item_code CODE , long_desc DESCRIPTION from xi_item_status_report where status='E' AND UPPER(item_code) LIKE UPPER(?) AND UPPER(long_desc) LIKE UPPER(?)  order by 2";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	var ret1=unescape(returnedValues);
	//alert("ret1"+ret1);
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
