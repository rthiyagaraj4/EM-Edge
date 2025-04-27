/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var xmlDom;
var xmlHttp;
function query(){
	f_query_add_mod.location.href = "../../eSS/jsp/CancelRequestQueryFrame.jsp?function_id="+function_id ; 
}

function onSuccess(){
	f_query_add_mod.document.location.href="../../eCommon/html/blank.html";
}

function reset() {
	if(f_query_add_mod.frameCancelRequestQueryCriteria!=null){
		f_query_add_mod.frameCancelRequestQueryCriteria.document.formCancelRequestQueryCriteria.reset();
		f_query_add_mod.frameCancelRequestQueryResult.document.location.href="../../eCommon/html/blank.html";
	}
	else if(f_query_add_mod.frameCancelRequestHeader!=null){
		f_query_add_mod.frameCancelRequestHeader.document.formCancelRequestHeader.reset();
	}
	//Added By Sakti Sankar against BRU-HIMS-CRF#374
	if(f_query_add_mod.frameCancelRequestDetail!=null){
		if(f_query_add_mod.frameCancelRequestDetail.document.formCancelRequestDetail.cancelAll.disabled == false){
		f_query_add_mod.frameCancelRequestDetail.document.formCancelRequestDetail.reset();
		}
	}
	//Added ends
}

function assignBean(frmObject) {
	bean_id = frmObject.bean_id.value;
	bean_name = frmObject.bean_name.value;
	xmlDom = new ActiveXObject("Microsoft.XMLDom");
	xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
}

async function apply(){

		if( f_query_add_mod.frameCancelRequestDetail==undefined){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	}

	var formObj		=	f_query_add_mod.frameCancelRequestHeader.document.formCancelRequestHeader ;
	var blankObject	=	null;
	var fields		=	new Array(formObj.cancelled_remarks);
	var fieldNames	=	new Array(getLabel("eSS.CancellationRemarks.label","SS"));

	var errorPage	=	"../../eCommon/jsp/error.jsp";
	blankObject		=	getBlankField( fields, fieldNames, messageFrame);

	if(blankObject==null) {
//Added By Sakti against BRU-HIMS-CRF-374
		var formObject = f_query_add_mod.frameCancelRequestDetail.document.formCancelRequestDetail ;
		var selectedIndices = "";
		var index = 0;
		var chkdValue = 0;
	
		var total_check_boxes = formObject.total_check_boxes.value;
		for (var count = 0;count<total_check_boxes;count++) {
				if(eval("formObject.group_code_"+count+".checked")) {
					selectedIndices += (count+ ",");
					chkdValue++;
				}
		}	
	if (chkdValue<=0) {
		messageFrame.location.href = errorPage+"?err_num="+ getMessage('MIN_ONE_DETAIL_REQUIRED','Common');
		return;
	}
		formObject.checkedIndices.value = selectedIndices;
	
		formObject.doc_type_code.value = formObj.doc_type_code.value;
		formObject.doc_no.value = formObj.doc_no.value;
		formObject.doc_date.value = formObj.doc_date.value;
		formObject.req_by_store_code.value = formObj.req_by_store_code.value;
		formObject.req_on_store_code.value = formObj.req_on_store_code.value;
		formObject.doc_ref.value = formObj.doc_ref.value;
		formObject.added_by_id.value = formObj.added_by_id.value;
		formObject.added_by_name.value = formObj.added_by_name.value;
		formObject.request_type.value = formObj.request_type.value;
		formObject.cancelled_remarks.value = formObj.cancelled_remarks.value;
		formObject.mode.value = formObj.mode.value;
		
		
		var confirmation =await confirmCancel();
		if(confirmation=="Yes"){

			//eval(formApply(formObj,SS_CONTROLLER));
			eval(formApply(formObject,SS_CONTROLLER));
			messageFrame.location.href = errorPage+"?err_num="+ message;
			if( result ) {
				onSuccess();
			}
		}
		else{
			messageFrame.location.href = errorPage+"?err_num="+ getMessage("OPERATION_CANCELLED","SS");
			return;
		}

}
	else{
		blankObject.focus();
	}
}

function Modify(obj){
	var doc_type_code=obj.cells[5].innerText;
	var doc_no=obj.cells[1].innerText;
	top.content.f_query_add_mod.document.location.href="../../eSS/jsp/CancelRequestFrame.jsp?mode="+MODE_MODIFY+"&function_id="+parent.parent.function_id+"&doc_type_code="+doc_type_code+"&doc_no="+doc_no;

	
}


function checkRemarks(remarksObj){
	return setTextAreaMaxLength(remarksObj,100);
}
//Added By Sakti against BRU-HIMS-CRF-374
function toggleCheck(selAllObj){

	var formObj = document.formCancelRequestDetail;
	
	for(i=0; i<formObj.total_check_boxes.value; i++){
		if(eval('formObj.group_code_'+i).disabled == false){
		if(selAllObj.checked == true){
			if(eval('formObj.group_code_'+i) != undefined) {
				eval('formObj.group_code_'+i).checked = true;
			}
		}
		else{
			if(eval('formObj.group_code_'+i) != undefined) {
				eval('formObj.group_code_'+i).checked = false;
			}
		}
	}
 }

}


function updateSelection() {
	var frmObject		= document.formCancelRequestDetail;
	var total_check_boxes = frmObject.total_check_boxes.value;
	var exist=false;
		for (var count = 0;count<total_check_boxes;count++) {
			if(eval('frmObject.group_code_'+count).disabled == false){
				if(eval("frmObject.group_code_"+count+".checked")) {
					exist=true;
				}else{
					exist=false;
					break;
				}
		}
	}

	if(!exist){
	document.formCancelRequestDetail.cancelAll.checked=false;
	}else{
	document.formCancelRequestDetail.cancelAll.checked=true;
	}
}

function checkSetTextAreaMaxLength(obj, len){
if(obj.value.length<=len)
	return true;
else 
	alert(getMessage("REMARKS_NOT_EXCEED_200_CH", "SS"));
	obj.focus();
	return false;
}
//Added ends

