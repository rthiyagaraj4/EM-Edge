 
async function searchStoreCode(objCode, objDesc) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var sql_1 = document.getElementById("SQL_PH_ST_STORE_LOOKUP_LANG").value + "  AND mm.language_id='" + document.forms[0].p_language_id.value +"' and  uas.user_id='" + document.forms[0].p_user_name.value +  "' ORDER BY 2 ";
	dataNameArray[0] = "facility_id";
	dataValueArray[0] = document.forms[0].p_facility_id.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] = unescape(sql_1);
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = objDesc.value;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ; 
	returnedValues =await CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	var str =unescape(returnedValues);
	var arr = str.split(",");
	if ((returnedValues != null) && (returnedValues != "")) {
		objCode.value = arr[0];
		objDesc.value = arr[1];
	}
	else{
		objCode.value ="";
		objDesc.value = "";
	}
}

async function searchItemCode(objCode, objDesc) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.forms[0].p_language_id.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] = document.getElementById("SQL_PH_ST_ITEM_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = objDesc.value.toUpperCase();
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ; 
	returnedValues =await CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	var str =unescape(returnedValues);
	var arr = str.split(",");
	if ((returnedValues != null) && (returnedValues != "")) {
		objCode.value = arr[0];
		objDesc.value = arr[1];
	}
	else{
		objCode.value = "";
		objDesc.value = "";
	}
}

function reset(){
	f_query_add_mod.location.href="../../ePH/jsp/QueryDrugPriceCriteria.jsp";
	f_price_detail.location.href="../../eCommon/html/blank.html";
}

function query(){
	f_query_add_mod.location.href="../../ePH/jsp/QueryDrugPriceCriteria.jsp";
	f_price_detail.location.href="../../eCommon/html/blank.html";
}

function goNext() {
	formObj =parent.f_price_detail.document.fromDrugPriceResult;
	criteriaFormObj =parent.f_query_add_mod.document.queryStockonHandCriteria_form;
	var	item_code_from = criteriaFormObj.p_fm_item_code.value;
	var item_code_to = criteriaFormObj.p_to_item_code.value;
	var store_code_from = criteriaFormObj.p_fr_st_code.value;
	var store_code_to = criteriaFormObj.p_to_st_code.value;
	if((parseInt(formObj.start) != undefined) || (parseInt(formObj.end) != undefined)){
		start = parseInt(formObj.start.value) + parseInt(formObj.displaySize.value);
		end = parseInt(formObj.end.value) + parseInt(formObj.displaySize.value);
		parent.f_price_detail.document.location.href = "../../ePH/jsp/QueryDrugPriceResult.jsp?from=" + start + "&to=" + end+"&item_code_from="+item_code_from+"&item_code_to="+item_code_to +"&store_code_from="+store_code_from+"&store_code_to="+store_code_to;
	}
}


function goPrev() {
	formObj =parent.f_price_detail.document.fromDrugPriceResult;
	criteriaFormObj =parent.f_query_add_mod.document.queryStockonHandCriteria_form;
	var	item_code_from = criteriaFormObj.p_fm_item_code.value;
	var item_code_to = criteriaFormObj.p_to_item_code.value;
	var store_code_from = criteriaFormObj.p_fr_st_code.value;
	var store_code_to = criteriaFormObj.p_to_st_code.value;
	if((parseInt(formObj.start) != undefined) || (parseInt(formObj.end) != undefined)){
		start = parseInt(formObj.start.value) - parseInt(formObj.displaySize.value);
		end = parseInt(formObj.end.value) - parseInt(formObj.displaySize.value);
		parent.f_price_detail.location.href = "../../ePH/jsp/QueryDrugPriceResult.jsp?from=" + start + "&to=" + end+"&item_code_from="+item_code_from+"&item_code_to="+item_code_to +"&store_code_from="+store_code_from+"&store_code_to="+store_code_to;
	}
}

function activeLink() {
	var	formObjResult =parent.f_price_detail.document.fromDrugPriceResult;
	if (formObjResult != null || formObjResult != undefined) {
		if ((parseInt(formObjResult.start) != undefined) && parseInt(formObjResult.start.value) != 0) {
			formObjResult.document.getElementById("lblPrev").style.display = 'inline';
		}
		else {
			formObjResult.document.getElementById("lblPrev").style.display = 'none';
		}
		if ((parseInt(formObjResult.start) != undefined) && !((parseInt(formObjResult.start.value) + parseInt(formObjResult.displaySize.value)) >= formObjResult.totalRecords.value)) {
			formObjResult.document.getElementById("lblNext").style.display = 'inline';
		} 
		else {
			formObjResult.document.getElementById("lblNext").style.display = 'none';
		}
	}
}

function isValidFromToField(fromObj, toObj, dataType, stLegend, messageFrame, errorPage) {
	var bReturn = true;
	var stFromValue = fromObj;
	var stToValue = toObj;
	if ((!trimCheck(stFromValue)) || (!trimCheck(stToValue))) {
		return bReturn;
	}
	if (dataType == null) {
		dataType = STRING;
	}
		if (stFromValue.toUpperCase() > stToValue.toUpperCase()) {
			bReturn = false;
		}
	
	
	if ((!bReturn) && (messageFrame != null)) {
		if (errorPage == null) {
			errorPa;ge = "../../eCommon/jsp/error.jsp";
		}
		var stMessage = getMessage("LESS_OR_EQUAL_VALIDATE", "ST");
		stMessage = stMessage.replace(/@/g, stLegend);
		messageFrame.location.href = errorPage + "?err_num=" + stMessage;
		toObj.focus();
	}
	return bReturn;
}

function searchVals() {
    errorPage = "../../eCommon/jsp/error.jsp";
    parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	var objform =parent.f_query_add_mod.document.queryStockonHandCriteria_form;	  
	var fields  = new Array() ;
	var names   = new Array() ;
	fields[0]   = objform.p_fm_item_code ;
	names[0]    = getLabel("Common.Drug.label", "Common")+' '+getLabel("Common.from.label", "Common") ;
	if(checkFields( fields, names, parent.messageFrame)){
		var	item_code_from = objform.p_fm_item_code.value;
		var item_code_to = objform.p_to_item_code.value;
		var store_code_from = objform.p_fr_st_code.value;
		var store_code_to = objform.p_to_st_code.value;
	
		if (isValidFromToField(item_code_from, item_code_to, STRING, getLabel("Common.item.label", "Common"), parent.messageFrame,errorPage)){ 
			if (isValidFromToField(store_code_from, store_code_to, STRING, getLabel("Common.Store.label", "Common"), parent.messageFrame,errorPage)){
				parent.f_price_detail.location.href = "../../ePH/jsp/QueryDrugPriceResult.jsp?item_code_from="+item_code_from+"&item_code_to="+item_code_to +"&store_code_from="+store_code_from+"&store_code_to="+store_code_to;
			}
		}
	}
}
