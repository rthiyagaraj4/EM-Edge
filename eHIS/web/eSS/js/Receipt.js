/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function query(){
	f_query_add_mod.location.href="../../eSS/jsp/ReceiptFrame.jsp?mode="+MODE_MODIFY+"&function_id="+function_id;
}

function onSuccess(){
	f_query_add_mod.location.reload();
}

function create(){
	f_query_add_mod.location.href="../../eSS/jsp/ReceiptFrame.jsp?mode="+MODE_INSERT+"&function_id="+function_id;
}


/*function apply(){
	//totalCBox=parseInt(f_query_add_mod.frameDispatchList.document.formDispatchList.total_checkboxes.value);
	var totalCBoxes=parseInt(f_query_add_mod.frameDispatchDetail.document.formDetail.total_check_boxes.value);
	alert(totalCBoxes);
	var checkBoxObj=null;
	var selectedIndices = "";
	for(i=0;i<totalCBoxes;i++)
	{
		checkBoxObj=eval("f_query_add_mod.frameDispatchDetail.document.formDetail.checkbox"+i);
		if(checkBoxObj.checked){
			selectedIndices += (i+ ",");
	 }
	}
	f_query_add_mod.frameDispatchDetail.document.formDetail.checkedIndices.value = selectedIndices;




	//var formObj		=	f_query_add_mod.frameDispatchHeader.document.formDispatch ;
	var formObj		=	f_query_add_mod.frameDispatchDetail.document.formDetail ;
	//formObj.records_to_modify.value=forDispatching;
	var errorPage	=	"../../eCommon/jsp/error.jsp";
	eval(formApply(formObj,SS_CONTROLLER));
	messageFrame.location.href = errorPage+"?err_num="+ message;
	if( result ) {
		onSuccess();
	}
}*/

//Added against BRU-HIMS-CRF-372
function apply(){
	
	if( f_query_add_mod.frameDispatchDetail==undefined){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	}
	
	var errorPage = "../../eCommon/jsp/error.jsp";
	var formObject = f_query_add_mod.frameDispatchDetail.document.formDetail;
	if (formObject == null) {
		messageFrame.location.href = errorPage+"?err_num=";
		return;
	}
	//Added by Sakti against BRU-HIMS-CRF-371
	
	var checkedIndices = "";
	var canProcess = false;
	var formobject = f_query_add_mod.frameDispatchDetail.document.formDetail;
	var total_checkboxes = formobject.total_check_boxes.value;
		for (var i=0;i<total_checkboxes;i++ ){
			if (eval ("formObject.checkbox"+i+".checked")) {
				canProcess = true;
				checkedIndices += (i+ ",");
			}
		}
		//Comented against inc#43640
		/*if (!canProcess) {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ "APP-000077 Transaction must have atleast one detail record ";
				//getMessage('MIN_ONE_DETAIL_REQUIRED',"SS");//This id is not working here so manually given
			return;
		}*/

		f_query_add_mod.frameDispatchDetail.document.formDetail.checkedIndices.value = checkedIndices;
		
		//Added ends
				
			var formObj		=	f_query_add_mod.frameDispatchDetail.document.formDetail;
			var errorPage	=	"../../eCommon/jsp/error.jsp";
			var responseText	=	formApply(formObj,SS_CONTROLLER);
			responseText = responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, "");
			eval(responseText);
			messageFrame.location.href = errorPage+"?err_num="+ message;
			if( result ) {
				onSuccess();
			}
}
//Added ends

function reset(){
	/*if(f_query_add_mod.frameDispatchHeader.document.formDispatch!=null)
		f_query_add_mod.frameDispatchHeader.formDispatch.reset();
	
	if(f_query_add_mod.frameDispatchDetail.document.formDispatchDetail !=null)
		f_query_add_mod.frameDispatchDetail.document.formDispatchDetail.reset();

	if(f_query_add_mod.frameDispatchList.document.formDispatchList !=null)
		f_query_add_mod.frameDispatchList.document.formDispatchList.reset();

	if(f_query_add_mod.frameDispatchAddModify.document.formDispatch !=null)
		f_query_add_mod.frameDispatchAddModify.document.formDispatch.reset();

	if(f_query_add_mod.frameDispatchDetail.document.formDetail !=null)
		f_query_add_mod.frameDispatchDetail.document.formDetail.reset();*/
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
	messageFrame.location.href = "../../eCommon/jsp/error.jsp";//Added against BRU-HIMS-CRF-372
	
	formObj.doc_date.value=	convertDate(formObj.doc_date.value,'DMY',formObj.locale.value,"en"); 
	//Added against BRU-HIMS-CRF-372
	var doc_date = formObj.doc_date.value;
	if(doc_date == ""){
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ getMessage('DATE_NOT_BLANK',"SS");
		parent.frameDispatchDetail.location.href= "../../eCommon/html/blank.html";
		formObj.doc_date.focus();
		return;
	}
	//Added ends
	temp_jsp="ReceiptValidation.jsp?function_id=Receipt_add_modify&rof_doc_type_code="+formObj.rof_doc_type_code.value+"&store_code="+formObj.store_code.value+"&rof_doc_no="+formObj.rof_doc_no.value+"&doc_date="+formObj.doc_date.value+"&location="+formObj.service_location.value+"&store_code="+formObj.store_code.value+"&doc_ref="+formObj.doc_ref.value;

	var xmlStr="<root><SEARCH/></root>";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	parent.frameDispatchDetail.location.href="../../eSS/jsp/ReceiptDetail.jsp?rof_doc_type_code="+formObj.rof_doc_type_code.value+"&mode="+MODE_MODIFY+"&store_code="+formObj.store_code.value+"&rof_doc_no="+formObj.rof_doc_no.value+"&doc_date="+formObj.doc_date.value+"&location="+formObj.service_location.value+"&store_code="+formObj.store_code.value+"&doc_ref="+formObj.doc_ref.value;
	
		
}


