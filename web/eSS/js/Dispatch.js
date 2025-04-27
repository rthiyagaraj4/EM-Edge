/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function assignBean(frmObject) {
	bean_id = frmObject.bean_id.value;
	bean_name = frmObject.bean_name.value;
	var xmlDom = "";
	var xmlHttp = new XMLHttpRequest();
}
function query(){
	f_query_add_mod.location.href="../../eSS/jsp/DispatchFrame.jsp?mode="+MODE_MODIFY+"&function_id="+function_id;
}

function onSuccess(){
	f_query_add_mod.location.reload();
}

function create(){
	f_query_add_mod.location.href="../../eSS/jsp/DispatchFrame.jsp?mode="+MODE_INSERT+"&function_id="+function_id;
}


function apply(){
	
	if( f_query_add_mod.frameDispatchDetail==undefined){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	}
	
	var errorPage = "../../eCommon/jsp/error.jsp";
	var formObject = f_query_add_mod.frameDispatchDetail.document.formWashingDetail;
	if (formObject == null) {
		messageFrame.location.href = errorPage+"?err_num=";
		return;
	}
	//Added by Sakti against BRU-HIMS-CRF-371
	var totalCBoxes=parseInt(f_query_add_mod.frameDispatchDetail.document.formWashingDetail.total_check_boxes.value);

	var checkBoxObj=null;
	var forDispatching="";
	var checkedIndices = "";
	var chkdValue = 0;
	
	
	var canProcess = false;
	var formobject = f_query_add_mod.frameDispatchDetail.document.formWashingDetail;
	var total_checkboxes = formobject.total_check_boxes.value;
		for (i=0;i<total_checkboxes;i++ ){
			if (eval ("formObject.checkbox"+i+".checked")) {
				canProcess = true;
				checkedIndices += (i+ ",");
			}
		}
		//Comented against inc#43640
		/*if (!canProcess) {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ getMessage('MIN_ONE_DETAIL_REQUIRED',"Common");	 
			return;
		}*/

		f_query_add_mod.frameDispatchDetail.document.formWashingDetail.checkedIndices.value = checkedIndices;
		
		//Added ends
				
			var formObj		=	f_query_add_mod.frameDispatchDetail.document.formWashingDetail;
			var errorPage	=	"../../eCommon/jsp/error.jsp";
			var responseText	=	formApply(formObj,SS_CONTROLLER);
			responseText = responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, "");
			eval(responseText);
			messageFrame.location.href = errorPage+"?err_num="+ message;
			if( result ) {
				onSuccess();
			}
}

function reset(){
	f_query_add_mod.location.reload();
}


function assignValue(obj){
if(obj.checked)
	obj.value="Y";
else
	obj.value="N";
}

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

function searchRofDtls(){
	var messageFrame = parent.parent.messageFrame; 
	var formObj		=	parent.frameDispatchAddModify.document.formDispatch ;
	messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
 //Added against inc#42404
	var fields = new Array ( formObj.doc_date);
	var names  =  new Array (getLabel("eSS.DocDate.label","SS"));
	var obj    =null;
	var messageFrame = parent.parent.messageFrame; 
	var errorPage	 = "../../eCommon/jsp/error.jsp";
	obj=getBlankField( fields, names, messageFrame);
	if(obj==null) {
	temp_jsp="DispatchValidation.jsp?function_id=dispatch_add_modify&rof_doc_type_code="+formObj.rof_doc_type_code.value+"&store_code="+formObj.store_code.value+"&rof_doc_no="+formObj.rof_doc_no.value+"&doc_date="+formObj.doc_date.value+"&location="+formObj.service_location.value+"&store_code="+formObj.store_code.value+"&doc_ref="+formObj.doc_ref.value;

	var xmlStr="<root><SEARCH/></root>"
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	parent.frameDispatchDetail.location.href="../../eSS/jsp/DispatchDetail.jsp?rof_doc_type_code="+formObj.rof_doc_type_code.value+"&mode="+MODE_MODIFY+"&store_code="+formObj.store_code.value+"&rof_doc_no="+formObj.rof_doc_no.value+"&doc_date="+formObj.doc_date.value+"&location="+formObj.service_location.value+"&store_code="+formObj.store_code.value+"&doc_ref="+formObj.doc_ref.value;
	
	}else{
		parent.frameDispatchDetail.location.href= "../../eCommon/html/blank.html";
	}
}



