/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
9/8/2021		TFS-22264			Shazana										MOHE-CRF-0084.1-US015
---------------------------------------------------------------------------------------------------------
*/
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
var formObj = "";
function reset() {
	formObj = f_query_add_mod.document.BatchesDueForExpiryCriteria;
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
	argumentArray[0] = "SELECT ST.ITEM_CODE CODE, MM.SHORT_DESC DESCRIPTION FROM MM_ITEM_LANG_VW  MM, ST_ITEM ST WHERE ST.ITEM_CODE = MM.ITEM_CODE AND MM.EFF_STATUS = 'E' AND MM.LANGUAGE_ID LIKE  ? AND ST .ITEM_CODE LIKE UPPER(?) AND UPPER(MM.SHORT_DESC) LIKE UPPER(?) ORDER BY 2";//modified for MOHE-CRF-0084.1 
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
	argumentArray[0] = "SELECT ITEM_CLASS_CODE CODE,SHORT_DESC DESCRIPTION FROM MM_ITEM_CLASS_LANG_VW MM_ITEM_CLASS WHERE EFF_STATUS='E' AND UPPER(ITEM_CLASS_CODE) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?) AND LANGUAGE_ID= " + "'" + document.forms[0].p_language_id.value + "'";//modified for MOHE-CRF-0084.1 
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
		if(arr[1]==undefined) 
		{
			arr[0]="";	
			arr[1]="";	
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
	argumentArray[0] = "SELECT     st.store_code code,  mm.short_desc  description     FROM  mm_store_lang_vw      mm, st_store st , st_acc_entity_param  WHERE    mm.eff_status ='E'  AND  language_id  like  ?   AND  mm.facility_id    LIKE decode(TRN_ACROSS_FACILITY_YN, 'Y',mm.facility_id,? )   	 	  AND    UPPER(st.store_code)    LIKE	      UPPER(?)  AND  UPPER(mm.short_desc)   LIKE	    UPPER(?)    AND      mm.store_code=st.store_code   ORDER BY 2";//modified for MOHE-CRF-0084.1 
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
		if(arr[1]==undefined) 
		{
			arr[0]="";	
			arr[1]="";	
		}
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = arr[0];
	}
}
//MOHE-CRF-0084.1
async function searchCodeStore1(obj) {
	 
	var user_name =   document.forms[0].p_user_name.value;
	var strFacilityParam = document.forms[0].p_strFacilityParam.value; //MOHE-CRF-0084.1
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
	/*dataNameArray[1] = "facility_id";//MOHE-CRF-0084.1-US015
	dataValueArray[1] = document.forms[0].p_facility_id.value;
	dataTypeArray[1] = STRING;*///commented for MOHE-CRF-0084.1-US015
	if(strFacilityParam == "Y"){//MOHE-CRF-0084.1 START
		argumentArray[0] = "SELECT     st.store_code code,  mm.short_desc  description     FROM  mm_store_lang_vw      mm, st_store st , st_acc_entity_param  WHERE    mm.eff_status ='E'  AND  language_id  like  ?   AND    UPPER(st.store_code)    LIKE	      UPPER(?)  AND  UPPER(mm.short_desc)   LIKE	    UPPER(?)    AND      mm.store_code=st.store_code AND st.store_code IN (SELECT STORE_CODE FROM st_user_access_for_store where user_id = '" +user_name+"' "+ ")  ORDER BY 2";//modified for MOHE-CRF-0084.1
	}else if (strFacilityParam == "N"){
		argumentArray[0] = "SELECT     st.store_code code,  mm.short_desc  description     FROM  mm_store_lang_vw      mm, st_store st , st_acc_entity_param  WHERE    mm.eff_status ='E'  AND  language_id  like  ?   AND    UPPER(st.store_code)    LIKE	      UPPER(?)  AND  UPPER(mm.short_desc)   LIKE	    UPPER(?)    AND      mm.store_code=st.store_code  ORDER BY 2";//modified for MOHE-CRF-0084.1
	}//END 
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";//modified for MOHE-CRF-0084.1-US015
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
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
function run() {
	if (f_query_add_mod.document.BatchesDueForExpiryCriteria) {
		formObj = f_query_add_mod.document.BatchesDueForExpiryCriteria;
		var fields = new Array(formObj.dt_from_1,formObj.dt_to_1);
		var names = new Array(getLabel("Common.from.label", "Common")+" "+getLabel("Common.CutOffDate.label", "Common"),getLabel("Common.to.label", "Common")+" "+getLabel("Common.CutOffDate.label", "Common"));
		var errorPage = "../../eCommon/jsp/error.jsp";
		var blankObject = null;
		blankObject = checkSTFields(fields, names, messageFrame, errorPage);
		if(blankObject){
			if (isValidFromToField(formObj.p_fm_str_code, formObj.p_to_str_code, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)) {
				if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
					if (isValidFromToField(formObj.p_fr_item_class, formObj.p_to_item_class, STRING, getLabel("Common.ItemClass.label", "Common"), messageFrame)) {
						if (isValidFromToField(formObj.p_fr_alp_code, formObj.p_to_alp_code, STRING,getLabel("Common.AlphaCode.label", "Common"), messageFrame)) {
							if (doDateCheck(formObj.dt_from_1, formObj.dt_to_1, messageFrame)) {
							//Added BY Rabbani #inc no:48586(SKR-SCF-0989) on 19-Jun-2014 Starts
							/*var plusdate = plusDate(formObj.dt_from_1.value, "DMY", formObj.p_language_id.value, 3, "M");
							var to_date           = formObj.dt_to_1.value.split("/");
		                    var  sysDateArray     = plusdate.split("/");
							var toDateObject      = new Date(to_date[2], (to_date[1] - 1), to_date[0]);
		                    var sysDateObject     = new Date(sysDateArray[2], (sysDateArray[1] - 1), sysDateArray[0]);
							if (Date.parse(toDateObject) > Date.parse(sysDateObject)) {
				             alert("APP-ST0217 Date Range Should Not Exceed Three Months ");
								formObj.dt_to_1.focus();
								return;
			                 }*/
							 //ends
								//Added by Sakti against TTM-SCF-0041 [IN:044423] 
								formObj.dt_from.value = convertDate(formObj.dt_from_1.value, "DMY", formObj.p_language_id.value, "en");
								formObj.dt_to.value = convertDate(formObj.dt_to_1.value, "DMY", formObj.p_language_id.value, "en");
								//Added ends
								f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
					    		f_query_add_mod.document.forms[0].target="messageFrame"; 
								formObj.submit();
							}
						}
					}
				}
			}
		}
	}
}

