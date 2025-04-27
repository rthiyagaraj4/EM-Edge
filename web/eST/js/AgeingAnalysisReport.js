/*
-------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		 	Edit history        Name			       Rev.Date		     Rev.Nam			     Description
-------------------------------------------------------------------------------------------------------------------------------------------------------------
10/10/2017							Shazana hasan							        				ML-MMOH-CRF-0917(Added 'From Store' and 'To Store')

--------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

function reset() {
	formObj = f_query_add_mod.document.formAgeingAnalysisReportCriteria;
	formObj.reset();
}
async function searchCodeItem(obj) {
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
	argumentArray[5] = obj.value.toUpperCase();
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		obj.value = arr[0];
	}
}
async function searchCodeItemClass(obj) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	argumentArray[0] = document.getElementById("SQL_ST_ITEM_CLASS_LOOKUP_LANG").value + "'" + document.forms[0].p_language_id.value + "'";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value.toUpperCase();
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.ItemClass.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		obj.value = arr[0];
	}
}
function isSlotAscending(formObj) {
	if (getNumber(formObj.p_slot_1) > getNumber(formObj.p_slot_2) || getNumber(formObj.p_slot_2) > getNumber(formObj.p_slot_3) || getNumber(formObj.p_slot_3) > getNumber(formObj.p_slot_4)) {
		alert(getMessage("INVALID_SLOT_VALUE", "ST"));
		return false;
	}
	return true;
}
function getNumber(Obj) {
	if (Obj.value == null || Obj.value == "") {
		return 0;
	}
	return parseFloat(Obj.value);
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
	formObj = f_query_add_mod.document.formAgeingAnalysisReportCriteria;
	if(formObj.fr_st_code.value==""){//Adding start for ML-MMOH-CRF-0917
		formObj.p_fr_st_code.value="";
	}
	if(formObj.to_st_code.value==""){
		formObj.p_to_st_code.value="";
	}//Adding end for ML-MMOH-CRF-0917
	if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING,getLabel("Common.ItemCode.label", "Common") , messageFrame)) {
		if (isValidFromToField(formObj.p_fm_item_class_code, formObj.p_to_item_class_code, STRING, getLabel("Common.ItemClass.label", "Common"), messageFrame)) {
			if (isValidFromToField(formObj.p_fm_alpha_code, formObj.p_to_alpha_code, STRING, getLabel("Common.AlphaCode.label", "Common"), messageFrame)) {
				//Added by Shazana for ML-MMOH-CRF-0917 START
					if (isValidFromToField(formObj.p_fr_st_code, formObj.p_to_st_code, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)){
						
						if (isSlotAscending(formObj)) {
							formObj.action="../../eCommon/jsp/report_options.jsp";
							formObj.target="messageFrame";
							formObj.submit();
						}
					}	
			}
		}
	}
}

// Added by Shazana for ML-MMOH-CRF-0917 START
async function searchCodeStore(obj,mode) {
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
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		obj.value = arr[0];
		if(mode=="F")
			document.forms[0].p_fr_st_code.value=arr[0];
		else
			document.forms[0].p_to_st_code.value=arr[0]; 
	}
} 

//Added by Shazana for ML-MMOH-CRF-0917 END
