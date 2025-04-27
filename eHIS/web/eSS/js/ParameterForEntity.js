/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function onSuccess(){
	f_query_add_mod.document.location.reload();
}
function apply(){
	var formObj = f_query_add_mod.document.formParameterForEntity;
	var fields	= new Array ( formObj.curr_proc_month, formObj.curr_proc_year);
	var names	= new Array ( getLabel("eSS.CurrentProcessingMonth.label","SS"),getLabel("eSS.CurrentProcessingYear.label","SS"));

	var errorPage = "../../eCommon/jsp/error.jsp";
	var blankObject = null;
	if (formObj.ss_period_end_scope.value=="E") {
		blankObject = getBlankField( fields, names, messageFrame);
	}
	if(blankObject == null) {
		var resultText	=	formApply(formObj,SS_CONTROLLER);
		eval(resultText);

		messageFrame.location.href = errorPage+"?err_num="+ message;
		if( result ) 
			onSuccess();
	}
	else
		blankObject.focus();
}

function reset(){
	f_query_add_mod.document.formParameterForEntity.reset();
}
