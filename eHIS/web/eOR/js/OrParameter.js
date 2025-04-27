/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             	100            		?           created
02/11/2011	  	IN029422		Chowminya G		Incident No: IN029422 - <Remove the check on the PH orders for IV orders> 
03/01/2012	  	IN028417		Menaka V		The registered lab samples can be discontinued from CA-OR even though
												the discontinuation reasons are not defined for lab module.
---------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        		Rev.Date		Rev.Name 		Description
---------------------------------------------------------------------------------------------------------------
11/08/2014		IN049419		Karthi L											An Audit Trail for Additional Information Amendment of Order	
06/10/2015		IN055737		Karthi L											IN055737 HSA-CRF-0250.1 - Dispatch Slip											
21/10/2015		IN057196		Ramesh G											Recording Of Consent Form
07/07/2016		IN059086		Karthi L											ML-MMOH-CRF-0493 [IN059086]
26/11/2016		IN062319		Karthi L											ML-MMOH-CRF-0508.1 [IN062319] 
27/11/2017		IN061890		Kamalakannan G		28/11/2017		Ramesh G		ML-MMOH-CRF-0542
05/12/2017		IN065925		Kamalakannan G		05/12/2017		Ramesh G		PMG2017-GHL-CRF-0006
18/04/2018      	IN064980        	Ramya   		18/04/2018       Ramesh G 		  ML-MMOH-CRF-956[IN064980]	
08/10/2018	  IN063719		Kamalakannan 	08/10/2018	Ramesh G		GHL-CRF-0419
25/01/2019    IN068673    DineshT           25/01/2019    Ramesh G      ML-MMOH-CRF-1263
15/08/2020	IN071361	Nijitha S	15/08/2020	Ramesh G	AAKH-CRF-0116
---------------------------------------------------------------------------------------------------------------
*/ 
var function_id = "" ;
var result = false;
var message = "" ;
var flag = "" ;


function apply() {
	var formObj = f_query_add_mod.document.or_parameter

	var order_hrs = formObj.order_hrs
	var results_hrs = formObj.results_hrs

	if(allowNonZero(order_hrs) == false){
	    order_hrs.focus()
		alert(getMessage('VAL_NOT_ZERO','OR'))
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false
	}
	if(allowNonZero(formObj.order_future_hrs_ahead) == false){
	    formObj.order_future_hrs_ahead.focus()
		alert(getMessage('VAL_NOT_ZERO','OR'))
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false
	}
	if(allowNonZero(results_hrs) == false){ 
	    results_hrs.focus()
		alert(getMessage('VAL_NOT_ZERO','OR'))
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false
	}

	/*if(formObj.app_ord_privilege[0].checked==true)
		app_ord_privilege		= "X";
	else if(formObj.app_ord_privilege[1].checked==true)
		app_ord_privilege		= "E";*/
	/*  Added by Kishore kumar N, for the CRF-640-OR */

	//alert('formObj.lnkFutureOrCrrEcntYn.checked '+formObj.lnkFutureOrderYn.checked)
	//IN049419 - Start
	if(formObj.amendauditreqdyn.checked)
	{
		formObj.amendauditreqdyn.value = "Y"
	}	
	else {
		formObj.amendauditreqdyn.value = "N"
	}
	if(formObj.amendreasonyn.checked)
	{
		formObj.amendreasonyn.value = "Y"
	}	
	else {
		formObj.amendreasonyn.value = "N"
	}
	if(formObj.amendreasonmandateyn.checked)
	{
		formObj.amendreasonmandateyn.value = "Y"
	}	
	else {
		formObj.amendreasonmandateyn.value = "N"
	}
	
	// End
	if(formObj.lnkFutureOrderYn.checked)
	{
		formObj.lnkFutureOrCrrEcntYn.value= "Y";
	}
	else
	{
		formObj.lnkFutureOrCrrEcntYn.value= "N";
	}
	//IN028417 Starts
	if(formObj.reasoncodeyn.checked)
	{
		formObj.ReasonCodeHoldDisYN.value= "Y";
	}
	else
	{
		formObj.ReasonCodeHoldDisYN.value= "N";
	}
	//IN028417 Ends
	//alert(formObj.lnkFutureOrCrrEcntYn.value);
	/* Ends here. */

	/*  Added by Uma, for the CRF-641 */
	if(formObj.lnkOrderingYn.checked)
	{
		formObj.lnkOrderingYn.value= "Y";
	}
	else
	{
		formObj.lnkOrderingYn.value= "N";
	}
	if(formObj.lnkOrderAuthorisationYn.checked)
	{
		formObj.lnkOrderAuthorisationYn.value= "Y";
	}
	else
	{
		formObj.lnkOrderAuthorisationYn.value= "N";
	}
	/* Ends here*/
	/*  Added by Uma on 2/1/2010, for the CRF-804 IN016226 */
	if(formObj.restrictCompNoteYn.checked)
	{
		formObj.restrictCompNoteYn.value= "Y";
	}
	else
	{
		formObj.restrictCompNoteYn.value= "N";
	}
	/*Ends Here*/
	/*  Added by Arvind on 4/19/2010, for the CRF-804  */
	if(formObj.by24_hrs.checked)
	{
		formObj.by24_hrs.value= "Y";
	}
	else
	{
		formObj.by24_hrs.value= "N";
	}
	/*Ends Here*/
	/* IN057196 Start.*/
	if(formObj.recConsetWithOrderYN.checked){
		formObj.recConsetWithOrderYN.value="Y";
	}else{
		formObj.recConsetWithOrderYN.value="N";
	}
	/* IN057196 End.*/
	//IN064980-----STARTS
	if(formObj.auth_ord_priv_rule_only_yn.checked)
	{
		formObj.DIS_SELECT_ALL_OPTION_YN.value = "Y"
		formObj.auth_ord_priv_rule_only_yn.value ="Y"
	}	
	else {
		formObj.auth_ord_priv_rule_only_yn.value = "N"
		formObj.DIS_SELECT_ALL_OPTION_YN.value = "N"
	}
	if(formObj.DIS_SELECT_ALL_OPTION_YN.checked)
	{
		formObj.DIS_SELECT_ALL_OPTION_YN.value = "Y"
	}	
	else {
		formObj.DIS_SELECT_ALL_OPTION_YN.value = "N"
	}
	//IN064980-----ENDS 
	//formObj.ord_privilege.value	= app_ord_privilege;
	//alert(formApply( f_query_add_mod.document.or_parameter,OR_CONTROLLER)) ;
	//alert(f_query_add_mod.document.or_parameter.fing_prn_auth_order.value);
	//alert(f_query_add_mod.document.or_parameter.fing_prn_auth_result.value);
	 eval(formApply(f_query_add_mod.document.or_parameter,OR_CONTROLLER));
	 //eval(fomApply(forobj,or_controller);
	 //alert(OR_CONTROLLER);
	// var message ="operation successfully";
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	if( result ) {
		onSuccess();
	}
}


