/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var result     =   false ;
var message     =   "" ;
var flag        =   "" ;

function clearBean(){
	var dummy="dummy";
	var xmlStr ="<root><SEARCH ";
	xmlStr+=" dummy=\""+ dummy + "\" ";
	xmlStr +=" /></root>";
	return fieldValidation(xmlStr,"clearBean");
}
function fieldValidation(xmlStr,source){
	var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");    
	xmlHttp.open("POST","VerifyCheckListValidation.jsp?func_mode="+source,false);
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
	//alert(responseText);
    responseText = responseText.replace(/<[^>]*>|\s+/g, '');
	eval(responseText);
    return true;
}  

function apply(){
	clearBean();
	//getFunctionString("CheckOutFromRecoveryRoom.jsp","27");
	//console.log(document.getElementById("f_add_modify").contentWindow.document.getElementById("VerifyCheckListForm"));
	var formObj=document.getElementById("f_add_modify").contentWindow.document.getElementById("VerifyCheckListForm");
	formObj.submit();
}
function reset(){
	var formObj=document.frames.f_add_modify.document.VerifyCheckListForm;
	var formObj1=document.frames.f_confirm.document.VerifyCheckListConfirmForm;
	formObj.reset();
	formObj1.reset();
}
function checkForMandatoryFields(formObj){
	var msg = getMessage("CANNOT_BE_BLANK","OT");
	var msgArray = msg.split("&");
	if(formObj.speciality.value ==""){
		alert(msgArray[0]+" Speciality "+(msgArray[1]));
		return true;
	}
	return false;
}
async function openCheckListRemarksWindow(row_num,previous_remarks,disable_all,size,checklist_remarks1){

	var formObj = document.VerifyCheckListForm;
	var remarks_title = encodeURIComponent(getLabel("Common.remarks.label","common")+"  "+eval("formObj.description_"+row_num).value);
	var checklist_remarks = eval("formObj.remarks_"+row_num).value;
//	Commented  By DhanasekarV on 23/11/2010 against  IN025190
	//checklist_remarks = encodeURIComponent(checklist_remarks,"UTF-8");


//Modified by DhanasekarV against issue IN025412 on 8/12/2010

	  var formObj1 =  parent.frames[6].document.forms[0];
      formObj1.previous_remarks.value = previous_remarks;
	  formObj1.checklist_remarks.value = checklist_remarks;	 
	  formObj1.mode.value = "LOAD";	 	
	 parent.frames[6].submit1();
//end 

	var dialogHeight	= "70vh";
	var dialogWidth		= "45vw";
	var dialogTop		= "145";
	var dialogLeft		= "350";
	var center			= "1";
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";
	//var retVal = window.showModalDialog("../../eOT/jsp/VerifyCheckListRemarks.jsp?row_num="+row_num+"&remarks_title="+remarks_title+"&previous_remarks="+previous_remarks+"&checklist_remarks="+checklist_remarks+"&disable_all="+disable_all+"&no_of_verifications="+formObj.no_of_verifications_orig.value+"&checklist_stage="+formObj.checklist_stage.value+"&size="+size,arguments, features);

var retVal = await window.showModalDialog("../../eOT/jsp/VerifyCheckListRemarks.jsp?row_num="+row_num+"&remarks_title="+remarks_title+"&disable_all="+disable_all+"&no_of_verifications="+formObj.no_of_verifications_orig.value+"&checklist_stage="+formObj.checklist_stage.value+"&size="+size,arguments, features);
	retVal=encodeURIComponent(retVal,"UTF-8");

	if(retVal==null || retVal=="null")
		eval("formObj.remarks_"+row_num).value = checklist_remarks;
	else if(retVal=="undefined")
		eval("formObj.remarks_"+row_num).value = checklist_remarks;
	else
		eval("formObj.remarks_"+row_num).value = retVal;

//Modified by DhanasekarV against issue IN025412 on 8/12/2010
  var formObj2 =  parent.frames[6].document.forms[0];      
	  formObj2.mode.value = "UNLOAD";	 	
	 parent.frames[6].submit1();
//end
	
//	Commented  By DhanasekarV on 23/11/2010 against  IN025190	
/*	if(retVal==null || retVal=="null")
		eval("formObj.remarks_"+row_num).value = decodeURIComponent(checklist_remarks);
	else if(retVal=="undefined")
		eval("formObj.remarks_"+row_num).value = decodeURIComponent(checklist_remarks);
	else
		eval("formObj.remarks_"+row_num).value = retVal;*/

}
function storeCheckListRemarks(row_num){
	var formObj = document.VerifyCheckListRemarksForm;
	window.returnValue=formObj.checklist_remarks.value;
	window.close();
}
function assignCheckboxValue(obj){
	if(obj.checked)
		obj.value="Y";
	else
		obj.value="N";
}
async function assignConfirm(obj,user_id){
	if(obj.checked==true){
		var dialogHeight= "10"; //"3" ;
		var dialogWidth	= "26"; //"19" ;
		var dialogTop = (window.screen.availHeight-dialogHeight)/3; //"210" ;
		var dialogLeft = (window.screen.availWidth-dialogWidth)/4;  // "240" ;
//		var dialogTop = "210" ;
//		var dialogLeft = "220" ;
		var center = "1" ;
		var status="no";
		var scroll="no";
	    var myBars = 'directories=no;location=no;menubar=no' ;
		var features	= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop+myBars;
		var arguments	= "" ;
		var retVal = await window.showModalDialog("../../eOT/jsp/VerifyCheckListPIN.jsp?user_id="+user_id,arguments,features);
		var checklist_formObj=parent.frames.f_add_modify.document.VerifyCheckListForm;
		if(retVal=="false" || retVal=="undefined" || retVal!="true"){
			checklist_formObj.confirm_yn.value="N";
			obj.checked=false;
			obj.value="N";
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var xmlStr ="<root></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=Verify_check_list_clear_value",false);
			xmlHttp.send(xmlDoc);
			var retVal = localTrimString(xmlHttp.responseText); 
			if(retVal!="" ){

			}
		}else if(retVal=="true"){
			checklist_formObj.confirm_yn.value="Y";
			obj.value="Y";
		}

	}
	
}

