var xmlDom;
var xmlHttp;
var prevObj=null;
var prevColor=null;

function assignBean(frmObject) {
	bean_id = frmObject.bean_id.value;
	bean_name = frmObject.bean_name.value;
	var xmlDom = "";
	var xmlHttp = new XMLHttpRequest();
	/*xmlDom = new ActiveXObject("Microsoft.XMLDom");
	xmlHttp = new ActiveXObject("Microsoft.XMLHTTP"); */
}

function Modify(obj){
	var doc_no =obj.cells[1].innerText;
	var doc_type_code =obj.cells[6].innerText;
	parent.document.location.href="../../eST/jsp/POCancelRequestFrame.jsp?mode="+MODE_MODIFY+"&function_id="+parent.parent.function_id+"&doc_type_code="+doc_type_code+"&doc_no="+doc_no;
}

function onSuccess(){
	f_query_add_mod.document.location.reload();
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ message;
	return;
}

function reset() {
		f_query_add_mod.location.reload();
}

function query() {
		f_query_add_mod.location.href="../../eST/jsp/POCancelRequestQueryFrame.jsp?function_id="+function_id+"&mode="+MODE_MODIFY;
}

async function apply() {

	if( f_query_add_mod.POCancelRequestQueryResultFrame==undefined){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	}
	var errorPage = "../../eCommon/jsp/error.jsp";
	var formObject = f_query_add_mod.POCancelRequestQueryResultFrame.document.formPOCancelRequestQueryResult;
	if (formObject == null) {
		messageFrame.location.href = errorPage+"?err_num=";
		return;
	}
	var total_items = formObject.total_check_boxes.value;
	var chkdValue = 0;
	for (count = 0;count<total_items;count++) {
			if(eval("formObject.doc_"+count+".checked")) {
				chkdValue++;
			}
	}
	
	if (chkdValue<=0) {
		messageFrame.location.href = errorPage+"?err_num="+ getMessage('MIN_ONE_DETAIL_REQUIRED','Common');
		return;
	}
	var selectedIndices = "";
	var index = 0;
	var flag  = "true";
	var total_check_boxes = formObject.total_check_boxes.value;

	for (count = 0;count<total_check_boxes;count++) {
		if(eval("formObject.doc_"+count+".checked") ) {
			selectedIndices += (count+ ",");
		}
	}
	formObject.checkedIndices.value = selectedIndices;
	
	CancelYN = await confirmCancel(); 
	if(CancelYN=="")
		{
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
		return false;
		}
	if(CancelYN == "Yes"  ) {
		var appResult  = formApply(formObject, ST_CONTROLLER);
		eval(appResult);
		if (message == "INVALID_REMARKS") {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=APP-000001 Remarks cannot be blank... ";
		}
		else{
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ getMessage(message,'ST');
		}
		if(result) {
			onSuccess();
		}
	}else {
	   f_query_add_mod.document.location.reload();
	   messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ getMessage("OPER_CANCELLED","ST");
	}
}

async function displayPending(trObj) {
	changeRowColor(trObj,8);
	var doc_no =trObj.cells[1].innerText;
	var doc_type_code = trObj.cells[8].innerText
	retVal=await window.showModalDialog("../../eST/jsp/POCancelRequestList.jsp?function_id="+parent.parent.function_id+"&doc_type_code="+doc_type_code+"&doc_no="+doc_no,'','dialogHeight:30vh; dialogWidth:40vw; center:0; status: no; scroll: no; dialogLeft :75; dialogTop :250;');
	
}

async function showReason(trObj,index) {
	changeRowColor(trObj,8);
	var doc_no =trObj.cells[1].innerText;
	var doc_type_code = trObj.cells[8].innerText
	if (eval ("document.formPOCancelRequestQueryResult.doc_"+index+".checked")){
		retVal=await window.showModalDialog("../../eST/jsp/POCancelRequestRemarks.jsp?function_id="+parent.parent.function_id+"&doc_type_code="+doc_type_code+"&doc_no="+doc_no,'','dialogHeight:30vh; dialogWidth:40vw; center:0; status: no; dialogLeft :75; dialogTop :250;');
	}
}

function updateRemarks() {
	formObject = document.formPOCancelRequestRemarks;
	if (!setTextAreaMaxLength(formObject.remarks,200)) {
		alert (getMessage('REMARKS_CHAR_EXCEEDS_LIMIT','ST'));
		return;
	}
	if (formObject.remarks.value == "") {
		checkField(formObject.remarks,getLabel("Common.remarks.label","Common"));
		return;
	}
	var xmlHttp = new XMLHttpRequest();
	assignBean(formObject);
	xmlStr = getXMLString(formObject);
	//xmlDom.loadXML(xmlStr);
	var xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/POCancelRequestValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=1", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);
	//window.close();
	const dialogTag = parent.document.getElementById("dialog_tag");    
    dialogTag.close();
}

function SubmitLink(from, to) {
	var formObject = document.formPOCancelRequestQueryResult;
	var selectedIndices = "";
	var index = 0;
	var total_check_boxes = formObject.total_check_boxes.value;
	for (count = 0;count<total_check_boxes;count++) {
			if(eval("formObject.doc_"+count+".checked")) {
				selectedIndices += (count+ ",");
			}
	}
	var xmlHttp = new XMLHttpRequest();
	formObject.checkedIndices.value = selectedIndices;
	assignBean(formObject);
	xmlStr = getXMLString(formObject);
	//xmlDom.loadXML(xmlStr);
	var xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/POCancelRequestValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=2", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);
    document.QueryForm.from.value = from;
    document.QueryForm.to.value = to;
    document.QueryForm.submit() ;
}


