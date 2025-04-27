/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
------------------------------------------------------------------------------------------------------------------------------
Date			Edit History	Name			Rev.Date	Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
?             	100            	?              	?			?				created
03/04/2013    	IN035929 		Karthi L		?			?				When user Place in OR/CA, user should not see Service charges. 
13/04/2013    	IN039995 		Karthi L		?			?				OR Parameter for Facility->Even if "Billing" is Unchecked "Display Billing Information" can be checked and the setup can be saved. 
26/02/2014		IN047204		Karthi L	07/03/2014		Ramesh 				Order result screen for Radiology to provide a link to the DMS URL where the scanned radiology result document is uploaded to. 
14/04/2015		IN052649		Ramesh G									Previous orders - Default filter to be filtered by All or by specialty.
02/01/2017		IN061888		Karthi L									To record collection all at 1 go
31/10/2017		IN061892		Prakash C	31/10/2017		Ramesh G		Time alert frame for ML-MMOH-CRF_0544 (Pending Lab Order Specimen)
26/02/2018		IN066119		Raja S		26/02/2018		Ramesh G		ML-MMOH-CRF-1024
25/04/2020		IN071618		Ramesh G	25/04/2020		Ramesh G		PMG2019-MMS-CRF-0004
13/10/2022       37018           Venkat S                                     PMG2021-COMN-CRF-0080-US001
--------------------------------------------------------------------------------------------------------

*/ 
var function_id = "" ;
var result = false;
var message = "" ;
var flag = "" ;


function apply() {  

	var formObj = f_query_add_mod.document.or_parameter_for_facility
	var mode = formObj.refusal_text.value
	var behind_hrs = formObj.behind_hrs
	var ahead_hrs = formObj.ahead_hrs
	var reactivate_hrs = formObj.reactivate_hrs
	var expired_hrs = formObj.expired_hrs
	var discontinued_hrs = formObj.discontinued_hrs
	var intf_to_billing_days  = "";


	var oth_loc_prnt = formObj.oth_loc_print.value
	if(oth_loc_prnt == 'S' ){
		if(formObj.oth_specific_loc_name.value == ""){
			var msg1 = (getMessage('OTHER_LOC_PRINT','OR'))
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg1;
			return false
		}
	}

	var dischg_pat_prnt = formObj.dischg_pat_prnt.value
	if(dischg_pat_prnt == 'S' ){
		if(formObj.dischg_specific_loc_name.value == ""){
			var msg2 = (getMessage('DISCHARGE_LOC_PRINT','OR'))
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg2;
			return false
		}
	}

	if(allowNonZero(behind_hrs) == false){
	    behind_hrs.focus()
		alert(getMessage('VAL_NOT_ZERO','OR'))
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false
	}

	if(allowNonZero(ahead_hrs) == false){
	    ahead_hrs.focus()
		alert(getMessage('VAL_NOT_ZERO','OR'))
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false
	}
	if(allowNonZero(reactivate_hrs) == false){
	    reactivate_hrs.focus()
		alert(getMessage('VAL_NOT_ZERO','OR'))
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false
	}
	if(allowNonZero(expired_hrs) == false){
	    expired_hrs.focus()
		alert(getMessage('VAL_NOT_ZERO','OR'))
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false
	}

	if(allowNonZero(discontinued_hrs) == false)
	{
	    discontinued_hrs.focus()
		alert(getMessage('VAL_NOT_ZERO','OR'))
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false
	}

	if(formObj.checkBillingInstalled == "Y")
	{
		if(formObj.intf_to_billing_days)
		{
			intf_to_billing_days = formObj.intf_to_billing_days
			if(allowNonZero(intf_to_billing_days) == false)
			{
				intf_to_billing_days.focus()
				alert(getMessage('VAL_NOT_ZERO','OR'))
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
				return false
			}
		}
	}
	
	eval(formApply( f_query_add_mod.document.or_parameter_for_facility,OR_CONTROLLER));
	//alert("OR_CONTROLLER")
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	//alert("message")

	if( true ) {
		onSuccess();
	}
}


function onSuccess() {
	
	f_query_add_mod.location.href = "../../eOR/jsp/ORParamforFacilityAddModify.jsp?mode=2&function_id="+function_id;
}


