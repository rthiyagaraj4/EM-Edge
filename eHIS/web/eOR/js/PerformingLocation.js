/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var function_id = "" ;
var result = false;
var resultGlobal = false;
var message = "" ;
var flag = "" ;
var qry_string = "";
var invalidCode		=	null;

function create() {
	f_query_add_mod.location.href = "../../eOR/jsp/PerformingLocationAddModify.jsp?mode=1&function_id="+function_id ;
}

function query() {
	f_query_add_mod.location.href='../../eOR/jsp/PerformingLocationQueryCriteria.jsp?function_id='+function_id ;
}


function apply() {

    if (! checkIsValidForProceed() ) {
		message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	var formObjTop = f_query_add_mod.performing_locn_top.document.perform_locn_top ;
	var formObjBottom = f_query_add_mod.performing_locn_bottom.document.perform_locn_bottom ;


	var mode =  formObjBottom.mode.value;

	if(mode == "1"){

			var fields = new Array ( formObjTop.locn_type);
			var names = new Array ( getLabel("Common.locationtype.label","Common"));

			formObjBottom.locn_type.value = formObjTop.locn_type.value
			if(!checkFieldsofMst( fields, names, messageFrame)) {
			  return false;
			}

			for(i = 0 ; i < 10 ; i++){
				var flds=new Array(eval("formObjBottom.code"+i));
				var name=new Array(getLabel("Common.code.label","Common"));
				if(!SpecialCharCheck(flds,name,messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){
					return false
				}
			}

			var arrFieldName		=	new Array();
			var arrLegends			=	new Array();
			var arrPKFieldNames		=	new Array();

			arrFieldName[0]			=	"code";
			arrFieldName[1]			=	"long_desc";
			arrFieldName[2]			=	"short_desc";

			arrLegends[0]			=	getLabel("Common.code.label","Common");
			arrLegends[1]			=	getLabel("Common.longdescription.label","Common");
			arrLegends[2]			=	getLabel("Common.shortdescription.label","Common");

			arrPKFieldNames[0]		=	"code";

			resetDuplicateClass( formObjBottom, arrPKFieldNames);

			var startIndex="0";
			var objMessageFrame=messageFrame;
			var errorPage="";

			var	result1	=	validateMandatoryFields(formObjBottom,arrFieldName,arrLegends,arrPKFieldNames,startIndex, objMessageFrame, errorPage);

			if(result1)
			{   
				//alert(formApply(formObjBottom,OR_CONTROLLER));
				eval(formApply(formObjBottom,OR_CONTROLLER));
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				if(result) {
					onSuccess();
				}else if(invalidCode != null && invalidCode != "" && invalidCode != "null"){
						showDuplicates(formObjBottom,arrPKFieldNames,invalidCode,"0",messageFrame,null );
				}
			}
		}
		else if(mode == "2")
		{

			//alert("inside modify - js");
			qry_string = "function_id="+function_id+"&mode="+mode+"&locn_type="+formObjBottom.locn_type.value+"&code="+formObjBottom.code.value;
			var fields = new Array ( formObjBottom.short_desc
									,formObjBottom.long_desc
				);
			var names = new Array ( getLabel("Common.ShortDesc.label","COMMON")
									,getLabel("Common.LongDesc.label","COMMON")
				);

			if(!checkFieldsofMst( fields, names, messageFrame)) {
			  return false;
			}

			if(eval("formObjBottom.intext.checked"))
				formObjBottom.intext.value = "X";
			else
				formObjBottom.intext.value = "I";
			if(formObjBottom.enabled_status.checked)
				formObjBottom.enabled_status.value = "E";
			else
				formObjBottom.enabled_status.value = "D";
			eval(formApply(formObjBottom,OR_CONTROLLER));
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			if(result) {
				onSuccess();
			}

	}
}
function resetColorCode(obj)
{	
	var arrPKFieldNames	=	new Array();
	var formObj			=	document.perform_locn_bottom;
	arrPKFieldNames[0]	=	"code";
	resetDuplicateClass( formObj, arrPKFieldNames, 0, obj );
}

function onSuccess() {
	var formObjBottom = f_query_add_mod.performing_locn_bottom.document.perform_locn_bottom ;
	var mode = formObjBottom.mode.value;
	if( mode == "1" ) {
		formReset();
	}else{//Update Mode
		f_query_add_mod.document.location.href="../../eOR/jsp/PerformingLocationAddModify.jsp?"+qry_string ;
	}
}


function formReset () {
	var formObjTop = f_query_add_mod.performing_locn_top.document.perform_locn_top ;
	var formObjBottom = f_query_add_mod.performing_locn_bottom.document.perform_locn_bottom ;
	formObjTop.locn_type.value = ""
	formObjTop.locn_type.focus();
	formObjBottom.reset();
}

function assignResult(_result, _message, _flag, _invalidCode){
	//alert(_result +"  -  "+_message+"  -  "+_flag)
	result = _result ;
	message  = _message ;
	flag = _flag ;
	invalidCode	= _invalidCode;

}

function reset(){
	//alert('1'+f_query_add_mod.document.frames[1].forms[0].name);
	//alert('0'+f_query_add_mod.performing_locn_top.name);
	if(f_query_add_mod.performing_locn_top != null){
		//alert('1');
		if(f_query_add_mod.performing_locn_top.document.forms[0] != null){
	    //alert('2');
			if(f_query_add_mod.performing_locn_top.document.forms[0].name == "perform_locn_top"){
			//alert('3');
				f_query_add_mod.performing_locn_top.document.perform_locn_top.reset();
				//clearList("f_query_add_mod.document")
			}else{
			//alert('4');
				f_query_add_mod.performing_locn_top.document.forms[0].reset();
			}
		}
	} else{
	//alert('4');
		if (f_query_add_mod.document.forms[0] != null)
			f_query_add_mod.document.forms[0].reset();
	}
	if(f_query_add_mod.performing_locn_bottom != null){
		if(f_query_add_mod.performing_locn_bottom.document.forms[0] != null){
	    //alert('2');
			if(f_query_add_mod.performing_locn_bottom.document.forms[0].name == "perform_locn_top"){
			//alert('3');
				f_query_add_mod.performing_locn_bottom.document.perform_locn_top.reset();
				//clearList("f_query_add_mod.document")
			}else{
			//alert('4');
				f_query_add_mod.performing_locn_bottom.document.forms[0].reset();
			}
		}
	} else{
	//alert('4');
		if (f_query_add_mod.document.forms[0] != null)
			f_query_add_mod.document.forms[0].reset();
	}
}

function checkIsValidForProceed()
{
		 var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
				return false;
}
function checkIE(target)
{
	//alert(target.value);
	if(target.value=="I")
		target.value = "X";
	else
		target.value = "I";
	//alert(target.value);
}
function checkEnabled(target)
{
	if(target.value=="E")
		target.value = "D";
	else
		target.value = "E";
}
//this function will give the final xml string on click of apply
/*function beforePost(str) {
	alert(str)
}*/
