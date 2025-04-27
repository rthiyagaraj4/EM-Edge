/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function create() {
	f_query_add_mod.location.href="../../eSS/jsp/SterilizationTypeAddModify.jsp?mode="+MODE_INSERT+"&function_id="+function_id; 
}

function query() {
		f_query_add_mod.location.href="../../eSS/jsp/SterilizationTypeQueryCriteria.jsp?function_id="+function_id+"&mode="+MODE_MODIFY;
}

function apply() {
	if(!proceedOnApply())
    {
        messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
        return false;
    }
	var formObj = f_query_add_mod.document.forms[0] ;
	
	var fields = new Array (formObj.sterile_type, formObj.long_desc, formObj.short_desc );
	
	var names = new Array ( getLabel("Common.code.label","Common"),getLabel("Common.longdescription.label","Common"),getLabel("Common.shortdescription.label","Common"));
	
	var errorPage	=	"../../eCommon/jsp/error.jsp";
	var blankObj	=	null;
	blankObject		=	checkSSFields( fields, names, messageFrame,errorPage);
	if(blankObject==true) {
		eval(formApply(formObj,SS_CONTROLLER));
		messageFrame.location.href = errorPage+"?err_num="+ message;
		if( result ) {
			onSuccess();
		}
	}
	else 
		return;
}

   

function proceedOnApply() {
    var url = f_query_add_mod.location.href;
    url = url.toLowerCase();
    if ( (url.indexOf("blank.html")==-1) && (url.indexOf("sterilizationtypequery")==-1) )
        return true;
    else
        return false;
}
function reset() {
	if(f_query_add_mod.document.formSterilizationType!=null)
		f_query_add_mod.document.formSterilizationType.reset();
	if(f_query_add_mod.document.query_form!=null)
		f_query_add_mod.document.query_form.reset();
}

function onSuccess() {
	var mode = f_query_add_mod.document.formSterilizationType.mode.value;
	if( mode == MODE_INSERT ) 
		reset();
	else{
		f_query_add_mod.document.location.reload();

	}
}

function Modify(obj){
	var sterile_type=obj.cells[0].innerText;
	document.location.href="../../eSS/jsp/SterilizationTypeAddModify.jsp?mode="+MODE_MODIFY+"&function_id="+parent.function_id+"&sterile_type="+sterile_type;
}

function CheckCode(obj)
{
		var xmlDoc = "" ;
	    var xmlHttp = new XMLHttpRequest() ;
	    var xmlStr ="<root><SEARCH ";
	    var codeValue = obj.value.toUpperCase();
	    xmlStr += " code =\""+ codeValue +"\"";
      // xmlStr += " code =\""+ obj.value +"\"";
	   xmlStr +=" /></root>";
	   xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "SterilizationTypValidate.jsp?validate=ADD_TO_LIST", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);
		
	
	
}
function CodeExit()
{
	var message=getMessage("SS_ALREADY_EXISTS","SS");
	document.formSterilizationType.sterile_type.value=""; 
    document.formSterilizationType.sterile_type.focus(); 
	parent.messageFrame.location.href	=	"../../eCommon/jsp/error.jsp?err_num="+ message;
	
}
