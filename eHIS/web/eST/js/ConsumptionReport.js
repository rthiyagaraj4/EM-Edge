/*
--------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------------------
15/07/2021	TFS:21516		Shazana										MOHE-CRF-0084.1-US0014
--------------------------------------------------------------------------------------------------------------------
*/
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
var formVal = "";
var flag = false;
var flag2 = true;
var flag3 = true;
var flag4 = true;
var flag5 = true;
function reset() {
	f_query_add_mod.location.href = "../../eST/jsp/ConsumptionReportQueryCriteria.jsp";
	flag = false;
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
	returnedValues = await  CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		
		var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		obj.value = arr[0];
		
	}
}
//MOHE-CRF-0084.1-US014
async function searchCodeStore1(obj) {
	var user_name =  document.forms[0].p_user_name.value; 
	var p_report = document.forms[0].p_report.value; //MOHE-CRF-0084.1
	//var restrictInReportYN = document.forms[0].restrictInReportYN.value; //commented for MOHE-CRF-0084.1
	var strFacilityParam = document.forms[0].p_strFacilityParam.value;//MOHE-CRF-0084.1 
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
	dataTypeArray[1] = STRING;//Commented for MOHE-CRF-0084.1
	if(p_report == "ATC" || p_report == "CD"){ //added for MOHE-CRF-0084.1 start
	if(strFacilityParam == "Y"){
		argumentArray[0] = "SELECT st.store_code code,  mm.short_desc  description FROM  mm_store_lang_vw  mm, st_store st    WHERE  mm.eff_status ='E'  AND  language_id  like  ? and mm.facility_id like ?    AND  UPPER(st.store_code)  LIKE UPPER(?)  AND  UPPER(mm.short_desc) LIKE	 UPPER(?) AND   mm.store_code=st.store_code AND st.store_code IN (SELECT STORE_CODE FROM st_user_access_for_store where user_id = '" +user_name+"' "+ ") ORDER BY 2";//MODIFIED FOR MOHE-CRF-0084.1
	}
		else if (strFacilityParam == "N"){
			argumentArray[0] = "SELECT st.store_code code,  mm.short_desc  description FROM  mm_store_lang_vw  mm, st_store st    WHERE  mm.eff_status ='E'  AND  language_id  like  ? and mm.facility_id like ?    AND  UPPER(st.store_code)  LIKE UPPER(?)  AND  UPPER(mm.short_desc) LIKE	 UPPER(?) AND   mm.store_code=st.store_code ORDER BY 2";//MODIFIED FOR MOHE-CRF-0084.1
		}//end 
	}
	else if (p_report =="C"){
		if(strFacilityParam == "Y"){//MOHE-CRF-0084.1
			argumentArray[0] = "SELECT st.store_code code,  mm.short_desc  description FROM  mm_store_lang_vw  mm, st_store st    WHERE  mm.eff_status ='E'  AND  language_id  like  ? and mm.facility_id like ?    AND  UPPER(st.store_code)  LIKE UPPER(?)  AND  UPPER(mm.short_desc) LIKE	 UPPER(?) AND   mm.store_code=st.store_code AND st.store_code IN (SELECT STORE_CODE FROM st_user_access_for_store where user_id = '" +user_name+"' "+ ")  ORDER BY 2";//MODIFIED FOR MOHE-CRF-0084.1
		}else if (strFacilityParam == "N"){
			argumentArray[0] = "SELECT st.store_code code,  mm.short_desc  description FROM  mm_store_lang_vw  mm, st_store st    WHERE  mm.eff_status ='E'  AND  language_id  like  ? and mm.facility_id like ?    AND  UPPER(st.store_code)  LIKE UPPER(?)  AND  UPPER(mm.short_desc) LIKE	 UPPER(?) AND   mm.store_code=st.store_code  ORDER BY 2";//MODIFIED FOR MOHE-CRF-0084.1
		}
		
	}//end 
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";//modified for MOHE-CRF-0084.1
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
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
async function searchCodeATCClassification(obj, a, b, c, d, e) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	if (document.formConsumptionReportQueryCriteria.p_report_idS.value == "ATCS1") {
		argumentArray[0] = a;
		argumentArray[1] = dataNameArray;
		argumentArray[2] = dataValueArray;
		argumentArray[3] = dataTypeArray;
		dataNameArray[0] = "language_id";
		dataValueArray[0] = document.forms[0].p_language_id.value;
		dataTypeArray[0] = STRING;
		argumentArray[4] = "2,3";
		argumentArray[5] = obj.value;
		argumentArray[6] = CODE_LINK;
		argumentArray[7] = CODE_DESC;
		returnedValues = await CommonLookup(getLabel("Common.ATCClassification.label", "Common") + "#1", argumentArray);
		if ((returnedValues != null) && (returnedValues != "")) {
			obj.value = returnedValues[0];
		}
	} else {
		if (document.formConsumptionReportQueryCriteria.p_report_idS.value == "ATCS2") {
			argumentArray[0] = b;
			argumentArray[1] = dataNameArray;
			argumentArray[2] = dataValueArray;
			argumentArray[3] = dataTypeArray;
			dataNameArray[0] = "language_id";
			dataValueArray[0] = document.forms[0].p_language_id.value;
			dataTypeArray[0] = STRING;
			argumentArray[4] = "2,3";
			argumentArray[5] = obj.value;
			argumentArray[6] = CODE_LINK;
			argumentArray[7] = CODE_DESC;
			returnedValues = await CommonLookup(getLabel("Common.ATCClassification.label", "Common") + "#2", argumentArray);
			if ((returnedValues != null) && (returnedValues != "")) {
				obj.value = returnedValues[0];
			}
		} else {
			if (document.formConsumptionReportQueryCriteria.p_report_idS.value == "ATCS3") {
				argumentArray[0] = c;
				argumentArray[1] = dataNameArray;
				argumentArray[2] = dataValueArray;
				argumentArray[3] = dataTypeArray;
				dataNameArray[0] = "language_id";
				dataValueArray[0] = document.forms[0].p_language_id.value;
				dataTypeArray[0] = STRING;
				argumentArray[4] = "2,3";
				argumentArray[5] = obj.value;
				argumentArray[6] = CODE_LINK;
				argumentArray[7] = CODE_DESC;
				returnedValues = await CommonLookup(getLabel("Common.ATCClassification.label", "Common") + "#3", argumentArray);
				if ((returnedValues != null) && (returnedValues != "")) {
					obj.value = returnedValues[0];
				}
			} else {
				if (document.formConsumptionReportQueryCriteria.p_report_idS.value == "ATCS4") {
					argumentArray[0] = d;
					argumentArray[1] = dataNameArray;
					argumentArray[2] = dataValueArray;
					argumentArray[3] = dataTypeArray;
					dataNameArray[0] = "language_id";
					dataValueArray[0] = document.forms[0].p_language_id.value;
					dataTypeArray[0] = STRING;
					argumentArray[4] = "2,3";
					argumentArray[5] = obj.value;
					argumentArray[6] = CODE_LINK;
					argumentArray[7] = CODE_DESC;
					returnedValues = await CommonLookup(getLabel("Common.ATCClassification.label", "Common") + "#4", argumentArray);
					if ((returnedValues != null) && (returnedValues != "")) {
						obj.value = returnedValues[0];
					}
				} else {
					if (document.formConsumptionReportQueryCriteria.p_report_idS.value == "ATCS5") {
						argumentArray[0] = e;
						argumentArray[1] = dataNameArray;
						argumentArray[2] = dataValueArray;
						argumentArray[3] = dataTypeArray;
						dataNameArray[0] = "language_id";
						dataValueArray[0] = document.forms[0].p_language_id.value;
						dataTypeArray[0] = STRING;
						argumentArray[4] = "2,3";
						argumentArray[5] = obj.value;
						argumentArray[6] = CODE_LINK;
						argumentArray[7] = CODE_DESC;
						returnedValues = await CommonLookup(getLabel("Common.ATCClassification.label", "Common") + "#5", argumentArray);
						if ((returnedValues != null) && (returnedValues != "")) {
							obj.value = returnedValues[0];
						}
					}
				}
			}
		}
	}
}
/*function searchAlphaCode( obj) {
	var result		=	false ;
	var message		=	"" ;
	var flag		=	"" ;
	var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	argumentArray[0] = document.getElementById("SQL_ST_ALPHA_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup( "Alpha", argumentArray );
if((returnedValues != null) && (returnedValues != "") )  {
	obj.value = returnedValues[0];
	} 
}
*/
function CheckForSpecialChars(event) {
	var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) {
		return false;
	}  // Not a valid key