function changeMyRowColor(index,n,chkObj) { 
	var trObj=eval(document.getElementById("tr_"+index));
	if (chkObj.checked) 
		//OAGREEN,OAHOLIDAY,DATACHANGE,ORPANEL,ORHIGHER		
		classValue="DATACHANGE"
	else if (index%2==0) 
		classValue="OAQRYEVEN";
	else
		classValue="OAQRYODD";

	for( k=0;k<n;k++)
		trObj.cells[k].className=classValue;
	if (chkObj.checked){
		document.getElementById("remarks_td_"+index).disabled=false;
	}else{
		document.getElementById("remarks_td_"+index).disabled=true;
	}
}

function changeRowColor(obj,n) {
	if(prevObj!=null){
		for( k=0;k<n;k++)
			prevObj.cells[k].className=prevColor;
	}
	prevObj=obj;
	prevColor=obj.cells[0].className;
	for( k=0;k<n;k++)
		obj.cells[k].className="STLIGHTPINK";
}

function submitQueryCriteria(){
	if (isValidFromToField(document.formPOCancelRequestQueryCriteria.from_doc_date,document.formPOCancelRequestQueryCriteria.to_doc_date,DATE,"Doc Date",parent.parent.messageFrame,"../../eCommon/jsp/error.jsp")) {
		document.formPOCancelRequestQueryCriteria.submit();
	}
}

// Added on Monday, July 26, 2004
function toggleCheck(formObject){
	var allElements	=	formObject.elements;
	var ischecked=formObject.cancelAll.checked;
	for (i=0; i<allElements.length; i++){
		if (allElements[i].type=="checkbox"){
			if (!allElements[i].disabled){ 
				allElements[i].checked=ischecked;
				if(ischecked){
					if(document.getElementById("remarks_td_"+i)){
						eval(document.getElementById("remarks_td_"+i)).disabled=false;
					}
				}else{
					if(document.getElementById("remarks_td_"+i)){
						document.getElementById("remarks_td_"+i).disabled=true;
					}
				}
			}			
		}
	}
}
// End - Monday, July 26, 2004

function populateStores(request_by_store) {
	if (request_by_store.value == "")	{
		clearListItems('document.forms[0].request_on_store');
		return;
	}
	var xmlHttp = new XMLHttpRequest();
	var arrayObject										=		 new Array();
	arrayObject[0]										=		request_by_store;
	assignBean(document.formPOCancelRequestQueryCriteria);
	xmlStr												=		getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	var xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/POCancelRequestValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=3", false);
	xmlHttp.send(xmlDom);
	responseText										=		xmlHttp.responseText;
	eval(responseText);
	
}
function populateItemClasses(request_by_store,request_on_store) {
	if (request_by_store.value == "" || request_on_store == "")	{
		
		clearListItems('document.forms[0].item_class_code');
		return;
	}
	var xmlHttp = new XMLHttpRequest();
	var arrayObject			=		 new Array();
	arrayObject[0]			=		request_by_store;
	arrayObject[1]			=		request_on_store;
	assignBean(document.formPOCancelRequestQueryCriteria);
	xmlStr					=		 getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	var xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/POCancelRequestValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=4", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);
}
async function searchRemarks(objCode,objDesc){
	
	var argumentArray		 =		 new Array();
	var dataNameArray		 =		 new Array();
	var dataValueArray		 =		 new Array();
	var dataTypeArray		 =		 new Array();

	dataNameArray[0]		 =		"language_id" ;
	dataValueArray[0]		 =		document.formPOCancelRequestRemarks.lang_id.value;
	dataTypeArray[0]		 =		STRING ;
	dataNameArray[1]		 =		"module_id" ;
	dataValueArray[1]		 =		"ST";
	dataTypeArray[1]		 =		STRING ; 
	dataNameArray[2]		 =		"trn_type" ;
	dataValueArray[2]		 =		document.formPOCancelRequestRemarks.rem_trans_type.value;
	dataTypeArray[2]		 =		STRING ;
	argumentArray[0]		 =		document.formPOCancelRequestRemarks.SQL_ST_TRN_REMARKS_LOOKUP_SELECT.value;
	argumentArray[1]		 =		dataNameArray;
	argumentArray[2]		 =		dataValueArray;
	argumentArray[3]		 =		dataTypeArray;
	argumentArray[4]		 =		 "4,5";
	argumentArray[5]		 =		objDesc.value;
	argumentArray[6]		 =		CODE_LINK;
	argumentArray[7]		 =		CODE_DESC;
	returnedValues			 =		await CommonLookup( getLabel("Common.remarks.label","Common"), argumentArray );	

	/*if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value		 =		returnedValues[0];
		objDesc.value		 =		returnedValues[1];
	
	} */
	if(returnedValues != null && returnedValues != "" )
	{
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}										
		 	objCode.value = arr[0];
			objDesc.value = arr[1];	  			  
	}
	
}