async function popDtlData(rof_doc_type_code,doc_no,doc_date,store_code,service_location,doc_type_desc){
	var retVal ;
	var dialogHeight= "26.5vh" ;
	var dialogWidth	= "43vw" ;
	var dialogTop = "100" ;
	var status="no";
	var features	= " dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status: " + status +"; dialogTop:" +dialogTop;
	var arguments	= "" ;
	var url ="../../eSS/jsp/DispatchDtlDetails.jsp?rof_doc_type_code="+rof_doc_type_code+"&doc_no="+doc_no+"&mode="+MODE_INSERT+"&doc_date="+doc_date+"&store_code="+store_code+"&service_location="+service_location+"&doc_type_desc="+doc_type_desc;
	retVal = await window.showModalDialog(url,arguments,features);
}

function modify(rof_doc_type_code,obj,doc_type_desc,service_location,store_code,doc_ref){
	
	var doc_no=obj.cells[1].innerText;
	var doc_date=obj.cells[2].innerText;
	
	top.content.f_query_add_mod.document.location.href="../../eSS/jsp/DispatchModifyFrame.jsp?rof_doc_type_code="+rof_doc_type_code+"&doc_no="+doc_no+"&mode="+MODE_MODIFY+"&doc_date="+doc_date+"&store_code="+store_code+"&service_location="+service_location+"&doc_type_desc="+doc_type_desc+"&doc_ref="+doc_ref;
}




function listModify(index){
parent.frameDispatchDetail.location.href="../../eSS/jsp/DispatchModifyDetail.jsp?index="+index+"&function_id="+parent.parent.function_id;
}


function addToList(){


	var formObj= parent.frameDispatchDetail.formDispatchDetail;

	var dateObj = formObj.dispatch_date ;
	var sysObj  = formObj.sys_date ;

	var fields = new Array ( formObj.dispatch_date);
	var names  =  new Array (getLabel("eSS.DispatchDate.label","SS"));
	var obj    =null;
	var messageFrame = parent.parent.messageFrame; 
	var errorPage	 = "../../eCommon/jsp/error.jsp"
	obj=getBlankField( fields, names, messageFrame);
	if(obj==null) {
        
		if(checkSysdat(dateObj,sysObj)==false)
		  return; 

		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));
	
		xmlHttp.open("POST", "../../eSS/jsp/DispatchValidate.jsp?dispatch_date=" + formObj.dispatch_date.value+"&index="+formObj.index.value+ "&validate=ADD_TO_LIST", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);
		if( result ) {
			refreshDetails();
		}
		else{
			messageFrame.location.href = errorPage+"?err_num="+ getMessage(message,"SS");
		}
	}
}


//Added by Sakti against BRU-HIMS-CRF-371

async function modifymore(obj,rof_doc_type_code,doc_no){

	var dialogHeight= "70vh" ;
    var dialogWidth = "80vw" ;
    var status = "no";
  
    var formObj = document.formWashingDetail;
    var checked_yn = eval("formObj.checkbox"+obj).checked;

	var dialogUrl       = "../../eSS/jsp/DispatchListMore.jsp?function_id="+parent.function_id+"&doc_no="+doc_no+"&rof_doc_type_code="+rof_doc_type_code+"&checked_yn="+checked_yn+"&index="+obj;
	var dialogArguments = ""
	var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=yes; status:" + status;
	var returnVal = await top.window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);
	
	if (returnVal != null && returnVal !="" && returnVal !=undefined) {

		if(obj == returnVal){
			eval("formObj.checkbox"+obj).checked = true;
		}
		updateSelection();
		
	}
}

