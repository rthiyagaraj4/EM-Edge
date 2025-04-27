/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var function_id = "" ;
var resultGlobal = false;
var messageGlobal = "" ;
var flagGlobal = true;
var linkContent = "";

function create(){
	f_query_add_mod.location.href="../../eOR/jsp/PractForConsentMain.jsp?mode="+MODE_INSERT+"&function_id="+function_id;
}

function selectPractOrConsent(obj){
	parent.framePractForConsentHdr.formPractForConsentHdr.submit();
	parent.framePractForConsentDtl.location.href="PractForConsentDtl.jsp?group_by="+obj.value;
	return true;
}

async function show_pract_lookup(target,code){
	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();

	localeName=document.formPractForConsentHdr.localeName.value;
	
	argumentArray[0]=parent.parent.f_query_add_mod.framePractForConsentHdr.document.formPractForConsentHdr.service_sql.value;
	argumentArray[0]=argumentArray[0].replace('?',"'"+localeName+"'");
	argumentArray[1]=dataNameArray;
	argumentArray[2]=dataValueArray;
	argumentArray[3]=dataTypeArray;
	argumentArray[4]="1,2";
	argumentArray[5]=target.value;
	argumentArray[6]= CODE_LINK;
	argumentArray[7]= CODE_DESC;
	retval=await CommonLookup(getLabel("Common.practitioner.label","Common"),argumentArray);
	var ret1=unescape(retval);
	 var arr=ret1.split(",");
		if(arr[1]==undefined) 
		{
			arr[0]="";	
			arr[1]="";	
		}
	if(retval !=null && retval != ""){
		code.value=arr[0];
		target.value=arr[1];
		parent.parent.f_query_add_mod.framePractForConsentHdr.document.formPractForConsentHdr.temp_service_desc.value=retval[1];
		}
}

function before_show_pract_lookup(target,code){
	if(target.value != parent.parent.f_query_add_mod.framePractForConsentHdr.document.formPractForConsentHdr.temp_service_desc.value) {
		if(target.value!="")
			show_pract_lookup(target,code);
		else{
			target.value="";
			code.value="";		
			parent.parent.f_query_add_mod.framePractForConsentHdr.document.formPractForConsentHdr.temp_service_desc.value="";
		}
	}
}

async function show_consent_lookup(target,code){
	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();
	
	localeName=document.formPractForConsentHdr.localeName.value;
	
	argumentArray[0]=parent.parent.f_query_add_mod.framePractForConsentHdr.document.formPractForConsentHdr.service_sql.value;
	argumentArray[0]=argumentArray[0].replace('?',"'"+localeName+"'");

	//argumentArray[0]=parent.parent.f_query_add_mod.framePractForConsentHdr.document.formPractForConsentHdr.service_sql.value;
	argumentArray[1]=dataNameArray;
	argumentArray[2]=dataValueArray;
	argumentArray[3]=dataTypeArray;
	argumentArray[4]="1,2";
	argumentArray[5]=target.value;
	argumentArray[6]= CODE_LINK;
	argumentArray[7]= CODE_DESC;
	retval=await CommonLookup(getLabel("Common.ConsentForm.label","COMMON"),argumentArray);
	var ret1=unescape(retval); 
	var arr=ret1.split(",");
	if(arr[1]==undefined) 
	{
		arr[0]="";	
		arr[1]="";	
	}

	if(retval !=null && retval != ""){
		code.value=arr[0];
		target.value=arr[1];
		parent.parent.f_query_add_mod.framePractForConsentHdr.document.formPractForConsentHdr.temp_service_desc.value=arr[1];
		}
}

function before_show_consent_lookup(target,code){
	if(target.value != parent.parent.f_query_add_mod.framePractForConsentHdr.document.formPractForConsentHdr.temp_service_desc.value) {
		if(target.value!="")
			show_consent_lookup(target,code);
		else{
			target.value="";
			code.value="";		
			parent.parent.f_query_add_mod.framePractForConsentHdr.document.formPractForConsentHdr.temp_service_desc.value="";
		}
	}
}


async function callOnAlphaLink(obj, obj2){
	await changeAlphaColor(obj2);
	var fldObj1 = parent.framePractForConsentHdr.document.getElementById("group_by");
	var fldObj2 = parent.framePractForConsentHdr.document.getElementById("pract_consent_code");
	
	if(parent.frames[2].location.href.indexOf(".jsp") != -1){
		var flag = await latestUpdate();
	}
	var group_by			=	 fldObj1.value;
	var pract_consent_code	=	 fldObj2.value;
	
	if(pract_consent_code != ""){
		parent.framePractForConsentList.location.href="../../eOR/jsp/PractForConsentList.jsp?pract_consent_code="+pract_consent_code+"&index="+obj+"&group_by="+group_by;		
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		parent.framePractForConsentHdr.document.forms[0].pract_consent_desc.disabled=true;
		parent.framePractForConsentHdr.document.forms[0].pract_consent_button.disabled=true;
		parent.framePractForConsentHdr.document.forms[0].group_by.disabled = true;
	}
	else{
		parent.framePractForConsentList.location.href="../../eCommon/html/blank.html";

		var msg = "";
		var name;
		if(group_by=='P')
		{
			name =  getLabel("Common.practitioner.label","Common");
			msg = msg + getMessage("CAN_NOT_BE_BLANK","Common");
			msg = msg.replace('$',name);
			//var msg = "APP-000001 Practitioner cannot be blank...";
		}
		else if(group_by=='C')
		{
			name =  getLabel("Common.ConsentForm.label","COMMON");
			msg = msg + getMessage("CAN_NOT_BE_BLANK","Common");
			msg = msg.replace('$',name);
  			//var msg = "APP-000001 Consent Form cannot be blank...";
		}
	/*	if(group_by=="P")
			var msg = "APP-000001 Practitioner cannot be blank...";
		else if(group_by=="C")
			var msg = "APP-000001 Consent Form cannot be blank...";*/
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;

	}

}

