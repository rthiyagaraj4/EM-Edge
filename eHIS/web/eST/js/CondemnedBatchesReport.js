/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
12/10/2020		IN073850	  	   Shazana										MOHE-SCF-0034
28/7/2021		TFS21715	  	   Shazana										MOHE-SCF-0034.1
---------------------------------------------------------------------------------------------------------------
*/
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
var formObj = "";
function reset() {
	formObj = f_query_add_mod.document.formCondemnedBatchesReport;
	formObj.reset();
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
	argumentArray[0] = "SELECT ST.ITEM_CODE CODE, MM.SHORT_DESC DESCRIPTION FROM MM_ITEM_LANG_VW  MM, ST_ITEM ST WHERE ST.ITEM_CODE = MM.ITEM_CODE AND MM.EFF_STATUS = 'E' AND MM.LANGUAGE_ID LIKE  ? AND ST .ITEM_CODE LIKE UPPER(?) AND UPPER(MM.SHORT_DESC) LIKE UPPER(?) ORDER BY 2";//21715
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		var arr=unescape(returnedValues);
			 arr=arr.split(",");
			 obj.value = arr[0];
		//obj.value = returnedValues[0];
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
	argumentArray[0] = "SELECT     st.store_code code,  mm.short_desc  description     FROM  mm_store_lang_vw      mm, st_store st , st_acc_entity_param  WHERE    mm.eff_status ='E'  AND  language_id  like  ?   AND  mm.facility_id    LIKE decode(TRN_ACROSS_FACILITY_YN, 'Y',mm.facility_id,? )   	 	  AND    UPPER(st.store_code)    LIKE	      UPPER(?)  AND  UPPER(mm.short_desc)   LIKE	    UPPER(?)    AND      mm.store_code=st.store_code  ORDER BY 2 ";//MODIFIED FOR IN073850
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	
	if ((returnedValues != null) && (returnedValues != "")) {
		var arr=unescape(returnedValues);
			arr=arr.split(",");
			obj.value = arr[0];
		//obj.value = returnedValues[0];
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
	argumentArray[0] = "SELECT ITEM_CLASS_CODE CODE,SHORT_DESC DESCRIPTION FROM MM_ITEM_CLASS_LANG_VW MM_ITEM_CLASS WHERE EFF_STATUS='E' AND UPPER(ITEM_CLASS_CODE) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?) AND LANGUAGE_ID= '"+ document.forms[0].p_language_id.value + "'";//MODIFIED FOR 21715
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.ItemClass.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		var arr=unescape(returnedValues);
		 arr=arr.split(",");
		 obj.value = arr[0];
		//obj.value = returnedValues[0];
	}
}
function CheckForSpecialChars(event) {
	var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) {
		return false;
	}  // Not a valid key
//	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	//	return (event.keyCode -= 32);
	return true;
}
function CheckforNumber() {
	if ((event.keyCode >= 48) && (event.keyCode <= 57)) {
		return true;
	} else {
		//return event.keyCode = 0;
		return false;
	}
}
function setReport() {
	document.formCondemnedBatchesReport.p_report_id.value = document.formCondemnedBatchesReport.p_report_order.value;
}
function run() {
	formObj = f_query_add_mod.document.formCondemnedBatchesReport;
	formObj.p_report_id.value = formObj.p_report_order.value;
	if (f_query_add_mod.document.formCondemnedBatchesReport) {
		if (isValidFromToField(formObj.p_fm_store_code, formObj.p_to_store_code, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)) {
			if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
				if (isValidFromToField(formObj.p_fm_item_class, formObj.p_to_item_class, STRING, getLabel("Common.ItemClass.label", "Common"), messageFrame)) {
					if (isValidFromToField(formObj.p_fm_batch_id, formObj.p_to_batch_id, STRING,getLabel("Common.BatchID.label", "Common"), messageFrame)) {
						if (doDateCheck(formObj.dt_from, formObj.dt_to, messageFrame)) {
							formObj.action="../../eCommon/jsp/report_options.jsp";
							formObj.target="messageFrame";
							formObj.submit();
						}
					}
				}
			}
		}
	}
}

async function searchRemarks(objCode, objDesc) {
	objCode_value = "";
	objDesc_value = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.formCondemnedBatchesReport.p_language_id.value;
	dataTypeArray[0] = STRING;
	dataNameArray[1] = "module_id";
	dataValueArray[1] = "ST";
	dataTypeArray[1] = STRING;
	argumentArray[0] = "SELECT DISTINCT MM.TRN_REMARKS_CODE CODE, MM.REMARKS_DESC DESCRIPTION FROM MM_TRN_REMARKS_LANG_VW MM, ST_TRN_TYPE_FOR_REMARKS ST WHERE ST.EFF_STATUS = 'E' AND ST.TRN_REMARKS_CODE = MM.TRN_REMARKS_CODE AND UPPER (MM.LANGUAGE_ID) LIKE UPPER (?) AND UPPER (MM.MODULE_ID) LIKE UPPER (?) AND ST.TRN_TYPE='CEB' AND MM.TRN_REMARKS_CODE LIKE UPPER (?) AND UPPER (MM.REMARKS_DESC) LIKE UPPER (?)";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	retVal = await CommonLookup(getLabel("Common.remarks.label", "Common"), argumentArray);
	var ret1=unescape(retVal);
							var arr=ret1.split(",");
							if(arr[1]==undefined) 
							{
								arr[0]="";	
								arr[1]="";	
							}				
	if ((retVal != null) && (retVal != "")) {
		objCode.value = arr[0];
		objDesc.value = arr[1];
	}
}