function toggleCheck(formObject){
	var allElements	=	formObject.elements;
	var ischecked=formObject.selectAll.checked;
	for (i=0; i<allElements.length; i++){
		if (allElements[i].type=="checkbox"){
			
				allElements[i].checked=ischecked;

						
		}
	}
}


/*function saveVals() {


	var formObj= document.formDispatchListMore;

	
	var messageFrame = parent.parent.messageFrame; 
	var sysObj  = formObj.sysdate ;//Added declaration for checking dispatch date should not greater sys_date
	var dateObj  = "" ;
	var autoclave_date = "";
	var total_rec = formObj.total_checkboxes.value;
	var canProcess = false;
	
		
	for(var i=0;i<total_rec;i++){
		if (eval ("formObj.checkbox_tray"+i+".checked")) {
			canProcess = true;
			
			if(eval("formObj.dispatch_date_"+i).value == ""){ 
				alert(getMessage('DISPATCH_DATE_CANNOT_BLANK',"SS"));
								
				eval("formObj.dispatch_date_"+i).focus();
				return;
				}
			
			dateObj = eval("formObj.dispatch_date_"+i);
			autoclave_date = eval("formObj.autoclave_date"+i);
			if(checkSysdat(dateObj,sysObj)==false){
				eval("formObj.dispatch_date_"+i).focus();
				return;
			}
			
			
			
			var flag=ChkDate(autoclave_date);
			if(flag)
			{
			if(!checkdateWithSysDate(autoclave_date,dateObj)){
				
			}
			else
			{
				alert(getMessage("DISPATCH_DATE_MUST_EQUALS","SS"));
				eval("formObj.dispatch_date_"+i).focus();
				return false;

			}


			}
			
			

		}
	}
	if (!canProcess) {
		alert(getMessage("SELECT_TRAY_TO_PROCEED","SS"));
		return;
	}
	for (var count = 0;count<total_rec;count++) {
		if(eval("formObj.checkbox_tray"+count+".checked")) {
				
		
					var xmlHttp = new XMLHttpRequest();
					var xmlDoc="";
					xmlDoc.loadXML(getEnhancedXMLString(formObj));
					xmlHttp.open("POST", "../../eSS/jsp/DispatchValidate.jsp?validate=ADD_TO_LIST&do_no="+eval("formObj.do_no_"+count).value+"&tray_no="+eval("formObj.tray_no_"+count).value+"&dispatch_date="+eval("formObj.dispatch_date_"+count).value+"&doc_type_code="+formObj.doc_type_code.value+"&group_code="+eval("formObj.group_code"+count).value , false);
					xmlHttp.send(xmlDoc);
					responseText = xmlHttp.responseText;
					eval(responseText);
			}
	}
	window.returnValue = result;
	window.close();

	
}*/


function saveVals() {


	var formObj= document.formDispatchListMore;

	
	var messageFrame = parent.parent.messageFrame; 
	var sysObj  = formObj.sysdate ;//Added declaration for checking dispatch date should not greater sys_date
	var dateObj  = "" ;
	var autoclave_date = "";
	var total_rec = formObj.total_checkboxes.value;
	var canProcess = false;
	var check_yn = "";
	var index = formObj.index.value
	
		
	for(var i=0;i<total_rec;i++){
		if (eval ("formObj.checkbox_tray"+i+".checked")) {
			canProcess = true;
			
			if(eval("formObj.dispatch_date_"+i).value == ""){ 
				alert(getMessage('DISPATCH_DATE_CANNOT_BLANK',"SS"));
								
				eval("formObj.dispatch_date_"+i).focus();
				return;
				}
			
			dateObj = eval("formObj.dispatch_date_"+i);
			autoclave_date = eval("formObj.autoclave_date"+i);
			if(checkSysdat(dateObj,sysObj)==false){
				eval("formObj.dispatch_date_"+i).focus();
				return;
			}
			
			
			
			var flag=ChkDate(autoclave_date);
			if(flag)
			{
			if(!checkdateWithSysDate(autoclave_date,dateObj)){
				
			}
			else
			{
				alert(getMessage("DISPATCH_DATE_MUST_EQUALS","SS"));
				eval("formObj.dispatch_date_"+i).focus();
				return false;

			}


			}
			
			

		}
	}
	if (!canProcess) {
		alert(getMessage("SELECT_TRAY_TO_PROCEED","SS"));
		return;
	}else{
		check_yn = "Y";
		index;
	}
	
					
		
					var xmlHttp = new XMLHttpRequest();
					var xmlDoc="";
					xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObj), "text/xml");
					//xmlDoc.loadXML(getEnhancedXMLString(formObj));
					xmlHttp.open("POST", "../../eSS/jsp/DispatchValidate.jsp?validate=ADD_TO_LIST&doc_no="+formObj.doc_no.value+"&doc_type_code="+formObj.doc_type_code.value , false);
					xmlHttp.send(xmlDoc);
					responseText = xmlHttp.responseText;
					responseText = responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, "");
					eval(responseText);

	window.returnValue = index;
	parent.document.getElementById("dialog_tag").close();
	
}

