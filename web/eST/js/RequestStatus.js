
var prevObj = null;
var prevColor = null; 

function reset() {
	/**
	* @Name - Priya
	* @Date - 22/01/2010
	* @Inc# - 15496 (SRR20056-CRF-0537.2)
	* @Desc - To Reset both criteria & result page
	*/
	//f_query_add_mod.criteria.formRequestStatusQueryCriteria.document.formRequestStatusQueryCriteria.reset();
	f_query_add_mod.location.reload();
}
async function displayPending(trObj) {
	var formObj = document.formRequestStatusQueryResult;
	var doc_no = trObj.cells[1].innerText;
	var doc_type_code = trObj.cells[9].innerText;
	var doc_type_desc = trObj.cells[0].innerText;
	var store_code = trObj.cells[19].innerText; //Added by rabbani #inc no:45231 on 28-NOV-2013
	changeColor(trObj, 8);
	//retVal = window.showModalDialog("../../eST/jsp/RequestStatusFrameList.jsp?function_id=" + parent.parent.function_id + "&doc_type_code=" + doc_type_code + "&doc_no=" + doc_no + "&doc_type_desc=" + doc_type_desc, "", "dialogHeight:17; dialogWidth:60; center:0; status: no; dialogLeft :30; dialogTop :250;");
	//Added by rabbani #inc no:45231 on 28-NOV-2013
	retVal = await window.showModalDialog("../../eST/jsp/RequestStatusFrameList.jsp?function_id=" + parent.parent.function_id + "&doc_type_code=" + doc_type_code + "&doc_no=" + doc_no+ "&store_code="+store_code + "&doc_type_desc=" + doc_type_desc, "", "dialogHeight:40vh; dialogWidth:65vw; center:0; status: no; dialogLeft :30; dialogTop :250;");
	retainColor(trObj, 8);
}
async function displayAuditInfo(trObj) {
	var formObj = document.formRequestStatusQueryResult;
	var added_by_id				=	trObj.cells[15].innerText;//Modified from 10 to 15 against GDOH-SCF-0195 by B.Badmavathi
	var req_authorized_by_id		=	trObj.cells[16].innerText;//Modified from 15 to 16 against GDOH-SCF-0195 by B.Badmavathi
	var modified_by_id			=	trObj.cells[17].innerText;
	var modified_date			=	trObj.cells[13].innerText;
	var request_status			=	trObj.cells[6].innerText;
	var doc_no					=	trObj.cells[1].innerText;
	var doc_type_desc			=	trObj.cells[0].innerText;
	var cancelled_by_id			=	trObj.cells[14].innerText;
	var sch_code				=	trObj.cells[18].innerText;
    //Added for ML-BRU-SCF-2222 starts
    var req_by_store_code       =   trObj.cells[19].innerText;  
    var req_on_store_name       =   trObj.cells[4].innerText;  
    var doc_type_code           =   trObj.cells[9].innerText;
    
	if(sch_code!=""){
		added_by_id=getLabel("eST.AutoRequest.label", "ST");
		req_authorized_by_id=getLabel("eST.AutoRequest.label", "ST");
	}

	changeColor(trObj, 8);

	retVal						=await 	top.window.showModalDialog("../../eST/jsp/RequestStatusAuditInfo.jsp?function_id=" + parent.parent.function_id + "&added_by_id=" + added_by_id + "&req_authorized_by_id=" + req_authorized_by_id + "&modified_by_id=" + modified_by_id + "&modified_date=" + modified_date+"&cancelled_by_id="+cancelled_by_id + "&request_status=" + request_status +"&req_by_store_code="+ req_by_store_code+"&req_on_store_name="+req_on_store_name+"&doc_type_code="+doc_type_code+ "&doc_no=" + doc_no + "&doc_type_desc=" + doc_type_desc, "", "dialogHeight:18vh; dialogWidth:24vw; center:1; status: no; dialogLeft :475; dialogTop :250;scroll:no");
	//Added for ML-BRU-SCF-2222 ends
	retainColor(trObj, 8);
}

var prevObj = null;
var prevColor = null;

