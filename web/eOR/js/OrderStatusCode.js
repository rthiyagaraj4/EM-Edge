/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var	function_id		= "" ;
var	result			= false;
var	flag			= "" ;
var	message			= "" ;

function create()
{
		f_query_add_mod.location.href='../../eOR/jsp/OrderStatusCodeAddModify.jsp?mode='+MODE_INSERT+"&function_id="+function_id ;
}

function query()
{
		f_query_add_mod.location.href='../../eOR/jsp/OrderStatusCodeQueryCriteria.jsp?mode='+MODE_MODIFY + "&function_id="+function_id;
}

function reset()
{
	if(f_query_add_mod.document.order_status_code_form) {
		f_query_add_mod.document.order_status_code_form.reset();
	}
	else if(f_query_add_mod.document.forms[0])
			f_query_add_mod.document.forms[0].reset();
	else
	{
		frames[0].location.reload();
		return false;
	}

}

function apply() {
	if (! checkIsValidForProceed() ) {
		message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	var	formObj	= f_query_add_mod.document.order_status_code_form ;
	var	fields = new Array ( formObj.order_status_code
						,formObj.long_desc
						,formObj.short_desc
						,formObj.order_status_type
						);

	  var	names =	new	Array (getLabel("Common.code.label","Common")
				,getLabel("Common.longdescription.label","Common")
				,getLabel("Common.shortdescription.label","Common")
				,getLabel("eOR.StatusType.label","OR")
				);
	  if(f_query_add_mod.checkFieldsofMst(	fields,	names, messageFrame)) {
		    var flds=new Array(formObj.order_status_code);
		  var name=new Array(getLabel("Common.code.label","Common"));
	  if(SpecialCharCheck(flds,name,messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){


		  eval(formApply(f_query_add_mod.document.order_status_code_form,OR_CONTROLLER)) ;
		  messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+	message;
		  if(result) {
			  onSuccess();
		 }
	 }
}
}
function assignResult( _result,	_message, _flag ) {
	result	= _result ;
	message	= _message	;
	flag	= _flag;
}

function onSuccess() {
	var mode = f_query_add_mod.document.order_status_code_form.mode.value;
	//if( mode == MODE_INSERT ) {
		formReset();
	//}
}

function formReset () {
	//f_query_add_mod.document.order_status_code_form.reset();
	f_query_add_mod.location.reload();
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
