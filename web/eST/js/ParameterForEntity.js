/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		       Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
09/05/2017		IN062881		B.Badmavathi								     					PO Mandatory in GRN 
--------------------------------------------------------------------------------------------------------------------------------------------
*/
function onSuccess() {
	f_query_add_mod.document.location.reload();
}
function apply() {
	var formObj = f_query_add_mod.document.formParameterForEntity;
	var fields = new Array();
	var names = new Array();
	var errorPage = "../../eCommon/jsp/error.jsp";
	var blankObject = null;
	var index = 0;
	if (formObj.ss_period_end_scope.value == "E") {
		fields[index] = formObj.curr_proc_month;
		names[index++] = getLabel("Common.CurrentProcessingMonth.label", "Common");
		fields[index] = formObj.curr_proc_year;
		names[index++] = getLabel("Common.CurrentProcessingYear.label", "Common");
	}
	fields[index] = formObj.expiry_warning_days;
	names[index++] = getLabel("eST.ExpiryWarningDays.label", "ST");
	blankObject = checkSTFields(fields, names, messageFrame);
	if (blankObject == true) {
		if (!isSlotAscending(formObj)) {
			messageFrame.location.href = errorPage + "?err_num=" + getMessage("INVALID_SLOT_VALUE", "ST");
			return;
		}
		//Added by Rabbani #48528(HSA-CRF-0168) on 08-MAY-2014
		if(formObj.prepacking.value == "" && formObj.standardformulary.value == "" && formObj.others.value == "" && formObj.extemporaneous.value == ""  ){
			messageFrame.location.href = errorPage + "?err_num=" +getMessage("ATLEAST_ONE_PREP_TYPE", "ST");
			return;	 
		}
		var resultText = formApply(formObj, ST_CONTROLLER);
		eval(resultText);
		messageFrame.location.href = errorPage + "?err_num=" + message;
		if (result) {
			onSuccess();
		}
	}
}
function isSlotAscending(formObj) {
	if (getNumber(formObj.age_slot_1) > getNumber(formObj.age_slot_2) || getNumber(formObj.age_slot_2) > getNumber(formObj.age_slot_3) || getNumber(formObj.age_slot_3) > getNumber(formObj.age_slot_4) || getNumber(formObj.age_slot_4) > getNumber(formObj.age_slot_5)) {
		return false;
	}
	return true;
}
function getNumber(Obj) {
	if (Obj.value == null || Obj.value == "") {
		return 0;
	}
	return parseFloat(Obj.value);
}
function reset() {
	f_query_add_mod.document.formParameterForEntity.reset();
}
function callbtprice() {
	document.formParameterForEntity.batch_sale_price_yn.disabled		= false;
	document.formParameterForEntity.sale_price_appl_yn.disabled			= false;
	if (document.formParameterForEntity.bl_interface_yn.disabled == true) {
		document.formParameterForEntity.bl_interface_yn.checked			= false;
	}
	if (document.formParameterForEntity.bl_interface_yn.checked == false) {
		document.formParameterForEntity.batch_sale_price_yn.checked		= false;
		document.formParameterForEntity.batch_sale_price_yn.disabled	= true;
		document.formParameterForEntity.sale_price_appl_yn.checked		= false;
		document.formParameterForEntity.sale_price_appl_yn.disabled		= true;
		document.formParameterForEntity.lesser_sale_price_yn.disabled	= true;
		document.formParameterForEntity.lesser_sale_price_yn.checked	= false;
	}
	if(document.formParameterForEntity.sale_price_appl_yn.checked)
		document.formParameterForEntity.lesser_sale_price_yn.disabled	= false;
	else
		document.formParameterForEntity.lesser_sale_price_yn.disabled	= true;
}
function mrpPrice(obj){
	if(obj.checked==false){
		document.formParameterForEntity.lesser_sale_price_yn.checked	= false;
		document.formParameterForEntity.lesser_sale_price_yn.disabled	= true;
	}else{
		document.formParameterForEntity.lesser_sale_price_yn.disabled	= false;
	}
}
function validateporequest(obj)
{
if(obj.checked==false){
document.formParameterForEntity.porequest_by.value="NA";
document.formParameterForEntity.porequest_by.disabled	= true;
}else{
document.formParameterForEntity.porequest_by.disabled	= false;
}
}

async function auditTrailLogs(){
	await window.showModalDialog("../../eST/jsp/ParameterForEntityAuditLogFrame.jsp?", "", "dialogHeight:65vh; dialogWidth:70vw; center:0; status: no; dialogLeft :100; dialogTop :150; scroll: no");
}

/**
	* @Name - Mahesh
	* @Date - 05/01/2010
	* @Inc# - IN015494
	* @Desc - Function to Restrict user to enter Interger Greater than 4
	*/