//Added ends

function refreshDetails(){
	displayMessage(top.content.messageFrame,"");
	refreshList();
}
function refreshList(){
	document.forms[0].group_desc.value="";
	document.forms[0].tray_no.value="";
	document.forms[0].dispatch_date.value="";

	
	top.content.f_query_add_mod.frameDispatchList.document.location.reload();

}

function checkSysdat(dispatchdate,sysdate){
		var locale			=	document.formDispatchListMore.locale.value;
		dispatchdate.value	=	convertDate(dispatchdate.value,'DMY',locale,"en"); 
	if(!checkDateWithSysDate(dispatchdate,sysdate)){

		//alert(getMessage("NOT_GRT_THAN_SYSDATE","SS"));
		alert(getMessage("DISPATCH_DATE_LESSTHAN_EQUALS","SS"));
		dispatchdate.select();
		dispatchdate.focus();
		return false;
	}
}

function resetDetail(){
parent.frameDispatchDetail.formDispatchDetail.reset();
}

function checkValDate(doc_date)
{
	
	var flag=ChkDate(doc_date);
	if(!flag)
	{
		alert(getMessage("INVALID_DATE_FMT","SS"));
		//doc_date.select();
		//doc_date.focus();
		doc_date.value="";
		return false;
	}
	
}

function checkSysdate(receiptdate,sysdate){
	
	var flag=ChkDate(receiptdate);
	if(flag)
	{
	if(!checkdateWithSysDate(receiptdate,sysdate)){
		
	}
	else
	{
		alert(getMessage("DATE_NOT_LESS_SYSDATE","SS"));
		receiptdate.select();
		receiptdate.focus();
		return false;

	}


	}
	else
	{
		alert(getMessage("INVALID_DATE_FMT","SS"));
		receiptdate.select();
		receiptdate.focus();
		return false;

	}
}


function checkdateWithSysDate(entered_date,sys_date) 
{
	var enteredDateArray; var sysDateArray;
	var enteredDate = entered_date.value ;
	var sysDate = sys_date.value;

	if(enteredDate.length > 0 && sysDate.length > 0 ) 
	{
		enteredDateArray = enteredDate.split("/");
		sysDateArray = sysDate.split("/");
		var enteredDateObject = new Date(enteredDateArray[2],(enteredDateArray[1]-1),enteredDateArray[0]);
		var sysDateObject = new Date(sysDateArray[2],(sysDateArray[1]-1),sysDateArray[0]);	
		if(Date.parse(sysDateObject) >= Date.parse(enteredDateObject)) 
		{
			/**
			  * If the sys_date is less than the entered_date date,
			  * i.e., The Entered date is greater than the Current System Date
			  * Then return false to indicate it is wrong..
			  */
			return false;
		}
		else if(Date.parse(sysDateObject) < Date.parse(enteredDateObject)) return true;
	}	
	return true;
}
function activeLink() {
	formObj=parent.frameDispatchDetail.document.forms[0];

	if(formObj.start.value != 0 ){
			parent.frameDispatchDetail.document.getElementById("prev").style.visibility='visible';
	}
	else{
			parent.frameDispatchDetail.document.getElementById("prev").style.visibility='hidden';
	}

	if(  !((parseInt(formObj.start.value) +parseInt(formObj.displaySize.value))>= formObj.totalRecords.value ))
		parent.frameDispatchDetail.document.getElementById("next").style.visibility='visible';
	else
		parent.frameDispatchDetail.document.getElementById("next").style.visibility='hidden';
}

