/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------

7/6/2021				TFS-19789				Shazana													MOHE-CRF-0084.1 
--------------------------------------------------------------------------------------------------------------------------------------------
*/ 

var sort_by = "";
function reset() {
	f_query_add_mod.location.href = "../../eST/jsp/StockStatusByStoreFrameset.jsp";
}
function query() {
	f_query_add_mod.location.href = "../../eST/jsp/StockStatusByStoreFrameset.jsp";
}
async function searchStoreCode(objCode, objDesc, user, language_id) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = language_id;
	dataTypeArray[0] = STRING;
	dataNameArray[1] = "facility_id";
	dataValueArray[1] = parent.criteria.StockStatusByStoreCriteria_form.p_facility_id.value;
	dataTypeArray[1] = STRING;
	//argumentArray[0] = parent.criteria.StockStatusByStoreCriteria_form.SQL_ST_STORE_LOOKUP.value;
	//Commented by Rabbani #Inc no :39203 on  18-APR-2013
	//var sql = "SELECT    DISTINCT A.STORE_CODE CODE, A.SHORT_DESC DESCRIPTION FROM MM_STORE_LANG_VW A, ST_STORE C, ST_ACC_ENTITY_PARAM D, ST_USER_ACCESS_FOR_STORE E WHERE A.LANGUAGE_ID LIKE ? AND A.FACILITY_ID LIKE ? AND A.STORE_CODE LIKE UPPER (?) AND UPPER (A.SHORT_DESC) LIKE UPPER (?) AND A.EFF_STATUS = 'E' AND A.STORE_CODE = C.STORE_CODE AND C.STORE_TYPE_FLAG != 'N' AND E.USER_ID LIKE DECODE(D.RESTRICT_VIEW_STK_STATUS , 'ALL','%', '"+user+"') AND C.STORE_CODE = E.STORE_CODE";
	
	//Added by Rabbani #Inc no :39203 on  18-APR-2013
	var sql = "SELECT DISTINCT A.STORE_CODE CODE, A.SHORT_DESC DESCRIPTION FROM MM_STORE_LANG_VW A, ST_STORE C, ST_ACC_ENTITY_PARAM D, ST_USER_ACCESS_FOR_STORE E WHERE A.LANGUAGE_ID LIKE ? AND A.FACILITY_ID LIKE DECODE(D.trn_across_facility_yn,'Y','%',?) AND A.STORE_CODE LIKE UPPER (?) AND UPPER (A.SHORT_DESC) LIKE UPPER (?) AND A.EFF_STATUS = 'E' AND A.STORE_CODE = C.STORE_CODE AND C.STORE_TYPE_FLAG != 'N' AND E.USER_ID LIKE DECODE(D.RESTRICT_VIEW_STK_STATUS , 'ALL','%', '"+user+"') AND C.STORE_CODE = E.STORE_CODE";
	
	argumentArray[0] = encodeURIComponent(sql)+" ORDER BY 2";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		if(arr[1]==undefined)
 		{
	 		arr[0]="";	
	 		arr[1]="";	
 		}
	else{
	//	obj.value=arr[0];
	    objCode.value = arr[0];
		objDesc.value = arr[0];
	}
	/*if ((returnedValues != null) && (returnedValues != "")) {
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[0];
	} */
}
//added for 19789

function searchStoreCode1(objCode, objDesc, user, language_id) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = language_id;
	dataTypeArray[0] = STRING;
	dataNameArray[1] = "facility_id";
	dataValueArray[1] = parent.criteria.StockStatusByStoreCriteria_form.p_facility_id.value;
	dataTypeArray[1] = STRING; 	
	argumentArray[0] =  "SELECT DISTINCT A.STORE_CODE CODE, A.SHORT_DESC DESCRIPTION FROM MM_STORE_LANG_VW A, ST_STORE C, ST_ACC_ENTITY_PARAM D, ST_USER_ACCESS_FOR_STORE E WHERE A.LANGUAGE_ID LIKE ? AND A.FACILITY_ID LIKE DECODE(D.trn_across_facility_yn,'Y','%',?) AND A.STORE_CODE LIKE UPPER (?) AND UPPER (A.SHORT_DESC) LIKE UPPER (?) AND A.EFF_STATUS = 'E' AND A.STORE_CODE = C.STORE_CODE AND C.STORE_TYPE_FLAG != 'N' AND E.USER_ID LIKE DECODE(D.RESTRICT_VIEW_STK_STATUS , 'ALL','%', '"+user+"') AND  c.store_code IN (select store_code from st_user_access_for_store where user_id= '"+user+"') AND C.STORE_CODE = E.STORE_CODE ORDER BY 2";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[0];
	}
}