function validIntegerLessThanThree() {
	var key = window.event.keyCode;
	if (!(key >= 48 && key <= 52)) {
		return false;
	} else {
		return true;
	}
}

function sitespecificenabledisable() {
	formObj = document.formParameterForEntity;
	var customer_id = formObj.site_id.value;

	if(customer_id != "KAUH") {
		formObj.allow_unf_grn_thru_interface_yn.disabled = true;
		formObj.allow_unf_grn_thru_interface_yn.checked = false;
		
	} else{
		formObj.allow_unf_grn_thru_interface_yn.disabled = false;
	}
}

function assignvalue() {
	formObj = document.formParameterForEntity;
	if(formObj.allow_unf_grn_thru_interface_yn.checked  == true) {

		formObj.allow_unf_grn_thru_interface_yn.value = "Y";
	} else{
		formObj.allow_unf_grn_thru_interface_yn.value = "N";
	}
	
}

function assignvalues() {
	formObj = document.formParameterForEntity;
	if(formObj.interface_po_applicable_yn.checked  == true) {

		formObj.interface_po_applicable_yn.value = "Y";
		formObj.po_details_applicable_yn.disabled = true;
		formObj.po_details_applicable_yn.checked = false;
		formObj.interface_to_external_po_yn.disabled = true;
		formObj.interface_to_external_po_yn.checked = false;
		
	} else{
		formObj.interface_po_applicable_yn.value = "N";
		formObj.po_details_applicable_yn.disabled = false;
		//formObj.po_details_applicable_yn.checked = true;
		formObj.interface_to_external_po_yn.disabled = false;
		//formObj.interface_to_external_po_yn.checked = true;
	}
	
}
//Added by Rabbani #48528(HSA-CRF-0168) on 08-MAY-2014
function checkPrepack(obj){
	if(obj.value == "" && document.formParameterForEntity.records_exist_for_prepack.value=="Y"){
		alert(getMessage("UNFINALIZED_TRN_EXITS_ST_ENTITY","ST"));
		//alert("APP-ST0217 Setup/Unfinalized Transaction for Manufacturing exist, cannot modify")
		document.formParameterForEntity.prepacking.focus();
		return
	}
}

function checkStandardform(obj){
	
	if(obj.value == "" && document.formParameterForEntity.records_exist_for_standard.value=="Y"){
		alert(getMessage("UNFINALIZED_TRN_EXITS_ST_ENTITY","ST"));
		//alert("APP-ST0217 Setup/Unfinalized Transaction for Manufacturing exist, cannot modify")
		document.formParameterForEntity.standardformulary.focus();
		return
	}
}
function checkExtemp(obj){
	
	if(obj.value == "" && document.formParameterForEntity.records_exist_for_extemp.value=="Y"){
		alert(getMessage("UNFINALIZED_TRN_EXITS_ST_ENTITY","ST"));
		//alert("APP-ST0217 Setup/Unfinalized Transaction for Manufacturing exist, cannot modify")
		document.formParameterForEntity.extemporaneous.focus();
		return
	}
}
function checkOthers(obj){ 
	
	if(obj.value == "" && document.formParameterForEntity.records_exist_for_others.value=="Y"){
		alert(getMessage("UNFINALIZED_TRN_EXITS_ST_ENTITY","ST"));
		//alert("APP-ST0217 Setup/Unfinalized Transaction for Manufacturing exist, cannot modify")
		document.formParameterForEntity.others.focus();
		return
	}
}
//ends
//Added by suresh.r on 10-07-2014 against AAKH-SCF-0113 beg
function assigncheckvalue(obj) {
	formObj = document.formParameterForEntity;
	if(formObj.disp_decimal_dtls_yn.checked  == true) {
		formObj.disp_decimal_dtls_yn.value = "Y";
		formObj.no_of_decimals.disabled=false;
	} else{
		formObj.disp_decimal_dtls_yn.value = "N";
		formObj.no_of_decimals.disabled=true;
	}
}//Added by suresh.r on 10-07-2014 against AAKH-SCF-0113 end
//Added against GDOH-CRF-0109 starts
function checkPOMandatory(obj){
	if(obj.checked == true && document.formParameterForEntity.po_mandatory.value=="Y"){
		alert(getMessage("PO_MANDATORY_CHECKED","ST"));
		obj.checked = false;
		obj.value = "N";
	}
}
//Added against GDOH-CRF-0109 ends


//Added against PMG2023-COMN-CRF-0039 starts
function callAverageUnitCostYn(obj){
	if(obj.checked == true){
		obj.checked = true;
		obj.value = "Y";
	} else {
		obj.checked = false;
		obj.value = "N";
	}
}
//Added against PMG2023-COMN-CRF-0039 starts