//if( (event.keyCode >= 97) && (event.keyCode <= 122) )
//	return (event.keyCode -= 32);
	return true;
}
function CheckMonth1(p_fr_month) {
	/*	  if(parseInt(p_fr_month.value) > 12 || parseInt(p_fr_month.value) < 1 )
		{
		//messageFrame.location.href="../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("MONTH_BET_1_12");
		alert(getMessage("MONTH_BET_1_12"));
		p_fr_month.select();
		p_fr_month.focus();
		}*/
}
function CheckMonth2(p_to_month) {
	/*	  if(parseInt(p_to_month.value) > 12 || parseInt(p_to_month.value) < 1 )
		{
		//messageFrame.location.href="../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("MONTH_BET_1_12");
		alert(getMessage("MONTH_BET_1_12"));
		p_to_month.select();
		p_to_month.focus();
		}*/
}
/*function CheckMonth1()
{
	
//alert(flag +""+ flag2 +""+ flag3 +"" + flag4);
		formObj=parent.frames[1].frames[1].document.forms[0];

	  if(parseInt(formObj.p_fr_month.value) > 12 || parseInt(formObj.p_fr_month.value) < 1 )
		{
messageFrame.location.href="../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("MONTH_BET_1_12");
	   flag5=false;
	   //alert("flag2" + flag2);
		formObj.p_fr_month.select();
		formObj.p_fr_month.focus();
		}
}
		
function CheckMonth2()
{
	formObj=parent.frames[1].frames[1].document.forms[0];

	  if(parseInt(formObj.p_to_month.value) > 12 ||  parseInt(formObj.p_to_month.value) < 1)
		{
	   messageFrame.location.href="../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("MONTH_BET_1_12");
	   flag5=false;
		formObj.p_to_month.select();
		formObj.p_to_month.focus();
	}
		
	}
*/
function ChkYear(yr) {
	/*	if(yr.value.length != 4)
	{
		alert(getMessage("INVALID_YR_FORMAT"));
		yr.select();
		yr.focus();
	}*/
}
function CheckYear() {
	formObj = parent.frames[1].frames[1].document.forms[0];
	if (formObj.p_to_year.value.length != 4) {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + getMessage("INVALID_YR_FORMAT", "SM");
		flag4 = false;
	} else {
		flag4 = true;
	}
}
function setReportSubType() {
	var formObject = document.formConsumptionReportQueryCriteria;
	if (formObject.p_report_idS.value == "STBCONS1") {
		document.getElementById("p_top_style").style.visibility = "visible";
		document.getElementById("p_count").style.visibility = "visible";
		document.getElementById("p_count_style").style.visibility = "visible";
		document.getElementById("p_item_style").style.visibility = "visible";
	} else {
		document.getElementById("p_top_style").style.visibility = "hidden";
		document.getElementById("p_count").style.visibility = "hidden";
		document.getElementById("p_count_style").style.visibility = "hidden";
		document.getElementById("p_item_style").style.visibility = "hidden";
	}
}
function checkDateMonYear() {
	formObj = parent.frames[1].frames[1].document.forms[0];
	var sysMonth = formObj.sysdate.value;
	var sysDateArray = sysMonth.split("/");
	var rMonth = sysDateArray[1];
	if (parseInt(formObj.p_to_year.value) > parseInt(formObj.curr_proc_year.value)) {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + getMessage("MONTH_YEAR_INVALID", "SM");
		flag2 = false;
	} else {
		if ((parseInt(formObj.p_to_month.value) > parseInt(formObj.curr_proc_month.value)) && (parseInt(formObj.p_to_year.value) >= parseInt(formObj.curr_proc_year.value))) {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + getMessage("DATE_NOT_GREATER_SYSDATE", "ST");
			flag2 = false;
		} else {
			flag2 = true;
		}
	}
}
function chkDateRun() {
	formObj = parent.frames[1].frames[1].document.forms[0];
	if (parseInt(formObj.p_to_year.value) < parseInt(formObj.p_fr_year.value)) {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + getMessage("FM_DATE_GR_TO_DATE");
		flag3 = false;
	} else {
		if ((parseInt(formObj.p_to_month.value) < parseInt(formObj.p_fr_month.value)) && (parseInt(formObj.p_to_year.value) <= parseInt(formObj.p_fr_year.value))) {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + getMessage("FM_DATE_GR_TO_DATE");
			flag3 = false;
		} else {
			flag3 = true;
		}
	}
}
function chkFromDate() {
	formObj = parent.frames[1].frames[1].document.forms[0];
	if ((formObj.p_fr_year.value.length) != 4 || (formObj.p_fr_month.value.length) < 1) {
		flag5 = false;
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + getMessage("FROM_DATE_CANNOT_BE_BLANK", "SM");
	} else {
		flag5 = true;
	}
}
function run() {
	formVal = frames[1].document.forms[0];
	flag = false;
	if (f_query_add_mod.document.formConsumptionReportQueryCriteria) {
		if ((f_query_add_mod.document.formConsumptionReportQueryCriteria.p_report.value == "C") || (f_query_add_mod.document.formConsumptionReportQueryCriteria.p_report.value == "ATC")) {
			if (!checkMonYear()) {
				return;
			}
		}
		if (isValidFromToField(formVal.p_fm_store_code, formVal.p_to_store_code, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)) {
			if (isValidFromToField(formVal.p_fm_item_code, formVal.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
				if (isValidFromToField(formVal.p_fm_item_class, formVal.p_to_item_class, STRING, getLabel("Common.ItemClass.label", "Common"), messageFrame)) {
					if (isValidFromToField(formVal.p_fr_alp_code, formVal.p_to_alp_code, STRING, getLabel("Common.AlphaCode.label", "Common"), messageFrame)) {
						if (isValidFromToField(formVal.p_fm_atc_class_lev, formVal.p_to_atc_class_lev, STRING, getLabel("Common.ATCClassification.label", "Common"), messageFrame)) {
							flag = true;
						}
					}
				}
			}
		}
	}
	if (flag && flag2 && flag3 && flag4 && flag5) {
		frames[1].document.forms[0].submit();
	}
}
function checkMonYear() {
	formObj = frames[1].document.forms[0];
	var p_fm_year = formObj.p_fr_year.value;
	var p_to_year = formObj.p_to_year.value;
	var p_fm_month = formObj.p_fr_month.value;
	var p_to_month = formObj.p_to_month.value;
	var sysDate = formObj.sysdate.value;
	var sysDateArray = sysDate.split("/");
	var curr_proc_year = sysDateArray[2];//formObj.curr_proc_year.value;
	var curr_proc_month = sysDateArray[1];//formObj.curr_proc_month.value;
	var fromPeriod = parseFloat(formatNumber(p_fm_year, 4) + formatNumber(p_fm_month, 2));
	var toPeriod = parseFloat(formatNumber(p_to_year, 4) + formatNumber(p_to_month, 2));
	var currPeriod = parseFloat(formatNumber(curr_proc_year, 4) + formatNumber(curr_proc_month, 2));
	if ((formObj.p_fr_year.value.length != 4) || (formObj.p_to_year.value.length != 4)) {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("INVALID_PERIOD_MONTH_YEAR", "ST");
		return false;
	} else {
		if ((formObj.p_fr_month.value > 12) || (formObj.p_to_month.value > 12) || (formObj.p_fr_month.value < 1) || (formObj.p_to_month.value < 1)) {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("INVALID_PERIOD_MONTH_YEAR", "ST");
			return false;
		} else {
			if (fromPeriod > toPeriod) {
				var stMessage = getMessage("LESS_OR_EQUAL_VALIDATE", "ST");
				stMessage = stMessage.replace(/@/g, "Month/Year");
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + stMessage;
				return false;
			} else {
				if (toPeriod > currPeriod) {
					messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("DATE_NOT_GREATER_SYSDATE", "ST");
					return false;
				}
			}
		}
	}
	return true;
}
function getVal() {
	var optP_reportValue = document.formConsumptionReportQueryCriteria.p_report.value;
	var optP_report_idValue = document.formConsumptionReportQueryCriteria.p_report_idS.value;
	var optP_report_idS = document.formConsumptionReportQueryCriteria.p_report_id.value;
	var P_fromMonth = document.formConsumptionReportQueryCriteria.p_fr_month.value;
	var P_fromYear = document.formConsumptionReportQueryCriteria.p_fr_year.value;
	document.formConsumptionReportQueryCriteria.reset();
	document.formConsumptionReportQueryCriteria.p_report.value = optP_reportValue;
	document.formConsumptionReportQueryCriteria.p_report_idS.value = optP_report_idValue;
	document.formConsumptionReportQueryCriteria.p_fr_month.value = P_fromMonth;
	document.formConsumptionReportQueryCriteria.p_fr_year.value = P_fromYear;
	if (optP_report_idValue.substring(0, optP_report_idValue.length - 1) == "ATCS") {
		document.formConsumptionReportQueryCriteria.p_report_id.value = "STBATCIC";
	} else {
		document.formConsumptionReportQueryCriteria.p_report_id.value = optP_report_idValue;
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

// code added on 03/08/2004
function setReportType() {
	var formObject = document.formConsumptionReportQueryCriteria;
	if (formObject.p_report.value == "CD") {
		document.getElementById("consumption_period").style.visibility = "hidden";
		document.getElementById("p_fr_month_style").style.visibility = "hidden";
		document.getElementById("p_fr_year_style").style.visibility = "hidden";
		document.getElementById("p_to_month_style").style.visibility = "hidden";
		document.getElementById("p_to_year_style").style.visibility = "hidden";
		document.getElementById("report_option_style").style.visibility = "hidden";
		document.getElementById("p_1_style").style.visibility = "hidden";
		document.getElementById("divide1_style").style.visibility = "hidden";
		document.getElementById("divide2_style").style.visibility = "hidden";
		document.getElementById("image_style").style.visibility = "hidden";
	} else {
		document.getElementById("consumption_period").style.visibility = "visible";
		document.getElementById("p_fr_month_style").style.visibility = "visible";
		document.getElementById("p_fr_year_style").style.visibility = "visible";
		document.getElementById("p_to_month_style").style.visibility = "visible";
		document.getElementById("p_to_year_style").style.visibility = "visible";
		document.getElementById("report_option_style").style.visibility = "visible";
		document.getElementById("p_1_style").style.visibility = "visible";
		document.getElementById("divide1_style").style.visibility = "visible";
		document.getElementById("divide2_style").style.visibility = "visible";
		document.getElementById("image_style").style.visibility = "visible";
	}
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/ConsumptionReportValidate.jsp?bean_id=" + formObject.bean_id.value + "&bean_name=" + formObject.bean_name.value + "&report_type=" + formObject.p_report.value + "&function_type=1", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	formObject.p_report_idS.remove(0);
}
function showReportId() {
	if (document.formConsumptionReportQueryCriteria.p_report.value == "C") {
		document.formConsumptionReportQueryCriteria.p_report_id.value = "STBCONS1";
	}
	if (document.formConsumptionReportQueryCriteria.p_report.value == "CD") {
		document.formConsumptionReportQueryCriteria.p_report_id.value = "STBCNDST";
	}
	if (document.formConsumptionReportQueryCriteria.p_report.value == "ATC") {
		document.formConsumptionReportQueryCriteria.p_report_id.value = "STBATCIC";
	}
}
function setATCType() {
	var formObject = document.formConsumptionReportQueryCriteria;
	if ((formObject.p_report.value == "CD") || (formObject.p_report.value == "C")) {
		document.getElementById("patcclass").style.visibility = "hidden";
		document.getElementById("p_fm_atc_class_lev_style").style.visibility = "hidden";
		document.getElementById("p_to_atc_class_lev_style").style.visibility = "hidden";
		document.getElementById("p_fr_sr_style").style.visibility = "hidden";
		document.getElementById("p_to_sr_style").style.visibility = "hidden";
	} else {
		document.getElementById("patcclass").style.visibility = "visible";
		document.getElementById("p_fm_atc_class_lev_style").style.visibility = "visible";
		document.getElementById("p_to_atc_class_lev_style").style.visibility = "visible";
		document.getElementById("p_fr_sr_style").style.visibility = "visible";
		document.getElementById("p_to_sr_style").style.visibility = "visible";
	}
	var optP_reportValue = document.formConsumptionReportQueryCriteria.p_report.value;
	document.formConsumptionReportQueryCriteria.reset();
	document.formConsumptionReportQueryCriteria.p_report.value = optP_reportValue;
}
function setItemStore() {
	var formObject = document.formConsumptionReportQueryCriteria;
	if (formObject.p_report.value == "ATC") {
		document.getElementById("p_item_store_style").style.visibility = "visible";
	} else {
		document.getElementById("p_item_store_style").style.visibility = "hidden";
	}
}
function setHideTop() {
	var formObject = document.formConsumptionReportQueryCriteria;
	if (formObject.p_report.value == "C") {
		document.getElementById("p_top_style").style.visibility = "visible";
		document.getElementById("p_count").style.visibility = "visible";
		document.getElementById("p_count_style").style.visibility = "visible";
		document.getElementById("p_item_style").style.visibility = "visible";
	} else {
		document.getElementById("p_top_style").style.visibility = "hidden";
		document.getElementById("p_count").style.visibility = "hidden";
		document.getElementById("p_count_style").style.visibility = "hidden";
		document.getElementById("p_item_style").style.visibility = "hidden";
	}
}
function getItem() {
	document.formConsumptionReportQueryCriteria.p_report_id.value = "STBCONS1";
}
function changeReport() {
	var formObject = document.formConsumptionReportQueryCriteria;
	if (document.formConsumptionReportQueryCriteria.p_count.value !== "") {
		formObject.p_report_id.value = "STBCONS6";
	}
	if (document.formConsumptionReportQueryCriteria.p_count.value == "") {
		formObject.p_report_id.value = "STBCONS1";
	}
}
function hideOrderBy() {
	var formObject = document.formConsumptionReportQueryCriteria;
	if (formObject.p_report.value == "C") {
		document.getElementById("p_order_by_style").style.visibility = "visible";
	} else {
		document.getElementById("p_order_by_style").style.visibility = "hidden";
	}
}
function setOrderByType() {
	var formObject = document.formConsumptionReportQueryCriteria;
	if (formObject.p_report_idS.value == "STBCONS1") {
		document.getElementById("p_order_by_style").style.visibility = "visible";
	} else {
		document.getElementById("p_order_by_style").style.visibility = "hidden";
	}
}

