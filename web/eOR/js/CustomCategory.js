/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/* Added on 13/1/2003, By Parimala  Start */

var function_id = "" ;
var resultGlobal = false;
var messageGlobal = "" ;
var flagGlobal = true;
var linkContent = "";
var invalidCode = "";


function changeValue(chk)
{
	if(chk.checked)
		chk.value = 'Y';
	else 
		chk.value = 'N';
}

function apply() 
{
	if (! checkIsValidForProceed() ) 
	{
				message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
		
    var formObj = custom_query_add_mod.document.custom_category;
	var arrFieldName		=	new Array();
	var arrLegends			=	new Array();
	var arrPKFieldNames		=	new Array();

	arrFieldName[0]			=	"order_cat";
	arrFieldName[1]			=	"short_desc";

	arrLegends[0]			=	getLabel("Common.OrderCategory.label","Common");
	arrLegends[1]			=	getLabel("Common.shortdescription.label","Common");

	arrPKFieldNames[0]		=	"order_cat";
			
	resetDuplicateClass(formObj, arrPKFieldNames );
			
	var	result1	=	validateMandatoryFields(formObj,arrFieldName,arrLegends,arrPKFieldNames);
	if(result1)
	{
		eval(formApply(custom_query_add_mod.document.custom_category, OR_CONTROLLER));
	    messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
	    if( resultGlobal )
		{
			//onSuccess();
			window.close();
		}
    }
}

function assignResult(_result, _message, _flag)
{
	resultGlobal = _result ;
	messageGlobal  = _message ;
	flagGlobal = _flag ;
}


function assignResult(_result,_message, _flag, invCode)
{
	resultGlobal = _result ;
	messageGlobal  = _message ;
	flagGlobal = _flag ;
	invalidCode=invCode;
}

function onSuccess() 
{
	custom_query_add_mod.location.href = "../../eOR/jsp/CustomCategoryAmend.jsp?mode="+MODE_MODIFY
}


function formReset () 
{
	var formObj = custom_query_add_mod.document.custom_category;
	formObj.reset();
}

function reset()
{
	custom_query_add_mod.document.forms[0].reset();
}

function checkIsValidForProceed()
{
		var url = custom_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
			return true;
		else
			return false;
}