function focus_ok(e)
{
	var formObj = document.CheckListPINForm;
		if(event.keyCode==13){
		if(formObj.pin_no.value!=''){
			return event.returnValue=false;
		}else{
				return event.returnValue=false;
		}

	}
}
function validateCheckListPIN(obj){
	var formObj = document.CheckListPINForm;
	var user_id = (formObj.user_id.value).toUpperCase();
	var pin_no	= (formObj.pin_no.value).toUpperCase();
	/* Added by lakshmanan for MMS-ME-SCF-0051 (password encryption) */
	var key = CryptoJS.enc.Base64.parse('u/Gu5posvwDsXUnV5Zaq4g==');
	var iv = CryptoJS.enc.Base64.parse('5D9r9ZVzEYYgha93/aUK2w==');
	var encrypted_pin = CryptoJS.AES.encrypt(pin_no,key,{ mode: CryptoJS.mode.CBC, padding: CryptoJS.pad.Pkcs7, iv: iv});
	/*end (password encryption)*/
	//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr  = "<root><SEARCH ";
	xmlStr += " bean_id=\""+ formObj.bean_id.value + "\" ";
	xmlStr += " bean_name=\""+ formObj.bean_name.value + "\" ";
	xmlStr += " pin_no=\""+ encrypted_pin + "\" "; //  MMS-ME-SCF-0051 (password encryption)
	xmlStr += " user_id=\""+ user_id + "\" ";
	xmlStr +=" /></root>";
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","VerifyCheckListValidation.jsp?func_mode=validateUserPIN",false);
	xmlHttp.send(xmlDoc);
	if(trimString(xmlHttp.responseText)=="Y"){
		window.returnValue = "true";
		window.close();
	}else{
		//alert("Invalid PIN");
		alert(getMessage("APP-OT0063","OT"));
		formObj.pin_no.select();
		formObj.pin_no.focus();
		return false;
	}
}

