/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
27/02/2014				42063			        Suresh R           27/02/2014        Suresh R     AMS-CRF-0054(Added Item Based IssueReturn)
26/04/2016				56060				Badmavathi B					  					PMG2015-CRF-INT-ST-0001(Use 'Authorize at Issue Store' privilege to Authorize)	
1/2/2018				66368					Shazana											GHL-CRF-0503 Split Batch
--------------------------------------------------------------------------------------------------------------------------------------------
*/
function onSuccess() {
	f_query_add_mod.document.location.reload();
}
function apply() {
	var formObj = f_query_add_mod.document.formParameterForFacility;
	var fields = new Array(formObj.curr_proc_month, formObj.curr_proc_year);
	var names = new Array(getLabel("Common.CurrentProcessingMonth.label", "Common"), getLabel("Common.CurrentProcessingYear.label", "Common"));
	var errorPage = "../../eCommon/jsp/error.jsp";
	if (validateForm()) { 
		var blankObject = null;
		blankObject = checkSTFields(fields, names, messageFrame);
		if (blankObject == true) {
			var resultText = formApply(formObj, ST_CONTROLLER);
			eval(resultText);
			messageFrame.location.href = errorPage + "?err_num=" + message;
			if (result) {
				onSuccess();
			}
		}
	}
}
function reset() {
		if(f_query_add_mod.document.formParameterForFacility.bean_batch_look_up_entry_yn.value=="Y")
	f_query_add_mod.document.formParameterForFacility.appl_batches_in_phy_inv_entry.disabled=false;
	else
	f_query_add_mod.document.formParameterForFacility.appl_batches_in_phy_inv_entry.disabled=true;
	f_query_add_mod.document.formParameterForFacility.reset();
}
function checkLength() {
	var formObj = document.formParameterForFacility;
	if (!SPCheckMaxLen(getLabel("Common.remarks.label", "Common"), formObj.adjustment_remarks, 200)) {
		return false;
	}
	return true;
}
function checkLength1() {
	var formObj = f_query_add_mod.document.formParameterForFacility;
	if (!SPCheckMaxLen1(getLabel("Common.remarks.label", "Common"), formObj.adjustment_remarks, 200)) {
		return false;
	}
	return true;
}
function SPCheckMaxLen1(lab, obj, max) {
	if (obj.value.length > max) {
		obj.focus();
		return false;
	} else {
		return true;
	}
}
function validateForm() {
	var errorPage = "../../eCommon/jsp/error.jsp";
	var message = "";
	var formObj = f_query_add_mod.document.formParameterForFacility;
	if (!checkLength1()) {
		message = "REMARKS_CHAR_EXCEEDS_LIMIT";
		messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
		return false;
	}
	return true;
}
async function searchRemarks(objCode, objDesc) {
	objCode_value = "";
	objDesc_value = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.formParameterForFacility.language_id.value;
	dataTypeArray[0] = STRING;
	dataNameArray[1] = "module_id";
	dataValueArray[1] = "ST";
	dataTypeArray[1] = STRING;
	dataNameArray[2] = "trn_type";
	dataValueArray[2] = document.formParameterForFacility.rem_trans_type.value;
	dataTypeArray[2] = STRING;
	argumentArray[0] = document.formParameterForFacility.SQL_ST_TRN_REMARKS_LOOKUP_SELECT.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "4,5";
	argumentArray[5] = objDesc_value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.remarks.label", "Common"), argumentArray);
	var ret1=unescape(returnedValues);
 	var arr=ret1.split(",");
 	if(arr[1]==undefined) 
	{
 		arr[0]="";	
 		arr[1]="";	
	}
	if ((returnedValues != null) && (returnedValues != "")) {
		objCode.value = arr[0];
		objDesc.value = arr[1];
	}
}
function checkRecordsForIssue(obj){
	if(obj.checked == false && document.formParameterForFacility.records_exist_for_issue.value=="Y"){
		alert(getMessage("UNFINALIZED_TRN_EXITS_ST_PARAM","ST"));
		obj.checked = true;
		obj.value = "Y";
	}
}
function checkRecordsForIssueReturn(obj){
	if(obj.checked == false && document.formParameterForFacility.records_exist_for_issueReturn.value=="Y"){
		alert(getMessage("UNFINALIZED_TRN_EXITS_ST_PARAM","ST"));
		obj.checked = true;
		obj.value = "Y";
	}
}
function checkRecordsForStockTransfer(obj){
	if(obj.checked == false && document.formParameterForFacility.records_exist_Stock_transfer.value=="Y"){
		alert(getMessage("UNFINALIZED_TRN_EXITS_ST_PARAM","ST"));
		obj.checked = true;
		obj.value = "Y";
	}
}
//Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001 starts 
function checkAllowAuthorizeAtIssueStore(obj){
	if(obj.checked == false)
		alert(getMessage("NOT_ALLOW_AUTHORIZE_AT_ISS_STORE","ST"));
	else
		alert(getMessage("ALLOW_AUTHORIZE_AT_ISS_STORE","ST"));
}
//Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001 ends
function toggleObject(obj){
	if(obj.checked == false){
		document.formParameterForFacility.appl_batches_in_phy_inv_entry.options.selectedIndex=0;
		document.formParameterForFacility.appl_batches_in_phy_inv_entry.disabled=true;
	   return;
		}
   if(obj.checked == true)
	{
 	  document.formParameterForFacility.appl_batches_in_phy_inv_entry.disabled=false;
      return;
	}	
}
function checkRecordsPhyInv(obj)
{     var code;
	  var selectedCode=document.formParameterForFacility.appl_batches.value;
	  if(selectedCode=='GRN')
	  code = 1;
	  else
	  code = 0;
 if(document.formParameterForFacility.records_exist_phy_inv.value=='Y')
	{
	alert("Records Exists In The Physical Invenory Entry");
    document.formParameterForFacility.appl_batches_in_phy_inv_entry.options.selectedIndex=code;
	return;
	}

}