function changeColor(obj, n) {
	prevColor = obj.cells[0].className;
	for (k = 0; k < n; k++) {
		obj.cells[k].className = "STLIGHTPINK";
	}
}
function retainColor(obj, n) {
	for (k = 0; k < n; k++) {
		obj.cells[k].className = prevColor;
	}
}
function changeRowColor(obj, n) {
	if (prevObj != null) {
		for (k = 0; k < n; k++) {
			prevObj.cells[k].className = prevColor;
		}
	}
	prevObj = obj;
	prevColor = obj.cells[0].className;
	for (k = 0; k < n; k++) {
		obj.cells[k].className = "STLIGHTPINK";
	}
}
function searchRequestResults() {
	formObj = parent.parent.f_query_add_mod.frames[0].document.forms[0];
	var currentdate=getCurrentDate("DMY",formObj.language_id.value);
	var localename=formObj.language_id.value;

	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
   //commented by Rabbani #Inc no:42721 on 28-AUG-2013	
	//var arrayObject = new Array(formObj.doc_type_code,formObj.from_doc_date);
	//var names = new Array(getLabel("Common.documenttype.label", "Common"), getLabel("eST.DocDateFrom.label", "eST"));
	var arrayObject = new Array(formObj.from_doc_date);
	var names = new Array(getLabel("eST.DocDateFrom.label", "eST"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.messageFrame);
	if(blankObject==false){
		return;
	}
	
	if(formObj.from_doc_date.value!=""){
		if(!isBefore(formObj.from_doc_date.value, currentdate, "DMY", localename)){
			parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("ST_DOC_DT_NOT_GR_SYSDATE","ST");
			formObj.from_doc_date.value = "";
			formObj.from_doc_date.select();
			formObj.from_doc_date.focus();
			return;
		}
	}
	if(formObj.to_doc_date.value!=""){
		if(!isBefore(formObj.to_doc_date.value, currentdate, "DMY", localename)){
			parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("ST_DOC_DT_NOT_GR_SYSDATE","ST");
			formObj.to_doc_date.value = "" ;
			formObj.to_doc_date.select();
			formObj.to_doc_date.focus();
			return;
		}
	}
	if (doDateCheck(formObj.from_doc_date, formObj.to_doc_date, parent.parent.frames[2])) {
		formObj.action = "../../eST/jsp/RequestStatusQueryResult.jsp";
		formObj.target = "result" ;
		formObj.submit();
	}
}
async function searchItemCode(objCode) {
	var search_string = "";
	search_string = document.formRequestStatusQueryCriteria.item_desc.value;
	var store_code = document.formRequestStatusQueryCriteria.request_by_store.value;
	var category = "A";
	var sole_source = "A";
	var ps_item = "A";
	var mfg_item = "A";
	var expiry = "A";
	var consignment = "A";
	var item_class = document.formRequestStatusQueryCriteria.item_class_code.value;
	var retVal = await callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment);
	if (retVal != null) {
		document.formRequestStatusQueryCriteria.item_code.value = retVal[0];
		document.formRequestStatusQueryCriteria.item_desc.value = retVal[1];
		document.formRequestStatusQueryCriteria.searchItem.disabled = true;
		document.formRequestStatusQueryCriteria.item_desc.disabled = true;
	}
}
async function populateToStoresInQuery(request_by_store) {
	if (request_by_store.value == "") {
		document.formRequestStatusQueryCriteria.request_on_store.value=""
		
	}

//Ramana C Commented to allow the user to view the Other Facility Stores
/*	if(document.formRequestStatusQueryCriteria.request_type.value == '%')
	{
	var sql = "SELECT st.store_code CODE,	mm.short_desc DESCRIPTION FROM st_store	st, mm_store_lang_vw mm WHERE st.store_code = mm.store_code  AND st.req_allowed_yn='Y' AND mm.facility_id	="+"'"+document.formRequestStatusQueryCriteria.facility_id.value+"'"+" AND mm.language_id = "+"'"+document.formRequestStatusQueryCriteria.language_id.value+"'"+" AND UPPER (st.store_code) LIKE UPPER (?) AND UPPER (MM.SHORT_DESC) LIKE UPPER (?) ";
	}else
	{*/
    var sql = "SELECT ST.STORE_CODE CODE, MM.SHORT_DESC DESCRIPTION FROM ST_STORE ST, MM_STORE_LANG_VW MM, ST_USER_ACCESS_FOR_STORE SU,ST_ACC_ENTITY_PARAM SP WHERE ST.STORE_CODE = MM.STORE_CODE AND MM.EFF_STATUS = 'E' AND ST.REQ_ALLOWED_YN = 'Y' AND SU.REQ_ALLOWED_YN = 'Y' AND SU.STORE_CODE = ST.STORE_CODE AND MM.FACILITY_ID LIKE DECODE(SP.TRN_ACROSS_FACILITY_YN,'Y','%',"+"'"+document.formRequestStatusQueryCriteria.facility_id.value+"'"+") AND MM.LANGUAGE_ID =" +"'"+document.formRequestStatusQueryCriteria.language_id.value+"'"+" AND USER_ID ="+"'"+document.formRequestStatusQueryCriteria.user_id.value+"'" +" AND MM.EXTERNAL_YN LIKE DECODE ("+"'"+document.formRequestStatusQueryCriteria.request_type.value+"'"+", 'A', '%'," +"'"+document.formRequestStatusQueryCriteria.request_type.value+"'"+") AND UPPER (st.store_code) LIKE UPPER (?)     AND UPPER (mm.short_desc) LIKE UPPER (?)";
//}
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	
	argumentArray[0] = encodeURIComponent(sql);
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] =request_by_store.value;
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
		request_by_store.value=arr[0];
	}
	/*if ((returnedValues != null) && (returnedValues != "")) {
		request_by_store.value = returnedValues[0];
		//request_by_store.value = returnedValues[0];
	} */
	
	
	// This Commented By RAMANA CV For the Introduction of the Look Ups for the Stores CRF -435
	
	/*if (request_by_store.value == "") {
		clearListItems("document.forms[0].request_on_store");
		return;
	}
	SELECT DISTINCT STP.PARENT_STORE_CODE, MM.SHORT_DESC FROM ST_STORE_PARENT_STORE STP,MM_STORE_LANG_VW MM, ST_STORE ST,ST_ACC_ENTITY_PARAM SP WHERE STP.PARENT_STORE_CODE = MM.STORE_CODE AND MM.EFF_STATUS = 'E'  AND ST.STORE_CODE = MM.STORE_CODE  AND ST.ISS_ALLOWED_YN = 'Y' AND MM.FACILITY_ID LIKE DECODE(SP.TRN_ACROSS_FACILITY_YN,'Y','%',?) AND MM.LANGUAGE_ID = ? AND STP.STORE_CODE = ? ORDER BY 2
	/*var arrayObject = new Array();
	arrayObject[0] = request_by_store;
	var frmObject = parent.frames[0].document.forms[0];
	bean_id = frmObject.bean_id.value;
	bean_name = frmObject.bean_name.value;
	xmlDom = new ActiveXObject("Microsoft.XMLDom");
	xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	xmlStr = getXMLString(arrayObject);
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "../../eST/jsp/RequestStatusValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&request_by_store=" + request_by_store.value + "&&function_type=1", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);*/ 

}