function formReset () {
	var formObj = f_query_add_mod.document.or_parameter_for_facility;
}

function assignResult(_result, _message, _flag){
//	alert(_result +"  -  "+_message+"  -  "+_flag)
	result = _result ;
	message  = _message ;
	flag = _flag ;

}

function reset(){
	
		f_query_add_mod.location.href = f_query_add_mod.location.href = "../../eOR/jsp/ORParamforFacilityAddModify.jsp?mode=2&function_id="+function_id;
	
}

function populateDetails(ord_cat){
	var bean_id = document.or_parameter_for_facility.bean_id.value ;
	var facility_id = document.or_parameter_for_facility.facility.value ;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var whichMode = document.or_parameter_for_facility.mode.value
	if(ord_cat.value == 'S'){
		document.getElementById("oth_specific_locn").innerHTML = "&nbsp;&nbsp;&nbsp;<select name='loctype' id='loctype' onchange='populateLocationTypeDetails(this);'><option value=''>---"+getLabel("Common.defaultSelect.label","Common")+"---</option><option value='C'>"+getLabel("Common.clinic.label","Common")+"</option><option value='N'>"+getLabel("Common.nursingUnit.label","Common")+"</option></select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<SELECT name='oth_specific_loc_name' id='oth_specific_loc_name'><option value=''>---"+getLabel("Common.defaultSelect.label","Common")+"---</option></SELECT><img src='../../eCommon/images/mandatory.gif'></img>"
	}else{
		document.getElementById("oth_specific_locn").innerHTML = "&nbsp;";
		document.getElementById("location_type").innerHTML="&nbsp;";
	}


	xmlStr ="<root><SEARCH " ;
	xmlStr += ord_cat.name+"=\""+ ord_cat.value +"\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	//alert(xmlStr)
	if(ord_cat.name == "oth_loc_print" && ord_cat.value == "S"){
		xmlHttp.open( "POST", "ORParamforFacilityValidate.jsp?bean_id=" + bean_id + "&validate=ord_cat&facility_id="+facility_id, false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval(responseText ) ;
	}else{
		document.getElementById("oth_specific_locn").innerHTML = "&nbsp;";
		document.getElementById("location_type").innerHTML="&nbsp;";
	}

}

function addOrderTypeList(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.or_parameter_for_facility.oth_specific_loc_name.add(element);
}


function clearL2List( docObj ) {
	var len = eval(docObj+".or_parameter_for_facility.oth_specific_loc_name.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".or_parameter_for_facility.oth_specific_loc_name.remove(\"atc_class_l2_code\")") ;
	}
	var tp = " ---"+getLabel("Common.defaultSelect.label","Common")+"---" ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".or_parameter_for_facility.oth_specific_loc_name.add(opt)") ;
}

function populateDischgPatDetails(ord_cat){
	var bean_id = document.or_parameter_for_facility.bean_id.value ;
	var facility_id = document.or_parameter_for_facility.facility.value ;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	if(ord_cat.value == 'S'){
		//alert("heres :");
		document.getElementById("dischg_specific_locn").innerHTML = "&nbsp;&nbsp;&nbsp;<select name='loctype1' id='loctype1' onchange='populateLocationTypeDetails1(this);'><option value=''>---"+getLabel("Common.defaultSelect.label","Common")+"---</option><option value='C'>"+getLabel("Common.clinic.label","Common")+"</option><option value='N'>"+getLabel("Common.nursingUnit.label","Common")+"</option></select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<SELECT name='dischg_specific_loc_name' id='dischg_specific_loc_name'><option value=''>---"+getLabel("Common.defaultSelect.label","Common")+"---/option></SELECT><img src='../../eCommon/images/mandatory.gif'></img>"
	}else{
		document.getElementById("dischg_specific_locn").innerHTML = "&nbsp;";
		document.getElementById("location_type1").innerHTML="&nbsp;";
	}
	xmlStr ="<root><SEARCH " ;
	xmlStr += ord_cat.name+"=\""+ ord_cat.value +"\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	if(ord_cat.name == "dischg_pat_prnt" && ord_cat.value == "S"){
		xmlHttp.open( "POST", "ORParamforFacilityValidate.jsp?bean_id=" + bean_id + "&validate=ord_cat1&facility_id="+facility_id, false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval(responseText ) ;
	}else{
		document.getElementById("dischg_specific_locn").innerHTML = "&nbsp;";
		document.getElementById("location_type1").innerHTML="&nbsp;";
	}
}