//records_exist_phy_inv

//Added by Sakti Sankar against Inc#-29441 for defaulting item search criteria

function getDefaultItmSearch()
{
	var formObj=document.formParameterForFacility;
	//alert(formObj.dflt_search_item.value);
	formObj.dflt_item_search.value=formObj.dflt_search_item.value;
	//formObj.dflt_mfg_mode.value=formObj.dflt_manfg_mode.value;//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013

}

//Added by Rabbani #Inc no:30909 on 12/03/12
//Starts
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
//ends
//Added By Sakti against CRF# - RUT-CRF-0081 icn#34757
function enabledisable(obj){
	if(obj.value == "N"){
		document.formParameterForFacility.appl_batches_in_phy_inv_entry.options.selectedIndex=0;
		document.formParameterForFacility.appl_batches_in_phy_inv_entry.disabled=true;
	   return;
		}
   if(obj.value == "Y" || obj.value == "B")
	{
 	  document.formParameterForFacility.appl_batches_in_phy_inv_entry.disabled=false;
      return;
	}	
}
//Added ends

//Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013 Starts -->
function getdurationforexpdate(obj)
{
	if(!CheckSplChars(obj)){ //Added by Rabbani #Inc no:38564 on 12-Mar-2013
	  alert(getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED", "ST"));
	  obj.focus();
	  return false;
	}else{
	  var formObj=document.formParameterForFacility;
	  if(formObj.dflt_Durn_for_ExpDate.value== "" )
	  formObj.dflt_Durn_for_ExpDate.value = 0;
	  if(formObj.dflt_Durn_for_ExpDate.value== "00" || formObj.dflt_Durn_for_ExpDate.value== "000" )
	  formObj.dflt_Durn_for_ExpDate.value = 0;
      if(formObj.dflt_Durn_for_ExpDate.value== "---" || formObj.dflt_Durn_for_ExpDate.value== "--" || formObj.dflt_Durn_for_ExpDate.value== "-" )
	  formObj.dflt_Durn_for_ExpDate.value = 0;
	/*var dflt_durn_leng = formObj.dflt_Durn_for_ExpDate.value;
	if(dflt_durn_leng.length>1){
	var dflt_Durn_for_ExpDate = formObj.dflt_Durn_for_ExpDate.value;
	if(dflt_Durn_for_ExpDate.charAt(1) == "-")
	formObj.dflt_Durn_for_ExpDate.value = dflt_Durn_for_ExpDate.charAt(0);
	if(dflt_Durn_for_ExpDate.charAt(2) == "-"){
	formObj.dflt_Durn_for_ExpDate.value = dflt_Durn_for_ExpDate.substring(0,2);
	if(formObj.dflt_Durn_for_ExpDate.value.charAt(1) == "-"){
	formObj.dflt_Durn_for_ExpDate.value = dflt_Durn_for_ExpDate.charAt(0);
	 }
	}
  } */
	
} 
}
//ends
/*function CheckForDispChars(event){
  var formObj=document.formParameterForFacility;
    var strCheck = '0123456789-';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
	var dflt_durn_leng = formObj.dflt_Durn_for_ExpDate.value; 
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}*/
function CheckForDispChars(event){
    var strCheck = '0123456789-';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode); 
    if (strCheck.indexOf(key) == -1) return false;   
	//if( (event.keyCode >= 97) && (event.keyCode <= 122))
	//return (event.keyCode -= 32);
     formObj = document.formParameterForFacility;
	 var dflt_Durn_for_ExpDate = formObj.dflt_Durn_for_ExpDate.value;
     var dflt_durn_leng = formObj.dflt_Durn_for_ExpDate.value;
     var selectedText = ShowSelection(formObj.dflt_Durn_for_ExpDate); 
	 if(selectedText != 0)
		return true;
     if(dflt_durn_leng.length>=1){
	 if( (event.keyCode == 45)){
	 if(dflt_Durn_for_ExpDate.charAt(0) != "-"){
	formObj.dflt_Durn_for_ExpDate.value =  "-"+formObj.dflt_Durn_for_ExpDate.value;
	}
	 return false;
	 }
	}
	 if(dflt_durn_leng.length>=3){
	 if(dflt_Durn_for_ExpDate.charAt(0) == "-")
     return true;
	 else
	 return false;
    }
	
	//return false ; 
}
//Added by Rabbani #Inc no:38564 on 12-Mar-2013
function CheckSplChars(Obj){
        var str = Obj.value;
        var specCharsExist = true;
        for (u=0;u<str.length;u++){
        if (((str.charCodeAt(u)>=48) && (str.charCodeAt(u)<=57))||(str.charCodeAt(u) ==45));
         else{
            specCharsExist = false;
            break;
            }
        }
        return specCharsExist;
 }
