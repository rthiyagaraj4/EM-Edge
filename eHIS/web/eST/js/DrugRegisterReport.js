
function reset() {
	formObj = f_query_add_mod.document.formDrugRegisterReportCriteria;
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
	retVal = await CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	var ret1=unescape(retVal);
							var arr=ret1.split(",");
							if(arr[1]==undefined) 
							{
								arr[0]="";	
								arr[1]="";	
							}				
 
	if ((retVal != null) && (retVal != "")) {
		obj.value = arr[1];
		document.forms[0].p_str_code.value = arr[0];
	}
}
async function searchCodeItem( obj) {
	var result		=	false ;
	var message		=	"" ;
	var flag		=	"" ;
	var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	dataNameArray[0]   = "language_id";
	dataValueArray[0]   = document.forms[0].p_language_id.value;
	dataTypeArray[0]    = STRING;
	argumentArray[0] = document.getElementById("SQL_ST_ITEM_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup( getLabel("Common.item.label","Common"), argumentArray );
	
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		obj.value = arr[1];
		document.forms[0].p_item_code.value = arr[0];
	} 
}
function checkMonthYear(){
	formObj = f_query_add_mod.document.formDrugRegisterReportCriteria;
	var sysDate = formObj.sysdate.value;
	var sysDateArray = sysDate.split("/");
	var curr_proc_year = sysDateArray[2];//formObj.curr_proc_year.value;
	var curr_proc_month = sysDateArray[1];//formObj.curr_proc_month.value;
	var currPeriod = parseFloat(formatNumber(curr_proc_year, 4) + formatNumber(curr_proc_month, 2));
	eval(formObj.p_fm_year.value+formObj.p_fm_month.value);
	if((!(formObj.p_fm_year.value=="")&&(formObj.p_fm_year.value.length<4))){
		alert("Invalid Year");
		return false;
	}else if((!(formObj.p_to_year.value=="")&&(formObj.p_to_year.value.length<4))){
		alert("Invalid Year");
		return false;
	}
	if(eval(formObj.p_fm_month.value)>12 || eval(formObj.p_to_month.value)>12){
		alert("Invalid Month");
		return false;
	}
	formObj.p_from_monthyear.value =""+ eval(formatNumber(formObj.p_fm_year.value,4)+formatNumber(formObj.p_fm_month.value,2));
	formObj.p_to_monthyear.value =""+ eval(formatNumber(formObj.p_to_year.value,4)+formatNumber(formObj.p_to_month.value,2));
	if(eval(formObj.p_from_monthyear.value)>eval(formObj.p_to_monthyear.value)){
		var stMessage = getMessage("LESS_OR_EQUAL_VALIDATE", "ST");
		stMessage = stMessage.replace(/@/g, "Month/Year");
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + stMessage;
		return false;
	}
	if (eval(formatNumber(formObj.p_fm_year.value,4)+formatNumber(formObj.p_fm_month.value,2)) > currPeriod) {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("DATE_NOT_GREATER_SYSDATE", "ST");
		return false;
	}
	if (eval(formatNumber(formObj.p_to_year.value,4)+formatNumber(formObj.p_to_month.value,2)) > currPeriod) {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("DATE_NOT_GREATER_SYSDATE", "ST");
		return false;
	}
	return true;
}
function run() {
	formObj = f_query_add_mod.document.formDrugRegisterReportCriteria;
	var localeName = formObj.p_language_id.value;
	formObj.p_fm_year.value = convertDate(formObj.p_fm_year.value, "YY", localeName,"en");
	formObj.p_to_year.value = convertDate(formObj.p_to_year.value, "YY", localeName,"en");
	var fields = new Array(formObj.p_str_code,formObj.p_item_code,formObj.p_fm_month, formObj.p_to_month,formObj.p_fm_year, formObj.p_to_year);
	var names = new Array(getLabel("Common.Store.label", "Common"),getLabel("Common.item.label", "Common"),getLabel("Common.FromMonth.label", "Common"),getLabel("Common.ToMonth.label", "Common"),"From Year", "To Year");
	var errorPage = "../../eCommon/jsp/error.jsp";
	var blankObject = null;
	blankObject = checkSTFields(fields, names, messageFrame, errorPage);
	if(blankObject){
		if(!checkMonthYear())
			return;
		formObj.p_from_monthyear.value =""+ eval(formatNumber(formObj.p_fm_year.value,4)+formatNumber(formObj.p_fm_month.value,2));
		formObj.p_to_monthyear.value =""+ eval(formatNumber(formObj.p_to_year.value,4)+formatNumber(formObj.p_to_month.value,2));
		formObj.submit();
	}
}
function formatNumber(number, length) {
	var returnNumber = "" + number;
	if (isNaN(returnNumber)) {
		returnNumber = "0";
	}
	var numberLength = length - returnNumber.length;
	for (i = 0; i < numberLength; i++) {
		returnNumber = "0" + returnNumber;
	}
	return returnNumber;
}

