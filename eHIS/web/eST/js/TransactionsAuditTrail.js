/*
--------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------------------
15/07/2021	TFS:21516		Shazana										MOHE-CRF-0084.1-US014
--------------------------------------------------------------------------------------------------------------------
*/ 
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
var formObj = "";
function reset() {
	formObj = f_query_add_mod.document.TransactionsAuditTrailCriteria;
	formObj.reset();
//	parent.frames[1].frames[1].document.forms[0].reset();
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
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
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
	returnedValues = await CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		obj.value = arr[0];
	}
}
//MOHE-CRF-0084.1
async function searchCodeStore1(obj) {
	var user_name =  document.forms[0].p_user_name.value; 
	var strFacilityParam =document.forms[0].p_strFacilityParam.value; //MOHE-CRF-0084.1 
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
	if(strFacilityParam == "Y"){//MOHE-CRF-0084.1 START
		argumentArray[0] = "SELECT st.store_code code, mm.short_desc  description  FROM  mm_store_lang_vw mm, st_store st , st_acc_entity_param  WHERE  mm.eff_status ='E'  AND  language_id  like  ?   AND  mm.facility_id    LIKE ?  AND  UPPER(st.store_code)   LIKE UPPER(?)  AND  UPPER(mm.short_desc)   LIKE  UPPER(?)    AND  mm.store_code=st.store_code  AND st.store_code IN (SELECT STORE_CODE FROM st_user_access_for_store where user_id = '" +user_name+"' "+ ")  ORDER BY 2";
	}
	else if (strFacilityParam == "N"){
		argumentArray[0] = "SELECT st.store_code code, mm.short_desc  description  FROM  mm_store_lang_vw mm, st_store st , st_acc_entity_param  WHERE  mm.eff_status ='E'  AND  language_id  like  ?   AND  mm.facility_id    LIKE ?  AND  UPPER(st.store_code)   LIKE UPPER(?)  AND  UPPER(mm.short_desc)   LIKE  UPPER(?)    AND  mm.store_code=st.store_code  ORDER BY 2";
	}//END 
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
function run() {
	formObj = f_query_add_mod.document.TransactionsAuditTrailCriteria;
	if (f_query_add_mod.document.TransactionsAuditTrailCriteria) {
		if (isValidFromToField(formObj.p_fr_str_code, formObj.p_to_str_code, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)) {
			if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
				if (isValidFromToField(formObj.p_fr_item_class, formObj.p_to_item_class, STRING, getLabel("Common.ItemClass.label", "Common"), messageFrame)) {
					if (isValidFromToField(formObj.p_fr_alpa_code, formObj.p_to_alpa_code, STRING, getLabel("Common.AlphaCode.label", "Common"), messageFrame)) {
						if (isValidFromToField(formObj.p_fr_doc_ref, formObj.p_to_doc_ref, STRING, getLabel("Common.DocRef.label", "Common"), messageFrame)) {
							if (doDateCheck(formObj.dt_from, formObj.dt_to, messageFrame)) {
								formObj.dt_from.value = convertDate(formObj.dt_from_1.value, "DMY", formObj.p_language_id.value, "en");
							}
						}
					}
				}
			}
		}
		formObj.dt_to.value = convertDate(formObj.dt_to_1.value, "DMY", formObj.p_language_id.value, "en");
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    	f_query_add_mod.document.forms[0].target="messageFrame"
		formObj.submit();
	}
}
function changeReport() {
	
	if (document.TransactionsAuditTrailCriteria.p_order_by.value == "1" || document.TransactionsAuditTrailCriteria.p_order_by.value == "3") {
		document.TransactionsAuditTrailCriteria.p_report_id.value = "STBTXAU1";
	}
	if (document.TransactionsAuditTrailCriteria.p_order_by.value == "2") {
		document.TransactionsAuditTrailCriteria.p_report_id.value = "STBTXAU2";
	}
	
}

/* @Name - Priya
 * @Date - 06/07/2010
 * @Inc# - 21344 (AK-CRF-0016)
 * @Desc - function 'setReportOrder' is to generate report order options based on the selected transaction type 
*/
function setReportOrder(){
   var trn_type = document.forms[0].p_tran_type.value;
   if(trn_type == 'ISS' || trn_type == 'URG' || trn_type == 'RET' || trn_type == 'TFR' || trn_type==""){
		document.forms[0].p_order_by.options.length = 3;
		document.forms[0].p_order_by.options[0].value = '1';
		document.forms[0].p_order_by.options[0].text = getLabel("eST.ByItem.label", "ST");
		document.forms[0].p_order_by.options[1].value = '2';
		document.forms[0].p_order_by.options[1].text = getLabel("eST.ByDocumentDate.label", "ST");
		document.forms[0].p_order_by.options[2].value = '3';
		document.forms[0].p_order_by.options[2].text = getLabel("eST.ByOtherStore.label", "ST");
				
   }else{
		document.forms[0].p_order_by.options.length = 2;
		document.forms[0].p_order_by.options[0].value = '1';
		document.forms[0].p_order_by.options[0].text = getLabel("eST.ByItem.label", "ST");
		document.forms[0].p_order_by.options[1].value = '2';
		document.forms[0].p_order_by.options[1].text = getLabel("eST.ByDocumentDate.label", "ST");
   }
}
//Added by Sakti against KDAH-SCF-0247
function setvals() {
	formObj = document.TransactionsAuditTrailCriteria;
	
	if(formObj.p_exclude_internal_adjustment_yn.checked){
		formObj.p_exclude_internal_adj_yn.value='Y';
	}else{
		formObj.p_exclude_internal_adj_yn.value='N';
	}

}//Added ends
