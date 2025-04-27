
function create() {
	f_query_add_mod.location.href = "../../eST/jsp/ScheduleAutoRequestFrame.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
}
function onSuccess(mode,schdule_code) {
if(mode.value==2 ){
	f_query_add_mod.location.href = "../../eST/jsp/ScheduleAutoRequestFrame.jsp?mode=" + MODE_MODIFY + "&schdule_code=" + schdule_code.value+"&function_id=" + parent.function_id ;
}else{
f_query_add_mod.location.href = "../../eST/jsp/ScheduleAutoRequestFrame.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
}
}
function reset() {

	f_query_add_mod.location.reload();
	
}
function query() {
	f_query_add_mod.location.href = "../../eST/jsp/ScheduleAutoRequestQueryCriteria.jsp?mode=" + MODE_MODIFY + "&function_id=" + function_id;
}
function apply() {
	var errorPage = "../../eCommon/jsp/error.jsp";

	if(f_query_add_mod.f_schdule_auto==undefined)
	{
		messageFrame.location.href = errorPage + "?err_num=";
		return;
	}
	var formHeader = f_query_add_mod.f_schdule_auto.document.schduleAutoRequestForm;
	var locale = formHeader.locale.value;

	var arrayObject = new Array(formHeader.schedule_code,formHeader.schedule_desc, formHeader.doc_type_code,formHeader.requisition_by_store, formHeader.requisition_on_store,formHeader.frequency,formHeader.starting_from);
	var names = new Array("Schdule Code","Schdule Description",getLabel("Common.DocType.label", "Common"),  getLabel("Common.ReqByStore.label", "Common"), getLabel("Common.ReqOnStore.label", "Common"),getLabel("Common.Frequency.label", "Common"),getLabel("eST.StartingFrom.label", "ST"));
	var blankObject = checkFields(arrayObject, names, messageFrame, errorPage);
	if (blankObject != true) {
		return;
	}
	if(formHeader.mode.value=="1"){
	var formObject = f_query_add_mod.f_schdule_detail.document.schduleAutoRequestDetailform;
	if(formObject==undefined){
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("MIN_ONE_DETAIL_REQUIRED", "common");
		return;

	}
	}

	if (formHeader.requisition_by_store.value == formHeader.requisition_on_store.value) {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("REQ_ON_REQ_BY_CANNOT_BE_SAME", "ST");
		formHeader.requisition_on_store.focus();
		return;
	}
	if(formHeader.mode.value=="1"){
	var bean_id = "scheduleAutoRequestBean";
	var bean_name = "eST.ScheduleAutoRequestBean";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eST/jsp/ScheduleAutoRequestValidate.jsp?function_type=CHECHFORATLEASTONERECORD&bean_id=" + bean_id + "&bean_name=" + bean_name,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);

		if(!result){
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("MIN_ONE_DETAIL_REQUIRED", "Common");
			return false;
		}
	}
	formHeader.starting_from.value=convertDate(formHeader.starting_from.value, "DMY", locale, "en");
	var responseText = formApply(formHeader, ST_CONTROLLER);
	eval(responseText);
	if (result) {
		messageFrame.location.href = errorPage + "?err_num=" + encodeURIComponent(message) + "<BR>";
		onSuccess(formHeader.mode, formHeader.schedule_code);
		
	} else {
			messageFrame.location.href = errorPage + "?err_num=" + message;
		}
}
function assignBean(formObject) {
	if (formObject == null) {
		bean_id = document.schduleAutoRequestForm.bean_id.value;
		bean_name = document.schduleAutoRequestForm.bean_name.value;
	} else {
		bean_id = formObject.bean_id.value;
		bean_name = formObject.bean_name.value;
	}
	//xmlDom = new ActiveXObject("Microsoft.XMLDom");
	//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	var xmlDom = "";
	var xmlHttp = new XMLHttpRequest();
}
function defaultFirstElement() {
	var formObject = document.schduleAutoRequestForm;
	if ((formObject.mode.value == MODE_INSERT) && (formObject.requisition_by_store.length > 0)) {
		formObject.requisition_by_store.selectedIndex = 1;
		formObject.requisition_by_store.focus();
		formObject.requisition_on_store.focus();
	}
	if (formObject.mode.value == MODE_INSERT) {
		formObject.doc_type_code.focus();
	}
}