function addDischgPatList(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.or_parameter_for_facility.dischg_specific_loc_name.add(element);
}


function clearDischgPatList( docObj ) {
	var len = eval(docObj+".or_parameter_for_facility.dischg_specific_loc_name.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".or_parameter_for_facility.dischg_specific_loc_name.remove(\"atc_class_l2_code\")") ;
	}
	var tp = " ---"+getLabel("Common.defaultSelect.label","Common")+"---" ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".or_parameter_for_facility.dischg_specific_loc_name.add(opt)") ;
}


function loadEnableDisable(){

	var formObj = document.or_parameter_for_facility;
	if(formObj)
	{
		if(formObj.refusal_destination.checked == false)
		{
			formObj.refusal_text.value="";
		}
	
		//if(formObj.referral_destination.checked == false)
		//{
		//	formObj.referral_text.value="";
		//}
		if(formObj.intf_to_billing)
		{
			if(formObj.intf_to_billing.checked == false)
			{
				formObj.intf_to_billing_days.checked = false
				formObj.intf_to_billing_days.disabled = true
				formObj.disp_bill_info.checked = false;  // added for IN039995
				formObj.disp_bill_info.disabled = true; // added for IN039995
				
			}
		}
	}
}

function enableDisable(){

	var formObj = document.or_parameter_for_facility
	if(formObj.intf_to_billing.checked == false){
		formObj.intf_to_billing_days.checked = false
		formObj.intf_to_billing_days.disabled = true
		formObj.dispBillChecked.value = ""; // added for IN035929
		formObj.disp_bill_info.checked = false;  // added for IN035929
		formObj.disp_bill_info.disabled = true; // added for IN039995

	}else{
		formObj.intf_to_billing_days.disabled = false
		formObj.disp_bill_info.disabled = false // added for IN039995
	}
}
//////////////////////////Added by Siva Kumar 27/08/2003////////////////////////////////////////////
function populateLocationTypeDetails(obj){
	var bean_id = document.or_parameter_for_facility.bean_id.value ;
	var facility_id = document.or_parameter_for_facility.facility.value ;
	var locType=obj.value;


	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var whichMode = document.or_parameter_for_facility.mode.value;

	var option1 = "<option value='' ";
    if (obj.value=='') option1 = option1 + "selected";
    option1 = option1 + ">---"+getLabel("Common.defaultSelect.label","Common")+"---</option>";

	var option2 = "<option value='C' ";
    if (obj.value=='C') option2 = option2 + "selected";
    option2 = option2 + ">"+getLabel("Common.clinic.label","Common")+"</option>";

	var option3 = "<option value='N' ";
    if (obj.value=='N') option3 = option3 + "selected";
    option3 = option3 + ">"+getLabel("Common.nursingUnit.label","Common")+"</option>";

    var html = option1 + option2 + option3;
    document.getElementById("oth_specific_locn").innerHTML = "&nbsp;";
    if (document.getElementById("location_type") != null) {
		document.getElementById("location_type").innerHTML="&nbsp;";
	}
	document.getElementById("oth_specific_locn").innerHTML = "&nbsp;&nbsp;&nbsp;<select name='loctype' id='loctype' onchange='populateLocationTypeDetails(this);'>"+html+"</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<SELECT name='oth_specific_loc_name' id='oth_specific_loc_name'><option value=''>---"+getLabel("Common.defaultSelect.label","Common")+"---</option></SELECT><img src='../../eCommon/images/mandatory.gif'></img>"


	xmlStr ="<root><SEARCH " ;
	xmlStr += "oth_loc_print=\"S\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	//alert(xmlStr)
	xmlHttp.open( "POST", "ORParamforFacilityValidate.jsp?bean_id=" + bean_id + "&validate=ord_cat&facility_id="+facility_id+"&locType="+locType, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	eval(responseText ) ;
}
////////////////////////////////////////////////////////
function populateLocationTypeDetails1(obj){
	var bean_id = document.or_parameter_for_facility.bean_id.value ;
	var facility_id = document.or_parameter_for_facility.facility.value ;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var locType = obj.value;

	var option1 = "<option value='' ";
    if (obj.value=='') option1 = option1 + "selected";
    option1 = option1 + ">---"+getLabel("Common.defaultSelect.label","Common")+"---</option>";

	var option2 = "<option value='C' ";
    if (obj.value=='C') option2 = option2 + "selected";
    option2 = option2 + ">"+getLabel("Common.clinic.label","Common")+"</option>";

	var option3 = "<option value='N' ";
    if (obj.value=='N') option3 = option3 + "selected";
    option3 = option3 + ">"+getLabel("Common.nursingUnit.label","Common")+"</option>";

    var html = option1 + option2 + option3

	document.getElementById("dischg_specific_locn").innerHTML = "&nbsp;"
    if (document.getElementById("location_type1") != null) {
			document.getElementById("location_type1").innerHTML="&nbsp;";
		}
	document.getElementById("dischg_specific_locn").innerHTML = "&nbsp;&nbsp;&nbsp;<select name='loctype1' id='loctype1' onchange='populateLocationTypeDetails1(this);'>"+html+"</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<SELECT name='dischg_specific_loc_name' id='dischg_specific_loc_name'><option value=''>---"+getLabel("Common.defaultSelect.label","Common")+"---</option></SELECT><img src='../../eCommon/images/mandatory.gif' align=center></img>"

	//document.getElementById("dischg_specific_locn").innerHTML = "<select name='loctype1' id='loctype1' onchange='populateLocationTypeDetails1(this);'>"+html+"</select>&nbsp;<SELECT name='dischg_specific_loc_name' id='dischg_specific_loc_name'><option value=''>----- Select -----</option></SELECT>"
	xmlStr ="<root><SEARCH " ;
	xmlStr += "dischg_specific_loc_name=\"S\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ORParamforFacilityValidate.jsp?bean_id=" + bean_id + "&validate=ord_cat1&facility_id="+facility_id+"&locType="+locType, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert(responseText ) ;
	eval(responseText ) ;
}


function func()
{
	if(document.forms[0].refusal_text)
	{
		if(document.forms[0].refusal_destination.checked)
		{
			document.forms[0].refusal_text.style.visibility="visible";
		}
		else
		{
			document.forms[0].refusal_text.style.visibility="hidden";
			//document.forms[0].refusal_text.value="";
		}
	} 
}

/*function funcReferral()
{
	if(document.forms[0].referral_text)
	{
		if(document.forms[0].referral_destination.checked)
		{
			document.forms[0].referral_text.style.visibility="visible";
		}
		else
		{
			document.forms[0].referral_text.style.visibility="hidden";
			//document.forms[0].referral_text.value="";
		}
	} 

} */

function callreferral(target,code)
{
	if(document.or_parameter_for_facility.ext_order_referral_desc!=null)
	{
		if(document.or_parameter_for_facility.ext_order_referral_desc.value!="")
		{
			Lookupwindow(target,code);
		}
	}
	if(target.value=="")
	{
		code.value="";
	}
}

 async function Lookupwindow(target,code)
{
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0]   = document.or_parameter_for_facility.referral_sql.value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;
	let retVal = await CommonLookup(getLabel("Common.referral.label", "COMMON"), argumentArray);
    let ret1 = unescape(retVal);
	let arr = ret1.split(",");

    if (arr[1] === undefined)
	{
	    arr[0] = "";
	    arr[1] = "";
	}

	if (retVal != null && retVal !== "")
	{
	    target.value = arr[1] || "";  // Set to empty string if undefined or null
	    code.value = arr[0] || "";    // Set to empty string if undefined or null
	}

		else
		{
			target.value = "";
			code.value = "" ;
		}
}
/*Added by Uma on 8/28/2009 for PMG20089 -CRF 640*/
function validatePostedNotBilledReceipted(obj)
{
	if(obj.checked==true)
	{
		obj.checked = true;
		obj.value = "Y";
	}
	else
	{
		obj.checked = false;
		obj.value = "N";
	}
}

