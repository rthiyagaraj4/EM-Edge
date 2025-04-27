
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
15/07/2014				43320					Abdul Rabbani	    		  		                       AMRI-CRF-100019
--------------------------------------------------------------------------------------------------------------------------------------------
*/
function load_f_criteria(var_L) {
	if (var_L == "yes") {
		document.FormPhyInvForSpecificItemAddingCriteria.temp_id.disabled = true;
		document.FormPhyInvForSpecificItemAddingCriteria.store_code.disabled = false;
		document.FormPhyInvForSpecificItemAddingCriteria.temp_disable.value = "create";
		document.FormPhyInvForSpecificItemAddingCriteria.store_code.value = "";
		document.FormPhyInvForSpecificItemAddingCriteria.store_code_1.value = "";
	} else {
		document.FormPhyInvForSpecificItemAddingCriteria.temp_id.disabled = false;
		document.FormPhyInvForSpecificItemAddingCriteria.temp_disable.value = "query";
		document.FormPhyInvForSpecificItemAddingCriteria.showItem.disabled = true;
		document.FormPhyInvForSpecificItemAddingCriteria.store_code.value = "";
		document.FormPhyInvForSpecificItemAddingCriteria.store_code_1.value = "";
	}
}
function create() { 
	createFrame.f_adding_criteria.document.location.href = "../../eST/jsp/PhyInvForSpecificItemAddingCriteria.jsp?disable_temp_id=yes&mode=" + MODE_INSERT + "&function_id=" + function_id;
	createFrame.f_adding_Remarks.document.location.href = "../../eST/jsp/PhyInvForSpecificItemAddingRemarks.jsp?show=no";
	onSuccess();
}
function reset() {
	//createFrame.location.reload();
	//onSuccess();
	if(createFrame.f_adding_criteria.document.FormPhyInvForSpecificItemAddingCriteria == undefined)
	return;
	
	if(createFrame.f_adding_criteria.document.FormPhyInvForSpecificItemAddingCriteria.disable_temp_id.value == "yes")
	create();
	else
	query();
}