function latestUpdate(){
	//var bean_id		= parent.framePractForConsentList.document.formPractForConsentList.bean_id.value;
	var bean_id		= parent.framePractForConsentHdr.document.getElementById("bean_id").value;
	//var bean_name	= parent.framePractForConsentList.document.formPractForConsentList.bean_name.value;
	var bean_name	= parent.framePractForConsentHdr.document.getElementById("bean_name").value;
	var fm_disp		= parent.framePractForConsentList.document.getElementById("fm_disp").value;
	//console.log(fm_disp);
	//console.log(parent.framePractForConsentList.fm_disp);
	//console.log(parent.document.getElementById("fm_disp"));
	//var fm_disp		= parent.framePractForConsentList.fm_disp.value;
	//var to_disp		= parent.framePractForConsentList.document.formPractForConsentList.to_disp.value;
	var to_disp		= parent.framePractForConsentList.document.getElementById("to_disp").value;
	//var tabVal		= parent.framePractForConsentList.document.formPractForConsentList.tabVal.value;
	var tabVal		= parent.framePractForConsentList.document.getElementById("tabVal").value;
	var value_str	= "";

	fm_disp = parseInt(fm_disp);
	to_disp = parseInt(to_disp);

	for(i=fm_disp; i<=to_disp; i++){
		//var value = eval('parent.framePractForConsentList.document.formPractForConsentList.select_yn'+i);
		var value = eval(parent.framePractForConsentList.document.getElementById('select_yn'+i));
		//console.log(value);
			if(!value.disabled){
				if(value.checked)
					val = "Y";
				else
					val = "N";
				}
				else
					val ="N";

			value_str += val+"~";
		}
		var xmlStr ="<root><SEARCH ";
		xmlStr += " INDEX_VALUES=\""+ value_str + "\" ";
		xmlStr += " FROM_VALUE=\""+ fm_disp + "\" ";
		xmlStr += " TO_VALUE=\""+ to_disp + "\" ";
		xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
		xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
		xmlStr += " TAB_VALUE=\""+ tabVal + "\" ";
		xmlStr += " CLASS_NAME=\"PractForConsentBean\"";
		xmlStr +=" /></root>";
	
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","PractForConsentValidate.jsp",false);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(xmlDoc);
		var responseText=xmlHttp.responseText ;
		eval(responseText);
		return true;
	}


