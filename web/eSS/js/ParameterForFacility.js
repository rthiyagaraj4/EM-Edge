/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function onSuccess(){ 
	f_query_add_mod.document.location.reload();
}
function apply(){
	var formObj = f_query_add_mod.document.formParameterForFacility;
	var fields	= new Array ( formObj.curr_proc_month, formObj.curr_proc_year);
	var names	= new Array ( getLabel("eSS.CurrentProcessingMonth.label","SS"),getLabel("eSS.CurrentProcessingYear.label","SS"));
	var errorPage = "../../eCommon/jsp/error.jsp";
	var blankObject = null;
	blankObject = getBlankField( fields, names, messageFrame);
	if(blankObject == null) {
		var resultText	=	formApply(formObj,SS_CONTROLLER);
		resultText = resultText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, "");
		eval(resultText);
		messageFrame.location.href = errorPage+"?err_num="+ message;
		if( result ) 
			onSuccess();
	}
	else
		blankObject.focus();
}

function reset(){
	
	f_query_add_mod.document.formParameterForFacility.reset();
	var allowMultilpeYN=f_query_add_mod.document.formParameterForFacility.allow_multi_group_types_yn_orgi.value;
	if(allowMultilpeYN=="Y"){
		
	
	f_query_add_mod.document.formParameterForFacility.linen_group_label_type.disabled		=true;
	f_query_add_mod.document.formParameterForFacility.set_group_label_type.disabled		=true;
	f_query_add_mod.document.formParameterForFacility.single_group_label_type.disabled	=true;
	f_query_add_mod.document.formParameterForFacility.soft_pack_group_label_type.disabled	=true;
	f_query_add_mod.document.formParameterForFacility.tray_group_label_type.disabled		=true;

	}
	else{

		
		f_query_add_mod.document.formParameterForFacility.linen_group_label_type.disabled		=false;
		f_query_add_mod.document.formParameterForFacility.set_group_label_type.disabled		=false;
		f_query_add_mod.document.formParameterForFacility.single_group_label_type.disabled	=false;
		f_query_add_mod.document.formParameterForFacility.soft_pack_group_label_type.disabled	=false;
		f_query_add_mod.document.formParameterForFacility.tray_group_label_type.disabled		=false;
	}
}

function checkRecordsForIssueGroup(obj){
	if(obj.checked == false && document.formParameterForFacility.records_exist_for_Issuegroup.value=="Y"){
		alert(getMessage("UNFINALIZED_TRN_EXITS_SS_PARAM","SS"));
		obj.checked = true;
		obj.value = "Y";
	}
}
function checkRecordsForReturnGroup(obj){
	if(obj.checked == false && document.formParameterForFacility.records_exist_for_Returngroup.value=="Y"){
		alert(getMessage("UNFINALIZED_TRN_EXITS_SS_PARAM","SS"));
		obj.checked = true;
		obj.value = "Y";
	}
}
//Added By Sakti Sankar on 10/13/2013 against CRF#225.1
function checkRecordsForLoanIssueGroup(obj){
	if(obj.checked == false && document.formParameterForFacility.records_exist_for_loan_Issuegroup.value=="Y"){
		alert(getMessage("UNFINALIZED_TRN_EXITS_SS_PARAM","SS"));
		obj.checked = true;
		obj.value = "Y";
	}
}
function checkRecordsForLoanReturnGroup(obj){
	if(obj.checked == false && document.formParameterForFacility.records_exist_for_loan_Returngroup.value=="Y"){
		alert(getMessage("UNFINALIZED_TRN_EXITS_SS_PARAM","SS"));
		obj.checked = true;
		obj.value = "Y";
	}
}
////Added By Sakti Sankar on 10/13/2013 against CRF#225.1 ends
function enableAutoRequest(obj){
	if(obj.checked == true){
		obj.value = "Y";
	}else{
		obj.value = "N";
	}
}
//Added by Sakti against inc#48848
function isValidIntegerZero(obj) {
	//alert("isValidIntegerZero");
	if (obj.value == "") {
		return;
	}
	if (!isValidIntegerFormat(obj)) {
		alert(getMessage("INVALID_NUMBER_FORMAT", "Common"));
		obj.focus();
		return false;
	}
	return true;
}

function getdurationcheck(obj)
{
 var validate = isValidIntegerZero(obj);
 if(validate){
	var formObj=document.formParameterForFacility; 
	if(formObj.durn_for_start_date.value== "" ){
	  formObj.durn_for_start_date.value = 0;
	}
	if(formObj.durn_for_start_date.value== "00" || formObj.durn_for_start_date.value== "000" ){
	  formObj.durn_for_start_date.value = 0;
	}
}
}
//Added ends

//Added for ML-MMOH-CRF-1821-- TFS - 30369 
function checkDisablePack(obj){
	var formObj=document.formParameterForFacility; 
	if(formObj){
		if(obj.checked == true){
			//formObj.instruction_label_pack.disabled		=true;
			//formObj.print_packed_label_yn.disabled		=true;
			formObj.linen_group_label_type.disabled		=true;
			formObj.set_group_label_type.disabled		=true;
			formObj.single_group_label_type.disabled	=true;
			formObj.soft_pack_group_label_type.disabled	=true;
			formObj.tray_group_label_type.disabled		=true;

			//formObj.print_packed_label_yn.checked		=false;
			//formObj.print_packed_label_yn.value			="N";

			//formObj.instruction_label_pack.value		="";
			//formObj.print_packed_label_yn.value			="N";
			formObj.linen_group_label_type.value		="";
			formObj.set_group_label_type.value			="";
			formObj.single_group_label_type.value		="";
			formObj.soft_pack_group_label_type.value	="";
			formObj.tray_group_label_type.value			="";
			

		}else{
			//formObj.instruction_label_pack.disabled		=false;
			//formObj.print_packed_label_yn.disabled		=false;
			formObj.linen_group_label_type.disabled		=false;
			formObj.set_group_label_type.disabled		=false;
			formObj.single_group_label_type.disabled	=false;
			formObj.soft_pack_group_label_type.disabled	=false;
			formObj.tray_group_label_type.disabled		=false;

			//formObj.print_packed_label_yn.checked		=true;
			//formObj.print_packed_label_yn.value			="Y";
		}
	}
}
//Added Ends for  ML-MMOH-CRF-1821-- TFS - 30369 