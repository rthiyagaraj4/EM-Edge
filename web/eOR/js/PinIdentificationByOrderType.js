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

function reset()
{
	f_query_add_mod.f_query_add_mod_query.document.pin_identification_form.reset();
	f_query_add_mod.f_query_add_mod_result.location.href="../../eCommon/html/blank.html";
}

function apply() {
	var	formObj	  =  f_query_add_mod.f_query_add_mod_query.document.pin_identification_form ;
	var	fields    = new Array ( formObj.order_category_code );
	var	names     =	new	Array (getLabel("Common.OrderCategory.label","Common"));
	
	/*var total_count = f_query_add_mod.f_query_add_mod_result.document.pin_identification_result_form.total_count.value;
	for(i=0;i<total_count;i++)
	{		 alert(eval("f_query_add_mod.f_query_add_mod_result.document.pin_identification_result_form.order_type_code"+i+".value"));
		 alert(eval("f_query_add_mod.f_query_add_mod_result.document.pin_identification_result_form.pin_applicable_on_order"+i+".value"));
    	 alert(eval("f_query_add_mod.f_query_add_mod_result.document.pin_identification_result_form.pin_applicable_on_result"+i+".value"));
	}*/

	if(f_query_add_mod.f_query_add_mod_query.checkFields(fields,names,messageFrame)) {
		if(f_query_add_mod.f_query_add_mod_result.document.pin_identification_result_form.total_count.value > 0)
		{
			eval(formApply(f_query_add_mod.f_query_add_mod_result.document.pin_identification_result_form,OR_CONTROLLER)) ;
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+	message;
			if(result) {
				onSuccess();
			}
        } 
		else messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage('BLANK_RECORD','OR');
	 }
}

function assignResult( _result,	_message, _flag ) {
	result	= _result ;
	message	= _message	;
	flag	= _flag;
}

function onSuccess() {
	var mode = f_query_add_mod.f_query_add_mod_query.document.pin_identification_form.mode.value;
	if( mode == MODE_MODIFY ) {
		formReset();
	}
}

function formReset () {
	//f_query_add_mod.f_query_add_mod_query.document.pin_identification_form.reset();
	f_query_add_mod.f_query_add_mod_result.location.reload();
	//f_query_add_mod.f_query_add_mod_result.location.href='../../eCommon/html/blank.html';
}

function getOrderType(obj)
{
	var bean_id		= document.pin_identification_form.bean_id.value ;
	var bean_name	= document.pin_identification_form.bean_name.value ;
	var mode		= document.pin_identification_form.mode.value ;
	var function_id	= document.pin_identification_form.function_id.value ;
	
	if(obj.value!='')
	{
		parent.f_query_add_mod_result.location.href="../../eOR/jsp/PinIdentificationByOrderTypeResult.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&mode="+mode+"&function_id="+function_id+"&order_category="+obj.value;
	}
	else
	{
		parent.f_query_add_mod_result.location.href="../../eCommon/html/blank.html";
	}
}

function change(obj)
{
	if(obj.checked==true)
		obj.value = "A";
	else
		obj.value = "X";
}