function goNext1(source_mode) {
	formObj=parent.frameDispatchAddModify.document.forms[0];
	
	if(formObj.mode.value==MODE_INSERT)
		modeVal=MODE_INSERT;
	else
		modeVal=MODE_MODIFY;
	
	var formObjDispatch	=	parent.frameDispatchDetail.document.forms[0];
	//var formObject = document.formDispatchListMore;
	var selectedIndices = "";
	var index = 0;
	var total_check_boxes = formObjDispatch.total_check_boxes.value;
	for (count = 0;count<total_check_boxes;count++) {
			if(eval("formObjDispatch.checkbox"+count+".checked")) {
				selectedIndices += (count+ ",");
			}
	}
	formObjDispatch.checkedIndices.value = selectedIndices;
	var xmlDom = new ActiveXObject("Microsoft.XMLDom");
	var xmlHttp = new XMLHttpRequest();
	assignBean(formObjDispatch);
	xmlStr = getXMLString(formObjDispatch);
	xmlDom.loadXML(xmlStr);

	xmlHttp.open("POST", "../../eSS/jsp/DispatchValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate=ASSIGN_VALUE", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);
	
	start = parseInt( formObjDispatch.start.value) +parseInt( formObjDispatch.displaySize.value ) ;
	end = parseInt( formObjDispatch.end.value )+ parseInt(formObjDispatch.displaySize.value ) ;
	parent.frameDispatchDetail.location.href="../../eSS/jsp/DispatchDetail.jsp?rof_doc_type_code="+formObj.rof_doc_type_code.value+"&mode="+MODE_MODIFY+"&store_code="+formObj.store_code.value+"&rof_doc_no="+formObj.rof_doc_no.value+"&doc_date="+formObj.doc_date.value+"&location="+formObj.service_location.value+"&store_code="+formObj.store_code.value+"&doc_ref="+formObj.doc_ref.value+"&modeVal="+MODE_MODIFY+"&from="+start+"&to="+end;
	
}	
function goPrev1(source_mode) {
		formObj=parent.frameDispatchAddModify.document.forms[0];
	
	

	if(formObj.mode.value==MODE_INSERT)
		modeVal=MODE_INSERT;
	else
		modeVal=MODE_MODIFY;

	
	var formObjDispatch	=	parent.frameDispatchDetail.document.forms[0];
	var selectedIndices = "";
	var index = 0;
	var total_check_boxes = formObjDispatch.total_check_boxes.value;
	for (count = 0;count<total_check_boxes;count++) {
			if(eval("formObjDispatch.checkbox"+count+".checked")) {
				selectedIndices += (count+ ",");
			}
	}
	formObjDispatch.checkedIndices.value = selectedIndices;
	var xmlDom = new ActiveXObject("Microsoft.XMLDom");
	var xmlHttp = new XMLHttpRequest();
	assignBean(formObjDispatch);
	xmlStr = getXMLString(formObjDispatch);
	xmlDom.loadXML(xmlStr);

	xmlHttp.open("POST", "../../eSS/jsp/DispatchValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate=ASSIGN_VALUE", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);
	
	start = parseInt( formObjDispatch.start.value  )-parseInt(  formObjDispatch.displaySize.value)  ;
	end = parseInt( formObjDispatch.end.value )- parseInt(formObjDispatch.displaySize.value ) ;
	
	parent.frameDispatchDetail.location.href="../../eSS/jsp/DispatchDetail.jsp?rof_doc_type_code="+formObj.rof_doc_type_code.value+"&mode="+MODE_INSERT+"&store_code="+formObj.store_code.value+"&rof_doc_no="+formObj.rof_doc_no.value+"&doc_date="+formObj.doc_date.value+"&location="+formObj.service_location.value+"&store_code="+formObj.store_code.value+"&doc_ref="+formObj.doc_ref.value+"&modeVal="+modeVal+"&from="+start+"&to="+end;
}