async function searchItemCode(objCode, objDesc) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.forms[0].language_id.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] = parent.criteria.StockStatusByStoreCriteria_form.SQL_ST_ITEM_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = objDesc.value.toUpperCase();
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		if(arr[1]==undefined)
 		{
	 		arr[0]="";	
	 		arr[1]="";	
 		}
	else{
		objCode.value = arr[0];
		objDesc.value = arr[1];
		objDesc.readOnly=true;
	}
	/*if ((returnedValues != null) && (returnedValues != "")) {
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
		objDesc.readOnly=true;
			//objDesc.disabled=true;
	} */
}
/*function searchItemCode( objCode, objDesc ) {
		
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	
	argumentArray[0] = parent.criteria.StockStatusByStoreCriteria_form.SQL_ST_ITEM_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = CommonLookup( getLabel("Common.item.label","Common"), argumentArray );
		if((returnedValues != null) && (returnedValues != "") )  {
			objCode.value = returnedValues[0];
			//alert("item code" + objCode.value);
			objDesc.value = returnedValues[1];
			//objDesc.disabled=true;
		}

		
	}*/
function searchResults(frmObj) {
	var store_code_from = "";
	var store_code_to = "";
	var item_code = "";
	/*if (frmObj.store_desc.value == "" || frmObj.store_desc.value == null) {
		store_code = "";
	} else {
		store_code = frmObj.store_code.value;
	}*/
	var errorPage = "../../eCommon/jsp/error.jsp";
	var fields = new Array(frmObj.store_code_from,frmObj.store_code_to);
	var names = new Array("From Store Code "," To Store Code ");
	var errorPage = "../../eCommon/jsp/error.jsp";
	var messageFrame=parent.parent.messageFrame;
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
	var blankObj = null;
	blankObject = checkSTFields(fields, names, messageFrame, errorPage);
	/*if(blankObject)
	{
	if(frmObj.store_code_from.value.toUpperCase() > frmObj.store_code_to.value.toUpperCase() )
	{
	        var stMessage = getMessage("LESS_OR_EQUAL_VALIDATE", "ST");
			stMessage = stMessage.replace(/@/g, "Store Code");
	        parent.parent.messageFrame.location.href = errorPage+"?err_num="+stMessage ;
	        blankObject = false
	}
	} */
	if (frmObj.item_desc.value == "" || frmObj.item_desc.value == null) { 
		item_code = "";
	} else {
		item_code = frmObj.item_code.value;
	}
	var stock_level = frmObj.stock_level.value;
	var stock_item = frmObj.stock_item.value;
	var store_code_from = frmObj.store_code_from.value;
	var store_code_to = frmObj.store_code_to.value;
	
	if(blankObject)
	{
		var errorcheck=false;
		if (isValidFromToField(frmObj.store_code_from, frmObj.store_code_to, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)){
		if (isValidFromToField(frmObj.p_fm_item_class, frmObj.p_to_item_class, STRING, getLabel("Common.ItemClass.label", "Common"), messageFrame)){
		if (isValidFromToField(frmObj.analysis_code1_from, frmObj.analysis_code1_to, STRING, getLabel("eMM.ItemAnalysisCode.label", "MM")+"1", messageFrame)){
		if (isValidFromToField(frmObj.analysis_code2_from, frmObj.analysis_code2_to, STRING, getLabel("eMM.ItemAnalysisCode.label", "MM")+"2", messageFrame)){
		if (isValidFromToField(frmObj.analysis_code3_from, frmObj.analysis_code3_to, STRING, getLabel("eMM.ItemAnalysisCode.label", "MM")+"3", messageFrame)){
			//parent.frames[1].location.href = "../../eST/jsp/StockStatusByStoreResult.jsp?item_code=" + item_code + "&store_code_from=" + store_code_from +"&store_code_to=" + store_code_to + "&stock_level=" + stock_level + "&stock_item=" + stock_item + "&fm_item_class=" + frmObj.p_fm_item_class.value + "&to_item_class=" + frmObj.p_to_item_class.value + "&fm_anal1=" + frmObj.analysis_code1_from.value + "&to_anal1=" + frmObj.analysis_code1_to.value + "&fm_anal2=" + frmObj.analysis_code2_from.value + "&to_anal2=" + frmObj.analysis_code2_to.value + "&fm_anal3=" + frmObj.analysis_code3_from.value + "&to_anal3=" + frmObj.analysis_code3_to.value+"&item_desc="+encodeURIComponent(frmObj.item_desc.value)+"&sort_order="+sort_by;
			errorcheck=true;
		}
		}
		}
		}
		}

		if(errorcheck){
			 parent.frames[1].location.href = "../../eST/jsp/StockStatusByStoreResult.jsp?item_code=" + item_code + "&store_code_from=" + store_code_from +"&store_code_to=" + store_code_to + "&stock_level=" + stock_level + "&stock_item=" + stock_item + "&fm_item_class=" + frmObj.p_fm_item_class.value + "&to_item_class=" + frmObj.p_to_item_class.value + "&fm_anal1=" + frmObj.analysis_code1_from.value + "&to_anal1=" + frmObj.analysis_code1_to.value + "&fm_anal2=" + frmObj.analysis_code2_from.value + "&to_anal2=" + frmObj.analysis_code2_to.value + "&fm_anal3=" + frmObj.analysis_code3_from.value + "&to_anal3=" + frmObj.analysis_code3_to.value+"&item_desc="+encodeURIComponent(frmObj.item_desc.value)+"&sort_order="+sort_by;
		}  else{
			parent.frames[1].location.href = "../../eCommon/html/blank.html";
		}
	}
}
async function displayPending(trObj) {
	var item_code = trObj.cells[0].innerText;
	var store_code = trObj.cells[7].innerText;
	retVal = await window.showModalDialog("../../eST/jsp/StockStatusByStoreFrameList.jsp?function_id=" + parent.parent.function_id + "&store_code=" + store_code + "&item_code=" + item_code, "", "dialogHeight:25vh; dialogWidth:45vw; center:0; status: no; dialogLeft :75; dialogTop :250;");
}
function callBatchSearchScreen(item_code, store_batch_code) {
	var batch_item = item_code;
	var batch_store = store_batch_code;
	var includeZeroStockBatches = "Y";
	var includeExpiredBatches = "Y";
	var includeSuspendedBatches = "Y";
	var searchFunction = "N";
	var multipleSelect = "N";
	var itemStoreDisable = "Y";
	var cuttOffDate = "";
	var doc_type_code = "";
	var doc_no = "";
	var trn_type = "";
	var retval = callBatchSearchWindow(batch_item, batch_store, includeZeroStockBatches, includeExpiredBatches, includeSuspendedBatches, searchFunction, multipleSelect,cuttOffDate, doc_type_code, doc_no, trn_type,itemStoreDisable);		
}

function loadcolumn(obj) {
	formObj = document.forms[0];
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
	argumentArray[0] = document.getElementById("SQL_ST_ITEM_CLASS_LOOKUP_LANG").value + "'" + document.forms[0].language_id.value + "'";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.ItemClass.label", "Common"), argumentArray);
	var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		if(arr[1]==undefined)
 		{
	 		arr[0]="";	
	 		arr[1]="";	
 		}
	else{
		obj.value=arr[0];
	}
	/*if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	} */
}
function sortOrder(obj,image1,image2)
{
 	image=obj.getElementsByTagName('img')[0];
	var a = image.src.lastIndexOf('/');
	var b = image.src.substring(a+1,a+10);
 
	if(b=='Ascending')
    {
	 image.src = image2;
	// sort_by = 'store_desc , ' + obj.name + ' Desc'
	 sort_by = 'store_desc , ' + obj.id + ' Desc'
	}
	else
	{
       image.src = image1;
	   //sort_by = 'store_desc , ' + obj.name+' Asc';
	   sort_by = 'store_desc , ' + obj.id+' Asc';
	}

 searchResults(parent.parent.f_query_add_mod.criteria.document.StockStatusByStoreCriteria_form);
}