function onSuccess() {
	f_query_add_mod.location.href = "../../eOR/jsp/OrParameterAddModify.jsp?mode=2&function_id="+function_id
}


function formReset () {
	var formObj = f_query_add_mod.document.or_parameter;
}

function assignResult(_result, _message, _flag){
//	alert(_result +"  -  "+_message+"  -  "+_flag)
	result = _result ;
	message  = _message ;
	flag = _flag ;

}

function reset(){
	// IN049419 - Commented Start
	/*f_query_add_mod.document.or_parameter.reset();
	var formObj = f_query_add_mod.document.or_parameter;
	if(formObj.ord_category.checked == false){
		formObj.ord_type.checked = false
		formObj.ord_type.disabled = true
	}*/
	f_query_add_mod.location.href = f_query_add_mod.location.href = "../../eOR/jsp/OrParameterAddModify.jsp?mode=2&function_id="+function_id;
	// IN049419 - End	
}

function loadEnableDisable(){
	var formObj = document.or_parameter
	
	if(formObj.ord_category.checked == false){
		formObj.ord_type.checked = false
		formObj.ord_type.disabled = true

	}
	// IN049419 - Start
	if(formObj.amendauditreqdyn.checked == false){
		formObj.amendreasonyn.checked = false
		formObj.amendreasonyn.disabled = true
	}	
	if(formObj.amendreasonyn.checked == false){
		formObj.amendreasonmandateyn.checked = false
		formObj.amendreasonmandateyn.disabled = true
	}
	// End
}

function enableDisable(){

	var formObj = document.or_parameter
	
	if(formObj.ord_category.checked == false){
		formObj.ord_type.checked = false
		formObj.ord_type.disabled = true

	}else{
		formObj.ord_type.disabled = false
	}
}
function checkActive(target)
{
	//alert(target.value);
	if(target.checked == false)
	{
		target.value = "N";
		target.checked = false;
	}
	else
	{
		target.value = "Y";
		target.checked = true;
	}
	//alert(target.value);
}

/*function beforePost(str)
{
	alert(str)
}*/
function validateOrdering(obj)
{
	if(obj.checked==true)
	{
		var confirm_val = window.confirm(getMessage("ALLOW_PRIV_TO_ORDER","OR"));
		if(!confirm_val)
		{
			obj.checked = false;
			obj.value = "N";
			return false;
		}
		else
		{
			obj.checked = true;
			obj.value = "Y";
		}
	}
}