function modify(rof_doc_type_code,obj,doc_type_desc,service_location,store_code,doc_ref){
	
	var doc_no=obj.cells[1].innerText;
	var doc_date=obj.cells[2].innerText;
	
	top.content.f_query_add_mod.document.location.href="../../eSS/jsp/ReceiptModifyFrame.jsp?rof_doc_type_code="+rof_doc_type_code+"&doc_no="+doc_no+"&mode="+MODE_MODIFY+"&doc_date="+doc_date+"&store_code="+store_code+"&service_location="+service_location+"&doc_type_desc="+doc_type_desc+"&doc_ref="+doc_ref;
}

function listModify(index){
parent.frameDispatchDetail.location.href="../../eSS/jsp/ReceiptModifyDetail.jsp?index="+index+"&function_id="+parent.parent.function_id;
}

//Added by Sakti against BRU-HIMS-CRF-372
async function modifymore(obj,rof_doc_type_code,doc_no){

	var dialogHeight= "70vh" ;
    var dialogWidth = "80vw" ;
    var status = "no";

    var formObj = document.formDetail;
    var checked_yn = eval("formObj.checkbox"+obj).checked;
	
	
	var dialogUrl       = "../../eSS/jsp/ReceiptListMore.jsp?function_id="+parent.function_id+"&doc_no="+doc_no+"&rof_doc_type_code="+rof_doc_type_code+"&checked_yn="+checked_yn+"&index="+obj;
	var dialogArguments = "";
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
	for (var i=0; i<allElements.length; i++){
		if (allElements[i].type=="checkbox"){
			
				allElements[i].checked=ischecked;

						
		}
	}
}
//Added ends

function addToList(){
	var formObj= parent.frameDispatchDetail.formDispatchDetail;

	var dateObj = formObj.dispatch_date ;
	var sysObj  = formObj.sysdate ;

	var fields = new Array ( formObj.dispatch_date);
	var names  =  new Array (getLabel("Common.ReceivedDate.label","Common"));
	var obj    =null;
	var messageFrame = parent.parent.messageFrame; 
	var errorPage	 = "../../eCommon/jsp/error.jsp";
	obj=getBlankField( fields, names, messageFrame);
	if(obj==null) {

        if(checkSysdate(dateObj,sysObj)==false)
		  return; 

		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		//xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eSS/jsp/ReceiptValidate.jsp?dispatch_date=" + formObj.dispatch_date.value+"&index="+formObj.index.value+ "&validate=ADD_TO_LIST", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, "");
		//alert(responseText);
		eval(responseText);
		if( result ) {
			refreshDetails();
		}
		else{
			messageFrame.location.href = errorPage+"?err_num="+ getMessage(message,"SS");
		}
	}
//	else
//		obj.focus();
}



function refreshDetails(){
	displayMessage(top.content.messageFrame,"");
	//resetPackingDetail();
	refreshList();
}
function refreshList(){
	top.content.f_query_add_mod.frameDispatchList.document.location.reload();
}


function checkValDate(doc_date)
{
	
	var flag=ChkDate(doc_date);
	if(!flag)
	{
		alert(getMessage("INVALID_DATE_FMT","SS"));
		doc_date.value="";
		doc_date.focus();
		return false;
	}
	
}

