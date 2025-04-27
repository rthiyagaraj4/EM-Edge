/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function create(){
	f_query_add_mod.location.href = "../../eSS/jsp/TrnDocTypeAddModifyMultiple.jsp?mode="+MODE_INSERT+"&function_id="+function_id;
}

function query(){
	f_query_add_mod.location.href = "../../eSS/jsp/TrnDocTypeQueryCriteria.jsp?function_id="+function_id+"&mode="+MODE_MODIFY ;
}

function onSuccess(){	
	reset();
}

function reset(){
	if(f_query_add_mod.document.formTrnDocType!=null)
	{
		
		//f_query_add_mod.location.href = "../../eSS/jsp/TrnDocTypeAddModifyMultiple.jsp?mode="+MODE_INSERT+"&function_id="+function_id;
		//Modified by suresh.r on 06-04-2015 against Inc 54315
		f_query_add_mod.location.reload();
		
	}
	if(f_query_add_mod.document.query_form!=null)
		f_query_add_mod.document.query_form.reset();

}

function apply(){
	if(!proceedOnApply()){
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
        return false;
    }
	var formObj = f_query_add_mod.document.formTrnDocType;
	
	var errorPage	=	"../../eCommon/jsp/error.jsp";
	if (formObj.mode.value == MODE_INSERT) 	{
		var arrFieldName = new Array();
		var arrLegends = new Array();
		var arrPKFieldNames =	new Array();
		arrFieldName[0] =	"doc_type_code_";
		arrFieldName[1] =	"trn_type_";
		arrLegends[0] = getLabel("Common.DocType.label","Common"); 
		arrLegends[1] = getLabel("eSS.TRNType.label","SS");    
		arrPKFieldNames[0] = "doc_type_code_";
		resetDuplicateClass( formObj, arrPKFieldNames );
		var validateResult = validateMandatoryFields(formObj,arrFieldName,arrLegends,arrPKFieldNames,null,messageFrame, errorPage);
		if(validateResult) {
			eval(formApply(formObj,SS_CONTROLLER));
			
			if( result ) {
				onSuccess();
			}
			if(invalidCode != "null" && invalidCode != ""){
				showDuplicates(formObj, arrPKFieldNames, invalidCode,'0',messageFrame,errorPage);
				return;
			}
			else {
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
			}
		}
	}
	/*else{
		message=getMessage("MODIFICATION_NOT_ALLOWED","SS")
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
	}*/
	 else {
			eval(formApply(formObj, SS_CONTROLLER));
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + message;
			if (result) {
				onSuccess();
			}
		}
}
function Modify(obj) {alert("modify")
	var doc_type_code = obj.cells[0].innerText;
	document.location.href = "../../eSS/jsp/TrnDocTypeModify.jsp?mode=" + MODE_MODIFY + "&function_id=" + parent.function_id + "&doc_type_code=" + doc_type_code;
}

function proceedOnApply() {
    var url = f_query_add_mod.location.href;
    url = url.toLowerCase();
    if ( (url.indexOf("blank.html")==-1) && (url.indexOf("trndoctypequery")==-1) )
        return true;
    else
        return false;
}

function Modify(obj){
	var doc_type_code=obj.cells[0].innerText;
	document.location.href="../../eSS/jsp/TrnDocTypeAddModify.jsp?mode="+MODE_MODIFY+"&function_id="+parent.function_id+"&doc_type_code="+doc_type_code;
}

function resetColorCode(obj){
    var arrPKFieldNames = new Array();
    var formObj = parent.f_query_add_mod.document.formTrnDocType;
    arrPKFieldNames[0] = "doc_type_code_";
    arrPKFieldNames[1] = "trn_type_";
    resetDuplicateClass( formObj, arrPKFieldNames, 0, obj );
}
function printreqd(obj) {
	if (obj.checked) {
		obj.value = "Y";
	} else {
		obj.value = "N";
	
	}
}

function checkPHListBox(obj, index) {

	var chkObj = eval("document.formTrnDocType.print_alert_reqd_yn_" + index);
	chkObj.disabled = !(obj.value == "REQ" || obj.value == "RTG");
	if (chkObj.disabled) {
		chkObj.checked = !chkObj.disabled;
	}
}