function validateBilledButNotReceipted(obj)
{
	if(obj.checked==true)
	{
		obj.checked = true;
		obj.value = "Y";
	}
	else
	{
		obj.checked = false;
		obj.value = "N";
	}
}

function validNumber(event)
{
    var strCheck = '0123456789';
    var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) 
		return false;  // Not a valid key
	else
		return true;
}
/* End Here*/

function stlmtExtOrders(obj)
{
	if(obj.checked)
		obj.value = "Y";
	else
		obj.value = "N";
}

function stlmtOPOrders(obj)
{
	if(obj.checked)
		obj.value = "Y";
	else
		obj.value = "N";
}

function stlmtEMOrders(obj)
{
	if(obj.checked)
		obj.value = "Y";
	else
		obj.value = "N";
}
// added for  IN035929
function setBillDispStauts(obj){
	if(obj.checked){
		document.or_parameter_for_facility.disp_bill_info.value="Y";
	}else{
		document.or_parameter_for_facility.disp_bill_info.value="N";
	}
}
//IN043081 Starts
function setLimitCatalogToLocChk(obj){
	if(obj.checked){
		document.or_parameter_for_facility.limit_catalog_to_loc.value="Y";
	}else{
		document.or_parameter_for_facility.limit_catalog_to_loc.value="N";
	}
	
}
//IN043081 Ends
// IN047204 - Start
function enableExtLink(obj) {
	if(obj.checked){
		document.or_parameter_for_facility.dms_ext_link_yn.value="Y";
	}else{
		document.or_parameter_for_facility.dms_ext_link_yn.value="N";
	}
}
// IN047204 - End
//IN052649 - Start.
function validateForZero(obj)
{
	var obj_value = obj.value;
	if(obj_value!=""){
		if (obj_value == 0) {
			alert(getMessage('VAL_NOT_ZERO','OR'));		
			obj.select();		
		}else{
			var sequence = "1234567890:";		   
		   var obj_length = obj_value.length;

		   for (i=0; i<obj_length; i++)   {
				if(sequence.indexOf(obj_value.charAt(i))==-1){
					alert(getMessage('ONLY_POSITIVE_NUM','OR'));					
					obj.select();
					return false;
				}
		   }
		}
	}
}
//IN052649 - End.