function validateOrderAuthorisation(obj)
{
	if(obj.checked==true)
	{
		var confirm_val = window.confirm(getMessage("ALLOW_PRIV_TO_ORDER_AUTHORISE","OR"));
		if(!confirm_val)
		{
			obj.checked = false;
			obj.value = "N";
			return false;
		}
		else
		{
			obj.checked = true;
			obj.value = "Y";
			document.or_parameter.auth_ord_priv_rule_only_yn.disabled = false; //ML-MMOH-CRF-0493 [IN059086] - IN005128
		}
	} else {
		document.or_parameter.auth_ord_priv_rule_only_yn.disabled = true; //ML-MMOH-CRF-0493 [IN059086] - IN005128
		document.or_parameter.auth_ord_priv_rule_only_yn.checked = false; //ML-MMOH-CRF-0493 [IN059086] - IN005128
	}
}
//IN049419 - Start
function enableAudiReqd(){
	var formObj = document.or_parameter
	if(formObj.amendauditreqdyn.checked == false){
		formObj.amendreasonyn.checked = false
		formObj.amendreasonyn.disabled = true
		formObj.amendreasonyn.value = "N"
		formObj.amendreasonmandateyn.checked = false
		formObj.amendreasonmandateyn.disabled = true
		formObj.amendreasonmandateyn.value = "N"
	}else{
		formObj.amendreasonyn.disabled = false
	}
}
function enableAmendReason(){
	var formObj = document.or_parameter
	if(formObj.amendreasonyn.checked == false){
		formObj.amendreasonmandateyn.checked = false
		formObj.amendreasonmandateyn.disabled = true
		formObj.amendreasonmandateyn.value = "N"
	}else{
		formObj.amendreasonmandateyn.disabled = false
	}
}
// End
//IN055737 HSA-CRF-0250.1 - Start
function enableBarCodeSearch(obj){
	if(obj.checked){
		document.or_parameter.allow_specimen_barcode_search_yn.value="Y";
	}else{
		document.or_parameter.allow_specimen_barcode_search_yn.value="N";
	}
}
// IN055737 HSA-CRF-0250.1 - End
//ML-MMOH-CRF-0493 [IN059086]  Start
function enableAuthPrivRule(obj) {
	if(obj.checked){
		document.or_parameter.auth_ord_priv_rule_only_yn.value="Y";
	}else{
		document.or_parameter.auth_ord_priv_rule_only_yn.value="N";
	}
}
//ML-MMOH-CRF-0493 [IN059086] - End
// ML-MMOH-CRF-0508.1 [IN062319] 
function enableMultiChkNonMandate(obj){
	if(obj.checked){
		document.or_parameter.ord_formt_multi_list_mand_yn.value="Y";
	}else{
		document.or_parameter.ord_formt_multi_list_mand_yn.value="N";
	}
}
// ML-MMOH-CRF-0508.1 [IN062319] 
//IN061890 starts

function enableOrdReplThroTermset(obj){
	if(obj.checked){
		document.or_parameter.ord_repl_thro_termset_yn.value="Y";
	}else{
		document.or_parameter.ord_repl_thro_termset_yn.value="N";
	}
}
//IN061890 ends
//IN065925 starts
function enableCanOptionInactiveOrd(obj){
	if(obj.checked){
		document.or_parameter.can_option_inactive_ord_yn.value="Y";
	}else{
		document.or_parameter.can_option_inactive_ord_yn.value="N";
	}
}
//IN065925 ends
//IN064980-----STARTS
function enableDisSelectOptn(){
	var formObj = document.or_parameter
	if(formObj.auth_ord_priv_rule_only_yn.checked == false){
		formObj.DIS_SELECT_ALL_OPTION_YN.checked = false
		formObj.DIS_SELECT_ALL_OPTION_YN.disabled = true
		formObj.DIS_SELECT_ALL_OPTION_YN.value = "N"
	}else{
		formObj.DIS_SELECT_ALL_OPTION_YN.disabled = false
	}
}
//IN064980-----ends 
//IN063719 starts

function enablerestrictAE_Encounters(obj){
	if(obj.checked){
		document.or_parameter.restrictAE_Encounters_yn.value="Y";
	}else{
		document.or_parameter.restrictAE_Encounters_yn.value="N";
	}
}
//IN063719-----ends 

//IN068673, starts
function pendAuthIncludeSecSplty(obj)
{
	(obj.checked)?obj.value="Y":obj.value="N";
}
//IN068673, ends


//IN071361 Starts
function enableTimeBasedRule(obj){
	if(obj.checked){
		document.or_parameter.time_based_rule_yn.value="Y";
	}else{
		document.or_parameter.time_based_rule_yn.value="N";
	}
}
//IN071361 Ends