function ShowSelection(id)
{
  var selectedText;
  // IE version
  if (document.selection != undefined)
  {
    id.focus();
    var sel = document.selection.createRange();
    selectedText = sel.text;
  }
  // Mozilla version
  else if (id.selectionStart != undefined)
  {
    var startPos = id.selectionStart;
    var endPos = id.selectionEnd;
    selectedText = id.value.substring(startPos, endPos)
  }
   return selectedText;
}
//Added by suresh.r on 31-01-2014 against AMS-CRF-0054  beg
function checkRecordsForIssueReturnBaseOn(obj)
{    
	if(document.formParameterForFacility.records_exist_for_issueReturn.value=="Y")
	{
		alert(getMessage("UNFINALIZED_TRN_EXITS_ST_PARAM","ST"));
		if(document.formParameterForFacility.chk_iss_ret_based_on.value=='D')
			obj.options.selectedIndex=0;
	    else
	    	obj.options.selectedIndex=1;
		return;
	}
}
//Added by suresh.r on 31-01-2014 against AMS-CRF-0054  end

//Added by suresh.r on 09-03-2015 against MMS-QH-CRF-0205 Inc 52253 beg
function checkRecordsForAllowEqvUOMs(obj){
	if(obj.checked == false && document.formParameterForFacility.records_exist_for_AllowEqvUOM.value=="Y"){
		alert(getMessage("UNFINALIZED_TRN_EXITS_ST_PARAM","ST"));
		obj.checked = true;
		obj.value = "Y";
	}
}
//Added by suresh.r on 09-03-2015 against MMS-QH-CRF-0205 Inc 52253 end
 
/*Added for GHL-CRF-0503 SPLIT BATCH start*/
function includeZeroStock(obj){
	if(obj.checked==false){
		document.formParameterForFacility.include_Zero_Stock_QOH.checked	= false;
		document.formParameterForFacility.include_Zero_Stock_QOH.disabled	= true;
	}else{
		document.formParameterForFacility.include_Zero_Stock_QOH.disabled	= false;
	}	
}
/*Added for GHL-CRF-0503 SPLIT BATCH end*/
//Added below function for MO-CRF-20166
function getissueHistorycheck(obj)
{
 var validate = isValidIntegerZero(obj);
 if(validate){
	var formObj=document.formParameterForFacility;
	
	if(formObj.issue_history_durn.value== "0" || formObj.issue_history_durn.value== "00" || formObj.issue_history_durn.value== "000" ){
	  alert("Value must be between 1 to 365 Days");
	  formObj.issue_history_durn.value = "";
	}
	//alert(formObj.issue_history_durn.value)
	if(formObj.issue_history_durn.value >365 ){
	  alert("Value must be between 1 to 365 Days");
	  formObj.issue_history_durn.value = "";
	}
 }//Adding end for MO-CRF-20166
}