function identifyKey(eventObj){
	if(eventObj.keyCode==13){
		document.getElementById("btnOK").click();
		return false;
	}
}

function CodeArrest() 
{
    if((window.event.button == 2) || (window.event.button == 3) || (window.event.button == 4)) 
	{
        alert("Welcome to eHIS");
    }
}

function lockKey()
{
    if(event.keyCode == 93)
		alert(getMessage("WELCOME",'Common'));
	
}


function value_clear()
{
	var row_val=document.forms[0].size.value;
	var column_val=document.forms[0].current_level.value;
	for (var i=1;i<=row_val ;i++ )
	{
		for (var j=1;j<=column_val ;j++ )
	{
			
			if(eval("document.forms[0].chkbox_value_"+i+"_"+j).disabled==false && eval("document.forms[0].chkbox_value_"+i+"_"+j).checked==true)
		{
			eval("document.forms[0].chkbox_value_"+i+"_"+j).checked=false;
		}

	}
	}

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=Verify_check_list_clear_value",false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText); 
	if(retVal!="" ){

	}
			parent.window.close();

}


function maintain_value()
{
	var row_val=document.forms[0].size.value;
	var column_val=document.forms[0].no_of_verifications_orig.value;
	var row_val=document.forms[0].size.value;
	var final_vals="";
	var selected_vals="";
	var selected_vals1="";
	var chech_unchk_vals="";
	var chech_unchk_vals_ses="";

	for (var i=1;i<=row_val ;i++ )
	{
		for (var j=1;j<=column_val ;j++ )
	{
			if(eval("document.forms[0].checklist_type_"+j).value =="L")
			{
				selected_vals=eval("document.forms[0].total_value_"+i+"_"+j).value +"|"+eval("document.forms[0].list_value_"+i+"_"+j).value 
			}else
			{
				selected_vals=eval("document.forms[0].total_value_"+i+"_"+j).value +"|"+eval("document.forms[0].chkbox_value_"+i+"_"+j).value 
			}
				selected_vals1 =selected_vals+"|"+eval("document.forms[0].remarks_"+j).value ;
				final_vals +=selected_vals1+"$";
	}
	}

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var modify="modify";
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=Verify_check_list&final_vals="+final_vals+"&mode="+modify,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText); 
	if(retVal!="" ){
			parent.window.close();
	}else
	{
		parent.window.close();
	}
}

function localTrimString(sInString) {
  return sInString.replace(/^\s+|\s+$/g,"");
}


function disable_reset1()
{
	if(document.forms[0].access.value=="NNNNN")
	{
parent.frames[0].document.forms[0].reset.disabled=true;
	}else
	{
parent.frames[0].document.forms[0].reset.disabled=false;
	}
}

function disable_reset()
{
var delay = function() { disable_reset1(); };

setTimeout(delay,1200);
}
//Added on 12/24/2010 by ANitha
function disable_apply_button()
{
	var checklist_stage_val=document.forms[0].checklist_stage.value;
	var no_of_verifications_val=document.forms[0].no_of_verifications_orig.value;
	var apply_flg=document.forms[0].apply_flag.value;
	if(apply_flg == null)apply_flg="";
	if(document.forms[0].access.value == "NNNNN")
	{
		apply_flg="";
	}
	if((checklist_stage_val == "C10" && no_of_verifications_val < 1) ||(checklist_stage_val == "C20" && no_of_verifications_val < 2) ||(checklist_stage_val == "C30" && no_of_verifications_val < 3) ||(checklist_stage_val == "C40" && no_of_verifications_val < 4))
	{
		if(apply_flg == "Y" ){
		if(parent.commontoolbarFrame != null || parent.commontoolbarFrame != 'undefined'){
				parent.commontoolbarFrame.document.forms[0].apply.disabled=true;
			}
		}
	}
}