async function populateStoresInQuery(request_on_store,request_by_store) {
// This Commented By RAMANA CV For the Introcuction of the Look Ups for the Stores CRF -435
	/*if (request_by_store.value == "") {
		document.formRequestStatusQueryCriteria.request_on_store.value=""
	   return;	
	
	}*/
// This query facilitates the user to get the Parent For Store 
/*var sql = "SELECT DISTINCT STP.PARENT_STORE_CODE CODE, MM.SHORT_DESC DESCRIPTION FROM ST_STORE_PARENT_STORE STP,MM_STORE_LANG_VW MM, ST_STORE ST,ST_ACC_ENTITY_PARAM SP WHERE STP.PARENT_STORE_CODE = MM.STORE_CODE AND MM.EFF_STATUS = 'E'  AND ST.STORE_CODE = MM.STORE_CODE  AND ST.ISS_ALLOWED_YN = 'Y' AND MM.FACILITY_ID LIKE DECODE(SP.TRN_ACROSS_FACILITY_YN,'Y','%',"+"'"+document.formRequestStatusQueryCriteria.facility_id.value+"'"+") AND MM.LANGUAGE_ID = "+"'"+document.formRequestStatusQueryCriteria.language_id.value+"'"+" AND STP.STORE_CODE =" +"'"+request_by_store.value+"'"+ "AND UPPER (STP.PARENT_STORE_CODE) LIKE UPPER (?) AND UPPER (MM.SHORT_DESC) LIKE UPPER (?)";*/
// It is used to dispalay all the stores inclusive stores in the Other Facilities can used for Further Enhansement
var sql = "SELECT ST.STORE_CODE CODE,	MM.SHORT_DESC DESCRIPTION FROM MM_STORE_LANG_VW MM, ST_STORE ST,ST_ACC_ENTITY_PARAM SP WHERE  MM.EFF_STATUS = 'E'  AND ST.STORE_CODE = MM.STORE_CODE  AND ST.ISS_ALLOWED_YN = 'Y' AND MM.FACILITY_ID LIKE DECODE(SP.TRN_ACROSS_FACILITY_YN,'Y','%',"+"'"+document.formRequestStatusQueryCriteria.facility_id.value+"'"+") AND MM.LANGUAGE_ID = "+"'"+document.formRequestStatusQueryCriteria.language_id.value+"'"+"AND UPPER (ST.STORE_CODE) LIKE UPPER (?) AND UPPER (MM.SHORT_DESC) LIKE UPPER (?)";

	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	
	argumentArray[0] = encodeURIComponent(sql);
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] =request_on_store.value;
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
		request_on_store.value=arr[0];
	}
	/*if ((returnedValues != null) && (returnedValues != "")) {
		request_on_store.value = returnedValues[0];
		//request_by_store.value = returnedValues[0];
	} */
}
function populateItemClasses(request_by_store,request_on_store) {
	/*if (request_by_store.value == "" || request_on_store == "") {
		clearListItems("document.forms[0].item_class_code");
		return;
	}*/
	var xmlHttp = new XMLHttpRequest();
	var arrayObject = new Array();
	arrayObject[0] = request_by_store;
	arrayObject[1] = request_on_store;
	assignBean(parent.frames[0].document.forms[0]);
	xmlStr = getXMLString(arrayObject);
//	xmlDom.loadXML(xmlStr);
    xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/RequestStatusValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +"&request_by_store="+request_by_store.value+"&request_on_store="+request_on_store.value+  "&function_type=2", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	return responseText;
}
function assignBean(frmObject) {
	bean_id = frmObject.bean_id.value;
	bean_name = frmObject.bean_name.value;
	xmlDom = "";
	var xmlHttp = new XMLHttpRequest();
}