function checkSysdate(receiptdate,sysdate){
	var flag=ChkDate(receiptdate);
    if(flag)
     {
			if(!checkdateWithSysDate(receiptdate,sysdate))
			{	
				alert(getMessage("NOT_GRT_THAN_SYSDATE","SS"));
				receiptdate.value="";
				receiptdate.focus();
				return false;
			}
			else
			{
				
			}
      }
	  else
	  {
	 	    alert(getMessage("INVALID_DATE_FMT","SS"));
			receiptdate.value="";
			receiptdate.focus();
			return false;
 	   }
}


function checkdateWithSysDate(entered_date,sys_date) 
{
	var enteredDateArray; 
	var sysDateArray;
	var enteredDate = entered_date.value ;
	var sysDate = sys_date.value;
//alert(enteredDate);
//alert(sysDate);
	if(enteredDate.length > 0 && sysDate.length > 0 ) 
	{
		enteredDateArray = enteredDate.split("/");
		sysDateArray = sysDate.split("/");
		var enteredDateObject = new Date(enteredDateArray[2],(enteredDateArray[1]-1),enteredDateArray[0]);
		var sysDateObject = new Date(sysDateArray[2],(sysDateArray[1]-1),sysDateArray[0]);
		//alert(Date.parse(sysDateObject));
		//alert(Date.parse(enteredDateObject));
		if(Date.parse(sysDateObject) < Date.parse(enteredDateObject)) 
		{
			/**
			  * If the sys_date is less than the entered_date date,
			  * i.e., The Entered date is greater than the Current System Date
			  * Then return false to indicate it is wrong..
			  */
			return false;
		}
		else if(Date.parse(sysDateObject) >= Date.parse(enteredDateObject)) return true;
	}	
	return true;
}

function resetDetail(){
parent.frameDispatchDetail.formDispatchDetail.reset();
}

function chkReceivedDate(receiveddate)
{
		
		formObj = parent.parent.f_query_add_mod.frames[0].document.forms[0];
		
		var locale			=	document.formDispatchDetail.locale.value;
		receiveddate.value	=	convertDate(document.formDispatchDetail.dispatch_date.value,'DMY',locale,"en"); 
	
		if(!(doDateCheckAlert(formObj.doc_date,receiveddate)))
				alert(getMessage("ACKNOWLEDGEMENT_DATE_NOT_LESS","SS"));
		
		
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
	
	
	
	//xmlStr=formXMLString(formObj.start.value,formObj.end.value,formObj.totalRecords.value,formObj);
	//formValidation(xmlStr,formObj.start.value,formObj.end.value,formObj.totalRecords.value);

	if(formObj.mode.value==MODE_INSERT)
		modeVal=MODE_INSERT;
	else
		modeVal=MODE_MODIFY;
	
	var formObjReceipt	=	document.formDetail;

	
	//var formObjDispatch	=	parent.frameDispatchDetail.document.forms[0];
	start = parseInt( formObjReceipt.start.value) +parseInt( formObjReceipt.displaySize.value ) ;
	end = parseInt( formObjReceipt.end.value )+ parseInt(formObjReceipt.displaySize.value ) ;
	parent.frameDispatchDetail.location.href="../../eSS/jsp/ReceiptDetail.jsp?rof_doc_type_code="+formObj.rof_doc_type_code.value+"&mode="+MODE_MODIFY+"&store_code="+formObj.store_code.value+"&rof_doc_no="+formObj.rof_doc_no.value+"&doc_date="+formObj.doc_date.value+"&location="+formObj.service_location.value+"&store_code="+formObj.store_code.value+"&doc_ref="+formObj.doc_ref.value+"&modeVal="+modeVal+"&from="+start+"&to="+end;
	
}	
function goPrev1(source_mode) {
		formObj=parent.frameDispatchAddModify.document.forms[0];
	
	

	if(formObj.mode.value==MODE_INSERT)
		modeVal=MODE_INSERT;
	else
		modeVal=MODE_MODIFY;
	
	var formObjReceipt	=	document.formDetail;
	

	
	//var formObjDispatch	=	document.formDetail;
	start = parseInt( formObjReceipt.start.value  )-parseInt(  formObjReceipt.displaySize.value)  ;
	end = parseInt( formObjReceipt.end.value )- parseInt(formObjReceipt.displaySize.value ) ;
	
	parent.frameDispatchDetail.location.href="../../eSS/jsp/ReceiptDetail.jsp?rof_doc_type_code="+formObj.rof_doc_type_code.value+"&mode="+MODE_MODIFY+"&store_code="+formObj.store_code.value+"&rof_doc_no="+formObj.rof_doc_no.value+"&doc_date="+formObj.doc_date.value+"&location="+formObj.service_location.value+"&store_code="+formObj.store_code.value+"&doc_ref="+formObj.doc_ref.value+"&modeVal="+modeVal+"&from="+start+"&to="+end;
}	