function query() {
	onSuccess();
	createFrame.f_adding_criteria.location.href = "../../eST/jsp/PhyInvForSpecificItemAddingCriteria.jsp?disable_temp_id=no&mode=" + MODE_INSERT + "&function_id=" + function_id;
	createFrame.f_adding_Remarks.location.href = "../../eST/jsp/PhyInvForSpecificItemAddingRemarks.jsp?show=no";
}
async function searchItemCode(objCode) {
	if (document.FormPhyInvForSpecificItemAddingCriteria.store_code.value == "") {
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("STORE_CANNOT_BE_BLANK", "ST");
		return;
	}
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	/*dataNameArray[0] = "store_code";
	dataValueArray[0] = document.forms[0].store_code.value;
	dataTypeArray[0] = STRING;*/
	//var sql = "SELECT st.item_code code,\tmm.short_desc description   FROM mm_item_lang_vw mm, st_item st , st_item_store ststr   WHERE\t    mm.eff_status =\t'E'\tAND\t  upper(ststr.store_code) like upper(?)  AND st.item_code LIKE UPPER(?) AND UPPER(mm.short_desc)\t  LIKE UPPER(?)      AND    st.item_code = mm.item_code AND ststr.phy_inv_id IS NULL AND ststr.item_code = st.item_code AND mm.language_id='" + document.forms[0].language_id.value + "'";
	
	var sql = "SELECT DISTINCT ST.ITEM_CODE CODE, MM.SHORT_DESC DESCRIPTION FROM MM_ITEM_LANG_VW MM, ST_ITEM ST, ST_ITEM_STORE STSTR,ST_ITEM_TRN_DTL TRN WHERE STSTR.STOCK_ITEM_YN = 'Y' AND MM.EFF_STATUS = 'E' AND STSTR.STORE_CODE = '"+document.forms[0].store_code.value+"' AND ST.ITEM_CODE LIKE UPPER (?) AND UPPER (MM.SHORT_DESC) LIKE UPPER (?) AND ST.ITEM_CODE = MM.ITEM_CODE AND STSTR.PHY_INV_ID IS NULL AND STSTR.ITEM_CODE = ST.ITEM_CODE AND MM.LANGUAGE_ID = '" + document.forms[0].language_id.value + "'AND TRN.ITEM_CODE = STSTR.ITEM_CODE AND TRN.STORE_CODE = STSTR.STORE_CODE";
	
	//ADDED BY RABBANI #AMRI-CRF-100019(43320) ON 21-JULY-2014 starts
	if(document.forms[0].item_class_code.value != null && document.forms[0].item_class_code.value != "")
	{
	 sql = sql+ "  AND MM.ITEM_CLASS_CODE = '"+document.forms[0].item_class_code.value.toUpperCase()+"'"; 
	 document.forms[0].item_class_code1.value = document.forms[0].item_class_code.value;
	}
	//ends
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = objCode.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		if(arr[1]==undefined)
 		{
	 		arr[0]="";	
	 		arr[1]="";	
		document.forms[0].item_class_code.disabled = true;
		document.forms[0].item_class_lookup.disabled = true;
 		}
	else{
		objCode.value=arr[0];
	}
	/*if ((returnedValues != null) && (returnedValues != "")) {
		objCode.value = returnedValues[0];
		//ADDED BY RABBANI #AMRI-CRF-100019(43320) ON 21-JULY-2014 starts
		document.forms[0].item_class_code.disabled = true;
		document.forms[0].item_class_lookup.disabled = true;	
		//ends
	} */
}
function fun_submit() {
	var errorPage = "../../eCommon/jsp/error.jsp";
	if (document.FormPhyInvForSpecificItemAddingCriteria.item_codeF.value == "" || document.FormPhyInvForSpecificItemAddingCriteria.item_codeT.value == "") {
		parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("ST_ITEM_CODE_BLANK", "ST");
		return;
	}
	if (document.FormPhyInvForSpecificItemAddingCriteria.store_code.value == "") {
		parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("STORE_CANNOT_BE_BLANK", "ST");
		return;
	}
	document.FormPhyInvForSpecificItemAddingCriteria.store_code.disabled = true;
	document.FormPhyInvForSpecificItemAddingCriteria.store_code_1.value = document.FormPhyInvForSpecificItemAddingCriteria.store_code.value;
	
	document.FormPhyInvForSpecificItemAddingCriteria.item_class_code1.value = document.FormPhyInvForSpecificItemAddingCriteria.item_class_code.value;
	document.FormPhyInvForSpecificItemAddingCriteria.target = "f_added_value";
	document.FormPhyInvForSpecificItemAddingCriteria.action = "../../eST/jsp/PhyInvForSpecificItemAddedResult.jsp";
	var frm_obj = document.FormPhyInvForSpecificItemAddingCriteria;
	if (isValidFromToField(frm_obj.item_codeF, frm_obj.item_codeT, STRING, getLabel("Common.item.label", "Common"), parent.parent.messageFrame)) {
		document.FormPhyInvForSpecificItemAddingCriteria.submit();
		document.FormPhyInvForSpecificItemAddingCriteria.temp_disable.value = "create_extra";//to add more records in create mode without flushing off the old items...
		//ADDED BY RABBANI #AMRI-CRF-100019(43320) ON 21-JULY-2014 starts
		document.FormPhyInvForSpecificItemAddingCriteria.item_codeF.value = "";
		document.FormPhyInvForSpecificItemAddingCriteria.item_codeT.value = "";
		document.FormPhyInvForSpecificItemAddingCriteria.item_class_code.value = "";
		document.forms[0].item_class_code.disabled = false;
		document.forms[0].item_class_lookup.disabled = false;
		//ends
		
	}
}
async function apply() {
	var formObj = createFrame.f_adding_criteria.document.FormPhyInvForSpecificItemAddingCriteria;
	var formObj_Rem = createFrame.f_adding_Remarks.document.FormPhyInvForSpecificItemAddingRemarks;
	var formObj_dtl = createFrame.f_added_value.document.FormPhyInvForSpecificItemAddedValue;
	if( formObj_Rem==undefined){
	     messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
		}
	   if( formObj_dtl==undefined){
	   messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
		}
	 
	
	formObj.remarks.value = formObj_Rem.remarks.value;
	formObj.total_rec.value = formObj_dtl.total_rec.value;
	total_checkboxes = formObj_dtl.total_rec.value;
	var forInserting = "";
	var canProcess = 0;
	var noDetailExists = false;
	var errorPage = "../../eCommon/jsp/error.jsp";
	for (i = 0; i < total_checkboxes; i++) {
		if (eval("createFrame.f_added_value.document.FormPhyInvForSpecificItemAddedValue.chk_val_" + i + ".checked")) {
			forInserting += "Y,";
		} else {
			forInserting += "N,";
			canProcess++;
		}
	}
	if (total_checkboxes == canProcess) {
		noDetailExists = true;
	}
	if (noDetailExists) {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("MIN_ONE_DETAIL_REQUIRED", "Common");
		return;
	}
	forInserting = forInserting.substring(0, forInserting.length - 1);
	formObj.checkBoxVals.value = forInserting;
	if (formObj.finalize_allowed_yn.value == "Y") {
		var response = await confirmFinalize();
		if (response == YES) {
			formObj.finalized_yn.value = "Y";
		}
	}
	var resultText = formApply(formObj, ST_CONTROLLER);
	eval(resultText);
	if (flag != "") {
		if (formObj.finalized_yn.value == "Y") {
			messageFrame.location.href = errorPage + "?err_num=" + message + "<BR>" + getLabel("eST.PhyInventoryID.label", "ST") + ": " + flag;
		} else {
			messageFrame.location.href = errorPage + "?err_num=" + message + "<BR>" + getLabel("eST.TemporaryPhyInvID.label", "ST") + ": " + flag;
		}
	} else {
		messageFrame.location.href = errorPage + "?err_num=" + message;
	}
	if (result) {
		onSuccess();
		reset();
	}
}
function onSuccess() {
	createFrame.f_added_value.location.href = "../../eST/jsp/PhyInvForSpecificItemAddedResultClear.jsp";
	createFrame.f_added_value.location.href = "../../eCommon/html/blank.html";
}
function dis_detail(formObj) {
	parent.f_added_value.location.href = "../../eST/jsp/PhyInvForSpecificItemAddedResultClear.jsp";
	parent.f_added_value.location.href = "../../eCommon/html/blank.html";
	var temp_phy_id = formObj.temp_id.options[formObj.temp_id.options.selectedIndex].value;
	if (temp_phy_id != "") {
		document.FormPhyInvForSpecificItemAddingCriteria.showItem.disabled = false;
		document.FormPhyInvForSpecificItemAddingCriteria.store_code.disabled = true;
	} else {
		document.FormPhyInvForSpecificItemAddingCriteria.showItem.disabled = true;
		document.FormPhyInvForSpecificItemAddingCriteria.store_code.disabled = false;
	}
	parent.f_added_value.location.href = "../../eST/jsp/PhyInvForSpecificItemAddedResult.jsp?temp_id=" + temp_phy_id + "&temp_disable=query";
	document.FormPhyInvForSpecificItemAddingCriteria.temp_disable.value = "";
	parent.f_adding_Remarks.location.href = "../../eST/jsp/PhyInvForSpecificItemAddingRemarks.jsp?show=yes&temp_id=" + temp_phy_id;
}
async function searchRemarks(objCode, objDesc) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.FormPhyInvForSpecificItemAddingRemarks.lang_id.value;
	dataTypeArray[0] = STRING;
	dataNameArray[1] = "module_id";
	dataValueArray[1] = "ST";
	dataTypeArray[1] = STRING;
	dataNameArray[2] = "trn_type";
	dataValueArray[2] = document.FormPhyInvForSpecificItemAddingRemarks.rem_trans_type.value;
	dataTypeArray[2] = STRING;
	argumentArray[0] = document.FormPhyInvForSpecificItemAddingRemarks.SQL_ST_TRN_REMARKS_LOOKUP_SELECT.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "4,5";
	argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("eST.AuthorizeAtIssueStoreRemarks.label", "ST"), argumentArray);
	var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		if(arr[1]==undefined)
 		{
	 		arr[0]="";	
	 		arr[1]="";	
 		}
	else{
		objCode.value=arr[0];
		objDesc.value=arr[1];
	}
	/*if ((returnedValues != null) && (returnedValues != "")) {
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
	} */
}
//ADDED BY RABBANI #AMRI-CRF-100019(43320) ON 15-JULY-2014 starts
function searchCodeItemClass(obj) {
   if (document.FormPhyInvForSpecificItemAddingCriteria.store_code.value == "") {
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("STORE_CANNOT_BE_BLANK", "ST");
		return;
	}
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();  
    dataNameArray[0] = "store_code";
	dataValueArray[0] = document.forms[0].store_code.value;
	dataTypeArray[0] = STRING;
	dataNameArray[1] = "language_id";
	dataValueArray[1] = document.forms[0].language_id.value;
	dataTypeArray[1] = STRING;
	
	argumentArray[0] = document.forms[0].SQL_ST_ITEM_CLASS_LOOKUP_LANG_PHY.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.ItemClass.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}

function dis_item_class(obj){
if(document.FormPhyInvForSpecificItemAddingCriteria.item_class_store.value != document.FormPhyInvForSpecificItemAddingCriteria.store_code.value){
document.FormPhyInvForSpecificItemAddingCriteria.item_class_code.value = "";

}
document.FormPhyInvForSpecificItemAddingCriteria.item_class_store.value = document.FormPhyInvForSpecificItemAddingCriteria.store_code.value;
}
//ends

