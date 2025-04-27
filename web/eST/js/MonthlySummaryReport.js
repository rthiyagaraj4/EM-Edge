
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
var formObj = "";
function reset() {
	var formObj = f_query_add_mod.document.MonthlySummaryReportCriteria;
	if (formObj == undefined && formObj == null) {
		var formObj = f_query_add_mod.frames[0].document.forms[0];
		f_query_add_mod.frames[1].location.href = "../../eCommon/html/blank.html";
	}
		//var formObj=f_query_add_mod.frames[0].document.formComputeStockLevelsCriteria;
	/*formObj.p_fm_item_code.disabled=true;
	formObj.p_fm_sr2.disabled=true;
	formObj.p_to_item_code.disabled=true;
	formObj.p_to_sr2.disabled=true;
	formObj.p_fr_str_code.disabled=true;
	formObj.p_fm_stc.disabled=true;
	formObj.p_to_str_code.disabled=true;
	formObj.p_to_stc.disabled=true;*/
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
	argumentArray[0] = document.getElementById('SQL_ST_ITEM_LOOKUP').value;
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
 	if(arr[0]==undefined) 
		{
 		arr[0]="";	
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
	argumentArray[0] = document.getElementById('SQL_ST_ITEM_CLASS_LOOKUP_LANG').value + "'" + document.forms[0].p_language_id.value + "'";
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
 	if(arr[0]==undefined) 
		{
 		arr[0]="";	
		}
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = arr[0];
	}
}
async function searchAlphaCode(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	argumentArray[0] = document.forms[0].SQL_ST_ALPHA_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.AlphaCode.label", "Common"), argumentArray);
	var ret1=unescape(returnedValues);
 	var arr=ret1.split(",");
 	if(arr[0]==undefined) 
		{
 		arr[0]="";	
		}
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = arr[0];
	}
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
	argumentArray[0] = document.getElementById('SQL_ST_STORE_LOOKUP').value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
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
		obj.value = arr[0];
	}
}
function loadcolumn(obj) {
	formObj = document.forms[0];
	if ((obj.value == "STBMTSM2") || (obj.value == "STBMTSM3")) {
		formObj.p_fm_item_code.disabled = false;
		formObj.p_fm_sr2.disabled = false;
		formObj.p_to_item_code.disabled = false;
		formObj.p_to_sr2.disabled = false;
	} else {
		formObj.p_fm_item_code.disabled = true;
		formObj.p_fm_item_code.value = "";
		formObj.p_fm_sr2.disabled = true;
		formObj.p_to_item_code.disabled = true;
		formObj.p_to_item_code.value = "";
		formObj.p_to_sr2.disabled = true;
	}
	if ((obj.value == "STBMTSM4") || (obj.value == "STBMTSM3")) {
		formObj.p_fr_str_code.disabled = false;
		formObj.p_fr_str_code.value = "";
		formObj.p_fm_stc.disabled = false;
		formObj.p_to_str_code.disabled = false;
		formObj.p_to_str_code.value = "";
		formObj.p_to_stc.disabled = false;
	} else {
		formObj.p_fr_str_code.disabled = true;
		formObj.p_fr_str_code.value = "";
		formObj.p_fm_stc.disabled = true;
		formObj.p_to_str_code.disabled = true;
		formObj.p_to_str_code.value = "";
		formObj.p_to_stc.disabled = true;
	}
}
function checkDateMonYear() {
	formObj = f_query_add_mod.document.MonthlySummaryReportCriteria;
	if (formObj.p_year.value.length != 4) {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("MONTH_YEAR_INVALID", "SM");//Invalid Year Format";
		return false;
	}
	if (formObj.p_month.value > 12) {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("MONTH_YEAR_INVALID", "SM");//Invalid Month Format";
		return false;
	}
	var pmonth = formObj.p_month.value;
	if (formObj.p_month.value > 0 && formObj.p_month.value < 10 && pmonth.length < 2) {
		var fm_month = "0" + formObj.p_month.value;
	} else {
		var fm_month = formObj.p_month.value;
	}
	var curmonth = formObj.curr_proc_month.value;
	if (formObj.curr_proc_month.value > 0 && formObj.curr_proc_month.value < 10 && curmonth.length < 2) {
		var p_month = "0" + formObj.curr_proc_month.value;
	} else {
		var p_month = formObj.curr_proc_month.value;
	}
	pmonth = formObj.p_year.value + fm_month;
	curmonth = formObj.curr_proc_year.value + p_month;
	if (pmonth <= curmonth) {
		return true;
	} else {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("MONTH_NOT_GREATER_SYSDATE", "ST");//Should be Less than Current month";
		return false;
	}
	/*if (parseFloat(formObj.p_month.value) > parseFloat(formObj.curr_proc_month.value) ){
		 if(formObj.p_year.value< formObj.curr_proc_year.value) {	
			   return true;
		}else{
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("CANNOT_BE_GT_CURR_PERIOD");//Should be Less than Current month";
			 return false;
		}
	}else{
			if(parseFloat(formObj.p_month.value) <= parseFloat(formObj.curr_proc_month.value))
			return true;
			else
			{				messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("CANNOT_BE_GT_CURR_PERIOD");//Should be Less than Current month";
				return false;
			}
					
	   }
	  if (parseFloat(formObj.p_year.value)>parseFloat(formObj.curr_proc_year.value)) {
	   messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("CANNOT_BE_GT_CURR_PERIOD");//Should be Less than Current year";
	   return false;
	   }*/
	return true;
}
function run() {
	if (f_query_add_mod.document.MonthlySummaryReportCriteria) {
		formObj = f_query_add_mod.document.MonthlySummaryReportCriteria;
		if (!checkDateMonYear()) {
			return;
		}
		if (isValidFromToField(formObj.p_fr_str_code, formObj.p_to_str_code, STRING,getLabel("Common.StoreCode.label", "Common"), messageFrame)) {
			if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
				if (isValidFromToField(formObj.p_fr_item_class, formObj.p_to_item_class, STRING, getLabel("Common.ItemClass.label", "Common"), messageFrame)) {
					formObj.submit();
				}
			}
		}
	}
}