//Added by Sakti against BRU-HIMS-CRF-371

function updateSelection() {
	var frmObject		= document.formWashingDetail;

	var total_check_boxes = frmObject.total_check_boxes.value;
	var exist=true;
		for (var count = 0;count<total_check_boxes;count++) {
				if(!(eval("frmObject.checkbox"+count+".checked"))) {
					exist=false;
				}
			}
			if(exist){
			document.formWashingDetail.selectAll.checked=true;
			}else{
			document.formWashingDetail.selectAll.checked=false;
			}
}

function updateSelectionGroupSearch() {
	var frmObject		= document.formDispatchListMore;
	var total_check_boxes = frmObject.total_checkboxes.value;
	var exist=true;
		for (var count = 0;count<total_check_boxes;count++) {

				if(!(eval("frmObject.checkbox_tray"+count+".checked"))) {
					exist=false;
				}
		}
			if(exist){
			document.formDispatchListMore.selectAll.checked=true;
			}else{
			document.formDispatchListMore.selectAll.checked=false;
			}
}


/*function removeVals() {


	var formObj= document.formDispatchListMore;


	var messageFrame = parent.parent.messageFrame; 
	var total_rec = formObj.total_checkboxes.value;

	
	for (var count = 0;count<total_rec;count++) {
		if(! eval("formObj.checkbox_tray"+count+".checked")) {
			
					var xmlHttp = new XMLHttpRequest();
					var xmlDoc="";
					xmlDoc.loadXML(getEnhancedXMLString(formObj));
					xmlHttp.open("POST", "../../eSS/jsp/DispatchValidate.jsp?validate=REMOVE_RECORD&do_no="+eval("formObj.do_no_"+count).value+"&tray_no="+eval("formObj.tray_no_"+count).value+"&dispatch_date="+eval("formObj.dispatch_date_"+count).value+"&doc_type_code="+formObj.doc_type_code.value+"&group_code="+eval("formObj.group_code"+count).value , false);
					xmlHttp.send(xmlDoc);
					responseText = xmlHttp.responseText;
					eval(responseText);
					
										
			}

	}

	
}*/

function removeVals() {


	var formObj= document.formDispatchListMore;


	var total_rec = formObj.total_checkboxes.value;

			
					var xmlHttp = new XMLHttpRequest();
					var xmlDoc="";
					xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObj), "text/xml");
					//xmlDoc.loadXML(getEnhancedXMLString(formObj));
					xmlHttp.open("POST", "../../eSS/jsp/DispatchValidate.jsp?validate=REMOVE_KEY&doc_no="+formObj.doc_no.value+"&doc_type_code="+formObj.doc_type_code.value , false);
					xmlHttp.send(xmlDoc);
					responseText = xmlHttp.responseText;
					responseText = responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, "");
					eval(responseText);
					
}



function SubmitLink(from, to) {
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	var formObject = document.formWashingDetail;
	var selectedIndices = "";
	
	var total_check_boxes = formObject.total_check_boxes.value;
	for (var count = 0;count<total_check_boxes;count++) {
			if(eval("formObject.checkbox"+count+".checked")) {
	
				selectedIndices += (count+ ",");
			}
	}
	formObject.checkedIndices.value = selectedIndices;
	
	var xmlHttp = new XMLHttpRequest();
	var xmlDom = new ActiveXObject("Microsoft.XMLDom");
	xmlStr = getXMLString(formObject);
	xmlDom.loadXML(xmlStr);

	xmlHttp.open("POST", "../../eSS/jsp/DispatchValidate.jsp?validate=ASSIGN_VALUE", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);
    document.QueryForm.from.value = from;
    document.QueryForm.to.value = to;
    document.QueryForm.submit() ;
}

//Added ends


 