async function dispLink(obj){
	//var group_by = document.getElementById("group_by").value;
	var group_by = parent.framePractForConsentHdr.document.getElementById("group_by").value;
	//console.log(parent.framePractForConsentHdr.document.getElementById("pract_consent_code").value);
	var pract_consent_code  = parent.framePractForConsentHdr.document.getElementById("pract_consent_code").value;
	if(pract_consent_code != ""){
		var buttonVal = obj;
		if(buttonVal == "S"){
			//document.forms[0].all.SelectTab.className="clicked";
			parent.framePractForConsentDtl.document.getElementById("SelectTab").className="clicked";
			//document.forms[0].all.AssociateTab.className="normal";
			parent.framePractForConsentDtl.document.getElementById("AssociateTab").className="normal";
		}else if(buttonVal == "A"){
			//document.forms[0].all.SelectTab.className="normal";
			parent.framePractForConsentDtl.document.getElementById("SelectTab").className="normal";
			//document.forms[0].all.AssociateTab.className="clicked";
			parent.framePractForConsentDtl.document.getElementById("AssociateTab").className="clicked";
		}
		var formObjAddMod = parent.framePractForConsentHdr.document.forms[0];
		formObjAddMod.group_by.disabled = true;
		formObjAddMod.pract_consent_desc.disabled=true;
		formObjAddMod.pract_consent_button.disabled=true;
		//document.forms[0].all.tabVal.value = buttonVal;
		parent.framePractForConsentDtl.document.getElementById("tabVal").value = buttonVal;
		//if(parent.frames[2].location.href.indexOf(".jsp") != -1){
		//console.log(parent);
			if(parent.framePractForConsentList.location.href.indexOf(".jsp") != -1){
		var flag = await latestUpdate();
		}
		if(linkContent=="")
			linkContent	=	document.getElementById("linkId").innerHTML;
		if(buttonVal=="A"){
			//console.log(document.getElementById("linkId"));
		//document.forms[0].all.linkId.className ="";
		document.getElementById("linkId").className ="";
		//document.forms[0].all.linkId.innerHTML = "&nbsp;";
		document.getElementById("linkId").innerHTML = "&nbsp;";
		parent.frames[2].location.href="../../eOR/jsp/PractForConsentList.jsp?tabVal="+buttonVal+"&pract_consent_code="+pract_consent_code+"&group_by="+group_by;
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}else{
			parent.frames[2].location.href="../../eCommon/html/blank.html";
			//document.forms[0].all.linkId.innerHTML = linkContent;
			document.getElementById("linkId").innerHTML = linkContent;
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
	}
	else
	{
		var msg = "";
		var name;
		if(group_by=='P')
		{
			name =  getLabel("Common.practitioner.label","Common");
			msg = msg + getMessage("CAN_NOT_BE_BLANK","Common");
			msg = msg.replace('$',name);
			//var msg = "APP-000001 Practitioner cannot be blank...";
		}
		else if(group_by=='C')
		{
			name =  getLabel("Common.ConsentForm.label","COMMON");
			msg = msg + getMessage("CAN_NOT_BE_BLANK","Common");
			msg = msg.replace('$',name);
  			//var msg = "APP-000001 Consent Form cannot be blank...";
		}
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
	}
}

function apply(){
	
	var message;
	if (! checkIsValidForProceed() )
    {
		message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	var formObj = f_query_add_mod.framePractForConsentHdr.document.formPractForConsentHdr;
	var group_by = f_query_add_mod.framePractForConsentHdr.document.formPractForConsentHdr.group_by.value;
	var fields = new Array (formObj.pract_consent_code);

	if(group_by=="P")
	{
		var names = new Array (getLabel("Common.practitioner.label","Common"));
		//var names = new Array ("Practitioner");
	}
	else if(group_by=="C")
	{
		//var names = new Array ("Consent Form");
		var names =  new Array (getLabel("Common.ConsentForm.label","COMMON"));
	}
		
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)){
		var flag = onApplyUpdate();
		if(flag )
		{
			eval( formApply(f_query_add_mod.framePractForConsentHdr.document.formPractForConsentHdr, OR_CONTROLLER) ) ;
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+messageGlobal;
			if(resultGlobal)
			{
				onSuccess();
			}
		}
	}
}

function checkVal(obj){
	document.forms[0].dispMode.value = obj;
	document.forms[0].submit();
}

function onApplyUpdate(){
	//var refForm = document.frames[1].frames[2].document.forms[0];
	var refForm = f_query_add_mod.framePractForConsentList.document.formPractForConsentList;
	//if(document.frames[1].frames[2].location.href.indexOf(".jsp") != -1){
	if(f_query_add_mod.framePractForConsentList.location.href.indexOf(".jsp") != -1){	
	    var bean_id		= refForm.bean_id.value;
	    var bean_name	= refForm.bean_name.value;
	    var fm_disp		= refForm.fm_disp.value;
		var to_disp		= refForm.to_disp.value;
		var tabVal		= refForm.tabVal.value;
		var value_str	= "";

		fm_disp = parseInt(fm_disp);
		to_disp = parseInt(to_disp);

		for(i=fm_disp; i<=to_disp; i++){
			//var value = eval('document.frames[1].frames[2].document.forms[0].select_yn'+i);
			var value = f_query_add_mod.framePractForConsentList.document.getElementById('select_yn'+i);
			if(!value.disabled){
				if(value.checked){
					val = "Y";
				}else
					val = "N";
				}
				else
					val ="N";

			value_str += val+"~";
		}
		var xmlStr ="<root><SEARCH ";
		xmlStr += " INDEX_VALUES=\""+ value_str + "\" ";
		xmlStr += " FROM_VALUE=\""+ fm_disp + "\" ";
		xmlStr += " TO_VALUE=\""+ to_disp + "\" ";
		xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
		xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
		xmlStr += " TAB_VALUE=\""+ tabVal + "\" ";
		xmlStr += " CLASS_NAME=\"PractForConsentBean\"";
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","PractForConsentValidate.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
	
		return true;
	}
	else
	{
		return true;
	}
}

function assignResult(res,msg,mod){
	resultGlobal  = res ;
	messageGlobal = msg ;
	flagGlobal    = mod;
	if((messageGlobal=="ATLEAST_ONE_PRACTITIONER"||messageGlobal=="ATLEAST_ONE_CONSENT")&& resultGlobal==false){
		messageGlobal=getMessage(messageGlobal,"OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
		return false;
	}
}

function reset()
{
    //if(document.frames[1].location.href.indexOf(".jsp") != -1)
    if(f_query_add_mod.framePractForConsentHdr.location.href.indexOf(".jsp") != -1)
	{
		create();
	}
}

function onSuccess(){

	create();
}

function checkIsValidForProceed()
{
    var url = f_query_add_mod.location.href;
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
	{
		
		return true;
	}
	else
		return false;
}



