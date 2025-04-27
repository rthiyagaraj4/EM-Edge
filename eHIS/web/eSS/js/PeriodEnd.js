/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function reset() {
	f_query_add_mod.formPeriodEnd.reset();
}

function onSuccess(){
	f_query_add_mod.location.reload();
}

function apply() {
	var formObj=f_query_add_mod.formPeriodEnd;
	var responseText=formApply(formObj,SS_CONTROLLER);
//	alert(responseText);
	eval(responseText);
	var errorPage	=	"../../eCommon/jsp/error.jsp";
	messageFrame.location.href = errorPage+"?err_num="+ message;
	if( result )
		onSuccess();
}