function populateItemClass(requisition_by_store, requisition_on_store) {
	if (requisition_by_store.value == "" || requisition_on_store == "") {
		return;
	}
	var arrayObject = new Array();
	arrayObject[0] = requisition_by_store;
	arrayObject[1] = requisition_on_store;
	assignBean(document.schduleAutoRequestForm);
	xmlStr = getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	var xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	var xmlHttp = new XMLHttpRequest() ;
	xmlHttp.open("POST", "../../eST/jsp/ScheduleAutoRequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=POPULATEITEMCLASSES", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
}


function CheckForSpecialChars(event) {
	var strCheck = "0123456789";
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  
	if (strCheck.indexOf(key) == -1) {
		return false;
	}  
	if ((event.keyCode >= 97) && (event.keyCode <= 122)) {
		return (event.keyCode -= 32);
	}
	return true;
}
function checkSysdate(receiptdate, sysdate) {
	
	var flag = ChkDate(receiptdate);
	if (!flag) {
		alert(getMessage("INVALID_DATE_FMT", "ST"));
		receiptdate.select();
		receiptdate.focus();
		return false;
	}
	if (flag) {
		if (checkdateWithSysDate(receiptdate, sysdate)) {
			alert(getMessage("NOT_LESS_THAN_SYSDATE", "ST"));
			receiptdate.select();
			return false;
		} else {
		}
	}
}

function checkdateWithSysDate(entered_date, sys_date) {
	var enteredDateArray;
	var sysDateArray;
	var enteredDate = entered_date.value;
	var sysDate = sys_date.value;
	if (enteredDate.length > 0 && sysDate.length > 0) {
		enteredDateArray = enteredDate.split("/");
		sysDateArray = sysDate.split("/");
		var enteredDateObject = new Date(enteredDateArray[2], (enteredDateArray[1] - 1), enteredDateArray[0]);
		var sysDateObject = new Date(sysDateArray[2], (sysDateArray[1] - 1), sysDateArray[0]);
		if (Date.parse(sysDateObject) <= Date.parse(enteredDateObject)) {
				
			return false;
		} else {
			if (Date.parse(sysDateObject) > Date.parse(enteredDateObject)) {
				return true;
			}
		}
	}
	return true;
}
function checkDuplicateCode(obj){
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	var errorPage = "../../eCommon/jsp/error.jsp";
	if(document.schduleAutoRequestForm.schedule_code!="")
	{
	var bean_id = "scheduleAutoRequestBean";
	var bean_name = "eST.ScheduleAutoRequestBean";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eST/jsp/ScheduleAutoRequestValidate.jsp?schdule_code="+obj.value+"&function_type=CHECHFORDUPLICATESCHDULECODE&bean_id=" + bean_id + "&bean_name=" + bean_name,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);

		if(!result){
			obj.select();
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("CODE_ALREADY_EXISTS", "ST");
			return false;
		}
	}
}
function assignValue(obj) {
	if (obj.checked) {
		obj.value = "Y";
	} else {
		obj.value = "N";
	}
}
function searchDetails(obj)
{ 	
	var messagef=parent.parent.messageFrame;
	messagef.location.href = "../../eCommon/jsp/error.jsp?err_num=";

	var fmode=parent.f_schdule_auto.schduleAutoRequestForm;
	var requisition_by_store=fmode.requisition_by_store.value;
	var requisition_on_store=fmode.requisition_on_store.value;
	var item_class_code=fmode.item_class_code.value;
	var consignment=fmode.consignment.value;
	var item_analysis_1=fmode.item_analysis_1.value;
	var item_analysis_2=fmode.item_analysis_2.value;
	var item_analysis_3=fmode.item_analysis_3.value;
	var messagef=parent.parent.messageFrame;
	var errorPage = "../../eCommon/jsp/error.jsp";
	
	var arrayObject = new Array(parent.f_schdule_auto.schduleAutoRequestForm.requisition_by_store,parent.f_schdule_auto.schduleAutoRequestForm.requisition_on_store);
	var names = new Array(getLabel("Common.ReqByStore.label", "Common"), getLabel("Common.ReqOnStore.label", "Common"));
	
	var blankObject = checkFields(arrayObject, names, parent.parent.messageFrame, errorPage);
	if (blankObject != true) {
		return;
	}

if(parent.f_schdule_auto.schduleAutoRequestForm.requisition_by_store.value==parent.f_schdule_auto.schduleAutoRequestForm.requisition_on_store.value){

	alert(getMessage("REQ_ON_REQ_BY_CANNOT_BE_SAME","ST"));
	return;

}
	var objf=parent.f_schdule_button.schduleAutoRequestTabsForm;
	if(objf.item_code.value=="" && objf.alpha_code.value=="" && objf.item_desc.value=="" ){
	messagef.location.href = "../../eCommon/jsp/error.jsp?err_num="+getLabel("Common.ItemCode.label","Common")+" / "+getLabel("Common.AlphaCode.label", "Common")+" / "+getLabel("Common.ItemDescription.label", "Common") +" "+getLabel("Common.Cannotbeblank.label","Common");
	return false;
	}
	var fmode=parent.f_schdule_button.schduleAutoRequestTabsForm;
	var item_desc=fmode.item_desc.value;
	var searchby_type=fmode.searchby_type.value;
	var alpha_code=fmode.alpha_code.value;
	var item_code=fmode.item_code.value;
	
	var fdloc=parent.f_schdule_detail;
	
	parent.f_schdule_auto.schduleAutoRequestForm.requisition_by_store.disabled=true;
	parent.f_schdule_auto.schduleAutoRequestForm.requisition_on_store.disabled=true;
	fdloc.location.href="../../eST/jsp/ScheduleAutoRequestDetail.jsp?mode="+fmode.mode.value+"&search=new"+"&requisition_by_store="+requisition_by_store+"&requisition_on_store="+requisition_on_store+"&item_class_code="+item_class_code+"&consignment="+consignment+"&item_analysis_1="+item_analysis_1+"&item_analysis_2="+item_analysis_2+"&item_analysis_3="+item_analysis_3+"&item_desc="+item_desc+"&searchby_type="+searchby_type+"&alpha_code="+alpha_code+"&item_code="+item_code+"&from=0&to=12";

}

function callAssociation(code)
{
f_schdule_button.document.getElementById("table_hide").style.display = 'none';
f_schdule_button.document.getElementById("select").className="SUB_LEVEL_LINK";
f_schdule_button.document.getElementById("select_col").className="normal";
f_schdule_button.document.getElementById("association").className="HIGHER_LEVEL_LINK";
f_schdule_button.document.getElementById("association_col").className="clicked";
navigation(f_schdule_detail.document.schduleAutoRequestDetailform,"associate");
}

function navigation(frmObj,link)
{  

	if(link=="associate")
	{
	f_schdule_detail.location.href="../../eST/jsp/ScheduleAutoRequestDetail.jsp?mode="+f_schdule_auto.schduleAutoRequestForm.mode.value+"&link="+link+"&from=0&to=12";

	}
	
}

function selectAll(obj, from, to){
	if(obj.checked == true)
		obj.value='Y';
	else
		obj.value='N';
	var bean_id = "scheduleAutoRequestBean";
	var bean_name = "eST.ScheduleAutoRequestBean";

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eST/jsp/ScheduleAutoRequestValidate.jsp?from="+from+"&function_type=SELECTALL&to="+to+"&selected="+ obj.value+"&bean_id=" + bean_id + "&bean_name=" + bean_name,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);

	for(i=from; i<=to; i++){
		eval("document.schduleAutoRequestDetailform.select_"+i).value = obj.value;
		eval("document.schduleAutoRequestDetailform.select_"+i).checked = obj.checked;
	}
}

function dispTypeCheck(obj,code){
	
	if(obj.checked == true){
	obj.value="Y";
	}else{
		obj.value="N";
	}
	var bean_id = "scheduleAutoRequestBean";
	var bean_name = "eST.ScheduleAutoRequestBean";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eST/jsp/ScheduleAutoRequestValidate.jsp?code="+code+"&function_type=SELECTALL"+"&selected="+ obj.value+"&bean_id=" + bean_id + "&bean_name=" + bean_name,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
	if(result)
	{
	alert(getMessage("ITEM_CODE_ALREADY_EXIST","ST"));
	return;
	}
} 
function callSelect(){
f_schdule_button.document.getElementById("table_hide").style.display = 'inline';
objf=f_schdule_button.schduleAutoRequestTabsForm;
var fmode=f_schdule_auto.schduleAutoRequestForm;
if(objf.item_code.value=="" && objf.alpha_code.value=="" && objf.item_desc.value=="" ){
f_schdule_button.location.href="../../eST/jsp/ScheduleAutoRequestTabs.jsp?mode="+fmode.mode.value+"&from=0&to=12";
f_schdule_detail.location.href="../../eCommon/html/blank.html";
return false;
}
	f_schdule_detail.location.href="../../eST/jsp/ScheduleAutoRequestDetail.jsp?mode="+fmode.mode.value;
}

function submitPrevNext(from, to){
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	document.forms[0].submit();
}
async function requestByStoreLookup(obj) {
	
	
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var facility_id    = document.query_form.facility_id.value;
	var language_id	   = document.query_form.locale.value
	var user_id		   = document.query_form.user_id.value
	var sql=document.query_form.SQL_SCHDULE_AUTO_STORE_LOOKUP.value;
	
	argumentArray[0] = sql+"'"+facility_id+"'"+" AND ST.USER_ID ="+"'"+ user_id+"'"      +" AND MM.LANGUAGE_ID="+"'"+language_id+"'"+"order by 2";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = "";
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues =await CommonLookup(getLabel("Common.ReqByStore.label","Common"), argumentArray);
	var ret1=unescape(returnedValues);
	 var arr=ret1.split(",");
		if(arr[1]==undefined) 
		{
			arr[0]="";	
			arr[1]="";	
		}

	if ((returnedValues != null) && (returnedValues != "") && returnedValues!=undefined) {
		document.query_form.requisition_by_store.value = arr[0];
		document.query_form.req_by_store_desc.value = arr[1];
	}
			
}

async function requestOnStoreLookup(obj,obj1) {
	
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	
	var facility_id    = document.query_form.facility_id.value;
	var language_id	   = document.query_form.locale.value;
	var user_id		   = document.query_form.user_id.value;
	var sql=document.query_form.SQL_SCHDULE_AUTO_STORE_LOOKUP.value;

	argumentArray[0] = sql+"'"+facility_id+"'"+" AND ST.USER_ID ="+"'"+ user_id+"'"      +" AND MM.LANGUAGE_ID="+"'"+language_id+"'"+"order by 2";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = "";
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues =await CommonLookup(getLabel("Common.ReqOnStore.label","Common"), argumentArray);
	var ret1=unescape(returnedValues);
	 var arr=ret1.split(",");
		if(arr[1]==undefined) 
		{
			arr[0]="";	
			arr[1]="";	
		}
	if ((returnedValues != null) && (returnedValues != "")) {
		if(returnedValues[0]==obj1.value){
		alert(getMessage("REQ_ON_REQ_BY_CANNOT_BE_SAME","ST"));
		return;
		}
		document.query_form.req_on_store_desc.value = arr[1];
		document.query_form.requisition_on_store.value = arr[0];
	
	}
}

function Modify(obj) {
	var schdule_code = obj.cells[0].innerText;
	parent.f_query_add_mod.location.href = "../../eST/jsp/ScheduleAutoRequestFrame.jsp?mode=" + MODE_MODIFY + "&schdule_code=" + schdule_code+"&function_id=" + parent.function_id ;
}

function checkCanAuthorize(requisition_by_store) {
	if (requisition_by_store.value == "") {
		return;
	}
	var arrayObject = new Array();
	arrayObject[0] = requisition_by_store;
	assignBean(document.schduleAutoRequestForm);
	xmlStr = getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	var xmlDom =new DOMParser().parseFromString(xmlStr, "text/xml");
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", "../../eST/jsp/ScheduleAutoRequestValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=POPULATEREQUESTONSTORE", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
}

function setParentStoreCode(store_code) {
	document.schduleAutoRequestForm.requisition_on_store.value = store_code;
}