//Added against BRU-HIMS-CRF-372
function saveVals(){


	var formObj= document.formReceiptListMore;

	var sysObj  = formObj.sysdate ;//Added declaration for checking dispatch date should not greater sys_date
	var dateObj  = "" ;
	
	var total_rec = formObj.total_checkboxes.value;
	var canProcess = false;
	var index = formObj.index.value;
	
		
	for(var i=0;i<total_rec;i++){
		if (eval ("formObj.checkbox_tray"+i+".checked")) {
			canProcess = true;
			
			if(eval("formObj.receipt_date"+i).value == ""){ 
				alert(getMessage('ACKNOWLEDGE_DATE_CANNOT_BLANK',"SS"));
								
				eval("formObj.receipt_date"+i).focus();
				return;
				}
			
			
			dateObj = eval("formObj.receipt_date"+i);
			dispatch_date = eval("formObj.dispatch_date"+i);
			
			if(checkSysdat(dateObj,sysObj)==false){
				eval("formObj.receipt_date"+i).focus();
				return;
			}
			
			
			
			var flag=ChkDate(dispatch_date);
			if(flag)
			{
				
			if(checkdateWithSysDate(dispatch_date,dateObj)){
				
			}
			else
			{
				alert(getMessage("ACKNOWLEDGE_DATE_MUST_EQUALS","SS"));
				eval("formObj.receipt_date"+i).focus();
				return false;

			}


			}
			
			

		}
	}
	if (!canProcess) {
		alert(getMessage("SELECT_TRAY_TO_PROCEED","SS"));
		return;
	}
	
					var xmlHttp = new XMLHttpRequest();
					var xmlDoc="";
					xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObj), "text/xml");
					// xmlDoc.loadXML(getEnhancedXMLString(formObj));
					xmlHttp.open("POST", "../../eSS/jsp/ReceiptValidate.jsp?validate=ADD_TO_LIST&doc_no="+formObj.doc_no.value+"&doc_type_code="+formObj.doc_type_code.value , false);
					xmlHttp.send(xmlDoc);
					responseText = xmlHttp.responseText;
					responseText = responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, "");
					eval(responseText);

	window.returnValue = index;
	parent.document.getElementById("dialog_tag").close(); 

	
}


function checkSysdat(receiptdate,sysdate){
	var locale			=	document.formReceiptListMore.locale.value;
	receiptdate.value	=	convertDate(receiptdate.value,'DMY',locale,"en"); 
if(!checkDateWithSysDate(receiptdate,sysdate)){

	
	alert(getMessage("ACKNOWLEDGE_DATE_LESSTHAN_EQUALS","SS"));
	receiptdate.select();
	receiptdate.focus();
	return false;
}
}

function removeVals() {


	var formObj= document.formReceiptListMore;


			
					var xmlHttp = new XMLHttpRequest();
					var xmlDoc="";
					xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObj), "text/xml");
					//xmlDoc.loadXML(getEnhancedXMLString(formObj));
					xmlHttp.open("POST", "../../eSS/jsp/ReceiptValidate.jsp?validate=REMOVE_KEY&doc_no="+formObj.doc_no.value+"&doc_type_code="+formObj.doc_type_code.value , false);
					xmlHttp.send(xmlDoc);
					responseText = xmlHttp.responseText;
					responseText = responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, "");
					eval(responseText);
					
	
}



function updateSelection() {
	var frmObject		= document.formDetail;

	var total_check_boxes = frmObject.total_check_boxes.value;
	
	var exist=true;
		for (var count = 0;count<total_check_boxes;count++) {
				if(!(eval("frmObject.checkbox"+count+".checked"))) {
					exist=false;
				}
			}
			if(exist){
			document.formDetail.selectAll.checked=true;
			}else{
			document.formDetail.selectAll.checked=false;
			}
}

function updateSelectionListMore() {
	var frmObject		= document.formReceiptListMore;
	var total_check_boxes = frmObject.total_checkboxes.value;
	var exist=true;
		for (var count = 0;count<total_check_boxes;count++) {

				if(!(eval("frmObject.checkbox_tray"+count+".checked"))) {
					exist=false;
				}
		}
			if(exist){
			document.formReceiptListMore.selectAll.checked=true;
			}else{
			document.formReceiptListMore.selectAll.checked=false;
			}
}

function SubmitLink(from, to) {
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";//Added against BRU-HIMS-CRF-372
	var formObject = document.formDetail;
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
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
//	xmlDom.loadXML(xmlStr);

	xmlHttp.open("POST", "../../eSS/jsp/ReceiptValidate.jsp?validate=ASSIGN_VALUE", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	responseText = responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, "");
	eval(responseText);
    document.QueryForm.from.value = from;
    document.QueryForm.to.value = to;
    document.QueryForm.submit() ;
}//Added ends
//Added ends