function enableRecordCollection(obj){
	if(obj.checked){
		document.or_parameter_for_facility.select_all_for_rec_collect_yn.value="Y";
	}else{
		document.or_parameter_for_facility.select_all_for_rec_collect_yn.value="N";
	}
}
//IN061892 starts
//IN071618 Start.
function enableSplitUnbilledOrders(obj){
	if(obj.checked){
		document.or_parameter_for_facility.splitUnbilledOrders.value="Y";
	}else{
		document.or_parameter_for_facility.splitUnbilledOrders.value="N";
	}
}
//IN071618 End.
function emptyValidate(obj)
{
	var obj_value = obj.value;
	if(obj_value==""){	
		alert(getMessage('TIME_FRAME_EMPTY_ALERT','OR'));
		document.getElementById('lab_not_registered').select();
	}
	else if(obj_value == 0){
		alert(getMessage('VAL_NOT_ZERO','OR'));		
		document.getElementById('lab_not_registered').select();
	}
}
//IN061892 ends
//IN066119 Starts
function setHideSpecimenType(obj){
	if(obj.checked){
		document.or_parameter_for_facility.hide_specimentype.value="Y";
	}else{
		document.or_parameter_for_facility.hide_specimentype.value="N";
	}
}
function setHideReportingPrac(obj){
	if(obj.checked){
		document.or_parameter_for_facility.hide_reportingprac.value="Y"; 
	}else{
		document.or_parameter_for_facility.hide_reportingprac.value="N";
	}
}
//IN066119 Ends

// 37018 begin
function setApplyOrderingRulesByPractitionerType(obj){
	if(obj.checked){
		document.or_parameter_for_facility.applyOrderingRulesByPractitionerType.value="Y"; 
	}else{
		document.or_parameter_for_facility.applyOrderingRulesByPractitionerType.value="N";
	}
}
//37018 end

