/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function searchReason(obj,target){
	var locale = document.forms[0].locale.value;
	var code_name = obj.name;
	var desc_name = target.name; 
	var tcode = obj.value;
	var tdesc = target.value;
	obj.value='';
	target.value='';
	var retVal =  new String();
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var tit="";				
	if(target.name == desc_name){
	//	tit="Search Reasons"
	var tit =getLabel("Common.reason.label","Common");
	var locale = document.forms[0].locale.value;

	//var sql="SELECT REASON_DESC description, REASON_CODE code FROM OT_REASONS WHERE NVL(STATUS,'E')='E' AND REASON_CODE IN (SELECT REASON_CODE FROM OT_REASON_ACTION_TYPE WHERE ACTION_TYPE='CN' AND NVL(ACTIVE_YN,'N')='Y')  and upper( REASON_DESC) like upper(?) and upper(REASON_CODE) like upper(?) order by 1";
	var sql="SELECT REASON_DESC description, REASON_CODE code FROM OT_REASONS_LANG_VW WHERE NVL(STATUS,'E')='E' AND REASON_CODE IN (SELECT REASON_CODE FROM OT_REASON_ACTION_TYPE WHERE ACTION_TYPE='CN' AND NVL(ACTIVE_YN,'N')='Y')  and upper( REASON_DESC) like upper(?) and upper(REASON_CODE) like upper(?) AND LANGUAGE_ID='"+locale+"' order by 1";
	}
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" ){
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		if(target.name == desc_name){
			obj.value = arr[0];
			document.forms[0].target.disabled=true;
		}
	}else{
		target.value=tdesc;
		obj.value=tcode;
	}

}


function CheckMandatoryFields(){
	var submitflag = false;
	var messageFrame = parent.parent.messageFrame;
	var formObj = document.frames.cancel_checkIn_frame.document.CancelCheckInForm;
	var fields= new Array(formObj.reason_desc);
//	var names=new Array("Reason");	
	var reason =getLabel("Common.reason.label","Common");
	var names=new Array(reason);
	
	if(checkFields(fields,names,messageFrame)){
		submitflag=true;
	}else{
		submitflag=false;
	}
	return submitflag;
}


function reset(){
	var formObj = document.frames.cancel_checkIn_frame.document.CancelCheckInForm;
	formObj.reset();
	document.frames.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
}

function apply(){
	var formObj = document.frames.cancel_checkIn_frame.document.CancelCheckInForm;
	if(CheckMandatoryFields()){
		var xmlDoc="" ;
		var xmlHttp = new XMLHttpRequest();
		//var called_from = formObj.called_from.value;
		var xmlStr ="<root><SEARCH ";
		var called_from = formObj.called_from.value;
		xmlStr += "oper_num=\""+ formObj.oper_num.value +  "\" ";
		xmlStr += "slate_user_id=\""+ formObj.slate_user_id.value +  "\" ";
		xmlStr += "cancel_date=\""+ formObj.cancel_date.value +  "\" ";
		xmlStr += "reason_code=\""+ formObj.reason_code.value +  "\" ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		//alert(xmlStr);
		xmlHttp.open("POST","CancelCheckInValidation.jsp?func_mode=cancelCheckInDtls",false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		//alert(retVal);
		if(retVal!=null && retVal!=""){
				if(called_from=="OT_SLATE"){
					window.returnValue=getMessage("RECORD_INSERTED","SM");
					alert(window.returnValue);
					window.close();
				}
		} 
	}
}