function populateReqByStores(request_type){
	
		document.formRequestStatusQueryCriteria.request_by_store.value="";
		document.formRequestStatusQueryCriteria.request_on_store.value="";
		clearListItems('formRequestStatusQueryCriteria.item_class_code');
// This Commented By RAMANA CV For the Introcuction of the Look Ups for the Stores CRF -435
	/*var arrayObject = new Array();
	var varReqType=parent.frames[0].document.forms[0].request_type.value;
	if(varReqType=='%'){
		varReqType='A';
	}
	arrayObject[0] = request_type;
	var frmObject = parent.frames[0].document.forms[0];
	bean_id = frmObject.bean_id.value;
	bean_name = frmObject.bean_name.value;
	xmlDom = new ActiveXObject("Microsoft.XMLDom");
	xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	xmlStr = getXMLString(arrayObject);
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "../../eST/jsp/RequestStatusValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&request_type=" + varReqType + "&function_type=3", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);*/
}
function populateackstatus(obj)
{	
	document.formRequestStatusQueryCriteria.acknowledge_status.selectedIndex=0;
if(obj.value=='PAI' || obj.value=='FAFI' || obj.value=='FAPI' || obj.value=='C' || obj.value=='P')
document.formRequestStatusQueryCriteria.acknowledge_status.disabled = false;
else
document.formRequestStatusQueryCriteria.acknowledge_status.disabled = true;
}
