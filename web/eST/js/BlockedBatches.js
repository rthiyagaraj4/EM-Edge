/*
--------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------------------
15/7/2021  	TFS:21515        Shazana                      					MOHE-CRF-0084.1-US013
10/8/2021		TFS-22402			Shazana										        ST-MOHE-CRF-0084.1-US013/06 - Unposted Transactions
--------------------------------------------------------------------------------------------------------------------------------
 */ 
function reset() { 
	f_query_add_mod.frameBlockedBatchesQueryCriteria.document.formBlockedBatchesQueryCriteria.reset();
//	f_query_add_mod.frameBlockedBatchesQueryCriteria.document.getElementById("module_lab").style.visibility="hidden";//Added by suresh.r on 29-09-2014 against Inc 51460
	f_query_add_mod.frameBlockedBatchesQueryCriteria.document.getElementById("module_sel").style.visibility="hidden";//Added by suresh.r on 29-09-2014 against Inc 51460
	f_query_add_mod.frameBlockedBatchesQueryResult.location.href = "../../eCommon/html/blank.html";
}
async function callItemSearchScreen(objCode) {
	var consignment = "A";
	var search_string = objCode.value;
	var store_code = "";
	var category = "A";
	var sole_source = "A";
	var ps_item = "A";
	var mfg_item = "A";
	var expiry = "A";
	var consignment = "A";
	var item_class = "";
	var retValue = await callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment);
	if (retValue != null) {
		objCode.value = retValue[0];
	}
}
async function searchStoreCode(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "locale";
	dataValueArray[0] = document.formBlockedBatchesQueryCriteria.locale.value;
	dataTypeArray[0] = STRING;
	dataNameArray[1] = "facility_id";
	dataValueArray[1] = document.formBlockedBatchesQueryCriteria.facility_id.value;
	dataTypeArray[1] = STRING;
	argumentArray[0] = document.formBlockedBatchesQueryCriteria.SQL_ST_STORE_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
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
		obj.value=arr[0];
	}
	/*if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0]; 
//		objCode.value = returnedValues[1];
//		document.getElementById("td_storedesc").innerText=returnedValues[1]
	} */
}
//ADDED for MOHE-CRF-0084.1
function searchStoreCode1(obj) { 

	var user_name =  document.formBlockedBatchesQueryCriteria.p_user_name.value;  
	var strFacilityParam = document.formBlockedBatchesQueryCriteria.p_strFacilityParam.value; //MOHE-CRF-0084.1 
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "locale";
	dataValueArray[0] = document.formBlockedBatchesQueryCriteria.locale.value;
	dataTypeArray[0] = STRING;
	dataNameArray[1] = "facility_id";
	dataValueArray[1] = document.formBlockedBatchesQueryCriteria.facility_id.value;
	dataTypeArray[1] = STRING;
	if(strFacilityParam == "Y"){//MOHE-CRF-0084.1 START
		argumentArray[0] = "SELECT st.store_code code,  mm.short_desc  description FROM  mm_store_lang_vw  mm, st_store st , st_acc_entity_param  WHERE  mm.eff_status ='E'  AND  language_id  like  ?   AND  mm.facility_id    LIKE decode(TRN_ACROSS_FACILITY_YN, 'Y',mm.facility_id,? ) AND  UPPER(st.store_code)  LIKE  UPPER(?)  AND  UPPER(mm.short_desc) LIKE  UPPER(?) AND   mm.store_code=st.store_code AND st.store_code IN (SELECT STORE_CODE FROM st_user_access_for_store where user_id = '" +user_name+"' "+ ") ORDER BY 2" ;//MOHE-CRF-0084.1
	}else if (strFacilityParam == "N"){
		argumentArray[0] = "SELECT st.store_code code,  mm.short_desc  description FROM  mm_store_lang_vw  mm, st_store st , st_acc_entity_param  WHERE  mm.eff_status ='E'  AND  language_id  like  ?   AND  mm.facility_id    LIKE decode(TRN_ACROSS_FACILITY_YN, 'Y',mm.facility_id,? ) AND  UPPER(st.store_code)  LIKE  UPPER(?)  AND  UPPER(mm.short_desc) LIKE  UPPER(?) AND   mm.store_code=st.store_code ORDER BY 2" ;//MOHE-CRF-0084.1
	}//END 
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;	
	returnedValues = CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
/*function searchStoreCode(objCode) {

	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	argumentArray[0] = document.formBlockedBatchesQueryCriteria.SQL_ST_STORE_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = objCode.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = CommonLookup( getLabel("Common.Store.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value = returnedValues[0];
	} 
}
*/
function populateDocTypeCode(_trn_type) {
	var xmlHttp = new XMLHttpRequest();
	/*var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null)); */
	var xmlString = getXMLString(null);
    var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/BlockedBatchesValidate.jsp?trn_type=" + _trn_type + "&validate=POPULATE_DOC_TYPE_CODE", false);
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	eval(responseText);
}
	/**
	* @Name - Priya
	* @Date - 29/01/2010
	* @Inc# - IN018492
	* @Desc - To check whether From date is less than or equal to to date
	*/
function searchResult(){
	var messageFrame=parent.parent.messageFrame;
	var formObj = parent.parent.f_query_add_mod.frames[0].document.forms[0]; 
     if(formObj.from_doc_date.value==""){
		 alert(getMessage("FROM_DATE_NOT_BLANK", "ST"));
		formObj.from_doc_date.focus();
		return;
		}	
	if (isValidFromToField(formObj.from_doc_date, formObj.to_doc_date, DATE, getLabel("Common.date.label", "Common"), messageFrame)) {
		formObj.submit();
		messageFrame.location.href="../../eCommon/jsp/error.jsp?error_value=0&err_num=";
	}else{
		parent.parent.f_query_add_mod.frameBlockedBatchesQueryResult.location.href="../../eCommon/html/blank.html";
	}
}
//Added by suresh.r on 29-09-2014 against Inc 51460 beg
function displayModuleid(_trn_type){
	var formObj = parent.parent.f_query_add_mod.frames[0]; 
	if(_trn_type=="SAL" || _trn_type=="SRT"){
	//	formObj.document.getElementById("module_lab").style.visibility="visible";
		formObj.document.getElementById("module_sel").style.visibility="visible";
		formObj.document.getElementById("module_id").value = "ALL";
	}else{
	//	formObj.document.getElementById("module_lab").style.visibility="hidden";
		formObj.document.getElementById("module_sel").style.visibility="hidden";
	}
}
//Added by suresh.r on 29-09-2014 against Inc 51460 end
